package com.comodin.basic.controller;

import com.alibaba.fastjson.JSON;
import com.comodin.basic.bean.ResultEntity;
import com.comodin.basic.constant.BaseConstants;
import com.comodin.basic.exception.BusinessLogicException;
import com.comodin.basic.exception.ParameterException;
import com.comodin.basic.service.IBaseService;
import com.comodin.basic.util.BaseUtils;
import com.comodin.basic.validation.IBaseValidGroup;
import com.comodin.basic.vo.BaseVo;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.support.RequestContext;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.Serializable;
import java.util.List;
import java.util.Map;

/**
 * <pre>
 *      业务功能：此抽象类是作用为：SpringMVC-->Controller，基类；用于规范CRUD方式
 *      注意事项：
 *              1、RequestMapping对应的url为固定模式，整个网站使用二级目录方式，作为请求方式
 *              2、各模块继承 AbstractBaseController 类时，需要实现 getModuleName()方法，因各子模块的路径不同；
 *              3、service为泛型通用，子模块自身的Service
 * </pre>
 *
 * @param <T>  对应各子模块的Bean对象，
 * @param <VO> 立VO对象，用于在Service进行数据传输使用的；若暂时未有Vo，就以BaseVo配置
 */
@SuppressWarnings("unused")
public abstract class AbstractBaseController<T extends Serializable, VO extends BaseVo<T>> {

    protected final Log log = LogFactory.getLog(this.getClass());

    @Autowired
    protected IBaseService<T, VO> baseService;

    /**
     * 主要高子类实现，针对list GET方式，需要配置子模块 /子模块/list
     * 需要子类将 stringRequestMappingList 重新配置
     */
    @SuppressWarnings("WeakerAccess")
    protected abstract String getModuleName();

    /**
     * <pre>
     *      接口编号：module-001
     *      请求地址：/module/add.php
     *      请求类型：GET
     *      业务功能：获取，增加功能，JSP页面
     * </pre>
     *
     * @return /module/add.jsp
     */
    @RequestMapping(value = "/add" + BaseConstants.INTERCEPTOR_URL_SUFFIX, method = RequestMethod.GET)
    public String add_GET(HttpServletRequest request, HttpServletResponse response) {
        request.setAttribute("bean", null);
        return this.getModuleName() + "/add";
    }

    /**
     * <pre>
     *      接口编号：module-002
     *      请求地址：/module/add.php
     *      请求类型：POST
     *      业务功能：增加数据表单，提交【不带，文件上传功能】
     * </pre>
     *
     * @param bean 页面form表单中的元素，对应bean中是属性名
     *             |----------------------------------------------------------------------------------------------
     *             |  字段名               字段类型            |                      说明                          |
     *             |----------------------------------------------------------------------------------------------
     *             |
     *             |----------------------------------------------------------------------------------------------
     *
     * @return JSON
     */
    @ResponseBody
    @RequestMapping(value = "/add" + BaseConstants.INTERCEPTOR_URL_SUFFIX, method = RequestMethod.POST)
    public ResultEntity add_POST(HttpServletRequest request, HttpServletResponse response, @Validated(value = IBaseValidGroup.Add.class) T bean, BindingResult bindingResult) {
        //先检查，使用Hibernate检验框架，是否包含对应Bean的校验失败的字段，并且根据国际化处理消息内容
        BaseUtils.webRequestParametersValidation(bindingResult);

        baseService.insert(bean);

        //实现国际信息
        String message = new RequestContext(request, response).getMessage(BaseConstants.GLOBAL_I18N_CRUD_ADD_SUCCESS);
        return BaseUtils.webAssemblySuccessResultEntity(message);
    }

