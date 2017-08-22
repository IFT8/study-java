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
@Table(name = "t_bank_atm_log")
public class BankAtmLogBean implements Serializable {
    /**
     * <pre>
     * DB remark: 数据库主键ID
     * DB column: atm_id	BIGINT(20)	<--->	id	java.lang.Long
     * DB is  Nullable: false
     * DB defaultValue: null
     * </pre>
     */
    @NotNull(message = "{BANK_ATM_LOG_BEAN_ID_NOT_NULL}", groups = {IBaseValidGroup.Add.class, IBaseValidGroup.Update.class})
    @ValidLength(max = 20, message = "{BANK_ATM_LOG_BEAN_ID_LENGTH}", groups = {IBaseValidGroup.Add.class, IBaseValidGroup.Update.class})
    @Id
    @Column(name = "atm_id", length = 20, nullable = false)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    /**
     * <pre>
     * DB remark: ATM外部编号,在调用第三方接口里的唯一标识
     * DB column: atm_external_id	VARCHAR(15)	<--->	externalId	java.lang.String
     * DB is  Nullable: false
     * DB defaultValue: null
     * </pre>
     */
    @NotBlank(message = "{BANK_ATM_LOG_BEAN_EXTERNAL_ID_NOT_BLANK}", groups = {IBaseValidGroup.Add.class, IBaseValidGroup.Update.class})
    @Length(max = 15, message = "{BANK_ATM_LOG_BEAN_EXTERNAL_ID_LENGTH}", groups = {IBaseValidGroup.Add.class, IBaseValidGroup.Update.class})
    @Column(name = "atm_external_id", length = 15, nullable = false)
    private String externalId;

    /**
     * <pre>
     * DB remark: 设备id
     * DB column: atm_dispositivo	VARCHAR(20)	<--->	dispositivo	java.lang.String
     * DB is  Nullable: false
     * DB defaultValue: null
     * </pre>
     */
    @NotBlank(message = "{BANK_ATM_LOG_BEAN_DISPOSITIVO_NOT_BLANK}", groups = {IBaseValidGroup.Add.class, IBaseValidGroup.Update.class})
    @Length(max = 20, message = "{BANK_ATM_LOG_BEAN_DISPOSITIVO_LENGTH}", groups = {IBaseValidGroup.Add.class, IBaseValidGroup.Update.class})
    @Column(name = "atm_dispositivo", length = 20, nullable = false)
    private String dispositivo;

    /**
     * <pre>
     * DB remark: 美国不使用
     * DB column: atm_consecutivo	BIGINT(19)	<--->	consecutivo	java.lang.Long
     * DB is  Nullable: false
     * DB defaultValue: 0
     * </pre>
     */
    @NotNull(message = "{BANK_ATM_LOG_BEAN_CONSECUTIVO_NOT_NULL}", groups = {IBaseValidGroup.Add.class, IBaseValidGroup.Update.class})
    @ValidLength(max = 19, message = "{BANK_ATM_LOG_BEAN_CONSECUTIVO_LENGTH}", groups = {IBaseValidGroup.Add.class, IBaseValidGroup.Update.class})
    @Column(name = "atm_consecutivo", length = 19, nullable = false)
    private Long consecutivo;

    /**
     * <pre>
     * DB remark: ATM内部编号
     * DB column: atm_internal_id	VARCHAR(15)	<--->	internalId	java.lang.String
     * DB is  Nullable: false
     * DB defaultValue: 
     * </pre>
     */
    @NotBlank(message = "{BANK_ATM_LOG_BEAN_INTERNAL_ID_NOT_BLANK}", groups = {IBaseValidGroup.Add.class, IBaseValidGroup.Update.class})
    @Length(max = 15, message = "{BANK_ATM_LOG_BEAN_INTERNAL_ID_LENGTH}", groups = {IBaseValidGroup.Add.class, IBaseValidGroup.Update.class})
    @Column(name = "atm_internal_id", length = 15, nullable = false)
    private String internalId;

    /**
     * <pre>
     * DB remark: 出错状态码（暂未定义）
     * DB column: atm_error_code	CHAR(10)	<--->	errorCode	java.lang.String
     * DB is  Nullable: false
     * DB defaultValue: null
     * </pre>
     */
    @NotBlank(message = "{BANK_ATM_LOG_BEAN_ERROR_CODE_NOT_BLANK}", groups = {IBaseValidGroup.Add.class, IBaseValidGroup.Update.class})
    @Length(max = 10, message = "{BANK_ATM_LOG_BEAN_ERROR_CODE_LENGTH}", groups = {IBaseValidGroup.Add.class, IBaseValidGroup.Update.class})
    @Column(name = "atm_error_code", length = 10, nullable = false)
    private String errorCode;

