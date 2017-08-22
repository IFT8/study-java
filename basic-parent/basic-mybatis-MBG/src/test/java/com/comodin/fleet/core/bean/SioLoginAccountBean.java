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

@SuppressWarnings({"unused", "UnusedReturnValue", "SameParameterValue", "DefaultAnnotationParam"})
@Table(name = "t_sio_login_account")
public class SioLoginAccountBean implements Serializable {
    /**
     * <pre>
     * DB remark: 数据库主键ID
     * DB column: account_id	BIGINT(20)	<--->	id	java.lang.Long
     * DB is  Nullable: false
     * DB defaultValue: null
     * </pre>
     */
    @NotNull(message = "{SIO_LOGIN_ACCOUNT_BEAN_ID_NOT_NULL}", groups = {IBaseValidGroup.Add.class, IBaseValidGroup.Update.class})
    @ValidLength(max = 20, message = "{SIO_LOGIN_ACCOUNT_BEAN_ID_LENGTH}", groups = {IBaseValidGroup.Add.class, IBaseValidGroup.Update.class})
    @Id
    @Column(name = "account_id", length = 20, nullable = false)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    /**
     * <pre>
     * DB remark: sioWebServer,登陆接口,公司内部ID
     * DB column: account_company_internal_id	VARCHAR(15)	<--->	companyInternalId	java.lang.String
     * DB is  Nullable: false
     * DB defaultValue: null
     * </pre>
     */
    @NotBlank(message = "{SIO_LOGIN_ACCOUNT_BEAN_COMPANY_INTERNAL_ID_NOT_BLANK}", groups = {IBaseValidGroup.Add.class, IBaseValidGroup.Update.class})
    @Length(max = 15, message = "{SIO_LOGIN_ACCOUNT_BEAN_COMPANY_INTERNAL_ID_LENGTH}", groups = {IBaseValidGroup.Add.class, IBaseValidGroup.Update.class})
    @Column(name = "account_company_internal_id", length = 15, nullable = false)
    private String companyInternalId;

    /**
     * <pre>
     * DB remark: sioWebServer,登陆接口,公司名字
     * DB column: account_company_name	VARCHAR(50)	<--->	companyName	java.lang.String
     * DB is  Nullable: true
     * DB defaultValue: null
     * </pre>
     */
    @Length(max = 50, message = "{SIO_LOGIN_ACCOUNT_BEAN_COMPANY_NAME_LENGTH}", groups = {IBaseValidGroup.Add.class, IBaseValidGroup.Update.class})
    @Column(name = "account_company_name", length = 50, nullable = true)
    private String companyName;

    /**
     * <pre>
     * DB remark: sioWebServer,登陆接口,网点内部ID，此字段预留
     * DB column: account_branch_internal_id	VARCHAR(15)	<--->	branchInternalId	java.lang.String
     * DB is  Nullable: false
     * DB defaultValue: 
     * </pre>
     */
    @NotBlank(message = "{SIO_LOGIN_ACCOUNT_BEAN_BRANCH_INTERNAL_ID_NOT_BLANK}", groups = {IBaseValidGroup.Add.class, IBaseValidGroup.Update.class})
    @Length(max = 15, message = "{SIO_LOGIN_ACCOUNT_BEAN_BRANCH_INTERNAL_ID_LENGTH}", groups = {IBaseValidGroup.Add.class, IBaseValidGroup.Update.class})
    @Column(name = "account_branch_internal_id", length = 15, nullable = false)
    private String branchInternalId;

    /**
     * <pre>
     * DB remark: sioWebServer,登陆接口,网点名字，此字段预留
     * DB column: account_branch_name	VARCHAR(15)	<--->	branchName	java.lang.String
     * DB is  Nullable: true
     * DB defaultValue: null
     * </pre>
     */
    @Length(max = 15, message = "{SIO_LOGIN_ACCOUNT_BEAN_BRANCH_NAME_LENGTH}", groups = {IBaseValidGroup.Add.class, IBaseValidGroup.Update.class})
    @Column(name = "account_branch_name", length = 15, nullable = true)
    private String branchName;

