package com.salahin.spring.recipes.service.config;

import com.salahin.spring.recipes.service.recipeimplementation.HomeMadeServiceImple;
import com.salahin.spring.recipes.service.recipeimplementation.MemberServiceImple;
import com.salahin.spring.recipes.service.recipeinterface.HomeMadeServiceInterface;
import com.salahin.spring.recipes.service.recipeinterface.MemberServiceInterface;
import com.salahin.spring.recipes.service.springSocialIntegration.config.SocialConfig;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;


@Configuration
@Import({SocialConfig.class})
@ComponentScan("com.salahin.spring.recipes.service")
public class ServiceConfiguration {

    @Bean
    public HomeMadeServiceInterface reservationService() {
        return new HomeMadeServiceImple();
    }

    @Bean
    MemberServiceInterface memberServiceInterface(){
        return new MemberServiceImple();
    }
}
