package com.comodin.fleet.service.impl;

import com.comodin.fleet.service.ITaskBeanService;
import org.springframework.stereotype.Service;
import com.comodin.basic.vo.BaseVo;
import com.comodin.basic.service.AbstractBaseService;
import com.comodin.fleet.core.bean.TaskBean;

@Service
@SuppressWarnings({"unused", "SpringAutowiredFieldsWarningInspection", "StatementWithEmptyBody"})
public class TaskBeanService extends AbstractBaseService<TaskBean, BaseVo<TaskBean>> implements ITaskBeanService {

}