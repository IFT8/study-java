package com.comodin.fleet.core.bean;

import com.comodin.basic.util.date.DateUtil;
import com.comodin.basic.validation.IBaseValidGroup;
import com.comodin.basic.validation.constraints.ValidDateTimeFormat;
import com.comodin.basic.validation.constraints.ValidLength;
import org.hibernate.validator.constraints.Length;
import org.hibernate.validator.constraints.NotBlank;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

@SuppressWarnings({"unused", "UnusedReturnValue", "SameParameterValue", "DefaultAnnotationParam"})
@Table(name = "t_atm_base")
public class AtmBaseBean implements Serializable {
    /**
     * <pre>
     * DB remark: 数据库主键ID
     * DB column: base_id	BIGINT(20)	<--->	id	java.lang.Long
     * DB is  Nullable: false
     * DB defaultValue: null
     * </pre>
     */
    @NotNull(message = "{ATM_BASE_BEAN_ID_NOT_NULL}", groups = {IBaseValidGroup.Add.class, IBaseValidGroup.Update.class})
    @ValidLength(max = 20, message = "{ATM_BASE_BEAN_ID_LENGTH}", groups = {IBaseValidGroup.Add.class, IBaseValidGroup.Update.class})
    @Id
    @Column(name = "base_id", length = 20, nullable = false)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    /**
     * <pre>
     * DB remark: 内部编号,在调用第三方接口里的唯一标识
     * DB column: base_internal_id	VARCHAR(15)	<--->	internalId	java.lang.String
     * DB is  Nullable: false
     * DB defaultValue: null
     * </pre>
     */
    @NotBlank(message = "{ATM_BASE_BEAN_INTERNAL_ID_NOT_BLANK}", groups = {IBaseValidGroup.Add.class, IBaseValidGroup.Update.class})
    @Length(max = 15, message = "{ATM_BASE_BEAN_INTERNAL_ID_LENGTH}", groups = {IBaseValidGroup.Add.class, IBaseValidGroup.Update.class})
    @Column(name = "base_internal_id", length = 15, nullable = false)
    private String internalId;

    /**
     * <pre>
     * DB remark: 基础状态
     * DB column: base_status	CHAR(32)	<--->	status	java.lang.String
     * DB is  Nullable: true
     * DB defaultValue: null
     * </pre>
     */
    @Length(max = 32, message = "{ATM_BASE_BEAN_STATUS_LENGTH}", groups = {IBaseValidGroup.Add.class, IBaseValidGroup.Update.class})
    @Column(name = "base_status", length = 32, nullable = true)
    private String status;

    /**
     * <pre>
     * DB remark: 所属branch
     * DB column: base_branch_id	BIGINT(19)	<--->	branchId	java.lang.Long
     * DB is  Nullable: false
     * DB defaultValue: null
     * </pre>
     */
    @NotNull(message = "{ATM_BASE_BEAN_BRANCH_ID_NOT_NULL}", groups = {IBaseValidGroup.Add.class, IBaseValidGroup.Update.class})
    @ValidLength(max = 19, message = "{ATM_BASE_BEAN_BRANCH_ID_LENGTH}", groups = {IBaseValidGroup.Add.class, IBaseValidGroup.Update.class})
    @Column(name = "base_branch_id", length = 19, nullable = false)
    private Long branchId;

    /**
     * <pre>
     * DB remark: 所属branchInternalId
     * DB column: base_branch_internal_id	VARCHAR(15)	<--->	branchInternalId	java.lang.String
     * DB is  Nullable: true
     * DB defaultValue: null
     * </pre>
     */
    @Length(max = 15, message = "{ATM_BASE_BEAN_BRANCH_INTERNAL_ID_LENGTH}", groups = {IBaseValidGroup.Add.class, IBaseValidGroup.Update.class})
    @Column(name = "base_branch_internal_id", length = 15, nullable = true)
    private String branchInternalId;

    /**
     * <pre>
     * DB remark: 负责人用户名
     * DB column: base_principal	VARCHAR(20)	<--->	principal	java.lang.String
     * DB is  Nullable: true
     * DB defaultValue: null
     * </pre>
     */
    @Length(max = 20, message = "{ATM_BASE_BEAN_PRINCIPAL_LENGTH}", groups = {IBaseValidGroup.Add.class, IBaseValidGroup.Update.class})
    @Column(name = "base_principal", length = 20, nullable = true)
    private String principal;

