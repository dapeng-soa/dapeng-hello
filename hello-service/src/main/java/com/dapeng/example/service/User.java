package com.dapeng.example.service;

import org.springframework.stereotype.Component;

@Component
public class User {
    private String name = "wangzx";

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
