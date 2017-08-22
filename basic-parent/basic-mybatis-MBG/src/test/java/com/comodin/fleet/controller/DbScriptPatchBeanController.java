package com.comodin.fleet.controller;

import com.comodin.basic.vo.BaseVo;
import org.springframework.web.bind.annotation.RequestMapping;
import com.comodin.basic.controller.AbstractBaseController;
import org.springframework.stereotype.Controller;
import com.comodin.fleet.core.bean.DbScriptPatchBean;

@Controller
@RequestMapping("/dbScriptPatch")
@SuppressWarnings({"unused", "SpringAutowiredFieldsWarningInspection", "StatementWithEmptyBody"})
public class DbScriptPatchBeanController extends AbstractBaseController<DbScriptPatchBean, BaseVo<DbScriptPatchBean>> {

    @Override protected String getModuleName() {return "dbScriptPatch";}

}