package com.comodin.fleet.controller;

import com.comodin.fleet.core.bean.SioTaskComprobantesBean;
import com.comodin.basic.vo.BaseVo;
import org.springframework.web.bind.annotation.RequestMapping;
import com.comodin.basic.controller.AbstractBaseController;
import org.springframework.stereotype.Controller;

@Controller
@RequestMapping("/sioTaskComprobantes")
public class SioTaskComprobantesBeanController extends AbstractBaseController<SioTaskComprobantesBean, BaseVo<SioTaskComprobantesBean>> {

    @Override protected String getModuleName() {return "sioTaskComprobantes";}

}