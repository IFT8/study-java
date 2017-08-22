package com.comodin.fleet.controller;

import com.comodin.fleet.core.bean.SettingBean;
import com.comodin.basic.vo.BaseVo;
import org.springframework.web.bind.annotation.RequestMapping;
import com.comodin.basic.controller.AbstractBaseController;
import org.springframework.stereotype.Controller;

@Controller
@RequestMapping("/setting")
@SuppressWarnings({"unused", "SpringAutowiredFieldsWarningInspection", "StatementWithEmptyBody"})
public class SettingBeanController extends AbstractBaseController<SettingBean, BaseVo<SettingBean>> {

    @Override protected String getModuleName() {return "setting";}

}