package com.comodin.fleet.core.bean;

import com.comodin.basic.util.date.DateUtil;
import com.comodin.basic.validation.IBaseValidGroup;
import com.comodin.basic.validation.constraints.*;
import com.comodin.fleet.constants.i18n.CrewBeanI18nConstant;
import java.io.Serializable;
import java.util.Date;
import javax.persistence.*;
import javax.validation.constraints.*;
import org.hibernate.validator.constraints.*;
import org.springframework.format.annotation.DateTimeFormat;

@SuppressWarnings({"unused", "SpringAutowiredFieldsWarningInspection", "StatementWithEmptyBody", "WeakerAccess", "DefaultAnnotationParam"})
@Entity
@Table(name = "t_crew")
public class CrewBean implements Serializable {
    /**
     * <pre>
     * DB remark: 数据库主键ID
     * DB column: crew_id	BIGINT(20)	<--->	id	java.lang.Long
     * DB is  Nullable: false
     * DB defaultValue: null
     * </pre>
     */
    @NotNull(message = "{" + CrewBeanI18nConstant.CREW_BEAN_ID_NOT_NULL + "}", groups = {IBaseValidGroup.Update.class})
    @ValidLength(max = 20, message = "{" + CrewBeanI18nConstant.CREW_BEAN_ID_LENGTH + "}", groups = {IBaseValidGroup.Update.class})
    @Column(name = "crew_id", length = 20, nullable = false)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    private Long id;

    /**
     * <pre>
     * DB remark: 员工内部编号
     * DB column: crew_internal_id	VARCHAR(15)	<--->	internalId	java.lang.String
     * DB is  Nullable: true
     * DB defaultValue: null
     * </pre>
     */
    @Length(max = 15, message = "{" + CrewBeanI18nConstant.CREW_BEAN_INTERNAL_ID_LENGTH + "}", groups = {IBaseValidGroup.Add.class, IBaseValidGroup.Update.class})
    @Column(name = "crew_internal_id", length = 15, nullable = true)
    private String internalId;

    /**
     * <pre>
     * DB remark: 员工登陆账号
     * DB column: crew_username	VARCHAR(20)	<--->	username	java.lang.String
     * DB is  Nullable: false
     * DB defaultValue: null
     * </pre>
     */
    @NotBlank(message = "{" + CrewBeanI18nConstant.CREW_BEAN_USERNAME_NOT_BLANK + "}", groups = {IBaseValidGroup.Add.class, IBaseValidGroup.Update.class})
    @Length(max = 20, message = "{" + CrewBeanI18nConstant.CREW_BEAN_USERNAME_LENGTH + "}", groups = {IBaseValidGroup.Add.class, IBaseValidGroup.Update.class})
    @Column(name = "crew_username", length = 20, nullable = false)
    private String username;

    /**
     * <pre>
     * DB remark: 员工登陆密码,sha256加密
     * DB column: crew_password	VARCHAR(64)	<--->	password	java.lang.String
     * DB is  Nullable: false
     * DB defaultValue: null
     * </pre>
     */
    @NotBlank(message = "{" + CrewBeanI18nConstant.CREW_BEAN_PASSWORD_NOT_BLANK + "}", groups = {IBaseValidGroup.Add.class, IBaseValidGroup.Update.class})
    @Length(max = 64, message = "{" + CrewBeanI18nConstant.CREW_BEAN_PASSWORD_LENGTH + "}", groups = {IBaseValidGroup.Add.class, IBaseValidGroup.Update.class})
    @Column(name = "crew_password", length = 64, nullable = false)
    private String password;

    /**
     * <pre>
     * DB remark: 密码加盐
     * DB column: crew_password_salt	CHAR(8)	<--->	passwordSalt	java.lang.String
     * DB is  Nullable: false
     * DB defaultValue: null
     * </pre>
     */
    @NotBlank(message = "{" + CrewBeanI18nConstant.CREW_BEAN_PASSWORD_SALT_NOT_BLANK + "}", groups = {IBaseValidGroup.Add.class, IBaseValidGroup.Update.class})
    @Length(max = 8, message = "{" + CrewBeanI18nConstant.CREW_BEAN_PASSWORD_SALT_LENGTH + "}", groups = {IBaseValidGroup.Add.class, IBaseValidGroup.Update.class})
    @Column(name = "crew_password_salt", length = 8, nullable = false)
    private String passwordSalt;

