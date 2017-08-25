package com.comodin.fleet.core.bean;

import com.comodin.basic.util.date.DateUtil;
import com.comodin.basic.validation.IBaseValidGroup;
import com.comodin.basic.validation.constraints.ValidAllowData;
import com.comodin.basic.validation.constraints.ValidDateTimeFormat;
import com.comodin.basic.validation.constraints.ValidLength;
import com.comodin.fleet.constants.bean.AtmClientTerminalRecordBeanConstant;
import com.comodin.fleet.constants.i18n.AtmClientTerminalRecordBeanI18nConstant;
import org.hibernate.validator.constraints.Length;
import org.hibernate.validator.constraints.NotBlank;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.io.Serializable;
import java.util.Date;

@SuppressWarnings({"unused", "UnusedReturnValue", "SameParameterValue", "DefaultAnnotationParam"})
@Entity
@Table(name = "t_atm_client_terminal_record")
public class AtmClientTerminalRecordBean implements Serializable {
    /**
     * <pre>
     * DB remark: 数据库主键ID
     * DB column: record_id	BIGINT(20)	<--->	id	java.lang.Long
     * DB is  Nullable: false
     * DB defaultValue: null
     * </pre>
     */
    @NotNull(message = "{" + AtmClientTerminalRecordBeanI18nConstant.ATM_CLIENT_TERMINAL_RECORD_BEAN_ID_NOT_NULL + "}", groups = {IBaseValidGroup.Update.class})
    @ValidLength(max = 20, message = "{" + AtmClientTerminalRecordBeanI18nConstant.ATM_CLIENT_TERMINAL_RECORD_BEAN_ID_LENGTH + "}", groups = {IBaseValidGroup.Update.class})
    @Column(name = "record_id", length = 20, nullable = false)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    private Long id;

    /**
     * <pre>
     * DB remark: ATM终端，唯一标识
     * DB column: record_atm_terminal_id	VARCHAR(64)	<--->	atmTerminalId	java.lang.String
     * DB is  Nullable: false
     * DB defaultValue: null
     * </pre>
     */
    @NotBlank(message = "{" + AtmClientTerminalRecordBeanI18nConstant.ATM_CLIENT_TERMINAL_RECORD_BEAN_ATM_TERMINAL_ID_NOT_BLANK + "}", groups = {IBaseValidGroup.Add.class, IBaseValidGroup.Update.class})
    @Length(max = 64, message = "{" + AtmClientTerminalRecordBeanI18nConstant.ATM_CLIENT_TERMINAL_RECORD_BEAN_ATM_TERMINAL_ID_LENGTH + "}", groups = {IBaseValidGroup.Add.class, IBaseValidGroup.Update.class})
    @Column(name = "record_atm_terminal_id", length = 64, nullable = false)
    private String atmTerminalId;

    /**
     * <pre>
     * DB remark: ATM终端，读取记录的类型【{"dataList":["TRANSACTION_RECORD","DEVICE_STATUS_RECORD","CASSETTE_STATUS_RECORD"]}】
     * DB column: record_read_record_type	VARCHAR(20)	<--->	readRecordType	java.lang.String
     * DB is  Nullable: false
     * DB defaultValue: null
     * </pre>
     */
    @ValidAllowData(allowDataArray = {AtmClientTerminalRecordBeanConstant.ATM_CLIENT_TERMINAL_RECORD_BEAN_READ_RECORD_TYPE_CASSETTE_STATUS_RECORD,AtmClientTerminalRecordBeanConstant.ATM_CLIENT_TERMINAL_RECORD_BEAN_READ_RECORD_TYPE_TRANSACTION_RECORD,AtmClientTerminalRecordBeanConstant.ATM_CLIENT_TERMINAL_RECORD_BEAN_READ_RECORD_TYPE_DEVICE_STATUS_RECORD}, message = "{" + AtmClientTerminalRecordBeanI18nConstant.ATM_CLIENT_TERMINAL_RECORD_BEAN_READ_RECORD_TYPE_ALLOW_DATA + "}", groups = {IBaseValidGroup.Add.class, IBaseValidGroup.Update.class})
    @NotBlank(message = "{" + AtmClientTerminalRecordBeanI18nConstant.ATM_CLIENT_TERMINAL_RECORD_BEAN_READ_RECORD_TYPE_NOT_BLANK + "}", groups = {IBaseValidGroup.Add.class, IBaseValidGroup.Update.class})
    @Length(max = 20, message = "{" + AtmClientTerminalRecordBeanI18nConstant.ATM_CLIENT_TERMINAL_RECORD_BEAN_READ_RECORD_TYPE_LENGTH + "}", groups = {IBaseValidGroup.Add.class, IBaseValidGroup.Update.class})
    @Column(name = "record_read_record_type", length = 20, nullable = false)
    private String readRecordType;

