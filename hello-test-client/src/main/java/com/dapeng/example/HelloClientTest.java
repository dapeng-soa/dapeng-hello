package com.dapeng.example;

import com.dapeng.example.hello.HelloServiceClient;
import com.dapeng.example.hello.domain.Hello;
import com.github.dapeng.core.SoaException;

import java.net.InetAddress;
import java.net.UnknownHostException;
import java.util.Date;

/**
 * @author with struy.
 * Create by 2018/7/9 00:24
 * email :yq1724555319@gmail.com
 */

public class HelloClientTest {
    public static void main(String[] args) throws SoaException, UnknownHostException {
        System.out.println(InetAddress.getLocalHost().getHostAddress());
//        String s = new String("1");
//
//        s.intern();
//
//        String s2 = "1";
//
//        System.out.println(s == s2);
//
//
//        String str2 = new String("str")+new String("01");
//        str2.intern();
//        String str1 = "str01";
//        System.out.println(str2==str1);

//
        System.setProperty("soa.zookeeper.host", "127.0.0.1:2181");
        HelloServiceClient client = new HelloServiceClient();
        Hello hello = new Hello();
        hello.name("Ever").time(new Date());
        String res = client.sayHello2(hello);
        System.out.println("result-->" + res);
    }
}
