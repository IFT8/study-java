package cn.assupg.study09;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;


@Component
@ConfigurationProperties(prefix = "tomcat")
public class TomcatProperties {

    private String host;
    private Integer port;

    @Override
    public String toString() {
        return String.format("TomcatProperties{host='%s', port=%d}", host, port);
    }

    public String getHost() {
        return (host == null) ? null : host.trim();
    }

    public TomcatProperties setHost(String host) {
        this.host = (host == null) ? null : host. trim();
        return this;
    }

    public Integer getPort() {
        return port;
    }

    public TomcatProperties setPort(Integer port) {
        this.port = port;
        return this;
    }
}
