package com.comodin.fleet.controller;

import com.comodin.fleet.core.bean.PrivilegeBean;
import com.comodin.basic.vo.BaseVo;
import org.springframework.web.bind.annotation.RequestMapping;
import com.comodin.basic.controller.AbstractBaseController;
import org.springframework.stereotype.Controller;

@Controller
@RequestMapping("/privilege")
@SuppressWarnings({"unused", "SpringAutowiredFieldsWarningInspection", "StatementWithEmptyBody"})
public class PrivilegeBeanController extends AbstractBaseController<PrivilegeBean, BaseVo<PrivilegeBean>> {

    @Override protected String getModuleName() {return "privilege";}

}