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
@Table(name = "t_comprobantes_banknote")
public class ComprobantesBankNoteBean implements Serializable {
    /**
     * <pre>
     * DB remark: 数据库主键ID
     * DB column: banknote_id	BIGINT(20)	<--->	id	java.lang.Long
     * DB is  Nullable: false
     * DB defaultValue: null
     * </pre>
     */
    @NotNull(message = "{COMPROBANTES_BANK_NOTE_BEAN_ID_NOT_NULL}", groups = {IBaseValidGroup.Add.class, IBaseValidGroup.Update.class})
    @ValidLength(max = 20, message = "{COMPROBANTES_BANK_NOTE_BEAN_ID_LENGTH}", groups = {IBaseValidGroup.Add.class, IBaseValidGroup.Update.class})
    @Id
    @Column(name = "banknote_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    /**
     * <pre>
     * DB remark: 票据的编号,t_comprobantes.comprobantes_code,关联
     * DB column: banknote_comprobantes_code	VARCHAR(15)	<--->	comprobantesCode	java.lang.String
     * DB is  Nullable: false
     * DB defaultValue: null
     * </pre>
     */
    @NotBlank(message = "{COMPROBANTES_BANK_NOTE_BEAN_COMPROBANTES_CODE_NOT_BLANK}", groups = {IBaseValidGroup.Add.class, IBaseValidGroup.Update.class})
    @Length(max = 15, message = "{COMPROBANTES_BANK_NOTE_BEAN_COMPROBANTES_CODE_LENGTH}", groups = {IBaseValidGroup.Add.class, IBaseValidGroup.Update.class})
    @Column(name = "banknote_comprobantes_code")
    private String comprobantesCode;

    /**
     * <pre>
     * DB remark: 钞票种类,【PAPER[纸币],HARD[硬币]】
     * DB column: banknote_bank_note_type	CHAR(5)	<--->	bankNoteType	java.lang.String
     * DB is  Nullable: false
     * DB defaultValue: null
     * </pre>
     */
    @NotBlank(message = "{COMPROBANTES_BANK_NOTE_BEAN_BANK_NOTE_TYPE_NOT_BLANK}", groups = {IBaseValidGroup.Add.class, IBaseValidGroup.Update.class})
    @Length(max = 5, message = "{COMPROBANTES_BANK_NOTE_BEAN_BANK_NOTE_TYPE_LENGTH}", groups = {IBaseValidGroup.Add.class, IBaseValidGroup.Update.class})
    @Column(name = "banknote_bank_note_type")
    private String bankNoteType;

    /**
     * <pre>
     * DB remark: 钞票面值【墨西哥流通货币，货币编号MXN[比索]，目前发行硬币有5、10、20、50分及1、2、5、10、20、50、100比索；纸币有20、50、100、200、500、1000比索】【美国流通货币，货币编号USD[美金]，目前发行硬币有1￠、5￠、10￠、25￠[美分]；纸币有$1、$5、$10、$20、$100
     * DB column: banknote_denomination	DECIMAL(7)	<--->	denomination	java.math.BigDecimal
     * DB is  Nullable: false
     * DB defaultValue: null
     * </pre>
     */
    @Column(name = "banknote_denomination")
    private BigDecimal denomination;

    /**
     * <pre>
     * DB remark: 钞票数量
     * DB column: banknote_number	INTEGER(10)	<--->	number	java.lang.Integer
     * DB is  Nullable: false
     * DB defaultValue: null
     * </pre>
     */
    @NotNull(message = "{COMPROBANTES_BANK_NOTE_BEAN_NUMBER_NOT_NULL}", groups = {IBaseValidGroup.Add.class, IBaseValidGroup.Update.class})
    @ValidLength(max = 10, message = "{COMPROBANTES_BANK_NOTE_BEAN_NUMBER_LENGTH}", groups = {IBaseValidGroup.Add.class, IBaseValidGroup.Update.class})
    @Column(name = "banknote_number")
    private Integer number;

    /**
     * <pre>
     * DB remark: 状态【ENABLE[启用]、DISABLE[禁用]】
     * DB column: banknote_status	CHAR(7)	<--->	status	java.lang.String
     * DB is  Nullable: false
     * DB defaultValue: ENABLE
     * </pre>
     */
    @NotBlank(message = "{COMPROBANTES_BANK_NOTE_BEAN_STATUS_NOT_BLANK}", groups = {IBaseValidGroup.Add.class, IBaseValidGroup.Update.class})
    @Length(max = 7, message = "{COMPROBANTES_BANK_NOTE_BEAN_STATUS_LENGTH}", groups = {IBaseValidGroup.Add.class, IBaseValidGroup.Update.class})
    @Column(name = "banknote_status")
    private String status;

    /**
     * <pre>
     * DB remark: 创建时间
     * DB column: banknote_create_timestamp	TIMESTAMP(19)	<--->	createTimestamp	java.util.Date
     * DB is  Nullable: false
     * DB defaultValue: CURRENT_TIMESTAMP
     * </pre>
     */
    @ValidDateTimeFormat(pattern = DateUtil.DATE_PATTERN_YYYY_MM_DD_HH_MM_SS , message = "{COMPROBANTES_BANK_NOTE_BEAN_CREATE_TIMESTAMP_DATE_TIME_FORMAT}", groups = {IBaseValidGroup.Add.class, IBaseValidGroup.Update.class})
    @DateTimeFormat(pattern = DateUtil.DATE_PATTERN_YYYY_MM_DD_HH_MM_SS)
    @NotNull(message = "{COMPROBANTES_BANK_NOTE_BEAN_CREATE_TIMESTAMP_NOT_NULL}", groups = {IBaseValidGroup.Add.class, IBaseValidGroup.Update.class})
    @Column(name = "banknote_create_timestamp")
    private Date createTimestamp;

    /**
     * <pre>
     * DB remark: 谁新增了该员工,与crew_username字段关联
     * DB column: banknote_create_by	VARCHAR(20)	<--->	createBy	java.lang.String
     * DB is  Nullable: false
     * DB defaultValue: null
     * </pre>
     */
    @NotBlank(message = "{COMPROBANTES_BANK_NOTE_BEAN_CREATE_BY_NOT_BLANK}", groups = {IBaseValidGroup.Add.class, IBaseValidGroup.Update.class})
    @Length(max = 20, message = "{COMPROBANTES_BANK_NOTE_BEAN_CREATE_BY_LENGTH}", groups = {IBaseValidGroup.Add.class, IBaseValidGroup.Update.class})
    @Column(name = "banknote_create_by")
    private String createBy;

    /**
     * <pre>
     * DB remark: 逻辑删除标志【N[正常]，Y[删除]】
     * DB column: banknote_delete_flag	CHAR(1)	<--->	deleteFlag	java.lang.String
     * DB is  Nullable: false
     * DB defaultValue: N
     * </pre>
     */
    @NotBlank(message = "{COMPROBANTES_BANK_NOTE_BEAN_DELETE_FLAG_NOT_BLANK}", groups = {IBaseValidGroup.Add.class, IBaseValidGroup.Update.class})
    @Length(max = 1, message = "{COMPROBANTES_BANK_NOTE_BEAN_DELETE_FLAG_LENGTH}", groups = {IBaseValidGroup.Add.class, IBaseValidGroup.Update.class})
    @Column(name = "banknote_delete_flag")
    private String deleteFlag;

    private static final long serialVersionUID = 1L;

    /**
     * 获取 数据库主键ID
     *
     * @return banknote_id - 数据库主键ID
     */
    public Long getId() {
        return id;
    }

    /**
     * 设置 数据库主键ID
     *
     * @param id - 数据库主键ID
     */
    public ComprobantesBankNoteBean setId(Long id) {
        this.id = id;
        return this;
    }

    /**
     * 获取 票据的编号,t_comprobantes.comprobantes_code,关联
     *
     * @return banknote_comprobantes_code - 票据的编号,t_comprobantes.comprobantes_code,关联
     */
    public String getComprobantesCode() {
        return comprobantesCode;
    }

    /**
     * 设置 票据的编号,t_comprobantes.comprobantes_code,关联
     *
     * @param comprobantesCode - 票据的编号,t_comprobantes.comprobantes_code,关联
     */
    public ComprobantesBankNoteBean setComprobantesCode(String comprobantesCode) {
        this.comprobantesCode = comprobantesCode == null ? null : comprobantesCode.trim();
        return this;
    }

    /**
     * 获取 钞票种类,【PAPER[纸币],HARD[硬币]】
     *
     * @return banknote_bank_note_type - 钞票种类,【PAPER[纸币],HARD[硬币]】
     */
    public String getBankNoteType() {
        return bankNoteType;
    }

    /**
     * 设置 钞票种类,【PAPER[纸币],HARD[硬币]】
     *
     * @param bankNoteType - 钞票种类,【PAPER[纸币],HARD[硬币]】
     */
    public ComprobantesBankNoteBean setBankNoteType(String bankNoteType) {
        this.bankNoteType = bankNoteType == null ? null : bankNoteType.trim();
        return this;
    }

    /**
     * 获取 钞票面值【墨西哥流通货币，货币编号MXN[比索]，目前发行硬币有5、10、20、50分及1、2、5、10、20、50、100比索；纸币有20、50、100、200、500、1000比索】【美国流通货币，货币编号USD[美金]，目前发行硬币有1￠、5￠、10￠、25￠[美分]；纸币有$1、$5、$10、$20、$100
     *
     * @return banknote_denomination - 钞票面值【墨西哥流通货币，货币编号MXN[比索]，目前发行硬币有5、10、20、50分及1、2、5、10、20、50、100比索；纸币有20、50、100、200、500、1000比索】【美国流通货币，货币编号USD[美金]，目前发行硬币有1￠、5￠、10￠、25￠[美分]；纸币有$1、$5、$10、$20、$100
     */
    public BigDecimal getDenomination() {
        return denomination;
    }

    /**
     * 设置 钞票面值【墨西哥流通货币，货币编号MXN[比索]，目前发行硬币有5、10、20、50分及1、2、5、10、20、50、100比索；纸币有20、50、100、200、500、1000比索】【美国流通货币，货币编号USD[美金]，目前发行硬币有1￠、5￠、10￠、25￠[美分]；纸币有$1、$5、$10、$20、$100
     *
     * @param denomination - 钞票面值【墨西哥流通货币，货币编号MXN[比索]，目前发行硬币有5、10、20、50分及1、2、5、10、20、50、100比索；纸币有20、50、100、200、500、1000比索】【美国流通货币，货币编号USD[美金]，目前发行硬币有1￠、5￠、10￠、25￠[美分]；纸币有$1、$5、$10、$20、$100
     */
    public ComprobantesBankNoteBean setDenomination(BigDecimal denomination) {
        this.denomination = denomination;
        return this;
    }

    /**
     * 获取 钞票数量
     *
     * @return banknote_number - 钞票数量
     */
    public Integer getNumber() {
        return number;
    }

    /**
     * 设置 钞票数量
     *
     * @param number - 钞票数量
     */
    public ComprobantesBankNoteBean setNumber(Integer number) {
        this.number = number;
        return this;
    }

    /**
     * 获取 状态【ENABLE[启用]、DISABLE[禁用]】
     *
     * @return banknote_status - 状态【ENABLE[启用]、DISABLE[禁用]】
     */
    public String getStatus() {
        return status;
    }

    /**
     * 设置 状态【ENABLE[启用]、DISABLE[禁用]】
     *
     * @param status - 状态【ENABLE[启用]、DISABLE[禁用]】
     */
    public ComprobantesBankNoteBean setStatus(String status) {
        this.status = status == null ? null : status.trim();
        return this;
    }

    /**
     * 获取 创建时间
     *
     * @return banknote_create_timestamp - 创建时间
     */
    public Date getCreateTimestamp() {
        return createTimestamp;
    }

    /**
     * 设置 创建时间
     *
     * @param createTimestamp - 创建时间
     */
    public ComprobantesBankNoteBean setCreateTimestamp(Date createTimestamp) {
        this.createTimestamp = createTimestamp;
        return this;
    }

    /**
     * 获取 谁新增了该员工,与crew_username字段关联
     *
     * @return banknote_create_by - 谁新增了该员工,与crew_username字段关联
     */
    public String getCreateBy() {
        return createBy;
    }

    /**
     * 设置 谁新增了该员工,与crew_username字段关联
     *
     * @param createBy - 谁新增了该员工,与crew_username字段关联
     */
    public ComprobantesBankNoteBean setCreateBy(String createBy) {
        this.createBy = createBy == null ? null : createBy.trim();
        return this;
    }

    /**
     * 获取 逻辑删除标志【N[正常]，Y[删除]】
     *
     * @return banknote_delete_flag - 逻辑删除标志【N[正常]，Y[删除]】
     */
    public String getDeleteFlag() {
        return deleteFlag;
    }

    /**
     * 设置 逻辑删除标志【N[正常]，Y[删除]】
     *
     * @param deleteFlag - 逻辑删除标志【N[正常]，Y[删除]】
     */
    public ComprobantesBankNoteBean setDeleteFlag(String deleteFlag) {
        this.deleteFlag = deleteFlag == null ? null : deleteFlag.trim();
        return this;
    }
}