    /**
     * <pre>
     * DB remark: 密码明文,不对外显示
     * DB column: crew_password_plaintext	CHAR(20)	<--->	passwordPlaintext	java.lang.String
     * DB is  Nullable: false
     * DB defaultValue: null
     * </pre>
     */
    @NotBlank(message = "{" + CrewBeanI18nConstant.CREW_BEAN_PASSWORD_PLAINTEXT_NOT_BLANK + "}", groups = {IBaseValidGroup.Add.class, IBaseValidGroup.Update.class})
    @Length(max = 20, message = "{" + CrewBeanI18nConstant.CREW_BEAN_PASSWORD_PLAINTEXT_LENGTH + "}", groups = {IBaseValidGroup.Add.class, IBaseValidGroup.Update.class})
    @Column(name = "crew_password_plaintext", length = 20, nullable = false)
    private String passwordPlaintext;

    /**
     * <pre>
     * DB remark: 员工所属的网点ID,与t_client_branch.branch_id 字段关联
     * DB column: crew_branch_id	BIGINT(20)	<--->	branchId	java.lang.Long
     * DB is  Nullable: false
     * DB defaultValue: null
     * </pre>
     */
    @NotNull(message = "{" + CrewBeanI18nConstant.CREW_BEAN_BRANCH_ID_NOT_NULL + "}", groups = {IBaseValidGroup.Add.class, IBaseValidGroup.Update.class})
    @ValidLength(max = 20, message = "{" + CrewBeanI18nConstant.CREW_BEAN_BRANCH_ID_LENGTH + "}", groups = {IBaseValidGroup.Add.class, IBaseValidGroup.Update.class})
    @Column(name = "crew_branch_id", length = 20, nullable = false)
    private Long branchId;

    /**
     * <pre>
     * DB remark: 员工所属部门id:技术部,运输部,安保部...
     * DB column: crew_department_id	VARCHAR(40)	<--->	departmentId	java.lang.String
     * DB is  Nullable: false
     * DB defaultValue: null
     * </pre>
     */
    @NotBlank(message = "{" + CrewBeanI18nConstant.CREW_BEAN_DEPARTMENT_ID_NOT_BLANK + "}", groups = {IBaseValidGroup.Add.class, IBaseValidGroup.Update.class})
    @Length(max = 40, message = "{" + CrewBeanI18nConstant.CREW_BEAN_DEPARTMENT_ID_LENGTH + "}", groups = {IBaseValidGroup.Add.class, IBaseValidGroup.Update.class})
    @Column(name = "crew_department_id", length = 40, nullable = false)
    private String departmentId;

    /**
     * <pre>
     * DB remark: 角色ID,【以1|2|3 表示对应表:角色表(t_role)的id】默认值:空字符串表示没有任何权限
     * DB column: crew_roles	VARCHAR(50)	<--->	roles	java.lang.String
     * DB is  Nullable: true
     * DB defaultValue: 
     * </pre>
     */
    @Length(max = 50, message = "{" + CrewBeanI18nConstant.CREW_BEAN_ROLES_LENGTH + "}", groups = {IBaseValidGroup.Add.class, IBaseValidGroup.Update.class})
    @Column(name = "crew_roles", length = 50, nullable = true)
    private String roles;

    /**
     * <pre>
     * DB remark: 姓名,名
     * DB column: crew_first_name	VARCHAR(100)	<--->	firstName	java.lang.String
     * DB is  Nullable: false
     * DB defaultValue: null
     * </pre>
     */
    @NotBlank(message = "{" + CrewBeanI18nConstant.CREW_BEAN_FIRST_NAME_NOT_BLANK + "}", groups = {IBaseValidGroup.Add.class, IBaseValidGroup.Update.class})
    @Length(max = 100, message = "{" + CrewBeanI18nConstant.CREW_BEAN_FIRST_NAME_LENGTH + "}", groups = {IBaseValidGroup.Add.class, IBaseValidGroup.Update.class})
    @Column(name = "crew_first_name", length = 100, nullable = false)
    private String firstName;

    /**
     * <pre>
     * DB remark: 姓名,姓
     * DB column: crew_last_name	VARCHAR(100)	<--->	lastName	java.lang.String
     * DB is  Nullable: false
     * DB defaultValue: null
     * </pre>
     */
    @NotBlank(message = "{" + CrewBeanI18nConstant.CREW_BEAN_LAST_NAME_NOT_BLANK + "}", groups = {IBaseValidGroup.Add.class, IBaseValidGroup.Update.class})
    @Length(max = 100, message = "{" + CrewBeanI18nConstant.CREW_BEAN_LAST_NAME_LENGTH + "}", groups = {IBaseValidGroup.Add.class, IBaseValidGroup.Update.class})
    @Column(name = "crew_last_name", length = 100, nullable = false)
    private String lastName;

