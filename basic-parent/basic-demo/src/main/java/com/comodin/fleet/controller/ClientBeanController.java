package com.comodin.fleet.controller;

import com.comodin.fleet.bean.ClientBean;
import com.comodin.basic.vo.BaseVo;
import org.springframework.web.bind.annotation.RequestMapping;
import com.comodin.basic.controller.AbstractBaseController;
import org.springframework.stereotype.Controller;

@Controller
@RequestMapping("/client")
public class ClientBeanController extends AbstractBaseController<ClientBean, BaseVo<ClientBean>> {

    @Override protected String getModuleName() {return "client";}

}