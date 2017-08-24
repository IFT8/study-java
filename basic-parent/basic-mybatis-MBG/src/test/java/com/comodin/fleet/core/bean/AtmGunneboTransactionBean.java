package com.comodin.fleet.core.bean;

import com.comodin.basic.util.date.DateUtil;
import com.comodin.basic.validation.IBaseValidGroup;
import com.comodin.basic.validation.constraints.*;
import com.comodin.fleet.constant.i18n.AtmGunneboTransactionBeanI18nConstant;
import java.io.Serializable;
import java.util.Date;
import javax.persistence.*;
import javax.validation.constraints.*;
import org.hibernate.validator.constraints.*;
import org.springframework.format.annotation.DateTimeFormat;

@SuppressWarnings({"unused", "UnusedReturnValue", "SameParameterValue", "DefaultAnnotationParam"})
@Entity
@Table(name = "t_atm_gunnebo_transaction")
public class AtmGunneboTransactionBean implements Serializable {
    /**
     * <pre>
     * DB remark: 数据库主键ID
     * DB column: transaction_id	BIGINT(20)	<--->	id	java.lang.Long
     * DB is  Nullable: false
     * DB defaultValue: null
     * </pre>
     */
    @NotNull(message = "{" + AtmGunneboTransactionBeanI18nConstant.ATM_GUNNEBO_TRANSACTION_BEAN_ID_NOT_NULL + "}", groups = {IBaseValidGroup.Update.class})
    @ValidLength(max = 20, message = "{" + AtmGunneboTransactionBeanI18nConstant.ATM_GUNNEBO_TRANSACTION_BEAN_ID_LENGTH + "}", groups = {IBaseValidGroup.Update.class})
    @Column(name = "transaction_id", length = 20, nullable = false)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    private Long id;

    /**
     * <pre>
     * DB remark: 记录，【Integer idtransaccion;//流水ID】
     * DB column: transaction_original_id	VARCHAR(20)	<--->	originalId	java.lang.String
     * DB is  Nullable: false
     * DB defaultValue: null
     * </pre>
     */
    @NotBlank(message = "{" + AtmGunneboTransactionBeanI18nConstant.ATM_GUNNEBO_TRANSACTION_BEAN_ORIGINAL_ID_NOT_BLANK + "}", groups = {IBaseValidGroup.Add.class, IBaseValidGroup.Update.class})
    @Length(max = 20, message = "{" + AtmGunneboTransactionBeanI18nConstant.ATM_GUNNEBO_TRANSACTION_BEAN_ORIGINAL_ID_LENGTH + "}", groups = {IBaseValidGroup.Add.class, IBaseValidGroup.Update.class})
    @Column(name = "transaction_original_id", length = 20, nullable = false)
    private String originalId;

    /**
     * <pre>
     * DB remark: cit客户公司内部ID【Integer cliente;//客户ID】
     * DB column: transaction_client_internal_id	VARCHAR(15)	<--->	clientInternalId	java.lang.String
     * DB is  Nullable: true
     * DB defaultValue: null
     * </pre>
     */
    @Length(max = 15, message = "{" + AtmGunneboTransactionBeanI18nConstant.ATM_GUNNEBO_TRANSACTION_BEAN_CLIENT_INTERNAL_ID_LENGTH + "}", groups = {IBaseValidGroup.Add.class, IBaseValidGroup.Update.class})
    @Column(name = "transaction_client_internal_id", length = 15, nullable = true)
    private String clientInternalId;

    /**
     * <pre>
     * DB remark: cit客户网点内部ID【Integer sucursal;//网点ID】
     * DB column: transaction_client_branch_internal_id	VARCHAR(15)	<--->	clientBranchInternalId	java.lang.String
     * DB is  Nullable: true
     * DB defaultValue: null
     * </pre>
     */
    @Length(max = 15, message = "{" + AtmGunneboTransactionBeanI18nConstant.ATM_GUNNEBO_TRANSACTION_BEAN_CLIENT_BRANCH_INTERNAL_ID_LENGTH + "}", groups = {IBaseValidGroup.Add.class, IBaseValidGroup.Update.class})
    @Column(name = "transaction_client_branch_internal_id", length = 15, nullable = true)
    private String clientBranchInternalId;

    /**
     * <pre>
     * DB remark: 【Integer operacion;//操作类型】
     * DB column: transaction_operation_type	VARCHAR(15)	<--->	operationType	java.lang.String
     * DB is  Nullable: true
     * DB defaultValue: null
     * </pre>
     */
    @Length(max = 15, message = "{" + AtmGunneboTransactionBeanI18nConstant.ATM_GUNNEBO_TRANSACTION_BEAN_OPERATION_TYPE_LENGTH + "}", groups = {IBaseValidGroup.Add.class, IBaseValidGroup.Update.class})
    @Column(name = "transaction_operation_type", length = 15, nullable = true)
    private String operationType;

    /**
     * <pre>
     * DB remark: 操作发生的时间
     * DB column: transaction_operate_timestamp	TIMESTAMP(19)	<--->	operateTimestamp	java.util.Date
     * DB is  Nullable: false
     * DB defaultValue: CURRENT_TIMESTAMP
     * </pre>
     */
    @ValidDateTimeFormat(pattern = DateUtil.DATE_PATTERN_YYYY_MM_DD_HH_MM_SS, message = "{" + AtmGunneboTransactionBeanI18nConstant.ATM_GUNNEBO_TRANSACTION_BEAN_OPERATE_TIMESTAMP_DATE_TIME_FORMAT + "}", groups = {IBaseValidGroup.Add.class, IBaseValidGroup.Update.class})
    @DateTimeFormat(pattern = DateUtil.DATE_PATTERN_YYYY_MM_DD_HH_MM_SS)
    @NotNull(message = "{" + AtmGunneboTransactionBeanI18nConstant.ATM_GUNNEBO_TRANSACTION_BEAN_OPERATE_TIMESTAMP_NOT_NULL + "}", groups = {IBaseValidGroup.Add.class, IBaseValidGroup.Update.class})
    @Column(name = "transaction_operate_timestamp", length = 19, nullable = false)
    private Date operateTimestamp;

    /**
     * <pre>
     * DB remark: 存款号ID【String dispositivo;//存款号ID】
     * DB column: transaction_deposit_id	VARCHAR(15)	<--->	depositId	java.lang.String
     * DB is  Nullable: true
     * DB defaultValue: null
     * </pre>
     */
    @Length(max = 15, message = "{" + AtmGunneboTransactionBeanI18nConstant.ATM_GUNNEBO_TRANSACTION_BEAN_DEPOSIT_ID_LENGTH + "}", groups = {IBaseValidGroup.Add.class, IBaseValidGroup.Update.class})
    @Column(name = "transaction_deposit_id", length = 15, nullable = true)
    private String depositId;

    /**
     * <pre>
     * DB remark: 存款用户账号【String usuario;//存款用户账号】
     * DB column: transaction_deposit_user_account	VARCHAR(15)	<--->	depositUserAccount	java.lang.String
     * DB is  Nullable: true
     * DB defaultValue: null
     * </pre>
     */
    @Length(max = 15, message = "{" + AtmGunneboTransactionBeanI18nConstant.ATM_GUNNEBO_TRANSACTION_BEAN_DEPOSIT_USER_ACCOUNT_LENGTH + "}", groups = {IBaseValidGroup.Add.class, IBaseValidGroup.Update.class})
    @Column(name = "transaction_deposit_user_account", length = 15, nullable = true)
    private String depositUserAccount;

    /**
     * <pre>
     * DB remark: 存款时间【Date fechaHoraDispositivo;//存款时间】
     * DB column: transaction_deposit_date_time	TIMESTAMP(19)	<--->	depositDateTime	java.util.Date
     * DB is  Nullable: true
     * DB defaultValue: null
     * </pre>
     */
    @ValidDateTimeFormat(pattern = DateUtil.DATE_PATTERN_YYYY_MM_DD_HH_MM_SS, message = "{" + AtmGunneboTransactionBeanI18nConstant.ATM_GUNNEBO_TRANSACTION_BEAN_DEPOSIT_DATE_TIME_DATE_TIME_FORMAT + "}", groups = {IBaseValidGroup.Add.class, IBaseValidGroup.Update.class})
    @DateTimeFormat(pattern = DateUtil.DATE_PATTERN_YYYY_MM_DD_HH_MM_SS)
    @Column(name = "transaction_deposit_date_time", length = 19, nullable = true)
    private Date depositDateTime;

    /**
     * <pre>
     * DB remark: 【Integer codigoRetiro;//取款ID】
     * DB column: transaction_withdrawals_id	VARCHAR(15)	<--->	withdrawalsId	java.lang.String
     * DB is  Nullable: true
     * DB defaultValue: null
     * </pre>
     */
    @Length(max = 15, message = "{" + AtmGunneboTransactionBeanI18nConstant.ATM_GUNNEBO_TRANSACTION_BEAN_WITHDRAWALS_ID_LENGTH + "}", groups = {IBaseValidGroup.Add.class, IBaseValidGroup.Update.class})
    @Column(name = "transaction_withdrawals_id", length = 15, nullable = true)
    private String withdrawalsId;

