package com.comodin.basic.test;

import org.springframework.test.context.testng.AbstractTransactionalTestNGSpringContextTests;
import org.springframework.transaction.annotation.Transactional;

//@Transactional            可以声明一个事务管理 每个单元测试都进行事务回滚 无论成功与否；extends AbstractTransactionalTestNGSpringContextTests { //回滚事务
//                          当然 你可以声明一个事务管理 每个单元测试都进行事务回滚 无论成功与否   //有些单元测试你不希望回滚 @Rollback(false)
@Transactional
//public abstract class AbstractTestNGTest extends AbstractTestNGSpringContextTests { //不回滚
public abstract class AbstractTestNGTest extends AbstractTransactionalTestNGSpringContextTests { //回滚
}
