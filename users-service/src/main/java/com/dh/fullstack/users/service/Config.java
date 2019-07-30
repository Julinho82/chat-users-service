package com.dh.fullstack.users.service;

import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

/**
 * @author Santiago Mamani
 */
@Configuration
@EnableFeignClients
@ComponentScan("com.dh.fullstack.users.service")
@EnableAutoConfiguration
public class Config {

}
