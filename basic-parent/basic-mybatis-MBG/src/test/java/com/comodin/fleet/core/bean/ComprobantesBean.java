package com.comodin.fleet.core.bean;

import com.comodin.basic.util.date.DateUtil;
import com.comodin.basic.validation.IBaseValidGroup;
import com.comodin.basic.validation.constraints.*;
import com.comodin.fleet.constant.i18n.ComprobantesBeanI18nConstant;
import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;
import javax.persistence.*;
import javax.validation.constraints.*;
import org.hibernate.validator.constraints.*;
import org.springframework.format.annotation.DateTimeFormat;

@SuppressWarnings({"unused", "UnusedReturnValue", "SameParameterValue", "DefaultAnnotationParam"})
@Entity
@Table(name = "t_comprobantes")
public class ComprobantesBean implements Serializable {
    /**
     * <pre>
     * DB remark: 数据库主键ID
     * DB column: comprobantes_id	BIGINT(20)	<--->	id	java.lang.Long
     * DB is  Nullable: false
     * DB defaultValue: null
     * </pre>
     */
    @NotNull(message = "{" + ComprobantesBeanI18nConstant.COMPROBANTES_BEAN_ID_NOT_NULL + "}", groups = {IBaseValidGroup.Update.class})
    @ValidLength(max = 20, message = "{" + ComprobantesBeanI18nConstant.COMPROBANTES_BEAN_ID_LENGTH + "}", groups = {IBaseValidGroup.Update.class})
    @Column(name = "comprobantes_id", length = 20, nullable = false)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    private Long id;

    /**
     * <pre>
     * DB remark: 票据对应的任务id, t_task.task_task_id关联,一个任务有多个票据
     * DB column: comprobantes_task_id	BIGINT(20)	<--->	taskId	java.lang.Long
     * DB is  Nullable: false
     * DB defaultValue: null
     * </pre>
     */
    @NotNull(message = "{" + ComprobantesBeanI18nConstant.COMPROBANTES_BEAN_TASK_ID_NOT_NULL + "}", groups = {IBaseValidGroup.Add.class, IBaseValidGroup.Update.class})
    @ValidLength(max = 20, message = "{" + ComprobantesBeanI18nConstant.COMPROBANTES_BEAN_TASK_ID_LENGTH + "}", groups = {IBaseValidGroup.Add.class, IBaseValidGroup.Update.class})
    @Column(name = "comprobantes_task_id", length = 20, nullable = false)
    private Long taskId;

    /**
     * <pre>
     * DB remark: 票据对应的任务id, t_task.task_pk_id关联,一个任务有多个票据
     * DB column: comprobantes_task_pk_id	BIGINT(20)	<--->	taskPkId	java.lang.Long
     * DB is  Nullable: false
     * DB defaultValue: null
     * </pre>
     */
    @NotNull(message = "{" + ComprobantesBeanI18nConstant.COMPROBANTES_BEAN_TASK_PK_ID_NOT_NULL + "}", groups = {IBaseValidGroup.Add.class, IBaseValidGroup.Update.class})
    @ValidLength(max = 20, message = "{" + ComprobantesBeanI18nConstant.COMPROBANTES_BEAN_TASK_PK_ID_LENGTH + "}", groups = {IBaseValidGroup.Add.class, IBaseValidGroup.Update.class})
    @Column(name = "comprobantes_task_pk_id", length = 20, nullable = false)
    private Long taskPkId;

    /**
     * <pre>
     * DB remark: 票据的编号,司机完成任务时候输入或扫描二维码输入
     * DB column: comprobantes_code	VARCHAR(15)	<--->	code	java.lang.String
     * DB is  Nullable: false
     * DB defaultValue: null
     * </pre>
     */
    @NotBlank(message = "{" + ComprobantesBeanI18nConstant.COMPROBANTES_BEAN_CODE_NOT_BLANK + "}", groups = {IBaseValidGroup.Add.class, IBaseValidGroup.Update.class})
    @Length(max = 15, message = "{" + ComprobantesBeanI18nConstant.COMPROBANTES_BEAN_CODE_LENGTH + "}", groups = {IBaseValidGroup.Add.class, IBaseValidGroup.Update.class})
    @Column(name = "comprobantes_code", length = 15, nullable = false)
    private String code;

    /**
     * <pre>
     * DB remark: 票据类型【ORDINARY[普通票据]、VISIT[即取消任务或取消某些票据时，需要到客户店里签收的回执单（访问票据）、POINT_MONEY[点钞票据]]】date:2016-12-12 by:supeng
     * DB column: comprobantes_type	CHAR(20)	<--->	type	java.lang.String
     * DB is  Nullable: false
     * DB defaultValue: null
     * </pre>
     */
    @NotBlank(message = "{" + ComprobantesBeanI18nConstant.COMPROBANTES_BEAN_TYPE_NOT_BLANK + "}", groups = {IBaseValidGroup.Add.class, IBaseValidGroup.Update.class})
    @Length(max = 20, message = "{" + ComprobantesBeanI18nConstant.COMPROBANTES_BEAN_TYPE_LENGTH + "}", groups = {IBaseValidGroup.Add.class, IBaseValidGroup.Update.class})
    @Column(name = "comprobantes_type", length = 20, nullable = false)
    private String type;

