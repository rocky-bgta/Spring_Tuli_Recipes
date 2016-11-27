package com.salahin.spring.recipes.service.presistanceDataSource;

import org.apache.commons.dbcp.BasicDataSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.Environment;
import org.springframework.stereotype.Component;

import javax.sql.DataSource;

/**
 * Created by Tuli on 11/14/2016.
 */
@Configuration
@PropertySource("classpath:/datasource.properties")
public class PersistenceDataSourceProvider {

    @Autowired
    private Environment environment;

    public DataSource mySqlDataSource() {
        BasicDataSource dataSource = new BasicDataSource();
        String test = environment.getProperty("jdbc.driverClassName");
        dataSource.setDriverClassName(environment.getProperty("jdbc.driverClassName"));
        dataSource.setUrl(environment.getProperty("jdbc.url"));
        dataSource.setUsername(environment.getProperty("jdbc.username"));
        dataSource.setPassword(environment.getProperty("jdbc.password"));
        return dataSource;
    }

}
