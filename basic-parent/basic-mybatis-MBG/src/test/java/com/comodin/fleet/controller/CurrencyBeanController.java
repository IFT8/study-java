package com.comodin.fleet.controller;

import com.comodin.fleet.core.bean.CurrencyBean;
import com.comodin.basic.vo.BaseVo;
import org.springframework.web.bind.annotation.RequestMapping;
import com.comodin.basic.controller.AbstractBaseController;
import org.springframework.stereotype.Controller;

@Controller
@RequestMapping("/currency")
@SuppressWarnings({"unused", "SpringAutowiredFieldsWarningInspection", "StatementWithEmptyBody"})
public class CurrencyBeanController extends AbstractBaseController<CurrencyBean, BaseVo<CurrencyBean>> {

    @Override protected String getModuleName() {return "currency";}

}