    /**
     * <pre>
     *      接口编号：module-003
     *      请求地址：/module/addAndMultipart.php
     *      请求类型：POST
     *      业务功能：增加数据表单，提交【带，文件上传功能】
     * </pre>
     *
     * @param bean  页面form表单中的元素，对应bean中是属性名
     *              |----------------------------------------------------------------------------------------------
     *              |  字段名               字段类型            |                      说明                          |
     *              |----------------------------------------------------------------------------------------------
     *              |
     *              |----------------------------------------------------------------------------------------------
     * @param files |  files               文件流              对应的页面form表单中，文件流【files】，可以上传多个
     *              |----------------------------------------------------------------------------------------------
     *
     * @return JSON
     */
    @ResponseBody
    @RequestMapping(value = "/addAndMultipart" + BaseConstants.INTERCEPTOR_URL_SUFFIX, method = RequestMethod.POST)
    public ResultEntity addAndMultipart_POST(HttpServletRequest request, HttpServletResponse response, @Validated(value = IBaseValidGroup.Add.class) T bean, BindingResult bindingResult, @RequestParam(value = "files", required = false) MultipartFile... files) {
        //先检查，使用Hibernate检验框架，是否包含对应Bean的校验失败的字段，并且根据国际化处理消息内容
        BaseUtils.webRequestParametersValidation(bindingResult);

        if (files == null || files.length < 1) {
            throw new ParameterException(BaseConstants.GLOBAL_I18N_CRUD_UPLOAD_ERROR_NOT_BLANK);
        }

        baseService.insert(bean, files);

        //实现国际信息
        String message = new RequestContext(request, response).getMessage(BaseConstants.GLOBAL_I18N_CRUD_ADD_SUCCESS);
        return BaseUtils.webAssemblySuccessResultEntity(message);
    }

    /**
     * 接口：
     * <pre>
     *      接口编号：module-004
     *      请求地址：/module/delete.php?primaryKeys=id1,id2,...,id5
     *      请求类型：POST
     *      业务功能：根据主键，逻辑删除
     * </pre>
     *
     * @param primaryKeys ID主键，可能批量删除，数组形式【id1,id2,id5,.....】
     *
     * @return JSON
     */
    @ResponseBody
    @RequestMapping(value = "/delete" + BaseConstants.INTERCEPTOR_URL_SUFFIX, method = RequestMethod.POST)
    public ResultEntity delete_POST(HttpServletRequest request, HttpServletResponse response, @RequestParam(value = "primaryKeys", required = false) Object... primaryKeys) {

        baseService.batchDeleteFlagByPrimaryKeys((Object[]) primaryKeys);

        //实现国际信息
        String message = new RequestContext(request, response).getMessage(BaseConstants.GLOBAL_I18N_CRUD_DELETE_SUCCESS);
        return BaseUtils.webAssemblySuccessResultEntity(message);
    }

    /**
     * 接口：
     * <pre>
     *      接口编号：module-005
     *      请求地址：/module/update.php?primaryKey=id1
     *      请求类型：GET
     *      业务功能：获取，更新功能，JSP页面
     *              在request.attributes中包含了 bean 对象         通过EL表达式，例：${bean.id}
     *              在request.attributes中包含了 bean JSON字符串   通过EL表达式，例：${beanJSONString}
     * </pre>
     *
     * @param primaryKey 更新ID
     *
     * @return /module/update.jsp
     */
    @RequestMapping(value = "/update" + BaseConstants.INTERCEPTOR_URL_SUFFIX, method = RequestMethod.GET)
    public String update_GET(HttpServletRequest request, HttpServletResponse response, @RequestParam(value = "primaryKey", required = false) Object primaryKey) {

        T bean = baseService.selectByPrimaryKey(primaryKey);
        if (bean == null) {
            throw new BusinessLogicException(BaseConstants.GLOBAL_I18N_CRUD_GET_ERROR);
        }
        request.setAttribute("bean", bean);
        request.setAttribute("beanJSONString", JSON.toJSONString(bean));
        return this.getModuleName() + "/update";
    }


    /**
     * <pre>
     *      接口编号：module-006
     *      请求地址：/module/update.php
     *      请求类型：POST
     *      业务功能：根据主键，更新数据，表单提交【不带，文件上传功能】
     * </pre>
     *
     * @param primaryKey 要更新的，ID主键
     * @param bean       页面form表单中的元素，对应bean中是属性名
     *                   |----------------------------------------------------------------------------------------------
     *                   |  字段名               字段类型            |                      说明                          |
     *                   |----------------------------------------------------------------------------------------------
     *                   |
     *                   |----------------------------------------------------------------------------------------------
     *
     * @return JSON
     */
    @ResponseBody
    @RequestMapping(value = "/update" + BaseConstants.INTERCEPTOR_URL_SUFFIX, method = RequestMethod.POST)
    public ResultEntity update_POST(HttpServletRequest request, HttpServletResponse response, @RequestParam(value = "primaryKey", required = false) Object primaryKey, @Validated(value = IBaseValidGroup.Update.class) T bean, BindingResult bindingResult) {
        //先检查，使用Hibernate检验框架，是否包含对应Bean的校验失败的字段，并且根据国际化处理消息内容
        BaseUtils.webRequestParametersValidation(bindingResult);

        baseService.updateByPrimaryKeySelective(bean);

        //实现国际信息
        String message = new RequestContext(request, response).getMessage(BaseConstants.GLOBAL_I18N_CRUD_UPDATE_SUCCESS);
        return BaseUtils.webAssemblySuccessResultEntity(message);
    }

