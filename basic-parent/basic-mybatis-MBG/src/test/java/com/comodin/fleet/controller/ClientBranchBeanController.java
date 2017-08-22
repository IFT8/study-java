package com.comodin.fleet.controller;

import com.comodin.fleet.core.bean.ClientBranchBean;
import com.comodin.basic.vo.BaseVo;
import org.springframework.web.bind.annotation.RequestMapping;
import com.comodin.basic.controller.AbstractBaseController;
import org.springframework.stereotype.Controller;

@Controller
@RequestMapping("/clientBranch")
@SuppressWarnings({"unused", "SpringAutowiredFieldsWarningInspection", "StatementWithEmptyBody"})
public class ClientBranchBeanController extends AbstractBaseController<ClientBranchBean, BaseVo<ClientBranchBean>> {

    @Override protected String getModuleName() {return "clientBranch";}

}