package com.salahin.spring.recipes.service.security;

import com.salahin.spring.recipes.service.presistanceDataSource.PersistenceDataSourceProvider;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

import javax.sql.DataSource;

/**
 * Created by Tuli on 11/15/2016.
 */
@Configuration
@EnableWebSecurity
public class RecipeSecurity extends WebSecurityConfigurerAdapter  {

    @Autowired
    private PersistenceDataSourceProvider persistenceDataSourceProvider;

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.csrf().disable();
                http.authorizeRequests()
                    .antMatchers("/", "/welcome","/members").permitAll()
                    .antMatchers("/atomfeed*").hasRole("USER")
                .and()
                    .formLogin()
                    .loginPage("/jspView/login.jsp")
                    .loginProcessingUrl("/spring_security_check")
                    .defaultSuccessUrl("/")
                    .failureUrl("/jspView/login.jsp?error=true")
                .and()
                    .rememberMe();
    }

    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
      /* auth.inMemoryAuthentication()
                .withUser("admin").password("a").authorities("ROLE_USER");*/

        auth.jdbcAuthentication()
                .dataSource(persistenceDataSourceProvider.mySqlDataSource());
    }
}
