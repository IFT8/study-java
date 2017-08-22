package com.comodin.fleet.controller;

import com.comodin.fleet.core.bean.SystemStatusBean;
import com.comodin.basic.vo.BaseVo;
import org.springframework.web.bind.annotation.RequestMapping;
import com.comodin.basic.controller.AbstractBaseController;
import org.springframework.stereotype.Controller;

@Controller
@RequestMapping("/systemStatus")
@SuppressWarnings({"unused", "SpringAutowiredFieldsWarningInspection", "StatementWithEmptyBody"})
public class SystemStatusBeanController extends AbstractBaseController<SystemStatusBean, BaseVo<SystemStatusBean>> {

    @Override protected String getModuleName() {return "systemStatus";}

}