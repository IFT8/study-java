package com.comodin.basic.util.db.rws;

import org.springframework.jdbc.datasource.lookup.AbstractRoutingDataSource;

public class DynamicDataSource extends AbstractRoutingDataSource {
    public static final String DYNAMIC_DATA_SOURCE_LOG_PACKAGE_NAME = "com.comodin.db.rws";

    @Override
    protected Object determineCurrentLookupKey() {
        return DynamicDataSourceHolder.getDbType();
    }
}