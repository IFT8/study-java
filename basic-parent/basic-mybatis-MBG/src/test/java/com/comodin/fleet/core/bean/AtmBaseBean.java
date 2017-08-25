package com.comodin.fleet.core.bean;

import com.comodin.basic.util.date.DateUtil;
import com.comodin.basic.validation.IBaseValidGroup;
import com.comodin.basic.validation.constraints.*;
import com.comodin.fleet.constants.i18n.AtmBaseBeanI18nConstant;
import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;
import javax.persistence.*;
import javax.validation.constraints.*;
import org.hibernate.validator.constraints.*;
import org.springframework.format.annotation.DateTimeFormat;

@SuppressWarnings({"unused", "UnusedReturnValue", "SameParameterValue", "DefaultAnnotationParam"})
@Entity
@Table(name = "t_atm_base")
public class AtmBaseBean implements Serializable {
    /**
     * <pre>
     * DB remark: 数据库主键ID
     * DB column: atm_id	BIGINT(20)	<--->	id	java.lang.Long
     * DB is  Nullable: false
     * DB defaultValue: null
     * </pre>
     */
    @NotNull(message = "{" + AtmBaseBeanI18nConstant.ATM_BASE_BEAN_ID_NOT_NULL + "}", groups = {IBaseValidGroup.Update.class})
    @ValidLength(max = 20, message = "{" + AtmBaseBeanI18nConstant.ATM_BASE_BEAN_ID_LENGTH + "}", groups = {IBaseValidGroup.Update.class})
    @Column(name = "atm_id", length = 20, nullable = false)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    private Long id;

    /**
     * <pre>
     * DB remark: ATM终端，唯一标识
     * DB column: atm_terminal_id	VARCHAR(64)	<--->	terminalId	java.lang.String
     * DB is  Nullable: false
     * DB defaultValue: null
     * </pre>
     */
    @NotBlank(message = "{" + AtmBaseBeanI18nConstant.ATM_BASE_BEAN_TERMINAL_ID_NOT_BLANK + "}", groups = {IBaseValidGroup.Add.class, IBaseValidGroup.Update.class})
    @Length(max = 64, message = "{" + AtmBaseBeanI18nConstant.ATM_BASE_BEAN_TERMINAL_ID_LENGTH + "}", groups = {IBaseValidGroup.Add.class, IBaseValidGroup.Update.class})
    @Column(name = "atm_terminal_id", length = 64, nullable = false)
    private String terminalId;

    /**
     * <pre>
     * DB remark: ATM终端，设备类型
     * DB column: atm_terminal_type	VARCHAR(20)	<--->	terminalType	java.lang.String
     * DB is  Nullable: false
     * DB defaultValue: null
     * </pre>
     */
    @NotBlank(message = "{" + AtmBaseBeanI18nConstant.ATM_BASE_BEAN_TERMINAL_TYPE_NOT_BLANK + "}", groups = {IBaseValidGroup.Add.class, IBaseValidGroup.Update.class})
    @Length(max = 20, message = "{" + AtmBaseBeanI18nConstant.ATM_BASE_BEAN_TERMINAL_TYPE_LENGTH + "}", groups = {IBaseValidGroup.Add.class, IBaseValidGroup.Update.class})
    @Column(name = "atm_terminal_type", length = 20, nullable = false)
    private String terminalType;

    /**
     * <pre>
     * DB remark: cit公司ID,与t_client.client_id 字段关联【{"max":13}】
     * DB column: atm_cit_id	BIGINT(20)	<--->	citId	java.lang.Long
     * DB is  Nullable: true
     * DB defaultValue: null
     * </pre>
     */
    @ValidLength(max = 13, message = "{" + AtmBaseBeanI18nConstant.ATM_BASE_BEAN_CIT_ID_LENGTH + "}", groups = {IBaseValidGroup.Add.class, IBaseValidGroup.Update.class})
    @Column(name = "atm_cit_id", length = 20, nullable = true)
    private Long citId;

    /**
     * <pre>
     * DB remark: cit公司内部ID,与t_client.client_internal_id 字段冗余
     * DB column: atm_cit_internal_id	VARCHAR(15)	<--->	citInternalId	java.lang.String
     * DB is  Nullable: false
     * DB defaultValue: null
     * </pre>
     */
    @NotBlank(message = "{" + AtmBaseBeanI18nConstant.ATM_BASE_BEAN_CIT_INTERNAL_ID_NOT_BLANK + "}", groups = {IBaseValidGroup.Add.class, IBaseValidGroup.Update.class})
    @Length(max = 15, message = "{" + AtmBaseBeanI18nConstant.ATM_BASE_BEAN_CIT_INTERNAL_ID_LENGTH + "}", groups = {IBaseValidGroup.Add.class, IBaseValidGroup.Update.class})
    @Column(name = "atm_cit_internal_id", length = 15, nullable = false)
    private String citInternalId;

