package com.comodin.basic.constant;

@SuppressWarnings("unused")
public class BaseConstants {

    //==================================================================================================
    //                              项目统一，Ajax和API模块，对外抛出的返回码说明                            #
    //==================================================================================================
    public static final String RESULTS_CODE_ERROR_SYSTEM = "-1";//系统错误
    public static final String RESULTS_CODE_SUCCESS = "0";//OK，成功处理
    public static final String RESULTS_CODE_TOKEN_FAILURE = "1";//用户token 失效
    public static final String RESULTS_CODE_TOKEN_FAILURE_REDIRECT_URL_MARK = "REDIRECT_URL";         //服务器，返回码，token失效；重写向的URL
    public static final String RESULTS_CODE_TOKEN_FAILURE_REDIRECT_CONTENT_MARK = "REDIRECT_CONTENT"; //服务器，返回码，token失效；重写向提示信息
    public static final String RESULTS_CODE_ERROR_PARAMETER = "2";//请求：参数错误
    public static final String RESULTS_CODE_ERROR_BUSINESS = "3";//请求：业务逻辑异常

    public static final String INTERCEPTOR_URL_SUFFIX = "";
    public static final String GLOBAL_I18N_CRUD_ADD_SUCCESS = "global.Controller.Add.Success";
    public static final String GLOBAL_I18N_CRUD_DELETE_SUCCESS = "global.Controller.Delete.Success";
    public static final String GLOBAL_I18N_CRUD_UPDATE_SUCCESS = "global.Controller.Update.Success";
    public static final String GLOBAL_I18N_CRUD_GET_ERROR = "global.Controller.Get.Error";
    public static final String GLOBAL_I18N_CRUD_UPLOAD_ERROR_NOT_BLANK = "global.Controller.Upload.NotBlank";

    public static final String LANGUAGE_EN_US = "en_US";
    public static final String LANGUAGE_ES_MX = "es_MX";
    public static final String LANGUAGE_ZH_CN = "zh_CN";
}
