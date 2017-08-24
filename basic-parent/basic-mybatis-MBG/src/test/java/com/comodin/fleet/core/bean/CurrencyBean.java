package com.comodin.fleet.core.bean;

import com.comodin.basic.util.date.DateUtil;
import com.comodin.basic.validation.IBaseValidGroup;
import com.comodin.basic.validation.constraints.*;
import java.io.Serializable;
import java.util.Date;
import javax.persistence.*;
import javax.validation.constraints.*;
import org.hibernate.validator.constraints.*;
import org.springframework.format.annotation.DateTimeFormat;

@SuppressWarnings({"unused", "UnusedReturnValue", "SameParameterValue", "DefaultAnnotationParam"})
@Entity
@Table(name = "t_currency")
public class CurrencyBean implements Serializable {
    /**
     * <pre>
     * DB remark: 数据库主键ID
     * DB column: currency_id	BIGINT(20)	<--->	id	java.lang.Long
     * DB is  Nullable: false
     * DB defaultValue: null
     * </pre>
     */
    @NotNull(message = "{CURRENCY_BEAN_ID_NOT_NULL}", groups = {IBaseValidGroup.Add.class, IBaseValidGroup.Update.class})
    @ValidLength(max = 20, message = "{CURRENCY_BEAN_ID_LENGTH}", groups = {IBaseValidGroup.Add.class, IBaseValidGroup.Update.class})
    @Column(name = "currency_id", length = 20, nullable = false)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    private Long id;

    /**
     * <pre>
     * DB remark: 货币所属的分公司,与t_client.client_id 字段关联
     * DB column: currency_client_id	BIGINT(20)	<--->	clientId	java.lang.Long
     * DB is  Nullable: false
     * DB defaultValue: null
     * </pre>
     */
    @NotNull(message = "{CURRENCY_BEAN_CLIENT_ID_NOT_NULL}", groups = {IBaseValidGroup.Add.class, IBaseValidGroup.Update.class})
    @ValidLength(max = 20, message = "{CURRENCY_BEAN_CLIENT_ID_LENGTH}", groups = {IBaseValidGroup.Add.class, IBaseValidGroup.Update.class})
    @Column(name = "currency_client_id", length = 20, nullable = false)
    private Long clientId;

    /**
     * <pre>
     * DB remark: 货币内部ID，
     * DB column: currency_internal_id	VARCHAR(15)	<--->	internalId	java.lang.String
     * DB is  Nullable: true
     * DB defaultValue: null
     * </pre>
     */
    @Length(max = 15, message = "{CURRENCY_BEAN_INTERNAL_ID_LENGTH}", groups = {IBaseValidGroup.Add.class, IBaseValidGroup.Update.class})
    @Column(name = "currency_internal_id", length = 15, nullable = true)
    private String internalId;

    /**
     * <pre>
     * DB remark: 货币代码：ISO 4217:2008标准的货币代码简称
     * DB column: currency_iso_code	VARCHAR(5)	<--->	isoCode	java.lang.String
     * DB is  Nullable: false
     * DB defaultValue: null
     * </pre>
     */
    @NotBlank(message = "{CURRENCY_BEAN_ISO_CODE_NOT_BLANK}", groups = {IBaseValidGroup.Add.class, IBaseValidGroup.Update.class})
    @Length(max = 5, message = "{CURRENCY_BEAN_ISO_CODE_LENGTH}", groups = {IBaseValidGroup.Add.class, IBaseValidGroup.Update.class})
    @Column(name = "currency_iso_code", length = 5, nullable = false)
    private String isoCode;

    /**
     * <pre>
     * DB remark: 货币是否有效【ENABLE[启用]、DISABLE[禁用]】
     * DB column: currency_availability	CHAR(7)	<--->	availability	java.lang.String
     * DB is  Nullable: false
     * DB defaultValue: null
     * </pre>
     */
    @NotBlank(message = "{CURRENCY_BEAN_AVAILABILITY_NOT_BLANK}", groups = {IBaseValidGroup.Add.class, IBaseValidGroup.Update.class})
    @Length(max = 7, message = "{CURRENCY_BEAN_AVAILABILITY_LENGTH}", groups = {IBaseValidGroup.Add.class, IBaseValidGroup.Update.class})
    @Column(name = "currency_availability", length = 7, nullable = false)
    private String availability;

