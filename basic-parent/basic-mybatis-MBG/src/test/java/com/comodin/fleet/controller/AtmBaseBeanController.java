package com.comodin.fleet.controller;

import com.comodin.basic.vo.BaseVo;
import org.springframework.web.bind.annotation.RequestMapping;
import com.comodin.basic.controller.AbstractBaseController;
import org.springframework.stereotype.Controller;
import com.comodin.fleet.core.bean.AtmBaseBean;

@Controller
@RequestMapping("/atmBase")
public class AtmBaseBeanController extends AbstractBaseController<AtmBaseBean, BaseVo<AtmBaseBean>> {

    @Override protected String getModuleName() {return "atmBase";}

}