package com.salahin.spring.recipes.web;

import com.salahin.spring.recipes.service.config.ServiceConfiguration;
import com.salahin.spring.recipes.service.security.RecipeSecurity;
import com.salahin.spring.recipes.web.config.WebConfiguration;
import org.springframework.core.annotation.Order;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.web.servlet.support.AbstractAnnotationConfigDispatcherServletInitializer;

/**
 * Created Date on 12-11-206.
 * @author Md. Nazmus Salahin Rocky
 */
@Order(1)
public class tuliApplicationInitializer extends AbstractAnnotationConfigDispatcherServletInitializer {
    @Override
    protected Class<?>[] getRootConfigClasses() {
        return new Class<?>[] {ServiceConfiguration.class, RecipeSecurity.class};
    }

    @Override
    protected Class<?>[] getServletConfigClasses() {
        return new Class<?>[] {WebConfiguration.class};
    }

    @Override
    protected String[] getServletMappings() {
        return new String[] {"/tulirecipes/*"};
    }
}
