package com.comodin.fleet.core.bean;

import com.comodin.basic.util.date.DateUtil;
import com.comodin.basic.validation.IBaseValidGroup;
import com.comodin.basic.validation.constraints.*;
import com.comodin.fleet.constants.i18n.AtmBaseTransactionBeanI18nConstant;
import java.io.Serializable;
import java.util.Date;
import javax.persistence.*;
import javax.validation.constraints.*;
import org.hibernate.validator.constraints.*;
import org.springframework.format.annotation.DateTimeFormat;

@SuppressWarnings({"unused", "SpringAutowiredFieldsWarningInspection", "StatementWithEmptyBody", "WeakerAccess", "DefaultAnnotationParam"})
@Entity
@Table(name = "t_atm_base_transaction")
public class AtmBaseTransactionBean implements Serializable {
    /**
     * <pre>
     * DB remark: 数据库主键ID
     * DB column: transaction_id	BIGINT(20)	<--->	id	java.lang.Long
     * DB is  Nullable: false
     * DB defaultValue: null
     * </pre>
     */
    @NotNull(message = "{" + AtmBaseTransactionBeanI18nConstant.ATM_BASE_TRANSACTION_BEAN_ID_NOT_NULL + "}", groups = {IBaseValidGroup.Update.class})
    @ValidLength(max = 20, message = "{" + AtmBaseTransactionBeanI18nConstant.ATM_BASE_TRANSACTION_BEAN_ID_LENGTH + "}", groups = {IBaseValidGroup.Update.class})
    @Column(name = "transaction_id", length = 20, nullable = false)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    private Long id;

    /**
     * <pre>
     * DB remark: ATM终端，唯一标识
     * DB column: transaction_atm_terminal_id	VARCHAR(64)	<--->	atmTerminalId	java.lang.String
     * DB is  Nullable: false
     * DB defaultValue: null
     * </pre>
     */
    @NotBlank(message = "{" + AtmBaseTransactionBeanI18nConstant.ATM_BASE_TRANSACTION_BEAN_ATM_TERMINAL_ID_NOT_BLANK + "}", groups = {IBaseValidGroup.Add.class, IBaseValidGroup.Update.class})
    @Length(max = 64, message = "{" + AtmBaseTransactionBeanI18nConstant.ATM_BASE_TRANSACTION_BEAN_ATM_TERMINAL_ID_LENGTH + "}", groups = {IBaseValidGroup.Add.class, IBaseValidGroup.Update.class})
    @Column(name = "transaction_atm_terminal_id", length = 64, nullable = false)
    private String atmTerminalId;

    /**
     * <pre>
     * DB remark: ATM终端，设备类型
     * DB column: transaction_atm_terminal_type	VARCHAR(20)	<--->	atmTerminalType	java.lang.String
     * DB is  Nullable: false
     * DB defaultValue: null
     * </pre>
     */
    @NotBlank(message = "{" + AtmBaseTransactionBeanI18nConstant.ATM_BASE_TRANSACTION_BEAN_ATM_TERMINAL_TYPE_NOT_BLANK + "}", groups = {IBaseValidGroup.Add.class, IBaseValidGroup.Update.class})
    @Length(max = 20, message = "{" + AtmBaseTransactionBeanI18nConstant.ATM_BASE_TRANSACTION_BEAN_ATM_TERMINAL_TYPE_LENGTH + "}", groups = {IBaseValidGroup.Add.class, IBaseValidGroup.Update.class})
    @Column(name = "transaction_atm_terminal_type", length = 20, nullable = false)
    private String atmTerminalType;

    /**
     * <pre>
     * DB remark: ATM，交易记录，原始ID
     * DB column: transaction_original_id	VARCHAR(20)	<--->	originalId	java.lang.String
     * DB is  Nullable: false
     * DB defaultValue: null
     * </pre>
     */
    @NotBlank(message = "{" + AtmBaseTransactionBeanI18nConstant.ATM_BASE_TRANSACTION_BEAN_ORIGINAL_ID_NOT_BLANK + "}", groups = {IBaseValidGroup.Add.class, IBaseValidGroup.Update.class})
    @Length(max = 20, message = "{" + AtmBaseTransactionBeanI18nConstant.ATM_BASE_TRANSACTION_BEAN_ORIGINAL_ID_LENGTH + "}", groups = {IBaseValidGroup.Add.class, IBaseValidGroup.Update.class})
    @Column(name = "transaction_original_id", length = 20, nullable = false)
    private String originalId;

