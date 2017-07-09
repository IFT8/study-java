package com.comodin.fleet.controller;

import org.springframework.stereotype.Controller;;
import com.comodin.basic.vo.BaseVo;
import org.springframework.web.bind.annotation.RequestMapping;
import com.comodin.basic.controller.AbstractBaseController;
import com.comodin.fleet.bean.CrewBean;

@RequestMapping("/crew")
@Controller
public class CrewBeanController extends AbstractBaseController<CrewBean, BaseVo<CrewBean>> {

    @Override protected String getModuleName() {return "crew";}

}