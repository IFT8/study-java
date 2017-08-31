package com.comodin.basic.util.logger;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

@SuppressWarnings({"UnnecessaryLocalVariable", "unused", "WeakerAccess"})
public class AuditLogsUtils {

    private static ThreadLocal<Log> local = new ThreadLocal<>();


    public static Log getLogger() {
        return local.get();
    }

    public static Log getLogger(Class<?> clazz) {
        Log log = local.get();
        return log != null ? log : LogFactory.getLog(clazz);
    }

    public static void setLogger(String auditLogClassName) {
        local.set(LogFactory.getLog(auditLogClassName));
    }

    public static void setLogger(Class<?> clazz) {
        local.set(LogFactory.getLog(clazz));
    }

    public static void removeLogger() {
        if (local != null) {
            local.remove();
        }
    }
}