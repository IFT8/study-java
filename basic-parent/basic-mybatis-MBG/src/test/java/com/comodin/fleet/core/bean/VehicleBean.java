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
@Table(name = "t_vehicle")
public class VehicleBean implements Serializable {
    /**
     * <pre>
     * DB remark: 数据库主键ID
     * DB column: vehicle_id	BIGINT(20)	<--->	id	java.lang.Long
     * DB is  Nullable: false
     * DB defaultValue: null
     * </pre>
     */
    @NotNull(message = "{VEHICLE_BEAN_ID_NOT_NULL}", groups = {IBaseValidGroup.Add.class, IBaseValidGroup.Update.class})
    @ValidLength(max = 20, message = "{VEHICLE_BEAN_ID_LENGTH}", groups = {IBaseValidGroup.Add.class, IBaseValidGroup.Update.class})
    @Column(name = "vehicle_id", length = 20, nullable = false)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    private Long id;

    /**
     * <pre>
     * DB remark: 4位数字的内部编号
     * DB column: vehicle_internal_id	VARCHAR(15)	<--->	internalId	java.lang.String
     * DB is  Nullable: true
     * DB defaultValue: null
     * </pre>
     */
    @Length(max = 15, message = "{VEHICLE_BEAN_INTERNAL_ID_LENGTH}", groups = {IBaseValidGroup.Add.class, IBaseValidGroup.Update.class})
    @Column(name = "vehicle_internal_id", length = 15, nullable = true)
    private String internalId;

    /**
     * <pre>
     * DB remark: 车辆实时数据外部标识
     * DB column: vehicle_tomtom_id	VARCHAR(15)	<--->	tomtomId	java.lang.String
     * DB is  Nullable: true
     * DB defaultValue: null
     * </pre>
     */
    @Length(max = 15, message = "{VEHICLE_BEAN_TOMTOM_ID_LENGTH}", groups = {IBaseValidGroup.Add.class, IBaseValidGroup.Update.class})
    @Column(name = "vehicle_tomtom_id", length = 15, nullable = true)
    private String tomtomId;

    /**
     * <pre>
     * DB remark: 车辆所属的网点ID,与t_client_branch.branch_id 字段关联
     * DB column: vehicle_branch_id	BIGINT(20)	<--->	branchId	java.lang.Long
     * DB is  Nullable: false
     * DB defaultValue: null
     * </pre>
     */
    @NotNull(message = "{VEHICLE_BEAN_BRANCH_ID_NOT_NULL}", groups = {IBaseValidGroup.Add.class, IBaseValidGroup.Update.class})
    @ValidLength(max = 20, message = "{VEHICLE_BEAN_BRANCH_ID_LENGTH}", groups = {IBaseValidGroup.Add.class, IBaseValidGroup.Update.class})
    @Column(name = "vehicle_branch_id", length = 20, nullable = false)
    private Long branchId;

    /**
     * <pre>
     * DB remark: 车牌号码
     * DB column: vehicle_license_plate	VARCHAR(20)	<--->	licensePlate	java.lang.String
     * DB is  Nullable: true
     * DB defaultValue: NONE
     * </pre>
     */
    @Length(max = 20, message = "{VEHICLE_BEAN_LICENSE_PLATE_LENGTH}", groups = {IBaseValidGroup.Add.class, IBaseValidGroup.Update.class})
    @Column(name = "vehicle_license_plate", length = 20, nullable = true)
    private String licensePlate;

    /**
     * <pre>
     * DB remark: 车辆识别代号,全宇宙唯一代号vehicle identification number
     * DB column: vehicle_VIN	VARCHAR(30)	<--->	vin	java.lang.String
     * DB is  Nullable: true
     * DB defaultValue: null
     * </pre>
     */
    @Length(max = 30, message = "{VEHICLE_BEAN_VIN_LENGTH}", groups = {IBaseValidGroup.Add.class, IBaseValidGroup.Update.class})
    @Column(name = "vehicle_VIN", length = 30, nullable = true)
    private String vin;

