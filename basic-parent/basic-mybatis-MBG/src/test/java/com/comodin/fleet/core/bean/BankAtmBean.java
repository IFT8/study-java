package com.comodin.fleet.core.bean;

import com.comodin.basic.util.date.DateUtil;
import com.comodin.basic.validation.IBaseValidGroup;
import com.comodin.basic.validation.constraints.*;
import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;
import javax.persistence.*;
import javax.validation.constraints.*;
import org.hibernate.validator.constraints.*;
import org.springframework.format.annotation.DateTimeFormat;

@SuppressWarnings({"unused", "UnusedReturnValue", "SameParameterValue"})
@Table(name = "t_bank_atm")
public class BankAtmBean implements Serializable {
    /**
     * <pre>
     * DB remark: 数据库主键ID
     * DB column: atm_id	BIGINT(20)	<--->	id	java.lang.Long
     * DB is  Nullable: false
     * DB defaultValue: null
     * </pre>
     */
    @NotNull(message = "{BANK_ATM_BEAN_ID_NOT_NULL}", groups = {IBaseValidGroup.Add.class, IBaseValidGroup.Update.class})
    @ValidLength(max = 20, message = "{BANK_ATM_BEAN_ID_LENGTH}", groups = {IBaseValidGroup.Add.class, IBaseValidGroup.Update.class})
    @Id
    @Column(name = "atm_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    /**
     * <pre>
     * DB remark: ATM对应,客户ID,与 t_client.client_id 字段关联
     * DB column: atm_client_id	BIGINT(20)	<--->	clientId	java.lang.Long
     * DB is  Nullable: false
     * DB defaultValue: null
     * </pre>
     */
    @NotNull(message = "{BANK_ATM_BEAN_CLIENT_ID_NOT_NULL}", groups = {IBaseValidGroup.Add.class, IBaseValidGroup.Update.class})
    @ValidLength(max = 20, message = "{BANK_ATM_BEAN_CLIENT_ID_LENGTH}", groups = {IBaseValidGroup.Add.class, IBaseValidGroup.Update.class})
    @Column(name = "atm_client_id")
    private Long clientId;

    /**
     * <pre>
     * DB remark: ATM对应,客户名称,与 t_client.client_name 字段冗余
     * DB column: atm_client_name	VARCHAR(100)	<--->	clientName	java.lang.String
     * DB is  Nullable: false
     * DB defaultValue: null
     * </pre>
     */
    @NotBlank(message = "{BANK_ATM_BEAN_CLIENT_NAME_NOT_BLANK}", groups = {IBaseValidGroup.Add.class, IBaseValidGroup.Update.class})
    @Length(max = 100, message = "{BANK_ATM_BEAN_CLIENT_NAME_LENGTH}", groups = {IBaseValidGroup.Add.class, IBaseValidGroup.Update.class})
    @Column(name = "atm_client_name")
    private String clientName;

    /**
     * <pre>
     * DB remark: ATM对应,网点ID,与 t_client_branch.branch_id 字段关联
     * DB column: atm_branch_id	BIGINT(20)	<--->	branchId	java.lang.Long
     * DB is  Nullable: false
     * DB defaultValue: null
     * </pre>
     */
    @NotNull(message = "{BANK_ATM_BEAN_BRANCH_ID_NOT_NULL}", groups = {IBaseValidGroup.Add.class, IBaseValidGroup.Update.class})
    @ValidLength(max = 20, message = "{BANK_ATM_BEAN_BRANCH_ID_LENGTH}", groups = {IBaseValidGroup.Add.class, IBaseValidGroup.Update.class})
    @Column(name = "atm_branch_id")
    private Long branchId;

    /**
     * <pre>
     * DB remark: ATM对应,网点名称,与 t_client_branch.branch_name 字段冗余
     * DB column: atm_branch_name	VARCHAR(100)	<--->	branchName	java.lang.String
     * DB is  Nullable: false
     * DB defaultValue: null
     * </pre>
     */
    @NotBlank(message = "{BANK_ATM_BEAN_BRANCH_NAME_NOT_BLANK}", groups = {IBaseValidGroup.Add.class, IBaseValidGroup.Update.class})
    @Length(max = 100, message = "{BANK_ATM_BEAN_BRANCH_NAME_LENGTH}", groups = {IBaseValidGroup.Add.class, IBaseValidGroup.Update.class})
    @Column(name = "atm_branch_name")
    private String branchName;

    /**
     * <pre>
     * DB remark: ATM对应使用的Ip地址
     * DB column: atm_ip	VARCHAR(50)	<--->	ip	java.lang.String
     * DB is  Nullable: true
     * DB defaultValue: null
     * </pre>
     */
    @Length(max = 50, message = "{BANK_ATM_BEAN_IP_LENGTH}", groups = {IBaseValidGroup.Add.class, IBaseValidGroup.Update.class})
    @Column(name = "atm_ip")
    private String ip;

    /**
     * <pre>
     * DB remark: ATM的机型号
     * DB column: atm_model	VARCHAR(20)	<--->	model	java.lang.String
     * DB is  Nullable: true
     * DB defaultValue: null
     * </pre>
     */
    @Length(max = 20, message = "{BANK_ATM_BEAN_MODEL_LENGTH}", groups = {IBaseValidGroup.Add.class, IBaseValidGroup.Update.class})
    @Column(name = "atm_model")
    private String model;

    /**
     * <pre>
     * DB remark: ATM机的供应商
     * DB column: atm_vendor	VARCHAR(20)	<--->	vendor	java.lang.String
     * DB is  Nullable: true
     * DB defaultValue: null
     * </pre>
     */
    @Length(max = 20, message = "{BANK_ATM_BEAN_VENDOR_LENGTH}", groups = {IBaseValidGroup.Add.class, IBaseValidGroup.Update.class})
    @Column(name = "atm_vendor")
    private String vendor;

    /**
     * <pre>
     * DB remark: 地址
     * DB column: atm_address	VARCHAR(150)	<--->	address	java.lang.String
     * DB is  Nullable: true
     * DB defaultValue: null
     * </pre>
     */
    @Length(max = 150, message = "{BANK_ATM_BEAN_ADDRESS_LENGTH}", groups = {IBaseValidGroup.Add.class, IBaseValidGroup.Update.class})
    @Column(name = "atm_address")
    private String address;

    /**
     * <pre>
     * DB remark: ATM需维修时的关联的taskId
     * DB column: atm_task_id	BIGINT(20)	<--->	taskId	java.lang.Long
     * DB is  Nullable: true
     * DB defaultValue: null
     * </pre>
     */
    @ValidLength(max = 20, message = "{BANK_ATM_BEAN_TASK_ID_LENGTH}", groups = {IBaseValidGroup.Add.class, IBaseValidGroup.Update.class})
    @Column(name = "atm_task_id")
    private Long taskId;

    /**
     * <pre>
     * DB remark: ATMATM类型：DEPOSIT,RECYCLE,ATM
     * DB column: atm_type	VARCHAR(15)	<--->	type	java.lang.String
     * DB is  Nullable: true
     * DB defaultValue: null
     * </pre>
     */
    @Length(max = 15, message = "{BANK_ATM_BEAN_TYPE_LENGTH}", groups = {IBaseValidGroup.Add.class, IBaseValidGroup.Update.class})
    @Column(name = "atm_type")
    private String type;

    /**
     * <pre>
     * DB remark: 坐标纬度,浮点型
     * DB column: atm_latitude	VARCHAR(15)	<--->	latitude	java.lang.String
     * DB is  Nullable: false
     * DB defaultValue: null
     * </pre>
     */
    @NotBlank(message = "{BANK_ATM_BEAN_LATITUDE_NOT_BLANK}", groups = {IBaseValidGroup.Add.class, IBaseValidGroup.Update.class})
    @Length(max = 15, message = "{BANK_ATM_BEAN_LATITUDE_LENGTH}", groups = {IBaseValidGroup.Add.class, IBaseValidGroup.Update.class})
    @Column(name = "atm_latitude")
    private String latitude;

    /**
     * <pre>
     * DB remark: 坐标经度,浮点型
     * DB column: atm_longitude	VARCHAR(15)	<--->	longitude	java.lang.String
     * DB is  Nullable: false
     * DB defaultValue: null
     * </pre>
     */
    @NotBlank(message = "{BANK_ATM_BEAN_LONGITUDE_NOT_BLANK}", groups = {IBaseValidGroup.Add.class, IBaseValidGroup.Update.class})
    @Length(max = 15, message = "{BANK_ATM_BEAN_LONGITUDE_LENGTH}", groups = {IBaseValidGroup.Add.class, IBaseValidGroup.Update.class})
    @Column(name = "atm_longitude")
    private String longitude;

    /**
     * <pre>
     * DB remark: ATM内部编号,与t_crew.crew_internal_id冗余
     * DB column: atm_internal_id	VARCHAR(15)	<--->	internalId	java.lang.String
     * DB is  Nullable: true
     * DB defaultValue: null
     * </pre>
     */
    @Length(max = 15, message = "{BANK_ATM_BEAN_INTERNAL_ID_LENGTH}", groups = {IBaseValidGroup.Add.class, IBaseValidGroup.Update.class})
    @Column(name = "atm_internal_id")
    private String internalId;

    /**
     * <pre>
     * DB remark: ATM外部编号,在调用第三方接口里的唯一标识
     * DB column: atm_external_id	VARCHAR(15)	<--->	externalId	java.lang.String
     * DB is  Nullable: false
     * DB defaultValue: null
     * </pre>
     */
    @NotBlank(message = "{BANK_ATM_BEAN_EXTERNAL_ID_NOT_BLANK}", groups = {IBaseValidGroup.Add.class, IBaseValidGroup.Update.class})
    @Length(max = 15, message = "{BANK_ATM_BEAN_EXTERNAL_ID_LENGTH}", groups = {IBaseValidGroup.Add.class, IBaseValidGroup.Update.class})
    @Column(name = "atm_external_id")
    private String externalId;

    /**
     * <pre>
     * DB remark: ATM内存状态，状态 【以 ENABLE、DISABLE、BREAK】默认值:DISABLE
     * DB column: atm_ram_status	CHAR(30)	<--->	ramStatus	java.lang.String
     * DB is  Nullable: true
     * DB defaultValue: DISABLE
     * </pre>
     */
    @Length(max = 30, message = "{BANK_ATM_BEAN_RAM_STATUS_LENGTH}", groups = {IBaseValidGroup.Add.class, IBaseValidGroup.Update.class})
    @Column(name = "atm_ram_status")
    private String ramStatus;

    /**
     * <pre>
     * DB remark: ATM内存上限，单位：M
     * DB column: atm_ram_max	DECIMAL(18)	<--->	ramMax	java.math.BigDecimal
     * DB is  Nullable: true
     * DB defaultValue: 0.0000
     * </pre>
     */
    @Column(name = "atm_ram_max")
    private BigDecimal ramMax;

    /**
     * <pre>
     * DB remark: ATM内存当前使用大小，单位：M
     * DB column: atm_ram_current	DECIMAL(14)	<--->	ramCurrent	java.math.BigDecimal
     * DB is  Nullable: true
     * DB defaultValue: 0.0000
     * </pre>
     */
    @Column(name = "atm_ram_current")
    private BigDecimal ramCurrent;

    /**
     * <pre>
     * DB remark: ATM CPU状态，状态 【以 ENABLE、DISABLE、BREAK】默认值:DISABLE
     * DB column: atm_cpu_status	CHAR(30)	<--->	cpuStatus	java.lang.String
     * DB is  Nullable: true
     * DB defaultValue: DISABLE
     * </pre>
     */
    @Length(max = 30, message = "{BANK_ATM_BEAN_CPU_STATUS_LENGTH}", groups = {IBaseValidGroup.Add.class, IBaseValidGroup.Update.class})
    @Column(name = "atm_cpu_status")
    private String cpuStatus;

    /**
     * <pre>
     * DB remark: ATM CPU上限，单位：GHz
     * DB column: atm_cpu_max	DECIMAL(14)	<--->	cpuMax	java.math.BigDecimal
     * DB is  Nullable: true
     * DB defaultValue: 0.0000
     * </pre>
     */
    @Column(name = "atm_cpu_max")
    private BigDecimal cpuMax;

    /**
     * <pre>
     * DB remark: ATM  CPU当前使用大小，单位：GHz
     * DB column: atm_cpu_current	DECIMAL(14)	<--->	cpuCurrent	java.math.BigDecimal
     * DB is  Nullable: true
     * DB defaultValue: 0.0000
     * </pre>
     */
    @Column(name = "atm_cpu_current")
    private BigDecimal cpuCurrent;

    /**
     * <pre>
     * DB remark: ATM 硬盘状态，状态 【以 ENABLE、DISABLE、BREAK】默认值:DISABLE
     * DB column: atm_disk_status	CHAR(30)	<--->	diskStatus	java.lang.String
     * DB is  Nullable: true
     * DB defaultValue: DISABLE
     * </pre>
     */
    @Length(max = 30, message = "{BANK_ATM_BEAN_DISK_STATUS_LENGTH}", groups = {IBaseValidGroup.Add.class, IBaseValidGroup.Update.class})
    @Column(name = "atm_disk_status")
    private String diskStatus;

    /**
     * <pre>
     * DB remark: ATM 硬盘上限，单位：M
     * DB column: atm_disk_max	DECIMAL(10)	<--->	diskMax	java.math.BigDecimal
     * DB is  Nullable: true
     * DB defaultValue: 0.0000
     * </pre>
     */
    @Column(name = "atm_disk_max")
    private BigDecimal diskMax;

    /**
     * <pre>
     * DB remark: ATM 硬盘当前使用大小，单位：M
     * DB column: atm_disk_current	DECIMAL(10)	<--->	diskCurrent	java.math.BigDecimal
     * DB is  Nullable: true
     * DB defaultValue: 0.0000
     * </pre>
     */
    @Column(name = "atm_disk_current")
    private BigDecimal diskCurrent;

    /**
     * <pre>
     * DB remark: ATM，安全门，状态 【以 ENABLE、DISABLE、BREAK】默认值:DISABLE
     * DB column: atm_safe_door_status	CHAR(30)	<--->	safeDoorStatus	java.lang.String
     * DB is  Nullable: true
     * DB defaultValue: DISABLE
     * </pre>
     */
    @Length(max = 30, message = "{BANK_ATM_BEAN_SAFE_DOOR_STATUS_LENGTH}", groups = {IBaseValidGroup.Add.class, IBaseValidGroup.Update.class})
    @Column(name = "atm_safe_door_status")
    private String safeDoorStatus;

    /**
     * <pre>
     * DB remark: ATM，安全门，错误码 【以 ENABLE、DISABLE、BREAK】默认值:DISABLE
     * DB column: atm_safe_door_error_code	CHAR(10)	<--->	safeDoorErrorCode	java.lang.String
     * DB is  Nullable: true
     * DB defaultValue: 00000
     * </pre>
     */
    @Length(max = 10, message = "{BANK_ATM_BEAN_SAFE_DOOR_ERROR_CODE_LENGTH}", groups = {IBaseValidGroup.Add.class, IBaseValidGroup.Update.class})
    @Column(name = "atm_safe_door_error_code")
    private String safeDoorErrorCode;

    /**
     * <pre>
     * DB remark: ATM，安全门，错误描述 【以 ENABLE、DISABLE、BREAK】默认值:DISABLE
     * DB column: atm_safe_door_description	CHAR(100)	<--->	safeDoorDescription	java.lang.String
     * DB is  Nullable: true
     * DB defaultValue: 
     * </pre>
     */
    @Length(max = 100, message = "{BANK_ATM_BEAN_SAFE_DOOR_DESCRIPTION_LENGTH}", groups = {IBaseValidGroup.Add.class, IBaseValidGroup.Update.class})
    @Column(name = "atm_safe_door_description")
    private String safeDoorDescription;

    /**
     * <pre>
     * DB remark: ATM，ups电源，状态 【以 ENABLE、DISABLE、BREAK】默认值:DISABLE
     * DB column: atm_ups_status	CHAR(30)	<--->	upsStatus	java.lang.String
     * DB is  Nullable: true
     * DB defaultValue: DISABLE
     * </pre>
     */
    @Length(max = 30, message = "{BANK_ATM_BEAN_UPS_STATUS_LENGTH}", groups = {IBaseValidGroup.Add.class, IBaseValidGroup.Update.class})
    @Column(name = "atm_ups_status")
    private String upsStatus;

    /**
     * <pre>
     * DB remark: ATM，卡，状态 【以 ENABLE、DISABLE、BREAK】默认值:DISABLE
     * DB column: atm_card_status	CHAR(30)	<--->	cardStatus	java.lang.String
     * DB is  Nullable: true
     * DB defaultValue: DISABLE
     * </pre>
     */
    @Length(max = 30, message = "{BANK_ATM_BEAN_CARD_STATUS_LENGTH}", groups = {IBaseValidGroup.Add.class, IBaseValidGroup.Update.class})
    @Column(name = "atm_card_status")
    private String cardStatus;

    /**
     * <pre>
     * DB remark: ATM，IC 卡，状态 【以 ENABLE、DISABLE、BREAK】默认值:DISABLE
     * DB column: atm_iccard_status	CHAR(30)	<--->	iccardStatus	java.lang.String
     * DB is  Nullable: true
     * DB defaultValue: DISABLE
     * </pre>
     */
    @Length(max = 30, message = "{BANK_ATM_BEAN_ICCARD_STATUS_LENGTH}", groups = {IBaseValidGroup.Add.class, IBaseValidGroup.Update.class})
    @Column(name = "atm_iccard_status")
    private String iccardStatus;

    /**
     * <pre>
     * DB remark: ATM，电子门，状态 【以 ENABLE、DISABLE、BREAK】默认值:DISABLE
     * DB column: atm_edoor_status	CHAR(30)	<--->	edoorStatus	java.lang.String
     * DB is  Nullable: true
     * DB defaultValue: DISABLE
     * </pre>
     */
    @Length(max = 30, message = "{BANK_ATM_BEAN_EDOOR_STATUS_LENGTH}", groups = {IBaseValidGroup.Add.class, IBaseValidGroup.Update.class})
    @Column(name = "atm_edoor_status")
    private String edoorStatus;

    /**
     * <pre>
     * DB remark: ATM，信封，状态 【以 ENABLE、DISABLE、BREAK】默认值:DISABLE
     * DB column: atm_envelope_status	CHAR(30)	<--->	envelopeStatus	java.lang.String
     * DB is  Nullable: true
     * DB defaultValue: DISABLE
     * </pre>
     */
    @Length(max = 30, message = "{BANK_ATM_BEAN_ENVELOPE_STATUS_LENGTH}", groups = {IBaseValidGroup.Add.class, IBaseValidGroup.Update.class})
    @Column(name = "atm_envelope_status")
    private String envelopeStatus;

    /**
     * <pre>
     * DB remark: ATM，日志，状态 【以 ENABLE、DISABLE、BREAK】默认值:DISABLE
     * DB column: atm_journal_status	CHAR(30)	<--->	journalStatus	java.lang.String
     * DB is  Nullable: true
     * DB defaultValue: DISABLE
     * </pre>
     */
    @Length(max = 30, message = "{BANK_ATM_BEAN_JOURNAL_STATUS_LENGTH}", groups = {IBaseValidGroup.Add.class, IBaseValidGroup.Update.class})
    @Column(name = "atm_journal_status")
    private String journalStatus;

    /**
     * <pre>
     * DB remark: ATM，发票，状态 【以 ENABLE、DISABLE、BREAK】默认值:DISABLE
     * DB column: atm_invoice_status	CHAR(30)	<--->	invoiceStatus	java.lang.String
     * DB is  Nullable: true
     * DB defaultValue: DISABLE
     * </pre>
     */
    @Length(max = 30, message = "{BANK_ATM_BEAN_INVOICE_STATUS_LENGTH}", groups = {IBaseValidGroup.Add.class, IBaseValidGroup.Update.class})
    @Column(name = "atm_invoice_status")
    private String invoiceStatus;

    /**
     * <pre>
     * DB remark: ATM，leftdeposit，状态 【以 ENABLE、DISABLE、BREAK】默认值:DISABLE
     * DB column: atm_left_deposit_status	CHAR(30)	<--->	leftDepositStatus	java.lang.String
     * DB is  Nullable: true
     * DB defaultValue: DISABLE
     * </pre>
     */
    @Length(max = 30, message = "{BANK_ATM_BEAN_LEFT_DEPOSIT_STATUS_LENGTH}", groups = {IBaseValidGroup.Add.class, IBaseValidGroup.Update.class})
    @Column(name = "atm_left_deposit_status")
    private String leftDepositStatus;

    /**
     * <pre>
     * DB remark: ATM，存款，状态 【以 ENABLE、DISABLE、BREAK】默认值:DISABLE
     * DB column: atm_deposit_status	CHAR(30)	<--->	depositStatus	java.lang.String
     * DB is  Nullable: true
     * DB defaultValue: DISABLE
     * </pre>
     */
    @Length(max = 30, message = "{BANK_ATM_BEAN_DEPOSIT_STATUS_LENGTH}", groups = {IBaseValidGroup.Add.class, IBaseValidGroup.Update.class})
    @Column(name = "atm_deposit_status")
    private String depositStatus;

    /**
     * <pre>
     * DB remark: ATM，票据打印机，状态 【以 ENABLE、DISABLE、BREAK】默认值:DISABLE
     * DB column: atm_receipt_printer_status	CHAR(30)	<--->	receiptPrinterStatus	java.lang.String
     * DB is  Nullable: true
     * DB defaultValue: DISABLE
     * </pre>
     */
    @Length(max = 30, message = "{BANK_ATM_BEAN_RECEIPT_PRINTER_STATUS_LENGTH}", groups = {IBaseValidGroup.Add.class, IBaseValidGroup.Update.class})
    @Column(name = "atm_receipt_printer_status")
    private String receiptPrinterStatus;

    /**
     * <pre>
     * DB remark: ATM，票据打印机，错误码 【以 ENABLE、DISABLE、BREAK】默认值:DISABLE
     * DB column: atm_receipt_printer_error_code	CHAR(10)	<--->	receiptPrinterErrorCode	java.lang.String
     * DB is  Nullable: true
     * DB defaultValue: 00000
     * </pre>
     */
    @Length(max = 10, message = "{BANK_ATM_BEAN_RECEIPT_PRINTER_ERROR_CODE_LENGTH}", groups = {IBaseValidGroup.Add.class, IBaseValidGroup.Update.class})
    @Column(name = "atm_receipt_printer_error_code")
    private String receiptPrinterErrorCode;

    /**
     * <pre>
     * DB remark: ATM，票据打印机，错误描述 【以 ENABLE、DISABLE、BREAK】默认值:DISABLE
     * DB column: atm_receipt_printer_description	CHAR(100)	<--->	receiptPrinterDescription	java.lang.String
     * DB is  Nullable: true
     * DB defaultValue: 
     * </pre>
     */
    @Length(max = 100, message = "{BANK_ATM_BEAN_RECEIPT_PRINTER_DESCRIPTION_LENGTH}", groups = {IBaseValidGroup.Add.class, IBaseValidGroup.Update.class})
    @Column(name = "atm_receipt_printer_description")
    private String receiptPrinterDescription;

    /**
     * <pre>
     * DB remark: ATM，现金检验设备，状态 【以 ENABLE、DISABLE、BREAK】默认值:DISABLE
     * DB column: atm_cash_acceptance_status	CHAR(30)	<--->	cashAcceptanceStatus	java.lang.String
     * DB is  Nullable: true
     * DB defaultValue: DISABLE
     * </pre>
     */
    @Length(max = 30, message = "{BANK_ATM_BEAN_CASH_ACCEPTANCE_STATUS_LENGTH}", groups = {IBaseValidGroup.Add.class, IBaseValidGroup.Update.class})
    @Column(name = "atm_cash_acceptance_status")
    private String cashAcceptanceStatus;

    /**
     * <pre>
     * DB remark: ATM，现金检验设备，错误码 【以 ENABLE、DISABLE、BREAK】默认值:DISABLE
     * DB column: atm_cash_acceptance_error_code	CHAR(10)	<--->	cashAcceptanceErrorCode	java.lang.String
     * DB is  Nullable: true
     * DB defaultValue: 00000
     * </pre>
     */
    @Length(max = 10, message = "{BANK_ATM_BEAN_CASH_ACCEPTANCE_ERROR_CODE_LENGTH}", groups = {IBaseValidGroup.Add.class, IBaseValidGroup.Update.class})
    @Column(name = "atm_cash_acceptance_error_code")
    private String cashAcceptanceErrorCode;

    /**
     * <pre>
     * DB remark: ATM，现金检验设备，错误描述 【以 ENABLE、DISABLE、BREAK】默认值:DISABLE
     * DB column: atm_cash_acceptance_description	CHAR(100)	<--->	cashAcceptanceDescription	java.lang.String
     * DB is  Nullable: true
     * DB defaultValue: 
     * </pre>
     */
    @Length(max = 100, message = "{BANK_ATM_BEAN_CASH_ACCEPTANCE_DESCRIPTION_LENGTH}", groups = {IBaseValidGroup.Add.class, IBaseValidGroup.Update.class})
    @Column(name = "atm_cash_acceptance_description")
    private String cashAcceptanceDescription;

    /**
     * <pre>
     * DB remark: ATM，自动取款设备，状态 【以 ENABLE、DISABLE、BREAK】默认值:DISABLE
     * DB column: atm_cash_dispenser_status	CHAR(30)	<--->	cashDispenserStatus	java.lang.String
     * DB is  Nullable: true
     * DB defaultValue: DISABLE
     * </pre>
     */
    @Length(max = 30, message = "{BANK_ATM_BEAN_CASH_DISPENSER_STATUS_LENGTH}", groups = {IBaseValidGroup.Add.class, IBaseValidGroup.Update.class})
    @Column(name = "atm_cash_dispenser_status")
    private String cashDispenserStatus;

    /**
     * <pre>
     * DB remark: ATM，自动取款设备，错误码 【以 ENABLE、DISABLE、BREAK】默认值:DISABLE
     * DB column: atm_cash_dispenser_error_code	CHAR(10)	<--->	cashDispenserErrorCode	java.lang.String
     * DB is  Nullable: true
     * DB defaultValue: 00000
     * </pre>
     */
    @Length(max = 10, message = "{BANK_ATM_BEAN_CASH_DISPENSER_ERROR_CODE_LENGTH}", groups = {IBaseValidGroup.Add.class, IBaseValidGroup.Update.class})
    @Column(name = "atm_cash_dispenser_error_code")
    private String cashDispenserErrorCode;

    /**
     * <pre>
     * DB remark: ATM，自动取款设备，错误描述 【以 ENABLE、DISABLE、BREAK】默认值:DISABLE
     * DB column: atm_cash_dispenser_description	CHAR(100)	<--->	cashDispenserDescription	java.lang.String
     * DB is  Nullable: true
     * DB defaultValue: 
     * </pre>
     */
    @Length(max = 100, message = "{BANK_ATM_BEAN_CASH_DISPENSER_DESCRIPTION_LENGTH}", groups = {IBaseValidGroup.Add.class, IBaseValidGroup.Update.class})
    @Column(name = "atm_cash_dispenser_description")
    private String cashDispenserDescription;

    /**
     * <pre>
     * DB remark: ATM，钱箱1，文本ID
     * DB column: atm_money_box_1_id	CHAR(14)	<--->	moneyBox1Id	java.lang.String
     * DB is  Nullable: true
     * DB defaultValue: null
     * </pre>
     */
    @Length(max = 14, message = "{BANK_ATM_BEAN_MONEY_BOX1_ID_LENGTH}", groups = {IBaseValidGroup.Add.class, IBaseValidGroup.Update.class})
    @Column(name = "atm_money_box_1_id")
    private String moneyBox1Id;

    /**
     * <pre>
     * DB remark: ATM，钱箱1，状态 【以 ENABLE、DISABLE、BREAK】默认值:DISABLE
     * DB column: atm_money_box_1_status	CHAR(30)	<--->	moneyBox1Status	java.lang.String
     * DB is  Nullable: true
     * DB defaultValue: DISABLE
     * </pre>
     */
    @Length(max = 30, message = "{BANK_ATM_BEAN_MONEY_BOX1_STATUS_LENGTH}", groups = {IBaseValidGroup.Add.class, IBaseValidGroup.Update.class})
    @Column(name = "atm_money_box_1_status")
    private String moneyBox1Status;

    /**
     * <pre>
     * DB remark: ATM，钱箱1，金额上限
     * DB column: atm_money_box_1_max_amount	DECIMAL(14)	<--->	moneyBox1MaxAmount	java.math.BigDecimal
     * DB is  Nullable: true
     * DB defaultValue: 0.0000
     * </pre>
     */
    @Column(name = "atm_money_box_1_max_amount")
    private BigDecimal moneyBox1MaxAmount;

    /**
     * <pre>
     * DB remark: ATM，钱箱1，当前金额
     * DB column: atm_money_box_1_current_amount	DECIMAL(14)	<--->	moneyBox1CurrentAmount	java.math.BigDecimal
     * DB is  Nullable: true
     * DB defaultValue: 0.0000
     * </pre>
     */
    @Column(name = "atm_money_box_1_current_amount")
    private BigDecimal moneyBox1CurrentAmount;

    /**
     * <pre>
     * DB remark: ATM，钱箱1，当前纸币数量
     * DB column: atm_money_box_1_current_count	INTEGER(10)	<--->	moneyBox1CurrentCount	java.lang.Integer
     * DB is  Nullable: true
     * DB defaultValue: 0
     * </pre>
     */
    @ValidLength(max = 10, message = "{BANK_ATM_BEAN_MONEY_BOX1_CURRENT_COUNT_LENGTH}", groups = {IBaseValidGroup.Add.class, IBaseValidGroup.Update.class})
    @Column(name = "atm_money_box_1_current_count")
    private Integer moneyBox1CurrentCount;

    /**
     * <pre>
     * DB remark: ATM，钱箱1，纸币数量上限
     * DB column: atm_money_box_1_max_count	INTEGER(10)	<--->	moneyBox1MaxCount	java.lang.Integer
     * DB is  Nullable: true
     * DB defaultValue: 0
     * </pre>
     */
    @ValidLength(max = 10, message = "{BANK_ATM_BEAN_MONEY_BOX1_MAX_COUNT_LENGTH}", groups = {IBaseValidGroup.Add.class, IBaseValidGroup.Update.class})
    @Column(name = "atm_money_box_1_max_count")
    private Integer moneyBox1MaxCount;

    /**
     * <pre>
     * DB remark: ATM，钱箱1，单张纸币面值
     * DB column: atm_money_box_1_currency	DECIMAL(14)	<--->	moneyBox1Currency	java.math.BigDecimal
     * DB is  Nullable: true
     * DB defaultValue: 0.0000
     * </pre>
     */
    @Column(name = "atm_money_box_1_currency")
    private BigDecimal moneyBox1Currency;

    /**
     * <pre>
     * DB remark: ATM，钱箱1，纸币单位
     * DB column: atm_money_box_1_unit	CHAR(10)	<--->	moneyBox1Unit	java.lang.String
     * DB is  Nullable: true
     * DB defaultValue: null
     * </pre>
     */
    @Length(max = 10, message = "{BANK_ATM_BEAN_MONEY_BOX1_UNIT_LENGTH}", groups = {IBaseValidGroup.Add.class, IBaseValidGroup.Update.class})
    @Column(name = "atm_money_box_1_unit")
    private String moneyBox1Unit;

    /**
     * <pre>
     * DB remark: ATM，钱箱1，类型【存钱：DEPOSIT、取钱：WITHDRAW】
     * DB column: atm_money_box_1_type	CHAR(10)	<--->	moneyBox1Type	java.lang.String
     * DB is  Nullable: true
     * DB defaultValue: null
     * </pre>
     */
    @Length(max = 10, message = "{BANK_ATM_BEAN_MONEY_BOX1_TYPE_LENGTH}", groups = {IBaseValidGroup.Add.class, IBaseValidGroup.Update.class})
    @Column(name = "atm_money_box_1_type")
    private String moneyBox1Type;

    /**
     * <pre>
     * DB remark: ATM，钱箱2，文本ID
     * DB column: atm_money_box_2_id	CHAR(14)	<--->	moneyBox2Id	java.lang.String
     * DB is  Nullable: true
     * DB defaultValue: null
     * </pre>
     */
    @Length(max = 14, message = "{BANK_ATM_BEAN_MONEY_BOX2_ID_LENGTH}", groups = {IBaseValidGroup.Add.class, IBaseValidGroup.Update.class})
    @Column(name = "atm_money_box_2_id")
    private String moneyBox2Id;

    /**
     * <pre>
     * DB remark: ATM，钱箱2，状态 【以 ENABLE、DISABLE、BREAK】默认值:DISABLE
     * DB column: atm_money_box_2_status	CHAR(30)	<--->	moneyBox2Status	java.lang.String
     * DB is  Nullable: true
     * DB defaultValue: DISABLE
     * </pre>
     */
    @Length(max = 30, message = "{BANK_ATM_BEAN_MONEY_BOX2_STATUS_LENGTH}", groups = {IBaseValidGroup.Add.class, IBaseValidGroup.Update.class})
    @Column(name = "atm_money_box_2_status")
    private String moneyBox2Status;

    /**
     * <pre>
     * DB remark: ATM，钱箱2，金额上限
     * DB column: atm_money_box_2_max_amount	DECIMAL(14)	<--->	moneyBox2MaxAmount	java.math.BigDecimal
     * DB is  Nullable: true
     * DB defaultValue: 0.0000
     * </pre>
     */
    @Column(name = "atm_money_box_2_max_amount")
    private BigDecimal moneyBox2MaxAmount;

    /**
     * <pre>
     * DB remark: ATM，钱箱2，当前金额
     * DB column: atm_money_box_2_current_amount	DECIMAL(14)	<--->	moneyBox2CurrentAmount	java.math.BigDecimal
     * DB is  Nullable: true
     * DB defaultValue: 0.0000
     * </pre>
     */
    @Column(name = "atm_money_box_2_current_amount")
    private BigDecimal moneyBox2CurrentAmount;

    /**
     * <pre>
     * DB remark: ATM，钱箱2，当前纸币数量
     * DB column: atm_money_box_2_current_count	INTEGER(10)	<--->	moneyBox2CurrentCount	java.lang.Integer
     * DB is  Nullable: true
     * DB defaultValue: 0
     * </pre>
     */
    @ValidLength(max = 10, message = "{BANK_ATM_BEAN_MONEY_BOX2_CURRENT_COUNT_LENGTH}", groups = {IBaseValidGroup.Add.class, IBaseValidGroup.Update.class})
    @Column(name = "atm_money_box_2_current_count")
    private Integer moneyBox2CurrentCount;

    /**
     * <pre>
     * DB remark: ATM，钱箱2，纸币数量上限
     * DB column: atm_money_box_2_max_count	INTEGER(10)	<--->	moneyBox2MaxCount	java.lang.Integer
     * DB is  Nullable: true
     * DB defaultValue: 0
     * </pre>
     */
    @ValidLength(max = 10, message = "{BANK_ATM_BEAN_MONEY_BOX2_MAX_COUNT_LENGTH}", groups = {IBaseValidGroup.Add.class, IBaseValidGroup.Update.class})
    @Column(name = "atm_money_box_2_max_count")
    private Integer moneyBox2MaxCount;

    /**
     * <pre>
     * DB remark: ATM，钱箱2，单张纸币面值
     * DB column: atm_money_box_2_currency	DECIMAL(14)	<--->	moneyBox2Currency	java.math.BigDecimal
     * DB is  Nullable: true
     * DB defaultValue: 0.0000
     * </pre>
     */
    @Column(name = "atm_money_box_2_currency")
    private BigDecimal moneyBox2Currency;

    /**
     * <pre>
     * DB remark: ATM，钱箱2，纸币单位
     * DB column: atm_money_box_2_unit	CHAR(10)	<--->	moneyBox2Unit	java.lang.String
     * DB is  Nullable: true
     * DB defaultValue: null
     * </pre>
     */
    @Length(max = 10, message = "{BANK_ATM_BEAN_MONEY_BOX2_UNIT_LENGTH}", groups = {IBaseValidGroup.Add.class, IBaseValidGroup.Update.class})
    @Column(name = "atm_money_box_2_unit")
    private String moneyBox2Unit;

    /**
     * <pre>
     * DB remark: ATM，钱箱2，类型【存钱：DEPOSIT、取钱：WITHDRAW】
     * DB column: atm_money_box_2_type	CHAR(10)	<--->	moneyBox2Type	java.lang.String
     * DB is  Nullable: true
     * DB defaultValue: null
     * </pre>
     */
    @Length(max = 10, message = "{BANK_ATM_BEAN_MONEY_BOX2_TYPE_LENGTH}", groups = {IBaseValidGroup.Add.class, IBaseValidGroup.Update.class})
    @Column(name = "atm_money_box_2_type")
    private String moneyBox2Type;

    /**
     * <pre>
     * DB remark: ATM，钱箱3，文本ID
     * DB column: atm_money_box_3_id	CHAR(14)	<--->	moneyBox3Id	java.lang.String
     * DB is  Nullable: true
     * DB defaultValue: null
     * </pre>
     */
    @Length(max = 14, message = "{BANK_ATM_BEAN_MONEY_BOX3_ID_LENGTH}", groups = {IBaseValidGroup.Add.class, IBaseValidGroup.Update.class})
    @Column(name = "atm_money_box_3_id")
    private String moneyBox3Id;

    /**
     * <pre>
     * DB remark: ATM，钱箱3，状态 【以 ENABLE、DISABLE、BREAK】默认值:DISABLE
     * DB column: atm_money_box_3_status	CHAR(30)	<--->	moneyBox3Status	java.lang.String
     * DB is  Nullable: true
     * DB defaultValue: DISABLE
     * </pre>
     */
    @Length(max = 30, message = "{BANK_ATM_BEAN_MONEY_BOX3_STATUS_LENGTH}", groups = {IBaseValidGroup.Add.class, IBaseValidGroup.Update.class})
    @Column(name = "atm_money_box_3_status")
    private String moneyBox3Status;

    /**
     * <pre>
     * DB remark: ATM，钱箱3，金额上限
     * DB column: atm_money_box_3_max_amount	DECIMAL(14)	<--->	moneyBox3MaxAmount	java.math.BigDecimal
     * DB is  Nullable: true
     * DB defaultValue: 0.0000
     * </pre>
     */
    @Column(name = "atm_money_box_3_max_amount")
    private BigDecimal moneyBox3MaxAmount;

    /**
     * <pre>
     * DB remark: ATM，钱箱3，当前金额
     * DB column: atm_money_box_3_current_amount	DECIMAL(14)	<--->	moneyBox3CurrentAmount	java.math.BigDecimal
     * DB is  Nullable: true
     * DB defaultValue: 0.0000
     * </pre>
     */
    @Column(name = "atm_money_box_3_current_amount")
    private BigDecimal moneyBox3CurrentAmount;

    /**
     * <pre>
     * DB remark: ATM，钱箱3，当前纸币数量
     * DB column: atm_money_box_3_current_count	INTEGER(10)	<--->	moneyBox3CurrentCount	java.lang.Integer
     * DB is  Nullable: true
     * DB defaultValue: 0
     * </pre>
     */
    @ValidLength(max = 10, message = "{BANK_ATM_BEAN_MONEY_BOX3_CURRENT_COUNT_LENGTH}", groups = {IBaseValidGroup.Add.class, IBaseValidGroup.Update.class})
    @Column(name = "atm_money_box_3_current_count")
    private Integer moneyBox3CurrentCount;

    /**
     * <pre>
     * DB remark: ATM，钱箱3，纸币数量上限
     * DB column: atm_money_box_3_max_count	INTEGER(10)	<--->	moneyBox3MaxCount	java.lang.Integer
     * DB is  Nullable: true
     * DB defaultValue: 0
     * </pre>
     */
    @ValidLength(max = 10, message = "{BANK_ATM_BEAN_MONEY_BOX3_MAX_COUNT_LENGTH}", groups = {IBaseValidGroup.Add.class, IBaseValidGroup.Update.class})
    @Column(name = "atm_money_box_3_max_count")
    private Integer moneyBox3MaxCount;

    /**
     * <pre>
     * DB remark: ATM，钱箱3，单张纸币面值
     * DB column: atm_money_box_3_currency	DECIMAL(14)	<--->	moneyBox3Currency	java.math.BigDecimal
     * DB is  Nullable: true
     * DB defaultValue: 0.0000
     * </pre>
     */
    @Column(name = "atm_money_box_3_currency")
    private BigDecimal moneyBox3Currency;

    /**
     * <pre>
     * DB remark: ATM，钱箱3，纸币单位
     * DB column: atm_money_box_3_unit	CHAR(10)	<--->	moneyBox3Unit	java.lang.String
     * DB is  Nullable: true
     * DB defaultValue: null
     * </pre>
     */
    @Length(max = 10, message = "{BANK_ATM_BEAN_MONEY_BOX3_UNIT_LENGTH}", groups = {IBaseValidGroup.Add.class, IBaseValidGroup.Update.class})
    @Column(name = "atm_money_box_3_unit")
    private String moneyBox3Unit;

    /**
     * <pre>
     * DB remark: ATM，钱箱3，类型【存钱：DEPOSIT、取钱：WITHDRAW】
     * DB column: atm_money_box_3_type	CHAR(10)	<--->	moneyBox3Type	java.lang.String
     * DB is  Nullable: true
     * DB defaultValue: null
     * </pre>
     */
    @Length(max = 10, message = "{BANK_ATM_BEAN_MONEY_BOX3_TYPE_LENGTH}", groups = {IBaseValidGroup.Add.class, IBaseValidGroup.Update.class})
    @Column(name = "atm_money_box_3_type")
    private String moneyBox3Type;

    /**
     * <pre>
     * DB remark: ATM，钱箱4，文本ID
     * DB column: atm_money_box_4_id	CHAR(14)	<--->	moneyBox4Id	java.lang.String
     * DB is  Nullable: true
     * DB defaultValue: null
     * </pre>
     */
    @Length(max = 14, message = "{BANK_ATM_BEAN_MONEY_BOX4_ID_LENGTH}", groups = {IBaseValidGroup.Add.class, IBaseValidGroup.Update.class})
    @Column(name = "atm_money_box_4_id")
    private String moneyBox4Id;

    /**
     * <pre>
     * DB remark: ATM，钱箱4，状态 【以 ENABLE、DISABLE、BREAK】默认值:DISABLE
     * DB column: atm_money_box_4_status	CHAR(30)	<--->	moneyBox4Status	java.lang.String
     * DB is  Nullable: true
     * DB defaultValue: DISABLE
     * </pre>
     */
    @Length(max = 30, message = "{BANK_ATM_BEAN_MONEY_BOX4_STATUS_LENGTH}", groups = {IBaseValidGroup.Add.class, IBaseValidGroup.Update.class})
    @Column(name = "atm_money_box_4_status")
    private String moneyBox4Status;

    /**
     * <pre>
     * DB remark: ATM，钱箱4，金额上限
     * DB column: atm_money_box_4_max_amount	DECIMAL(14)	<--->	moneyBox4MaxAmount	java.math.BigDecimal
     * DB is  Nullable: true
     * DB defaultValue: 0.0000
     * </pre>
     */
    @Column(name = "atm_money_box_4_max_amount")
    private BigDecimal moneyBox4MaxAmount;

    /**
     * <pre>
     * DB remark: ATM，钱箱4，当前金额
     * DB column: atm_money_box_4_current_amount	DECIMAL(14)	<--->	moneyBox4CurrentAmount	java.math.BigDecimal
     * DB is  Nullable: true
     * DB defaultValue: 0.0000
     * </pre>
     */
    @Column(name = "atm_money_box_4_current_amount")
    private BigDecimal moneyBox4CurrentAmount;

    /**
     * <pre>
     * DB remark: ATM，钱箱4，当前纸币数量
     * DB column: atm_money_box_4_current_count	INTEGER(10)	<--->	moneyBox4CurrentCount	java.lang.Integer
     * DB is  Nullable: true
     * DB defaultValue: 0
     * </pre>
     */
    @ValidLength(max = 10, message = "{BANK_ATM_BEAN_MONEY_BOX4_CURRENT_COUNT_LENGTH}", groups = {IBaseValidGroup.Add.class, IBaseValidGroup.Update.class})
    @Column(name = "atm_money_box_4_current_count")
    private Integer moneyBox4CurrentCount;

    /**
     * <pre>
     * DB remark: ATM，钱箱4，纸币数量上限
     * DB column: atm_money_box_4_max_count	INTEGER(10)	<--->	moneyBox4MaxCount	java.lang.Integer
     * DB is  Nullable: true
     * DB defaultValue: 0
     * </pre>
     */
    @ValidLength(max = 10, message = "{BANK_ATM_BEAN_MONEY_BOX4_MAX_COUNT_LENGTH}", groups = {IBaseValidGroup.Add.class, IBaseValidGroup.Update.class})
    @Column(name = "atm_money_box_4_max_count")
    private Integer moneyBox4MaxCount;

    /**
     * <pre>
     * DB remark: ATM，钱箱4，单张纸币面值
     * DB column: atm_money_box_4_currency	DECIMAL(14)	<--->	moneyBox4Currency	java.math.BigDecimal
     * DB is  Nullable: true
     * DB defaultValue: 0.0000
     * </pre>
     */
    @Column(name = "atm_money_box_4_currency")
    private BigDecimal moneyBox4Currency;

    /**
     * <pre>
     * DB remark: ATM，钱箱4，纸币单位
     * DB column: atm_money_box_4_unit	CHAR(10)	<--->	moneyBox4Unit	java.lang.String
     * DB is  Nullable: true
     * DB defaultValue: null
     * </pre>
     */
    @Length(max = 10, message = "{BANK_ATM_BEAN_MONEY_BOX4_UNIT_LENGTH}", groups = {IBaseValidGroup.Add.class, IBaseValidGroup.Update.class})
    @Column(name = "atm_money_box_4_unit")
    private String moneyBox4Unit;

    /**
     * <pre>
     * DB remark: ATM，钱箱4，类型【存钱：DEPOSIT、取钱：WITHDRAW】
     * DB column: atm_money_box_4_type	CHAR(10)	<--->	moneyBox4Type	java.lang.String
     * DB is  Nullable: true
     * DB defaultValue: null
     * </pre>
     */
    @Length(max = 10, message = "{BANK_ATM_BEAN_MONEY_BOX4_TYPE_LENGTH}", groups = {IBaseValidGroup.Add.class, IBaseValidGroup.Update.class})
    @Column(name = "atm_money_box_4_type")
    private String moneyBox4Type;

    /**
     * <pre>
     * DB remark: ATM，钱箱5，文本ID
     * DB column: atm_money_box_5_id	CHAR(14)	<--->	moneyBox5Id	java.lang.String
     * DB is  Nullable: true
     * DB defaultValue: null
     * </pre>
     */
    @Length(max = 14, message = "{BANK_ATM_BEAN_MONEY_BOX5_ID_LENGTH}", groups = {IBaseValidGroup.Add.class, IBaseValidGroup.Update.class})
    @Column(name = "atm_money_box_5_id")
    private String moneyBox5Id;

    /**
     * <pre>
     * DB remark: ATM，钱箱5，状态 【以 ENABLE、DISABLE、BREAK】默认值:DISABLE
     * DB column: atm_money_box_5_status	CHAR(30)	<--->	moneyBox5Status	java.lang.String
     * DB is  Nullable: true
     * DB defaultValue: DISABLE
     * </pre>
     */
    @Length(max = 30, message = "{BANK_ATM_BEAN_MONEY_BOX5_STATUS_LENGTH}", groups = {IBaseValidGroup.Add.class, IBaseValidGroup.Update.class})
    @Column(name = "atm_money_box_5_status")
    private String moneyBox5Status;

    /**
     * <pre>
     * DB remark: ATM，钱箱5，金额上限
     * DB column: atm_money_box_5_max_amount	DECIMAL(14)	<--->	moneyBox5MaxAmount	java.math.BigDecimal
     * DB is  Nullable: true
     * DB defaultValue: 0.0000
     * </pre>
     */
    @Column(name = "atm_money_box_5_max_amount")
    private BigDecimal moneyBox5MaxAmount;

    /**
     * <pre>
     * DB remark: ATM，钱箱5，当前金额
     * DB column: atm_money_box_5_current_amount	DECIMAL(14)	<--->	moneyBox5CurrentAmount	java.math.BigDecimal
     * DB is  Nullable: true
     * DB defaultValue: 0.0000
     * </pre>
     */
    @Column(name = "atm_money_box_5_current_amount")
    private BigDecimal moneyBox5CurrentAmount;

    /**
     * <pre>
     * DB remark: ATM，钱箱5，当前纸币数量
     * DB column: atm_money_box_5_current_count	INTEGER(10)	<--->	moneyBox5CurrentCount	java.lang.Integer
     * DB is  Nullable: true
     * DB defaultValue: 0
     * </pre>
     */
    @ValidLength(max = 10, message = "{BANK_ATM_BEAN_MONEY_BOX5_CURRENT_COUNT_LENGTH}", groups = {IBaseValidGroup.Add.class, IBaseValidGroup.Update.class})
    @Column(name = "atm_money_box_5_current_count")
    private Integer moneyBox5CurrentCount;

    /**
     * <pre>
     * DB remark: ATM，钱箱5，纸币数量上限
     * DB column: atm_money_box_5_max_count	INTEGER(10)	<--->	moneyBox5MaxCount	java.lang.Integer
     * DB is  Nullable: true
     * DB defaultValue: 0
     * </pre>
     */
    @ValidLength(max = 10, message = "{BANK_ATM_BEAN_MONEY_BOX5_MAX_COUNT_LENGTH}", groups = {IBaseValidGroup.Add.class, IBaseValidGroup.Update.class})
    @Column(name = "atm_money_box_5_max_count")
    private Integer moneyBox5MaxCount;

    /**
     * <pre>
     * DB remark: ATM，钱箱5，单张纸币面值
     * DB column: atm_money_box_5_currency	DECIMAL(14)	<--->	moneyBox5Currency	java.math.BigDecimal
     * DB is  Nullable: true
     * DB defaultValue: 0.0000
     * </pre>
     */
    @Column(name = "atm_money_box_5_currency")
    private BigDecimal moneyBox5Currency;

    /**
     * <pre>
     * DB remark: ATM，钱箱5，纸币单位
     * DB column: atm_money_box_5_unit	CHAR(10)	<--->	moneyBox5Unit	java.lang.String
     * DB is  Nullable: true
     * DB defaultValue: null
     * </pre>
     */
    @Length(max = 10, message = "{BANK_ATM_BEAN_MONEY_BOX5_UNIT_LENGTH}", groups = {IBaseValidGroup.Add.class, IBaseValidGroup.Update.class})
    @Column(name = "atm_money_box_5_unit")
    private String moneyBox5Unit;

    /**
     * <pre>
     * DB remark: ATM，钱箱5，类型【存钱：DEPOSIT、取钱：WITHDRAW】
     * DB column: atm_money_box_5_type	CHAR(10)	<--->	moneyBox5Type	java.lang.String
     * DB is  Nullable: true
     * DB defaultValue: null
     * </pre>
     */
    @Length(max = 10, message = "{BANK_ATM_BEAN_MONEY_BOX5_TYPE_LENGTH}", groups = {IBaseValidGroup.Add.class, IBaseValidGroup.Update.class})
    @Column(name = "atm_money_box_5_type")
    private String moneyBox5Type;

    /**
     * <pre>
     * DB remark: ATM,获取数据的时间戳字段,类型:DateTime(yyyy-MM-dd HH:mm:ss)
     * DB column: atm_upload_timestamp	TIMESTAMP(19)	<--->	uploadTimestamp	java.util.Date
     * DB is  Nullable: false
     * DB defaultValue: null
     * </pre>
     */
    @ValidDateTimeFormat(pattern = DateUtil.DATE_PATTERN_YYYY_MM_DD_HH_MM_SS , message = "{BANK_ATM_BEAN_UPLOAD_TIMESTAMP_DATE_TIME_FORMAT}", groups = {IBaseValidGroup.Add.class, IBaseValidGroup.Update.class})
    @DateTimeFormat(pattern = DateUtil.DATE_PATTERN_YYYY_MM_DD_HH_MM_SS)
    @NotNull(message = "{BANK_ATM_BEAN_UPLOAD_TIMESTAMP_NOT_NULL}", groups = {IBaseValidGroup.Add.class, IBaseValidGroup.Update.class})
    @Column(name = "atm_upload_timestamp")
    private Date uploadTimestamp;

    /**
     * <pre>
     * DB remark: ATM（用户服务端portal端显示）整体状况：WARNING（告警，有故障）,DOWN（关机、失联）,REPAIR（维修中、长时间）,MAINTAIN（短时间维护中）,INSERVICE（正常服务）
     * DB column: atm_status	CHAR(32)	<--->	status	java.lang.String
     * DB is  Nullable: false
     * DB defaultValue: INSERVICE
     * </pre>
     */
    @NotBlank(message = "{BANK_ATM_BEAN_STATUS_NOT_BLANK}", groups = {IBaseValidGroup.Add.class, IBaseValidGroup.Update.class})
    @Length(max = 32, message = "{BANK_ATM_BEAN_STATUS_LENGTH}", groups = {IBaseValidGroup.Add.class, IBaseValidGroup.Update.class})
    @Column(name = "atm_status")
    private String status;

    /**
     * <pre>
     * DB remark: ATM客户端上传的整体状态码
     * DB column: atm_term_status	CHAR(32)	<--->	termStatus	java.lang.String
     * DB is  Nullable: true
     * DB defaultValue: null
     * </pre>
     */
    @Length(max = 32, message = "{BANK_ATM_BEAN_TERM_STATUS_LENGTH}", groups = {IBaseValidGroup.Add.class, IBaseValidGroup.Update.class})
    @Column(name = "atm_term_status")
    private String termStatus;

    /**
     * <pre>
     * DB remark: ATM心跳包上传的时间
     * DB column: atm_live_timestamp	TIMESTAMP(19)	<--->	liveTimestamp	java.util.Date
     * DB is  Nullable: true
     * DB defaultValue: null
     * </pre>
     */
    @ValidDateTimeFormat(pattern = DateUtil.DATE_PATTERN_YYYY_MM_DD_HH_MM_SS , message = "{BANK_ATM_BEAN_LIVE_TIMESTAMP_DATE_TIME_FORMAT}", groups = {IBaseValidGroup.Add.class, IBaseValidGroup.Update.class})
    @DateTimeFormat(pattern = DateUtil.DATE_PATTERN_YYYY_MM_DD_HH_MM_SS)
    @Column(name = "atm_live_timestamp")
    private Date liveTimestamp;

    /**
     * <pre>
     * DB remark: 创建时间
     * DB column: atm_create_timestamp	TIMESTAMP(19)	<--->	createTimestamp	java.util.Date
     * DB is  Nullable: false
     * DB defaultValue: CURRENT_TIMESTAMP
     * </pre>
     */
    @ValidDateTimeFormat(pattern = DateUtil.DATE_PATTERN_YYYY_MM_DD_HH_MM_SS , message = "{BANK_ATM_BEAN_CREATE_TIMESTAMP_DATE_TIME_FORMAT}", groups = {IBaseValidGroup.Add.class, IBaseValidGroup.Update.class})
    @DateTimeFormat(pattern = DateUtil.DATE_PATTERN_YYYY_MM_DD_HH_MM_SS)
    @NotNull(message = "{BANK_ATM_BEAN_CREATE_TIMESTAMP_NOT_NULL}", groups = {IBaseValidGroup.Add.class, IBaseValidGroup.Update.class})
    @Column(name = "atm_create_timestamp")
    private Date createTimestamp;

    /**
     * <pre>
     * DB remark: 创建人
     * DB column: atm_create_by	VARCHAR(20)	<--->	createBy	java.lang.String
     * DB is  Nullable: false
     * DB defaultValue: null
     * </pre>
     */
    @NotBlank(message = "{BANK_ATM_BEAN_CREATE_BY_NOT_BLANK}", groups = {IBaseValidGroup.Add.class, IBaseValidGroup.Update.class})
    @Length(max = 20, message = "{BANK_ATM_BEAN_CREATE_BY_LENGTH}", groups = {IBaseValidGroup.Add.class, IBaseValidGroup.Update.class})
    @Column(name = "atm_create_by")
    private String createBy;

    /**
     * <pre>
     * DB remark: 更新人ID与t_user.user_id和t_crew.crew_id关联,0代表系统自动执行
     * DB column: atm_operator_id	BIGINT(20)	<--->	operatorId	java.lang.Long
     * DB is  Nullable: false
     * DB defaultValue: null
     * </pre>
     */
    @NotNull(message = "{BANK_ATM_BEAN_OPERATOR_ID_NOT_NULL}", groups = {IBaseValidGroup.Add.class, IBaseValidGroup.Update.class})
    @ValidLength(max = 20, message = "{BANK_ATM_BEAN_OPERATOR_ID_LENGTH}", groups = {IBaseValidGroup.Add.class, IBaseValidGroup.Update.class})
    @Column(name = "atm_operator_id")
    private Long operatorId;

    /**
     * <pre>
     * DB remark: 更新人用户名与t_user.user_name和t_crew.crew_name关联,system代表系统自动执行
     * DB column: atm_operator_name	VARCHAR(20)	<--->	operatorName	java.lang.String
     * DB is  Nullable: false
     * DB defaultValue: null
     * </pre>
     */
    @NotBlank(message = "{BANK_ATM_BEAN_OPERATOR_NAME_NOT_BLANK}", groups = {IBaseValidGroup.Add.class, IBaseValidGroup.Update.class})
    @Length(max = 20, message = "{BANK_ATM_BEAN_OPERATOR_NAME_LENGTH}", groups = {IBaseValidGroup.Add.class, IBaseValidGroup.Update.class})
    @Column(name = "atm_operator_name")
    private String operatorName;

    /**
     * <pre>
     * DB remark: 逻辑删除标志【N[正常]，Y[删除]】
     * DB column: atm_delete_flag	CHAR(1)	<--->	deleteFlag	java.lang.String
     * DB is  Nullable: false
     * DB defaultValue: N
     * </pre>
     */
    @NotBlank(message = "{BANK_ATM_BEAN_DELETE_FLAG_NOT_BLANK}", groups = {IBaseValidGroup.Add.class, IBaseValidGroup.Update.class})
    @Length(max = 1, message = "{BANK_ATM_BEAN_DELETE_FLAG_LENGTH}", groups = {IBaseValidGroup.Add.class, IBaseValidGroup.Update.class})
    @Column(name = "atm_delete_flag")
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
    public BankAtmBean setId(Long id) {
        this.id = id;
        return this;
    }

    /**
     * 获取 ATM对应,客户ID,与 t_client.client_id 字段关联
     *
     * @return atm_client_id - ATM对应,客户ID,与 t_client.client_id 字段关联
     */
    public Long getClientId() {
        return clientId;
    }

    /**
     * 设置 ATM对应,客户ID,与 t_client.client_id 字段关联
     *
     * @param clientId - ATM对应,客户ID,与 t_client.client_id 字段关联
     */
    public BankAtmBean setClientId(Long clientId) {
        this.clientId = clientId;
        return this;
    }

    /**
     * 获取 ATM对应,客户名称,与 t_client.client_name 字段冗余
     *
     * @return atm_client_name - ATM对应,客户名称,与 t_client.client_name 字段冗余
     */
    public String getClientName() {
        return clientName;
    }

    /**
     * 设置 ATM对应,客户名称,与 t_client.client_name 字段冗余
     *
     * @param clientName - ATM对应,客户名称,与 t_client.client_name 字段冗余
     */
    public BankAtmBean setClientName(String clientName) {
        this.clientName = clientName == null ? null : clientName.trim();
        return this;
    }

    /**
     * 获取 ATM对应,网点ID,与 t_client_branch.branch_id 字段关联
     *
     * @return atm_branch_id - ATM对应,网点ID,与 t_client_branch.branch_id 字段关联
     */
    public Long getBranchId() {
        return branchId;
    }

    /**
     * 设置 ATM对应,网点ID,与 t_client_branch.branch_id 字段关联
     *
     * @param branchId - ATM对应,网点ID,与 t_client_branch.branch_id 字段关联
     */
    public BankAtmBean setBranchId(Long branchId) {
        this.branchId = branchId;
        return this;
    }

    /**
     * 获取 ATM对应,网点名称,与 t_client_branch.branch_name 字段冗余
     *
     * @return atm_branch_name - ATM对应,网点名称,与 t_client_branch.branch_name 字段冗余
     */
    public String getBranchName() {
        return branchName;
    }

    /**
     * 设置 ATM对应,网点名称,与 t_client_branch.branch_name 字段冗余
     *
     * @param branchName - ATM对应,网点名称,与 t_client_branch.branch_name 字段冗余
     */
    public BankAtmBean setBranchName(String branchName) {
        this.branchName = branchName == null ? null : branchName.trim();
        return this;
    }

    /**
     * 获取 ATM对应使用的Ip地址
     *
     * @return atm_ip - ATM对应使用的Ip地址
     */
    public String getIp() {
        return ip;
    }

    /**
     * 设置 ATM对应使用的Ip地址
     *
     * @param ip - ATM对应使用的Ip地址
     */
    public BankAtmBean setIp(String ip) {
        this.ip = ip == null ? null : ip.trim();
        return this;
    }

    /**
     * 获取 ATM的机型号
     *
     * @return atm_model - ATM的机型号
     */
    public String getModel() {
        return model;
    }

    /**
     * 设置 ATM的机型号
     *
     * @param model - ATM的机型号
     */
    public BankAtmBean setModel(String model) {
        this.model = model == null ? null : model.trim();
        return this;
    }

    /**
     * 获取 ATM机的供应商
     *
     * @return atm_vendor - ATM机的供应商
     */
    public String getVendor() {
        return vendor;
    }

    /**
     * 设置 ATM机的供应商
     *
     * @param vendor - ATM机的供应商
     */
    public BankAtmBean setVendor(String vendor) {
        this.vendor = vendor == null ? null : vendor.trim();
        return this;
    }

    /**
     * 获取 地址
     *
     * @return atm_address - 地址
     */
    public String getAddress() {
        return address;
    }

    /**
     * 设置 地址
     *
     * @param address - 地址
     */
    public BankAtmBean setAddress(String address) {
        this.address = address == null ? null : address.trim();
        return this;
    }

    /**
     * 获取 ATM需维修时的关联的taskId
     *
     * @return atm_task_id - ATM需维修时的关联的taskId
     */
    public Long getTaskId() {
        return taskId;
    }

    /**
     * 设置 ATM需维修时的关联的taskId
     *
     * @param taskId - ATM需维修时的关联的taskId
     */
    public BankAtmBean setTaskId(Long taskId) {
        this.taskId = taskId;
        return this;
    }

    /**
     * 获取 ATMATM类型：DEPOSIT,RECYCLE,ATM
     *
     * @return atm_type - ATMATM类型：DEPOSIT,RECYCLE,ATM
     */
    public String getType() {
        return type;
    }

    /**
     * 设置 ATMATM类型：DEPOSIT,RECYCLE,ATM
     *
     * @param type - ATMATM类型：DEPOSIT,RECYCLE,ATM
     */
    public BankAtmBean setType(String type) {
        this.type = type == null ? null : type.trim();
        return this;
    }

    /**
     * 获取 坐标纬度,浮点型
     *
     * @return atm_latitude - 坐标纬度,浮点型
     */
    public String getLatitude() {
        return latitude;
    }

    /**
     * 设置 坐标纬度,浮点型
     *
     * @param latitude - 坐标纬度,浮点型
     */
    public BankAtmBean setLatitude(String latitude) {
        this.latitude = latitude == null ? null : latitude.trim();
        return this;
    }

    /**
     * 获取 坐标经度,浮点型
     *
     * @return atm_longitude - 坐标经度,浮点型
     */
    public String getLongitude() {
        return longitude;
    }

    /**
     * 设置 坐标经度,浮点型
     *
     * @param longitude - 坐标经度,浮点型
     */
    public BankAtmBean setLongitude(String longitude) {
        this.longitude = longitude == null ? null : longitude.trim();
        return this;
    }

    /**
     * 获取 ATM内部编号,与t_crew.crew_internal_id冗余
     *
     * @return atm_internal_id - ATM内部编号,与t_crew.crew_internal_id冗余
     */
    public String getInternalId() {
        return internalId;
    }

    /**
     * 设置 ATM内部编号,与t_crew.crew_internal_id冗余
     *
     * @param internalId - ATM内部编号,与t_crew.crew_internal_id冗余
     */
    public BankAtmBean setInternalId(String internalId) {
        this.internalId = internalId == null ? null : internalId.trim();
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
    public BankAtmBean setExternalId(String externalId) {
        this.externalId = externalId == null ? null : externalId.trim();
        return this;
    }

    /**
     * 获取 ATM内存状态，状态 【以 ENABLE、DISABLE、BREAK】默认值:DISABLE
     *
     * @return atm_ram_status - ATM内存状态，状态 【以 ENABLE、DISABLE、BREAK】默认值:DISABLE
     */
    public String getRamStatus() {
        return ramStatus;
    }

    /**
     * 设置 ATM内存状态，状态 【以 ENABLE、DISABLE、BREAK】默认值:DISABLE
     *
     * @param ramStatus - ATM内存状态，状态 【以 ENABLE、DISABLE、BREAK】默认值:DISABLE
     */
    public BankAtmBean setRamStatus(String ramStatus) {
        this.ramStatus = ramStatus == null ? null : ramStatus.trim();
        return this;
    }

    /**
     * 获取 ATM内存上限，单位：M
     *
     * @return atm_ram_max - ATM内存上限，单位：M
     */
    public BigDecimal getRamMax() {
        return ramMax;
    }

    /**
     * 设置 ATM内存上限，单位：M
     *
     * @param ramMax - ATM内存上限，单位：M
     */
    public BankAtmBean setRamMax(BigDecimal ramMax) {
        this.ramMax = ramMax;
        return this;
    }

    /**
     * 获取 ATM内存当前使用大小，单位：M
     *
     * @return atm_ram_current - ATM内存当前使用大小，单位：M
     */
    public BigDecimal getRamCurrent() {
        return ramCurrent;
    }

    /**
     * 设置 ATM内存当前使用大小，单位：M
     *
     * @param ramCurrent - ATM内存当前使用大小，单位：M
     */
    public BankAtmBean setRamCurrent(BigDecimal ramCurrent) {
        this.ramCurrent = ramCurrent;
        return this;
    }

    /**
     * 获取 ATM CPU状态，状态 【以 ENABLE、DISABLE、BREAK】默认值:DISABLE
     *
     * @return atm_cpu_status - ATM CPU状态，状态 【以 ENABLE、DISABLE、BREAK】默认值:DISABLE
     */
    public String getCpuStatus() {
        return cpuStatus;
    }

    /**
     * 设置 ATM CPU状态，状态 【以 ENABLE、DISABLE、BREAK】默认值:DISABLE
     *
     * @param cpuStatus - ATM CPU状态，状态 【以 ENABLE、DISABLE、BREAK】默认值:DISABLE
     */
    public BankAtmBean setCpuStatus(String cpuStatus) {
        this.cpuStatus = cpuStatus == null ? null : cpuStatus.trim();
        return this;
    }

    /**
     * 获取 ATM CPU上限，单位：GHz
     *
     * @return atm_cpu_max - ATM CPU上限，单位：GHz
     */
    public BigDecimal getCpuMax() {
        return cpuMax;
    }

    /**
     * 设置 ATM CPU上限，单位：GHz
     *
     * @param cpuMax - ATM CPU上限，单位：GHz
     */
    public BankAtmBean setCpuMax(BigDecimal cpuMax) {
        this.cpuMax = cpuMax;
        return this;
    }

    /**
     * 获取 ATM  CPU当前使用大小，单位：GHz
     *
     * @return atm_cpu_current - ATM  CPU当前使用大小，单位：GHz
     */
    public BigDecimal getCpuCurrent() {
        return cpuCurrent;
    }

    /**
     * 设置 ATM  CPU当前使用大小，单位：GHz
     *
     * @param cpuCurrent - ATM  CPU当前使用大小，单位：GHz
     */
    public BankAtmBean setCpuCurrent(BigDecimal cpuCurrent) {
        this.cpuCurrent = cpuCurrent;
        return this;
    }

    /**
     * 获取 ATM 硬盘状态，状态 【以 ENABLE、DISABLE、BREAK】默认值:DISABLE
     *
     * @return atm_disk_status - ATM 硬盘状态，状态 【以 ENABLE、DISABLE、BREAK】默认值:DISABLE
     */
    public String getDiskStatus() {
        return diskStatus;
    }

    /**
     * 设置 ATM 硬盘状态，状态 【以 ENABLE、DISABLE、BREAK】默认值:DISABLE
     *
     * @param diskStatus - ATM 硬盘状态，状态 【以 ENABLE、DISABLE、BREAK】默认值:DISABLE
     */
    public BankAtmBean setDiskStatus(String diskStatus) {
        this.diskStatus = diskStatus == null ? null : diskStatus.trim();
        return this;
    }

    /**
     * 获取 ATM 硬盘上限，单位：M
     *
     * @return atm_disk_max - ATM 硬盘上限，单位：M
     */
    public BigDecimal getDiskMax() {
        return diskMax;
    }

    /**
     * 设置 ATM 硬盘上限，单位：M
     *
     * @param diskMax - ATM 硬盘上限，单位：M
     */
    public BankAtmBean setDiskMax(BigDecimal diskMax) {
        this.diskMax = diskMax;
        return this;
    }

    /**
     * 获取 ATM 硬盘当前使用大小，单位：M
     *
     * @return atm_disk_current - ATM 硬盘当前使用大小，单位：M
     */
    public BigDecimal getDiskCurrent() {
        return diskCurrent;
    }

    /**
     * 设置 ATM 硬盘当前使用大小，单位：M
     *
     * @param diskCurrent - ATM 硬盘当前使用大小，单位：M
     */
    public BankAtmBean setDiskCurrent(BigDecimal diskCurrent) {
        this.diskCurrent = diskCurrent;
        return this;
    }

    /**
     * 获取 ATM，安全门，状态 【以 ENABLE、DISABLE、BREAK】默认值:DISABLE
     *
     * @return atm_safe_door_status - ATM，安全门，状态 【以 ENABLE、DISABLE、BREAK】默认值:DISABLE
     */
    public String getSafeDoorStatus() {
        return safeDoorStatus;
    }

    /**
     * 设置 ATM，安全门，状态 【以 ENABLE、DISABLE、BREAK】默认值:DISABLE
     *
     * @param safeDoorStatus - ATM，安全门，状态 【以 ENABLE、DISABLE、BREAK】默认值:DISABLE
     */
    public BankAtmBean setSafeDoorStatus(String safeDoorStatus) {
        this.safeDoorStatus = safeDoorStatus == null ? null : safeDoorStatus.trim();
        return this;
    }

    /**
     * 获取 ATM，安全门，错误码 【以 ENABLE、DISABLE、BREAK】默认值:DISABLE
     *
     * @return atm_safe_door_error_code - ATM，安全门，错误码 【以 ENABLE、DISABLE、BREAK】默认值:DISABLE
     */
    public String getSafeDoorErrorCode() {
        return safeDoorErrorCode;
    }

    /**
     * 设置 ATM，安全门，错误码 【以 ENABLE、DISABLE、BREAK】默认值:DISABLE
     *
     * @param safeDoorErrorCode - ATM，安全门，错误码 【以 ENABLE、DISABLE、BREAK】默认值:DISABLE
     */
    public BankAtmBean setSafeDoorErrorCode(String safeDoorErrorCode) {
        this.safeDoorErrorCode = safeDoorErrorCode == null ? null : safeDoorErrorCode.trim();
        return this;
    }

    /**
     * 获取 ATM，安全门，错误描述 【以 ENABLE、DISABLE、BREAK】默认值:DISABLE
     *
     * @return atm_safe_door_description - ATM，安全门，错误描述 【以 ENABLE、DISABLE、BREAK】默认值:DISABLE
     */
    public String getSafeDoorDescription() {
        return safeDoorDescription;
    }

    /**
     * 设置 ATM，安全门，错误描述 【以 ENABLE、DISABLE、BREAK】默认值:DISABLE
     *
     * @param safeDoorDescription - ATM，安全门，错误描述 【以 ENABLE、DISABLE、BREAK】默认值:DISABLE
     */
    public BankAtmBean setSafeDoorDescription(String safeDoorDescription) {
        this.safeDoorDescription = safeDoorDescription == null ? null : safeDoorDescription.trim();
        return this;
    }

    /**
     * 获取 ATM，ups电源，状态 【以 ENABLE、DISABLE、BREAK】默认值:DISABLE
     *
     * @return atm_ups_status - ATM，ups电源，状态 【以 ENABLE、DISABLE、BREAK】默认值:DISABLE
     */
    public String getUpsStatus() {
        return upsStatus;
    }

    /**
     * 设置 ATM，ups电源，状态 【以 ENABLE、DISABLE、BREAK】默认值:DISABLE
     *
     * @param upsStatus - ATM，ups电源，状态 【以 ENABLE、DISABLE、BREAK】默认值:DISABLE
     */
    public BankAtmBean setUpsStatus(String upsStatus) {
        this.upsStatus = upsStatus == null ? null : upsStatus.trim();
        return this;
    }

    /**
     * 获取 ATM，卡，状态 【以 ENABLE、DISABLE、BREAK】默认值:DISABLE
     *
     * @return atm_card_status - ATM，卡，状态 【以 ENABLE、DISABLE、BREAK】默认值:DISABLE
     */
    public String getCardStatus() {
        return cardStatus;
    }

    /**
     * 设置 ATM，卡，状态 【以 ENABLE、DISABLE、BREAK】默认值:DISABLE
     *
     * @param cardStatus - ATM，卡，状态 【以 ENABLE、DISABLE、BREAK】默认值:DISABLE
     */
    public BankAtmBean setCardStatus(String cardStatus) {
        this.cardStatus = cardStatus == null ? null : cardStatus.trim();
        return this;
    }

    /**
     * 获取 ATM，IC 卡，状态 【以 ENABLE、DISABLE、BREAK】默认值:DISABLE
     *
     * @return atm_iccard_status - ATM，IC 卡，状态 【以 ENABLE、DISABLE、BREAK】默认值:DISABLE
     */
    public String getIccardStatus() {
        return iccardStatus;
    }

    /**
     * 设置 ATM，IC 卡，状态 【以 ENABLE、DISABLE、BREAK】默认值:DISABLE
     *
     * @param iccardStatus - ATM，IC 卡，状态 【以 ENABLE、DISABLE、BREAK】默认值:DISABLE
     */
    public BankAtmBean setIccardStatus(String iccardStatus) {
        this.iccardStatus = iccardStatus == null ? null : iccardStatus.trim();
        return this;
    }

    /**
     * 获取 ATM，电子门，状态 【以 ENABLE、DISABLE、BREAK】默认值:DISABLE
     *
     * @return atm_edoor_status - ATM，电子门，状态 【以 ENABLE、DISABLE、BREAK】默认值:DISABLE
     */
    public String getEdoorStatus() {
        return edoorStatus;
    }

    /**
     * 设置 ATM，电子门，状态 【以 ENABLE、DISABLE、BREAK】默认值:DISABLE
     *
     * @param edoorStatus - ATM，电子门，状态 【以 ENABLE、DISABLE、BREAK】默认值:DISABLE
     */
    public BankAtmBean setEdoorStatus(String edoorStatus) {
        this.edoorStatus = edoorStatus == null ? null : edoorStatus.trim();
        return this;
    }

    /**
     * 获取 ATM，信封，状态 【以 ENABLE、DISABLE、BREAK】默认值:DISABLE
     *
     * @return atm_envelope_status - ATM，信封，状态 【以 ENABLE、DISABLE、BREAK】默认值:DISABLE
     */
    public String getEnvelopeStatus() {
        return envelopeStatus;
    }

    /**
     * 设置 ATM，信封，状态 【以 ENABLE、DISABLE、BREAK】默认值:DISABLE
     *
     * @param envelopeStatus - ATM，信封，状态 【以 ENABLE、DISABLE、BREAK】默认值:DISABLE
     */
    public BankAtmBean setEnvelopeStatus(String envelopeStatus) {
        this.envelopeStatus = envelopeStatus == null ? null : envelopeStatus.trim();
        return this;
    }

    /**
     * 获取 ATM，日志，状态 【以 ENABLE、DISABLE、BREAK】默认值:DISABLE
     *
     * @return atm_journal_status - ATM，日志，状态 【以 ENABLE、DISABLE、BREAK】默认值:DISABLE
     */
    public String getJournalStatus() {
        return journalStatus;
    }

    /**
     * 设置 ATM，日志，状态 【以 ENABLE、DISABLE、BREAK】默认值:DISABLE
     *
     * @param journalStatus - ATM，日志，状态 【以 ENABLE、DISABLE、BREAK】默认值:DISABLE
     */
    public BankAtmBean setJournalStatus(String journalStatus) {
        this.journalStatus = journalStatus == null ? null : journalStatus.trim();
        return this;
    }

    /**
     * 获取 ATM，发票，状态 【以 ENABLE、DISABLE、BREAK】默认值:DISABLE
     *
     * @return atm_invoice_status - ATM，发票，状态 【以 ENABLE、DISABLE、BREAK】默认值:DISABLE
     */
    public String getInvoiceStatus() {
        return invoiceStatus;
    }

    /**
     * 设置 ATM，发票，状态 【以 ENABLE、DISABLE、BREAK】默认值:DISABLE
     *
     * @param invoiceStatus - ATM，发票，状态 【以 ENABLE、DISABLE、BREAK】默认值:DISABLE
     */
    public BankAtmBean setInvoiceStatus(String invoiceStatus) {
        this.invoiceStatus = invoiceStatus == null ? null : invoiceStatus.trim();
        return this;
    }

    /**
     * 获取 ATM，leftdeposit，状态 【以 ENABLE、DISABLE、BREAK】默认值:DISABLE
     *
     * @return atm_left_deposit_status - ATM，leftdeposit，状态 【以 ENABLE、DISABLE、BREAK】默认值:DISABLE
     */
    public String getLeftDepositStatus() {
        return leftDepositStatus;
    }

    /**
     * 设置 ATM，leftdeposit，状态 【以 ENABLE、DISABLE、BREAK】默认值:DISABLE
     *
     * @param leftDepositStatus - ATM，leftdeposit，状态 【以 ENABLE、DISABLE、BREAK】默认值:DISABLE
     */
    public BankAtmBean setLeftDepositStatus(String leftDepositStatus) {
        this.leftDepositStatus = leftDepositStatus == null ? null : leftDepositStatus.trim();
        return this;
    }

    /**
     * 获取 ATM，存款，状态 【以 ENABLE、DISABLE、BREAK】默认值:DISABLE
     *
     * @return atm_deposit_status - ATM，存款，状态 【以 ENABLE、DISABLE、BREAK】默认值:DISABLE
     */
    public String getDepositStatus() {
        return depositStatus;
    }

    /**
     * 设置 ATM，存款，状态 【以 ENABLE、DISABLE、BREAK】默认值:DISABLE
     *
     * @param depositStatus - ATM，存款，状态 【以 ENABLE、DISABLE、BREAK】默认值:DISABLE
     */
    public BankAtmBean setDepositStatus(String depositStatus) {
        this.depositStatus = depositStatus == null ? null : depositStatus.trim();
        return this;
    }

    /**
     * 获取 ATM，票据打印机，状态 【以 ENABLE、DISABLE、BREAK】默认值:DISABLE
     *
     * @return atm_receipt_printer_status - ATM，票据打印机，状态 【以 ENABLE、DISABLE、BREAK】默认值:DISABLE
     */
    public String getReceiptPrinterStatus() {
        return receiptPrinterStatus;
    }

    /**
     * 设置 ATM，票据打印机，状态 【以 ENABLE、DISABLE、BREAK】默认值:DISABLE
     *
     * @param receiptPrinterStatus - ATM，票据打印机，状态 【以 ENABLE、DISABLE、BREAK】默认值:DISABLE
     */
    public BankAtmBean setReceiptPrinterStatus(String receiptPrinterStatus) {
        this.receiptPrinterStatus = receiptPrinterStatus == null ? null : receiptPrinterStatus.trim();
        return this;
    }

    /**
     * 获取 ATM，票据打印机，错误码 【以 ENABLE、DISABLE、BREAK】默认值:DISABLE
     *
     * @return atm_receipt_printer_error_code - ATM，票据打印机，错误码 【以 ENABLE、DISABLE、BREAK】默认值:DISABLE
     */
    public String getReceiptPrinterErrorCode() {
        return receiptPrinterErrorCode;
    }

    /**
     * 设置 ATM，票据打印机，错误码 【以 ENABLE、DISABLE、BREAK】默认值:DISABLE
     *
     * @param receiptPrinterErrorCode - ATM，票据打印机，错误码 【以 ENABLE、DISABLE、BREAK】默认值:DISABLE
     */
    public BankAtmBean setReceiptPrinterErrorCode(String receiptPrinterErrorCode) {
        this.receiptPrinterErrorCode = receiptPrinterErrorCode == null ? null : receiptPrinterErrorCode.trim();
        return this;
    }

    /**
     * 获取 ATM，票据打印机，错误描述 【以 ENABLE、DISABLE、BREAK】默认值:DISABLE
     *
     * @return atm_receipt_printer_description - ATM，票据打印机，错误描述 【以 ENABLE、DISABLE、BREAK】默认值:DISABLE
     */
    public String getReceiptPrinterDescription() {
        return receiptPrinterDescription;
    }

    /**
     * 设置 ATM，票据打印机，错误描述 【以 ENABLE、DISABLE、BREAK】默认值:DISABLE
     *
     * @param receiptPrinterDescription - ATM，票据打印机，错误描述 【以 ENABLE、DISABLE、BREAK】默认值:DISABLE
     */
    public BankAtmBean setReceiptPrinterDescription(String receiptPrinterDescription) {
        this.receiptPrinterDescription = receiptPrinterDescription == null ? null : receiptPrinterDescription.trim();
        return this;
    }

    /**
     * 获取 ATM，现金检验设备，状态 【以 ENABLE、DISABLE、BREAK】默认值:DISABLE
     *
     * @return atm_cash_acceptance_status - ATM，现金检验设备，状态 【以 ENABLE、DISABLE、BREAK】默认值:DISABLE
     */
    public String getCashAcceptanceStatus() {
        return cashAcceptanceStatus;
    }

    /**
     * 设置 ATM，现金检验设备，状态 【以 ENABLE、DISABLE、BREAK】默认值:DISABLE
     *
     * @param cashAcceptanceStatus - ATM，现金检验设备，状态 【以 ENABLE、DISABLE、BREAK】默认值:DISABLE
     */
    public BankAtmBean setCashAcceptanceStatus(String cashAcceptanceStatus) {
        this.cashAcceptanceStatus = cashAcceptanceStatus == null ? null : cashAcceptanceStatus.trim();
        return this;
    }

    /**
     * 获取 ATM，现金检验设备，错误码 【以 ENABLE、DISABLE、BREAK】默认值:DISABLE
     *
     * @return atm_cash_acceptance_error_code - ATM，现金检验设备，错误码 【以 ENABLE、DISABLE、BREAK】默认值:DISABLE
     */
    public String getCashAcceptanceErrorCode() {
        return cashAcceptanceErrorCode;
    }

    /**
     * 设置 ATM，现金检验设备，错误码 【以 ENABLE、DISABLE、BREAK】默认值:DISABLE
     *
     * @param cashAcceptanceErrorCode - ATM，现金检验设备，错误码 【以 ENABLE、DISABLE、BREAK】默认值:DISABLE
     */
    public BankAtmBean setCashAcceptanceErrorCode(String cashAcceptanceErrorCode) {
        this.cashAcceptanceErrorCode = cashAcceptanceErrorCode == null ? null : cashAcceptanceErrorCode.trim();
        return this;
    }

    /**
     * 获取 ATM，现金检验设备，错误描述 【以 ENABLE、DISABLE、BREAK】默认值:DISABLE
     *
     * @return atm_cash_acceptance_description - ATM，现金检验设备，错误描述 【以 ENABLE、DISABLE、BREAK】默认值:DISABLE
     */
    public String getCashAcceptanceDescription() {
        return cashAcceptanceDescription;
    }

    /**
     * 设置 ATM，现金检验设备，错误描述 【以 ENABLE、DISABLE、BREAK】默认值:DISABLE
     *
     * @param cashAcceptanceDescription - ATM，现金检验设备，错误描述 【以 ENABLE、DISABLE、BREAK】默认值:DISABLE
     */
    public BankAtmBean setCashAcceptanceDescription(String cashAcceptanceDescription) {
        this.cashAcceptanceDescription = cashAcceptanceDescription == null ? null : cashAcceptanceDescription.trim();
        return this;
    }

    /**
     * 获取 ATM，自动取款设备，状态 【以 ENABLE、DISABLE、BREAK】默认值:DISABLE
     *
     * @return atm_cash_dispenser_status - ATM，自动取款设备，状态 【以 ENABLE、DISABLE、BREAK】默认值:DISABLE
     */
    public String getCashDispenserStatus() {
        return cashDispenserStatus;
    }

    /**
     * 设置 ATM，自动取款设备，状态 【以 ENABLE、DISABLE、BREAK】默认值:DISABLE
     *
     * @param cashDispenserStatus - ATM，自动取款设备，状态 【以 ENABLE、DISABLE、BREAK】默认值:DISABLE
     */
    public BankAtmBean setCashDispenserStatus(String cashDispenserStatus) {
        this.cashDispenserStatus = cashDispenserStatus == null ? null : cashDispenserStatus.trim();
        return this;
    }

    /**
     * 获取 ATM，自动取款设备，错误码 【以 ENABLE、DISABLE、BREAK】默认值:DISABLE
     *
     * @return atm_cash_dispenser_error_code - ATM，自动取款设备，错误码 【以 ENABLE、DISABLE、BREAK】默认值:DISABLE
     */
    public String getCashDispenserErrorCode() {
        return cashDispenserErrorCode;
    }

    /**
     * 设置 ATM，自动取款设备，错误码 【以 ENABLE、DISABLE、BREAK】默认值:DISABLE
     *
     * @param cashDispenserErrorCode - ATM，自动取款设备，错误码 【以 ENABLE、DISABLE、BREAK】默认值:DISABLE
     */
    public BankAtmBean setCashDispenserErrorCode(String cashDispenserErrorCode) {
        this.cashDispenserErrorCode = cashDispenserErrorCode == null ? null : cashDispenserErrorCode.trim();
        return this;
    }

    /**
     * 获取 ATM，自动取款设备，错误描述 【以 ENABLE、DISABLE、BREAK】默认值:DISABLE
     *
     * @return atm_cash_dispenser_description - ATM，自动取款设备，错误描述 【以 ENABLE、DISABLE、BREAK】默认值:DISABLE
     */
    public String getCashDispenserDescription() {
        return cashDispenserDescription;
    }

    /**
     * 设置 ATM，自动取款设备，错误描述 【以 ENABLE、DISABLE、BREAK】默认值:DISABLE
     *
     * @param cashDispenserDescription - ATM，自动取款设备，错误描述 【以 ENABLE、DISABLE、BREAK】默认值:DISABLE
     */
    public BankAtmBean setCashDispenserDescription(String cashDispenserDescription) {
        this.cashDispenserDescription = cashDispenserDescription == null ? null : cashDispenserDescription.trim();
        return this;
    }

    /**
     * 获取 ATM，钱箱1，文本ID
     *
     * @return atm_money_box_1_id - ATM，钱箱1，文本ID
     */
    public String getMoneyBox1Id() {
        return moneyBox1Id;
    }

    /**
     * 设置 ATM，钱箱1，文本ID
     *
     * @param moneyBox1Id - ATM，钱箱1，文本ID
     */
    public BankAtmBean setMoneyBox1Id(String moneyBox1Id) {
        this.moneyBox1Id = moneyBox1Id == null ? null : moneyBox1Id.trim();
        return this;
    }

    /**
     * 获取 ATM，钱箱1，状态 【以 ENABLE、DISABLE、BREAK】默认值:DISABLE
     *
     * @return atm_money_box_1_status - ATM，钱箱1，状态 【以 ENABLE、DISABLE、BREAK】默认值:DISABLE
     */
    public String getMoneyBox1Status() {
        return moneyBox1Status;
    }

    /**
     * 设置 ATM，钱箱1，状态 【以 ENABLE、DISABLE、BREAK】默认值:DISABLE
     *
     * @param moneyBox1Status - ATM，钱箱1，状态 【以 ENABLE、DISABLE、BREAK】默认值:DISABLE
     */
    public BankAtmBean setMoneyBox1Status(String moneyBox1Status) {
        this.moneyBox1Status = moneyBox1Status == null ? null : moneyBox1Status.trim();
        return this;
    }

    /**
     * 获取 ATM，钱箱1，金额上限
     *
     * @return atm_money_box_1_max_amount - ATM，钱箱1，金额上限
     */
    public BigDecimal getMoneyBox1MaxAmount() {
        return moneyBox1MaxAmount;
    }

    /**
     * 设置 ATM，钱箱1，金额上限
     *
     * @param moneyBox1MaxAmount - ATM，钱箱1，金额上限
     */
    public BankAtmBean setMoneyBox1MaxAmount(BigDecimal moneyBox1MaxAmount) {
        this.moneyBox1MaxAmount = moneyBox1MaxAmount;
        return this;
    }

    /**
     * 获取 ATM，钱箱1，当前金额
     *
     * @return atm_money_box_1_current_amount - ATM，钱箱1，当前金额
     */
    public BigDecimal getMoneyBox1CurrentAmount() {
        return moneyBox1CurrentAmount;
    }

    /**
     * 设置 ATM，钱箱1，当前金额
     *
     * @param moneyBox1CurrentAmount - ATM，钱箱1，当前金额
     */
    public BankAtmBean setMoneyBox1CurrentAmount(BigDecimal moneyBox1CurrentAmount) {
        this.moneyBox1CurrentAmount = moneyBox1CurrentAmount;
        return this;
    }

    /**
     * 获取 ATM，钱箱1，当前纸币数量
     *
     * @return atm_money_box_1_current_count - ATM，钱箱1，当前纸币数量
     */
    public Integer getMoneyBox1CurrentCount() {
        return moneyBox1CurrentCount;
    }

    /**
     * 设置 ATM，钱箱1，当前纸币数量
     *
     * @param moneyBox1CurrentCount - ATM，钱箱1，当前纸币数量
     */
    public BankAtmBean setMoneyBox1CurrentCount(Integer moneyBox1CurrentCount) {
        this.moneyBox1CurrentCount = moneyBox1CurrentCount;
        return this;
    }

    /**
     * 获取 ATM，钱箱1，纸币数量上限
     *
     * @return atm_money_box_1_max_count - ATM，钱箱1，纸币数量上限
     */
    public Integer getMoneyBox1MaxCount() {
        return moneyBox1MaxCount;
    }

    /**
     * 设置 ATM，钱箱1，纸币数量上限
     *
     * @param moneyBox1MaxCount - ATM，钱箱1，纸币数量上限
     */
    public BankAtmBean setMoneyBox1MaxCount(Integer moneyBox1MaxCount) {
        this.moneyBox1MaxCount = moneyBox1MaxCount;
        return this;
    }

    /**
     * 获取 ATM，钱箱1，单张纸币面值
     *
     * @return atm_money_box_1_currency - ATM，钱箱1，单张纸币面值
     */
    public BigDecimal getMoneyBox1Currency() {
        return moneyBox1Currency;
    }

    /**
     * 设置 ATM，钱箱1，单张纸币面值
     *
     * @param moneyBox1Currency - ATM，钱箱1，单张纸币面值
     */
    public BankAtmBean setMoneyBox1Currency(BigDecimal moneyBox1Currency) {
        this.moneyBox1Currency = moneyBox1Currency;
        return this;
    }

    /**
     * 获取 ATM，钱箱1，纸币单位
     *
     * @return atm_money_box_1_unit - ATM，钱箱1，纸币单位
     */
    public String getMoneyBox1Unit() {
        return moneyBox1Unit;
    }

    /**
     * 设置 ATM，钱箱1，纸币单位
     *
     * @param moneyBox1Unit - ATM，钱箱1，纸币单位
     */
    public BankAtmBean setMoneyBox1Unit(String moneyBox1Unit) {
        this.moneyBox1Unit = moneyBox1Unit == null ? null : moneyBox1Unit.trim();
        return this;
    }

    /**
     * 获取 ATM，钱箱1，类型【存钱：DEPOSIT、取钱：WITHDRAW】
     *
     * @return atm_money_box_1_type - ATM，钱箱1，类型【存钱：DEPOSIT、取钱：WITHDRAW】
     */
    public String getMoneyBox1Type() {
        return moneyBox1Type;
    }

    /**
     * 设置 ATM，钱箱1，类型【存钱：DEPOSIT、取钱：WITHDRAW】
     *
     * @param moneyBox1Type - ATM，钱箱1，类型【存钱：DEPOSIT、取钱：WITHDRAW】
     */
    public BankAtmBean setMoneyBox1Type(String moneyBox1Type) {
        this.moneyBox1Type = moneyBox1Type == null ? null : moneyBox1Type.trim();
        return this;
    }

    /**
     * 获取 ATM，钱箱2，文本ID
     *
     * @return atm_money_box_2_id - ATM，钱箱2，文本ID
     */
    public String getMoneyBox2Id() {
        return moneyBox2Id;
    }

    /**
     * 设置 ATM，钱箱2，文本ID
     *
     * @param moneyBox2Id - ATM，钱箱2，文本ID
     */
    public BankAtmBean setMoneyBox2Id(String moneyBox2Id) {
        this.moneyBox2Id = moneyBox2Id == null ? null : moneyBox2Id.trim();
        return this;
    }

    /**
     * 获取 ATM，钱箱2，状态 【以 ENABLE、DISABLE、BREAK】默认值:DISABLE
     *
     * @return atm_money_box_2_status - ATM，钱箱2，状态 【以 ENABLE、DISABLE、BREAK】默认值:DISABLE
     */
    public String getMoneyBox2Status() {
        return moneyBox2Status;
    }

    /**
     * 设置 ATM，钱箱2，状态 【以 ENABLE、DISABLE、BREAK】默认值:DISABLE
     *
     * @param moneyBox2Status - ATM，钱箱2，状态 【以 ENABLE、DISABLE、BREAK】默认值:DISABLE
     */
    public BankAtmBean setMoneyBox2Status(String moneyBox2Status) {
        this.moneyBox2Status = moneyBox2Status == null ? null : moneyBox2Status.trim();
        return this;
    }

    /**
     * 获取 ATM，钱箱2，金额上限
     *
     * @return atm_money_box_2_max_amount - ATM，钱箱2，金额上限
     */
    public BigDecimal getMoneyBox2MaxAmount() {
        return moneyBox2MaxAmount;
    }

    /**
     * 设置 ATM，钱箱2，金额上限
     *
     * @param moneyBox2MaxAmount - ATM，钱箱2，金额上限
     */
    public BankAtmBean setMoneyBox2MaxAmount(BigDecimal moneyBox2MaxAmount) {
        this.moneyBox2MaxAmount = moneyBox2MaxAmount;
        return this;
    }

    /**
     * 获取 ATM，钱箱2，当前金额
     *
     * @return atm_money_box_2_current_amount - ATM，钱箱2，当前金额
     */
    public BigDecimal getMoneyBox2CurrentAmount() {
        return moneyBox2CurrentAmount;
    }

    /**
     * 设置 ATM，钱箱2，当前金额
     *
     * @param moneyBox2CurrentAmount - ATM，钱箱2，当前金额
     */
    public BankAtmBean setMoneyBox2CurrentAmount(BigDecimal moneyBox2CurrentAmount) {
        this.moneyBox2CurrentAmount = moneyBox2CurrentAmount;
        return this;
    }

    /**
     * 获取 ATM，钱箱2，当前纸币数量
     *
     * @return atm_money_box_2_current_count - ATM，钱箱2，当前纸币数量
     */
    public Integer getMoneyBox2CurrentCount() {
        return moneyBox2CurrentCount;
    }

    /**
     * 设置 ATM，钱箱2，当前纸币数量
     *
     * @param moneyBox2CurrentCount - ATM，钱箱2，当前纸币数量
     */
    public BankAtmBean setMoneyBox2CurrentCount(Integer moneyBox2CurrentCount) {
        this.moneyBox2CurrentCount = moneyBox2CurrentCount;
        return this;
    }

    /**
     * 获取 ATM，钱箱2，纸币数量上限
     *
     * @return atm_money_box_2_max_count - ATM，钱箱2，纸币数量上限
     */
    public Integer getMoneyBox2MaxCount() {
        return moneyBox2MaxCount;
    }

    /**
     * 设置 ATM，钱箱2，纸币数量上限
     *
     * @param moneyBox2MaxCount - ATM，钱箱2，纸币数量上限
     */
    public BankAtmBean setMoneyBox2MaxCount(Integer moneyBox2MaxCount) {
        this.moneyBox2MaxCount = moneyBox2MaxCount;
        return this;
    }

    /**
     * 获取 ATM，钱箱2，单张纸币面值
     *
     * @return atm_money_box_2_currency - ATM，钱箱2，单张纸币面值
     */
    public BigDecimal getMoneyBox2Currency() {
        return moneyBox2Currency;
    }

    /**
     * 设置 ATM，钱箱2，单张纸币面值
     *
     * @param moneyBox2Currency - ATM，钱箱2，单张纸币面值
     */
    public BankAtmBean setMoneyBox2Currency(BigDecimal moneyBox2Currency) {
        this.moneyBox2Currency = moneyBox2Currency;
        return this;
    }

    /**
     * 获取 ATM，钱箱2，纸币单位
     *
     * @return atm_money_box_2_unit - ATM，钱箱2，纸币单位
     */
    public String getMoneyBox2Unit() {
        return moneyBox2Unit;
    }

    /**
     * 设置 ATM，钱箱2，纸币单位
     *
     * @param moneyBox2Unit - ATM，钱箱2，纸币单位
     */
    public BankAtmBean setMoneyBox2Unit(String moneyBox2Unit) {
        this.moneyBox2Unit = moneyBox2Unit == null ? null : moneyBox2Unit.trim();
        return this;
    }

    /**
     * 获取 ATM，钱箱2，类型【存钱：DEPOSIT、取钱：WITHDRAW】
     *
     * @return atm_money_box_2_type - ATM，钱箱2，类型【存钱：DEPOSIT、取钱：WITHDRAW】
     */
    public String getMoneyBox2Type() {
        return moneyBox2Type;
    }

    /**
     * 设置 ATM，钱箱2，类型【存钱：DEPOSIT、取钱：WITHDRAW】
     *
     * @param moneyBox2Type - ATM，钱箱2，类型【存钱：DEPOSIT、取钱：WITHDRAW】
     */
    public BankAtmBean setMoneyBox2Type(String moneyBox2Type) {
        this.moneyBox2Type = moneyBox2Type == null ? null : moneyBox2Type.trim();
        return this;
    }

    /**
     * 获取 ATM，钱箱3，文本ID
     *
     * @return atm_money_box_3_id - ATM，钱箱3，文本ID
     */
    public String getMoneyBox3Id() {
        return moneyBox3Id;
    }

    /**
     * 设置 ATM，钱箱3，文本ID
     *
     * @param moneyBox3Id - ATM，钱箱3，文本ID
     */
    public BankAtmBean setMoneyBox3Id(String moneyBox3Id) {
        this.moneyBox3Id = moneyBox3Id == null ? null : moneyBox3Id.trim();
        return this;
    }

    /**
     * 获取 ATM，钱箱3，状态 【以 ENABLE、DISABLE、BREAK】默认值:DISABLE
     *
     * @return atm_money_box_3_status - ATM，钱箱3，状态 【以 ENABLE、DISABLE、BREAK】默认值:DISABLE
     */
    public String getMoneyBox3Status() {
        return moneyBox3Status;
    }

    /**
     * 设置 ATM，钱箱3，状态 【以 ENABLE、DISABLE、BREAK】默认值:DISABLE
     *
     * @param moneyBox3Status - ATM，钱箱3，状态 【以 ENABLE、DISABLE、BREAK】默认值:DISABLE
     */
    public BankAtmBean setMoneyBox3Status(String moneyBox3Status) {
        this.moneyBox3Status = moneyBox3Status == null ? null : moneyBox3Status.trim();
        return this;
    }

    /**
     * 获取 ATM，钱箱3，金额上限
     *
     * @return atm_money_box_3_max_amount - ATM，钱箱3，金额上限
     */
    public BigDecimal getMoneyBox3MaxAmount() {
        return moneyBox3MaxAmount;
    }

    /**
     * 设置 ATM，钱箱3，金额上限
     *
     * @param moneyBox3MaxAmount - ATM，钱箱3，金额上限
     */
    public BankAtmBean setMoneyBox3MaxAmount(BigDecimal moneyBox3MaxAmount) {
        this.moneyBox3MaxAmount = moneyBox3MaxAmount;
        return this;
    }

    /**
     * 获取 ATM，钱箱3，当前金额
     *
     * @return atm_money_box_3_current_amount - ATM，钱箱3，当前金额
     */
    public BigDecimal getMoneyBox3CurrentAmount() {
        return moneyBox3CurrentAmount;
    }

    /**
     * 设置 ATM，钱箱3，当前金额
     *
     * @param moneyBox3CurrentAmount - ATM，钱箱3，当前金额
     */
    public BankAtmBean setMoneyBox3CurrentAmount(BigDecimal moneyBox3CurrentAmount) {
        this.moneyBox3CurrentAmount = moneyBox3CurrentAmount;
        return this;
    }

    /**
     * 获取 ATM，钱箱3，当前纸币数量
     *
     * @return atm_money_box_3_current_count - ATM，钱箱3，当前纸币数量
     */
    public Integer getMoneyBox3CurrentCount() {
        return moneyBox3CurrentCount;
    }

    /**
     * 设置 ATM，钱箱3，当前纸币数量
     *
     * @param moneyBox3CurrentCount - ATM，钱箱3，当前纸币数量
     */
    public BankAtmBean setMoneyBox3CurrentCount(Integer moneyBox3CurrentCount) {
        this.moneyBox3CurrentCount = moneyBox3CurrentCount;
        return this;
    }

    /**
     * 获取 ATM，钱箱3，纸币数量上限
     *
     * @return atm_money_box_3_max_count - ATM，钱箱3，纸币数量上限
     */
    public Integer getMoneyBox3MaxCount() {
        return moneyBox3MaxCount;
    }

    /**
     * 设置 ATM，钱箱3，纸币数量上限
     *
     * @param moneyBox3MaxCount - ATM，钱箱3，纸币数量上限
     */
    public BankAtmBean setMoneyBox3MaxCount(Integer moneyBox3MaxCount) {
        this.moneyBox3MaxCount = moneyBox3MaxCount;
        return this;
    }

    /**
     * 获取 ATM，钱箱3，单张纸币面值
     *
     * @return atm_money_box_3_currency - ATM，钱箱3，单张纸币面值
     */
    public BigDecimal getMoneyBox3Currency() {
        return moneyBox3Currency;
    }

    /**
     * 设置 ATM，钱箱3，单张纸币面值
     *
     * @param moneyBox3Currency - ATM，钱箱3，单张纸币面值
     */
    public BankAtmBean setMoneyBox3Currency(BigDecimal moneyBox3Currency) {
        this.moneyBox3Currency = moneyBox3Currency;
        return this;
    }

    /**
     * 获取 ATM，钱箱3，纸币单位
     *
     * @return atm_money_box_3_unit - ATM，钱箱3，纸币单位
     */
    public String getMoneyBox3Unit() {
        return moneyBox3Unit;
    }

    /**
     * 设置 ATM，钱箱3，纸币单位
     *
     * @param moneyBox3Unit - ATM，钱箱3，纸币单位
     */
    public BankAtmBean setMoneyBox3Unit(String moneyBox3Unit) {
        this.moneyBox3Unit = moneyBox3Unit == null ? null : moneyBox3Unit.trim();
        return this;
    }

    /**
     * 获取 ATM，钱箱3，类型【存钱：DEPOSIT、取钱：WITHDRAW】
     *
     * @return atm_money_box_3_type - ATM，钱箱3，类型【存钱：DEPOSIT、取钱：WITHDRAW】
     */
    public String getMoneyBox3Type() {
        return moneyBox3Type;
    }

    /**
     * 设置 ATM，钱箱3，类型【存钱：DEPOSIT、取钱：WITHDRAW】
     *
     * @param moneyBox3Type - ATM，钱箱3，类型【存钱：DEPOSIT、取钱：WITHDRAW】
     */
    public BankAtmBean setMoneyBox3Type(String moneyBox3Type) {
        this.moneyBox3Type = moneyBox3Type == null ? null : moneyBox3Type.trim();
        return this;
    }

    /**
     * 获取 ATM，钱箱4，文本ID
     *
     * @return atm_money_box_4_id - ATM，钱箱4，文本ID
     */
    public String getMoneyBox4Id() {
        return moneyBox4Id;
    }

    /**
     * 设置 ATM，钱箱4，文本ID
     *
     * @param moneyBox4Id - ATM，钱箱4，文本ID
     */
    public BankAtmBean setMoneyBox4Id(String moneyBox4Id) {
        this.moneyBox4Id = moneyBox4Id == null ? null : moneyBox4Id.trim();
        return this;
    }

    /**
     * 获取 ATM，钱箱4，状态 【以 ENABLE、DISABLE、BREAK】默认值:DISABLE
     *
     * @return atm_money_box_4_status - ATM，钱箱4，状态 【以 ENABLE、DISABLE、BREAK】默认值:DISABLE
     */
    public String getMoneyBox4Status() {
        return moneyBox4Status;
    }

    /**
     * 设置 ATM，钱箱4，状态 【以 ENABLE、DISABLE、BREAK】默认值:DISABLE
     *
     * @param moneyBox4Status - ATM，钱箱4，状态 【以 ENABLE、DISABLE、BREAK】默认值:DISABLE
     */
    public BankAtmBean setMoneyBox4Status(String moneyBox4Status) {
        this.moneyBox4Status = moneyBox4Status == null ? null : moneyBox4Status.trim();
        return this;
    }

    /**
     * 获取 ATM，钱箱4，金额上限
     *
     * @return atm_money_box_4_max_amount - ATM，钱箱4，金额上限
     */
    public BigDecimal getMoneyBox4MaxAmount() {
        return moneyBox4MaxAmount;
    }

    /**
     * 设置 ATM，钱箱4，金额上限
     *
     * @param moneyBox4MaxAmount - ATM，钱箱4，金额上限
     */
    public BankAtmBean setMoneyBox4MaxAmount(BigDecimal moneyBox4MaxAmount) {
        this.moneyBox4MaxAmount = moneyBox4MaxAmount;
        return this;
    }

    /**
     * 获取 ATM，钱箱4，当前金额
     *
     * @return atm_money_box_4_current_amount - ATM，钱箱4，当前金额
     */
    public BigDecimal getMoneyBox4CurrentAmount() {
        return moneyBox4CurrentAmount;
    }

    /**
     * 设置 ATM，钱箱4，当前金额
     *
     * @param moneyBox4CurrentAmount - ATM，钱箱4，当前金额
     */
    public BankAtmBean setMoneyBox4CurrentAmount(BigDecimal moneyBox4CurrentAmount) {
        this.moneyBox4CurrentAmount = moneyBox4CurrentAmount;
        return this;
    }

    /**
     * 获取 ATM，钱箱4，当前纸币数量
     *
     * @return atm_money_box_4_current_count - ATM，钱箱4，当前纸币数量
     */
    public Integer getMoneyBox4CurrentCount() {
        return moneyBox4CurrentCount;
    }

    /**
     * 设置 ATM，钱箱4，当前纸币数量
     *
     * @param moneyBox4CurrentCount - ATM，钱箱4，当前纸币数量
     */
    public BankAtmBean setMoneyBox4CurrentCount(Integer moneyBox4CurrentCount) {
        this.moneyBox4CurrentCount = moneyBox4CurrentCount;
        return this;
    }

    /**
     * 获取 ATM，钱箱4，纸币数量上限
     *
     * @return atm_money_box_4_max_count - ATM，钱箱4，纸币数量上限
     */
    public Integer getMoneyBox4MaxCount() {
        return moneyBox4MaxCount;
    }

    /**
     * 设置 ATM，钱箱4，纸币数量上限
     *
     * @param moneyBox4MaxCount - ATM，钱箱4，纸币数量上限
     */
    public BankAtmBean setMoneyBox4MaxCount(Integer moneyBox4MaxCount) {
        this.moneyBox4MaxCount = moneyBox4MaxCount;
        return this;
    }

    /**
     * 获取 ATM，钱箱4，单张纸币面值
     *
     * @return atm_money_box_4_currency - ATM，钱箱4，单张纸币面值
     */
    public BigDecimal getMoneyBox4Currency() {
        return moneyBox4Currency;
    }

    /**
     * 设置 ATM，钱箱4，单张纸币面值
     *
     * @param moneyBox4Currency - ATM，钱箱4，单张纸币面值
     */
    public BankAtmBean setMoneyBox4Currency(BigDecimal moneyBox4Currency) {
        this.moneyBox4Currency = moneyBox4Currency;
        return this;
    }

    /**
     * 获取 ATM，钱箱4，纸币单位
     *
     * @return atm_money_box_4_unit - ATM，钱箱4，纸币单位
     */
    public String getMoneyBox4Unit() {
        return moneyBox4Unit;
    }

    /**
     * 设置 ATM，钱箱4，纸币单位
     *
     * @param moneyBox4Unit - ATM，钱箱4，纸币单位
     */
    public BankAtmBean setMoneyBox4Unit(String moneyBox4Unit) {
        this.moneyBox4Unit = moneyBox4Unit == null ? null : moneyBox4Unit.trim();
        return this;
    }

    /**
     * 获取 ATM，钱箱4，类型【存钱：DEPOSIT、取钱：WITHDRAW】
     *
     * @return atm_money_box_4_type - ATM，钱箱4，类型【存钱：DEPOSIT、取钱：WITHDRAW】
     */
    public String getMoneyBox4Type() {
        return moneyBox4Type;
    }

    /**
     * 设置 ATM，钱箱4，类型【存钱：DEPOSIT、取钱：WITHDRAW】
     *
     * @param moneyBox4Type - ATM，钱箱4，类型【存钱：DEPOSIT、取钱：WITHDRAW】
     */
    public BankAtmBean setMoneyBox4Type(String moneyBox4Type) {
        this.moneyBox4Type = moneyBox4Type == null ? null : moneyBox4Type.trim();
        return this;
    }

    /**
     * 获取 ATM，钱箱5，文本ID
     *
     * @return atm_money_box_5_id - ATM，钱箱5，文本ID
     */
    public String getMoneyBox5Id() {
        return moneyBox5Id;
    }

    /**
     * 设置 ATM，钱箱5，文本ID
     *
     * @param moneyBox5Id - ATM，钱箱5，文本ID
     */
    public BankAtmBean setMoneyBox5Id(String moneyBox5Id) {
        this.moneyBox5Id = moneyBox5Id == null ? null : moneyBox5Id.trim();
        return this;
    }

    /**
     * 获取 ATM，钱箱5，状态 【以 ENABLE、DISABLE、BREAK】默认值:DISABLE
     *
     * @return atm_money_box_5_status - ATM，钱箱5，状态 【以 ENABLE、DISABLE、BREAK】默认值:DISABLE
     */
    public String getMoneyBox5Status() {
        return moneyBox5Status;
    }

    /**
     * 设置 ATM，钱箱5，状态 【以 ENABLE、DISABLE、BREAK】默认值:DISABLE
     *
     * @param moneyBox5Status - ATM，钱箱5，状态 【以 ENABLE、DISABLE、BREAK】默认值:DISABLE
     */
    public BankAtmBean setMoneyBox5Status(String moneyBox5Status) {
        this.moneyBox5Status = moneyBox5Status == null ? null : moneyBox5Status.trim();
        return this;
    }

    /**
     * 获取 ATM，钱箱5，金额上限
     *
     * @return atm_money_box_5_max_amount - ATM，钱箱5，金额上限
     */
    public BigDecimal getMoneyBox5MaxAmount() {
        return moneyBox5MaxAmount;
    }

    /**
     * 设置 ATM，钱箱5，金额上限
     *
     * @param moneyBox5MaxAmount - ATM，钱箱5，金额上限
     */
    public BankAtmBean setMoneyBox5MaxAmount(BigDecimal moneyBox5MaxAmount) {
        this.moneyBox5MaxAmount = moneyBox5MaxAmount;
        return this;
    }

    /**
     * 获取 ATM，钱箱5，当前金额
     *
     * @return atm_money_box_5_current_amount - ATM，钱箱5，当前金额
     */
    public BigDecimal getMoneyBox5CurrentAmount() {
        return moneyBox5CurrentAmount;
    }

    /**
     * 设置 ATM，钱箱5，当前金额
     *
     * @param moneyBox5CurrentAmount - ATM，钱箱5，当前金额
     */
    public BankAtmBean setMoneyBox5CurrentAmount(BigDecimal moneyBox5CurrentAmount) {
        this.moneyBox5CurrentAmount = moneyBox5CurrentAmount;
        return this;
    }

    /**
     * 获取 ATM，钱箱5，当前纸币数量
     *
     * @return atm_money_box_5_current_count - ATM，钱箱5，当前纸币数量
     */
    public Integer getMoneyBox5CurrentCount() {
        return moneyBox5CurrentCount;
    }

    /**
     * 设置 ATM，钱箱5，当前纸币数量
     *
     * @param moneyBox5CurrentCount - ATM，钱箱5，当前纸币数量
     */
    public BankAtmBean setMoneyBox5CurrentCount(Integer moneyBox5CurrentCount) {
        this.moneyBox5CurrentCount = moneyBox5CurrentCount;
        return this;
    }

    /**
     * 获取 ATM，钱箱5，纸币数量上限
     *
     * @return atm_money_box_5_max_count - ATM，钱箱5，纸币数量上限
     */
    public Integer getMoneyBox5MaxCount() {
        return moneyBox5MaxCount;
    }

    /**
     * 设置 ATM，钱箱5，纸币数量上限
     *
     * @param moneyBox5MaxCount - ATM，钱箱5，纸币数量上限
     */
    public BankAtmBean setMoneyBox5MaxCount(Integer moneyBox5MaxCount) {
        this.moneyBox5MaxCount = moneyBox5MaxCount;
        return this;
    }

    /**
     * 获取 ATM，钱箱5，单张纸币面值
     *
     * @return atm_money_box_5_currency - ATM，钱箱5，单张纸币面值
     */
    public BigDecimal getMoneyBox5Currency() {
        return moneyBox5Currency;
    }

    /**
     * 设置 ATM，钱箱5，单张纸币面值
     *
     * @param moneyBox5Currency - ATM，钱箱5，单张纸币面值
     */
    public BankAtmBean setMoneyBox5Currency(BigDecimal moneyBox5Currency) {
        this.moneyBox5Currency = moneyBox5Currency;
        return this;
    }

    /**
     * 获取 ATM，钱箱5，纸币单位
     *
     * @return atm_money_box_5_unit - ATM，钱箱5，纸币单位
     */
    public String getMoneyBox5Unit() {
        return moneyBox5Unit;
    }

    /**
     * 设置 ATM，钱箱5，纸币单位
     *
     * @param moneyBox5Unit - ATM，钱箱5，纸币单位
     */
    public BankAtmBean setMoneyBox5Unit(String moneyBox5Unit) {
        this.moneyBox5Unit = moneyBox5Unit == null ? null : moneyBox5Unit.trim();
        return this;
    }

    /**
     * 获取 ATM，钱箱5，类型【存钱：DEPOSIT、取钱：WITHDRAW】
     *
     * @return atm_money_box_5_type - ATM，钱箱5，类型【存钱：DEPOSIT、取钱：WITHDRAW】
     */
    public String getMoneyBox5Type() {
        return moneyBox5Type;
    }

    /**
     * 设置 ATM，钱箱5，类型【存钱：DEPOSIT、取钱：WITHDRAW】
     *
     * @param moneyBox5Type - ATM，钱箱5，类型【存钱：DEPOSIT、取钱：WITHDRAW】
     */
    public BankAtmBean setMoneyBox5Type(String moneyBox5Type) {
        this.moneyBox5Type = moneyBox5Type == null ? null : moneyBox5Type.trim();
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
    public BankAtmBean setUploadTimestamp(Date uploadTimestamp) {
        this.uploadTimestamp = uploadTimestamp;
        return this;
    }

    /**
     * 获取 ATM（用户服务端portal端显示）整体状况：WARNING（告警，有故障）,DOWN（关机、失联）,REPAIR（维修中、长时间）,MAINTAIN（短时间维护中）,INSERVICE（正常服务）
     *
     * @return atm_status - ATM（用户服务端portal端显示）整体状况：WARNING（告警，有故障）,DOWN（关机、失联）,REPAIR（维修中、长时间）,MAINTAIN（短时间维护中）,INSERVICE（正常服务）
     */
    public String getStatus() {
        return status;
    }

    /**
     * 设置 ATM（用户服务端portal端显示）整体状况：WARNING（告警，有故障）,DOWN（关机、失联）,REPAIR（维修中、长时间）,MAINTAIN（短时间维护中）,INSERVICE（正常服务）
     *
     * @param status - ATM（用户服务端portal端显示）整体状况：WARNING（告警，有故障）,DOWN（关机、失联）,REPAIR（维修中、长时间）,MAINTAIN（短时间维护中）,INSERVICE（正常服务）
     */
    public BankAtmBean setStatus(String status) {
        this.status = status == null ? null : status.trim();
        return this;
    }

    /**
     * 获取 ATM客户端上传的整体状态码
     *
     * @return atm_term_status - ATM客户端上传的整体状态码
     */
    public String getTermStatus() {
        return termStatus;
    }

    /**
     * 设置 ATM客户端上传的整体状态码
     *
     * @param termStatus - ATM客户端上传的整体状态码
     */
    public BankAtmBean setTermStatus(String termStatus) {
        this.termStatus = termStatus == null ? null : termStatus.trim();
        return this;
    }

    /**
     * 获取 ATM心跳包上传的时间
     *
     * @return atm_live_timestamp - ATM心跳包上传的时间
     */
    public Date getLiveTimestamp() {
        return liveTimestamp;
    }

    /**
     * 设置 ATM心跳包上传的时间
     *
     * @param liveTimestamp - ATM心跳包上传的时间
     */
    public BankAtmBean setLiveTimestamp(Date liveTimestamp) {
        this.liveTimestamp = liveTimestamp;
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
    public BankAtmBean setCreateTimestamp(Date createTimestamp) {
        this.createTimestamp = createTimestamp;
        return this;
    }

    /**
     * 获取 创建人
     *
     * @return atm_create_by - 创建人
     */
    public String getCreateBy() {
        return createBy;
    }

    /**
     * 设置 创建人
     *
     * @param createBy - 创建人
     */
    public BankAtmBean setCreateBy(String createBy) {
        this.createBy = createBy == null ? null : createBy.trim();
        return this;
    }

    /**
     * 获取 更新人ID与t_user.user_id和t_crew.crew_id关联,0代表系统自动执行
     *
     * @return atm_operator_id - 更新人ID与t_user.user_id和t_crew.crew_id关联,0代表系统自动执行
     */
    public Long getOperatorId() {
        return operatorId;
    }

    /**
     * 设置 更新人ID与t_user.user_id和t_crew.crew_id关联,0代表系统自动执行
     *
     * @param operatorId - 更新人ID与t_user.user_id和t_crew.crew_id关联,0代表系统自动执行
     */
    public BankAtmBean setOperatorId(Long operatorId) {
        this.operatorId = operatorId;
        return this;
    }

    /**
     * 获取 更新人用户名与t_user.user_name和t_crew.crew_name关联,system代表系统自动执行
     *
     * @return atm_operator_name - 更新人用户名与t_user.user_name和t_crew.crew_name关联,system代表系统自动执行
     */
    public String getOperatorName() {
        return operatorName;
    }

    /**
     * 设置 更新人用户名与t_user.user_name和t_crew.crew_name关联,system代表系统自动执行
     *
     * @param operatorName - 更新人用户名与t_user.user_name和t_crew.crew_name关联,system代表系统自动执行
     */
    public BankAtmBean setOperatorName(String operatorName) {
        this.operatorName = operatorName == null ? null : operatorName.trim();
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
    public BankAtmBean setDeleteFlag(String deleteFlag) {
        this.deleteFlag = deleteFlag == null ? null : deleteFlag.trim();
        return this;
    }
}