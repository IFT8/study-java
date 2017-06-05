package com.comodin.basic;

import com.comodin.basic.util.AnnotationUtil;
import org.testng.annotations.Test;

/**
 * Created by supeng on 2017/3/2.
 */
public class BaseTempTest {
    @Test
    public void test001() throws Exception {
        System.out.println(AnnotationUtil.getBeanPrimarykeyFieldName(BankAtmBean.class));
    }
}