    /**
     * <pre>
     * DB remark: 操作人用户名
     * DB column: transaction_operator_name	VARCHAR(20)	<--->	operatorName	java.lang.String
     * DB is  Nullable: false
     * DB defaultValue: null
     * </pre>
     */
    @NotBlank(message = "{" + AtmBaseTransactionBeanI18nConstant.ATM_BASE_TRANSACTION_BEAN_OPERATOR_NAME_NOT_BLANK + "}", groups = {IBaseValidGroup.Add.class, IBaseValidGroup.Update.class})
    @Length(max = 20, message = "{" + AtmBaseTransactionBeanI18nConstant.ATM_BASE_TRANSACTION_BEAN_OPERATOR_NAME_LENGTH + "}", groups = {IBaseValidGroup.Add.class, IBaseValidGroup.Update.class})
    @Column(name = "transaction_operator_name", length = 20, nullable = false)
    private String operatorName;

    /**
     * <pre>
     * DB remark: 操作类型
     * DB column: transaction_operate_type	VARCHAR(25)	<--->	operateType	java.lang.String
     * DB is  Nullable: false
     * DB defaultValue: null
     * </pre>
     */
    @NotBlank(message = "{" + AtmBaseTransactionBeanI18nConstant.ATM_BASE_TRANSACTION_BEAN_OPERATE_TYPE_NOT_BLANK + "}", groups = {IBaseValidGroup.Add.class, IBaseValidGroup.Update.class})
    @Length(max = 25, message = "{" + AtmBaseTransactionBeanI18nConstant.ATM_BASE_TRANSACTION_BEAN_OPERATE_TYPE_LENGTH + "}", groups = {IBaseValidGroup.Add.class, IBaseValidGroup.Update.class})
    @Column(name = "transaction_operate_type", length = 25, nullable = false)
    private String operateType;

    /**
     * <pre>
     * DB remark: 操作类型,数据
     * DB column: transaction_operate_value	VARCHAR(80)	<--->	operateValue	java.lang.String
     * DB is  Nullable: true
     * DB defaultValue: null
     * </pre>
     */
    @Length(max = 80, message = "{" + AtmBaseTransactionBeanI18nConstant.ATM_BASE_TRANSACTION_BEAN_OPERATE_VALUE_LENGTH + "}", groups = {IBaseValidGroup.Add.class, IBaseValidGroup.Update.class})
    @Column(name = "transaction_operate_value", length = 80, nullable = true)
    private String operateValue;

    /**
     * <pre>
     * DB remark: 操作结果[成功或失败]
     * DB column: transaction_operate_result	VARCHAR(20)	<--->	operateResult	java.lang.String
     * DB is  Nullable: true
     * DB defaultValue: null
     * </pre>
     */
    @Length(max = 20, message = "{" + AtmBaseTransactionBeanI18nConstant.ATM_BASE_TRANSACTION_BEAN_OPERATE_RESULT_LENGTH + "}", groups = {IBaseValidGroup.Add.class, IBaseValidGroup.Update.class})
    @Column(name = "transaction_operate_result", length = 20, nullable = true)
    private String operateResult;

    /**
     * <pre>
     * DB remark: 备注,留着扩展
     * DB column: transaction_operate_comment	VARCHAR(500)	<--->	operateComment	java.lang.String
     * DB is  Nullable: true
     * DB defaultValue: null
     * </pre>
     */
    @Length(max = 500, message = "{" + AtmBaseTransactionBeanI18nConstant.ATM_BASE_TRANSACTION_BEAN_OPERATE_COMMENT_LENGTH + "}", groups = {IBaseValidGroup.Add.class, IBaseValidGroup.Update.class})
    @Column(name = "transaction_operate_comment", length = 500, nullable = true)
    private String operateComment;

    /**
     * <pre>
     * DB remark: 操作发生的时间
     * DB column: transaction_operate_timestamp	TIMESTAMP(19)	<--->	operateTimestamp	java.util.Date
     * DB is  Nullable: false
     * DB defaultValue: CURRENT_TIMESTAMP
     * </pre>
     */
    @ValidDateTimeFormat(pattern = DateUtil.DATE_PATTERN_YYYY_MM_DD_HH_MM_SS, message = "{" + AtmBaseTransactionBeanI18nConstant.ATM_BASE_TRANSACTION_BEAN_OPERATE_TIMESTAMP_DATE_TIME_FORMAT + "}", groups = {IBaseValidGroup.Add.class, IBaseValidGroup.Update.class})
    @DateTimeFormat(pattern = DateUtil.DATE_PATTERN_YYYY_MM_DD_HH_MM_SS)
    @NotNull(message = "{" + AtmBaseTransactionBeanI18nConstant.ATM_BASE_TRANSACTION_BEAN_OPERATE_TIMESTAMP_NOT_NULL + "}", groups = {IBaseValidGroup.Add.class, IBaseValidGroup.Update.class})
    @Column(name = "transaction_operate_timestamp", length = 19, nullable = false)
    private Date operateTimestamp;

