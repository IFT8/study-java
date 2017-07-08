package com.comodin.basic.util;

import org.testng.annotations.Test;

/**
 * Created by supeng on 2017/7/8.
 */
public class MyStringUtilsTest {
    @Test
    public void testCamelToUnderline() throws Exception {
        String aaa = "appVersionFld";
        System.out.println(MyStringUtils.camelToUnderline(aaa));
    }

    @Test
    public void testUnderlineToCamel() throws Exception {
        String aaa = "app_version_fld";
        System.out.println(MyStringUtils.underlineToCamel(aaa));
    }

    @Test
    public void testUnderlineToCamel2() throws Exception {
        String aaa = "app_version_fld";
        System.out.println(MyStringUtils.underlineToCamel2(aaa));
    }

}