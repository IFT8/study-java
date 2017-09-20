package com.comodin.fleet.controller;

import com.comodin.fleet.core.bean.UpgradeBean;
import com.comodin.basic.vo.BaseVo;
import org.springframework.web.bind.annotation.RequestMapping;
import com.comodin.basic.controller.AbstractBaseController;
import org.springframework.stereotype.Controller;

@Controller
@RequestMapping("/upgrade")
@SuppressWarnings({"unused", "SpringAutowiredFieldsWarningInspection", "StatementWithEmptyBody"})
public class UpgradeBeanController extends AbstractBaseController<UpgradeBean, BaseVo<UpgradeBean>> {

    @Override protected String getModuleName() {return "upgrade";}

}