    /**
     * <pre>
     * DB remark: 手机号
     * DB column: crew_phone	VARCHAR(15)	<--->	phone	java.lang.String
     * DB is  Nullable: true
     * DB defaultValue: null
     * </pre>
     */
    @Length(max = 15, message = "{" + CrewBeanI18nConstant.CREW_BEAN_PHONE_LENGTH + "}", groups = {IBaseValidGroup.Add.class, IBaseValidGroup.Update.class})
    @Column(name = "crew_phone", length = 15, nullable = true)
    private String phone;

    /**
     * <pre>
     * DB remark: 固定电话
     * DB column: crew_tele_phone	VARCHAR(20)	<--->	telePhone	java.lang.String
     * DB is  Nullable: true
     * DB defaultValue: null
     * </pre>
     */
    @Length(max = 20, message = "{" + CrewBeanI18nConstant.CREW_BEAN_TELE_PHONE_LENGTH + "}", groups = {IBaseValidGroup.Add.class, IBaseValidGroup.Update.class})
    @Column(name = "crew_tele_phone", length = 20, nullable = true)
    private String telePhone;

    /**
     * <pre>
     * DB remark: 电子邮箱
     * DB column: crew_email	VARCHAR(45)	<--->	email	java.lang.String
     * DB is  Nullable: true
     * DB defaultValue: null
     * </pre>
     */
    @Length(max = 45, message = "{" + CrewBeanI18nConstant.CREW_BEAN_EMAIL_LENGTH + "}", groups = {IBaseValidGroup.Add.class, IBaseValidGroup.Update.class})
    @Column(name = "crew_email", length = 45, nullable = true)
    private String email;

    /**
     * <pre>
     * DB remark: 性别MALE,FEMALE
     * DB column: crew_gender	CHAR(6)	<--->	gender	java.lang.String
     * DB is  Nullable: true
     * DB defaultValue: null
     * </pre>
     */
    @Length(max = 6, message = "{" + CrewBeanI18nConstant.CREW_BEAN_GENDER_LENGTH + "}", groups = {IBaseValidGroup.Add.class, IBaseValidGroup.Update.class})
    @Column(name = "crew_gender", length = 6, nullable = true)
    private String gender;

    /**
     * <pre>
     * DB remark: 生日
     * DB column: crew_birthday	DATE(10)	<--->	birthday	java.util.Date
     * DB is  Nullable: true
     * DB defaultValue: null
     * </pre>
     */
    @ValidDateTimeFormat(pattern = DateUtil.DATE_PATTERN_YYYY_MM_DD, message = "{" + CrewBeanI18nConstant.CREW_BEAN_BIRTHDAY_DATE_TIME_FORMAT + "}", groups = {IBaseValidGroup.Add.class, IBaseValidGroup.Update.class})
    @DateTimeFormat(pattern = DateUtil.DATE_PATTERN_YYYY_MM_DD)
    @Column(name = "crew_birthday", length = 10, nullable = true)
    private Date birthday;

    /**
     * <pre>
     * DB remark: 类似身份证号
     * DB column: crew_curp_id	VARCHAR(20)	<--->	curpId	java.lang.String
     * DB is  Nullable: true
     * DB defaultValue: null
     * </pre>
     */
    @Length(max = 20, message = "{" + CrewBeanI18nConstant.CREW_BEAN_CURP_ID_LENGTH + "}", groups = {IBaseValidGroup.Add.class, IBaseValidGroup.Update.class})
    @Column(name = "crew_curp_id", length = 20, nullable = true)
    private String curpId;

    /**
     * <pre>
     * DB remark: 头像地址
     * DB column: crew_photo	VARCHAR(100)	<--->	photo	java.lang.String
     * DB is  Nullable: true
     * DB defaultValue: null
     * </pre>
     */
    @Length(max = 100, message = "{" + CrewBeanI18nConstant.CREW_BEAN_PHOTO_LENGTH + "}", groups = {IBaseValidGroup.Add.class, IBaseValidGroup.Update.class})
    @Column(name = "crew_photo", length = 100, nullable = true)
    private String photo;

