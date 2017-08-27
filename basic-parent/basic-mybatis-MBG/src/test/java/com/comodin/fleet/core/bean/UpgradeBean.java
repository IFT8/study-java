package com.comodin.fleet.core.bean;

import com.comodin.basic.util.date.DateUtil;
import com.comodin.basic.validation.IBaseValidGroup;
import com.comodin.basic.validation.constraints.*;
import com.comodin.fleet.constants.i18n.UpgradeBeanI18nConstant;
import java.io.Serializable;
import java.util.Date;
import javax.persistence.*;
import javax.validation.constraints.*;
import org.hibernate.validator.constraints.*;
import org.springframework.format.annotation.DateTimeFormat;

@SuppressWarnings({"unused", "SpringAutowiredFieldsWarningInspection", "StatementWithEmptyBody", "WeakerAccess"})
@Entity
@Table(name = "t_upgrade")
public class UpgradeBean implements Serializable {
    /**
     * <pre>
     * DB remark: 数据库主键ID
     * DB column: upgrade_id	BIGINT(20)	<--->	id	java.lang.Long
     * DB is  Nullable: false
     * DB defaultValue: null
     * </pre>
     */
    @NotNull(message = "{" + UpgradeBeanI18nConstant.UPGRADE_BEAN_ID_NOT_NULL + "}", groups = {IBaseValidGroup.Update.class})
    @ValidLength(max = 20, message = "{" + UpgradeBeanI18nConstant.UPGRADE_BEAN_ID_LENGTH + "}", groups = {IBaseValidGroup.Update.class})
    @Column(name = "upgrade_id", length = 20, nullable = false)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    private Long id;

    /**
     * <pre>
     * DB remark: 版本号
     * DB column: upgrade_version	BIGINT(20)	<--->	version	java.lang.Long
     * DB is  Nullable: false
     * DB defaultValue: null
     * </pre>
     */
    @NotNull(message = "{" + UpgradeBeanI18nConstant.UPGRADE_BEAN_VERSION_NOT_NULL + "}", groups = {IBaseValidGroup.Add.class, IBaseValidGroup.Update.class})
    @ValidLength(max = 20, message = "{" + UpgradeBeanI18nConstant.UPGRADE_BEAN_VERSION_LENGTH + "}", groups = {IBaseValidGroup.Add.class, IBaseValidGroup.Update.class})
    @Column(name = "upgrade_version", length = 20, nullable = false)
    private Long version;

    /**
     * <pre>
     * DB remark: 版本,版本号对外文本说明
     * DB column: upgrade_version_text	VARCHAR(20)	<--->	versionText	java.lang.String
     * DB is  Nullable: false
     * DB defaultValue: 
     * </pre>
     */
    @NotBlank(message = "{" + UpgradeBeanI18nConstant.UPGRADE_BEAN_VERSION_TEXT_NOT_BLANK + "}", groups = {IBaseValidGroup.Add.class, IBaseValidGroup.Update.class})
    @Length(max = 20, message = "{" + UpgradeBeanI18nConstant.UPGRADE_BEAN_VERSION_TEXT_LENGTH + "}", groups = {IBaseValidGroup.Add.class, IBaseValidGroup.Update.class})
    @Column(name = "upgrade_version_text", length = 20, nullable = false)
    private String versionText;

    /**
     * <pre>
     * DB remark: APP名称
     * DB column: upgrade_app_name	VARCHAR(20)	<--->	appName	java.lang.String
     * DB is  Nullable: false
     * DB defaultValue: 
     * </pre>
     */
    @NotBlank(message = "{" + UpgradeBeanI18nConstant.UPGRADE_BEAN_APP_NAME_NOT_BLANK + "}", groups = {IBaseValidGroup.Add.class, IBaseValidGroup.Update.class})
    @Length(max = 20, message = "{" + UpgradeBeanI18nConstant.UPGRADE_BEAN_APP_NAME_LENGTH + "}", groups = {IBaseValidGroup.Add.class, IBaseValidGroup.Update.class})
    @Column(name = "upgrade_app_name", length = 20, nullable = false)
    private String appName;