    /**
     * <pre>
     * DB remark: 出错描述
     * DB column: atm_description	CHAR(100)	<--->	description	java.lang.String
     * DB is  Nullable: true
     * DB defaultValue: null
     * </pre>
     */
    @Length(max = 100, message = "{BANK_ATM_LOG_BEAN_DESCRIPTION_LENGTH}", groups = {IBaseValidGroup.Add.class, IBaseValidGroup.Update.class})
    @Column(name = "atm_description", length = 100, nullable = true)
    private String description;

    /**
     * <pre>
     * DB remark: ATM,获取数据的时间戳字段,类型:DateTime(yyyy-MM-dd HH:mm:ss)
     * DB column: atm_upload_timestamp	TIMESTAMP(19)	<--->	uploadTimestamp	java.util.Date
     * DB is  Nullable: false
     * DB defaultValue: null
     * </pre>
     */
    @ValidDateTimeFormat(pattern = DateUtil.DATE_PATTERN_YYYY_MM_DD_HH_MM_SS , message = "{BANK_ATM_LOG_BEAN_UPLOAD_TIMESTAMP_DATE_TIME_FORMAT}", groups = {IBaseValidGroup.Add.class, IBaseValidGroup.Update.class})
    @DateTimeFormat(pattern = DateUtil.DATE_PATTERN_YYYY_MM_DD_HH_MM_SS)
    @NotNull(message = "{BANK_ATM_LOG_BEAN_UPLOAD_TIMESTAMP_NOT_NULL}", groups = {IBaseValidGroup.Add.class, IBaseValidGroup.Update.class})
    @Column(name = "atm_upload_timestamp", length = 19, nullable = false)
    private Date uploadTimestamp;

    /**
     * <pre>
     * DB remark: 状态 字段类型:CHAR(7)值:NOT NULL【以 ENABLE、DISABLE】默认值:ENABLE
     * DB column: atm_unit_status	CHAR(7)	<--->	unitStatus	java.lang.String
     * DB is  Nullable: false
     * DB defaultValue: ENABLE
     * </pre>
     */
    @NotBlank(message = "{BANK_ATM_LOG_BEAN_UNIT_STATUS_NOT_BLANK}", groups = {IBaseValidGroup.Add.class, IBaseValidGroup.Update.class})
    @Length(max = 7, message = "{BANK_ATM_LOG_BEAN_UNIT_STATUS_LENGTH}", groups = {IBaseValidGroup.Add.class, IBaseValidGroup.Update.class})
    @Column(name = "atm_unit_status", length = 7, nullable = false)
    private String unitStatus;

    /**
     * <pre>
     * DB remark: 创建时间
     * DB column: atm_create_timestamp	TIMESTAMP(19)	<--->	createTimestamp	java.util.Date
     * DB is  Nullable: false
     * DB defaultValue: CURRENT_TIMESTAMP
     * </pre>
     */
    @ValidDateTimeFormat(pattern = DateUtil.DATE_PATTERN_YYYY_MM_DD_HH_MM_SS , message = "{BANK_ATM_LOG_BEAN_CREATE_TIMESTAMP_DATE_TIME_FORMAT}", groups = {IBaseValidGroup.Add.class, IBaseValidGroup.Update.class})
    @DateTimeFormat(pattern = DateUtil.DATE_PATTERN_YYYY_MM_DD_HH_MM_SS)
    @NotNull(message = "{BANK_ATM_LOG_BEAN_CREATE_TIMESTAMP_NOT_NULL}", groups = {IBaseValidGroup.Add.class, IBaseValidGroup.Update.class})
    @Column(name = "atm_create_timestamp", length = 19, nullable = false)
    private Date createTimestamp;

    private static final long serialVersionUID = 1L;

    /**
     * 获取 数据库主键ID
     *
     * @return atm_id - 数据库主键ID
     */
    public Long getId() {
        return id;
    }

    /**
     * 设置 数据库主键ID
     *
     * @param id - 数据库主键ID
     */
    public BankAtmLogBean setId(Long id) {
        this.id = id;
        return this;
    }

    /**
     * 获取 ATM外部编号,在调用第三方接口里的唯一标识
     *
     * @return atm_external_id - ATM外部编号,在调用第三方接口里的唯一标识
     */
    public String getExternalId() {
        return externalId;
    }

