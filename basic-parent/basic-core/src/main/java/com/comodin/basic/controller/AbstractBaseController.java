package com.comodin.basic.controller;

import com.alibaba.fastjson.JSON;
import com.comodin.basic.bean.ResultEntity;
import com.comodin.basic.constant.BaseConstants;
import com.comodin.basic.exception.BusinessLogicException;
import com.comodin.basic.exception.ParameterException;
import com.comodin.basic.service.IBaseService;
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

/**
 * 功能：此抽象类是作用为：SpringMVC-->Controller，基类；用于规范CRUD方式
 * <p>
 * RequestMapping对应的url为固定模式，整个网站使用二级目录方式，作为请求方式
 * <p>
 * 注意事项：
 * 1、各模块继承BaseController类时，因各子模块的路径不同，需要子类使用无参构造器，调用BaseController带参构造器中配置；
 * 2、list，get请求所需要，返回对应的 view地址；是由注意事项1中配置好的。
 * 3、service为泛型通用，子模块自身的Service
 *
 * @param <T>  对应各子模块的Bean对象，
 * @param <VO> 立VO对象，用于在Service进行数据传输使用的；若暂时未有Vo，就以BaseVo配置
 */
public abstract class AbstractBaseController<T extends Serializable, VO extends BaseVo<T>> {

    protected final Log log = LogFactory.getLog(this.getClass());

    @Autowired
    protected IBaseService<T, VO> service;

    /**
     * //各模块继承BaseController类时，因各子模块的路径不同，需要子类使用无参构造器，调用BaseController带参构造器中配置；
     * 主要高子类实现，针对list GET方式，需要配置子模块 /子模块/list
     * 需要子类将 stringRequestMappingList 重新配置
     */
    protected abstract String getModuleName();

    /**
     * 接口：
     * <pre>
     *       URL：   /module/add.php
     *      TYPE：   GET
     * </pre>
     * <pre>
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
     * 接口：
     * <pre>
     *       URL：   /module/add.php
     *      TYPE：   POST
     * </pre>
     * <pre>
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
    public ResultEntity add_POST(HttpServletRequest request, HttpServletResponse response,
                                 @Validated(value = IBaseValidGroup.Add.class) T bean, BindingResult bindingResult) {
        //先检查，使用hiberante检验框架，是否包含对应Bean的校验失败的字段，并且根据国际化处理消息内容
        //FleetUtil.webRequestParametersValidation(bindingResult);

        service.save(bean);

        //实现国际信息
        String message = new RequestContext(request, response).getMessage(BaseConstants.GLOBAL_I18N_CRUD_ADD_SUCCESS);
        //return FleetUtil.webAssemblySuccessResultEntity(message);

        return null;
    }

    /**
     * 接口：
     * <pre>
     *       URL：   /module/addAndMultipart.php
     *      TYPE：   POST
     * </pre>
     * <pre>
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
    public ResultEntity addAndMultipart_POST(HttpServletRequest request, HttpServletResponse response,
                                             @Validated(value = IBaseValidGroup.Add.class) T bean, BindingResult bindingResult,
                                             @RequestParam(value = "files", required = false) MultipartFile... files) {
        //log.info("BaseController.addAndMultipart_POST ======>>> req_params: " + request.getParameterMap().toString());

        //先检查，使用hiberante检验框架，是否包含对应Bean的校验失败的字段，并且根据国际化处理消息内容
        //FleetUtil.webRequestParametersValidation(bindingResult);

        if (files == null || files.length < 1) {
            throw new ParameterException(BaseConstants.GLOBAL_I18N_CRUD_UPLOAD_ERROR_NOTBLANK);
        }

        service.save(bean, files);

        //实现国际信息
        String message = new RequestContext(request, response).getMessage(BaseConstants.GLOBAL_I18N_CRUD_ADD_SUCCESS);
        //return FleetUtil.webAssemblySuccessResultEntity(message);
        return null;
    }

    /**
     * 接口：
     * <pre>
     *       URL：   /module/delete.php?ids=id1,id2,...,id5
     *      TYPE：   POST
     * </pre>
     * <pre>
     *      业务功能：根据主键，逻辑删除
     * </pre>
     *
     * @param primaryKeys ID主键，可能批量删除，数组形式【id1,id2,id5,.....】
     *
     * @return JSON
     */
    @ResponseBody
    @RequestMapping(value = "/delete" + BaseConstants.INTERCEPTOR_URL_SUFFIX, method = RequestMethod.POST)
    public ResultEntity delete_POST(HttpServletRequest request, HttpServletResponse response,
                                    @RequestParam(value = "primaryKeys", required = false) Object... primaryKeys) {
        //service.batchDeleteFlagByPrimaryKeys((Object[]) ids);
        //实现国际信息
        String message = new RequestContext(request, response).getMessage(BaseConstants.GLOBAL_I18N_CRUD_DELETE_SUCCESS);
        //return FleetUtil.webAssemblySuccessResultEntity(message);
        return null;
    }

