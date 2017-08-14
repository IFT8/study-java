package com.comodin.basic.exception;


import com.comodin.basic.bean.ResultEntity;
import com.comodin.basic.constant.BaseConstants;
import org.apache.commons.lang3.StringUtils;
import org.apache.log4j.Logger;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.support.RequestContext;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@SuppressWarnings("unused")
public abstract class BaseExceptionHandler {
    protected static final Logger log = Logger.getLogger(BaseExceptionHandler.class);
    private static final Logger subTableLog = Logger.getLogger("com.comodin.subTable");


    @ResponseBody
    @ExceptionHandler({RuntimeException.class})
    public ResultEntity handleSystemException(Exception ex, HttpServletRequest request, HttpServletResponse response) {
        String message = getIn18NMessage(ex, request, response);
        log.error(message, ex);
        return new ResultEntity(BaseConstants.RESULTS_CODE_ERROR_SYSTEM, message);
    }

    @ResponseBody
    @ExceptionHandler({ParameterException.class})
    public ResultEntity handleParameterException(ParameterException ex, HttpServletRequest request, HttpServletResponse response) {
        String message = getIn18NMessage(ex, ex.getStrings(), request, response);
        log.error(message, ex);
        return new ResultEntity(BaseConstants.RESULTS_CODE_ERROR_PARAMETER, message);
    }

    @ResponseBody
    @ExceptionHandler({BusinessLogicException.class})
    public ResultEntity handleBusinessException(BusinessLogicException ex, HttpServletRequest request, HttpServletResponse response) {
        String message = getIn18NMessage(ex, ex.getStrings(), request, response);
        log.error(message, ex);
        return new ResultEntity(BaseConstants.RESULTS_CODE_ERROR_BUSINESS, message);
    }

    @ResponseBody
    @ExceptionHandler({UploadDataErrorException.class})
    public ResultEntity handleUploadDataErrorException(UploadDataErrorException ex, HttpServletRequest request, HttpServletResponse response) {
        log.error(String.format("UploadDataErrorException==> [externalCode]: %s  [externalMessage]: %s [systemMessage]: %s", ex.getExternalErrorCode(), ex.getExternalErrorMessage(), ex.getSystemMessage()),ex);
        return new ResultEntity(ex.getExternalErrorCode(), ex.getExternalErrorMessage());
    }

    /**
     * 用户登陆失效，需要子类，自身实现：
     * 模版：
     * String message = getIn18NMessage(ex, request, response);
     * //log.error(message, ex);
     * FleetUtil.webRequestDispatcherLoginPageByAjaxOrForward(message, "", request, response);
     */
    @ExceptionHandler({UserLoginFailException.class})
    public abstract void handleUserLoginFailException(Exception ex, HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException;


    @SuppressWarnings("WeakerAccess")
    protected String getIn18NMessage(Exception ex, HttpServletRequest request, HttpServletResponse response) {
        String messageIn18Key = ex.getMessage();
        try {
            String i18NMessage = new RequestContext(request, response).getMessage(ex.getMessage());
            if (StringUtils.isNotBlank(i18NMessage)) {
                messageIn18Key = i18NMessage;
            }
        } catch (Exception e) {
            log.error("Being Thrown international system information failed");
        }
        return messageIn18Key;
    }

    @SuppressWarnings("WeakerAccess")
    protected String getIn18NMessage(Exception ex, String[] strings, HttpServletRequest request, HttpServletResponse response) {
        String messageIn18Key = ex.getMessage();
        try {
            String i18NMessage = new RequestContext(request, response).getMessage(ex.getMessage(), strings);
            if (StringUtils.isNotBlank(i18NMessage)) {
                messageIn18Key = i18NMessage;
            }
        } catch (Exception e) {
            log.error("Being Thrown international system information failed");
        }
        return messageIn18Key;
    }
}
