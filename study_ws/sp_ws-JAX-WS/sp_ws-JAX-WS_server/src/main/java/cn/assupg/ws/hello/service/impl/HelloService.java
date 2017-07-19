package cn.assupg.ws.hello.service.impl;


import cn.assupg.ws.hello.service.IHelloService;

import javax.jws.WebService;

/**
 * Created by supeng on 11/17/2016.
 */
@WebService(endpointInterface = "cn.assupg.ws.hello.service.IHelloService")
public class HelloService implements IHelloService {

    @Override
    public int add(int a, int b) {
        int i = a + b;
        System.out.println("server add method: " + a + " + " + b + " = " + i);
        return i;
    }

    @Override
    public int sub(int a, int b) {
        int i = a - b;
        System.out.println("server sub method: " + a + " - " + b + " = " + i);
        return i;
    }
}
