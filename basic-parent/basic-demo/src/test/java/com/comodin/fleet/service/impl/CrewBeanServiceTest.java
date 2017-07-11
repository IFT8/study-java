package com.comodin.fleet.service.impl;

import com.comodin.basic.test.BaseTestNGServiceTest;
import com.comodin.fleet.bean.CrewBean;
import com.comodin.fleet.constant.CrewBeanConstant;
import com.comodin.fleet.service.ICrewBeanService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.annotation.Rollback;
import org.testng.annotations.Test;

import java.util.List;


public class CrewBeanServiceTest extends BaseTestNGServiceTest {
    @Autowired
    ICrewBeanService crewBeanService;

    @Rollback(false)
    @Test
    public void testInsertSelective() throws Exception {
        CrewBean crewBean = new CrewBean().setUsername("test1").setInternalId("test1").setBranchId(1L).setStatus(CrewBeanConstant.CREW_BEAN_STATUS_DISABLE);
        crewBeanService.insertSelective(crewBean);
    }


    @Test
    public void testSelectAll() throws Exception {
        List<CrewBean> crewBeanList = crewBeanService.selectAll();
    }

}