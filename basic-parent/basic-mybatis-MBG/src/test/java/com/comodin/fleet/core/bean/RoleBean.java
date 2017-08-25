package com.comodin.fleet.core.bean;

import com.comodin.basic.util.date.DateUtil;
import com.comodin.basic.validation.IBaseValidGroup;
import com.comodin.basic.validation.constraints.*;
import com.comodin.fleet.constants.i18n.RoleBeanI18nConstant;
import java.io.Serializable;
import java.util.Date;
import javax.persistence.*;
import javax.validation.constraints.*;
import org.hibernate.validator.constraints.*;
import org.springframework.format.annotation.DateTimeFormat;

@SuppressWarnings({"unused", "UnusedReturnValue", "SameParameterValue", "DefaultAnnotationParam"})
@Entity
@Table(name = "t_role")
public class RoleBean implements Serializable {
    /**
     * <pre>
     * DB remark: 数据库主键ID
     * DB column: role_id	BIGINT(20)	<--->	id	java.lang.Long
     * DB is  Nullable: false
     * DB defaultValue: null
     * </pre>
     */
    @NotNull(message = "{" + RoleBeanI18nConstant.ROLE_BEAN_ID_NOT_NULL + "}", groups = {IBaseValidGroup.Update.class})
    @ValidLength(max = 20, message = "{" + RoleBeanI18nConstant.ROLE_BEAN_ID_LENGTH + "}", groups = {IBaseValidGroup.Update.class})
    @Column(name = "role_id", length = 20, nullable = false)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    private Long id;

    /**
     * <pre>
     * DB remark: 角色名称
     * DB column: role_name	VARCHAR(20)	<--->	name	java.lang.String
     * DB is  Nullable: true
     * DB defaultValue: null
     * </pre>
     */
    @Length(max = 20, message = "{" + RoleBeanI18nConstant.ROLE_BEAN_NAME_LENGTH + "}", groups = {IBaseValidGroup.Add.class, IBaseValidGroup.Update.class})
    @Column(name = "role_name", length = 20, nullable = true)
    private String name;

    /**
     * <pre>
     * DB remark: 有多少员工拥有该角色
     * DB column: role_amount	INTEGER(10)	<--->	amount	java.lang.Integer
     * DB is  Nullable: true
     * DB defaultValue: 0
     * </pre>
     */
    @ValidLength(max = 10, message = "{" + RoleBeanI18nConstant.ROLE_BEAN_AMOUNT_LENGTH + "}", groups = {IBaseValidGroup.Add.class, IBaseValidGroup.Update.class})
    @Column(name = "role_amount", length = 10, nullable = true)
    private Integer amount;

    /**
     * <pre>
     * DB remark: 角色对应的权限，关联t_privilege主键ID【此处以 |privilege_id1|privilege_id2|privilege_id3| 风格进行表示】
     * DB column: role_privilege	VARCHAR(5000)	<--->	privilege	java.lang.String
     * DB is  Nullable: true
     * DB defaultValue: null
     * </pre>
     */
    @Length(max = 5000, message = "{" + RoleBeanI18nConstant.ROLE_BEAN_PRIVILEGE_LENGTH + "}", groups = {IBaseValidGroup.Add.class, IBaseValidGroup.Update.class})
    @Column(name = "role_privilege", length = 5000, nullable = true)
    private String privilege;

    /**
     * <pre>
     * DB remark: 状态【ENABLE[启用]、DISABLE[禁用]】
     * DB column: role_status	CHAR(7)	<--->	status	java.lang.String
     * DB is  Nullable: false
     * DB defaultValue: ENABLE
     * </pre>
     */
    @NotBlank(message = "{" + RoleBeanI18nConstant.ROLE_BEAN_STATUS_NOT_BLANK + "}", groups = {IBaseValidGroup.Add.class, IBaseValidGroup.Update.class})
    @Length(max = 7, message = "{" + RoleBeanI18nConstant.ROLE_BEAN_STATUS_LENGTH + "}", groups = {IBaseValidGroup.Add.class, IBaseValidGroup.Update.class})
    @Column(name = "role_status", length = 7, nullable = false)
    private String status;