    /**
     * <pre>
     * DB remark: sioWebServer,登陆接口,用户名
     * DB column: account_username	VARCHAR(20)	<--->	username	java.lang.String
     * DB is  Nullable: false
     * DB defaultValue: null
     * </pre>
     */
    @NotBlank(message = "{SIO_LOGIN_ACCOUNT_BEAN_USERNAME_NOT_BLANK}", groups = {IBaseValidGroup.Add.class, IBaseValidGroup.Update.class})
    @Length(max = 20, message = "{SIO_LOGIN_ACCOUNT_BEAN_USERNAME_LENGTH}", groups = {IBaseValidGroup.Add.class, IBaseValidGroup.Update.class})
    @Column(name = "account_username", length = 20, nullable = false)
    private String username;

    /**
     * <pre>
     * DB remark: sioWebServer,登陆接口,密码
     * DB column: account_password	VARCHAR(20)	<--->	password	java.lang.String
     * DB is  Nullable: true
     * DB defaultValue: null
     * </pre>
     */
    @Length(max = 20, message = "{SIO_LOGIN_ACCOUNT_BEAN_PASSWORD_LENGTH}", groups = {IBaseValidGroup.Add.class, IBaseValidGroup.Update.class})
    @Column(name = "account_password", length = 20, nullable = true)
    private String password;

    /**
     * <pre>
     * DB remark: sioWebServer,登陆接口,URL
     * DB column: account_login_url	VARCHAR(100)	<--->	loginUrl	java.lang.String
     * DB is  Nullable: false
     * DB defaultValue: http://189.240.94.180:8090/CompSegWebSrv/rest/login
     * </pre>
     */
    @NotBlank(message = "{SIO_LOGIN_ACCOUNT_BEAN_LOGIN_URL_NOT_BLANK}", groups = {IBaseValidGroup.Add.class, IBaseValidGroup.Update.class})
    @Length(max = 100, message = "{SIO_LOGIN_ACCOUNT_BEAN_LOGIN_URL_LENGTH}", groups = {IBaseValidGroup.Add.class, IBaseValidGroup.Update.class})
    @Column(name = "account_login_url", length = 100, nullable = false)
    private String loginUrl;

    /**
     * <pre>
     * DB remark: sioWebServer,登陆接口,公司内部ID，KEY
     * DB column: account_key_login_company_internal_id	VARCHAR(20)	<--->	keyLoginCompanyInternalId	java.lang.String
     * DB is  Nullable: false
     * DB defaultValue: company
     * </pre>
     */
    @NotBlank(message = "{SIO_LOGIN_ACCOUNT_BEAN_KEY_LOGIN_COMPANY_INTERNAL_ID_NOT_BLANK}", groups = {IBaseValidGroup.Add.class, IBaseValidGroup.Update.class})
    @Length(max = 20, message = "{SIO_LOGIN_ACCOUNT_BEAN_KEY_LOGIN_COMPANY_INTERNAL_ID_LENGTH}", groups = {IBaseValidGroup.Add.class, IBaseValidGroup.Update.class})
    @Column(name = "account_key_login_company_internal_id", length = 20, nullable = false)
    private String keyLoginCompanyInternalId;

    /**
     * <pre>
     * DB remark: sioWebServer,登陆接口,网点内部ID，KEY
     * DB column: account_key_login_branch_internal_id	VARCHAR(20)	<--->	keyLoginBranchInternalId	java.lang.String
     * DB is  Nullable: false
     * DB defaultValue: branch
     * </pre>
     */
    @NotBlank(message = "{SIO_LOGIN_ACCOUNT_BEAN_KEY_LOGIN_BRANCH_INTERNAL_ID_NOT_BLANK}", groups = {IBaseValidGroup.Add.class, IBaseValidGroup.Update.class})
    @Length(max = 20, message = "{SIO_LOGIN_ACCOUNT_BEAN_KEY_LOGIN_BRANCH_INTERNAL_ID_LENGTH}", groups = {IBaseValidGroup.Add.class, IBaseValidGroup.Update.class})
    @Column(name = "account_key_login_branch_internal_id", length = 20, nullable = false)
    private String keyLoginBranchInternalId;

