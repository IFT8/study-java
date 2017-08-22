package com.comodin.fleet.controller;

import com.comodin.basic.vo.BaseVo;
import org.springframework.web.bind.annotation.RequestMapping;
import com.comodin.basic.controller.AbstractBaseController;
import org.springframework.stereotype.Controller;
import com.comodin.fleet.core.bean.BankAtmBean;

@Controller
@RequestMapping("/bankAtm")
public class BankAtmBeanController extends AbstractBaseController<BankAtmBean, BaseVo<BankAtmBean>> {

    @Override protected String getModuleName() {return "bankAtm";}

}