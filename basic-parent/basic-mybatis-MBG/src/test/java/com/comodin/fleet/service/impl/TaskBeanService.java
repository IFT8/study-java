package com.comodin.fleet.service.impl;

import com.comodin.fleet.service.ITaskBeanService;
import com.comodin.fleet.bean.TaskBean;
import org.springframework.stereotype.Service;
import com.comodin.basic.vo.BaseVo;
import com.comodin.basic.service.AbstractBaseService;

@Service
public class TaskBeanService extends AbstractBaseService<TaskBean, BaseVo<TaskBean>> implements ITaskBeanService {

}