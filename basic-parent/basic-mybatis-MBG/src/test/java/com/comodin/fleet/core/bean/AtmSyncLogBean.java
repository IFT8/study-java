package com.comodin.fleet.core.bean;

import com.comodin.basic.util.date.DateUtil;
import com.comodin.basic.validation.IBaseValidGroup;
import com.comodin.basic.validation.constraints.*;
import com.comodin.fleet.constants.bean.AtmSyncLogBeanConstant;
import com.comodin.fleet.constants.i18n.AtmSyncLogBeanI18nConstant;
import java.io.Serializable;
import java.util.Date;
import javax.persistence.*;
import javax.validation.constraints.*;
import org.hibernate.validator.constraints.*;
import org.springframework.format.annotation.DateTimeFormat;

@SuppressWarnings({"unused", "SpringAutowiredFieldsWarningInspection", "StatementWithEmptyBody", "WeakerAccess"})
@Entity
@Table(name = "t_atm_sync_log")
public class AtmSyncLogBean implements Serializable {
    /**
     * <pre>
     * DB remark: 数据库主键ID
     * DB column: sync_id	BIGINT(20)	<--->	id	java.lang.Long
     * DB is  Nullable: false
     * DB defaultValue: null
     * </pre>
     */
    @NotNull(message = "{" + AtmSyncLogBeanI18nConstant.ATM_SYNC_LOG_BEAN_ID_NOT_NULL + "}", groups = {IBaseValidGroup.Update.class})
    @ValidLength(max = 20, message = "{" + AtmSyncLogBeanI18nConstant.ATM_SYNC_LOG_BEAN_ID_LENGTH + "}", groups = {IBaseValidGroup.Update.class})
    @Column(name = "sync_id", length = 20, nullable = false)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    private Long id;

    /**
     * <pre>
     * DB remark: ATM终端，唯一标识
     * DB column: sync_atm_terminal_id	VARCHAR(64)	<--->	atmTerminalId	java.lang.String
     * DB is  Nullable: false
     * DB defaultValue: null
     * </pre>
     */
    @NotBlank(message = "{" + AtmSyncLogBeanI18nConstant.ATM_SYNC_LOG_BEAN_ATM_TERMINAL_ID_NOT_BLANK + "}", groups = {IBaseValidGroup.Add.class, IBaseValidGroup.Update.class})
    @Length(max = 64, message = "{" + AtmSyncLogBeanI18nConstant.ATM_SYNC_LOG_BEAN_ATM_TERMINAL_ID_LENGTH + "}", groups = {IBaseValidGroup.Add.class, IBaseValidGroup.Update.class})
    @Column(name = "sync_atm_terminal_id", length = 64, nullable = false)
    private String atmTerminalId;

    /**
     * <pre>
     * DB remark: ATM终端，读取记录的类型【{"dataList":["SYNC_TRANSACTION","SYNC_DEVICE_STATUS","SYNC_CASSETTE_STATUS"]}】
     * DB column: sync_type	VARCHAR(20)	<--->	type	java.lang.String
     * DB is  Nullable: false
     * DB defaultValue: null
     * </pre>
     */
    @ValidAllowData(allowDataArray = {AtmSyncLogBeanConstant.ATM_SYNC_LOG_BEAN_TYPE_SYNC_DEVICE_STATUS,AtmSyncLogBeanConstant.ATM_SYNC_LOG_BEAN_TYPE_SYNC_TRANSACTION,AtmSyncLogBeanConstant.ATM_SYNC_LOG_BEAN_TYPE_SYNC_CASSETTE_STATUS}, message = "{" + AtmSyncLogBeanI18nConstant.ATM_SYNC_LOG_BEAN_TYPE_ALLOW_DATA + "}", groups = {IBaseValidGroup.Add.class, IBaseValidGroup.Update.class})
    @NotBlank(message = "{" + AtmSyncLogBeanI18nConstant.ATM_SYNC_LOG_BEAN_TYPE_NOT_BLANK + "}", groups = {IBaseValidGroup.Add.class, IBaseValidGroup.Update.class})
    @Length(max = 20, message = "{" + AtmSyncLogBeanI18nConstant.ATM_SYNC_LOG_BEAN_TYPE_LENGTH + "}", groups = {IBaseValidGroup.Add.class, IBaseValidGroup.Update.class})
    @Column(name = "sync_type", length = 20, nullable = false)
    private String type;