    /**
     * <pre>
     * DB remark: 创建时间
     * DB column: transaction_create_timestamp	TIMESTAMP(19)	<--->	createTimestamp	java.util.Date
     * DB is  Nullable: false
     * DB defaultValue: CURRENT_TIMESTAMP
     * </pre>
     */
    @ValidDateTimeFormat(pattern = DateUtil.DATE_PATTERN_YYYY_MM_DD_HH_MM_SS, message = "{" + AtmBaseTransactionBeanI18nConstant.ATM_BASE_TRANSACTION_BEAN_CREATE_TIMESTAMP_DATE_TIME_FORMAT + "}", groups = {IBaseValidGroup.Add.class, IBaseValidGroup.Update.class})
    @DateTimeFormat(pattern = DateUtil.DATE_PATTERN_YYYY_MM_DD_HH_MM_SS)
    @NotNull(message = "{" + AtmBaseTransactionBeanI18nConstant.ATM_BASE_TRANSACTION_BEAN_CREATE_TIMESTAMP_NOT_NULL + "}", groups = {IBaseValidGroup.Add.class, IBaseValidGroup.Update.class})
    @Column(name = "transaction_create_timestamp", length = 19, nullable = false)
    private Date createTimestamp;

    /**
     * <pre>
     * DB remark: 创建人
     * DB column: transaction_create_by	VARCHAR(20)	<--->	createBy	java.lang.String
     * DB is  Nullable: false
     * DB defaultValue: null
     * </pre>
     */
    @NotBlank(message = "{" + AtmBaseTransactionBeanI18nConstant.ATM_BASE_TRANSACTION_BEAN_CREATE_BY_NOT_BLANK + "}", groups = {IBaseValidGroup.Add.class, IBaseValidGroup.Update.class})
    @Length(max = 20, message = "{" + AtmBaseTransactionBeanI18nConstant.ATM_BASE_TRANSACTION_BEAN_CREATE_BY_LENGTH + "}", groups = {IBaseValidGroup.Add.class, IBaseValidGroup.Update.class})
    @Column(name = "transaction_create_by", length = 20, nullable = false)
    private String createBy;

    /**
     * <pre>
     * DB remark: 逻辑删除标志【N[正常]，Y[删除]】
     * DB column: transaction_delete_flag	CHAR(1)	<--->	deleteFlag	java.lang.String
     * DB is  Nullable: false
     * DB defaultValue: N
     * </pre>
     */
    @NotBlank(message = "{" + AtmBaseTransactionBeanI18nConstant.ATM_BASE_TRANSACTION_BEAN_DELETE_FLAG_NOT_BLANK + "}", groups = {IBaseValidGroup.Add.class, IBaseValidGroup.Update.class})
    @Length(max = 1, message = "{" + AtmBaseTransactionBeanI18nConstant.ATM_BASE_TRANSACTION_BEAN_DELETE_FLAG_LENGTH + "}", groups = {IBaseValidGroup.Add.class, IBaseValidGroup.Update.class})
    @Column(name = "transaction_delete_flag", length = 1, nullable = false)
    private String deleteFlag;

    private static final long serialVersionUID = 1L;

    /**
     * 获取 数据库主键ID
     *
     * @return transaction_id - 数据库主键ID
     */
    public Long getId() {
        return id;
    }

    /**
     * 设置 数据库主键ID
     *
     * @param id - 数据库主键ID
     */
    public AtmBaseTransactionBean setId(Long id) {
        this.id = id;
        return this;
    }

    /**
     * 获取 ATM终端，唯一标识
     *
     * @return transaction_atm_terminal_id - ATM终端，唯一标识
     */
    public String getAtmTerminalId() {
        return atmTerminalId;
    }

    /**
     * 设置 ATM终端，唯一标识
     *
     * @param atmTerminalId - ATM终端，唯一标识
     */
    public AtmBaseTransactionBean setAtmTerminalId(String atmTerminalId) {
        this.atmTerminalId = atmTerminalId == null ? null : atmTerminalId.trim();
        return this;
    }

    /**
     * 获取 ATM终端，设备类型
     *
     * @return transaction_atm_terminal_type - ATM终端，设备类型
     */
    public String getAtmTerminalType() {
        return atmTerminalType;
    }

    /**
     * 设置 ATM终端，设备类型
     *
     * @param atmTerminalType - ATM终端，设备类型
     */
    public AtmBaseTransactionBean setAtmTerminalType(String atmTerminalType) {
        this.atmTerminalType = atmTerminalType == null ? null : atmTerminalType.trim();
        return this;
    }