    /**
     * <pre>
     * DB remark: 票据是否有效【ENABLE[启用]、DISABLE[失效]】将原有comprobantes_status 改成 comprobantes_availability【date:2016-12-12 by:supeng】
     * DB column: comprobantes_availability	CHAR(7)	<--->	availability	java.lang.String
     * DB is  Nullable: false
     * DB defaultValue: ENABLE
     * </pre>
     */
    @NotBlank(message = "{" + ComprobantesBeanI18nConstant.COMPROBANTES_BEAN_AVAILABILITY_NOT_BLANK + "}", groups = {IBaseValidGroup.Add.class, IBaseValidGroup.Update.class})
    @Length(max = 7, message = "{" + ComprobantesBeanI18nConstant.COMPROBANTES_BEAN_AVAILABILITY_LENGTH + "}", groups = {IBaseValidGroup.Add.class, IBaseValidGroup.Update.class})
    @Column(name = "comprobantes_availability", length = 7, nullable = false)
    private String availability;

    /**
     * <pre>
     * DB remark: 状态【RECEIVE_BILL_CP[收钱票据]、SEND_BILL_CE[送钱票据]、SEND_BILL_NOT_YET_DELIVERED_CS[送钱票据，还未交付]、SEND_BILL_NOT_USED_RETURN_CR[送钱票据，还未使用，直接返回回来的票据Return]、VISIT_BILL_CC[访问票据，即取消任务，或者票据，回执单]】
     * DB column: comprobantes_status	VARCHAR(30)	<--->	status	java.lang.String
     * DB is  Nullable: false
     * DB defaultValue: null
     * </pre>
     */
    @NotBlank(message = "{" + ComprobantesBeanI18nConstant.COMPROBANTES_BEAN_STATUS_NOT_BLANK + "}", groups = {IBaseValidGroup.Add.class, IBaseValidGroup.Update.class})
    @Length(max = 30, message = "{" + ComprobantesBeanI18nConstant.COMPROBANTES_BEAN_STATUS_LENGTH + "}", groups = {IBaseValidGroup.Add.class, IBaseValidGroup.Update.class})
    @Column(name = "comprobantes_status", length = 30, nullable = false)
    private String status;

    /**
     * <pre>
     * DB remark: 货币内部编号，各运钞分公司对货币有着不同的设定
     * DB column: comprobantes_currency_internal_id	CHAR(15)	<--->	currencyInternalId	java.lang.String
     * DB is  Nullable: true
     * DB defaultValue: null
     * </pre>
     */
    @Length(max = 15, message = "{" + ComprobantesBeanI18nConstant.COMPROBANTES_BEAN_CURRENCY_INTERNAL_ID_LENGTH + "}", groups = {IBaseValidGroup.Add.class, IBaseValidGroup.Update.class})
    @Column(name = "comprobantes_currency_internal_id", length = 15, nullable = true)
    private String currencyInternalId;

    /**
     * <pre>
     * DB remark: 货币类型,USD MXN,XXX...
     * DB column: comprobantes_currency_iso_code	CHAR(5)	<--->	currencyIsoCode	java.lang.String
     * DB is  Nullable: false
     * DB defaultValue: null
     * </pre>
     */
    @NotBlank(message = "{" + ComprobantesBeanI18nConstant.COMPROBANTES_BEAN_CURRENCY_ISO_CODE_NOT_BLANK + "}", groups = {IBaseValidGroup.Add.class, IBaseValidGroup.Update.class})
    @Length(max = 5, message = "{" + ComprobantesBeanI18nConstant.COMPROBANTES_BEAN_CURRENCY_ISO_CODE_LENGTH + "}", groups = {IBaseValidGroup.Add.class, IBaseValidGroup.Update.class})
    @Column(name = "comprobantes_currency_iso_code", length = 5, nullable = false)
    private String currencyIsoCode;

    /**
     * <pre>
     * DB remark: 票据对应的钱袋子数量,暂时没有记录每个钱袋子的编号
     * DB column: comprobantes_package_number	INTEGER(10)	<--->	packageNumber	java.lang.Integer
     * DB is  Nullable: false
     * DB defaultValue: 0
     * </pre>
     */
    @NotNull(message = "{" + ComprobantesBeanI18nConstant.COMPROBANTES_BEAN_PACKAGE_NUMBER_NOT_NULL + "}", groups = {IBaseValidGroup.Add.class, IBaseValidGroup.Update.class})
    @ValidLength(max = 10, message = "{" + ComprobantesBeanI18nConstant.COMPROBANTES_BEAN_PACKAGE_NUMBER_LENGTH + "}", groups = {IBaseValidGroup.Add.class, IBaseValidGroup.Update.class})
    @Column(name = "comprobantes_package_number", length = 10, nullable = false)
    private Integer packageNumber;