    /**
     * <pre>
     * DB remark: 车辆，核载的人数量
     * DB column: vehicle_nuclear_load_people_number	INTEGER(10)	<--->	nuclearLoadPeopleNumber	java.lang.Integer
     * DB is  Nullable: true
     * DB defaultValue: null
     * </pre>
     */
    @ValidLength(max = 10, message = "{VEHICLE_BEAN_NUCLEAR_LOAD_PEOPLE_NUMBER_LENGTH}", groups = {IBaseValidGroup.Add.class, IBaseValidGroup.Update.class})
    @Column(name = "vehicle_nuclear_load_people_number", length = 10, nullable = true)
    private Integer nuclearLoadPeopleNumber;

    /**
     * <pre>
     * DB remark: 车辆使用年限
     * DB column: vehicle_year	CHAR(4)	<--->	year	java.lang.String
     * DB is  Nullable: true
     * DB defaultValue: null
     * </pre>
     */
    @Length(max = 4, message = "{VEHICLE_BEAN_YEAR_LENGTH}", groups = {IBaseValidGroup.Add.class, IBaseValidGroup.Update.class})
    @Column(name = "vehicle_year", length = 4, nullable = true)
    private String year;

    /**
     * <pre>
     * DB remark: 车辆货币容量
     * DB column: vehicle_currency_capacity	VARCHAR(15)	<--->	currencyCapacity	java.lang.String
     * DB is  Nullable: true
     * DB defaultValue: null
     * </pre>
     */
    @Length(max = 15, message = "{VEHICLE_BEAN_CURRENCY_CAPACITY_LENGTH}", groups = {IBaseValidGroup.Add.class, IBaseValidGroup.Update.class})
    @Column(name = "vehicle_currency_capacity", length = 15, nullable = true)
    private String currencyCapacity;

    /**
     * <pre>
     * DB remark: 车辆描述信息
     * DB column: vehicle_description	VARCHAR(80)	<--->	description	java.lang.String
     * DB is  Nullable: true
     * DB defaultValue: null
     * </pre>
     */
    @Length(max = 80, message = "{VEHICLE_BEAN_DESCRIPTION_LENGTH}", groups = {IBaseValidGroup.Add.class, IBaseValidGroup.Update.class})
    @Column(name = "vehicle_description", length = 80, nullable = true)
    private String description;

    /**
     * <pre>
     * DB remark: 汽车型号
     * DB column: vehicle_model	VARCHAR(30)	<--->	model	java.lang.String
     * DB is  Nullable: true
     * DB defaultValue: null
     * </pre>
     */
    @Length(max = 30, message = "{VEHICLE_BEAN_MODEL_LENGTH}", groups = {IBaseValidGroup.Add.class, IBaseValidGroup.Update.class})
    @Column(name = "vehicle_model", length = 30, nullable = true)
    private String model;

    /**
     * <pre>
     * DB remark: 服务类型【ATMCIT】
     * DB column: vehicle_service_type	VARCHAR(30)	<--->	serviceType	java.lang.String
     * DB is  Nullable: true
     * DB defaultValue: null
     * </pre>
     */
    @Length(max = 30, message = "{VEHICLE_BEAN_SERVICE_TYPE_LENGTH}", groups = {IBaseValidGroup.Add.class, IBaseValidGroup.Update.class})
    @Column(name = "vehicle_service_type", length = 30, nullable = true)
    private String serviceType;

    /**
     * <pre>
     * DB remark: 武装等级【NONE[无], LIGHT[一般], MEDIUM[中等], HEAVY[重型]】
     * DB column: vehicle_armored_level	VARCHAR(20)	<--->	armoredLevel	java.lang.String
     * DB is  Nullable: false
     * DB defaultValue: null
     * </pre>
     */
    @NotBlank(message = "{VEHICLE_BEAN_ARMORED_LEVEL_NOT_BLANK}", groups = {IBaseValidGroup.Add.class, IBaseValidGroup.Update.class})
    @Length(max = 20, message = "{VEHICLE_BEAN_ARMORED_LEVEL_LENGTH}", groups = {IBaseValidGroup.Add.class, IBaseValidGroup.Update.class})
    @Column(name = "vehicle_armored_level", length = 20, nullable = false)
    private String armoredLevel;

