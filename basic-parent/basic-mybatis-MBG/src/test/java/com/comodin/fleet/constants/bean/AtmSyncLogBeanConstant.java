package com.comodin.fleet.constants.bean;

@SuppressWarnings({"unused", "SpringAutowiredFieldsWarningInspection", "StatementWithEmptyBody"})
public class AtmSyncLogBeanConstant  {

    /**
     * ATM终端，读取记录的类型【{"dataList":["SYNC_TRANSACTION","SYNC_DEVICE_STATUS","SYNC_CASSETTE_STATUS"]}】
     */
    public static final String ATM_SYNC_LOG_BEAN_TYPE_SYNC_CASSETTE_STATUS = "SYNC_CASSETTE_STATUS";
    /**
     * ATM终端，读取记录的类型【{"dataList":["SYNC_TRANSACTION","SYNC_DEVICE_STATUS","SYNC_CASSETTE_STATUS"]}】
     */
    public static final String ATM_SYNC_LOG_BEAN_TYPE_SYNC_TRANSACTION = "SYNC_TRANSACTION";
    /**
     * ATM终端，读取记录的类型【{"dataList":["SYNC_TRANSACTION","SYNC_DEVICE_STATUS","SYNC_CASSETTE_STATUS"]}】
     */
    public static final String ATM_SYNC_LOG_BEAN_TYPE_SYNC_DEVICE_STATUS = "SYNC_DEVICE_STATUS";

}