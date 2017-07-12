package com.comodin.fleet.controller;

import com.comodin.fleet.bean.TaskBean;
import com.comodin.basic.vo.BaseVo;
import org.springframework.web.bind.annotation.RequestMapping;
import com.comodin.basic.controller.AbstractBaseController;
import org.springframework.stereotype.Controller;

@Controller
@RequestMapping("/task")
public class TaskBeanController extends AbstractBaseController<TaskBean, BaseVo<TaskBean>> {

    @Override protected String getModuleName() {return "task";}

}