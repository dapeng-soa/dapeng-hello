package com.dapeng.example.service;

import com.dapeng.example.hello.domain.Hello;
import com.dapeng.example.hello.domain.SupportDataType;
import com.dapeng.example.hello.service.HelloService;
import com.github.dapeng.core.SoaException;
import com.github.dapeng.spring.annotation.DapengService;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.Optional;


/**
 * @author with struy.
 * Create by 2018/6/24 09:07
 * email :yq1724555319@gmail.com
 */

@DapengService(service = HelloService.class)
public class HelloServiceImpl implements HelloService {

    @Autowired
    User user;  // only test as Autowired Inject

    @Override
    public String sayHello(String name) throws SoaException {
        return "hello : " + name;
    }

    @Override
    public String sayHello2(Hello hello) throws SoaException {
        return "hello : " + hello.name + "-> " + hello.message;
    }

    @Override
    public SupportDataType testAllDataType(Optional<SupportDataType> dataType, Optional<Integer> anyNumber) throws SoaException {
        SupportDataType dataType1 = new SupportDataType();
        dataType1.intType = Optional.of(404);
        return dataType.orElse(dataType1);
    }
}
