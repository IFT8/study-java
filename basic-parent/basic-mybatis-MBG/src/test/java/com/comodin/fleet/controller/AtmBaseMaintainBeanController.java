package com.comodin.fleet.controller;

import com.comodin.fleet.core.bean.AtmBaseMaintainBean;
import com.comodin.basic.vo.BaseVo;
import org.springframework.web.bind.annotation.RequestMapping;
import com.comodin.basic.controller.AbstractBaseController;
import org.springframework.stereotype.Controller;

@Controller
@RequestMapping("/atmBaseMaintain")
@SuppressWarnings({"unused", "SpringAutowiredFieldsWarningInspection", "StatementWithEmptyBody"})
public class AtmBaseMaintainBeanController extends AbstractBaseController<AtmBaseMaintainBean, BaseVo<AtmBaseMaintainBean>> {

    @Override protected String getModuleName() {return "atmBaseMaintain";}

}