    /**
     * <pre>
     * DB remark: 票据对应的钱袋子编号,多个编号以|隔开,例|123|456|789|
     * DB column: comprobantes_bag_serial_numbers	VARCHAR(800)	<--->	bagSerialNumbers	java.lang.String
     * DB is  Nullable: true
     * DB defaultValue: null
     * </pre>
     */
    @Length(max = 800, message = "{" + ComprobantesBeanI18nConstant.COMPROBANTES_BEAN_BAG_SERIAL_NUMBERS_LENGTH + "}", groups = {IBaseValidGroup.Add.class, IBaseValidGroup.Update.class})
    @Column(name = "comprobantes_bag_serial_numbers", length = 800, nullable = true)
    private String bagSerialNumbers;

    /**
     * <pre>
     * DB remark: 所有钱袋子加起来总金额
     * DB column: comprobantes_amount	DECIMAL(15)	<--->	amount	java.math.BigDecimal
     * DB is  Nullable: false
     * DB defaultValue: 0.0000
     * </pre>
     */
    @Column(name = "comprobantes_amount", length = 15, nullable = false)
    private BigDecimal amount;

    /**
     * <pre>
     * DB remark: 拍照图片文件名
     * DB column: comprobantes_evidence_picture	VARCHAR(100)	<--->	evidencePicture	java.lang.String
     * DB is  Nullable: true
     * DB defaultValue: null
     * </pre>
     */
    @Length(max = 100, message = "{" + ComprobantesBeanI18nConstant.COMPROBANTES_BEAN_EVIDENCE_PICTURE_LENGTH + "}", groups = {IBaseValidGroup.Add.class, IBaseValidGroup.Update.class})
    @Column(name = "comprobantes_evidence_picture", length = 100, nullable = true)
    private String evidencePicture;

    /**
     * <pre>
     * DB remark: 签名图片文件名
     * DB column: comprobantes_signature_picture	VARCHAR(100)	<--->	signaturePicture	java.lang.String
     * DB is  Nullable: true
     * DB defaultValue: null
     * </pre>
     */
    @Length(max = 100, message = "{" + ComprobantesBeanI18nConstant.COMPROBANTES_BEAN_SIGNATURE_PICTURE_LENGTH + "}", groups = {IBaseValidGroup.Add.class, IBaseValidGroup.Update.class})
    @Column(name = "comprobantes_signature_picture", length = 100, nullable = true)
    private String signaturePicture;

    /**
     * <pre>
     * DB remark: client To client 任务类型时，在客户取钱后拍照图片文件名
     * DB column: comprobantes_part_evidence_picture	VARCHAR(100)	<--->	partEvidencePicture	java.lang.String
     * DB is  Nullable: true
     * DB defaultValue: null
     * </pre>
     */
    @Length(max = 100, message = "{" + ComprobantesBeanI18nConstant.COMPROBANTES_BEAN_PART_EVIDENCE_PICTURE_LENGTH + "}", groups = {IBaseValidGroup.Add.class, IBaseValidGroup.Update.class})
    @Column(name = "comprobantes_part_evidence_picture", length = 100, nullable = true)
    private String partEvidencePicture;

    /**
     * <pre>
     * DB remark: client To client 任务类型时，在客户取钱后签名图片文件名
     * DB column: comprobantes_part_signature_picture	VARCHAR(100)	<--->	partSignaturePicture	java.lang.String
     * DB is  Nullable: true
     * DB defaultValue: null
     * </pre>
     */
    @Length(max = 100, message = "{" + ComprobantesBeanI18nConstant.COMPROBANTES_BEAN_PART_SIGNATURE_PICTURE_LENGTH + "}", groups = {IBaseValidGroup.Add.class, IBaseValidGroup.Update.class})
    @Column(name = "comprobantes_part_signature_picture", length = 100, nullable = true)
    private String partSignaturePicture;

    /**
     * <pre>
     * DB remark: 取消票据的,责任方【CIT,CLIENT】
     * DB column: comprobantes_cancel_responsible_party	VARCHAR(10)	<--->	cancelResponsibleParty	java.lang.String
     * DB is  Nullable: true
     * DB defaultValue: null
     * </pre>
     */
    @Length(max = 10, message = "{" + ComprobantesBeanI18nConstant.COMPROBANTES_BEAN_CANCEL_RESPONSIBLE_PARTY_LENGTH + "}", groups = {IBaseValidGroup.Add.class, IBaseValidGroup.Update.class})
    @Column(name = "comprobantes_cancel_responsible_party", length = 10, nullable = true)
    private String cancelResponsibleParty;

    /**
     * <pre>
     * DB remark: 取消票据的,回执行单【目前需求,只有责任方为Client时,才有回执单】
     * DB column: comprobantes_cancel_single_receipt	VARCHAR(20)	<--->	cancelSingleReceipt	java.lang.String
     * DB is  Nullable: true
     * DB defaultValue: null
     * </pre>
     */
    @Length(max = 20, message = "{" + ComprobantesBeanI18nConstant.COMPROBANTES_BEAN_CANCEL_SINGLE_RECEIPT_LENGTH + "}", groups = {IBaseValidGroup.Add.class, IBaseValidGroup.Update.class})
    @Column(name = "comprobantes_cancel_single_receipt", length = 20, nullable = true)
    private String cancelSingleReceipt;