    /**
     * <pre>
     * DB remark: 【String estatus;//状态】
     * DB column: transaction_status	VARCHAR(15)	<--->	status	java.lang.String
     * DB is  Nullable: true
     * DB defaultValue: null
     * </pre>
     */
    @Length(max = 15, message = "{" + AtmGunneboTransactionBeanI18nConstant.ATM_GUNNEBO_TRANSACTION_BEAN_STATUS_LENGTH + "}", groups = {IBaseValidGroup.Add.class, IBaseValidGroup.Update.class})
    @Column(name = "transaction_status", length = 15, nullable = true)
    private String status;

    /**
     * <pre>
     * DB remark: 【String estatusmaquina;//设备状态】
     * DB column: transaction_device_status	VARCHAR(15)	<--->	deviceStatus	java.lang.String
     * DB is  Nullable: true
     * DB defaultValue: null
     * </pre>
     */
    @Length(max = 15, message = "{" + AtmGunneboTransactionBeanI18nConstant.ATM_GUNNEBO_TRANSACTION_BEAN_DEVICE_STATUS_LENGTH + "}", groups = {IBaseValidGroup.Add.class, IBaseValidGroup.Update.class})
    @Column(name = "transaction_device_status", length = 15, nullable = true)
    private String deviceStatus;

    /**
     * <pre>
     * DB remark: 【Integer estatusTransaccion;//交易状态】
     * DB column: transaction_transaction_status	VARCHAR(15)	<--->	transactionStatus	java.lang.String
     * DB is  Nullable: true
     * DB defaultValue: null
     * </pre>
     */
    @Length(max = 15, message = "{" + AtmGunneboTransactionBeanI18nConstant.ATM_GUNNEBO_TRANSACTION_BEAN_TRANSACTION_STATUS_LENGTH + "}", groups = {IBaseValidGroup.Add.class, IBaseValidGroup.Update.class})
    @Column(name = "transaction_transaction_status", length = 15, nullable = true)
    private String transactionStatus;

    /**
     * <pre>
     * DB remark: 【String descripcion;//描述】
     * DB column: transaction_description	VARCHAR(15)	<--->	description	java.lang.String
     * DB is  Nullable: true
     * DB defaultValue: null
     * </pre>
     */
    @Length(max = 15, message = "{" + AtmGunneboTransactionBeanI18nConstant.ATM_GUNNEBO_TRANSACTION_BEAN_DESCRIPTION_LENGTH + "}", groups = {IBaseValidGroup.Add.class, IBaseValidGroup.Update.class})
    @Column(name = "transaction_description", length = 15, nullable = true)
    private String description;

    /**
     * <pre>
     * DB remark: 【String codHex;////错误代码】
     * DB column: transaction_cod_error	VARCHAR(15)	<--->	codError	java.lang.String
     * DB is  Nullable: true
     * DB defaultValue: null
     * </pre>
     */
    @Length(max = 15, message = "{" + AtmGunneboTransactionBeanI18nConstant.ATM_GUNNEBO_TRANSACTION_BEAN_COD_ERROR_LENGTH + "}", groups = {IBaseValidGroup.Add.class, IBaseValidGroup.Update.class})
    @Column(name = "transaction_cod_error", length = 15, nullable = true)
    private String codError;

    /**
     * <pre>
     * DB remark: 【cantidadBilletesValidados;//支票金额】
     * DB column: transaction_cheque_total_amount	VARCHAR(15)	<--->	chequeTotalAmount	java.lang.String
     * DB is  Nullable: true
     * DB defaultValue: null
     * </pre>
     */
    @Length(max = 15, message = "{" + AtmGunneboTransactionBeanI18nConstant.ATM_GUNNEBO_TRANSACTION_BEAN_CHEQUE_TOTAL_AMOUNT_LENGTH + "}", groups = {IBaseValidGroup.Add.class, IBaseValidGroup.Update.class})
    @Column(name = "transaction_cheque_total_amount", length = 15, nullable = true)
    private String chequeTotalAmount;

    /**
     * <pre>
     * DB remark: 【cantidadBilletesManual;//支票数量】
     * DB column: transaction_cheque_number	VARCHAR(15)	<--->	chequeNumber	java.lang.String
     * DB is  Nullable: true
     * DB defaultValue: null
     * </pre>
     */
    @Length(max = 15, message = "{" + AtmGunneboTransactionBeanI18nConstant.ATM_GUNNEBO_TRANSACTION_BEAN_CHEQUE_NUMBER_LENGTH + "}", groups = {IBaseValidGroup.Add.class, IBaseValidGroup.Update.class})
    @Column(name = "transaction_cheque_number", length = 15, nullable = true)
    private String chequeNumber;

    /**
     * <pre>
     * DB remark: 【Integer transaccionEnvase;//信封数量】
     * DB column: transaction_envelopes_number	VARCHAR(15)	<--->	envelopesNumber	java.lang.String
     * DB is  Nullable: true
     * DB defaultValue: null
     * </pre>
     */
    @Length(max = 15, message = "{" + AtmGunneboTransactionBeanI18nConstant.ATM_GUNNEBO_TRANSACTION_BEAN_ENVELOPES_NUMBER_LENGTH + "}", groups = {IBaseValidGroup.Add.class, IBaseValidGroup.Update.class})
    @Column(name = "transaction_envelopes_number", length = 15, nullable = true)
    private String envelopesNumber;

    /**
     * <pre>
     * DB remark: 【String codigoenvase;//信封代码】
     * DB column: transaction_envelopes_code	VARCHAR(15)	<--->	envelopesCode	java.lang.String
     * DB is  Nullable: true
     * DB defaultValue: null
     * </pre>
     */
    @Length(max = 15, message = "{" + AtmGunneboTransactionBeanI18nConstant.ATM_GUNNEBO_TRANSACTION_BEAN_ENVELOPES_CODE_LENGTH + "}", groups = {IBaseValidGroup.Add.class, IBaseValidGroup.Update.class})
    @Column(name = "transaction_envelopes_code", length = 15, nullable = true)
    private String envelopesCode;

    /**
     * <pre>
     * DB remark: 【String divisa;//货币类型】
     * DB column: transaction_currency_type	VARCHAR(15)	<--->	currencyType	java.lang.String
     * DB is  Nullable: true
     * DB defaultValue: null
     * </pre>
     */
    @Length(max = 15, message = "{" + AtmGunneboTransactionBeanI18nConstant.ATM_GUNNEBO_TRANSACTION_BEAN_CURRENCY_TYPE_LENGTH + "}", groups = {IBaseValidGroup.Add.class, IBaseValidGroup.Update.class})
    @Column(name = "transaction_currency_type", length = 15, nullable = true)
    private String currencyType;

    /**
     * <pre>
     * DB remark: 【String cuentaBanco;//当前货币张数】
     * DB column: transaction_currency_current_number	VARCHAR(15)	<--->	currencyCurrentNumber	java.lang.String
     * DB is  Nullable: true
     * DB defaultValue: null
     * </pre>
     */
    @Length(max = 15, message = "{" + AtmGunneboTransactionBeanI18nConstant.ATM_GUNNEBO_TRANSACTION_BEAN_CURRENCY_CURRENT_NUMBER_LENGTH + "}", groups = {IBaseValidGroup.Add.class, IBaseValidGroup.Update.class})
    @Column(name = "transaction_currency_current_number", length = 15, nullable = true)
    private String currencyCurrentNumber;

    /**
     * <pre>
     * DB remark: 【Integer totalValidado;//总金额】
     * DB column: transaction_currency_total_amount	VARCHAR(15)	<--->	currencyTotalAmount	java.lang.String
     * DB is  Nullable: true
     * DB defaultValue: null
     * </pre>
     */
    @Length(max = 15, message = "{" + AtmGunneboTransactionBeanI18nConstant.ATM_GUNNEBO_TRANSACTION_BEAN_CURRENCY_TOTAL_AMOUNT_LENGTH + "}", groups = {IBaseValidGroup.Add.class, IBaseValidGroup.Update.class})
    @Column(name = "transaction_currency_total_amount", length = 15, nullable = true)
    private String currencyTotalAmount;

    /**
     * <pre>
     * DB remark: 【Integer denominacion1;//硬币,*，面额】
     * DB column: transaction_hard_denomination1	VARCHAR(15)	<--->	hardDenomination1	java.lang.String
     * DB is  Nullable: true
     * DB defaultValue: null
     * </pre>
     */
    @Length(max = 15, message = "{" + AtmGunneboTransactionBeanI18nConstant.ATM_GUNNEBO_TRANSACTION_BEAN_HARD_DENOMINATION1_LENGTH + "}", groups = {IBaseValidGroup.Add.class, IBaseValidGroup.Update.class})
    @Column(name = "transaction_hard_denomination1", length = 15, nullable = true)
    private String hardDenomination1;

    /**
     * <pre>
     * DB remark: 【Integer denominacion2;//硬币,*，面额】
     * DB column: transaction_hard_denomination2	VARCHAR(15)	<--->	hardDenomination2	java.lang.String
     * DB is  Nullable: true
     * DB defaultValue: null
     * </pre>
     */
    @Length(max = 15, message = "{" + AtmGunneboTransactionBeanI18nConstant.ATM_GUNNEBO_TRANSACTION_BEAN_HARD_DENOMINATION2_LENGTH + "}", groups = {IBaseValidGroup.Add.class, IBaseValidGroup.Update.class})
    @Column(name = "transaction_hard_denomination2", length = 15, nullable = true)
    private String hardDenomination2;