    /**
     * <pre>
     * DB remark: 住址
     * DB column: crew_address	VARCHAR(100)	<--->	address	java.lang.String
     * DB is  Nullable: true
     * DB defaultValue: null
     * </pre>
     */
    @Length(max = 100, message = "{" + CrewBeanI18nConstant.CREW_BEAN_ADDRESS_LENGTH + "}", groups = {IBaseValidGroup.Add.class, IBaseValidGroup.Update.class})
    @Column(name = "crew_address", length = 100, nullable = true)
    private String address;

    /**
     * <pre>
     * DB remark: 简介
     * DB column: crew_description	VARCHAR(300)	<--->	description	java.lang.String
     * DB is  Nullable: true
     * DB defaultValue: null
     * </pre>
     */
    @Length(max = 300, message = "{" + CrewBeanI18nConstant.CREW_BEAN_DESCRIPTION_LENGTH + "}", groups = {IBaseValidGroup.Add.class, IBaseValidGroup.Update.class})
    @Column(name = "crew_description", length = 300, nullable = true)
    private String description;

    /**
     * <pre>
     * DB remark: 员工技能,比如:  DRIVE,REPAIR,MAINTANENCE,多个技能以|分割,如 |DRIVE|REPAIR|MAINTANENCE|
     * DB column: crew_skills	VARCHAR(50)	<--->	skills	java.lang.String
     * DB is  Nullable: true
     * DB defaultValue: null
     * </pre>
     */
    @Length(max = 50, message = "{" + CrewBeanI18nConstant.CREW_BEAN_SKILLS_LENGTH + "}", groups = {IBaseValidGroup.Add.class, IBaseValidGroup.Update.class})
    @Column(name = "crew_skills", length = 50, nullable = true)
    private String skills;

    /**
     * <pre>
     * DB remark: 武器,比如:ESCOPETA,REVOLVER,多个武器以|分割,如 |ESCOPETA|REVOLVER|
     * DB column: crew_weapons	VARCHAR(50)	<--->	weapons	java.lang.String
     * DB is  Nullable: true
     * DB defaultValue: null
     * </pre>
     */
    @Length(max = 50, message = "{" + CrewBeanI18nConstant.CREW_BEAN_WEAPONS_LENGTH + "}", groups = {IBaseValidGroup.Add.class, IBaseValidGroup.Update.class})
    @Column(name = "crew_weapons", length = 50, nullable = true)
    private String weapons;

    /**
     * <pre>
     * DB remark: 最近登陆时间
     * DB column: crew_last_login_time	TIMESTAMP(19)	<--->	lastLoginTime	java.util.Date
     * DB is  Nullable: true
     * DB defaultValue: null
     * </pre>
     */
    @ValidDateTimeFormat(pattern = DateUtil.DATE_PATTERN_YYYY_MM_DD_HH_MM_SS, message = "{" + CrewBeanI18nConstant.CREW_BEAN_LAST_LOGIN_TIME_DATE_TIME_FORMAT + "}", groups = {IBaseValidGroup.Add.class, IBaseValidGroup.Update.class})
    @DateTimeFormat(pattern = DateUtil.DATE_PATTERN_YYYY_MM_DD_HH_MM_SS)
    @Column(name = "crew_last_login_time", length = 19, nullable = true)
    private Date lastLoginTime;

    /**
     * <pre>
     * DB remark: 最近登陆IP
     * DB column: crew_last_login_ip	VARCHAR(20)	<--->	lastLoginIp	java.lang.String
     * DB is  Nullable: true
     * DB defaultValue: null
     * </pre>
     */
    @Length(max = 20, message = "{" + CrewBeanI18nConstant.CREW_BEAN_LAST_LOGIN_IP_LENGTH + "}", groups = {IBaseValidGroup.Add.class, IBaseValidGroup.Update.class})
    @Column(name = "crew_last_login_ip", length = 20, nullable = true)
    private String lastLoginIp;

    /**
     * <pre>
     * DB remark: 组织机构级别,与t_client_organization.client_organization_id关联比如总部可以看所有分支的数据,region只能看自己区域内的数据
     * DB column: crew_organization_id	INTEGER(10)	<--->	organizationId	java.lang.Integer
     * DB is  Nullable: true
     * DB defaultValue: null
     * </pre>
     */
    @ValidLength(max = 10, message = "{" + CrewBeanI18nConstant.CREW_BEAN_ORGANIZATION_ID_LENGTH + "}", groups = {IBaseValidGroup.Add.class, IBaseValidGroup.Update.class})
    @Column(name = "crew_organization_id", length = 10, nullable = true)
    private Integer organizationId;

