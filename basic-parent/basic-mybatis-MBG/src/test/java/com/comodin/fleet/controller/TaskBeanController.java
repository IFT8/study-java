package com.comodin.fleet.controller;

import com.comodin.basic.vo.BaseVo;
import org.springframework.web.bind.annotation.RequestMapping;
import com.comodin.basic.controller.AbstractBaseController;
import org.springframework.stereotype.Controller;
import com.comodin.fleet.core.bean.TaskBean;

@Controller
@RequestMapping("/task")
@SuppressWarnings({"unused", "SpringAutowiredFieldsWarningInspection", "StatementWithEmptyBody"})
public class TaskBeanController extends AbstractBaseController<TaskBean, BaseVo<TaskBean>> {

    @Override protected String getModuleName() {return "task";}

}