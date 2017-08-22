package com.comodin.fleet.controller;

import com.comodin.fleet.core.bean.ComprobantesBankNoteBean;
import com.comodin.basic.vo.BaseVo;
import org.springframework.web.bind.annotation.RequestMapping;
import com.comodin.basic.controller.AbstractBaseController;
import org.springframework.stereotype.Controller;

@Controller
@RequestMapping("/comprobantesBankNote")
public class ComprobantesBankNoteBeanController extends AbstractBaseController<ComprobantesBankNoteBean, BaseVo<ComprobantesBankNoteBean>> {

    @Override protected String getModuleName() {return "comprobantesBankNote";}

}