    /**
     * <pre>
     * DB remark: 描述
     * DB column: role_description	VARCHAR(255)	<--->	description	java.lang.String
     * DB is  Nullable: true
     * DB defaultValue: 
     * </pre>
     */
    @Length(max = 255, message = "{" + RoleBeanI18nConstant.ROLE_BEAN_DESCRIPTION_LENGTH + "}", groups = {IBaseValidGroup.Add.class, IBaseValidGroup.Update.class})
    @Column(name = "role_description", length = 255, nullable = true)
    private String description;

    /**
     * <pre>
     * DB remark: crew_username字段关联
     * DB column: role_create_by	VARCHAR(20)	<--->	createBy	java.lang.String
     * DB is  Nullable: false
     * DB defaultValue: null
     * </pre>
     */
    @NotBlank(message = "{" + RoleBeanI18nConstant.ROLE_BEAN_CREATE_BY_NOT_BLANK + "}", groups = {IBaseValidGroup.Add.class, IBaseValidGroup.Update.class})
    @Length(max = 20, message = "{" + RoleBeanI18nConstant.ROLE_BEAN_CREATE_BY_LENGTH + "}", groups = {IBaseValidGroup.Add.class, IBaseValidGroup.Update.class})
    @Column(name = "role_create_by", length = 20, nullable = false)
    private String createBy;

    /**
     * <pre>
     * DB remark: 创建时间
     * DB column: role_create_date_timestamp	TIMESTAMP(19)	<--->	createDateTimestamp	java.util.Date
     * DB is  Nullable: false
     * DB defaultValue: CURRENT_TIMESTAMP
     * </pre>
     */
    @ValidDateTimeFormat(pattern = DateUtil.DATE_PATTERN_YYYY_MM_DD_HH_MM_SS, message = "{" + RoleBeanI18nConstant.ROLE_BEAN_CREATE_DATE_TIMESTAMP_DATE_TIME_FORMAT + "}", groups = {IBaseValidGroup.Add.class, IBaseValidGroup.Update.class})
    @DateTimeFormat(pattern = DateUtil.DATE_PATTERN_YYYY_MM_DD_HH_MM_SS)
    @NotNull(message = "{" + RoleBeanI18nConstant.ROLE_BEAN_CREATE_DATE_TIMESTAMP_NOT_NULL + "}", groups = {IBaseValidGroup.Add.class, IBaseValidGroup.Update.class})
    @Column(name = "role_create_date_timestamp", length = 19, nullable = false)
    private Date createDateTimestamp;

    /**
     * <pre>
     * DB remark: 逻辑删除标志【N[正常]，Y[删除]】
     * DB column: role_delete_flag	CHAR(1)	<--->	deleteFlag	java.lang.String
     * DB is  Nullable: false
     * DB defaultValue: N
     * </pre>
     */
    @NotBlank(message = "{" + RoleBeanI18nConstant.ROLE_BEAN_DELETE_FLAG_NOT_BLANK + "}", groups = {IBaseValidGroup.Add.class, IBaseValidGroup.Update.class})
    @Length(max = 1, message = "{" + RoleBeanI18nConstant.ROLE_BEAN_DELETE_FLAG_LENGTH + "}", groups = {IBaseValidGroup.Add.class, IBaseValidGroup.Update.class})
    @Column(name = "role_delete_flag", length = 1, nullable = false)
    private String deleteFlag;

    private static final long serialVersionUID = 1L;

    /**
     * 获取 数据库主键ID
     *
     * @return role_id - 数据库主键ID
     */
    public Long getId() {
        return id;
    }

    /**
     * 设置 数据库主键ID
     *
     * @param id - 数据库主键ID
     */
    public RoleBean setId(Long id) {
        this.id = id;
        return this;
    }

