package com.salahin.spring.recipes.service.security;

import com.salahin.spring.recipes.service.presistanceDataSource.PersistenceDataSourceProvider;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.Cache;
import org.springframework.cache.CacheManager;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.cache.SpringCacheBasedUserCache;

/**
 * Created by Tuli on 11/15/2016.
 */
@Configuration
@EnableWebSecurity
@EnableGlobalMethodSecurity(prePostEnabled = true)
public class RecipeSecurity extends WebSecurityConfigurerAdapter  {


    @Autowired
    private PersistenceDataSourceProvider persistenceDataSourceProvider;

    @Autowired
    private CacheManager cacheManager;

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.csrf().disable();
        //http.authorizeRequests().antMatchers("/resources/**").permitAll().anyRequest().permitAll();
                http.authorizeRequests()
                    .antMatchers("/", "/welcome","/members").permitAll()
                    .antMatchers("/atomfeed*").hasRole("USER")
                .and()
                    .formLogin()
                    .loginPage("/jspView/login.jsp")
                    .usernameParameter("ssoId")
                    .passwordParameter("password")
                    //.loginProcessingUrl("/spring_security_check")
                    .defaultSuccessUrl("/")
                    .failureUrl("/jspView/login.jsp?error=true")
                .and()
                    .rememberMe();
    }

    @Bean
    public SpringCacheBasedUserCache userCache() throws Exception {
        Cache cache = cacheManager.getCache("userCache");
        return new SpringCacheBasedUserCache(cache);
    }

    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
       auth.inMemoryAuthentication().withUser("admin").password("a").authorities("ROLE_USER");

       /* auth.inMemoryAuthentication().withUser("bill").password("abc123").roles("USER");
        auth.inMemoryAuthentication().withUser("admin").password("root123").roles("ADMIN");
        auth.inMemoryAuthentication().withUser("dba").password("root123").roles("ADMIN","DBA");*/

        auth.jdbcAuthentication()
                .dataSource(persistenceDataSourceProvider.mySqlDataSource())
                .userCache(userCache());
    }
}
