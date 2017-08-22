package com.comodin.fleet.controller;

import com.comodin.basic.vo.BaseVo;
import org.springframework.web.bind.annotation.RequestMapping;
import com.comodin.basic.controller.AbstractBaseController;
import org.springframework.stereotype.Controller;
import com.comodin.fleet.core.bean.SioLoginAccountBean;

@Controller
@RequestMapping("/sioLoginAccount")
@SuppressWarnings({"unused", "SpringAutowiredFieldsWarningInspection", "StatementWithEmptyBody"})
public class SioLoginAccountBeanController extends AbstractBaseController<SioLoginAccountBean, BaseVo<SioLoginAccountBean>> {

    @Override protected String getModuleName() {return "sioLoginAccount";}

}