    /**
     * 获取 角色名称
     *
     * @return role_name - 角色名称
     */
    public String getName() {
        return name;
    }

    /**
     * 设置 角色名称
     *
     * @param name - 角色名称
     */
    public RoleBean setName(String name) {
        this.name = name == null ? null : name.trim();
        return this;
    }

    /**
     * 获取 有多少员工拥有该角色
     *
     * @return role_amount - 有多少员工拥有该角色
     */
    public Integer getAmount() {
        return amount;
    }

    /**
     * 设置 有多少员工拥有该角色
     *
     * @param amount - 有多少员工拥有该角色
     */
    public RoleBean setAmount(Integer amount) {
        this.amount = amount;
        return this;
    }

    /**
     * 获取 角色对应的权限，关联t_privilege主键ID【此处以 |privilege_id1|privilege_id2|privilege_id3| 风格进行表示】
     *
     * @return role_privilege - 角色对应的权限，关联t_privilege主键ID【此处以 |privilege_id1|privilege_id2|privilege_id3| 风格进行表示】
     */
    public String getPrivilege() {
        return privilege;
    }

    /**
     * 设置 角色对应的权限，关联t_privilege主键ID【此处以 |privilege_id1|privilege_id2|privilege_id3| 风格进行表示】
     *
     * @param privilege - 角色对应的权限，关联t_privilege主键ID【此处以 |privilege_id1|privilege_id2|privilege_id3| 风格进行表示】
     */
    public RoleBean setPrivilege(String privilege) {
        this.privilege = privilege == null ? null : privilege.trim();
        return this;
    }

    /**
     * 获取 状态【ENABLE[启用]、DISABLE[禁用]】
     *
     * @return role_status - 状态【ENABLE[启用]、DISABLE[禁用]】
     */
    public String getStatus() {
        return status;
    }

    /**
     * 设置 状态【ENABLE[启用]、DISABLE[禁用]】
     *
     * @param status - 状态【ENABLE[启用]、DISABLE[禁用]】
     */
    public RoleBean setStatus(String status) {
        this.status = status == null ? null : status.trim();
        return this;
    }

    /**
     * 获取 描述
     *
     * @return role_description - 描述
     */
    public String getDescription() {
        return description;
    }

    /**
     * 设置 描述
     *
     * @param description - 描述
     */
    public RoleBean setDescription(String description) {
        this.description = description == null ? null : description.trim();
        return this;
    }

    /**
     * 获取 crew_username字段关联
     *
     * @return role_create_by - crew_username字段关联
     */
    public String getCreateBy() {
        return createBy;
    }

    /**
     * 设置 crew_username字段关联
     *
     * @param createBy - crew_username字段关联
     */
    public RoleBean setCreateBy(String createBy) {
        this.createBy = createBy == null ? null : createBy.trim();
        return this;
    }

    /**
     * 获取 创建时间
     *
     * @return role_create_date_timestamp - 创建时间
     */
    public Date getCreateDateTimestamp() {
        return createDateTimestamp;
    }

    /**
     * 设置 创建时间
     *
     * @param createDateTimestamp - 创建时间
     */
    public RoleBean setCreateDateTimestamp(Date createDateTimestamp) {
        this.createDateTimestamp = createDateTimestamp;
        return this;
    }

    /**
     * 获取 逻辑删除标志【N[正常]，Y[删除]】
     *
     * @return role_delete_flag - 逻辑删除标志【N[正常]，Y[删除]】
     */
    public String getDeleteFlag() {
        return deleteFlag;
    }

    /**
     * 设置 逻辑删除标志【N[正常]，Y[删除]】
     *
     * @param deleteFlag - 逻辑删除标志【N[正常]，Y[删除]】
     */
    public RoleBean setDeleteFlag(String deleteFlag) {
        this.deleteFlag = deleteFlag == null ? null : deleteFlag.trim();
        return this;
    }
}