    /**
     * 设置 ATM外部编号,在调用第三方接口里的唯一标识
     *
     * @param externalId - ATM外部编号,在调用第三方接口里的唯一标识
     */
    public BankAtmLogBean setExternalId(String externalId) {
        this.externalId = externalId == null ? null : externalId.trim();
        return this;
    }

    /**
     * 获取 设备id
     *
     * @return atm_dispositivo - 设备id
     */
    public String getDispositivo() {
        return dispositivo;
    }

    /**
     * 设置 设备id
     *
     * @param dispositivo - 设备id
     */
    public BankAtmLogBean setDispositivo(String dispositivo) {
        this.dispositivo = dispositivo == null ? null : dispositivo.trim();
        return this;
    }

    /**
     * 获取 美国不使用
     *
     * @return atm_consecutivo - 美国不使用
     */
    public Long getConsecutivo() {
        return consecutivo;
    }

    /**
     * 设置 美国不使用
     *
     * @param consecutivo - 美国不使用
     */
    public BankAtmLogBean setConsecutivo(Long consecutivo) {
        this.consecutivo = consecutivo;
        return this;
    }

    /**
     * 获取 ATM内部编号
     *
     * @return atm_internal_id - ATM内部编号
     */
    public String getInternalId() {
        return internalId;
    }

    /**
     * 设置 ATM内部编号
     *
     * @param internalId - ATM内部编号
     */
    public BankAtmLogBean setInternalId(String internalId) {
        this.internalId = internalId == null ? null : internalId.trim();
        return this;
    }

    /**
     * 获取 出错状态码（暂未定义）
     *
     * @return atm_error_code - 出错状态码（暂未定义）
     */
    public String getErrorCode() {
        return errorCode;
    }

    /**
     * 设置 出错状态码（暂未定义）
     *
     * @param errorCode - 出错状态码（暂未定义）
     */
    public BankAtmLogBean setErrorCode(String errorCode) {
        this.errorCode = errorCode == null ? null : errorCode.trim();
        return this;
    }

    /**
     * 获取 出错描述
     *
     * @return atm_description - 出错描述
     */
    public String getDescription() {
        return description;
    }

    /**
     * 设置 出错描述
     *
     * @param description - 出错描述
     */
    public BankAtmLogBean setDescription(String description) {
        this.description = description == null ? null : description.trim();
        return this;
    }

    /**
     * 获取 ATM,获取数据的时间戳字段,类型:DateTime(yyyy-MM-dd HH:mm:ss)
     *
     * @return atm_upload_timestamp - ATM,获取数据的时间戳字段,类型:DateTime(yyyy-MM-dd HH:mm:ss)
     */
    public Date getUploadTimestamp() {
        return uploadTimestamp;
    }

    /**
     * 设置 ATM,获取数据的时间戳字段,类型:DateTime(yyyy-MM-dd HH:mm:ss)
     *
     * @param uploadTimestamp - ATM,获取数据的时间戳字段,类型:DateTime(yyyy-MM-dd HH:mm:ss)
     */
    public BankAtmLogBean setUploadTimestamp(Date uploadTimestamp) {
        this.uploadTimestamp = uploadTimestamp;
        return this;
    }

    /**
     * 获取 状态 字段类型:CHAR(7)值:NOT NULL【以 ENABLE、DISABLE】默认值:ENABLE
     *
     * @return atm_unit_status - 状态 字段类型:CHAR(7)值:NOT NULL【以 ENABLE、DISABLE】默认值:ENABLE
     */
    public String getUnitStatus() {
        return unitStatus;
    }

    /**
     * 设置 状态 字段类型:CHAR(7)值:NOT NULL【以 ENABLE、DISABLE】默认值:ENABLE
     *
     * @param unitStatus - 状态 字段类型:CHAR(7)值:NOT NULL【以 ENABLE、DISABLE】默认值:ENABLE
     */
    public BankAtmLogBean setUnitStatus(String unitStatus) {
        this.unitStatus = unitStatus == null ? null : unitStatus.trim();
        return this;
    }

    /**
     * 获取 创建时间
     *
     * @return atm_create_timestamp - 创建时间
     */
    public Date getCreateTimestamp() {
        return createTimestamp;
    }

    /**
     * 设置 创建时间
     *
     * @param createTimestamp - 创建时间
     */
    public BankAtmLogBean setCreateTimestamp(Date createTimestamp) {
        this.createTimestamp = createTimestamp;
        return this;
    }
}