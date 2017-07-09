package com.comodin.basic.service;

import com.comodin.basic.exception.BusinessLogicException;
import com.comodin.basic.exception.ParameterException;
import com.comodin.basic.vo.BaseVo;
import org.apache.ibatis.session.RowBounds;
import org.springframework.web.multipart.MultipartFile;
import tk.mybatis.mapper.entity.Example;

import java.io.Serializable;
import java.util.List;

/**
 * service层 通用基类接口
 *
 * @param <T>  实体bean
 * @param <VO> VO,即
 */
@SuppressWarnings({"UnusedReturnValue", "unused"})
public interface IBaseService<T extends Serializable, VO extends BaseVo> {

    /**
     * <pre>
     *      业务功能：保存一个实体，null的属性也会保存，不会使用数据库默认值
     * </pre>
     *
     * @param entity 要保存的实体对象
     *
     * @return T                      返回当前传递的实体对象，其中包含了当前保存对象，在数据库中对应的ID
     *
     * @throws ParameterException     若必需参数不合法，抛出
     * @throws BusinessLogicException 预留【根据各模块自身的业务逻辑需求，自行抛出】
     */
    T insert(T entity) throws ParameterException, BusinessLogicException;

    /**
     * <pre>
     *      业务功能：保存一个实体，null的属性也会保存，不会使用数据库默认值
     *      注意事项：此接口方法，默认实现为空，需要各模块，自己重写业务逻辑。
     * </pre>
     *
     * @param entity         要保存的实体对象
     * @param multipartFiles 文件流
     *
     * @return T                      返回当前传递的实体对象，其中包含了当前保存对象，在数据库中对应的ID
     *
     * @throws ParameterException     若必需参数不合法，抛出
     * @throws BusinessLogicException 预留【根据各模块自身的业务逻辑需求，自行抛出】
     */
    T insert(T entity, MultipartFile... multipartFiles) throws ParameterException, BusinessLogicException;

    /**
     * <pre>
     *      业务功能：保存一个实体，null的属性不会保存，会使用数据库默认值
     * </pre>
     *
     * @param entity 要保存的实体对象
     *
     * @return T                      返回当前传递的实体对象，其中包含了当前保存对象，在数据库中对应的ID
     *
     * @throws ParameterException     若必需参数不合法，抛出
     * @throws BusinessLogicException 预留【根据各模块自身的业务逻辑需求，自行抛出】
     */
    T insertSelective(T entity) throws ParameterException, BusinessLogicException;

    /**
     * <pre>
     *      业务功能：批量保存，只会返回插入到数据中的条数；entityList中对应的实体对象并不会对应的ID
     *      SQL格式：INSERT INTO table (字段名1,字段名2,字段名3,......) VALUES
     *                                (字段名1值,字段名2值,字段名3值),
     *                                (字段名1值,字段名2值,字段名3值),
     *                                (字段名1值,字段名2值,字段名3值),
     *                                 ....;
     * </pre>
     *
     * @param entityList 要保存的实体对象列表集合
     *
     * @return 总结插入数据库中的记录数
     *
     * @throws ParameterException     若必需参数不合法，抛出
     * @throws BusinessLogicException 预留【根据各模块自身的业务逻辑需求，自行抛出】
     */
    int insertList(List<T> entityList) throws ParameterException, BusinessLogicException;

    /**
     * <pre>
     *      业务功能：批量保存，只会返回插入到数据中的条数；entityList 中对应的实体对象并不会对应的ID
     *      注意事项：指定批次插入条数，若整个 entityList 的条数少于指定 batchNumber，即一次写入，若多条指定 batchNumber，分批次进行写入
     *      SQL格式：INSERT INTO table (字段名1,字段名2,字段名3,......) VALUES
     *                                (字段名1值,字段名2值,字段名3值),
     *                                (字段名1值,字段名2值,字段名3值),
     *                                (字段名1值,字段名2值,字段名3值),
     *                                 ....;
     * </pre>
     *
     * @param entityList      要保存的实体对象列表集合
     * @param eachBatchNumber 指定批次插入条数，若整个 entityList 的条数少于指定 batchNumber，即一次写入，若多条指定 batchNumber，分批次进行写入
     *
     * @return 总结插入数据库中的记录数
     *
     * @throws ParameterException     若必需参数不合法，抛出
     * @throws BusinessLogicException 预留【根据各模块自身的业务逻辑需求，自行抛出】
     */
    int insertList(List<T> entityList, Integer eachBatchNumber) throws ParameterException, BusinessLogicException;

