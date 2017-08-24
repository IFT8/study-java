package com.comodin.fleet.core.bean;

import com.comodin.basic.util.date.DateUtil;
import com.comodin.basic.validation.IBaseValidGroup;
import com.comodin.basic.validation.constraints.*;
import com.comodin.fleet.constant.i18n.ClientBranchBeanI18nConstant;
import java.io.Serializable;
import java.util.Date;
import javax.persistence.*;
import javax.validation.constraints.*;
import org.hibernate.validator.constraints.*;
import org.springframework.format.annotation.DateTimeFormat;

@SuppressWarnings({"unused", "UnusedReturnValue", "SameParameterValue", "DefaultAnnotationParam"})
@Entity
@Table(name = "t_client_branch")
public class ClientBranchBean implements Serializable {
    /**
     * <pre>
     * DB remark: 数据库主键ID
     * DB column: branch_id	BIGINT(20)	<--->	id	java.lang.Long
     * DB is  Nullable: false
     * DB defaultValue: null
     * </pre>
     */
    @NotNull(message = "{" + ClientBranchBeanI18nConstant.CLIENT_BRANCH_BEAN_ID_NOT_NULL + "}", groups = {IBaseValidGroup.Update.class})
    @ValidLength(max = 20, message = "{" + ClientBranchBeanI18nConstant.CLIENT_BRANCH_BEAN_ID_LENGTH + "}", groups = {IBaseValidGroup.Update.class})
    @Column(name = "branch_id", length = 20, nullable = false)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    private Long id;

    /**
     * <pre>
     * DB remark: 网点内部ID
     * DB column: branch_internal_id	VARCHAR(15)	<--->	internalId	java.lang.String
     * DB is  Nullable: true
     * DB defaultValue: null
     * </pre>
     */
    @Length(max = 15, message = "{" + ClientBranchBeanI18nConstant.CLIENT_BRANCH_BEAN_INTERNAL_ID_LENGTH + "}", groups = {IBaseValidGroup.Add.class, IBaseValidGroup.Update.class})
    @Column(name = "branch_internal_id", length = 15, nullable = true)
    private String internalId;

    /**
     * <pre>
     * DB remark: 网点名称
     * DB column: branch_name	VARCHAR(100)	<--->	name	java.lang.String
     * DB is  Nullable: false
     * DB defaultValue: null
     * </pre>
     */
    @NotBlank(message = "{" + ClientBranchBeanI18nConstant.CLIENT_BRANCH_BEAN_NAME_NOT_BLANK + "}", groups = {IBaseValidGroup.Add.class, IBaseValidGroup.Update.class})
    @Length(max = 100, message = "{" + ClientBranchBeanI18nConstant.CLIENT_BRANCH_BEAN_NAME_LENGTH + "}", groups = {IBaseValidGroup.Add.class, IBaseValidGroup.Update.class})
    @Column(name = "branch_name", length = 100, nullable = false)
    private String name;

    /**
     * <pre>
     * DB remark: 客户类型为[CLIENT]所属哪一个CIT的客户，与t_client.client_id 字段冗余，且类型为[CIT]；0为CIT
     * DB column: branch_cit_id	BIGINT(20)	<--->	citId	java.lang.Long
     * DB is  Nullable: false
     * DB defaultValue: null
     * </pre>
     */
    @NotNull(message = "{" + ClientBranchBeanI18nConstant.CLIENT_BRANCH_BEAN_CIT_ID_NOT_NULL + "}", groups = {IBaseValidGroup.Add.class, IBaseValidGroup.Update.class})
    @ValidLength(max = 20, message = "{" + ClientBranchBeanI18nConstant.CLIENT_BRANCH_BEAN_CIT_ID_LENGTH + "}", groups = {IBaseValidGroup.Add.class, IBaseValidGroup.Update.class})
    @Column(name = "branch_cit_id", length = 20, nullable = false)
    private Long citId;

    /**
     * <pre>
     * DB remark: 网点类型【CIT,CLIENT,BANK...】
     * DB column: branch_type	VARCHAR(15)	<--->	type	java.lang.String
     * DB is  Nullable: false
     * DB defaultValue: null
     * </pre>
     */
    @NotBlank(message = "{" + ClientBranchBeanI18nConstant.CLIENT_BRANCH_BEAN_TYPE_NOT_BLANK + "}", groups = {IBaseValidGroup.Add.class, IBaseValidGroup.Update.class})
    @Length(max = 15, message = "{" + ClientBranchBeanI18nConstant.CLIENT_BRANCH_BEAN_TYPE_LENGTH + "}", groups = {IBaseValidGroup.Add.class, IBaseValidGroup.Update.class})
    @Column(name = "branch_type", length = 15, nullable = false)
    private String type;

    /**
     * <pre>
     * DB remark: 网点所属的客户ID,与t_client.client_id 字段关联
     * DB column: branch_client_id	BIGINT(20)	<--->	clientId	java.lang.Long
     * DB is  Nullable: false
     * DB defaultValue: null
     * </pre>
     */
    @NotNull(message = "{" + ClientBranchBeanI18nConstant.CLIENT_BRANCH_BEAN_CLIENT_ID_NOT_NULL + "}", groups = {IBaseValidGroup.Add.class, IBaseValidGroup.Update.class})
    @ValidLength(max = 20, message = "{" + ClientBranchBeanI18nConstant.CLIENT_BRANCH_BEAN_CLIENT_ID_LENGTH + "}", groups = {IBaseValidGroup.Add.class, IBaseValidGroup.Update.class})
    @Column(name = "branch_client_id", length = 20, nullable = false)
    private Long clientId;

    /**
     * <pre>
     * DB remark: 网点所属的客户内部ID,与t_client.client_internal_id 字段冗余
     * DB column: branch_client_internal_id	VARCHAR(15)	<--->	clientInternalId	java.lang.String
     * DB is  Nullable: false
     * DB defaultValue: null
     * </pre>
     */
    @NotBlank(message = "{" + ClientBranchBeanI18nConstant.CLIENT_BRANCH_BEAN_CLIENT_INTERNAL_ID_NOT_BLANK + "}", groups = {IBaseValidGroup.Add.class, IBaseValidGroup.Update.class})
    @Length(max = 15, message = "{" + ClientBranchBeanI18nConstant.CLIENT_BRANCH_BEAN_CLIENT_INTERNAL_ID_LENGTH + "}", groups = {IBaseValidGroup.Add.class, IBaseValidGroup.Update.class})
    @Column(name = "branch_client_internal_id", length = 15, nullable = false)
    private String clientInternalId;

    /**
     * <pre>
     * DB remark: 客户的名称,与t_client.client_name冗余
     * DB column: branch_client_name	VARCHAR(100)	<--->	clientName	java.lang.String
     * DB is  Nullable: false
     * DB defaultValue: null
     * </pre>
     */
    @NotBlank(message = "{" + ClientBranchBeanI18nConstant.CLIENT_BRANCH_BEAN_CLIENT_NAME_NOT_BLANK + "}", groups = {IBaseValidGroup.Add.class, IBaseValidGroup.Update.class})
    @Length(max = 100, message = "{" + ClientBranchBeanI18nConstant.CLIENT_BRANCH_BEAN_CLIENT_NAME_LENGTH + "}", groups = {IBaseValidGroup.Add.class, IBaseValidGroup.Update.class})
    @Column(name = "branch_client_name", length = 100, nullable = false)
    private String clientName;

