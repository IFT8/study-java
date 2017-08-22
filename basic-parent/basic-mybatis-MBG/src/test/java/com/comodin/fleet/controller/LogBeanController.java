package com.comodin.fleet.controller;

import com.comodin.fleet.core.bean.LogBean;
import com.comodin.basic.vo.BaseVo;
import org.springframework.web.bind.annotation.RequestMapping;
import com.comodin.basic.controller.AbstractBaseController;
import org.springframework.stereotype.Controller;

@Controller
@RequestMapping("/log")
public class LogBeanController extends AbstractBaseController<LogBean, BaseVo<LogBean>> {

    @Override protected String getModuleName() {return "log";}

}