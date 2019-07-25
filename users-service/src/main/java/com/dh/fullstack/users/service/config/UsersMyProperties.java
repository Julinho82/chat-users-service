package com.dh.fullstack.users.service.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;

/**
 * @author Santiago Mamani
 */
@Configuration
@PropertySource("classpath:/configuration/api-version.properties")
public class UsersMyProperties {

    @Value("${users.api.version}")
    private String apiVersion;

    public String getApiVersion() {
        return apiVersion;
    }
}
