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
@Entity
@Table(name = "t_log")
public class LogBean implements Serializable {
    /**
     * <pre>
     * DB remark: 数据库主键ID
     * DB column: log_id	BIGINT(20)	<--->	id	java.lang.Long
     * DB is  Nullable: false
     * DB defaultValue: null
     * </pre>
     */
    @NotNull(message = "{LOG_BEAN_ID_NOT_NULL}", groups = {IBaseValidGroup.Add.class, IBaseValidGroup.Update.class})
    @ValidLength(max = 20, message = "{LOG_BEAN_ID_LENGTH}", groups = {IBaseValidGroup.Add.class, IBaseValidGroup.Update.class})
    @Id
    @Column(name = "log_id", length = 20, nullable = false)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    /**
     * <pre>
     * DB remark: 与t_crew or t_user.id冗余
     * DB column: log_user_id	BIGINT(20)	<--->	userId	java.lang.Long
     * DB is  Nullable: false
     * DB defaultValue: null
     * </pre>
     */
    @NotNull(message = "{LOG_BEAN_USER_ID_NOT_NULL}", groups = {IBaseValidGroup.Add.class, IBaseValidGroup.Update.class})
    @ValidLength(max = 20, message = "{LOG_BEAN_USER_ID_LENGTH}", groups = {IBaseValidGroup.Add.class, IBaseValidGroup.Update.class})
    @Column(name = "log_user_id", length = 20, nullable = false)
    private Long userId;

    /**
     * <pre>
     * DB remark: 用户名
     * DB column: log_username	VARCHAR(50)	<--->	username	java.lang.String
     * DB is  Nullable: false
     * DB defaultValue: null
     * </pre>
     */
    @NotBlank(message = "{LOG_BEAN_USERNAME_NOT_BLANK}", groups = {IBaseValidGroup.Add.class, IBaseValidGroup.Update.class})
    @Length(max = 50, message = "{LOG_BEAN_USERNAME_LENGTH}", groups = {IBaseValidGroup.Add.class, IBaseValidGroup.Update.class})
    @Column(name = "log_username", length = 50, nullable = false)
    private String username;

    /**
     * <pre>
     * DB remark: 用户的类型,员工为 CREW,用户为 USER
     * DB column: log_user_type	CHAR(4)	<--->	userType	java.lang.String
     * DB is  Nullable: false
     * DB defaultValue: null
     * </pre>
     */
    @NotBlank(message = "{LOG_BEAN_USER_TYPE_NOT_BLANK}", groups = {IBaseValidGroup.Add.class, IBaseValidGroup.Update.class})
    @Length(max = 4, message = "{LOG_BEAN_USER_TYPE_LENGTH}", groups = {IBaseValidGroup.Add.class, IBaseValidGroup.Update.class})
    @Column(name = "log_user_type", length = 4, nullable = false)
    private String userType;

    /**
     * <pre>
     * DB remark: 设备的类型,API为 API,门户为 WEB
     * DB column: log_device_type	CHAR(15)	<--->	deviceType	java.lang.String
     * DB is  Nullable: false
     * DB defaultValue: null
     * </pre>
     */
    @NotBlank(message = "{LOG_BEAN_DEVICE_TYPE_NOT_BLANK}", groups = {IBaseValidGroup.Add.class, IBaseValidGroup.Update.class})
    @Length(max = 15, message = "{LOG_BEAN_DEVICE_TYPE_LENGTH}", groups = {IBaseValidGroup.Add.class, IBaseValidGroup.Update.class})
    @Column(name = "log_device_type", length = 15, nullable = false)
    private String deviceType;

    /**
     * <pre>
     * DB remark: 操作的类型,登录为 LOGIN,退出为 LOGOUT,等等...
     * DB column: log_operate_type	CHAR(20)	<--->	operateType	java.lang.String
     * DB is  Nullable: false
     * DB defaultValue: null
     * </pre>
     */
    @NotBlank(message = "{LOG_BEAN_OPERATE_TYPE_NOT_BLANK}", groups = {IBaseValidGroup.Add.class, IBaseValidGroup.Update.class})
    @Length(max = 20, message = "{LOG_BEAN_OPERATE_TYPE_LENGTH}", groups = {IBaseValidGroup.Add.class, IBaseValidGroup.Update.class})
    @Column(name = "log_operate_type", length = 20, nullable = false)
    private String operateType;