    /**
     * <pre>
     * DB remark: 车辆状态: AVAILABLE,LOAN,MAINTENANCE,TOWED,DESTROYED
     * DB column: vehicle_status	VARCHAR(15)	<--->	status	java.lang.String
     * DB is  Nullable: false
     * DB defaultValue: AVAILABLE
     * </pre>
     */
    @NotBlank(message = "{VEHICLE_BEAN_STATUS_NOT_BLANK}", groups = {IBaseValidGroup.Add.class, IBaseValidGroup.Update.class})
    @Length(max = 15, message = "{VEHICLE_BEAN_STATUS_LENGTH}", groups = {IBaseValidGroup.Add.class, IBaseValidGroup.Update.class})
    @Column(name = "vehicle_status", length = 15, nullable = false)
    private String status;

    /**
     * <pre>
     * DB remark: 车辆,里程数
     * DB column: vehicle_mileage	VARCHAR(15)	<--->	mileage	java.lang.String
     * DB is  Nullable: true
     * DB defaultValue: null
     * </pre>
     */
    @Length(max = 15, message = "{VEHICLE_BEAN_MILEAGE_LENGTH}", groups = {IBaseValidGroup.Add.class, IBaseValidGroup.Update.class})
    @Column(name = "vehicle_mileage", length = 15, nullable = true)
    private String mileage;

    /**
     * <pre>
     * DB remark: 车辆,最后保养时间
     * DB column: vehicle_last_maintenance_time	TIMESTAMP(19)	<--->	lastMaintenanceTime	java.util.Date
     * DB is  Nullable: true
     * DB defaultValue: null
     * </pre>
     */
    @ValidDateTimeFormat(pattern = DateUtil.DATE_PATTERN_YYYY_MM_DD_HH_MM_SS , message = "{VEHICLE_BEAN_LAST_MAINTENANCE_TIME_DATE_TIME_FORMAT}", groups = {IBaseValidGroup.Add.class, IBaseValidGroup.Update.class})
    @DateTimeFormat(pattern = DateUtil.DATE_PATTERN_YYYY_MM_DD_HH_MM_SS)
    @Column(name = "vehicle_last_maintenance_time", length = 19, nullable = true)
    private Date lastMaintenanceTime;

    /**
     * <pre>
     * DB remark: 车辆,负责人
     * DB column: vehicle_principal_by	VARCHAR(20)	<--->	principalBy	java.lang.String
     * DB is  Nullable: true
     * DB defaultValue: null
     * </pre>
     */
    @Length(max = 20, message = "{VEHICLE_BEAN_PRINCIPAL_BY_LENGTH}", groups = {IBaseValidGroup.Add.class, IBaseValidGroup.Update.class})
    @Column(name = "vehicle_principal_by", length = 20, nullable = true)
    private String principalBy;

    /**
     * <pre>
     * DB remark: 车辆,操作者
     * DB column: vehicle_operator_by	VARCHAR(20)	<--->	operatorBy	java.lang.String
     * DB is  Nullable: true
     * DB defaultValue: null
     * </pre>
     */
    @Length(max = 20, message = "{VEHICLE_BEAN_OPERATOR_BY_LENGTH}", groups = {IBaseValidGroup.Add.class, IBaseValidGroup.Update.class})
    @Column(name = "vehicle_operator_by", length = 20, nullable = true)
    private String operatorBy;

    /**
     * <pre>
     * DB remark: 入库时间
     * DB column: vehicle_create_timestamp	TIMESTAMP(19)	<--->	createTimestamp	java.util.Date
     * DB is  Nullable: false
     * DB defaultValue: CURRENT_TIMESTAMP
     * </pre>
     */
    @ValidDateTimeFormat(pattern = DateUtil.DATE_PATTERN_YYYY_MM_DD_HH_MM_SS , message = "{VEHICLE_BEAN_CREATE_TIMESTAMP_DATE_TIME_FORMAT}", groups = {IBaseValidGroup.Add.class, IBaseValidGroup.Update.class})
    @DateTimeFormat(pattern = DateUtil.DATE_PATTERN_YYYY_MM_DD_HH_MM_SS)
    @NotNull(message = "{VEHICLE_BEAN_CREATE_TIMESTAMP_NOT_NULL}", groups = {IBaseValidGroup.Add.class, IBaseValidGroup.Update.class})
    @Column(name = "vehicle_create_timestamp", length = 19, nullable = false)
    private Date createTimestamp;

