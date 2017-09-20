package com.comodin.fleet.controller;

import com.comodin.fleet.core.bean.UserBean;
import com.comodin.basic.vo.BaseVo;
import org.springframework.web.bind.annotation.RequestMapping;
import com.comodin.basic.controller.AbstractBaseController;
import org.springframework.stereotype.Controller;

@Controller
@RequestMapping("/user")
@SuppressWarnings({"unused", "SpringAutowiredFieldsWarningInspection", "StatementWithEmptyBody"})
public class UserBeanController extends AbstractBaseController<UserBean, BaseVo<UserBean>> {

    @Override protected String getModuleName() {return "user";}

}