    /**
     * <pre>
     * DB remark: 取消票据的,理由,t_setting.setting_key,关联
     * DB column: comprobantes_cancel_reason	VARCHAR(40)	<--->	cancelReason	java.lang.String
     * DB is  Nullable: true
     * DB defaultValue: null
     * </pre>
     */
    @Length(max = 40, message = "{" + ComprobantesBeanI18nConstant.COMPROBANTES_BEAN_CANCEL_REASON_LENGTH + "}", groups = {IBaseValidGroup.Add.class, IBaseValidGroup.Update.class})
    @Column(name = "comprobantes_cancel_reason", length = 40, nullable = true)
    private String cancelReason;

    /**
     * <pre>
     * DB remark: 取消票据的,钱回退处
     * DB column: comprobantes_cancel_money_back_party	VARCHAR(30)	<--->	cancelMoneyBackParty	java.lang.String
     * DB is  Nullable: true
     * DB defaultValue: null
     * </pre>
     */
    @Length(max = 30, message = "{" + ComprobantesBeanI18nConstant.COMPROBANTES_BEAN_CANCEL_MONEY_BACK_PARTY_LENGTH + "}", groups = {IBaseValidGroup.Add.class, IBaseValidGroup.Update.class})
    @Column(name = "comprobantes_cancel_money_back_party", length = 30, nullable = true)
    private String cancelMoneyBackParty;

    /**
     * <pre>
     * DB remark: 取消票据的备注
     * DB column: comprobantes_cancel_comment	VARCHAR(100)	<--->	cancelComment	java.lang.String
     * DB is  Nullable: true
     * DB defaultValue: null
     * </pre>
     */
    @Length(max = 100, message = "{" + ComprobantesBeanI18nConstant.COMPROBANTES_BEAN_CANCEL_COMMENT_LENGTH + "}", groups = {IBaseValidGroup.Add.class, IBaseValidGroup.Update.class})
    @Column(name = "comprobantes_cancel_comment", length = 100, nullable = true)
    private String cancelComment;

    /**
     * <pre>
     * DB remark: 客户网点代号
     * DB column: comprobantes_branch_code	VARCHAR(50)	<--->	branchCode	java.lang.String
     * DB is  Nullable: true
     * DB defaultValue: null
     * </pre>
     */
    @Length(max = 50, message = "{" + ComprobantesBeanI18nConstant.COMPROBANTES_BEAN_BRANCH_CODE_LENGTH + "}", groups = {IBaseValidGroup.Add.class, IBaseValidGroup.Update.class})
    @Column(name = "comprobantes_branch_code", length = 50, nullable = true)
    private String branchCode;

    /**
     * <pre>
     * DB remark: 创建时间
     * DB column: comprobantes_create_timestamp	TIMESTAMP(19)	<--->	createTimestamp	java.util.Date
     * DB is  Nullable: false
     * DB defaultValue: CURRENT_TIMESTAMP
     * </pre>
     */
    @ValidDateTimeFormat(pattern = DateUtil.DATE_PATTERN_YYYY_MM_DD_HH_MM_SS, message = "{" + ComprobantesBeanI18nConstant.COMPROBANTES_BEAN_CREATE_TIMESTAMP_DATE_TIME_FORMAT + "}", groups = {IBaseValidGroup.Add.class, IBaseValidGroup.Update.class})
    @DateTimeFormat(pattern = DateUtil.DATE_PATTERN_YYYY_MM_DD_HH_MM_SS)
    @NotNull(message = "{" + ComprobantesBeanI18nConstant.COMPROBANTES_BEAN_CREATE_TIMESTAMP_NOT_NULL + "}", groups = {IBaseValidGroup.Add.class, IBaseValidGroup.Update.class})
    @Column(name = "comprobantes_create_timestamp", length = 19, nullable = false)
    private Date createTimestamp;

    @ValidDateTimeFormat(pattern = DateUtil.DATE_PATTERN_YYYY_MM_DD_HH_MM_SS, message = "{" + ComprobantesBeanI18nConstant.COMPROBANTES_BEAN_UPDATE_TIMESTAMP_DATE_TIME_FORMAT + "}", groups = {IBaseValidGroup.Add.class, IBaseValidGroup.Update.class})
    @DateTimeFormat(pattern = DateUtil.DATE_PATTERN_YYYY_MM_DD_HH_MM_SS)
    @NotNull(message = "{" + ComprobantesBeanI18nConstant.COMPROBANTES_BEAN_UPDATE_TIMESTAMP_NOT_NULL + "}", groups = {IBaseValidGroup.Add.class, IBaseValidGroup.Update.class})
    @Column(name = "comprobantes_update_timestamp", length = 19, nullable = false)
    private Date updateTimestamp;

