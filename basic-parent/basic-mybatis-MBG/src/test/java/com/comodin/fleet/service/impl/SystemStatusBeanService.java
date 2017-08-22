package com.comodin.fleet.service.impl;

import com.comodin.fleet.core.bean.SystemStatusBean;
import org.springframework.stereotype.Service;
import com.comodin.fleet.service.ISystemStatusBeanService;
import com.comodin.basic.vo.BaseVo;
import com.comodin.basic.service.AbstractBaseService;

@Service
public class SystemStatusBeanService extends AbstractBaseService<SystemStatusBean, BaseVo<SystemStatusBean>> implements ISystemStatusBeanService {

}