    /**
     * <pre>
     * DB remark: 升级说明
     * DB column: upgrade_desc	VARCHAR(250)	<--->	desc	java.lang.String
     * DB is  Nullable: false
     * DB defaultValue: null
     * </pre>
     */
    @NotBlank(message = "{" + UpgradeBeanI18nConstant.UPGRADE_BEAN_DESC_NOT_BLANK + "}", groups = {IBaseValidGroup.Add.class, IBaseValidGroup.Update.class})
    @Length(max = 250, message = "{" + UpgradeBeanI18nConstant.UPGRADE_BEAN_DESC_LENGTH + "}", groups = {IBaseValidGroup.Add.class, IBaseValidGroup.Update.class})
    @Column(name = "upgrade_desc", length = 250, nullable = false)
    private String desc;

    /**
     * <pre>
     * DB remark: 强制升级标志Y/N
     * DB column: upgrade_force	CHAR(1)	<--->	force	java.lang.String
     * DB is  Nullable: false
     * DB defaultValue: null
     * </pre>
     */
    @NotBlank(message = "{" + UpgradeBeanI18nConstant.UPGRADE_BEAN_FORCE_NOT_BLANK + "}", groups = {IBaseValidGroup.Add.class, IBaseValidGroup.Update.class})
    @Length(max = 1, message = "{" + UpgradeBeanI18nConstant.UPGRADE_BEAN_FORCE_LENGTH + "}", groups = {IBaseValidGroup.Add.class, IBaseValidGroup.Update.class})
    @Column(name = "upgrade_force", length = 1, nullable = false)
    private String force;

    /**
     * <pre>
     * DB remark: 升级文件的md5
     * DB column: upgrade_md5	CHAR(32)	<--->	md5	java.lang.String
     * DB is  Nullable: false
     * DB defaultValue: null
     * </pre>
     */
    @NotBlank(message = "{" + UpgradeBeanI18nConstant.UPGRADE_BEAN_MD5_NOT_BLANK + "}", groups = {IBaseValidGroup.Add.class, IBaseValidGroup.Update.class})
    @Length(max = 32, message = "{" + UpgradeBeanI18nConstant.UPGRADE_BEAN_MD5_LENGTH + "}", groups = {IBaseValidGroup.Add.class, IBaseValidGroup.Update.class})
    @Column(name = "upgrade_md5", length = 32, nullable = false)
    private String md5;

    /**
     * <pre>
     * DB remark: app包的大小,存储的是Byte大小
     * DB column: upgrade_size	VARCHAR(30)	<--->	size	java.lang.String
     * DB is  Nullable: false
     * DB defaultValue: null
     * </pre>
     */
    @NotBlank(message = "{" + UpgradeBeanI18nConstant.UPGRADE_BEAN_SIZE_NOT_BLANK + "}", groups = {IBaseValidGroup.Add.class, IBaseValidGroup.Update.class})
    @Length(max = 30, message = "{" + UpgradeBeanI18nConstant.UPGRADE_BEAN_SIZE_LENGTH + "}", groups = {IBaseValidGroup.Add.class, IBaseValidGroup.Update.class})
    @Column(name = "upgrade_size", length = 30, nullable = false)
    private String size;

    /**
     * <pre>
     * DB remark: 下载文件的url
     * DB column: upgrade_url	VARCHAR(150)	<--->	url	java.lang.String
     * DB is  Nullable: false
     * DB defaultValue: null
     * </pre>
     */
    @NotBlank(message = "{" + UpgradeBeanI18nConstant.UPGRADE_BEAN_URL_NOT_BLANK + "}", groups = {IBaseValidGroup.Add.class, IBaseValidGroup.Update.class})
    @Length(max = 150, message = "{" + UpgradeBeanI18nConstant.UPGRADE_BEAN_URL_LENGTH + "}", groups = {IBaseValidGroup.Add.class, IBaseValidGroup.Update.class})
    @Column(name = "upgrade_url", length = 150, nullable = false)
    private String url;

