package com.comodin.fleet.controller;

import com.comodin.fleet.core.bean.XmlRecordSioToComodinBean;
import com.comodin.basic.vo.BaseVo;
import org.springframework.web.bind.annotation.RequestMapping;
import com.comodin.basic.controller.AbstractBaseController;
import org.springframework.stereotype.Controller;

@Controller
@RequestMapping("/xmlRecordSioToComodin")
@SuppressWarnings({"unused", "SpringAutowiredFieldsWarningInspection", "StatementWithEmptyBody"})
public class XmlRecordSioToComodinBeanController extends AbstractBaseController<XmlRecordSioToComodinBean, BaseVo<XmlRecordSioToComodinBean>> {

    @Override protected String getModuleName() {return "xmlRecordSioToComodin";}

}