    /**
     * <pre>
     * DB remark: sioWebServer,登陆接口,用户名，KEY
     * DB column: account_key_login_username	VARCHAR(20)	<--->	keyLoginUsername	java.lang.String
     * DB is  Nullable: false
     * DB defaultValue: user
     * </pre>
     */
    @NotBlank(message = "{SIO_LOGIN_ACCOUNT_BEAN_KEY_LOGIN_USERNAME_NOT_BLANK}", groups = {IBaseValidGroup.Add.class, IBaseValidGroup.Update.class})
    @Length(max = 20, message = "{SIO_LOGIN_ACCOUNT_BEAN_KEY_LOGIN_USERNAME_LENGTH}", groups = {IBaseValidGroup.Add.class, IBaseValidGroup.Update.class})
    @Column(name = "account_key_login_username", length = 20, nullable = false)
    private String keyLoginUsername;

    /**
     * <pre>
     * DB remark: sioWebServer,登陆接口,密码，KEY
     * DB column: account_key_login_password	VARCHAR(20)	<--->	keyLoginPassword	java.lang.String
     * DB is  Nullable: false
     * DB defaultValue: pwd
     * </pre>
     */
    @NotBlank(message = "{SIO_LOGIN_ACCOUNT_BEAN_KEY_LOGIN_PASSWORD_NOT_BLANK}", groups = {IBaseValidGroup.Add.class, IBaseValidGroup.Update.class})
    @Length(max = 20, message = "{SIO_LOGIN_ACCOUNT_BEAN_KEY_LOGIN_PASSWORD_LENGTH}", groups = {IBaseValidGroup.Add.class, IBaseValidGroup.Update.class})
    @Column(name = "account_key_login_password", length = 20, nullable = false)
    private String keyLoginPassword;

    /**
     * <pre>
     * DB remark: 票据类型，预留字段2016-12-20 by:supeng
     * DB column: account_upload_data_url	VARCHAR(100)	<--->	uploadDataUrl	java.lang.String
     * DB is  Nullable: false
     * DB defaultValue: http://189.240.94.180:8090/CompSegWebSrv/rest/fileUpload
     * </pre>
     */
    @NotBlank(message = "{SIO_LOGIN_ACCOUNT_BEAN_UPLOAD_DATA_URL_NOT_BLANK}", groups = {IBaseValidGroup.Add.class, IBaseValidGroup.Update.class})
    @Length(max = 100, message = "{SIO_LOGIN_ACCOUNT_BEAN_UPLOAD_DATA_URL_LENGTH}", groups = {IBaseValidGroup.Add.class, IBaseValidGroup.Update.class})
    @Column(name = "account_upload_data_url", length = 100, nullable = false)
    private String uploadDataUrl;

    /**
     * <pre>
     * DB remark: sioWebServer,登陆接口,URL
     * DB column: account_key_upload_data_file	VARCHAR(20)	<--->	keyUploadDataFile	java.lang.String
     * DB is  Nullable: false
     * DB defaultValue: file
     * </pre>
     */
    @NotBlank(message = "{SIO_LOGIN_ACCOUNT_BEAN_KEY_UPLOAD_DATA_FILE_NOT_BLANK}", groups = {IBaseValidGroup.Add.class, IBaseValidGroup.Update.class})
    @Length(max = 20, message = "{SIO_LOGIN_ACCOUNT_BEAN_KEY_UPLOAD_DATA_FILE_LENGTH}", groups = {IBaseValidGroup.Add.class, IBaseValidGroup.Update.class})
    @Column(name = "account_key_upload_data_file", length = 20, nullable = false)
    private String keyUploadDataFile;