    /**
     * <pre>
     * DB remark: 创建人,与t_crew.crew_username字段关联
     * DB column: currency_create_by	VARCHAR(20)	<--->	createBy	java.lang.String
     * DB is  Nullable: false
     * DB defaultValue: null
     * </pre>
     */
    @NotBlank(message = "{CURRENCY_BEAN_CREATE_BY_NOT_BLANK}", groups = {IBaseValidGroup.Add.class, IBaseValidGroup.Update.class})
    @Length(max = 20, message = "{CURRENCY_BEAN_CREATE_BY_LENGTH}", groups = {IBaseValidGroup.Add.class, IBaseValidGroup.Update.class})
    @Column(name = "currency_create_by", length = 20, nullable = false)
    private String createBy;

    /**
     * <pre>
     * DB remark: 创建时间
     * DB column: currency_create_timestamp	TIMESTAMP(19)	<--->	createTimestamp	java.util.Date
     * DB is  Nullable: false
     * DB defaultValue: CURRENT_TIMESTAMP
     * </pre>
     */
    @ValidDateTimeFormat(pattern = DateUtil.DATE_PATTERN_YYYY_MM_DD_HH_MM_SS , message = "{CURRENCY_BEAN_CREATE_TIMESTAMP_DATE_TIME_FORMAT}", groups = {IBaseValidGroup.Add.class, IBaseValidGroup.Update.class})
    @DateTimeFormat(pattern = DateUtil.DATE_PATTERN_YYYY_MM_DD_HH_MM_SS)
    @NotNull(message = "{CURRENCY_BEAN_CREATE_TIMESTAMP_NOT_NULL}", groups = {IBaseValidGroup.Add.class, IBaseValidGroup.Update.class})
    @Column(name = "currency_create_timestamp", length = 19, nullable = false)
    private Date createTimestamp;

    /**
     * <pre>
     * DB remark: 更新时间
     * DB column: currency_update_timestamp	TIMESTAMP(19)	<--->	updateTimestamp	java.util.Date
     * DB is  Nullable: false
     * DB defaultValue: CURRENT_TIMESTAMP
     * </pre>
     */
    @ValidDateTimeFormat(pattern = DateUtil.DATE_PATTERN_YYYY_MM_DD_HH_MM_SS , message = "{CURRENCY_BEAN_UPDATE_TIMESTAMP_DATE_TIME_FORMAT}", groups = {IBaseValidGroup.Add.class, IBaseValidGroup.Update.class})
    @DateTimeFormat(pattern = DateUtil.DATE_PATTERN_YYYY_MM_DD_HH_MM_SS)
    @NotNull(message = "{CURRENCY_BEAN_UPDATE_TIMESTAMP_NOT_NULL}", groups = {IBaseValidGroup.Add.class, IBaseValidGroup.Update.class})
    @Column(name = "currency_update_timestamp", length = 19, nullable = false)
    private Date updateTimestamp;

    /**
     * <pre>
     * DB remark: 逻辑删除标志【N[正常]，Y[删除]】
     * DB column: currency_delete_flag	CHAR(1)	<--->	deleteFlag	java.lang.String
     * DB is  Nullable: false
     * DB defaultValue: N
     * </pre>
     */
    @NotBlank(message = "{CURRENCY_BEAN_DELETE_FLAG_NOT_BLANK}", groups = {IBaseValidGroup.Add.class, IBaseValidGroup.Update.class})
    @Length(max = 1, message = "{CURRENCY_BEAN_DELETE_FLAG_LENGTH}", groups = {IBaseValidGroup.Add.class, IBaseValidGroup.Update.class})
    @Column(name = "currency_delete_flag", length = 1, nullable = false)
    private String deleteFlag;

    private static final long serialVersionUID = 1L;

    /**
     * 获取 数据库主键ID
     *
     * @return currency_id - 数据库主键ID
     */
    public Long getId() {
        return id;
    }

    /**
     * 设置 数据库主键ID
     *
     * @param id - 数据库主键ID
     */
    public CurrencyBean setId(Long id) {
        this.id = id;
        return this;
    }