    /**
     * <pre>
     * DB remark: 状态【ENABLE[启用]、DISABLE[禁用]】
     * DB column: crew_status	CHAR(7)	<--->	status	java.lang.String
     * DB is  Nullable: false
     * DB defaultValue: ENABLE
     * </pre>
     */
    @NotBlank(message = "{" + CrewBeanI18nConstant.CREW_BEAN_STATUS_NOT_BLANK + "}", groups = {IBaseValidGroup.Add.class, IBaseValidGroup.Update.class})
    @Length(max = 7, message = "{" + CrewBeanI18nConstant.CREW_BEAN_STATUS_LENGTH + "}", groups = {IBaseValidGroup.Add.class, IBaseValidGroup.Update.class})
    @Column(name = "crew_status", length = 7, nullable = false)
    private String status;

    /**
     * <pre>
     * DB remark: 谁新增了该员工,与crew_username字段关联
     * DB column: crew_create_by	VARCHAR(20)	<--->	createBy	java.lang.String
     * DB is  Nullable: false
     * DB defaultValue: null
     * </pre>
     */
    @NotBlank(message = "{" + CrewBeanI18nConstant.CREW_BEAN_CREATE_BY_NOT_BLANK + "}", groups = {IBaseValidGroup.Add.class, IBaseValidGroup.Update.class})
    @Length(max = 20, message = "{" + CrewBeanI18nConstant.CREW_BEAN_CREATE_BY_LENGTH + "}", groups = {IBaseValidGroup.Add.class, IBaseValidGroup.Update.class})
    @Column(name = "crew_create_by", length = 20, nullable = false)
    private String createBy;

    /**
     * <pre>
     * DB remark: 创建时间
     * DB column: crew_create_timestamp	TIMESTAMP(19)	<--->	createTimestamp	java.util.Date
     * DB is  Nullable: false
     * DB defaultValue: CURRENT_TIMESTAMP
     * </pre>
     */
    @ValidDateTimeFormat(pattern = DateUtil.DATE_PATTERN_YYYY_MM_DD_HH_MM_SS, message = "{" + CrewBeanI18nConstant.CREW_BEAN_CREATE_TIMESTAMP_DATE_TIME_FORMAT + "}", groups = {IBaseValidGroup.Add.class, IBaseValidGroup.Update.class})
    @DateTimeFormat(pattern = DateUtil.DATE_PATTERN_YYYY_MM_DD_HH_MM_SS)
    @NotNull(message = "{" + CrewBeanI18nConstant.CREW_BEAN_CREATE_TIMESTAMP_NOT_NULL + "}", groups = {IBaseValidGroup.Add.class, IBaseValidGroup.Update.class})
    @Column(name = "crew_create_timestamp", length = 19, nullable = false)
    private Date createTimestamp;

    /**
     * <pre>
     * DB remark: 逻辑删除标志【N[正常],Y[删除]】
     * DB column: crew_delete_flag	CHAR(1)	<--->	deleteFlag	java.lang.String
     * DB is  Nullable: false
     * DB defaultValue: N
     * </pre>
     */
    @NotBlank(message = "{" + CrewBeanI18nConstant.CREW_BEAN_DELETE_FLAG_NOT_BLANK + "}", groups = {IBaseValidGroup.Add.class, IBaseValidGroup.Update.class})
    @Length(max = 1, message = "{" + CrewBeanI18nConstant.CREW_BEAN_DELETE_FLAG_LENGTH + "}", groups = {IBaseValidGroup.Add.class, IBaseValidGroup.Update.class})
    @Column(name = "crew_delete_flag", length = 1, nullable = false)
    private String deleteFlag;

    private static final long serialVersionUID = 1L;

    /**
     * 获取 数据库主键ID
     *
     * @return crew_id - 数据库主键ID
     */
    public Long getId() {
        return id;
    }

    /**
     * 设置 数据库主键ID
     *
     * @param id - 数据库主键ID
     */
    public CrewBean setId(Long id) {
        this.id = id;
        return this;
    }

    /**
     * 获取 员工内部编号
     *
     * @return crew_internal_id - 员工内部编号
     */
    public String getInternalId() {
        return internalId;
    }