    /**
     * <pre>
     * DB remark: 网点时域【以GMT标准 America/Mexico_City为墨西哥时区】
     * DB column: branch_time_zone	VARCHAR(20)	<--->	timeZone	java.lang.String
     * DB is  Nullable: false
     * DB defaultValue: 
     * </pre>
     */
    @NotBlank(message = "{" + ClientBranchBeanI18nConstant.CLIENT_BRANCH_BEAN_TIME_ZONE_NOT_BLANK + "}", groups = {IBaseValidGroup.Add.class, IBaseValidGroup.Update.class})
    @Length(max = 20, message = "{" + ClientBranchBeanI18nConstant.CLIENT_BRANCH_BEAN_TIME_ZONE_LENGTH + "}", groups = {IBaseValidGroup.Add.class, IBaseValidGroup.Update.class})
    @Column(name = "branch_time_zone", length = 20, nullable = false)
    private String timeZone;

    /**
     * <pre>
     * DB remark: 网点联系电话
     * DB column: branch_phone	VARCHAR(15)	<--->	phone	java.lang.String
     * DB is  Nullable: true
     * DB defaultValue: null
     * </pre>
     */
    @Length(max = 15, message = "{" + ClientBranchBeanI18nConstant.CLIENT_BRANCH_BEAN_PHONE_LENGTH + "}", groups = {IBaseValidGroup.Add.class, IBaseValidGroup.Update.class})
    @Column(name = "branch_phone", length = 15, nullable = true)
    private String phone;

    /**
     * <pre>
     * DB remark: 网点地址
     * DB column: branch_address	VARCHAR(150)	<--->	address	java.lang.String
     * DB is  Nullable: true
     * DB defaultValue: null
     * </pre>
     */
    @Length(max = 150, message = "{" + ClientBranchBeanI18nConstant.CLIENT_BRANCH_BEAN_ADDRESS_LENGTH + "}", groups = {IBaseValidGroup.Add.class, IBaseValidGroup.Update.class})
    @Column(name = "branch_address", length = 150, nullable = true)
    private String address;

    /**
     * <pre>
     * DB remark: 网点坐标纬度,浮点型
     * DB column: branch_latitude	VARCHAR(15)	<--->	latitude	java.lang.String
     * DB is  Nullable: false
     * DB defaultValue: null
     * </pre>
     */
    @NotBlank(message = "{" + ClientBranchBeanI18nConstant.CLIENT_BRANCH_BEAN_LATITUDE_NOT_BLANK + "}", groups = {IBaseValidGroup.Add.class, IBaseValidGroup.Update.class})
    @Length(max = 15, message = "{" + ClientBranchBeanI18nConstant.CLIENT_BRANCH_BEAN_LATITUDE_LENGTH + "}", groups = {IBaseValidGroup.Add.class, IBaseValidGroup.Update.class})
    @Column(name = "branch_latitude", length = 15, nullable = false)
    private String latitude;

    /**
     * <pre>
     * DB remark: 网点坐标经度,浮点型
     * DB column: branch_longitude	VARCHAR(15)	<--->	longitude	java.lang.String
     * DB is  Nullable: false
     * DB defaultValue: null
     * </pre>
     */
    @NotBlank(message = "{" + ClientBranchBeanI18nConstant.CLIENT_BRANCH_BEAN_LONGITUDE_NOT_BLANK + "}", groups = {IBaseValidGroup.Add.class, IBaseValidGroup.Update.class})
    @Length(max = 15, message = "{" + ClientBranchBeanI18nConstant.CLIENT_BRANCH_BEAN_LONGITUDE_LENGTH + "}", groups = {IBaseValidGroup.Add.class, IBaseValidGroup.Update.class})
    @Column(name = "branch_longitude", length = 15, nullable = false)
    private String longitude;

    /**
     * <pre>
     * DB remark: 网点保险箱钥匙编号
     * DB column: branch_safe_key_number	VARCHAR(20)	<--->	safeKeyNumber	java.lang.String
     * DB is  Nullable: true
     * DB defaultValue: 
     * </pre>
     */
    @Length(max = 20, message = "{" + ClientBranchBeanI18nConstant.CLIENT_BRANCH_BEAN_SAFE_KEY_NUMBER_LENGTH + "}", groups = {IBaseValidGroup.Add.class, IBaseValidGroup.Update.class})
    @Column(name = "branch_safe_key_number", length = 20, nullable = true)
    private String safeKeyNumber;

    /**
     * <pre>
     * DB remark: 网点用户在APP操作任务，任务数据同步到服务器的时间间隔，单位s（秒），默认900秒
     * DB column: branch_synchronous_interval	BIGINT(20)	<--->	synchronousInterval	java.lang.Long
     * DB is  Nullable: false
     * DB defaultValue: 900
     * </pre>
     */
    @NotNull(message = "{" + ClientBranchBeanI18nConstant.CLIENT_BRANCH_BEAN_SYNCHRONOUS_INTERVAL_NOT_NULL + "}", groups = {IBaseValidGroup.Add.class, IBaseValidGroup.Update.class})
    @ValidLength(max = 20, message = "{" + ClientBranchBeanI18nConstant.CLIENT_BRANCH_BEAN_SYNCHRONOUS_INTERVAL_LENGTH + "}", groups = {IBaseValidGroup.Add.class, IBaseValidGroup.Update.class})
    @Column(name = "branch_synchronous_interval", length = 20, nullable = false)
    private Long synchronousInterval;

    /**
     * <pre>
     * DB remark: 是否需要分配车辆,Y有,N无【备注:该分支,名下的司机,在登陆APP客户端时,是否弹出分配车辆,开关[需求改变,是因为TanMeMe的任务是外部导入,已经分配好线路,车辆,司机,保镖,营业员 dateBy 2016-08-29]】
     * DB column: branch_assign_vehicle_flag	CHAR(1)	<--->	assignVehicleFlag	java.lang.String
     * DB is  Nullable: false
     * DB defaultValue: Y
     * </pre>
     */
    @NotBlank(message = "{" + ClientBranchBeanI18nConstant.CLIENT_BRANCH_BEAN_ASSIGN_VEHICLE_FLAG_NOT_BLANK + "}", groups = {IBaseValidGroup.Add.class, IBaseValidGroup.Update.class})
    @Length(max = 1, message = "{" + ClientBranchBeanI18nConstant.CLIENT_BRANCH_BEAN_ASSIGN_VEHICLE_FLAG_LENGTH + "}", groups = {IBaseValidGroup.Add.class, IBaseValidGroup.Update.class})
    @Column(name = "branch_assign_vehicle_flag", length = 1, nullable = false)
    private String assignVehicleFlag;

    /**
     * <pre>
     * DB remark: 是否需要分配路线,Y有,N无【备注:该分支,名下的司机,在登陆APP客户端时,是否弹出分配路线,开关[需求改变,是因为TanMeMe的任务是外部导入,已经分配好线路,车辆,司机,保镖,营业员 dateBy 2016-08-29]】
     * DB column: branch_assign_route_flag	CHAR(1)	<--->	assignRouteFlag	java.lang.String
     * DB is  Nullable: false
     * DB defaultValue: Y
     * </pre>
     */
    @NotBlank(message = "{" + ClientBranchBeanI18nConstant.CLIENT_BRANCH_BEAN_ASSIGN_ROUTE_FLAG_NOT_BLANK + "}", groups = {IBaseValidGroup.Add.class, IBaseValidGroup.Update.class})
    @Length(max = 1, message = "{" + ClientBranchBeanI18nConstant.CLIENT_BRANCH_BEAN_ASSIGN_ROUTE_FLAG_LENGTH + "}", groups = {IBaseValidGroup.Add.class, IBaseValidGroup.Update.class})
    @Column(name = "branch_assign_route_flag", length = 1, nullable = false)
    private String assignRouteFlag;

