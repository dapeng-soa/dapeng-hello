package com.dapeng.example.config;

import com.alibaba.druid.pool.DruidDataSource;
import com.mysql.jdbc.Driver;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.jdbc.DataSourceBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;

import javax.sql.DataSource;

@Configuration
public class DbConfig {

    @Bean(name = "myDbSource")
//    @ConfigurationProperties(prefix = "spring.datasource")
    public DataSource localDataSource() {
        return DataSourceBuilder.create().
                url("jdbc:mysql://0.0.0.0:3306/titanrtx")
                .username("root")
                .password("root")
                .type(DruidDataSource.class)
                .driverClassName("com.mysql.jdbc.Driver")
                .build();
    }

    @Bean(name = "myDsTM")
    public DataSourceTransactionManager transactionManagerLocalDatasource() {
        DataSourceTransactionManager dsTM = new DataSourceTransactionManager(localDataSource());
        dsTM.setDefaultTimeout(30);
        return dsTM;
    }
}