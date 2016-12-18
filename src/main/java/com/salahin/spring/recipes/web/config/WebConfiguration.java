package com.salahin.spring.recipes.web.config;


import com.salahin.spring.recipes.service.recipeimplementation.MemberServiceImple;
import com.salahin.spring.recipes.service.recipeinterface.MemberServiceInterface;
import com.salahin.spring.recipes.web.Interceptor;
import com.salahin.spring.recipes.web.view.AtomFeedView;
import com.salahin.spring.recipes.web.view.RSSFeedView;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.social.connect.ConnectionFactoryLocator;
import org.springframework.social.connect.ConnectionRepository;
import org.springframework.social.connect.web.ConnectController;
import org.springframework.web.servlet.ViewResolver;
import org.springframework.web.servlet.config.annotation.*;
import org.springframework.web.servlet.handler.SimpleUrlHandlerMapping;
import org.springframework.web.servlet.mvc.UrlFilenameViewController;
import org.springframework.web.servlet.view.BeanNameViewResolver;
import org.springframework.web.servlet.view.InternalResourceViewResolver;
import org.springframework.web.servlet.view.JstlView;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Properties;

/**
 * Configuration class to setup Spring MVC.
 *
 * @author Md. Nazmus Salahin Rocky
 *
 *
 */
@Configuration
@EnableWebMvc
@EnableScheduling
@ComponentScan({"com.salahin.spring.recipes.web"})
public class WebConfiguration extends WebMvcConfigurerAdapter {

    private static final Logger log = LoggerFactory.getLogger(WebConfiguration.class);
    private static final SimpleDateFormat dateFormat = new SimpleDateFormat("HH:mm:ss");

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
        viewResolver.setSuffix(".jsp");
        return viewResolver;
    }

    /*
     * Configure ResourceHandlers to serve static resources like CSS/ Javascript etc...
     */
    //@Override
    //public void addResourceHandlers(ResourceHandlerRegistry registry) {
        //registry.addResourceHandler("/static/**").addResourceLocations("/static/");
        //registry.addResourceHandler("/resources/**").addResourceLocations("/resources/");
       /* ResourceHandlerRegistration resourceRegistration = registry
                .addResourceHandler("resources*//**");
        resourceRegistration.addResourceLocations("/resources*//**");
        registry.addResourceHandler("/css*//**").addResourceLocations("/css*//**");
        registry.addResourceHandler("/img*//**").addResourceLocations("/img*//**");
        registry.addResourceHandler("/js*//**").addResourceLocations("/js*//**");
        registry.addResourceHandler("/resources*//**").addResourceLocations("classpath:/resources/");*/
    //}

    /*@Override
    public void addViewControllers(ViewControllerRegistry registry) {
        registry.addViewController("/").setViewName("forward:/index.html");
    }*/

    @Scheduled(fixedRate = 5000)
    public void reportCurrentTime() {
        log.debug("Debug Test");
        log.info("The time is now {}", dateFormat.format(new Date()));
        log.error("Did it again!");
        log.trace("Entering application.");
    }

}
