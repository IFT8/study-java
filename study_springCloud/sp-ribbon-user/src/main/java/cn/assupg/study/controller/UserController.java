package cn.assupg.study.controller;

import cn.assupg.study.entity.User;
import cn.assupg.study.repository.IUserRepository;
import com.netflix.discovery.EurekaClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@SuppressWarnings({"SpringJavaAutowiringInspection", "SpringAutowiredFieldsWarningInspection"})
@RestController
public class UserController {

    @Autowired
    private IUserRepository iUserRepository;
    @Autowired
    private EurekaClient eurekaClient;
    @Autowired
    private DiscoveryClient discoveryClient;

    @GetMapping("/user/{id}")
    public User findById(@PathVariable Long id) {
        return this.iUserRepository.findOne(id);
    }

    ///**
    // * 本地服务实现的信息
    // *
    // * @return //
    // */
    //@GetMapping("/eureka-instance")
    //public String serviceUrl() {
    //    InstanceInfo instance = eurekaClient.getNextServerFromEureka("SP-RIBBON-USER", false);
    //    return instance.getHomePageUrl();
    //}

    /**
     * 本地服务实现的信息
     *
     * @return //
     */
    @SuppressWarnings("UnnecessaryLocalVariable")
    @GetMapping("/instance-info")
    public ServiceInstance showInfo() {
        ServiceInstance localServiceInstance = discoveryClient.getLocalServiceInstance();
        return localServiceInstance;
    }
}