    /**
     * <pre>
     * DB remark: cit公司名称,与t_client.client_name,冗余
     * DB column: atm_cit_name	VARCHAR(100)	<--->	citName	java.lang.String
     * DB is  Nullable: true
     * DB defaultValue: null
     * </pre>
     */
    @Length(max = 100, message = "{" + AtmBaseBeanI18nConstant.ATM_BASE_BEAN_CIT_NAME_LENGTH + "}", groups = {IBaseValidGroup.Add.class, IBaseValidGroup.Update.class})
    @Column(name = "atm_cit_name", length = 100, nullable = true)
    private String citName;

    /**
     * <pre>
     * DB remark: cit网点ID,网点id,与t_client_branch.branch_id,关联【{"max":13}】
     * DB column: atm_cit_branch_id	VARCHAR(15)	<--->	citBranchId	java.lang.String
     * DB is  Nullable: false
     * DB defaultValue: null
     * </pre>
     */
    @NotBlank(message = "{" + AtmBaseBeanI18nConstant.ATM_BASE_BEAN_CIT_BRANCH_ID_NOT_BLANK + "}", groups = {IBaseValidGroup.Add.class, IBaseValidGroup.Update.class})
    @Length(max = 13, message = "{" + AtmBaseBeanI18nConstant.ATM_BASE_BEAN_CIT_BRANCH_ID_LENGTH + "}", groups = {IBaseValidGroup.Add.class, IBaseValidGroup.Update.class})
    @Column(name = "atm_cit_branch_id", length = 15, nullable = false)
    private String citBranchId;

    /**
     * <pre>
     * DB remark: cit网点ID,网点内部Id,与t_client_branch.branch_internal_id,关联
     * DB column: atm_cit_branch_internal_id	VARCHAR(15)	<--->	citBranchInternalId	java.lang.String
     * DB is  Nullable: false
     * DB defaultValue: null
     * </pre>
     */
    @NotBlank(message = "{" + AtmBaseBeanI18nConstant.ATM_BASE_BEAN_CIT_BRANCH_INTERNAL_ID_NOT_BLANK + "}", groups = {IBaseValidGroup.Add.class, IBaseValidGroup.Update.class})
    @Length(max = 15, message = "{" + AtmBaseBeanI18nConstant.ATM_BASE_BEAN_CIT_BRANCH_INTERNAL_ID_LENGTH + "}", groups = {IBaseValidGroup.Add.class, IBaseValidGroup.Update.class})
    @Column(name = "atm_cit_branch_internal_id", length = 15, nullable = false)
    private String citBranchInternalId;

    /**
     * <pre>
     * DB remark: cit网点名称,与t_client_branch.branch_name,冗余
     * DB column: atm_cit_branch_name	VARCHAR(100)	<--->	citBranchName	java.lang.String
     * DB is  Nullable: true
     * DB defaultValue: null
     * </pre>
     */
    @Length(max = 100, message = "{" + AtmBaseBeanI18nConstant.ATM_BASE_BEAN_CIT_BRANCH_NAME_LENGTH + "}", groups = {IBaseValidGroup.Add.class, IBaseValidGroup.Update.class})
    @Column(name = "atm_cit_branch_name", length = 100, nullable = true)
    private String citBranchName;

    /**
     * <pre>
     * DB remark: 负责人,与t_crew.crew_id 字段关联【{"max":13}】
     * DB column: atm_cit_owner_id	BIGINT(20)	<--->	citOwnerId	java.lang.Long
     * DB is  Nullable: true
     * DB defaultValue: null
     * </pre>
     */
    @ValidLength(max = 13, message = "{" + AtmBaseBeanI18nConstant.ATM_BASE_BEAN_CIT_OWNER_ID_LENGTH + "}", groups = {IBaseValidGroup.Add.class, IBaseValidGroup.Update.class})
    @Column(name = "atm_cit_owner_id", length = 20, nullable = true)
    private Long citOwnerId;

    /**
     * <pre>
     * DB remark: 负责人,与t_client.client_id 字段关联
     * DB column: atm_cit_owner_name	VARCHAR(50)	<--->	citOwnerName	java.lang.String
     * DB is  Nullable: true
     * DB defaultValue: null
     * </pre>
     */
    @Length(max = 50, message = "{" + AtmBaseBeanI18nConstant.ATM_BASE_BEAN_CIT_OWNER_NAME_LENGTH + "}", groups = {IBaseValidGroup.Add.class, IBaseValidGroup.Update.class})
    @Column(name = "atm_cit_owner_name", length = 50, nullable = true)
    private String citOwnerName;

    /**
     * <pre>
     * DB remark: 客户公司名
     * DB column: atm_client_name	VARCHAR(100)	<--->	clientName	java.lang.String
     * DB is  Nullable: true
     * DB defaultValue: null
     * </pre>
     */
    @Length(max = 100, message = "{" + AtmBaseBeanI18nConstant.ATM_BASE_BEAN_CLIENT_NAME_LENGTH + "}", groups = {IBaseValidGroup.Add.class, IBaseValidGroup.Update.class})
    @Column(name = "atm_client_name", length = 100, nullable = true)
    private String clientName;

