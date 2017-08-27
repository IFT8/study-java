package com.comodin.fleet.core.bean;

import com.comodin.basic.util.date.DateUtil;
import com.comodin.basic.validation.IBaseValidGroup;
import com.comodin.basic.validation.constraints.*;
import com.comodin.fleet.constants.i18n.ClientBeanI18nConstant;
import java.io.Serializable;
import java.util.Date;
import javax.persistence.*;
import javax.validation.constraints.*;
import org.hibernate.validator.constraints.*;
import org.springframework.format.annotation.DateTimeFormat;

@SuppressWarnings({"unused", "SpringAutowiredFieldsWarningInspection", "StatementWithEmptyBody", "WeakerAccess"})
@Entity
@Table(name = "t_client")
public class ClientBean implements Serializable {
    /**
     * <pre>
     * DB remark: 数据库主键ID
     * DB column: client_id	BIGINT(20)	<--->	id	java.lang.Long
     * DB is  Nullable: false
     * DB defaultValue: null
     * </pre>
     */
    @NotNull(message = "{" + ClientBeanI18nConstant.CLIENT_BEAN_ID_NOT_NULL + "}", groups = {IBaseValidGroup.Update.class})
    @ValidLength(max = 20, message = "{" + ClientBeanI18nConstant.CLIENT_BEAN_ID_LENGTH + "}", groups = {IBaseValidGroup.Update.class})
    @Column(name = "client_id", length = 20, nullable = false)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    private Long id;

    /**
     * <pre>
     * DB remark: 客户内部编号
     * DB column: client_internal_id	VARCHAR(15)	<--->	internalId	java.lang.String
     * DB is  Nullable: false
     * DB defaultValue: null
     * </pre>
     */
    @NotBlank(message = "{" + ClientBeanI18nConstant.CLIENT_BEAN_INTERNAL_ID_NOT_BLANK + "}", groups = {IBaseValidGroup.Add.class, IBaseValidGroup.Update.class})
    @Length(max = 15, message = "{" + ClientBeanI18nConstant.CLIENT_BEAN_INTERNAL_ID_LENGTH + "}", groups = {IBaseValidGroup.Add.class, IBaseValidGroup.Update.class})
    @Column(name = "client_internal_id", length = 15, nullable = false)
    private String internalId;

    /**
     * <pre>
     * DB remark: 客户名称
     * DB column: client_name	VARCHAR(100)	<--->	name	java.lang.String
     * DB is  Nullable: false
     * DB defaultValue: null
     * </pre>
     */
    @NotBlank(message = "{" + ClientBeanI18nConstant.CLIENT_BEAN_NAME_NOT_BLANK + "}", groups = {IBaseValidGroup.Add.class, IBaseValidGroup.Update.class})
    @Length(max = 100, message = "{" + ClientBeanI18nConstant.CLIENT_BEAN_NAME_LENGTH + "}", groups = {IBaseValidGroup.Add.class, IBaseValidGroup.Update.class})
    @Column(name = "client_name", length = 100, nullable = false)
    private String name;

    /**
     * <pre>
     * DB remark: 客户类型【CIT,CLIENT...】
     * DB column: client_type	VARCHAR(6)	<--->	type	java.lang.String
     * DB is  Nullable: false
     * DB defaultValue: null
     * </pre>
     */
    @NotBlank(message = "{" + ClientBeanI18nConstant.CLIENT_BEAN_TYPE_NOT_BLANK + "}", groups = {IBaseValidGroup.Add.class, IBaseValidGroup.Update.class})
    @Length(max = 6, message = "{" + ClientBeanI18nConstant.CLIENT_BEAN_TYPE_LENGTH + "}", groups = {IBaseValidGroup.Add.class, IBaseValidGroup.Update.class})
    @Column(name = "client_type", length = 6, nullable = false)
    private String type;

    /**
     * <pre>
     * DB remark: 客户类型为[CLIENT]所属哪一个CIT的客户，与t_client.client_id关联，且类型为[CIT]；0为CIT
     * DB column: client_cit_id	BIGINT(20)	<--->	citId	java.lang.Long
     * DB is  Nullable: false
     * DB defaultValue: null
     * </pre>
     */
    @NotNull(message = "{" + ClientBeanI18nConstant.CLIENT_BEAN_CIT_ID_NOT_NULL + "}", groups = {IBaseValidGroup.Add.class, IBaseValidGroup.Update.class})
    @ValidLength(max = 20, message = "{" + ClientBeanI18nConstant.CLIENT_BEAN_CIT_ID_LENGTH + "}", groups = {IBaseValidGroup.Add.class, IBaseValidGroup.Update.class})
    @Column(name = "client_cit_id", length = 20, nullable = false)
    private Long citId;