    /**
     * <pre>
     * DB remark: ATM终端，上次读取记录
     * DB column: record_last_read_date_time	VARCHAR(20)	<--->	lastReadDateTime	java.lang.String
     * DB is  Nullable: false
     * DB defaultValue: null
     * </pre>
     */
    @NotBlank(message = "{" + AtmClientTerminalRecordBeanI18nConstant.ATM_CLIENT_TERMINAL_RECORD_BEAN_LAST_READ_DATE_TIME_NOT_BLANK + "}", groups = {IBaseValidGroup.Add.class, IBaseValidGroup.Update.class})
    @Length(max = 20, message = "{" + AtmClientTerminalRecordBeanI18nConstant.ATM_CLIENT_TERMINAL_RECORD_BEAN_LAST_READ_DATE_TIME_LENGTH + "}", groups = {IBaseValidGroup.Add.class, IBaseValidGroup.Update.class})
    @Column(name = "record_last_read_date_time", length = 20, nullable = false)
    private String lastReadDateTime;

    /**
     * <pre>
     * DB remark: 创建的用户
     * DB column: record_create_by	VARCHAR(20)	<--->	createBy	java.lang.String
     * DB is  Nullable: false
     * DB defaultValue: null
     * </pre>
     */
    @NotBlank(message = "{" + AtmClientTerminalRecordBeanI18nConstant.ATM_CLIENT_TERMINAL_RECORD_BEAN_CREATE_BY_NOT_BLANK + "}", groups = {IBaseValidGroup.Add.class, IBaseValidGroup.Update.class})
    @Length(max = 20, message = "{" + AtmClientTerminalRecordBeanI18nConstant.ATM_CLIENT_TERMINAL_RECORD_BEAN_CREATE_BY_LENGTH + "}", groups = {IBaseValidGroup.Add.class, IBaseValidGroup.Update.class})
    @Column(name = "record_create_by", length = 20, nullable = false)
    private String createBy;

    /**
     * <pre>
     * DB remark: 创建时间
     * DB column: record_create_timestamp	TIMESTAMP(19)	<--->	createTimestamp	java.util.Date
     * DB is  Nullable: false
     * DB defaultValue: CURRENT_TIMESTAMP
     * </pre>
     */
    @ValidDateTimeFormat(pattern = DateUtil.DATE_PATTERN_YYYY_MM_DD_HH_MM_SS, message = "{" + AtmClientTerminalRecordBeanI18nConstant.ATM_CLIENT_TERMINAL_RECORD_BEAN_CREATE_TIMESTAMP_DATE_TIME_FORMAT + "}", groups = {IBaseValidGroup.Add.class, IBaseValidGroup.Update.class})
    @DateTimeFormat(pattern = DateUtil.DATE_PATTERN_YYYY_MM_DD_HH_MM_SS)
    @NotNull(message = "{" + AtmClientTerminalRecordBeanI18nConstant.ATM_CLIENT_TERMINAL_RECORD_BEAN_CREATE_TIMESTAMP_NOT_NULL + "}", groups = {IBaseValidGroup.Add.class, IBaseValidGroup.Update.class})
    @Column(name = "record_create_timestamp", length = 19, nullable = false)
    private Date createTimestamp;

    /**
     * <pre>
     * DB remark: 更新时间
     * DB column: record_update_timestamp	TIMESTAMP(19)	<--->	updateTimestamp	java.util.Date
     * DB is  Nullable: false
     * DB defaultValue: CURRENT_TIMESTAMP
     * </pre>
     */
    @ValidDateTimeFormat(pattern = DateUtil.DATE_PATTERN_YYYY_MM_DD_HH_MM_SS, message = "{" + AtmClientTerminalRecordBeanI18nConstant.ATM_CLIENT_TERMINAL_RECORD_BEAN_UPDATE_TIMESTAMP_DATE_TIME_FORMAT + "}", groups = {IBaseValidGroup.Add.class, IBaseValidGroup.Update.class})
    @DateTimeFormat(pattern = DateUtil.DATE_PATTERN_YYYY_MM_DD_HH_MM_SS)
    @NotNull(message = "{" + AtmClientTerminalRecordBeanI18nConstant.ATM_CLIENT_TERMINAL_RECORD_BEAN_UPDATE_TIMESTAMP_NOT_NULL + "}", groups = {IBaseValidGroup.Add.class, IBaseValidGroup.Update.class})
    @Column(name = "record_update_timestamp", length = 19, nullable = false)
    private Date updateTimestamp;

    /**
     * <pre>
     * DB remark: 逻辑删除标志【N[正常]，Y[删除]】
     * DB column: record_delete_flag	CHAR(1)	<--->	deleteFlag	java.lang.String
     * DB is  Nullable: false
     * DB defaultValue: N
     * </pre>
     */
    @NotBlank(message = "{" + AtmClientTerminalRecordBeanI18nConstant.ATM_CLIENT_TERMINAL_RECORD_BEAN_DELETE_FLAG_NOT_BLANK + "}", groups = {IBaseValidGroup.Add.class, IBaseValidGroup.Update.class})
    @Length(max = 1, message = "{" + AtmClientTerminalRecordBeanI18nConstant.ATM_CLIENT_TERMINAL_RECORD_BEAN_DELETE_FLAG_LENGTH + "}", groups = {IBaseValidGroup.Add.class, IBaseValidGroup.Update.class})
    @Column(name = "record_delete_flag", length = 1, nullable = false)
    private String deleteFlag;

