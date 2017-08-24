package cn.assupg.study;

import cn.assupg.ribbon.config.TestConfiguration;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.netflix.ribbon.RibbonClient;
import org.springframework.context.annotation.Bean;
import org.springframework.web.client.RestTemplate;

/**
 * Ribbon 负载均衡
 * 在RestTemplate 增加注解：@LoadBalanced 即可
 * # 使用Ribbon 实现负载均衡，即不需要配置 服务者的URL，通过 eureka注册中心获取
 * #user:
 * #  userServicePath: http://localhost:7900/user/
 */
@SpringBootApplication
@EnableEurekaClient
@RibbonClient(name = "sp-user", configuration = TestConfiguration.class)
public class SpMovieRibbonApp {

    @LoadBalanced
    @Bean
    public RestTemplate restTemplate() {
        return new RestTemplate();
    }

    public static void main(String[] args) {
        SpringApplication.run(SpMovieRibbonApp.class, args);
    }
}
