package com.comodin.fleet.core.bean;

import com.comodin.basic.util.date.DateUtil;
import com.comodin.basic.validation.IBaseValidGroup;
import com.comodin.basic.validation.constraints.*;
import com.comodin.fleet.constants.i18n.AtmBaseMaintainBeanI18nConstant;
import java.io.Serializable;
import java.util.Date;
import javax.persistence.*;
import javax.validation.constraints.*;
import org.hibernate.validator.constraints.*;
import org.springframework.format.annotation.DateTimeFormat;

@SuppressWarnings({"unused", "SpringAutowiredFieldsWarningInspection", "StatementWithEmptyBody", "WeakerAccess"})
@Entity
@Table(name = "t_atm_base_maintain")
public class AtmBaseMaintainBean implements Serializable {
    /**
     * <pre>
     * DB remark: 数据库主键ID
     * DB column: maintain_id	BIGINT(20)	<--->	id	java.lang.Long
     * DB is  Nullable: false
     * DB defaultValue: null
     * </pre>
     */
    @NotNull(message = "{" + AtmBaseMaintainBeanI18nConstant.ATM_BASE_MAINTAIN_BEAN_ID_NOT_NULL + "}", groups = {IBaseValidGroup.Update.class})
    @ValidLength(max = 20, message = "{" + AtmBaseMaintainBeanI18nConstant.ATM_BASE_MAINTAIN_BEAN_ID_LENGTH + "}", groups = {IBaseValidGroup.Update.class})
    @Column(name = "maintain_id", length = 20, nullable = false)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    private Long id;

    /**
     * <pre>
     * DB remark: atmBaseId,t_atm_base.base_id 关联
     * DB column: maintain_base_id	BIGINT(20)	<--->	baseId	java.lang.Long
     * DB is  Nullable: false
     * DB defaultValue: null
     * </pre>
     */
    @NotNull(message = "{" + AtmBaseMaintainBeanI18nConstant.ATM_BASE_MAINTAIN_BEAN_BASE_ID_NOT_NULL + "}", groups = {IBaseValidGroup.Add.class, IBaseValidGroup.Update.class})
    @ValidLength(max = 20, message = "{" + AtmBaseMaintainBeanI18nConstant.ATM_BASE_MAINTAIN_BEAN_BASE_ID_LENGTH + "}", groups = {IBaseValidGroup.Add.class, IBaseValidGroup.Update.class})
    @Column(name = "maintain_base_id", length = 20, nullable = false)
    private Long baseId;

    /**
     * <pre>
     * DB remark: ATM终端，唯一标识
     * DB column: maintain_atm_terminal_id	VARCHAR(64)	<--->	atmTerminalId	java.lang.String
     * DB is  Nullable: false
     * DB defaultValue: null
     * </pre>
     */
    @NotBlank(message = "{" + AtmBaseMaintainBeanI18nConstant.ATM_BASE_MAINTAIN_BEAN_ATM_TERMINAL_ID_NOT_BLANK + "}", groups = {IBaseValidGroup.Add.class, IBaseValidGroup.Update.class})
    @Length(max = 64, message = "{" + AtmBaseMaintainBeanI18nConstant.ATM_BASE_MAINTAIN_BEAN_ATM_TERMINAL_ID_LENGTH + "}", groups = {IBaseValidGroup.Add.class, IBaseValidGroup.Update.class})
    @Column(name = "maintain_atm_terminal_id", length = 64, nullable = false)
    private String atmTerminalId;

    /**
     * <pre>
     * DB remark: ATM终端，设备类型
     * DB column: maintain_atm_terminal_type	VARCHAR(20)	<--->	atmTerminalType	java.lang.String
     * DB is  Nullable: false
     * DB defaultValue: null
     * </pre>
     */
    @NotBlank(message = "{" + AtmBaseMaintainBeanI18nConstant.ATM_BASE_MAINTAIN_BEAN_ATM_TERMINAL_TYPE_NOT_BLANK + "}", groups = {IBaseValidGroup.Add.class, IBaseValidGroup.Update.class})
    @Length(max = 20, message = "{" + AtmBaseMaintainBeanI18nConstant.ATM_BASE_MAINTAIN_BEAN_ATM_TERMINAL_TYPE_LENGTH + "}", groups = {IBaseValidGroup.Add.class, IBaseValidGroup.Update.class})
    @Column(name = "maintain_atm_terminal_type", length = 20, nullable = false)
    private String atmTerminalType;

