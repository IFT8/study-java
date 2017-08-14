package com.comodin.fleet.controller;

import com.comodin.fleet.core.bean.TaskInterChangeBean;
import com.comodin.basic.vo.BaseVo;
import org.springframework.web.bind.annotation.RequestMapping;
import com.comodin.basic.controller.AbstractBaseController;
import org.springframework.stereotype.Controller;

@Controller
@RequestMapping("/taskInterChange")
public class TaskInterChangeBeanController extends AbstractBaseController<TaskInterChangeBean, BaseVo<TaskInterChangeBean>> {

    @Override protected String getModuleName() {return "taskInterChange";}

}