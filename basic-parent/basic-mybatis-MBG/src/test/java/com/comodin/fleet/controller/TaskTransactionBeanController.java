package com.comodin.fleet.controller;

import com.comodin.fleet.core.bean.TaskTransactionBean;
import com.comodin.basic.vo.BaseVo;
import org.springframework.web.bind.annotation.RequestMapping;
import com.comodin.basic.controller.AbstractBaseController;
import org.springframework.stereotype.Controller;

@Controller
@RequestMapping("/taskTransaction")
@SuppressWarnings({"unused", "SpringAutowiredFieldsWarningInspection", "StatementWithEmptyBody"})
public class TaskTransactionBeanController extends AbstractBaseController<TaskTransactionBean, BaseVo<TaskTransactionBean>> {

    @Override protected String getModuleName() {return "taskTransaction";}

}