package com.comodin.basic.util;


import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.comodin.basic.bean.ResultEntity;
import com.comodin.basic.constant.BaseConstants;
import com.comodin.basic.exception.ParameterException;
import com.github.pagehelper.PageInfo;
import org.apache.log4j.Logger;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.servlet.support.RequestContext;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.*;

@SuppressWarnings("Duplicates")
public class BaeUtils {

    private static final Logger log = Logger.getLogger(BaeUtils.class);

    /**
     * 组装，成功返回给客户，实体对象。
     *
     * @param messageObj 返回给客户端，成功，简单消息信息
     *
     * @return 返回 ResultEntity 实体
     */
    public static ResultEntity webAssemblySuccessResultEntity(Object messageObj) {
        return new ResultEntity(BaseConstants.RESULTS_CODE_SUCCESS, messageObj);
    }

    /**
     * 拼装，查询结果集，带分页信息的。
     *
     * @param resultList 查询返回的结果集
     * @param draw       客户端请求的次数的编号
     *
     * @return 返回 ，带分页信息的结果集 Map集合
     */
    public static Map<String, Object> webBricolageReturnResultByList(List<?> resultList, Integer draw) {
        Map<String, Object> map = new HashMap<>();
        PageInfo<?> page = new PageInfo<>(resultList);// 用PageInfo对结果进行包装
        // PageInfo包含了非常全面的分页属性
        map.put("draw", draw);
        map.put("recordsTotal", page.getTotal());
        map.put("recordsFiltered", page.getTotal());
        map.put("data", resultList);
        return map;
    }

    /**
     * 拼装，查询结果集，带分页信息的。
     *
     * @param pageInfo 查询返回的结果集
     * @param draw     客户端请求的次数的编号
     *
     * @return 返回 ，带分页信息的结果集 Map集合
     */
    public static Map<String, Object> webBricolageReturnResultByPageInfo(PageInfo<?> pageInfo, Integer draw) {
        Map<String, Object> map = new HashMap<>();
        // PageInfo包含了非常全面的分页属性
        map.put("draw", draw);
        map.put("recordsTotal", pageInfo.getTotal());
        map.put("recordsFiltered", pageInfo.getTotal());
        map.put("data", pageInfo.getList());
        return map;
    }


    /**
     * <pre>
     *     业务功能：跳转URL，根据请求的方式，判断是否为Ajax请求，和普通请求。
     *              如果为：Ajax请求，即返回 结果消息体，里面包含，跳转页面，以及代码号为：1即为跳转
     *              如果为：普通方式请求，直接 浏览器 跳转至 用户登陆页面
     * </pre>
     *
     * @param content    返回客户的文本消息内容
     * @param forwardUrl 需要跳到的URL
     * @param request    //
     * @param response   //
     *
     * @throws IOException
     * @throws ServletException
     */
    public static void webRequestDispatcherLoginPageByAjaxOrForward(String content, String forwardUrl, HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        if (request.getHeader("x-requested-with") != null && request.getHeader("x-requested-with").equalsIgnoreCase("XMLHttpRequest")) {
            // 如果是ajax请求响应头会有，x-requested-with
            Map<String, Object> map = new HashMap<>();
            map.put(BaseConstants.RESULTS_CODE_TOKEN_FAILURE_REDIRECT_URL_MARK, forwardUrl);
            map.put(BaseConstants.RESULTS_CODE_TOKEN_FAILURE_REDIRECT_CONTENT_MARK, content);
            webSendResponseMessageByJSON(BaseConstants.RESULTS_CODE_TOKEN_FAILURE, map, response);
        } else {
            request.getRequestDispatcher(forwardUrl).forward(request, response);
        }
    }

    public static void fleetPortalWebRequestDispatcherLoginPageByAjaxOrForward(String content, HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        String forwardUrl = "/crewLogin" + BaseConstants.INTERCEPTOR_URL_SUFFIX;
        webRequestDispatcherLoginPageByAjaxOrForward(content, forwardUrl, request, response);
    }

    public static void fleetClientPortalWebRequestDispatcherLoginPageByAjaxOrForward(String content, HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        String forwardUrl = "/clientLogin" + BaseConstants.INTERCEPTOR_URL_SUFFIX;
        webRequestDispatcherLoginPageByAjaxOrForward(content, forwardUrl, request, response);
    }


    /**
     * Send response json message.
     *
     * @param resultCode 为返回结果的代码，都在 BaseConstants 类已经定义好了
     * @param messageObj 为返回结果的内容 ResultEntity 格式
     * @param response   使用response流
     *
     * @throws IOException 抛出
     */
    public static void webSendResponseMessageByJSON(String resultCode, Object messageObj, HttpServletResponse response) throws IOException {
        ResultEntity resultEntity = new ResultEntity(resultCode, JSONObject.toJSONString(messageObj));
        String jsonString = JSON.toJSONString(resultEntity);
        response.setCharacterEncoding("UTF-8");
        response.setContentType("application/json; charset=utf-8");
        response.getWriter().write(jsonString);
        response.flushBuffer();
    }

    /**
     * by supeng
     * <pre>
     * 功能：使用了  hibernate validator校验框架，检查若有检验失败的字段，抛出参数异常，并对bean中对应的字段，进行JSON提取处理后，交于前端JS通用处理，进行解析
     *
     * 业务场景：
     *      1、在spring mvc controller层
     * </pre>
     *
     * @param bindingResult the binding result
     *
     * @return string
     */
    public static String webRequestParametersValidation(BindingResult bindingResult) {
        String resultMessage = "";
        if (bindingResult.hasErrors()) {
            Map<String, String> map = new HashMap<>();
            for (FieldError fieldError : bindingResult.getFieldErrors()) {
                map.put(fieldError.getField(), fieldError.getDefaultMessage());
            }
            resultMessage = JSON.toJSONString(map);
            // log.error("web request parameters valid data format error JSON: " + resultMessage);
            throw new ParameterException(resultMessage);
        }

        return resultMessage;
    }

    public static String webGetRequestLanguage(HttpServletRequest request) {
        RequestContext requestContext = new RequestContext(request);
        Locale locale = requestContext.getLocale();
        String language = locale.getLanguage() + "_" + locale.getCountry();
        //System.out.println(locale.toString());
        //System.out.println(locale.getLanguage() + "_" + locale.getCountry());

        List<String> allowLanguageList = new ArrayList<>();
        allowLanguageList.add(BaseConstants.LANGUAGE_ES_MX);
        //allowLanguageList.add(BaseConstants.LANGUAGE_EN_US);
        if (!allowLanguageList.contains(language)) {
            language = BaseConstants.LANGUAGE_ES_MX;
        }
        return language;
    }
}