    /**
     * <pre>
     *      业务功能：指定表名批量插入数据，主要用于数据库分表，表名不同
     * </pre>
     *
     * @param entityList 要保存的实体对象列表集合
     * @param tableName  对应的表名
     *
     * @return 总结插入数据库中的记录数
     *
     * @throws ParameterException     若必需参数不合法，抛出
     * @throws BusinessLogicException 预留【根据各模块自身的业务逻辑需求，自行抛出】
     */
    int insertListByTableName(List<T> entityList, String tableName) throws ParameterException, BusinessLogicException;

    /**
     * <pre>
     *      业务功能：根据主键，删除当前对象
     * </pre>
     *
     * @param primaryKey 主键
     *
     * @return 返回删除成功的记录数
     *
     * @throws ParameterException     若必需参数不合法，抛出
     * @throws BusinessLogicException 预留【根据各模块自身的业务逻辑需求，自行抛出】
     */
    int deleteByPrimaryKey(Object primaryKey) throws ParameterException, BusinessLogicException;

    /**
     * <pre>
     *     业务功能：根据实体record中的属性进行查询，删除符合的记录
     * </pre>
     *
     * @param record 实体record中的属性进行查询
     *
     * @return 返回删除成功的记录数
     *
     * @throws ParameterException     若必需参数不合法，抛出
     * @throws BusinessLogicException 预留【根据各模块自身的业务逻辑需求，自行抛出】
     */
    int delete(T record) throws ParameterException, BusinessLogicException;

    /**
     * <pre>
     *      业务功能：【根据条件工具类example中的条件进行查询】，进行删除
     * </pre>
     *
     * @param example 条件工具类example中的条件进行查询
     *
     * @return 返回删除成功的记录数
     *
     * @throws ParameterException     若必需参数不合法，抛出
     * @throws BusinessLogicException 预留【根据各模块自身的业务逻辑需求，自行抛出】
     */
    int deleteByExample(Object example) throws ParameterException, BusinessLogicException;

    /**
     * <pre>
     *      业务功能：批量删除，根据主键
     * </pre>
     *
     * @param primaryKeys 多主键
     *
     * @return 返回删除成功的记录数
     *
     * @throws ParameterException     若必需参数不合法，抛出
     * @throws BusinessLogicException 预留【根据各模块自身的业务逻辑需求，自行抛出】
     */
    int batchDeleteByPrimaryKeys(Object... primaryKeys) throws ParameterException, BusinessLogicException;

    /**
     * <pre>
     *      业务功能：实现业务逻辑删除功能，此处需在数据库对应的表中
     * </pre>
     *
     * @param primaryKeys 要删除业务逻辑的主键，可以是多个
     *
     * @throws ParameterException     若必需参数不合法，抛出
     * @throws BusinessLogicException 预留【根据各模块自身的业务逻辑需求，自行抛出】
     */
    int batchDeleteFlagByPrimaryKeys(Object... primaryKeys) throws ParameterException, BusinessLogicException;

    /**
     * <pre>
     *      业务功能：依据主键，进行更新全部字段，若字段值为null，也会更新为null
     * </pre>
     *
     * @param entity 更新对象【必需要含主键信息】
     *
     * @throws ParameterException     若必需参数不合法，抛出
     * @throws BusinessLogicException 预留【根据各模块自身的业务逻辑需求，自行抛出】
     */
    int updateByPrimaryKey(T entity) throws ParameterException, BusinessLogicException;

    /**
     * <pre>
     *      业务功能：更新方法，并针对上传的文件流进行，保存
     * </pre>
     *
     * @param entity         更新对象【必需要含主键信息】
     * @param multipartFiles 文件流
     *
     * @return 返回更新数
     *
     * @throws ParameterException     若必需参数不合法，抛出
     * @throws BusinessLogicException 预留【根据各模块自身的业务逻辑需求，自行抛出】
     */
    int updateByPrimaryKey(T entity, MultipartFile... multipartFiles) throws ParameterException, BusinessLogicException;

    /**
     * <pre>
     *      业务功能：依据主键，进行更新，字段不为空的数据
     * </pre>
     *
     * @param entity 更新对象【必需要含主键信息】
     *
     * @return 返回更新数
     *
     * @throws ParameterException     若必需参数不合法，抛出
     * @throws BusinessLogicException 预留【根据各模块自身的业务逻辑需求，自行抛出】
     */
    int updateByPrimaryKeySelective(T entity) throws ParameterException, BusinessLogicException;

    /**
     * <pre>
     *      业务功能：根据example条件，进行更新全部字段，若字段值为null，也会更新为null
     * </pre>
     *
     * @param entity  更新对象【必需要含主键信息】
     * @param example 更新的条件
     *
     * @return 返回更新数
     *
     * @throws ParameterException     若必需参数不合法，抛出
     * @throws BusinessLogicException 预留【根据各模块自身的业务逻辑需求，自行抛出】
     */
    int updateByExample(T entity, Object example) throws ParameterException, BusinessLogicException;

