package com.comodin.fleet.bean;

import com.comodin.basic.util.date.DateUtil;
import com.comodin.basic.validation.IBaseValidGroup;
import com.comodin.basic.validation.constraints.ValidAllowData;
import com.comodin.basic.validation.constraints.ValidDateTimeFormat;
import com.comodin.basic.validation.constraints.ValidLength;
import com.comodin.fleet.constant.CrewBeanConstant;
import org.hibernate.validator.constraints.Email;
import org.hibernate.validator.constraints.Length;
import org.hibernate.validator.constraints.NotBlank;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.io.Serializable;
import java.util.Date;

@SuppressWarnings("unused")
@Table(name = "t_crew")
public class CrewBean implements Serializable {
    /**
     * <pre>
     * DB remark: 数据库主键ID{"max":13}
     * DB column: crew_id	BIGINT(20)	<--->	id	java.lang.Long
     * DB is  Nullable: false
     * DB defaultValue: null
     * </pre>
     */
    @NotNull(message = "{CREW_BEAN_ID_NOT_NULL}", groups = {IBaseValidGroup.Add.class, IBaseValidGroup.Update.class})
    @ValidLength(max = 13, message = "{CREW_BEAN_ID_LENGTH}", groups = {IBaseValidGroup.Add.class, IBaseValidGroup.Update.class})
    @Id
    @Column(name = "crew_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    /**
     * <pre>
     * DB remark: 员工内部编号{"min":3}
     * DB column: crew_internal_id	VARCHAR(15)	<--->	internalId	java.lang.String
     * DB is  Nullable: true
     * DB defaultValue: null
     * </pre>
     */
    @Length(min = 3, max = 15, message = "{CREW_BEAN_INTERNAL_ID_LENGTH}", groups = {IBaseValidGroup.Add.class, IBaseValidGroup.Update.class})
    @Column(name = "crew_internal_id")
    private String internalId;

    /**
     * <pre>
     * DB remark: 员工登陆账号{"min":3}
     * DB column: crew_username	VARCHAR(20)	<--->	username	java.lang.String
     * DB is  Nullable: false
     * DB defaultValue: null
     * </pre>
     */
    @NotBlank(message = "{CREW_BEAN_USERNAME_NOT_BLANK}", groups = {IBaseValidGroup.Add.class, IBaseValidGroup.Update.class})
    @Length(min = 3, max = 20, message = "{CREW_BEAN_USERNAME_LENGTH}", groups = {IBaseValidGroup.Add.class, IBaseValidGroup.Update.class})
    @Column(name = "crew_username")
    private String username;

    /**
     * <pre>
     * DB remark: 员工所属的网点ID,与 t_client_branch.branch_id 字段关联
     * DB column: crew_branch_id	BIGINT(20)	<--->	branchId	java.lang.Long
     * DB is  Nullable: false
     * DB defaultValue: null
     * </pre>
     */
    @NotNull(message = "{CREW_BEAN_BRANCH_ID_NOT_NULL}", groups = {IBaseValidGroup.Add.class, IBaseValidGroup.Update.class})
    @ValidLength(max = 20, message = "{CREW_BEAN_BRANCH_ID_LENGTH}", groups = {IBaseValidGroup.Add.class, IBaseValidGroup.Update.class})
    @Column(name = "crew_branch_id")
    private Long branchId;

    /**
     * <pre>
     * DB remark: 电子邮箱 {"email":true}
     * DB column: crew_email	VARCHAR(45)	<--->	email	java.lang.String
     * DB is  Nullable: true
     * DB defaultValue: null
     * </pre>
     */
    @Email(message = "{CREW_BEAN_EMAIL_EMAIL}", groups = {IBaseValidGroup.Add.class, IBaseValidGroup.Update.class})
    @Length(max = 45, message = "{CREW_BEAN_EMAIL_LENGTH}", groups = {IBaseValidGroup.Add.class, IBaseValidGroup.Update.class})
    @Column(name = "crew_email")
    private String email;

    /**
     * <pre>
     * DB remark: 生日 {"pattern":"yyyy-MM-dd"]
     * DB column: crew_birthday	DATE(10)	<--->	birthday	java.util.Date
     * DB is  Nullable: true
     * DB defaultValue: null
     * </pre>
     */
    @ValidDateTimeFormat(pattern = DateUtil.DATE_PATTERN_YYYY_MM_DD, message = "{CREW_BEAN_BIRTHDAY_DATE_TIME_FORMAT}", groups = {IBaseValidGroup.Add.class, IBaseValidGroup.Update.class})
    @Column(name = "crew_birthday")
    private Date birthday;

    /**
     * <pre>
     * DB remark: 状态【ENABLE[启用]、DISABLE[禁用]】{"dataList":["ENABLE","DISABLE"]}
     * DB column: crew_status	CHAR(7)	<--->	status	java.lang.String
     * DB is  Nullable: false
     * DB defaultValue: ENABLE
     * </pre>
     */
    @ValidAllowData(allowDataArray = {CrewBeanConstant.CREW_BEAN_STATUS_DISABLE, CrewBeanConstant.CREW_BEAN_STATUS_ENABLE}, message = "{CREW_BEAN_STATUS_ALLOW_DATA}", groups = {IBaseValidGroup.Add.class, IBaseValidGroup.Update.class})
    @NotBlank(message = "{CREW_BEAN_STATUS_NOT_BLANK}", groups = {IBaseValidGroup.Add.class, IBaseValidGroup.Update.class})
    @Length(max = 7, message = "{CREW_BEAN_STATUS_LENGTH}", groups = {IBaseValidGroup.Add.class, IBaseValidGroup.Update.class})
    @Column(name = "crew_status")
    private String status;

    /**
     * <pre>
     * DB remark: 创建时间 {"pattern":"yyyy-MM-dd HH:mm:ss"}
     * DB column: crew_create_timestamp	TIMESTAMP(19)	<--->	createTimestamp	java.util.Date
     * DB is  Nullable: false
     * DB defaultValue: CURRENT_TIMESTAMP
     * </pre>
     */
    @ValidDateTimeFormat(pattern = DateUtil.DATE_PATTERN_YYYY_MM_DD_HH_MM_SS, message = "{CREW_BEAN_CREATE_TIMESTAMP_DATE_TIME_FORMAT}", groups = {IBaseValidGroup.Add.class, IBaseValidGroup.Update.class})
    @NotNull(message = "{CREW_BEAN_CREATE_TIMESTAMP_NOT_NULL}", groups = {IBaseValidGroup.Add.class, IBaseValidGroup.Update.class})
    @Column(name = "crew_create_timestamp")
    private Date createTimestamp;

    /**
     * <pre>
     * DB remark: 逻辑删除标志【N[正常]，Y[删除]】 {"dataList":["N","Y"]}
     * DB column: crew_delete_flag	CHAR(1)	<--->	deleteFlag	java.lang.String
     * DB is  Nullable: false
     * DB defaultValue: N
     * </pre>
     */
    @ValidAllowData(allowDataArray = {CrewBeanConstant.CREW_BEAN_DELETE_FLAG_Y, CrewBeanConstant.CREW_BEAN_DELETE_FLAG_N}, message = "{CREW_BEAN_DELETE_FLAG_ALLOW_DATA}", groups = {IBaseValidGroup.Add.class, IBaseValidGroup.Update.class})
    @NotBlank(message = "{CREW_BEAN_DELETE_FLAG_NOT_BLANK}", groups = {IBaseValidGroup.Add.class, IBaseValidGroup.Update.class})
    @Length(max = 1, message = "{CREW_BEAN_DELETE_FLAG_LENGTH}", groups = {IBaseValidGroup.Add.class, IBaseValidGroup.Update.class})
    @Column(name = "crew_delete_flag")
    private String deleteFlag;

    private static final long serialVersionUID = 1L;

    /**
     * 获取 数据库主键ID{"max":13}
     *
     * @return crew_id - 数据库主键ID{"max":13}
     */
    public Long getId() {
        return id;
    }

    /**
     * 设置 数据库主键ID{"max":13}
     *
     * @param id - 数据库主键ID{"max":13}
     */
    public CrewBean setId(Long id) {
        this.id = id;
        return this;
    }

    /**
     * 获取 员工内部编号{"min":3}
     *
     * @return crew_internal_id - 员工内部编号{"min":3}
     */
    public String getInternalId() {
        return internalId;
    }

    /**
     * 设置 员工内部编号{"min":3}
     *
     * @param internalId - 员工内部编号{"min":3}
     */
    public CrewBean setInternalId(String internalId) {
        this.internalId = internalId == null ? null : internalId.trim();
        return this;
    }

    /**
     * 获取 员工登陆账号{"min":3}
     *
     * @return crew_username - 员工登陆账号{"min":3}
     */
    public String getUsername() {
        return username;
    }

    /**
     * 设置 员工登陆账号{"min":3}
     *
     * @param username - 员工登陆账号{"min":3}
     */
    public CrewBean setUsername(String username) {
        this.username = username == null ? null : username.trim();
        return this;
    }

    /**
     * 获取 员工所属的网点ID,与 t_client_branch.branch_id 字段关联
     *
     * @return crew_branch_id - 员工所属的网点ID,与 t_client_branch.branch_id 字段关联
     */
    public Long getBranchId() {
        return branchId;
    }

    /**
     * 设置 员工所属的网点ID,与 t_client_branch.branch_id 字段关联
     *
     * @param branchId - 员工所属的网点ID,与 t_client_branch.branch_id 字段关联
     */
    public CrewBean setBranchId(Long branchId) {
        this.branchId = branchId;
        return this;
    }

    /**
     * 获取 电子邮箱 {"email":true}
     *
     * @return crew_email - 电子邮箱 {"email":true}
     */
    public String getEmail() {
        return email;
    }

    /**
     * 设置 电子邮箱 {"email":true}
     *
     * @param email - 电子邮箱 {"email":true}
     */
    public CrewBean setEmail(String email) {
        this.email = email == null ? null : email.trim();
        return this;
    }

    /**
     * 获取 生日 {"pattern":"yyyy-MM-dd"]
     *
     * @return crew_birthday - 生日 {"pattern":"yyyy-MM-dd"]
     */
    public Date getBirthday() {
        return birthday;
    }

    /**
     * 设置 生日 {"pattern":"yyyy-MM-dd"]
     *
     * @param birthday - 生日 {"pattern":"yyyy-MM-dd"]
     */
    public CrewBean setBirthday(Date birthday) {
        this.birthday = birthday;
        return this;
    }

    /**
     * 获取 状态【ENABLE[启用]、DISABLE[禁用]】{"dataList":["ENABLE","DISABLE"]}
     *
     * @return crew_status - 状态【ENABLE[启用]、DISABLE[禁用]】{"dataList":["ENABLE","DISABLE"]}
     */
    public String getStatus() {
        return status;
    }

    /**
     * 设置 状态【ENABLE[启用]、DISABLE[禁用]】{"dataList":["ENABLE","DISABLE"]}
     *
     * @param status - 状态【ENABLE[启用]、DISABLE[禁用]】{"dataList":["ENABLE","DISABLE"]}
     */
    public CrewBean setStatus(String status) {
        this.status = status == null ? null : status.trim();
        return this;
    }

    /**
     * 获取 创建时间 {"pattern":"yyyy-MM-dd HH:mm:ss"}
     *
     * @return crew_create_timestamp - 创建时间 {"pattern":"yyyy-MM-dd HH:mm:ss"}
     */
    public Date getCreateTimestamp() {
        return createTimestamp;
    }

    /**
     * 设置 创建时间 {"pattern":"yyyy-MM-dd HH:mm:ss"}
     *
     * @param createTimestamp - 创建时间 {"pattern":"yyyy-MM-dd HH:mm:ss"}
     */
    public CrewBean setCreateTimestamp(Date createTimestamp) {
        this.createTimestamp = createTimestamp;
        return this;
    }

    /**
     * 获取 逻辑删除标志【N[正常]，Y[删除]】 {"dataList":["N","Y"]}
     *
     * @return crew_delete_flag - 逻辑删除标志【N[正常]，Y[删除]】 {"dataList":["N","Y"]}
     */
    public String getDeleteFlag() {
        return deleteFlag;
    }

    /**
     * 设置 逻辑删除标志【N[正常]，Y[删除]】 {"dataList":["N","Y"]}
     *
     * @param deleteFlag - 逻辑删除标志【N[正常]，Y[删除]】 {"dataList":["N","Y"]}
     */
    public CrewBean setDeleteFlag(String deleteFlag) {
        this.deleteFlag = deleteFlag == null ? null : deleteFlag.trim();
        return this;
    }
}