    /**
     * <pre>
     * DB remark: 操作时间,
     * DB column: log_operate_time	TIMESTAMP(19)	<--->	operateTime	java.util.Date
     * DB is  Nullable: false
     * DB defaultValue: CURRENT_TIMESTAMP
     * </pre>
     */
    @ValidDateTimeFormat(pattern = DateUtil.DATE_PATTERN_YYYY_MM_DD_HH_MM_SS , message = "{LOG_BEAN_OPERATE_TIME_DATE_TIME_FORMAT}", groups = {IBaseValidGroup.Add.class, IBaseValidGroup.Update.class})
    @DateTimeFormat(pattern = DateUtil.DATE_PATTERN_YYYY_MM_DD_HH_MM_SS)
    @NotNull(message = "{LOG_BEAN_OPERATE_TIME_NOT_NULL}", groups = {IBaseValidGroup.Add.class, IBaseValidGroup.Update.class})
    @Column(name = "log_operate_time", length = 19, nullable = false)
    private Date operateTime;

    /**
     * <pre>
     * DB remark: comment
     * DB column: log_operate_comment	VARCHAR(80)	<--->	operateComment	java.lang.String
     * DB is  Nullable: true
     * DB defaultValue: null
     * </pre>
     */
    @Length(max = 80, message = "{LOG_BEAN_OPERATE_COMMENT_LENGTH}", groups = {IBaseValidGroup.Add.class, IBaseValidGroup.Update.class})
    @Column(name = "log_operate_comment", length = 80, nullable = true)
    private String operateComment;

    /**
     * <pre>
     * DB remark: 创建时间
     * DB column: log_create_timestamp	TIMESTAMP(19)	<--->	createTimestamp	java.util.Date
     * DB is  Nullable: false
     * DB defaultValue: CURRENT_TIMESTAMP
     * </pre>
     */
    @ValidDateTimeFormat(pattern = DateUtil.DATE_PATTERN_YYYY_MM_DD_HH_MM_SS , message = "{LOG_BEAN_CREATE_TIMESTAMP_DATE_TIME_FORMAT}", groups = {IBaseValidGroup.Add.class, IBaseValidGroup.Update.class})
    @DateTimeFormat(pattern = DateUtil.DATE_PATTERN_YYYY_MM_DD_HH_MM_SS)
    @NotNull(message = "{LOG_BEAN_CREATE_TIMESTAMP_NOT_NULL}", groups = {IBaseValidGroup.Add.class, IBaseValidGroup.Update.class})
    @Column(name = "log_create_timestamp", length = 19, nullable = false)
    private Date createTimestamp;

    /**
     * <pre>
     * DB remark: crew_username字段关联
     * DB column: log_create_by	VARCHAR(20)	<--->	createBy	java.lang.String
     * DB is  Nullable: false
     * DB defaultValue: null
     * </pre>
     */
    @NotBlank(message = "{LOG_BEAN_CREATE_BY_NOT_BLANK}", groups = {IBaseValidGroup.Add.class, IBaseValidGroup.Update.class})
    @Length(max = 20, message = "{LOG_BEAN_CREATE_BY_LENGTH}", groups = {IBaseValidGroup.Add.class, IBaseValidGroup.Update.class})
    @Column(name = "log_create_by", length = 20, nullable = false)
    private String createBy;

    /**
     * <pre>
     * DB remark: 逻辑删除标志【N[正常]，Y[删除]】
     * DB column: log_delete_flag	CHAR(1)	<--->	deleteFlag	java.lang.String
     * DB is  Nullable: false
     * DB defaultValue: N
     * </pre>
     */
    @NotBlank(message = "{LOG_BEAN_DELETE_FLAG_NOT_BLANK}", groups = {IBaseValidGroup.Add.class, IBaseValidGroup.Update.class})
    @Length(max = 1, message = "{LOG_BEAN_DELETE_FLAG_LENGTH}", groups = {IBaseValidGroup.Add.class, IBaseValidGroup.Update.class})
    @Column(name = "log_delete_flag", length = 1, nullable = false)
    private String deleteFlag;

    private static final long serialVersionUID = 1L;

    /**
     * 获取 数据库主键ID
     *
     * @return log_id - 数据库主键ID
     */
    public Long getId() {
        return id;
    }

    /**
     * 设置 数据库主键ID
     *
     * @param id - 数据库主键ID
     */
    public LogBean setId(Long id) {
        this.id = id;
        return this;
    }