    /**
     * <pre>
     * DB remark: 纸币最大容量张数
     * DB column: base_max_capacity	INTEGER(10)	<--->	maxCapacity	java.lang.Integer
     * DB is  Nullable: false
     * DB defaultValue: 0
     * </pre>
     */
    @NotNull(message = "{ATM_BASE_BEAN_MAX_CAPACITY_NOT_NULL}", groups = {IBaseValidGroup.Add.class, IBaseValidGroup.Update.class})
    @ValidLength(max = 10, message = "{ATM_BASE_BEAN_MAX_CAPACITY_LENGTH}", groups = {IBaseValidGroup.Add.class, IBaseValidGroup.Update.class})
    @Column(name = "base_max_capacity", length = 10, nullable = false)
    private Integer maxCapacity;

    /**
     * <pre>
     * DB remark: 当前纸币张数
     * DB column: base_current_capacity	INTEGER(10)	<--->	currentCapacity	java.lang.Integer
     * DB is  Nullable: false
     * DB defaultValue: 0
     * </pre>
     */
    @NotNull(message = "{ATM_BASE_BEAN_CURRENT_CAPACITY_NOT_NULL}", groups = {IBaseValidGroup.Add.class, IBaseValidGroup.Update.class})
    @ValidLength(max = 10, message = "{ATM_BASE_BEAN_CURRENT_CAPACITY_LENGTH}", groups = {IBaseValidGroup.Add.class, IBaseValidGroup.Update.class})
    @Column(name = "base_current_capacity", length = 10, nullable = false)
    private Integer currentCapacity;

    /**
     * <pre>
     * DB remark: 当前总金额
     * DB column: base_total_amount	DECIMAL(14)	<--->	totalAmount	java.math.BigDecimal
     * DB is  Nullable: true
     * DB defaultValue: 0.0000
     * </pre>
     */
    @Column(name = "base_total_amount", length = 14, nullable = true)
    private BigDecimal totalAmount;

    /**
     * <pre>
     * DB remark: 金额货币单位
     * DB column: base_amount_currency	VARCHAR(5)	<--->	amountCurrency	java.lang.String
     * DB is  Nullable: true
     * DB defaultValue: null
     * </pre>
     */
    @Length(max = 5, message = "{ATM_BASE_BEAN_AMOUNT_CURRENCY_LENGTH}", groups = {IBaseValidGroup.Add.class, IBaseValidGroup.Update.class})
    @Column(name = "base_amount_currency", length = 5, nullable = true)
    private String amountCurrency;

    /**
     * <pre>
     * DB remark: 创建的用户
     * DB column: base_create_by	VARCHAR(20)	<--->	createBy	java.lang.String
     * DB is  Nullable: false
     * DB defaultValue: null
     * </pre>
     */
    @NotBlank(message = "{ATM_BASE_BEAN_CREATE_BY_NOT_BLANK}", groups = {IBaseValidGroup.Add.class, IBaseValidGroup.Update.class})
    @Length(max = 20, message = "{ATM_BASE_BEAN_CREATE_BY_LENGTH}", groups = {IBaseValidGroup.Add.class, IBaseValidGroup.Update.class})
    @Column(name = "base_create_by", length = 20, nullable = false)
    private String createBy;

    /**
     * <pre>
     * DB remark: 设备型号
     * DB column: base_device_model	VARCHAR(20)	<--->	deviceModel	java.lang.String
     * DB is  Nullable: false
     * DB defaultValue: null
     * </pre>
     */
    @NotBlank(message = "{ATM_BASE_BEAN_DEVICE_MODEL_NOT_BLANK}", groups = {IBaseValidGroup.Add.class, IBaseValidGroup.Update.class})
    @Length(max = 20, message = "{ATM_BASE_BEAN_DEVICE_MODEL_LENGTH}", groups = {IBaseValidGroup.Add.class, IBaseValidGroup.Update.class})
    @Column(name = "base_device_model", length = 20, nullable = false)
    private String deviceModel;

