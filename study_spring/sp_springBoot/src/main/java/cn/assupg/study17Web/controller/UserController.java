package cn.assupg.study17Web.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UserController {

    @GetMapping("/user/home")
    public String home() {
        System.out.println("user home.");
        return "user home.";
    }
}
