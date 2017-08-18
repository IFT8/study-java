package com.comodin.fleet.controller;

import com.comodin.basic.vo.BaseVo;
import org.springframework.web.bind.annotation.RequestMapping;
import com.comodin.basic.controller.AbstractBaseController;
import org.springframework.stereotype.Controller;
import com.comodin.fleet.core.bean.SioLoginAccount;

@Controller
@RequestMapping("/sioLoginAccount")
public class SioLoginAccountController extends AbstractBaseController<SioLoginAccount, BaseVo<SioLoginAccount>> {

    @Override protected String getModuleName() {return "sioLoginAccount";}

}