    /**
     * <pre>
     * DB remark: 【Integer denominacion3;//硬币,*，面额】
     * DB column: transaction_hard_denomination3	VARCHAR(15)	<--->	hardDenomination3	java.lang.String
     * DB is  Nullable: true
     * DB defaultValue: null
     * </pre>
     */
    @Length(max = 15, message = "{" + AtmGunneboTransactionBeanI18nConstant.ATM_GUNNEBO_TRANSACTION_BEAN_HARD_DENOMINATION3_LENGTH + "}", groups = {IBaseValidGroup.Add.class, IBaseValidGroup.Update.class})
    @Column(name = "transaction_hard_denomination3", length = 15, nullable = true)
    private String hardDenomination3;

    /**
     * <pre>
     * DB remark: 【Integer denominacion4;//硬币,*，面额】
     * DB column: transaction_hard_denomination4	VARCHAR(15)	<--->	hardDenomination4	java.lang.String
     * DB is  Nullable: true
     * DB defaultValue: null
     * </pre>
     */
    @Length(max = 15, message = "{" + AtmGunneboTransactionBeanI18nConstant.ATM_GUNNEBO_TRANSACTION_BEAN_HARD_DENOMINATION4_LENGTH + "}", groups = {IBaseValidGroup.Add.class, IBaseValidGroup.Update.class})
    @Column(name = "transaction_hard_denomination4", length = 15, nullable = true)
    private String hardDenomination4;

    /**
     * <pre>
     * DB remark: 【Integer denominacion5;//硬币,*，面额】
     * DB column: transaction_hard_denomination5	VARCHAR(15)	<--->	hardDenomination5	java.lang.String
     * DB is  Nullable: true
     * DB defaultValue: null
     * </pre>
     */
    @Length(max = 15, message = "{" + AtmGunneboTransactionBeanI18nConstant.ATM_GUNNEBO_TRANSACTION_BEAN_HARD_DENOMINATION5_LENGTH + "}", groups = {IBaseValidGroup.Add.class, IBaseValidGroup.Update.class})
    @Column(name = "transaction_hard_denomination5", length = 15, nullable = true)
    private String hardDenomination5;

    /**
     * <pre>
     * DB remark: 【Integer denominacion6;//硬币,*，面额】
     * DB column: transaction_hard_denomination6	VARCHAR(15)	<--->	hardDenomination6	java.lang.String
     * DB is  Nullable: true
     * DB defaultValue: null
     * </pre>
     */
    @Length(max = 15, message = "{" + AtmGunneboTransactionBeanI18nConstant.ATM_GUNNEBO_TRANSACTION_BEAN_HARD_DENOMINATION6_LENGTH + "}", groups = {IBaseValidGroup.Add.class, IBaseValidGroup.Update.class})
    @Column(name = "transaction_hard_denomination6", length = 15, nullable = true)
    private String hardDenomination6;

    /**
     * <pre>
     * DB remark: 【Integer denominacion7;//硬币,*，面额】
     * DB column: transaction_hard_denomination7	VARCHAR(15)	<--->	hardDenomination7	java.lang.String
     * DB is  Nullable: true
     * DB defaultValue: null
     * </pre>
     */
    @Length(max = 15, message = "{" + AtmGunneboTransactionBeanI18nConstant.ATM_GUNNEBO_TRANSACTION_BEAN_HARD_DENOMINATION7_LENGTH + "}", groups = {IBaseValidGroup.Add.class, IBaseValidGroup.Update.class})
    @Column(name = "transaction_hard_denomination7", length = 15, nullable = true)
    private String hardDenomination7;

    /**
     * <pre>
     * DB remark: 【Integer denominacion8;//硬币,*，面额】
     * DB column: transaction_hard_denomination8	VARCHAR(15)	<--->	hardDenomination8	java.lang.String
     * DB is  Nullable: true
     * DB defaultValue: null
     * </pre>
     */
    @Length(max = 15, message = "{" + AtmGunneboTransactionBeanI18nConstant.ATM_GUNNEBO_TRANSACTION_BEAN_HARD_DENOMINATION8_LENGTH + "}", groups = {IBaseValidGroup.Add.class, IBaseValidGroup.Update.class})
    @Column(name = "transaction_hard_denomination8", length = 15, nullable = true)
    private String hardDenomination8;

    /**
     * <pre>
     * DB remark: 【Integer denominacionM1;//纸币,*，面额】
     * DB column: transaction_paper_denomination1	VARCHAR(15)	<--->	paperDenomination1	java.lang.String
     * DB is  Nullable: true
     * DB defaultValue: null
     * </pre>
     */
    @Length(max = 15, message = "{" + AtmGunneboTransactionBeanI18nConstant.ATM_GUNNEBO_TRANSACTION_BEAN_PAPER_DENOMINATION1_LENGTH + "}", groups = {IBaseValidGroup.Add.class, IBaseValidGroup.Update.class})
    @Column(name = "transaction_paper_denomination1", length = 15, nullable = true)
    private String paperDenomination1;

    /**
     * <pre>
     * DB remark: 【Integer denominacionM2;//纸币,*，面额】
     * DB column: transaction_paper_denomination2	VARCHAR(15)	<--->	paperDenomination2	java.lang.String
     * DB is  Nullable: true
     * DB defaultValue: null
     * </pre>
     */
    @Length(max = 15, message = "{" + AtmGunneboTransactionBeanI18nConstant.ATM_GUNNEBO_TRANSACTION_BEAN_PAPER_DENOMINATION2_LENGTH + "}", groups = {IBaseValidGroup.Add.class, IBaseValidGroup.Update.class})
    @Column(name = "transaction_paper_denomination2", length = 15, nullable = true)
    private String paperDenomination2;

    /**
     * <pre>
     * DB remark: 【Integer denominacionM3;//纸币,*，面额】
     * DB column: transaction_paper_denomination3	VARCHAR(15)	<--->	paperDenomination3	java.lang.String
     * DB is  Nullable: true
     * DB defaultValue: null
     * </pre>
     */
    @Length(max = 15, message = "{" + AtmGunneboTransactionBeanI18nConstant.ATM_GUNNEBO_TRANSACTION_BEAN_PAPER_DENOMINATION3_LENGTH + "}", groups = {IBaseValidGroup.Add.class, IBaseValidGroup.Update.class})
    @Column(name = "transaction_paper_denomination3", length = 15, nullable = true)
    private String paperDenomination3;

    /**
     * <pre>
     * DB remark: 【Integer denominacionM4;//纸币,*，面额】
     * DB column: transaction_paper_denomination4	VARCHAR(15)	<--->	paperDenomination4	java.lang.String
     * DB is  Nullable: true
     * DB defaultValue: null
     * </pre>
     */
    @Length(max = 15, message = "{" + AtmGunneboTransactionBeanI18nConstant.ATM_GUNNEBO_TRANSACTION_BEAN_PAPER_DENOMINATION4_LENGTH + "}", groups = {IBaseValidGroup.Add.class, IBaseValidGroup.Update.class})
    @Column(name = "transaction_paper_denomination4", length = 15, nullable = true)
    private String paperDenomination4;

    /**
     * <pre>
     * DB remark: 【Integer denominacionM5;//纸币,*，面额】
     * DB column: transaction_paper_denomination5	VARCHAR(15)	<--->	paperDenomination5	java.lang.String
     * DB is  Nullable: true
     * DB defaultValue: null
     * </pre>
     */
    @Length(max = 15, message = "{" + AtmGunneboTransactionBeanI18nConstant.ATM_GUNNEBO_TRANSACTION_BEAN_PAPER_DENOMINATION5_LENGTH + "}", groups = {IBaseValidGroup.Add.class, IBaseValidGroup.Update.class})
    @Column(name = "transaction_paper_denomination5", length = 15, nullable = true)
    private String paperDenomination5;

    /**
     * <pre>
     * DB remark: 【Integer denominacionM6;//纸币,*，面额】
     * DB column: transaction_paper_denomination6	VARCHAR(15)	<--->	paperDenomination6	java.lang.String
     * DB is  Nullable: true
     * DB defaultValue: null
     * </pre>
     */
    @Length(max = 15, message = "{" + AtmGunneboTransactionBeanI18nConstant.ATM_GUNNEBO_TRANSACTION_BEAN_PAPER_DENOMINATION6_LENGTH + "}", groups = {IBaseValidGroup.Add.class, IBaseValidGroup.Update.class})
    @Column(name = "transaction_paper_denomination6", length = 15, nullable = true)
    private String paperDenomination6;

    /**
     * <pre>
     * DB remark: 【Integer denominacionM7;//纸币,*，面额】
     * DB column: transaction_paper_denomination7	VARCHAR(15)	<--->	paperDenomination7	java.lang.String
     * DB is  Nullable: true
     * DB defaultValue: null
     * </pre>
     */
    @Length(max = 15, message = "{" + AtmGunneboTransactionBeanI18nConstant.ATM_GUNNEBO_TRANSACTION_BEAN_PAPER_DENOMINATION7_LENGTH + "}", groups = {IBaseValidGroup.Add.class, IBaseValidGroup.Update.class})
    @Column(name = "transaction_paper_denomination7", length = 15, nullable = true)
    private String paperDenomination7;