    /**
     * <pre>
     * DB remark: crew_username字段关联
     * DB column: upgrade_create_by	VARCHAR(50)	<--->	createBy	java.lang.String
     * DB is  Nullable: false
     * DB defaultValue: null
     * </pre>
     */
    @NotBlank(message = "{" + UpgradeBeanI18nConstant.UPGRADE_BEAN_CREATE_BY_NOT_BLANK + "}", groups = {IBaseValidGroup.Add.class, IBaseValidGroup.Update.class})
    @Length(max = 50, message = "{" + UpgradeBeanI18nConstant.UPGRADE_BEAN_CREATE_BY_LENGTH + "}", groups = {IBaseValidGroup.Add.class, IBaseValidGroup.Update.class})
    @Column(name = "upgrade_create_by", length = 50, nullable = false)
    private String createBy;

    /**
     * <pre>
     * DB remark: 创建时间
     * DB column: upgrade_create_timestamp	TIMESTAMP(19)	<--->	createTimestamp	java.util.Date
     * DB is  Nullable: false
     * DB defaultValue: CURRENT_TIMESTAMP
     * </pre>
     */
    @ValidDateTimeFormat(pattern = DateUtil.DATE_PATTERN_YYYY_MM_DD_HH_MM_SS, message = "{" + UpgradeBeanI18nConstant.UPGRADE_BEAN_CREATE_TIMESTAMP_DATE_TIME_FORMAT + "}", groups = {IBaseValidGroup.Add.class, IBaseValidGroup.Update.class})
    @DateTimeFormat(pattern = DateUtil.DATE_PATTERN_YYYY_MM_DD_HH_MM_SS)
    @NotNull(message = "{" + UpgradeBeanI18nConstant.UPGRADE_BEAN_CREATE_TIMESTAMP_NOT_NULL + "}", groups = {IBaseValidGroup.Add.class, IBaseValidGroup.Update.class})
    @Column(name = "upgrade_create_timestamp", length = 19, nullable = false)
    private Date createTimestamp;

    /**
     * <pre>
     * DB remark: 逻辑删除标志【N[正常]，Y[删除]】
     * DB column: upgrade_delete_flag	CHAR(1)	<--->	deleteFlag	java.lang.String
     * DB is  Nullable: false
     * DB defaultValue: N
     * </pre>
     */
    @NotBlank(message = "{" + UpgradeBeanI18nConstant.UPGRADE_BEAN_DELETE_FLAG_NOT_BLANK + "}", groups = {IBaseValidGroup.Add.class, IBaseValidGroup.Update.class})
    @Length(max = 1, message = "{" + UpgradeBeanI18nConstant.UPGRADE_BEAN_DELETE_FLAG_LENGTH + "}", groups = {IBaseValidGroup.Add.class, IBaseValidGroup.Update.class})
    @Column(name = "upgrade_delete_flag", length = 1, nullable = false)
    private String deleteFlag;

    private static final long serialVersionUID = 1L;

    /**
     * 获取 数据库主键ID
     *
     * @return upgrade_id - 数据库主键ID
     */
    public Long getId() {
        return id;
    }

    /**
     * 设置 数据库主键ID
     *
     * @param id - 数据库主键ID
     */
    public UpgradeBean setId(Long id) {
        this.id = id;
        return this;
    }

    /**
     * 获取 版本号
     *
     * @return upgrade_version - 版本号
     */
    public Long getVersion() {
        return version;
    }

    /**
     * 设置 版本号
     *
     * @param version - 版本号
     */
    public UpgradeBean setVersion(Long version) {
        this.version = version;
        return this;
    }

    /**
     * 获取 版本,版本号对外文本说明
     *
     * @return upgrade_version_text - 版本,版本号对外文本说明
     */
    public String getVersionText() {
        return versionText;
    }

