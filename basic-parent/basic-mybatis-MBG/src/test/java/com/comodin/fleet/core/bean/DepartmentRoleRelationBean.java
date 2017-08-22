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
@Table(name = "t_department_role_relation")
public class DepartmentRoleRelationBean implements Serializable {
    /**
     * <pre>
     * DB remark: 数据库主键ID
     * DB column: relation_id	BIGINT(20)	<--->	id	java.lang.Long
     * DB is  Nullable: false
     * DB defaultValue: null
     * </pre>
     */
    @NotNull(message = "{DEPARTMENT_ROLE_RELATION_BEAN_ID_NOT_NULL}", groups = {IBaseValidGroup.Add.class, IBaseValidGroup.Update.class})
    @ValidLength(max = 20, message = "{DEPARTMENT_ROLE_RELATION_BEAN_ID_LENGTH}", groups = {IBaseValidGroup.Add.class, IBaseValidGroup.Update.class})
    @Id
    @Column(name = "relation_id", length = 20, nullable = false)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    /**
     * <pre>
     * DB remark: 部门ID,t_department.department_id字段关联
     * DB column: relation_department_id	BIGINT(19)	<--->	departmentId	java.lang.Long
     * DB is  Nullable: false
     * DB defaultValue: null
     * </pre>
     */
    @NotNull(message = "{DEPARTMENT_ROLE_RELATION_BEAN_DEPARTMENT_ID_NOT_NULL}", groups = {IBaseValidGroup.Add.class, IBaseValidGroup.Update.class})
    @ValidLength(max = 19, message = "{DEPARTMENT_ROLE_RELATION_BEAN_DEPARTMENT_ID_LENGTH}", groups = {IBaseValidGroup.Add.class, IBaseValidGroup.Update.class})
    @Column(name = "relation_department_id", length = 19, nullable = false)
    private Long departmentId;

    /**
     * <pre>
     * DB remark: 角色ID,t_role.role_id字段关联
     * DB column: relation_role_id	BIGINT(19)	<--->	roleId	java.lang.Long
     * DB is  Nullable: false
     * DB defaultValue: null
     * </pre>
     */
    @NotNull(message = "{DEPARTMENT_ROLE_RELATION_BEAN_ROLE_ID_NOT_NULL}", groups = {IBaseValidGroup.Add.class, IBaseValidGroup.Update.class})
    @ValidLength(max = 19, message = "{DEPARTMENT_ROLE_RELATION_BEAN_ROLE_ID_LENGTH}", groups = {IBaseValidGroup.Add.class, IBaseValidGroup.Update.class})
    @Column(name = "relation_role_id", length = 19, nullable = false)
    private Long roleId;

    /**
     * <pre>
     * DB remark: 创建时间
     * DB column: relation_create_timestamp	TIMESTAMP(19)	<--->	createTimestamp	java.util.Date
     * DB is  Nullable: false
     * DB defaultValue: CURRENT_TIMESTAMP
     * </pre>
     */
    @ValidDateTimeFormat(pattern = DateUtil.DATE_PATTERN_YYYY_MM_DD_HH_MM_SS , message = "{DEPARTMENT_ROLE_RELATION_BEAN_CREATE_TIMESTAMP_DATE_TIME_FORMAT}", groups = {IBaseValidGroup.Add.class, IBaseValidGroup.Update.class})
    @DateTimeFormat(pattern = DateUtil.DATE_PATTERN_YYYY_MM_DD_HH_MM_SS)
    @NotNull(message = "{DEPARTMENT_ROLE_RELATION_BEAN_CREATE_TIMESTAMP_NOT_NULL}", groups = {IBaseValidGroup.Add.class, IBaseValidGroup.Update.class})
    @Column(name = "relation_create_timestamp", length = 19, nullable = false)
    private Date createTimestamp;