    /**
     * <pre>
     * DB remark: 是否需要分配收银员,Y有,N无【备注:该分支,名下的司机,在登陆APP客户端时,是否弹出分配收银员,开关[需求改变,是因为TanMeMe的任务是外部导入,已经分配好线路,车辆,司机,保镖,营业员 dateBy 2016-08-29]】
     * DB column: branch_assign_auxiliary_flag	CHAR(1)	<--->	assignAuxiliaryFlag	java.lang.String
     * DB is  Nullable: false
     * DB defaultValue: Y
     * </pre>
     */
    @NotBlank(message = "{" + ClientBranchBeanI18nConstant.CLIENT_BRANCH_BEAN_ASSIGN_AUXILIARY_FLAG_NOT_BLANK + "}", groups = {IBaseValidGroup.Add.class, IBaseValidGroup.Update.class})
    @Length(max = 1, message = "{" + ClientBranchBeanI18nConstant.CLIENT_BRANCH_BEAN_ASSIGN_AUXILIARY_FLAG_LENGTH + "}", groups = {IBaseValidGroup.Add.class, IBaseValidGroup.Update.class})
    @Column(name = "branch_assign_auxiliary_flag", length = 1, nullable = false)
    private String assignAuxiliaryFlag;

    /**
     * <pre>
     * DB remark: 是否需要分配保镖,Y有,N无【备注:该分支,名下的司机,在登陆APP客户端时,是否弹出分配保镖,开关[需求改变,是因为TanMeMe的任务是外部导入,已经分配好线路,车辆,司机,保镖,营业员 dateBy 2016-08-29]】
     * DB column: branch_assign_guard_flag	CHAR(1)	<--->	assignGuardFlag	java.lang.String
     * DB is  Nullable: false
     * DB defaultValue: Y
     * </pre>
     */
    @NotBlank(message = "{" + ClientBranchBeanI18nConstant.CLIENT_BRANCH_BEAN_ASSIGN_GUARD_FLAG_NOT_BLANK + "}", groups = {IBaseValidGroup.Add.class, IBaseValidGroup.Update.class})
    @Length(max = 1, message = "{" + ClientBranchBeanI18nConstant.CLIENT_BRANCH_BEAN_ASSIGN_GUARD_FLAG_LENGTH + "}", groups = {IBaseValidGroup.Add.class, IBaseValidGroup.Update.class})
    @Column(name = "branch_assign_guard_flag", length = 1, nullable = false)
    private String assignGuardFlag;

    /**
     * <pre>
     * DB remark: 是否需要validate,Y需要,N不需要
     * DB column: branch_need_validate_flag	CHAR(1)	<--->	needValidateFlag	java.lang.String
     * DB is  Nullable: false
     * DB defaultValue: Y
     * </pre>
     */
    @NotBlank(message = "{" + ClientBranchBeanI18nConstant.CLIENT_BRANCH_BEAN_NEED_VALIDATE_FLAG_NOT_BLANK + "}", groups = {IBaseValidGroup.Add.class, IBaseValidGroup.Update.class})
    @Length(max = 1, message = "{" + ClientBranchBeanI18nConstant.CLIENT_BRANCH_BEAN_NEED_VALIDATE_FLAG_LENGTH + "}", groups = {IBaseValidGroup.Add.class, IBaseValidGroup.Update.class})
    @Column(name = "branch_need_validate_flag", length = 1, nullable = false)
    private String needValidateFlag;

    /**
     * <pre>
     * DB remark: 是否达到目的才能开始任务,Y需要,N不需要
     * DB column: branch_need_arrive_flag	CHAR(1)	<--->	needArriveFlag	java.lang.String
     * DB is  Nullable: false
     * DB defaultValue: Y
     * </pre>
     */
    @NotBlank(message = "{" + ClientBranchBeanI18nConstant.CLIENT_BRANCH_BEAN_NEED_ARRIVE_FLAG_NOT_BLANK + "}", groups = {IBaseValidGroup.Add.class, IBaseValidGroup.Update.class})
    @Length(max = 1, message = "{" + ClientBranchBeanI18nConstant.CLIENT_BRANCH_BEAN_NEED_ARRIVE_FLAG_LENGTH + "}", groups = {IBaseValidGroup.Add.class, IBaseValidGroup.Update.class})
    @Column(name = "branch_need_arrive_flag", length = 1, nullable = false)
    private String needArriveFlag;

    /**
     * <pre>
     * DB remark: 是否需要按顺序完成任务,Y需要,N不需要
     * DB column: branch_need_order_flag	CHAR(1)	<--->	needOrderFlag	java.lang.String
     * DB is  Nullable: false
     * DB defaultValue: Y
     * </pre>
     */
    @NotBlank(message = "{" + ClientBranchBeanI18nConstant.CLIENT_BRANCH_BEAN_NEED_ORDER_FLAG_NOT_BLANK + "}", groups = {IBaseValidGroup.Add.class, IBaseValidGroup.Update.class})
    @Length(max = 1, message = "{" + ClientBranchBeanI18nConstant.CLIENT_BRANCH_BEAN_NEED_ORDER_FLAG_LENGTH + "}", groups = {IBaseValidGroup.Add.class, IBaseValidGroup.Update.class})
    @Column(name = "branch_need_order_flag", length = 1, nullable = false)
    private String needOrderFlag;

    /**
     * <pre>
     * DB remark: 是否需要打印,Y需要,N不需要
     * DB column: branch_need_print_flag	CHAR(1)	<--->	needPrintFlag	java.lang.String
     * DB is  Nullable: false
     * DB defaultValue: Y
     * </pre>
     */
    @NotBlank(message = "{" + ClientBranchBeanI18nConstant.CLIENT_BRANCH_BEAN_NEED_PRINT_FLAG_NOT_BLANK + "}", groups = {IBaseValidGroup.Add.class, IBaseValidGroup.Update.class})
    @Length(max = 1, message = "{" + ClientBranchBeanI18nConstant.CLIENT_BRANCH_BEAN_NEED_PRINT_FLAG_LENGTH + "}", groups = {IBaseValidGroup.Add.class, IBaseValidGroup.Update.class})
    @Column(name = "branch_need_print_flag", length = 1, nullable = false)
    private String needPrintFlag;

    /**
     * <pre>
     * DB remark: 是否需要输入PIN码,Y需要,N不需要
     * DB column: branch_need_pin_flag	CHAR(1)	<--->	needPinFlag	java.lang.String
     * DB is  Nullable: false
     * DB defaultValue: Y
     * </pre>
     */
    @NotBlank(message = "{" + ClientBranchBeanI18nConstant.CLIENT_BRANCH_BEAN_NEED_PIN_FLAG_NOT_BLANK + "}", groups = {IBaseValidGroup.Add.class, IBaseValidGroup.Update.class})
    @Length(max = 1, message = "{" + ClientBranchBeanI18nConstant.CLIENT_BRANCH_BEAN_NEED_PIN_FLAG_LENGTH + "}", groups = {IBaseValidGroup.Add.class, IBaseValidGroup.Update.class})
    @Column(name = "branch_need_pin_flag", length = 1, nullable = false)
    private String needPinFlag;

