package com.comodin.fleet.controller;

import com.comodin.basic.vo.BaseVo;
import com.comodin.fleet.core.bean.AtmGunneboTransactionBean;
import org.springframework.web.bind.annotation.RequestMapping;
import com.comodin.basic.controller.AbstractBaseController;
import org.springframework.stereotype.Controller;

@Controller
@RequestMapping("/atmGunneboTransaction")
@SuppressWarnings({"unused", "SpringAutowiredFieldsWarningInspection", "StatementWithEmptyBody"})
public class AtmGunneboTransactionBeanController extends AbstractBaseController<AtmGunneboTransactionBean, BaseVo<AtmGunneboTransactionBean>> {

    @Override protected String getModuleName() {return "atmGunneboTransaction";}

}