    /**
     * <pre>
     * DB remark: 客户所属领域,retailer,bank...
     * DB column: client_sector	VARCHAR(30)	<--->	sector	java.lang.String
     * DB is  Nullable: true
     * DB defaultValue: null
     * </pre>
     */
    @Length(max = 30, message = "{" + ClientBeanI18nConstant.CLIENT_BEAN_SECTOR_LENGTH + "}", groups = {IBaseValidGroup.Add.class, IBaseValidGroup.Update.class})
    @Column(name = "client_sector", length = 30, nullable = true)
    private String sector;

    /**
     * <pre>
     * DB remark: 客户联系电话
     * DB column: client_tele_phone	VARCHAR(15)	<--->	telePhone	java.lang.String
     * DB is  Nullable: true
     * DB defaultValue: null
     * </pre>
     */
    @Length(max = 15, message = "{" + ClientBeanI18nConstant.CLIENT_BEAN_TELE_PHONE_LENGTH + "}", groups = {IBaseValidGroup.Add.class, IBaseValidGroup.Update.class})
    @Column(name = "client_tele_phone", length = 15, nullable = true)
    private String telePhone;

    /**
     * <pre>
     * DB remark: 客户总部地址
     * DB column: client_address	VARCHAR(150)	<--->	address	java.lang.String
     * DB is  Nullable: true
     * DB defaultValue: null
     * </pre>
     */
    @Length(max = 150, message = "{" + ClientBeanI18nConstant.CLIENT_BEAN_ADDRESS_LENGTH + "}", groups = {IBaseValidGroup.Add.class, IBaseValidGroup.Update.class})
    @Column(name = "client_address", length = 150, nullable = true)
    private String address;

    /**
     * <pre>
     * DB remark: 客户联系电话
     * DB column: client_phone	VARCHAR(20)	<--->	phone	java.lang.String
     * DB is  Nullable: true
     * DB defaultValue: null
     * </pre>
     */
    @Length(max = 20, message = "{" + ClientBeanI18nConstant.CLIENT_BEAN_PHONE_LENGTH + "}", groups = {IBaseValidGroup.Add.class, IBaseValidGroup.Update.class})
    @Column(name = "client_phone", length = 20, nullable = true)
    private String phone;

    /**
     * <pre>
     * DB remark: 客户地址经度
     * DB column: client_longitude	VARCHAR(15)	<--->	longitude	java.lang.String
     * DB is  Nullable: true
     * DB defaultValue: null
     * </pre>
     */
    @Length(max = 15, message = "{" + ClientBeanI18nConstant.CLIENT_BEAN_LONGITUDE_LENGTH + "}", groups = {IBaseValidGroup.Add.class, IBaseValidGroup.Update.class})
    @Column(name = "client_longitude", length = 15, nullable = true)
    private String longitude;

    /**
     * <pre>
     * DB remark: 客户地址纬度
     * DB column: client_latitude	VARCHAR(15)	<--->	latitude	java.lang.String
     * DB is  Nullable: true
     * DB defaultValue: null
     * </pre>
     */
    @Length(max = 15, message = "{" + ClientBeanI18nConstant.CLIENT_BEAN_LATITUDE_LENGTH + "}", groups = {IBaseValidGroup.Add.class, IBaseValidGroup.Update.class})
    @Column(name = "client_latitude", length = 15, nullable = true)
    private String latitude;