    /**
     * <pre>
     * DB remark: ATM终端，上次读取记录
     * DB column: sync_last_time	VARCHAR(20)	<--->	lastTime	java.lang.String
     * DB is  Nullable: false
     * DB defaultValue: null
     * </pre>
     */
    @NotBlank(message = "{" + AtmSyncLogBeanI18nConstant.ATM_SYNC_LOG_BEAN_LAST_TIME_NOT_BLANK + "}", groups = {IBaseValidGroup.Add.class, IBaseValidGroup.Update.class})
    @Length(max = 20, message = "{" + AtmSyncLogBeanI18nConstant.ATM_SYNC_LOG_BEAN_LAST_TIME_LENGTH + "}", groups = {IBaseValidGroup.Add.class, IBaseValidGroup.Update.class})
    @Column(name = "sync_last_time", length = 20, nullable = false)
    private String lastTime;

    /**
     * <pre>
     * DB remark: 创建的用户
     * DB column: sync_create_by	VARCHAR(20)	<--->	createBy	java.lang.String
     * DB is  Nullable: false
     * DB defaultValue: null
     * </pre>
     */
    @NotBlank(message = "{" + AtmSyncLogBeanI18nConstant.ATM_SYNC_LOG_BEAN_CREATE_BY_NOT_BLANK + "}", groups = {IBaseValidGroup.Add.class, IBaseValidGroup.Update.class})
    @Length(max = 20, message = "{" + AtmSyncLogBeanI18nConstant.ATM_SYNC_LOG_BEAN_CREATE_BY_LENGTH + "}", groups = {IBaseValidGroup.Add.class, IBaseValidGroup.Update.class})
    @Column(name = "sync_create_by", length = 20, nullable = false)
    private String createBy;

    /**
     * <pre>
     * DB remark: 创建时间
     * DB column: sync_create_timestamp	TIMESTAMP(19)	<--->	createTimestamp	java.util.Date
     * DB is  Nullable: false
     * DB defaultValue: CURRENT_TIMESTAMP
     * </pre>
     */
    @ValidDateTimeFormat(pattern = DateUtil.DATE_PATTERN_YYYY_MM_DD_HH_MM_SS, message = "{" + AtmSyncLogBeanI18nConstant.ATM_SYNC_LOG_BEAN_CREATE_TIMESTAMP_DATE_TIME_FORMAT + "}", groups = {IBaseValidGroup.Add.class, IBaseValidGroup.Update.class})
    @DateTimeFormat(pattern = DateUtil.DATE_PATTERN_YYYY_MM_DD_HH_MM_SS)
    @NotNull(message = "{" + AtmSyncLogBeanI18nConstant.ATM_SYNC_LOG_BEAN_CREATE_TIMESTAMP_NOT_NULL + "}", groups = {IBaseValidGroup.Add.class, IBaseValidGroup.Update.class})
    @Column(name = "sync_create_timestamp", length = 19, nullable = false)
    private Date createTimestamp;

    /**
     * <pre>
     * DB remark: 更新时间
     * DB column: sync_update_timestamp	TIMESTAMP(19)	<--->	updateTimestamp	java.util.Date
     * DB is  Nullable: false
     * DB defaultValue: CURRENT_TIMESTAMP
     * </pre>
     */
    @ValidDateTimeFormat(pattern = DateUtil.DATE_PATTERN_YYYY_MM_DD_HH_MM_SS, message = "{" + AtmSyncLogBeanI18nConstant.ATM_SYNC_LOG_BEAN_UPDATE_TIMESTAMP_DATE_TIME_FORMAT + "}", groups = {IBaseValidGroup.Add.class, IBaseValidGroup.Update.class})
    @DateTimeFormat(pattern = DateUtil.DATE_PATTERN_YYYY_MM_DD_HH_MM_SS)
    @NotNull(message = "{" + AtmSyncLogBeanI18nConstant.ATM_SYNC_LOG_BEAN_UPDATE_TIMESTAMP_NOT_NULL + "}", groups = {IBaseValidGroup.Add.class, IBaseValidGroup.Update.class})
    @Column(name = "sync_update_timestamp", length = 19, nullable = false)
    private Date updateTimestamp;

    /**
     * <pre>
     * DB remark: 逻辑删除标志【N[正常]，Y[删除]】
     * DB column: sync_delete_flag	CHAR(1)	<--->	deleteFlag	java.lang.String
     * DB is  Nullable: false
     * DB defaultValue: N
     * </pre>
     */
    @NotBlank(message = "{" + AtmSyncLogBeanI18nConstant.ATM_SYNC_LOG_BEAN_DELETE_FLAG_NOT_BLANK + "}", groups = {IBaseValidGroup.Add.class, IBaseValidGroup.Update.class})
    @Length(max = 1, message = "{" + AtmSyncLogBeanI18nConstant.ATM_SYNC_LOG_BEAN_DELETE_FLAG_LENGTH + "}", groups = {IBaseValidGroup.Add.class, IBaseValidGroup.Update.class})
    @Column(name = "sync_delete_flag", length = 1, nullable = false)
    private String deleteFlag;

