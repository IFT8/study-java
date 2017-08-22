package com.comodin.fleet.core.bean;

import com.comodin.basic.util.date.DateUtil;
import com.comodin.basic.validation.IBaseValidGroup;
import com.comodin.basic.validation.constraints.*;
import java.io.Serializable;
import javax.persistence.*;
import javax.validation.constraints.*;
import org.hibernate.validator.constraints.*;
import org.springframework.format.annotation.DateTimeFormat;

@SuppressWarnings({"unused", "UnusedReturnValue", "SameParameterValue"})
@Table(name = "t_privilege")
public class PrivilegeBean implements Serializable {
    /**
     * <pre>
     * DB remark: 数据库主键ID
     * DB column: privilege_id	BIGINT(20)	<--->	id	java.lang.Long
     * DB is  Nullable: false
     * DB defaultValue: null
     * </pre>
     */
    @NotNull(message = "{PRIVILEGE_BEAN_ID_NOT_NULL}", groups = {IBaseValidGroup.Add.class, IBaseValidGroup.Update.class})
    @ValidLength(max = 20, message = "{PRIVILEGE_BEAN_ID_LENGTH}", groups = {IBaseValidGroup.Add.class, IBaseValidGroup.Update.class})
    @Id
    @Column(name = "privilege_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    /**
     * <pre>
     * DB remark: 权限名称
     * DB column: privilege_name	VARCHAR(30)	<--->	name	java.lang.String
     * DB is  Nullable: true
     * DB defaultValue: null
     * </pre>
     */
    @Length(max = 30, message = "{PRIVILEGE_BEAN_NAME_LENGTH}", groups = {IBaseValidGroup.Add.class, IBaseValidGroup.Update.class})
    @Column(name = "privilege_name")
    private String name;

    /**
     * <pre>
     * DB remark: 权限模块名称
     * DB column: privilege_module_name	VARCHAR(20)	<--->	moduleName	java.lang.String
     * DB is  Nullable: true
     * DB defaultValue: null
     * </pre>
     */
    @Length(max = 20, message = "{PRIVILEGE_BEAN_MODULE_NAME_LENGTH}", groups = {IBaseValidGroup.Add.class, IBaseValidGroup.Update.class})
    @Column(name = "privilege_module_name")
    private String moduleName;

    /**
     * <pre>
     * DB remark: 状态【ENABLE[启用]、DISABLE[禁用]】
     * DB column: privilege_status	CHAR(7)	<--->	status	java.lang.String
     * DB is  Nullable: false
     * DB defaultValue: ENABLE
     * </pre>
     */
    @NotBlank(message = "{PRIVILEGE_BEAN_STATUS_NOT_BLANK}", groups = {IBaseValidGroup.Add.class, IBaseValidGroup.Update.class})
    @Length(max = 7, message = "{PRIVILEGE_BEAN_STATUS_LENGTH}", groups = {IBaseValidGroup.Add.class, IBaseValidGroup.Update.class})
    @Column(name = "privilege_status")
    private String status;

    /**
     * <pre>
     * DB remark: 该权限下拥有的所有合法请求url，| 隔开
     * DB column: privilege_urls	VARCHAR(2000)	<--->	urls	java.lang.String
     * DB is  Nullable: true
     * DB defaultValue: 
     * </pre>
     */
    @Length(max = 2000, message = "{PRIVILEGE_BEAN_URLS_LENGTH}", groups = {IBaseValidGroup.Add.class, IBaseValidGroup.Update.class})
    @Column(name = "privilege_urls")
    private String urls;

    /**
     * <pre>
     * DB remark: 逻辑删除标志【N[正常]，Y[删除]】
     * DB column: privilege_delete_flag	CHAR(1)	<--->	deleteFlag	java.lang.String
     * DB is  Nullable: false
     * DB defaultValue: N
     * </pre>
     */
    @NotBlank(message = "{PRIVILEGE_BEAN_DELETE_FLAG_NOT_BLANK}", groups = {IBaseValidGroup.Add.class, IBaseValidGroup.Update.class})
    @Length(max = 1, message = "{PRIVILEGE_BEAN_DELETE_FLAG_LENGTH}", groups = {IBaseValidGroup.Add.class, IBaseValidGroup.Update.class})
    @Column(name = "privilege_delete_flag")
    private String deleteFlag;

    private static final long serialVersionUID = 1L;

    /**
     * 获取 数据库主键ID
     *
     * @return privilege_id - 数据库主键ID
     */
    public Long getId() {
        return id;
    }

    /**
     * 设置 数据库主键ID
     *
     * @param id - 数据库主键ID
     */
    public PrivilegeBean setId(Long id) {
        this.id = id;
        return this;
    }

    /**
     * 获取 权限名称
     *
     * @return privilege_name - 权限名称
     */
    public String getName() {
        return name;
    }

    /**
     * 设置 权限名称
     *
     * @param name - 权限名称
     */
    public PrivilegeBean setName(String name) {
        this.name = name == null ? null : name.trim();
        return this;
    }

    /**
     * 获取 权限模块名称
     *
     * @return privilege_module_name - 权限模块名称
     */
    public String getModuleName() {
        return moduleName;
    }

    /**
     * 设置 权限模块名称
     *
     * @param moduleName - 权限模块名称
     */
    public PrivilegeBean setModuleName(String moduleName) {
        this.moduleName = moduleName == null ? null : moduleName.trim();
        return this;
    }

    /**
     * 获取 状态【ENABLE[启用]、DISABLE[禁用]】
     *
     * @return privilege_status - 状态【ENABLE[启用]、DISABLE[禁用]】
     */
    public String getStatus() {
        return status;
    }

    /**
     * 设置 状态【ENABLE[启用]、DISABLE[禁用]】
     *
     * @param status - 状态【ENABLE[启用]、DISABLE[禁用]】
     */
    public PrivilegeBean setStatus(String status) {
        this.status = status == null ? null : status.trim();
        return this;
    }

    /**
     * 获取 该权限下拥有的所有合法请求url，| 隔开
     *
     * @return privilege_urls - 该权限下拥有的所有合法请求url，| 隔开
     */
    public String getUrls() {
        return urls;
    }

    /**
     * 设置 该权限下拥有的所有合法请求url，| 隔开
     *
     * @param urls - 该权限下拥有的所有合法请求url，| 隔开
     */
    public PrivilegeBean setUrls(String urls) {
        this.urls = urls == null ? null : urls.trim();
        return this;
    }

    /**
     * 获取 逻辑删除标志【N[正常]，Y[删除]】
     *
     * @return privilege_delete_flag - 逻辑删除标志【N[正常]，Y[删除]】
     */
    public String getDeleteFlag() {
        return deleteFlag;
    }

    /**
     * 设置 逻辑删除标志【N[正常]，Y[删除]】
     *
     * @param deleteFlag - 逻辑删除标志【N[正常]，Y[删除]】
     */
    public PrivilegeBean setDeleteFlag(String deleteFlag) {
        this.deleteFlag = deleteFlag == null ? null : deleteFlag.trim();
        return this;
    }
}