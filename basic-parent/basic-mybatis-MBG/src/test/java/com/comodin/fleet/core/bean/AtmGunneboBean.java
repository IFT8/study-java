package com.comodin.fleet.core.bean;

import com.comodin.basic.util.date.DateUtil;
import com.comodin.basic.validation.IBaseValidGroup;
import com.comodin.basic.validation.constraints.*;
import com.comodin.fleet.constants.i18n.AtmGunneboBeanI18nConstant;
import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;
import javax.persistence.*;
import javax.validation.constraints.*;
import org.hibernate.validator.constraints.*;
import org.springframework.format.annotation.DateTimeFormat;

@SuppressWarnings({"unused", "SpringAutowiredFieldsWarningInspection", "StatementWithEmptyBody", "WeakerAccess", "DefaultAnnotationParam"})
@Entity
@Table(name = "t_atm_gunnebo")
public class AtmGunneboBean implements Serializable {
    /**
     * <pre>
     * DB remark: 数据库主键ID
     * DB column: gunnebo_id	BIGINT(20)	<--->	id	java.lang.Long
     * DB is  Nullable: false
     * DB defaultValue: null
     * </pre>
     */
    @NotNull(message = "{" + AtmGunneboBeanI18nConstant.ATM_GUNNEBO_BEAN_ID_NOT_NULL + "}", groups = {IBaseValidGroup.Update.class})
    @ValidLength(max = 20, message = "{" + AtmGunneboBeanI18nConstant.ATM_GUNNEBO_BEAN_ID_LENGTH + "}", groups = {IBaseValidGroup.Update.class})
    @Column(name = "gunnebo_id", length = 20, nullable = false)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    private Long id;

    /**
     * <pre>
     * DB remark: ATM终端，唯一标识
     * DB column: gunnebo_atm_terminal_id	VARCHAR(64)	<--->	atmTerminalId	java.lang.String
     * DB is  Nullable: false
     * DB defaultValue: null
     * </pre>
     */
    @NotBlank(message = "{" + AtmGunneboBeanI18nConstant.ATM_GUNNEBO_BEAN_ATM_TERMINAL_ID_NOT_BLANK + "}", groups = {IBaseValidGroup.Add.class, IBaseValidGroup.Update.class})
    @Length(max = 64, message = "{" + AtmGunneboBeanI18nConstant.ATM_GUNNEBO_BEAN_ATM_TERMINAL_ID_LENGTH + "}", groups = {IBaseValidGroup.Add.class, IBaseValidGroup.Update.class})
    @Column(name = "gunnebo_atm_terminal_id", length = 64, nullable = false)
    private String atmTerminalId;

    /**
     * <pre>
     * DB remark: ATM终端，设备类型
     * DB column: gunnebo_atm_terminal_type	VARCHAR(20)	<--->	atmTerminalType	java.lang.String
     * DB is  Nullable: false
     * DB defaultValue: null
     * </pre>
     */
    @NotBlank(message = "{" + AtmGunneboBeanI18nConstant.ATM_GUNNEBO_BEAN_ATM_TERMINAL_TYPE_NOT_BLANK + "}", groups = {IBaseValidGroup.Add.class, IBaseValidGroup.Update.class})
    @Length(max = 20, message = "{" + AtmGunneboBeanI18nConstant.ATM_GUNNEBO_BEAN_ATM_TERMINAL_TYPE_LENGTH + "}", groups = {IBaseValidGroup.Add.class, IBaseValidGroup.Update.class})
    @Column(name = "gunnebo_atm_terminal_type", length = 20, nullable = false)
    private String atmTerminalType;

    /**
     * <pre>
     * DB remark: 状态【String [Estatus] nchar(1) COLLATE Modern_Spanish_CI_AI NULL DEFAULT (N'A')】
     * DB column: gunnebo_status	VARCHAR(20)	<--->	status	java.lang.String
     * DB is  Nullable: true
     * DB defaultValue: null
     * </pre>
     */
    @Length(max = 20, message = "{" + AtmGunneboBeanI18nConstant.ATM_GUNNEBO_BEAN_STATUS_LENGTH + "}", groups = {IBaseValidGroup.Add.class, IBaseValidGroup.Update.class})
    @Column(name = "gunnebo_status", length = 20, nullable = true)
    private String status;