    /**
     * 接口：
     * <pre>
     *       URL：   /module/update.php?id=id1
     *      TYPE：   GET
     * </pre>
     * <pre>
     *      业务功能：获取，更新功能，JSP页面
     *      在request.attributes中包含了 bean 对象         通过EL表达式，例：${bean.id}
     *      在request.attributes中包含了 bean JSON字符串   通过EL表达式，例：${beanJSONString}
     * </pre>
     *
     * @param primaryKey 更新ID
     *
     * @return /module/update.jsp
     */
    @RequestMapping(value = "/update" + BaseConstants.INTERCEPTOR_URL_SUFFIX, method = RequestMethod.GET)
    public String update_GET(HttpServletRequest request, HttpServletResponse response,
                             @RequestParam(value = "primaryKey", required = false) Object primaryKey) {
        //log.info("BaseController.update_GET ======>>> req_params: " + request.getParameterMap().toString());

        T bean = service.selectByPrimaryKey(primaryKey);
        if (bean == null) {
            throw new BusinessLogicException(BaseConstants.GLOBAL_I18N_CRUD_GET_ERROR);
        }

        request.setAttribute("bean", bean);
        request.setAttribute("beanJSONString", JSON.toJSONString(bean));
        return this.getModuleName() + "/update";
    }


    /**
     * 接口：
     * <pre>
     *       URL：   /module/update.php
     *      TYPE：   POST
     * </pre>
     * <pre>
     *      业务功能：根据主键，更新数据，表单提交【不带，文件上传功能】
     * </pre>
     *
     * @param primaryKey //要更新的，ID主键
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
    public ResultEntity update_POST(HttpServletRequest request, HttpServletResponse response,
                                    @RequestParam(value = "primaryKey", required = false) Object primaryKey,
                                    @Validated(value = IBaseValidGroup.Update.class) T bean, BindingResult bindingResult) {
        //log.info("BaseController.update_POST ======>>> req_params: " + request.getParameterMap().toString());

        //先检查，使用hiberante检验框架，是否包含对应Bean的校验失败的字段，并且根据国际化处理消息内容
        //FleetUtil.webRequestParametersValidation(bindingResult);

        service.updateNotNull(bean);

        //实现国际信息
        String message = new RequestContext(request, response).getMessage(BaseConstants.GLOBAL_I18N_CRUD_UPDATE_SUCCESS);
        //return FleetUtil.webAssemblySuccessResultEntity(message);
        return null;
    }

    /**
     * 接口：
     * <pre>
     *       URL：   /module/updateAndMultipart.php
     *      TYPE：   POST
     * </pre>
     * <pre>
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
    public ResultEntity updateAndMultipart_POST(HttpServletRequest request, HttpServletResponse response,
                                                @RequestParam(value = "primaryKey", required = false) Object primaryKey,
                                                @Validated(value = IBaseValidGroup.Update.class) T bean, BindingResult bindingResult,
                                                @RequestParam(value = "files", required = false) MultipartFile... files) {
        //先检查，使用hiberante检验框架，是否包含对应Bean的校验失败的字段，并且根据国际化处理消息内容
        //FleetUtil.webRequestParametersValidation(bindingResult);

        if (files == null || files.length < 1) {
            throw new ParameterException(BaseConstants.GLOBAL_I18N_CRUD_UPLOAD_ERROR_NOTBLANK);
        }

        service.updateNotNull(primaryKey, bean, files);

        //实现国际信息
        String message = new RequestContext(request, response).getMessage(BaseConstants.GLOBAL_I18N_CRUD_UPDATE_SUCCESS);
        //return FleetUtil.webAssemblySuccessResultEntity(message);
        return null;
    }


    /**
     * 接口：
     * <pre>
     *       URL：   /module/detail.php?id=id1
     *      TYPE：   GET
     * </pre>
     * <pre>
     *      业务功能：获取，详细页面，JSP页面
     *      在request.attributes中包含了 bean 对象         通过EL表达式，例：${bean.id}
     *      在request.attributes中包含了 bean JSON字符串   通过EL表达式，例：${beanJSONString}
     * </pre>
     *
     * @param primaryKey 获取某一条记录，通过ID
     *
     * @return /module/detail.jsp
     */
    @RequestMapping(value = "/detail" + BaseConstants.INTERCEPTOR_URL_SUFFIX, method = RequestMethod.GET)
    public String detail_GET(HttpServletRequest request, HttpServletResponse response,
                             @RequestParam(value = "primaryKey", required = false) Object primaryKey) {

        T bean = service.selectByPrimaryKey(primaryKey);
        if (bean == null) {
            throw new BusinessLogicException(BaseConstants.GLOBAL_I18N_CRUD_GET_ERROR);
        }

        request.setAttribute("bean", bean);
        request.setAttribute("beanJSONString", JSON.toJSONString(bean));

        return this.getModuleName() + "/detail";
    }

