package com.salahin.spring.recipes.web.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.ViewResolver;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.view.InternalResourceViewResolver;

/**
 * Configuration class to setup Spring MVC.
 *
 * @author Md. Nazmus Salahin Rocky
 *
 *
 */
@Configuration
@EnableWebMvc
@ComponentScan("com.salahin.spring.recipes.web.controller")
public class WebConfiguration {

    @Bean
    public ViewResolver internalResourceViewResolver() {
        InternalResourceViewResolver viewResolver = new InternalResourceViewResolver();
        viewResolver.setPrefix("/jspView/");
        viewResolver.setSuffix(".jsp");
        return viewResolver;
    }
}
