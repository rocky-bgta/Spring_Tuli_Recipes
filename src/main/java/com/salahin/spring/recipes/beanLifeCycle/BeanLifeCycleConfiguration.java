package com.salahin.spring.recipes.beanLifeCycle;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * Created by Tuli on 12/18/2016.
 */
@Configuration
public class BeanLifeCycleConfiguration {
    @Bean
    public CompleteLivingBean completeLivingBean(){
        return  new CompleteLivingBean();
    }

    @Bean
    public PrototypeBean prototypeBean(){
        return new PrototypeBean();
    }
}
