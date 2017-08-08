package cn.assupg.study.controller;

import cn.assupg.study.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController
public class MovieController {

    @Autowired
    private RestTemplate restTemplate;

    @GetMapping("/movie/{id}")
    public User findById(@PathVariable Long id) {
        String url = "http://localhost:7900/simple/" + id;
        return this.restTemplate.getForObject(url, User.class);
    }
}