    /**
     * <pre>
     * DB remark: cancel时是否需要到任务点拍照,Y需要,N不需要
     * DB column: branch_need_photograph_flag	CHAR(1)	<--->	needPhotographFlag	java.lang.String
     * DB is  Nullable: false
     * DB defaultValue: Y
     * </pre>
     */
    @NotBlank(message = "{" + ClientBranchBeanI18nConstant.CLIENT_BRANCH_BEAN_NEED_PHOTOGRAPH_FLAG_NOT_BLANK + "}", groups = {IBaseValidGroup.Add.class, IBaseValidGroup.Update.class})
    @Length(max = 1, message = "{" + ClientBranchBeanI18nConstant.CLIENT_BRANCH_BEAN_NEED_PHOTOGRAPH_FLAG_LENGTH + "}", groups = {IBaseValidGroup.Add.class, IBaseValidGroup.Update.class})
    @Column(name = "branch_need_photograph_flag", length = 1, nullable = false)
    private String needPhotographFlag;

    /**
     * <pre>
     * DB remark: 是否拍照签名才能完成任务,Y需要,N不需要
     * DB column: branch_need_signature_flag	CHAR(1)	<--->	needSignatureFlag	java.lang.String
     * DB is  Nullable: false
     * DB defaultValue: Y
     * </pre>
     */
    @NotBlank(message = "{" + ClientBranchBeanI18nConstant.CLIENT_BRANCH_BEAN_NEED_SIGNATURE_FLAG_NOT_BLANK + "}", groups = {IBaseValidGroup.Add.class, IBaseValidGroup.Update.class})
    @Length(max = 1, message = "{" + ClientBranchBeanI18nConstant.CLIENT_BRANCH_BEAN_NEED_SIGNATURE_FLAG_LENGTH + "}", groups = {IBaseValidGroup.Add.class, IBaseValidGroup.Update.class})
    @Column(name = "branch_need_signature_flag", length = 1, nullable = false)
    private String needSignatureFlag;

    /**
     * <pre>
     * DB remark: 开关,收钱，取消任务，是否需要访问票据,Y需要,N不需要
     * DB column: branch_switch_cancel_task_visit_bill_by_pickup	CHAR(1)	<--->	switchCancelTaskVisitBillByPickup	java.lang.String
     * DB is  Nullable: false
     * DB defaultValue: Y
     * </pre>
     */
    @NotBlank(message = "{" + ClientBranchBeanI18nConstant.CLIENT_BRANCH_BEAN_SWITCH_CANCEL_TASK_VISIT_BILL_BY_PICKUP_NOT_BLANK + "}", groups = {IBaseValidGroup.Add.class, IBaseValidGroup.Update.class})
    @Length(max = 1, message = "{" + ClientBranchBeanI18nConstant.CLIENT_BRANCH_BEAN_SWITCH_CANCEL_TASK_VISIT_BILL_BY_PICKUP_LENGTH + "}", groups = {IBaseValidGroup.Add.class, IBaseValidGroup.Update.class})
    @Column(name = "branch_switch_cancel_task_visit_bill_by_pickup", length = 1, nullable = false)
    private String switchCancelTaskVisitBillByPickup;

    /**
     * <pre>
     * DB remark: 开关,送钱，取消任务，是否需要访问票据,Y需要,N不需要
     * DB column: branch_switch_cancel_task_visit_bill_by_delivery	CHAR(1)	<--->	switchCancelTaskVisitBillByDelivery	java.lang.String
     * DB is  Nullable: false
     * DB defaultValue: Y
     * </pre>
     */
    @NotBlank(message = "{" + ClientBranchBeanI18nConstant.CLIENT_BRANCH_BEAN_SWITCH_CANCEL_TASK_VISIT_BILL_BY_DELIVERY_NOT_BLANK + "}", groups = {IBaseValidGroup.Add.class, IBaseValidGroup.Update.class})
    @Length(max = 1, message = "{" + ClientBranchBeanI18nConstant.CLIENT_BRANCH_BEAN_SWITCH_CANCEL_TASK_VISIT_BILL_BY_DELIVERY_LENGTH + "}", groups = {IBaseValidGroup.Add.class, IBaseValidGroup.Update.class})
    @Column(name = "branch_switch_cancel_task_visit_bill_by_delivery", length = 1, nullable = false)
    private String switchCancelTaskVisitBillByDelivery;

    /**
     * <pre>
     * DB remark: 开关,送钱，取消任务，是否需要访问票据,Y需要,N不需要
     * DB column: branch_switch_cancel_task_visit_bill_by_directly_to_pickup	CHAR(1)	<--->	switchCancelTaskVisitBillByDirectlyToPickup	java.lang.String
     * DB is  Nullable: false
     * DB defaultValue: Y
     * </pre>
     */
    @NotBlank(message = "{" + ClientBranchBeanI18nConstant.CLIENT_BRANCH_BEAN_SWITCH_CANCEL_TASK_VISIT_BILL_BY_DIRECTLY_TO_PICKUP_NOT_BLANK + "}", groups = {IBaseValidGroup.Add.class, IBaseValidGroup.Update.class})
    @Length(max = 1, message = "{" + ClientBranchBeanI18nConstant.CLIENT_BRANCH_BEAN_SWITCH_CANCEL_TASK_VISIT_BILL_BY_DIRECTLY_TO_PICKUP_LENGTH + "}", groups = {IBaseValidGroup.Add.class, IBaseValidGroup.Update.class})
    @Column(name = "branch_switch_cancel_task_visit_bill_by_directly_to_pickup", length = 1, nullable = false)
    private String switchCancelTaskVisitBillByDirectlyToPickup;

    /**
     * <pre>
     * DB remark: 开关,送钱，取消任务，是否需要访问票据,Y需要,N不需要
     * DB column: branch_switch_cancel_task_visit_bill_by_directly_to_delivery	CHAR(1)	<--->	switchCancelTaskVisitBillByDirectlyToDelivery	java.lang.String
     * DB is  Nullable: false
     * DB defaultValue: Y
     * </pre>
     */
    @NotBlank(message = "{" + ClientBranchBeanI18nConstant.CLIENT_BRANCH_BEAN_SWITCH_CANCEL_TASK_VISIT_BILL_BY_DIRECTLY_TO_DELIVERY_NOT_BLANK + "}", groups = {IBaseValidGroup.Add.class, IBaseValidGroup.Update.class})
    @Length(max = 1, message = "{" + ClientBranchBeanI18nConstant.CLIENT_BRANCH_BEAN_SWITCH_CANCEL_TASK_VISIT_BILL_BY_DIRECTLY_TO_DELIVERY_LENGTH + "}", groups = {IBaseValidGroup.Add.class, IBaseValidGroup.Update.class})
    @Column(name = "branch_switch_cancel_task_visit_bill_by_directly_to_delivery", length = 1, nullable = false)
    private String switchCancelTaskVisitBillByDirectlyToDelivery;

    /**
     * <pre>
     * DB remark: 开关,送钱，是否需要添加票据,Y需要,N不需要
     * DB column: branch_switch_send_task_need_add_comprobantes	CHAR(1)	<--->	switchSendTaskNeedAddComprobantes	java.lang.String
     * DB is  Nullable: false
     * DB defaultValue: Y
     * </pre>
     */
    @NotBlank(message = "{" + ClientBranchBeanI18nConstant.CLIENT_BRANCH_BEAN_SWITCH_SEND_TASK_NEED_ADD_COMPROBANTES_NOT_BLANK + "}", groups = {IBaseValidGroup.Add.class, IBaseValidGroup.Update.class})
    @Length(max = 1, message = "{" + ClientBranchBeanI18nConstant.CLIENT_BRANCH_BEAN_SWITCH_SEND_TASK_NEED_ADD_COMPROBANTES_LENGTH + "}", groups = {IBaseValidGroup.Add.class, IBaseValidGroup.Update.class})
    @Column(name = "branch_switch_send_task_need_add_comprobantes", length = 1, nullable = false)
    private String switchSendTaskNeedAddComprobantes;

