package com.dapeng.example.config;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.jdbc.DataSourceBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;

import javax.sql.DataSource;

@Configuration
public class DbConfig {

    @Bean(name = "myDbSource")
    @ConfigurationProperties(prefix = "spring.datasource.test")
    public DataSource localDataSource() {
        return DataSourceBuilder.create().build();
    }

    @Bean(name = "myDsTM")
    public DataSourceTransactionManager transactionManagerLocalDatasource() {
        DataSourceTransactionManager dsTM = new DataSourceTransactionManager(localDataSource());
        dsTM.setDefaultTimeout(30);
        return dsTM;
    }
}