package com.comodin.basic.bean;

public class ResultEntity {
    private Integer resultCode;
    private Object resultMsg;

    public Integer getResultCode() {
        return resultCode;
    }

    public ResultEntity setResultCode(Integer resultCode) {
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