    /**
     * <pre>
     * DB remark: 客户网点名
     * DB column: atm_client_branch_name	VARCHAR(100)	<--->	clientBranchName	java.lang.String
     * DB is  Nullable: true
     * DB defaultValue: null
     * </pre>
     */
    @Length(max = 100, message = "{" + AtmBaseBeanI18nConstant.ATM_BASE_BEAN_CLIENT_BRANCH_NAME_LENGTH + "}", groups = {IBaseValidGroup.Add.class, IBaseValidGroup.Update.class})
    @Column(name = "atm_client_branch_name", length = 100, nullable = true)
    private String clientBranchName;

    /**
     * <pre>
     * DB remark: 客户网点联系电话,与t_client_branch.branch_phone,关联
     * DB column: atm_client_branch_phone	VARCHAR(15)	<--->	clientBranchPhone	java.lang.String
     * DB is  Nullable: true
     * DB defaultValue: null
     * </pre>
     */
    @Length(max = 15, message = "{" + AtmBaseBeanI18nConstant.ATM_BASE_BEAN_CLIENT_BRANCH_PHONE_LENGTH + "}", groups = {IBaseValidGroup.Add.class, IBaseValidGroup.Update.class})
    @Column(name = "atm_client_branch_phone", length = 15, nullable = true)
    private String clientBranchPhone;

    /**
     * <pre>
     * DB remark: 客户网点地址,与t_client_branch.branch_address,关联
     * DB column: atm_client_branch_address	VARCHAR(150)	<--->	clientBranchAddress	java.lang.String
     * DB is  Nullable: true
     * DB defaultValue: null
     * </pre>
     */
    @Length(max = 150, message = "{" + AtmBaseBeanI18nConstant.ATM_BASE_BEAN_CLIENT_BRANCH_ADDRESS_LENGTH + "}", groups = {IBaseValidGroup.Add.class, IBaseValidGroup.Update.class})
    @Column(name = "atm_client_branch_address", length = 150, nullable = true)
    private String clientBranchAddress;

    /**
     * <pre>
     * DB remark: 客户网点地址坐标纬度,浮点型,与t_client_branch.branch_latitude,关联
     * DB column: atm_client_branch_latitude	VARCHAR(15)	<--->	clientBranchLatitude	java.lang.String
     * DB is  Nullable: true
     * DB defaultValue: null
     * </pre>
     */
    @Length(max = 15, message = "{" + AtmBaseBeanI18nConstant.ATM_BASE_BEAN_CLIENT_BRANCH_LATITUDE_LENGTH + "}", groups = {IBaseValidGroup.Add.class, IBaseValidGroup.Update.class})
    @Column(name = "atm_client_branch_latitude", length = 15, nullable = true)
    private String clientBranchLatitude;

    /**
     * <pre>
     * DB remark: 客户网点地址坐标经度,浮点型,与t_client_branch.branch_longitude,关联
     * DB column: atm_client_branch_longitude	VARCHAR(15)	<--->	clientBranchLongitude	java.lang.String
     * DB is  Nullable: true
     * DB defaultValue: null
     * </pre>
     */
    @Length(max = 15, message = "{" + AtmBaseBeanI18nConstant.ATM_BASE_BEAN_CLIENT_BRANCH_LONGITUDE_LENGTH + "}", groups = {IBaseValidGroup.Add.class, IBaseValidGroup.Update.class})
    @Column(name = "atm_client_branch_longitude", length = 15, nullable = true)
    private String clientBranchLongitude;

    /**
     * <pre>
     * DB remark: 负责人,与t_crew.crew_id 字段关联【{"max":13}】
     * DB column: atm_client_owner_id	BIGINT(20)	<--->	clientOwnerId	java.lang.Long
     * DB is  Nullable: true
     * DB defaultValue: null
     * </pre>
     */
    @ValidLength(max = 13, message = "{" + AtmBaseBeanI18nConstant.ATM_BASE_BEAN_CLIENT_OWNER_ID_LENGTH + "}", groups = {IBaseValidGroup.Add.class, IBaseValidGroup.Update.class})
    @Column(name = "atm_client_owner_id", length = 20, nullable = true)
    private Long clientOwnerId;

    /**
     * <pre>
     * DB remark: 负责人,与t_client.client_id 字段关联【{"max":13}】
     * DB column: atm_client_owner_name	VARCHAR(50)	<--->	clientOwnerName	java.lang.String
     * DB is  Nullable: true
     * DB defaultValue: null
     * </pre>
     */
    @Length(max = 13, message = "{" + AtmBaseBeanI18nConstant.ATM_BASE_BEAN_CLIENT_OWNER_NAME_LENGTH + "}", groups = {IBaseValidGroup.Add.class, IBaseValidGroup.Update.class})
    @Column(name = "atm_client_owner_name", length = 50, nullable = true)
    private String clientOwnerName;

