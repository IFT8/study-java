package com.comodin.basic.util.logger;


import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

import java.lang.reflect.Method;

@Component
@Aspect
public class AuditLogAspect {

    //切点
    @Pointcut("@annotation(com.comodin.basic.util.logger.AuditLog)")
    public void pointcut() {
    }

    //环绕通知
    @Around("pointcut()")
    public Object around(ProceedingJoinPoint joinPoint) throws Throwable {

        Object result;
        //noinspection CaughtExceptionImmediatelyRethrown
        try {
            AuditLog auditLog = getTargetMethodAuditLogAnnotation(joinPoint);
            if (auditLog != null) {
                if (!"".equals(auditLog.value().trim())) {
                    AuditLogsUtils.setLogger(auditLog.value().trim());
                } else {
                    Class<?> clazz = auditLog.clazz();
                    AuditLogsUtils.setLogger(clazz);
                }
            }

            result = joinPoint.proceed();
        } catch (Throwable e) {
            throw e;
        } finally {
            AuditLogsUtils.removeLogger();
        }
        return result;
    }


    // 获取是否过滤标示
    private static AuditLog getTargetMethodAuditLogAnnotation(ProceedingJoinPoint joinPoint) throws ClassNotFoundException {
        //获取目标类名
        String targetName = joinPoint.getTarget().getClass().getName();
        //获取方法名
        String methodName = joinPoint.getSignature().getName();
        //获取相关参数
        Object[] arguments = joinPoint.getArgs();
        //生成类对象
        Class targetClass = Class.forName(targetName);
        //获取该类中的方法
        Method[] methods = targetClass.getMethods();

        for (Method method : methods) {
            if (!method.getName().equals(methodName)) {
                continue;
            }
            Class<?>[] methodParameterTypes = method.getParameterTypes();
            if (methodParameterTypes.length != arguments.length) {
                continue;
            }
            if (method.isAnnotationPresent(AuditLog.class)) {
                return method.getAnnotation(AuditLog.class);
            }
        }
        return null;
    }
}


////切点
//@Pointcut("execution(* com.zhangguo.Spring052.aop04.Math.a*(..))")
//public void pointcut(){
//}
//
////前置通知
//@Before("pointcut()")
//public void before(JoinPoint jp){
//    System.out.println(jp.getSignature().getName());
//    System.out.println("----------前置通知----------");
//}
//
////最终通知
//@After("pointcut()")
//public void after(JoinPoint jp){
//    System.out.println("----------最终通知----------");
//}
//
////环绕通知
//@Around("execution(* com.zhangguo.Spring052.aop04.Math.s*(..))")
//public Object around(ProceedingJoinPoint pjp) throws Throwable{
//    System.out.println(pjp.getSignature().getName());
//    System.out.println("----------环绕前置----------");
//    Object result=pjp.proceed();
//    System.out.println("----------环绕后置----------");
//    return result;
//}
//
////返回结果通知
//@AfterReturning(pointcut="execution(* com.zhangguo.Spring052.aop04.Math.m*(..))",returning="result")
//public void afterReturning(JoinPoint jp, Object result){
//    System.out.println(jp.getSignature().getName());
//    System.out.println("结果是："+result);
//    System.out.println("----------返回结果----------");
//}
//
////异常后通知
//@AfterThrowing(pointcut="execution(* com.zhangguo.Spring052.aop04.Math.d*(..))",throwing="exp")
//public void afterThrowing(JoinPoint jp,Exception exp){
//    System.out.println(jp.getSignature().getName());
//    System.out.println("异常消息："+exp.getMessage());
//    System.out.println("----------异常通知----------");
//}