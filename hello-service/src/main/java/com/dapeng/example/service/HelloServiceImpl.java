package com.dapeng.example.service;

import com.dapeng.example.hello.domain.Hello;
import com.dapeng.example.hello.service.HelloService;
import com.github.dapeng.api.RemoteStoreService;
import com.github.dapeng.api.dto.StoreRequest;
import com.github.dapeng.api.dto.StoreResponse;
import com.github.dapeng.core.SoaException;
import com.github.dapeng.spring.annotation.DapengService;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.HashMap;


/**
 * @author with struy.
 * Create by 2018/6/24 09:07
 * email :yq1724555319@gmail.com
 */

@DapengService
public class HelloServiceImpl implements HelloService {

    @Autowired
    private RemoteStoreService storeService;

    @Override
    public String sayHello(String name) throws SoaException {
        StoreRequest storeRequest = new StoreRequest();
        storeRequest.setNumberId(123);
        storeRequest.setName(name);
        storeRequest.setAttachment(new HashMap<>());
        StoreResponse response = storeService.store(storeRequest);

        return name + "resp: " + response.toString();
//        return "hello : " + name;
    }

    @Override
    public String sayHello2(Hello hello) throws SoaException {
        return "hello : " + hello.name + "-> " + hello.message;
    }
}