    /**
     * <pre>
     * DB remark: sioWebServer,登陆接口,URL
     * DB column: account_key_upload_data_token	VARCHAR(20)	<--->	keyUploadDataToken	java.lang.String
     * DB is  Nullable: false
     * DB defaultValue: token
     * </pre>
     */
    @NotBlank(message = "{SIO_LOGIN_ACCOUNT_BEAN_KEY_UPLOAD_DATA_TOKEN_NOT_BLANK}", groups = {IBaseValidGroup.Add.class, IBaseValidGroup.Update.class})
    @Length(max = 20, message = "{SIO_LOGIN_ACCOUNT_BEAN_KEY_UPLOAD_DATA_TOKEN_LENGTH}", groups = {IBaseValidGroup.Add.class, IBaseValidGroup.Update.class})
    @Column(name = "account_key_upload_data_token", length = 20, nullable = false)
    private String keyUploadDataToken;

    /**
     * <pre>
     * DB remark: 状态【ENABLE[启用]、DISABLE[禁用]】
     * DB column: account_status	CHAR(7)	<--->	status	java.lang.String
     * DB is  Nullable: false
     * DB defaultValue: ENABLE
     * </pre>
     */
    @NotBlank(message = "{SIO_LOGIN_ACCOUNT_BEAN_STATUS_NOT_BLANK}", groups = {IBaseValidGroup.Add.class, IBaseValidGroup.Update.class})
    @Length(max = 7, message = "{SIO_LOGIN_ACCOUNT_BEAN_STATUS_LENGTH}", groups = {IBaseValidGroup.Add.class, IBaseValidGroup.Update.class})
    @Column(name = "account_status", length = 7, nullable = false)
    private String status;

    /**
     * <pre>
     * DB remark: 创建时间
     * DB column: account_create_timestamp	TIMESTAMP(19)	<--->	createTimestamp	java.util.Date
     * DB is  Nullable: false
     * DB defaultValue: CURRENT_TIMESTAMP
     * </pre>
     */
    @ValidDateTimeFormat(pattern = DateUtil.DATE_PATTERN_YYYY_MM_DD_HH_MM_SS , message = "{SIO_LOGIN_ACCOUNT_BEAN_CREATE_TIMESTAMP_DATE_TIME_FORMAT}", groups = {IBaseValidGroup.Add.class, IBaseValidGroup.Update.class})
    @DateTimeFormat(pattern = DateUtil.DATE_PATTERN_YYYY_MM_DD_HH_MM_SS)
    @NotNull(message = "{SIO_LOGIN_ACCOUNT_BEAN_CREATE_TIMESTAMP_NOT_NULL}", groups = {IBaseValidGroup.Add.class, IBaseValidGroup.Update.class})
    @Column(name = "account_create_timestamp", length = 19, nullable = false)
    private Date createTimestamp;

    /**
     * <pre>
     * DB remark: 谁新增了该员工,与crew_username字段关联
     * DB column: account_create_by	VARCHAR(20)	<--->	createBy	java.lang.String
     * DB is  Nullable: false
     * DB defaultValue: SYSTEM
     * </pre>
     */
    @NotBlank(message = "{SIO_LOGIN_ACCOUNT_BEAN_CREATE_BY_NOT_BLANK}", groups = {IBaseValidGroup.Add.class, IBaseValidGroup.Update.class})
    @Length(max = 20, message = "{SIO_LOGIN_ACCOUNT_BEAN_CREATE_BY_LENGTH}", groups = {IBaseValidGroup.Add.class, IBaseValidGroup.Update.class})
    @Column(name = "account_create_by", length = 20, nullable = false)
    private String createBy;