    /**
     * 获取 ATM，交易记录，原始ID
     *
     * @return transaction_original_id - ATM，交易记录，原始ID
     */
    public String getOriginalId() {
        return originalId;
    }

    /**
     * 设置 ATM，交易记录，原始ID
     *
     * @param originalId - ATM，交易记录，原始ID
     */
    public AtmBaseTransactionBean setOriginalId(String originalId) {
        this.originalId = originalId == null ? null : originalId.trim();
        return this;
    }

    /**
     * 获取 操作人用户名
     *
     * @return transaction_operator_name - 操作人用户名
     */
    public String getOperatorName() {
        return operatorName;
    }

    /**
     * 设置 操作人用户名
     *
     * @param operatorName - 操作人用户名
     */
    public AtmBaseTransactionBean setOperatorName(String operatorName) {
        this.operatorName = operatorName == null ? null : operatorName.trim();
        return this;
    }

    /**
     * 获取 操作类型
     *
     * @return transaction_operate_type - 操作类型
     */
    public String getOperateType() {
        return operateType;
    }

    /**
     * 设置 操作类型
     *
     * @param operateType - 操作类型
     */
    public AtmBaseTransactionBean setOperateType(String operateType) {
        this.operateType = operateType == null ? null : operateType.trim();
        return this;
    }

    /**
     * 获取 操作类型,数据
     *
     * @return transaction_operate_value - 操作类型,数据
     */
    public String getOperateValue() {
        return operateValue;
    }

    /**
     * 设置 操作类型,数据
     *
     * @param operateValue - 操作类型,数据
     */
    public AtmBaseTransactionBean setOperateValue(String operateValue) {
        this.operateValue = operateValue == null ? null : operateValue.trim();
        return this;
    }

    /**
     * 获取 操作结果[成功或失败]
     *
     * @return transaction_operate_result - 操作结果[成功或失败]
     */
    public String getOperateResult() {
        return operateResult;
    }

    /**
     * 设置 操作结果[成功或失败]
     *
     * @param operateResult - 操作结果[成功或失败]
     */
    public AtmBaseTransactionBean setOperateResult(String operateResult) {
        this.operateResult = operateResult == null ? null : operateResult.trim();
        return this;
    }

    /**
     * 获取 备注,留着扩展
     *
     * @return transaction_operate_comment - 备注,留着扩展
     */
    public String getOperateComment() {
        return operateComment;
    }

    /**
     * 设置 备注,留着扩展
     *
     * @param operateComment - 备注,留着扩展
     */
    public AtmBaseTransactionBean setOperateComment(String operateComment) {
        this.operateComment = operateComment == null ? null : operateComment.trim();
        return this;
    }

    /**
     * 获取 操作发生的时间
     *
     * @return transaction_operate_timestamp - 操作发生的时间
     */
    public Date getOperateTimestamp() {
        return operateTimestamp;
    }

    /**
     * 设置 操作发生的时间
     *
     * @param operateTimestamp - 操作发生的时间
     */
    public AtmBaseTransactionBean setOperateTimestamp(Date operateTimestamp) {
        this.operateTimestamp = operateTimestamp;
        return this;
    }

    /**
     * 获取 创建时间
     *
     * @return transaction_create_timestamp - 创建时间
     */
    public Date getCreateTimestamp() {
        return createTimestamp;
    }

    /**
     * 设置 创建时间
     *
     * @param createTimestamp - 创建时间
     */
    public AtmBaseTransactionBean setCreateTimestamp(Date createTimestamp) {
        this.createTimestamp = createTimestamp;
        return this;
    }

    /**
     * 获取 创建人
     *
     * @return transaction_create_by - 创建人
     */
    public String getCreateBy() {
        return createBy;
    }

    /**
     * 设置 创建人
     *
     * @param createBy - 创建人
     */
    public AtmBaseTransactionBean setCreateBy(String createBy) {
        this.createBy = createBy == null ? null : createBy.trim();
        return this;
    }

    /**
     * 获取 逻辑删除标志【N[正常]，Y[删除]】
     *
     * @return transaction_delete_flag - 逻辑删除标志【N[正常]，Y[删除]】
     */
    public String getDeleteFlag() {
        return deleteFlag;
    }

    /**
     * 设置 逻辑删除标志【N[正常]，Y[删除]】
     *
     * @param deleteFlag - 逻辑删除标志【N[正常]，Y[删除]】
     */
    public AtmBaseTransactionBean setDeleteFlag(String deleteFlag) {
        this.deleteFlag = deleteFlag == null ? null : deleteFlag.trim();
        return this;
    }
}