    /**
     * 设置 版本,版本号对外文本说明
     *
     * @param versionText - 版本,版本号对外文本说明
     */
    public UpgradeBean setVersionText(String versionText) {
        this.versionText = versionText == null ? null : versionText.trim();
        return this;
    }

    /**
     * 获取 APP名称
     *
     * @return upgrade_app_name - APP名称
     */
    public String getAppName() {
        return appName;
    }

    /**
     * 设置 APP名称
     *
     * @param appName - APP名称
     */
    public UpgradeBean setAppName(String appName) {
        this.appName = appName == null ? null : appName.trim();
        return this;
    }

    /**
     * 获取 升级说明
     *
     * @return upgrade_desc - 升级说明
     */
    public String getDesc() {
        return desc;
    }

    /**
     * 设置 升级说明
     *
     * @param desc - 升级说明
     */
    public UpgradeBean setDesc(String desc) {
        this.desc = desc == null ? null : desc.trim();
        return this;
    }

    /**
     * 获取 强制升级标志Y/N
     *
     * @return upgrade_force - 强制升级标志Y/N
     */
    public String getForce() {
        return force;
    }

    /**
     * 设置 强制升级标志Y/N
     *
     * @param force - 强制升级标志Y/N
     */
    public UpgradeBean setForce(String force) {
        this.force = force == null ? null : force.trim();
        return this;
    }

    /**
     * 获取 升级文件的md5
     *
     * @return upgrade_md5 - 升级文件的md5
     */
    public String getMd5() {
        return md5;
    }

    /**
     * 设置 升级文件的md5
     *
     * @param md5 - 升级文件的md5
     */
    public UpgradeBean setMd5(String md5) {
        this.md5 = md5 == null ? null : md5.trim();
        return this;
    }

    /**
     * 获取 app包的大小,存储的是Byte大小
     *
     * @return upgrade_size - app包的大小,存储的是Byte大小
     */
    public String getSize() {
        return size;
    }

    /**
     * 设置 app包的大小,存储的是Byte大小
     *
     * @param size - app包的大小,存储的是Byte大小
     */
    public UpgradeBean setSize(String size) {
        this.size = size == null ? null : size.trim();
        return this;
    }

    /**
     * 获取 下载文件的url
     *
     * @return upgrade_url - 下载文件的url
     */
    public String getUrl() {
        return url;
    }

    /**
     * 设置 下载文件的url
     *
     * @param url - 下载文件的url
     */
    public UpgradeBean setUrl(String url) {
        this.url = url == null ? null : url.trim();
        return this;
    }

    /**
     * 获取 crew_username字段关联
     *
     * @return upgrade_create_by - crew_username字段关联
     */
    public String getCreateBy() {
        return createBy;
    }

    /**
     * 设置 crew_username字段关联
     *
     * @param createBy - crew_username字段关联
     */
    public UpgradeBean setCreateBy(String createBy) {
        this.createBy = createBy == null ? null : createBy.trim();
        return this;
    }

    /**
     * 获取 创建时间
     *
     * @return upgrade_create_timestamp - 创建时间
     */
    public Date getCreateTimestamp() {
        return createTimestamp;
    }

    /**
     * 设置 创建时间
     *
     * @param createTimestamp - 创建时间
     */
    public UpgradeBean setCreateTimestamp(Date createTimestamp) {
        this.createTimestamp = createTimestamp;
        return this;
    }

    /**
     * 获取 逻辑删除标志【N[正常]，Y[删除]】
     *
     * @return upgrade_delete_flag - 逻辑删除标志【N[正常]，Y[删除]】
     */
    public String getDeleteFlag() {
        return deleteFlag;
    }

    /**
     * 设置 逻辑删除标志【N[正常]，Y[删除]】
     *
     * @param deleteFlag - 逻辑删除标志【N[正常]，Y[删除]】
     */
    public UpgradeBean setDeleteFlag(String deleteFlag) {
        this.deleteFlag = deleteFlag == null ? null : deleteFlag.trim();
        return this;
    }
}