    /**
     * <pre>
     * DB remark: 【String totalManual;//手工输入的金额】
     * DB column: transaction_manual_total_amount	VARCHAR(15)	<--->	manualTotalAmount	java.lang.String
     * DB is  Nullable: true
     * DB defaultValue: null
     * </pre>
     */
    @Length(max = 15, message = "{" + AtmGunneboTransactionBeanI18nConstant.ATM_GUNNEBO_TRANSACTION_BEAN_MANUAL_TOTAL_AMOUNT_LENGTH + "}", groups = {IBaseValidGroup.Add.class, IBaseValidGroup.Update.class})
    @Column(name = "transaction_manual_total_amount", length = 15, nullable = true)
    private String manualTotalAmount;

    /**
     * <pre>
     * DB remark: 【Integer denominacion1Manua1;//手工输入的面额（存信封时使用）,*，面额】
     * DB column: transaction_manual_denomination1	VARCHAR(15)	<--->	manualDenomination1	java.lang.String
     * DB is  Nullable: true
     * DB defaultValue: null
     * </pre>
     */
    @Length(max = 15, message = "{" + AtmGunneboTransactionBeanI18nConstant.ATM_GUNNEBO_TRANSACTION_BEAN_MANUAL_DENOMINATION1_LENGTH + "}", groups = {IBaseValidGroup.Add.class, IBaseValidGroup.Update.class})
    @Column(name = "transaction_manual_denomination1", length = 15, nullable = true)
    private String manualDenomination1;

    /**
     * <pre>
     * DB remark: 【Integer denominacion1Manua2;//手工输入的面额（存信封时使用）,*，面额】
     * DB column: transaction_manual_denomination2	VARCHAR(15)	<--->	manualDenomination2	java.lang.String
     * DB is  Nullable: true
     * DB defaultValue: null
     * </pre>
     */
    @Length(max = 15, message = "{" + AtmGunneboTransactionBeanI18nConstant.ATM_GUNNEBO_TRANSACTION_BEAN_MANUAL_DENOMINATION2_LENGTH + "}", groups = {IBaseValidGroup.Add.class, IBaseValidGroup.Update.class})
    @Column(name = "transaction_manual_denomination2", length = 15, nullable = true)
    private String manualDenomination2;

    /**
     * <pre>
     * DB remark: 【Integer denominacion1Manua3;//手工输入的面额（存信封时使用）,*，面额】
     * DB column: transaction_manual_denomination3	VARCHAR(15)	<--->	manualDenomination3	java.lang.String
     * DB is  Nullable: true
     * DB defaultValue: null
     * </pre>
     */
    @Length(max = 15, message = "{" + AtmGunneboTransactionBeanI18nConstant.ATM_GUNNEBO_TRANSACTION_BEAN_MANUAL_DENOMINATION3_LENGTH + "}", groups = {IBaseValidGroup.Add.class, IBaseValidGroup.Update.class})
    @Column(name = "transaction_manual_denomination3", length = 15, nullable = true)
    private String manualDenomination3;

    /**
     * <pre>
     * DB remark: 【Integer denominacion1Manua4;//手工输入的面额（存信封时使用）,*，面额】
     * DB column: transaction_manual_denomination4	VARCHAR(15)	<--->	manualDenomination4	java.lang.String
     * DB is  Nullable: true
     * DB defaultValue: null
     * </pre>
     */
    @Length(max = 15, message = "{" + AtmGunneboTransactionBeanI18nConstant.ATM_GUNNEBO_TRANSACTION_BEAN_MANUAL_DENOMINATION4_LENGTH + "}", groups = {IBaseValidGroup.Add.class, IBaseValidGroup.Update.class})
    @Column(name = "transaction_manual_denomination4", length = 15, nullable = true)
    private String manualDenomination4;

    /**
     * <pre>
     * DB remark: 【Integer denominacion1Manua5;//手工输入的面额（存信封时使用）,*，面额】
     * DB column: transaction_manual_denomination5	VARCHAR(15)	<--->	manualDenomination5	java.lang.String
     * DB is  Nullable: true
     * DB defaultValue: null
     * </pre>
     */
    @Length(max = 15, message = "{" + AtmGunneboTransactionBeanI18nConstant.ATM_GUNNEBO_TRANSACTION_BEAN_MANUAL_DENOMINATION5_LENGTH + "}", groups = {IBaseValidGroup.Add.class, IBaseValidGroup.Update.class})
    @Column(name = "transaction_manual_denomination5", length = 15, nullable = true)
    private String manualDenomination5;

    /**
     * <pre>
     * DB remark: 【Integer denominacion1Manua6;//手工输入的面额（存信封时使用）,*，面额】
     * DB column: transaction_manual_denomination6	VARCHAR(15)	<--->	manualDenomination6	java.lang.String
     * DB is  Nullable: true
     * DB defaultValue: null
     * </pre>
     */
    @Length(max = 15, message = "{" + AtmGunneboTransactionBeanI18nConstant.ATM_GUNNEBO_TRANSACTION_BEAN_MANUAL_DENOMINATION6_LENGTH + "}", groups = {IBaseValidGroup.Add.class, IBaseValidGroup.Update.class})
    @Column(name = "transaction_manual_denomination6", length = 15, nullable = true)
    private String manualDenomination6;

    /**
     * <pre>
     * DB remark: 【Integer denominacion1Manua7;//手工输入的面额（存信封时使用）,*，面额】
     * DB column: transaction_manual_denomination7	VARCHAR(15)	<--->	manualDenomination7	java.lang.String
     * DB is  Nullable: true
     * DB defaultValue: null
     * </pre>
     */
    @Length(max = 15, message = "{" + AtmGunneboTransactionBeanI18nConstant.ATM_GUNNEBO_TRANSACTION_BEAN_MANUAL_DENOMINATION7_LENGTH + "}", groups = {IBaseValidGroup.Add.class, IBaseValidGroup.Update.class})
    @Column(name = "transaction_manual_denomination7", length = 15, nullable = true)
    private String manualDenomination7;

    /**
     * <pre>
     * DB remark: 【Integer denominacion1Manua8;//手工输入的面额（存信封时使用）,*，面额】
     * DB column: transaction_manual_denomination8	VARCHAR(15)	<--->	manualDenomination8	java.lang.String
     * DB is  Nullable: true
     * DB defaultValue: null
     * </pre>
     */
    @Length(max = 15, message = "{" + AtmGunneboTransactionBeanI18nConstant.ATM_GUNNEBO_TRANSACTION_BEAN_MANUAL_DENOMINATION8_LENGTH + "}", groups = {IBaseValidGroup.Add.class, IBaseValidGroup.Update.class})
    @Column(name = "transaction_manual_denomination8", length = 15, nullable = true)
    private String manualDenomination8;

    /**
     * <pre>
     * DB remark: 【String totalDocumentosExternos;//文件数量、（其他机器使用，忽略）】
     * DB column: transaction_document_total_amount	VARCHAR(15)	<--->	documentTotalAmount	java.lang.String
     * DB is  Nullable: true
     * DB defaultValue: null
     * </pre>
     */
    @Length(max = 15, message = "{" + AtmGunneboTransactionBeanI18nConstant.ATM_GUNNEBO_TRANSACTION_BEAN_DOCUMENT_TOTAL_AMOUNT_LENGTH + "}", groups = {IBaseValidGroup.Add.class, IBaseValidGroup.Update.class})
    @Column(name = "transaction_document_total_amount", length = 15, nullable = true)
    private String documentTotalAmount;

    /**
     * <pre>
     * DB remark: 【String referencia;//（客户输入的内容有关）】
     * DB column: transaction_reference	VARCHAR(15)	<--->	reference	java.lang.String
     * DB is  Nullable: true
     * DB defaultValue: null
     * </pre>
     */
    @Length(max = 15, message = "{" + AtmGunneboTransactionBeanI18nConstant.ATM_GUNNEBO_TRANSACTION_BEAN_REFERENCE_LENGTH + "}", groups = {IBaseValidGroup.Add.class, IBaseValidGroup.Update.class})
    @Column(name = "transaction_reference", length = 15, nullable = true)
    private String reference;

    /**
     * <pre>
     * DB remark: 【String claveSobre】
     * DB column: transaction_clave_sobre	VARCHAR(15)	<--->	claveSobre	java.lang.String
     * DB is  Nullable: true
     * DB defaultValue: null
     * </pre>
     */
    @Length(max = 15, message = "{" + AtmGunneboTransactionBeanI18nConstant.ATM_GUNNEBO_TRANSACTION_BEAN_CLAVE_SOBRE_LENGTH + "}", groups = {IBaseValidGroup.Add.class, IBaseValidGroup.Update.class})
    @Column(name = "transaction_clave_sobre", length = 15, nullable = true)
    private String claveSobre;