    /**
     * <pre>
     *      接口编号：module-007
     *      请求地址：/module/updateAndMultipart.php
     *      请求类型：POST
     *      业务功能：根据主键，更新数据，表单提交【带，文件上传功能】
     * </pre>
     *
     * @param primaryKey 要更新的，ID主键
     * @param bean       页面form表单中的元素，对应bean中是属性名
     *                   |----------------------------------------------------------------------------------------------
     *                   |  字段名               字段类型            |                      说明                          |
     *                   |----------------------------------------------------------------------------------------------
     *                   |
     *                   |----------------------------------------------------------------------------------------------
     * @param files      |  files               文件流              对应的页面form表单中，文件流【files】，可以上传多个
     *                   |----------------------------------------------------------------------------------------------
     *
     * @return JSON
     */
    @ResponseBody
    @RequestMapping(value = "/updateAndMultipart" + BaseConstants.INTERCEPTOR_URL_SUFFIX, method = RequestMethod.POST)
    public ResultEntity updateAndMultipart_POST(HttpServletRequest request, HttpServletResponse response, @RequestParam(value = "primaryKey", required = false) Object primaryKey, @Validated(value = IBaseValidGroup.Update.class) T bean, BindingResult bindingResult, @RequestParam(value = "files", required = false) MultipartFile... files) {
        //先检查，使用 Hibernate 检验框架，是否包含对应Bean的校验失败的字段，并且根据国际化处理消息内容
        BaseUtils.webRequestParametersValidation(bindingResult);

        if (files == null || files.length < 1) {
            throw new ParameterException(BaseConstants.GLOBAL_I18N_CRUD_UPLOAD_ERROR_NOT_BLANK);
        }

        baseService.updateByPrimaryKey(bean, files);

        //实现国际信息
        String message = new RequestContext(request, response).getMessage(BaseConstants.GLOBAL_I18N_CRUD_UPDATE_SUCCESS);
        return BaseUtils.webAssemblySuccessResultEntity(message);
    }


    /**
     * <pre>
     *      接口编号：module-008
     *      请求地址：/module/detail.php?primaryKey=d1
     *      请求类型：GET
     *      业务功能：获取，详细页面，JSP页面
     *              在request.attributes中包含了 bean 对象         通过EL表达式，例：${bean.id}
     *              在request.attributes中包含了 bean JSON字符串   通过EL表达式，例：${beanJSONString}
     * </pre>
     *
     * @param primaryKey 获取某一条记录，通过ID
     *
     * @return /module/detail.jsp
     */
    @RequestMapping(value = "/detail" + BaseConstants.INTERCEPTOR_URL_SUFFIX, method = RequestMethod.GET)
    public String detail_GET(HttpServletRequest request, HttpServletResponse response, @RequestParam(value = "primaryKey", required = false) Object primaryKey) {

        T bean = baseService.selectByPrimaryKey(primaryKey);
        if (bean == null) {
            throw new BusinessLogicException(BaseConstants.GLOBAL_I18N_CRUD_GET_ERROR);
        }

        request.setAttribute("bean", bean);
        request.setAttribute("beanJSONString", JSON.toJSONString(bean));
        return this.getModuleName() + "/detail";
    }

    /**
     * <pre>
     *      接口编号：module-009
     *      请求地址：/module/detailJSON.php?primaryKey=d1
     *      请求类型：GET
     *      业务功能：通过主键ID，获取该对象JSON格式数据
     * </pre>
     *
     * @param primaryKey ID主键
     *
     * @return JSON
     */
    @ResponseBody
    @RequestMapping(value = "/detailJSON" + BaseConstants.INTERCEPTOR_URL_SUFFIX, method = RequestMethod.GET)
    public ResultEntity detailJSON_GET(HttpServletRequest request, HttpServletResponse response, @RequestParam(value = "primaryKey", required = false) Object primaryKey) {

        T bean = baseService.selectByPrimaryKey(primaryKey);
        if (bean == null) {
            throw new BusinessLogicException(BaseConstants.GLOBAL_I18N_CRUD_GET_ERROR);
        }

        return BaseUtils.webAssemblySuccessResultEntity(bean);
    }


