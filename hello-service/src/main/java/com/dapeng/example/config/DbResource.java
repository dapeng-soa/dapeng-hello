package com.dapeng.example.config;


import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import javax.sql.DataSource;

@Service
public class DbResource {
    public static DataSource myDbSource;

    @Resource(name = "myDbSource")
    public void setLocalDbDataSource( DataSource dataSource) {
        DbResource.myDbSource = dataSource;
    }
}