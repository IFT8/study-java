package com.comodin.basic.mybatis.generator.plugins;

import com.alibaba.fastjson.JSON;
import com.comodin.basic.mybatis.generator.json.RemarksJSON;
import com.comodin.basic.util.date.DateUtil;
import org.testng.annotations.Test;


public class remarksJSONTest {
    @Test
    public void testGetMin() throws Exception {
        RemarksJSON RemarksJSON = new RemarksJSON();
        RemarksJSON.setMin(1);
        RemarksJSON.setMin(10);
        RemarksJSON.setEmail(false);
        RemarksJSON.setPattern(DateUtil.DATE_PATTERN_YYYY_MM_DD_HH_MM_SS);
        RemarksJSON.getDataList().add("test1");
        RemarksJSON.getDataList().add("test2");
        RemarksJSON.getDataList().add("test3");
        System.out.println(JSON.toJSONString(RemarksJSON));

        RemarksJSON = new RemarksJSON();
        System.out.println(JSON.toJSONString(RemarksJSON));
    }

}