    /**
     * <pre>
     * DB remark: 设备状态【String [estatusMaquina] varchar(10) COLLATE Modern_Spanish_CI_AI NULL】
     * DB column: gunnebo_device_status	VARCHAR(10)	<--->	deviceStatus	java.lang.String
     * DB is  Nullable: true
     * DB defaultValue: null
     * </pre>
     */
    @Length(max = 10, message = "{" + AtmGunneboBeanI18nConstant.ATM_GUNNEBO_BEAN_DEVICE_STATUS_LENGTH + "}", groups = {IBaseValidGroup.Add.class, IBaseValidGroup.Update.class})
    @Column(name = "gunnebo_device_status", length = 10, nullable = true)
    private String deviceStatus;

    /**
     * <pre>
     * DB remark: 交易状态【Integer [estatusTransaccion] int NULL】
     * DB column: gunnebo_transaction_status	VARCHAR(15)	<--->	transactionStatus	java.lang.String
     * DB is  Nullable: true
     * DB defaultValue: null
     * </pre>
     */
    @Length(max = 15, message = "{" + AtmGunneboBeanI18nConstant.ATM_GUNNEBO_BEAN_TRANSACTION_STATUS_LENGTH + "}", groups = {IBaseValidGroup.Add.class, IBaseValidGroup.Update.class})
    @Column(name = "gunnebo_transaction_status", length = 15, nullable = true)
    private String transactionStatus;

    /**
     * <pre>
     * DB remark: 货币,总金额
     * DB column: gunnebo_currency_total_amount	DECIMAL(14)	<--->	currencyTotalAmount	java.math.BigDecimal
     * DB is  Nullable: true
     * DB defaultValue: 0.0000
     * </pre>
     */
    @Column(name = "gunnebo_currency_total_amount", length = 14, nullable = true)
    private BigDecimal currencyTotalAmount;

    /**
     * <pre>
     * DB remark: 货币,当前容量【单位：张】
     * DB column: gunnebo_current_capacity	INTEGER(10)	<--->	currentCapacity	java.lang.Integer
     * DB is  Nullable: true
     * DB defaultValue: 0
     * </pre>
     */
    @ValidLength(max = 10, message = "{" + AtmGunneboBeanI18nConstant.ATM_GUNNEBO_BEAN_CURRENT_CAPACITY_LENGTH + "}", groups = {IBaseValidGroup.Add.class, IBaseValidGroup.Update.class})
    @Column(name = "gunnebo_current_capacity", length = 10, nullable = true)
    private Integer currentCapacity;

    /**
     * <pre>
     * DB remark: 货币,最大容量【单位：张】
     * DB column: gunnebo_currency_max_capacity	INTEGER(10)	<--->	currencyMaxCapacity	java.lang.Integer
     * DB is  Nullable: true
     * DB defaultValue: 0
     * </pre>
     */
    @ValidLength(max = 10, message = "{" + AtmGunneboBeanI18nConstant.ATM_GUNNEBO_BEAN_CURRENCY_MAX_CAPACITY_LENGTH + "}", groups = {IBaseValidGroup.Add.class, IBaseValidGroup.Update.class})
    @Column(name = "gunnebo_currency_max_capacity", length = 10, nullable = true)
    private Integer currencyMaxCapacity;

    /**
     * <pre>
     * DB remark: 货币,类型
     * DB column: gunnebo_currency_type	VARCHAR(5)	<--->	currencyType	java.lang.String
     * DB is  Nullable: true
     * DB defaultValue: null
     * </pre>
     */
    @Length(max = 5, message = "{" + AtmGunneboBeanI18nConstant.ATM_GUNNEBO_BEAN_CURRENCY_TYPE_LENGTH + "}", groups = {IBaseValidGroup.Add.class, IBaseValidGroup.Update.class})
    @Column(name = "gunnebo_currency_type", length = 5, nullable = true)
    private String currencyType;

