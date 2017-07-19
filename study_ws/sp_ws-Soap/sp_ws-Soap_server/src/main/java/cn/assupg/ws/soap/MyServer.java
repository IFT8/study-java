package cn.assupg.ws.soap;

import cn.assupg.ws.soap.service.impl.MyService;

import javax.xml.ws.Endpoint;

/**
 * Created by supeng on 11/22/2016.
 */
public class MyServer {
    public static void main(String[] args) {
        String address = "http://localhost:8989/ms/";
        Endpoint.publish(address, new MyService());
        System.out.println(address + "?wsdl");
    }
}
