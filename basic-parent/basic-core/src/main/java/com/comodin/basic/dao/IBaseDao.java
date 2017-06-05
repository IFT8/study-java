package com.comodin.basic.dao;

import tk.mybatis.mapper.common.Mapper;
import tk.mybatis.mapper.common.MySqlMapper;

import java.io.Serializable;

public interface IBaseDao<T extends Serializable> extends Mapper<T>, MySqlMapper<T> {


    /**
     * 批量删除，根据 主键，需要自己在 *Mapper.xml 文件中自己实现.
     *
     * @param primaryKeys 主键值
     */
    void batchDeleteByPrimaryKeys(Object... primaryKeys);

    /**
     * 批量业务逻辑上删除，根据 主键，需要自己在 *Mapper.xml 文件中自己实现.
     *
     * @param primaryKeys 主键值
     */
    void batchDeleteFlagByPrimaryKeys(Object... primaryKeys);
}
