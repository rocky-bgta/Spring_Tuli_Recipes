package com.salahin.spring.recipes.service.config;

import com.salahin.spring.recipes.service.recipeimplementation.HomeMadeServiceImple;
import com.salahin.spring.recipes.service.recipeinterface.HomeMadeServiceInterface;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;


@Configuration
@ComponentScan("com.salahin.spring.recipes.service")
public class ServiceConfiguration {

    @Bean
    public HomeMadeServiceInterface reservationService() {
        return new HomeMadeServiceImple();
    }
}