    /**
     * <pre>
     * DB remark: 信封,总数【单位：张】
     * DB column: gunnebo_envelopes_total_amount	INTEGER(10)	<--->	envelopesTotalAmount	java.lang.Integer
     * DB is  Nullable: true
     * DB defaultValue: 0
     * </pre>
     */
    @ValidLength(max = 10, message = "{" + AtmGunneboBeanI18nConstant.ATM_GUNNEBO_BEAN_ENVELOPES_TOTAL_AMOUNT_LENGTH + "}", groups = {IBaseValidGroup.Add.class, IBaseValidGroup.Update.class})
    @Column(name = "gunnebo_envelopes_total_amount", length = 10, nullable = true)
    private Integer envelopesTotalAmount;

    /**
     * <pre>
     * DB remark: 信封,当前容量【单位：张】
     * DB column: gunnebo_envelopes_capacity	INTEGER(10)	<--->	envelopesCapacity	java.lang.Integer
     * DB is  Nullable: true
     * DB defaultValue: 0
     * </pre>
     */
    @ValidLength(max = 10, message = "{" + AtmGunneboBeanI18nConstant.ATM_GUNNEBO_BEAN_ENVELOPES_CAPACITY_LENGTH + "}", groups = {IBaseValidGroup.Add.class, IBaseValidGroup.Update.class})
    @Column(name = "gunnebo_envelopes_capacity", length = 10, nullable = true)
    private Integer envelopesCapacity;

    /**
     * <pre>
     * DB remark: 信封,最大容量【单位：张】
     * DB column: gunnebo_envelopes_max_capacity	INTEGER(10)	<--->	envelopesMaxCapacity	java.lang.Integer
     * DB is  Nullable: true
     * DB defaultValue: 0
     * </pre>
     */
    @ValidLength(max = 10, message = "{" + AtmGunneboBeanI18nConstant.ATM_GUNNEBO_BEAN_ENVELOPES_MAX_CAPACITY_LENGTH + "}", groups = {IBaseValidGroup.Add.class, IBaseValidGroup.Update.class})
    @Column(name = "gunnebo_envelopes_max_capacity", length = 10, nullable = true)
    private Integer envelopesMaxCapacity;

    /**
     * <pre>
     * DB remark: 创建的用户
     * DB column: gunnebo_create_by	VARCHAR(20)	<--->	createBy	java.lang.String
     * DB is  Nullable: false
     * DB defaultValue: null
     * </pre>
     */
    @NotBlank(message = "{" + AtmGunneboBeanI18nConstant.ATM_GUNNEBO_BEAN_CREATE_BY_NOT_BLANK + "}", groups = {IBaseValidGroup.Add.class, IBaseValidGroup.Update.class})
    @Length(max = 20, message = "{" + AtmGunneboBeanI18nConstant.ATM_GUNNEBO_BEAN_CREATE_BY_LENGTH + "}", groups = {IBaseValidGroup.Add.class, IBaseValidGroup.Update.class})
    @Column(name = "gunnebo_create_by", length = 20, nullable = false)
    private String createBy;

    /**
     * <pre>
     * DB remark: 创建时间
     * DB column: gunnebo_create_timestamp	TIMESTAMP(19)	<--->	createTimestamp	java.util.Date
     * DB is  Nullable: false
     * DB defaultValue: CURRENT_TIMESTAMP
     * </pre>
     */
    @ValidDateTimeFormat(pattern = DateUtil.DATE_PATTERN_YYYY_MM_DD_HH_MM_SS, message = "{" + AtmGunneboBeanI18nConstant.ATM_GUNNEBO_BEAN_CREATE_TIMESTAMP_DATE_TIME_FORMAT + "}", groups = {IBaseValidGroup.Add.class, IBaseValidGroup.Update.class})
    @DateTimeFormat(pattern = DateUtil.DATE_PATTERN_YYYY_MM_DD_HH_MM_SS)
    @NotNull(message = "{" + AtmGunneboBeanI18nConstant.ATM_GUNNEBO_BEAN_CREATE_TIMESTAMP_NOT_NULL + "}", groups = {IBaseValidGroup.Add.class, IBaseValidGroup.Update.class})
    @Column(name = "gunnebo_create_timestamp", length = 19, nullable = false)
    private Date createTimestamp;