    /**
     * <pre>
     * DB remark: 【String totalSobre】
     * DB column: transaction_total_sobre	VARCHAR(15)	<--->	totalSobre	java.lang.String
     * DB is  Nullable: true
     * DB defaultValue: null
     * </pre>
     */
    @Length(max = 15, message = "{" + AtmGunneboTransactionBeanI18nConstant.ATM_GUNNEBO_TRANSACTION_BEAN_TOTAL_SOBRE_LENGTH + "}", groups = {IBaseValidGroup.Add.class, IBaseValidGroup.Update.class})
    @Column(name = "transaction_total_sobre", length = 15, nullable = true)
    private String totalSobre;

    /**
     * <pre>
     * DB remark: 【String impreso】
     * DB column: transaction_impreso	VARCHAR(15)	<--->	impreso	java.lang.String
     * DB is  Nullable: true
     * DB defaultValue: null
     * </pre>
     */
    @Length(max = 15, message = "{" + AtmGunneboTransactionBeanI18nConstant.ATM_GUNNEBO_TRANSACTION_BEAN_IMPRESO_LENGTH + "}", groups = {IBaseValidGroup.Add.class, IBaseValidGroup.Update.class})
    @Column(name = "transaction_impreso", length = 15, nullable = true)
    private String impreso;

    /**
     * <pre>
     * DB remark: 【String balanza】
     * DB column: transaction_balanza	VARCHAR(15)	<--->	balanza	java.lang.String
     * DB is  Nullable: true
     * DB defaultValue: null
     * </pre>
     */
    @Length(max = 15, message = "{" + AtmGunneboTransactionBeanI18nConstant.ATM_GUNNEBO_TRANSACTION_BEAN_BALANZA_LENGTH + "}", groups = {IBaseValidGroup.Add.class, IBaseValidGroup.Update.class})
    @Column(name = "transaction_balanza", length = 15, nullable = true)
    private String balanza;

    /**
     * <pre>
     * DB remark: 【String fechaCont】
     * DB column: transaction_fecha_cont	VARCHAR(15)	<--->	fechaCont	java.lang.String
     * DB is  Nullable: true
     * DB defaultValue: null
     * </pre>
     */
    @Length(max = 15, message = "{" + AtmGunneboTransactionBeanI18nConstant.ATM_GUNNEBO_TRANSACTION_BEAN_FECHA_CONT_LENGTH + "}", groups = {IBaseValidGroup.Add.class, IBaseValidGroup.Update.class})
    @Column(name = "transaction_fecha_cont", length = 15, nullable = true)
    private String fechaCont;

    /**
     * <pre>
     * DB remark: 创建时间
     * DB column: transaction_create_timestamp	TIMESTAMP(19)	<--->	createTimestamp	java.util.Date
     * DB is  Nullable: false
     * DB defaultValue: CURRENT_TIMESTAMP
     * </pre>
     */
    @ValidDateTimeFormat(pattern = DateUtil.DATE_PATTERN_YYYY_MM_DD_HH_MM_SS, message = "{" + AtmGunneboTransactionBeanI18nConstant.ATM_GUNNEBO_TRANSACTION_BEAN_CREATE_TIMESTAMP_DATE_TIME_FORMAT + "}", groups = {IBaseValidGroup.Add.class, IBaseValidGroup.Update.class})
    @DateTimeFormat(pattern = DateUtil.DATE_PATTERN_YYYY_MM_DD_HH_MM_SS)
    @NotNull(message = "{" + AtmGunneboTransactionBeanI18nConstant.ATM_GUNNEBO_TRANSACTION_BEAN_CREATE_TIMESTAMP_NOT_NULL + "}", groups = {IBaseValidGroup.Add.class, IBaseValidGroup.Update.class})
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
    @NotBlank(message = "{" + AtmGunneboTransactionBeanI18nConstant.ATM_GUNNEBO_TRANSACTION_BEAN_CREATE_BY_NOT_BLANK + "}", groups = {IBaseValidGroup.Add.class, IBaseValidGroup.Update.class})
    @Length(max = 20, message = "{" + AtmGunneboTransactionBeanI18nConstant.ATM_GUNNEBO_TRANSACTION_BEAN_CREATE_BY_LENGTH + "}", groups = {IBaseValidGroup.Add.class, IBaseValidGroup.Update.class})
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
    @NotBlank(message = "{" + AtmGunneboTransactionBeanI18nConstant.ATM_GUNNEBO_TRANSACTION_BEAN_DELETE_FLAG_NOT_BLANK + "}", groups = {IBaseValidGroup.Add.class, IBaseValidGroup.Update.class})
    @Length(max = 1, message = "{" + AtmGunneboTransactionBeanI18nConstant.ATM_GUNNEBO_TRANSACTION_BEAN_DELETE_FLAG_LENGTH + "}", groups = {IBaseValidGroup.Add.class, IBaseValidGroup.Update.class})
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
    public AtmGunneboTransactionBean setId(Long id) {
        this.id = id;
        return this;
    }

    /**
     * 获取 记录，【Integer idtransaccion;//流水ID】
     *
     * @return transaction_original_id - 记录，【Integer idtransaccion;//流水ID】
     */
    public String getOriginalId() {
        return originalId;
    }

    /**
     * 设置 记录，【Integer idtransaccion;//流水ID】
     *
     * @param originalId - 记录，【Integer idtransaccion;//流水ID】
     */
    public AtmGunneboTransactionBean setOriginalId(String originalId) {
        this.originalId = originalId == null ? null : originalId.trim();
        return this;
    }

    /**
     * 获取 cit客户公司内部ID【Integer cliente;//客户ID】
     *
     * @return transaction_client_internal_id - cit客户公司内部ID【Integer cliente;//客户ID】
     */
    public String getClientInternalId() {
        return clientInternalId;
    }

    /**
     * 设置 cit客户公司内部ID【Integer cliente;//客户ID】
     *
     * @param clientInternalId - cit客户公司内部ID【Integer cliente;//客户ID】
     */
    public AtmGunneboTransactionBean setClientInternalId(String clientInternalId) {
        this.clientInternalId = clientInternalId == null ? null : clientInternalId.trim();
        return this;
    }

    /**
     * 获取 cit客户网点内部ID【Integer sucursal;//网点ID】
     *
     * @return transaction_client_branch_internal_id - cit客户网点内部ID【Integer sucursal;//网点ID】
     */
    public String getClientBranchInternalId() {
        return clientBranchInternalId;
    }

    /**
     * 设置 cit客户网点内部ID【Integer sucursal;//网点ID】
     *
     * @param clientBranchInternalId - cit客户网点内部ID【Integer sucursal;//网点ID】
     */
    public AtmGunneboTransactionBean setClientBranchInternalId(String clientBranchInternalId) {
        this.clientBranchInternalId = clientBranchInternalId == null ? null : clientBranchInternalId.trim();
        return this;
    }

    /**
     * 获取 【Integer operacion;//操作类型】
     *
     * @return transaction_operation_type - 【Integer operacion;//操作类型】
     */
    public String getOperationType() {
        return operationType;
    }

