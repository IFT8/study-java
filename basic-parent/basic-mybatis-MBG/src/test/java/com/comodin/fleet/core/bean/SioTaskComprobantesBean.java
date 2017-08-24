package com.comodin.fleet.core.bean;

import com.comodin.basic.util.date.DateUtil;
import com.comodin.basic.validation.IBaseValidGroup;
import com.comodin.basic.validation.constraints.*;
import com.comodin.fleet.constant.i18n.SioTaskComprobantesBeanI18nConstant;
import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;
import javax.persistence.*;
import javax.validation.constraints.*;
import org.hibernate.validator.constraints.*;
import org.springframework.format.annotation.DateTimeFormat;

@SuppressWarnings({"unused", "UnusedReturnValue", "SameParameterValue", "DefaultAnnotationParam"})
@Entity
@Table(name = "t_sio_task_comprobantes")
public class SioTaskComprobantesBean implements Serializable {
    /**
     * <pre>
     * DB remark: 数据库主键ID
     * DB column: comprobantes_id	BIGINT(20)	<--->	id	java.lang.Long
     * DB is  Nullable: false
     * DB defaultValue: null
     * </pre>
     */
    @NotNull(message = "{" + SioTaskComprobantesBeanI18nConstant.SIO_TASK_COMPROBANTES_BEAN_ID_NOT_NULL + "}", groups = {IBaseValidGroup.Update.class})
    @ValidLength(max = 20, message = "{" + SioTaskComprobantesBeanI18nConstant.SIO_TASK_COMPROBANTES_BEAN_ID_LENGTH + "}", groups = {IBaseValidGroup.Update.class})
    @Column(name = "comprobantes_id", length = 20, nullable = false)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    private Long id;

    /**
     * <pre>
     * DB remark: SIO任务ID组成方式【|4|26|20161118|1101|1|】【|SIO公司内部ID|SIO公司网点内部ID|路线日期[yyyyMMdd]|路线ID|任务ID|】【date:2016-12-12 by:supeng】
     * DB column: comprobantes_task_original_complex_id	VARCHAR(100)	<--->	taskOriginalComplexId	java.lang.String
     * DB is  Nullable: true
     * DB defaultValue: null
     * </pre>
     */
    @Length(max = 100, message = "{" + SioTaskComprobantesBeanI18nConstant.SIO_TASK_COMPROBANTES_BEAN_TASK_ORIGINAL_COMPLEX_ID_LENGTH + "}", groups = {IBaseValidGroup.Add.class, IBaseValidGroup.Update.class})
    @Column(name = "comprobantes_task_original_complex_id", length = 100, nullable = true)
    private String taskOriginalComplexId;

    /**
     * <pre>
     * DB remark: 票据ID
     * DB column: comprobantes_code	VARCHAR(15)	<--->	code	java.lang.String
     * DB is  Nullable: false
     * DB defaultValue: null
     * </pre>
     */
    @NotBlank(message = "{" + SioTaskComprobantesBeanI18nConstant.SIO_TASK_COMPROBANTES_BEAN_CODE_NOT_BLANK + "}", groups = {IBaseValidGroup.Add.class, IBaseValidGroup.Update.class})
    @Length(max = 15, message = "{" + SioTaskComprobantesBeanI18nConstant.SIO_TASK_COMPROBANTES_BEAN_CODE_LENGTH + "}", groups = {IBaseValidGroup.Add.class, IBaseValidGroup.Update.class})
    @Column(name = "comprobantes_code", length = 15, nullable = false)
    private String code;

    /**
     * <pre>
     * DB remark: 票据,袋子数
     * DB column: comprobantes_package_number	INTEGER(10)	<--->	packageNumber	java.lang.Integer
     * DB is  Nullable: false
     * DB defaultValue: 0
     * </pre>
     */
    @NotNull(message = "{" + SioTaskComprobantesBeanI18nConstant.SIO_TASK_COMPROBANTES_BEAN_PACKAGE_NUMBER_NOT_NULL + "}", groups = {IBaseValidGroup.Add.class, IBaseValidGroup.Update.class})
    @ValidLength(max = 10, message = "{" + SioTaskComprobantesBeanI18nConstant.SIO_TASK_COMPROBANTES_BEAN_PACKAGE_NUMBER_LENGTH + "}", groups = {IBaseValidGroup.Add.class, IBaseValidGroup.Update.class})
    @Column(name = "comprobantes_package_number", length = 10, nullable = false)
    private Integer packageNumber;

