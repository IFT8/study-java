package com.comodin.fleet.core.bean;

import com.comodin.basic.util.date.DateUtil;
import com.comodin.basic.validation.IBaseValidGroup;
import com.comodin.basic.validation.constraints.*;
import com.comodin.fleet.constants.i18n.DbScriptPatchBeanI18nConstant;
import java.io.Serializable;
import java.util.Date;
import javax.persistence.*;
import javax.validation.constraints.*;
import org.hibernate.validator.constraints.*;
import org.springframework.format.annotation.DateTimeFormat;

@SuppressWarnings({"unused", "SpringAutowiredFieldsWarningInspection", "StatementWithEmptyBody", "WeakerAccess", "DefaultAnnotationParam"})
@Entity
@Table(name = "t_db_script_patch")
public class DbScriptPatchBean implements Serializable {
    /**
     * <pre>
     * DB remark: 数据库主键ID
     * DB column: script_id	BIGINT(20)	<--->	id	java.lang.Long
     * DB is  Nullable: false
     * DB defaultValue: null
     * </pre>
     */
    @NotNull(message = "{" + DbScriptPatchBeanI18nConstant.DB_SCRIPT_PATCH_BEAN_ID_NOT_NULL + "}", groups = {IBaseValidGroup.Update.class})
    @ValidLength(max = 20, message = "{" + DbScriptPatchBeanI18nConstant.DB_SCRIPT_PATCH_BEAN_ID_LENGTH + "}", groups = {IBaseValidGroup.Update.class})
    @Column(name = "script_id", length = 20, nullable = false)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    private Long id;

    /**
     * <pre>
     * DB remark: 脚本,文件
     * DB column: script_patch_file	VARCHAR(100)	<--->	patchFile	java.lang.String
     * DB is  Nullable: false
     * DB defaultValue: null
     * </pre>
     */
    @NotBlank(message = "{" + DbScriptPatchBeanI18nConstant.DB_SCRIPT_PATCH_BEAN_PATCH_FILE_NOT_BLANK + "}", groups = {IBaseValidGroup.Add.class, IBaseValidGroup.Update.class})
    @Length(max = 100, message = "{" + DbScriptPatchBeanI18nConstant.DB_SCRIPT_PATCH_BEAN_PATCH_FILE_LENGTH + "}", groups = {IBaseValidGroup.Add.class, IBaseValidGroup.Update.class})
    @Column(name = "script_patch_file", length = 100, nullable = false)
    private String patchFile;

    /**
     * <pre>
     * DB remark: 脚本,描述
     * DB column: script_description	VARCHAR(255)	<--->	description	java.lang.String
     * DB is  Nullable: false
     * DB defaultValue: 
     * </pre>
     */
    @NotBlank(message = "{" + DbScriptPatchBeanI18nConstant.DB_SCRIPT_PATCH_BEAN_DESCRIPTION_NOT_BLANK + "}", groups = {IBaseValidGroup.Add.class, IBaseValidGroup.Update.class})
    @Length(max = 255, message = "{" + DbScriptPatchBeanI18nConstant.DB_SCRIPT_PATCH_BEAN_DESCRIPTION_LENGTH + "}", groups = {IBaseValidGroup.Add.class, IBaseValidGroup.Update.class})
    @Column(name = "script_description", length = 255, nullable = false)
    private String description;

    /**
     * <pre>
     * DB remark: 创建时间
     * DB column: system_create_timestamp	TIMESTAMP(19)	<--->	systemCreateTimestamp	java.util.Date
     * DB is  Nullable: false
     * DB defaultValue: CURRENT_TIMESTAMP
     * </pre>
     */
    @ValidDateTimeFormat(pattern = DateUtil.DATE_PATTERN_YYYY_MM_DD_HH_MM_SS, message = "{" + DbScriptPatchBeanI18nConstant.DB_SCRIPT_PATCH_BEAN_SYSTEM_CREATE_TIMESTAMP_DATE_TIME_FORMAT + "}", groups = {IBaseValidGroup.Add.class, IBaseValidGroup.Update.class})
    @DateTimeFormat(pattern = DateUtil.DATE_PATTERN_YYYY_MM_DD_HH_MM_SS)
    @NotNull(message = "{" + DbScriptPatchBeanI18nConstant.DB_SCRIPT_PATCH_BEAN_SYSTEM_CREATE_TIMESTAMP_NOT_NULL + "}", groups = {IBaseValidGroup.Add.class, IBaseValidGroup.Update.class})
    @Column(name = "system_create_timestamp", length = 19, nullable = false)
    private Date systemCreateTimestamp;

