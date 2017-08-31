package com.comodin.basic.util.logger;

import java.lang.annotation.*;

@Target({ElementType.METHOD, ElementType.TYPE})
@Retention(RetentionPolicy.RUNTIME)
@Documented
public @interface AuditLog {

    String value() default "";

    Class<?> clazz() default AuditLogsUtils.class;
}