package cn.assupg.study18Tomcat;

import org.apache.catalina.connector.Connector;
import org.apache.coyote.http11.Http11NioProtocol;
import org.springframework.boot.context.embedded.tomcat.TomcatConnectorCustomizer;


public class MyTomcatConnectorCustomizer implements TomcatConnectorCustomizer {
    @Override
    public void customize(Connector connector) {
        System.out.println("==============container============" + connector.getClass());
        System.out.println("==============container============" + connector.getProtocolHandler().getClass());
        Http11NioProtocol protocol = (Http11NioProtocol) connector.getProtocolHandler();


    }
}