    /**
     * <pre>
     *      业务功能：根据example条件，进行更新，字段不为空的数据
     * </pre>
     *
     * @param entity  更新对象【必需要含主键信息】
     * @param example 更新的条件
     *
     * @return 返回更新数
     *
     * @throws ParameterException     若必需参数不合法，抛出
     * @throws BusinessLogicException 预留【根据各模块自身的业务逻辑需求，自行抛出】
     */
    int updateByExampleSelective(T entity, Object example) throws ParameterException, BusinessLogicException;

    /**
     * <pre>
     *      业务功能：查询所有数据
     * </pre>
     *
     * @return 返回当前数据库所有的记录
     */
    List<T> selectAll();

    /**
     * <pre>
     *      业务功能：根据主键，进行查询
     * </pre>
     *
     * @param primaryKey 主键
     *
     * @return 返回当前主键，对应的实体对象
     *
     * @throws ParameterException     若必需参数不合法，抛出
     * @throws BusinessLogicException 预留【根据各模块自身的业务逻辑需求，自行抛出】
     */
    T selectByPrimaryKey(Object primaryKey) throws ParameterException, BusinessLogicException;

    /**
     * <pre>
     *      业务功能：【根据实体record中的属性进行查询，对应的属性不为空的条件】，进行查询所符合的实体列表
     * </pre>
     *
     * @param record 当前实体需要查询的条件
     *
     * @return list 返回当前符合条件，对象集合
     *
     * @throws ParameterException     若必需参数不合法，抛出
     * @throws BusinessLogicException 预留【根据各模块自身的业务逻辑需求，自行抛出】
     */
    List<T> select(T record) throws ParameterException, BusinessLogicException;

    /**
     * <pre>
     *      业务功能：【根据实体record中的属性进行查询，对应的属性不为空的条件】，只能有一个返回值，有多个结果是抛出异常，查询条件使用等号
     * </pre>
     *
     * @param record 当前实体需要查询的条件
     *
     * @return 返回当当前符合条件，对象
     *
     * @throws ParameterException     若必需参数不合法，抛出
     * @throws BusinessLogicException 预留【根据各模块自身的业务逻辑需求，自行抛出】
     */
    T selectOne(T record) throws ParameterException, BusinessLogicException;

    /**
     * <pre>
     *     业务功能：【根据条件工具类example中的条件进行查询】，进行查询所符合的实体列表
     * </pre>
     *
     * @param example 条件工具类example中的条件进行查询
     *
     * @return 返回当当前符合条件，对象列表
     *
     * @throws ParameterException     若必需参数不合法，抛出
     * @throws BusinessLogicException 预留【根据各模块自身的业务逻辑需求，自行抛出】
     */
    List<T> selectByExample(Object example) throws ParameterException, BusinessLogicException;

    /**
     * <pre>
     *      业务功能：【根据实体record中的属性进行查询，对应的属性不为空的条件，并且指定分页】，进行查询所符合的实体列表
     * </pre>
     *
     * @param record    实体record中的属性进行查询
     * @param rowBounds 分页bean
     *
     * @return 返回当当前符合条件，对象列表
     *
     * @throws ParameterException     若必需参数不合法，抛出
     * @throws BusinessLogicException 预留【根据各模块自身的业务逻辑需求，自行抛出】
     */
    List<T> selectByRowBounds(T record, RowBounds rowBounds) throws ParameterException, BusinessLogicException;

    /**
     * <pre>
     *     业务功能：【根据条件工具类example中的条件进行查询，并且指定分页】，进行查询所符合的实体列表
     * </pre>
     *
     * @param example   条件工具类example中的条件进行查询
     * @param rowBounds 分页bean
     *
     * @return 返回当当前符合条件，对象列表
     *
     * @throws ParameterException     若必需参数不合法，抛出
     * @throws BusinessLogicException 预留【根据各模块自身的业务逻辑需求，自行抛出】
     */
    List<T> selectByExampleAndRowBounds(Object example, RowBounds rowBounds) throws ParameterException, BusinessLogicException;

    /**
     * <pre>
     *      业务功能：统计符合，查询条件总数
     * </pre>
     *
     * @param record 实体record中的属性进行查询
     *
     * @return list 返回当前符合条件，对象集合
     *
     * @throws ParameterException     若必需参数不合法，抛出
     * @throws BusinessLogicException 预留【根据各模块自身的业务逻辑需求，自行抛出】
     */
    int selectCount(T record) throws ParameterException, BusinessLogicException;

