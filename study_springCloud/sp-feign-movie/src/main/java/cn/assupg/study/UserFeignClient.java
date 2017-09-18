package cn.assupg.study;

import org.springframework.cloud.netflix.feign.FeignClient;

@FeignClient("sp-user-feign")
public interface UserFeignClient {
}