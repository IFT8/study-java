package cn.assupg.study.controller;

import cn.assupg.study.entity.User;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@SuppressWarnings({"SpringAutowiredFieldsWarningInspection", "SpringJavaAutowiringInspection"})
@RestController
public class MovieController {

    @GetMapping("/movie/{id}")
    public User findById(@PathVariable Long id) {
        return null;
    }
}