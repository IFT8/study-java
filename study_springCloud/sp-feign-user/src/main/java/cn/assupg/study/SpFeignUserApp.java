package cn.assupg.study;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@SpringBootApplication
@EnableEurekaClient
public class SpFeignUserApp {

	public static void main(String[] args) {
		SpringApplication.run(SpFeignUserApp.class, args);
	}
}