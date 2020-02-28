package com.dapeng.example;

import com.github.dapeng.core.ApplicationContext;
import com.github.dapeng.core.definition.SoaServiceDefinition;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.*;
import org.springframework.boot.autoconfigure.*;
//import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import java.util.Map;

@EnableFeignClients({"com.github.dapeng.api"})
@SpringBootApplication
@EnableTransactionManagement
public class HelloServiceApp implements ApplicationContext {

    private static Logger LOG = LoggerFactory.getLogger(HelloServiceApp.class);

    public static void main(String[] args) {
        // TODO support launch as a standalone SpringBootApp
        ConfigurableApplicationContext applicationContext = SpringApplication.run(HelloServiceApp.class, args);
//        applicationContext.close();
    }


    @Override
    public Map<String, SoaServiceDefinition> getServiceDefinitions() {
        try {
            ConfigurableApplicationContext ctx = SpringApplication.run(HelloServiceApp.class, new String[]{});
            return ctx.getBeansOfType(SoaServiceDefinition.class);
        } catch (Throwable ex) {
            LOG.error("initialaize example application failed", ex);
            throw new RuntimeException("initialaize example application failed", ex);
        }
    }


}