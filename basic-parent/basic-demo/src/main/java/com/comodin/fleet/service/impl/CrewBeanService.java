package com.comodin.fleet.service.impl;

import com.comodin.fleet.service.ICrewBeanService;
import org.springframework.stereotype.Service;
import com.comodin.basic.vo.BaseVo;
import com.comodin.basic.service.AbstractBaseService;
import com.comodin.fleet.bean.CrewBean;

@Service
public class CrewBeanService extends AbstractBaseService<CrewBean, BaseVo<CrewBean>> implements ICrewBeanService {

}