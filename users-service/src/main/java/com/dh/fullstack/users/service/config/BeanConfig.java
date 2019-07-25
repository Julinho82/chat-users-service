package com.dh.fullstack.users.service.config;

import com.dh.fullstack.users.service.bean.Asus;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Scope;

/**
 * @author Santiago Mamani
 */
@Configuration
public class BeanConfig {

    @Bean
    @Scope("prototype")
    public Asus beanAsus(){
        Asus asus = new Asus();
        asus.setName("I am asus");

        return asus;
    }
}