    /**
     * <pre>
     * DB remark: 错误,类型
     * DB column: maintain_error_type	VARCHAR(10)	<--->	errorType	java.lang.String
     * DB is  Nullable: false
     * DB defaultValue: null
     * </pre>
     */
    @NotBlank(message = "{" + AtmBaseMaintainBeanI18nConstant.ATM_BASE_MAINTAIN_BEAN_ERROR_TYPE_NOT_BLANK + "}", groups = {IBaseValidGroup.Add.class, IBaseValidGroup.Update.class})
    @Length(max = 10, message = "{" + AtmBaseMaintainBeanI18nConstant.ATM_BASE_MAINTAIN_BEAN_ERROR_TYPE_LENGTH + "}", groups = {IBaseValidGroup.Add.class, IBaseValidGroup.Update.class})
    @Column(name = "maintain_error_type", length = 10, nullable = false)
    private String errorType;

    /**
     * <pre>
     * DB remark: 错误,产生时间
     * DB column: maintain_error_time	TIMESTAMP(19)	<--->	errorTime	java.util.Date
     * DB is  Nullable: false
     * DB defaultValue: null
     * </pre>
     */
    @ValidDateTimeFormat(pattern = DateUtil.DATE_PATTERN_YYYY_MM_DD_HH_MM_SS, message = "{" + AtmBaseMaintainBeanI18nConstant.ATM_BASE_MAINTAIN_BEAN_ERROR_TIME_DATE_TIME_FORMAT + "}", groups = {IBaseValidGroup.Add.class, IBaseValidGroup.Update.class})
    @DateTimeFormat(pattern = DateUtil.DATE_PATTERN_YYYY_MM_DD_HH_MM_SS)
    @NotNull(message = "{" + AtmBaseMaintainBeanI18nConstant.ATM_BASE_MAINTAIN_BEAN_ERROR_TIME_NOT_NULL + "}", groups = {IBaseValidGroup.Add.class, IBaseValidGroup.Update.class})
    @Column(name = "maintain_error_time", length = 19, nullable = false)
    private Date errorTime;

    /**
     * <pre>
     * DB remark: 错误,修复时间
     * DB column: maintain_error_fixed_time	TIMESTAMP(19)	<--->	errorFixedTime	java.util.Date
     * DB is  Nullable: true
     * DB defaultValue: null
     * </pre>
     */
    @ValidDateTimeFormat(pattern = DateUtil.DATE_PATTERN_YYYY_MM_DD_HH_MM_SS, message = "{" + AtmBaseMaintainBeanI18nConstant.ATM_BASE_MAINTAIN_BEAN_ERROR_FIXED_TIME_DATE_TIME_FORMAT + "}", groups = {IBaseValidGroup.Add.class, IBaseValidGroup.Update.class})
    @DateTimeFormat(pattern = DateUtil.DATE_PATTERN_YYYY_MM_DD_HH_MM_SS)
    @Column(name = "maintain_error_fixed_time", length = 19, nullable = true)
    private Date errorFixedTime;

    /**
     * <pre>
     * DB remark: 维护者,ID
     * DB column: maintain_operator_id	VARCHAR(20)	<--->	operatorId	java.lang.String
     * DB is  Nullable: false
     * DB defaultValue: null
     * </pre>
     */
    @NotBlank(message = "{" + AtmBaseMaintainBeanI18nConstant.ATM_BASE_MAINTAIN_BEAN_OPERATOR_ID_NOT_BLANK + "}", groups = {IBaseValidGroup.Add.class, IBaseValidGroup.Update.class})
    @Length(max = 20, message = "{" + AtmBaseMaintainBeanI18nConstant.ATM_BASE_MAINTAIN_BEAN_OPERATOR_ID_LENGTH + "}", groups = {IBaseValidGroup.Add.class, IBaseValidGroup.Update.class})
    @Column(name = "maintain_operator_id", length = 20, nullable = false)
    private String operatorId;

    /**
     * <pre>
     * DB remark: 错误,修复结果
     * DB column: maintain_result	VARCHAR(20)	<--->	result	java.lang.String
     * DB is  Nullable: true
     * DB defaultValue: null
     * </pre>
     */
    @Length(max = 20, message = "{" + AtmBaseMaintainBeanI18nConstant.ATM_BASE_MAINTAIN_BEAN_RESULT_LENGTH + "}", groups = {IBaseValidGroup.Add.class, IBaseValidGroup.Update.class})
    @Column(name = "maintain_result", length = 20, nullable = true)
    private String result;