    /**
     * <pre>
     * DB remark: 逻辑删除标志【N[正常]，Y[删除]】
     * DB column: account_delete_flag	CHAR(1)	<--->	deleteFlag	java.lang.String
     * DB is  Nullable: false
     * DB defaultValue: N
     * </pre>
     */
    @NotBlank(message = "{SIO_LOGIN_ACCOUNT_BEAN_DELETE_FLAG_NOT_BLANK}", groups = {IBaseValidGroup.Add.class, IBaseValidGroup.Update.class})
    @Length(max = 1, message = "{SIO_LOGIN_ACCOUNT_BEAN_DELETE_FLAG_LENGTH}", groups = {IBaseValidGroup.Add.class, IBaseValidGroup.Update.class})
    @Column(name = "account_delete_flag", length = 1, nullable = false)
    private String deleteFlag;

    private static final long serialVersionUID = 1L;

    /**
     * 获取 数据库主键ID
     *
     * @return account_id - 数据库主键ID
     */
    public Long getId() {
        return id;
    }

    /**
     * 设置 数据库主键ID
     *
     * @param id - 数据库主键ID
     */
    public SioLoginAccountBean setId(Long id) {
        this.id = id;
        return this;
    }

    /**
     * 获取 sioWebServer,登陆接口,公司内部ID
     *
     * @return account_company_internal_id - sioWebServer,登陆接口,公司内部ID
     */
    public String getCompanyInternalId() {
        return companyInternalId;
    }

    /**
     * 设置 sioWebServer,登陆接口,公司内部ID
     *
     * @param companyInternalId - sioWebServer,登陆接口,公司内部ID
     */
    public SioLoginAccountBean setCompanyInternalId(String companyInternalId) {
        this.companyInternalId = companyInternalId == null ? null : companyInternalId.trim();
        return this;
    }

    /**
     * 获取 sioWebServer,登陆接口,公司名字
     *
     * @return account_company_name - sioWebServer,登陆接口,公司名字
     */
    public String getCompanyName() {
        return companyName;
    }

    /**
     * 设置 sioWebServer,登陆接口,公司名字
     *
     * @param companyName - sioWebServer,登陆接口,公司名字
     */
    public SioLoginAccountBean setCompanyName(String companyName) {
        this.companyName = companyName == null ? null : companyName.trim();
        return this;
    }

    /**
     * 获取 sioWebServer,登陆接口,网点内部ID，此字段预留
     *
     * @return account_branch_internal_id - sioWebServer,登陆接口,网点内部ID，此字段预留
     */
    public String getBranchInternalId() {
        return branchInternalId;
    }

    /**
     * 设置 sioWebServer,登陆接口,网点内部ID，此字段预留
     *
     * @param branchInternalId - sioWebServer,登陆接口,网点内部ID，此字段预留
     */
    public SioLoginAccountBean setBranchInternalId(String branchInternalId) {
        this.branchInternalId = branchInternalId == null ? null : branchInternalId.trim();
        return this;
    }

    /**
     * 获取 sioWebServer,登陆接口,网点名字，此字段预留
     *
     * @return account_branch_name - sioWebServer,登陆接口,网点名字，此字段预留
     */
    public String getBranchName() {
        return branchName;
    }

    /**
     * 设置 sioWebServer,登陆接口,网点名字，此字段预留
     *
     * @param branchName - sioWebServer,登陆接口,网点名字，此字段预留
     */
    public SioLoginAccountBean setBranchName(String branchName) {
        this.branchName = branchName == null ? null : branchName.trim();
        return this;
    }

    /**
     * 获取 sioWebServer,登陆接口,用户名
     *
     * @return account_username - sioWebServer,登陆接口,用户名
     */
    public String getUsername() {
        return username;
    }

    /**
     * 设置 sioWebServer,登陆接口,用户名
     *
     * @param username - sioWebServer,登陆接口,用户名
     */
    public SioLoginAccountBean setUsername(String username) {
        this.username = username == null ? null : username.trim();
        return this;
    }

