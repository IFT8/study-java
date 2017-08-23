package cn.assupg.study;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@SpringBootApplication
@EnableEurekaClient
public class SpEurekaUserApp {

	public static void main(String[] args) {
		SpringApplication.run(SpEurekaUserApp.class, args);
	}
}
