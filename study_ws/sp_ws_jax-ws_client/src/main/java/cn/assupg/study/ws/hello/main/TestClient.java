package cn.assupg.study.ws.hello.main;

import cn.assupg.study.ws.hello.wsdl2java.IHelloService;

import javax.xml.namespace.QName;
import javax.xml.ws.Service;
import java.net.MalformedURLException;
import java.net.URL;

/**
 * Created by supeng on 11/17/2016.
 */
public class TestClient {
    public static void main(String[] args) throws MalformedURLException {

        URL url = new URL("http://localhost:8888/ws/?wsdl");
        QName qName = new QName("http://impl.service.hello.ws.study.assupg.cn/", "HelloServiceService");
        Service service = Service.create(url, qName);
        IHelloService helloService = service.getPort(IHelloService.class);

        System.out.println(helloService.add(1, 2));
        System.out.println(helloService.sub(3, 3));

    }
}
