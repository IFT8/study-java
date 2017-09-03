package cn.assupg.study;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.context.annotation.Bean;
import org.springframework.web.client.RestTemplate;

/**
 * 配置，application.yml 来定义负载均衡的规则。
 * 优先顺序： application.yml -> java代码 -> defaults spring
 * <p>
 * If there is no other source of zone data then a guess is made based on the client configuration
 * (as opposed to the instance configuration). We take eureka.client.availabilityZones,
 * which is a map from region name to a list of zones, and pull out the first zone for the instance’s
 * own region (i.e. the eureka.client.region, which defaults to "us-east-1" for comatibility with native Netflix).
 * <p>
 * eureka.client.region 可能通过yml文件中配置，默认为：“us-east”
 */
@SpringBootApplication
@EnableEurekaClient
public class SpRibbonMoviePropertiesCustomizing {

    @LoadBalanced
    @Bean
    public RestTemplate restTemplate() {
        return new RestTemplate();
    }

    public static void main(String[] args) {
        SpringApplication.run(SpRibbonMoviePropertiesCustomizing.class, args);
    }
}