    /**
     * <pre>
     * DB remark: 票据,总额
     * DB column: comprobantes_amount	DECIMAL(15)	<--->	amount	java.math.BigDecimal
     * DB is  Nullable: false
     * DB defaultValue: 0.0000
     * </pre>
     */
    @Column(name = "comprobantes_amount", length = 15, nullable = false)
    private BigDecimal amount;

    /**
     * <pre>
     * DB remark: 票据,状态
     * DB column: comprobantes_status	CHAR(7)	<--->	status	java.lang.String
     * DB is  Nullable: false
     * DB defaultValue: ENABLE
     * </pre>
     */
    @NotBlank(message = "{" + SioTaskComprobantesBeanI18nConstant.SIO_TASK_COMPROBANTES_BEAN_STATUS_NOT_BLANK + "}", groups = {IBaseValidGroup.Add.class, IBaseValidGroup.Update.class})
    @Length(max = 7, message = "{" + SioTaskComprobantesBeanI18nConstant.SIO_TASK_COMPROBANTES_BEAN_STATUS_LENGTH + "}", groups = {IBaseValidGroup.Add.class, IBaseValidGroup.Update.class})
    @Column(name = "comprobantes_status", length = 7, nullable = false)
    private String status;

    /**
     * <pre>
     * DB remark: SIO中，记录日期，由SIO增加的字段
     * DB column: comprobantes_record_date	CHAR(10)	<--->	recordDate	java.lang.String
     * DB is  Nullable: true
     * DB defaultValue: null
     * </pre>
     */
    @Length(max = 10, message = "{" + SioTaskComprobantesBeanI18nConstant.SIO_TASK_COMPROBANTES_BEAN_RECORD_DATE_LENGTH + "}", groups = {IBaseValidGroup.Add.class, IBaseValidGroup.Update.class})
    @Column(name = "comprobantes_record_date", length = 10, nullable = true)
    private String recordDate;

    /**
     * <pre>
     * DB remark: SIO中，记录时间，由SIO增加的字段
     * DB column: comprobantes_record_time	CHAR(8)	<--->	recordTime	java.lang.String
     * DB is  Nullable: true
     * DB defaultValue: null
     * </pre>
     */
    @Length(max = 8, message = "{" + SioTaskComprobantesBeanI18nConstant.SIO_TASK_COMPROBANTES_BEAN_RECORD_TIME_LENGTH + "}", groups = {IBaseValidGroup.Add.class, IBaseValidGroup.Update.class})
    @Column(name = "comprobantes_record_time", length = 8, nullable = true)
    private String recordTime;

    /**
     * <pre>
     * DB remark: 票据类型，预留字段2016-12-20 by:supeng
     * DB column: comprobantes_type	CHAR(16)	<--->	type	java.lang.String
     * DB is  Nullable: true
     * DB defaultValue: null
     * </pre>
     */
    @Length(max = 16, message = "{" + SioTaskComprobantesBeanI18nConstant.SIO_TASK_COMPROBANTES_BEAN_TYPE_LENGTH + "}", groups = {IBaseValidGroup.Add.class, IBaseValidGroup.Update.class})
    @Column(name = "comprobantes_type", length = 16, nullable = true)
    private String type;

    /**
     * <pre>
     * DB remark: 货币类型，预留字段2016-12-20 by:supeng
     * DB column: comprobantes_currency_internal_id	CHAR(16)	<--->	currencyInternalId	java.lang.String
     * DB is  Nullable: true
     * DB defaultValue: null
     * </pre>
     */
    @Length(max = 16, message = "{" + SioTaskComprobantesBeanI18nConstant.SIO_TASK_COMPROBANTES_BEAN_CURRENCY_INTERNAL_ID_LENGTH + "}", groups = {IBaseValidGroup.Add.class, IBaseValidGroup.Update.class})
    @Column(name = "comprobantes_currency_internal_id", length = 16, nullable = true)
    private String currencyInternalId;