    /**
     * 获取 与t_crew or t_user.id冗余
     *
     * @return log_user_id - 与t_crew or t_user.id冗余
     */
    public Long getUserId() {
        return userId;
    }

    /**
     * 设置 与t_crew or t_user.id冗余
     *
     * @param userId - 与t_crew or t_user.id冗余
     */
    public LogBean setUserId(Long userId) {
        this.userId = userId;
        return this;
    }

    /**
     * 获取 用户名
     *
     * @return log_username - 用户名
     */
    public String getUsername() {
        return username;
    }

    /**
     * 设置 用户名
     *
     * @param username - 用户名
     */
    public LogBean setUsername(String username) {
        this.username = username == null ? null : username.trim();
        return this;
    }

    /**
     * 获取 用户的类型,员工为 CREW,用户为 USER
     *
     * @return log_user_type - 用户的类型,员工为 CREW,用户为 USER
     */
    public String getUserType() {
        return userType;
    }

    /**
     * 设置 用户的类型,员工为 CREW,用户为 USER
     *
     * @param userType - 用户的类型,员工为 CREW,用户为 USER
     */
    public LogBean setUserType(String userType) {
        this.userType = userType == null ? null : userType.trim();
        return this;
    }

    /**
     * 获取 设备的类型,API为 API,门户为 WEB
     *
     * @return log_device_type - 设备的类型,API为 API,门户为 WEB
     */
    public String getDeviceType() {
        return deviceType;
    }

    /**
     * 设置 设备的类型,API为 API,门户为 WEB
     *
     * @param deviceType - 设备的类型,API为 API,门户为 WEB
     */
    public LogBean setDeviceType(String deviceType) {
        this.deviceType = deviceType == null ? null : deviceType.trim();
        return this;
    }

    /**
     * 获取 操作的类型,登录为 LOGIN,退出为 LOGOUT,等等...
     *
     * @return log_operate_type - 操作的类型,登录为 LOGIN,退出为 LOGOUT,等等...
     */
    public String getOperateType() {
        return operateType;
    }

    /**
     * 设置 操作的类型,登录为 LOGIN,退出为 LOGOUT,等等...
     *
     * @param operateType - 操作的类型,登录为 LOGIN,退出为 LOGOUT,等等...
     */
    public LogBean setOperateType(String operateType) {
        this.operateType = operateType == null ? null : operateType.trim();
        return this;
    }

    /**
     * 获取 操作时间,
     *
     * @return log_operate_time - 操作时间,
     */
    public Date getOperateTime() {
        return operateTime;
    }

    /**
     * 设置 操作时间,
     *
     * @param operateTime - 操作时间,
     */
    public LogBean setOperateTime(Date operateTime) {
        this.operateTime = operateTime;
        return this;
    }

    /**
     * 获取 comment
     *
     * @return log_operate_comment - comment
     */
    public String getOperateComment() {
        return operateComment;
    }

    /**
     * 设置 comment
     *
     * @param operateComment - comment
     */
    public LogBean setOperateComment(String operateComment) {
        this.operateComment = operateComment == null ? null : operateComment.trim();
        return this;
    }

    /**
     * 获取 创建时间
     *
     * @return log_create_timestamp - 创建时间
     */
    public Date getCreateTimestamp() {
        return createTimestamp;
    }

    /**
     * 设置 创建时间
     *
     * @param createTimestamp - 创建时间
     */
    public LogBean setCreateTimestamp(Date createTimestamp) {
        this.createTimestamp = createTimestamp;
        return this;
    }

    /**
     * 获取 crew_username字段关联
     *
     * @return log_create_by - crew_username字段关联
     */
    public String getCreateBy() {
        return createBy;
    }

    /**
     * 设置 crew_username字段关联
     *
     * @param createBy - crew_username字段关联
     */
    public LogBean setCreateBy(String createBy) {
        this.createBy = createBy == null ? null : createBy.trim();
        return this;
    }

    /**
     * 获取 逻辑删除标志【N[正常]，Y[删除]】
     *
     * @return log_delete_flag - 逻辑删除标志【N[正常]，Y[删除]】
     */
    public String getDeleteFlag() {
        return deleteFlag;
    }

    /**
     * 设置 逻辑删除标志【N[正常]，Y[删除]】
     *
     * @param deleteFlag - 逻辑删除标志【N[正常]，Y[删除]】
     */
    public LogBean setDeleteFlag(String deleteFlag) {
        this.deleteFlag = deleteFlag == null ? null : deleteFlag.trim();
        return this;
    }
}