    /**
     * 设置 员工内部编号
     *
     * @param internalId - 员工内部编号
     */
    public CrewBean setInternalId(String internalId) {
        this.internalId = internalId == null ? null : internalId.trim();
        return this;
    }

    /**
     * 获取 员工登陆账号
     *
     * @return crew_username - 员工登陆账号
     */
    public String getUsername() {
        return username;
    }

    /**
     * 设置 员工登陆账号
     *
     * @param username - 员工登陆账号
     */
    public CrewBean setUsername(String username) {
        this.username = username == null ? null : username.trim();
        return this;
    }

    /**
     * 获取 员工登陆密码,sha256加密
     *
     * @return crew_password - 员工登陆密码,sha256加密
     */
    public String getPassword() {
        return password;
    }

    /**
     * 设置 员工登陆密码,sha256加密
     *
     * @param password - 员工登陆密码,sha256加密
     */
    public CrewBean setPassword(String password) {
        this.password = password == null ? null : password.trim();
        return this;
    }

    /**
     * 获取 密码加盐
     *
     * @return crew_password_salt - 密码加盐
     */
    public String getPasswordSalt() {
        return passwordSalt;
    }

    /**
     * 设置 密码加盐
     *
     * @param passwordSalt - 密码加盐
     */
    public CrewBean setPasswordSalt(String passwordSalt) {
        this.passwordSalt = passwordSalt == null ? null : passwordSalt.trim();
        return this;
    }

    /**
     * 获取 密码明文,不对外显示
     *
     * @return crew_password_plaintext - 密码明文,不对外显示
     */
    public String getPasswordPlaintext() {
        return passwordPlaintext;
    }

    /**
     * 设置 密码明文,不对外显示
     *
     * @param passwordPlaintext - 密码明文,不对外显示
     */
    public CrewBean setPasswordPlaintext(String passwordPlaintext) {
        this.passwordPlaintext = passwordPlaintext == null ? null : passwordPlaintext.trim();
        return this;
    }

    /**
     * 获取 员工所属的网点ID,与t_client_branch.branch_id 字段关联
     *
     * @return crew_branch_id - 员工所属的网点ID,与t_client_branch.branch_id 字段关联
     */
    public Long getBranchId() {
        return branchId;
    }

    /**
     * 设置 员工所属的网点ID,与t_client_branch.branch_id 字段关联
     *
     * @param branchId - 员工所属的网点ID,与t_client_branch.branch_id 字段关联
     */
    public CrewBean setBranchId(Long branchId) {
        this.branchId = branchId;
        return this;
    }

    /**
     * 获取 员工所属部门id:技术部,运输部,安保部...
     *
     * @return crew_department_id - 员工所属部门id:技术部,运输部,安保部...
     */
    public String getDepartmentId() {
        return departmentId;
    }

    /**
     * 设置 员工所属部门id:技术部,运输部,安保部...
     *
     * @param departmentId - 员工所属部门id:技术部,运输部,安保部...
     */
    public CrewBean setDepartmentId(String departmentId) {
        this.departmentId = departmentId == null ? null : departmentId.trim();
        return this;
    }

    /**
     * 获取 角色ID,【以1|2|3 表示对应表:角色表(t_role)的id】默认值:空字符串表示没有任何权限
     *
     * @return crew_roles - 角色ID,【以1|2|3 表示对应表:角色表(t_role)的id】默认值:空字符串表示没有任何权限
     */
    public String getRoles() {
        return roles;
    }

    /**
     * 设置 角色ID,【以1|2|3 表示对应表:角色表(t_role)的id】默认值:空字符串表示没有任何权限
     *
     * @param roles - 角色ID,【以1|2|3 表示对应表:角色表(t_role)的id】默认值:空字符串表示没有任何权限
     */
    public CrewBean setRoles(String roles) {
        this.roles = roles == null ? null : roles.trim();
        return this;
    }

    /**
     * 获取 姓名,名
     *
     * @return crew_first_name - 姓名,名
     */
    public String getFirstName() {
        return firstName;
    }

    /**
     * 设置 姓名,名
     *
     * @param firstName - 姓名,名
     */
    public CrewBean setFirstName(String firstName) {
        this.firstName = firstName == null ? null : firstName.trim();
        return this;
    }

    /**
     * 获取 姓名,姓
     *
     * @return crew_last_name - 姓名,姓
     */
    public String getLastName() {
        return lastName;
    }

