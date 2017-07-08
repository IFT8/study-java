package com.comodin.basic.exception;

/**
 * 此功能，主要针对上传数据明，错误日志对外显示
 */
public class UploadDataErrorException extends RuntimeException {
    /**
     * 主要用于，对外显示的错误代码，以便快带查找
     */
    private String externalErrorCode;
    /**
     * 主要用于，对外显示的简单说明
     */
    private String externalErrorMessage;
    /**
     * 系统具体错误
     */
    private String systemMessage;

    public UploadDataErrorException(String externalErrorMessage) {
        super(externalErrorMessage);
        this.externalErrorCode = "3";
        this.externalErrorMessage = externalErrorMessage;
    }

    public UploadDataErrorException(String externalErrorCode, String externalErrorMessage) {
        super(externalErrorMessage);
        this.externalErrorCode = externalErrorCode;
        this.externalErrorMessage = externalErrorMessage;
    }

    public UploadDataErrorException(String externalErrorCode, String externalErrorMessage, String systemMessage) {
        super(externalErrorMessage);
        this.externalErrorCode = externalErrorCode;
        this.externalErrorMessage = externalErrorMessage;
        this.systemMessage = systemMessage;
    }

    public UploadDataErrorException(String externalErrorCode, String externalErrorMessage, Throwable cause) {
        super(externalErrorMessage, cause);
        this.externalErrorCode = externalErrorCode;
        this.externalErrorMessage = externalErrorMessage;
    }

    public UploadDataErrorException(String externalErrorCode, String externalErrorMessage, String systemMessage, Throwable cause) {
        super(externalErrorMessage, cause);
        this.externalErrorCode = externalErrorCode;
        this.externalErrorMessage = externalErrorMessage;
        this.systemMessage = systemMessage;
    }

    protected UploadDataErrorException(String externalErrorCode, String externalErrorMessage, String systemMessage, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(externalErrorMessage, cause, enableSuppression, writableStackTrace);
        this.externalErrorCode = externalErrorCode;
        this.externalErrorMessage = externalErrorMessage;
        this.systemMessage = systemMessage;
    }

    public String getExternalErrorCode() {
        return (externalErrorCode == null) ? null : externalErrorCode.trim();
    }

    public UploadDataErrorException setExternalErrorCode(String externalErrorCode) {
        this.externalErrorCode = (externalErrorCode == null) ? null : externalErrorCode.trim();
        return this;
    }

    public String getExternalErrorMessage() {
        return (externalErrorMessage == null) ? null : externalErrorMessage.trim();
    }

    public UploadDataErrorException setExternalErrorMessage(String externalErrorMessage) {
        this.externalErrorMessage = (externalErrorMessage == null) ? null : externalErrorMessage.trim();
        return this;
    }

    public String getSystemMessage() {
        return (systemMessage == null) ? null : systemMessage.trim();
    }

    public UploadDataErrorException setSystemMessage(String systemMessage) {
        this.systemMessage = (systemMessage == null) ? null : systemMessage.trim();
        return this;
    }
}