    /**
     * 接口：
     * <pre>
     *       URL：   /module/detailJSON.php?id=id1
     *      TYPE：   GET
     * </pre>
     * <pre>
     *      业务功能：通过主键ID，获取该对象JSON格式数据
     *      在request.attributes中包含了 bean 对象         通过EL表达式，例：${bean.id}
     * </pre>
     *
     * @param primaryKey ID主键
     *
     * @return JSON
     */
    @ResponseBody
    @RequestMapping(value = "/detailJSON" + BaseConstants.INTERCEPTOR_URL_SUFFIX, method = RequestMethod.GET)
    public ResultEntity detailJSON_GET(HttpServletRequest request, HttpServletResponse response,
                                       @RequestParam(value = "primaryKey", required = false) Object primaryKey) {

        T bean = service.selectByPrimaryKey(primaryKey);
        if (bean == null) {
            throw new BusinessLogicException(BaseConstants.GLOBAL_I18N_CRUD_GET_ERROR);
        }

        return null;
        //return FleetUtil.webAssemblySuccessResultEntity(bean);
    }


    /**
     * 接口：
     * <pre>
     *       URL：   /module/upload.php
     *      TYPE：   GET
     * </pre>
     * <pre>
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
     * 接口：
     * <pre>
     *       URL：   /module/upload.php
     *      TYPE：   POST
     * </pre>
     * <pre>
     *      业务功能：根据主键，更新数据，表单提交【带，文件上传功能】
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
    public ResultEntity upload_POST(HttpServletRequest request, HttpServletResponse response,
                                    @RequestParam(value = "files", required = false) MultipartFile... files) {
        if (files == null) {
            throw new ParameterException(BaseConstants.GLOBAL_I18N_CRUD_UPLOAD_ERROR_NOTBLANK);
        }

        //实现国际信息
        String message = new RequestContext(request, response).getMessage(BaseConstants.GLOBAL_I18N_CRUD_ADD_SUCCESS);
        //return FleetUtil.webAssemblySuccessResultEntity(message);
        return null;
    }

    /**
     * 接口：
     * <pre>
     *       URL：   /module/list.php
     *      TYPE：   GET
     * </pre>
     * <pre>
     *     业务功能：获取，List列表，JSP页面
     * </pre>
     *
     * @return /module/list.jsp
     */
    @RequestMapping(value = "/list" + BaseConstants.INTERCEPTOR_URL_SUFFIX, method = RequestMethod.GET)
    public String list_GET(HttpServletRequest request, HttpServletResponse response) {
        return this.getModuleName() + "/list";
    }


    /**
     * 接口：
     * <pre>
     *       URL：   /module/list.php
     *      TYPE：   POST
     * </pre>
     * <pre>
     *      业务功能：获取，列表数据；支持分页
     *  </pre>
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
        List<T> list = service.getListByVo(vo);
        return null;
    }
}
