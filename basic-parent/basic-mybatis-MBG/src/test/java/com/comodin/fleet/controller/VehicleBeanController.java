package com.comodin.fleet.controller;

import com.comodin.basic.vo.BaseVo;
import org.springframework.web.bind.annotation.RequestMapping;
import com.comodin.fleet.core.bean.VehicleBean;
import com.comodin.basic.controller.AbstractBaseController;
import org.springframework.stereotype.Controller;

@RequestMapping("/vehicle")
@Controller
public class VehicleBeanController extends AbstractBaseController<VehicleBean, BaseVo<VehicleBean>> {

    @Override protected String getModuleName() {return "vehicle";}

}