    private static final long serialVersionUID = 1L;

    /**
     * 获取 数据库主键ID
     *
     * @return record_id - 数据库主键ID
     */
    public Long getId() {
        return id;
    }

    /**
     * 设置 数据库主键ID
     *
     * @param id - 数据库主键ID
     */
    public AtmClientTerminalRecordBean setId(Long id) {
        this.id = id;
        return this;
    }

    /**
     * 获取 ATM终端，唯一标识
     *
     * @return record_atm_terminal_id - ATM终端，唯一标识
     */
    public String getAtmTerminalId() {
        return atmTerminalId;
    }

    /**
     * 设置 ATM终端，唯一标识
     *
     * @param atmTerminalId - ATM终端，唯一标识
     */
    public AtmClientTerminalRecordBean setAtmTerminalId(String atmTerminalId) {
        this.atmTerminalId = atmTerminalId == null ? null : atmTerminalId.trim();
        return this;
    }

    /**
     * 获取 ATM终端，读取记录的类型【{"dataList":["TRANSACTION_RECORD","DEVICE_STATUS_RECORD","CASSETTE_STATUS_RECORD"]}】
     *
     * @return record_read_record_type - ATM终端，读取记录的类型【{"dataList":["TRANSACTION_RECORD","DEVICE_STATUS_RECORD","CASSETTE_STATUS_RECORD"]}】
     */
    public String getReadRecordType() {
        return readRecordType;
    }

    /**
     * 设置 ATM终端，读取记录的类型【{"dataList":["TRANSACTION_RECORD","DEVICE_STATUS_RECORD","CASSETTE_STATUS_RECORD"]}】
     *
     * @param readRecordType - ATM终端，读取记录的类型【{"dataList":["TRANSACTION_RECORD","DEVICE_STATUS_RECORD","CASSETTE_STATUS_RECORD"]}】
     */
    public AtmClientTerminalRecordBean setReadRecordType(String readRecordType) {
        this.readRecordType = readRecordType == null ? null : readRecordType.trim();
        return this;
    }

    /**
     * 获取 ATM终端，上次读取记录
     *
     * @return record_last_read_date_time - ATM终端，上次读取记录
     */
    public String getLastReadDateTime() {
        return lastReadDateTime;
    }

    /**
     * 设置 ATM终端，上次读取记录
     *
     * @param lastReadDateTime - ATM终端，上次读取记录
     */
    public AtmClientTerminalRecordBean setLastReadDateTime(String lastReadDateTime) {
        this.lastReadDateTime = lastReadDateTime == null ? null : lastReadDateTime.trim();
        return this;
    }

    /**
     * 获取 创建的用户
     *
     * @return record_create_by - 创建的用户
     */
    public String getCreateBy() {
        return createBy;
    }

    /**
     * 设置 创建的用户
     *
     * @param createBy - 创建的用户
     */
    public AtmClientTerminalRecordBean setCreateBy(String createBy) {
        this.createBy = createBy == null ? null : createBy.trim();
        return this;
    }

    /**
     * 获取 创建时间
     *
     * @return record_create_timestamp - 创建时间
     */
    public Date getCreateTimestamp() {
        return createTimestamp;
    }

    /**
     * 设置 创建时间
     *
     * @param createTimestamp - 创建时间
     */
    public AtmClientTerminalRecordBean setCreateTimestamp(Date createTimestamp) {
        this.createTimestamp = createTimestamp;
        return this;
    }

    /**
     * 获取 更新时间
     *
     * @return record_update_timestamp - 更新时间
     */
    public Date getUpdateTimestamp() {
        return updateTimestamp;
    }

    /**
     * 设置 更新时间
     *
     * @param updateTimestamp - 更新时间
     */
    public AtmClientTerminalRecordBean setUpdateTimestamp(Date updateTimestamp) {
        this.updateTimestamp = updateTimestamp;
        return this;
    }

    /**
     * 获取 逻辑删除标志【N[正常]，Y[删除]】
     *
     * @return record_delete_flag - 逻辑删除标志【N[正常]，Y[删除]】
     */
    public String getDeleteFlag() {
        return deleteFlag;
    }

    /**
     * 设置 逻辑删除标志【N[正常]，Y[删除]】
     *
     * @param deleteFlag - 逻辑删除标志【N[正常]，Y[删除]】
     */
    public AtmClientTerminalRecordBean setDeleteFlag(String deleteFlag) {
        this.deleteFlag = deleteFlag == null ? null : deleteFlag.trim();
        return this;
    }
}