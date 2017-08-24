package com.comodin.fleet.core.bean;

import com.comodin.basic.util.date.DateUtil;
import com.comodin.basic.validation.IBaseValidGroup;
import com.comodin.basic.validation.constraints.*;
import com.comodin.fleet.constant.i18n.SystemStatusBeanI18nConstant;
import java.io.Serializable;
import java.util.Date;
import javax.persistence.*;
import javax.validation.constraints.*;
import org.hibernate.validator.constraints.*;
import org.springframework.format.annotation.DateTimeFormat;

@SuppressWarnings({"unused", "UnusedReturnValue", "SameParameterValue", "DefaultAnnotationParam"})
@Entity
@Table(name = "t_system_status")
public class SystemStatusBean implements Serializable {
    /**
     * <pre>
     * DB remark: 数据库主键ID
     * DB column: system_id	BIGINT(20)	<--->	id	java.lang.Long
     * DB is  Nullable: false
     * DB defaultValue: null
     * </pre>
     */
    @NotNull(message = "{" + SystemStatusBeanI18nConstant.SYSTEM_STATUS_BEAN_ID_NOT_NULL + "}", groups = {IBaseValidGroup.Update.class})
    @ValidLength(max = 20, message = "{" + SystemStatusBeanI18nConstant.SYSTEM_STATUS_BEAN_ID_LENGTH + "}", groups = {IBaseValidGroup.Update.class})
    @Column(name = "system_id", length = 20, nullable = false)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    private Long id;

    /**
     * <pre>
     * DB remark: 系统配置项
     * DB column: system_attribute_key	VARCHAR(40)	<--->	attributeKey	java.lang.String
     * DB is  Nullable: false
     * DB defaultValue: null
     * </pre>
     */
    @NotBlank(message = "{" + SystemStatusBeanI18nConstant.SYSTEM_STATUS_BEAN_ATTRIBUTE_KEY_NOT_BLANK + "}", groups = {IBaseValidGroup.Add.class, IBaseValidGroup.Update.class})
    @Length(max = 40, message = "{" + SystemStatusBeanI18nConstant.SYSTEM_STATUS_BEAN_ATTRIBUTE_KEY_LENGTH + "}", groups = {IBaseValidGroup.Add.class, IBaseValidGroup.Update.class})
    @Column(name = "system_attribute_key", length = 40, nullable = false)
    private String attributeKey;

    /**
     * <pre>
     * DB remark: 配置项的值
     * DB column: system_attribute_value	VARCHAR(40)	<--->	attributeValue	java.lang.String
     * DB is  Nullable: true
     * DB defaultValue: null
     * </pre>
     */
    @Length(max = 40, message = "{" + SystemStatusBeanI18nConstant.SYSTEM_STATUS_BEAN_ATTRIBUTE_VALUE_LENGTH + "}", groups = {IBaseValidGroup.Add.class, IBaseValidGroup.Update.class})
    @Column(name = "system_attribute_value", length = 40, nullable = true)
    private String attributeValue;

    /**
     * <pre>
     * DB remark: 配置项的comment
     * DB column: system_comment	VARCHAR(50)	<--->	comment	java.lang.String
     * DB is  Nullable: true
     * DB defaultValue: null
     * </pre>
     */
    @Length(max = 50, message = "{" + SystemStatusBeanI18nConstant.SYSTEM_STATUS_BEAN_COMMENT_LENGTH + "}", groups = {IBaseValidGroup.Add.class, IBaseValidGroup.Update.class})
    @Column(name = "system_comment", length = 50, nullable = true)
    private String comment;

    /**
     * <pre>
     * DB remark: 创建时间
     * DB column: system_create_timestamp	TIMESTAMP(19)	<--->	createTimestamp	java.util.Date
     * DB is  Nullable: false
     * DB defaultValue: CURRENT_TIMESTAMP
     * </pre>
     */
    @ValidDateTimeFormat(pattern = DateUtil.DATE_PATTERN_YYYY_MM_DD_HH_MM_SS, message = "{" + SystemStatusBeanI18nConstant.SYSTEM_STATUS_BEAN_CREATE_TIMESTAMP_DATE_TIME_FORMAT + "}", groups = {IBaseValidGroup.Add.class, IBaseValidGroup.Update.class})
    @DateTimeFormat(pattern = DateUtil.DATE_PATTERN_YYYY_MM_DD_HH_MM_SS)
    @NotNull(message = "{" + SystemStatusBeanI18nConstant.SYSTEM_STATUS_BEAN_CREATE_TIMESTAMP_NOT_NULL + "}", groups = {IBaseValidGroup.Add.class, IBaseValidGroup.Update.class})
    @Column(name = "system_create_timestamp", length = 19, nullable = false)
    private Date createTimestamp;

