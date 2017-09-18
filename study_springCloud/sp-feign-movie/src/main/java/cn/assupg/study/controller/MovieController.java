package cn.assupg.study.controller;

import cn.assupg.study.entity.User;
import cn.assupg.study.service.UserFeignClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@SuppressWarnings({"SpringAutowiredFieldsWarningInspection", "SpringJavaAutowiringInspection"})
@RestController
public class MovieController {

    @Autowired
    private UserFeignClient userFeignClient;

    @GetMapping("/movie/{id}")
    public User findById(@PathVariable Long id) {
        return userFeignClient.findById(id);
    }

    @PostMapping(value = "/movie")
    public User postUser(User user) {
        return userFeignClient.postUser(user);
    }

    @GetMapping(value = "/get-movie")
    public User getUser(User user) {
        return userFeignClient.getUser(user);
    }
}