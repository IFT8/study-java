package cn.assupg.study.ws.hello.main;

import cn.assupg.study.ws.hello.service.impl.HelloService;

import javax.xml.ws.Endpoint;

/**
 * Created by supeng on 11/17/2016.
 */
public class TestServer {

    public static void main(String[] args) {
        String address = "http://localhost:8888/ws/";
        Endpoint.publish(address, new HelloService());


        System.out.println(address + "?wsdl");
    }
}
