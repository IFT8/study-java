package com.comodin.fleet.service.impl;

import com.comodin.fleet.core.bean.ClientBean;
import org.springframework.stereotype.Service;
import com.comodin.fleet.service.IClientBeanService;
import com.comodin.basic.vo.BaseVo;
import com.comodin.basic.service.AbstractBaseService;

@Service
public class ClientBeanService extends AbstractBaseService<ClientBean, BaseVo<ClientBean>> implements IClientBeanService {

}