    /**
     * <pre>
     * DB remark: SIO中，原始Comprobante号，由SIO增加的字段
     * DB column: comprobantes_original_code	VARCHAR(100)	<--->	originalCode	java.lang.String
     * DB is  Nullable: true
     * DB defaultValue: null
     * </pre>
     */
    @Length(max = 100, message = "{" + SioTaskComprobantesBeanI18nConstant.SIO_TASK_COMPROBANTES_BEAN_ORIGINAL_CODE_LENGTH + "}", groups = {IBaseValidGroup.Add.class, IBaseValidGroup.Update.class})
    @Column(name = "comprobantes_original_code", length = 100, nullable = true)
    private String originalCode;

    /**
     * <pre>
     * DB remark: 票据操作设备
     * DB column: comprobantes_operate_device_json	VARCHAR(1024)	<--->	operateDeviceJson	java.lang.String
     * DB is  Nullable: true
     * DB defaultValue: null
     * </pre>
     */
    @Length(max = 1024, message = "{" + SioTaskComprobantesBeanI18nConstant.SIO_TASK_COMPROBANTES_BEAN_OPERATE_DEVICE_JSON_LENGTH + "}", groups = {IBaseValidGroup.Add.class, IBaseValidGroup.Update.class})
    @Column(name = "comprobantes_operate_device_json", length = 1024, nullable = true)
    private String operateDeviceJson;

    /**
     * <pre>
     * DB remark: 创建时间
     * DB column: comprobantes_create_timestamp	TIMESTAMP(19)	<--->	createTimestamp	java.util.Date
     * DB is  Nullable: false
     * DB defaultValue: CURRENT_TIMESTAMP
     * </pre>
     */
    @ValidDateTimeFormat(pattern = DateUtil.DATE_PATTERN_YYYY_MM_DD_HH_MM_SS, message = "{" + SioTaskComprobantesBeanI18nConstant.SIO_TASK_COMPROBANTES_BEAN_CREATE_TIMESTAMP_DATE_TIME_FORMAT + "}", groups = {IBaseValidGroup.Add.class, IBaseValidGroup.Update.class})
    @DateTimeFormat(pattern = DateUtil.DATE_PATTERN_YYYY_MM_DD_HH_MM_SS)
    @NotNull(message = "{" + SioTaskComprobantesBeanI18nConstant.SIO_TASK_COMPROBANTES_BEAN_CREATE_TIMESTAMP_NOT_NULL + "}", groups = {IBaseValidGroup.Add.class, IBaseValidGroup.Update.class})
    @Column(name = "comprobantes_create_timestamp", length = 19, nullable = false)
    private Date createTimestamp;

    /**
     * <pre>
     * DB remark: 谁新增了该员工,与crew_username字段关联
     * DB column: comprobantes_create_by	VARCHAR(20)	<--->	createBy	java.lang.String
     * DB is  Nullable: false
     * DB defaultValue: null
     * </pre>
     */
    @NotBlank(message = "{" + SioTaskComprobantesBeanI18nConstant.SIO_TASK_COMPROBANTES_BEAN_CREATE_BY_NOT_BLANK + "}", groups = {IBaseValidGroup.Add.class, IBaseValidGroup.Update.class})
    @Length(max = 20, message = "{" + SioTaskComprobantesBeanI18nConstant.SIO_TASK_COMPROBANTES_BEAN_CREATE_BY_LENGTH + "}", groups = {IBaseValidGroup.Add.class, IBaseValidGroup.Update.class})
    @Column(name = "comprobantes_create_by", length = 20, nullable = false)
    private String createBy;

    /**
     * <pre>
     * DB remark: 逻辑删除标志【N[正常]，Y[删除]】
     * DB column: comprobantes_delete_flag	CHAR(1)	<--->	deleteFlag	java.lang.String
     * DB is  Nullable: false
     * DB defaultValue: N
     * </pre>
     */
    @NotBlank(message = "{" + SioTaskComprobantesBeanI18nConstant.SIO_TASK_COMPROBANTES_BEAN_DELETE_FLAG_NOT_BLANK + "}", groups = {IBaseValidGroup.Add.class, IBaseValidGroup.Update.class})
    @Length(max = 1, message = "{" + SioTaskComprobantesBeanI18nConstant.SIO_TASK_COMPROBANTES_BEAN_DELETE_FLAG_LENGTH + "}", groups = {IBaseValidGroup.Add.class, IBaseValidGroup.Update.class})
    @Column(name = "comprobantes_delete_flag", length = 1, nullable = false)
    private String deleteFlag;

