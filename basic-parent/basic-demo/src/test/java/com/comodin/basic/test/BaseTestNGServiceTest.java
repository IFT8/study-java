package com.comodin.basic.test;

import org.springframework.test.context.ContextConfiguration;

//@ContextConfiguration     只解析了指明.xml，如果项目中还存在其他模块的applicationContext，也需要把他们引进来否则得到的Service就是null的。
@ContextConfiguration({"classpath*:/fleet-service.xml"})
public class BaseTestNGServiceTest extends AbstractTestNGTestServiceTest {

}
