package com.comodin.fleet.controller;

import com.comodin.fleet.core.bean.DepartmentRoleRelationBean;
import com.comodin.basic.vo.BaseVo;
import org.springframework.web.bind.annotation.RequestMapping;
import com.comodin.basic.controller.AbstractBaseController;
import org.springframework.stereotype.Controller;

@Controller
@RequestMapping("/departmentRoleRelation")
public class DepartmentRoleRelationBeanController extends AbstractBaseController<DepartmentRoleRelationBean, BaseVo<DepartmentRoleRelationBean>> {

    @Override protected String getModuleName() {return "departmentRoleRelation";}

}