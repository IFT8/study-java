package com.comodin.fleet.service.impl;

import com.comodin.fleet.service.IAtmBaseTransactionBeanService;
import com.comodin.fleet.core.bean.AtmBaseTransactionBean;
import org.springframework.stereotype.Service;
import com.comodin.basic.vo.BaseVo;
import com.comodin.basic.service.AbstractBaseService;

@Service
@SuppressWarnings({"unused", "SpringAutowiredFieldsWarningInspection", "StatementWithEmptyBody"})
public class AtmBaseTransactionBeanService extends AbstractBaseService<AtmBaseTransactionBean, BaseVo<AtmBaseTransactionBean>> implements IAtmBaseTransactionBeanService {

}