    /**
     * <pre>
     * DB remark: 开关,用户登录凭证，ip变化时用户登录凭证失不失效,Y失效,N不失效
     * DB column: branch_switch_ip_change_token_effective	CHAR(1)	<--->	switchIpChangeTokenEffective	java.lang.String
     * DB is  Nullable: false
     * DB defaultValue: Y
     * </pre>
     */
    @NotBlank(message = "{" + ClientBranchBeanI18nConstant.CLIENT_BRANCH_BEAN_SWITCH_IP_CHANGE_TOKEN_EFFECTIVE_NOT_BLANK + "}", groups = {IBaseValidGroup.Add.class, IBaseValidGroup.Update.class})
    @Length(max = 1, message = "{" + ClientBranchBeanI18nConstant.CLIENT_BRANCH_BEAN_SWITCH_IP_CHANGE_TOKEN_EFFECTIVE_LENGTH + "}", groups = {IBaseValidGroup.Add.class, IBaseValidGroup.Update.class})
    @Column(name = "branch_switch_ip_change_token_effective", length = 1, nullable = false)
    private String switchIpChangeTokenEffective;

    /**
     * <pre>
     * DB remark: 创建时间
     * DB column: branch_create_timestamp	TIMESTAMP(19)	<--->	createTimestamp	java.util.Date
     * DB is  Nullable: false
     * DB defaultValue: CURRENT_TIMESTAMP
     * </pre>
     */
    @ValidDateTimeFormat(pattern = DateUtil.DATE_PATTERN_YYYY_MM_DD_HH_MM_SS, message = "{" + ClientBranchBeanI18nConstant.CLIENT_BRANCH_BEAN_CREATE_TIMESTAMP_DATE_TIME_FORMAT + "}", groups = {IBaseValidGroup.Add.class, IBaseValidGroup.Update.class})
    @DateTimeFormat(pattern = DateUtil.DATE_PATTERN_YYYY_MM_DD_HH_MM_SS)
    @NotNull(message = "{" + ClientBranchBeanI18nConstant.CLIENT_BRANCH_BEAN_CREATE_TIMESTAMP_NOT_NULL + "}", groups = {IBaseValidGroup.Add.class, IBaseValidGroup.Update.class})
    @Column(name = "branch_create_timestamp", length = 19, nullable = false)
    private Date createTimestamp;

    /**
     * <pre>
     * DB remark: 创建人,与t_crew.crew_username字段关联
     * DB column: branch_create_by	VARCHAR(20)	<--->	createBy	java.lang.String
     * DB is  Nullable: false
     * DB defaultValue: null
     * </pre>
     */
    @NotBlank(message = "{" + ClientBranchBeanI18nConstant.CLIENT_BRANCH_BEAN_CREATE_BY_NOT_BLANK + "}", groups = {IBaseValidGroup.Add.class, IBaseValidGroup.Update.class})
    @Length(max = 20, message = "{" + ClientBranchBeanI18nConstant.CLIENT_BRANCH_BEAN_CREATE_BY_LENGTH + "}", groups = {IBaseValidGroup.Add.class, IBaseValidGroup.Update.class})
    @Column(name = "branch_create_by", length = 20, nullable = false)
    private String createBy;

    /**
     * <pre>
     * DB remark: 逻辑删除标志【N[正常]，Y[删除]】
     * DB column: branch_delete_flag	CHAR(1)	<--->	deleteFlag	java.lang.String
     * DB is  Nullable: false
     * DB defaultValue: N
     * </pre>
     */
    @NotBlank(message = "{" + ClientBranchBeanI18nConstant.CLIENT_BRANCH_BEAN_DELETE_FLAG_NOT_BLANK + "}", groups = {IBaseValidGroup.Add.class, IBaseValidGroup.Update.class})
    @Length(max = 1, message = "{" + ClientBranchBeanI18nConstant.CLIENT_BRANCH_BEAN_DELETE_FLAG_LENGTH + "}", groups = {IBaseValidGroup.Add.class, IBaseValidGroup.Update.class})
    @Column(name = "branch_delete_flag", length = 1, nullable = false)
    private String deleteFlag;

    private static final long serialVersionUID = 1L;

    /**
     * 获取 数据库主键ID
     *
     * @return branch_id - 数据库主键ID
     */
    public Long getId() {
        return id;
    }

    /**
     * 设置 数据库主键ID
     *
     * @param id - 数据库主键ID
     */
    public ClientBranchBean setId(Long id) {
        this.id = id;
        return this;
    }

    /**
     * 获取 网点内部ID
     *
     * @return branch_internal_id - 网点内部ID
     */
    public String getInternalId() {
        return internalId;
    }

    /**
     * 设置 网点内部ID
     *
     * @param internalId - 网点内部ID
     */
    public ClientBranchBean setInternalId(String internalId) {
        this.internalId = internalId == null ? null : internalId.trim();
        return this;
    }

    /**
     * 获取 网点名称
     *
     * @return branch_name - 网点名称
     */
    public String getName() {
        return name;
    }

    /**
     * 设置 网点名称
     *
     * @param name - 网点名称
     */
    public ClientBranchBean setName(String name) {
        this.name = name == null ? null : name.trim();
        return this;
    }

    /**
     * 获取 客户类型为[CLIENT]所属哪一个CIT的客户，与t_client.client_id 字段冗余，且类型为[CIT]；0为CIT
     *
     * @return branch_cit_id - 客户类型为[CLIENT]所属哪一个CIT的客户，与t_client.client_id 字段冗余，且类型为[CIT]；0为CIT
     */
    public Long getCitId() {
        return citId;
    }

    /**
     * 设置 客户类型为[CLIENT]所属哪一个CIT的客户，与t_client.client_id 字段冗余，且类型为[CIT]；0为CIT
     *
     * @param citId - 客户类型为[CLIENT]所属哪一个CIT的客户，与t_client.client_id 字段冗余，且类型为[CIT]；0为CIT
     */
    public ClientBranchBean setCitId(Long citId) {
        this.citId = citId;
        return this;
    }

    /**
     * 获取 网点类型【CIT,CLIENT,BANK...】
     *
     * @return branch_type - 网点类型【CIT,CLIENT,BANK...】
     */
    public String getType() {
        return type;
    }

    /**
     * 设置 网点类型【CIT,CLIENT,BANK...】
     *
     * @param type - 网点类型【CIT,CLIENT,BANK...】
     */
    public ClientBranchBean setType(String type) {
        this.type = type == null ? null : type.trim();
        return this;
    }

    /**
     * 获取 网点所属的客户ID,与t_client.client_id 字段关联
     *
     * @return branch_client_id - 网点所属的客户ID,与t_client.client_id 字段关联
     */
    public Long getClientId() {
        return clientId;
    }

    /**
     * 设置 网点所属的客户ID,与t_client.client_id 字段关联
     *
     * @param clientId - 网点所属的客户ID,与t_client.client_id 字段关联
     */
    public ClientBranchBean setClientId(Long clientId) {
        this.clientId = clientId;
        return this;
    }

    /**
     * 获取 网点所属的客户内部ID,与t_client.client_internal_id 字段冗余
     *
     * @return branch_client_internal_id - 网点所属的客户内部ID,与t_client.client_internal_id 字段冗余
     */
    public String getClientInternalId() {
        return clientInternalId;
    }

