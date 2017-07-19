package cn.assupg.ws.hello.service;

import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebResult;
import javax.jws.WebService;

/**
 * Created by supeng on 11/17/2016.
 */
@WebService
public interface IHelloService {

    @WebMethod
    @WebResult(name = "addResult")
    int add(@WebParam(name = "a") int a, @WebParam(name = "b") int b);

    @WebMethod
    @WebResult(name = "subResult")
    int sub(@WebParam(name = "a") int a, @WebParam(name = "b") int b);
}