    /**
     * 获取 sioWebServer,登陆接口,密码
     *
     * @return account_password - sioWebServer,登陆接口,密码
     */
    public String getPassword() {
        return password;
    }

    /**
     * 设置 sioWebServer,登陆接口,密码
     *
     * @param password - sioWebServer,登陆接口,密码
     */
    public SioLoginAccountBean setPassword(String password) {
        this.password = password == null ? null : password.trim();
        return this;
    }

    /**
     * 获取 sioWebServer,登陆接口,URL
     *
     * @return account_login_url - sioWebServer,登陆接口,URL
     */
    public String getLoginUrl() {
        return loginUrl;
    }

    /**
     * 设置 sioWebServer,登陆接口,URL
     *
     * @param loginUrl - sioWebServer,登陆接口,URL
     */
    public SioLoginAccountBean setLoginUrl(String loginUrl) {
        this.loginUrl = loginUrl == null ? null : loginUrl.trim();
        return this;
    }

    /**
     * 获取 sioWebServer,登陆接口,公司内部ID，KEY
     *
     * @return account_key_login_company_internal_id - sioWebServer,登陆接口,公司内部ID，KEY
     */
    public String getKeyLoginCompanyInternalId() {
        return keyLoginCompanyInternalId;
    }

    /**
     * 设置 sioWebServer,登陆接口,公司内部ID，KEY
     *
     * @param keyLoginCompanyInternalId - sioWebServer,登陆接口,公司内部ID，KEY
     */
    public SioLoginAccountBean setKeyLoginCompanyInternalId(String keyLoginCompanyInternalId) {
        this.keyLoginCompanyInternalId = keyLoginCompanyInternalId == null ? null : keyLoginCompanyInternalId.trim();
        return this;
    }

    /**
     * 获取 sioWebServer,登陆接口,网点内部ID，KEY
     *
     * @return account_key_login_branch_internal_id - sioWebServer,登陆接口,网点内部ID，KEY
     */
    public String getKeyLoginBranchInternalId() {
        return keyLoginBranchInternalId;
    }

    /**
     * 设置 sioWebServer,登陆接口,网点内部ID，KEY
     *
     * @param keyLoginBranchInternalId - sioWebServer,登陆接口,网点内部ID，KEY
     */
    public SioLoginAccountBean setKeyLoginBranchInternalId(String keyLoginBranchInternalId) {
        this.keyLoginBranchInternalId = keyLoginBranchInternalId == null ? null : keyLoginBranchInternalId.trim();
        return this;
    }

    /**
     * 获取 sioWebServer,登陆接口,用户名，KEY
     *
     * @return account_key_login_username - sioWebServer,登陆接口,用户名，KEY
     */
    public String getKeyLoginUsername() {
        return keyLoginUsername;
    }

    /**
     * 设置 sioWebServer,登陆接口,用户名，KEY
     *
     * @param keyLoginUsername - sioWebServer,登陆接口,用户名，KEY
     */
    public SioLoginAccountBean setKeyLoginUsername(String keyLoginUsername) {
        this.keyLoginUsername = keyLoginUsername == null ? null : keyLoginUsername.trim();
        return this;
    }

    /**
     * 获取 sioWebServer,登陆接口,密码，KEY
     *
     * @return account_key_login_password - sioWebServer,登陆接口,密码，KEY
     */
    public String getKeyLoginPassword() {
        return keyLoginPassword;
    }

    /**
     * 设置 sioWebServer,登陆接口,密码，KEY
     *
     * @param keyLoginPassword - sioWebServer,登陆接口,密码，KEY
     */
    public SioLoginAccountBean setKeyLoginPassword(String keyLoginPassword) {
        this.keyLoginPassword = keyLoginPassword == null ? null : keyLoginPassword.trim();
        return this;
    }

