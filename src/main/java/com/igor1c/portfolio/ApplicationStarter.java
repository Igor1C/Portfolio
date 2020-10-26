package com.igor1c.portfolio;

import com.igor1c.portfolio.helpers.ApplicationContextProvider;
import com.igor1c.portfolio.helpers.DatabaseHelper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.orm.jpa.HibernateJpaAutoConfiguration;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.Configuration;

import java.util.*;
import java.util.concurrent.ConcurrentHashMap;

@Configuration
@SpringBootApplication(exclude = HibernateJpaAutoConfiguration.class)
public class ApplicationStarter {

    @Autowired
    private ApplicationContextProvider acp;

    public static void main(String[] args) {
        Map<String, Object> props = new HashMap();
        processParameters(props);

        TimeZone.setDefault(TimeZone.getDefault());

        ConfigurableApplicationContext context =
                new SpringApplicationBuilder()
                        .sources(ApplicationStarter.class)
                        .properties(props)
                        .run();

        if (Arrays.stream(args).anyMatch(arg -> arg.equals("dropTables"))) {
            new DatabaseHelper().dropTables();
            System.exit(0);
        } else if (Arrays.stream(args).anyMatch(arg -> arg.equals("fillDatabase"))) {
            DatabaseHelper.clearDatabase();
            DatabaseHelper.fillDatabase();
        }
    }

    private static void processParameters(Map<String, Object> props) {
        props.put("server.port", com.igor1c.portfolio.helpers.PropertiesHelper.getPORT());
    }
}
