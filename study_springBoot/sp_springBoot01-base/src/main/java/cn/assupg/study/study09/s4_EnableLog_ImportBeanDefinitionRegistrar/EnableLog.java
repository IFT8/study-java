package cn.assupg.study.study09.s4_EnableLog_ImportBeanDefinitionRegistrar;

import org.springframework.context.annotation.Import;

import java.lang.annotation.*;

@Target(ElementType.TYPE)
@Retention(RetentionPolicy.RUNTIME)
@Documented
@Import(MyImportBeanDefinitionRegistrar.class)
public @interface EnableLog {
    String name();
}
