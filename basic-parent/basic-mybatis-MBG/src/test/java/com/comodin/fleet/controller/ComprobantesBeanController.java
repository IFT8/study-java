package com.comodin.fleet.controller;

import com.comodin.basic.vo.BaseVo;
import org.springframework.web.bind.annotation.RequestMapping;
import com.comodin.basic.controller.AbstractBaseController;
import org.springframework.stereotype.Controller;
import com.comodin.fleet.core.bean.ComprobantesBean;

@Controller
@RequestMapping("/comprobantes")
@SuppressWarnings({"unused", "SpringAutowiredFieldsWarningInspection", "StatementWithEmptyBody"})
public class ComprobantesBeanController extends AbstractBaseController<ComprobantesBean, BaseVo<ComprobantesBean>> {

    @Override protected String getModuleName() {return "comprobantes";}

}