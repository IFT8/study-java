package com.comodin.fleet.controller;

import com.comodin.basic.vo.BaseVo;
import org.springframework.web.bind.annotation.RequestMapping;
import com.comodin.basic.controller.AbstractBaseController;
import org.springframework.stereotype.Controller;
import com.comodin.fleet.core.bean.BankAtmLogBean;

@Controller
@RequestMapping("/bankAtmLog")
public class BankAtmLogBeanController extends AbstractBaseController<BankAtmLogBean, BaseVo<BankAtmLogBean>> {

    @Override protected String getModuleName() {return "bankAtmLog";}

}