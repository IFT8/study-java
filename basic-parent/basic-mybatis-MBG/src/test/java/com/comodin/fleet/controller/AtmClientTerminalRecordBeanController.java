package com.comodin.fleet.controller;

import com.comodin.basic.vo.BaseVo;
import org.springframework.web.bind.annotation.RequestMapping;
import com.comodin.basic.controller.AbstractBaseController;
import org.springframework.stereotype.Controller;
import com.comodin.fleet.core.bean.AtmClientTerminalRecordBean;

@Controller
@RequestMapping("/atmClientTerminalRecord")
@SuppressWarnings({"unused", "SpringAutowiredFieldsWarningInspection", "StatementWithEmptyBody"})
public class AtmClientTerminalRecordBeanController extends AbstractBaseController<AtmClientTerminalRecordBean, BaseVo<AtmClientTerminalRecordBean>> {

    @Override protected String getModuleName() {return "atmClientTerminalRecord";}

}