    private static final long serialVersionUID = 1L;

    /**
     * 获取 数据库主键ID
     *
     * @return comprobantes_id - 数据库主键ID
     */
    public Long getId() {
        return id;
    }

    /**
     * 设置 数据库主键ID
     *
     * @param id - 数据库主键ID
     */
    public SioTaskComprobantesBean setId(Long id) {
        this.id = id;
        return this;
    }

    /**
     * 获取 SIO任务ID组成方式【|4|26|20161118|1101|1|】【|SIO公司内部ID|SIO公司网点内部ID|路线日期[yyyyMMdd]|路线ID|任务ID|】【date:2016-12-12 by:supeng】
     *
     * @return comprobantes_task_original_complex_id - SIO任务ID组成方式【|4|26|20161118|1101|1|】【|SIO公司内部ID|SIO公司网点内部ID|路线日期[yyyyMMdd]|路线ID|任务ID|】【date:2016-12-12 by:supeng】
     */
    public String getTaskOriginalComplexId() {
        return taskOriginalComplexId;
    }

    /**
     * 设置 SIO任务ID组成方式【|4|26|20161118|1101|1|】【|SIO公司内部ID|SIO公司网点内部ID|路线日期[yyyyMMdd]|路线ID|任务ID|】【date:2016-12-12 by:supeng】
     *
     * @param taskOriginalComplexId - SIO任务ID组成方式【|4|26|20161118|1101|1|】【|SIO公司内部ID|SIO公司网点内部ID|路线日期[yyyyMMdd]|路线ID|任务ID|】【date:2016-12-12 by:supeng】
     */
    public SioTaskComprobantesBean setTaskOriginalComplexId(String taskOriginalComplexId) {
        this.taskOriginalComplexId = taskOriginalComplexId == null ? null : taskOriginalComplexId.trim();
        return this;
    }

    /**
     * 获取 票据ID
     *
     * @return comprobantes_code - 票据ID
     */
    public String getCode() {
        return code;
    }

    /**
     * 设置 票据ID
     *
     * @param code - 票据ID
     */
    public SioTaskComprobantesBean setCode(String code) {
        this.code = code == null ? null : code.trim();
        return this;
    }

    /**
     * 获取 票据,袋子数
     *
     * @return comprobantes_package_number - 票据,袋子数
     */
    public Integer getPackageNumber() {
        return packageNumber;
    }

    /**
     * 设置 票据,袋子数
     *
     * @param packageNumber - 票据,袋子数
     */
    public SioTaskComprobantesBean setPackageNumber(Integer packageNumber) {
        this.packageNumber = packageNumber;
        return this;
    }

    /**
     * 获取 票据,总额
     *
     * @return comprobantes_amount - 票据,总额
     */
    public BigDecimal getAmount() {
        return amount;
    }

    /**
     * 设置 票据,总额
     *
     * @param amount - 票据,总额
     */
    public SioTaskComprobantesBean setAmount(BigDecimal amount) {
        this.amount = amount;
        return this;
    }

    /**
     * 获取 票据,状态
     *
     * @return comprobantes_status - 票据,状态
     */
    public String getStatus() {
        return status;
    }

    /**
     * 设置 票据,状态
     *
     * @param status - 票据,状态
     */
    public SioTaskComprobantesBean setStatus(String status) {
        this.status = status == null ? null : status.trim();
        return this;
    }

    /**
     * 获取 SIO中，记录日期，由SIO增加的字段
     *
     * @return comprobantes_record_date - SIO中，记录日期，由SIO增加的字段
     */
    public String getRecordDate() {
        return recordDate;
    }

    /**
     * 设置 SIO中，记录日期，由SIO增加的字段
     *
     * @param recordDate - SIO中，记录日期，由SIO增加的字段
     */
    public SioTaskComprobantesBean setRecordDate(String recordDate) {
        this.recordDate = recordDate == null ? null : recordDate.trim();
        return this;
    }

    /**
     * 获取 SIO中，记录时间，由SIO增加的字段
     *
     * @return comprobantes_record_time - SIO中，记录时间，由SIO增加的字段
     */
    public String getRecordTime() {
        return recordTime;
    }

