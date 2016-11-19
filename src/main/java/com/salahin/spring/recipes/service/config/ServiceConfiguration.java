package com.salahin.spring.recipes.service.config;

import com.salahin.spring.recipes.service.cacheProvider.EhCacheProvider;
import com.salahin.spring.recipes.service.springSocialIntegration.config.SocialConfig;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;


@Configuration
@Import({SocialConfig.class, EhCacheProvider.class})
@ComponentScan("com.salahin.spring.recipes.service")
public class ServiceConfiguration {

    /*@Bean
    public PersistenceDataSourceProvider persistenceDataSourceProvider(){
        return new PersistenceDataSourceProvider();
    }
*/
   /* @Bean
    public HomeMadeServiceInterface homeMadeServiceInterface() {
        return new HomeMadeServiceImple();
    }

    @Bean
    MemberServiceInterface memberServiceInterface(){
        return new MemberServiceImple();
    }*/
}
