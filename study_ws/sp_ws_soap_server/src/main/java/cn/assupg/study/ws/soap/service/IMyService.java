package cn.assupg.study.ws.soap.service;

import cn.assupg.study.ws.soap.bean.User;

import javax.jws.WebParam;
import javax.jws.WebResult;
import javax.jws.WebService;
import java.util.List;

/**
 * Created by supeng on 11/22/2016.
 */
@WebService(targetNamespace = "http://www.assupg.cn/webservice")
public interface IMyService {

    @WebResult(name = "addResult")
    int add(@WebParam(name = "a") int a, @WebParam(name = "b") int b);

    @WebResult(name = "user")
    User addUser(@WebParam(name = "user") User user);

    @WebResult(name = "user")
    User login(@WebParam(name = "username") String username, @WebParam(name = "password") String password);

    @WebResult(name = "user")
    List<User> list();

}
