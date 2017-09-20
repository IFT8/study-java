package com.comodin.fleet.controller;

import com.comodin.basic.vo.BaseVo;
import org.springframework.web.bind.annotation.RequestMapping;
import com.comodin.basic.controller.AbstractBaseController;
import org.springframework.stereotype.Controller;
import com.comodin.fleet.core.bean.RoleBean;

@Controller
@RequestMapping("/role")
@SuppressWarnings({"unused", "SpringAutowiredFieldsWarningInspection", "StatementWithEmptyBody"})
public class RoleBeanController extends AbstractBaseController<RoleBean, BaseVo<RoleBean>> {

    @Override protected String getModuleName() {return "role";}

}