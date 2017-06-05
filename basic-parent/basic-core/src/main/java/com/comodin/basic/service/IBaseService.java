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
 * 通用接口
 *
 * @param <T> the type parameter
 */
public interface IBaseService<T extends Serializable, VO extends BaseVo> {

    /**
     * 保存一个实体，null的属性也会保存，不会使用数据库默认值
     *
     * @param entity 要保存的实体对象
     *
     * @return T                      返回当前传递的实体对象，其中包含了当前保存对象，在数据库中对应的ID
     *
     * @throws ParameterException     若必需参数不合法，抛出
     * @throws BusinessLogicException 预留【根据各模块自身的业务逻辑需求，自行抛出】
     */
    T save(T entity) throws ParameterException, BusinessLogicException;

    /**
     * <pre>
     *      业务功能：保存一个实体，并针对上传的文件流进行，保存
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
    T save(T entity, MultipartFile... multipartFiles) throws ParameterException, BusinessLogicException;

    /**
     * 保存一个实体，null的属性不会保存，会使用数据库默认值
     *
     * @param entity 要保存的实体对象
     *
     * @return T                      返回当前传递的实体对象，其中包含了当前保存对象，在数据库中对应的ID
     *
     * @throws ParameterException     若必需参数不合法，抛出
     * @throws BusinessLogicException 预留【根据各模块自身的业务逻辑需求，自行抛出】
     */
    T saveSelective(T entity) throws ParameterException, BusinessLogicException;


    /**
     * 批量保存，只会返回插入到数据中的条数；entityList中对应的实体对象并不会对应的ID
     * SQL格式：INSERT INTO table (字段名, 字段名, ......) VALUES (值, 值, ......), (值, 值, ......), (值, 值, ......), ....;
     *
     * @param entityList 要保存的实体对象列表集合
     *
     * @return 总结插入数据库中的记录数
     *
     * @throws ParameterException     若必需参数不合法，抛出
     * @throws BusinessLogicException 预留【根据各模块自身的业务逻辑需求，自行抛出】
     */
    int saveList(List<T> entityList) throws ParameterException, BusinessLogicException;

    int saveList(List<T> entityList, Integer batchNumber) throws ParameterException, BusinessLogicException;

    /**
     * 根据ID，删除当前对象
     *
     * @param primaryKey 要删除的ID
     *
     * @throws ParameterException     若必需参数不合法，抛出
     * @throws BusinessLogicException 预留【根据各模块自身的业务逻辑需求，自行抛出】
     */
    void deleteByPrimaryKey(Object primaryKey) throws ParameterException, BusinessLogicException;

    /**
     * 批量删除，根据主键，需要自己在 *Mapper.xml 文件中自己实现. 因各模块的ID字段名可能不一样，所以需要实现
     *
     * @param primaryKeys 要删除业务逻辑的ids
     *
     * @throws ParameterException     若必需参数不合法，抛出
     * @throws BusinessLogicException 预留【根据各模块自身的业务逻辑需求，自行抛出】
     */
    void deleteByPrimaryKeys(Class<T> tClass, Object... primaryKeys) throws ParameterException, BusinessLogicException;

    /**
     * 批量业务逻辑上删除，根据 主键，需要自己在 *Mapper.xml 文件中自己实现.
     *
     * @param primaryKeys 要删除业务逻辑的ids
     *
     * @throws ParameterException     若必需参数不合法，抛出
     * @throws BusinessLogicException 预留【根据各模块自身的业务逻辑需求，自行抛出】
     */
    void deleteFlagByPrimaryKeys(Class<T> tClass, Object... primaryKeys) throws ParameterException, BusinessLogicException;


    /**
     * 更新方法，依据主键，进行更新全部字段，若字段值为null，也会更新为null
     *
     * @param entity 更新对象【必需要含主键信息】
     *
     * @throws ParameterException     若必需参数不合法，抛出
     * @throws BusinessLogicException 预留【根据各模块自身的业务逻辑需求，自行抛出】
     */
    int updateAll(T entity) throws ParameterException, BusinessLogicException;

