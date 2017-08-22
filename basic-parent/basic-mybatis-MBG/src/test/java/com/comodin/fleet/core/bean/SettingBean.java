package com.comodin.fleet.core.bean;

import com.comodin.basic.util.date.DateUtil;
import com.comodin.basic.validation.IBaseValidGroup;
import com.comodin.basic.validation.constraints.*;
import java.io.Serializable;
import javax.persistence.*;
import javax.validation.constraints.*;
import org.hibernate.validator.constraints.*;
import org.springframework.format.annotation.DateTimeFormat;

@SuppressWarnings({"unused", "UnusedReturnValue", "SameParameterValue", "DefaultAnnotationParam"})
@Entity
@Table(name = "t_setting")
public class SettingBean implements Serializable {
    /**
     * <pre>
     * DB remark: 数据库主键ID
     * DB column: setting_id	BIGINT(20)	<--->	id	java.lang.Long
     * DB is  Nullable: false
     * DB defaultValue: null
     * </pre>
     */
    @NotNull(message = "{SETTING_BEAN_ID_NOT_NULL}", groups = {IBaseValidGroup.Add.class, IBaseValidGroup.Update.class})
    @ValidLength(max = 20, message = "{SETTING_BEAN_ID_LENGTH}", groups = {IBaseValidGroup.Add.class, IBaseValidGroup.Update.class})
    @Id
    @Column(name = "setting_id", length = 20, nullable = false)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    /**
     * <pre>
     * DB remark: 配置项的module
     * DB column: setting_module	VARCHAR(40)	<--->	module	java.lang.String
     * DB is  Nullable: false
     * DB defaultValue: null
     * </pre>
     */
    @NotBlank(message = "{SETTING_BEAN_MODULE_NOT_BLANK}", groups = {IBaseValidGroup.Add.class, IBaseValidGroup.Update.class})
    @Length(max = 40, message = "{SETTING_BEAN_MODULE_LENGTH}", groups = {IBaseValidGroup.Add.class, IBaseValidGroup.Update.class})
    @Column(name = "setting_module", length = 40, nullable = false)
    private String module;

    /**
     * <pre>
     * DB remark: 配置项的key
     * DB column: setting_key	VARCHAR(40)	<--->	key	java.lang.String
     * DB is  Nullable: false
     * DB defaultValue: null
     * </pre>
     */
    @NotBlank(message = "{SETTING_BEAN_KEY_NOT_BLANK}", groups = {IBaseValidGroup.Add.class, IBaseValidGroup.Update.class})
    @Length(max = 40, message = "{SETTING_BEAN_KEY_LENGTH}", groups = {IBaseValidGroup.Add.class, IBaseValidGroup.Update.class})
    @Column(name = "setting_key", length = 40, nullable = false)
    private String key;

    /**
     * <pre>
     * DB remark: 配置项的value
     * DB column: setting_value	VARCHAR(50)	<--->	value	java.lang.String
     * DB is  Nullable: false
     * DB defaultValue: null
     * </pre>
     */
    @NotBlank(message = "{SETTING_BEAN_VALUE_NOT_BLANK}", groups = {IBaseValidGroup.Add.class, IBaseValidGroup.Update.class})
    @Length(max = 50, message = "{SETTING_BEAN_VALUE_LENGTH}", groups = {IBaseValidGroup.Add.class, IBaseValidGroup.Update.class})
    @Column(name = "setting_value", length = 50, nullable = false)
    private String value;

    /**
     * <pre>
     * DB remark: 配置项的语言,en_US,zh_CN,es_MX
     * DB column: setting_language	VARCHAR(10)	<--->	language	java.lang.String
     * DB is  Nullable: false
     * DB defaultValue: null
     * </pre>
     */
    @NotBlank(message = "{SETTING_BEAN_LANGUAGE_NOT_BLANK}", groups = {IBaseValidGroup.Add.class, IBaseValidGroup.Update.class})
    @Length(max = 10, message = "{SETTING_BEAN_LANGUAGE_LENGTH}", groups = {IBaseValidGroup.Add.class, IBaseValidGroup.Update.class})
    @Column(name = "setting_language", length = 10, nullable = false)
    private String language;

    /**
     * <pre>
     * DB remark: 配置项的comment
     * DB column: setting_comment	VARCHAR(50)	<--->	comment	java.lang.String
     * DB is  Nullable: true
     * DB defaultValue: null
     * </pre>
     */
    @Length(max = 50, message = "{SETTING_BEAN_COMMENT_LENGTH}", groups = {IBaseValidGroup.Add.class, IBaseValidGroup.Update.class})
    @Column(name = "setting_comment", length = 50, nullable = true)
    private String comment;

    private static final long serialVersionUID = 1L;

    /**
     * 获取 数据库主键ID
     *
     * @return setting_id - 数据库主键ID
     */
    public Long getId() {
        return id;
    }

    /**
     * 设置 数据库主键ID
     *
     * @param id - 数据库主键ID
     */
    public SettingBean setId(Long id) {
        this.id = id;
        return this;
    }

    /**
     * 获取 配置项的module
     *
     * @return setting_module - 配置项的module
     */
    public String getModule() {
        return module;
    }

    /**
     * 设置 配置项的module
     *
     * @param module - 配置项的module
     */
    public SettingBean setModule(String module) {
        this.module = module == null ? null : module.trim();
        return this;
    }

    /**
     * 获取 配置项的key
     *
     * @return setting_key - 配置项的key
     */
    public String getKey() {
        return key;
    }

    /**
     * 设置 配置项的key
     *
     * @param key - 配置项的key
     */
    public SettingBean setKey(String key) {
        this.key = key == null ? null : key.trim();
        return this;
    }

    /**
     * 获取 配置项的value
     *
     * @return setting_value - 配置项的value
     */
    public String getValue() {
        return value;
    }

    /**
     * 设置 配置项的value
     *
     * @param value - 配置项的value
     */
    public SettingBean setValue(String value) {
        this.value = value == null ? null : value.trim();
        return this;
    }

    /**
     * 获取 配置项的语言,en_US,zh_CN,es_MX
     *
     * @return setting_language - 配置项的语言,en_US,zh_CN,es_MX
     */
    public String getLanguage() {
        return language;
    }

    /**
     * 设置 配置项的语言,en_US,zh_CN,es_MX
     *
     * @param language - 配置项的语言,en_US,zh_CN,es_MX
     */
    public SettingBean setLanguage(String language) {
        this.language = language == null ? null : language.trim();
        return this;
    }

    /**
     * 获取 配置项的comment
     *
     * @return setting_comment - 配置项的comment
     */
    public String getComment() {
        return comment;
    }

    /**
     * 设置 配置项的comment
     *
     * @param comment - 配置项的comment
     */
    public SettingBean setComment(String comment) {
        this.comment = comment == null ? null : comment.trim();
        return this;
    }
}