    /**
     * <pre>
     * DB remark: 基础状态
     * DB column: atm_status	CHAR(32)	<--->	status	java.lang.String
     * DB is  Nullable: true
     * DB defaultValue: null
     * </pre>
     */
    @Length(max = 32, message = "{" + AtmBaseBeanI18nConstant.ATM_BASE_BEAN_STATUS_LENGTH + "}", groups = {IBaseValidGroup.Add.class, IBaseValidGroup.Update.class})
    @Column(name = "atm_status", length = 32, nullable = true)
    private String status;

    /**
     * <pre>
     * DB remark: 货币,总金额
     * DB column: atm_currency_total_amount	DECIMAL(14)	<--->	currencyTotalAmount	java.math.BigDecimal
     * DB is  Nullable: true
     * DB defaultValue: 0.0000
     * </pre>
     */
    @Column(name = "atm_currency_total_amount", length = 14, nullable = true)
    private BigDecimal currencyTotalAmount;

    /**
     * <pre>
     * DB remark: 货币,当前容量【单位：张】
     * DB column: atm_current_capacity	INTEGER(10)	<--->	currentCapacity	java.lang.Integer
     * DB is  Nullable: true
     * DB defaultValue: 0
     * </pre>
     */
    @ValidLength(max = 10, message = "{" + AtmBaseBeanI18nConstant.ATM_BASE_BEAN_CURRENT_CAPACITY_LENGTH + "}", groups = {IBaseValidGroup.Add.class, IBaseValidGroup.Update.class})
    @Column(name = "atm_current_capacity", length = 10, nullable = true)
    private Integer currentCapacity;

    /**
     * <pre>
     * DB remark: 货币,最大容量【单位：张】
     * DB column: atm_currency_max_capacity	INTEGER(10)	<--->	currencyMaxCapacity	java.lang.Integer
     * DB is  Nullable: true
     * DB defaultValue: 0
     * </pre>
     */
    @ValidLength(max = 10, message = "{" + AtmBaseBeanI18nConstant.ATM_BASE_BEAN_CURRENCY_MAX_CAPACITY_LENGTH + "}", groups = {IBaseValidGroup.Add.class, IBaseValidGroup.Update.class})
    @Column(name = "atm_currency_max_capacity", length = 10, nullable = true)
    private Integer currencyMaxCapacity;

    /**
     * <pre>
     * DB remark: 货币,类型
     * DB column: atm_currency_type	VARCHAR(5)	<--->	currencyType	java.lang.String
     * DB is  Nullable: true
     * DB defaultValue: null
     * </pre>
     */
    @Length(max = 5, message = "{" + AtmBaseBeanI18nConstant.ATM_BASE_BEAN_CURRENCY_TYPE_LENGTH + "}", groups = {IBaseValidGroup.Add.class, IBaseValidGroup.Update.class})
    @Column(name = "atm_currency_type", length = 5, nullable = true)
    private String currencyType;

    /**
     * <pre>
     * DB remark: 信封,总数【单位：张】
     * DB column: atm_envelopes_total_amount	INTEGER(10)	<--->	envelopesTotalAmount	java.lang.Integer
     * DB is  Nullable: true
     * DB defaultValue: 0
     * </pre>
     */
    @ValidLength(max = 10, message = "{" + AtmBaseBeanI18nConstant.ATM_BASE_BEAN_ENVELOPES_TOTAL_AMOUNT_LENGTH + "}", groups = {IBaseValidGroup.Add.class, IBaseValidGroup.Update.class})
    @Column(name = "atm_envelopes_total_amount", length = 10, nullable = true)
    private Integer envelopesTotalAmount;

    /**
     * <pre>
     * DB remark: 信封,当前容量【单位：张】
     * DB column: atm_envelopes_capacity	INTEGER(10)	<--->	envelopesCapacity	java.lang.Integer
     * DB is  Nullable: true
     * DB defaultValue: 0
     * </pre>
     */
    @ValidLength(max = 10, message = "{" + AtmBaseBeanI18nConstant.ATM_BASE_BEAN_ENVELOPES_CAPACITY_LENGTH + "}", groups = {IBaseValidGroup.Add.class, IBaseValidGroup.Update.class})
    @Column(name = "atm_envelopes_capacity", length = 10, nullable = true)
    private Integer envelopesCapacity;

    /**
     * <pre>
     * DB remark: 信封,最大容量【单位：张】
     * DB column: atm_envelopes_max_capacity	INTEGER(10)	<--->	envelopesMaxCapacity	java.lang.Integer
     * DB is  Nullable: true
     * DB defaultValue: 0
     * </pre>
     */
    @ValidLength(max = 10, message = "{" + AtmBaseBeanI18nConstant.ATM_BASE_BEAN_ENVELOPES_MAX_CAPACITY_LENGTH + "}", groups = {IBaseValidGroup.Add.class, IBaseValidGroup.Update.class})
    @Column(name = "atm_envelopes_max_capacity", length = 10, nullable = true)
    private Integer envelopesMaxCapacity;

