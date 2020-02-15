package com.dapeng.example.service;

import com.dapeng.example.hello.HelloServiceCodec;
import com.dapeng.example.hello.service.HelloService;
import com.github.dapeng.core.definition.SoaServiceDefinition;
import org.springframework.beans.factory.FactoryBean;
import org.springframework.stereotype.Service;

// Todo use an annotation on the Service Impl instead

@Service
public class HelloDef implements FactoryBean<SoaServiceDefinition> {

    public HelloDef(){
        System.out.println("create...");
    }

    @Override
    public SoaServiceDefinition getObject() throws Exception {
        SoaServiceDefinition def = new HelloServiceCodec.Processor(new HelloServiceImpl(), HelloService.class);
        return def;
    }

    @Override
    public Class<?> getObjectType() {
        return SoaServiceDefinition.class ;
    }

    @Override
    public boolean isSingleton() {
        return true;
    }
}