    /**
     * 获取 货币所属的分公司,与t_client.client_id 字段关联
     *
     * @return currency_client_id - 货币所属的分公司,与t_client.client_id 字段关联
     */
    public Long getClientId() {
        return clientId;
    }

    /**
     * 设置 货币所属的分公司,与t_client.client_id 字段关联
     *
     * @param clientId - 货币所属的分公司,与t_client.client_id 字段关联
     */
    public CurrencyBean setClientId(Long clientId) {
        this.clientId = clientId;
        return this;
    }

    /**
     * 获取 货币内部ID，
     *
     * @return currency_internal_id - 货币内部ID，
     */
    public String getInternalId() {
        return internalId;
    }

    /**
     * 设置 货币内部ID，
     *
     * @param internalId - 货币内部ID，
     */
    public CurrencyBean setInternalId(String internalId) {
        this.internalId = internalId == null ? null : internalId.trim();
        return this;
    }

    /**
     * 获取 货币代码：ISO 4217:2008标准的货币代码简称
     *
     * @return currency_iso_code - 货币代码：ISO 4217:2008标准的货币代码简称
     */
    public String getIsoCode() {
        return isoCode;
    }

    /**
     * 设置 货币代码：ISO 4217:2008标准的货币代码简称
     *
     * @param isoCode - 货币代码：ISO 4217:2008标准的货币代码简称
     */
    public CurrencyBean setIsoCode(String isoCode) {
        this.isoCode = isoCode == null ? null : isoCode.trim();
        return this;
    }

    /**
     * 获取 货币是否有效【ENABLE[启用]、DISABLE[禁用]】
     *
     * @return currency_availability - 货币是否有效【ENABLE[启用]、DISABLE[禁用]】
     */
    public String getAvailability() {
        return availability;
    }

    /**
     * 设置 货币是否有效【ENABLE[启用]、DISABLE[禁用]】
     *
     * @param availability - 货币是否有效【ENABLE[启用]、DISABLE[禁用]】
     */
    public CurrencyBean setAvailability(String availability) {
        this.availability = availability == null ? null : availability.trim();
        return this;
    }

    /**
     * 获取 创建人,与t_crew.crew_username字段关联
     *
     * @return currency_create_by - 创建人,与t_crew.crew_username字段关联
     */
    public String getCreateBy() {
        return createBy;
    }

    /**
     * 设置 创建人,与t_crew.crew_username字段关联
     *
     * @param createBy - 创建人,与t_crew.crew_username字段关联
     */
    public CurrencyBean setCreateBy(String createBy) {
        this.createBy = createBy == null ? null : createBy.trim();
        return this;
    }

    /**
     * 获取 创建时间
     *
     * @return currency_create_timestamp - 创建时间
     */
    public Date getCreateTimestamp() {
        return createTimestamp;
    }

    /**
     * 设置 创建时间
     *
     * @param createTimestamp - 创建时间
     */
    public CurrencyBean setCreateTimestamp(Date createTimestamp) {
        this.createTimestamp = createTimestamp;
        return this;
    }

    /**
     * 获取 更新时间
     *
     * @return currency_update_timestamp - 更新时间
     */
    public Date getUpdateTimestamp() {
        return updateTimestamp;
    }

    /**
     * 设置 更新时间
     *
     * @param updateTimestamp - 更新时间
     */
    public CurrencyBean setUpdateTimestamp(Date updateTimestamp) {
        this.updateTimestamp = updateTimestamp;
        return this;
    }

    /**
     * 获取 逻辑删除标志【N[正常]，Y[删除]】
     *
     * @return currency_delete_flag - 逻辑删除标志【N[正常]，Y[删除]】
     */
    public String getDeleteFlag() {
        return deleteFlag;
    }

    /**
     * 设置 逻辑删除标志【N[正常]，Y[删除]】
     *
     * @param deleteFlag - 逻辑删除标志【N[正常]，Y[删除]】
     */
    public CurrencyBean setDeleteFlag(String deleteFlag) {
        this.deleteFlag = deleteFlag == null ? null : deleteFlag.trim();
        return this;
    }
}