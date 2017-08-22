package com.comodin.fleet.controller;

import com.comodin.fleet.core.bean.SioTaskBean;
import com.comodin.basic.vo.BaseVo;
import org.springframework.web.bind.annotation.RequestMapping;
import com.comodin.basic.controller.AbstractBaseController;
import org.springframework.stereotype.Controller;

@Controller
@RequestMapping("/sioTask")
@SuppressWarnings({"unused", "SpringAutowiredFieldsWarningInspection", "StatementWithEmptyBody"})
public class SioTaskBeanController extends AbstractBaseController<SioTaskBean, BaseVo<SioTaskBean>> {

    @Override protected String getModuleName() {return "sioTask";}

}