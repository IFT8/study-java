package com.comodin.fleet.constants.bean;

@SuppressWarnings({"unused", "SpringAutowiredFieldsWarningInspection", "StatementWithEmptyBody"})
public class AtmClientTerminalRecordBeanConstant  {

    /**
     * ATM终端，读取记录的类型【{"dataList":["TRANSACTION_RECORD","DEVICE_STATUS_RECORD","CASSETTE_STATUS_RECORD"]}】
     */
    public static final String ATM_CLIENT_TERMINAL_RECORD_BEAN_READ_RECORD_TYPE_TRANSACTION_RECORD = "TRANSACTION_RECORD";
    /**
     * ATM终端，读取记录的类型【{"dataList":["TRANSACTION_RECORD","DEVICE_STATUS_RECORD","CASSETTE_STATUS_RECORD"]}】
     */
    public static final String ATM_CLIENT_TERMINAL_RECORD_BEAN_READ_RECORD_TYPE_CASSETTE_STATUS_RECORD = "CASSETTE_STATUS_RECORD";
    /**
     * ATM终端，读取记录的类型【{"dataList":["TRANSACTION_RECORD","DEVICE_STATUS_RECORD","CASSETTE_STATUS_RECORD"]}】
     */
    public static final String ATM_CLIENT_TERMINAL_RECORD_BEAN_READ_RECORD_TYPE_DEVICE_STATUS_RECORD = "DEVICE_STATUS_RECORD";

}