package com.comodin.basic.util.db.rws;

import com.comodin.basic.util.RandomUtils;
import org.apache.log4j.Logger;

import java.util.HashSet;
import java.util.Set;

public class DynamicDataSourceHolder {

    private static final Logger log = Logger.getLogger(DynamicDataSource.DYNAMIC_DATA_SOURCE_LOG_PACKAGE_NAME);

    /**
     * 线程threadLocal
     */
    private static final ThreadLocal<DynamicDataSourceType> contextHolder = new ThreadLocal<>();

    private static final Set<DynamicDataSourceType> dbContextSlaveTypeSet = new HashSet<>();

    static {
        dbContextSlaveTypeSet.add(DynamicDataSourceType.DATA_SOURCE_SLAVE1);
        dbContextSlaveTypeSet.add(DynamicDataSourceType.DATA_SOURCE_SLAVE2);
        dbContextSlaveTypeSet.add(DynamicDataSourceType.DATA_SOURCE_SLAVE3);
        dbContextSlaveTypeSet.add(DynamicDataSourceType.DATA_SOURCE_SLAVE4);
        dbContextSlaveTypeSet.add(DynamicDataSourceType.DATA_SOURCE_SLAVE5);
    }

    public static ThreadLocal<DynamicDataSourceType> getContextHolder() {
        return contextHolder;
    }

    public static DynamicDataSourceType getDbType() {
        if (log.isDebugEnabled()) {
            log.debug("DynamicDataSourceHolder Current db type: " + ((contextHolder.get() == null) ? " null " : contextHolder.get().name()));
        }
        return contextHolder.get();
    }

    /**
     * 设置本线程的dbtype
     *
     * @param dynamicDataSourceType
     */
    public static void setDbType(DynamicDataSourceType dynamicDataSourceType) {
        contextHolder.set(dynamicDataSourceType);
    }

    /**
     * clearDBType
     *
     * @Title: clearDBType
     * @Description: 清理连接类型
     */
    public static void clearDBType() {
        contextHolder.remove();
    }

    public static void setDbTypeMaster() {
        setDbType(DynamicDataSourceType.DATA_SOURCE_MASTER);
    }

    public static void setDbTypeSlave() {
        setDbType(RandomUtils.getRandomElement(dbContextSlaveTypeSet));
    }
}
