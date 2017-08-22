package com.comodin.fleet.controller;

import com.comodin.fleet.core.bean.DepartmentBean;
import com.comodin.basic.vo.BaseVo;
import org.springframework.web.bind.annotation.RequestMapping;
import com.comodin.basic.controller.AbstractBaseController;
import org.springframework.stereotype.Controller;

@Controller
@RequestMapping("/department")
public class DepartmentBeanController extends AbstractBaseController<DepartmentBean, BaseVo<DepartmentBean>> {

    @Override protected String getModuleName() {return "department";}

}