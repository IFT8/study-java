package com.comodin.fleet.controller;

import com.comodin.fleet.core.bean.CrewBean;
import com.comodin.basic.vo.BaseVo;
import org.springframework.web.bind.annotation.RequestMapping;
import com.comodin.basic.controller.AbstractBaseController;
import org.springframework.stereotype.Controller;

@RequestMapping("/crew")
@Controller
@SuppressWarnings({"unused", "SpringAutowiredFieldsWarningInspection", "StatementWithEmptyBody"})
public class CrewBeanController extends AbstractBaseController<CrewBean, BaseVo<CrewBean>> {

    @Override protected String getModuleName() {return "crew";}

}