    /**
     * 设置 姓名,姓
     *
     * @param lastName - 姓名,姓
     */
    public CrewBean setLastName(String lastName) {
        this.lastName = lastName == null ? null : lastName.trim();
        return this;
    }

    /**
     * 获取 手机号
     *
     * @return crew_phone - 手机号
     */
    public String getPhone() {
        return phone;
    }

    /**
     * 设置 手机号
     *
     * @param phone - 手机号
     */
    public CrewBean setPhone(String phone) {
        this.phone = phone == null ? null : phone.trim();
        return this;
    }

    /**
     * 获取 固定电话
     *
     * @return crew_tele_phone - 固定电话
     */
    public String getTelePhone() {
        return telePhone;
    }

    /**
     * 设置 固定电话
     *
     * @param telePhone - 固定电话
     */
    public CrewBean setTelePhone(String telePhone) {
        this.telePhone = telePhone == null ? null : telePhone.trim();
        return this;
    }

    /**
     * 获取 电子邮箱
     *
     * @return crew_email - 电子邮箱
     */
    public String getEmail() {
        return email;
    }

    /**
     * 设置 电子邮箱
     *
     * @param email - 电子邮箱
     */
    public CrewBean setEmail(String email) {
        this.email = email == null ? null : email.trim();
        return this;
    }

    /**
     * 获取 性别MALE,FEMALE
     *
     * @return crew_gender - 性别MALE,FEMALE
     */
    public String getGender() {
        return gender;
    }

    /**
     * 设置 性别MALE,FEMALE
     *
     * @param gender - 性别MALE,FEMALE
     */
    public CrewBean setGender(String gender) {
        this.gender = gender == null ? null : gender.trim();
        return this;
    }

    /**
     * 获取 生日
     *
     * @return crew_birthday - 生日
     */
    public Date getBirthday() {
        return birthday;
    }

    /**
     * 设置 生日
     *
     * @param birthday - 生日
     */
    public CrewBean setBirthday(Date birthday) {
        this.birthday = birthday;
        return this;
    }

    /**
     * 获取 类似身份证号
     *
     * @return crew_curp_id - 类似身份证号
     */
    public String getCurpId() {
        return curpId;
    }

    /**
     * 设置 类似身份证号
     *
     * @param curpId - 类似身份证号
     */
    public CrewBean setCurpId(String curpId) {
        this.curpId = curpId == null ? null : curpId.trim();
        return this;
    }

    /**
     * 获取 头像地址
     *
     * @return crew_photo - 头像地址
     */
    public String getPhoto() {
        return photo;
    }

    /**
     * 设置 头像地址
     *
     * @param photo - 头像地址
     */
    public CrewBean setPhoto(String photo) {
        this.photo = photo == null ? null : photo.trim();
        return this;
    }

    /**
     * 获取 住址
     *
     * @return crew_address - 住址
     */
    public String getAddress() {
        return address;
    }

    /**
     * 设置 住址
     *
     * @param address - 住址
     */
    public CrewBean setAddress(String address) {
        this.address = address == null ? null : address.trim();
        return this;
    }

    /**
     * 获取 简介
     *
     * @return crew_description - 简介
     */
    public String getDescription() {
        return description;
    }

    /**
     * 设置 简介
     *
     * @param description - 简介
     */
    public CrewBean setDescription(String description) {
        this.description = description == null ? null : description.trim();
        return this;
    }

    /**
     * 获取 员工技能,比如:  DRIVE,REPAIR,MAINTANENCE,多个技能以|分割,如 |DRIVE|REPAIR|MAINTANENCE|
     *
     * @return crew_skills - 员工技能,比如:  DRIVE,REPAIR,MAINTANENCE,多个技能以|分割,如 |DRIVE|REPAIR|MAINTANENCE|
     */
    public String getSkills() {
        return skills;
    }

    /**
     * 设置 员工技能,比如:  DRIVE,REPAIR,MAINTANENCE,多个技能以|分割,如 |DRIVE|REPAIR|MAINTANENCE|
     *
     * @param skills - 员工技能,比如:  DRIVE,REPAIR,MAINTANENCE,多个技能以|分割,如 |DRIVE|REPAIR|MAINTANENCE|
     */
    public CrewBean setSkills(String skills) {
        this.skills = skills == null ? null : skills.trim();
        return this;
    }

    /**
     * 获取 武器,比如:ESCOPETA,REVOLVER,多个武器以|分割,如 |ESCOPETA|REVOLVER|
     *
     * @return crew_weapons - 武器,比如:ESCOPETA,REVOLVER,多个武器以|分割,如 |ESCOPETA|REVOLVER|
     */
    public String getWeapons() {
        return weapons;
    }

