package cn.assupg.study;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

/**
 * <pre>
 * //增加 @EnableEurekaClient 就可以将，服务注册到 eureka Server中。
 *
 * application.yml
 * #eureka:
 * #  client:
 * #    #实现健康检查开关，需要依赖：spring-boot-actuator
 * #    healthcheck:
 * #        enabled: true
 * #    serviceUrl:
 * #      #registered-replicas	http://localhost:8761/eureka/
 * #      #unavailable-replicas	http://localhost:8761/eureka/,
 * #      #defaultZone: http://localhost:8761/eureka/                  #将当前应用，注册到指定eureka 服务器中
 * #      defaultZone: http://root:root123456@localhost:8761/eureka   #将当前应用，注册到指定eureka 服务器中【安全认证方式】
 * #  instance:
 * #    # 默认是使用，主机名进行访问，若以IP访问，需要将  prefer-ip-address: true
 * #    prefer-ip-address: true
 * #    # Eureka Instance ID
 * #    # 默认：${spring.cloud.client.hostname}:${spring.application.name}:${spring.application.instance_id:${server.port}}}.
 * #    instance-id: ${spring.application.name}:${spring.application.instance_id:${server.port}}}.
 * </pre>
 */
@SpringBootApplication
@EnableEurekaClient
public class SpEurekaUserApp {

    public static void main(String[] args) {
        SpringApplication.run(SpEurekaUserApp.class, args);
    }
}