    /**
     * <pre>
     * DB remark: 谁新增了该员工,与crew_username字段关联
     * DB column: comprobantes_create_by	VARCHAR(20)	<--->	createBy	java.lang.String
     * DB is  Nullable: false
     * DB defaultValue: null
     * </pre>
     */
    @NotBlank(message = "{" + ComprobantesBeanI18nConstant.COMPROBANTES_BEAN_CREATE_BY_NOT_BLANK + "}", groups = {IBaseValidGroup.Add.class, IBaseValidGroup.Update.class})
    @Length(max = 20, message = "{" + ComprobantesBeanI18nConstant.COMPROBANTES_BEAN_CREATE_BY_LENGTH + "}", groups = {IBaseValidGroup.Add.class, IBaseValidGroup.Update.class})
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
    @NotBlank(message = "{" + ComprobantesBeanI18nConstant.COMPROBANTES_BEAN_DELETE_FLAG_NOT_BLANK + "}", groups = {IBaseValidGroup.Add.class, IBaseValidGroup.Update.class})
    @Length(max = 1, message = "{" + ComprobantesBeanI18nConstant.COMPROBANTES_BEAN_DELETE_FLAG_LENGTH + "}", groups = {IBaseValidGroup.Add.class, IBaseValidGroup.Update.class})
    @Column(name = "comprobantes_delete_flag", length = 1, nullable = false)
    private String deleteFlag;

    /**
     * <pre>
     * DB remark: 票据来源，哪一方生成的任务【SIO公司导入进来分两种：[SIO_0_KIOSKOLIN、SIO_1_COMODIN]，COMODIN[comodin手工创建]，EXCEL[excel批量导入]】
     * DB column: comprobantes_generate_source_party	VARCHAR(20)	<--->	generateSourceParty	java.lang.String
     * DB is  Nullable: false
     * DB defaultValue: null
     * </pre>
     */
    @NotBlank(message = "{" + ComprobantesBeanI18nConstant.COMPROBANTES_BEAN_GENERATE_SOURCE_PARTY_NOT_BLANK + "}", groups = {IBaseValidGroup.Add.class, IBaseValidGroup.Update.class})
    @Length(max = 20, message = "{" + ComprobantesBeanI18nConstant.COMPROBANTES_BEAN_GENERATE_SOURCE_PARTY_LENGTH + "}", groups = {IBaseValidGroup.Add.class, IBaseValidGroup.Update.class})
    @Column(name = "comprobantes_generate_source_party", length = 20, nullable = false)
    private String generateSourceParty;

    /**
     * <pre>
     * DB remark: 票据来源，原始Comprobantes号，【date:2016-12-12 by:supeng】
     * DB column: comprobantes_source_bill_original_code	VARCHAR(100)	<--->	sourceBillOriginalCode	java.lang.String
     * DB is  Nullable: true
     * DB defaultValue: null
     * </pre>
     */
    @Length(max = 100, message = "{" + ComprobantesBeanI18nConstant.COMPROBANTES_BEAN_SOURCE_BILL_ORIGINAL_CODE_LENGTH + "}", groups = {IBaseValidGroup.Add.class, IBaseValidGroup.Update.class})
    @Column(name = "comprobantes_source_bill_original_code", length = 100, nullable = true)
    private String sourceBillOriginalCode;

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
    public ComprobantesBean setId(Long id) {
        this.id = id;
        return this;
    }

    /**
     * 获取 票据对应的任务id, t_task.task_task_id关联,一个任务有多个票据
     *
     * @return comprobantes_task_id - 票据对应的任务id, t_task.task_task_id关联,一个任务有多个票据
     */
    public Long getTaskId() {
        return taskId;
    }

    /**
     * 设置 票据对应的任务id, t_task.task_task_id关联,一个任务有多个票据
     *
     * @param taskId - 票据对应的任务id, t_task.task_task_id关联,一个任务有多个票据
     */
    public ComprobantesBean setTaskId(Long taskId) {
        this.taskId = taskId;
        return this;
    }

    /**
     * 获取 票据对应的任务id, t_task.task_pk_id关联,一个任务有多个票据
     *
     * @return comprobantes_task_pk_id - 票据对应的任务id, t_task.task_pk_id关联,一个任务有多个票据
     */
    public Long getTaskPkId() {
        return taskPkId;
    }

    /**
     * 设置 票据对应的任务id, t_task.task_pk_id关联,一个任务有多个票据
     *
     * @param taskPkId - 票据对应的任务id, t_task.task_pk_id关联,一个任务有多个票据
     */
    public ComprobantesBean setTaskPkId(Long taskPkId) {
        this.taskPkId = taskPkId;
        return this;
    }

    /**
     * 获取 票据的编号,司机完成任务时候输入或扫描二维码输入
     *
     * @return comprobantes_code - 票据的编号,司机完成任务时候输入或扫描二维码输入
     */
    public String getCode() {
        return code;
    }

    /**
     * 设置 票据的编号,司机完成任务时候输入或扫描二维码输入
     *
     * @param code - 票据的编号,司机完成任务时候输入或扫描二维码输入
     */
    public ComprobantesBean setCode(String code) {
        this.code = code == null ? null : code.trim();
        return this;
    }

    /**
     * 获取 票据类型【ORDINARY[普通票据]、VISIT[即取消任务或取消某些票据时，需要到客户店里签收的回执单（访问票据）、POINT_MONEY[点钞票据]]】date:2016-12-12 by:supeng
     *
     * @return comprobantes_type - 票据类型【ORDINARY[普通票据]、VISIT[即取消任务或取消某些票据时，需要到客户店里签收的回执单（访问票据）、POINT_MONEY[点钞票据]]】date:2016-12-12 by:supeng
     */
    public String getType() {
        return type;
    }