    /**
     * <pre>
     * DB remark: crew_username字段关联
     * DB column: system_create_by	VARCHAR(20)	<--->	createBy	java.lang.String
     * DB is  Nullable: false
     * DB defaultValue: null
     * </pre>
     */
    @NotBlank(message = "{" + SystemStatusBeanI18nConstant.SYSTEM_STATUS_BEAN_CREATE_BY_NOT_BLANK + "}", groups = {IBaseValidGroup.Add.class, IBaseValidGroup.Update.class})
    @Length(max = 20, message = "{" + SystemStatusBeanI18nConstant.SYSTEM_STATUS_BEAN_CREATE_BY_LENGTH + "}", groups = {IBaseValidGroup.Add.class, IBaseValidGroup.Update.class})
    @Column(name = "system_create_by", length = 20, nullable = false)
    private String createBy;

    /**
     * <pre>
     * DB remark: 逻辑删除标志【N[正常]，Y[删除]】
     * DB column: system_delete_flag	CHAR(1)	<--->	deleteFlag	java.lang.String
     * DB is  Nullable: false
     * DB defaultValue: N
     * </pre>
     */
    @NotBlank(message = "{" + SystemStatusBeanI18nConstant.SYSTEM_STATUS_BEAN_DELETE_FLAG_NOT_BLANK + "}", groups = {IBaseValidGroup.Add.class, IBaseValidGroup.Update.class})
    @Length(max = 1, message = "{" + SystemStatusBeanI18nConstant.SYSTEM_STATUS_BEAN_DELETE_FLAG_LENGTH + "}", groups = {IBaseValidGroup.Add.class, IBaseValidGroup.Update.class})
    @Column(name = "system_delete_flag", length = 1, nullable = false)
    private String deleteFlag;

    private static final long serialVersionUID = 1L;

    /**
     * 获取 数据库主键ID
     *
     * @return system_id - 数据库主键ID
     */
    public Long getId() {
        return id;
    }

    /**
     * 设置 数据库主键ID
     *
     * @param id - 数据库主键ID
     */
    public SystemStatusBean setId(Long id) {
        this.id = id;
        return this;
    }

    /**
     * 获取 系统配置项
     *
     * @return system_attribute_key - 系统配置项
     */
    public String getAttributeKey() {
        return attributeKey;
    }

    /**
     * 设置 系统配置项
     *
     * @param attributeKey - 系统配置项
     */
    public SystemStatusBean setAttributeKey(String attributeKey) {
        this.attributeKey = attributeKey == null ? null : attributeKey.trim();
        return this;
    }

    /**
     * 获取 配置项的值
     *
     * @return system_attribute_value - 配置项的值
     */
    public String getAttributeValue() {
        return attributeValue;
    }

    /**
     * 设置 配置项的值
     *
     * @param attributeValue - 配置项的值
     */
    public SystemStatusBean setAttributeValue(String attributeValue) {
        this.attributeValue = attributeValue == null ? null : attributeValue.trim();
        return this;
    }

    /**
     * 获取 配置项的comment
     *
     * @return system_comment - 配置项的comment
     */
    public String getComment() {
        return comment;
    }

    /**
     * 设置 配置项的comment
     *
     * @param comment - 配置项的comment
     */
    public SystemStatusBean setComment(String comment) {
        this.comment = comment == null ? null : comment.trim();
        return this;
    }

    /**
     * 获取 创建时间
     *
     * @return system_create_timestamp - 创建时间
     */
    public Date getCreateTimestamp() {
        return createTimestamp;
    }

    /**
     * 设置 创建时间
     *
     * @param createTimestamp - 创建时间
     */
    public SystemStatusBean setCreateTimestamp(Date createTimestamp) {
        this.createTimestamp = createTimestamp;
        return this;
    }

    /**
     * 获取 crew_username字段关联
     *
     * @return system_create_by - crew_username字段关联
     */
    public String getCreateBy() {
        return createBy;
    }

    /**
     * 设置 crew_username字段关联
     *
     * @param createBy - crew_username字段关联
     */
    public SystemStatusBean setCreateBy(String createBy) {
        this.createBy = createBy == null ? null : createBy.trim();
        return this;
    }

    /**
     * 获取 逻辑删除标志【N[正常]，Y[删除]】
     *
     * @return system_delete_flag - 逻辑删除标志【N[正常]，Y[删除]】
     */
    public String getDeleteFlag() {
        return deleteFlag;
    }

    /**
     * 设置 逻辑删除标志【N[正常]，Y[删除]】
     *
     * @param deleteFlag - 逻辑删除标志【N[正常]，Y[删除]】
     */
    public SystemStatusBean setDeleteFlag(String deleteFlag) {
        this.deleteFlag = deleteFlag == null ? null : deleteFlag.trim();
        return this;
    }
}