    /**
     * 设置 网点所属的客户内部ID,与t_client.client_internal_id 字段冗余
     *
     * @param clientInternalId - 网点所属的客户内部ID,与t_client.client_internal_id 字段冗余
     */
    public ClientBranchBean setClientInternalId(String clientInternalId) {
        this.clientInternalId = clientInternalId == null ? null : clientInternalId.trim();
        return this;
    }

    /**
     * 获取 客户的名称,与t_client.client_name冗余
     *
     * @return branch_client_name - 客户的名称,与t_client.client_name冗余
     */
    public String getClientName() {
        return clientName;
    }

    /**
     * 设置 客户的名称,与t_client.client_name冗余
     *
     * @param clientName - 客户的名称,与t_client.client_name冗余
     */
    public ClientBranchBean setClientName(String clientName) {
        this.clientName = clientName == null ? null : clientName.trim();
        return this;
    }

    /**
     * 获取 网点时域【以GMT标准 America/Mexico_City为墨西哥时区】
     *
     * @return branch_time_zone - 网点时域【以GMT标准 America/Mexico_City为墨西哥时区】
     */
    public String getTimeZone() {
        return timeZone;
    }

    /**
     * 设置 网点时域【以GMT标准 America/Mexico_City为墨西哥时区】
     *
     * @param timeZone - 网点时域【以GMT标准 America/Mexico_City为墨西哥时区】
     */
    public ClientBranchBean setTimeZone(String timeZone) {
        this.timeZone = timeZone == null ? null : timeZone.trim();
        return this;
    }

    /**
     * 获取 网点联系电话
     *
     * @return branch_phone - 网点联系电话
     */
    public String getPhone() {
        return phone;
    }

    /**
     * 设置 网点联系电话
     *
     * @param phone - 网点联系电话
     */
    public ClientBranchBean setPhone(String phone) {
        this.phone = phone == null ? null : phone.trim();
        return this;
    }

    /**
     * 获取 网点地址
     *
     * @return branch_address - 网点地址
     */
    public String getAddress() {
        return address;
    }

    /**
     * 设置 网点地址
     *
     * @param address - 网点地址
     */
    public ClientBranchBean setAddress(String address) {
        this.address = address == null ? null : address.trim();
        return this;
    }

    /**
     * 获取 网点坐标纬度,浮点型
     *
     * @return branch_latitude - 网点坐标纬度,浮点型
     */
    public String getLatitude() {
        return latitude;
    }

    /**
     * 设置 网点坐标纬度,浮点型
     *
     * @param latitude - 网点坐标纬度,浮点型
     */
    public ClientBranchBean setLatitude(String latitude) {
        this.latitude = latitude == null ? null : latitude.trim();
        return this;
    }

    /**
     * 获取 网点坐标经度,浮点型
     *
     * @return branch_longitude - 网点坐标经度,浮点型
     */
    public String getLongitude() {
        return longitude;
    }

    /**
     * 设置 网点坐标经度,浮点型
     *
     * @param longitude - 网点坐标经度,浮点型
     */
    public ClientBranchBean setLongitude(String longitude) {
        this.longitude = longitude == null ? null : longitude.trim();
        return this;
    }

    /**
     * 获取 网点保险箱钥匙编号
     *
     * @return branch_safe_key_number - 网点保险箱钥匙编号
     */
    public String getSafeKeyNumber() {
        return safeKeyNumber;
    }

    /**
     * 设置 网点保险箱钥匙编号
     *
     * @param safeKeyNumber - 网点保险箱钥匙编号
     */
    public ClientBranchBean setSafeKeyNumber(String safeKeyNumber) {
        this.safeKeyNumber = safeKeyNumber == null ? null : safeKeyNumber.trim();
        return this;
    }

    /**
     * 获取 网点用户在APP操作任务，任务数据同步到服务器的时间间隔，单位s（秒），默认900秒
     *
     * @return branch_synchronous_interval - 网点用户在APP操作任务，任务数据同步到服务器的时间间隔，单位s（秒），默认900秒
     */
    public Long getSynchronousInterval() {
        return synchronousInterval;
    }

    /**
     * 设置 网点用户在APP操作任务，任务数据同步到服务器的时间间隔，单位s（秒），默认900秒
     *
     * @param synchronousInterval - 网点用户在APP操作任务，任务数据同步到服务器的时间间隔，单位s（秒），默认900秒
     */
    public ClientBranchBean setSynchronousInterval(Long synchronousInterval) {
        this.synchronousInterval = synchronousInterval;
        return this;
    }

    /**
     * 获取 是否需要分配车辆,Y有,N无【备注:该分支,名下的司机,在登陆APP客户端时,是否弹出分配车辆,开关[需求改变,是因为TanMeMe的任务是外部导入,已经分配好线路,车辆,司机,保镖,营业员 dateBy 2016-08-29]】
     *
     * @return branch_assign_vehicle_flag - 是否需要分配车辆,Y有,N无【备注:该分支,名下的司机,在登陆APP客户端时,是否弹出分配车辆,开关[需求改变,是因为TanMeMe的任务是外部导入,已经分配好线路,车辆,司机,保镖,营业员 dateBy 2016-08-29]】
     */
    public String getAssignVehicleFlag() {
        return assignVehicleFlag;
    }

    /**
     * 设置 是否需要分配车辆,Y有,N无【备注:该分支,名下的司机,在登陆APP客户端时,是否弹出分配车辆,开关[需求改变,是因为TanMeMe的任务是外部导入,已经分配好线路,车辆,司机,保镖,营业员 dateBy 2016-08-29]】
     *
     * @param assignVehicleFlag - 是否需要分配车辆,Y有,N无【备注:该分支,名下的司机,在登陆APP客户端时,是否弹出分配车辆,开关[需求改变,是因为TanMeMe的任务是外部导入,已经分配好线路,车辆,司机,保镖,营业员 dateBy 2016-08-29]】
     */
    public ClientBranchBean setAssignVehicleFlag(String assignVehicleFlag) {
        this.assignVehicleFlag = assignVehicleFlag == null ? null : assignVehicleFlag.trim();
        return this;
    }

    /**
     * 获取 是否需要分配路线,Y有,N无【备注:该分支,名下的司机,在登陆APP客户端时,是否弹出分配路线,开关[需求改变,是因为TanMeMe的任务是外部导入,已经分配好线路,车辆,司机,保镖,营业员 dateBy 2016-08-29]】
     *
     * @return branch_assign_route_flag - 是否需要分配路线,Y有,N无【备注:该分支,名下的司机,在登陆APP客户端时,是否弹出分配路线,开关[需求改变,是因为TanMeMe的任务是外部导入,已经分配好线路,车辆,司机,保镖,营业员 dateBy 2016-08-29]】
     */
    public String getAssignRouteFlag() {
        return assignRouteFlag;
    }

    /**
     * 设置 是否需要分配路线,Y有,N无【备注:该分支,名下的司机,在登陆APP客户端时,是否弹出分配路线,开关[需求改变,是因为TanMeMe的任务是外部导入,已经分配好线路,车辆,司机,保镖,营业员 dateBy 2016-08-29]】
     *
     * @param assignRouteFlag - 是否需要分配路线,Y有,N无【备注:该分支,名下的司机,在登陆APP客户端时,是否弹出分配路线,开关[需求改变,是因为TanMeMe的任务是外部导入,已经分配好线路,车辆,司机,保镖,营业员 dateBy 2016-08-29]】
     */
    public ClientBranchBean setAssignRouteFlag(String assignRouteFlag) {
        this.assignRouteFlag = assignRouteFlag == null ? null : assignRouteFlag.trim();
        return this;
    }

