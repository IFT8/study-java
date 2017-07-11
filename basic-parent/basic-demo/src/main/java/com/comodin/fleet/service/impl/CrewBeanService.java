package com.comodin.fleet.service.impl;

import com.comodin.basic.exception.BusinessLogicException;
import com.comodin.basic.exception.ParameterException;
import com.comodin.fleet.service.ICrewBeanService;
import org.springframework.stereotype.Service;
import com.comodin.basic.vo.BaseVo;
import com.comodin.basic.service.AbstractBaseService;
import com.comodin.fleet.bean.CrewBean;

import java.util.List;

@Service
public class CrewBeanService extends AbstractBaseService<CrewBean, BaseVo<CrewBean>> implements ICrewBeanService {
    /**
     * <pre>
     *      业务功能：查询所有数据
     * </pre>
     *
     * @return 返回当前数据库所有的记录
     */
    @Override
    public List<CrewBean> selectAll() {
        return super.selectAll();
    }

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
    @Override
    public CrewBean insertSelective(CrewBean entity) throws ParameterException, BusinessLogicException {
        return super.insertSelective(entity);
    }
}