package cn.assupg.study.controller;

import cn.assupg.study.entity.User;
import com.netflix.appinfo.InstanceInfo;
import com.netflix.discovery.EurekaClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.cloud.client.loadbalancer.LoadBalancerClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@SuppressWarnings({"SpringAutowiredFieldsWarningInspection", "SpringJavaAutowiringInspection", "Duplicates"})
@RestController
public class MovieController {

    @Autowired
    private RestTemplate restTemplate;
    @Autowired
    private EurekaClient eurekaClient;
    @Autowired
    private DiscoveryClient discoveryClient;
    @Autowired
    private LoadBalancerClient loadBalancerClient;

    @GetMapping("/movie/{id}")
    public User findById(@PathVariable Long id) {
        //String url = "http://localhost:7900/user/" + id;
        //String url = this.userServicePath + id;
        String url = "http://sp-ribbon-user/user/" + id;
        return this.restTemplate.getForObject(url, User.class);
    }

    /**
     * 本地服务实现的信息
     *
     * @return //
     */
    @GetMapping("/eureka-instance")
    public String serviceUrl() {
        InstanceInfo instance = eurekaClient.getNextServerFromEureka("SP-RIBBON-MOVIE", false);
        return instance.getHomePageUrl();
    }

    /**
     * 本地服务实现的信息
     *
     * @return //
     */
    @GetMapping("/instance-info")
    public ServiceInstance showInfo() {
        return discoveryClient.getLocalServiceInstance();
    }

    @GetMapping("/test")
    public String test() {
        ServiceInstance serviceInstance = this.loadBalancerClient.choose("sp-ribbon-user");
        System.out.println("sp-ribbon-user:\t" + serviceInstance.getHost() + ":" + serviceInstance.getPort() + ":" + serviceInstance.getServiceId());
        ServiceInstance serviceInstance2 = this.loadBalancerClient.choose("sp-ribbon-user2");
        System.out.println("sp-ribbon-user2:\t" + serviceInstance2.getHost() + ":" + serviceInstance2.getPort() + ":" + serviceInstance2.getServiceId());
        System.out.println("");
        return "1";
    }
}
