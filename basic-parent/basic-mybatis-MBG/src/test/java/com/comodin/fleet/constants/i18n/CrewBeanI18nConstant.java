package com.comodin.fleet.constants.i18n;

@SuppressWarnings({"unused", "SpringAutowiredFieldsWarningInspection", "StatementWithEmptyBody"})
public class CrewBeanI18nConstant  {

    /**
     * 数据库主键ID
     */
    public static final String CREW_BEAN_ID_LENGTH = "CREW_BEAN_ID_LENGTH";
    /**
     * 手机号
     */
    public static final String CREW_BEAN_PHONE_LENGTH = "CREW_BEAN_PHONE_LENGTH";
    /**
     * 密码加盐
     */
    public static final String CREW_BEAN_PASSWORD_SALT_LENGTH = "CREW_BEAN_PASSWORD_SALT_LENGTH";
    /**
     * 创建时间
     */
    public static final String CREW_BEAN_CREATE_TIMESTAMP_NOT_NULL = "CREW_BEAN_CREATE_TIMESTAMP_NOT_NULL";
    /**
     * 武器,比如:ESCOPETA,REVOLVER,多个武器以|分割,如 |ESCOPETA|REVOLVER|
     */
    public static final String CREW_BEAN_WEAPONS_LENGTH = "CREW_BEAN_WEAPONS_LENGTH";
    /**
     * 密码明文，不对外显示
     */
    public static final String CREW_BEAN_PASSWORD_PLAINTEXT_LENGTH = "CREW_BEAN_PASSWORD_PLAINTEXT_LENGTH";
    /**
     * 简介
     */
    public static final String CREW_BEAN_DESCRIPTION_LENGTH = "CREW_BEAN_DESCRIPTION_LENGTH";
    /**
     * 最近登陆IP
     */
    public static final String CREW_BEAN_LAST_LOGIN_IP_LENGTH = "CREW_BEAN_LAST_LOGIN_IP_LENGTH";
    /**
     * 姓名,姓
     */
    public static final String CREW_BEAN_LAST_NAME_NOT_BLANK = "CREW_BEAN_LAST_NAME_NOT_BLANK";
    /**
     * 数据库主键ID
     */
    public static final String CREW_BEAN_ID_NOT_NULL = "CREW_BEAN_ID_NOT_NULL";
    /**
     * 创建时间
     */
    public static final String CREW_BEAN_CREATE_TIMESTAMP_DATE_TIME_FORMAT = "CREW_BEAN_CREATE_TIMESTAMP_DATE_TIME_FORMAT";
    /**
     * 密码明文，不对外显示
     */
    public static final String CREW_BEAN_PASSWORD_PLAINTEXT_NOT_BLANK = "CREW_BEAN_PASSWORD_PLAINTEXT_NOT_BLANK";
    /**
     * 类似身份证号
     */
    public static final String CREW_BEAN_CURP_ID_LENGTH = "CREW_BEAN_CURP_ID_LENGTH";
    /**
     * 逻辑删除标志【N[正常]，Y[删除]】
     */
    public static final String CREW_BEAN_DELETE_FLAG_NOT_BLANK = "CREW_BEAN_DELETE_FLAG_NOT_BLANK";
    /**
     * 姓名,姓
     */
    public static final String CREW_BEAN_LAST_NAME_LENGTH = "CREW_BEAN_LAST_NAME_LENGTH";
    /**
     * 员工登陆账号
     */
    public static final String CREW_BEAN_USERNAME_LENGTH = "CREW_BEAN_USERNAME_LENGTH";
    /**
     * 姓名,名
     */
    public static final String CREW_BEAN_FIRST_NAME_LENGTH = "CREW_BEAN_FIRST_NAME_LENGTH";
    /**
     * 员工登陆密码,sha256加密
     */
    public static final String CREW_BEAN_PASSWORD_NOT_BLANK = "CREW_BEAN_PASSWORD_NOT_BLANK";
    /**
     * 住址
     */
    public static final String CREW_BEAN_ADDRESS_LENGTH = "CREW_BEAN_ADDRESS_LENGTH";
    /**
     * 电子邮箱
     */
    public static final String CREW_BEAN_EMAIL_LENGTH = "CREW_BEAN_EMAIL_LENGTH";
    /**
     * 逻辑删除标志【N[正常]，Y[删除]】
     */
    public static final String CREW_BEAN_DELETE_FLAG_LENGTH = "CREW_BEAN_DELETE_FLAG_LENGTH";
    /**
     * 员工登陆账号
     */
    public static final String CREW_BEAN_USERNAME_NOT_BLANK = "CREW_BEAN_USERNAME_NOT_BLANK";
    /**
     * 角色ID,【以1|2|3 表示对应表:角色表(t_role)的id】默认值:空字符串表示没有任何权限
     */
    public static final String CREW_BEAN_ROLES_LENGTH = "CREW_BEAN_ROLES_LENGTH";
    /**
     * 组织机构级别,与t_client_organization.client_organization_id关联比如总部可以看所有分支的数据,region只能看自己区域内的数据
     */
    public static final String CREW_BEAN_ORGANIZATION_ID_LENGTH = "CREW_BEAN_ORGANIZATION_ID_LENGTH";
    /**
     * 最近登陆时间
     */
    public static final String CREW_BEAN_LAST_LOGIN_TIME_DATE_TIME_FORMAT = "CREW_BEAN_LAST_LOGIN_TIME_DATE_TIME_FORMAT";
    /**
     * 头像地址
     */
    public static final String CREW_BEAN_PHOTO_LENGTH = "CREW_BEAN_PHOTO_LENGTH";
    /**
     * 状态【ENABLE[启用]、DISABLE[禁用]】
     */
    public static final String CREW_BEAN_STATUS_NOT_BLANK = "CREW_BEAN_STATUS_NOT_BLANK";
    /**
     * 密码加盐
     */
    public static final String CREW_BEAN_PASSWORD_SALT_NOT_BLANK = "CREW_BEAN_PASSWORD_SALT_NOT_BLANK";
    /**
     * 员工所属部门id:技术部,运输部,安保部...
     */
    public static final String CREW_BEAN_DEPARTMENT_ID_NOT_BLANK = "CREW_BEAN_DEPARTMENT_ID_NOT_BLANK";
    /**
     * 固定电话
     */
    public static final String CREW_BEAN_TELE_PHONE_LENGTH = "CREW_BEAN_TELE_PHONE_LENGTH";
    /**
     * 姓名,名
     */
    public static final String CREW_BEAN_FIRST_NAME_NOT_BLANK = "CREW_BEAN_FIRST_NAME_NOT_BLANK";
    /**
     * 员工内部编号
     */
    public static final String CREW_BEAN_INTERNAL_ID_LENGTH = "CREW_BEAN_INTERNAL_ID_LENGTH";
    /**
     * 员工所属部门id:技术部,运输部,安保部...
     */
    public static final String CREW_BEAN_DEPARTMENT_ID_LENGTH = "CREW_BEAN_DEPARTMENT_ID_LENGTH";
    /**
     * 员工技能,比如:  DRIVE,REPAIR,MAINTANENCE,多个技能以|分割,如 |DRIVE|REPAIR|MAINTANENCE|
     */
    public static final String CREW_BEAN_SKILLS_LENGTH = "CREW_BEAN_SKILLS_LENGTH";
    /**
     * 生日
     */
    public static final String CREW_BEAN_BIRTHDAY_DATE_TIME_FORMAT = "CREW_BEAN_BIRTHDAY_DATE_TIME_FORMAT";
    /**
     * 员工登陆密码,sha256加密
     */
    public static final String CREW_BEAN_PASSWORD_LENGTH = "CREW_BEAN_PASSWORD_LENGTH";
    /**
     * 员工所属的网点ID,与t_client_branch.branch_id 字段关联
     */
    public static final String CREW_BEAN_BRANCH_ID_NOT_NULL = "CREW_BEAN_BRANCH_ID_NOT_NULL";
    /**
     * 谁新增了该员工,与crew_username字段关联
     */
    public static final String CREW_BEAN_CREATE_BY_LENGTH = "CREW_BEAN_CREATE_BY_LENGTH";
    /**
     * 状态【ENABLE[启用]、DISABLE[禁用]】
     */
    public static final String CREW_BEAN_STATUS_LENGTH = "CREW_BEAN_STATUS_LENGTH";
    /**
     * 性别MALE,FEMALE
     */
    public static final String CREW_BEAN_GENDER_LENGTH = "CREW_BEAN_GENDER_LENGTH";
    /**
     * 谁新增了该员工,与crew_username字段关联
     */
    public static final String CREW_BEAN_CREATE_BY_NOT_BLANK = "CREW_BEAN_CREATE_BY_NOT_BLANK";
    /**
     * 员工所属的网点ID,与t_client_branch.branch_id 字段关联
     */
    public static final String CREW_BEAN_BRANCH_ID_LENGTH = "CREW_BEAN_BRANCH_ID_LENGTH";

}