    /**
     * <pre>
     * DB remark: 谁新增了该车辆,与t_crew.crew_username字段关联
     * DB column: vehicle_create_by	VARCHAR(20)	<--->	createBy	java.lang.String
     * DB is  Nullable: false
     * DB defaultValue: null
     * </pre>
     */
    @NotBlank(message = "{VEHICLE_BEAN_CREATE_BY_NOT_BLANK}", groups = {IBaseValidGroup.Add.class, IBaseValidGroup.Update.class})
    @Length(max = 20, message = "{VEHICLE_BEAN_CREATE_BY_LENGTH}", groups = {IBaseValidGroup.Add.class, IBaseValidGroup.Update.class})
    @Column(name = "vehicle_create_by", length = 20, nullable = false)
    private String createBy;

    /**
     * <pre>
     * DB remark: 逻辑删除标志【N[正常]，Y[删除]】
     * DB column: vehicle_delete_flag	CHAR(1)	<--->	deleteFlag	java.lang.String
     * DB is  Nullable: false
     * DB defaultValue: N
     * </pre>
     */
    @NotBlank(message = "{VEHICLE_BEAN_DELETE_FLAG_NOT_BLANK}", groups = {IBaseValidGroup.Add.class, IBaseValidGroup.Update.class})
    @Length(max = 1, message = "{VEHICLE_BEAN_DELETE_FLAG_LENGTH}", groups = {IBaseValidGroup.Add.class, IBaseValidGroup.Update.class})
    @Column(name = "vehicle_delete_flag", length = 1, nullable = false)
    private String deleteFlag;

    private static final long serialVersionUID = 1L;

    /**
     * 获取 数据库主键ID
     *
     * @return vehicle_id - 数据库主键ID
     */
    public Long getId() {
        return id;
    }

    /**
     * 设置 数据库主键ID
     *
     * @param id - 数据库主键ID
     */
    public VehicleBean setId(Long id) {
        this.id = id;
        return this;
    }

    /**
     * 获取 4位数字的内部编号
     *
     * @return vehicle_internal_id - 4位数字的内部编号
     */
    public String getInternalId() {
        return internalId;
    }

    /**
     * 设置 4位数字的内部编号
     *
     * @param internalId - 4位数字的内部编号
     */
    public VehicleBean setInternalId(String internalId) {
        this.internalId = internalId == null ? null : internalId.trim();
        return this;
    }

    /**
     * 获取 车辆实时数据外部标识
     *
     * @return vehicle_tomtom_id - 车辆实时数据外部标识
     */
    public String getTomtomId() {
        return tomtomId;
    }

    /**
     * 设置 车辆实时数据外部标识
     *
     * @param tomtomId - 车辆实时数据外部标识
     */
    public VehicleBean setTomtomId(String tomtomId) {
        this.tomtomId = tomtomId == null ? null : tomtomId.trim();
        return this;
    }

    /**
     * 获取 车辆所属的网点ID,与t_client_branch.branch_id 字段关联
     *
     * @return vehicle_branch_id - 车辆所属的网点ID,与t_client_branch.branch_id 字段关联
     */
    public Long getBranchId() {
        return branchId;
    }

    /**
     * 设置 车辆所属的网点ID,与t_client_branch.branch_id 字段关联
     *
     * @param branchId - 车辆所属的网点ID,与t_client_branch.branch_id 字段关联
     */
    public VehicleBean setBranchId(Long branchId) {
        this.branchId = branchId;
        return this;
    }

    /**
     * 获取 车牌号码
     *
     * @return vehicle_license_plate - 车牌号码
     */
    public String getLicensePlate() {
        return licensePlate;
    }

    /**
     * 设置 车牌号码
     *
     * @param licensePlate - 车牌号码
     */
    public VehicleBean setLicensePlate(String licensePlate) {
        this.licensePlate = licensePlate == null ? null : licensePlate.trim();
        return this;
    }