    /**
     * <pre>
     *      业务功能：【根据条件工具类example中的条件进行查询】，统计总数
     * </pre>
     *
     * @param example 条件工具类example中的条件进行查询
     *
     * @return 返回当当前符合条件，对象列表
     *
     * @throws ParameterException     若必需参数不合法，抛出
     * @throws BusinessLogicException 预留【根据各模块自身的业务逻辑需求，自行抛出】
     */
    int selectCountByExample(Object example) throws ParameterException, BusinessLogicException;

    /**
     * <pre>
     *      业务功能：带参数查询，结合了分页参数；此方法需要，各模块自己根据业务需求，重新 BaseService.getListByVo 方法；
     *              分页参数，必需参数；
     *
     * 例：
     * log.info("service parameters vo JSON: " + JSON.toJSONString(vo));
     *
     * if (vo == null || vo.getStart() == null || vo.getLength() == null) {
     *          log.info("Query param, check paging start length");
     *          throw new ParameterException("Query param, check paging start length");
     * }
     *
     * Example example = new Example(CrewBean.class);
     * Example.Criteria criteria = example.createCriteria();
     *
     * //组装分页参数
     * RowBounds rowBounds = new RowBounds(vo.getStart(), vo.getLength());
     * //组装排序参数
     * if (StringUtils.isNotBlank(vo.getOrderColumn())) {
     *      if (StringUtils.isNotBlank(vo.getOrderDir()) && "DESC".equalsIgnoreCase(vo.getOrderDir())) {
     *              example.orderBy(vo.getOrderColumn()).desc();
     *      } else {
     *              example.orderBy(vo.getOrderColumn()).asc();
     *      }
     * }
     *
     * //组装查询参数，需要自己自身实现
     * if (StringUtils.isNotBlank(vo.getCompositeQuery())) {
     *      StringBuilder sb = new StringBuilder(100);
     *                      sb.append(" crew_id LIKE '" + FleetBasicUtil.likePercent(vo.getCompositeQuery().trim()) + "' ")
     *                          .append(" OR crew_first_name LIKE '" + FleetBasicUtil.likePercent(vo.getCompositeQuery().trim()) + "' ")
     *                          .append(" OR crew_last_name LIKE '" + FleetBasicUtil.likePercent(vo.getCompositeQuery().trim()) + "' ")
     *                          .append(" OR crew_phone LIKE '" + FleetBasicUtil.likePercent(vo.getCompositeQuery().trim()) + "' ");
     *      criteria.andCondition(sb.toString());
     * }
     *
     * if (StringUtils.isNotBlank(vo.getCreateTimestampStartTime())) {
     *      criteria.andGreaterThanOrEqualTo("createTimestamp", vo.getCreateTimestampStartTime().trim());
     * }
     * if (StringUtils.isNotBlank(vo.getCreateTimestampEndTime())) {
     *      criteria.andLessThanOrEqualTo("createTimestamp", vo.getCreateTimestampEndTime().trim());
     * }
     * criteria.andEqualTo("deleteFlag", ConstantsFinalValue.DELETE_FLAG_N);
     *
     * return mapper.selectByExampleAndRowBounds(example, new RowBounds(vo.getStart(), vo.getLength()));
     * </pre>
     *
     * @param vo vo包含了查询参数，和必需的，分页参数。
     *
     * @throws ParameterException     若必需参数不合法，抛出
     * @throws BusinessLogicException 预留【根据各模块自身的业务逻辑需求，自行抛出】
     */
    List<T> getListByVo(VO vo) throws ParameterException, BusinessLogicException;

    /**
     * <pre>
     *      业务功能：带参数查询，结合了分页参数；此方法需要，各模块自己根据业务需求，重新 BaseService.getListByVo 方法；
     *              分页参数，必需参数；
     * </pre>
     *
     * @param example 在调用者，组装查询参数，需要自己自身实现
     * @param vo      vo包含了查询参数，和必需的，分页参数。
     *
     * @return 返回符合的 对象列表
     *
     * @throws ParameterException     若必需参数不合法，抛出
     * @throws BusinessLogicException 预留【根据各模块自身的业务逻辑需求，自行抛出】
     */
    List<T> getListByVo(VO vo, Example example) throws ParameterException, BusinessLogicException;


    //Map<String, T> batchSaveOrUpdateListByPropertyName(Map<String, T> mapInsertBeanList, Map<String, T> mapUpdateBeanList, String propertyName, Class<T> beanEntityClass) throws ParameterException, BusinessLogicException;
    //
    //Map<String, T> batchSaveOrUpdateListByPropertyName(Map<String, T> mapInsertBeanList, Map<String, T> mapUpdateBeanList, String propertyName, Example example) throws ParameterException, BusinessLogicException;
}