    /**
     * 设置 票据类型【ORDINARY[普通票据]、VISIT[即取消任务或取消某些票据时，需要到客户店里签收的回执单（访问票据）、POINT_MONEY[点钞票据]]】date:2016-12-12 by:supeng
     *
     * @param type - 票据类型【ORDINARY[普通票据]、VISIT[即取消任务或取消某些票据时，需要到客户店里签收的回执单（访问票据）、POINT_MONEY[点钞票据]]】date:2016-12-12 by:supeng
     */
    public ComprobantesBean setType(String type) {
        this.type = type == null ? null : type.trim();
        return this;
    }

    /**
     * 获取 票据是否有效【ENABLE[启用]、DISABLE[失效]】将原有comprobantes_status 改成 comprobantes_availability【date:2016-12-12 by:supeng】
     *
     * @return comprobantes_availability - 票据是否有效【ENABLE[启用]、DISABLE[失效]】将原有comprobantes_status 改成 comprobantes_availability【date:2016-12-12 by:supeng】
     */
    public String getAvailability() {
        return availability;
    }

    /**
     * 设置 票据是否有效【ENABLE[启用]、DISABLE[失效]】将原有comprobantes_status 改成 comprobantes_availability【date:2016-12-12 by:supeng】
     *
     * @param availability - 票据是否有效【ENABLE[启用]、DISABLE[失效]】将原有comprobantes_status 改成 comprobantes_availability【date:2016-12-12 by:supeng】
     */
    public ComprobantesBean setAvailability(String availability) {
        this.availability = availability == null ? null : availability.trim();
        return this;
    }

    /**
     * 获取 状态【RECEIVE_BILL_CP[收钱票据]、SEND_BILL_CE[送钱票据]、SEND_BILL_NOT_YET_DELIVERED_CS[送钱票据，还未交付]、SEND_BILL_NOT_USED_RETURN_CR[送钱票据，还未使用，直接返回回来的票据Return]、VISIT_BILL_CC[访问票据，即取消任务，或者票据，回执单]】
     *
     * @return comprobantes_status - 状态【RECEIVE_BILL_CP[收钱票据]、SEND_BILL_CE[送钱票据]、SEND_BILL_NOT_YET_DELIVERED_CS[送钱票据，还未交付]、SEND_BILL_NOT_USED_RETURN_CR[送钱票据，还未使用，直接返回回来的票据Return]、VISIT_BILL_CC[访问票据，即取消任务，或者票据，回执单]】
     */
    public String getStatus() {
        return status;
    }

    /**
     * 设置 状态【RECEIVE_BILL_CP[收钱票据]、SEND_BILL_CE[送钱票据]、SEND_BILL_NOT_YET_DELIVERED_CS[送钱票据，还未交付]、SEND_BILL_NOT_USED_RETURN_CR[送钱票据，还未使用，直接返回回来的票据Return]、VISIT_BILL_CC[访问票据，即取消任务，或者票据，回执单]】
     *
     * @param status - 状态【RECEIVE_BILL_CP[收钱票据]、SEND_BILL_CE[送钱票据]、SEND_BILL_NOT_YET_DELIVERED_CS[送钱票据，还未交付]、SEND_BILL_NOT_USED_RETURN_CR[送钱票据，还未使用，直接返回回来的票据Return]、VISIT_BILL_CC[访问票据，即取消任务，或者票据，回执单]】
     */
    public ComprobantesBean setStatus(String status) {
        this.status = status == null ? null : status.trim();
        return this;
    }

    /**
     * 获取 货币内部编号，各运钞分公司对货币有着不同的设定
     *
     * @return comprobantes_currency_internal_id - 货币内部编号，各运钞分公司对货币有着不同的设定
     */
    public String getCurrencyInternalId() {
        return currencyInternalId;
    }

    /**
     * 设置 货币内部编号，各运钞分公司对货币有着不同的设定
     *
     * @param currencyInternalId - 货币内部编号，各运钞分公司对货币有着不同的设定
     */
    public ComprobantesBean setCurrencyInternalId(String currencyInternalId) {
        this.currencyInternalId = currencyInternalId == null ? null : currencyInternalId.trim();
        return this;
    }

    /**
     * 获取 货币类型,USD MXN,XXX...
     *
     * @return comprobantes_currency_iso_code - 货币类型,USD MXN,XXX...
     */
    public String getCurrencyIsoCode() {
        return currencyIsoCode;
    }

    /**
     * 设置 货币类型,USD MXN,XXX...
     *
     * @param currencyIsoCode - 货币类型,USD MXN,XXX...
     */
    public ComprobantesBean setCurrencyIsoCode(String currencyIsoCode) {
        this.currencyIsoCode = currencyIsoCode == null ? null : currencyIsoCode.trim();
        return this;
    }

    /**
     * 获取 票据对应的钱袋子数量,暂时没有记录每个钱袋子的编号
     *
     * @return comprobantes_package_number - 票据对应的钱袋子数量,暂时没有记录每个钱袋子的编号
     */
    public Integer getPackageNumber() {
        return packageNumber;
    }