    /**
     * <pre>
     * DB remark: 更新时间
     * DB column: gunnebo_update_timestamp	TIMESTAMP(19)	<--->	updateTimestamp	java.util.Date
     * DB is  Nullable: false
     * DB defaultValue: CURRENT_TIMESTAMP
     * </pre>
     */
    @ValidDateTimeFormat(pattern = DateUtil.DATE_PATTERN_YYYY_MM_DD_HH_MM_SS, message = "{" + AtmGunneboBeanI18nConstant.ATM_GUNNEBO_BEAN_UPDATE_TIMESTAMP_DATE_TIME_FORMAT + "}", groups = {IBaseValidGroup.Add.class, IBaseValidGroup.Update.class})
    @DateTimeFormat(pattern = DateUtil.DATE_PATTERN_YYYY_MM_DD_HH_MM_SS)
    @NotNull(message = "{" + AtmGunneboBeanI18nConstant.ATM_GUNNEBO_BEAN_UPDATE_TIMESTAMP_NOT_NULL + "}", groups = {IBaseValidGroup.Add.class, IBaseValidGroup.Update.class})
    @Column(name = "gunnebo_update_timestamp", length = 19, nullable = false)
    private Date updateTimestamp;

    /**
     * <pre>
     * DB remark: 逻辑删除标志【N[正常]，Y[删除]】
     * DB column: gunnebo_delete_flag	CHAR(1)	<--->	deleteFlag	java.lang.String
     * DB is  Nullable: false
     * DB defaultValue: N
     * </pre>
     */
    @NotBlank(message = "{" + AtmGunneboBeanI18nConstant.ATM_GUNNEBO_BEAN_DELETE_FLAG_NOT_BLANK + "}", groups = {IBaseValidGroup.Add.class, IBaseValidGroup.Update.class})
    @Length(max = 1, message = "{" + AtmGunneboBeanI18nConstant.ATM_GUNNEBO_BEAN_DELETE_FLAG_LENGTH + "}", groups = {IBaseValidGroup.Add.class, IBaseValidGroup.Update.class})
    @Column(name = "gunnebo_delete_flag", length = 1, nullable = false)
    private String deleteFlag;

    private static final long serialVersionUID = 1L;

    /**
     * 获取 数据库主键ID
     *
     * @return gunnebo_id - 数据库主键ID
     */
    public Long getId() {
        return id;
    }

    /**
     * 设置 数据库主键ID
     *
     * @param id - 数据库主键ID
     */
    public AtmGunneboBean setId(Long id) {
        this.id = id;
        return this;
    }

    /**
     * 获取 ATM终端，唯一标识
     *
     * @return gunnebo_atm_terminal_id - ATM终端，唯一标识
     */
    public String getAtmTerminalId() {
        return atmTerminalId;
    }

    /**
     * 设置 ATM终端，唯一标识
     *
     * @param atmTerminalId - ATM终端，唯一标识
     */
    public AtmGunneboBean setAtmTerminalId(String atmTerminalId) {
        this.atmTerminalId = atmTerminalId == null ? null : atmTerminalId.trim();
        return this;
    }

    /**
     * 获取 ATM终端，设备类型
     *
     * @return gunnebo_atm_terminal_type - ATM终端，设备类型
     */
    public String getAtmTerminalType() {
        return atmTerminalType;
    }

    /**
     * 设置 ATM终端，设备类型
     *
     * @param atmTerminalType - ATM终端，设备类型
     */
    public AtmGunneboBean setAtmTerminalType(String atmTerminalType) {
        this.atmTerminalType = atmTerminalType == null ? null : atmTerminalType.trim();
        return this;
    }

