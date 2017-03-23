package cn.assupg.study.ws.hello.main;

import cn.assupg.study.ws.hello.wsdl2java.HelloServiceService;
import cn.assupg.study.ws.hello.wsdl2java.IHelloService;

/**
 * Created by supeng on 11/17/2016.
 */
public class TestClient2 {
    public static void main(String[] args) {
        HelloServiceService helloServiceService = new HelloServiceService();
        IHelloService helloService = helloServiceService.getPort(IHelloService.class);

        System.out.println(helloService.add(1, 2));
        System.out.println(helloService.sub(3, 3));
    }
}
