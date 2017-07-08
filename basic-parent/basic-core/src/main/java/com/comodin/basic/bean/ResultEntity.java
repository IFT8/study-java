package com.comodin.basic.bean;

public class ResultEntity {
    private String resultCode;
    private Object resultMsg;

    public ResultEntity() {
    }

    public ResultEntity(String resultCode, Object resultMsg) {
        this.resultCode = resultCode;
        this.resultMsg = resultMsg;
    }

    public String getResultCode() {
        return resultCode;
    }

    public ResultEntity setResultCode(String resultCode) {
        this.resultCode = resultCode;
        return this;
    }

    public Object getResultMsg() {
        return resultMsg;
    }

    public ResultEntity setResultMsg(Object resultMsg) {
        this.resultMsg = resultMsg;
        return this;
    }
}