    /**
     * <pre>
     * DB remark: crew_username字段关联
     * DB column: relation_create_by	VARCHAR(20)	<--->	createBy	java.lang.String
     * DB is  Nullable: false
     * DB defaultValue: null
     * </pre>
     */
    @NotBlank(message = "{DEPARTMENT_ROLE_RELATION_BEAN_CREATE_BY_NOT_BLANK}", groups = {IBaseValidGroup.Add.class, IBaseValidGroup.Update.class})
    @Length(max = 20, message = "{DEPARTMENT_ROLE_RELATION_BEAN_CREATE_BY_LENGTH}", groups = {IBaseValidGroup.Add.class, IBaseValidGroup.Update.class})
    @Column(name = "relation_create_by", length = 20, nullable = false)
    private String createBy;

    /**
     * <pre>
     * DB remark: 逻辑删除标志【N[正常]，Y[删除]】
     * DB column: relation_delete_flag	CHAR(1)	<--->	deleteFlag	java.lang.String
     * DB is  Nullable: false
     * DB defaultValue: N
     * </pre>
     */
    @NotBlank(message = "{DEPARTMENT_ROLE_RELATION_BEAN_DELETE_FLAG_NOT_BLANK}", groups = {IBaseValidGroup.Add.class, IBaseValidGroup.Update.class})
    @Length(max = 1, message = "{DEPARTMENT_ROLE_RELATION_BEAN_DELETE_FLAG_LENGTH}", groups = {IBaseValidGroup.Add.class, IBaseValidGroup.Update.class})
    @Column(name = "relation_delete_flag", length = 1, nullable = false)
    private String deleteFlag;

    private static final long serialVersionUID = 1L;

    /**
     * 获取 数据库主键ID
     *
     * @return relation_id - 数据库主键ID
     */
    public Long getId() {
        return id;
    }

    /**
     * 设置 数据库主键ID
     *
     * @param id - 数据库主键ID
     */
    public DepartmentRoleRelationBean setId(Long id) {
        this.id = id;
        return this;
    }

    /**
     * 获取 部门ID,t_department.department_id字段关联
     *
     * @return relation_department_id - 部门ID,t_department.department_id字段关联
     */
    public Long getDepartmentId() {
        return departmentId;
    }

    /**
     * 设置 部门ID,t_department.department_id字段关联
     *
     * @param departmentId - 部门ID,t_department.department_id字段关联
     */
    public DepartmentRoleRelationBean setDepartmentId(Long departmentId) {
        this.departmentId = departmentId;
        return this;
    }

    /**
     * 获取 角色ID,t_role.role_id字段关联
     *
     * @return relation_role_id - 角色ID,t_role.role_id字段关联
     */
    public Long getRoleId() {
        return roleId;
    }

    /**
     * 设置 角色ID,t_role.role_id字段关联
     *
     * @param roleId - 角色ID,t_role.role_id字段关联
     */
    public DepartmentRoleRelationBean setRoleId(Long roleId) {
        this.roleId = roleId;
        return this;
    }

    /**
     * 获取 创建时间
     *
     * @return relation_create_timestamp - 创建时间
     */
    public Date getCreateTimestamp() {
        return createTimestamp;
    }

    /**
     * 设置 创建时间
     *
     * @param createTimestamp - 创建时间
     */
    public DepartmentRoleRelationBean setCreateTimestamp(Date createTimestamp) {
        this.createTimestamp = createTimestamp;
        return this;
    }

    /**
     * 获取 crew_username字段关联
     *
     * @return relation_create_by - crew_username字段关联
     */
    public String getCreateBy() {
        return createBy;
    }

    /**
     * 设置 crew_username字段关联
     *
     * @param createBy - crew_username字段关联
     */
    public DepartmentRoleRelationBean setCreateBy(String createBy) {
        this.createBy = createBy == null ? null : createBy.trim();
        return this;
    }

    /**
     * 获取 逻辑删除标志【N[正常]，Y[删除]】
     *
     * @return relation_delete_flag - 逻辑删除标志【N[正常]，Y[删除]】
     */
    public String getDeleteFlag() {
        return deleteFlag;
    }

    /**
     * 设置 逻辑删除标志【N[正常]，Y[删除]】
     *
     * @param deleteFlag - 逻辑删除标志【N[正常]，Y[删除]】
     */
    public DepartmentRoleRelationBean setDeleteFlag(String deleteFlag) {
        this.deleteFlag = deleteFlag == null ? null : deleteFlag.trim();
        return this;
    }
}