    /**
     * 更新方法，依据主键，进行更新，字段不为空的数据
     *
     * @param entity 更新对象【必需要含主键信息】
     *
     * @throws ParameterException     若必需参数不合法，抛出
     * @throws BusinessLogicException 预留【根据各模块自身的业务逻辑需求，自行抛出】
     */
    int updateNotNull(T entity) throws ParameterException, BusinessLogicException;

    /**
     * <pre>
     *      业务功能：更新方法，并针对上传的文件流进行，保存
     *      注意事项：此接口方法，默认实现为空，需要各模块，自己重写业务逻辑。
     * </pre>
     *
     * @param primaryKey     要更新的对应的，主键
     * @param entity         要保存的实体对象
     * @param multipartFiles 文件流
     *
     * @return T                      返回当前传递的实体对象，其中包含了当前保存对象，在数据库中对应的ID
     *
     * @throws ParameterException     若必需参数不合法，抛出
     * @throws BusinessLogicException 预留【根据各模块自身的业务逻辑需求，自行抛出】
     */
    int updateNotNull(Object primaryKey, T entity, MultipartFile... multipartFiles) throws ParameterException, BusinessLogicException;

    int updateByExample(T entity, Object example) throws ParameterException, BusinessLogicException;

    int updateByExampleSelective(T entity, Object example) throws ParameterException, BusinessLogicException;

    int updateByPrimaryKeySelective(T entity) throws ParameterException, BusinessLogicException;

    /**
     * 查询方法，根据主键，进行查询
     *
     * @param primaryKey 主键
     *
     * @return 返回当前ID的实体对象；
     *
     * @throws ParameterException     若必需参数不合法，抛出
     * @throws BusinessLogicException 预留【根据各模块自身的业务逻辑需求，自行抛出】
     */
    T selectByPrimaryKey(Object primaryKey) throws ParameterException, BusinessLogicException;

    /**
     * 查询所有数据
     *
     * @return 返回当前数据库所有的记录
     */
    List<T> selectAll();

    /**
     * 查询所有数据，根据 Bean的条件进行查询
     *
     * @param record 当前实体需要查询的条件
     *
     * @return list 返回当前符合条件，对象集合
     *
     * @throws ParameterException     若必需参数不合法，抛出
     * @throws BusinessLogicException 预留【根据各模块自身的业务逻辑需求，自行抛出】
     */
    List<T> select(T record) throws ParameterException, BusinessLogicException;


    List<T> selectByExample(Object example) throws ParameterException, BusinessLogicException;

    List<T> selectByExampleAndRowBounds(Object example, RowBounds rowBounds) throws ParameterException, BusinessLogicException;

    List<T> selectByRowBounds(T record, RowBounds rowBounds) throws ParameterException, BusinessLogicException;

    /**
     * 根据实体中的属性进行查询，只能有一个返回值，有多个结果是抛出异常，查询条件使用等号
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
     * 统计符合，查询条件总数
     *
     * @param record 当前实体需要查询的条件
     *
     * @return list 返回当前符合条件，对象集合
     *
     * @throws ParameterException     若必需参数不合法，抛出
     * @throws BusinessLogicException 预留【根据各模块自身的业务逻辑需求，自行抛出】
     */
    int selectCount(T record) throws ParameterException, BusinessLogicException;

    int selectCountByExample(Object example) throws ParameterException, BusinessLogicException;

    /**
     * <pre>
     * 带参数查询，结合了分页参数；此方法需要，各模块自己根据业务需求，重新 BaseService.getListByVo 方法；
     * 分页参数，必需参数；
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
     *                      sb.append(" crew_id LIKE '" + FleetBasiUtil.likePercent(vo.getCompositeQuery().trim()) + "' ")
     *                          .append(" OR crew_first_name LIKE '" + FleetBasiUtil.likePercent(vo.getCompositeQuery().trim()) + "' ")
     *                          .append(" OR crew_last_name LIKE '" + FleetBasiUtil.likePercent(vo.getCompositeQuery().trim()) + "' ")
     *                          .append(" OR crew_phone LIKE '" + FleetBasiUtil.likePercent(vo.getCompositeQuery().trim()) + "' ");
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
     * 带参数查询，结合了分页参数；此方法需要，各模块自己根据业务需求，重新 BaseService.getListByVo 方法；
     * 分页参数，必需参数；
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
}