    /**
     * 设置 武器,比如:ESCOPETA,REVOLVER,多个武器以|分割,如 |ESCOPETA|REVOLVER|
     *
     * @param weapons - 武器,比如:ESCOPETA,REVOLVER,多个武器以|分割,如 |ESCOPETA|REVOLVER|
     */
    public CrewBean setWeapons(String weapons) {
        this.weapons = weapons == null ? null : weapons.trim();
        return this;
    }

    /**
     * 获取 最近登陆时间
     *
     * @return crew_last_login_time - 最近登陆时间
     */
    public Date getLastLoginTime() {
        return lastLoginTime;
    }

    /**
     * 设置 最近登陆时间
     *
     * @param lastLoginTime - 最近登陆时间
     */
    public CrewBean setLastLoginTime(Date lastLoginTime) {
        this.lastLoginTime = lastLoginTime;
        return this;
    }

    /**
     * 获取 最近登陆IP
     *
     * @return crew_last_login_ip - 最近登陆IP
     */
    public String getLastLoginIp() {
        return lastLoginIp;
    }

    /**
     * 设置 最近登陆IP
     *
     * @param lastLoginIp - 最近登陆IP
     */
    public CrewBean setLastLoginIp(String lastLoginIp) {
        this.lastLoginIp = lastLoginIp == null ? null : lastLoginIp.trim();
        return this;
    }

    /**
     * 获取 组织机构级别,与t_client_organization.client_organization_id关联比如总部可以看所有分支的数据,region只能看自己区域内的数据
     *
     * @return crew_organization_id - 组织机构级别,与t_client_organization.client_organization_id关联比如总部可以看所有分支的数据,region只能看自己区域内的数据
     */
    public Integer getOrganizationId() {
        return organizationId;
    }

    /**
     * 设置 组织机构级别,与t_client_organization.client_organization_id关联比如总部可以看所有分支的数据,region只能看自己区域内的数据
     *
     * @param organizationId - 组织机构级别,与t_client_organization.client_organization_id关联比如总部可以看所有分支的数据,region只能看自己区域内的数据
     */
    public CrewBean setOrganizationId(Integer organizationId) {
        this.organizationId = organizationId;
        return this;
    }

    /**
     * 获取 状态【ENABLE[启用]、DISABLE[禁用]】
     *
     * @return crew_status - 状态【ENABLE[启用]、DISABLE[禁用]】
     */
    public String getStatus() {
        return status;
    }

    /**
     * 设置 状态【ENABLE[启用]、DISABLE[禁用]】
     *
     * @param status - 状态【ENABLE[启用]、DISABLE[禁用]】
     */
    public CrewBean setStatus(String status) {
        this.status = status == null ? null : status.trim();
        return this;
    }

    /**
     * 获取 谁新增了该员工,与crew_username字段关联
     *
     * @return crew_create_by - 谁新增了该员工,与crew_username字段关联
     */
    public String getCreateBy() {
        return createBy;
    }

    /**
     * 设置 谁新增了该员工,与crew_username字段关联
     *
     * @param createBy - 谁新增了该员工,与crew_username字段关联
     */
    public CrewBean setCreateBy(String createBy) {
        this.createBy = createBy == null ? null : createBy.trim();
        return this;
    }

    /**
     * 获取 创建时间
     *
     * @return crew_create_timestamp - 创建时间
     */
    public Date getCreateTimestamp() {
        return createTimestamp;
    }

    /**
     * 设置 创建时间
     *
     * @param createTimestamp - 创建时间
     */
    public CrewBean setCreateTimestamp(Date createTimestamp) {
        this.createTimestamp = createTimestamp;
        return this;
    }

    /**
     * 获取 逻辑删除标志【N[正常],Y[删除]】
     *
     * @return crew_delete_flag - 逻辑删除标志【N[正常],Y[删除]】
     */
    public String getDeleteFlag() {
        return deleteFlag;
    }

    /**
     * 设置 逻辑删除标志【N[正常],Y[删除]】
     *
     * @param deleteFlag - 逻辑删除标志【N[正常],Y[删除]】
     */
    public CrewBean setDeleteFlag(String deleteFlag) {
        this.deleteFlag = deleteFlag == null ? null : deleteFlag.trim();
        return this;
    }
}