    /**
     * <pre>
     * DB remark: 创建时间
     * DB column: maintain_create_timestamp	TIMESTAMP(19)	<--->	createTimestamp	java.util.Date
     * DB is  Nullable: false
     * DB defaultValue: CURRENT_TIMESTAMP
     * </pre>
     */
    @ValidDateTimeFormat(pattern = DateUtil.DATE_PATTERN_YYYY_MM_DD_HH_MM_SS, message = "{" + AtmBaseMaintainBeanI18nConstant.ATM_BASE_MAINTAIN_BEAN_CREATE_TIMESTAMP_DATE_TIME_FORMAT + "}", groups = {IBaseValidGroup.Add.class, IBaseValidGroup.Update.class})
    @DateTimeFormat(pattern = DateUtil.DATE_PATTERN_YYYY_MM_DD_HH_MM_SS)
    @NotNull(message = "{" + AtmBaseMaintainBeanI18nConstant.ATM_BASE_MAINTAIN_BEAN_CREATE_TIMESTAMP_NOT_NULL + "}", groups = {IBaseValidGroup.Add.class, IBaseValidGroup.Update.class})
    @Column(name = "maintain_create_timestamp", length = 19, nullable = false)
    private Date createTimestamp;

    /**
     * <pre>
     * DB remark: 创建人
     * DB column: maintain_create_by	VARCHAR(20)	<--->	createBy	java.lang.String
     * DB is  Nullable: false
     * DB defaultValue: null
     * </pre>
     */
    @NotBlank(message = "{" + AtmBaseMaintainBeanI18nConstant.ATM_BASE_MAINTAIN_BEAN_CREATE_BY_NOT_BLANK + "}", groups = {IBaseValidGroup.Add.class, IBaseValidGroup.Update.class})
    @Length(max = 20, message = "{" + AtmBaseMaintainBeanI18nConstant.ATM_BASE_MAINTAIN_BEAN_CREATE_BY_LENGTH + "}", groups = {IBaseValidGroup.Add.class, IBaseValidGroup.Update.class})
    @Column(name = "maintain_create_by", length = 20, nullable = false)
    private String createBy;

    /**
     * <pre>
     * DB remark: 逻辑删除标志【N[正常]，Y[删除]】
     * DB column: maintain_delete_flag	CHAR(1)	<--->	deleteFlag	java.lang.String
     * DB is  Nullable: false
     * DB defaultValue: N
     * </pre>
     */
    @NotBlank(message = "{" + AtmBaseMaintainBeanI18nConstant.ATM_BASE_MAINTAIN_BEAN_DELETE_FLAG_NOT_BLANK + "}", groups = {IBaseValidGroup.Add.class, IBaseValidGroup.Update.class})
    @Length(max = 1, message = "{" + AtmBaseMaintainBeanI18nConstant.ATM_BASE_MAINTAIN_BEAN_DELETE_FLAG_LENGTH + "}", groups = {IBaseValidGroup.Add.class, IBaseValidGroup.Update.class})
    @Column(name = "maintain_delete_flag", length = 1, nullable = false)
    private String deleteFlag;

    private static final long serialVersionUID = 1L;

    /**
     * 获取 数据库主键ID
     *
     * @return maintain_id - 数据库主键ID
     */
    public Long getId() {
        return id;
    }

    /**
     * 设置 数据库主键ID
     *
     * @param id - 数据库主键ID
     */
    public AtmBaseMaintainBean setId(Long id) {
        this.id = id;
        return this;
    }

    /**
     * 获取 atmBaseId,t_atm_base.base_id 关联
     *
     * @return maintain_base_id - atmBaseId,t_atm_base.base_id 关联
     */
    public Long getBaseId() {
        return baseId;
    }

    /**
     * 设置 atmBaseId,t_atm_base.base_id 关联
     *
     * @param baseId - atmBaseId,t_atm_base.base_id 关联
     */
    public AtmBaseMaintainBean setBaseId(Long baseId) {
        this.baseId = baseId;
        return this;
    }

    /**
     * 获取 ATM终端，唯一标识
     *
     * @return maintain_atm_terminal_id - ATM终端，唯一标识
     */
    public String getAtmTerminalId() {
        return atmTerminalId;
    }