    /**
     * <pre>
     * DB remark: crew_username字段关联
     * DB column: system_create_by	VARCHAR(20)	<--->	systemCreateBy	java.lang.String
     * DB is  Nullable: false
     * DB defaultValue: null
     * </pre>
     */
    @NotBlank(message = "{" + DbScriptPatchBeanI18nConstant.DB_SCRIPT_PATCH_BEAN_SYSTEM_CREATE_BY_NOT_BLANK + "}", groups = {IBaseValidGroup.Add.class, IBaseValidGroup.Update.class})
    @Length(max = 20, message = "{" + DbScriptPatchBeanI18nConstant.DB_SCRIPT_PATCH_BEAN_SYSTEM_CREATE_BY_LENGTH + "}", groups = {IBaseValidGroup.Add.class, IBaseValidGroup.Update.class})
    @Column(name = "system_create_by", length = 20, nullable = false)
    private String systemCreateBy;

    /**
     * <pre>
     * DB remark: 逻辑删除标志【N[正常],Y[删除]】
     * DB column: system_delete_flag	CHAR(1)	<--->	systemDeleteFlag	java.lang.String
     * DB is  Nullable: false
     * DB defaultValue: N
     * </pre>
     */
    @NotBlank(message = "{" + DbScriptPatchBeanI18nConstant.DB_SCRIPT_PATCH_BEAN_SYSTEM_DELETE_FLAG_NOT_BLANK + "}", groups = {IBaseValidGroup.Add.class, IBaseValidGroup.Update.class})
    @Length(max = 1, message = "{" + DbScriptPatchBeanI18nConstant.DB_SCRIPT_PATCH_BEAN_SYSTEM_DELETE_FLAG_LENGTH + "}", groups = {IBaseValidGroup.Add.class, IBaseValidGroup.Update.class})
    @Column(name = "system_delete_flag", length = 1, nullable = false)
    private String systemDeleteFlag;

    private static final long serialVersionUID = 1L;

    /**
     * 获取 数据库主键ID
     *
     * @return script_id - 数据库主键ID
     */
    public Long getId() {
        return id;
    }

    /**
     * 设置 数据库主键ID
     *
     * @param id - 数据库主键ID
     */
    public DbScriptPatchBean setId(Long id) {
        this.id = id;
        return this;
    }

    /**
     * 获取 脚本,文件
     *
     * @return script_patch_file - 脚本,文件
     */
    public String getPatchFile() {
        return patchFile;
    }

    /**
     * 设置 脚本,文件
     *
     * @param patchFile - 脚本,文件
     */
    public DbScriptPatchBean setPatchFile(String patchFile) {
        this.patchFile = patchFile == null ? null : patchFile.trim();
        return this;
    }

    /**
     * 获取 脚本,描述
     *
     * @return script_description - 脚本,描述
     */
    public String getDescription() {
        return description;
    }

    /**
     * 设置 脚本,描述
     *
     * @param description - 脚本,描述
     */
    public DbScriptPatchBean setDescription(String description) {
        this.description = description == null ? null : description.trim();
        return this;
    }

    /**
     * 获取 创建时间
     *
     * @return system_create_timestamp - 创建时间
     */
    public Date getSystemCreateTimestamp() {
        return systemCreateTimestamp;
    }

    /**
     * 设置 创建时间
     *
     * @param systemCreateTimestamp - 创建时间
     */
    public DbScriptPatchBean setSystemCreateTimestamp(Date systemCreateTimestamp) {
        this.systemCreateTimestamp = systemCreateTimestamp;
        return this;
    }

    /**
     * 获取 crew_username字段关联
     *
     * @return system_create_by - crew_username字段关联
     */
    public String getSystemCreateBy() {
        return systemCreateBy;
    }

    /**
     * 设置 crew_username字段关联
     *
     * @param systemCreateBy - crew_username字段关联
     */
    public DbScriptPatchBean setSystemCreateBy(String systemCreateBy) {
        this.systemCreateBy = systemCreateBy == null ? null : systemCreateBy.trim();
        return this;
    }

    /**
     * 获取 逻辑删除标志【N[正常],Y[删除]】
     *
     * @return system_delete_flag - 逻辑删除标志【N[正常],Y[删除]】
     */
    public String getSystemDeleteFlag() {
        return systemDeleteFlag;
    }

    /**
     * 设置 逻辑删除标志【N[正常],Y[删除]】
     *
     * @param systemDeleteFlag - 逻辑删除标志【N[正常],Y[删除]】
     */
    public DbScriptPatchBean setSystemDeleteFlag(String systemDeleteFlag) {
        this.systemDeleteFlag = systemDeleteFlag == null ? null : systemDeleteFlag.trim();
        return this;
    }
}