    /**
     * <pre>
     * DB remark: 创建的用户
     * DB column: atm_create_by	VARCHAR(20)	<--->	createBy	java.lang.String
     * DB is  Nullable: false
     * DB defaultValue: null
     * </pre>
     */
    @NotBlank(message = "{" + AtmBaseBeanI18nConstant.ATM_BASE_BEAN_CREATE_BY_NOT_BLANK + "}", groups = {IBaseValidGroup.Add.class, IBaseValidGroup.Update.class})
    @Length(max = 20, message = "{" + AtmBaseBeanI18nConstant.ATM_BASE_BEAN_CREATE_BY_LENGTH + "}", groups = {IBaseValidGroup.Add.class, IBaseValidGroup.Update.class})
    @Column(name = "atm_create_by", length = 20, nullable = false)
    private String createBy;

    /**
     * <pre>
     * DB remark: 创建时间
     * DB column: atm_create_timestamp	TIMESTAMP(19)	<--->	createTimestamp	java.util.Date
     * DB is  Nullable: false
     * DB defaultValue: CURRENT_TIMESTAMP
     * </pre>
     */
    @ValidDateTimeFormat(pattern = DateUtil.DATE_PATTERN_YYYY_MM_DD_HH_MM_SS, message = "{" + AtmBaseBeanI18nConstant.ATM_BASE_BEAN_CREATE_TIMESTAMP_DATE_TIME_FORMAT + "}", groups = {IBaseValidGroup.Add.class, IBaseValidGroup.Update.class})
    @DateTimeFormat(pattern = DateUtil.DATE_PATTERN_YYYY_MM_DD_HH_MM_SS)
    @NotNull(message = "{" + AtmBaseBeanI18nConstant.ATM_BASE_BEAN_CREATE_TIMESTAMP_NOT_NULL + "}", groups = {IBaseValidGroup.Add.class, IBaseValidGroup.Update.class})
    @Column(name = "atm_create_timestamp", length = 19, nullable = false)
    private Date createTimestamp;

    /**
     * <pre>
     * DB remark: 更新时间
     * DB column: atm_update_timestamp	TIMESTAMP(19)	<--->	updateTimestamp	java.util.Date
     * DB is  Nullable: false
     * DB defaultValue: CURRENT_TIMESTAMP
     * </pre>
     */
    @ValidDateTimeFormat(pattern = DateUtil.DATE_PATTERN_YYYY_MM_DD_HH_MM_SS, message = "{" + AtmBaseBeanI18nConstant.ATM_BASE_BEAN_UPDATE_TIMESTAMP_DATE_TIME_FORMAT + "}", groups = {IBaseValidGroup.Add.class, IBaseValidGroup.Update.class})
    @DateTimeFormat(pattern = DateUtil.DATE_PATTERN_YYYY_MM_DD_HH_MM_SS)
    @NotNull(message = "{" + AtmBaseBeanI18nConstant.ATM_BASE_BEAN_UPDATE_TIMESTAMP_NOT_NULL + "}", groups = {IBaseValidGroup.Add.class, IBaseValidGroup.Update.class})
    @Column(name = "atm_update_timestamp", length = 19, nullable = false)
    private Date updateTimestamp;

    /**
     * <pre>
     * DB remark: 逻辑删除标志【N[正常]，Y[删除]】
     * DB column: atm_delete_flag	CHAR(1)	<--->	deleteFlag	java.lang.String
     * DB is  Nullable: false
     * DB defaultValue: N
     * </pre>
     */
    @NotBlank(message = "{" + AtmBaseBeanI18nConstant.ATM_BASE_BEAN_DELETE_FLAG_NOT_BLANK + "}", groups = {IBaseValidGroup.Add.class, IBaseValidGroup.Update.class})
    @Length(max = 1, message = "{" + AtmBaseBeanI18nConstant.ATM_BASE_BEAN_DELETE_FLAG_LENGTH + "}", groups = {IBaseValidGroup.Add.class, IBaseValidGroup.Update.class})
    @Column(name = "atm_delete_flag", length = 1, nullable = false)
    private String deleteFlag;

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
    public AtmBaseBean setId(Long id) {
        this.id = id;
        return this;
    }

    /**
     * 获取 ATM终端，唯一标识
     *
     * @return atm_terminal_id - ATM终端，唯一标识
     */
    public String getTerminalId() {
        return terminalId;
    }

    /**
     * 设置 ATM终端，唯一标识
     *
     * @param terminalId - ATM终端，唯一标识
     */
    public AtmBaseBean setTerminalId(String terminalId) {
        this.terminalId = terminalId == null ? null : terminalId.trim();
        return this;
    }

