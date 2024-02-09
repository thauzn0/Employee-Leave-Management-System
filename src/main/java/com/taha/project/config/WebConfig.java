package com.taha.project.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

/*
 * Configuration class to configure CORS (Cross-Origin Resource Sharing) for the application.
 */
@Configuration
public class WebConfig implements WebMvcConfigurer {

    /*
     * Configure CORS mappings for the application.
     * @param registry CorsRegistry object to register CORS configuration.
     */
    @Override
    public void addCorsMappings(CorsRegistry registry) {
        registry.addMapping("/**")
                .allowedOrigins("http://localhost:3000") // Allowed origins for requests, typically the frontend URL
                .allowedMethods("GET", "POST", "PUT", "DELETE") // Allowed HTTP methods
                .allowCredentials(true); // Whether credentials such as cookies are allowed to be sent with requests
    }
}
