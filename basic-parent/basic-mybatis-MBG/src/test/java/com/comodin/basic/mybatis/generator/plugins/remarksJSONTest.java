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

    @Test
    public void test001() throws Exception {
        String s = "1111aa【{\"dataList\":[\"test2\",\"test3\",\"test1\"],\"email\":false,\"min\":10,\"pattern\":\"yyyy-MM-dd HH:mm:ss\"}】";
        System.out.println(PluginsUtils.extractRemarksDescription(s));
    }

    @Test
    public void test002() throws Exception {
        String s = "1111aa【{\"dataList\":[\"test2\",\"test3\",\"test1\"],\"email\":false,\"min\":10,\"pattern\":\"yyyy-MM-dd HH:mm:ss\"}】111";
        System.out.println(PluginsUtils.extractRemarksJSON(s));
    }
}