    /**
     * 获取 状态【String [Estatus] nchar(1) COLLATE Modern_Spanish_CI_AI NULL DEFAULT (N'A')】
     *
     * @return gunnebo_status - 状态【String [Estatus] nchar(1) COLLATE Modern_Spanish_CI_AI NULL DEFAULT (N'A')】
     */
    public String getStatus() {
        return status;
    }

    /**
     * 设置 状态【String [Estatus] nchar(1) COLLATE Modern_Spanish_CI_AI NULL DEFAULT (N'A')】
     *
     * @param status - 状态【String [Estatus] nchar(1) COLLATE Modern_Spanish_CI_AI NULL DEFAULT (N'A')】
     */
    public AtmGunneboBean setStatus(String status) {
        this.status = status == null ? null : status.trim();
        return this;
    }

    /**
     * 获取 设备状态【String [estatusMaquina] varchar(10) COLLATE Modern_Spanish_CI_AI NULL】
     *
     * @return gunnebo_device_status - 设备状态【String [estatusMaquina] varchar(10) COLLATE Modern_Spanish_CI_AI NULL】
     */
    public String getDeviceStatus() {
        return deviceStatus;
    }

    /**
     * 设置 设备状态【String [estatusMaquina] varchar(10) COLLATE Modern_Spanish_CI_AI NULL】
     *
     * @param deviceStatus - 设备状态【String [estatusMaquina] varchar(10) COLLATE Modern_Spanish_CI_AI NULL】
     */
    public AtmGunneboBean setDeviceStatus(String deviceStatus) {
        this.deviceStatus = deviceStatus == null ? null : deviceStatus.trim();
        return this;
    }

    /**
     * 获取 交易状态【Integer [estatusTransaccion] int NULL】
     *
     * @return gunnebo_transaction_status - 交易状态【Integer [estatusTransaccion] int NULL】
     */
    public String getTransactionStatus() {
        return transactionStatus;
    }

    /**
     * 设置 交易状态【Integer [estatusTransaccion] int NULL】
     *
     * @param transactionStatus - 交易状态【Integer [estatusTransaccion] int NULL】
     */
    public AtmGunneboBean setTransactionStatus(String transactionStatus) {
        this.transactionStatus = transactionStatus == null ? null : transactionStatus.trim();
        return this;
    }

    /**
     * 获取 货币,总金额
     *
     * @return gunnebo_currency_total_amount - 货币,总金额
     */
    public BigDecimal getCurrencyTotalAmount() {
        return currencyTotalAmount;
    }

    /**
     * 设置 货币,总金额
     *
     * @param currencyTotalAmount - 货币,总金额
     */
    public AtmGunneboBean setCurrencyTotalAmount(BigDecimal currencyTotalAmount) {
        this.currencyTotalAmount = currencyTotalAmount;
        return this;
    }

    /**
     * 获取 货币,当前容量【单位：张】
     *
     * @return gunnebo_current_capacity - 货币,当前容量【单位：张】
     */
    public Integer getCurrentCapacity() {
        return currentCapacity;
    }

    /**
     * 设置 货币,当前容量【单位：张】
     *
     * @param currentCapacity - 货币,当前容量【单位：张】
     */
    public AtmGunneboBean setCurrentCapacity(Integer currentCapacity) {
        this.currentCapacity = currentCapacity;
        return this;
    }

    /**
     * 获取 货币,最大容量【单位：张】
     *
     * @return gunnebo_currency_max_capacity - 货币,最大容量【单位：张】
     */
    public Integer getCurrencyMaxCapacity() {
        return currencyMaxCapacity;
    }

    /**
     * 设置 货币,最大容量【单位：张】
     *
     * @param currencyMaxCapacity - 货币,最大容量【单位：张】
     */
    public AtmGunneboBean setCurrencyMaxCapacity(Integer currencyMaxCapacity) {
        this.currencyMaxCapacity = currencyMaxCapacity;
        return this;
    }