    /**
     * 设置 【Integer operacion;//操作类型】
     *
     * @param operationType - 【Integer operacion;//操作类型】
     */
    public AtmGunneboTransactionBean setOperationType(String operationType) {
        this.operationType = operationType == null ? null : operationType.trim();
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
    public AtmGunneboTransactionBean setOperateTimestamp(Date operateTimestamp) {
        this.operateTimestamp = operateTimestamp;
        return this;
    }

    /**
     * 获取 存款号ID【String dispositivo;//存款号ID】
     *
     * @return transaction_deposit_id - 存款号ID【String dispositivo;//存款号ID】
     */
    public String getDepositId() {
        return depositId;
    }

    /**
     * 设置 存款号ID【String dispositivo;//存款号ID】
     *
     * @param depositId - 存款号ID【String dispositivo;//存款号ID】
     */
    public AtmGunneboTransactionBean setDepositId(String depositId) {
        this.depositId = depositId == null ? null : depositId.trim();
        return this;
    }

    /**
     * 获取 存款用户账号【String usuario;//存款用户账号】
     *
     * @return transaction_deposit_user_account - 存款用户账号【String usuario;//存款用户账号】
     */
    public String getDepositUserAccount() {
        return depositUserAccount;
    }

    /**
     * 设置 存款用户账号【String usuario;//存款用户账号】
     *
     * @param depositUserAccount - 存款用户账号【String usuario;//存款用户账号】
     */
    public AtmGunneboTransactionBean setDepositUserAccount(String depositUserAccount) {
        this.depositUserAccount = depositUserAccount == null ? null : depositUserAccount.trim();
        return this;
    }

    /**
     * 获取 存款时间【Date fechaHoraDispositivo;//存款时间】
     *
     * @return transaction_deposit_date_time - 存款时间【Date fechaHoraDispositivo;//存款时间】
     */
    public Date getDepositDateTime() {
        return depositDateTime;
    }

    /**
     * 设置 存款时间【Date fechaHoraDispositivo;//存款时间】
     *
     * @param depositDateTime - 存款时间【Date fechaHoraDispositivo;//存款时间】
     */
    public AtmGunneboTransactionBean setDepositDateTime(Date depositDateTime) {
        this.depositDateTime = depositDateTime;
        return this;
    }

    /**
     * 获取 【Integer codigoRetiro;//取款ID】
     *
     * @return transaction_withdrawals_id - 【Integer codigoRetiro;//取款ID】
     */
    public String getWithdrawalsId() {
        return withdrawalsId;
    }

    /**
     * 设置 【Integer codigoRetiro;//取款ID】
     *
     * @param withdrawalsId - 【Integer codigoRetiro;//取款ID】
     */
    public AtmGunneboTransactionBean setWithdrawalsId(String withdrawalsId) {
        this.withdrawalsId = withdrawalsId == null ? null : withdrawalsId.trim();
        return this;
    }

    /**
     * 获取 【String estatus;//状态】
     *
     * @return transaction_status - 【String estatus;//状态】
     */
    public String getStatus() {
        return status;
    }

    /**
     * 设置 【String estatus;//状态】
     *
     * @param status - 【String estatus;//状态】
     */
    public AtmGunneboTransactionBean setStatus(String status) {
        this.status = status == null ? null : status.trim();
        return this;
    }

    /**
     * 获取 【String estatusmaquina;//设备状态】
     *
     * @return transaction_device_status - 【String estatusmaquina;//设备状态】
     */
    public String getDeviceStatus() {
        return deviceStatus;
    }

    /**
     * 设置 【String estatusmaquina;//设备状态】
     *
     * @param deviceStatus - 【String estatusmaquina;//设备状态】
     */
    public AtmGunneboTransactionBean setDeviceStatus(String deviceStatus) {
        this.deviceStatus = deviceStatus == null ? null : deviceStatus.trim();
        return this;
    }

    /**
     * 获取 【Integer estatusTransaccion;//交易状态】
     *
     * @return transaction_transaction_status - 【Integer estatusTransaccion;//交易状态】
     */
    public String getTransactionStatus() {
        return transactionStatus;
    }

    /**
     * 设置 【Integer estatusTransaccion;//交易状态】
     *
     * @param transactionStatus - 【Integer estatusTransaccion;//交易状态】
     */
    public AtmGunneboTransactionBean setTransactionStatus(String transactionStatus) {
        this.transactionStatus = transactionStatus == null ? null : transactionStatus.trim();
        return this;
    }

    /**
     * 获取 【String descripcion;//描述】
     *
     * @return transaction_description - 【String descripcion;//描述】
     */
    public String getDescription() {
        return description;
    }

    /**
     * 设置 【String descripcion;//描述】
     *
     * @param description - 【String descripcion;//描述】
     */
    public AtmGunneboTransactionBean setDescription(String description) {
        this.description = description == null ? null : description.trim();
        return this;
    }

    /**
     * 获取 【String codHex;////错误代码】
     *
     * @return transaction_cod_error - 【String codHex;////错误代码】
     */
    public String getCodError() {
        return codError;
    }

    /**
     * 设置 【String codHex;////错误代码】
     *
     * @param codError - 【String codHex;////错误代码】
     */
    public AtmGunneboTransactionBean setCodError(String codError) {
        this.codError = codError == null ? null : codError.trim();
        return this;
    }

    /**
     * 获取 【cantidadBilletesValidados;//支票金额】
     *
     * @return transaction_cheque_total_amount - 【cantidadBilletesValidados;//支票金额】
     */
    public String getChequeTotalAmount() {
        return chequeTotalAmount;
    }

    /**
     * 设置 【cantidadBilletesValidados;//支票金额】
     *
     * @param chequeTotalAmount - 【cantidadBilletesValidados;//支票金额】
     */
    public AtmGunneboTransactionBean setChequeTotalAmount(String chequeTotalAmount) {
        this.chequeTotalAmount = chequeTotalAmount == null ? null : chequeTotalAmount.trim();
        return this;
    }

    /**
     * 获取 【cantidadBilletesManual;//支票数量】
     *
     * @return transaction_cheque_number - 【cantidadBilletesManual;//支票数量】
     */
    public String getChequeNumber() {
        return chequeNumber;
    }

    /**
     * 设置 【cantidadBilletesManual;//支票数量】
     *
     * @param chequeNumber - 【cantidadBilletesManual;//支票数量】
     */
    public AtmGunneboTransactionBean setChequeNumber(String chequeNumber) {
        this.chequeNumber = chequeNumber == null ? null : chequeNumber.trim();
        return this;
    }

    /**
     * 获取 【Integer transaccionEnvase;//信封数量】
     *
     * @return transaction_envelopes_number - 【Integer transaccionEnvase;//信封数量】
     */
    public String getEnvelopesNumber() {
        return envelopesNumber;
    }

    /**
     * 设置 【Integer transaccionEnvase;//信封数量】
     *
     * @param envelopesNumber - 【Integer transaccionEnvase;//信封数量】
     */
    public AtmGunneboTransactionBean setEnvelopesNumber(String envelopesNumber) {
        this.envelopesNumber = envelopesNumber == null ? null : envelopesNumber.trim();
        return this;
    }

    /**
     * 获取 【String codigoenvase;//信封代码】
     *
     * @return transaction_envelopes_code - 【String codigoenvase;//信封代码】
     */
    public String getEnvelopesCode() {
        return envelopesCode;
    }

    /**
     * 设置 【String codigoenvase;//信封代码】
     *
     * @param envelopesCode - 【String codigoenvase;//信封代码】
     */
    public AtmGunneboTransactionBean setEnvelopesCode(String envelopesCode) {
        this.envelopesCode = envelopesCode == null ? null : envelopesCode.trim();
        return this;
    }

    /**
     * 获取 【String divisa;//货币类型】
     *
     * @return transaction_currency_type - 【String divisa;//货币类型】
     */
    public String getCurrencyType() {
        return currencyType;
    }

    /**
     * 设置 【String divisa;//货币类型】
     *
     * @param currencyType - 【String divisa;//货币类型】
     */
    public AtmGunneboTransactionBean setCurrencyType(String currencyType) {
        this.currencyType = currencyType == null ? null : currencyType.trim();
        return this;
    }

    /**
     * 获取 【String cuentaBanco;//当前货币张数】
     *
     * @return transaction_currency_current_number - 【String cuentaBanco;//当前货币张数】
     */
    public String getCurrencyCurrentNumber() {
        return currencyCurrentNumber;
    }

    /**
     * 设置 【String cuentaBanco;//当前货币张数】
     *
     * @param currencyCurrentNumber - 【String cuentaBanco;//当前货币张数】
     */
    public AtmGunneboTransactionBean setCurrencyCurrentNumber(String currencyCurrentNumber) {
        this.currencyCurrentNumber = currencyCurrentNumber == null ? null : currencyCurrentNumber.trim();
        return this;
    }

    /**
     * 获取 【Integer totalValidado;//总金额】
     *
     * @return transaction_currency_total_amount - 【Integer totalValidado;//总金额】
     */
    public String getCurrencyTotalAmount() {
        return currencyTotalAmount;
    }

    /**
     * 设置 【Integer totalValidado;//总金额】
     *
     * @param currencyTotalAmount - 【Integer totalValidado;//总金额】
     */
    public AtmGunneboTransactionBean setCurrencyTotalAmount(String currencyTotalAmount) {
        this.currencyTotalAmount = currencyTotalAmount == null ? null : currencyTotalAmount.trim();
        return this;
    }

    /**
     * 获取 【Integer denominacion1;//硬币,*，面额】
     *
     * @return transaction_hard_denomination1 - 【Integer denominacion1;//硬币,*，面额】
     */
    public String getHardDenomination1() {
        return hardDenomination1;
    }

    /**
     * 设置 【Integer denominacion1;//硬币,*，面额】
     *
     * @param hardDenomination1 - 【Integer denominacion1;//硬币,*，面额】
     */
    public AtmGunneboTransactionBean setHardDenomination1(String hardDenomination1) {
        this.hardDenomination1 = hardDenomination1 == null ? null : hardDenomination1.trim();
        return this;
    }

    /**
     * 获取 【Integer denominacion2;//硬币,*，面额】
     *
     * @return transaction_hard_denomination2 - 【Integer denominacion2;//硬币,*，面额】
     */
    public String getHardDenomination2() {
        return hardDenomination2;
    }

    /**
     * 设置 【Integer denominacion2;//硬币,*，面额】
     *
     * @param hardDenomination2 - 【Integer denominacion2;//硬币,*，面额】
     */
    public AtmGunneboTransactionBean setHardDenomination2(String hardDenomination2) {
        this.hardDenomination2 = hardDenomination2 == null ? null : hardDenomination2.trim();
        return this;
    }

    /**
     * 获取 【Integer denominacion3;//硬币,*，面额】
     *
     * @return transaction_hard_denomination3 - 【Integer denominacion3;//硬币,*，面额】
     */
    public String getHardDenomination3() {
        return hardDenomination3;
    }

    /**
     * 设置 【Integer denominacion3;//硬币,*，面额】
     *
     * @param hardDenomination3 - 【Integer denominacion3;//硬币,*，面额】
     */
    public AtmGunneboTransactionBean setHardDenomination3(String hardDenomination3) {
        this.hardDenomination3 = hardDenomination3 == null ? null : hardDenomination3.trim();
        return this;
    }

    /**
     * 获取 【Integer denominacion4;//硬币,*，面额】
     *
     * @return transaction_hard_denomination4 - 【Integer denominacion4;//硬币,*，面额】
     */
    public String getHardDenomination4() {
        return hardDenomination4;
    }

    /**
     * 设置 【Integer denominacion4;//硬币,*，面额】
     *
     * @param hardDenomination4 - 【Integer denominacion4;//硬币,*，面额】
     */
    public AtmGunneboTransactionBean setHardDenomination4(String hardDenomination4) {
        this.hardDenomination4 = hardDenomination4 == null ? null : hardDenomination4.trim();
        return this;
    }

    /**
     * 获取 【Integer denominacion5;//硬币,*，面额】
     *
     * @return transaction_hard_denomination5 - 【Integer denominacion5;//硬币,*，面额】
     */
    public String getHardDenomination5() {
        return hardDenomination5;
    }

    /**
     * 设置 【Integer denominacion5;//硬币,*，面额】
     *
     * @param hardDenomination5 - 【Integer denominacion5;//硬币,*，面额】
     */
    public AtmGunneboTransactionBean setHardDenomination5(String hardDenomination5) {
        this.hardDenomination5 = hardDenomination5 == null ? null : hardDenomination5.trim();
        return this;
    }

    /**
     * 获取 【Integer denominacion6;//硬币,*，面额】
     *
     * @return transaction_hard_denomination6 - 【Integer denominacion6;//硬币,*，面额】
     */
    public String getHardDenomination6() {
        return hardDenomination6;
    }

    /**
     * 设置 【Integer denominacion6;//硬币,*，面额】
     *
     * @param hardDenomination6 - 【Integer denominacion6;//硬币,*，面额】
     */
    public AtmGunneboTransactionBean setHardDenomination6(String hardDenomination6) {
        this.hardDenomination6 = hardDenomination6 == null ? null : hardDenomination6.trim();
        return this;
    }

    /**
     * 获取 【Integer denominacion7;//硬币,*，面额】
     *
     * @return transaction_hard_denomination7 - 【Integer denominacion7;//硬币,*，面额】
     */
    public String getHardDenomination7() {
        return hardDenomination7;
    }

    /**
     * 设置 【Integer denominacion7;//硬币,*，面额】
     *
     * @param hardDenomination7 - 【Integer denominacion7;//硬币,*，面额】
     */
    public AtmGunneboTransactionBean setHardDenomination7(String hardDenomination7) {
        this.hardDenomination7 = hardDenomination7 == null ? null : hardDenomination7.trim();
        return this;
    }

    /**
     * 获取 【Integer denominacion8;//硬币,*，面额】
     *
     * @return transaction_hard_denomination8 - 【Integer denominacion8;//硬币,*，面额】
     */
    public String getHardDenomination8() {
        return hardDenomination8;
    }

    /**
     * 设置 【Integer denominacion8;//硬币,*，面额】
     *
     * @param hardDenomination8 - 【Integer denominacion8;//硬币,*，面额】
     */
    public AtmGunneboTransactionBean setHardDenomination8(String hardDenomination8) {
        this.hardDenomination8 = hardDenomination8 == null ? null : hardDenomination8.trim();
        return this;
    }

    /**
     * 获取 【Integer denominacionM1;//纸币,*，面额】
     *
     * @return transaction_paper_denomination1 - 【Integer denominacionM1;//纸币,*，面额】
     */
    public String getPaperDenomination1() {
        return paperDenomination1;
    }

    /**
     * 设置 【Integer denominacionM1;//纸币,*，面额】
     *
     * @param paperDenomination1 - 【Integer denominacionM1;//纸币,*，面额】
     */
    public AtmGunneboTransactionBean setPaperDenomination1(String paperDenomination1) {
        this.paperDenomination1 = paperDenomination1 == null ? null : paperDenomination1.trim();
        return this;
    }

    /**
     * 获取 【Integer denominacionM2;//纸币,*，面额】
     *
     * @return transaction_paper_denomination2 - 【Integer denominacionM2;//纸币,*，面额】
     */
    public String getPaperDenomination2() {
        return paperDenomination2;
    }

    /**
     * 设置 【Integer denominacionM2;//纸币,*，面额】
     *
     * @param paperDenomination2 - 【Integer denominacionM2;//纸币,*，面额】
     */
    public AtmGunneboTransactionBean setPaperDenomination2(String paperDenomination2) {
        this.paperDenomination2 = paperDenomination2 == null ? null : paperDenomination2.trim();
        return this;
    }

    /**
     * 获取 【Integer denominacionM3;//纸币,*，面额】
     *
     * @return transaction_paper_denomination3 - 【Integer denominacionM3;//纸币,*，面额】
     */
    public String getPaperDenomination3() {
        return paperDenomination3;
    }

    /**
     * 设置 【Integer denominacionM3;//纸币,*，面额】
     *
     * @param paperDenomination3 - 【Integer denominacionM3;//纸币,*，面额】
     */
    public AtmGunneboTransactionBean setPaperDenomination3(String paperDenomination3) {
        this.paperDenomination3 = paperDenomination3 == null ? null : paperDenomination3.trim();
        return this;
    }

    /**
     * 获取 【Integer denominacionM4;//纸币,*，面额】
     *
     * @return transaction_paper_denomination4 - 【Integer denominacionM4;//纸币,*，面额】
     */
    public String getPaperDenomination4() {
        return paperDenomination4;
    }

    /**
     * 设置 【Integer denominacionM4;//纸币,*，面额】
     *
     * @param paperDenomination4 - 【Integer denominacionM4;//纸币,*，面额】
     */
    public AtmGunneboTransactionBean setPaperDenomination4(String paperDenomination4) {
        this.paperDenomination4 = paperDenomination4 == null ? null : paperDenomination4.trim();
        return this;
    }

    /**
     * 获取 【Integer denominacionM5;//纸币,*，面额】
     *
     * @return transaction_paper_denomination5 - 【Integer denominacionM5;//纸币,*，面额】
     */
    public String getPaperDenomination5() {
        return paperDenomination5;
    }

    /**
     * 设置 【Integer denominacionM5;//纸币,*，面额】
     *
     * @param paperDenomination5 - 【Integer denominacionM5;//纸币,*，面额】
     */
    public AtmGunneboTransactionBean setPaperDenomination5(String paperDenomination5) {
        this.paperDenomination5 = paperDenomination5 == null ? null : paperDenomination5.trim();
        return this;
    }

    /**
     * 获取 【Integer denominacionM6;//纸币,*，面额】
     *
     * @return transaction_paper_denomination6 - 【Integer denominacionM6;//纸币,*，面额】
     */
    public String getPaperDenomination6() {
        return paperDenomination6;
    }

    /**
     * 设置 【Integer denominacionM6;//纸币,*，面额】
     *
     * @param paperDenomination6 - 【Integer denominacionM6;//纸币,*，面额】
     */
    public AtmGunneboTransactionBean setPaperDenomination6(String paperDenomination6) {
        this.paperDenomination6 = paperDenomination6 == null ? null : paperDenomination6.trim();
        return this;
    }

    /**
     * 获取 【Integer denominacionM7;//纸币,*，面额】
     *
     * @return transaction_paper_denomination7 - 【Integer denominacionM7;//纸币,*，面额】
     */
    public String getPaperDenomination7() {
        return paperDenomination7;
    }

    /**
     * 设置 【Integer denominacionM7;//纸币,*，面额】
     *
     * @param paperDenomination7 - 【Integer denominacionM7;//纸币,*，面额】
     */
    public AtmGunneboTransactionBean setPaperDenomination7(String paperDenomination7) {
        this.paperDenomination7 = paperDenomination7 == null ? null : paperDenomination7.trim();
        return this;
    }

    /**
     * 获取 【String totalManual;//手工输入的金额】
     *
     * @return transaction_manual_total_amount - 【String totalManual;//手工输入的金额】
     */
    public String getManualTotalAmount() {
        return manualTotalAmount;
    }

    /**
     * 设置 【String totalManual;//手工输入的金额】
     *
     * @param manualTotalAmount - 【String totalManual;//手工输入的金额】
     */
    public AtmGunneboTransactionBean setManualTotalAmount(String manualTotalAmount) {
        this.manualTotalAmount = manualTotalAmount == null ? null : manualTotalAmount.trim();
        return this;
    }

    /**
     * 获取 【Integer denominacion1Manua1;//手工输入的面额（存信封时使用）,*，面额】
     *
     * @return transaction_manual_denomination1 - 【Integer denominacion1Manua1;//手工输入的面额（存信封时使用）,*，面额】
     */
    public String getManualDenomination1() {
        return manualDenomination1;
    }

    /**
     * 设置 【Integer denominacion1Manua1;//手工输入的面额（存信封时使用）,*，面额】
     *
     * @param manualDenomination1 - 【Integer denominacion1Manua1;//手工输入的面额（存信封时使用）,*，面额】
     */
    public AtmGunneboTransactionBean setManualDenomination1(String manualDenomination1) {
        this.manualDenomination1 = manualDenomination1 == null ? null : manualDenomination1.trim();
        return this;
    }

    /**
     * 获取 【Integer denominacion1Manua2;//手工输入的面额（存信封时使用）,*，面额】
     *
     * @return transaction_manual_denomination2 - 【Integer denominacion1Manua2;//手工输入的面额（存信封时使用）,*，面额】
     */
    public String getManualDenomination2() {
        return manualDenomination2;
    }

    /**
     * 设置 【Integer denominacion1Manua2;//手工输入的面额（存信封时使用）,*，面额】
     *
     * @param manualDenomination2 - 【Integer denominacion1Manua2;//手工输入的面额（存信封时使用）,*，面额】
     */
    public AtmGunneboTransactionBean setManualDenomination2(String manualDenomination2) {
        this.manualDenomination2 = manualDenomination2 == null ? null : manualDenomination2.trim();
        return this;
    }

    /**
     * 获取 【Integer denominacion1Manua3;//手工输入的面额（存信封时使用）,*，面额】
     *
     * @return transaction_manual_denomination3 - 【Integer denominacion1Manua3;//手工输入的面额（存信封时使用）,*，面额】
     */
    public String getManualDenomination3() {
        return manualDenomination3;
    }

    /**
     * 设置 【Integer denominacion1Manua3;//手工输入的面额（存信封时使用）,*，面额】
     *
     * @param manualDenomination3 - 【Integer denominacion1Manua3;//手工输入的面额（存信封时使用）,*，面额】
     */
    public AtmGunneboTransactionBean setManualDenomination3(String manualDenomination3) {
        this.manualDenomination3 = manualDenomination3 == null ? null : manualDenomination3.trim();
        return this;
    }

    /**
     * 获取 【Integer denominacion1Manua4;//手工输入的面额（存信封时使用）,*，面额】
     *
     * @return transaction_manual_denomination4 - 【Integer denominacion1Manua4;//手工输入的面额（存信封时使用）,*，面额】
     */
    public String getManualDenomination4() {
        return manualDenomination4;
    }

    /**
     * 设置 【Integer denominacion1Manua4;//手工输入的面额（存信封时使用）,*，面额】
     *
     * @param manualDenomination4 - 【Integer denominacion1Manua4;//手工输入的面额（存信封时使用）,*，面额】
     */
    public AtmGunneboTransactionBean setManualDenomination4(String manualDenomination4) {
        this.manualDenomination4 = manualDenomination4 == null ? null : manualDenomination4.trim();
        return this;
    }

    /**
     * 获取 【Integer denominacion1Manua5;//手工输入的面额（存信封时使用）,*，面额】
     *
     * @return transaction_manual_denomination5 - 【Integer denominacion1Manua5;//手工输入的面额（存信封时使用）,*，面额】
     */
    public String getManualDenomination5() {
        return manualDenomination5;
    }

    /**
     * 设置 【Integer denominacion1Manua5;//手工输入的面额（存信封时使用）,*，面额】
     *
     * @param manualDenomination5 - 【Integer denominacion1Manua5;//手工输入的面额（存信封时使用）,*，面额】
     */
    public AtmGunneboTransactionBean setManualDenomination5(String manualDenomination5) {
        this.manualDenomination5 = manualDenomination5 == null ? null : manualDenomination5.trim();
        return this;
    }

    /**
     * 获取 【Integer denominacion1Manua6;//手工输入的面额（存信封时使用）,*，面额】
     *
     * @return transaction_manual_denomination6 - 【Integer denominacion1Manua6;//手工输入的面额（存信封时使用）,*，面额】
     */
    public String getManualDenomination6() {
        return manualDenomination6;
    }

    /**
     * 设置 【Integer denominacion1Manua6;//手工输入的面额（存信封时使用）,*，面额】
     *
     * @param manualDenomination6 - 【Integer denominacion1Manua6;//手工输入的面额（存信封时使用）,*，面额】
     */
    public AtmGunneboTransactionBean setManualDenomination6(String manualDenomination6) {
        this.manualDenomination6 = manualDenomination6 == null ? null : manualDenomination6.trim();
        return this;
    }

    /**
     * 获取 【Integer denominacion1Manua7;//手工输入的面额（存信封时使用）,*，面额】
     *
     * @return transaction_manual_denomination7 - 【Integer denominacion1Manua7;//手工输入的面额（存信封时使用）,*，面额】
     */
    public String getManualDenomination7() {
        return manualDenomination7;
    }

    /**
     * 设置 【Integer denominacion1Manua7;//手工输入的面额（存信封时使用）,*，面额】
     *
     * @param manualDenomination7 - 【Integer denominacion1Manua7;//手工输入的面额（存信封时使用）,*，面额】
     */
    public AtmGunneboTransactionBean setManualDenomination7(String manualDenomination7) {
        this.manualDenomination7 = manualDenomination7 == null ? null : manualDenomination7.trim();
        return this;
    }

    /**
     * 获取 【Integer denominacion1Manua8;//手工输入的面额（存信封时使用）,*，面额】
     *
     * @return transaction_manual_denomination8 - 【Integer denominacion1Manua8;//手工输入的面额（存信封时使用）,*，面额】
     */
    public String getManualDenomination8() {
        return manualDenomination8;
    }

    /**
     * 设置 【Integer denominacion1Manua8;//手工输入的面额（存信封时使用）,*，面额】
     *
     * @param manualDenomination8 - 【Integer denominacion1Manua8;//手工输入的面额（存信封时使用）,*，面额】
     */
    public AtmGunneboTransactionBean setManualDenomination8(String manualDenomination8) {
        this.manualDenomination8 = manualDenomination8 == null ? null : manualDenomination8.trim();
        return this;
    }

    /**
     * 获取 【String totalDocumentosExternos;//文件数量、（其他机器使用，忽略）】
     *
     * @return transaction_document_total_amount - 【String totalDocumentosExternos;//文件数量、（其他机器使用，忽略）】
     */
    public String getDocumentTotalAmount() {
        return documentTotalAmount;
    }

    /**
     * 设置 【String totalDocumentosExternos;//文件数量、（其他机器使用，忽略）】
     *
     * @param documentTotalAmount - 【String totalDocumentosExternos;//文件数量、（其他机器使用，忽略）】
     */
    public AtmGunneboTransactionBean setDocumentTotalAmount(String documentTotalAmount) {
        this.documentTotalAmount = documentTotalAmount == null ? null : documentTotalAmount.trim();
        return this;
    }

    /**
     * 获取 【String referencia;//（客户输入的内容有关）】
     *
     * @return transaction_reference - 【String referencia;//（客户输入的内容有关）】
     */
    public String getReference() {
        return reference;
    }

    /**
     * 设置 【String referencia;//（客户输入的内容有关）】
     *
     * @param reference - 【String referencia;//（客户输入的内容有关）】
     */
    public AtmGunneboTransactionBean setReference(String reference) {
        this.reference = reference == null ? null : reference.trim();
        return this;
    }

    /**
     * 获取 【String claveSobre】
     *
     * @return transaction_clave_sobre - 【String claveSobre】
     */
    public String getClaveSobre() {
        return claveSobre;
    }

    /**
     * 设置 【String claveSobre】
     *
     * @param claveSobre - 【String claveSobre】
     */
    public AtmGunneboTransactionBean setClaveSobre(String claveSobre) {
        this.claveSobre = claveSobre == null ? null : claveSobre.trim();
        return this;
    }

    /**
     * 获取 【String totalSobre】
     *
     * @return transaction_total_sobre - 【String totalSobre】
     */
    public String getTotalSobre() {
        return totalSobre;
    }

    /**
     * 设置 【String totalSobre】
     *
     * @param totalSobre - 【String totalSobre】
     */
    public AtmGunneboTransactionBean setTotalSobre(String totalSobre) {
        this.totalSobre = totalSobre == null ? null : totalSobre.trim();
        return this;
    }

    /**
     * 获取 【String impreso】
     *
     * @return transaction_impreso - 【String impreso】
     */
    public String getImpreso() {
        return impreso;
    }

    /**
     * 设置 【String impreso】
     *
     * @param impreso - 【String impreso】
     */
    public AtmGunneboTransactionBean setImpreso(String impreso) {
        this.impreso = impreso == null ? null : impreso.trim();
        return this;
    }

    /**
     * 获取 【String balanza】
     *
     * @return transaction_balanza - 【String balanza】
     */
    public String getBalanza() {
        return balanza;
    }

    /**
     * 设置 【String balanza】
     *
     * @param balanza - 【String balanza】
     */
    public AtmGunneboTransactionBean setBalanza(String balanza) {
        this.balanza = balanza == null ? null : balanza.trim();
        return this;
    }

    /**
     * 获取 【String fechaCont】
     *
     * @return transaction_fecha_cont - 【String fechaCont】
     */
    public String getFechaCont() {
        return fechaCont;
    }

    /**
     * 设置 【String fechaCont】
     *
     * @param fechaCont - 【String fechaCont】
     */
    public AtmGunneboTransactionBean setFechaCont(String fechaCont) {
        this.fechaCont = fechaCont == null ? null : fechaCont.trim();
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
    public AtmGunneboTransactionBean setCreateTimestamp(Date createTimestamp) {
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
    public AtmGunneboTransactionBean setCreateBy(String createBy) {
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
    public AtmGunneboTransactionBean setDeleteFlag(String deleteFlag) {
        this.deleteFlag = deleteFlag == null ? null : deleteFlag.trim();
        return this;
    }
}