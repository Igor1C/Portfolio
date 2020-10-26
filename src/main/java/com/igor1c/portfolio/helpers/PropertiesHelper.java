package com.igor1c.portfolio.helpers;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class PropertiesHelper {

    private static String PORT = "33010";
    private static String RESOURCES_FOLDER = "C:\\Java\\Portfolio - Project\\Resources\\";
    private static String DB_PATH = "jdbc:postgresql://localhost/portfolio";
    private static String DB_USER = "sa";
    private static String DB_PASSWORD = "";

    private static Properties properties;

    static {
        properties = new Properties();

        try (FileInputStream fis = new FileInputStream("config.properties")) {
            properties.load(fis);

            PORT = properties.getProperty("port");
            RESOURCES_FOLDER = properties.getProperty("resources.folder");

            DB_PATH = properties.getProperty("spring.datasource.url");
            DB_USER = properties.getProperty("spring.datasource.username");
            DB_PASSWORD = properties.getProperty("spring.datasource.password");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }



    public static String getPORT() {
        return PORT;
    }

    public static String getResourcesFolder() {
        return RESOURCES_FOLDER;
    }

    public static String getDbPath() {
        return DB_PATH;
    }

    public static String getDbUser() {
        return DB_USER;
    }

    public static String getDbPassword() {
        return DB_PASSWORD;
    }
}
