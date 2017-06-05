package com.comodin.basic.dao.support;

import org.apache.ibatis.annotations.InsertProvider;

public interface IBatchDeleteByPrimaryKeys<T> {

    @InsertProvider(type = BatchDeleteByPrimaryKeys.class, method = "dynamicSQL")
    int batchDeleteByPrimaryKeys(Object... primaryKeys);
}
