package cn.assupg.ws.soap.service.impl;

import cn.assupg.ws.soap.bean.User;
import cn.assupg.ws.soap.service.IMyService;

import javax.jws.WebService;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by supeng on 11/22/2016.
 */
@WebService(endpointInterface = "cn.assupg.ws.soap.service.IMyService", targetNamespace = "http://www.assupg.cn/webservice")
public class MyService implements IMyService {

    private static List<User> users = new ArrayList<>();

    public MyService() {
        users.add(new User(1, "admin", "admin", "管理员"));
    }

    @Override
    public int add(int a, int b) {
        int i = a + b;
        System.out.println(a + " + " + b + " = " + i);
        return i;
    }

    @Override
    public User addUser(User user) {
        users.add(user);
        return user;
    }

    @Override
    public User login(String username, String password) {
        for (User user : users) {
            if (user.getUsername().equals(username) && user.getPassword().equals(password)) {
                return user;
            }
        }
        return null;
    }

    @Override
    public List<User> list() {
        return users;
    }
}