    /**
     * 获取 是否需要分配收银员,Y有,N无【备注:该分支,名下的司机,在登陆APP客户端时,是否弹出分配收银员,开关[需求改变,是因为TanMeMe的任务是外部导入,已经分配好线路,车辆,司机,保镖,营业员 dateBy 2016-08-29]】
     *
     * @return branch_assign_auxiliary_flag - 是否需要分配收银员,Y有,N无【备注:该分支,名下的司机,在登陆APP客户端时,是否弹出分配收银员,开关[需求改变,是因为TanMeMe的任务是外部导入,已经分配好线路,车辆,司机,保镖,营业员 dateBy 2016-08-29]】
     */
    public String getAssignAuxiliaryFlag() {
        return assignAuxiliaryFlag;
    }

    /**
     * 设置 是否需要分配收银员,Y有,N无【备注:该分支,名下的司机,在登陆APP客户端时,是否弹出分配收银员,开关[需求改变,是因为TanMeMe的任务是外部导入,已经分配好线路,车辆,司机,保镖,营业员 dateBy 2016-08-29]】
     *
     * @param assignAuxiliaryFlag - 是否需要分配收银员,Y有,N无【备注:该分支,名下的司机,在登陆APP客户端时,是否弹出分配收银员,开关[需求改变,是因为TanMeMe的任务是外部导入,已经分配好线路,车辆,司机,保镖,营业员 dateBy 2016-08-29]】
     */
    public ClientBranchBean setAssignAuxiliaryFlag(String assignAuxiliaryFlag) {
        this.assignAuxiliaryFlag = assignAuxiliaryFlag == null ? null : assignAuxiliaryFlag.trim();
        return this;
    }

    /**
     * 获取 是否需要分配保镖,Y有,N无【备注:该分支,名下的司机,在登陆APP客户端时,是否弹出分配保镖,开关[需求改变,是因为TanMeMe的任务是外部导入,已经分配好线路,车辆,司机,保镖,营业员 dateBy 2016-08-29]】
     *
     * @return branch_assign_guard_flag - 是否需要分配保镖,Y有,N无【备注:该分支,名下的司机,在登陆APP客户端时,是否弹出分配保镖,开关[需求改变,是因为TanMeMe的任务是外部导入,已经分配好线路,车辆,司机,保镖,营业员 dateBy 2016-08-29]】
     */
    public String getAssignGuardFlag() {
        return assignGuardFlag;
    }

    /**
     * 设置 是否需要分配保镖,Y有,N无【备注:该分支,名下的司机,在登陆APP客户端时,是否弹出分配保镖,开关[需求改变,是因为TanMeMe的任务是外部导入,已经分配好线路,车辆,司机,保镖,营业员 dateBy 2016-08-29]】
     *
     * @param assignGuardFlag - 是否需要分配保镖,Y有,N无【备注:该分支,名下的司机,在登陆APP客户端时,是否弹出分配保镖,开关[需求改变,是因为TanMeMe的任务是外部导入,已经分配好线路,车辆,司机,保镖,营业员 dateBy 2016-08-29]】
     */
    public ClientBranchBean setAssignGuardFlag(String assignGuardFlag) {
        this.assignGuardFlag = assignGuardFlag == null ? null : assignGuardFlag.trim();
        return this;
    }

    /**
     * 获取 是否需要validate,Y需要,N不需要
     *
     * @return branch_need_validate_flag - 是否需要validate,Y需要,N不需要
     */
    public String getNeedValidateFlag() {
        return needValidateFlag;
    }

    /**
     * 设置 是否需要validate,Y需要,N不需要
     *
     * @param needValidateFlag - 是否需要validate,Y需要,N不需要
     */
    public ClientBranchBean setNeedValidateFlag(String needValidateFlag) {
        this.needValidateFlag = needValidateFlag == null ? null : needValidateFlag.trim();
        return this;
    }

    /**
     * 获取 是否达到目的才能开始任务,Y需要,N不需要
     *
     * @return branch_need_arrive_flag - 是否达到目的才能开始任务,Y需要,N不需要
     */
    public String getNeedArriveFlag() {
        return needArriveFlag;
    }

    /**
     * 设置 是否达到目的才能开始任务,Y需要,N不需要
     *
     * @param needArriveFlag - 是否达到目的才能开始任务,Y需要,N不需要
     */
    public ClientBranchBean setNeedArriveFlag(String needArriveFlag) {
        this.needArriveFlag = needArriveFlag == null ? null : needArriveFlag.trim();
        return this;
    }

    /**
     * 获取 是否需要按顺序完成任务,Y需要,N不需要
     *
     * @return branch_need_order_flag - 是否需要按顺序完成任务,Y需要,N不需要
     */
    public String getNeedOrderFlag() {
        return needOrderFlag;
    }

    /**
     * 设置 是否需要按顺序完成任务,Y需要,N不需要
     *
     * @param needOrderFlag - 是否需要按顺序完成任务,Y需要,N不需要
     */
    public ClientBranchBean setNeedOrderFlag(String needOrderFlag) {
        this.needOrderFlag = needOrderFlag == null ? null : needOrderFlag.trim();
        return this;
    }

    /**
     * 获取 是否需要打印,Y需要,N不需要
     *
     * @return branch_need_print_flag - 是否需要打印,Y需要,N不需要
     */
    public String getNeedPrintFlag() {
        return needPrintFlag;
    }

    /**
     * 设置 是否需要打印,Y需要,N不需要
     *
     * @param needPrintFlag - 是否需要打印,Y需要,N不需要
     */
    public ClientBranchBean setNeedPrintFlag(String needPrintFlag) {
        this.needPrintFlag = needPrintFlag == null ? null : needPrintFlag.trim();
        return this;
    }

    /**
     * 获取 是否需要输入PIN码,Y需要,N不需要
     *
     * @return branch_need_pin_flag - 是否需要输入PIN码,Y需要,N不需要
     */
    public String getNeedPinFlag() {
        return needPinFlag;
    }

    /**
     * 设置 是否需要输入PIN码,Y需要,N不需要
     *
     * @param needPinFlag - 是否需要输入PIN码,Y需要,N不需要
     */
    public ClientBranchBean setNeedPinFlag(String needPinFlag) {
        this.needPinFlag = needPinFlag == null ? null : needPinFlag.trim();
        return this;
    }

    /**
     * 获取 cancel时是否需要到任务点拍照,Y需要,N不需要
     *
     * @return branch_need_photograph_flag - cancel时是否需要到任务点拍照,Y需要,N不需要
     */
    public String getNeedPhotographFlag() {
        return needPhotographFlag;
    }

    /**
     * 设置 cancel时是否需要到任务点拍照,Y需要,N不需要
     *
     * @param needPhotographFlag - cancel时是否需要到任务点拍照,Y需要,N不需要
     */
    public ClientBranchBean setNeedPhotographFlag(String needPhotographFlag) {
        this.needPhotographFlag = needPhotographFlag == null ? null : needPhotographFlag.trim();
        return this;
    }

    /**
     * 获取 是否拍照签名才能完成任务,Y需要,N不需要
     *
     * @return branch_need_signature_flag - 是否拍照签名才能完成任务,Y需要,N不需要
     */
    public String getNeedSignatureFlag() {
        return needSignatureFlag;
    }

    /**
     * 设置 是否拍照签名才能完成任务,Y需要,N不需要
     *
     * @param needSignatureFlag - 是否拍照签名才能完成任务,Y需要,N不需要
     */
    public ClientBranchBean setNeedSignatureFlag(String needSignatureFlag) {
        this.needSignatureFlag = needSignatureFlag == null ? null : needSignatureFlag.trim();
        return this;
    }

