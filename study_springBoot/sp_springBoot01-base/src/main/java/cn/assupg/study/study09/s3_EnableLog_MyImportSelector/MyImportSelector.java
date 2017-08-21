package cn.assupg.study09.s3_EnableLog_MyImportSelector;

import org.springframework.context.annotation.ImportSelector;
import org.springframework.core.type.AnnotationMetadata;

public class MyImportSelector implements ImportSelector {

    @Override
    public String[] selectImports(AnnotationMetadata importingClassMetadata) {

        System.out.println(importingClassMetadata.getAnnotationAttributes(EnableLog.class.getName()));
        /**
         * 这是可以获取得注解的详细信息，然后，根据信息去动态的返回需要被spring容器去管理的bean
         */

        return new String[]{"User"};
    }
}