    /**
     * <pre>
     * DB remark: 创建时间
     * DB column: client_create_timestamp	TIMESTAMP(19)	<--->	createTimestamp	java.util.Date
     * DB is  Nullable: false
     * DB defaultValue: CURRENT_TIMESTAMP
     * </pre>
     */
    @ValidDateTimeFormat(pattern = DateUtil.DATE_PATTERN_YYYY_MM_DD_HH_MM_SS, message = "{" + ClientBeanI18nConstant.CLIENT_BEAN_CREATE_TIMESTAMP_DATE_TIME_FORMAT + "}", groups = {IBaseValidGroup.Add.class, IBaseValidGroup.Update.class})
    @DateTimeFormat(pattern = DateUtil.DATE_PATTERN_YYYY_MM_DD_HH_MM_SS)
    @NotNull(message = "{" + ClientBeanI18nConstant.CLIENT_BEAN_CREATE_TIMESTAMP_NOT_NULL + "}", groups = {IBaseValidGroup.Add.class, IBaseValidGroup.Update.class})
    @Column(name = "client_create_timestamp", length = 19, nullable = false)
    private Date createTimestamp;

    /**
     * <pre>
     * DB remark: 创建人,与t_crew.crew_username字段关联
     * DB column: client_create_by	VARCHAR(20)	<--->	createBy	java.lang.String
     * DB is  Nullable: false
     * DB defaultValue: null
     * </pre>
     */
    @NotBlank(message = "{" + ClientBeanI18nConstant.CLIENT_BEAN_CREATE_BY_NOT_BLANK + "}", groups = {IBaseValidGroup.Add.class, IBaseValidGroup.Update.class})
    @Length(max = 20, message = "{" + ClientBeanI18nConstant.CLIENT_BEAN_CREATE_BY_LENGTH + "}", groups = {IBaseValidGroup.Add.class, IBaseValidGroup.Update.class})
    @Column(name = "client_create_by", length = 20, nullable = false)
    private String createBy;

    /**
     * <pre>
     * DB remark: 逻辑删除标志【N[正常]，Y[删除]】
     * DB column: client_delete_flag	CHAR(1)	<--->	deleteFlag	java.lang.String
     * DB is  Nullable: false
     * DB defaultValue: N
     * </pre>
     */
    @NotBlank(message = "{" + ClientBeanI18nConstant.CLIENT_BEAN_DELETE_FLAG_NOT_BLANK + "}", groups = {IBaseValidGroup.Add.class, IBaseValidGroup.Update.class})
    @Length(max = 1, message = "{" + ClientBeanI18nConstant.CLIENT_BEAN_DELETE_FLAG_LENGTH + "}", groups = {IBaseValidGroup.Add.class, IBaseValidGroup.Update.class})
    @Column(name = "client_delete_flag", length = 1, nullable = false)
    private String deleteFlag;

    private static final long serialVersionUID = 1L;

    /**
     * 获取 数据库主键ID
     *
     * @return client_id - 数据库主键ID
     */
    public Long getId() {
        return id;
    }

    /**
     * 设置 数据库主键ID
     *
     * @param id - 数据库主键ID
     */
    public ClientBean setId(Long id) {
        this.id = id;
        return this;
    }

    /**
     * 获取 客户内部编号
     *
     * @return client_internal_id - 客户内部编号
     */
    public String getInternalId() {
        return internalId;
    }

    /**
     * 设置 客户内部编号
     *
     * @param internalId - 客户内部编号
     */
    public ClientBean setInternalId(String internalId) {
        this.internalId = internalId == null ? null : internalId.trim();
        return this;
    }

    /**
     * 获取 客户名称
     *
     * @return client_name - 客户名称
     */
    public String getName() {
        return name;
    }

    /**
     * 设置 客户名称
     *
     * @param name - 客户名称
     */
    public ClientBean setName(String name) {
        this.name = name == null ? null : name.trim();
        return this;
    }

    /**
     * 获取 客户类型【CIT,CLIENT...】
     *
     * @return client_type - 客户类型【CIT,CLIENT...】
     */
    public String getType() {
        return type;
    }

    /**
     * 设置 客户类型【CIT,CLIENT...】
     *
     * @param type - 客户类型【CIT,CLIENT...】
     */
    public ClientBean setType(String type) {
        this.type = type == null ? null : type.trim();
        return this;
    }

    /**
     * 获取 客户类型为[CLIENT]所属哪一个CIT的客户，与t_client.client_id关联，且类型为[CIT]；0为CIT
     *
     * @return client_cit_id - 客户类型为[CLIENT]所属哪一个CIT的客户，与t_client.client_id关联，且类型为[CIT]；0为CIT
     */
    public Long getCitId() {
        return citId;
    }

