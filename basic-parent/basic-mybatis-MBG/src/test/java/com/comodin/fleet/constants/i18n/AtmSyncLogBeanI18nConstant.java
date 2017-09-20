package com.comodin.fleet.constants.i18n;

@SuppressWarnings({"unused", "SpringAutowiredFieldsWarningInspection", "StatementWithEmptyBody"})
public class AtmSyncLogBeanI18nConstant  {

    /**
     * 创建的用户
     */
    public static final String ATM_SYNC_LOG_BEAN_CREATE_BY_LENGTH = "ATM_SYNC_LOG_BEAN_CREATE_BY_LENGTH";
    /**
     * ATM终端，上次同步成功的主键值，此字段为了解决，ATM终端系统，对应的同步表中，生成的记录的创建时间相同，主键ID不同问题
     */
    public static final String ATM_SYNC_LOG_BEAN_LAST_PRIMARY_KEY_LENGTH = "ATM_SYNC_LOG_BEAN_LAST_PRIMARY_KEY_LENGTH";
    /**
     * 创建时间
     */
    public static final String ATM_SYNC_LOG_BEAN_CREATE_TIMESTAMP_NOT_NULL = "ATM_SYNC_LOG_BEAN_CREATE_TIMESTAMP_NOT_NULL";
    /**
     * ATM终端，上次同步成功的记录时间，【此值为日期时间格式，考虑各ATM客户系统的日期格式差异，目前comodin系统，进行统一处理：yyyy-MM-dd HH:mm:ss.SSS，日期时区服务器不做任务处理，以ATM客户为主】
     */
    public static final String ATM_SYNC_LOG_BEAN_LAST_TIME_NOT_BLANK = "ATM_SYNC_LOG_BEAN_LAST_TIME_NOT_BLANK";
    /**
     * ATM终端，唯一标识
     */
    public static final String ATM_SYNC_LOG_BEAN_ATM_TERMINAL_ID_LENGTH = "ATM_SYNC_LOG_BEAN_ATM_TERMINAL_ID_LENGTH";
    /**
     * ATM终端，读取记录的类型
     */
    public static final String ATM_SYNC_LOG_BEAN_TYPE_ALLOW_DATA = "ATM_SYNC_LOG_BEAN_TYPE_ALLOW_DATA";
    /**
     * 逻辑删除标志【N[正常]，Y[删除]】
     */
    public static final String ATM_SYNC_LOG_BEAN_DELETE_FLAG_NOT_BLANK = "ATM_SYNC_LOG_BEAN_DELETE_FLAG_NOT_BLANK";
    /**
     * ATM终端，读取记录的类型
     */
    public static final String ATM_SYNC_LOG_BEAN_TYPE_LENGTH = "ATM_SYNC_LOG_BEAN_TYPE_LENGTH";
    /**
     * 数据库主键ID
     */
    public static final String ATM_SYNC_LOG_BEAN_ID_NOT_NULL = "ATM_SYNC_LOG_BEAN_ID_NOT_NULL";
    /**
     * ATM终端，读取记录的类型
     */
    public static final String ATM_SYNC_LOG_BEAN_TYPE_NOT_BLANK = "ATM_SYNC_LOG_BEAN_TYPE_NOT_BLANK";
    /**
     * 更新时间
     */
    public static final String ATM_SYNC_LOG_BEAN_UPDATE_TIMESTAMP_DATE_TIME_FORMAT = "ATM_SYNC_LOG_BEAN_UPDATE_TIMESTAMP_DATE_TIME_FORMAT";
    /**
     * ATM终端，上次同步成功的记录时间，【此值为日期时间格式，考虑各ATM客户系统的日期格式差异，目前comodin系统，进行统一处理：yyyy-MM-dd HH:mm:ss.SSS，日期时区服务器不做任务处理，以ATM客户为主】
     */
    public static final String ATM_SYNC_LOG_BEAN_LAST_TIME_LENGTH = "ATM_SYNC_LOG_BEAN_LAST_TIME_LENGTH";
    /**
     * 更新时间
     */
    public static final String ATM_SYNC_LOG_BEAN_UPDATE_TIMESTAMP_NOT_NULL = "ATM_SYNC_LOG_BEAN_UPDATE_TIMESTAMP_NOT_NULL";
    /**
     * ATM终端，唯一标识
     */
    public static final String ATM_SYNC_LOG_BEAN_ATM_TERMINAL_ID_NOT_BLANK = "ATM_SYNC_LOG_BEAN_ATM_TERMINAL_ID_NOT_BLANK";
    /**
     * 创建的用户
     */
    public static final String ATM_SYNC_LOG_BEAN_CREATE_BY_NOT_BLANK = "ATM_SYNC_LOG_BEAN_CREATE_BY_NOT_BLANK";
    /**
     * 创建时间
     */
    public static final String ATM_SYNC_LOG_BEAN_CREATE_TIMESTAMP_DATE_TIME_FORMAT = "ATM_SYNC_LOG_BEAN_CREATE_TIMESTAMP_DATE_TIME_FORMAT";
    /**
     * 数据库主键ID
     */
    public static final String ATM_SYNC_LOG_BEAN_ID_LENGTH = "ATM_SYNC_LOG_BEAN_ID_LENGTH";
    /**
     * 逻辑删除标志【N[正常]，Y[删除]】
     */
    public static final String ATM_SYNC_LOG_BEAN_DELETE_FLAG_LENGTH = "ATM_SYNC_LOG_BEAN_DELETE_FLAG_LENGTH";

}