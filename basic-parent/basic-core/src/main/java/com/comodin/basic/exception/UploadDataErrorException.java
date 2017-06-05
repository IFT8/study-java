package com.comodin.basic.exception;

public class UploadDataErrorException extends RuntimeException {
    private Integer resultCode;
    private String resultMsg;

    public UploadDataErrorException(Integer resultCode, String resultMsg) {
        super(resultMsg);
        this.resultCode = resultCode;
        this.resultMsg = resultMsg;
    }

    public UploadDataErrorException(Integer resultCode, String resultMsg, String message) {
        super(message);
        this.resultCode = resultCode;
        this.resultMsg = resultMsg;
    }

    public UploadDataErrorException(Integer resultCode, String resultMsg, Throwable cause) {
        super(resultMsg, cause);
        this.resultCode = resultCode;
        this.resultMsg = resultMsg;
    }

    public UploadDataErrorException(Integer resultCode, String resultMsg, String message, Throwable cause) {
        super(message, cause);
        this.resultCode = resultCode;
        this.resultMsg = resultMsg;
    }

    protected UploadDataErrorException(Integer resultCode, String resultMsg, String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
        this.resultCode = resultCode;
        this.resultMsg = resultMsg;
    }

    public Integer getResultCode() {
        return resultCode;
    }

    public void setResultCode(Integer resultCode) {
        this.resultCode = resultCode;
    }

    public String getResultMsg() {
        return resultMsg;
    }

    public void setResultMsg(String resultMsg) {
        this.resultMsg = resultMsg;
    }
}
