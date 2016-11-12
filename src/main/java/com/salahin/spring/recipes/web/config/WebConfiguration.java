package com.salahin.spring.recipes.web.config;


import com.salahin.spring.recipes.service.recipeimplementation.MemberServiceImple;
import com.salahin.spring.recipes.service.recipeinterface.MemberServiceInterface;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.ViewResolver;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.view.BeanNameViewResolver;
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

    //=====================XML Restful Service==============================
   /* Class classArray[] = {Members.class, Member.class};
    @Bean
    public View memberTemplate(){
        return new MarshallingView(jaxb2Marshaller());
    }

    @Bean
    public Marshaller jaxb2Marshaller(){
        Jaxb2Marshaller marshaller = new Jaxb2Marshaller();
        marshaller.setClassesToBeBound(classArray);
        return  marshaller;
    }*/

    @Bean
    public MemberServiceInterface memberService(){
        return  new MemberServiceImple();
    }

    @Bean
    public ViewResolver viewResolver(){
        return new BeanNameViewResolver();
    }
    //====================END XML Restful Service===============================

    @Bean
    public ViewResolver internalResourceViewResolver() {
        InternalResourceViewResolver viewResolver = new InternalResourceViewResolver();
        viewResolver.setPrefix("/jspView/");
        viewResolver.setSuffix(".jsp");
        return viewResolver;
    }
}