    /**
     * <pre>
     * DB remark: 创建时间
     * DB column: base_create_timestamp	TIMESTAMP(19)	<--->	createTimestamp	java.util.Date
     * DB is  Nullable: false
     * DB defaultValue: CURRENT_TIMESTAMP
     * </pre>
     */
    @ValidDateTimeFormat(pattern = DateUtil.DATE_PATTERN_YYYY_MM_DD_HH_MM_SS, message = "{ATM_BASE_BEAN_CREATE_TIMESTAMP_DATE_TIME_FORMAT}", groups = {IBaseValidGroup.Add.class, IBaseValidGroup.Update.class})
    @DateTimeFormat(pattern = DateUtil.DATE_PATTERN_YYYY_MM_DD_HH_MM_SS)
    @NotNull(message = "{ATM_BASE_BEAN_CREATE_TIMESTAMP_NOT_NULL}", groups = {IBaseValidGroup.Add.class, IBaseValidGroup.Update.class})
    @Column(name = "base_create_timestamp", length = 19, nullable = false)
    private Date createTimestamp;

    /**
     * <pre>
     * DB remark: 更新时间
     * DB column: base_update_timestamp	TIMESTAMP(19)	<--->	updateTimestamp	java.util.Date
     * DB is  Nullable: false
     * DB defaultValue: CURRENT_TIMESTAMP
     * </pre>
     */
    @ValidDateTimeFormat(pattern = DateUtil.DATE_PATTERN_YYYY_MM_DD_HH_MM_SS, message = "{ATM_BASE_BEAN_UPDATE_TIMESTAMP_DATE_TIME_FORMAT}", groups = {IBaseValidGroup.Add.class, IBaseValidGroup.Update.class})
    @DateTimeFormat(pattern = DateUtil.DATE_PATTERN_YYYY_MM_DD_HH_MM_SS)
    @NotNull(message = "{ATM_BASE_BEAN_UPDATE_TIMESTAMP_NOT_NULL}", groups = {IBaseValidGroup.Add.class, IBaseValidGroup.Update.class})
    @Column(name = "base_update_timestamp", length = 19, nullable = false)
    private Date updateTimestamp;

    /**
     * <pre>
     * DB remark: 逻辑删除标志【N[正常]，Y[删除]】
     * DB column: base_delete_flag	CHAR(1)	<--->	deleteFlag	java.lang.String
     * DB is  Nullable: false
     * DB defaultValue: N
     * </pre>
     */
    @NotBlank(message = "{ATM_BASE_BEAN_DELETE_FLAG_NOT_BLANK}", groups = {IBaseValidGroup.Add.class, IBaseValidGroup.Update.class})
    @Length(max = 1, message = "{ATM_BASE_BEAN_DELETE_FLAG_LENGTH}", groups = {IBaseValidGroup.Add.class, IBaseValidGroup.Update.class})
    @Column(name = "base_delete_flag", length = 1, nullable = false)
    private String deleteFlag;

    private static final long serialVersionUID = 1L;

    /**
     * 获取 数据库主键ID
     *
     * @return base_id - 数据库主键ID
     */
    public Long getId() {
        return id;
    }

    /**
     * 设置 数据库主键ID
     *
     * @param id - 数据库主键ID
     */
    public AtmBaseBean setId(Long id) {
        this.id = id;
        return this;
    }

    /**
     * 获取 内部编号,在调用第三方接口里的唯一标识
     *
     * @return base_internal_id - 内部编号,在调用第三方接口里的唯一标识
     */
    public String getInternalId() {
        return internalId;
    }

    /**
     * 设置 内部编号,在调用第三方接口里的唯一标识
     *
     * @param internalId - 内部编号,在调用第三方接口里的唯一标识
     */
    public AtmBaseBean setInternalId(String internalId) {
        this.internalId = internalId == null ? null : internalId.trim();
        return this;
    }

    /**
     * 获取 基础状态
     *
     * @return base_status - 基础状态
     */
    public String getStatus() {
        return status;
    }

    /**
     * 设置 基础状态
     *
     * @param status - 基础状态
     */
    public AtmBaseBean setStatus(String status) {
        this.status = status == null ? null : status.trim();
        return this;
    }

    /**
     * 获取 所属branch
     *
     * @return base_branch_id - 所属branch
     */
    public Long getBranchId() {
        return branchId;
    }

    /**
     * 设置 所属branch
     *
     * @param branchId - 所属branch
     */
    public AtmBaseBean setBranchId(Long branchId) {
        this.branchId = branchId;
        return this;
    }

    /**
     * 获取 所属branchInternalId
     *
     * @return base_branch_internal_id - 所属branchInternalId
     */
    public String getBranchInternalId() {
        return branchInternalId;
    }

    /**
     * 设置 所属branchInternalId
     *
     * @param branchInternalId - 所属branchInternalId
     */
    public AtmBaseBean setBranchInternalId(String branchInternalId) {
        this.branchInternalId = branchInternalId == null ? null : branchInternalId.trim();
        return this;
    }

