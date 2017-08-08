package com.comodin.basic.bean;

@SuppressWarnings("unused")
public class ResultEntity {
    private String resultCode;
    private String resultMsg;
    private Object resultData;

    public ResultEntity() {
    }

    public ResultEntity(String resultCode, Object resultData) {
        this.resultCode = resultCode;
        this.resultData = resultData;
    }

    public ResultEntity(String resultCode, String resultMsg, Object resultData) {
        this.resultCode = resultCode;
        this.resultMsg = resultMsg;
        this.resultData = resultData;
    }

    public String getResultCode() {
        return (resultCode == null) ? null : resultCode.trim();
    }

    public ResultEntity setResultCode(String resultCode) {
        this.resultCode = (resultCode == null) ? null : resultCode.trim();
        return this;
    }

    public String getResultMsg() {
        return (resultMsg == null) ? null : resultMsg.trim();
    }

    public ResultEntity setResultMsg(String resultMsg) {
        this.resultMsg = (resultMsg == null) ? null : resultMsg.trim();
        return this;
    }

    public Object getResultData() {
        return resultData;
    }

    public ResultEntity setResultData(Object resultData) {
        this.resultData = resultData;
        return this;
    }
}
