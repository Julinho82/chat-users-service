package com.dh.fullstack.users.service.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;

/**
 * @author Santiago Mamani
 */
@Configuration
public class UsersProperties {

    @Value("${users.permit.age:15}")
    private Integer permitAge;

    @Value("#{4*20}")
    private Long countUser;

    @Value("#{beanAsus.name}")
    private String nameAsus;

    public Integer getPermitAge() {
        return permitAge;
    }

    public Long getCountUser() {
        return countUser;
    }

    public String getNameAsus() {
        return nameAsus;
    }
}
