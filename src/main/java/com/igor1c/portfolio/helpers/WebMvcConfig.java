package com.igor1c.portfolio.helpers;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import java.util.Arrays;

@Configuration
@EnableWebMvc
public class WebMvcConfig implements WebMvcConfigurer {
    final static String[] ALLOWED_ORIGINS = {
            "http://localhost:28001",
            "http://192.168.1.38:28001",
            "http://5.129.145.48:28001",
            "http://109.111.187.78:28001"
    };

    final static String[] MAPPINGS = {
            "/article*",
            "/article/getAll*",
            "/language/getAll*",
            "/project*",
            "/project/getAll*",
            "/project/getByName*",
            "/project/getMultimedia*",
            "/project/getMultimediaByName*",
            "/project/getWithFilter*",
            "/project/getFilterOptions*"
    };

    public void addResourceHandlers(ResourceHandlerRegistry registry) {
        registry.addResourceHandler("/js/**").addResourceLocations("classpath:/js/");
        registry.addResourceHandler("/css/**").addResourceLocations("classpath:/css/");
        registry.addResourceHandler("/images/**").addResourceLocations("classpath:/images/");
    }

    @Override
    public void addCorsMappings(CorsRegistry registry) {
        Arrays.asList(MAPPINGS).forEach(m ->
                registry.addMapping(m).allowedOrigins(ALLOWED_ORIGINS)
        );
    }
}