    /**
     * 设置 票据对应的钱袋子数量,暂时没有记录每个钱袋子的编号
     *
     * @param packageNumber - 票据对应的钱袋子数量,暂时没有记录每个钱袋子的编号
     */
    public ComprobantesBean setPackageNumber(Integer packageNumber) {
        this.packageNumber = packageNumber;
        return this;
    }

    /**
     * 获取 票据对应的钱袋子编号,多个编号以|隔开,例|123|456|789|
     *
     * @return comprobantes_bag_serial_numbers - 票据对应的钱袋子编号,多个编号以|隔开,例|123|456|789|
     */
    public String getBagSerialNumbers() {
        return bagSerialNumbers;
    }

    /**
     * 设置 票据对应的钱袋子编号,多个编号以|隔开,例|123|456|789|
     *
     * @param bagSerialNumbers - 票据对应的钱袋子编号,多个编号以|隔开,例|123|456|789|
     */
    public ComprobantesBean setBagSerialNumbers(String bagSerialNumbers) {
        this.bagSerialNumbers = bagSerialNumbers == null ? null : bagSerialNumbers.trim();
        return this;
    }

    /**
     * 获取 所有钱袋子加起来总金额
     *
     * @return comprobantes_amount - 所有钱袋子加起来总金额
     */
    public BigDecimal getAmount() {
        return amount;
    }

    /**
     * 设置 所有钱袋子加起来总金额
     *
     * @param amount - 所有钱袋子加起来总金额
     */
    public ComprobantesBean setAmount(BigDecimal amount) {
        this.amount = amount;
        return this;
    }

    /**
     * 获取 拍照图片文件名
     *
     * @return comprobantes_evidence_picture - 拍照图片文件名
     */
    public String getEvidencePicture() {
        return evidencePicture;
    }

    /**
     * 设置 拍照图片文件名
     *
     * @param evidencePicture - 拍照图片文件名
     */
    public ComprobantesBean setEvidencePicture(String evidencePicture) {
        this.evidencePicture = evidencePicture == null ? null : evidencePicture.trim();
        return this;
    }

    /**
     * 获取 签名图片文件名
     *
     * @return comprobantes_signature_picture - 签名图片文件名
     */
    public String getSignaturePicture() {
        return signaturePicture;
    }

    /**
     * 设置 签名图片文件名
     *
     * @param signaturePicture - 签名图片文件名
     */
    public ComprobantesBean setSignaturePicture(String signaturePicture) {
        this.signaturePicture = signaturePicture == null ? null : signaturePicture.trim();
        return this;
    }

    /**
     * 获取 client To client 任务类型时，在客户取钱后拍照图片文件名
     *
     * @return comprobantes_part_evidence_picture - client To client 任务类型时，在客户取钱后拍照图片文件名
     */
    public String getPartEvidencePicture() {
        return partEvidencePicture;
    }

    /**
     * 设置 client To client 任务类型时，在客户取钱后拍照图片文件名
     *
     * @param partEvidencePicture - client To client 任务类型时，在客户取钱后拍照图片文件名
     */
    public ComprobantesBean setPartEvidencePicture(String partEvidencePicture) {
        this.partEvidencePicture = partEvidencePicture == null ? null : partEvidencePicture.trim();
        return this;
    }

    /**
     * 获取 client To client 任务类型时，在客户取钱后签名图片文件名
     *
     * @return comprobantes_part_signature_picture - client To client 任务类型时，在客户取钱后签名图片文件名
     */
    public String getPartSignaturePicture() {
        return partSignaturePicture;
    }

    /**
     * 设置 client To client 任务类型时，在客户取钱后签名图片文件名
     *
     * @param partSignaturePicture - client To client 任务类型时，在客户取钱后签名图片文件名
     */
    public ComprobantesBean setPartSignaturePicture(String partSignaturePicture) {
        this.partSignaturePicture = partSignaturePicture == null ? null : partSignaturePicture.trim();
        return this;
    }

    /**
     * 获取 取消票据的,责任方【CIT,CLIENT】
     *
     * @return comprobantes_cancel_responsible_party - 取消票据的,责任方【CIT,CLIENT】
     */
    public String getCancelResponsibleParty() {
        return cancelResponsibleParty;
    }

    /**
     * 设置 取消票据的,责任方【CIT,CLIENT】
     *
     * @param cancelResponsibleParty - 取消票据的,责任方【CIT,CLIENT】
     */
    public ComprobantesBean setCancelResponsibleParty(String cancelResponsibleParty) {
        this.cancelResponsibleParty = cancelResponsibleParty == null ? null : cancelResponsibleParty.trim();
        return this;
    }

    /**
     * 获取 取消票据的,回执行单【目前需求,只有责任方为Client时,才有回执单】
     *
     * @return comprobantes_cancel_single_receipt - 取消票据的,回执行单【目前需求,只有责任方为Client时,才有回执单】
     */
    public String getCancelSingleReceipt() {
        return cancelSingleReceipt;
    }

    /**
     * 设置 取消票据的,回执行单【目前需求,只有责任方为Client时,才有回执单】
     *
     * @param cancelSingleReceipt - 取消票据的,回执行单【目前需求,只有责任方为Client时,才有回执单】
     */
    public ComprobantesBean setCancelSingleReceipt(String cancelSingleReceipt) {
        this.cancelSingleReceipt = cancelSingleReceipt == null ? null : cancelSingleReceipt.trim();
        return this;
    }

