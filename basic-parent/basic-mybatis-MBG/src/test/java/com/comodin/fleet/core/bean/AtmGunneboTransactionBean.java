package com.comodin.fleet.core.bean;

import com.comodin.basic.util.date.DateUtil;
import com.comodin.basic.validation.IBaseValidGroup;
import com.comodin.basic.validation.constraints.*;
import com.comodin.fleet.constants.i18n.AtmGunneboTransactionBeanI18nConstant;
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
     * DB remark: gunneboATM主表ID,与t_atm_gunnebo.atm_id 字段关联【{"max":13}】
     * DB column: transaction_atm_id	BIGINT(20)	<--->	atmId	java.lang.Long
     * DB is  Nullable: true
     * DB defaultValue: null
     * </pre>
     */
    @ValidLength(max = 13, message = "{" + AtmGunneboTransactionBeanI18nConstant.ATM_GUNNEBO_TRANSACTION_BEAN_ATM_ID_LENGTH + "}", groups = {IBaseValidGroup.Add.class, IBaseValidGroup.Update.class})
    @Column(name = "transaction_atm_id", length = 20, nullable = true)
    private Long atmId;

    /**
     * <pre>
     * DB remark: ATM终端，唯一标识
     * DB column: transaction_atm_terminal_id	VARCHAR(64)	<--->	atmTerminalId	java.lang.String
     * DB is  Nullable: false
     * DB defaultValue: null
     * </pre>
     */
    @NotBlank(message = "{" + AtmGunneboTransactionBeanI18nConstant.ATM_GUNNEBO_TRANSACTION_BEAN_ATM_TERMINAL_ID_NOT_BLANK + "}", groups = {IBaseValidGroup.Add.class, IBaseValidGroup.Update.class})
    @Length(max = 64, message = "{" + AtmGunneboTransactionBeanI18nConstant.ATM_GUNNEBO_TRANSACTION_BEAN_ATM_TERMINAL_ID_LENGTH + "}", groups = {IBaseValidGroup.Add.class, IBaseValidGroup.Update.class})
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
    @NotBlank(message = "{" + AtmGunneboTransactionBeanI18nConstant.ATM_GUNNEBO_TRANSACTION_BEAN_ATM_TERMINAL_TYPE_NOT_BLANK + "}", groups = {IBaseValidGroup.Add.class, IBaseValidGroup.Update.class})
    @Length(max = 20, message = "{" + AtmGunneboTransactionBeanI18nConstant.ATM_GUNNEBO_TRANSACTION_BEAN_ATM_TERMINAL_TYPE_LENGTH + "}", groups = {IBaseValidGroup.Add.class, IBaseValidGroup.Update.class})
    @Column(name = "transaction_atm_terminal_type", length = 20, nullable = false)
    private String atmTerminalType;

    /**
     * <pre>
     * DB remark: 记录，Atm设备原始TransaccionesId【Integer [idtransaccion] int NOT NULL IDENTITY(8897826,1)】
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
     * DB remark: cit客户公司内部ID【Integer [cliente] int NULL】
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
     * DB remark: cit客户网点内部ID【Integer [sucursal] int NULL】
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
     * DB remark: 操作类型【Integer [operacion] int NULL】
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
     * DB remark: 存款号ID【String [dispositivo] varchar(30) COLLATE Modern_Spanish_CI_AI NULL】
     * DB column: transaction_deposit_id	VARCHAR(30)	<--->	depositId	java.lang.String
     * DB is  Nullable: true
     * DB defaultValue: null
     * </pre>
     */
    @Length(max = 30, message = "{" + AtmGunneboTransactionBeanI18nConstant.ATM_GUNNEBO_TRANSACTION_BEAN_DEPOSIT_ID_LENGTH + "}", groups = {IBaseValidGroup.Add.class, IBaseValidGroup.Update.class})
    @Column(name = "transaction_deposit_id", length = 30, nullable = true)
    private String depositId;

    /**
     * <pre>
     * DB remark: 存款用户账号【String [usuario] varchar(30) COLLATE Modern_Spanish_CI_AI NULL】
     * DB column: transaction_deposit_user_account	VARCHAR(30)	<--->	depositUserAccount	java.lang.String
     * DB is  Nullable: true
     * DB defaultValue: null
     * </pre>
     */
    @Length(max = 30, message = "{" + AtmGunneboTransactionBeanI18nConstant.ATM_GUNNEBO_TRANSACTION_BEAN_DEPOSIT_USER_ACCOUNT_LENGTH + "}", groups = {IBaseValidGroup.Add.class, IBaseValidGroup.Update.class})
    @Column(name = "transaction_deposit_user_account", length = 30, nullable = true)
    private String depositUserAccount;

    /**
     * <pre>
     * DB remark: 存款时间【Date [fechaHoraDispositivo] datetime NULL】
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
     * DB remark: 存款机发送到服务端的时间【Date [fechaHoraServicio] datetime NULL】
     * DB column: transaction_deposit_send_server_date_time	TIMESTAMP(19)	<--->	depositSendServerDateTime	java.util.Date
     * DB is  Nullable: true
     * DB defaultValue: null
     * </pre>
     */
    @ValidDateTimeFormat(pattern = DateUtil.DATE_PATTERN_YYYY_MM_DD_HH_MM_SS, message = "{" + AtmGunneboTransactionBeanI18nConstant.ATM_GUNNEBO_TRANSACTION_BEAN_DEPOSIT_SEND_SERVER_DATE_TIME_DATE_TIME_FORMAT + "}", groups = {IBaseValidGroup.Add.class, IBaseValidGroup.Update.class})
    @DateTimeFormat(pattern = DateUtil.DATE_PATTERN_YYYY_MM_DD_HH_MM_SS)
    @Column(name = "transaction_deposit_send_server_date_time", length = 19, nullable = true)
    private Date depositSendServerDateTime;

    /**
     * <pre>
     * DB remark: 取款ID【Integer [codigoRetiro] int NULL】
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
     * DB remark: 状态【String [Estatus] nchar(1) COLLATE Modern_Spanish_CI_AI NULL DEFAULT (N'A')】
     * DB column: transaction_status	CHAR(1)	<--->	status	java.lang.String
     * DB is  Nullable: true
     * DB defaultValue: null
     * </pre>
     */
    @Length(max = 1, message = "{" + AtmGunneboTransactionBeanI18nConstant.ATM_GUNNEBO_TRANSACTION_BEAN_STATUS_LENGTH + "}", groups = {IBaseValidGroup.Add.class, IBaseValidGroup.Update.class})
    @Column(name = "transaction_status", length = 1, nullable = true)
    private String status;

    /**
     * <pre>
     * DB remark: 设备状态【String [estatusMaquina] varchar(10) COLLATE Modern_Spanish_CI_AI NULL】
     * DB column: transaction_device_status	VARCHAR(10)	<--->	deviceStatus	java.lang.String
     * DB is  Nullable: true
     * DB defaultValue: null
     * </pre>
     */
    @Length(max = 10, message = "{" + AtmGunneboTransactionBeanI18nConstant.ATM_GUNNEBO_TRANSACTION_BEAN_DEVICE_STATUS_LENGTH + "}", groups = {IBaseValidGroup.Add.class, IBaseValidGroup.Update.class})
    @Column(name = "transaction_device_status", length = 10, nullable = true)
    private String deviceStatus;

    /**
     * <pre>
     * DB remark: 交易状态【Integer [estatusTransaccion] int NULL】
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
     * DB remark: 描述【String [descripcion] varchar(30) COLLATE Modern_Spanish_CI_AI NULL】
     * DB column: transaction_description	VARCHAR(30)	<--->	description	java.lang.String
     * DB is  Nullable: true
     * DB defaultValue: null
     * </pre>
     */
    @Length(max = 30, message = "{" + AtmGunneboTransactionBeanI18nConstant.ATM_GUNNEBO_TRANSACTION_BEAN_DESCRIPTION_LENGTH + "}", groups = {IBaseValidGroup.Add.class, IBaseValidGroup.Update.class})
    @Column(name = "transaction_description", length = 30, nullable = true)
    private String description;

    /**
     * <pre>
     * DB remark: 错误代码【String [codHex] varchar(5) COLLATE Modern_Spanish_CI_AI NULL】
     * DB column: transaction_cod_error	VARCHAR(5)	<--->	codError	java.lang.String
     * DB is  Nullable: true
     * DB defaultValue: null
     * </pre>
     */
    @Length(max = 5, message = "{" + AtmGunneboTransactionBeanI18nConstant.ATM_GUNNEBO_TRANSACTION_BEAN_COD_ERROR_LENGTH + "}", groups = {IBaseValidGroup.Add.class, IBaseValidGroup.Update.class})
    @Column(name = "transaction_cod_error", length = 5, nullable = true)
    private String codError;

    /**
     * <pre>
     * DB remark: 支票金额【Integer [billetesValidados] int NULL】
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
     * DB remark: 支票数量【Integer [billetesManual] int NULL】
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
     * DB remark: 信封数量【Integer [transaccionEnvase] int NULL】
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
     * DB remark: 信封代码【String [codigoEnvase] varchar(50) COLLATE Modern_Spanish_CI_AI NULL】
     * DB column: transaction_envelopes_code	VARCHAR(50)	<--->	envelopesCode	java.lang.String
     * DB is  Nullable: true
     * DB defaultValue: null
     * </pre>
     */
    @Length(max = 50, message = "{" + AtmGunneboTransactionBeanI18nConstant.ATM_GUNNEBO_TRANSACTION_BEAN_ENVELOPES_CODE_LENGTH + "}", groups = {IBaseValidGroup.Add.class, IBaseValidGroup.Update.class})
    @Column(name = "transaction_envelopes_code", length = 50, nullable = true)
    private String envelopesCode;

    /**
     * <pre>
     * DB remark: 货币类型【String [divisa] varchar(5) COLLATE Modern_Spanish_CI_AI NULL】
     * DB column: transaction_currency_type	VARCHAR(5)	<--->	currencyType	java.lang.String
     * DB is  Nullable: true
     * DB defaultValue: null
     * </pre>
     */
    @Length(max = 5, message = "{" + AtmGunneboTransactionBeanI18nConstant.ATM_GUNNEBO_TRANSACTION_BEAN_CURRENCY_TYPE_LENGTH + "}", groups = {IBaseValidGroup.Add.class, IBaseValidGroup.Update.class})
    @Column(name = "transaction_currency_type", length = 5, nullable = true)
    private String currencyType;

    /**
     * <pre>
     * DB remark: 当前货币张数【String [cuentaBanco] int NULL】
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
     * DB remark: 总金额【Integer [totalValidado] int NULL】
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
     * DB remark: 硬币,20，面额【Integer [denominacion1] int NULL】
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
     * DB remark: 硬币,50，面额【Integer [denominacion2] int NULL】
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
     * DB remark: 硬币,*，面额【Integer [denominacion3] int NULL】
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
     * DB remark: 硬币,*，面额【Integer [denominacion4] int NULL】
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
     * DB remark: 硬币,*，面额【Integer [denominacion5] int NULL】
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
     * DB remark: 硬币,*，面额【Integer [denominacion6] int NULL】
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
     * DB remark: 硬币,*，面额【Integer [denominacion7] int NULL】
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
     * DB remark: 硬币,*，面额【Integer [denominacion8] int NULL】
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
     * DB remark: 纸币,*，面额【Integer [denominacionM1] int NULL】
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
     * DB remark: 纸币,*，面额【Integer [denominacionM2] int NULL】
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
     * DB remark: 纸币,*，面额【Integer [denominacionM3] int NULL】
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
     * DB remark: 纸币,*，面额【Integer [denominacionM4] int NULL】
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
     * DB remark: 纸币,*，面额【Integer [denominacionM5] int NULL】
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
     * DB remark: 纸币,*，面额【Integer [denominacionM6] int NULL】
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
     * DB remark: 纸币,*，面额【Integer [denominacionM7] int NULL】
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
     * DB remark: 手工输入的金额【String [totalManual] int NULL】
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
     * DB remark: 手工输入的面额（存信封时使用）,*，面额【Integer [denominacion1Manual] int NULL】
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
     * DB remark: 手工输入的面额（存信封时使用）,*，面额【Integer [denominacion2Manual] int NULL】
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
     * DB remark: 手工输入的面额（存信封时使用）,*，面额【Integer [denominacion3Manual] int NULL】
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
     * DB remark: 手工输入的面额（存信封时使用）,*，面额【Integer [denominacion4Manual] int NULL】
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
     * DB remark: 手工输入的面额（存信封时使用）,*，面额【Integer [denominacion5Manual] int NULL】
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
     * DB remark: 手工输入的面额（存信封时使用）,*，面额【Integer [denominacion6Manual] int NULL】
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
     * DB remark: 手工输入的面额（存信封时使用）,*，面额【Integer [denominacion7Manual] int NULL】
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
     * DB remark: 手工输入的面额（存信封时使用）,*，面额【Integer [denominacion8Manual] int NULL】
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
     * DB remark: 文件数量、（其他机器使用，忽略）【String [totalDocumentosExternos] float(53) NULL】
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
     * DB remark: 客户输入的内容有关【String [referencia] int NULL】
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
     * DB remark: 其他机器使用，忽略【String [claveSobre] varchar(50) COLLATE Modern_Spanish_CI_AI NULL】
     * DB column: transaction_clave_sobre	VARCHAR(50)	<--->	claveSobre	java.lang.String
     * DB is  Nullable: true
     * DB defaultValue: null
     * </pre>
     */
    @Length(max = 50, message = "{" + AtmGunneboTransactionBeanI18nConstant.ATM_GUNNEBO_TRANSACTION_BEAN_CLAVE_SOBRE_LENGTH + "}", groups = {IBaseValidGroup.Add.class, IBaseValidGroup.Update.class})
    @Column(name = "transaction_clave_sobre", length = 50, nullable = true)
    private String claveSobre;

    /**
     * <pre>
     * DB remark: 其他机器使用，忽略【String [totalSobre] float(53) NULL DEFAULT ((0))】
     * DB column: transaction_total_sobre	VARCHAR(53)	<--->	totalSobre	java.lang.String
     * DB is  Nullable: true
     * DB defaultValue: null
     * </pre>
     */
    @Length(max = 53, message = "{" + AtmGunneboTransactionBeanI18nConstant.ATM_GUNNEBO_TRANSACTION_BEAN_TOTAL_SOBRE_LENGTH + "}", groups = {IBaseValidGroup.Add.class, IBaseValidGroup.Update.class})
    @Column(name = "transaction_total_sobre", length = 53, nullable = true)
    private String totalSobre;

    /**
     * <pre>
     * DB remark: 其他机器使用，忽略【String impreso int default 0】
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
     * DB remark: 其他机器使用，忽略【String Balanza nvarchar(150)】
     * DB column: transaction_balanza	VARCHAR(150)	<--->	balanza	java.lang.String
     * DB is  Nullable: true
     * DB defaultValue: null
     * </pre>
     */
    @Length(max = 150, message = "{" + AtmGunneboTransactionBeanI18nConstant.ATM_GUNNEBO_TRANSACTION_BEAN_BALANZA_LENGTH + "}", groups = {IBaseValidGroup.Add.class, IBaseValidGroup.Update.class})
    @Column(name = "transaction_balanza", length = 150, nullable = true)
    private String balanza;

    /**
     * <pre>
     * DB remark: 其他机器使用，忽略【String Fecha_Cont nvarchar(50)】
     * DB column: transaction_fecha_cont	VARCHAR(50)	<--->	fechaCont	java.lang.String
     * DB is  Nullable: true
     * DB defaultValue: null
     * </pre>
     */
    @Length(max = 50, message = "{" + AtmGunneboTransactionBeanI18nConstant.ATM_GUNNEBO_TRANSACTION_BEAN_FECHA_CONT_LENGTH + "}", groups = {IBaseValidGroup.Add.class, IBaseValidGroup.Update.class})
    @Column(name = "transaction_fecha_cont", length = 50, nullable = true)
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
     * 获取 gunneboATM主表ID,与t_atm_gunnebo.atm_id 字段关联【{"max":13}】
     *
     * @return transaction_atm_id - gunneboATM主表ID,与t_atm_gunnebo.atm_id 字段关联【{"max":13}】
     */
    public Long getAtmId() {
        return atmId;
    }

    /**
     * 设置 gunneboATM主表ID,与t_atm_gunnebo.atm_id 字段关联【{"max":13}】
     *
     * @param atmId - gunneboATM主表ID,与t_atm_gunnebo.atm_id 字段关联【{"max":13}】
     */
    public AtmGunneboTransactionBean setAtmId(Long atmId) {
        this.atmId = atmId;
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
    public AtmGunneboTransactionBean setAtmTerminalId(String atmTerminalId) {
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
    public AtmGunneboTransactionBean setAtmTerminalType(String atmTerminalType) {
        this.atmTerminalType = atmTerminalType == null ? null : atmTerminalType.trim();
        return this;
    }

    /**
     * 获取 记录，Atm设备原始TransaccionesId【Integer [idtransaccion] int NOT NULL IDENTITY(8897826,1)】
     *
     * @return transaction_original_id - 记录，Atm设备原始TransaccionesId【Integer [idtransaccion] int NOT NULL IDENTITY(8897826,1)】
     */
    public String getOriginalId() {
        return originalId;
    }

    /**
     * 设置 记录，Atm设备原始TransaccionesId【Integer [idtransaccion] int NOT NULL IDENTITY(8897826,1)】
     *
     * @param originalId - 记录，Atm设备原始TransaccionesId【Integer [idtransaccion] int NOT NULL IDENTITY(8897826,1)】
     */
    public AtmGunneboTransactionBean setOriginalId(String originalId) {
        this.originalId = originalId == null ? null : originalId.trim();
        return this;
    }

    /**
     * 获取 cit客户公司内部ID【Integer [cliente] int NULL】
     *
     * @return transaction_client_internal_id - cit客户公司内部ID【Integer [cliente] int NULL】
     */
    public String getClientInternalId() {
        return clientInternalId;
    }

    /**
     * 设置 cit客户公司内部ID【Integer [cliente] int NULL】
     *
     * @param clientInternalId - cit客户公司内部ID【Integer [cliente] int NULL】
     */
    public AtmGunneboTransactionBean setClientInternalId(String clientInternalId) {
        this.clientInternalId = clientInternalId == null ? null : clientInternalId.trim();
        return this;
    }

    /**
     * 获取 cit客户网点内部ID【Integer [sucursal] int NULL】
     *
     * @return transaction_client_branch_internal_id - cit客户网点内部ID【Integer [sucursal] int NULL】
     */
    public String getClientBranchInternalId() {
        return clientBranchInternalId;
    }

    /**
     * 设置 cit客户网点内部ID【Integer [sucursal] int NULL】
     *
     * @param clientBranchInternalId - cit客户网点内部ID【Integer [sucursal] int NULL】
     */
    public AtmGunneboTransactionBean setClientBranchInternalId(String clientBranchInternalId) {
        this.clientBranchInternalId = clientBranchInternalId == null ? null : clientBranchInternalId.trim();
        return this;
    }

    /**
     * 获取 操作类型【Integer [operacion] int NULL】
     *
     * @return transaction_operation_type - 操作类型【Integer [operacion] int NULL】
     */
    public String getOperationType() {
        return operationType;
    }

    /**
     * 设置 操作类型【Integer [operacion] int NULL】
     *
     * @param operationType - 操作类型【Integer [operacion] int NULL】
     */
    public AtmGunneboTransactionBean setOperationType(String operationType) {
        this.operationType = operationType == null ? null : operationType.trim();
        return this;
    }

    /**
     * 获取 存款号ID【String [dispositivo] varchar(30) COLLATE Modern_Spanish_CI_AI NULL】
     *
     * @return transaction_deposit_id - 存款号ID【String [dispositivo] varchar(30) COLLATE Modern_Spanish_CI_AI NULL】
     */
    public String getDepositId() {
        return depositId;
    }

    /**
     * 设置 存款号ID【String [dispositivo] varchar(30) COLLATE Modern_Spanish_CI_AI NULL】
     *
     * @param depositId - 存款号ID【String [dispositivo] varchar(30) COLLATE Modern_Spanish_CI_AI NULL】
     */
    public AtmGunneboTransactionBean setDepositId(String depositId) {
        this.depositId = depositId == null ? null : depositId.trim();
        return this;
    }

    /**
     * 获取 存款用户账号【String [usuario] varchar(30) COLLATE Modern_Spanish_CI_AI NULL】
     *
     * @return transaction_deposit_user_account - 存款用户账号【String [usuario] varchar(30) COLLATE Modern_Spanish_CI_AI NULL】
     */
    public String getDepositUserAccount() {
        return depositUserAccount;
    }

    /**
     * 设置 存款用户账号【String [usuario] varchar(30) COLLATE Modern_Spanish_CI_AI NULL】
     *
     * @param depositUserAccount - 存款用户账号【String [usuario] varchar(30) COLLATE Modern_Spanish_CI_AI NULL】
     */
    public AtmGunneboTransactionBean setDepositUserAccount(String depositUserAccount) {
        this.depositUserAccount = depositUserAccount == null ? null : depositUserAccount.trim();
        return this;
    }

    /**
     * 获取 存款时间【Date [fechaHoraDispositivo] datetime NULL】
     *
     * @return transaction_deposit_date_time - 存款时间【Date [fechaHoraDispositivo] datetime NULL】
     */
    public Date getDepositDateTime() {
        return depositDateTime;
    }

    /**
     * 设置 存款时间【Date [fechaHoraDispositivo] datetime NULL】
     *
     * @param depositDateTime - 存款时间【Date [fechaHoraDispositivo] datetime NULL】
     */
    public AtmGunneboTransactionBean setDepositDateTime(Date depositDateTime) {
        this.depositDateTime = depositDateTime;
        return this;
    }

    /**
     * 获取 存款机发送到服务端的时间【Date [fechaHoraServicio] datetime NULL】
     *
     * @return transaction_deposit_send_server_date_time - 存款机发送到服务端的时间【Date [fechaHoraServicio] datetime NULL】
     */
    public Date getDepositSendServerDateTime() {
        return depositSendServerDateTime;
    }

    /**
     * 设置 存款机发送到服务端的时间【Date [fechaHoraServicio] datetime NULL】
     *
     * @param depositSendServerDateTime - 存款机发送到服务端的时间【Date [fechaHoraServicio] datetime NULL】
     */
    public AtmGunneboTransactionBean setDepositSendServerDateTime(Date depositSendServerDateTime) {
        this.depositSendServerDateTime = depositSendServerDateTime;
        return this;
    }

    /**
     * 获取 取款ID【Integer [codigoRetiro] int NULL】
     *
     * @return transaction_withdrawals_id - 取款ID【Integer [codigoRetiro] int NULL】
     */
    public String getWithdrawalsId() {
        return withdrawalsId;
    }

    /**
     * 设置 取款ID【Integer [codigoRetiro] int NULL】
     *
     * @param withdrawalsId - 取款ID【Integer [codigoRetiro] int NULL】
     */
    public AtmGunneboTransactionBean setWithdrawalsId(String withdrawalsId) {
        this.withdrawalsId = withdrawalsId == null ? null : withdrawalsId.trim();
        return this;
    }

    /**
     * 获取 状态【String [Estatus] nchar(1) COLLATE Modern_Spanish_CI_AI NULL DEFAULT (N'A')】
     *
     * @return transaction_status - 状态【String [Estatus] nchar(1) COLLATE Modern_Spanish_CI_AI NULL DEFAULT (N'A')】
     */
    public String getStatus() {
        return status;
    }

    /**
     * 设置 状态【String [Estatus] nchar(1) COLLATE Modern_Spanish_CI_AI NULL DEFAULT (N'A')】
     *
     * @param status - 状态【String [Estatus] nchar(1) COLLATE Modern_Spanish_CI_AI NULL DEFAULT (N'A')】
     */
    public AtmGunneboTransactionBean setStatus(String status) {
        this.status = status == null ? null : status.trim();
        return this;
    }

    /**
     * 获取 设备状态【String [estatusMaquina] varchar(10) COLLATE Modern_Spanish_CI_AI NULL】
     *
     * @return transaction_device_status - 设备状态【String [estatusMaquina] varchar(10) COLLATE Modern_Spanish_CI_AI NULL】
     */
    public String getDeviceStatus() {
        return deviceStatus;
    }

    /**
     * 设置 设备状态【String [estatusMaquina] varchar(10) COLLATE Modern_Spanish_CI_AI NULL】
     *
     * @param deviceStatus - 设备状态【String [estatusMaquina] varchar(10) COLLATE Modern_Spanish_CI_AI NULL】
     */
    public AtmGunneboTransactionBean setDeviceStatus(String deviceStatus) {
        this.deviceStatus = deviceStatus == null ? null : deviceStatus.trim();
        return this;
    }

    /**
     * 获取 交易状态【Integer [estatusTransaccion] int NULL】
     *
     * @return transaction_transaction_status - 交易状态【Integer [estatusTransaccion] int NULL】
     */
    public String getTransactionStatus() {
        return transactionStatus;
    }

    /**
     * 设置 交易状态【Integer [estatusTransaccion] int NULL】
     *
     * @param transactionStatus - 交易状态【Integer [estatusTransaccion] int NULL】
     */
    public AtmGunneboTransactionBean setTransactionStatus(String transactionStatus) {
        this.transactionStatus = transactionStatus == null ? null : transactionStatus.trim();
        return this;
    }

    /**
     * 获取 描述【String [descripcion] varchar(30) COLLATE Modern_Spanish_CI_AI NULL】
     *
     * @return transaction_description - 描述【String [descripcion] varchar(30) COLLATE Modern_Spanish_CI_AI NULL】
     */
    public String getDescription() {
        return description;
    }

    /**
     * 设置 描述【String [descripcion] varchar(30) COLLATE Modern_Spanish_CI_AI NULL】
     *
     * @param description - 描述【String [descripcion] varchar(30) COLLATE Modern_Spanish_CI_AI NULL】
     */
    public AtmGunneboTransactionBean setDescription(String description) {
        this.description = description == null ? null : description.trim();
        return this;
    }

    /**
     * 获取 错误代码【String [codHex] varchar(5) COLLATE Modern_Spanish_CI_AI NULL】
     *
     * @return transaction_cod_error - 错误代码【String [codHex] varchar(5) COLLATE Modern_Spanish_CI_AI NULL】
     */
    public String getCodError() {
        return codError;
    }

    /**
     * 设置 错误代码【String [codHex] varchar(5) COLLATE Modern_Spanish_CI_AI NULL】
     *
     * @param codError - 错误代码【String [codHex] varchar(5) COLLATE Modern_Spanish_CI_AI NULL】
     */
    public AtmGunneboTransactionBean setCodError(String codError) {
        this.codError = codError == null ? null : codError.trim();
        return this;
    }

    /**
     * 获取 支票金额【Integer [billetesValidados] int NULL】
     *
     * @return transaction_cheque_total_amount - 支票金额【Integer [billetesValidados] int NULL】
     */
    public String getChequeTotalAmount() {
        return chequeTotalAmount;
    }

    /**
     * 设置 支票金额【Integer [billetesValidados] int NULL】
     *
     * @param chequeTotalAmount - 支票金额【Integer [billetesValidados] int NULL】
     */
    public AtmGunneboTransactionBean setChequeTotalAmount(String chequeTotalAmount) {
        this.chequeTotalAmount = chequeTotalAmount == null ? null : chequeTotalAmount.trim();
        return this;
    }

    /**
     * 获取 支票数量【Integer [billetesManual] int NULL】
     *
     * @return transaction_cheque_number - 支票数量【Integer [billetesManual] int NULL】
     */
    public String getChequeNumber() {
        return chequeNumber;
    }

    /**
     * 设置 支票数量【Integer [billetesManual] int NULL】
     *
     * @param chequeNumber - 支票数量【Integer [billetesManual] int NULL】
     */
    public AtmGunneboTransactionBean setChequeNumber(String chequeNumber) {
        this.chequeNumber = chequeNumber == null ? null : chequeNumber.trim();
        return this;
    }

    /**
     * 获取 信封数量【Integer [transaccionEnvase] int NULL】
     *
     * @return transaction_envelopes_number - 信封数量【Integer [transaccionEnvase] int NULL】
     */
    public String getEnvelopesNumber() {
        return envelopesNumber;
    }

    /**
     * 设置 信封数量【Integer [transaccionEnvase] int NULL】
     *
     * @param envelopesNumber - 信封数量【Integer [transaccionEnvase] int NULL】
     */
    public AtmGunneboTransactionBean setEnvelopesNumber(String envelopesNumber) {
        this.envelopesNumber = envelopesNumber == null ? null : envelopesNumber.trim();
        return this;
    }

    /**
     * 获取 信封代码【String [codigoEnvase] varchar(50) COLLATE Modern_Spanish_CI_AI NULL】
     *
     * @return transaction_envelopes_code - 信封代码【String [codigoEnvase] varchar(50) COLLATE Modern_Spanish_CI_AI NULL】
     */
    public String getEnvelopesCode() {
        return envelopesCode;
    }

    /**
     * 设置 信封代码【String [codigoEnvase] varchar(50) COLLATE Modern_Spanish_CI_AI NULL】
     *
     * @param envelopesCode - 信封代码【String [codigoEnvase] varchar(50) COLLATE Modern_Spanish_CI_AI NULL】
     */
    public AtmGunneboTransactionBean setEnvelopesCode(String envelopesCode) {
        this.envelopesCode = envelopesCode == null ? null : envelopesCode.trim();
        return this;
    }

    /**
     * 获取 货币类型【String [divisa] varchar(5) COLLATE Modern_Spanish_CI_AI NULL】
     *
     * @return transaction_currency_type - 货币类型【String [divisa] varchar(5) COLLATE Modern_Spanish_CI_AI NULL】
     */
    public String getCurrencyType() {
        return currencyType;
    }

    /**
     * 设置 货币类型【String [divisa] varchar(5) COLLATE Modern_Spanish_CI_AI NULL】
     *
     * @param currencyType - 货币类型【String [divisa] varchar(5) COLLATE Modern_Spanish_CI_AI NULL】
     */
    public AtmGunneboTransactionBean setCurrencyType(String currencyType) {
        this.currencyType = currencyType == null ? null : currencyType.trim();
        return this;
    }

    /**
     * 获取 当前货币张数【String [cuentaBanco] int NULL】
     *
     * @return transaction_currency_current_number - 当前货币张数【String [cuentaBanco] int NULL】
     */
    public String getCurrencyCurrentNumber() {
        return currencyCurrentNumber;
    }

    /**
     * 设置 当前货币张数【String [cuentaBanco] int NULL】
     *
     * @param currencyCurrentNumber - 当前货币张数【String [cuentaBanco] int NULL】
     */
    public AtmGunneboTransactionBean setCurrencyCurrentNumber(String currencyCurrentNumber) {
        this.currencyCurrentNumber = currencyCurrentNumber == null ? null : currencyCurrentNumber.trim();
        return this;
    }

    /**
     * 获取 总金额【Integer [totalValidado] int NULL】
     *
     * @return transaction_currency_total_amount - 总金额【Integer [totalValidado] int NULL】
     */
    public String getCurrencyTotalAmount() {
        return currencyTotalAmount;
    }

    /**
     * 设置 总金额【Integer [totalValidado] int NULL】
     *
     * @param currencyTotalAmount - 总金额【Integer [totalValidado] int NULL】
     */
    public AtmGunneboTransactionBean setCurrencyTotalAmount(String currencyTotalAmount) {
        this.currencyTotalAmount = currencyTotalAmount == null ? null : currencyTotalAmount.trim();
        return this;
    }

    /**
     * 获取 硬币,20，面额【Integer [denominacion1] int NULL】
     *
     * @return transaction_hard_denomination1 - 硬币,20，面额【Integer [denominacion1] int NULL】
     */
    public String getHardDenomination1() {
        return hardDenomination1;
    }

    /**
     * 设置 硬币,20，面额【Integer [denominacion1] int NULL】
     *
     * @param hardDenomination1 - 硬币,20，面额【Integer [denominacion1] int NULL】
     */
    public AtmGunneboTransactionBean setHardDenomination1(String hardDenomination1) {
        this.hardDenomination1 = hardDenomination1 == null ? null : hardDenomination1.trim();
        return this;
    }

    /**
     * 获取 硬币,50，面额【Integer [denominacion2] int NULL】
     *
     * @return transaction_hard_denomination2 - 硬币,50，面额【Integer [denominacion2] int NULL】
     */
    public String getHardDenomination2() {
        return hardDenomination2;
    }

    /**
     * 设置 硬币,50，面额【Integer [denominacion2] int NULL】
     *
     * @param hardDenomination2 - 硬币,50，面额【Integer [denominacion2] int NULL】
     */
    public AtmGunneboTransactionBean setHardDenomination2(String hardDenomination2) {
        this.hardDenomination2 = hardDenomination2 == null ? null : hardDenomination2.trim();
        return this;
    }

    /**
     * 获取 硬币,*，面额【Integer [denominacion3] int NULL】
     *
     * @return transaction_hard_denomination3 - 硬币,*，面额【Integer [denominacion3] int NULL】
     */
    public String getHardDenomination3() {
        return hardDenomination3;
    }

    /**
     * 设置 硬币,*，面额【Integer [denominacion3] int NULL】
     *
     * @param hardDenomination3 - 硬币,*，面额【Integer [denominacion3] int NULL】
     */
    public AtmGunneboTransactionBean setHardDenomination3(String hardDenomination3) {
        this.hardDenomination3 = hardDenomination3 == null ? null : hardDenomination3.trim();
        return this;
    }

    /**
     * 获取 硬币,*，面额【Integer [denominacion4] int NULL】
     *
     * @return transaction_hard_denomination4 - 硬币,*，面额【Integer [denominacion4] int NULL】
     */
    public String getHardDenomination4() {
        return hardDenomination4;
    }

    /**
     * 设置 硬币,*，面额【Integer [denominacion4] int NULL】
     *
     * @param hardDenomination4 - 硬币,*，面额【Integer [denominacion4] int NULL】
     */
    public AtmGunneboTransactionBean setHardDenomination4(String hardDenomination4) {
        this.hardDenomination4 = hardDenomination4 == null ? null : hardDenomination4.trim();
        return this;
    }

    /**
     * 获取 硬币,*，面额【Integer [denominacion5] int NULL】
     *
     * @return transaction_hard_denomination5 - 硬币,*，面额【Integer [denominacion5] int NULL】
     */
    public String getHardDenomination5() {
        return hardDenomination5;
    }

    /**
     * 设置 硬币,*，面额【Integer [denominacion5] int NULL】
     *
     * @param hardDenomination5 - 硬币,*，面额【Integer [denominacion5] int NULL】
     */
    public AtmGunneboTransactionBean setHardDenomination5(String hardDenomination5) {
        this.hardDenomination5 = hardDenomination5 == null ? null : hardDenomination5.trim();
        return this;
    }

    /**
     * 获取 硬币,*，面额【Integer [denominacion6] int NULL】
     *
     * @return transaction_hard_denomination6 - 硬币,*，面额【Integer [denominacion6] int NULL】
     */
    public String getHardDenomination6() {
        return hardDenomination6;
    }

    /**
     * 设置 硬币,*，面额【Integer [denominacion6] int NULL】
     *
     * @param hardDenomination6 - 硬币,*，面额【Integer [denominacion6] int NULL】
     */
    public AtmGunneboTransactionBean setHardDenomination6(String hardDenomination6) {
        this.hardDenomination6 = hardDenomination6 == null ? null : hardDenomination6.trim();
        return this;
    }

    /**
     * 获取 硬币,*，面额【Integer [denominacion7] int NULL】
     *
     * @return transaction_hard_denomination7 - 硬币,*，面额【Integer [denominacion7] int NULL】
     */
    public String getHardDenomination7() {
        return hardDenomination7;
    }

    /**
     * 设置 硬币,*，面额【Integer [denominacion7] int NULL】
     *
     * @param hardDenomination7 - 硬币,*，面额【Integer [denominacion7] int NULL】
     */
    public AtmGunneboTransactionBean setHardDenomination7(String hardDenomination7) {
        this.hardDenomination7 = hardDenomination7 == null ? null : hardDenomination7.trim();
        return this;
    }

    /**
     * 获取 硬币,*，面额【Integer [denominacion8] int NULL】
     *
     * @return transaction_hard_denomination8 - 硬币,*，面额【Integer [denominacion8] int NULL】
     */
    public String getHardDenomination8() {
        return hardDenomination8;
    }

    /**
     * 设置 硬币,*，面额【Integer [denominacion8] int NULL】
     *
     * @param hardDenomination8 - 硬币,*，面额【Integer [denominacion8] int NULL】
     */
    public AtmGunneboTransactionBean setHardDenomination8(String hardDenomination8) {
        this.hardDenomination8 = hardDenomination8 == null ? null : hardDenomination8.trim();
        return this;
    }

    /**
     * 获取 纸币,*，面额【Integer [denominacionM1] int NULL】
     *
     * @return transaction_paper_denomination1 - 纸币,*，面额【Integer [denominacionM1] int NULL】
     */
    public String getPaperDenomination1() {
        return paperDenomination1;
    }

    /**
     * 设置 纸币,*，面额【Integer [denominacionM1] int NULL】
     *
     * @param paperDenomination1 - 纸币,*，面额【Integer [denominacionM1] int NULL】
     */
    public AtmGunneboTransactionBean setPaperDenomination1(String paperDenomination1) {
        this.paperDenomination1 = paperDenomination1 == null ? null : paperDenomination1.trim();
        return this;
    }

    /**
     * 获取 纸币,*，面额【Integer [denominacionM2] int NULL】
     *
     * @return transaction_paper_denomination2 - 纸币,*，面额【Integer [denominacionM2] int NULL】
     */
    public String getPaperDenomination2() {
        return paperDenomination2;
    }

    /**
     * 设置 纸币,*，面额【Integer [denominacionM2] int NULL】
     *
     * @param paperDenomination2 - 纸币,*，面额【Integer [denominacionM2] int NULL】
     */
    public AtmGunneboTransactionBean setPaperDenomination2(String paperDenomination2) {
        this.paperDenomination2 = paperDenomination2 == null ? null : paperDenomination2.trim();
        return this;
    }

    /**
     * 获取 纸币,*，面额【Integer [denominacionM3] int NULL】
     *
     * @return transaction_paper_denomination3 - 纸币,*，面额【Integer [denominacionM3] int NULL】
     */
    public String getPaperDenomination3() {
        return paperDenomination3;
    }

    /**
     * 设置 纸币,*，面额【Integer [denominacionM3] int NULL】
     *
     * @param paperDenomination3 - 纸币,*，面额【Integer [denominacionM3] int NULL】
     */
    public AtmGunneboTransactionBean setPaperDenomination3(String paperDenomination3) {
        this.paperDenomination3 = paperDenomination3 == null ? null : paperDenomination3.trim();
        return this;
    }

    /**
     * 获取 纸币,*，面额【Integer [denominacionM4] int NULL】
     *
     * @return transaction_paper_denomination4 - 纸币,*，面额【Integer [denominacionM4] int NULL】
     */
    public String getPaperDenomination4() {
        return paperDenomination4;
    }

    /**
     * 设置 纸币,*，面额【Integer [denominacionM4] int NULL】
     *
     * @param paperDenomination4 - 纸币,*，面额【Integer [denominacionM4] int NULL】
     */
    public AtmGunneboTransactionBean setPaperDenomination4(String paperDenomination4) {
        this.paperDenomination4 = paperDenomination4 == null ? null : paperDenomination4.trim();
        return this;
    }

    /**
     * 获取 纸币,*，面额【Integer [denominacionM5] int NULL】
     *
     * @return transaction_paper_denomination5 - 纸币,*，面额【Integer [denominacionM5] int NULL】
     */
    public String getPaperDenomination5() {
        return paperDenomination5;
    }

    /**
     * 设置 纸币,*，面额【Integer [denominacionM5] int NULL】
     *
     * @param paperDenomination5 - 纸币,*，面额【Integer [denominacionM5] int NULL】
     */
    public AtmGunneboTransactionBean setPaperDenomination5(String paperDenomination5) {
        this.paperDenomination5 = paperDenomination5 == null ? null : paperDenomination5.trim();
        return this;
    }

    /**
     * 获取 纸币,*，面额【Integer [denominacionM6] int NULL】
     *
     * @return transaction_paper_denomination6 - 纸币,*，面额【Integer [denominacionM6] int NULL】
     */
    public String getPaperDenomination6() {
        return paperDenomination6;
    }

    /**
     * 设置 纸币,*，面额【Integer [denominacionM6] int NULL】
     *
     * @param paperDenomination6 - 纸币,*，面额【Integer [denominacionM6] int NULL】
     */
    public AtmGunneboTransactionBean setPaperDenomination6(String paperDenomination6) {
        this.paperDenomination6 = paperDenomination6 == null ? null : paperDenomination6.trim();
        return this;
    }

    /**
     * 获取 纸币,*，面额【Integer [denominacionM7] int NULL】
     *
     * @return transaction_paper_denomination7 - 纸币,*，面额【Integer [denominacionM7] int NULL】
     */
    public String getPaperDenomination7() {
        return paperDenomination7;
    }

    /**
     * 设置 纸币,*，面额【Integer [denominacionM7] int NULL】
     *
     * @param paperDenomination7 - 纸币,*，面额【Integer [denominacionM7] int NULL】
     */
    public AtmGunneboTransactionBean setPaperDenomination7(String paperDenomination7) {
        this.paperDenomination7 = paperDenomination7 == null ? null : paperDenomination7.trim();
        return this;
    }

    /**
     * 获取 手工输入的金额【String [totalManual] int NULL】
     *
     * @return transaction_manual_total_amount - 手工输入的金额【String [totalManual] int NULL】
     */
    public String getManualTotalAmount() {
        return manualTotalAmount;
    }

    /**
     * 设置 手工输入的金额【String [totalManual] int NULL】
     *
     * @param manualTotalAmount - 手工输入的金额【String [totalManual] int NULL】
     */
    public AtmGunneboTransactionBean setManualTotalAmount(String manualTotalAmount) {
        this.manualTotalAmount = manualTotalAmount == null ? null : manualTotalAmount.trim();
        return this;
    }

    /**
     * 获取 手工输入的面额（存信封时使用）,*，面额【Integer [denominacion1Manual] int NULL】
     *
     * @return transaction_manual_denomination1 - 手工输入的面额（存信封时使用）,*，面额【Integer [denominacion1Manual] int NULL】
     */
    public String getManualDenomination1() {
        return manualDenomination1;
    }

    /**
     * 设置 手工输入的面额（存信封时使用）,*，面额【Integer [denominacion1Manual] int NULL】
     *
     * @param manualDenomination1 - 手工输入的面额（存信封时使用）,*，面额【Integer [denominacion1Manual] int NULL】
     */
    public AtmGunneboTransactionBean setManualDenomination1(String manualDenomination1) {
        this.manualDenomination1 = manualDenomination1 == null ? null : manualDenomination1.trim();
        return this;
    }

    /**
     * 获取 手工输入的面额（存信封时使用）,*，面额【Integer [denominacion2Manual] int NULL】
     *
     * @return transaction_manual_denomination2 - 手工输入的面额（存信封时使用）,*，面额【Integer [denominacion2Manual] int NULL】
     */
    public String getManualDenomination2() {
        return manualDenomination2;
    }

    /**
     * 设置 手工输入的面额（存信封时使用）,*，面额【Integer [denominacion2Manual] int NULL】
     *
     * @param manualDenomination2 - 手工输入的面额（存信封时使用）,*，面额【Integer [denominacion2Manual] int NULL】
     */
    public AtmGunneboTransactionBean setManualDenomination2(String manualDenomination2) {
        this.manualDenomination2 = manualDenomination2 == null ? null : manualDenomination2.trim();
        return this;
    }

    /**
     * 获取 手工输入的面额（存信封时使用）,*，面额【Integer [denominacion3Manual] int NULL】
     *
     * @return transaction_manual_denomination3 - 手工输入的面额（存信封时使用）,*，面额【Integer [denominacion3Manual] int NULL】
     */
    public String getManualDenomination3() {
        return manualDenomination3;
    }

    /**
     * 设置 手工输入的面额（存信封时使用）,*，面额【Integer [denominacion3Manual] int NULL】
     *
     * @param manualDenomination3 - 手工输入的面额（存信封时使用）,*，面额【Integer [denominacion3Manual] int NULL】
     */
    public AtmGunneboTransactionBean setManualDenomination3(String manualDenomination3) {
        this.manualDenomination3 = manualDenomination3 == null ? null : manualDenomination3.trim();
        return this;
    }

    /**
     * 获取 手工输入的面额（存信封时使用）,*，面额【Integer [denominacion4Manual] int NULL】
     *
     * @return transaction_manual_denomination4 - 手工输入的面额（存信封时使用）,*，面额【Integer [denominacion4Manual] int NULL】
     */
    public String getManualDenomination4() {
        return manualDenomination4;
    }

    /**
     * 设置 手工输入的面额（存信封时使用）,*，面额【Integer [denominacion4Manual] int NULL】
     *
     * @param manualDenomination4 - 手工输入的面额（存信封时使用）,*，面额【Integer [denominacion4Manual] int NULL】
     */
    public AtmGunneboTransactionBean setManualDenomination4(String manualDenomination4) {
        this.manualDenomination4 = manualDenomination4 == null ? null : manualDenomination4.trim();
        return this;
    }

    /**
     * 获取 手工输入的面额（存信封时使用）,*，面额【Integer [denominacion5Manual] int NULL】
     *
     * @return transaction_manual_denomination5 - 手工输入的面额（存信封时使用）,*，面额【Integer [denominacion5Manual] int NULL】
     */
    public String getManualDenomination5() {
        return manualDenomination5;
    }

    /**
     * 设置 手工输入的面额（存信封时使用）,*，面额【Integer [denominacion5Manual] int NULL】
     *
     * @param manualDenomination5 - 手工输入的面额（存信封时使用）,*，面额【Integer [denominacion5Manual] int NULL】
     */
    public AtmGunneboTransactionBean setManualDenomination5(String manualDenomination5) {
        this.manualDenomination5 = manualDenomination5 == null ? null : manualDenomination5.trim();
        return this;
    }

    /**
     * 获取 手工输入的面额（存信封时使用）,*，面额【Integer [denominacion6Manual] int NULL】
     *
     * @return transaction_manual_denomination6 - 手工输入的面额（存信封时使用）,*，面额【Integer [denominacion6Manual] int NULL】
     */
    public String getManualDenomination6() {
        return manualDenomination6;
    }

    /**
     * 设置 手工输入的面额（存信封时使用）,*，面额【Integer [denominacion6Manual] int NULL】
     *
     * @param manualDenomination6 - 手工输入的面额（存信封时使用）,*，面额【Integer [denominacion6Manual] int NULL】
     */
    public AtmGunneboTransactionBean setManualDenomination6(String manualDenomination6) {
        this.manualDenomination6 = manualDenomination6 == null ? null : manualDenomination6.trim();
        return this;
    }

    /**
     * 获取 手工输入的面额（存信封时使用）,*，面额【Integer [denominacion7Manual] int NULL】
     *
     * @return transaction_manual_denomination7 - 手工输入的面额（存信封时使用）,*，面额【Integer [denominacion7Manual] int NULL】
     */
    public String getManualDenomination7() {
        return manualDenomination7;
    }

    /**
     * 设置 手工输入的面额（存信封时使用）,*，面额【Integer [denominacion7Manual] int NULL】
     *
     * @param manualDenomination7 - 手工输入的面额（存信封时使用）,*，面额【Integer [denominacion7Manual] int NULL】
     */
    public AtmGunneboTransactionBean setManualDenomination7(String manualDenomination7) {
        this.manualDenomination7 = manualDenomination7 == null ? null : manualDenomination7.trim();
        return this;
    }

    /**
     * 获取 手工输入的面额（存信封时使用）,*，面额【Integer [denominacion8Manual] int NULL】
     *
     * @return transaction_manual_denomination8 - 手工输入的面额（存信封时使用）,*，面额【Integer [denominacion8Manual] int NULL】
     */
    public String getManualDenomination8() {
        return manualDenomination8;
    }

    /**
     * 设置 手工输入的面额（存信封时使用）,*，面额【Integer [denominacion8Manual] int NULL】
     *
     * @param manualDenomination8 - 手工输入的面额（存信封时使用）,*，面额【Integer [denominacion8Manual] int NULL】
     */
    public AtmGunneboTransactionBean setManualDenomination8(String manualDenomination8) {
        this.manualDenomination8 = manualDenomination8 == null ? null : manualDenomination8.trim();
        return this;
    }

    /**
     * 获取 文件数量、（其他机器使用，忽略）【String [totalDocumentosExternos] float(53) NULL】
     *
     * @return transaction_document_total_amount - 文件数量、（其他机器使用，忽略）【String [totalDocumentosExternos] float(53) NULL】
     */
    public String getDocumentTotalAmount() {
        return documentTotalAmount;
    }

    /**
     * 设置 文件数量、（其他机器使用，忽略）【String [totalDocumentosExternos] float(53) NULL】
     *
     * @param documentTotalAmount - 文件数量、（其他机器使用，忽略）【String [totalDocumentosExternos] float(53) NULL】
     */
    public AtmGunneboTransactionBean setDocumentTotalAmount(String documentTotalAmount) {
        this.documentTotalAmount = documentTotalAmount == null ? null : documentTotalAmount.trim();
        return this;
    }

    /**
     * 获取 客户输入的内容有关【String [referencia] int NULL】
     *
     * @return transaction_reference - 客户输入的内容有关【String [referencia] int NULL】
     */
    public String getReference() {
        return reference;
    }

    /**
     * 设置 客户输入的内容有关【String [referencia] int NULL】
     *
     * @param reference - 客户输入的内容有关【String [referencia] int NULL】
     */
    public AtmGunneboTransactionBean setReference(String reference) {
        this.reference = reference == null ? null : reference.trim();
        return this;
    }

    /**
     * 获取 其他机器使用，忽略【String [claveSobre] varchar(50) COLLATE Modern_Spanish_CI_AI NULL】
     *
     * @return transaction_clave_sobre - 其他机器使用，忽略【String [claveSobre] varchar(50) COLLATE Modern_Spanish_CI_AI NULL】
     */
    public String getClaveSobre() {
        return claveSobre;
    }

    /**
     * 设置 其他机器使用，忽略【String [claveSobre] varchar(50) COLLATE Modern_Spanish_CI_AI NULL】
     *
     * @param claveSobre - 其他机器使用，忽略【String [claveSobre] varchar(50) COLLATE Modern_Spanish_CI_AI NULL】
     */
    public AtmGunneboTransactionBean setClaveSobre(String claveSobre) {
        this.claveSobre = claveSobre == null ? null : claveSobre.trim();
        return this;
    }

    /**
     * 获取 其他机器使用，忽略【String [totalSobre] float(53) NULL DEFAULT ((0))】
     *
     * @return transaction_total_sobre - 其他机器使用，忽略【String [totalSobre] float(53) NULL DEFAULT ((0))】
     */
    public String getTotalSobre() {
        return totalSobre;
    }

    /**
     * 设置 其他机器使用，忽略【String [totalSobre] float(53) NULL DEFAULT ((0))】
     *
     * @param totalSobre - 其他机器使用，忽略【String [totalSobre] float(53) NULL DEFAULT ((0))】
     */
    public AtmGunneboTransactionBean setTotalSobre(String totalSobre) {
        this.totalSobre = totalSobre == null ? null : totalSobre.trim();
        return this;
    }

    /**
     * 获取 其他机器使用，忽略【String impreso int default 0】
     *
     * @return transaction_impreso - 其他机器使用，忽略【String impreso int default 0】
     */
    public String getImpreso() {
        return impreso;
    }

    /**
     * 设置 其他机器使用，忽略【String impreso int default 0】
     *
     * @param impreso - 其他机器使用，忽略【String impreso int default 0】
     */
    public AtmGunneboTransactionBean setImpreso(String impreso) {
        this.impreso = impreso == null ? null : impreso.trim();
        return this;
    }

    /**
     * 获取 其他机器使用，忽略【String Balanza nvarchar(150)】
     *
     * @return transaction_balanza - 其他机器使用，忽略【String Balanza nvarchar(150)】
     */
    public String getBalanza() {
        return balanza;
    }

    /**
     * 设置 其他机器使用，忽略【String Balanza nvarchar(150)】
     *
     * @param balanza - 其他机器使用，忽略【String Balanza nvarchar(150)】
     */
    public AtmGunneboTransactionBean setBalanza(String balanza) {
        this.balanza = balanza == null ? null : balanza.trim();
        return this;
    }

    /**
     * 获取 其他机器使用，忽略【String Fecha_Cont nvarchar(50)】
     *
     * @return transaction_fecha_cont - 其他机器使用，忽略【String Fecha_Cont nvarchar(50)】
     */
    public String getFechaCont() {
        return fechaCont;
    }

    /**
     * 设置 其他机器使用，忽略【String Fecha_Cont nvarchar(50)】
     *
     * @param fechaCont - 其他机器使用，忽略【String Fecha_Cont nvarchar(50)】
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