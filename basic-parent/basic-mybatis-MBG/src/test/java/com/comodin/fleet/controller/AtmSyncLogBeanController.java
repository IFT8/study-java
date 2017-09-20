package com.comodin.fleet.controller;

import com.comodin.fleet.core.bean.AtmSyncLogBean;
import com.comodin.basic.vo.BaseVo;
import org.springframework.web.bind.annotation.RequestMapping;
import com.comodin.basic.controller.AbstractBaseController;
import org.springframework.stereotype.Controller;

@Controller
@RequestMapping("/atmSyncLog")
@SuppressWarnings({"unused", "SpringAutowiredFieldsWarningInspection", "StatementWithEmptyBody"})
public class AtmSyncLogBeanController extends AbstractBaseController<AtmSyncLogBean, BaseVo<AtmSyncLogBean>> {

    @Override protected String getModuleName() {return "atmSyncLog";}

}