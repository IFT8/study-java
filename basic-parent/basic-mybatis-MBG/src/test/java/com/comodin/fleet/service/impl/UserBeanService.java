package com.comodin.fleet.service.impl;

import com.comodin.fleet.core.bean.UserBean;
import com.comodin.fleet.service.IUserBeanService;
import org.springframework.stereotype.Service;
import com.comodin.basic.vo.BaseVo;
import com.comodin.basic.service.AbstractBaseService;

@Service
public class UserBeanService extends AbstractBaseService<UserBean, BaseVo<UserBean>> implements IUserBeanService {

}