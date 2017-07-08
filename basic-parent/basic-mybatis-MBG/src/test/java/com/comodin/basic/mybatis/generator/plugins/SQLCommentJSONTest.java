package com.comodin.basic.mybatis.generator.plugins;

import com.alibaba.fastjson.JSON;
import com.comodin.basic.util.date.DateUtil;
import org.testng.annotations.Test;


public class SQLCommentJSONTest {
    @Test
    public void testGetMin() throws Exception {
        SQLCommentJSON sqlCommentJSON = new SQLCommentJSON();
        sqlCommentJSON.setMin(1);
        sqlCommentJSON.setMin(10);
        sqlCommentJSON.setEmail(false);
        sqlCommentJSON.setPattern(DateUtil.DATE_PATTERN_YYYY_MM_DD_HH_MM_SS);
        sqlCommentJSON.getDataList().add("test1");
        sqlCommentJSON.getDataList().add("test2");
        sqlCommentJSON.getDataList().add("test3");
        System.out.println(JSON.toJSONString(sqlCommentJSON));

        sqlCommentJSON = new SQLCommentJSON();
        System.out.println(JSON.toJSONString(sqlCommentJSON));
    }

}