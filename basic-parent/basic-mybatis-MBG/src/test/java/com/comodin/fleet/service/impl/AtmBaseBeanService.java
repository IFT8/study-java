package com.comodin.fleet.service.impl;

import com.comodin.fleet.service.IAtmBaseBeanService;
import org.springframework.stereotype.Service;
import com.comodin.basic.vo.BaseVo;
import com.comodin.basic.service.AbstractBaseService;
import com.comodin.fleet.core.bean.AtmBaseBean;

@Service
@SuppressWarnings({"unused", "SpringAutowiredFieldsWarningInspection", "StatementWithEmptyBody"})
public class AtmBaseBeanService extends AbstractBaseService<AtmBaseBean, BaseVo<AtmBaseBean>> implements IAtmBaseBeanService {

}