package com.comodin.fleet.service.impl;

import com.comodin.fleet.core.bean.LogBean;
import org.springframework.stereotype.Service;
import com.comodin.fleet.service.ILogBeanService;
import com.comodin.basic.vo.BaseVo;
import com.comodin.basic.service.AbstractBaseService;

@Service
public class LogBeanService extends AbstractBaseService<LogBean, BaseVo<LogBean>> implements ILogBeanService {

}