    /**
     * 获取 车辆识别代号,全宇宙唯一代号vehicle identification number
     *
     * @return vehicle_VIN - 车辆识别代号,全宇宙唯一代号vehicle identification number
     */
    public String getVin() {
        return vin;
    }

    /**
     * 设置 车辆识别代号,全宇宙唯一代号vehicle identification number
     *
     * @param vin - 车辆识别代号,全宇宙唯一代号vehicle identification number
     */
    public VehicleBean setVin(String vin) {
        this.vin = vin == null ? null : vin.trim();
        return this;
    }

    /**
     * 获取 车辆，核载的人数量
     *
     * @return vehicle_nuclear_load_people_number - 车辆，核载的人数量
     */
    public Integer getNuclearLoadPeopleNumber() {
        return nuclearLoadPeopleNumber;
    }

    /**
     * 设置 车辆，核载的人数量
     *
     * @param nuclearLoadPeopleNumber - 车辆，核载的人数量
     */
    public VehicleBean setNuclearLoadPeopleNumber(Integer nuclearLoadPeopleNumber) {
        this.nuclearLoadPeopleNumber = nuclearLoadPeopleNumber;
        return this;
    }

    /**
     * 获取 车辆使用年限
     *
     * @return vehicle_year - 车辆使用年限
     */
    public String getYear() {
        return year;
    }

    /**
     * 设置 车辆使用年限
     *
     * @param year - 车辆使用年限
     */
    public VehicleBean setYear(String year) {
        this.year = year == null ? null : year.trim();
        return this;
    }

    /**
     * 获取 车辆货币容量
     *
     * @return vehicle_currency_capacity - 车辆货币容量
     */
    public String getCurrencyCapacity() {
        return currencyCapacity;
    }

    /**
     * 设置 车辆货币容量
     *
     * @param currencyCapacity - 车辆货币容量
     */
    public VehicleBean setCurrencyCapacity(String currencyCapacity) {
        this.currencyCapacity = currencyCapacity == null ? null : currencyCapacity.trim();
        return this;
    }

    /**
     * 获取 车辆描述信息
     *
     * @return vehicle_description - 车辆描述信息
     */
    public String getDescription() {
        return description;
    }

    /**
     * 设置 车辆描述信息
     *
     * @param description - 车辆描述信息
     */
    public VehicleBean setDescription(String description) {
        this.description = description == null ? null : description.trim();
        return this;
    }

    /**
     * 获取 汽车型号
     *
     * @return vehicle_model - 汽车型号
     */
    public String getModel() {
        return model;
    }

    /**
     * 设置 汽车型号
     *
     * @param model - 汽车型号
     */
    public VehicleBean setModel(String model) {
        this.model = model == null ? null : model.trim();
        return this;
    }

    /**
     * 获取 服务类型【ATMCIT】
     *
     * @return vehicle_service_type - 服务类型【ATMCIT】
     */
    public String getServiceType() {
        return serviceType;
    }

    /**
     * 设置 服务类型【ATMCIT】
     *
     * @param serviceType - 服务类型【ATMCIT】
     */
    public VehicleBean setServiceType(String serviceType) {
        this.serviceType = serviceType == null ? null : serviceType.trim();
        return this;
    }

    /**
     * 获取 武装等级【NONE[无], LIGHT[一般], MEDIUM[中等], HEAVY[重型]】
     *
     * @return vehicle_armored_level - 武装等级【NONE[无], LIGHT[一般], MEDIUM[中等], HEAVY[重型]】
     */
    public String getArmoredLevel() {
        return armoredLevel;
    }

    /**
     * 设置 武装等级【NONE[无], LIGHT[一般], MEDIUM[中等], HEAVY[重型]】
     *
     * @param armoredLevel - 武装等级【NONE[无], LIGHT[一般], MEDIUM[中等], HEAVY[重型]】
     */
    public VehicleBean setArmoredLevel(String armoredLevel) {
        this.armoredLevel = armoredLevel == null ? null : armoredLevel.trim();
        return this;
    }

