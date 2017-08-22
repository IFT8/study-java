package com.comodin.fleet.service.impl;

import com.comodin.fleet.service.IClientBranchBeanService;
import org.springframework.stereotype.Service;
import com.comodin.fleet.core.bean.ClientBranchBean;
import com.comodin.basic.vo.BaseVo;
import com.comodin.basic.service.AbstractBaseService;

@Service
public class ClientBranchBeanService extends AbstractBaseService<ClientBranchBean, BaseVo<ClientBranchBean>> implements IClientBranchBeanService {

}