    /**
     * 获取 ATM终端，设备类型
     *
     * @return atm_terminal_type - ATM终端，设备类型
     */
    public String getTerminalType() {
        return terminalType;
    }

    /**
     * 设置 ATM终端，设备类型
     *
     * @param terminalType - ATM终端，设备类型
     */
    public AtmBaseBean setTerminalType(String terminalType) {
        this.terminalType = terminalType == null ? null : terminalType.trim();
        return this;
    }

    /**
     * 获取 cit公司ID,与t_client.client_id 字段关联【{"max":13}】
     *
     * @return atm_cit_id - cit公司ID,与t_client.client_id 字段关联【{"max":13}】
     */
    public Long getCitId() {
        return citId;
    }

    /**
     * 设置 cit公司ID,与t_client.client_id 字段关联【{"max":13}】
     *
     * @param citId - cit公司ID,与t_client.client_id 字段关联【{"max":13}】
     */
    public AtmBaseBean setCitId(Long citId) {
        this.citId = citId;
        return this;
    }

    /**
     * 获取 cit公司内部ID,与t_client.client_internal_id 字段冗余
     *
     * @return atm_cit_internal_id - cit公司内部ID,与t_client.client_internal_id 字段冗余
     */
    public String getCitInternalId() {
        return citInternalId;
    }

    /**
     * 设置 cit公司内部ID,与t_client.client_internal_id 字段冗余
     *
     * @param citInternalId - cit公司内部ID,与t_client.client_internal_id 字段冗余
     */
    public AtmBaseBean setCitInternalId(String citInternalId) {
        this.citInternalId = citInternalId == null ? null : citInternalId.trim();
        return this;
    }

    /**
     * 获取 cit公司名称,与t_client.client_name,冗余
     *
     * @return atm_cit_name - cit公司名称,与t_client.client_name,冗余
     */
    public String getCitName() {
        return citName;
    }

    /**
     * 设置 cit公司名称,与t_client.client_name,冗余
     *
     * @param citName - cit公司名称,与t_client.client_name,冗余
     */
    public AtmBaseBean setCitName(String citName) {
        this.citName = citName == null ? null : citName.trim();
        return this;
    }

    /**
     * 获取 cit网点ID,网点id,与t_client_branch.branch_id,关联【{"max":13}】
     *
     * @return atm_cit_branch_id - cit网点ID,网点id,与t_client_branch.branch_id,关联【{"max":13}】
     */
    public String getCitBranchId() {
        return citBranchId;
    }

    /**
     * 设置 cit网点ID,网点id,与t_client_branch.branch_id,关联【{"max":13}】
     *
     * @param citBranchId - cit网点ID,网点id,与t_client_branch.branch_id,关联【{"max":13}】
     */
    public AtmBaseBean setCitBranchId(String citBranchId) {
        this.citBranchId = citBranchId == null ? null : citBranchId.trim();
        return this;
    }

    /**
     * 获取 cit网点ID,网点内部Id,与t_client_branch.branch_internal_id,关联
     *
     * @return atm_cit_branch_internal_id - cit网点ID,网点内部Id,与t_client_branch.branch_internal_id,关联
     */
    public String getCitBranchInternalId() {
        return citBranchInternalId;
    }

    /**
     * 设置 cit网点ID,网点内部Id,与t_client_branch.branch_internal_id,关联
     *
     * @param citBranchInternalId - cit网点ID,网点内部Id,与t_client_branch.branch_internal_id,关联
     */
    public AtmBaseBean setCitBranchInternalId(String citBranchInternalId) {
        this.citBranchInternalId = citBranchInternalId == null ? null : citBranchInternalId.trim();
        return this;
    }

    /**
     * 获取 cit网点名称,与t_client_branch.branch_name,冗余
     *
     * @return atm_cit_branch_name - cit网点名称,与t_client_branch.branch_name,冗余
     */
    public String getCitBranchName() {
        return citBranchName;
    }

    /**
     * 设置 cit网点名称,与t_client_branch.branch_name,冗余
     *
     * @param citBranchName - cit网点名称,与t_client_branch.branch_name,冗余
     */
    public AtmBaseBean setCitBranchName(String citBranchName) {
        this.citBranchName = citBranchName == null ? null : citBranchName.trim();
        return this;
    }

    /**
     * 获取 负责人,与t_crew.crew_id 字段关联【{"max":13}】
     *
     * @return atm_cit_owner_id - 负责人,与t_crew.crew_id 字段关联【{"max":13}】
     */
    public Long getCitOwnerId() {
        return citOwnerId;
    }

    /**
     * 设置 负责人,与t_crew.crew_id 字段关联【{"max":13}】
     *
     * @param citOwnerId - 负责人,与t_crew.crew_id 字段关联【{"max":13}】
     */
    public AtmBaseBean setCitOwnerId(Long citOwnerId) {
        this.citOwnerId = citOwnerId;
        return this;
    }

