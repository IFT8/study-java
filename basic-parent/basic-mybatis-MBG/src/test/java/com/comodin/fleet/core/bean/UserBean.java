package com.comodin.fleet.core.bean;

import com.comodin.basic.util.date.DateUtil;
import com.comodin.basic.validation.IBaseValidGroup;
import com.comodin.basic.validation.constraints.*;
import java.io.Serializable;
import java.util.Date;
import javax.persistence.*;
import javax.validation.constraints.*;
import org.hibernate.validator.constraints.*;
import org.springframework.format.annotation.DateTimeFormat;

@SuppressWarnings({"unused", "UnusedReturnValue", "SameParameterValue"})
@Table(name = "t_user")
public class UserBean implements Serializable {
    /**
     * <pre>
     * DB remark: 数据库主键ID
     * DB column: user_id	BIGINT(20)	<--->	id	java.lang.Long
     * DB is  Nullable: false
     * DB defaultValue: null
     * </pre>
     */
    @NotNull(message = "{USER_BEAN_ID_NOT_NULL}", groups = {IBaseValidGroup.Add.class, IBaseValidGroup.Update.class})
    @ValidLength(max = 20, message = "{USER_BEAN_ID_LENGTH}", groups = {IBaseValidGroup.Add.class, IBaseValidGroup.Update.class})
    @Id
    @Column(name = "user_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    /**
     * <pre>
     * DB remark: 用户登陆账号
     * DB column: user_username	VARCHAR(20)	<--->	username	java.lang.String
     * DB is  Nullable: false
     * DB defaultValue: null
     * </pre>
     */
    @NotBlank(message = "{USER_BEAN_USERNAME_NOT_BLANK}", groups = {IBaseValidGroup.Add.class, IBaseValidGroup.Update.class})
    @Length(max = 20, message = "{USER_BEAN_USERNAME_LENGTH}", groups = {IBaseValidGroup.Add.class, IBaseValidGroup.Update.class})
    @Column(name = "user_username")
    private String username;

    /**
     * <pre>
     * DB remark: 用户登陆密码,sha256加密
     * DB column: user_password	VARCHAR(64)	<--->	password	java.lang.String
     * DB is  Nullable: false
     * DB defaultValue: null
     * </pre>
     */
    @NotBlank(message = "{USER_BEAN_PASSWORD_NOT_BLANK}", groups = {IBaseValidGroup.Add.class, IBaseValidGroup.Update.class})
    @Length(max = 64, message = "{USER_BEAN_PASSWORD_LENGTH}", groups = {IBaseValidGroup.Add.class, IBaseValidGroup.Update.class})
    @Column(name = "user_password")
    private String password;

    /**
     * <pre>
     * DB remark: 密码加盐
     * DB column: user_password_salt	CHAR(8)	<--->	passwordSalt	java.lang.String
     * DB is  Nullable: false
     * DB defaultValue: null
     * </pre>
     */
    @NotBlank(message = "{USER_BEAN_PASSWORD_SALT_NOT_BLANK}", groups = {IBaseValidGroup.Add.class, IBaseValidGroup.Update.class})
    @Length(max = 8, message = "{USER_BEAN_PASSWORD_SALT_LENGTH}", groups = {IBaseValidGroup.Add.class, IBaseValidGroup.Update.class})
    @Column(name = "user_password_salt")
    private String passwordSalt;

    /**
     * <pre>
     * DB remark: 用户所属的网点ID,与 t_client_branch.branch_id 字段关联
     * DB column: user_branch_id	BIGINT(20)	<--->	branchId	java.lang.Long
     * DB is  Nullable: false
     * DB defaultValue: null
     * </pre>
     */
    @NotNull(message = "{USER_BEAN_BRANCH_ID_NOT_NULL}", groups = {IBaseValidGroup.Add.class, IBaseValidGroup.Update.class})
    @ValidLength(max = 20, message = "{USER_BEAN_BRANCH_ID_LENGTH}", groups = {IBaseValidGroup.Add.class, IBaseValidGroup.Update.class})
    @Column(name = "user_branch_id")
    private Long branchId;

    /**
     * <pre>
     * DB remark: 客户类型为[CLIENT]所属哪一个CIT的客户，与t_client.client_id 字段冗余，且类型为[CIT]；0为CIT
     * DB column: user_cit_id	BIGINT(20)	<--->	citId	java.lang.Long
     * DB is  Nullable: false
     * DB defaultValue: null
     * </pre>
     */
    @NotNull(message = "{USER_BEAN_CIT_ID_NOT_NULL}", groups = {IBaseValidGroup.Add.class, IBaseValidGroup.Update.class})
    @ValidLength(max = 20, message = "{USER_BEAN_CIT_ID_LENGTH}", groups = {IBaseValidGroup.Add.class, IBaseValidGroup.Update.class})
    @Column(name = "user_cit_id")
    private Long citId;

    /**
     * <pre>
     * DB remark: 姓名,名
     * DB column: user_first_name	VARCHAR(50)	<--->	firstName	java.lang.String
     * DB is  Nullable: true
     * DB defaultValue: null
     * </pre>
     */
    @Length(max = 50, message = "{USER_BEAN_FIRST_NAME_LENGTH}", groups = {IBaseValidGroup.Add.class, IBaseValidGroup.Update.class})
    @Column(name = "user_first_name")
    private String firstName;

    /**
     * <pre>
     * DB remark: 姓名,姓
     * DB column: user_last_name	VARCHAR(50)	<--->	lastName	java.lang.String
     * DB is  Nullable: true
     * DB defaultValue: null
     * </pre>
     */
    @Length(max = 50, message = "{USER_BEAN_LAST_NAME_LENGTH}", groups = {IBaseValidGroup.Add.class, IBaseValidGroup.Update.class})
    @Column(name = "user_last_name")
    private String lastName;

    /**
     * <pre>
     * DB remark: 手机号
     * DB column: user_phone	VARCHAR(15)	<--->	phone	java.lang.String
     * DB is  Nullable: true
     * DB defaultValue: null
     * </pre>
     */
    @Length(max = 15, message = "{USER_BEAN_PHONE_LENGTH}", groups = {IBaseValidGroup.Add.class, IBaseValidGroup.Update.class})
    @Column(name = "user_phone")
    private String phone;

    /**
     * <pre>
     * DB remark: 电子邮箱
     * DB column: user_email	VARCHAR(20)	<--->	email	java.lang.String
     * DB is  Nullable: true
     * DB defaultValue: null
     * </pre>
     */
    @Length(max = 20, message = "{USER_BEAN_EMAIL_LENGTH}", groups = {IBaseValidGroup.Add.class, IBaseValidGroup.Update.class})
    @Column(name = "user_email")
    private String email;

    /**
     * <pre>
     * DB remark: 性别
     * DB column: user_gender	CHAR(6)	<--->	gender	java.lang.String
     * DB is  Nullable: true
     * DB defaultValue: null
     * </pre>
     */
    @Length(max = 6, message = "{USER_BEAN_GENDER_LENGTH}", groups = {IBaseValidGroup.Add.class, IBaseValidGroup.Update.class})
    @Column(name = "user_gender")
    private String gender;

    /**
     * <pre>
     * DB remark: 生日
     * DB column: user_birthday	DATE(10)	<--->	birthday	java.util.Date
     * DB is  Nullable: true
     * DB defaultValue: null
     * </pre>
     */
    @ValidDateTimeFormat(pattern = DateUtil.DATE_PATTERN_YYYY_MM_DD , message = "{USER_BEAN_BIRTHDAY_DATE_TIME_FORMAT}", groups = {IBaseValidGroup.Add.class, IBaseValidGroup.Update.class})
    @DateTimeFormat(pattern = DateUtil.DATE_PATTERN_YYYY_MM_DD_HH_MM_SS)
    @Column(name = "user_birthday")
    private Date birthday;

    /**
     * <pre>
     * DB remark: 类似身份证号
     * DB column: user_curp_id	VARCHAR(20)	<--->	curpId	java.lang.String
     * DB is  Nullable: true
     * DB defaultValue: null
     * </pre>
     */
    @Length(max = 20, message = "{USER_BEAN_CURP_ID_LENGTH}", groups = {IBaseValidGroup.Add.class, IBaseValidGroup.Update.class})
    @Column(name = "user_curp_id")
    private String curpId;

    /**
     * <pre>
     * DB remark: 住址
     * DB column: user_address	VARCHAR(100)	<--->	address	java.lang.String
     * DB is  Nullable: true
     * DB defaultValue: null
     * </pre>
     */
    @Length(max = 100, message = "{USER_BEAN_ADDRESS_LENGTH}", groups = {IBaseValidGroup.Add.class, IBaseValidGroup.Update.class})
    @Column(name = "user_address")
    private String address;

    /**
     * <pre>
     * DB remark: 头像地址
     * DB column: user_photo	VARCHAR(100)	<--->	photo	java.lang.String
     * DB is  Nullable: true
     * DB defaultValue: null
     * </pre>
     */
    @Length(max = 100, message = "{USER_BEAN_PHOTO_LENGTH}", groups = {IBaseValidGroup.Add.class, IBaseValidGroup.Update.class})
    @Column(name = "user_photo")
    private String photo;

    /**
     * <pre>
     * DB remark: 简介
     * DB column: user_description	VARCHAR(300)	<--->	description	java.lang.String
     * DB is  Nullable: true
     * DB defaultValue: null
     * </pre>
     */
    @Length(max = 300, message = "{USER_BEAN_DESCRIPTION_LENGTH}", groups = {IBaseValidGroup.Add.class, IBaseValidGroup.Update.class})
    @Column(name = "user_description")
    private String description;

    /**
     * <pre>
     * DB remark: 最近登陆时间,每次登陆的时候更新一次
     * DB column: user_last_login_time	TIMESTAMP(19)	<--->	lastLoginTime	java.util.Date
     * DB is  Nullable: true
     * DB defaultValue: null
     * </pre>
     */
    @ValidDateTimeFormat(pattern = DateUtil.DATE_PATTERN_YYYY_MM_DD_HH_MM_SS , message = "{USER_BEAN_LAST_LOGIN_TIME_DATE_TIME_FORMAT}", groups = {IBaseValidGroup.Add.class, IBaseValidGroup.Update.class})
    @DateTimeFormat(pattern = DateUtil.DATE_PATTERN_YYYY_MM_DD_HH_MM_SS)
    @Column(name = "user_last_login_time")
    private Date lastLoginTime;

    /**
     * <pre>
     * DB remark: 最近登陆IP每次登陆的时候更新一次
     * DB column: user_last_login_ip	VARCHAR(20)	<--->	lastLoginIp	java.lang.String
     * DB is  Nullable: true
     * DB defaultValue: null
     * </pre>
     */
    @Length(max = 20, message = "{USER_BEAN_LAST_LOGIN_IP_LENGTH}", groups = {IBaseValidGroup.Add.class, IBaseValidGroup.Update.class})
    @Column(name = "user_last_login_ip")
    private String lastLoginIp;

    /**
     * <pre>
     * DB remark: 角色ID,【以1|2|3 表示对应表:角色表(t_role) 的 id】默认值:空字符串表示没有任何权限
     * DB column: user_roles	VARCHAR(50)	<--->	roles	java.lang.String
     * DB is  Nullable: true
     * DB defaultValue: 
     * </pre>
     */
    @Length(max = 50, message = "{USER_BEAN_ROLES_LENGTH}", groups = {IBaseValidGroup.Add.class, IBaseValidGroup.Update.class})
    @Column(name = "user_roles")
    private String roles;

    /**
     * <pre>
     * DB remark: 是否拥有NIP密码权限,Y有,N无
     * DB column: user_pass_code_enable	CHAR(1)	<--->	passCodeEnable	java.lang.String
     * DB is  Nullable: true
     * DB defaultValue: N
     * </pre>
     */
    @Length(max = 1, message = "{USER_BEAN_PASS_CODE_ENABLE_LENGTH}", groups = {IBaseValidGroup.Add.class, IBaseValidGroup.Update.class})
    @Column(name = "user_pass_code_enable")
    private String passCodeEnable;

    /**
     * <pre>
     * DB remark: nip用户确认签收密码,MD5加密之后
     * DB column: user_pass_code	VARCHAR(32)	<--->	passCode	java.lang.String
     * DB is  Nullable: true
     * DB defaultValue: 
     * </pre>
     */
    @Length(max = 32, message = "{USER_BEAN_PASS_CODE_LENGTH}", groups = {IBaseValidGroup.Add.class, IBaseValidGroup.Update.class})
    @Column(name = "user_pass_code")
    private String passCode;

    /**
     * <pre>
     * DB remark: 状态【ENABLE[启用]、DISABLE[禁用]】
     * DB column: user_status	CHAR(7)	<--->	status	java.lang.String
     * DB is  Nullable: false
     * DB defaultValue: ENABLE
     * </pre>
     */
    @NotBlank(message = "{USER_BEAN_STATUS_NOT_BLANK}", groups = {IBaseValidGroup.Add.class, IBaseValidGroup.Update.class})
    @Length(max = 7, message = "{USER_BEAN_STATUS_LENGTH}", groups = {IBaseValidGroup.Add.class, IBaseValidGroup.Update.class})
    @Column(name = "user_status")
    private String status;

    /**
     * <pre>
     * DB remark: 创建时间
     * DB column: user_create_timestamp	TIMESTAMP(19)	<--->	createTimestamp	java.util.Date
     * DB is  Nullable: false
     * DB defaultValue: CURRENT_TIMESTAMP
     * </pre>
     */
    @ValidDateTimeFormat(pattern = DateUtil.DATE_PATTERN_YYYY_MM_DD_HH_MM_SS , message = "{USER_BEAN_CREATE_TIMESTAMP_DATE_TIME_FORMAT}", groups = {IBaseValidGroup.Add.class, IBaseValidGroup.Update.class})
    @DateTimeFormat(pattern = DateUtil.DATE_PATTERN_YYYY_MM_DD_HH_MM_SS)
    @NotNull(message = "{USER_BEAN_CREATE_TIMESTAMP_NOT_NULL}", groups = {IBaseValidGroup.Add.class, IBaseValidGroup.Update.class})
    @Column(name = "user_create_timestamp")
    private Date createTimestamp;

    /**
     * <pre>
     * DB remark: 谁新增了该员工,与crew_username字段关联
     * DB column: user_create_by	VARCHAR(20)	<--->	createBy	java.lang.String
     * DB is  Nullable: false
     * DB defaultValue: null
     * </pre>
     */
    @NotBlank(message = "{USER_BEAN_CREATE_BY_NOT_BLANK}", groups = {IBaseValidGroup.Add.class, IBaseValidGroup.Update.class})
    @Length(max = 20, message = "{USER_BEAN_CREATE_BY_LENGTH}", groups = {IBaseValidGroup.Add.class, IBaseValidGroup.Update.class})
    @Column(name = "user_create_by")
    private String createBy;

    /**
     * <pre>
     * DB remark: 逻辑删除标志【N[正常]，Y[删除]】
     * DB column: user_delete_flag	CHAR(1)	<--->	deleteFlag	java.lang.String
     * DB is  Nullable: false
     * DB defaultValue: N
     * </pre>
     */
    @NotBlank(message = "{USER_BEAN_DELETE_FLAG_NOT_BLANK}", groups = {IBaseValidGroup.Add.class, IBaseValidGroup.Update.class})
    @Length(max = 1, message = "{USER_BEAN_DELETE_FLAG_LENGTH}", groups = {IBaseValidGroup.Add.class, IBaseValidGroup.Update.class})
    @Column(name = "user_delete_flag")
    private String deleteFlag;

    private static final long serialVersionUID = 1L;

    /**
     * 获取 数据库主键ID
     *
     * @return user_id - 数据库主键ID
     */
    public Long getId() {
        return id;
    }

    /**
     * 设置 数据库主键ID
     *
     * @param id - 数据库主键ID
     */
    public UserBean setId(Long id) {
        this.id = id;
        return this;
    }

    /**
     * 获取 用户登陆账号
     *
     * @return user_username - 用户登陆账号
     */
    public String getUsername() {
        return username;
    }

    /**
     * 设置 用户登陆账号
     *
     * @param username - 用户登陆账号
     */
    public UserBean setUsername(String username) {
        this.username = username == null ? null : username.trim();
        return this;
    }

    /**
     * 获取 用户登陆密码,sha256加密
     *
     * @return user_password - 用户登陆密码,sha256加密
     */
    public String getPassword() {
        return password;
    }

    /**
     * 设置 用户登陆密码,sha256加密
     *
     * @param password - 用户登陆密码,sha256加密
     */
    public UserBean setPassword(String password) {
        this.password = password == null ? null : password.trim();
        return this;
    }

    /**
     * 获取 密码加盐
     *
     * @return user_password_salt - 密码加盐
     */
    public String getPasswordSalt() {
        return passwordSalt;
    }

    /**
     * 设置 密码加盐
     *
     * @param passwordSalt - 密码加盐
     */
    public UserBean setPasswordSalt(String passwordSalt) {
        this.passwordSalt = passwordSalt == null ? null : passwordSalt.trim();
        return this;
    }

    /**
     * 获取 用户所属的网点ID,与 t_client_branch.branch_id 字段关联
     *
     * @return user_branch_id - 用户所属的网点ID,与 t_client_branch.branch_id 字段关联
     */
    public Long getBranchId() {
        return branchId;
    }

    /**
     * 设置 用户所属的网点ID,与 t_client_branch.branch_id 字段关联
     *
     * @param branchId - 用户所属的网点ID,与 t_client_branch.branch_id 字段关联
     */
    public UserBean setBranchId(Long branchId) {
        this.branchId = branchId;
        return this;
    }

    /**
     * 获取 客户类型为[CLIENT]所属哪一个CIT的客户，与t_client.client_id 字段冗余，且类型为[CIT]；0为CIT
     *
     * @return user_cit_id - 客户类型为[CLIENT]所属哪一个CIT的客户，与t_client.client_id 字段冗余，且类型为[CIT]；0为CIT
     */
    public Long getCitId() {
        return citId;
    }

    /**
     * 设置 客户类型为[CLIENT]所属哪一个CIT的客户，与t_client.client_id 字段冗余，且类型为[CIT]；0为CIT
     *
     * @param citId - 客户类型为[CLIENT]所属哪一个CIT的客户，与t_client.client_id 字段冗余，且类型为[CIT]；0为CIT
     */
    public UserBean setCitId(Long citId) {
        this.citId = citId;
        return this;
    }

    /**
     * 获取 姓名,名
     *
     * @return user_first_name - 姓名,名
     */
    public String getFirstName() {
        return firstName;
    }

    /**
     * 设置 姓名,名
     *
     * @param firstName - 姓名,名
     */
    public UserBean setFirstName(String firstName) {
        this.firstName = firstName == null ? null : firstName.trim();
        return this;
    }

    /**
     * 获取 姓名,姓
     *
     * @return user_last_name - 姓名,姓
     */
    public String getLastName() {
        return lastName;
    }

    /**
     * 设置 姓名,姓
     *
     * @param lastName - 姓名,姓
     */
    public UserBean setLastName(String lastName) {
        this.lastName = lastName == null ? null : lastName.trim();
        return this;
    }

    /**
     * 获取 手机号
     *
     * @return user_phone - 手机号
     */
    public String getPhone() {
        return phone;
    }

    /**
     * 设置 手机号
     *
     * @param phone - 手机号
     */
    public UserBean setPhone(String phone) {
        this.phone = phone == null ? null : phone.trim();
        return this;
    }

    /**
     * 获取 电子邮箱
     *
     * @return user_email - 电子邮箱
     */
    public String getEmail() {
        return email;
    }

    /**
     * 设置 电子邮箱
     *
     * @param email - 电子邮箱
     */
    public UserBean setEmail(String email) {
        this.email = email == null ? null : email.trim();
        return this;
    }

    /**
     * 获取 性别
     *
     * @return user_gender - 性别
     */
    public String getGender() {
        return gender;
    }

    /**
     * 设置 性别
     *
     * @param gender - 性别
     */
    public UserBean setGender(String gender) {
        this.gender = gender == null ? null : gender.trim();
        return this;
    }

    /**
     * 获取 生日
     *
     * @return user_birthday - 生日
     */
    public Date getBirthday() {
        return birthday;
    }

    /**
     * 设置 生日
     *
     * @param birthday - 生日
     */
    public UserBean setBirthday(Date birthday) {
        this.birthday = birthday;
        return this;
    }

    /**
     * 获取 类似身份证号
     *
     * @return user_curp_id - 类似身份证号
     */
    public String getCurpId() {
        return curpId;
    }

    /**
     * 设置 类似身份证号
     *
     * @param curpId - 类似身份证号
     */
    public UserBean setCurpId(String curpId) {
        this.curpId = curpId == null ? null : curpId.trim();
        return this;
    }

    /**
     * 获取 住址
     *
     * @return user_address - 住址
     */
    public String getAddress() {
        return address;
    }

    /**
     * 设置 住址
     *
     * @param address - 住址
     */
    public UserBean setAddress(String address) {
        this.address = address == null ? null : address.trim();
        return this;
    }

    /**
     * 获取 头像地址
     *
     * @return user_photo - 头像地址
     */
    public String getPhoto() {
        return photo;
    }

    /**
     * 设置 头像地址
     *
     * @param photo - 头像地址
     */
    public UserBean setPhoto(String photo) {
        this.photo = photo == null ? null : photo.trim();
        return this;
    }

    /**
     * 获取 简介
     *
     * @return user_description - 简介
     */
    public String getDescription() {
        return description;
    }

    /**
     * 设置 简介
     *
     * @param description - 简介
     */
    public UserBean setDescription(String description) {
        this.description = description == null ? null : description.trim();
        return this;
    }

    /**
     * 获取 最近登陆时间,每次登陆的时候更新一次
     *
     * @return user_last_login_time - 最近登陆时间,每次登陆的时候更新一次
     */
    public Date getLastLoginTime() {
        return lastLoginTime;
    }

    /**
     * 设置 最近登陆时间,每次登陆的时候更新一次
     *
     * @param lastLoginTime - 最近登陆时间,每次登陆的时候更新一次
     */
    public UserBean setLastLoginTime(Date lastLoginTime) {
        this.lastLoginTime = lastLoginTime;
        return this;
    }

    /**
     * 获取 最近登陆IP每次登陆的时候更新一次
     *
     * @return user_last_login_ip - 最近登陆IP每次登陆的时候更新一次
     */
    public String getLastLoginIp() {
        return lastLoginIp;
    }

    /**
     * 设置 最近登陆IP每次登陆的时候更新一次
     *
     * @param lastLoginIp - 最近登陆IP每次登陆的时候更新一次
     */
    public UserBean setLastLoginIp(String lastLoginIp) {
        this.lastLoginIp = lastLoginIp == null ? null : lastLoginIp.trim();
        return this;
    }

    /**
     * 获取 角色ID,【以1|2|3 表示对应表:角色表(t_role) 的 id】默认值:空字符串表示没有任何权限
     *
     * @return user_roles - 角色ID,【以1|2|3 表示对应表:角色表(t_role) 的 id】默认值:空字符串表示没有任何权限
     */
    public String getRoles() {
        return roles;
    }

    /**
     * 设置 角色ID,【以1|2|3 表示对应表:角色表(t_role) 的 id】默认值:空字符串表示没有任何权限
     *
     * @param roles - 角色ID,【以1|2|3 表示对应表:角色表(t_role) 的 id】默认值:空字符串表示没有任何权限
     */
    public UserBean setRoles(String roles) {
        this.roles = roles == null ? null : roles.trim();
        return this;
    }

    /**
     * 获取 是否拥有NIP密码权限,Y有,N无
     *
     * @return user_pass_code_enable - 是否拥有NIP密码权限,Y有,N无
     */
    public String getPassCodeEnable() {
        return passCodeEnable;
    }

    /**
     * 设置 是否拥有NIP密码权限,Y有,N无
     *
     * @param passCodeEnable - 是否拥有NIP密码权限,Y有,N无
     */
    public UserBean setPassCodeEnable(String passCodeEnable) {
        this.passCodeEnable = passCodeEnable == null ? null : passCodeEnable.trim();
        return this;
    }

    /**
     * 获取 nip用户确认签收密码,MD5加密之后
     *
     * @return user_pass_code - nip用户确认签收密码,MD5加密之后
     */
    public String getPassCode() {
        return passCode;
    }

    /**
     * 设置 nip用户确认签收密码,MD5加密之后
     *
     * @param passCode - nip用户确认签收密码,MD5加密之后
     */
    public UserBean setPassCode(String passCode) {
        this.passCode = passCode == null ? null : passCode.trim();
        return this;
    }

    /**
     * 获取 状态【ENABLE[启用]、DISABLE[禁用]】
     *
     * @return user_status - 状态【ENABLE[启用]、DISABLE[禁用]】
     */
    public String getStatus() {
        return status;
    }

    /**
     * 设置 状态【ENABLE[启用]、DISABLE[禁用]】
     *
     * @param status - 状态【ENABLE[启用]、DISABLE[禁用]】
     */
    public UserBean setStatus(String status) {
        this.status = status == null ? null : status.trim();
        return this;
    }

    /**
     * 获取 创建时间
     *
     * @return user_create_timestamp - 创建时间
     */
    public Date getCreateTimestamp() {
        return createTimestamp;
    }

    /**
     * 设置 创建时间
     *
     * @param createTimestamp - 创建时间
     */
    public UserBean setCreateTimestamp(Date createTimestamp) {
        this.createTimestamp = createTimestamp;
        return this;
    }

    /**
     * 获取 谁新增了该员工,与crew_username字段关联
     *
     * @return user_create_by - 谁新增了该员工,与crew_username字段关联
     */
    public String getCreateBy() {
        return createBy;
    }

    /**
     * 设置 谁新增了该员工,与crew_username字段关联
     *
     * @param createBy - 谁新增了该员工,与crew_username字段关联
     */
    public UserBean setCreateBy(String createBy) {
        this.createBy = createBy == null ? null : createBy.trim();
        return this;
    }

    /**
     * 获取 逻辑删除标志【N[正常]，Y[删除]】
     *
     * @return user_delete_flag - 逻辑删除标志【N[正常]，Y[删除]】
     */
    public String getDeleteFlag() {
        return deleteFlag;
    }

    /**
     * 设置 逻辑删除标志【N[正常]，Y[删除]】
     *
     * @param deleteFlag - 逻辑删除标志【N[正常]，Y[删除]】
     */
    public UserBean setDeleteFlag(String deleteFlag) {
        this.deleteFlag = deleteFlag == null ? null : deleteFlag.trim();
        return this;
    }
}