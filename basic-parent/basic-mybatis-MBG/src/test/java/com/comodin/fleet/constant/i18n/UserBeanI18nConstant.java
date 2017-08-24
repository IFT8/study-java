package com.comodin.fleet.constant.i18n;

@SuppressWarnings({"unused", "SpringAutowiredFieldsWarningInspection", "StatementWithEmptyBody"})
public class UserBeanI18nConstant  {

    /**
     * 状态【ENABLE[启用]、DISABLE[禁用]】
     */
    public static final String USER_BEAN_STATUS_LENGTH = "USER_BEAN_STATUS_LENGTH";
    /**
     * 创建时间
     */
    public static final String USER_BEAN_CREATE_TIMESTAMP_DATE_TIME_FORMAT = "USER_BEAN_CREATE_TIMESTAMP_DATE_TIME_FORMAT";
    /**
     * 用户登陆账号
     */
    public static final String USER_BEAN_USERNAME_LENGTH = "USER_BEAN_USERNAME_LENGTH";
    /**
     * 创建时间
     */
    public static final String USER_BEAN_CREATE_TIMESTAMP_NOT_NULL = "USER_BEAN_CREATE_TIMESTAMP_NOT_NULL";
    /**
     * 角色ID,【以1|2|3 表示对应表:角色表(t_role) 的 id】默认值:空字符串表示没有任何权限
     */
    public static final String USER_BEAN_ROLES_LENGTH = "USER_BEAN_ROLES_LENGTH";
    /**
     * 密码加盐
     */
    public static final String USER_BEAN_PASSWORD_SALT_LENGTH = "USER_BEAN_PASSWORD_SALT_LENGTH";
    /**
     * 逻辑删除标志【N[正常]，Y[删除]】
     */
    public static final String USER_BEAN_DELETE_FLAG_LENGTH = "USER_BEAN_DELETE_FLAG_LENGTH";
    /**
     * 手机号
     */
    public static final String USER_BEAN_PHONE_LENGTH = "USER_BEAN_PHONE_LENGTH";
    /**
     * 状态【ENABLE[启用]、DISABLE[禁用]】
     */
    public static final String USER_BEAN_STATUS_NOT_BLANK = "USER_BEAN_STATUS_NOT_BLANK";
    /**
     * nip用户确认签收密码,MD5加密之后
     */
    public static final String USER_BEAN_PASS_CODE_LENGTH = "USER_BEAN_PASS_CODE_LENGTH";
    /**
     * 最近登陆时间,每次登陆的时候更新一次
     */
    public static final String USER_BEAN_LAST_LOGIN_TIME_DATE_TIME_FORMAT = "USER_BEAN_LAST_LOGIN_TIME_DATE_TIME_FORMAT";
    /**
     * 逻辑删除标志【N[正常]，Y[删除]】
     */
    public static final String USER_BEAN_DELETE_FLAG_NOT_BLANK = "USER_BEAN_DELETE_FLAG_NOT_BLANK";
    /**
     * 姓名,姓
     */
    public static final String USER_BEAN_LAST_NAME_LENGTH = "USER_BEAN_LAST_NAME_LENGTH";
    /**
     * 是否拥有NIP密码权限,Y有,N无
     */
    public static final String USER_BEAN_PASS_CODE_ENABLE_LENGTH = "USER_BEAN_PASS_CODE_ENABLE_LENGTH";
    /**
     * 密码加盐
     */
    public static final String USER_BEAN_PASSWORD_SALT_NOT_BLANK = "USER_BEAN_PASSWORD_SALT_NOT_BLANK";
    /**
     * 用户所属的网点ID,与t_client_branch.branch_id 字段关联
     */
    public static final String USER_BEAN_BRANCH_ID_LENGTH = "USER_BEAN_BRANCH_ID_LENGTH";
    /**
     * 性别
     */
    public static final String USER_BEAN_GENDER_LENGTH = "USER_BEAN_GENDER_LENGTH";
    /**
     * 用户登陆账号
     */
    public static final String USER_BEAN_USERNAME_NOT_BLANK = "USER_BEAN_USERNAME_NOT_BLANK";
    /**
     * 客户类型为[CLIENT]所属哪一个CIT的客户，与t_client.client_id 字段冗余，且类型为[CIT]；0为CIT
     */
    public static final String USER_BEAN_CIT_ID_LENGTH = "USER_BEAN_CIT_ID_LENGTH";
    /**
     * 用户登陆密码,sha256加密
     */
    public static final String USER_BEAN_PASSWORD_NOT_BLANK = "USER_BEAN_PASSWORD_NOT_BLANK";
    /**
     * 谁新增了该员工,与crew_username字段关联
     */
    public static final String USER_BEAN_CREATE_BY_NOT_BLANK = "USER_BEAN_CREATE_BY_NOT_BLANK";
    /**
     * 电子邮箱
     */
    public static final String USER_BEAN_EMAIL_LENGTH = "USER_BEAN_EMAIL_LENGTH";
    /**
     * 头像地址
     */
    public static final String USER_BEAN_PHOTO_LENGTH = "USER_BEAN_PHOTO_LENGTH";
    /**
     * 姓名,名
     */
    public static final String USER_BEAN_FIRST_NAME_LENGTH = "USER_BEAN_FIRST_NAME_LENGTH";
    /**
     * 生日
     */
    public static final String USER_BEAN_BIRTHDAY_DATE_TIME_FORMAT = "USER_BEAN_BIRTHDAY_DATE_TIME_FORMAT";
    /**
     * 用户所属的网点ID,与t_client_branch.branch_id 字段关联
     */
    public static final String USER_BEAN_BRANCH_ID_NOT_NULL = "USER_BEAN_BRANCH_ID_NOT_NULL";
    /**
     * 谁新增了该员工,与crew_username字段关联
     */
    public static final String USER_BEAN_CREATE_BY_LENGTH = "USER_BEAN_CREATE_BY_LENGTH";
    /**
     * 住址
     */
    public static final String USER_BEAN_ADDRESS_LENGTH = "USER_BEAN_ADDRESS_LENGTH";
    /**
     * 数据库主键ID
     */
    public static final String USER_BEAN_ID_LENGTH = "USER_BEAN_ID_LENGTH";
    /**
     * 数据库主键ID
     */
    public static final String USER_BEAN_ID_NOT_NULL = "USER_BEAN_ID_NOT_NULL";
    /**
     * 用户登陆密码,sha256加密
     */
    public static final String USER_BEAN_PASSWORD_LENGTH = "USER_BEAN_PASSWORD_LENGTH";
    /**
     * 客户类型为[CLIENT]所属哪一个CIT的客户，与t_client.client_id 字段冗余，且类型为[CIT]；0为CIT
     */
    public static final String USER_BEAN_CIT_ID_NOT_NULL = "USER_BEAN_CIT_ID_NOT_NULL";
    /**
     * 简介
     */
    public static final String USER_BEAN_DESCRIPTION_LENGTH = "USER_BEAN_DESCRIPTION_LENGTH";
    /**
     * 类似身份证号
     */
    public static final String USER_BEAN_CURP_ID_LENGTH = "USER_BEAN_CURP_ID_LENGTH";
    /**
     * 最近登陆IP每次登陆的时候更新一次
     */
    public static final String USER_BEAN_LAST_LOGIN_IP_LENGTH = "USER_BEAN_LAST_LOGIN_IP_LENGTH";

}