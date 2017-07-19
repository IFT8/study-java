package cn.assupg.study18Tomcat;


import org.apache.catalina.valves.AccessLogValve;
import org.springframework.boot.context.embedded.ConfigurableEmbeddedServletContainer;
import org.springframework.boot.context.embedded.EmbeddedServletContainerCustomizer;
import org.springframework.boot.context.embedded.tomcat.TomcatEmbeddedServletContainerFactory;
import org.springframework.stereotype.Component;

import java.io.File;

@Component
public class MyEmbeddedServletContainer implements EmbeddedServletContainerCustomizer {
    @Override
    public void customize(ConfigurableEmbeddedServletContainer container) {
        System.out.println("==============container============" + container.getClass());

        TomcatEmbeddedServletContainerFactory factory = (TomcatEmbeddedServletContainerFactory) container;
        factory.setPort(10003);
        factory.setBaseDirectory(new File("D:/tmp/tomcat"));

        factory.addContextValves(getLogAccessLogValve());
        factory.addConnectorCustomizers(new MyTomcatConnectorCustomizer());
    }

    private AccessLogValve getLogAccessLogValve() {
        AccessLogValve logValve = new AccessLogValve();
        logValve.setDirectory("d:/");
        logValve.setEnabled(true);
        logValve.setPattern("common");
        logValve.setPrefix("springboot-access-log");
        logValve.setSuffix(".txt");
        return logValve;
    }
}
