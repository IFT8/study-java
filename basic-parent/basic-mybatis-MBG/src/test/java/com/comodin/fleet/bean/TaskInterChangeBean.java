package com.comodin.fleet.bean;

import com.comodin.basic.util.date.DateUtil;
import com.comodin.basic.validation.IBaseValidGroup;
import com.comodin.basic.validation.constraints.*;
import java.io.Serializable;
import java.util.Date;
import javax.persistence.*;
import javax.validation.constraints.*;
import org.hibernate.validator.constraints.*;
import org.springframework.format.annotation.DateTimeFormat;

@SuppressWarnings({"unused", "UnusedReturnValue", "SameParameterValue"})
@Table(name = "t_task_inter_change")
public class TaskInterChangeBean implements Serializable {
    /**
     * <pre>
     * DB remark: 数据库主键ID【{"max":13}】
     * DB column: ic_id	BIGINT(19)	<--->	id	java.lang.Long
     * DB is  Nullable: false
     * DB defaultValue: null
     * </pre>
     */
    @NotNull(message = "{TASK_INTER_CHANGE_BEAN_ID_NOT_NULL}", groups = {IBaseValidGroup.Add.class, IBaseValidGroup.Update.class})
    @ValidLength(max = 13, message = "{TASK_INTER_CHANGE_BEAN_ID_LENGTH}", groups = {IBaseValidGroup.Add.class, IBaseValidGroup.Update.class})
    @Id
    @Column(name = "ic_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    /**
     * <pre>
     * DB remark: 批次ID
     * DB column: ic_batch_id	BIGINT(19)	<--->	batchId	java.lang.Long
     * DB is  Nullable: false
     * DB defaultValue: null
     * </pre>
     */
    @NotNull(message = "{TASK_INTER_CHANGE_BEAN_BATCH_ID_NOT_NULL}", groups = {IBaseValidGroup.Add.class, IBaseValidGroup.Update.class})
    @ValidLength(max = 19, message = "{TASK_INTER_CHANGE_BEAN_BATCH_ID_LENGTH}", groups = {IBaseValidGroup.Add.class, IBaseValidGroup.Update.class})
    @Column(name = "ic_batch_id")
    private Long batchId;

    /**
     * <pre>
     * DB remark: interChange源,公司,内部ID
     * DB column: ic_from_company_internal_id	VARCHAR(15)	<--->	fromCompanyInternalId	java.lang.String
     * DB is  Nullable: true
     * DB defaultValue: null
     * </pre>
     */
    @Length(max = 15, message = "{TASK_INTER_CHANGE_BEAN_FROM_COMPANY_INTERNAL_ID_LENGTH}", groups = {IBaseValidGroup.Add.class, IBaseValidGroup.Update.class})
    @Column(name = "ic_from_company_internal_id")
    private String fromCompanyInternalId;

    /**
     * <pre>
     * DB remark: interChange源,网点,内部ID
     * DB column: ic_from_branch_internal_id	VARCHAR(15)	<--->	fromBranchInternalId	java.lang.String
     * DB is  Nullable: true
     * DB defaultValue: null
     * </pre>
     */
    @Length(max = 15, message = "{TASK_INTER_CHANGE_BEAN_FROM_BRANCH_INTERNAL_ID_LENGTH}", groups = {IBaseValidGroup.Add.class, IBaseValidGroup.Update.class})
    @Column(name = "ic_from_branch_internal_id")
    private String fromBranchInternalId;

    /**
     * <pre>
     * DB remark: interChange源,任务服务日期
     * DB column: ic_from_service_date	CHAR(10)	<--->	fromServiceDate	java.lang.String
     * DB is  Nullable: false
     * DB defaultValue: null
     * </pre>
     */
    @NotBlank(message = "{TASK_INTER_CHANGE_BEAN_FROM_SERVICE_DATE_NOT_BLANK}", groups = {IBaseValidGroup.Add.class, IBaseValidGroup.Update.class})
    @Length(max = 10, message = "{TASK_INTER_CHANGE_BEAN_FROM_SERVICE_DATE_LENGTH}", groups = {IBaseValidGroup.Add.class, IBaseValidGroup.Update.class})
    @Column(name = "ic_from_service_date")
    private String fromServiceDate;

    /**
     * <pre>
     * DB remark: interChange源,任务路线ID
     * DB column: ic_from_route_id	VARCHAR(10)	<--->	fromRouteId	java.lang.String
     * DB is  Nullable: false
     * DB defaultValue: null
     * </pre>
     */
    @NotBlank(message = "{TASK_INTER_CHANGE_BEAN_FROM_ROUTE_ID_NOT_BLANK}", groups = {IBaseValidGroup.Add.class, IBaseValidGroup.Update.class})
    @Length(max = 10, message = "{TASK_INTER_CHANGE_BEAN_FROM_ROUTE_ID_LENGTH}", groups = {IBaseValidGroup.Add.class, IBaseValidGroup.Update.class})
    @Column(name = "ic_from_route_id")
    private String fromRouteId;

    /**
     * <pre>
     * DB remark: interChange源,内部ID【以JSON数据格式：pkId,taskId,sourceId】
     * DB column: ic_from_task_ids	VARCHAR(2048)	<--->	fromTaskIds	java.lang.String
     * DB is  Nullable: false
     * DB defaultValue: null
     * </pre>
     */
    @NotBlank(message = "{TASK_INTER_CHANGE_BEAN_FROM_TASK_IDS_NOT_BLANK}", groups = {IBaseValidGroup.Add.class, IBaseValidGroup.Update.class})
    @Length(max = 2048, message = "{TASK_INTER_CHANGE_BEAN_FROM_TASK_IDS_LENGTH}", groups = {IBaseValidGroup.Add.class, IBaseValidGroup.Update.class})
    @Column(name = "ic_from_task_ids")
    private String fromTaskIds;

    /**
     * <pre>
     * DB remark: interChange源,拍照图片文件名
     * DB column: ic_from_evidence_picture	VARCHAR(100)	<--->	fromEvidencePicture	java.lang.String
     * DB is  Nullable: true
     * DB defaultValue: null
     * </pre>
     */
    @Length(max = 100, message = "{TASK_INTER_CHANGE_BEAN_FROM_EVIDENCE_PICTURE_LENGTH}", groups = {IBaseValidGroup.Add.class, IBaseValidGroup.Update.class})
    @Column(name = "ic_from_evidence_picture")
    private String fromEvidencePicture;

    /**
     * <pre>
     * DB remark: interChange源,签名图片文件名
     * DB column: ic_from_signature_picture	VARCHAR(100)	<--->	fromSignaturePicture	java.lang.String
     * DB is  Nullable: true
     * DB defaultValue: null
     * </pre>
     */
    @Length(max = 100, message = "{TASK_INTER_CHANGE_BEAN_FROM_SIGNATURE_PICTURE_LENGTH}", groups = {IBaseValidGroup.Add.class, IBaseValidGroup.Update.class})
    @Column(name = "ic_from_signature_picture")
    private String fromSignaturePicture;

    /**
     * <pre>
     * DB remark: interChange源,地址坐标纬度,浮点型
     * DB column: ic_from_latitude	VARCHAR(15)	<--->	fromLatitude	java.lang.String
     * DB is  Nullable: true
     * DB defaultValue: null
     * </pre>
     */
    @Length(max = 15, message = "{TASK_INTER_CHANGE_BEAN_FROM_LATITUDE_LENGTH}", groups = {IBaseValidGroup.Add.class, IBaseValidGroup.Update.class})
    @Column(name = "ic_from_latitude")
    private String fromLatitude;

    /**
     * <pre>
     * DB remark: interChange源,地址坐标经度,浮点型
     * DB column: ic_from_longitude	VARCHAR(15)	<--->	fromLongitude	java.lang.String
     * DB is  Nullable: true
     * DB defaultValue: null
     * </pre>
     */
    @Length(max = 15, message = "{TASK_INTER_CHANGE_BEAN_FROM_LONGITUDE_LENGTH}", groups = {IBaseValidGroup.Add.class, IBaseValidGroup.Update.class})
    @Column(name = "ic_from_longitude")
    private String fromLongitude;

    /**
     * <pre>
     * DB remark: interChange源,是否Interchange完成标识
     * DB column: ic_from_confirm	CHAR(1)	<--->	fromConfirm	java.lang.String
     * DB is  Nullable: true
     * DB defaultValue: N
     * </pre>
     */
    @Length(max = 1, message = "{TASK_INTER_CHANGE_BEAN_FROM_CONFIRM_LENGTH}", groups = {IBaseValidGroup.Add.class, IBaseValidGroup.Update.class})
    @Column(name = "ic_from_confirm")
    private String fromConfirm;

    /**
     * <pre>
     * DB remark: interChange新,公司,内部ID
     * DB column: ic_to_company_internal_id	VARCHAR(15)	<--->	toCompanyInternalId	java.lang.String
     * DB is  Nullable: true
     * DB defaultValue: null
     * </pre>
     */
    @Length(max = 15, message = "{TASK_INTER_CHANGE_BEAN_TO_COMPANY_INTERNAL_ID_LENGTH}", groups = {IBaseValidGroup.Add.class, IBaseValidGroup.Update.class})
    @Column(name = "ic_to_company_internal_id")
    private String toCompanyInternalId;

    /**
     * <pre>
     * DB remark: interChange新,网点,内部ID
     * DB column: ic_to_branch_internal_id	VARCHAR(15)	<--->	toBranchInternalId	java.lang.String
     * DB is  Nullable: true
     * DB defaultValue: null
     * </pre>
     */
    @Length(max = 15, message = "{TASK_INTER_CHANGE_BEAN_TO_BRANCH_INTERNAL_ID_LENGTH}", groups = {IBaseValidGroup.Add.class, IBaseValidGroup.Update.class})
    @Column(name = "ic_to_branch_internal_id")
    private String toBranchInternalId;

    /**
     * <pre>
     * DB remark: interChange新,任务服务日期
     * DB column: ic_to_service_date	CHAR(10)	<--->	toServiceDate	java.lang.String
     * DB is  Nullable: false
     * DB defaultValue: null
     * </pre>
     */
    @NotBlank(message = "{TASK_INTER_CHANGE_BEAN_TO_SERVICE_DATE_NOT_BLANK}", groups = {IBaseValidGroup.Add.class, IBaseValidGroup.Update.class})
    @Length(max = 10, message = "{TASK_INTER_CHANGE_BEAN_TO_SERVICE_DATE_LENGTH}", groups = {IBaseValidGroup.Add.class, IBaseValidGroup.Update.class})
    @Column(name = "ic_to_service_date")
    private String toServiceDate;

    /**
     * <pre>
     * DB remark: interChange新,任务路线ID
     * DB column: ic_to_route_id	VARCHAR(10)	<--->	toRouteId	java.lang.String
     * DB is  Nullable: false
     * DB defaultValue: null
     * </pre>
     */
    @NotBlank(message = "{TASK_INTER_CHANGE_BEAN_TO_ROUTE_ID_NOT_BLANK}", groups = {IBaseValidGroup.Add.class, IBaseValidGroup.Update.class})
    @Length(max = 10, message = "{TASK_INTER_CHANGE_BEAN_TO_ROUTE_ID_LENGTH}", groups = {IBaseValidGroup.Add.class, IBaseValidGroup.Update.class})
    @Column(name = "ic_to_route_id")
    private String toRouteId;

    /**
     * <pre>
     * DB remark: interChange新,内部ID【以JSON数据格式：pkId,taskId,sourceId】
     * DB column: ic_to_task_ids	VARCHAR(2048)	<--->	toTaskIds	java.lang.String
     * DB is  Nullable: false
     * DB defaultValue: null
     * </pre>
     */
    @NotBlank(message = "{TASK_INTER_CHANGE_BEAN_TO_TASK_IDS_NOT_BLANK}", groups = {IBaseValidGroup.Add.class, IBaseValidGroup.Update.class})
    @Length(max = 2048, message = "{TASK_INTER_CHANGE_BEAN_TO_TASK_IDS_LENGTH}", groups = {IBaseValidGroup.Add.class, IBaseValidGroup.Update.class})
    @Column(name = "ic_to_task_ids")
    private String toTaskIds;

    /**
     * <pre>
     * DB remark: interChange新,拍照图片文件名
     * DB column: ic_to_evidence_picture	VARCHAR(100)	<--->	toEvidencePicture	java.lang.String
     * DB is  Nullable: true
     * DB defaultValue: null
     * </pre>
     */
    @Length(max = 100, message = "{TASK_INTER_CHANGE_BEAN_TO_EVIDENCE_PICTURE_LENGTH}", groups = {IBaseValidGroup.Add.class, IBaseValidGroup.Update.class})
    @Column(name = "ic_to_evidence_picture")
    private String toEvidencePicture;

    /**
     * <pre>
     * DB remark: interChange新,签名图片文件名
     * DB column: ic_to_signature_picture	VARCHAR(100)	<--->	toSignaturePicture	java.lang.String
     * DB is  Nullable: true
     * DB defaultValue: null
     * </pre>
     */
    @Length(max = 100, message = "{TASK_INTER_CHANGE_BEAN_TO_SIGNATURE_PICTURE_LENGTH}", groups = {IBaseValidGroup.Add.class, IBaseValidGroup.Update.class})
    @Column(name = "ic_to_signature_picture")
    private String toSignaturePicture;

    /**
     * <pre>
     * DB remark: interChange新,地址坐标纬度,浮点型
     * DB column: ic_to_latitude	VARCHAR(15)	<--->	toLatitude	java.lang.String
     * DB is  Nullable: true
     * DB defaultValue: null
     * </pre>
     */
    @Length(max = 15, message = "{TASK_INTER_CHANGE_BEAN_TO_LATITUDE_LENGTH}", groups = {IBaseValidGroup.Add.class, IBaseValidGroup.Update.class})
    @Column(name = "ic_to_latitude")
    private String toLatitude;

    /**
     * <pre>
     * DB remark: interChange新,地址坐标经度,浮点型
     * DB column: ic_to_longitude	VARCHAR(15)	<--->	toLongitude	java.lang.String
     * DB is  Nullable: true
     * DB defaultValue: null
     * </pre>
     */
    @Length(max = 15, message = "{TASK_INTER_CHANGE_BEAN_TO_LONGITUDE_LENGTH}", groups = {IBaseValidGroup.Add.class, IBaseValidGroup.Update.class})
    @Column(name = "ic_to_longitude")
    private String toLongitude;

    /**
     * <pre>
     * DB remark: interChange新,是否Interchange完成标识
     * DB column: ic_to_confirm	CHAR(1)	<--->	toConfirm	java.lang.String
     * DB is  Nullable: true
     * DB defaultValue: N
     * </pre>
     */
    @Length(max = 1, message = "{TASK_INTER_CHANGE_BEAN_TO_CONFIRM_LENGTH}", groups = {IBaseValidGroup.Add.class, IBaseValidGroup.Update.class})
    @Column(name = "ic_to_confirm")
    private String toConfirm;

    /**
     * <pre>
     * DB remark: 状态
     * DB column: ic_status	VARCHAR(30)	<--->	status	java.lang.String
     * DB is  Nullable: false
     * DB defaultValue: null
     * </pre>
     */
    @NotBlank(message = "{TASK_INTER_CHANGE_BEAN_STATUS_NOT_BLANK}", groups = {IBaseValidGroup.Add.class, IBaseValidGroup.Update.class})
    @Length(max = 30, message = "{TASK_INTER_CHANGE_BEAN_STATUS_LENGTH}", groups = {IBaseValidGroup.Add.class, IBaseValidGroup.Update.class})
    @Column(name = "ic_status")
    private String status;

    /**
     * <pre>
     * DB remark: 创建时间
     * DB column: ic_create_timestamp	TIMESTAMP(19)	<--->	createTimestamp	java.util.Date
     * DB is  Nullable: false
     * DB defaultValue: CURRENT_TIMESTAMP
     * </pre>
     */
    @ValidDateTimeFormat(pattern = DateUtil.DATE_PATTERN_YYYY_MM_DD_HH_MM_SS , message = "{TASK_INTER_CHANGE_BEAN_CREATE_TIMESTAMP_DATE_TIME_FORMAT}", groups = {IBaseValidGroup.Add.class, IBaseValidGroup.Update.class})
    @DateTimeFormat(pattern = DateUtil.DATE_PATTERN_YYYY_MM_DD_HH_MM_SS)
    @NotNull(message = "{TASK_INTER_CHANGE_BEAN_CREATE_TIMESTAMP_NOT_NULL}", groups = {IBaseValidGroup.Add.class, IBaseValidGroup.Update.class})
    @Column(name = "ic_create_timestamp")
    private Date createTimestamp;

    /**
     * <pre>
     * DB remark: 谁新增了该员工,与crew_username字段关联
     * DB column: ic_create_by	VARCHAR(20)	<--->	createBy	java.lang.String
     * DB is  Nullable: false
     * DB defaultValue: null
     * </pre>
     */
    @NotBlank(message = "{TASK_INTER_CHANGE_BEAN_CREATE_BY_NOT_BLANK}", groups = {IBaseValidGroup.Add.class, IBaseValidGroup.Update.class})
    @Length(max = 20, message = "{TASK_INTER_CHANGE_BEAN_CREATE_BY_LENGTH}", groups = {IBaseValidGroup.Add.class, IBaseValidGroup.Update.class})
    @Column(name = "ic_create_by")
    private String createBy;

    /**
     * <pre>
     * DB remark: 逻辑删除标志【N[正常]，Y[删除]】
     * DB column: ic_delete_flag	CHAR(1)	<--->	deleteFlag	java.lang.String
     * DB is  Nullable: false
     * DB defaultValue: N
     * </pre>
     */
    @NotBlank(message = "{TASK_INTER_CHANGE_BEAN_DELETE_FLAG_NOT_BLANK}", groups = {IBaseValidGroup.Add.class, IBaseValidGroup.Update.class})
    @Length(max = 1, message = "{TASK_INTER_CHANGE_BEAN_DELETE_FLAG_LENGTH}", groups = {IBaseValidGroup.Add.class, IBaseValidGroup.Update.class})
    @Column(name = "ic_delete_flag")
    private String deleteFlag;

    private static final long serialVersionUID = 1L;

    /**
     * 获取 数据库主键ID【{"max":13}】
     *
     * @return ic_id - 数据库主键ID【{"max":13}】
     */
    public Long getId() {
        return id;
    }

    /**
     * 设置 数据库主键ID【{"max":13}】
     *
     * @param id - 数据库主键ID【{"max":13}】
     */
    public TaskInterChangeBean setId(Long id) {
        this.id = id;
        return this;
    }

    /**
     * 获取 批次ID
     *
     * @return ic_batch_id - 批次ID
     */
    public Long getBatchId() {
        return batchId;
    }

    /**
     * 设置 批次ID
     *
     * @param batchId - 批次ID
     */
    public TaskInterChangeBean setBatchId(Long batchId) {
        this.batchId = batchId;
        return this;
    }

    /**
     * 获取 interChange源,公司,内部ID
     *
     * @return ic_from_company_internal_id - interChange源,公司,内部ID
     */
    public String getFromCompanyInternalId() {
        return fromCompanyInternalId;
    }

    /**
     * 设置 interChange源,公司,内部ID
     *
     * @param fromCompanyInternalId - interChange源,公司,内部ID
     */
    public TaskInterChangeBean setFromCompanyInternalId(String fromCompanyInternalId) {
        this.fromCompanyInternalId = fromCompanyInternalId == null ? null : fromCompanyInternalId.trim();
        return this;
    }

    /**
     * 获取 interChange源,网点,内部ID
     *
     * @return ic_from_branch_internal_id - interChange源,网点,内部ID
     */
    public String getFromBranchInternalId() {
        return fromBranchInternalId;
    }

    /**
     * 设置 interChange源,网点,内部ID
     *
     * @param fromBranchInternalId - interChange源,网点,内部ID
     */
    public TaskInterChangeBean setFromBranchInternalId(String fromBranchInternalId) {
        this.fromBranchInternalId = fromBranchInternalId == null ? null : fromBranchInternalId.trim();
        return this;
    }

    /**
     * 获取 interChange源,任务服务日期
     *
     * @return ic_from_service_date - interChange源,任务服务日期
     */
    public String getFromServiceDate() {
        return fromServiceDate;
    }

    /**
     * 设置 interChange源,任务服务日期
     *
     * @param fromServiceDate - interChange源,任务服务日期
     */
    public TaskInterChangeBean setFromServiceDate(String fromServiceDate) {
        this.fromServiceDate = fromServiceDate == null ? null : fromServiceDate.trim();
        return this;
    }

    /**
     * 获取 interChange源,任务路线ID
     *
     * @return ic_from_route_id - interChange源,任务路线ID
     */
    public String getFromRouteId() {
        return fromRouteId;
    }

    /**
     * 设置 interChange源,任务路线ID
     *
     * @param fromRouteId - interChange源,任务路线ID
     */
    public TaskInterChangeBean setFromRouteId(String fromRouteId) {
        this.fromRouteId = fromRouteId == null ? null : fromRouteId.trim();
        return this;
    }

    /**
     * 获取 interChange源,内部ID【以JSON数据格式：pkId,taskId,sourceId】
     *
     * @return ic_from_task_ids - interChange源,内部ID【以JSON数据格式：pkId,taskId,sourceId】
     */
    public String getFromTaskIds() {
        return fromTaskIds;
    }

    /**
     * 设置 interChange源,内部ID【以JSON数据格式：pkId,taskId,sourceId】
     *
     * @param fromTaskIds - interChange源,内部ID【以JSON数据格式：pkId,taskId,sourceId】
     */
    public TaskInterChangeBean setFromTaskIds(String fromTaskIds) {
        this.fromTaskIds = fromTaskIds == null ? null : fromTaskIds.trim();
        return this;
    }

    /**
     * 获取 interChange源,拍照图片文件名
     *
     * @return ic_from_evidence_picture - interChange源,拍照图片文件名
     */
    public String getFromEvidencePicture() {
        return fromEvidencePicture;
    }

    /**
     * 设置 interChange源,拍照图片文件名
     *
     * @param fromEvidencePicture - interChange源,拍照图片文件名
     */
    public TaskInterChangeBean setFromEvidencePicture(String fromEvidencePicture) {
        this.fromEvidencePicture = fromEvidencePicture == null ? null : fromEvidencePicture.trim();
        return this;
    }

    /**
     * 获取 interChange源,签名图片文件名
     *
     * @return ic_from_signature_picture - interChange源,签名图片文件名
     */
    public String getFromSignaturePicture() {
        return fromSignaturePicture;
    }

    /**
     * 设置 interChange源,签名图片文件名
     *
     * @param fromSignaturePicture - interChange源,签名图片文件名
     */
    public TaskInterChangeBean setFromSignaturePicture(String fromSignaturePicture) {
        this.fromSignaturePicture = fromSignaturePicture == null ? null : fromSignaturePicture.trim();
        return this;
    }

    /**
     * 获取 interChange源,地址坐标纬度,浮点型
     *
     * @return ic_from_latitude - interChange源,地址坐标纬度,浮点型
     */
    public String getFromLatitude() {
        return fromLatitude;
    }

    /**
     * 设置 interChange源,地址坐标纬度,浮点型
     *
     * @param fromLatitude - interChange源,地址坐标纬度,浮点型
     */
    public TaskInterChangeBean setFromLatitude(String fromLatitude) {
        this.fromLatitude = fromLatitude == null ? null : fromLatitude.trim();
        return this;
    }

    /**
     * 获取 interChange源,地址坐标经度,浮点型
     *
     * @return ic_from_longitude - interChange源,地址坐标经度,浮点型
     */
    public String getFromLongitude() {
        return fromLongitude;
    }

    /**
     * 设置 interChange源,地址坐标经度,浮点型
     *
     * @param fromLongitude - interChange源,地址坐标经度,浮点型
     */
    public TaskInterChangeBean setFromLongitude(String fromLongitude) {
        this.fromLongitude = fromLongitude == null ? null : fromLongitude.trim();
        return this;
    }

    /**
     * 获取 interChange源,是否Interchange完成标识
     *
     * @return ic_from_confirm - interChange源,是否Interchange完成标识
     */
    public String getFromConfirm() {
        return fromConfirm;
    }

    /**
     * 设置 interChange源,是否Interchange完成标识
     *
     * @param fromConfirm - interChange源,是否Interchange完成标识
     */
    public TaskInterChangeBean setFromConfirm(String fromConfirm) {
        this.fromConfirm = fromConfirm == null ? null : fromConfirm.trim();
        return this;
    }

    /**
     * 获取 interChange新,公司,内部ID
     *
     * @return ic_to_company_internal_id - interChange新,公司,内部ID
     */
    public String getToCompanyInternalId() {
        return toCompanyInternalId;
    }

    /**
     * 设置 interChange新,公司,内部ID
     *
     * @param toCompanyInternalId - interChange新,公司,内部ID
     */
    public TaskInterChangeBean setToCompanyInternalId(String toCompanyInternalId) {
        this.toCompanyInternalId = toCompanyInternalId == null ? null : toCompanyInternalId.trim();
        return this;
    }

    /**
     * 获取 interChange新,网点,内部ID
     *
     * @return ic_to_branch_internal_id - interChange新,网点,内部ID
     */
    public String getToBranchInternalId() {
        return toBranchInternalId;
    }

    /**
     * 设置 interChange新,网点,内部ID
     *
     * @param toBranchInternalId - interChange新,网点,内部ID
     */
    public TaskInterChangeBean setToBranchInternalId(String toBranchInternalId) {
        this.toBranchInternalId = toBranchInternalId == null ? null : toBranchInternalId.trim();
        return this;
    }

    /**
     * 获取 interChange新,任务服务日期
     *
     * @return ic_to_service_date - interChange新,任务服务日期
     */
    public String getToServiceDate() {
        return toServiceDate;
    }

    /**
     * 设置 interChange新,任务服务日期
     *
     * @param toServiceDate - interChange新,任务服务日期
     */
    public TaskInterChangeBean setToServiceDate(String toServiceDate) {
        this.toServiceDate = toServiceDate == null ? null : toServiceDate.trim();
        return this;
    }

    /**
     * 获取 interChange新,任务路线ID
     *
     * @return ic_to_route_id - interChange新,任务路线ID
     */
    public String getToRouteId() {
        return toRouteId;
    }

    /**
     * 设置 interChange新,任务路线ID
     *
     * @param toRouteId - interChange新,任务路线ID
     */
    public TaskInterChangeBean setToRouteId(String toRouteId) {
        this.toRouteId = toRouteId == null ? null : toRouteId.trim();
        return this;
    }

    /**
     * 获取 interChange新,内部ID【以JSON数据格式：pkId,taskId,sourceId】
     *
     * @return ic_to_task_ids - interChange新,内部ID【以JSON数据格式：pkId,taskId,sourceId】
     */
    public String getToTaskIds() {
        return toTaskIds;
    }

    /**
     * 设置 interChange新,内部ID【以JSON数据格式：pkId,taskId,sourceId】
     *
     * @param toTaskIds - interChange新,内部ID【以JSON数据格式：pkId,taskId,sourceId】
     */
    public TaskInterChangeBean setToTaskIds(String toTaskIds) {
        this.toTaskIds = toTaskIds == null ? null : toTaskIds.trim();
        return this;
    }

    /**
     * 获取 interChange新,拍照图片文件名
     *
     * @return ic_to_evidence_picture - interChange新,拍照图片文件名
     */
    public String getToEvidencePicture() {
        return toEvidencePicture;
    }

    /**
     * 设置 interChange新,拍照图片文件名
     *
     * @param toEvidencePicture - interChange新,拍照图片文件名
     */
    public TaskInterChangeBean setToEvidencePicture(String toEvidencePicture) {
        this.toEvidencePicture = toEvidencePicture == null ? null : toEvidencePicture.trim();
        return this;
    }

    /**
     * 获取 interChange新,签名图片文件名
     *
     * @return ic_to_signature_picture - interChange新,签名图片文件名
     */
    public String getToSignaturePicture() {
        return toSignaturePicture;
    }

    /**
     * 设置 interChange新,签名图片文件名
     *
     * @param toSignaturePicture - interChange新,签名图片文件名
     */
    public TaskInterChangeBean setToSignaturePicture(String toSignaturePicture) {
        this.toSignaturePicture = toSignaturePicture == null ? null : toSignaturePicture.trim();
        return this;
    }

    /**
     * 获取 interChange新,地址坐标纬度,浮点型
     *
     * @return ic_to_latitude - interChange新,地址坐标纬度,浮点型
     */
    public String getToLatitude() {
        return toLatitude;
    }

    /**
     * 设置 interChange新,地址坐标纬度,浮点型
     *
     * @param toLatitude - interChange新,地址坐标纬度,浮点型
     */
    public TaskInterChangeBean setToLatitude(String toLatitude) {
        this.toLatitude = toLatitude == null ? null : toLatitude.trim();
        return this;
    }

    /**
     * 获取 interChange新,地址坐标经度,浮点型
     *
     * @return ic_to_longitude - interChange新,地址坐标经度,浮点型
     */
    public String getToLongitude() {
        return toLongitude;
    }

    /**
     * 设置 interChange新,地址坐标经度,浮点型
     *
     * @param toLongitude - interChange新,地址坐标经度,浮点型
     */
    public TaskInterChangeBean setToLongitude(String toLongitude) {
        this.toLongitude = toLongitude == null ? null : toLongitude.trim();
        return this;
    }

    /**
     * 获取 interChange新,是否Interchange完成标识
     *
     * @return ic_to_confirm - interChange新,是否Interchange完成标识
     */
    public String getToConfirm() {
        return toConfirm;
    }

    /**
     * 设置 interChange新,是否Interchange完成标识
     *
     * @param toConfirm - interChange新,是否Interchange完成标识
     */
    public TaskInterChangeBean setToConfirm(String toConfirm) {
        this.toConfirm = toConfirm == null ? null : toConfirm.trim();
        return this;
    }

    /**
     * 获取 状态
     *
     * @return ic_status - 状态
     */
    public String getStatus() {
        return status;
    }

    /**
     * 设置 状态
     *
     * @param status - 状态
     */
    public TaskInterChangeBean setStatus(String status) {
        this.status = status == null ? null : status.trim();
        return this;
    }

    /**
     * 获取 创建时间
     *
     * @return ic_create_timestamp - 创建时间
     */
    public Date getCreateTimestamp() {
        return createTimestamp;
    }

    /**
     * 设置 创建时间
     *
     * @param createTimestamp - 创建时间
     */
    public TaskInterChangeBean setCreateTimestamp(Date createTimestamp) {
        this.createTimestamp = createTimestamp;
        return this;
    }

    /**
     * 获取 谁新增了该员工,与crew_username字段关联
     *
     * @return ic_create_by - 谁新增了该员工,与crew_username字段关联
     */
    public String getCreateBy() {
        return createBy;
    }

    /**
     * 设置 谁新增了该员工,与crew_username字段关联
     *
     * @param createBy - 谁新增了该员工,与crew_username字段关联
     */
    public TaskInterChangeBean setCreateBy(String createBy) {
        this.createBy = createBy == null ? null : createBy.trim();
        return this;
    }

    /**
     * 获取 逻辑删除标志【N[正常]，Y[删除]】
     *
     * @return ic_delete_flag - 逻辑删除标志【N[正常]，Y[删除]】
     */
    public String getDeleteFlag() {
        return deleteFlag;
    }

    /**
     * 设置 逻辑删除标志【N[正常]，Y[删除]】
     *
     * @param deleteFlag - 逻辑删除标志【N[正常]，Y[删除]】
     */
    public TaskInterChangeBean setDeleteFlag(String deleteFlag) {
        this.deleteFlag = deleteFlag == null ? null : deleteFlag.trim();
        return this;
    }
}