    /**
     * 获取 开关,收钱，取消任务，是否需要访问票据,Y需要,N不需要
     *
     * @return branch_switch_cancel_task_visit_bill_by_pickup - 开关,收钱，取消任务，是否需要访问票据,Y需要,N不需要
     */
    public String getSwitchCancelTaskVisitBillByPickup() {
        return switchCancelTaskVisitBillByPickup;
    }

    /**
     * 设置 开关,收钱，取消任务，是否需要访问票据,Y需要,N不需要
     *
     * @param switchCancelTaskVisitBillByPickup - 开关,收钱，取消任务，是否需要访问票据,Y需要,N不需要
     */
    public ClientBranchBean setSwitchCancelTaskVisitBillByPickup(String switchCancelTaskVisitBillByPickup) {
        this.switchCancelTaskVisitBillByPickup = switchCancelTaskVisitBillByPickup == null ? null : switchCancelTaskVisitBillByPickup.trim();
        return this;
    }

    /**
     * 获取 开关,送钱，取消任务，是否需要访问票据,Y需要,N不需要
     *
     * @return branch_switch_cancel_task_visit_bill_by_delivery - 开关,送钱，取消任务，是否需要访问票据,Y需要,N不需要
     */
    public String getSwitchCancelTaskVisitBillByDelivery() {
        return switchCancelTaskVisitBillByDelivery;
    }

    /**
     * 设置 开关,送钱，取消任务，是否需要访问票据,Y需要,N不需要
     *
     * @param switchCancelTaskVisitBillByDelivery - 开关,送钱，取消任务，是否需要访问票据,Y需要,N不需要
     */
    public ClientBranchBean setSwitchCancelTaskVisitBillByDelivery(String switchCancelTaskVisitBillByDelivery) {
        this.switchCancelTaskVisitBillByDelivery = switchCancelTaskVisitBillByDelivery == null ? null : switchCancelTaskVisitBillByDelivery.trim();
        return this;
    }

    /**
     * 获取 开关,送钱，取消任务，是否需要访问票据,Y需要,N不需要
     *
     * @return branch_switch_cancel_task_visit_bill_by_directly_to_pickup - 开关,送钱，取消任务，是否需要访问票据,Y需要,N不需要
     */
    public String getSwitchCancelTaskVisitBillByDirectlyToPickup() {
        return switchCancelTaskVisitBillByDirectlyToPickup;
    }

    /**
     * 设置 开关,送钱，取消任务，是否需要访问票据,Y需要,N不需要
     *
     * @param switchCancelTaskVisitBillByDirectlyToPickup - 开关,送钱，取消任务，是否需要访问票据,Y需要,N不需要
     */
    public ClientBranchBean setSwitchCancelTaskVisitBillByDirectlyToPickup(String switchCancelTaskVisitBillByDirectlyToPickup) {
        this.switchCancelTaskVisitBillByDirectlyToPickup = switchCancelTaskVisitBillByDirectlyToPickup == null ? null : switchCancelTaskVisitBillByDirectlyToPickup.trim();
        return this;
    }

    /**
     * 获取 开关,送钱，取消任务，是否需要访问票据,Y需要,N不需要
     *
     * @return branch_switch_cancel_task_visit_bill_by_directly_to_delivery - 开关,送钱，取消任务，是否需要访问票据,Y需要,N不需要
     */
    public String getSwitchCancelTaskVisitBillByDirectlyToDelivery() {
        return switchCancelTaskVisitBillByDirectlyToDelivery;
    }

    /**
     * 设置 开关,送钱，取消任务，是否需要访问票据,Y需要,N不需要
     *
     * @param switchCancelTaskVisitBillByDirectlyToDelivery - 开关,送钱，取消任务，是否需要访问票据,Y需要,N不需要
     */
    public ClientBranchBean setSwitchCancelTaskVisitBillByDirectlyToDelivery(String switchCancelTaskVisitBillByDirectlyToDelivery) {
        this.switchCancelTaskVisitBillByDirectlyToDelivery = switchCancelTaskVisitBillByDirectlyToDelivery == null ? null : switchCancelTaskVisitBillByDirectlyToDelivery.trim();
        return this;
    }

    /**
     * 获取 开关,送钱，是否需要添加票据,Y需要,N不需要
     *
     * @return branch_switch_send_task_need_add_comprobantes - 开关,送钱，是否需要添加票据,Y需要,N不需要
     */
    public String getSwitchSendTaskNeedAddComprobantes() {
        return switchSendTaskNeedAddComprobantes;
    }

    /**
     * 设置 开关,送钱，是否需要添加票据,Y需要,N不需要
     *
     * @param switchSendTaskNeedAddComprobantes - 开关,送钱，是否需要添加票据,Y需要,N不需要
     */
    public ClientBranchBean setSwitchSendTaskNeedAddComprobantes(String switchSendTaskNeedAddComprobantes) {
        this.switchSendTaskNeedAddComprobantes = switchSendTaskNeedAddComprobantes == null ? null : switchSendTaskNeedAddComprobantes.trim();
        return this;
    }

    /**
     * 获取 开关,用户登录凭证，ip变化时用户登录凭证失不失效,Y失效,N不失效
     *
     * @return branch_switch_ip_change_token_effective - 开关,用户登录凭证，ip变化时用户登录凭证失不失效,Y失效,N不失效
     */
    public String getSwitchIpChangeTokenEffective() {
        return switchIpChangeTokenEffective;
    }

    /**
     * 设置 开关,用户登录凭证，ip变化时用户登录凭证失不失效,Y失效,N不失效
     *
     * @param switchIpChangeTokenEffective - 开关,用户登录凭证，ip变化时用户登录凭证失不失效,Y失效,N不失效
     */
    public ClientBranchBean setSwitchIpChangeTokenEffective(String switchIpChangeTokenEffective) {
        this.switchIpChangeTokenEffective = switchIpChangeTokenEffective == null ? null : switchIpChangeTokenEffective.trim();
        return this;
    }

    /**
     * 获取 创建时间
     *
     * @return branch_create_timestamp - 创建时间
     */
    public Date getCreateTimestamp() {
        return createTimestamp;
    }

    /**
     * 设置 创建时间
     *
     * @param createTimestamp - 创建时间
     */
    public ClientBranchBean setCreateTimestamp(Date createTimestamp) {
        this.createTimestamp = createTimestamp;
        return this;
    }

    /**
     * 获取 创建人,与t_crew.crew_username字段关联
     *
     * @return branch_create_by - 创建人,与t_crew.crew_username字段关联
     */
    public String getCreateBy() {
        return createBy;
    }

    /**
     * 设置 创建人,与t_crew.crew_username字段关联
     *
     * @param createBy - 创建人,与t_crew.crew_username字段关联
     */
    public ClientBranchBean setCreateBy(String createBy) {
        this.createBy = createBy == null ? null : createBy.trim();
        return this;
    }

    /**
     * 获取 逻辑删除标志【N[正常]，Y[删除]】
     *
     * @return branch_delete_flag - 逻辑删除标志【N[正常]，Y[删除]】
     */
    public String getDeleteFlag() {
        return deleteFlag;
    }

    /**
     * 设置 逻辑删除标志【N[正常]，Y[删除]】
     *
     * @param deleteFlag - 逻辑删除标志【N[正常]，Y[删除]】
     */
    public ClientBranchBean setDeleteFlag(String deleteFlag) {
        this.deleteFlag = deleteFlag == null ? null : deleteFlag.trim();
        return this;
    }
}