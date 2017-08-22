package com.comodin.fleet.controller;

import com.comodin.basic.vo.BaseVo;
import org.springframework.web.bind.annotation.RequestMapping;
import com.comodin.basic.controller.AbstractBaseController;
import org.springframework.stereotype.Controller;
import com.comodin.fleet.core.bean.ComprobantesBagNumberBean;

@Controller
@RequestMapping("/comprobantesBagNumber")
public class ComprobantesBagNumberBeanController extends AbstractBaseController<ComprobantesBagNumberBean, BaseVo<ComprobantesBagNumberBean>> {

    @Override protected String getModuleName() {return "comprobantesBagNumber";}

}