    /**
     * 获取 票据类型，预留字段2016-12-20 by:supeng
     *
     * @return account_upload_data_url - 票据类型，预留字段2016-12-20 by:supeng
     */
    public String getUploadDataUrl() {
        return uploadDataUrl;
    }

    /**
     * 设置 票据类型，预留字段2016-12-20 by:supeng
     *
     * @param uploadDataUrl - 票据类型，预留字段2016-12-20 by:supeng
     */
    public SioLoginAccountBean setUploadDataUrl(String uploadDataUrl) {
        this.uploadDataUrl = uploadDataUrl == null ? null : uploadDataUrl.trim();
        return this;
    }

    /**
     * 获取 sioWebServer,登陆接口,URL
     *
     * @return account_key_upload_data_file - sioWebServer,登陆接口,URL
     */
    public String getKeyUploadDataFile() {
        return keyUploadDataFile;
    }

    /**
     * 设置 sioWebServer,登陆接口,URL
     *
     * @param keyUploadDataFile - sioWebServer,登陆接口,URL
     */
    public SioLoginAccountBean setKeyUploadDataFile(String keyUploadDataFile) {
        this.keyUploadDataFile = keyUploadDataFile == null ? null : keyUploadDataFile.trim();
        return this;
    }

    /**
     * 获取 sioWebServer,登陆接口,URL
     *
     * @return account_key_upload_data_token - sioWebServer,登陆接口,URL
     */
    public String getKeyUploadDataToken() {
        return keyUploadDataToken;
    }

    /**
     * 设置 sioWebServer,登陆接口,URL
     *
     * @param keyUploadDataToken - sioWebServer,登陆接口,URL
     */
    public SioLoginAccountBean setKeyUploadDataToken(String keyUploadDataToken) {
        this.keyUploadDataToken = keyUploadDataToken == null ? null : keyUploadDataToken.trim();
        return this;
    }

    /**
     * 获取 状态【ENABLE[启用]、DISABLE[禁用]】
     *
     * @return account_status - 状态【ENABLE[启用]、DISABLE[禁用]】
     */
    public String getStatus() {
        return status;
    }

    /**
     * 设置 状态【ENABLE[启用]、DISABLE[禁用]】
     *
     * @param status - 状态【ENABLE[启用]、DISABLE[禁用]】
     */
    public SioLoginAccountBean setStatus(String status) {
        this.status = status == null ? null : status.trim();
        return this;
    }

    /**
     * 获取 创建时间
     *
     * @return account_create_timestamp - 创建时间
     */
    public Date getCreateTimestamp() {
        return createTimestamp;
    }

    /**
     * 设置 创建时间
     *
     * @param createTimestamp - 创建时间
     */
    public SioLoginAccountBean setCreateTimestamp(Date createTimestamp) {
        this.createTimestamp = createTimestamp;
        return this;
    }

    /**
     * 获取 谁新增了该员工,与crew_username字段关联
     *
     * @return account_create_by - 谁新增了该员工,与crew_username字段关联
     */
    public String getCreateBy() {
        return createBy;
    }

    /**
     * 设置 谁新增了该员工,与crew_username字段关联
     *
     * @param createBy - 谁新增了该员工,与crew_username字段关联
     */
    public SioLoginAccountBean setCreateBy(String createBy) {
        this.createBy = createBy == null ? null : createBy.trim();
        return this;
    }

    /**
     * 获取 逻辑删除标志【N[正常]，Y[删除]】
     *
     * @return account_delete_flag - 逻辑删除标志【N[正常]，Y[删除]】
     */
    public String getDeleteFlag() {
        return deleteFlag;
    }

    /**
     * 设置 逻辑删除标志【N[正常]，Y[删除]】
     *
     * @param deleteFlag - 逻辑删除标志【N[正常]，Y[删除]】
     */
    public SioLoginAccountBean setDeleteFlag(String deleteFlag) {
        this.deleteFlag = deleteFlag == null ? null : deleteFlag.trim();
        return this;
    }
}