    /**
     * 获取 负责人,与t_client.client_id 字段关联
     *
     * @return atm_cit_owner_name - 负责人,与t_client.client_id 字段关联
     */
    public String getCitOwnerName() {
        return citOwnerName;
    }

    /**
     * 设置 负责人,与t_client.client_id 字段关联
     *
     * @param citOwnerName - 负责人,与t_client.client_id 字段关联
     */
    public AtmBaseBean setCitOwnerName(String citOwnerName) {
        this.citOwnerName = citOwnerName == null ? null : citOwnerName.trim();
        return this;
    }

    /**
     * 获取 客户公司名
     *
     * @return atm_client_name - 客户公司名
     */
    public String getClientName() {
        return clientName;
    }

    /**
     * 设置 客户公司名
     *
     * @param clientName - 客户公司名
     */
    public AtmBaseBean setClientName(String clientName) {
        this.clientName = clientName == null ? null : clientName.trim();
        return this;
    }

    /**
     * 获取 客户网点名
     *
     * @return atm_client_branch_name - 客户网点名
     */
    public String getClientBranchName() {
        return clientBranchName;
    }

    /**
     * 设置 客户网点名
     *
     * @param clientBranchName - 客户网点名
     */
    public AtmBaseBean setClientBranchName(String clientBranchName) {
        this.clientBranchName = clientBranchName == null ? null : clientBranchName.trim();
        return this;
    }

    /**
     * 获取 客户网点联系电话,与t_client_branch.branch_phone,关联
     *
     * @return atm_client_branch_phone - 客户网点联系电话,与t_client_branch.branch_phone,关联
     */
    public String getClientBranchPhone() {
        return clientBranchPhone;
    }

    /**
     * 设置 客户网点联系电话,与t_client_branch.branch_phone,关联
     *
     * @param clientBranchPhone - 客户网点联系电话,与t_client_branch.branch_phone,关联
     */
    public AtmBaseBean setClientBranchPhone(String clientBranchPhone) {
        this.clientBranchPhone = clientBranchPhone == null ? null : clientBranchPhone.trim();
        return this;
    }

    /**
     * 获取 客户网点地址,与t_client_branch.branch_address,关联
     *
     * @return atm_client_branch_address - 客户网点地址,与t_client_branch.branch_address,关联
     */
    public String getClientBranchAddress() {
        return clientBranchAddress;
    }

    /**
     * 设置 客户网点地址,与t_client_branch.branch_address,关联
     *
     * @param clientBranchAddress - 客户网点地址,与t_client_branch.branch_address,关联
     */
    public AtmBaseBean setClientBranchAddress(String clientBranchAddress) {
        this.clientBranchAddress = clientBranchAddress == null ? null : clientBranchAddress.trim();
        return this;
    }

    /**
     * 获取 客户网点地址坐标纬度,浮点型,与t_client_branch.branch_latitude,关联
     *
     * @return atm_client_branch_latitude - 客户网点地址坐标纬度,浮点型,与t_client_branch.branch_latitude,关联
     */
    public String getClientBranchLatitude() {
        return clientBranchLatitude;
    }

    /**
     * 设置 客户网点地址坐标纬度,浮点型,与t_client_branch.branch_latitude,关联
     *
     * @param clientBranchLatitude - 客户网点地址坐标纬度,浮点型,与t_client_branch.branch_latitude,关联
     */
    public AtmBaseBean setClientBranchLatitude(String clientBranchLatitude) {
        this.clientBranchLatitude = clientBranchLatitude == null ? null : clientBranchLatitude.trim();
        return this;
    }

    /**
     * 获取 客户网点地址坐标经度,浮点型,与t_client_branch.branch_longitude,关联
     *
     * @return atm_client_branch_longitude - 客户网点地址坐标经度,浮点型,与t_client_branch.branch_longitude,关联
     */
    public String getClientBranchLongitude() {
        return clientBranchLongitude;
    }

    /**
     * 设置 客户网点地址坐标经度,浮点型,与t_client_branch.branch_longitude,关联
     *
     * @param clientBranchLongitude - 客户网点地址坐标经度,浮点型,与t_client_branch.branch_longitude,关联
     */
    public AtmBaseBean setClientBranchLongitude(String clientBranchLongitude) {
        this.clientBranchLongitude = clientBranchLongitude == null ? null : clientBranchLongitude.trim();
        return this;
    }

    /**
     * 获取 负责人,与t_crew.crew_id 字段关联【{"max":13}】
     *
     * @return atm_client_owner_id - 负责人,与t_crew.crew_id 字段关联【{"max":13}】
     */
    public Long getClientOwnerId() {
        return clientOwnerId;
    }

    /**
     * 设置 负责人,与t_crew.crew_id 字段关联【{"max":13}】
     *
     * @param clientOwnerId - 负责人,与t_crew.crew_id 字段关联【{"max":13}】
     */
    public AtmBaseBean setClientOwnerId(Long clientOwnerId) {
        this.clientOwnerId = clientOwnerId;
        return this;
    }