    private static final long serialVersionUID = 1L;

    /**
     * 获取 数据库主键ID
     *
     * @return sync_id - 数据库主键ID
     */
    public Long getId() {
        return id;
    }

    /**
     * 设置 数据库主键ID
     *
     * @param id - 数据库主键ID
     */
    public AtmSyncLogBean setId(Long id) {
        this.id = id;
        return this;
    }

    /**
     * 获取 ATM终端，唯一标识
     *
     * @return sync_atm_terminal_id - ATM终端，唯一标识
     */
    public String getAtmTerminalId() {
        return atmTerminalId;
    }

    /**
     * 设置 ATM终端，唯一标识
     *
     * @param atmTerminalId - ATM终端，唯一标识
     */
    public AtmSyncLogBean setAtmTerminalId(String atmTerminalId) {
        this.atmTerminalId = atmTerminalId == null ? null : atmTerminalId.trim();
        return this;
    }

    /**
     * 获取 ATM终端，读取记录的类型【{"dataList":["SYNC_TRANSACTION","SYNC_DEVICE_STATUS","SYNC_CASSETTE_STATUS"]}】
     *
     * @return sync_type - ATM终端，读取记录的类型【{"dataList":["SYNC_TRANSACTION","SYNC_DEVICE_STATUS","SYNC_CASSETTE_STATUS"]}】
     */
    public String getType() {
        return type;
    }

    /**
     * 设置 ATM终端，读取记录的类型【{"dataList":["SYNC_TRANSACTION","SYNC_DEVICE_STATUS","SYNC_CASSETTE_STATUS"]}】
     *
     * @param type - ATM终端，读取记录的类型【{"dataList":["SYNC_TRANSACTION","SYNC_DEVICE_STATUS","SYNC_CASSETTE_STATUS"]}】
     */
    public AtmSyncLogBean setType(String type) {
        this.type = type == null ? null : type.trim();
        return this;
    }

    /**
     * 获取 ATM终端，上次读取记录
     *
     * @return sync_last_time - ATM终端，上次读取记录
     */
    public String getLastTime() {
        return lastTime;
    }

    /**
     * 设置 ATM终端，上次读取记录
     *
     * @param lastTime - ATM终端，上次读取记录
     */
    public AtmSyncLogBean setLastTime(String lastTime) {
        this.lastTime = lastTime == null ? null : lastTime.trim();
        return this;
    }

    /**
     * 获取 创建的用户
     *
     * @return sync_create_by - 创建的用户
     */
    public String getCreateBy() {
        return createBy;
    }

    /**
     * 设置 创建的用户
     *
     * @param createBy - 创建的用户
     */
    public AtmSyncLogBean setCreateBy(String createBy) {
        this.createBy = createBy == null ? null : createBy.trim();
        return this;
    }

    /**
     * 获取 创建时间
     *
     * @return sync_create_timestamp - 创建时间
     */
    public Date getCreateTimestamp() {
        return createTimestamp;
    }

    /**
     * 设置 创建时间
     *
     * @param createTimestamp - 创建时间
     */
    public AtmSyncLogBean setCreateTimestamp(Date createTimestamp) {
        this.createTimestamp = createTimestamp;
        return this;
    }

    /**
     * 获取 更新时间
     *
     * @return sync_update_timestamp - 更新时间
     */
    public Date getUpdateTimestamp() {
        return updateTimestamp;
    }

    /**
     * 设置 更新时间
     *
     * @param updateTimestamp - 更新时间
     */
    public AtmSyncLogBean setUpdateTimestamp(Date updateTimestamp) {
        this.updateTimestamp = updateTimestamp;
        return this;
    }

    /**
     * 获取 逻辑删除标志【N[正常]，Y[删除]】
     *
     * @return sync_delete_flag - 逻辑删除标志【N[正常]，Y[删除]】
     */
    public String getDeleteFlag() {
        return deleteFlag;
    }

    /**
     * 设置 逻辑删除标志【N[正常]，Y[删除]】
     *
     * @param deleteFlag - 逻辑删除标志【N[正常]，Y[删除]】
     */
    public AtmSyncLogBean setDeleteFlag(String deleteFlag) {
        this.deleteFlag = deleteFlag == null ? null : deleteFlag.trim();
        return this;
    }
}