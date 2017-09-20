package com.comodin.fleet.controller;

import com.comodin.fleet.core.bean.AtmGunneboBean;
import com.comodin.basic.vo.BaseVo;
import org.springframework.web.bind.annotation.RequestMapping;
import com.comodin.basic.controller.AbstractBaseController;
import org.springframework.stereotype.Controller;

@Controller
@RequestMapping("/atmGunnebo")
@SuppressWarnings({"unused", "SpringAutowiredFieldsWarningInspection", "StatementWithEmptyBody"})
public class AtmGunneboBeanController extends AbstractBaseController<AtmGunneboBean, BaseVo<AtmGunneboBean>> {

    @Override protected String getModuleName() {return "atmGunnebo";}

}