    /**
     * 获取 负责人用户名
     *
     * @return base_principal - 负责人用户名
     */
    public String getPrincipal() {
        return principal;
    }

    /**
     * 设置 负责人用户名
     *
     * @param principal - 负责人用户名
     */
    public AtmBaseBean setPrincipal(String principal) {
        this.principal = principal == null ? null : principal.trim();
        return this;
    }

    /**
     * 获取 纸币最大容量张数
     *
     * @return base_max_capacity - 纸币最大容量张数
     */
    public Integer getMaxCapacity() {
        return maxCapacity;
    }

    /**
     * 设置 纸币最大容量张数
     *
     * @param maxCapacity - 纸币最大容量张数
     */
    public AtmBaseBean setMaxCapacity(Integer maxCapacity) {
        this.maxCapacity = maxCapacity;
        return this;
    }

    /**
     * 获取 当前纸币张数
     *
     * @return base_current_capacity - 当前纸币张数
     */
    public Integer getCurrentCapacity() {
        return currentCapacity;
    }

    /**
     * 设置 当前纸币张数
     *
     * @param currentCapacity - 当前纸币张数
     */
    public AtmBaseBean setCurrentCapacity(Integer currentCapacity) {
        this.currentCapacity = currentCapacity;
        return this;
    }

    /**
     * 获取 当前总金额
     *
     * @return base_total_amount - 当前总金额
     */
    public BigDecimal getTotalAmount() {
        return totalAmount;
    }

    /**
     * 设置 当前总金额
     *
     * @param totalAmount - 当前总金额
     */
    public AtmBaseBean setTotalAmount(BigDecimal totalAmount) {
        this.totalAmount = totalAmount;
        return this;
    }

    /**
     * 获取 金额货币单位
     *
     * @return base_amount_currency - 金额货币单位
     */
    public String getAmountCurrency() {
        return amountCurrency;
    }

    /**
     * 设置 金额货币单位
     *
     * @param amountCurrency - 金额货币单位
     */
    public AtmBaseBean setAmountCurrency(String amountCurrency) {
        this.amountCurrency = amountCurrency == null ? null : amountCurrency.trim();
        return this;
    }

    /**
     * 获取 创建的用户
     *
     * @return base_create_by - 创建的用户
     */
    public String getCreateBy() {
        return createBy;
    }

    /**
     * 设置 创建的用户
     *
     * @param createBy - 创建的用户
     */
    public AtmBaseBean setCreateBy(String createBy) {
        this.createBy = createBy == null ? null : createBy.trim();
        return this;
    }

    /**
     * 获取 设备型号
     *
     * @return base_device_model - 设备型号
     */
    public String getDeviceModel() {
        return deviceModel;
    }

    /**
     * 设置 设备型号
     *
     * @param deviceModel - 设备型号
     */
    public AtmBaseBean setDeviceModel(String deviceModel) {
        this.deviceModel = deviceModel == null ? null : deviceModel.trim();
        return this;
    }

    /**
     * 获取 创建时间
     *
     * @return base_create_timestamp - 创建时间
     */
    public Date getCreateTimestamp() {
        return createTimestamp;
    }

    /**
     * 设置 创建时间
     *
     * @param createTimestamp - 创建时间
     */
    public AtmBaseBean setCreateTimestamp(Date createTimestamp) {
        this.createTimestamp = createTimestamp;
        return this;
    }

    /**
     * 获取 更新时间
     *
     * @return base_update_timestamp - 更新时间
     */
    public Date getUpdateTimestamp() {
        return updateTimestamp;
    }

    /**
     * 设置 更新时间
     *
     * @param updateTimestamp - 更新时间
     */
    public AtmBaseBean setUpdateTimestamp(Date updateTimestamp) {
        this.updateTimestamp = updateTimestamp;
        return this;
    }

    /**
     * 获取 逻辑删除标志【N[正常]，Y[删除]】
     *
     * @return base_delete_flag - 逻辑删除标志【N[正常]，Y[删除]】
     */
    public String getDeleteFlag() {
        return deleteFlag;
    }

    /**
     * 设置 逻辑删除标志【N[正常]，Y[删除]】
     *
     * @param deleteFlag - 逻辑删除标志【N[正常]，Y[删除]】
     */
    public AtmBaseBean setDeleteFlag(String deleteFlag) {
        this.deleteFlag = deleteFlag == null ? null : deleteFlag.trim();
        return this;
    }
}