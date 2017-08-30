package cn.assupg.study.controller;

import cn.assupg.study.entity.User;
import cn.assupg.study.repository.IUserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UserController {

    @Autowired
    private IUserRepository iUserRepository;

    @GetMapping("/user/{id}")
    public User findById(@PathVariable Long id) {
        return this.iUserRepository.findOne(id);
    }
}
