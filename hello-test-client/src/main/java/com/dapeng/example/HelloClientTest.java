package com.dapeng.example;

import com.dapeng.example.hello.HelloServiceClient;
import com.dapeng.example.hello.domain.SupportDataType;
import com.dapeng.example.hello.domain.enums.Color;
import com.github.dapeng.core.SoaException;

import java.math.BigDecimal;
import java.nio.ByteBuffer;
import java.util.Date;
import java.util.Optional;

/**
 * @author with struy.
 * Create by 2018/7/9 00:24
 * email :yq1724555319@gmail.com
 */

public class HelloClientTest {
    public static void main(String[] args) throws SoaException {
        System.setProperty("soa.zookeeper.host", "127.0.0.1:2181");
        HelloServiceClient client = new HelloServiceClient();
        String res = client.sayHello("Dapeng");
        System.out.println("result-->" + res);
        SupportDataType req = new SupportDataType();
        req.bigDecimalType = Optional.of(BigDecimal.valueOf(23.3333333332323));
        req.dateType = Optional.of(new Date());
        req.byteType = Optional.of(Byte.parseByte("87"));
        req.binaryType = Optional.of(ByteBuffer.allocate(1024));
        req.enumType = Optional.of(Color.RED);
        SupportDataType res2 = client.testAllDataType(Optional.of(req),Optional.empty());
        System.out.println("result-->" + res2);
    }
}