    /**
     * 设置 ATM终端，唯一标识
     *
     * @param atmTerminalId - ATM终端，唯一标识
     */
    public AtmBaseMaintainBean setAtmTerminalId(String atmTerminalId) {
        this.atmTerminalId = atmTerminalId == null ? null : atmTerminalId.trim();
        return this;
    }

    /**
     * 获取 ATM终端，设备类型
     *
     * @return maintain_atm_terminal_type - ATM终端，设备类型
     */
    public String getAtmTerminalType() {
        return atmTerminalType;
    }

    /**
     * 设置 ATM终端，设备类型
     *
     * @param atmTerminalType - ATM终端，设备类型
     */
    public AtmBaseMaintainBean setAtmTerminalType(String atmTerminalType) {
        this.atmTerminalType = atmTerminalType == null ? null : atmTerminalType.trim();
        return this;
    }

    /**
     * 获取 错误,类型
     *
     * @return maintain_error_type - 错误,类型
     */
    public String getErrorType() {
        return errorType;
    }

    /**
     * 设置 错误,类型
     *
     * @param errorType - 错误,类型
     */
    public AtmBaseMaintainBean setErrorType(String errorType) {
        this.errorType = errorType == null ? null : errorType.trim();
        return this;
    }

    /**
     * 获取 错误,产生时间
     *
     * @return maintain_error_time - 错误,产生时间
     */
    public Date getErrorTime() {
        return errorTime;
    }

    /**
     * 设置 错误,产生时间
     *
     * @param errorTime - 错误,产生时间
     */
    public AtmBaseMaintainBean setErrorTime(Date errorTime) {
        this.errorTime = errorTime;
        return this;
    }

    /**
     * 获取 错误,修复时间
     *
     * @return maintain_error_fixed_time - 错误,修复时间
     */
    public Date getErrorFixedTime() {
        return errorFixedTime;
    }

    /**
     * 设置 错误,修复时间
     *
     * @param errorFixedTime - 错误,修复时间
     */
    public AtmBaseMaintainBean setErrorFixedTime(Date errorFixedTime) {
        this.errorFixedTime = errorFixedTime;
        return this;
    }

    /**
     * 获取 维护者,ID
     *
     * @return maintain_operator_id - 维护者,ID
     */
    public String getOperatorId() {
        return operatorId;
    }

    /**
     * 设置 维护者,ID
     *
     * @param operatorId - 维护者,ID
     */
    public AtmBaseMaintainBean setOperatorId(String operatorId) {
        this.operatorId = operatorId == null ? null : operatorId.trim();
        return this;
    }

    /**
     * 获取 错误,修复结果
     *
     * @return maintain_result - 错误,修复结果
     */
    public String getResult() {
        return result;
    }

    /**
     * 设置 错误,修复结果
     *
     * @param result - 错误,修复结果
     */
    public AtmBaseMaintainBean setResult(String result) {
        this.result = result == null ? null : result.trim();
        return this;
    }

    /**
     * 获取 创建时间
     *
     * @return maintain_create_timestamp - 创建时间
     */
    public Date getCreateTimestamp() {
        return createTimestamp;
    }

    /**
     * 设置 创建时间
     *
     * @param createTimestamp - 创建时间
     */
    public AtmBaseMaintainBean setCreateTimestamp(Date createTimestamp) {
        this.createTimestamp = createTimestamp;
        return this;
    }

    /**
     * 获取 创建人
     *
     * @return maintain_create_by - 创建人
     */
    public String getCreateBy() {
        return createBy;
    }

    /**
     * 设置 创建人
     *
     * @param createBy - 创建人
     */
    public AtmBaseMaintainBean setCreateBy(String createBy) {
        this.createBy = createBy == null ? null : createBy.trim();
        return this;
    }

    /**
     * 获取 逻辑删除标志【N[正常]，Y[删除]】
     *
     * @return maintain_delete_flag - 逻辑删除标志【N[正常]，Y[删除]】
     */
    public String getDeleteFlag() {
        return deleteFlag;
    }

    /**
     * 设置 逻辑删除标志【N[正常]，Y[删除]】
     *
     * @param deleteFlag - 逻辑删除标志【N[正常]，Y[删除]】
     */
    public AtmBaseMaintainBean setDeleteFlag(String deleteFlag) {
        this.deleteFlag = deleteFlag == null ? null : deleteFlag.trim();
        return this;
    }
}