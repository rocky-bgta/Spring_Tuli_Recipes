package com.salahin.spring.recipes.web.config;


import com.salahin.spring.recipes.service.recipeimplementation.MemberServiceImple;
import com.salahin.spring.recipes.service.recipeinterface.MemberServiceInterface;
import com.salahin.spring.recipes.web.Interceptor;
import com.salahin.spring.recipes.web.view.AtomFeedView;
import com.salahin.spring.recipes.web.view.RSSFeedView;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.social.connect.ConnectionFactoryLocator;
import org.springframework.social.connect.ConnectionRepository;
import org.springframework.social.connect.web.ConnectController;
import org.springframework.web.servlet.ViewResolver;
import org.springframework.web.servlet.config.annotation.*;
import org.springframework.web.servlet.view.BeanNameViewResolver;
import org.springframework.web.servlet.view.InternalResourceViewResolver;
import org.springframework.web.servlet.view.JstlView;

/**
 * Configuration class to setup Spring MVC.
 *
 * @author Md. Nazmus Salahin Rocky
 *
 *
 */
@Configuration
@EnableWebMvc
@EnableWebSecurity
@ComponentScan("com.salahin.spring.recipes.web")
public class WebConfiguration extends WebMvcConfigurerAdapter {

    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        //super.addInterceptors(registry);
        registry.addInterceptor(restServiceConsume()).addPathPatterns("/members*");
    }

    @Bean
    public Interceptor restServiceConsume(){
        return new Interceptor();
    }


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
    //====================END XML Restful Service===============================

    @Bean
    public ViewResolver viewResolver(){
        return new BeanNameViewResolver();
    }


    @Bean
    public AtomFeedView atomFeedViewTemplate(){
        return new AtomFeedView();
    }

    @Bean
    public RSSFeedView rssFeedViewTemplate(){
        return new RSSFeedView();
    }

    //Spring Social Integration=======================================================
    @Bean
    public ConnectController connectController(
            ConnectionFactoryLocator connectionFactoryLocator,
            ConnectionRepository connectionRepository) {
        return  new ConnectController(connectionFactoryLocator, connectionRepository);
    }
    //Spring Social Integration=======================================================

    @Bean
    public ViewResolver internalResourceViewResolver() {
        InternalResourceViewResolver viewResolver = new InternalResourceViewResolver();
        viewResolver.setPrefix("/jspView/");
        viewResolver.setViewClass(JstlView.class);
        viewResolver.setSuffix(".jsp");
        return viewResolver;
    }

    /*
     * Configure ResourceHandlers to serve static resources like CSS/ Javascript etc...
     */
    @Override
    public void addResourceHandlers(ResourceHandlerRegistry registry) {
        registry.addResourceHandler("/public/**").addResourceLocations("/public/");
    }
}