    /**
     * 获取 货币,类型
     *
     * @return gunnebo_currency_type - 货币,类型
     */
    public String getCurrencyType() {
        return currencyType;
    }

    /**
     * 设置 货币,类型
     *
     * @param currencyType - 货币,类型
     */
    public AtmGunneboBean setCurrencyType(String currencyType) {
        this.currencyType = currencyType == null ? null : currencyType.trim();
        return this;
    }

    /**
     * 获取 信封,总数【单位：张】
     *
     * @return gunnebo_envelopes_total_amount - 信封,总数【单位：张】
     */
    public Integer getEnvelopesTotalAmount() {
        return envelopesTotalAmount;
    }

    /**
     * 设置 信封,总数【单位：张】
     *
     * @param envelopesTotalAmount - 信封,总数【单位：张】
     */
    public AtmGunneboBean setEnvelopesTotalAmount(Integer envelopesTotalAmount) {
        this.envelopesTotalAmount = envelopesTotalAmount;
        return this;
    }

    /**
     * 获取 信封,当前容量【单位：张】
     *
     * @return gunnebo_envelopes_capacity - 信封,当前容量【单位：张】
     */
    public Integer getEnvelopesCapacity() {
        return envelopesCapacity;
    }

    /**
     * 设置 信封,当前容量【单位：张】
     *
     * @param envelopesCapacity - 信封,当前容量【单位：张】
     */
    public AtmGunneboBean setEnvelopesCapacity(Integer envelopesCapacity) {
        this.envelopesCapacity = envelopesCapacity;
        return this;
    }

    /**
     * 获取 信封,最大容量【单位：张】
     *
     * @return gunnebo_envelopes_max_capacity - 信封,最大容量【单位：张】
     */
    public Integer getEnvelopesMaxCapacity() {
        return envelopesMaxCapacity;
    }

    /**
     * 设置 信封,最大容量【单位：张】
     *
     * @param envelopesMaxCapacity - 信封,最大容量【单位：张】
     */
    public AtmGunneboBean setEnvelopesMaxCapacity(Integer envelopesMaxCapacity) {
        this.envelopesMaxCapacity = envelopesMaxCapacity;
        return this;
    }

    /**
     * 获取 创建的用户
     *
     * @return gunnebo_create_by - 创建的用户
     */
    public String getCreateBy() {
        return createBy;
    }

    /**
     * 设置 创建的用户
     *
     * @param createBy - 创建的用户
     */
    public AtmGunneboBean setCreateBy(String createBy) {
        this.createBy = createBy == null ? null : createBy.trim();
        return this;
    }

    /**
     * 获取 创建时间
     *
     * @return gunnebo_create_timestamp - 创建时间
     */
    public Date getCreateTimestamp() {
        return createTimestamp;
    }

    /**
     * 设置 创建时间
     *
     * @param createTimestamp - 创建时间
     */
    public AtmGunneboBean setCreateTimestamp(Date createTimestamp) {
        this.createTimestamp = createTimestamp;
        return this;
    }

    /**
     * 获取 更新时间
     *
     * @return gunnebo_update_timestamp - 更新时间
     */
    public Date getUpdateTimestamp() {
        return updateTimestamp;
    }

    /**
     * 设置 更新时间
     *
     * @param updateTimestamp - 更新时间
     */
    public AtmGunneboBean setUpdateTimestamp(Date updateTimestamp) {
        this.updateTimestamp = updateTimestamp;
        return this;
    }

    /**
     * 获取 逻辑删除标志【N[正常]，Y[删除]】
     *
     * @return gunnebo_delete_flag - 逻辑删除标志【N[正常]，Y[删除]】
     */
    public String getDeleteFlag() {
        return deleteFlag;
    }

    /**
     * 设置 逻辑删除标志【N[正常]，Y[删除]】
     *
     * @param deleteFlag - 逻辑删除标志【N[正常]，Y[删除]】
     */
    public AtmGunneboBean setDeleteFlag(String deleteFlag) {
        this.deleteFlag = deleteFlag == null ? null : deleteFlag.trim();
        return this;
    }
}