    /**
     * 设置 客户类型为[CLIENT]所属哪一个CIT的客户，与t_client.client_id关联，且类型为[CIT]；0为CIT
     *
     * @param citId - 客户类型为[CLIENT]所属哪一个CIT的客户，与t_client.client_id关联，且类型为[CIT]；0为CIT
     */
    public ClientBean setCitId(Long citId) {
        this.citId = citId;
        return this;
    }

    /**
     * 获取 客户所属领域,retailer,bank...
     *
     * @return client_sector - 客户所属领域,retailer,bank...
     */
    public String getSector() {
        return sector;
    }

    /**
     * 设置 客户所属领域,retailer,bank...
     *
     * @param sector - 客户所属领域,retailer,bank...
     */
    public ClientBean setSector(String sector) {
        this.sector = sector == null ? null : sector.trim();
        return this;
    }

    /**
     * 获取 客户联系电话
     *
     * @return client_tele_phone - 客户联系电话
     */
    public String getTelePhone() {
        return telePhone;
    }

    /**
     * 设置 客户联系电话
     *
     * @param telePhone - 客户联系电话
     */
    public ClientBean setTelePhone(String telePhone) {
        this.telePhone = telePhone == null ? null : telePhone.trim();
        return this;
    }

    /**
     * 获取 客户总部地址
     *
     * @return client_address - 客户总部地址
     */
    public String getAddress() {
        return address;
    }

    /**
     * 设置 客户总部地址
     *
     * @param address - 客户总部地址
     */
    public ClientBean setAddress(String address) {
        this.address = address == null ? null : address.trim();
        return this;
    }

    /**
     * 获取 客户联系电话
     *
     * @return client_phone - 客户联系电话
     */
    public String getPhone() {
        return phone;
    }

    /**
     * 设置 客户联系电话
     *
     * @param phone - 客户联系电话
     */
    public ClientBean setPhone(String phone) {
        this.phone = phone == null ? null : phone.trim();
        return this;
    }

    /**
     * 获取 客户地址经度
     *
     * @return client_longitude - 客户地址经度
     */
    public String getLongitude() {
        return longitude;
    }

    /**
     * 设置 客户地址经度
     *
     * @param longitude - 客户地址经度
     */
    public ClientBean setLongitude(String longitude) {
        this.longitude = longitude == null ? null : longitude.trim();
        return this;
    }

    /**
     * 获取 客户地址纬度
     *
     * @return client_latitude - 客户地址纬度
     */
    public String getLatitude() {
        return latitude;
    }

    /**
     * 设置 客户地址纬度
     *
     * @param latitude - 客户地址纬度
     */
    public ClientBean setLatitude(String latitude) {
        this.latitude = latitude == null ? null : latitude.trim();
        return this;
    }

    /**
     * 获取 创建时间
     *
     * @return client_create_timestamp - 创建时间
     */
    public Date getCreateTimestamp() {
        return createTimestamp;
    }

    /**
     * 设置 创建时间
     *
     * @param createTimestamp - 创建时间
     */
    public ClientBean setCreateTimestamp(Date createTimestamp) {
        this.createTimestamp = createTimestamp;
        return this;
    }

    /**
     * 获取 创建人,与t_crew.crew_username字段关联
     *
     * @return client_create_by - 创建人,与t_crew.crew_username字段关联
     */
    public String getCreateBy() {
        return createBy;
    }

    /**
     * 设置 创建人,与t_crew.crew_username字段关联
     *
     * @param createBy - 创建人,与t_crew.crew_username字段关联
     */
    public ClientBean setCreateBy(String createBy) {
        this.createBy = createBy == null ? null : createBy.trim();
        return this;
    }

    /**
     * 获取 逻辑删除标志【N[正常]，Y[删除]】
     *
     * @return client_delete_flag - 逻辑删除标志【N[正常]，Y[删除]】
     */
    public String getDeleteFlag() {
        return deleteFlag;
    }

    /**
     * 设置 逻辑删除标志【N[正常]，Y[删除]】
     *
     * @param deleteFlag - 逻辑删除标志【N[正常]，Y[删除]】
     */
    public ClientBean setDeleteFlag(String deleteFlag) {
        this.deleteFlag = deleteFlag == null ? null : deleteFlag.trim();
        return this;
    }
}