package com.dapeng.example.service;

import com.dapeng.example.hello.domain.Hello;
import com.dapeng.example.hello.service.HelloService;
import com.github.dapeng.api.RemoteStoreService;
import com.github.dapeng.api.dto.StoreRequest;
import com.github.dapeng.api.dto.StoreResponse;
import com.github.dapeng.core.SoaException;
import com.github.dapeng.spring.annotation.DapengService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;

import java.util.HashMap;
import java.util.Optional;


/**
 * @author with struy.
 * Create by 2018/6/24 09:07
 * email :yq1724555319@gmail.com
 */

@DapengService(service = HelloService.class)
@Transactional
public class HelloServiceImpl implements HelloService {

    @Autowired
    private RemoteStoreService storeService;

    @Override
    @Transactional(rollbackFor = Exception.class)
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
        return "hello : " + hello.name + "-> " + hello.message + "@" + hello.time;
    }

    @Override
    public String sayHello3(int id, Optional<Integer> age, Optional<String> name) throws SoaException {
        return "sayHello3:" + id + ", " + age + ", " + name;
    }
}