    /**
     * 获取 车辆状态: AVAILABLE,LOAN,MAINTENANCE,TOWED,DESTROYED
     *
     * @return vehicle_status - 车辆状态: AVAILABLE,LOAN,MAINTENANCE,TOWED,DESTROYED
     */
    public String getStatus() {
        return status;
    }

    /**
     * 设置 车辆状态: AVAILABLE,LOAN,MAINTENANCE,TOWED,DESTROYED
     *
     * @param status - 车辆状态: AVAILABLE,LOAN,MAINTENANCE,TOWED,DESTROYED
     */
    public VehicleBean setStatus(String status) {
        this.status = status == null ? null : status.trim();
        return this;
    }

    /**
     * 获取 车辆,里程数
     *
     * @return vehicle_mileage - 车辆,里程数
     */
    public String getMileage() {
        return mileage;
    }

    /**
     * 设置 车辆,里程数
     *
     * @param mileage - 车辆,里程数
     */
    public VehicleBean setMileage(String mileage) {
        this.mileage = mileage == null ? null : mileage.trim();
        return this;
    }

    /**
     * 获取 车辆,最后保养时间
     *
     * @return vehicle_last_maintenance_time - 车辆,最后保养时间
     */
    public Date getLastMaintenanceTime() {
        return lastMaintenanceTime;
    }

    /**
     * 设置 车辆,最后保养时间
     *
     * @param lastMaintenanceTime - 车辆,最后保养时间
     */
    public VehicleBean setLastMaintenanceTime(Date lastMaintenanceTime) {
        this.lastMaintenanceTime = lastMaintenanceTime;
        return this;
    }

    /**
     * 获取 车辆,负责人
     *
     * @return vehicle_principal_by - 车辆,负责人
     */
    public String getPrincipalBy() {
        return principalBy;
    }

    /**
     * 设置 车辆,负责人
     *
     * @param principalBy - 车辆,负责人
     */
    public VehicleBean setPrincipalBy(String principalBy) {
        this.principalBy = principalBy == null ? null : principalBy.trim();
        return this;
    }

    /**
     * 获取 车辆,操作者
     *
     * @return vehicle_operator_by - 车辆,操作者
     */
    public String getOperatorBy() {
        return operatorBy;
    }

    /**
     * 设置 车辆,操作者
     *
     * @param operatorBy - 车辆,操作者
     */
    public VehicleBean setOperatorBy(String operatorBy) {
        this.operatorBy = operatorBy == null ? null : operatorBy.trim();
        return this;
    }

    /**
     * 获取 入库时间
     *
     * @return vehicle_create_timestamp - 入库时间
     */
    public Date getCreateTimestamp() {
        return createTimestamp;
    }

    /**
     * 设置 入库时间
     *
     * @param createTimestamp - 入库时间
     */
    public VehicleBean setCreateTimestamp(Date createTimestamp) {
        this.createTimestamp = createTimestamp;
        return this;
    }

    /**
     * 获取 谁新增了该车辆,与t_crew.crew_username字段关联
     *
     * @return vehicle_create_by - 谁新增了该车辆,与t_crew.crew_username字段关联
     */
    public String getCreateBy() {
        return createBy;
    }

    /**
     * 设置 谁新增了该车辆,与t_crew.crew_username字段关联
     *
     * @param createBy - 谁新增了该车辆,与t_crew.crew_username字段关联
     */
    public VehicleBean setCreateBy(String createBy) {
        this.createBy = createBy == null ? null : createBy.trim();
        return this;
    }

    /**
     * 获取 逻辑删除标志【N[正常]，Y[删除]】
     *
     * @return vehicle_delete_flag - 逻辑删除标志【N[正常]，Y[删除]】
     */
    public String getDeleteFlag() {
        return deleteFlag;
    }

    /**
     * 设置 逻辑删除标志【N[正常]，Y[删除]】
     *
     * @param deleteFlag - 逻辑删除标志【N[正常]，Y[删除]】
     */
    public VehicleBean setDeleteFlag(String deleteFlag) {
        this.deleteFlag = deleteFlag == null ? null : deleteFlag.trim();
        return this;
    }
}