package cn.assupg.study;

import cn.assupg.study.config.ExcludeFromComponentScan;
import cn.assupg.study.config.TestRibbonCustomizeConfiguration2;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.netflix.ribbon.RibbonClient;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.FilterType;
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
//Customizing the Ribbon Client You can configure some bits of a Ribbon client
//  The TestRibbonCustomizeConfiguration has to be @Configuration but take care that it is not in a
//      @ComponentScan for the main application context, otherwise it will be shared by all the @RibbonClients.
//      If you use @ComponentScan (or @SpringBootApplication) you need to take steps to avoid it being included
//      (for instance put it in a separate, non-overlapping package, or specify the packages to scan explicitly in the @ComponentScan).
//@RibbonClient(name = "sp-ribbon-user", configuration = TestRibbonCustomizeConfiguration.class)
//通过，@ComponentScan 排除指定的 TestRibbonCustomizeConfiguration2.class
@RibbonClient(name = "sp-ribbon-user", configuration = TestRibbonCustomizeConfiguration2.class)
@ComponentScan(excludeFilters = {@ComponentScan.Filter(type = FilterType.ANNOTATION, value = ExcludeFromComponentScan.class)})
public class SpRibbonMovie {

    @LoadBalanced
    @Bean
    public RestTemplate restTemplate() {
        return new RestTemplate();
    }

    public static void main(String[] args) {
        SpringApplication.run(SpRibbonMovie.class, args);
    }
}