    /**
     * 获取 负责人,与t_client.client_id 字段关联【{"max":13}】
     *
     * @return atm_client_owner_name - 负责人,与t_client.client_id 字段关联【{"max":13}】
     */
    public String getClientOwnerName() {
        return clientOwnerName;
    }

    /**
     * 设置 负责人,与t_client.client_id 字段关联【{"max":13}】
     *
     * @param clientOwnerName - 负责人,与t_client.client_id 字段关联【{"max":13}】
     */
    public AtmBaseBean setClientOwnerName(String clientOwnerName) {
        this.clientOwnerName = clientOwnerName == null ? null : clientOwnerName.trim();
        return this;
    }

    /**
     * 获取 基础状态
     *
     * @return atm_status - 基础状态
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
     * 获取 货币,总金额
     *
     * @return atm_currency_total_amount - 货币,总金额
     */
    public BigDecimal getCurrencyTotalAmount() {
        return currencyTotalAmount;
    }

    /**
     * 设置 货币,总金额
     *
     * @param currencyTotalAmount - 货币,总金额
     */
    public AtmBaseBean setCurrencyTotalAmount(BigDecimal currencyTotalAmount) {
        this.currencyTotalAmount = currencyTotalAmount;
        return this;
    }

    /**
     * 获取 货币,当前容量【单位：张】
     *
     * @return atm_current_capacity - 货币,当前容量【单位：张】
     */
    public Integer getCurrentCapacity() {
        return currentCapacity;
    }

    /**
     * 设置 货币,当前容量【单位：张】
     *
     * @param currentCapacity - 货币,当前容量【单位：张】
     */
    public AtmBaseBean setCurrentCapacity(Integer currentCapacity) {
        this.currentCapacity = currentCapacity;
        return this;
    }

    /**
     * 获取 货币,最大容量【单位：张】
     *
     * @return atm_currency_max_capacity - 货币,最大容量【单位：张】
     */
    public Integer getCurrencyMaxCapacity() {
        return currencyMaxCapacity;
    }

    /**
     * 设置 货币,最大容量【单位：张】
     *
     * @param currencyMaxCapacity - 货币,最大容量【单位：张】
     */
    public AtmBaseBean setCurrencyMaxCapacity(Integer currencyMaxCapacity) {
        this.currencyMaxCapacity = currencyMaxCapacity;
        return this;
    }

    /**
     * 获取 货币,类型
     *
     * @return atm_currency_type - 货币,类型
     */
    public String getCurrencyType() {
        return currencyType;
    }

    /**
     * 设置 货币,类型
     *
     * @param currencyType - 货币,类型
     */
    public AtmBaseBean setCurrencyType(String currencyType) {
        this.currencyType = currencyType == null ? null : currencyType.trim();
        return this;
    }

    /**
     * 获取 信封,总数【单位：张】
     *
     * @return atm_envelopes_total_amount - 信封,总数【单位：张】
     */
    public Integer getEnvelopesTotalAmount() {
        return envelopesTotalAmount;
    }

    /**
     * 设置 信封,总数【单位：张】
     *
     * @param envelopesTotalAmount - 信封,总数【单位：张】
     */
    public AtmBaseBean setEnvelopesTotalAmount(Integer envelopesTotalAmount) {
        this.envelopesTotalAmount = envelopesTotalAmount;
        return this;
    }

    /**
     * 获取 信封,当前容量【单位：张】
     *
     * @return atm_envelopes_capacity - 信封,当前容量【单位：张】
     */
    public Integer getEnvelopesCapacity() {
        return envelopesCapacity;
    }

    /**
     * 设置 信封,当前容量【单位：张】
     *
     * @param envelopesCapacity - 信封,当前容量【单位：张】
     */
    public AtmBaseBean setEnvelopesCapacity(Integer envelopesCapacity) {
        this.envelopesCapacity = envelopesCapacity;
        return this;
    }

    /**
     * 获取 信封,最大容量【单位：张】
     *
     * @return atm_envelopes_max_capacity - 信封,最大容量【单位：张】
     */
    public Integer getEnvelopesMaxCapacity() {
        return envelopesMaxCapacity;
    }

    /**
     * 设置 信封,最大容量【单位：张】
     *
     * @param envelopesMaxCapacity - 信封,最大容量【单位：张】
     */
    public AtmBaseBean setEnvelopesMaxCapacity(Integer envelopesMaxCapacity) {
        this.envelopesMaxCapacity = envelopesMaxCapacity;
        return this;
    }

    /**
     * 获取 创建的用户
     *
     * @return atm_create_by - 创建的用户
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
    public AtmBaseBean setCreateTimestamp(Date createTimestamp) {
        this.createTimestamp = createTimestamp;
        return this;
    }

    /**
     * 获取 更新时间
     *
     * @return atm_update_timestamp - 更新时间
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
     * @return atm_delete_flag - 逻辑删除标志【N[正常]，Y[删除]】
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