    /**
     * <pre>
     *      接口编号：module-010
     *      请求地址：/module/upload.php
     *      请求类型：GET
     *      业务功能：获取，上传功能，JSP页面
     * </pre>
     *
     * @return /module/upload.jsp
     */
    @RequestMapping(value = "/upload" + BaseConstants.INTERCEPTOR_URL_SUFFIX, method = RequestMethod.GET)
    public String upload_GET(HttpServletRequest request, HttpServletResponse response) {
        return this.getModuleName() + "/upload";
    }


    /**
     * <pre>
     *      接口编号：module-011
     *      请求地址：/module/upload.php
     *      请求类型：POST
     *      业务功能：上传文件
     * </pre>
     *
     * @param files |----------------------------------------------------------------------------------------------
     *              |  字段名               字段类型            |                      说明                          |
     *              |----------------------------------------------------------------------------------------------
     *              |  files               文件流              对应的页面form表单中，文件流【files】，可以上传多个
     *              |----------------------------------------------------------------------------------------------
     *
     * @return JSON
     */
    @ResponseBody
    @RequestMapping(value = "/upload" + BaseConstants.INTERCEPTOR_URL_SUFFIX, method = RequestMethod.POST)
    public ResultEntity upload_POST(HttpServletRequest request, HttpServletResponse response, @RequestParam(value = "files", required = false) MultipartFile... files) {

        if (files == null || files.length < 1) {
            throw new ParameterException(BaseConstants.GLOBAL_I18N_CRUD_UPLOAD_ERROR_NOT_BLANK);
        }

        //实现国际信息
        String message = new RequestContext(request, response).getMessage(BaseConstants.GLOBAL_I18N_CRUD_ADD_SUCCESS);
        return BaseUtils.webAssemblySuccessResultEntity(message);
    }

    /**
     * <pre>
     *      接口编号：module-012
     *      请求地址：/module/list.php
     *      请求类型：GET
     *      业务功能：获取，List列表，JSP页面
     * </pre>
     *
     * @return /module/list.jsp
     */
    @RequestMapping(value = "/list" + BaseConstants.INTERCEPTOR_URL_SUFFIX, method = RequestMethod.GET)
    public String list_GET(HttpServletRequest request, HttpServletResponse response) {
        return this.getModuleName() + "/list";
    }


    /**
     * <pre>
     *      接口编号：module-012
     *      请求地址：/module/list.php
     *      请求类型：POST
     *      业务功能：获取，列表数据；支持分页
     *
     * @param vo vo包含了查询参数，和必需的，分页参数【start、length】
     *           |-------------------------------------------------------------------------------------------------
     *           |  字段名               字段类型            |                      说明                             |
     *           |-------------------------------------------------------------------------------------------------
     *           |start                 Integer             通用，从第多少条开始;
     *           |length                Integer             通用，取多少条;
     *           |
     *           |orderColumn           String              通用，排序的字段;
     *           |orderDir              String              通用，排序的方式，只能为：ASC DESC;
     *           |
     *           |compositeQuery        String              通用，复合条件查询;
     *           |
     *           |searchDate            String              通用，搜索日期，单日期【格式：yyyy-MM-dd】
     *           |searchDateTimeStart   String              通用，搜索日期，双日期的，开始时间【格式：yyyy-MM-dd HH:mm:ss】
     *           |searchDateTimeEnd     String              通用，搜索日期，双日期的，结束时间【格式：yyyy-MM-dd HH:mm:ss】
     *           |--------------------------------------------------------------------------------------------------
     *
     * @return JSON
     * |------------------------------------------------------------------------------------------------------------
     * |     {
     * |         "resultCode": 0,
     * |         "resultMsg":
     * |         {
     * |                 "recordsFiltered": 25,
     * |                 "draw": 1,
     * |                 "recordsTotal": 25,
     * |                 "data":
     * |                 [
     * |                             {"routeId": "r001","vehicleInternalId": "v001","driverId": 10001},
     * |                             {"routeId": "r002","vehicleInternalId": "v002","driverId": 10002}
     * |                 ]
     * |         }
     * |     }
     * |------------------------------------------------------------------------------------------------------------
     */
    @ResponseBody
    @RequestMapping(value = "/list" + BaseConstants.INTERCEPTOR_URL_SUFFIX, method = RequestMethod.POST)
    public ResultEntity list_POST(HttpServletRequest request, HttpServletResponse response, VO vo) {
        List<T> list = baseService.getListByVo(vo);

        Map<String, Object> stringObjectMap = BaseUtils.webAssemblyReturnResultByList(list, vo.getDraw());

        return BaseUtils.webAssemblySuccessResultEntity(stringObjectMap);
    }
}