    /**
     * 获取 取消票据的,理由,t_setting.setting_key,关联
     *
     * @return comprobantes_cancel_reason - 取消票据的,理由,t_setting.setting_key,关联
     */
    public String getCancelReason() {
        return cancelReason;
    }

    /**
     * 设置 取消票据的,理由,t_setting.setting_key,关联
     *
     * @param cancelReason - 取消票据的,理由,t_setting.setting_key,关联
     */
    public ComprobantesBean setCancelReason(String cancelReason) {
        this.cancelReason = cancelReason == null ? null : cancelReason.trim();
        return this;
    }

    /**
     * 获取 取消票据的,钱回退处
     *
     * @return comprobantes_cancel_money_back_party - 取消票据的,钱回退处
     */
    public String getCancelMoneyBackParty() {
        return cancelMoneyBackParty;
    }

    /**
     * 设置 取消票据的,钱回退处
     *
     * @param cancelMoneyBackParty - 取消票据的,钱回退处
     */
    public ComprobantesBean setCancelMoneyBackParty(String cancelMoneyBackParty) {
        this.cancelMoneyBackParty = cancelMoneyBackParty == null ? null : cancelMoneyBackParty.trim();
        return this;
    }

    /**
     * 获取 取消票据的备注
     *
     * @return comprobantes_cancel_comment - 取消票据的备注
     */
    public String getCancelComment() {
        return cancelComment;
    }

    /**
     * 设置 取消票据的备注
     *
     * @param cancelComment - 取消票据的备注
     */
    public ComprobantesBean setCancelComment(String cancelComment) {
        this.cancelComment = cancelComment == null ? null : cancelComment.trim();
        return this;
    }

    /**
     * 获取 客户网点代号
     *
     * @return comprobantes_branch_code - 客户网点代号
     */
    public String getBranchCode() {
        return branchCode;
    }

    /**
     * 设置 客户网点代号
     *
     * @param branchCode - 客户网点代号
     */
    public ComprobantesBean setBranchCode(String branchCode) {
        this.branchCode = branchCode == null ? null : branchCode.trim();
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
    public ComprobantesBean setCreateTimestamp(Date createTimestamp) {
        this.createTimestamp = createTimestamp;
        return this;
    }

    /**
     *
     * @return comprobantes_update_timestamp
     */
    public Date getUpdateTimestamp() {
        return updateTimestamp;
    }

    /**
     *
     * @param updateTimestamp - 
     */
    public ComprobantesBean setUpdateTimestamp(Date updateTimestamp) {
        this.updateTimestamp = updateTimestamp;
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
    public ComprobantesBean setCreateBy(String createBy) {
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
    public ComprobantesBean setDeleteFlag(String deleteFlag) {
        this.deleteFlag = deleteFlag == null ? null : deleteFlag.trim();
        return this;
    }

    /**
     * 获取 票据来源，哪一方生成的任务【SIO公司导入进来分两种：[SIO_0_KIOSKOLIN、SIO_1_COMODIN]，COMODIN[comodin手工创建]，EXCEL[excel批量导入]】
     *
     * @return comprobantes_generate_source_party - 票据来源，哪一方生成的任务【SIO公司导入进来分两种：[SIO_0_KIOSKOLIN、SIO_1_COMODIN]，COMODIN[comodin手工创建]，EXCEL[excel批量导入]】
     */
    public String getGenerateSourceParty() {
        return generateSourceParty;
    }

    /**
     * 设置 票据来源，哪一方生成的任务【SIO公司导入进来分两种：[SIO_0_KIOSKOLIN、SIO_1_COMODIN]，COMODIN[comodin手工创建]，EXCEL[excel批量导入]】
     *
     * @param generateSourceParty - 票据来源，哪一方生成的任务【SIO公司导入进来分两种：[SIO_0_KIOSKOLIN、SIO_1_COMODIN]，COMODIN[comodin手工创建]，EXCEL[excel批量导入]】
     */
    public ComprobantesBean setGenerateSourceParty(String generateSourceParty) {
        this.generateSourceParty = generateSourceParty == null ? null : generateSourceParty.trim();
        return this;
    }

    /**
     * 获取 票据来源，原始Comprobantes号，【date:2016-12-12 by:supeng】
     *
     * @return comprobantes_source_bill_original_code - 票据来源，原始Comprobantes号，【date:2016-12-12 by:supeng】
     */
    public String getSourceBillOriginalCode() {
        return sourceBillOriginalCode;
    }

    /**
     * 设置 票据来源，原始Comprobantes号，【date:2016-12-12 by:supeng】
     *
     * @param sourceBillOriginalCode - 票据来源，原始Comprobantes号，【date:2016-12-12 by:supeng】
     */
    public ComprobantesBean setSourceBillOriginalCode(String sourceBillOriginalCode) {
        this.sourceBillOriginalCode = sourceBillOriginalCode == null ? null : sourceBillOriginalCode.trim();
        return this;
    }
}