    /**
     * 设置 SIO中，记录时间，由SIO增加的字段
     *
     * @param recordTime - SIO中，记录时间，由SIO增加的字段
     */
    public SioTaskComprobantesBean setRecordTime(String recordTime) {
        this.recordTime = recordTime == null ? null : recordTime.trim();
        return this;
    }

    /**
     * 获取 票据类型，预留字段2016-12-20 by:supeng
     *
     * @return comprobantes_type - 票据类型，预留字段2016-12-20 by:supeng
     */
    public String getType() {
        return type;
    }

    /**
     * 设置 票据类型，预留字段2016-12-20 by:supeng
     *
     * @param type - 票据类型，预留字段2016-12-20 by:supeng
     */
    public SioTaskComprobantesBean setType(String type) {
        this.type = type == null ? null : type.trim();
        return this;
    }

    /**
     * 获取 货币类型，预留字段2016-12-20 by:supeng
     *
     * @return comprobantes_currency_internal_id - 货币类型，预留字段2016-12-20 by:supeng
     */
    public String getCurrencyInternalId() {
        return currencyInternalId;
    }

    /**
     * 设置 货币类型，预留字段2016-12-20 by:supeng
     *
     * @param currencyInternalId - 货币类型，预留字段2016-12-20 by:supeng
     */
    public SioTaskComprobantesBean setCurrencyInternalId(String currencyInternalId) {
        this.currencyInternalId = currencyInternalId == null ? null : currencyInternalId.trim();
        return this;
    }

    /**
     * 获取 SIO中，原始Comprobante号，由SIO增加的字段
     *
     * @return comprobantes_original_code - SIO中，原始Comprobante号，由SIO增加的字段
     */
    public String getOriginalCode() {
        return originalCode;
    }

    /**
     * 设置 SIO中，原始Comprobante号，由SIO增加的字段
     *
     * @param originalCode - SIO中，原始Comprobante号，由SIO增加的字段
     */
    public SioTaskComprobantesBean setOriginalCode(String originalCode) {
        this.originalCode = originalCode == null ? null : originalCode.trim();
        return this;
    }

    /**
     * 获取 票据操作设备
     *
     * @return comprobantes_operate_device_json - 票据操作设备
     */
    public String getOperateDeviceJson() {
        return operateDeviceJson;
    }

    /**
     * 设置 票据操作设备
     *
     * @param operateDeviceJson - 票据操作设备
     */
    public SioTaskComprobantesBean setOperateDeviceJson(String operateDeviceJson) {
        this.operateDeviceJson = operateDeviceJson == null ? null : operateDeviceJson.trim();
        return this;
    }

    /**
     * 获取 创建时间
     *
     * @return comprobantes_create_timestamp - 创建时间
     */
    public Date getCreateTimestamp() {
        return createTimestamp;
    }

    /**
     * 设置 创建时间
     *
     * @param createTimestamp - 创建时间
     */
    public SioTaskComprobantesBean setCreateTimestamp(Date createTimestamp) {
        this.createTimestamp = createTimestamp;
        return this;
    }

    /**
     * 获取 谁新增了该员工,与crew_username字段关联
     *
     * @return comprobantes_create_by - 谁新增了该员工,与crew_username字段关联
     */
    public String getCreateBy() {
        return createBy;
    }

    /**
     * 设置 谁新增了该员工,与crew_username字段关联
     *
     * @param createBy - 谁新增了该员工,与crew_username字段关联
     */
    public SioTaskComprobantesBean setCreateBy(String createBy) {
        this.createBy = createBy == null ? null : createBy.trim();
        return this;
    }

    /**
     * 获取 逻辑删除标志【N[正常]，Y[删除]】
     *
     * @return comprobantes_delete_flag - 逻辑删除标志【N[正常]，Y[删除]】
     */
    public String getDeleteFlag() {
        return deleteFlag;
    }

    /**
     * 设置 逻辑删除标志【N[正常]，Y[删除]】
     *
     * @param deleteFlag - 逻辑删除标志【N[正常]，Y[删除]】
     */
    public SioTaskComprobantesBean setDeleteFlag(String deleteFlag) {
        this.deleteFlag = deleteFlag == null ? null : deleteFlag.trim();
        return this;
    }
}