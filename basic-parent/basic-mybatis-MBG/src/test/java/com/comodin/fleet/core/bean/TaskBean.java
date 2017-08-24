package com.comodin.fleet.core.bean;

import com.comodin.basic.util.date.DateUtil;
import com.comodin.basic.validation.IBaseValidGroup;
import com.comodin.basic.validation.constraints.*;
import com.comodin.fleet.constant.i18n.TaskBeanI18nConstant;
import java.io.Serializable;
import java.util.Date;
import javax.persistence.*;
import javax.validation.constraints.*;
import org.hibernate.validator.constraints.*;
import org.springframework.format.annotation.DateTimeFormat;

@SuppressWarnings({"unused", "UnusedReturnValue", "SameParameterValue", "DefaultAnnotationParam"})
@Entity
@Table(name = "t_task")
public class TaskBean implements Serializable {
    /**
     * <pre>
     * DB remark: 数据库主键ID【{"max":13}】
     * DB column: task_pk_id	BIGINT(19)	<--->	pkId	java.lang.Long
     * DB is  Nullable: false
     * DB defaultValue: null
     * </pre>
     */
    @NotNull(message = "{" + TaskBeanI18nConstant.TASK_BEAN_PK_ID_NOT_NULL + "}", groups = {IBaseValidGroup.Update.class})
    @ValidLength(max = 13, message = "{" + TaskBeanI18nConstant.TASK_BEAN_PK_ID_LENGTH + "}", groups = {IBaseValidGroup.Update.class})
    @Column(name = "task_pk_id", length = 19, nullable = false)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    private Long pkId;

    /**
     * <pre>
     * DB remark: 任务ID,与pk_id区别在于,业务场景:在 in_changed的时候,会生成两条记录task_pk_id 而task_id为同一条,且只有一条task_availability,为ENABLE【{"max":13}】
     * DB column: task_id	BIGINT(19)	<--->	taskId	java.lang.Long
     * DB is  Nullable: false
     * DB defaultValue: null
     * </pre>
     */
    @NotNull(message = "{" + TaskBeanI18nConstant.TASK_BEAN_TASK_ID_NOT_NULL + "}", groups = {IBaseValidGroup.Add.class, IBaseValidGroup.Update.class})
    @ValidLength(max = 13, message = "{" + TaskBeanI18nConstant.TASK_BEAN_TASK_ID_LENGTH + "}", groups = {IBaseValidGroup.Add.class, IBaseValidGroup.Update.class})
    @Column(name = "task_id", length = 19, nullable = false)
    private Long taskId;

    /**
     * <pre>
     * DB remark: 任务执行日期,与t_task_contract.contract_cron_expression 服务日期表达式所定义生成
     * DB column: task_service_date	CHAR(10)	<--->	serviceDate	java.lang.String
     * DB is  Nullable: false
     * DB defaultValue: null
     * </pre>
     */
    @NotBlank(message = "{" + TaskBeanI18nConstant.TASK_BEAN_SERVICE_DATE_NOT_BLANK + "}", groups = {IBaseValidGroup.Add.class, IBaseValidGroup.Update.class})
    @Length(max = 10, message = "{" + TaskBeanI18nConstant.TASK_BEAN_SERVICE_DATE_LENGTH + "}", groups = {IBaseValidGroup.Add.class, IBaseValidGroup.Update.class})
    @Column(name = "task_service_date", length = 10, nullable = false)
    private String serviceDate;

    /**
     * <pre>
     * DB remark: 服务类型,与t_task_contract.contract_service_type,关联
     * DB column: task_service_type	VARCHAR(20)	<--->	serviceType	java.lang.String
     * DB is  Nullable: false
     * DB defaultValue: null
     * </pre>
     */
    @NotBlank(message = "{" + TaskBeanI18nConstant.TASK_BEAN_SERVICE_TYPE_NOT_BLANK + "}", groups = {IBaseValidGroup.Add.class, IBaseValidGroup.Update.class})
    @Length(max = 20, message = "{" + TaskBeanI18nConstant.TASK_BEAN_SERVICE_TYPE_LENGTH + "}", groups = {IBaseValidGroup.Add.class, IBaseValidGroup.Update.class})
    @Column(name = "task_service_type", length = 20, nullable = false)
    private String serviceType;

    /**
     * <pre>
     * DB remark: 任务是否需要现场数钞【NOT_COUNT[不需要]COUNT_TOTAL[统计总额]COUNT_DENOMINATION[统计面额]REAL_TIME_ARRIVAL[实时到账]】
     * DB column: task_whether_site_counting	VARCHAR(20)	<--->	whetherSiteCounting	java.lang.String
     * DB is  Nullable: false
     * DB defaultValue: NOT_COUNT
     * </pre>
     */
    @NotBlank(message = "{" + TaskBeanI18nConstant.TASK_BEAN_WHETHER_SITE_COUNTING_NOT_BLANK + "}", groups = {IBaseValidGroup.Add.class, IBaseValidGroup.Update.class})
    @Length(max = 20, message = "{" + TaskBeanI18nConstant.TASK_BEAN_WHETHER_SITE_COUNTING_LENGTH + "}", groups = {IBaseValidGroup.Add.class, IBaseValidGroup.Update.class})
    @Column(name = "task_whether_site_counting", length = 20, nullable = false)
    private String whetherSiteCounting;

    /**
     * <pre>
     * DB remark: 路线id,与t_task_contract.contract_route_id,关联
     * DB column: task_route_id	VARCHAR(10)	<--->	routeId	java.lang.String
     * DB is  Nullable: false
     * DB defaultValue: null
     * </pre>
     */
    @NotBlank(message = "{" + TaskBeanI18nConstant.TASK_BEAN_ROUTE_ID_NOT_BLANK + "}", groups = {IBaseValidGroup.Add.class, IBaseValidGroup.Update.class})
    @Length(max = 10, message = "{" + TaskBeanI18nConstant.TASK_BEAN_ROUTE_ID_LENGTH + "}", groups = {IBaseValidGroup.Add.class, IBaseValidGroup.Update.class})
    @Column(name = "task_route_id", length = 10, nullable = false)
    private String routeId;

    /**
     * <pre>
     * DB remark: 路线顺序,与t_task_contract.contract_route_order,关联
     * DB column: task_route_order	INTEGER(10)	<--->	routeOrder	java.lang.Integer
     * DB is  Nullable: false
     * DB defaultValue: null
     * </pre>
     */
    @NotNull(message = "{" + TaskBeanI18nConstant.TASK_BEAN_ROUTE_ORDER_NOT_NULL + "}", groups = {IBaseValidGroup.Add.class, IBaseValidGroup.Update.class})
    @ValidLength(max = 10, message = "{" + TaskBeanI18nConstant.TASK_BEAN_ROUTE_ORDER_LENGTH + "}", groups = {IBaseValidGroup.Add.class, IBaseValidGroup.Update.class})
    @Column(name = "task_route_order", length = 10, nullable = false)
    private Integer routeOrder;

    /**
     * <pre>
     * DB remark: 任务状态,任务当下的状态 pending schedule assign_route assign_driver assign_guard assign_vehicle in_route in_processcomprobante completed inter_changed cancelled
     * DB column: task_status	VARCHAR(25)	<--->	status	java.lang.String
     * DB is  Nullable: false
     * DB defaultValue: null
     * </pre>
     */
    @NotBlank(message = "{" + TaskBeanI18nConstant.TASK_BEAN_STATUS_NOT_BLANK + "}", groups = {IBaseValidGroup.Add.class, IBaseValidGroup.Update.class})
    @Length(max = 25, message = "{" + TaskBeanI18nConstant.TASK_BEAN_STATUS_LENGTH + "}", groups = {IBaseValidGroup.Add.class, IBaseValidGroup.Update.class})
    @Column(name = "task_status", length = 25, nullable = false)
    private String status;

    /**
     * <pre>
     * DB remark: 任务是否有效【ENABLE[启用]、DISABLE[禁用]】
     * DB column: task_availability	CHAR(7)	<--->	availability	java.lang.String
     * DB is  Nullable: false
     * DB defaultValue: null
     * </pre>
     */
    @NotBlank(message = "{" + TaskBeanI18nConstant.TASK_BEAN_AVAILABILITY_NOT_BLANK + "}", groups = {IBaseValidGroup.Add.class, IBaseValidGroup.Update.class})
    @Length(max = 7, message = "{" + TaskBeanI18nConstant.TASK_BEAN_AVAILABILITY_LENGTH + "}", groups = {IBaseValidGroup.Add.class, IBaseValidGroup.Update.class})
    @Column(name = "task_availability", length = 7, nullable = false)
    private String availability;

    /**
     * <pre>
     * DB remark: 任务是否为交接，已收到钱在车上【Y[任务是已完成]、N[任务未完成]】
     * DB column: task_whether_completed	CHAR(25)	<--->	whetherCompleted	java.lang.String
     * DB is  Nullable: false
     * DB defaultValue: N
     * </pre>
     */
    @NotBlank(message = "{" + TaskBeanI18nConstant.TASK_BEAN_WHETHER_COMPLETED_NOT_BLANK + "}", groups = {IBaseValidGroup.Add.class, IBaseValidGroup.Update.class})
    @Length(max = 25, message = "{" + TaskBeanI18nConstant.TASK_BEAN_WHETHER_COMPLETED_LENGTH + "}", groups = {IBaseValidGroup.Add.class, IBaseValidGroup.Update.class})
    @Column(name = "task_whether_completed", length = 25, nullable = false)
    private String whetherCompleted;

    /**
     * <pre>
     * DB remark: 任务是否为交接时，所生成的新任务【Y[任务是交换出来的新任务]、N[不是]】
     * DB column: task_whether_inter_changed	CHAR(1)	<--->	whetherInterChanged	java.lang.String
     * DB is  Nullable: false
     * DB defaultValue: N
     * </pre>
     */
    @NotBlank(message = "{" + TaskBeanI18nConstant.TASK_BEAN_WHETHER_INTER_CHANGED_NOT_BLANK + "}", groups = {IBaseValidGroup.Add.class, IBaseValidGroup.Update.class})
    @Length(max = 1, message = "{" + TaskBeanI18nConstant.TASK_BEAN_WHETHER_INTER_CHANGED_LENGTH + "}", groups = {IBaseValidGroup.Add.class, IBaseValidGroup.Update.class})
    @Column(name = "task_whether_inter_changed", length = 1, nullable = false)
    private String whetherInterChanged;

    /**
     * <pre>
     * DB remark: interchange,["",ORIG,DEST]【date:2017-07-28 by:supeng】
     * DB column: task_inter_change_type	CHAR(4)	<--->	interChangeType	java.lang.String
     * DB is  Nullable: true
     * DB defaultValue: null
     * </pre>
     */
    @Length(max = 4, message = "{" + TaskBeanI18nConstant.TASK_BEAN_INTER_CHANGE_TYPE_LENGTH + "}", groups = {IBaseValidGroup.Add.class, IBaseValidGroup.Update.class})
    @Column(name = "task_inter_change_type", length = 4, nullable = true)
    private String interChangeType;

    /**
     * <pre>
     * DB remark: interchange,原先的任务复合ID，组成方式【|4|26|20161118|1101|1|】【|SIO公司内部ID|SIO公司网点内部ID|路线日期[yyyyMMdd]|路线ID|任务ID|】【date:2017-07-28 by:supeng】
     * DB column: task_inter_change_original_task_complex_id	VARCHAR(100)	<--->	interChangeOriginalComplexId	java.lang.String
     * DB is  Nullable: true
     * DB defaultValue: null
     * </pre>
     */
    @Length(max = 100, message = "{" + TaskBeanI18nConstant.TASK_BEAN_INTER_CHANGE_ORIGINAL_COMPLEX_ID_LENGTH + "}", groups = {IBaseValidGroup.Add.class, IBaseValidGroup.Update.class})
    @Column(name = "task_inter_change_original_task_complex_id", length = 100, nullable = true)
    private String interChangeOriginalComplexId;

    /**
     * <pre>
     * DB remark: interchange任务时地址坐标纬度,浮点型
     * DB column: task_inter_change_latitude	VARCHAR(15)	<--->	interChangeLatitude	java.lang.String
     * DB is  Nullable: true
     * DB defaultValue: null
     * </pre>
     */
    @Length(max = 15, message = "{" + TaskBeanI18nConstant.TASK_BEAN_INTER_CHANGE_LATITUDE_LENGTH + "}", groups = {IBaseValidGroup.Add.class, IBaseValidGroup.Update.class})
    @Column(name = "task_inter_change_latitude", length = 15, nullable = true)
    private String interChangeLatitude;

    /**
     * <pre>
     * DB remark: interchange任务时地址坐标经度,浮点型
     * DB column: task_inter_change_longitude	VARCHAR(15)	<--->	interChangeLongitude	java.lang.String
     * DB is  Nullable: true
     * DB defaultValue: null
     * </pre>
     */
    @Length(max = 15, message = "{" + TaskBeanI18nConstant.TASK_BEAN_INTER_CHANGE_LONGITUDE_LENGTH + "}", groups = {IBaseValidGroup.Add.class, IBaseValidGroup.Update.class})
    @Column(name = "task_inter_change_longitude", length = 15, nullable = true)
    private String interChangeLongitude;

    /**
     * <pre>
     * DB remark: 完成任务（或者部分完成任务）时地址坐标纬度,浮点型
     * DB column: task_complete_latitude	VARCHAR(15)	<--->	completeLatitude	java.lang.String
     * DB is  Nullable: true
     * DB defaultValue: null
     * </pre>
     */
    @Length(max = 15, message = "{" + TaskBeanI18nConstant.TASK_BEAN_COMPLETE_LATITUDE_LENGTH + "}", groups = {IBaseValidGroup.Add.class, IBaseValidGroup.Update.class})
    @Column(name = "task_complete_latitude", length = 15, nullable = true)
    private String completeLatitude;

    /**
     * <pre>
     * DB remark: 完成任务（或者部分完成任务）时地址坐标经度,浮点型
     * DB column: task_complete_longitude	VARCHAR(15)	<--->	completeLongitude	java.lang.String
     * DB is  Nullable: true
     * DB defaultValue: null
     * </pre>
     */
    @Length(max = 15, message = "{" + TaskBeanI18nConstant.TASK_BEAN_COMPLETE_LONGITUDE_LENGTH + "}", groups = {IBaseValidGroup.Add.class, IBaseValidGroup.Update.class})
    @Column(name = "task_complete_longitude", length = 15, nullable = true)
    private String completeLongitude;

    /**
     * <pre>
     * DB remark: APP司机部，每次回传的版本号
     * DB column: task_app_version	TIMESTAMP(19)	<--->	appVersion	java.util.Date
     * DB is  Nullable: true
     * DB defaultValue: null
     * </pre>
     */
    @ValidDateTimeFormat(pattern = DateUtil.DATE_PATTERN_YYYY_MM_DD_HH_MM_SS, message = "{" + TaskBeanI18nConstant.TASK_BEAN_APP_VERSION_DATE_TIME_FORMAT + "}", groups = {IBaseValidGroup.Add.class, IBaseValidGroup.Update.class})
    @DateTimeFormat(pattern = DateUtil.DATE_PATTERN_YYYY_MM_DD_HH_MM_SS)
    @Column(name = "task_app_version", length = 19, nullable = true)
    private Date appVersion;

    /**
     * <pre>
     * DB remark: 任务，到达目的（网点地址）时间，系统自动根据经纬度范围，推算出来的时间
     * DB column: task_arrival_time_auto_calc	TIMESTAMP(19)	<--->	arrivalTimeAutoCalc	java.util.Date
     * DB is  Nullable: true
     * DB defaultValue: null
     * </pre>
     */
    @ValidDateTimeFormat(pattern = DateUtil.DATE_PATTERN_YYYY_MM_DD_HH_MM_SS, message = "{" + TaskBeanI18nConstant.TASK_BEAN_ARRIVAL_TIME_AUTO_CALC_DATE_TIME_FORMAT + "}", groups = {IBaseValidGroup.Add.class, IBaseValidGroup.Update.class})
    @DateTimeFormat(pattern = DateUtil.DATE_PATTERN_YYYY_MM_DD_HH_MM_SS)
    @Column(name = "task_arrival_time_auto_calc", length = 19, nullable = true)
    private Date arrivalTimeAutoCalc;

    /**
     * <pre>
     * DB remark: 任务，到达目的（网点地址）时间，人工输入的时间
     * DB column: task_arrival_time_manual_input	TIMESTAMP(19)	<--->	arrivalTimeManualInput	java.util.Date
     * DB is  Nullable: true
     * DB defaultValue: null
     * </pre>
     */
    @ValidDateTimeFormat(pattern = DateUtil.DATE_PATTERN_YYYY_MM_DD_HH_MM_SS, message = "{" + TaskBeanI18nConstant.TASK_BEAN_ARRIVAL_TIME_MANUAL_INPUT_DATE_TIME_FORMAT + "}", groups = {IBaseValidGroup.Add.class, IBaseValidGroup.Update.class})
    @DateTimeFormat(pattern = DateUtil.DATE_PATTERN_YYYY_MM_DD_HH_MM_SS)
    @Column(name = "task_arrival_time_manual_input", length = 19, nullable = true)
    private Date arrivalTimeManualInput;

    /**
     * <pre>
     * DB remark: 任务处理开始时间,目前系统根据,司机手机APP,在进入该客户分支店时,任务状态为:in_process任务,到达任务地址,开始处理
     * DB column: task_process_start_timestamp	TIMESTAMP(19)	<--->	processStartTimestamp	java.util.Date
     * DB is  Nullable: true
     * DB defaultValue: null
     * </pre>
     */
    @ValidDateTimeFormat(pattern = DateUtil.DATE_PATTERN_YYYY_MM_DD_HH_MM_SS, message = "{" + TaskBeanI18nConstant.TASK_BEAN_PROCESS_START_TIMESTAMP_DATE_TIME_FORMAT + "}", groups = {IBaseValidGroup.Add.class, IBaseValidGroup.Update.class})
    @DateTimeFormat(pattern = DateUtil.DATE_PATTERN_YYYY_MM_DD_HH_MM_SS)
    @Column(name = "task_process_start_timestamp", length = 19, nullable = true)
    private Date processStartTimestamp;

    /**
     * <pre>
     * DB remark: 任务处理结束时间,目前系统根据,司机手机APP,在验收钞票与票据动作之后,completed任务,完成
     * DB column: task_process_end_timestamp	TIMESTAMP(19)	<--->	processEndTimestamp	java.util.Date
     * DB is  Nullable: true
     * DB defaultValue: null
     * </pre>
     */
    @ValidDateTimeFormat(pattern = DateUtil.DATE_PATTERN_YYYY_MM_DD_HH_MM_SS, message = "{" + TaskBeanI18nConstant.TASK_BEAN_PROCESS_END_TIMESTAMP_DATE_TIME_FORMAT + "}", groups = {IBaseValidGroup.Add.class, IBaseValidGroup.Update.class})
    @DateTimeFormat(pattern = DateUtil.DATE_PATTERN_YYYY_MM_DD_HH_MM_SS)
    @Column(name = "task_process_end_timestamp", length = 19, nullable = true)
    private Date processEndTimestamp;

    /**
     * <pre>
     * DB remark: 任务处理完成后,时效【ON_TIME 为及时、IN_ADVANCE 为早到、BE_LATE 为迟到、TIME_OUT 为超时】
     * DB column: task_process_timeliness	VARCHAR(10)	<--->	processTimeliness	java.lang.String
     * DB is  Nullable: true
     * DB defaultValue: null
     * </pre>
     */
    @Length(max = 10, message = "{" + TaskBeanI18nConstant.TASK_BEAN_PROCESS_TIMELINESS_LENGTH + "}", groups = {IBaseValidGroup.Add.class, IBaseValidGroup.Update.class})
    @Column(name = "task_process_timeliness", length = 10, nullable = true)
    private String processTimeliness;

    /**
     * <pre>
     * DB remark: 客户到客户类型，任务，到达目的（网点地址）时间，系统自动根据经纬度范围，推算出来的时间
     * DB column: task_partial_arrival_time_auto_calc	TIMESTAMP(19)	<--->	partialArrivalTimeAutoCalc	java.util.Date
     * DB is  Nullable: true
     * DB defaultValue: null
     * </pre>
     */
    @ValidDateTimeFormat(pattern = DateUtil.DATE_PATTERN_YYYY_MM_DD_HH_MM_SS, message = "{" + TaskBeanI18nConstant.TASK_BEAN_PARTIAL_ARRIVAL_TIME_AUTO_CALC_DATE_TIME_FORMAT + "}", groups = {IBaseValidGroup.Add.class, IBaseValidGroup.Update.class})
    @DateTimeFormat(pattern = DateUtil.DATE_PATTERN_YYYY_MM_DD_HH_MM_SS)
    @Column(name = "task_partial_arrival_time_auto_calc", length = 19, nullable = true)
    private Date partialArrivalTimeAutoCalc;

    /**
     * <pre>
     * DB remark: 客户到客户类型，任务，到达目的（网点地址）时间，人工输入的时间
     * DB column: task_partial_arrival_time_manual_input	TIMESTAMP(19)	<--->	partialArrivalTimeManualInput	java.util.Date
     * DB is  Nullable: true
     * DB defaultValue: null
     * </pre>
     */
    @ValidDateTimeFormat(pattern = DateUtil.DATE_PATTERN_YYYY_MM_DD_HH_MM_SS, message = "{" + TaskBeanI18nConstant.TASK_BEAN_PARTIAL_ARRIVAL_TIME_MANUAL_INPUT_DATE_TIME_FORMAT + "}", groups = {IBaseValidGroup.Add.class, IBaseValidGroup.Update.class})
    @DateTimeFormat(pattern = DateUtil.DATE_PATTERN_YYYY_MM_DD_HH_MM_SS)
    @Column(name = "task_partial_arrival_time_manual_input", length = 19, nullable = true)
    private Date partialArrivalTimeManualInput;

    /**
     * <pre>
     * DB remark: 客户到客户类型任务，收钱时的任务处理开始时间,目前系统根据,司机手机APP,在进入该客户分支店时,任务状态为:in_process任务,到达任务地址,开始处理
     * DB column: task_partial_process_start_timestamp	TIMESTAMP(19)	<--->	partialProcessStartTimestamp	java.util.Date
     * DB is  Nullable: true
     * DB defaultValue: null
     * </pre>
     */
    @ValidDateTimeFormat(pattern = DateUtil.DATE_PATTERN_YYYY_MM_DD_HH_MM_SS, message = "{" + TaskBeanI18nConstant.TASK_BEAN_PARTIAL_PROCESS_START_TIMESTAMP_DATE_TIME_FORMAT + "}", groups = {IBaseValidGroup.Add.class, IBaseValidGroup.Update.class})
    @DateTimeFormat(pattern = DateUtil.DATE_PATTERN_YYYY_MM_DD_HH_MM_SS)
    @Column(name = "task_partial_process_start_timestamp", length = 19, nullable = true)
    private Date partialProcessStartTimestamp;

    /**
     * <pre>
     * DB remark: 客户到客户类型任务，收钱时的任务处理结束时间,目前系统根据,司机手机APP,在验收钞票与票据动作之后,completed任务,完成
     * DB column: task_partial_process_end_timestamp	TIMESTAMP(19)	<--->	partialProcessEndTimestamp	java.util.Date
     * DB is  Nullable: true
     * DB defaultValue: null
     * </pre>
     */
    @ValidDateTimeFormat(pattern = DateUtil.DATE_PATTERN_YYYY_MM_DD_HH_MM_SS, message = "{" + TaskBeanI18nConstant.TASK_BEAN_PARTIAL_PROCESS_END_TIMESTAMP_DATE_TIME_FORMAT + "}", groups = {IBaseValidGroup.Add.class, IBaseValidGroup.Update.class})
    @DateTimeFormat(pattern = DateUtil.DATE_PATTERN_YYYY_MM_DD_HH_MM_SS)
    @Column(name = "task_partial_process_end_timestamp", length = 19, nullable = true)
    private Date partialProcessEndTimestamp;

    /**
     * <pre>
     * DB remark: 客户到客户类型任务，收钱时的任务处理完成后,时效【ON_TIME 为及时、IN_ADVANCE 为早到、BE_LATE 为迟到、TIME_OUT 为超时】
     * DB column: task_partial_process_timeliness	VARCHAR(10)	<--->	partialProcessTimeliness	java.lang.String
     * DB is  Nullable: true
     * DB defaultValue: null
     * </pre>
     */
    @Length(max = 10, message = "{" + TaskBeanI18nConstant.TASK_BEAN_PARTIAL_PROCESS_TIMELINESS_LENGTH + "}", groups = {IBaseValidGroup.Add.class, IBaseValidGroup.Update.class})
    @Column(name = "task_partial_process_timeliness", length = 10, nullable = true)
    private String partialProcessTimeliness;

    /**
     * <pre>
     * DB remark: 取消任务,责任方【CIT,CLIENT】
     * DB column: task_cancel_responsible_party	VARCHAR(10)	<--->	cancelResponsibleParty	java.lang.String
     * DB is  Nullable: true
     * DB defaultValue: null
     * </pre>
     */
    @Length(max = 10, message = "{" + TaskBeanI18nConstant.TASK_BEAN_CANCEL_RESPONSIBLE_PARTY_LENGTH + "}", groups = {IBaseValidGroup.Add.class, IBaseValidGroup.Update.class})
    @Column(name = "task_cancel_responsible_party", length = 10, nullable = true)
    private String cancelResponsibleParty;

    /**
     * <pre>
     * DB remark: 取消任务,回执单[访问票据单]【目前需求,只有责任方为Client时,才有回执单】
     * DB column: task_cancel_single_receipt	VARCHAR(20)	<--->	cancelSingleReceipt	java.lang.String
     * DB is  Nullable: true
     * DB defaultValue: null
     * </pre>
     */
    @Length(max = 20, message = "{" + TaskBeanI18nConstant.TASK_BEAN_CANCEL_SINGLE_RECEIPT_LENGTH + "}", groups = {IBaseValidGroup.Add.class, IBaseValidGroup.Update.class})
    @Column(name = "task_cancel_single_receipt", length = 20, nullable = true)
    private String cancelSingleReceipt;

    /**
     * <pre>
     * DB remark: 取消任务,理由,t_setting.setting_key,关联
     * DB column: task_cancel_reason	VARCHAR(40)	<--->	cancelReason	java.lang.String
     * DB is  Nullable: true
     * DB defaultValue: null
     * </pre>
     */
    @Length(max = 40, message = "{" + TaskBeanI18nConstant.TASK_BEAN_CANCEL_REASON_LENGTH + "}", groups = {IBaseValidGroup.Add.class, IBaseValidGroup.Update.class})
    @Column(name = "task_cancel_reason", length = 40, nullable = true)
    private String cancelReason;

    /**
     * <pre>
     * DB remark: 取消任务,钱回退处
     * DB column: task_cancel_money_back_party	VARCHAR(20)	<--->	cancelMoneyBackParty	java.lang.String
     * DB is  Nullable: true
     * DB defaultValue: null
     * </pre>
     */
    @Length(max = 20, message = "{" + TaskBeanI18nConstant.TASK_BEAN_CANCEL_MONEY_BACK_PARTY_LENGTH + "}", groups = {IBaseValidGroup.Add.class, IBaseValidGroup.Update.class})
    @Column(name = "task_cancel_money_back_party", length = 20, nullable = true)
    private String cancelMoneyBackParty;

    /**
     * <pre>
     * DB remark: 取消任务,备注
     * DB column: task_cancel_comment	VARCHAR(100)	<--->	cancelComment	java.lang.String
     * DB is  Nullable: true
     * DB defaultValue: null
     * </pre>
     */
    @Length(max = 100, message = "{" + TaskBeanI18nConstant.TASK_BEAN_CANCEL_COMMENT_LENGTH + "}", groups = {IBaseValidGroup.Add.class, IBaseValidGroup.Update.class})
    @Column(name = "task_cancel_comment", length = 100, nullable = true)
    private String cancelComment;

    /**
     * <pre>
     * DB remark: 发件人客户ID,与t_client.client_id 字段关联【{"max":13}】
     * DB column: task_sender_client_id	BIGINT(20)	<--->	senderClientId	java.lang.Long
     * DB is  Nullable: true
     * DB defaultValue: null
     * </pre>
     */
    @ValidLength(max = 13, message = "{" + TaskBeanI18nConstant.TASK_BEAN_SENDER_CLIENT_ID_LENGTH + "}", groups = {IBaseValidGroup.Add.class, IBaseValidGroup.Update.class})
    @Column(name = "task_sender_client_id", length = 20, nullable = true)
    private Long senderClientId;

    /**
     * <pre>
     * DB remark: 发件人客户内部ID,与t_client.client_internal_id 字段冗余
     * DB column: task_sender_client_internal_id	VARCHAR(15)	<--->	senderClientInternalId	java.lang.String
     * DB is  Nullable: true
     * DB defaultValue: null
     * </pre>
     */
    @Length(max = 15, message = "{" + TaskBeanI18nConstant.TASK_BEAN_SENDER_CLIENT_INTERNAL_ID_LENGTH + "}", groups = {IBaseValidGroup.Add.class, IBaseValidGroup.Update.class})
    @Column(name = "task_sender_client_internal_id", length = 15, nullable = true)
    private String senderClientInternalId;

    /**
     * <pre>
     * DB remark: 发件人名称,与t_task_contract.contract_sender_client_name,冗余
     * DB column: task_sender_client_name	VARCHAR(100)	<--->	senderClientName	java.lang.String
     * DB is  Nullable: true
     * DB defaultValue: null
     * </pre>
     */
    @Length(max = 100, message = "{" + TaskBeanI18nConstant.TASK_BEAN_SENDER_CLIENT_NAME_LENGTH + "}", groups = {IBaseValidGroup.Add.class, IBaseValidGroup.Update.class})
    @Column(name = "task_sender_client_name", length = 100, nullable = true)
    private String senderClientName;

    /**
     * <pre>
     * DB remark: 发件人网点id,与t_task_contract.contract_sender_branch_id,关联【{"max":13}】
     * DB column: task_sender_branch_id	BIGINT(20)	<--->	senderBranchId	java.lang.Long
     * DB is  Nullable: true
     * DB defaultValue: null
     * </pre>
     */
    @ValidLength(max = 13, message = "{" + TaskBeanI18nConstant.TASK_BEAN_SENDER_BRANCH_ID_LENGTH + "}", groups = {IBaseValidGroup.Add.class, IBaseValidGroup.Update.class})
    @Column(name = "task_sender_branch_id", length = 20, nullable = true)
    private Long senderBranchId;

    /**
     * <pre>
     * DB remark: 发件人网点内部ID,与t_client_branch.branch_internal_id 字段冗余
     * DB column: task_sender_branch_internal_id	VARCHAR(15)	<--->	senderBranchInternalId	java.lang.String
     * DB is  Nullable: true
     * DB defaultValue: null
     * </pre>
     */
    @Length(max = 15, message = "{" + TaskBeanI18nConstant.TASK_BEAN_SENDER_BRANCH_INTERNAL_ID_LENGTH + "}", groups = {IBaseValidGroup.Add.class, IBaseValidGroup.Update.class})
    @Column(name = "task_sender_branch_internal_id", length = 15, nullable = true)
    private String senderBranchInternalId;

    /**
     * <pre>
     * DB remark: 发件人网点名称,与t_client_branch.branch_name 字段冗余
     * DB column: task_sender_branch_name	VARCHAR(100)	<--->	senderBranchName	java.lang.String
     * DB is  Nullable: false
     * DB defaultValue: null
     * </pre>
     */
    @NotBlank(message = "{" + TaskBeanI18nConstant.TASK_BEAN_SENDER_BRANCH_NAME_NOT_BLANK + "}", groups = {IBaseValidGroup.Add.class, IBaseValidGroup.Update.class})
    @Length(max = 100, message = "{" + TaskBeanI18nConstant.TASK_BEAN_SENDER_BRANCH_NAME_LENGTH + "}", groups = {IBaseValidGroup.Add.class, IBaseValidGroup.Update.class})
    @Column(name = "task_sender_branch_name", length = 100, nullable = false)
    private String senderBranchName;

    /**
     * <pre>
     * DB remark: 发件人网点服务时间窗口开始时间,时间格式 hh:mm:ss,与t_task_contract.contract_sender_time_window_start,冗余
     * DB column: task_sender_time_window_start	CHAR(8)	<--->	senderTimeWindowStart	java.lang.String
     * DB is  Nullable: false
     * DB defaultValue: null
     * </pre>
     */
    @NotBlank(message = "{" + TaskBeanI18nConstant.TASK_BEAN_SENDER_TIME_WINDOW_START_NOT_BLANK + "}", groups = {IBaseValidGroup.Add.class, IBaseValidGroup.Update.class})
    @Length(max = 8, message = "{" + TaskBeanI18nConstant.TASK_BEAN_SENDER_TIME_WINDOW_START_LENGTH + "}", groups = {IBaseValidGroup.Add.class, IBaseValidGroup.Update.class})
    @Column(name = "task_sender_time_window_start", length = 8, nullable = false)
    private String senderTimeWindowStart;

    /**
     * <pre>
     * DB remark: 发件人网点服务时间窗口结束时间,时间格式 hh:mm:ss,与t_task_contract.contract_sender_time_window_end,冗余
     * DB column: task_sender_time_window_end	CHAR(8)	<--->	senderTimeWindowEnd	java.lang.String
     * DB is  Nullable: false
     * DB defaultValue: null
     * </pre>
     */
    @NotBlank(message = "{" + TaskBeanI18nConstant.TASK_BEAN_SENDER_TIME_WINDOW_END_NOT_BLANK + "}", groups = {IBaseValidGroup.Add.class, IBaseValidGroup.Update.class})
    @Length(max = 8, message = "{" + TaskBeanI18nConstant.TASK_BEAN_SENDER_TIME_WINDOW_END_LENGTH + "}", groups = {IBaseValidGroup.Add.class, IBaseValidGroup.Update.class})
    @Column(name = "task_sender_time_window_end", length = 8, nullable = false)
    private String senderTimeWindowEnd;

    /**
     * <pre>
     * DB remark: 发件人网点执行服务时长,单位分钟,与t_task_contract.contract_sender_time_window_duration,冗余
     * DB column: task_sender_time_window_duration	INTEGER(10)	<--->	senderTimeWindowDuration	java.lang.Integer
     * DB is  Nullable: true
     * DB defaultValue: null
     * </pre>
     */
    @ValidLength(max = 10, message = "{" + TaskBeanI18nConstant.TASK_BEAN_SENDER_TIME_WINDOW_DURATION_LENGTH + "}", groups = {IBaseValidGroup.Add.class, IBaseValidGroup.Update.class})
    @Column(name = "task_sender_time_window_duration", length = 10, nullable = true)
    private Integer senderTimeWindowDuration;

    /**
     * <pre>
     * DB remark: 发件人网点联系电话,与t_client_branch.branch_phone,关联
     * DB column: task_sender_branch_phone	VARCHAR(15)	<--->	senderBranchPhone	java.lang.String
     * DB is  Nullable: true
     * DB defaultValue: null
     * </pre>
     */
    @Length(max = 15, message = "{" + TaskBeanI18nConstant.TASK_BEAN_SENDER_BRANCH_PHONE_LENGTH + "}", groups = {IBaseValidGroup.Add.class, IBaseValidGroup.Update.class})
    @Column(name = "task_sender_branch_phone", length = 15, nullable = true)
    private String senderBranchPhone;

    /**
     * <pre>
     * DB remark: 发件人网点地址,与t_client_branch.branch_address,关联
     * DB column: task_sender_branch_address	VARCHAR(150)	<--->	senderBranchAddress	java.lang.String
     * DB is  Nullable: true
     * DB defaultValue: null
     * </pre>
     */
    @Length(max = 150, message = "{" + TaskBeanI18nConstant.TASK_BEAN_SENDER_BRANCH_ADDRESS_LENGTH + "}", groups = {IBaseValidGroup.Add.class, IBaseValidGroup.Update.class})
    @Column(name = "task_sender_branch_address", length = 150, nullable = true)
    private String senderBranchAddress;

    /**
     * <pre>
     * DB remark: 发件人网点地址坐标纬度,浮点型,与t_client_branch.branch_latitude,关联
     * DB column: task_sender_branch_latitude	VARCHAR(15)	<--->	senderBranchLatitude	java.lang.String
     * DB is  Nullable: true
     * DB defaultValue: null
     * </pre>
     */
    @Length(max = 15, message = "{" + TaskBeanI18nConstant.TASK_BEAN_SENDER_BRANCH_LATITUDE_LENGTH + "}", groups = {IBaseValidGroup.Add.class, IBaseValidGroup.Update.class})
    @Column(name = "task_sender_branch_latitude", length = 15, nullable = true)
    private String senderBranchLatitude;

    /**
     * <pre>
     * DB remark: 发件人网点地址坐标经度,浮点型,与t_client_branch.branch_longitude,关联
     * DB column: task_sender_branch_longitude	VARCHAR(15)	<--->	senderBranchLongitude	java.lang.String
     * DB is  Nullable: true
     * DB defaultValue: null
     * </pre>
     */
    @Length(max = 15, message = "{" + TaskBeanI18nConstant.TASK_BEAN_SENDER_BRANCH_LONGITUDE_LENGTH + "}", groups = {IBaseValidGroup.Add.class, IBaseValidGroup.Update.class})
    @Column(name = "task_sender_branch_longitude", length = 15, nullable = true)
    private String senderBranchLongitude;

    /**
     * <pre>
     * DB remark: 收件人客户ID,与t_client.client_id 字段关联【{"max":13}】
     * DB column: task_receiver_client_id	BIGINT(20)	<--->	receiverClientId	java.lang.Long
     * DB is  Nullable: true
     * DB defaultValue: null
     * </pre>
     */
    @ValidLength(max = 13, message = "{" + TaskBeanI18nConstant.TASK_BEAN_RECEIVER_CLIENT_ID_LENGTH + "}", groups = {IBaseValidGroup.Add.class, IBaseValidGroup.Update.class})
    @Column(name = "task_receiver_client_id", length = 20, nullable = true)
    private Long receiverClientId;

    /**
     * <pre>
     * DB remark: 收件人内部ID,与t_client.client_internal_id关联
     * DB column: task_receiver_client_internal_id	VARCHAR(25)	<--->	receiverClientInternalId	java.lang.String
     * DB is  Nullable: true
     * DB defaultValue: null
     * </pre>
     */
    @Length(max = 25, message = "{" + TaskBeanI18nConstant.TASK_BEAN_RECEIVER_CLIENT_INTERNAL_ID_LENGTH + "}", groups = {IBaseValidGroup.Add.class, IBaseValidGroup.Update.class})
    @Column(name = "task_receiver_client_internal_id", length = 25, nullable = true)
    private String receiverClientInternalId;

    /**
     * <pre>
     * DB remark: 收件人名称,与t_task_contract.contract_receiver_client_name,冗余
     * DB column: task_receiver_client_name	VARCHAR(100)	<--->	receiverClientName	java.lang.String
     * DB is  Nullable: true
     * DB defaultValue: null
     * </pre>
     */
    @Length(max = 100, message = "{" + TaskBeanI18nConstant.TASK_BEAN_RECEIVER_CLIENT_NAME_LENGTH + "}", groups = {IBaseValidGroup.Add.class, IBaseValidGroup.Update.class})
    @Column(name = "task_receiver_client_name", length = 100, nullable = true)
    private String receiverClientName;

    /**
     * <pre>
     * DB remark: 收件人网点id,与t_task_contract.contract_receiver_branch_id,关联【{"max":13}】
     * DB column: task_receiver_branch_id	BIGINT(20)	<--->	receiverBranchId	java.lang.Long
     * DB is  Nullable: true
     * DB defaultValue: null
     * </pre>
     */
    @ValidLength(max = 13, message = "{" + TaskBeanI18nConstant.TASK_BEAN_RECEIVER_BRANCH_ID_LENGTH + "}", groups = {IBaseValidGroup.Add.class, IBaseValidGroup.Update.class})
    @Column(name = "task_receiver_branch_id", length = 20, nullable = true)
    private Long receiverBranchId;

    /**
     * <pre>
     * DB remark: 收件人网点内部ID,与t_client_branch.branch_internal_id 字段冗余
     * DB column: task_receiver_branch_internal_id	VARCHAR(25)	<--->	receiverBranchInternalId	java.lang.String
     * DB is  Nullable: true
     * DB defaultValue: null
     * </pre>
     */
    @Length(max = 25, message = "{" + TaskBeanI18nConstant.TASK_BEAN_RECEIVER_BRANCH_INTERNAL_ID_LENGTH + "}", groups = {IBaseValidGroup.Add.class, IBaseValidGroup.Update.class})
    @Column(name = "task_receiver_branch_internal_id", length = 25, nullable = true)
    private String receiverBranchInternalId;

    /**
     * <pre>
     * DB remark: 收件人网点名称,与t_client_branch.branch_name 字段冗余
     * DB column: task_receiver_branch_name	VARCHAR(100)	<--->	receiverBranchName	java.lang.String
     * DB is  Nullable: false
     * DB defaultValue: null
     * </pre>
     */
    @NotBlank(message = "{" + TaskBeanI18nConstant.TASK_BEAN_RECEIVER_BRANCH_NAME_NOT_BLANK + "}", groups = {IBaseValidGroup.Add.class, IBaseValidGroup.Update.class})
    @Length(max = 100, message = "{" + TaskBeanI18nConstant.TASK_BEAN_RECEIVER_BRANCH_NAME_LENGTH + "}", groups = {IBaseValidGroup.Add.class, IBaseValidGroup.Update.class})
    @Column(name = "task_receiver_branch_name", length = 100, nullable = false)
    private String receiverBranchName;

    /**
     * <pre>
     * DB remark: 收件人网点服务时间窗口开始时间,时间格式 hh:mm:ss,与t_task_contract.contract_receiver_time_window_start,冗余
     * DB column: task_receiver_time_window_start	CHAR(8)	<--->	receiverTimeWindowStart	java.lang.String
     * DB is  Nullable: false
     * DB defaultValue: null
     * </pre>
     */
    @NotBlank(message = "{" + TaskBeanI18nConstant.TASK_BEAN_RECEIVER_TIME_WINDOW_START_NOT_BLANK + "}", groups = {IBaseValidGroup.Add.class, IBaseValidGroup.Update.class})
    @Length(max = 8, message = "{" + TaskBeanI18nConstant.TASK_BEAN_RECEIVER_TIME_WINDOW_START_LENGTH + "}", groups = {IBaseValidGroup.Add.class, IBaseValidGroup.Update.class})
    @Column(name = "task_receiver_time_window_start", length = 8, nullable = false)
    private String receiverTimeWindowStart;

    /**
     * <pre>
     * DB remark: 收件人网点服务时间窗口结束时间,时间格式 hh:mm:ss,与t_task_contract.contract_receiver_time_window_end,冗余
     * DB column: task_receiver_time_window_end	CHAR(8)	<--->	receiverTimeWindowEnd	java.lang.String
     * DB is  Nullable: false
     * DB defaultValue: null
     * </pre>
     */
    @NotBlank(message = "{" + TaskBeanI18nConstant.TASK_BEAN_RECEIVER_TIME_WINDOW_END_NOT_BLANK + "}", groups = {IBaseValidGroup.Add.class, IBaseValidGroup.Update.class})
    @Length(max = 8, message = "{" + TaskBeanI18nConstant.TASK_BEAN_RECEIVER_TIME_WINDOW_END_LENGTH + "}", groups = {IBaseValidGroup.Add.class, IBaseValidGroup.Update.class})
    @Column(name = "task_receiver_time_window_end", length = 8, nullable = false)
    private String receiverTimeWindowEnd;

    /**
     * <pre>
     * DB remark: 收件人网点执行服务时长,单位分钟,与t_task_contract.contract_receiver_time_window_duration,冗余
     * DB column: task_receiver_time_window_duration	INTEGER(10)	<--->	receiverTimeWindowDuration	java.lang.Integer
     * DB is  Nullable: true
     * DB defaultValue: null
     * </pre>
     */
    @ValidLength(max = 10, message = "{" + TaskBeanI18nConstant.TASK_BEAN_RECEIVER_TIME_WINDOW_DURATION_LENGTH + "}", groups = {IBaseValidGroup.Add.class, IBaseValidGroup.Update.class})
    @Column(name = "task_receiver_time_window_duration", length = 10, nullable = true)
    private Integer receiverTimeWindowDuration;

    /**
     * <pre>
     * DB remark: 收件人网点联系电话,与t_client_branch.branch_phone,关联
     * DB column: task_receiver_branch_phone	VARCHAR(15)	<--->	receiverBranchPhone	java.lang.String
     * DB is  Nullable: true
     * DB defaultValue: null
     * </pre>
     */
    @Length(max = 15, message = "{" + TaskBeanI18nConstant.TASK_BEAN_RECEIVER_BRANCH_PHONE_LENGTH + "}", groups = {IBaseValidGroup.Add.class, IBaseValidGroup.Update.class})
    @Column(name = "task_receiver_branch_phone", length = 15, nullable = true)
    private String receiverBranchPhone;

    /**
     * <pre>
     * DB remark: 收件人网点地址,与t_client_branch.branch_address,关联
     * DB column: task_receiver_branch_address	VARCHAR(150)	<--->	receiverBranchAddress	java.lang.String
     * DB is  Nullable: true
     * DB defaultValue: null
     * </pre>
     */
    @Length(max = 150, message = "{" + TaskBeanI18nConstant.TASK_BEAN_RECEIVER_BRANCH_ADDRESS_LENGTH + "}", groups = {IBaseValidGroup.Add.class, IBaseValidGroup.Update.class})
    @Column(name = "task_receiver_branch_address", length = 150, nullable = true)
    private String receiverBranchAddress;

    /**
     * <pre>
     * DB remark: 收件人网点地址坐标纬度,浮点型,与t_client_branch.branch_latitude,关联
     * DB column: task_receiver_branch_latitude	VARCHAR(15)	<--->	receiverBranchLatitude	java.lang.String
     * DB is  Nullable: true
     * DB defaultValue: null
     * </pre>
     */
    @Length(max = 15, message = "{" + TaskBeanI18nConstant.TASK_BEAN_RECEIVER_BRANCH_LATITUDE_LENGTH + "}", groups = {IBaseValidGroup.Add.class, IBaseValidGroup.Update.class})
    @Column(name = "task_receiver_branch_latitude", length = 15, nullable = true)
    private String receiverBranchLatitude;

    /**
     * <pre>
     * DB remark: 收件人网点地址坐标经度,浮点型,与t_client_branch.branch_longitude,关联
     * DB column: task_receiver_branch_longitude	VARCHAR(15)	<--->	receiverBranchLongitude	java.lang.String
     * DB is  Nullable: true
     * DB defaultValue: null
     * </pre>
     */
    @Length(max = 15, message = "{" + TaskBeanI18nConstant.TASK_BEAN_RECEIVER_BRANCH_LONGITUDE_LENGTH + "}", groups = {IBaseValidGroup.Add.class, IBaseValidGroup.Update.class})
    @Column(name = "task_receiver_branch_longitude", length = 15, nullable = true)
    private String receiverBranchLongitude;

    /**
     * <pre>
     * DB remark: 车辆id,与t_vehicle关联【{"max":13}】
     * DB column: task_vehicle_id	BIGINT(20)	<--->	vehicleId	java.lang.Long
     * DB is  Nullable: true
     * DB defaultValue: null
     * </pre>
     */
    @ValidLength(max = 13, message = "{" + TaskBeanI18nConstant.TASK_BEAN_VEHICLE_ID_LENGTH + "}", groups = {IBaseValidGroup.Add.class, IBaseValidGroup.Update.class})
    @Column(name = "task_vehicle_id", length = 20, nullable = true)
    private Long vehicleId;

    /**
     * <pre>
     * DB remark: 与t_vehicle.vehicle_internal_id冗余4位数字的内部编号
     * DB column: task_vehicle_internal_id	VARCHAR(15)	<--->	vehicleInternalId	java.lang.String
     * DB is  Nullable: true
     * DB defaultValue: null
     * </pre>
     */
    @Length(max = 15, message = "{" + TaskBeanI18nConstant.TASK_BEAN_VEHICLE_INTERNAL_ID_LENGTH + "}", groups = {IBaseValidGroup.Add.class, IBaseValidGroup.Update.class})
    @Column(name = "task_vehicle_internal_id", length = 15, nullable = true)
    private String vehicleInternalId;

    /**
     * <pre>
     * DB remark: 与t_vehicle.vehicle_tomtom_id 冗余,车辆实时数据外部标识
     * DB column: task_vehicle_tomtom_id	VARCHAR(15)	<--->	vehicleTomtomId	java.lang.String
     * DB is  Nullable: true
     * DB defaultValue: null
     * </pre>
     */
    @Length(max = 15, message = "{" + TaskBeanI18nConstant.TASK_BEAN_VEHICLE_TOMTOM_ID_LENGTH + "}", groups = {IBaseValidGroup.Add.class, IBaseValidGroup.Update.class})
    @Column(name = "task_vehicle_tomtom_id", length = 15, nullable = true)
    private String vehicleTomtomId;

    /**
     * <pre>
     * DB remark: 与t_vehicle.vehicle_license冗余车牌号码
     * DB column: task_vehicle_license	VARCHAR(20)	<--->	vehicleLicense	java.lang.String
     * DB is  Nullable: true
     * DB defaultValue: null
     * </pre>
     */
    @Length(max = 20, message = "{" + TaskBeanI18nConstant.TASK_BEAN_VEHICLE_LICENSE_LENGTH + "}", groups = {IBaseValidGroup.Add.class, IBaseValidGroup.Update.class})
    @Column(name = "task_vehicle_license", length = 20, nullable = true)
    private String vehicleLicense;

    /**
     * <pre>
     * DB remark: 与t_vehicle.vehicle_armored_level冗余武装等级:none,light,medium,heavy
     * DB column: task_vehicle_armored_level	VARCHAR(20)	<--->	vehicleArmoredLevel	java.lang.String
     * DB is  Nullable: true
     * DB defaultValue: null
     * </pre>
     */
    @Length(max = 20, message = "{" + TaskBeanI18nConstant.TASK_BEAN_VEHICLE_ARMORED_LEVEL_LENGTH + "}", groups = {IBaseValidGroup.Add.class, IBaseValidGroup.Update.class})
    @Column(name = "task_vehicle_armored_level", length = 20, nullable = true)
    private String vehicleArmoredLevel;

    /**
     * <pre>
     * DB remark: 与t_vehicle.vehicle_service_type冗余
     * DB column: task_vehicle_service_type	VARCHAR(30)	<--->	vehicleServiceType	java.lang.String
     * DB is  Nullable: true
     * DB defaultValue: null
     * </pre>
     */
    @Length(max = 30, message = "{" + TaskBeanI18nConstant.TASK_BEAN_VEHICLE_SERVICE_TYPE_LENGTH + "}", groups = {IBaseValidGroup.Add.class, IBaseValidGroup.Update.class})
    @Column(name = "task_vehicle_service_type", length = 30, nullable = true)
    private String vehicleServiceType;

    /**
     * <pre>
     * DB remark: 与t_vehicle.vehicle_model冗余汽车型号
     * DB column: task_vehicle_model	VARCHAR(30)	<--->	vehicleModel	java.lang.String
     * DB is  Nullable: true
     * DB defaultValue: null
     * </pre>
     */
    @Length(max = 30, message = "{" + TaskBeanI18nConstant.TASK_BEAN_VEHICLE_MODEL_LENGTH + "}", groups = {IBaseValidGroup.Add.class, IBaseValidGroup.Update.class})
    @Column(name = "task_vehicle_model", length = 30, nullable = true)
    private String vehicleModel;

    /**
     * <pre>
     * DB remark: 与t_vehicle.vehicle_vin冗余车辆识别代号,全宇宙唯一代号
     * DB column: task_vehicle_vin	VARCHAR(30)	<--->	vehicleVin	java.lang.String
     * DB is  Nullable: true
     * DB defaultValue: null
     * </pre>
     */
    @Length(max = 30, message = "{" + TaskBeanI18nConstant.TASK_BEAN_VEHICLE_VIN_LENGTH + "}", groups = {IBaseValidGroup.Add.class, IBaseValidGroup.Update.class})
    @Column(name = "task_vehicle_vin", length = 30, nullable = true)
    private String vehicleVin;

    /**
     * <pre>
     * DB remark: 与t_vehicle.vehicle_currency_capacity冗余,货币限定容量
     * DB column: task_vehicle_currency_capacity	VARCHAR(15)	<--->	vehicleCurrencyCapacity	java.lang.String
     * DB is  Nullable: true
     * DB defaultValue: null
     * </pre>
     */
    @Length(max = 15, message = "{" + TaskBeanI18nConstant.TASK_BEAN_VEHICLE_CURRENCY_CAPACITY_LENGTH + "}", groups = {IBaseValidGroup.Add.class, IBaseValidGroup.Update.class})
    @Column(name = "task_vehicle_currency_capacity", length = 15, nullable = true)
    private String vehicleCurrencyCapacity;

    /**
     * <pre>
     * DB remark: 任务所需要的人数
     * DB column: task_service_person_number	INTEGER(10)	<--->	servicePersonNumber	java.lang.Integer
     * DB is  Nullable: true
     * DB defaultValue: null
     * </pre>
     */
    @ValidLength(max = 10, message = "{" + TaskBeanI18nConstant.TASK_BEAN_SERVICE_PERSON_NUMBER_LENGTH + "}", groups = {IBaseValidGroup.Add.class, IBaseValidGroup.Update.class})
    @Column(name = "task_service_person_number", length = 10, nullable = true)
    private Integer servicePersonNumber;

    /**
     * <pre>
     * DB remark: 司机ID,与t_crew.crew_id冗余【{"max":13}】
     * DB column: task_driver_id	BIGINT(20)	<--->	driverId	java.lang.Long
     * DB is  Nullable: true
     * DB defaultValue: null
     * </pre>
     */
    @ValidLength(max = 13, message = "{" + TaskBeanI18nConstant.TASK_BEAN_DRIVER_ID_LENGTH + "}", groups = {IBaseValidGroup.Add.class, IBaseValidGroup.Update.class})
    @Column(name = "task_driver_id", length = 20, nullable = true)
    private Long driverId;

    /**
     * <pre>
     * DB remark: 司机username,与t_crew.crew_username冗余
     * DB column: task_driver_username	VARCHAR(20)	<--->	driverUsername	java.lang.String
     * DB is  Nullable: true
     * DB defaultValue: null
     * </pre>
     */
    @Length(max = 20, message = "{" + TaskBeanI18nConstant.TASK_BEAN_DRIVER_USERNAME_LENGTH + "}", groups = {IBaseValidGroup.Add.class, IBaseValidGroup.Update.class})
    @Column(name = "task_driver_username", length = 20, nullable = true)
    private String driverUsername;

    /**
     * <pre>
     * DB remark: 司机内部编号,与t_crew.crew_internal_id冗余
     * DB column: task_driver_internal_id	VARCHAR(15)	<--->	driverInternalId	java.lang.String
     * DB is  Nullable: true
     * DB defaultValue: null
     * </pre>
     */
    @Length(max = 15, message = "{" + TaskBeanI18nConstant.TASK_BEAN_DRIVER_INTERNAL_ID_LENGTH + "}", groups = {IBaseValidGroup.Add.class, IBaseValidGroup.Update.class})
    @Column(name = "task_driver_internal_id", length = 15, nullable = true)
    private String driverInternalId;

    /**
     * <pre>
     * DB remark: 司机名字,与t_crew.crew_first_name字段关联
     * DB column: task_driver_first_name	VARCHAR(50)	<--->	driverFirstName	java.lang.String
     * DB is  Nullable: true
     * DB defaultValue: null
     * </pre>
     */
    @Length(max = 50, message = "{" + TaskBeanI18nConstant.TASK_BEAN_DRIVER_FIRST_NAME_LENGTH + "}", groups = {IBaseValidGroup.Add.class, IBaseValidGroup.Update.class})
    @Column(name = "task_driver_first_name", length = 50, nullable = true)
    private String driverFirstName;

    /**
     * <pre>
     * DB remark: 司机姓氏,与t_crew.crew_last_name字段关联
     * DB column: task_driver_last_name	VARCHAR(50)	<--->	driverLastName	java.lang.String
     * DB is  Nullable: true
     * DB defaultValue: null
     * </pre>
     */
    @Length(max = 50, message = "{" + TaskBeanI18nConstant.TASK_BEAN_DRIVER_LAST_NAME_LENGTH + "}", groups = {IBaseValidGroup.Add.class, IBaseValidGroup.Update.class})
    @Column(name = "task_driver_last_name", length = 50, nullable = true)
    private String driverLastName;

    /**
     * <pre>
     * DB remark: 司机电话,与t_crew.crew_phone字段关联
     * DB column: task_driver_phone	VARCHAR(15)	<--->	driverPhone	java.lang.String
     * DB is  Nullable: true
     * DB defaultValue: null
     * </pre>
     */
    @Length(max = 15, message = "{" + TaskBeanI18nConstant.TASK_BEAN_DRIVER_PHONE_LENGTH + "}", groups = {IBaseValidGroup.Add.class, IBaseValidGroup.Update.class})
    @Column(name = "task_driver_phone", length = 15, nullable = true)
    private String driverPhone;

    /**
     * <pre>
     * DB remark: 司机shift,与shift_week_start_date,对应【应在生成计划任务,根据人员安排时,设置值也要注意在变更路线时,设置值】
     * DB column: task_driver_shift	CHAR(1)	<--->	driverShift	java.lang.String
     * DB is  Nullable: true
     * DB defaultValue: null
     * </pre>
     */
    @Length(max = 1, message = "{" + TaskBeanI18nConstant.TASK_BEAN_DRIVER_SHIFT_LENGTH + "}", groups = {IBaseValidGroup.Add.class, IBaseValidGroup.Update.class})
    @Column(name = "task_driver_shift", length = 1, nullable = true)
    private String driverShift;

    /**
     * <pre>
     * DB remark: 出纳员ID,与t_crew.crew_id冗余【{"max":13}】
     * DB column: task_cashier_id	BIGINT(20)	<--->	cashierId	java.lang.Long
     * DB is  Nullable: true
     * DB defaultValue: null
     * </pre>
     */
    @ValidLength(max = 13, message = "{" + TaskBeanI18nConstant.TASK_BEAN_CASHIER_ID_LENGTH + "}", groups = {IBaseValidGroup.Add.class, IBaseValidGroup.Update.class})
    @Column(name = "task_cashier_id", length = 20, nullable = true)
    private Long cashierId;

    /**
     * <pre>
     * DB remark: 收银员username,与t_crew.crew_username冗余
     * DB column: task_cashier_username	VARCHAR(20)	<--->	cashierUsername	java.lang.String
     * DB is  Nullable: true
     * DB defaultValue: null
     * </pre>
     */
    @Length(max = 20, message = "{" + TaskBeanI18nConstant.TASK_BEAN_CASHIER_USERNAME_LENGTH + "}", groups = {IBaseValidGroup.Add.class, IBaseValidGroup.Update.class})
    @Column(name = "task_cashier_username", length = 20, nullable = true)
    private String cashierUsername;

    /**
     * <pre>
     * DB remark: 收银员内部编号,与t_crew.crew_internal_id冗余
     * DB column: task_cashier_internal_id	VARCHAR(15)	<--->	cashierInternalId	java.lang.String
     * DB is  Nullable: true
     * DB defaultValue: null
     * </pre>
     */
    @Length(max = 15, message = "{" + TaskBeanI18nConstant.TASK_BEAN_CASHIER_INTERNAL_ID_LENGTH + "}", groups = {IBaseValidGroup.Add.class, IBaseValidGroup.Update.class})
    @Column(name = "task_cashier_internal_id", length = 15, nullable = true)
    private String cashierInternalId;

    /**
     * <pre>
     * DB remark: 收银员名字,与t_crew.crew_first_name字段关联
     * DB column: task_cashier_first_name	VARCHAR(50)	<--->	cashierFirstName	java.lang.String
     * DB is  Nullable: true
     * DB defaultValue: null
     * </pre>
     */
    @Length(max = 50, message = "{" + TaskBeanI18nConstant.TASK_BEAN_CASHIER_FIRST_NAME_LENGTH + "}", groups = {IBaseValidGroup.Add.class, IBaseValidGroup.Update.class})
    @Column(name = "task_cashier_first_name", length = 50, nullable = true)
    private String cashierFirstName;

    /**
     * <pre>
     * DB remark: 收银员姓氏,与t_crew.crew_last_name字段关联
     * DB column: task_cashier_last_name	VARCHAR(50)	<--->	cashierLastName	java.lang.String
     * DB is  Nullable: true
     * DB defaultValue: null
     * </pre>
     */
    @Length(max = 50, message = "{" + TaskBeanI18nConstant.TASK_BEAN_CASHIER_LAST_NAME_LENGTH + "}", groups = {IBaseValidGroup.Add.class, IBaseValidGroup.Update.class})
    @Column(name = "task_cashier_last_name", length = 50, nullable = true)
    private String cashierLastName;

    /**
     * <pre>
     * DB remark: 收银员电话,与t_crew.crew_phone字段关联
     * DB column: task_cashier_phone	VARCHAR(15)	<--->	cashierPhone	java.lang.String
     * DB is  Nullable: true
     * DB defaultValue: null
     * </pre>
     */
    @Length(max = 15, message = "{" + TaskBeanI18nConstant.TASK_BEAN_CASHIER_PHONE_LENGTH + "}", groups = {IBaseValidGroup.Add.class, IBaseValidGroup.Update.class})
    @Column(name = "task_cashier_phone", length = 15, nullable = true)
    private String cashierPhone;

    /**
     * <pre>
     * DB remark: 收银员班次,与shift_week_start_date,对应;【应在生成计划任务,根据人员安排时,设置值也要注意在变更路线时,设置值】
     * DB column: task_cashier_shift	CHAR(1)	<--->	cashierShift	java.lang.String
     * DB is  Nullable: true
     * DB defaultValue: null
     * </pre>
     */
    @Length(max = 1, message = "{" + TaskBeanI18nConstant.TASK_BEAN_CASHIER_SHIFT_LENGTH + "}", groups = {IBaseValidGroup.Add.class, IBaseValidGroup.Update.class})
    @Column(name = "task_cashier_shift", length = 1, nullable = true)
    private String cashierShift;

    /**
     * <pre>
     * DB remark: 收银员passCode密码(员工登陆密码),MD5加密之后取前8位+登陆密码加盐,与t_user.user_pass_code【该分支机构下,所有拥有nip密码的,JSON对象 {"passCode":"4c2bf06d","passSalt":"_random_"}】
     * DB column: task_cashier_pass_code	VARCHAR(45)	<--->	cashierPassCode	java.lang.String
     * DB is  Nullable: true
     * DB defaultValue: null
     * </pre>
     */
    @Length(max = 45, message = "{" + TaskBeanI18nConstant.TASK_BEAN_CASHIER_PASS_CODE_LENGTH + "}", groups = {IBaseValidGroup.Add.class, IBaseValidGroup.Update.class})
    @Column(name = "task_cashier_pass_code", length = 45, nullable = true)
    private String cashierPassCode;

    /**
     * <pre>
     * DB remark: 保镖1ID,与t_crew.crew_id冗余【{"max":13}】
     * DB column: task_security1_id	BIGINT(20)	<--->	security1Id	java.lang.Long
     * DB is  Nullable: true
     * DB defaultValue: null
     * </pre>
     */
    @ValidLength(max = 13, message = "{" + TaskBeanI18nConstant.TASK_BEAN_SECURITY1_ID_LENGTH + "}", groups = {IBaseValidGroup.Add.class, IBaseValidGroup.Update.class})
    @Column(name = "task_security1_id", length = 20, nullable = true)
    private Long security1Id;

    /**
     * <pre>
     * DB remark: 保镖1username,与t_crew.crew_username冗余
     * DB column: task_security1_username	VARCHAR(20)	<--->	security1Username	java.lang.String
     * DB is  Nullable: true
     * DB defaultValue: null
     * </pre>
     */
    @Length(max = 20, message = "{" + TaskBeanI18nConstant.TASK_BEAN_SECURITY1_USERNAME_LENGTH + "}", groups = {IBaseValidGroup.Add.class, IBaseValidGroup.Update.class})
    @Column(name = "task_security1_username", length = 20, nullable = true)
    private String security1Username;

    /**
     * <pre>
     * DB remark: 保镖1内部编号,与t_crew.crew_internal_id冗余
     * DB column: task_security1_internal_id	VARCHAR(15)	<--->	security1InternalId	java.lang.String
     * DB is  Nullable: true
     * DB defaultValue: null
     * </pre>
     */
    @Length(max = 15, message = "{" + TaskBeanI18nConstant.TASK_BEAN_SECURITY1_INTERNAL_ID_LENGTH + "}", groups = {IBaseValidGroup.Add.class, IBaseValidGroup.Update.class})
    @Column(name = "task_security1_internal_id", length = 15, nullable = true)
    private String security1InternalId;

    /**
     * <pre>
     * DB remark: 保镖1名字,与t_crew.crew_first_name字段关联
     * DB column: task_security1_first_name	VARCHAR(50)	<--->	security1FirstName	java.lang.String
     * DB is  Nullable: true
     * DB defaultValue: null
     * </pre>
     */
    @Length(max = 50, message = "{" + TaskBeanI18nConstant.TASK_BEAN_SECURITY1_FIRST_NAME_LENGTH + "}", groups = {IBaseValidGroup.Add.class, IBaseValidGroup.Update.class})
    @Column(name = "task_security1_first_name", length = 50, nullable = true)
    private String security1FirstName;

    /**
     * <pre>
     * DB remark: 保镖1姓氏,与t_crew.crew_last_name字段关联
     * DB column: task_security1_last_name	VARCHAR(50)	<--->	security1LastName	java.lang.String
     * DB is  Nullable: true
     * DB defaultValue: null
     * </pre>
     */
    @Length(max = 50, message = "{" + TaskBeanI18nConstant.TASK_BEAN_SECURITY1_LAST_NAME_LENGTH + "}", groups = {IBaseValidGroup.Add.class, IBaseValidGroup.Update.class})
    @Column(name = "task_security1_last_name", length = 50, nullable = true)
    private String security1LastName;

    /**
     * <pre>
     * DB remark: 保镖1电话,与t_crew.crew_phone字段关联
     * DB column: task_security1_phone	VARCHAR(15)	<--->	security1Phone	java.lang.String
     * DB is  Nullable: true
     * DB defaultValue: null
     * </pre>
     */
    @Length(max = 15, message = "{" + TaskBeanI18nConstant.TASK_BEAN_SECURITY1_PHONE_LENGTH + "}", groups = {IBaseValidGroup.Add.class, IBaseValidGroup.Update.class})
    @Column(name = "task_security1_phone", length = 15, nullable = true)
    private String security1Phone;

    /**
     * <pre>
     * DB remark: 保镖1班次,与shift_week_start_date,对应;【应在生成计划任务,根据人员安排时,设置值也要注意在变更路线时,设置值】
     * DB column: task_security1_shift	CHAR(1)	<--->	security1Shift	java.lang.String
     * DB is  Nullable: true
     * DB defaultValue: null
     * </pre>
     */
    @Length(max = 1, message = "{" + TaskBeanI18nConstant.TASK_BEAN_SECURITY1_SHIFT_LENGTH + "}", groups = {IBaseValidGroup.Add.class, IBaseValidGroup.Update.class})
    @Column(name = "task_security1_shift", length = 1, nullable = true)
    private String security1Shift;

    /**
     * <pre>
     * DB remark: 保镖2ID,与t_crew.crew_id冗余【{"max":13}】
     * DB column: task_security2_id	BIGINT(20)	<--->	security2Id	java.lang.Long
     * DB is  Nullable: true
     * DB defaultValue: null
     * </pre>
     */
    @ValidLength(max = 13, message = "{" + TaskBeanI18nConstant.TASK_BEAN_SECURITY2_ID_LENGTH + "}", groups = {IBaseValidGroup.Add.class, IBaseValidGroup.Update.class})
    @Column(name = "task_security2_id", length = 20, nullable = true)
    private Long security2Id;

    /**
     * <pre>
     * DB remark: 保镖2username,与t_crew.crew_username冗余
     * DB column: task_security2_username	VARCHAR(20)	<--->	security2Username	java.lang.String
     * DB is  Nullable: true
     * DB defaultValue: null
     * </pre>
     */
    @Length(max = 20, message = "{" + TaskBeanI18nConstant.TASK_BEAN_SECURITY2_USERNAME_LENGTH + "}", groups = {IBaseValidGroup.Add.class, IBaseValidGroup.Update.class})
    @Column(name = "task_security2_username", length = 20, nullable = true)
    private String security2Username;

    /**
     * <pre>
     * DB remark: 保镖2内部编号,与t_crew.crew_internal_id冗余
     * DB column: task_security2_internal_id	VARCHAR(15)	<--->	security2InternalId	java.lang.String
     * DB is  Nullable: true
     * DB defaultValue: null
     * </pre>
     */
    @Length(max = 15, message = "{" + TaskBeanI18nConstant.TASK_BEAN_SECURITY2_INTERNAL_ID_LENGTH + "}", groups = {IBaseValidGroup.Add.class, IBaseValidGroup.Update.class})
    @Column(name = "task_security2_internal_id", length = 15, nullable = true)
    private String security2InternalId;

    /**
     * <pre>
     * DB remark: 保镖2名字,与t_crew.crew_first_name字段关联
     * DB column: task_security2_first_name	VARCHAR(50)	<--->	security2FirstName	java.lang.String
     * DB is  Nullable: true
     * DB defaultValue: null
     * </pre>
     */
    @Length(max = 50, message = "{" + TaskBeanI18nConstant.TASK_BEAN_SECURITY2_FIRST_NAME_LENGTH + "}", groups = {IBaseValidGroup.Add.class, IBaseValidGroup.Update.class})
    @Column(name = "task_security2_first_name", length = 50, nullable = true)
    private String security2FirstName;

    /**
     * <pre>
     * DB remark: 保镖2姓氏,与t_crew.crew_last_name字段关联
     * DB column: task_security2_last_name	VARCHAR(50)	<--->	security2LastName	java.lang.String
     * DB is  Nullable: true
     * DB defaultValue: null
     * </pre>
     */
    @Length(max = 50, message = "{" + TaskBeanI18nConstant.TASK_BEAN_SECURITY2_LAST_NAME_LENGTH + "}", groups = {IBaseValidGroup.Add.class, IBaseValidGroup.Update.class})
    @Column(name = "task_security2_last_name", length = 50, nullable = true)
    private String security2LastName;

    /**
     * <pre>
     * DB remark: 保镖2电话,与t_crew.crew_phone字段关联
     * DB column: task_security2_phone	VARCHAR(15)	<--->	security2Phone	java.lang.String
     * DB is  Nullable: true
     * DB defaultValue: null
     * </pre>
     */
    @Length(max = 15, message = "{" + TaskBeanI18nConstant.TASK_BEAN_SECURITY2_PHONE_LENGTH + "}", groups = {IBaseValidGroup.Add.class, IBaseValidGroup.Update.class})
    @Column(name = "task_security2_phone", length = 15, nullable = true)
    private String security2Phone;

    /**
     * <pre>
     * DB remark: 保镖2班次,与shift_week_start_date,对应;【应在生成计划任务,根据人员安排时,设置值也要注意在变更路线时,设置值】
     * DB column: task_security2_shift	CHAR(1)	<--->	security2Shift	java.lang.String
     * DB is  Nullable: true
     * DB defaultValue: null
     * </pre>
     */
    @Length(max = 1, message = "{" + TaskBeanI18nConstant.TASK_BEAN_SECURITY2_SHIFT_LENGTH + "}", groups = {IBaseValidGroup.Add.class, IBaseValidGroup.Update.class})
    @Column(name = "task_security2_shift", length = 1, nullable = true)
    private String security2Shift;

    /**
     * <pre>
     * DB remark: 保镖3ID,与t_crew.crew_id冗余【{"max":13}】
     * DB column: task_security3_id	BIGINT(20)	<--->	security3Id	java.lang.Long
     * DB is  Nullable: true
     * DB defaultValue: null
     * </pre>
     */
    @ValidLength(max = 13, message = "{" + TaskBeanI18nConstant.TASK_BEAN_SECURITY3_ID_LENGTH + "}", groups = {IBaseValidGroup.Add.class, IBaseValidGroup.Update.class})
    @Column(name = "task_security3_id", length = 20, nullable = true)
    private Long security3Id;

    /**
     * <pre>
     * DB remark: 保镖3username,与t_crew.crew_username冗余
     * DB column: task_security3_username	VARCHAR(20)	<--->	security3Username	java.lang.String
     * DB is  Nullable: true
     * DB defaultValue: null
     * </pre>
     */
    @Length(max = 20, message = "{" + TaskBeanI18nConstant.TASK_BEAN_SECURITY3_USERNAME_LENGTH + "}", groups = {IBaseValidGroup.Add.class, IBaseValidGroup.Update.class})
    @Column(name = "task_security3_username", length = 20, nullable = true)
    private String security3Username;

    /**
     * <pre>
     * DB remark: 保镖3内部编号,与t_crew.crew_internal_id冗余
     * DB column: task_security3_internal_id	VARCHAR(15)	<--->	security3InternalId	java.lang.String
     * DB is  Nullable: true
     * DB defaultValue: null
     * </pre>
     */
    @Length(max = 15, message = "{" + TaskBeanI18nConstant.TASK_BEAN_SECURITY3_INTERNAL_ID_LENGTH + "}", groups = {IBaseValidGroup.Add.class, IBaseValidGroup.Update.class})
    @Column(name = "task_security3_internal_id", length = 15, nullable = true)
    private String security3InternalId;

    /**
     * <pre>
     * DB remark: 保镖3名字,与t_crew.crew_first_name字段关联
     * DB column: task_security3_first_name	VARCHAR(50)	<--->	security3FirstName	java.lang.String
     * DB is  Nullable: true
     * DB defaultValue: null
     * </pre>
     */
    @Length(max = 50, message = "{" + TaskBeanI18nConstant.TASK_BEAN_SECURITY3_FIRST_NAME_LENGTH + "}", groups = {IBaseValidGroup.Add.class, IBaseValidGroup.Update.class})
    @Column(name = "task_security3_first_name", length = 50, nullable = true)
    private String security3FirstName;

    /**
     * <pre>
     * DB remark: 保镖3姓氏,与t_crew.crew_last_name字段关联
     * DB column: task_security3_last_name	VARCHAR(50)	<--->	security3LastName	java.lang.String
     * DB is  Nullable: true
     * DB defaultValue: null
     * </pre>
     */
    @Length(max = 50, message = "{" + TaskBeanI18nConstant.TASK_BEAN_SECURITY3_LAST_NAME_LENGTH + "}", groups = {IBaseValidGroup.Add.class, IBaseValidGroup.Update.class})
    @Column(name = "task_security3_last_name", length = 50, nullable = true)
    private String security3LastName;

    /**
     * <pre>
     * DB remark: 保镖3电话,与t_crew.crew_phone字段关联
     * DB column: task_security3_phone	VARCHAR(15)	<--->	security3Phone	java.lang.String
     * DB is  Nullable: true
     * DB defaultValue: null
     * </pre>
     */
    @Length(max = 15, message = "{" + TaskBeanI18nConstant.TASK_BEAN_SECURITY3_PHONE_LENGTH + "}", groups = {IBaseValidGroup.Add.class, IBaseValidGroup.Update.class})
    @Column(name = "task_security3_phone", length = 15, nullable = true)
    private String security3Phone;

    /**
     * <pre>
     * DB remark: 保镖3班次,与shift_week_start_date,对应;【应在生成计划任务,根据人员安排时,设置值也要注意在变更路线时,设置值】
     * DB column: task_security3_shift	CHAR(1)	<--->	security3Shift	java.lang.String
     * DB is  Nullable: true
     * DB defaultValue: null
     * </pre>
     */
    @Length(max = 1, message = "{" + TaskBeanI18nConstant.TASK_BEAN_SECURITY3_SHIFT_LENGTH + "}", groups = {IBaseValidGroup.Add.class, IBaseValidGroup.Update.class})
    @Column(name = "task_security3_shift", length = 1, nullable = true)
    private String security3Shift;

    /**
     * <pre>
     * DB remark: 保镖4ID,与t_crew.crew_id冗余【{"max":13}】
     * DB column: task_security4_id	BIGINT(20)	<--->	security4Id	java.lang.Long
     * DB is  Nullable: true
     * DB defaultValue: null
     * </pre>
     */
    @ValidLength(max = 13, message = "{" + TaskBeanI18nConstant.TASK_BEAN_SECURITY4_ID_LENGTH + "}", groups = {IBaseValidGroup.Add.class, IBaseValidGroup.Update.class})
    @Column(name = "task_security4_id", length = 20, nullable = true)
    private Long security4Id;

    /**
     * <pre>
     * DB remark: 保镖4username,与t_crew.crew_username冗余
     * DB column: task_security4_username	VARCHAR(20)	<--->	security4Username	java.lang.String
     * DB is  Nullable: true
     * DB defaultValue: null
     * </pre>
     */
    @Length(max = 20, message = "{" + TaskBeanI18nConstant.TASK_BEAN_SECURITY4_USERNAME_LENGTH + "}", groups = {IBaseValidGroup.Add.class, IBaseValidGroup.Update.class})
    @Column(name = "task_security4_username", length = 20, nullable = true)
    private String security4Username;

    /**
     * <pre>
     * DB remark: 保镖4内部编号,与t_crew.crew_internal_id冗余
     * DB column: task_security4_internal_id	VARCHAR(15)	<--->	security4InternalId	java.lang.String
     * DB is  Nullable: true
     * DB defaultValue: null
     * </pre>
     */
    @Length(max = 15, message = "{" + TaskBeanI18nConstant.TASK_BEAN_SECURITY4_INTERNAL_ID_LENGTH + "}", groups = {IBaseValidGroup.Add.class, IBaseValidGroup.Update.class})
    @Column(name = "task_security4_internal_id", length = 15, nullable = true)
    private String security4InternalId;

    /**
     * <pre>
     * DB remark: 保镖4名字,与t_crew.crew_first_name字段关联
     * DB column: task_security4_first_name	VARCHAR(50)	<--->	security4FirstName	java.lang.String
     * DB is  Nullable: true
     * DB defaultValue: null
     * </pre>
     */
    @Length(max = 50, message = "{" + TaskBeanI18nConstant.TASK_BEAN_SECURITY4_FIRST_NAME_LENGTH + "}", groups = {IBaseValidGroup.Add.class, IBaseValidGroup.Update.class})
    @Column(name = "task_security4_first_name", length = 50, nullable = true)
    private String security4FirstName;

    /**
     * <pre>
     * DB remark: 保镖4姓氏,与t_crew.crew_last_name字段关联
     * DB column: task_security4_last_name	VARCHAR(50)	<--->	security4LastName	java.lang.String
     * DB is  Nullable: true
     * DB defaultValue: null
     * </pre>
     */
    @Length(max = 50, message = "{" + TaskBeanI18nConstant.TASK_BEAN_SECURITY4_LAST_NAME_LENGTH + "}", groups = {IBaseValidGroup.Add.class, IBaseValidGroup.Update.class})
    @Column(name = "task_security4_last_name", length = 50, nullable = true)
    private String security4LastName;

    /**
     * <pre>
     * DB remark: 保镖4电话,与t_crew.crew_phone字段关联
     * DB column: task_security4_phone	VARCHAR(15)	<--->	security4Phone	java.lang.String
     * DB is  Nullable: true
     * DB defaultValue: null
     * </pre>
     */
    @Length(max = 15, message = "{" + TaskBeanI18nConstant.TASK_BEAN_SECURITY4_PHONE_LENGTH + "}", groups = {IBaseValidGroup.Add.class, IBaseValidGroup.Update.class})
    @Column(name = "task_security4_phone", length = 15, nullable = true)
    private String security4Phone;

    /**
     * <pre>
     * DB remark: 保镖4班次,与shift_week_start_date,对应;【应在生成计划任务,根据人员安排时,设置值也要注意在变更路线时,设置值】
     * DB column: task_security4_shift	CHAR(1)	<--->	security4Shift	java.lang.String
     * DB is  Nullable: true
     * DB defaultValue: null
     * </pre>
     */
    @Length(max = 1, message = "{" + TaskBeanI18nConstant.TASK_BEAN_SECURITY4_SHIFT_LENGTH + "}", groups = {IBaseValidGroup.Add.class, IBaseValidGroup.Update.class})
    @Column(name = "task_security4_shift", length = 1, nullable = true)
    private String security4Shift;

    /**
     * <pre>
     * DB remark: nip客户负责人确认签收密码6位,MD5加密之后取前8位,与t_user.user_pass_code【该分支机构下,所有拥有nip密码的,JSON对象[{username:a1,passCode:123456},{username:a2,passCode:654321}]】
     * DB column: task_nip_username_pass_code	VARCHAR(175)	<--->	nipUsernamePassCode	java.lang.String
     * DB is  Nullable: true
     * DB defaultValue: 670b1472
     * </pre>
     */
    @Length(max = 175, message = "{" + TaskBeanI18nConstant.TASK_BEAN_NIP_USERNAME_PASS_CODE_LENGTH + "}", groups = {IBaseValidGroup.Add.class, IBaseValidGroup.Update.class})
    @Column(name = "task_nip_username_pass_code", length = 175, nullable = true)
    private String nipUsernamePassCode;

    /**
     * <pre>
     * DB remark: nip客户负责人username,在客户负责人与司机进行交接时,确认签收人的username
     * DB column: task_nip_confirm_username	VARCHAR(20)	<--->	nipConfirmUsername	java.lang.String
     * DB is  Nullable: true
     * DB defaultValue: DEFAULT
     * </pre>
     */
    @Length(max = 20, message = "{" + TaskBeanI18nConstant.TASK_BEAN_NIP_CONFIRM_USERNAME_LENGTH + "}", groups = {IBaseValidGroup.Add.class, IBaseValidGroup.Update.class})
    @Column(name = "task_nip_confirm_username", length = 20, nullable = true)
    private String nipConfirmUsername;

    /**
     * <pre>
     * DB remark: 服务种类【WORKDAY[工作日], HOLIDAY[节假日], SATURDAY[周六], SUNDAY[周日]】,与t_task_contract.contract_service_line,关联
     * DB column: task_service_line	VARCHAR(20)	<--->	serviceLine	java.lang.String
     * DB is  Nullable: true
     * DB defaultValue: null
     * </pre>
     */
    @Length(max = 20, message = "{" + TaskBeanI18nConstant.TASK_BEAN_SERVICE_LINE_LENGTH + "}", groups = {IBaseValidGroup.Add.class, IBaseValidGroup.Update.class})
    @Column(name = "task_service_line", length = 20, nullable = true)
    private String serviceLine;

    /**
     * <pre>
     * DB remark: 班次类型【M[早班Morning]6am-1pm[06:00-13:00], A[中班Afternoon]2pm-6pm[14:00-18:00], N[晚班Night]6pm-12am[18:00-23:59], V[休假Vacations]】,以司机班次为任务班次,当前业务逻辑需求2016-08-22
     * DB column: task_shift	CHAR(1)	<--->	shift	java.lang.String
     * DB is  Nullable: true
     * DB defaultValue: null
     * </pre>
     */
    @Length(max = 1, message = "{" + TaskBeanI18nConstant.TASK_BEAN_SHIFT_LENGTH + "}", groups = {IBaseValidGroup.Add.class, IBaseValidGroup.Update.class})
    @Column(name = "task_shift", length = 1, nullable = true)
    private String shift;

    /**
     * <pre>
     * DB remark: 武装等级【NONE[无], LIGHT[一般], MEDIUM[中等], HEAVY[重型]】,与t_task_contract.contract_armored_level,关联
     * DB column: task_armored_level	VARCHAR(20)	<--->	armoredLevel	java.lang.String
     * DB is  Nullable: true
     * DB defaultValue: null
     * </pre>
     */
    @Length(max = 20, message = "{" + TaskBeanI18nConstant.TASK_BEAN_ARMORED_LEVEL_LENGTH + "}", groups = {IBaseValidGroup.Add.class, IBaseValidGroup.Update.class})
    @Column(name = "task_armored_level", length = 20, nullable = true)
    private String armoredLevel;

    /**
     * <pre>
     * DB remark: 创建时间
     * DB column: task_create_timestamp	TIMESTAMP(19)	<--->	createTimestamp	java.util.Date
     * DB is  Nullable: false
     * DB defaultValue: CURRENT_TIMESTAMP
     * </pre>
     */
    @ValidDateTimeFormat(pattern = DateUtil.DATE_PATTERN_YYYY_MM_DD_HH_MM_SS, message = "{" + TaskBeanI18nConstant.TASK_BEAN_CREATE_TIMESTAMP_DATE_TIME_FORMAT + "}", groups = {IBaseValidGroup.Add.class, IBaseValidGroup.Update.class})
    @DateTimeFormat(pattern = DateUtil.DATE_PATTERN_YYYY_MM_DD_HH_MM_SS)
    @NotNull(message = "{" + TaskBeanI18nConstant.TASK_BEAN_CREATE_TIMESTAMP_NOT_NULL + "}", groups = {IBaseValidGroup.Add.class, IBaseValidGroup.Update.class})
    @Column(name = "task_create_timestamp", length = 19, nullable = false)
    private Date createTimestamp;

    @ValidDateTimeFormat(pattern = DateUtil.DATE_PATTERN_YYYY_MM_DD_HH_MM_SS, message = "{" + TaskBeanI18nConstant.TASK_BEAN_UPDATE_TIMESTAMP_DATE_TIME_FORMAT + "}", groups = {IBaseValidGroup.Add.class, IBaseValidGroup.Update.class})
    @DateTimeFormat(pattern = DateUtil.DATE_PATTERN_YYYY_MM_DD_HH_MM_SS)
    @NotNull(message = "{" + TaskBeanI18nConstant.TASK_BEAN_UPDATE_TIMESTAMP_NOT_NULL + "}", groups = {IBaseValidGroup.Add.class, IBaseValidGroup.Update.class})
    @Column(name = "task_update_timestamp", length = 19, nullable = false)
    private Date updateTimestamp;

    /**
     * <pre>
     * DB remark: 谁新增了该员工,与crew_username字段关联 若为系统生成创建者为:SYSTEM
     * DB column: task_create_by	VARCHAR(20)	<--->	createBy	java.lang.String
     * DB is  Nullable: false
     * DB defaultValue: null
     * </pre>
     */
    @NotBlank(message = "{" + TaskBeanI18nConstant.TASK_BEAN_CREATE_BY_NOT_BLANK + "}", groups = {IBaseValidGroup.Add.class, IBaseValidGroup.Update.class})
    @Length(max = 20, message = "{" + TaskBeanI18nConstant.TASK_BEAN_CREATE_BY_LENGTH + "}", groups = {IBaseValidGroup.Add.class, IBaseValidGroup.Update.class})
    @Column(name = "task_create_by", length = 20, nullable = false)
    private String createBy;

    /**
     * <pre>
     * DB remark: 逻辑删除标志【N[正常]，Y[删除]】
     * DB column: task_delete_flag	CHAR(1)	<--->	deleteFlag	java.lang.String
     * DB is  Nullable: false
     * DB defaultValue: N
     * </pre>
     */
    @NotBlank(message = "{" + TaskBeanI18nConstant.TASK_BEAN_DELETE_FLAG_NOT_BLANK + "}", groups = {IBaseValidGroup.Add.class, IBaseValidGroup.Update.class})
    @Length(max = 1, message = "{" + TaskBeanI18nConstant.TASK_BEAN_DELETE_FLAG_LENGTH + "}", groups = {IBaseValidGroup.Add.class, IBaseValidGroup.Update.class})
    @Column(name = "task_delete_flag", length = 1, nullable = false)
    private String deleteFlag;

    /**
     * <pre>
     * DB remark: ATM外部编号,在调用第三方接口里的唯一标识
     * DB column: task_atm_external_id	VARCHAR(15)	<--->	atmExternalId	java.lang.String
     * DB is  Nullable: true
     * DB defaultValue: null
     * </pre>
     */
    @Length(max = 15, message = "{" + TaskBeanI18nConstant.TASK_BEAN_ATM_EXTERNAL_ID_LENGTH + "}", groups = {IBaseValidGroup.Add.class, IBaseValidGroup.Update.class})
    @Column(name = "task_atm_external_id", length = 15, nullable = true)
    private String atmExternalId;

    /**
     * <pre>
     * DB remark: 任务预设截止日期,目前ATM修复任务类型任务时才有该字段信息
     * DB column: task_deadline	CHAR(20)	<--->	deadline	java.lang.String
     * DB is  Nullable: true
     * DB defaultValue: null
     * </pre>
     */
    @Length(max = 20, message = "{" + TaskBeanI18nConstant.TASK_BEAN_DEADLINE_LENGTH + "}", groups = {IBaseValidGroup.Add.class, IBaseValidGroup.Update.class})
    @Column(name = "task_deadline", length = 20, nullable = true)
    private String deadline;

    /**
     * <pre>
     * DB remark: 任务完成结果描述
     * DB column: task_description	VARCHAR(200)	<--->	description	java.lang.String
     * DB is  Nullable: true
     * DB defaultValue: null
     * </pre>
     */
    @Length(max = 200, message = "{" + TaskBeanI18nConstant.TASK_BEAN_DESCRIPTION_LENGTH + "}", groups = {IBaseValidGroup.Add.class, IBaseValidGroup.Update.class})
    @Column(name = "task_description", length = 200, nullable = true)
    private String description;

    /**
     * <pre>
     * DB remark: 任务来源哪一方生成的任务【SIO公司导入进来分两种：[SIO_0_KIOSKOLIN、SIO_1_COMODIN]，COMODIN[comodin手工创建]，EXCEL[excel批量导入]】
     * DB column: task_generate_source_party	VARCHAR(20)	<--->	generateSourceParty	java.lang.String
     * DB is  Nullable: false
     * DB defaultValue: null
     * </pre>
     */
    @NotBlank(message = "{" + TaskBeanI18nConstant.TASK_BEAN_GENERATE_SOURCE_PARTY_NOT_BLANK + "}", groups = {IBaseValidGroup.Add.class, IBaseValidGroup.Update.class})
    @Length(max = 20, message = "{" + TaskBeanI18nConstant.TASK_BEAN_GENERATE_SOURCE_PARTY_LENGTH + "}", groups = {IBaseValidGroup.Add.class, IBaseValidGroup.Update.class})
    @Column(name = "task_generate_source_party", length = 20, nullable = false)
    private String generateSourceParty;

    /**
     * <pre>
     * DB remark: 生成任务的方式【ON_CONTRACT[按合同], ON_DEMAND[按需求]】
     * DB column: task_generated_type	VARCHAR(20)	<--->	generatedType	java.lang.String
     * DB is  Nullable: true
     * DB defaultValue: null
     * </pre>
     */
    @Length(max = 20, message = "{" + TaskBeanI18nConstant.TASK_BEAN_GENERATED_TYPE_LENGTH + "}", groups = {IBaseValidGroup.Add.class, IBaseValidGroup.Update.class})
    @Column(name = "task_generated_type", length = 20, nullable = true)
    private String generatedType;

    /**
     * <pre>
     * DB remark: 任务来源的,公司,ID【date:2016-12-12 by:supeng】【{"max":13}】
     * DB column: task_source_company_id	BIGINT(20)	<--->	sourceCompanyId	java.lang.Long
     * DB is  Nullable: true
     * DB defaultValue: null
     * </pre>
     */
    @ValidLength(max = 13, message = "{" + TaskBeanI18nConstant.TASK_BEAN_SOURCE_COMPANY_ID_LENGTH + "}", groups = {IBaseValidGroup.Add.class, IBaseValidGroup.Update.class})
    @Column(name = "task_source_company_id", length = 20, nullable = true)
    private Long sourceCompanyId;

    /**
     * <pre>
     * DB remark: 任务来源的,公司,内部ID【date:2016-12-12 by:supeng】
     * DB column: task_source_company_internal_id	VARCHAR(15)	<--->	sourceCompanyInternalId	java.lang.String
     * DB is  Nullable: true
     * DB defaultValue: null
     * </pre>
     */
    @Length(max = 15, message = "{" + TaskBeanI18nConstant.TASK_BEAN_SOURCE_COMPANY_INTERNAL_ID_LENGTH + "}", groups = {IBaseValidGroup.Add.class, IBaseValidGroup.Update.class})
    @Column(name = "task_source_company_internal_id", length = 15, nullable = true)
    private String sourceCompanyInternalId;

    /**
     * <pre>
     * DB remark: 任务来源的,公司,名【date:2016-12-12 by:supeng】
     * DB column: task_source_company_name	VARCHAR(100)	<--->	sourceCompanyName	java.lang.String
     * DB is  Nullable: true
     * DB defaultValue: null
     * </pre>
     */
    @Length(max = 100, message = "{" + TaskBeanI18nConstant.TASK_BEAN_SOURCE_COMPANY_NAME_LENGTH + "}", groups = {IBaseValidGroup.Add.class, IBaseValidGroup.Update.class})
    @Column(name = "task_source_company_name", length = 100, nullable = true)
    private String sourceCompanyName;

    /**
     * <pre>
     * DB remark: 任务来源的,网点,ID【date:2016-12-12 by:supeng】【{"max":13}】
     * DB column: task_source_branch_id	BIGINT(20)	<--->	sourceBranchId	java.lang.Long
     * DB is  Nullable: true
     * DB defaultValue: null
     * </pre>
     */
    @ValidLength(max = 13, message = "{" + TaskBeanI18nConstant.TASK_BEAN_SOURCE_BRANCH_ID_LENGTH + "}", groups = {IBaseValidGroup.Add.class, IBaseValidGroup.Update.class})
    @Column(name = "task_source_branch_id", length = 20, nullable = true)
    private Long sourceBranchId;

    /**
     * <pre>
     * DB remark: 任务来源的,网点,内部ID【date:2016-12-12 by:supeng】
     * DB column: task_source_branch_internal_id	VARCHAR(15)	<--->	sourceBranchInternalId	java.lang.String
     * DB is  Nullable: true
     * DB defaultValue: null
     * </pre>
     */
    @Length(max = 15, message = "{" + TaskBeanI18nConstant.TASK_BEAN_SOURCE_BRANCH_INTERNAL_ID_LENGTH + "}", groups = {IBaseValidGroup.Add.class, IBaseValidGroup.Update.class})
    @Column(name = "task_source_branch_internal_id", length = 15, nullable = true)
    private String sourceBranchInternalId;

    /**
     * <pre>
     * DB remark: 任务来源的,网点,名【date:2016-12-12 by:supeng】
     * DB column: task_source_branch_name	VARCHAR(100)	<--->	sourceBranchName	java.lang.String
     * DB is  Nullable: true
     * DB defaultValue: null
     * </pre>
     */
    @Length(max = 100, message = "{" + TaskBeanI18nConstant.TASK_BEAN_SOURCE_BRANCH_NAME_LENGTH + "}", groups = {IBaseValidGroup.Add.class, IBaseValidGroup.Update.class})
    @Column(name = "task_source_branch_name", length = 100, nullable = true)
    private String sourceBranchName;

    /**
     * <pre>
     * DB remark: 任务原始,ID,【date:2016-12-12 by:supeng】
     * DB column: task_source_task_id	VARCHAR(15)	<--->	sourceTaskId	java.lang.String
     * DB is  Nullable: true
     * DB defaultValue: null
     * </pre>
     */
    @Length(max = 15, message = "{" + TaskBeanI18nConstant.TASK_BEAN_SOURCE_TASK_ID_LENGTH + "}", groups = {IBaseValidGroup.Add.class, IBaseValidGroup.Update.class})
    @Column(name = "task_source_task_id", length = 15, nullable = true)
    private String sourceTaskId;

    /**
     * <pre>
     * DB remark: 任务原始,服务类型【1_CLIENT_TO_CLIENT、2_RECEIVER_CLIENT_TO_BOVEDA、3_RECEIVER_CLIENT_TO_PROCESS、4_SENDER_BOVEDA_TO_CLIENT、5_SENDER_PROCESS_TO_CLIENT、6_SENDER_WAREHOUSE_TO_CLIENT】by:supeng date:2017-05-19
     * DB column: task_source_task_service_type	VARCHAR(30)	<--->	sourceServiceType	java.lang.String
     * DB is  Nullable: true
     * DB defaultValue: null
     * </pre>
     */
    @Length(max = 30, message = "{" + TaskBeanI18nConstant.TASK_BEAN_SOURCE_SERVICE_TYPE_LENGTH + "}", groups = {IBaseValidGroup.Add.class, IBaseValidGroup.Update.class})
    @Column(name = "task_source_task_service_type", length = 30, nullable = true)
    private String sourceServiceType;

    /**
     * <pre>
     * DB remark: 任务原始,服务代码
     * DB column: task_source_service_code	VARCHAR(20)	<--->	sourceServiceCode	java.lang.String
     * DB is  Nullable: true
     * DB defaultValue: null
     * </pre>
     */
    @Length(max = 20, message = "{" + TaskBeanI18nConstant.TASK_BEAN_SOURCE_SERVICE_CODE_LENGTH + "}", groups = {IBaseValidGroup.Add.class, IBaseValidGroup.Update.class})
    @Column(name = "task_source_service_code", length = 20, nullable = true)
    private String sourceServiceCode;

    /**
     * <pre>
     * DB remark: 任务原始,钥匙编号
     * DB column: task_source_safe_key_number	VARCHAR(20)	<--->	sourceSafeKeyNumber	java.lang.String
     * DB is  Nullable: true
     * DB defaultValue: null
     * </pre>
     */
    @Length(max = 20, message = "{" + TaskBeanI18nConstant.TASK_BEAN_SOURCE_SAFE_KEY_NUMBER_LENGTH + "}", groups = {IBaseValidGroup.Add.class, IBaseValidGroup.Update.class})
    @Column(name = "task_source_safe_key_number", length = 20, nullable = true)
    private String sourceSafeKeyNumber;

    /**
     * <pre>
     * DB remark: 任务原始,描述 - 需要在APP中显示
     * DB column: task_source_description	VARCHAR(255)	<--->	sourceDescription	java.lang.String
     * DB is  Nullable: true
     * DB defaultValue: null
     * </pre>
     */
    @Length(max = 255, message = "{" + TaskBeanI18nConstant.TASK_BEAN_SOURCE_DESCRIPTION_LENGTH + "}", groups = {IBaseValidGroup.Add.class, IBaseValidGroup.Update.class})
    @Column(name = "task_source_description", length = 255, nullable = true)
    private String sourceDescription;

    /**
     * <pre>
     * DB remark: 任务原始,该任务是否生效; 该字段目前主要是sioXml导入的任务开关【ENABLE[启用]、DISABLE[禁用]】
     * DB column: task_source_availability	CHAR(7)	<--->	sourceAvailability	java.lang.String
     * DB is  Nullable: true
     * DB defaultValue: ENABLE
     * </pre>
     */
    @Length(max = 7, message = "{" + TaskBeanI18nConstant.TASK_BEAN_SOURCE_AVAILABILITY_LENGTH + "}", groups = {IBaseValidGroup.Add.class, IBaseValidGroup.Update.class})
    @Column(name = "task_source_availability", length = 7, nullable = true)
    private String sourceAvailability;

    /**
     * <pre>
     * DB remark: 任务复合ID,组成方式【|4|26|20161118|1101|1|】【|SIO公司内部ID|SIO公司网点内部ID|路线日期[yyyyMMdd]|路线ID|任务ID|】【date:2016-12-12 by:supeng】
     * DB column: task_source_task_original_complex_id	VARCHAR(100)	<--->	sourceOriginalComplexId	java.lang.String
     * DB is  Nullable: true
     * DB defaultValue: null
     * </pre>
     */
    @Length(max = 100, message = "{" + TaskBeanI18nConstant.TASK_BEAN_SOURCE_ORIGINAL_COMPLEX_ID_LENGTH + "}", groups = {IBaseValidGroup.Add.class, IBaseValidGroup.Update.class})
    @Column(name = "task_source_task_original_complex_id", length = 100, nullable = true)
    private String sourceOriginalComplexId;

    @Length(max = 25, message = "{" + TaskBeanI18nConstant.TASK_BEAN_LAST_GENERATE_XML_TASK_STATUS_LENGTH + "}", groups = {IBaseValidGroup.Add.class, IBaseValidGroup.Update.class})
    @Column(name = "task_last_generate_xml_task_status", length = 25, nullable = true)
    private String lastGenerateXmlTaskStatus;

    private static final long serialVersionUID = 1L;

    /**
     * 获取 数据库主键ID【{"max":13}】
     *
     * @return task_pk_id - 数据库主键ID【{"max":13}】
     */
    public Long getPkId() {
        return pkId;
    }

    /**
     * 设置 数据库主键ID【{"max":13}】
     *
     * @param pkId - 数据库主键ID【{"max":13}】
     */
    public TaskBean setPkId(Long pkId) {
        this.pkId = pkId;
        return this;
    }

    /**
     * 获取 任务ID,与pk_id区别在于,业务场景:在 in_changed的时候,会生成两条记录task_pk_id 而task_id为同一条,且只有一条task_availability,为ENABLE【{"max":13}】
     *
     * @return task_id - 任务ID,与pk_id区别在于,业务场景:在 in_changed的时候,会生成两条记录task_pk_id 而task_id为同一条,且只有一条task_availability,为ENABLE【{"max":13}】
     */
    public Long getTaskId() {
        return taskId;
    }

    /**
     * 设置 任务ID,与pk_id区别在于,业务场景:在 in_changed的时候,会生成两条记录task_pk_id 而task_id为同一条,且只有一条task_availability,为ENABLE【{"max":13}】
     *
     * @param taskId - 任务ID,与pk_id区别在于,业务场景:在 in_changed的时候,会生成两条记录task_pk_id 而task_id为同一条,且只有一条task_availability,为ENABLE【{"max":13}】
     */
    public TaskBean setTaskId(Long taskId) {
        this.taskId = taskId;
        return this;
    }

    /**
     * 获取 任务执行日期,与t_task_contract.contract_cron_expression 服务日期表达式所定义生成
     *
     * @return task_service_date - 任务执行日期,与t_task_contract.contract_cron_expression 服务日期表达式所定义生成
     */
    public String getServiceDate() {
        return serviceDate;
    }

    /**
     * 设置 任务执行日期,与t_task_contract.contract_cron_expression 服务日期表达式所定义生成
     *
     * @param serviceDate - 任务执行日期,与t_task_contract.contract_cron_expression 服务日期表达式所定义生成
     */
    public TaskBean setServiceDate(String serviceDate) {
        this.serviceDate = serviceDate == null ? null : serviceDate.trim();
        return this;
    }

    /**
     * 获取 服务类型,与t_task_contract.contract_service_type,关联
     *
     * @return task_service_type - 服务类型,与t_task_contract.contract_service_type,关联
     */
    public String getServiceType() {
        return serviceType;
    }

    /**
     * 设置 服务类型,与t_task_contract.contract_service_type,关联
     *
     * @param serviceType - 服务类型,与t_task_contract.contract_service_type,关联
     */
    public TaskBean setServiceType(String serviceType) {
        this.serviceType = serviceType == null ? null : serviceType.trim();
        return this;
    }

    /**
     * 获取 任务是否需要现场数钞【NOT_COUNT[不需要]COUNT_TOTAL[统计总额]COUNT_DENOMINATION[统计面额]REAL_TIME_ARRIVAL[实时到账]】
     *
     * @return task_whether_site_counting - 任务是否需要现场数钞【NOT_COUNT[不需要]COUNT_TOTAL[统计总额]COUNT_DENOMINATION[统计面额]REAL_TIME_ARRIVAL[实时到账]】
     */
    public String getWhetherSiteCounting() {
        return whetherSiteCounting;
    }

    /**
     * 设置 任务是否需要现场数钞【NOT_COUNT[不需要]COUNT_TOTAL[统计总额]COUNT_DENOMINATION[统计面额]REAL_TIME_ARRIVAL[实时到账]】
     *
     * @param whetherSiteCounting - 任务是否需要现场数钞【NOT_COUNT[不需要]COUNT_TOTAL[统计总额]COUNT_DENOMINATION[统计面额]REAL_TIME_ARRIVAL[实时到账]】
     */
    public TaskBean setWhetherSiteCounting(String whetherSiteCounting) {
        this.whetherSiteCounting = whetherSiteCounting == null ? null : whetherSiteCounting.trim();
        return this;
    }

    /**
     * 获取 路线id,与t_task_contract.contract_route_id,关联
     *
     * @return task_route_id - 路线id,与t_task_contract.contract_route_id,关联
     */
    public String getRouteId() {
        return routeId;
    }

    /**
     * 设置 路线id,与t_task_contract.contract_route_id,关联
     *
     * @param routeId - 路线id,与t_task_contract.contract_route_id,关联
     */
    public TaskBean setRouteId(String routeId) {
        this.routeId = routeId == null ? null : routeId.trim();
        return this;
    }

    /**
     * 获取 路线顺序,与t_task_contract.contract_route_order,关联
     *
     * @return task_route_order - 路线顺序,与t_task_contract.contract_route_order,关联
     */
    public Integer getRouteOrder() {
        return routeOrder;
    }

    /**
     * 设置 路线顺序,与t_task_contract.contract_route_order,关联
     *
     * @param routeOrder - 路线顺序,与t_task_contract.contract_route_order,关联
     */
    public TaskBean setRouteOrder(Integer routeOrder) {
        this.routeOrder = routeOrder;
        return this;
    }

    /**
     * 获取 任务状态,任务当下的状态 pending schedule assign_route assign_driver assign_guard assign_vehicle in_route in_processcomprobante completed inter_changed cancelled
     *
     * @return task_status - 任务状态,任务当下的状态 pending schedule assign_route assign_driver assign_guard assign_vehicle in_route in_processcomprobante completed inter_changed cancelled
     */
    public String getStatus() {
        return status;
    }

    /**
     * 设置 任务状态,任务当下的状态 pending schedule assign_route assign_driver assign_guard assign_vehicle in_route in_processcomprobante completed inter_changed cancelled
     *
     * @param status - 任务状态,任务当下的状态 pending schedule assign_route assign_driver assign_guard assign_vehicle in_route in_processcomprobante completed inter_changed cancelled
     */
    public TaskBean setStatus(String status) {
        this.status = status == null ? null : status.trim();
        return this;
    }

    /**
     * 获取 任务是否有效【ENABLE[启用]、DISABLE[禁用]】
     *
     * @return task_availability - 任务是否有效【ENABLE[启用]、DISABLE[禁用]】
     */
    public String getAvailability() {
        return availability;
    }

    /**
     * 设置 任务是否有效【ENABLE[启用]、DISABLE[禁用]】
     *
     * @param availability - 任务是否有效【ENABLE[启用]、DISABLE[禁用]】
     */
    public TaskBean setAvailability(String availability) {
        this.availability = availability == null ? null : availability.trim();
        return this;
    }

    /**
     * 获取 任务是否为交接，已收到钱在车上【Y[任务是已完成]、N[任务未完成]】
     *
     * @return task_whether_completed - 任务是否为交接，已收到钱在车上【Y[任务是已完成]、N[任务未完成]】
     */
    public String getWhetherCompleted() {
        return whetherCompleted;
    }

    /**
     * 设置 任务是否为交接，已收到钱在车上【Y[任务是已完成]、N[任务未完成]】
     *
     * @param whetherCompleted - 任务是否为交接，已收到钱在车上【Y[任务是已完成]、N[任务未完成]】
     */
    public TaskBean setWhetherCompleted(String whetherCompleted) {
        this.whetherCompleted = whetherCompleted == null ? null : whetherCompleted.trim();
        return this;
    }

    /**
     * 获取 任务是否为交接时，所生成的新任务【Y[任务是交换出来的新任务]、N[不是]】
     *
     * @return task_whether_inter_changed - 任务是否为交接时，所生成的新任务【Y[任务是交换出来的新任务]、N[不是]】
     */
    public String getWhetherInterChanged() {
        return whetherInterChanged;
    }

    /**
     * 设置 任务是否为交接时，所生成的新任务【Y[任务是交换出来的新任务]、N[不是]】
     *
     * @param whetherInterChanged - 任务是否为交接时，所生成的新任务【Y[任务是交换出来的新任务]、N[不是]】
     */
    public TaskBean setWhetherInterChanged(String whetherInterChanged) {
        this.whetherInterChanged = whetherInterChanged == null ? null : whetherInterChanged.trim();
        return this;
    }

    /**
     * 获取 interchange,["",ORIG,DEST]【date:2017-07-28 by:supeng】
     *
     * @return task_inter_change_type - interchange,["",ORIG,DEST]【date:2017-07-28 by:supeng】
     */
    public String getInterChangeType() {
        return interChangeType;
    }

    /**
     * 设置 interchange,["",ORIG,DEST]【date:2017-07-28 by:supeng】
     *
     * @param interChangeType - interchange,["",ORIG,DEST]【date:2017-07-28 by:supeng】
     */
    public TaskBean setInterChangeType(String interChangeType) {
        this.interChangeType = interChangeType == null ? null : interChangeType.trim();
        return this;
    }

    /**
     * 获取 interchange,原先的任务复合ID，组成方式【|4|26|20161118|1101|1|】【|SIO公司内部ID|SIO公司网点内部ID|路线日期[yyyyMMdd]|路线ID|任务ID|】【date:2017-07-28 by:supeng】
     *
     * @return task_inter_change_original_task_complex_id - interchange,原先的任务复合ID，组成方式【|4|26|20161118|1101|1|】【|SIO公司内部ID|SIO公司网点内部ID|路线日期[yyyyMMdd]|路线ID|任务ID|】【date:2017-07-28 by:supeng】
     */
    public String getInterChangeOriginalComplexId() {
        return interChangeOriginalComplexId;
    }

    /**
     * 设置 interchange,原先的任务复合ID，组成方式【|4|26|20161118|1101|1|】【|SIO公司内部ID|SIO公司网点内部ID|路线日期[yyyyMMdd]|路线ID|任务ID|】【date:2017-07-28 by:supeng】
     *
     * @param interChangeOriginalComplexId - interchange,原先的任务复合ID，组成方式【|4|26|20161118|1101|1|】【|SIO公司内部ID|SIO公司网点内部ID|路线日期[yyyyMMdd]|路线ID|任务ID|】【date:2017-07-28 by:supeng】
     */
    public TaskBean setInterChangeOriginalComplexId(String interChangeOriginalComplexId) {
        this.interChangeOriginalComplexId = interChangeOriginalComplexId == null ? null : interChangeOriginalComplexId.trim();
        return this;
    }

    /**
     * 获取 interchange任务时地址坐标纬度,浮点型
     *
     * @return task_inter_change_latitude - interchange任务时地址坐标纬度,浮点型
     */
    public String getInterChangeLatitude() {
        return interChangeLatitude;
    }

    /**
     * 设置 interchange任务时地址坐标纬度,浮点型
     *
     * @param interChangeLatitude - interchange任务时地址坐标纬度,浮点型
     */
    public TaskBean setInterChangeLatitude(String interChangeLatitude) {
        this.interChangeLatitude = interChangeLatitude == null ? null : interChangeLatitude.trim();
        return this;
    }

    /**
     * 获取 interchange任务时地址坐标经度,浮点型
     *
     * @return task_inter_change_longitude - interchange任务时地址坐标经度,浮点型
     */
    public String getInterChangeLongitude() {
        return interChangeLongitude;
    }

    /**
     * 设置 interchange任务时地址坐标经度,浮点型
     *
     * @param interChangeLongitude - interchange任务时地址坐标经度,浮点型
     */
    public TaskBean setInterChangeLongitude(String interChangeLongitude) {
        this.interChangeLongitude = interChangeLongitude == null ? null : interChangeLongitude.trim();
        return this;
    }

    /**
     * 获取 完成任务（或者部分完成任务）时地址坐标纬度,浮点型
     *
     * @return task_complete_latitude - 完成任务（或者部分完成任务）时地址坐标纬度,浮点型
     */
    public String getCompleteLatitude() {
        return completeLatitude;
    }

    /**
     * 设置 完成任务（或者部分完成任务）时地址坐标纬度,浮点型
     *
     * @param completeLatitude - 完成任务（或者部分完成任务）时地址坐标纬度,浮点型
     */
    public TaskBean setCompleteLatitude(String completeLatitude) {
        this.completeLatitude = completeLatitude == null ? null : completeLatitude.trim();
        return this;
    }

    /**
     * 获取 完成任务（或者部分完成任务）时地址坐标经度,浮点型
     *
     * @return task_complete_longitude - 完成任务（或者部分完成任务）时地址坐标经度,浮点型
     */
    public String getCompleteLongitude() {
        return completeLongitude;
    }

    /**
     * 设置 完成任务（或者部分完成任务）时地址坐标经度,浮点型
     *
     * @param completeLongitude - 完成任务（或者部分完成任务）时地址坐标经度,浮点型
     */
    public TaskBean setCompleteLongitude(String completeLongitude) {
        this.completeLongitude = completeLongitude == null ? null : completeLongitude.trim();
        return this;
    }

    /**
     * 获取 APP司机部，每次回传的版本号
     *
     * @return task_app_version - APP司机部，每次回传的版本号
     */
    public Date getAppVersion() {
        return appVersion;
    }

    /**
     * 设置 APP司机部，每次回传的版本号
     *
     * @param appVersion - APP司机部，每次回传的版本号
     */
    public TaskBean setAppVersion(Date appVersion) {
        this.appVersion = appVersion;
        return this;
    }

    /**
     * 获取 任务，到达目的（网点地址）时间，系统自动根据经纬度范围，推算出来的时间
     *
     * @return task_arrival_time_auto_calc - 任务，到达目的（网点地址）时间，系统自动根据经纬度范围，推算出来的时间
     */
    public Date getArrivalTimeAutoCalc() {
        return arrivalTimeAutoCalc;
    }

    /**
     * 设置 任务，到达目的（网点地址）时间，系统自动根据经纬度范围，推算出来的时间
     *
     * @param arrivalTimeAutoCalc - 任务，到达目的（网点地址）时间，系统自动根据经纬度范围，推算出来的时间
     */
    public TaskBean setArrivalTimeAutoCalc(Date arrivalTimeAutoCalc) {
        this.arrivalTimeAutoCalc = arrivalTimeAutoCalc;
        return this;
    }

    /**
     * 获取 任务，到达目的（网点地址）时间，人工输入的时间
     *
     * @return task_arrival_time_manual_input - 任务，到达目的（网点地址）时间，人工输入的时间
     */
    public Date getArrivalTimeManualInput() {
        return arrivalTimeManualInput;
    }

    /**
     * 设置 任务，到达目的（网点地址）时间，人工输入的时间
     *
     * @param arrivalTimeManualInput - 任务，到达目的（网点地址）时间，人工输入的时间
     */
    public TaskBean setArrivalTimeManualInput(Date arrivalTimeManualInput) {
        this.arrivalTimeManualInput = arrivalTimeManualInput;
        return this;
    }

    /**
     * 获取 任务处理开始时间,目前系统根据,司机手机APP,在进入该客户分支店时,任务状态为:in_process任务,到达任务地址,开始处理
     *
     * @return task_process_start_timestamp - 任务处理开始时间,目前系统根据,司机手机APP,在进入该客户分支店时,任务状态为:in_process任务,到达任务地址,开始处理
     */
    public Date getProcessStartTimestamp() {
        return processStartTimestamp;
    }

    /**
     * 设置 任务处理开始时间,目前系统根据,司机手机APP,在进入该客户分支店时,任务状态为:in_process任务,到达任务地址,开始处理
     *
     * @param processStartTimestamp - 任务处理开始时间,目前系统根据,司机手机APP,在进入该客户分支店时,任务状态为:in_process任务,到达任务地址,开始处理
     */
    public TaskBean setProcessStartTimestamp(Date processStartTimestamp) {
        this.processStartTimestamp = processStartTimestamp;
        return this;
    }

    /**
     * 获取 任务处理结束时间,目前系统根据,司机手机APP,在验收钞票与票据动作之后,completed任务,完成
     *
     * @return task_process_end_timestamp - 任务处理结束时间,目前系统根据,司机手机APP,在验收钞票与票据动作之后,completed任务,完成
     */
    public Date getProcessEndTimestamp() {
        return processEndTimestamp;
    }

    /**
     * 设置 任务处理结束时间,目前系统根据,司机手机APP,在验收钞票与票据动作之后,completed任务,完成
     *
     * @param processEndTimestamp - 任务处理结束时间,目前系统根据,司机手机APP,在验收钞票与票据动作之后,completed任务,完成
     */
    public TaskBean setProcessEndTimestamp(Date processEndTimestamp) {
        this.processEndTimestamp = processEndTimestamp;
        return this;
    }

    /**
     * 获取 任务处理完成后,时效【ON_TIME 为及时、IN_ADVANCE 为早到、BE_LATE 为迟到、TIME_OUT 为超时】
     *
     * @return task_process_timeliness - 任务处理完成后,时效【ON_TIME 为及时、IN_ADVANCE 为早到、BE_LATE 为迟到、TIME_OUT 为超时】
     */
    public String getProcessTimeliness() {
        return processTimeliness;
    }

    /**
     * 设置 任务处理完成后,时效【ON_TIME 为及时、IN_ADVANCE 为早到、BE_LATE 为迟到、TIME_OUT 为超时】
     *
     * @param processTimeliness - 任务处理完成后,时效【ON_TIME 为及时、IN_ADVANCE 为早到、BE_LATE 为迟到、TIME_OUT 为超时】
     */
    public TaskBean setProcessTimeliness(String processTimeliness) {
        this.processTimeliness = processTimeliness == null ? null : processTimeliness.trim();
        return this;
    }

    /**
     * 获取 客户到客户类型，任务，到达目的（网点地址）时间，系统自动根据经纬度范围，推算出来的时间
     *
     * @return task_partial_arrival_time_auto_calc - 客户到客户类型，任务，到达目的（网点地址）时间，系统自动根据经纬度范围，推算出来的时间
     */
    public Date getPartialArrivalTimeAutoCalc() {
        return partialArrivalTimeAutoCalc;
    }

    /**
     * 设置 客户到客户类型，任务，到达目的（网点地址）时间，系统自动根据经纬度范围，推算出来的时间
     *
     * @param partialArrivalTimeAutoCalc - 客户到客户类型，任务，到达目的（网点地址）时间，系统自动根据经纬度范围，推算出来的时间
     */
    public TaskBean setPartialArrivalTimeAutoCalc(Date partialArrivalTimeAutoCalc) {
        this.partialArrivalTimeAutoCalc = partialArrivalTimeAutoCalc;
        return this;
    }

    /**
     * 获取 客户到客户类型，任务，到达目的（网点地址）时间，人工输入的时间
     *
     * @return task_partial_arrival_time_manual_input - 客户到客户类型，任务，到达目的（网点地址）时间，人工输入的时间
     */
    public Date getPartialArrivalTimeManualInput() {
        return partialArrivalTimeManualInput;
    }

    /**
     * 设置 客户到客户类型，任务，到达目的（网点地址）时间，人工输入的时间
     *
     * @param partialArrivalTimeManualInput - 客户到客户类型，任务，到达目的（网点地址）时间，人工输入的时间
     */
    public TaskBean setPartialArrivalTimeManualInput(Date partialArrivalTimeManualInput) {
        this.partialArrivalTimeManualInput = partialArrivalTimeManualInput;
        return this;
    }

    /**
     * 获取 客户到客户类型任务，收钱时的任务处理开始时间,目前系统根据,司机手机APP,在进入该客户分支店时,任务状态为:in_process任务,到达任务地址,开始处理
     *
     * @return task_partial_process_start_timestamp - 客户到客户类型任务，收钱时的任务处理开始时间,目前系统根据,司机手机APP,在进入该客户分支店时,任务状态为:in_process任务,到达任务地址,开始处理
     */
    public Date getPartialProcessStartTimestamp() {
        return partialProcessStartTimestamp;
    }

    /**
     * 设置 客户到客户类型任务，收钱时的任务处理开始时间,目前系统根据,司机手机APP,在进入该客户分支店时,任务状态为:in_process任务,到达任务地址,开始处理
     *
     * @param partialProcessStartTimestamp - 客户到客户类型任务，收钱时的任务处理开始时间,目前系统根据,司机手机APP,在进入该客户分支店时,任务状态为:in_process任务,到达任务地址,开始处理
     */
    public TaskBean setPartialProcessStartTimestamp(Date partialProcessStartTimestamp) {
        this.partialProcessStartTimestamp = partialProcessStartTimestamp;
        return this;
    }

    /**
     * 获取 客户到客户类型任务，收钱时的任务处理结束时间,目前系统根据,司机手机APP,在验收钞票与票据动作之后,completed任务,完成
     *
     * @return task_partial_process_end_timestamp - 客户到客户类型任务，收钱时的任务处理结束时间,目前系统根据,司机手机APP,在验收钞票与票据动作之后,completed任务,完成
     */
    public Date getPartialProcessEndTimestamp() {
        return partialProcessEndTimestamp;
    }

    /**
     * 设置 客户到客户类型任务，收钱时的任务处理结束时间,目前系统根据,司机手机APP,在验收钞票与票据动作之后,completed任务,完成
     *
     * @param partialProcessEndTimestamp - 客户到客户类型任务，收钱时的任务处理结束时间,目前系统根据,司机手机APP,在验收钞票与票据动作之后,completed任务,完成
     */
    public TaskBean setPartialProcessEndTimestamp(Date partialProcessEndTimestamp) {
        this.partialProcessEndTimestamp = partialProcessEndTimestamp;
        return this;
    }

    /**
     * 获取 客户到客户类型任务，收钱时的任务处理完成后,时效【ON_TIME 为及时、IN_ADVANCE 为早到、BE_LATE 为迟到、TIME_OUT 为超时】
     *
     * @return task_partial_process_timeliness - 客户到客户类型任务，收钱时的任务处理完成后,时效【ON_TIME 为及时、IN_ADVANCE 为早到、BE_LATE 为迟到、TIME_OUT 为超时】
     */
    public String getPartialProcessTimeliness() {
        return partialProcessTimeliness;
    }

    /**
     * 设置 客户到客户类型任务，收钱时的任务处理完成后,时效【ON_TIME 为及时、IN_ADVANCE 为早到、BE_LATE 为迟到、TIME_OUT 为超时】
     *
     * @param partialProcessTimeliness - 客户到客户类型任务，收钱时的任务处理完成后,时效【ON_TIME 为及时、IN_ADVANCE 为早到、BE_LATE 为迟到、TIME_OUT 为超时】
     */
    public TaskBean setPartialProcessTimeliness(String partialProcessTimeliness) {
        this.partialProcessTimeliness = partialProcessTimeliness == null ? null : partialProcessTimeliness.trim();
        return this;
    }

    /**
     * 获取 取消任务,责任方【CIT,CLIENT】
     *
     * @return task_cancel_responsible_party - 取消任务,责任方【CIT,CLIENT】
     */
    public String getCancelResponsibleParty() {
        return cancelResponsibleParty;
    }

    /**
     * 设置 取消任务,责任方【CIT,CLIENT】
     *
     * @param cancelResponsibleParty - 取消任务,责任方【CIT,CLIENT】
     */
    public TaskBean setCancelResponsibleParty(String cancelResponsibleParty) {
        this.cancelResponsibleParty = cancelResponsibleParty == null ? null : cancelResponsibleParty.trim();
        return this;
    }

    /**
     * 获取 取消任务,回执单[访问票据单]【目前需求,只有责任方为Client时,才有回执单】
     *
     * @return task_cancel_single_receipt - 取消任务,回执单[访问票据单]【目前需求,只有责任方为Client时,才有回执单】
     */
    public String getCancelSingleReceipt() {
        return cancelSingleReceipt;
    }

    /**
     * 设置 取消任务,回执单[访问票据单]【目前需求,只有责任方为Client时,才有回执单】
     *
     * @param cancelSingleReceipt - 取消任务,回执单[访问票据单]【目前需求,只有责任方为Client时,才有回执单】
     */
    public TaskBean setCancelSingleReceipt(String cancelSingleReceipt) {
        this.cancelSingleReceipt = cancelSingleReceipt == null ? null : cancelSingleReceipt.trim();
        return this;
    }

    /**
     * 获取 取消任务,理由,t_setting.setting_key,关联
     *
     * @return task_cancel_reason - 取消任务,理由,t_setting.setting_key,关联
     */
    public String getCancelReason() {
        return cancelReason;
    }

    /**
     * 设置 取消任务,理由,t_setting.setting_key,关联
     *
     * @param cancelReason - 取消任务,理由,t_setting.setting_key,关联
     */
    public TaskBean setCancelReason(String cancelReason) {
        this.cancelReason = cancelReason == null ? null : cancelReason.trim();
        return this;
    }

    /**
     * 获取 取消任务,钱回退处
     *
     * @return task_cancel_money_back_party - 取消任务,钱回退处
     */
    public String getCancelMoneyBackParty() {
        return cancelMoneyBackParty;
    }

    /**
     * 设置 取消任务,钱回退处
     *
     * @param cancelMoneyBackParty - 取消任务,钱回退处
     */
    public TaskBean setCancelMoneyBackParty(String cancelMoneyBackParty) {
        this.cancelMoneyBackParty = cancelMoneyBackParty == null ? null : cancelMoneyBackParty.trim();
        return this;
    }

    /**
     * 获取 取消任务,备注
     *
     * @return task_cancel_comment - 取消任务,备注
     */
    public String getCancelComment() {
        return cancelComment;
    }

    /**
     * 设置 取消任务,备注
     *
     * @param cancelComment - 取消任务,备注
     */
    public TaskBean setCancelComment(String cancelComment) {
        this.cancelComment = cancelComment == null ? null : cancelComment.trim();
        return this;
    }

    /**
     * 获取 发件人客户ID,与t_client.client_id 字段关联【{"max":13}】
     *
     * @return task_sender_client_id - 发件人客户ID,与t_client.client_id 字段关联【{"max":13}】
     */
    public Long getSenderClientId() {
        return senderClientId;
    }

    /**
     * 设置 发件人客户ID,与t_client.client_id 字段关联【{"max":13}】
     *
     * @param senderClientId - 发件人客户ID,与t_client.client_id 字段关联【{"max":13}】
     */
    public TaskBean setSenderClientId(Long senderClientId) {
        this.senderClientId = senderClientId;
        return this;
    }

    /**
     * 获取 发件人客户内部ID,与t_client.client_internal_id 字段冗余
     *
     * @return task_sender_client_internal_id - 发件人客户内部ID,与t_client.client_internal_id 字段冗余
     */
    public String getSenderClientInternalId() {
        return senderClientInternalId;
    }

    /**
     * 设置 发件人客户内部ID,与t_client.client_internal_id 字段冗余
     *
     * @param senderClientInternalId - 发件人客户内部ID,与t_client.client_internal_id 字段冗余
     */
    public TaskBean setSenderClientInternalId(String senderClientInternalId) {
        this.senderClientInternalId = senderClientInternalId == null ? null : senderClientInternalId.trim();
        return this;
    }

    /**
     * 获取 发件人名称,与t_task_contract.contract_sender_client_name,冗余
     *
     * @return task_sender_client_name - 发件人名称,与t_task_contract.contract_sender_client_name,冗余
     */
    public String getSenderClientName() {
        return senderClientName;
    }

    /**
     * 设置 发件人名称,与t_task_contract.contract_sender_client_name,冗余
     *
     * @param senderClientName - 发件人名称,与t_task_contract.contract_sender_client_name,冗余
     */
    public TaskBean setSenderClientName(String senderClientName) {
        this.senderClientName = senderClientName == null ? null : senderClientName.trim();
        return this;
    }

    /**
     * 获取 发件人网点id,与t_task_contract.contract_sender_branch_id,关联【{"max":13}】
     *
     * @return task_sender_branch_id - 发件人网点id,与t_task_contract.contract_sender_branch_id,关联【{"max":13}】
     */
    public Long getSenderBranchId() {
        return senderBranchId;
    }

    /**
     * 设置 发件人网点id,与t_task_contract.contract_sender_branch_id,关联【{"max":13}】
     *
     * @param senderBranchId - 发件人网点id,与t_task_contract.contract_sender_branch_id,关联【{"max":13}】
     */
    public TaskBean setSenderBranchId(Long senderBranchId) {
        this.senderBranchId = senderBranchId;
        return this;
    }

    /**
     * 获取 发件人网点内部ID,与t_client_branch.branch_internal_id 字段冗余
     *
     * @return task_sender_branch_internal_id - 发件人网点内部ID,与t_client_branch.branch_internal_id 字段冗余
     */
    public String getSenderBranchInternalId() {
        return senderBranchInternalId;
    }

    /**
     * 设置 发件人网点内部ID,与t_client_branch.branch_internal_id 字段冗余
     *
     * @param senderBranchInternalId - 发件人网点内部ID,与t_client_branch.branch_internal_id 字段冗余
     */
    public TaskBean setSenderBranchInternalId(String senderBranchInternalId) {
        this.senderBranchInternalId = senderBranchInternalId == null ? null : senderBranchInternalId.trim();
        return this;
    }

    /**
     * 获取 发件人网点名称,与t_client_branch.branch_name 字段冗余
     *
     * @return task_sender_branch_name - 发件人网点名称,与t_client_branch.branch_name 字段冗余
     */
    public String getSenderBranchName() {
        return senderBranchName;
    }

    /**
     * 设置 发件人网点名称,与t_client_branch.branch_name 字段冗余
     *
     * @param senderBranchName - 发件人网点名称,与t_client_branch.branch_name 字段冗余
     */
    public TaskBean setSenderBranchName(String senderBranchName) {
        this.senderBranchName = senderBranchName == null ? null : senderBranchName.trim();
        return this;
    }

    /**
     * 获取 发件人网点服务时间窗口开始时间,时间格式 hh:mm:ss,与t_task_contract.contract_sender_time_window_start,冗余
     *
     * @return task_sender_time_window_start - 发件人网点服务时间窗口开始时间,时间格式 hh:mm:ss,与t_task_contract.contract_sender_time_window_start,冗余
     */
    public String getSenderTimeWindowStart() {
        return senderTimeWindowStart;
    }

    /**
     * 设置 发件人网点服务时间窗口开始时间,时间格式 hh:mm:ss,与t_task_contract.contract_sender_time_window_start,冗余
     *
     * @param senderTimeWindowStart - 发件人网点服务时间窗口开始时间,时间格式 hh:mm:ss,与t_task_contract.contract_sender_time_window_start,冗余
     */
    public TaskBean setSenderTimeWindowStart(String senderTimeWindowStart) {
        this.senderTimeWindowStart = senderTimeWindowStart == null ? null : senderTimeWindowStart.trim();
        return this;
    }

    /**
     * 获取 发件人网点服务时间窗口结束时间,时间格式 hh:mm:ss,与t_task_contract.contract_sender_time_window_end,冗余
     *
     * @return task_sender_time_window_end - 发件人网点服务时间窗口结束时间,时间格式 hh:mm:ss,与t_task_contract.contract_sender_time_window_end,冗余
     */
    public String getSenderTimeWindowEnd() {
        return senderTimeWindowEnd;
    }

    /**
     * 设置 发件人网点服务时间窗口结束时间,时间格式 hh:mm:ss,与t_task_contract.contract_sender_time_window_end,冗余
     *
     * @param senderTimeWindowEnd - 发件人网点服务时间窗口结束时间,时间格式 hh:mm:ss,与t_task_contract.contract_sender_time_window_end,冗余
     */
    public TaskBean setSenderTimeWindowEnd(String senderTimeWindowEnd) {
        this.senderTimeWindowEnd = senderTimeWindowEnd == null ? null : senderTimeWindowEnd.trim();
        return this;
    }

    /**
     * 获取 发件人网点执行服务时长,单位分钟,与t_task_contract.contract_sender_time_window_duration,冗余
     *
     * @return task_sender_time_window_duration - 发件人网点执行服务时长,单位分钟,与t_task_contract.contract_sender_time_window_duration,冗余
     */
    public Integer getSenderTimeWindowDuration() {
        return senderTimeWindowDuration;
    }

    /**
     * 设置 发件人网点执行服务时长,单位分钟,与t_task_contract.contract_sender_time_window_duration,冗余
     *
     * @param senderTimeWindowDuration - 发件人网点执行服务时长,单位分钟,与t_task_contract.contract_sender_time_window_duration,冗余
     */
    public TaskBean setSenderTimeWindowDuration(Integer senderTimeWindowDuration) {
        this.senderTimeWindowDuration = senderTimeWindowDuration;
        return this;
    }

    /**
     * 获取 发件人网点联系电话,与t_client_branch.branch_phone,关联
     *
     * @return task_sender_branch_phone - 发件人网点联系电话,与t_client_branch.branch_phone,关联
     */
    public String getSenderBranchPhone() {
        return senderBranchPhone;
    }

    /**
     * 设置 发件人网点联系电话,与t_client_branch.branch_phone,关联
     *
     * @param senderBranchPhone - 发件人网点联系电话,与t_client_branch.branch_phone,关联
     */
    public TaskBean setSenderBranchPhone(String senderBranchPhone) {
        this.senderBranchPhone = senderBranchPhone == null ? null : senderBranchPhone.trim();
        return this;
    }

    /**
     * 获取 发件人网点地址,与t_client_branch.branch_address,关联
     *
     * @return task_sender_branch_address - 发件人网点地址,与t_client_branch.branch_address,关联
     */
    public String getSenderBranchAddress() {
        return senderBranchAddress;
    }

    /**
     * 设置 发件人网点地址,与t_client_branch.branch_address,关联
     *
     * @param senderBranchAddress - 发件人网点地址,与t_client_branch.branch_address,关联
     */
    public TaskBean setSenderBranchAddress(String senderBranchAddress) {
        this.senderBranchAddress = senderBranchAddress == null ? null : senderBranchAddress.trim();
        return this;
    }

    /**
     * 获取 发件人网点地址坐标纬度,浮点型,与t_client_branch.branch_latitude,关联
     *
     * @return task_sender_branch_latitude - 发件人网点地址坐标纬度,浮点型,与t_client_branch.branch_latitude,关联
     */
    public String getSenderBranchLatitude() {
        return senderBranchLatitude;
    }

    /**
     * 设置 发件人网点地址坐标纬度,浮点型,与t_client_branch.branch_latitude,关联
     *
     * @param senderBranchLatitude - 发件人网点地址坐标纬度,浮点型,与t_client_branch.branch_latitude,关联
     */
    public TaskBean setSenderBranchLatitude(String senderBranchLatitude) {
        this.senderBranchLatitude = senderBranchLatitude == null ? null : senderBranchLatitude.trim();
        return this;
    }

    /**
     * 获取 发件人网点地址坐标经度,浮点型,与t_client_branch.branch_longitude,关联
     *
     * @return task_sender_branch_longitude - 发件人网点地址坐标经度,浮点型,与t_client_branch.branch_longitude,关联
     */
    public String getSenderBranchLongitude() {
        return senderBranchLongitude;
    }

    /**
     * 设置 发件人网点地址坐标经度,浮点型,与t_client_branch.branch_longitude,关联
     *
     * @param senderBranchLongitude - 发件人网点地址坐标经度,浮点型,与t_client_branch.branch_longitude,关联
     */
    public TaskBean setSenderBranchLongitude(String senderBranchLongitude) {
        this.senderBranchLongitude = senderBranchLongitude == null ? null : senderBranchLongitude.trim();
        return this;
    }

    /**
     * 获取 收件人客户ID,与t_client.client_id 字段关联【{"max":13}】
     *
     * @return task_receiver_client_id - 收件人客户ID,与t_client.client_id 字段关联【{"max":13}】
     */
    public Long getReceiverClientId() {
        return receiverClientId;
    }

    /**
     * 设置 收件人客户ID,与t_client.client_id 字段关联【{"max":13}】
     *
     * @param receiverClientId - 收件人客户ID,与t_client.client_id 字段关联【{"max":13}】
     */
    public TaskBean setReceiverClientId(Long receiverClientId) {
        this.receiverClientId = receiverClientId;
        return this;
    }

    /**
     * 获取 收件人内部ID,与t_client.client_internal_id关联
     *
     * @return task_receiver_client_internal_id - 收件人内部ID,与t_client.client_internal_id关联
     */
    public String getReceiverClientInternalId() {
        return receiverClientInternalId;
    }

    /**
     * 设置 收件人内部ID,与t_client.client_internal_id关联
     *
     * @param receiverClientInternalId - 收件人内部ID,与t_client.client_internal_id关联
     */
    public TaskBean setReceiverClientInternalId(String receiverClientInternalId) {
        this.receiverClientInternalId = receiverClientInternalId == null ? null : receiverClientInternalId.trim();
        return this;
    }

    /**
     * 获取 收件人名称,与t_task_contract.contract_receiver_client_name,冗余
     *
     * @return task_receiver_client_name - 收件人名称,与t_task_contract.contract_receiver_client_name,冗余
     */
    public String getReceiverClientName() {
        return receiverClientName;
    }

    /**
     * 设置 收件人名称,与t_task_contract.contract_receiver_client_name,冗余
     *
     * @param receiverClientName - 收件人名称,与t_task_contract.contract_receiver_client_name,冗余
     */
    public TaskBean setReceiverClientName(String receiverClientName) {
        this.receiverClientName = receiverClientName == null ? null : receiverClientName.trim();
        return this;
    }

    /**
     * 获取 收件人网点id,与t_task_contract.contract_receiver_branch_id,关联【{"max":13}】
     *
     * @return task_receiver_branch_id - 收件人网点id,与t_task_contract.contract_receiver_branch_id,关联【{"max":13}】
     */
    public Long getReceiverBranchId() {
        return receiverBranchId;
    }

    /**
     * 设置 收件人网点id,与t_task_contract.contract_receiver_branch_id,关联【{"max":13}】
     *
     * @param receiverBranchId - 收件人网点id,与t_task_contract.contract_receiver_branch_id,关联【{"max":13}】
     */
    public TaskBean setReceiverBranchId(Long receiverBranchId) {
        this.receiverBranchId = receiverBranchId;
        return this;
    }

    /**
     * 获取 收件人网点内部ID,与t_client_branch.branch_internal_id 字段冗余
     *
     * @return task_receiver_branch_internal_id - 收件人网点内部ID,与t_client_branch.branch_internal_id 字段冗余
     */
    public String getReceiverBranchInternalId() {
        return receiverBranchInternalId;
    }

    /**
     * 设置 收件人网点内部ID,与t_client_branch.branch_internal_id 字段冗余
     *
     * @param receiverBranchInternalId - 收件人网点内部ID,与t_client_branch.branch_internal_id 字段冗余
     */
    public TaskBean setReceiverBranchInternalId(String receiverBranchInternalId) {
        this.receiverBranchInternalId = receiverBranchInternalId == null ? null : receiverBranchInternalId.trim();
        return this;
    }

    /**
     * 获取 收件人网点名称,与t_client_branch.branch_name 字段冗余
     *
     * @return task_receiver_branch_name - 收件人网点名称,与t_client_branch.branch_name 字段冗余
     */
    public String getReceiverBranchName() {
        return receiverBranchName;
    }

    /**
     * 设置 收件人网点名称,与t_client_branch.branch_name 字段冗余
     *
     * @param receiverBranchName - 收件人网点名称,与t_client_branch.branch_name 字段冗余
     */
    public TaskBean setReceiverBranchName(String receiverBranchName) {
        this.receiverBranchName = receiverBranchName == null ? null : receiverBranchName.trim();
        return this;
    }

    /**
     * 获取 收件人网点服务时间窗口开始时间,时间格式 hh:mm:ss,与t_task_contract.contract_receiver_time_window_start,冗余
     *
     * @return task_receiver_time_window_start - 收件人网点服务时间窗口开始时间,时间格式 hh:mm:ss,与t_task_contract.contract_receiver_time_window_start,冗余
     */
    public String getReceiverTimeWindowStart() {
        return receiverTimeWindowStart;
    }

    /**
     * 设置 收件人网点服务时间窗口开始时间,时间格式 hh:mm:ss,与t_task_contract.contract_receiver_time_window_start,冗余
     *
     * @param receiverTimeWindowStart - 收件人网点服务时间窗口开始时间,时间格式 hh:mm:ss,与t_task_contract.contract_receiver_time_window_start,冗余
     */
    public TaskBean setReceiverTimeWindowStart(String receiverTimeWindowStart) {
        this.receiverTimeWindowStart = receiverTimeWindowStart == null ? null : receiverTimeWindowStart.trim();
        return this;
    }

    /**
     * 获取 收件人网点服务时间窗口结束时间,时间格式 hh:mm:ss,与t_task_contract.contract_receiver_time_window_end,冗余
     *
     * @return task_receiver_time_window_end - 收件人网点服务时间窗口结束时间,时间格式 hh:mm:ss,与t_task_contract.contract_receiver_time_window_end,冗余
     */
    public String getReceiverTimeWindowEnd() {
        return receiverTimeWindowEnd;
    }

    /**
     * 设置 收件人网点服务时间窗口结束时间,时间格式 hh:mm:ss,与t_task_contract.contract_receiver_time_window_end,冗余
     *
     * @param receiverTimeWindowEnd - 收件人网点服务时间窗口结束时间,时间格式 hh:mm:ss,与t_task_contract.contract_receiver_time_window_end,冗余
     */
    public TaskBean setReceiverTimeWindowEnd(String receiverTimeWindowEnd) {
        this.receiverTimeWindowEnd = receiverTimeWindowEnd == null ? null : receiverTimeWindowEnd.trim();
        return this;
    }

    /**
     * 获取 收件人网点执行服务时长,单位分钟,与t_task_contract.contract_receiver_time_window_duration,冗余
     *
     * @return task_receiver_time_window_duration - 收件人网点执行服务时长,单位分钟,与t_task_contract.contract_receiver_time_window_duration,冗余
     */
    public Integer getReceiverTimeWindowDuration() {
        return receiverTimeWindowDuration;
    }

    /**
     * 设置 收件人网点执行服务时长,单位分钟,与t_task_contract.contract_receiver_time_window_duration,冗余
     *
     * @param receiverTimeWindowDuration - 收件人网点执行服务时长,单位分钟,与t_task_contract.contract_receiver_time_window_duration,冗余
     */
    public TaskBean setReceiverTimeWindowDuration(Integer receiverTimeWindowDuration) {
        this.receiverTimeWindowDuration = receiverTimeWindowDuration;
        return this;
    }

    /**
     * 获取 收件人网点联系电话,与t_client_branch.branch_phone,关联
     *
     * @return task_receiver_branch_phone - 收件人网点联系电话,与t_client_branch.branch_phone,关联
     */
    public String getReceiverBranchPhone() {
        return receiverBranchPhone;
    }

    /**
     * 设置 收件人网点联系电话,与t_client_branch.branch_phone,关联
     *
     * @param receiverBranchPhone - 收件人网点联系电话,与t_client_branch.branch_phone,关联
     */
    public TaskBean setReceiverBranchPhone(String receiverBranchPhone) {
        this.receiverBranchPhone = receiverBranchPhone == null ? null : receiverBranchPhone.trim();
        return this;
    }

    /**
     * 获取 收件人网点地址,与t_client_branch.branch_address,关联
     *
     * @return task_receiver_branch_address - 收件人网点地址,与t_client_branch.branch_address,关联
     */
    public String getReceiverBranchAddress() {
        return receiverBranchAddress;
    }

    /**
     * 设置 收件人网点地址,与t_client_branch.branch_address,关联
     *
     * @param receiverBranchAddress - 收件人网点地址,与t_client_branch.branch_address,关联
     */
    public TaskBean setReceiverBranchAddress(String receiverBranchAddress) {
        this.receiverBranchAddress = receiverBranchAddress == null ? null : receiverBranchAddress.trim();
        return this;
    }

    /**
     * 获取 收件人网点地址坐标纬度,浮点型,与t_client_branch.branch_latitude,关联
     *
     * @return task_receiver_branch_latitude - 收件人网点地址坐标纬度,浮点型,与t_client_branch.branch_latitude,关联
     */
    public String getReceiverBranchLatitude() {
        return receiverBranchLatitude;
    }

    /**
     * 设置 收件人网点地址坐标纬度,浮点型,与t_client_branch.branch_latitude,关联
     *
     * @param receiverBranchLatitude - 收件人网点地址坐标纬度,浮点型,与t_client_branch.branch_latitude,关联
     */
    public TaskBean setReceiverBranchLatitude(String receiverBranchLatitude) {
        this.receiverBranchLatitude = receiverBranchLatitude == null ? null : receiverBranchLatitude.trim();
        return this;
    }

    /**
     * 获取 收件人网点地址坐标经度,浮点型,与t_client_branch.branch_longitude,关联
     *
     * @return task_receiver_branch_longitude - 收件人网点地址坐标经度,浮点型,与t_client_branch.branch_longitude,关联
     */
    public String getReceiverBranchLongitude() {
        return receiverBranchLongitude;
    }

    /**
     * 设置 收件人网点地址坐标经度,浮点型,与t_client_branch.branch_longitude,关联
     *
     * @param receiverBranchLongitude - 收件人网点地址坐标经度,浮点型,与t_client_branch.branch_longitude,关联
     */
    public TaskBean setReceiverBranchLongitude(String receiverBranchLongitude) {
        this.receiverBranchLongitude = receiverBranchLongitude == null ? null : receiverBranchLongitude.trim();
        return this;
    }

    /**
     * 获取 车辆id,与t_vehicle关联【{"max":13}】
     *
     * @return task_vehicle_id - 车辆id,与t_vehicle关联【{"max":13}】
     */
    public Long getVehicleId() {
        return vehicleId;
    }

    /**
     * 设置 车辆id,与t_vehicle关联【{"max":13}】
     *
     * @param vehicleId - 车辆id,与t_vehicle关联【{"max":13}】
     */
    public TaskBean setVehicleId(Long vehicleId) {
        this.vehicleId = vehicleId;
        return this;
    }

    /**
     * 获取 与t_vehicle.vehicle_internal_id冗余4位数字的内部编号
     *
     * @return task_vehicle_internal_id - 与t_vehicle.vehicle_internal_id冗余4位数字的内部编号
     */
    public String getVehicleInternalId() {
        return vehicleInternalId;
    }

    /**
     * 设置 与t_vehicle.vehicle_internal_id冗余4位数字的内部编号
     *
     * @param vehicleInternalId - 与t_vehicle.vehicle_internal_id冗余4位数字的内部编号
     */
    public TaskBean setVehicleInternalId(String vehicleInternalId) {
        this.vehicleInternalId = vehicleInternalId == null ? null : vehicleInternalId.trim();
        return this;
    }

    /**
     * 获取 与t_vehicle.vehicle_tomtom_id 冗余,车辆实时数据外部标识
     *
     * @return task_vehicle_tomtom_id - 与t_vehicle.vehicle_tomtom_id 冗余,车辆实时数据外部标识
     */
    public String getVehicleTomtomId() {
        return vehicleTomtomId;
    }

    /**
     * 设置 与t_vehicle.vehicle_tomtom_id 冗余,车辆实时数据外部标识
     *
     * @param vehicleTomtomId - 与t_vehicle.vehicle_tomtom_id 冗余,车辆实时数据外部标识
     */
    public TaskBean setVehicleTomtomId(String vehicleTomtomId) {
        this.vehicleTomtomId = vehicleTomtomId == null ? null : vehicleTomtomId.trim();
        return this;
    }

    /**
     * 获取 与t_vehicle.vehicle_license冗余车牌号码
     *
     * @return task_vehicle_license - 与t_vehicle.vehicle_license冗余车牌号码
     */
    public String getVehicleLicense() {
        return vehicleLicense;
    }

    /**
     * 设置 与t_vehicle.vehicle_license冗余车牌号码
     *
     * @param vehicleLicense - 与t_vehicle.vehicle_license冗余车牌号码
     */
    public TaskBean setVehicleLicense(String vehicleLicense) {
        this.vehicleLicense = vehicleLicense == null ? null : vehicleLicense.trim();
        return this;
    }

    /**
     * 获取 与t_vehicle.vehicle_armored_level冗余武装等级:none,light,medium,heavy
     *
     * @return task_vehicle_armored_level - 与t_vehicle.vehicle_armored_level冗余武装等级:none,light,medium,heavy
     */
    public String getVehicleArmoredLevel() {
        return vehicleArmoredLevel;
    }

    /**
     * 设置 与t_vehicle.vehicle_armored_level冗余武装等级:none,light,medium,heavy
     *
     * @param vehicleArmoredLevel - 与t_vehicle.vehicle_armored_level冗余武装等级:none,light,medium,heavy
     */
    public TaskBean setVehicleArmoredLevel(String vehicleArmoredLevel) {
        this.vehicleArmoredLevel = vehicleArmoredLevel == null ? null : vehicleArmoredLevel.trim();
        return this;
    }

    /**
     * 获取 与t_vehicle.vehicle_service_type冗余
     *
     * @return task_vehicle_service_type - 与t_vehicle.vehicle_service_type冗余
     */
    public String getVehicleServiceType() {
        return vehicleServiceType;
    }

    /**
     * 设置 与t_vehicle.vehicle_service_type冗余
     *
     * @param vehicleServiceType - 与t_vehicle.vehicle_service_type冗余
     */
    public TaskBean setVehicleServiceType(String vehicleServiceType) {
        this.vehicleServiceType = vehicleServiceType == null ? null : vehicleServiceType.trim();
        return this;
    }

    /**
     * 获取 与t_vehicle.vehicle_model冗余汽车型号
     *
     * @return task_vehicle_model - 与t_vehicle.vehicle_model冗余汽车型号
     */
    public String getVehicleModel() {
        return vehicleModel;
    }

    /**
     * 设置 与t_vehicle.vehicle_model冗余汽车型号
     *
     * @param vehicleModel - 与t_vehicle.vehicle_model冗余汽车型号
     */
    public TaskBean setVehicleModel(String vehicleModel) {
        this.vehicleModel = vehicleModel == null ? null : vehicleModel.trim();
        return this;
    }

    /**
     * 获取 与t_vehicle.vehicle_vin冗余车辆识别代号,全宇宙唯一代号
     *
     * @return task_vehicle_vin - 与t_vehicle.vehicle_vin冗余车辆识别代号,全宇宙唯一代号
     */
    public String getVehicleVin() {
        return vehicleVin;
    }

    /**
     * 设置 与t_vehicle.vehicle_vin冗余车辆识别代号,全宇宙唯一代号
     *
     * @param vehicleVin - 与t_vehicle.vehicle_vin冗余车辆识别代号,全宇宙唯一代号
     */
    public TaskBean setVehicleVin(String vehicleVin) {
        this.vehicleVin = vehicleVin == null ? null : vehicleVin.trim();
        return this;
    }

    /**
     * 获取 与t_vehicle.vehicle_currency_capacity冗余,货币限定容量
     *
     * @return task_vehicle_currency_capacity - 与t_vehicle.vehicle_currency_capacity冗余,货币限定容量
     */
    public String getVehicleCurrencyCapacity() {
        return vehicleCurrencyCapacity;
    }

    /**
     * 设置 与t_vehicle.vehicle_currency_capacity冗余,货币限定容量
     *
     * @param vehicleCurrencyCapacity - 与t_vehicle.vehicle_currency_capacity冗余,货币限定容量
     */
    public TaskBean setVehicleCurrencyCapacity(String vehicleCurrencyCapacity) {
        this.vehicleCurrencyCapacity = vehicleCurrencyCapacity == null ? null : vehicleCurrencyCapacity.trim();
        return this;
    }

    /**
     * 获取 任务所需要的人数
     *
     * @return task_service_person_number - 任务所需要的人数
     */
    public Integer getServicePersonNumber() {
        return servicePersonNumber;
    }

    /**
     * 设置 任务所需要的人数
     *
     * @param servicePersonNumber - 任务所需要的人数
     */
    public TaskBean setServicePersonNumber(Integer servicePersonNumber) {
        this.servicePersonNumber = servicePersonNumber;
        return this;
    }

    /**
     * 获取 司机ID,与t_crew.crew_id冗余【{"max":13}】
     *
     * @return task_driver_id - 司机ID,与t_crew.crew_id冗余【{"max":13}】
     */
    public Long getDriverId() {
        return driverId;
    }

    /**
     * 设置 司机ID,与t_crew.crew_id冗余【{"max":13}】
     *
     * @param driverId - 司机ID,与t_crew.crew_id冗余【{"max":13}】
     */
    public TaskBean setDriverId(Long driverId) {
        this.driverId = driverId;
        return this;
    }

    /**
     * 获取 司机username,与t_crew.crew_username冗余
     *
     * @return task_driver_username - 司机username,与t_crew.crew_username冗余
     */
    public String getDriverUsername() {
        return driverUsername;
    }

    /**
     * 设置 司机username,与t_crew.crew_username冗余
     *
     * @param driverUsername - 司机username,与t_crew.crew_username冗余
     */
    public TaskBean setDriverUsername(String driverUsername) {
        this.driverUsername = driverUsername == null ? null : driverUsername.trim();
        return this;
    }

    /**
     * 获取 司机内部编号,与t_crew.crew_internal_id冗余
     *
     * @return task_driver_internal_id - 司机内部编号,与t_crew.crew_internal_id冗余
     */
    public String getDriverInternalId() {
        return driverInternalId;
    }

    /**
     * 设置 司机内部编号,与t_crew.crew_internal_id冗余
     *
     * @param driverInternalId - 司机内部编号,与t_crew.crew_internal_id冗余
     */
    public TaskBean setDriverInternalId(String driverInternalId) {
        this.driverInternalId = driverInternalId == null ? null : driverInternalId.trim();
        return this;
    }

    /**
     * 获取 司机名字,与t_crew.crew_first_name字段关联
     *
     * @return task_driver_first_name - 司机名字,与t_crew.crew_first_name字段关联
     */
    public String getDriverFirstName() {
        return driverFirstName;
    }

    /**
     * 设置 司机名字,与t_crew.crew_first_name字段关联
     *
     * @param driverFirstName - 司机名字,与t_crew.crew_first_name字段关联
     */
    public TaskBean setDriverFirstName(String driverFirstName) {
        this.driverFirstName = driverFirstName == null ? null : driverFirstName.trim();
        return this;
    }

    /**
     * 获取 司机姓氏,与t_crew.crew_last_name字段关联
     *
     * @return task_driver_last_name - 司机姓氏,与t_crew.crew_last_name字段关联
     */
    public String getDriverLastName() {
        return driverLastName;
    }

    /**
     * 设置 司机姓氏,与t_crew.crew_last_name字段关联
     *
     * @param driverLastName - 司机姓氏,与t_crew.crew_last_name字段关联
     */
    public TaskBean setDriverLastName(String driverLastName) {
        this.driverLastName = driverLastName == null ? null : driverLastName.trim();
        return this;
    }

    /**
     * 获取 司机电话,与t_crew.crew_phone字段关联
     *
     * @return task_driver_phone - 司机电话,与t_crew.crew_phone字段关联
     */
    public String getDriverPhone() {
        return driverPhone;
    }

    /**
     * 设置 司机电话,与t_crew.crew_phone字段关联
     *
     * @param driverPhone - 司机电话,与t_crew.crew_phone字段关联
     */
    public TaskBean setDriverPhone(String driverPhone) {
        this.driverPhone = driverPhone == null ? null : driverPhone.trim();
        return this;
    }

    /**
     * 获取 司机shift,与shift_week_start_date,对应【应在生成计划任务,根据人员安排时,设置值也要注意在变更路线时,设置值】
     *
     * @return task_driver_shift - 司机shift,与shift_week_start_date,对应【应在生成计划任务,根据人员安排时,设置值也要注意在变更路线时,设置值】
     */
    public String getDriverShift() {
        return driverShift;
    }

    /**
     * 设置 司机shift,与shift_week_start_date,对应【应在生成计划任务,根据人员安排时,设置值也要注意在变更路线时,设置值】
     *
     * @param driverShift - 司机shift,与shift_week_start_date,对应【应在生成计划任务,根据人员安排时,设置值也要注意在变更路线时,设置值】
     */
    public TaskBean setDriverShift(String driverShift) {
        this.driverShift = driverShift == null ? null : driverShift.trim();
        return this;
    }

    /**
     * 获取 出纳员ID,与t_crew.crew_id冗余【{"max":13}】
     *
     * @return task_cashier_id - 出纳员ID,与t_crew.crew_id冗余【{"max":13}】
     */
    public Long getCashierId() {
        return cashierId;
    }

    /**
     * 设置 出纳员ID,与t_crew.crew_id冗余【{"max":13}】
     *
     * @param cashierId - 出纳员ID,与t_crew.crew_id冗余【{"max":13}】
     */
    public TaskBean setCashierId(Long cashierId) {
        this.cashierId = cashierId;
        return this;
    }

    /**
     * 获取 收银员username,与t_crew.crew_username冗余
     *
     * @return task_cashier_username - 收银员username,与t_crew.crew_username冗余
     */
    public String getCashierUsername() {
        return cashierUsername;
    }

    /**
     * 设置 收银员username,与t_crew.crew_username冗余
     *
     * @param cashierUsername - 收银员username,与t_crew.crew_username冗余
     */
    public TaskBean setCashierUsername(String cashierUsername) {
        this.cashierUsername = cashierUsername == null ? null : cashierUsername.trim();
        return this;
    }

    /**
     * 获取 收银员内部编号,与t_crew.crew_internal_id冗余
     *
     * @return task_cashier_internal_id - 收银员内部编号,与t_crew.crew_internal_id冗余
     */
    public String getCashierInternalId() {
        return cashierInternalId;
    }

    /**
     * 设置 收银员内部编号,与t_crew.crew_internal_id冗余
     *
     * @param cashierInternalId - 收银员内部编号,与t_crew.crew_internal_id冗余
     */
    public TaskBean setCashierInternalId(String cashierInternalId) {
        this.cashierInternalId = cashierInternalId == null ? null : cashierInternalId.trim();
        return this;
    }

    /**
     * 获取 收银员名字,与t_crew.crew_first_name字段关联
     *
     * @return task_cashier_first_name - 收银员名字,与t_crew.crew_first_name字段关联
     */
    public String getCashierFirstName() {
        return cashierFirstName;
    }

    /**
     * 设置 收银员名字,与t_crew.crew_first_name字段关联
     *
     * @param cashierFirstName - 收银员名字,与t_crew.crew_first_name字段关联
     */
    public TaskBean setCashierFirstName(String cashierFirstName) {
        this.cashierFirstName = cashierFirstName == null ? null : cashierFirstName.trim();
        return this;
    }

    /**
     * 获取 收银员姓氏,与t_crew.crew_last_name字段关联
     *
     * @return task_cashier_last_name - 收银员姓氏,与t_crew.crew_last_name字段关联
     */
    public String getCashierLastName() {
        return cashierLastName;
    }

    /**
     * 设置 收银员姓氏,与t_crew.crew_last_name字段关联
     *
     * @param cashierLastName - 收银员姓氏,与t_crew.crew_last_name字段关联
     */
    public TaskBean setCashierLastName(String cashierLastName) {
        this.cashierLastName = cashierLastName == null ? null : cashierLastName.trim();
        return this;
    }

    /**
     * 获取 收银员电话,与t_crew.crew_phone字段关联
     *
     * @return task_cashier_phone - 收银员电话,与t_crew.crew_phone字段关联
     */
    public String getCashierPhone() {
        return cashierPhone;
    }

    /**
     * 设置 收银员电话,与t_crew.crew_phone字段关联
     *
     * @param cashierPhone - 收银员电话,与t_crew.crew_phone字段关联
     */
    public TaskBean setCashierPhone(String cashierPhone) {
        this.cashierPhone = cashierPhone == null ? null : cashierPhone.trim();
        return this;
    }

    /**
     * 获取 收银员班次,与shift_week_start_date,对应;【应在生成计划任务,根据人员安排时,设置值也要注意在变更路线时,设置值】
     *
     * @return task_cashier_shift - 收银员班次,与shift_week_start_date,对应;【应在生成计划任务,根据人员安排时,设置值也要注意在变更路线时,设置值】
     */
    public String getCashierShift() {
        return cashierShift;
    }

    /**
     * 设置 收银员班次,与shift_week_start_date,对应;【应在生成计划任务,根据人员安排时,设置值也要注意在变更路线时,设置值】
     *
     * @param cashierShift - 收银员班次,与shift_week_start_date,对应;【应在生成计划任务,根据人员安排时,设置值也要注意在变更路线时,设置值】
     */
    public TaskBean setCashierShift(String cashierShift) {
        this.cashierShift = cashierShift == null ? null : cashierShift.trim();
        return this;
    }

    /**
     * 获取 收银员passCode密码(员工登陆密码),MD5加密之后取前8位+登陆密码加盐,与t_user.user_pass_code【该分支机构下,所有拥有nip密码的,JSON对象 {"passCode":"4c2bf06d","passSalt":"_random_"}】
     *
     * @return task_cashier_pass_code - 收银员passCode密码(员工登陆密码),MD5加密之后取前8位+登陆密码加盐,与t_user.user_pass_code【该分支机构下,所有拥有nip密码的,JSON对象 {"passCode":"4c2bf06d","passSalt":"_random_"}】
     */
    public String getCashierPassCode() {
        return cashierPassCode;
    }

    /**
     * 设置 收银员passCode密码(员工登陆密码),MD5加密之后取前8位+登陆密码加盐,与t_user.user_pass_code【该分支机构下,所有拥有nip密码的,JSON对象 {"passCode":"4c2bf06d","passSalt":"_random_"}】
     *
     * @param cashierPassCode - 收银员passCode密码(员工登陆密码),MD5加密之后取前8位+登陆密码加盐,与t_user.user_pass_code【该分支机构下,所有拥有nip密码的,JSON对象 {"passCode":"4c2bf06d","passSalt":"_random_"}】
     */
    public TaskBean setCashierPassCode(String cashierPassCode) {
        this.cashierPassCode = cashierPassCode == null ? null : cashierPassCode.trim();
        return this;
    }

    /**
     * 获取 保镖1ID,与t_crew.crew_id冗余【{"max":13}】
     *
     * @return task_security1_id - 保镖1ID,与t_crew.crew_id冗余【{"max":13}】
     */
    public Long getSecurity1Id() {
        return security1Id;
    }

    /**
     * 设置 保镖1ID,与t_crew.crew_id冗余【{"max":13}】
     *
     * @param security1Id - 保镖1ID,与t_crew.crew_id冗余【{"max":13}】
     */
    public TaskBean setSecurity1Id(Long security1Id) {
        this.security1Id = security1Id;
        return this;
    }

    /**
     * 获取 保镖1username,与t_crew.crew_username冗余
     *
     * @return task_security1_username - 保镖1username,与t_crew.crew_username冗余
     */
    public String getSecurity1Username() {
        return security1Username;
    }

    /**
     * 设置 保镖1username,与t_crew.crew_username冗余
     *
     * @param security1Username - 保镖1username,与t_crew.crew_username冗余
     */
    public TaskBean setSecurity1Username(String security1Username) {
        this.security1Username = security1Username == null ? null : security1Username.trim();
        return this;
    }

    /**
     * 获取 保镖1内部编号,与t_crew.crew_internal_id冗余
     *
     * @return task_security1_internal_id - 保镖1内部编号,与t_crew.crew_internal_id冗余
     */
    public String getSecurity1InternalId() {
        return security1InternalId;
    }

    /**
     * 设置 保镖1内部编号,与t_crew.crew_internal_id冗余
     *
     * @param security1InternalId - 保镖1内部编号,与t_crew.crew_internal_id冗余
     */
    public TaskBean setSecurity1InternalId(String security1InternalId) {
        this.security1InternalId = security1InternalId == null ? null : security1InternalId.trim();
        return this;
    }

    /**
     * 获取 保镖1名字,与t_crew.crew_first_name字段关联
     *
     * @return task_security1_first_name - 保镖1名字,与t_crew.crew_first_name字段关联
     */
    public String getSecurity1FirstName() {
        return security1FirstName;
    }

    /**
     * 设置 保镖1名字,与t_crew.crew_first_name字段关联
     *
     * @param security1FirstName - 保镖1名字,与t_crew.crew_first_name字段关联
     */
    public TaskBean setSecurity1FirstName(String security1FirstName) {
        this.security1FirstName = security1FirstName == null ? null : security1FirstName.trim();
        return this;
    }

    /**
     * 获取 保镖1姓氏,与t_crew.crew_last_name字段关联
     *
     * @return task_security1_last_name - 保镖1姓氏,与t_crew.crew_last_name字段关联
     */
    public String getSecurity1LastName() {
        return security1LastName;
    }

    /**
     * 设置 保镖1姓氏,与t_crew.crew_last_name字段关联
     *
     * @param security1LastName - 保镖1姓氏,与t_crew.crew_last_name字段关联
     */
    public TaskBean setSecurity1LastName(String security1LastName) {
        this.security1LastName = security1LastName == null ? null : security1LastName.trim();
        return this;
    }

    /**
     * 获取 保镖1电话,与t_crew.crew_phone字段关联
     *
     * @return task_security1_phone - 保镖1电话,与t_crew.crew_phone字段关联
     */
    public String getSecurity1Phone() {
        return security1Phone;
    }

    /**
     * 设置 保镖1电话,与t_crew.crew_phone字段关联
     *
     * @param security1Phone - 保镖1电话,与t_crew.crew_phone字段关联
     */
    public TaskBean setSecurity1Phone(String security1Phone) {
        this.security1Phone = security1Phone == null ? null : security1Phone.trim();
        return this;
    }

    /**
     * 获取 保镖1班次,与shift_week_start_date,对应;【应在生成计划任务,根据人员安排时,设置值也要注意在变更路线时,设置值】
     *
     * @return task_security1_shift - 保镖1班次,与shift_week_start_date,对应;【应在生成计划任务,根据人员安排时,设置值也要注意在变更路线时,设置值】
     */
    public String getSecurity1Shift() {
        return security1Shift;
    }

    /**
     * 设置 保镖1班次,与shift_week_start_date,对应;【应在生成计划任务,根据人员安排时,设置值也要注意在变更路线时,设置值】
     *
     * @param security1Shift - 保镖1班次,与shift_week_start_date,对应;【应在生成计划任务,根据人员安排时,设置值也要注意在变更路线时,设置值】
     */
    public TaskBean setSecurity1Shift(String security1Shift) {
        this.security1Shift = security1Shift == null ? null : security1Shift.trim();
        return this;
    }

    /**
     * 获取 保镖2ID,与t_crew.crew_id冗余【{"max":13}】
     *
     * @return task_security2_id - 保镖2ID,与t_crew.crew_id冗余【{"max":13}】
     */
    public Long getSecurity2Id() {
        return security2Id;
    }

    /**
     * 设置 保镖2ID,与t_crew.crew_id冗余【{"max":13}】
     *
     * @param security2Id - 保镖2ID,与t_crew.crew_id冗余【{"max":13}】
     */
    public TaskBean setSecurity2Id(Long security2Id) {
        this.security2Id = security2Id;
        return this;
    }

    /**
     * 获取 保镖2username,与t_crew.crew_username冗余
     *
     * @return task_security2_username - 保镖2username,与t_crew.crew_username冗余
     */
    public String getSecurity2Username() {
        return security2Username;
    }

    /**
     * 设置 保镖2username,与t_crew.crew_username冗余
     *
     * @param security2Username - 保镖2username,与t_crew.crew_username冗余
     */
    public TaskBean setSecurity2Username(String security2Username) {
        this.security2Username = security2Username == null ? null : security2Username.trim();
        return this;
    }

    /**
     * 获取 保镖2内部编号,与t_crew.crew_internal_id冗余
     *
     * @return task_security2_internal_id - 保镖2内部编号,与t_crew.crew_internal_id冗余
     */
    public String getSecurity2InternalId() {
        return security2InternalId;
    }

    /**
     * 设置 保镖2内部编号,与t_crew.crew_internal_id冗余
     *
     * @param security2InternalId - 保镖2内部编号,与t_crew.crew_internal_id冗余
     */
    public TaskBean setSecurity2InternalId(String security2InternalId) {
        this.security2InternalId = security2InternalId == null ? null : security2InternalId.trim();
        return this;
    }

    /**
     * 获取 保镖2名字,与t_crew.crew_first_name字段关联
     *
     * @return task_security2_first_name - 保镖2名字,与t_crew.crew_first_name字段关联
     */
    public String getSecurity2FirstName() {
        return security2FirstName;
    }

    /**
     * 设置 保镖2名字,与t_crew.crew_first_name字段关联
     *
     * @param security2FirstName - 保镖2名字,与t_crew.crew_first_name字段关联
     */
    public TaskBean setSecurity2FirstName(String security2FirstName) {
        this.security2FirstName = security2FirstName == null ? null : security2FirstName.trim();
        return this;
    }

    /**
     * 获取 保镖2姓氏,与t_crew.crew_last_name字段关联
     *
     * @return task_security2_last_name - 保镖2姓氏,与t_crew.crew_last_name字段关联
     */
    public String getSecurity2LastName() {
        return security2LastName;
    }

    /**
     * 设置 保镖2姓氏,与t_crew.crew_last_name字段关联
     *
     * @param security2LastName - 保镖2姓氏,与t_crew.crew_last_name字段关联
     */
    public TaskBean setSecurity2LastName(String security2LastName) {
        this.security2LastName = security2LastName == null ? null : security2LastName.trim();
        return this;
    }

    /**
     * 获取 保镖2电话,与t_crew.crew_phone字段关联
     *
     * @return task_security2_phone - 保镖2电话,与t_crew.crew_phone字段关联
     */
    public String getSecurity2Phone() {
        return security2Phone;
    }

    /**
     * 设置 保镖2电话,与t_crew.crew_phone字段关联
     *
     * @param security2Phone - 保镖2电话,与t_crew.crew_phone字段关联
     */
    public TaskBean setSecurity2Phone(String security2Phone) {
        this.security2Phone = security2Phone == null ? null : security2Phone.trim();
        return this;
    }

    /**
     * 获取 保镖2班次,与shift_week_start_date,对应;【应在生成计划任务,根据人员安排时,设置值也要注意在变更路线时,设置值】
     *
     * @return task_security2_shift - 保镖2班次,与shift_week_start_date,对应;【应在生成计划任务,根据人员安排时,设置值也要注意在变更路线时,设置值】
     */
    public String getSecurity2Shift() {
        return security2Shift;
    }

    /**
     * 设置 保镖2班次,与shift_week_start_date,对应;【应在生成计划任务,根据人员安排时,设置值也要注意在变更路线时,设置值】
     *
     * @param security2Shift - 保镖2班次,与shift_week_start_date,对应;【应在生成计划任务,根据人员安排时,设置值也要注意在变更路线时,设置值】
     */
    public TaskBean setSecurity2Shift(String security2Shift) {
        this.security2Shift = security2Shift == null ? null : security2Shift.trim();
        return this;
    }

    /**
     * 获取 保镖3ID,与t_crew.crew_id冗余【{"max":13}】
     *
     * @return task_security3_id - 保镖3ID,与t_crew.crew_id冗余【{"max":13}】
     */
    public Long getSecurity3Id() {
        return security3Id;
    }

    /**
     * 设置 保镖3ID,与t_crew.crew_id冗余【{"max":13}】
     *
     * @param security3Id - 保镖3ID,与t_crew.crew_id冗余【{"max":13}】
     */
    public TaskBean setSecurity3Id(Long security3Id) {
        this.security3Id = security3Id;
        return this;
    }

    /**
     * 获取 保镖3username,与t_crew.crew_username冗余
     *
     * @return task_security3_username - 保镖3username,与t_crew.crew_username冗余
     */
    public String getSecurity3Username() {
        return security3Username;
    }

    /**
     * 设置 保镖3username,与t_crew.crew_username冗余
     *
     * @param security3Username - 保镖3username,与t_crew.crew_username冗余
     */
    public TaskBean setSecurity3Username(String security3Username) {
        this.security3Username = security3Username == null ? null : security3Username.trim();
        return this;
    }

    /**
     * 获取 保镖3内部编号,与t_crew.crew_internal_id冗余
     *
     * @return task_security3_internal_id - 保镖3内部编号,与t_crew.crew_internal_id冗余
     */
    public String getSecurity3InternalId() {
        return security3InternalId;
    }

    /**
     * 设置 保镖3内部编号,与t_crew.crew_internal_id冗余
     *
     * @param security3InternalId - 保镖3内部编号,与t_crew.crew_internal_id冗余
     */
    public TaskBean setSecurity3InternalId(String security3InternalId) {
        this.security3InternalId = security3InternalId == null ? null : security3InternalId.trim();
        return this;
    }

    /**
     * 获取 保镖3名字,与t_crew.crew_first_name字段关联
     *
     * @return task_security3_first_name - 保镖3名字,与t_crew.crew_first_name字段关联
     */
    public String getSecurity3FirstName() {
        return security3FirstName;
    }

    /**
     * 设置 保镖3名字,与t_crew.crew_first_name字段关联
     *
     * @param security3FirstName - 保镖3名字,与t_crew.crew_first_name字段关联
     */
    public TaskBean setSecurity3FirstName(String security3FirstName) {
        this.security3FirstName = security3FirstName == null ? null : security3FirstName.trim();
        return this;
    }

    /**
     * 获取 保镖3姓氏,与t_crew.crew_last_name字段关联
     *
     * @return task_security3_last_name - 保镖3姓氏,与t_crew.crew_last_name字段关联
     */
    public String getSecurity3LastName() {
        return security3LastName;
    }

    /**
     * 设置 保镖3姓氏,与t_crew.crew_last_name字段关联
     *
     * @param security3LastName - 保镖3姓氏,与t_crew.crew_last_name字段关联
     */
    public TaskBean setSecurity3LastName(String security3LastName) {
        this.security3LastName = security3LastName == null ? null : security3LastName.trim();
        return this;
    }

    /**
     * 获取 保镖3电话,与t_crew.crew_phone字段关联
     *
     * @return task_security3_phone - 保镖3电话,与t_crew.crew_phone字段关联
     */
    public String getSecurity3Phone() {
        return security3Phone;
    }

    /**
     * 设置 保镖3电话,与t_crew.crew_phone字段关联
     *
     * @param security3Phone - 保镖3电话,与t_crew.crew_phone字段关联
     */
    public TaskBean setSecurity3Phone(String security3Phone) {
        this.security3Phone = security3Phone == null ? null : security3Phone.trim();
        return this;
    }

    /**
     * 获取 保镖3班次,与shift_week_start_date,对应;【应在生成计划任务,根据人员安排时,设置值也要注意在变更路线时,设置值】
     *
     * @return task_security3_shift - 保镖3班次,与shift_week_start_date,对应;【应在生成计划任务,根据人员安排时,设置值也要注意在变更路线时,设置值】
     */
    public String getSecurity3Shift() {
        return security3Shift;
    }

    /**
     * 设置 保镖3班次,与shift_week_start_date,对应;【应在生成计划任务,根据人员安排时,设置值也要注意在变更路线时,设置值】
     *
     * @param security3Shift - 保镖3班次,与shift_week_start_date,对应;【应在生成计划任务,根据人员安排时,设置值也要注意在变更路线时,设置值】
     */
    public TaskBean setSecurity3Shift(String security3Shift) {
        this.security3Shift = security3Shift == null ? null : security3Shift.trim();
        return this;
    }

    /**
     * 获取 保镖4ID,与t_crew.crew_id冗余【{"max":13}】
     *
     * @return task_security4_id - 保镖4ID,与t_crew.crew_id冗余【{"max":13}】
     */
    public Long getSecurity4Id() {
        return security4Id;
    }

    /**
     * 设置 保镖4ID,与t_crew.crew_id冗余【{"max":13}】
     *
     * @param security4Id - 保镖4ID,与t_crew.crew_id冗余【{"max":13}】
     */
    public TaskBean setSecurity4Id(Long security4Id) {
        this.security4Id = security4Id;
        return this;
    }

    /**
     * 获取 保镖4username,与t_crew.crew_username冗余
     *
     * @return task_security4_username - 保镖4username,与t_crew.crew_username冗余
     */
    public String getSecurity4Username() {
        return security4Username;
    }

    /**
     * 设置 保镖4username,与t_crew.crew_username冗余
     *
     * @param security4Username - 保镖4username,与t_crew.crew_username冗余
     */
    public TaskBean setSecurity4Username(String security4Username) {
        this.security4Username = security4Username == null ? null : security4Username.trim();
        return this;
    }

    /**
     * 获取 保镖4内部编号,与t_crew.crew_internal_id冗余
     *
     * @return task_security4_internal_id - 保镖4内部编号,与t_crew.crew_internal_id冗余
     */
    public String getSecurity4InternalId() {
        return security4InternalId;
    }

    /**
     * 设置 保镖4内部编号,与t_crew.crew_internal_id冗余
     *
     * @param security4InternalId - 保镖4内部编号,与t_crew.crew_internal_id冗余
     */
    public TaskBean setSecurity4InternalId(String security4InternalId) {
        this.security4InternalId = security4InternalId == null ? null : security4InternalId.trim();
        return this;
    }

    /**
     * 获取 保镖4名字,与t_crew.crew_first_name字段关联
     *
     * @return task_security4_first_name - 保镖4名字,与t_crew.crew_first_name字段关联
     */
    public String getSecurity4FirstName() {
        return security4FirstName;
    }

    /**
     * 设置 保镖4名字,与t_crew.crew_first_name字段关联
     *
     * @param security4FirstName - 保镖4名字,与t_crew.crew_first_name字段关联
     */
    public TaskBean setSecurity4FirstName(String security4FirstName) {
        this.security4FirstName = security4FirstName == null ? null : security4FirstName.trim();
        return this;
    }

    /**
     * 获取 保镖4姓氏,与t_crew.crew_last_name字段关联
     *
     * @return task_security4_last_name - 保镖4姓氏,与t_crew.crew_last_name字段关联
     */
    public String getSecurity4LastName() {
        return security4LastName;
    }

    /**
     * 设置 保镖4姓氏,与t_crew.crew_last_name字段关联
     *
     * @param security4LastName - 保镖4姓氏,与t_crew.crew_last_name字段关联
     */
    public TaskBean setSecurity4LastName(String security4LastName) {
        this.security4LastName = security4LastName == null ? null : security4LastName.trim();
        return this;
    }

    /**
     * 获取 保镖4电话,与t_crew.crew_phone字段关联
     *
     * @return task_security4_phone - 保镖4电话,与t_crew.crew_phone字段关联
     */
    public String getSecurity4Phone() {
        return security4Phone;
    }

    /**
     * 设置 保镖4电话,与t_crew.crew_phone字段关联
     *
     * @param security4Phone - 保镖4电话,与t_crew.crew_phone字段关联
     */
    public TaskBean setSecurity4Phone(String security4Phone) {
        this.security4Phone = security4Phone == null ? null : security4Phone.trim();
        return this;
    }

    /**
     * 获取 保镖4班次,与shift_week_start_date,对应;【应在生成计划任务,根据人员安排时,设置值也要注意在变更路线时,设置值】
     *
     * @return task_security4_shift - 保镖4班次,与shift_week_start_date,对应;【应在生成计划任务,根据人员安排时,设置值也要注意在变更路线时,设置值】
     */
    public String getSecurity4Shift() {
        return security4Shift;
    }

    /**
     * 设置 保镖4班次,与shift_week_start_date,对应;【应在生成计划任务,根据人员安排时,设置值也要注意在变更路线时,设置值】
     *
     * @param security4Shift - 保镖4班次,与shift_week_start_date,对应;【应在生成计划任务,根据人员安排时,设置值也要注意在变更路线时,设置值】
     */
    public TaskBean setSecurity4Shift(String security4Shift) {
        this.security4Shift = security4Shift == null ? null : security4Shift.trim();
        return this;
    }

    /**
     * 获取 nip客户负责人确认签收密码6位,MD5加密之后取前8位,与t_user.user_pass_code【该分支机构下,所有拥有nip密码的,JSON对象[{username:a1,passCode:123456},{username:a2,passCode:654321}]】
     *
     * @return task_nip_username_pass_code - nip客户负责人确认签收密码6位,MD5加密之后取前8位,与t_user.user_pass_code【该分支机构下,所有拥有nip密码的,JSON对象[{username:a1,passCode:123456},{username:a2,passCode:654321}]】
     */
    public String getNipUsernamePassCode() {
        return nipUsernamePassCode;
    }

    /**
     * 设置 nip客户负责人确认签收密码6位,MD5加密之后取前8位,与t_user.user_pass_code【该分支机构下,所有拥有nip密码的,JSON对象[{username:a1,passCode:123456},{username:a2,passCode:654321}]】
     *
     * @param nipUsernamePassCode - nip客户负责人确认签收密码6位,MD5加密之后取前8位,与t_user.user_pass_code【该分支机构下,所有拥有nip密码的,JSON对象[{username:a1,passCode:123456},{username:a2,passCode:654321}]】
     */
    public TaskBean setNipUsernamePassCode(String nipUsernamePassCode) {
        this.nipUsernamePassCode = nipUsernamePassCode == null ? null : nipUsernamePassCode.trim();
        return this;
    }

    /**
     * 获取 nip客户负责人username,在客户负责人与司机进行交接时,确认签收人的username
     *
     * @return task_nip_confirm_username - nip客户负责人username,在客户负责人与司机进行交接时,确认签收人的username
     */
    public String getNipConfirmUsername() {
        return nipConfirmUsername;
    }

    /**
     * 设置 nip客户负责人username,在客户负责人与司机进行交接时,确认签收人的username
     *
     * @param nipConfirmUsername - nip客户负责人username,在客户负责人与司机进行交接时,确认签收人的username
     */
    public TaskBean setNipConfirmUsername(String nipConfirmUsername) {
        this.nipConfirmUsername = nipConfirmUsername == null ? null : nipConfirmUsername.trim();
        return this;
    }

    /**
     * 获取 服务种类【WORKDAY[工作日], HOLIDAY[节假日], SATURDAY[周六], SUNDAY[周日]】,与t_task_contract.contract_service_line,关联
     *
     * @return task_service_line - 服务种类【WORKDAY[工作日], HOLIDAY[节假日], SATURDAY[周六], SUNDAY[周日]】,与t_task_contract.contract_service_line,关联
     */
    public String getServiceLine() {
        return serviceLine;
    }

    /**
     * 设置 服务种类【WORKDAY[工作日], HOLIDAY[节假日], SATURDAY[周六], SUNDAY[周日]】,与t_task_contract.contract_service_line,关联
     *
     * @param serviceLine - 服务种类【WORKDAY[工作日], HOLIDAY[节假日], SATURDAY[周六], SUNDAY[周日]】,与t_task_contract.contract_service_line,关联
     */
    public TaskBean setServiceLine(String serviceLine) {
        this.serviceLine = serviceLine == null ? null : serviceLine.trim();
        return this;
    }

    /**
     * 获取 班次类型【M[早班Morning]6am-1pm[06:00-13:00], A[中班Afternoon]2pm-6pm[14:00-18:00], N[晚班Night]6pm-12am[18:00-23:59], V[休假Vacations]】,以司机班次为任务班次,当前业务逻辑需求2016-08-22
     *
     * @return task_shift - 班次类型【M[早班Morning]6am-1pm[06:00-13:00], A[中班Afternoon]2pm-6pm[14:00-18:00], N[晚班Night]6pm-12am[18:00-23:59], V[休假Vacations]】,以司机班次为任务班次,当前业务逻辑需求2016-08-22
     */
    public String getShift() {
        return shift;
    }

    /**
     * 设置 班次类型【M[早班Morning]6am-1pm[06:00-13:00], A[中班Afternoon]2pm-6pm[14:00-18:00], N[晚班Night]6pm-12am[18:00-23:59], V[休假Vacations]】,以司机班次为任务班次,当前业务逻辑需求2016-08-22
     *
     * @param shift - 班次类型【M[早班Morning]6am-1pm[06:00-13:00], A[中班Afternoon]2pm-6pm[14:00-18:00], N[晚班Night]6pm-12am[18:00-23:59], V[休假Vacations]】,以司机班次为任务班次,当前业务逻辑需求2016-08-22
     */
    public TaskBean setShift(String shift) {
        this.shift = shift == null ? null : shift.trim();
        return this;
    }

    /**
     * 获取 武装等级【NONE[无], LIGHT[一般], MEDIUM[中等], HEAVY[重型]】,与t_task_contract.contract_armored_level,关联
     *
     * @return task_armored_level - 武装等级【NONE[无], LIGHT[一般], MEDIUM[中等], HEAVY[重型]】,与t_task_contract.contract_armored_level,关联
     */
    public String getArmoredLevel() {
        return armoredLevel;
    }

    /**
     * 设置 武装等级【NONE[无], LIGHT[一般], MEDIUM[中等], HEAVY[重型]】,与t_task_contract.contract_armored_level,关联
     *
     * @param armoredLevel - 武装等级【NONE[无], LIGHT[一般], MEDIUM[中等], HEAVY[重型]】,与t_task_contract.contract_armored_level,关联
     */
    public TaskBean setArmoredLevel(String armoredLevel) {
        this.armoredLevel = armoredLevel == null ? null : armoredLevel.trim();
        return this;
    }

    /**
     * 获取 创建时间
     *
     * @return task_create_timestamp - 创建时间
     */
    public Date getCreateTimestamp() {
        return createTimestamp;
    }

    /**
     * 设置 创建时间
     *
     * @param createTimestamp - 创建时间
     */
    public TaskBean setCreateTimestamp(Date createTimestamp) {
        this.createTimestamp = createTimestamp;
        return this;
    }

    /**
     *
     * @return task_update_timestamp
     */
    public Date getUpdateTimestamp() {
        return updateTimestamp;
    }

    /**
     *
     * @param updateTimestamp - 
     */
    public TaskBean setUpdateTimestamp(Date updateTimestamp) {
        this.updateTimestamp = updateTimestamp;
        return this;
    }

    /**
     * 获取 谁新增了该员工,与crew_username字段关联 若为系统生成创建者为:SYSTEM
     *
     * @return task_create_by - 谁新增了该员工,与crew_username字段关联 若为系统生成创建者为:SYSTEM
     */
    public String getCreateBy() {
        return createBy;
    }

    /**
     * 设置 谁新增了该员工,与crew_username字段关联 若为系统生成创建者为:SYSTEM
     *
     * @param createBy - 谁新增了该员工,与crew_username字段关联 若为系统生成创建者为:SYSTEM
     */
    public TaskBean setCreateBy(String createBy) {
        this.createBy = createBy == null ? null : createBy.trim();
        return this;
    }

    /**
     * 获取 逻辑删除标志【N[正常]，Y[删除]】
     *
     * @return task_delete_flag - 逻辑删除标志【N[正常]，Y[删除]】
     */
    public String getDeleteFlag() {
        return deleteFlag;
    }

    /**
     * 设置 逻辑删除标志【N[正常]，Y[删除]】
     *
     * @param deleteFlag - 逻辑删除标志【N[正常]，Y[删除]】
     */
    public TaskBean setDeleteFlag(String deleteFlag) {
        this.deleteFlag = deleteFlag == null ? null : deleteFlag.trim();
        return this;
    }

    /**
     * 获取 ATM外部编号,在调用第三方接口里的唯一标识
     *
     * @return task_atm_external_id - ATM外部编号,在调用第三方接口里的唯一标识
     */
    public String getAtmExternalId() {
        return atmExternalId;
    }

    /**
     * 设置 ATM外部编号,在调用第三方接口里的唯一标识
     *
     * @param atmExternalId - ATM外部编号,在调用第三方接口里的唯一标识
     */
    public TaskBean setAtmExternalId(String atmExternalId) {
        this.atmExternalId = atmExternalId == null ? null : atmExternalId.trim();
        return this;
    }

    /**
     * 获取 任务预设截止日期,目前ATM修复任务类型任务时才有该字段信息
     *
     * @return task_deadline - 任务预设截止日期,目前ATM修复任务类型任务时才有该字段信息
     */
    public String getDeadline() {
        return deadline;
    }

    /**
     * 设置 任务预设截止日期,目前ATM修复任务类型任务时才有该字段信息
     *
     * @param deadline - 任务预设截止日期,目前ATM修复任务类型任务时才有该字段信息
     */
    public TaskBean setDeadline(String deadline) {
        this.deadline = deadline == null ? null : deadline.trim();
        return this;
    }

    /**
     * 获取 任务完成结果描述
     *
     * @return task_description - 任务完成结果描述
     */
    public String getDescription() {
        return description;
    }

    /**
     * 设置 任务完成结果描述
     *
     * @param description - 任务完成结果描述
     */
    public TaskBean setDescription(String description) {
        this.description = description == null ? null : description.trim();
        return this;
    }

    /**
     * 获取 任务来源哪一方生成的任务【SIO公司导入进来分两种：[SIO_0_KIOSKOLIN、SIO_1_COMODIN]，COMODIN[comodin手工创建]，EXCEL[excel批量导入]】
     *
     * @return task_generate_source_party - 任务来源哪一方生成的任务【SIO公司导入进来分两种：[SIO_0_KIOSKOLIN、SIO_1_COMODIN]，COMODIN[comodin手工创建]，EXCEL[excel批量导入]】
     */
    public String getGenerateSourceParty() {
        return generateSourceParty;
    }

    /**
     * 设置 任务来源哪一方生成的任务【SIO公司导入进来分两种：[SIO_0_KIOSKOLIN、SIO_1_COMODIN]，COMODIN[comodin手工创建]，EXCEL[excel批量导入]】
     *
     * @param generateSourceParty - 任务来源哪一方生成的任务【SIO公司导入进来分两种：[SIO_0_KIOSKOLIN、SIO_1_COMODIN]，COMODIN[comodin手工创建]，EXCEL[excel批量导入]】
     */
    public TaskBean setGenerateSourceParty(String generateSourceParty) {
        this.generateSourceParty = generateSourceParty == null ? null : generateSourceParty.trim();
        return this;
    }

    /**
     * 获取 生成任务的方式【ON_CONTRACT[按合同], ON_DEMAND[按需求]】
     *
     * @return task_generated_type - 生成任务的方式【ON_CONTRACT[按合同], ON_DEMAND[按需求]】
     */
    public String getGeneratedType() {
        return generatedType;
    }

    /**
     * 设置 生成任务的方式【ON_CONTRACT[按合同], ON_DEMAND[按需求]】
     *
     * @param generatedType - 生成任务的方式【ON_CONTRACT[按合同], ON_DEMAND[按需求]】
     */
    public TaskBean setGeneratedType(String generatedType) {
        this.generatedType = generatedType == null ? null : generatedType.trim();
        return this;
    }

    /**
     * 获取 任务来源的,公司,ID【date:2016-12-12 by:supeng】【{"max":13}】
     *
     * @return task_source_company_id - 任务来源的,公司,ID【date:2016-12-12 by:supeng】【{"max":13}】
     */
    public Long getSourceCompanyId() {
        return sourceCompanyId;
    }

    /**
     * 设置 任务来源的,公司,ID【date:2016-12-12 by:supeng】【{"max":13}】
     *
     * @param sourceCompanyId - 任务来源的,公司,ID【date:2016-12-12 by:supeng】【{"max":13}】
     */
    public TaskBean setSourceCompanyId(Long sourceCompanyId) {
        this.sourceCompanyId = sourceCompanyId;
        return this;
    }

    /**
     * 获取 任务来源的,公司,内部ID【date:2016-12-12 by:supeng】
     *
     * @return task_source_company_internal_id - 任务来源的,公司,内部ID【date:2016-12-12 by:supeng】
     */
    public String getSourceCompanyInternalId() {
        return sourceCompanyInternalId;
    }

    /**
     * 设置 任务来源的,公司,内部ID【date:2016-12-12 by:supeng】
     *
     * @param sourceCompanyInternalId - 任务来源的,公司,内部ID【date:2016-12-12 by:supeng】
     */
    public TaskBean setSourceCompanyInternalId(String sourceCompanyInternalId) {
        this.sourceCompanyInternalId = sourceCompanyInternalId == null ? null : sourceCompanyInternalId.trim();
        return this;
    }

    /**
     * 获取 任务来源的,公司,名【date:2016-12-12 by:supeng】
     *
     * @return task_source_company_name - 任务来源的,公司,名【date:2016-12-12 by:supeng】
     */
    public String getSourceCompanyName() {
        return sourceCompanyName;
    }

    /**
     * 设置 任务来源的,公司,名【date:2016-12-12 by:supeng】
     *
     * @param sourceCompanyName - 任务来源的,公司,名【date:2016-12-12 by:supeng】
     */
    public TaskBean setSourceCompanyName(String sourceCompanyName) {
        this.sourceCompanyName = sourceCompanyName == null ? null : sourceCompanyName.trim();
        return this;
    }

    /**
     * 获取 任务来源的,网点,ID【date:2016-12-12 by:supeng】【{"max":13}】
     *
     * @return task_source_branch_id - 任务来源的,网点,ID【date:2016-12-12 by:supeng】【{"max":13}】
     */
    public Long getSourceBranchId() {
        return sourceBranchId;
    }

    /**
     * 设置 任务来源的,网点,ID【date:2016-12-12 by:supeng】【{"max":13}】
     *
     * @param sourceBranchId - 任务来源的,网点,ID【date:2016-12-12 by:supeng】【{"max":13}】
     */
    public TaskBean setSourceBranchId(Long sourceBranchId) {
        this.sourceBranchId = sourceBranchId;
        return this;
    }

    /**
     * 获取 任务来源的,网点,内部ID【date:2016-12-12 by:supeng】
     *
     * @return task_source_branch_internal_id - 任务来源的,网点,内部ID【date:2016-12-12 by:supeng】
     */
    public String getSourceBranchInternalId() {
        return sourceBranchInternalId;
    }

    /**
     * 设置 任务来源的,网点,内部ID【date:2016-12-12 by:supeng】
     *
     * @param sourceBranchInternalId - 任务来源的,网点,内部ID【date:2016-12-12 by:supeng】
     */
    public TaskBean setSourceBranchInternalId(String sourceBranchInternalId) {
        this.sourceBranchInternalId = sourceBranchInternalId == null ? null : sourceBranchInternalId.trim();
        return this;
    }

    /**
     * 获取 任务来源的,网点,名【date:2016-12-12 by:supeng】
     *
     * @return task_source_branch_name - 任务来源的,网点,名【date:2016-12-12 by:supeng】
     */
    public String getSourceBranchName() {
        return sourceBranchName;
    }

    /**
     * 设置 任务来源的,网点,名【date:2016-12-12 by:supeng】
     *
     * @param sourceBranchName - 任务来源的,网点,名【date:2016-12-12 by:supeng】
     */
    public TaskBean setSourceBranchName(String sourceBranchName) {
        this.sourceBranchName = sourceBranchName == null ? null : sourceBranchName.trim();
        return this;
    }

    /**
     * 获取 任务原始,ID,【date:2016-12-12 by:supeng】
     *
     * @return task_source_task_id - 任务原始,ID,【date:2016-12-12 by:supeng】
     */
    public String getSourceTaskId() {
        return sourceTaskId;
    }

    /**
     * 设置 任务原始,ID,【date:2016-12-12 by:supeng】
     *
     * @param sourceTaskId - 任务原始,ID,【date:2016-12-12 by:supeng】
     */
    public TaskBean setSourceTaskId(String sourceTaskId) {
        this.sourceTaskId = sourceTaskId == null ? null : sourceTaskId.trim();
        return this;
    }

    /**
     * 获取 任务原始,服务类型【1_CLIENT_TO_CLIENT、2_RECEIVER_CLIENT_TO_BOVEDA、3_RECEIVER_CLIENT_TO_PROCESS、4_SENDER_BOVEDA_TO_CLIENT、5_SENDER_PROCESS_TO_CLIENT、6_SENDER_WAREHOUSE_TO_CLIENT】by:supeng date:2017-05-19
     *
     * @return task_source_task_service_type - 任务原始,服务类型【1_CLIENT_TO_CLIENT、2_RECEIVER_CLIENT_TO_BOVEDA、3_RECEIVER_CLIENT_TO_PROCESS、4_SENDER_BOVEDA_TO_CLIENT、5_SENDER_PROCESS_TO_CLIENT、6_SENDER_WAREHOUSE_TO_CLIENT】by:supeng date:2017-05-19
     */
    public String getSourceServiceType() {
        return sourceServiceType;
    }

    /**
     * 设置 任务原始,服务类型【1_CLIENT_TO_CLIENT、2_RECEIVER_CLIENT_TO_BOVEDA、3_RECEIVER_CLIENT_TO_PROCESS、4_SENDER_BOVEDA_TO_CLIENT、5_SENDER_PROCESS_TO_CLIENT、6_SENDER_WAREHOUSE_TO_CLIENT】by:supeng date:2017-05-19
     *
     * @param sourceServiceType - 任务原始,服务类型【1_CLIENT_TO_CLIENT、2_RECEIVER_CLIENT_TO_BOVEDA、3_RECEIVER_CLIENT_TO_PROCESS、4_SENDER_BOVEDA_TO_CLIENT、5_SENDER_PROCESS_TO_CLIENT、6_SENDER_WAREHOUSE_TO_CLIENT】by:supeng date:2017-05-19
     */
    public TaskBean setSourceServiceType(String sourceServiceType) {
        this.sourceServiceType = sourceServiceType == null ? null : sourceServiceType.trim();
        return this;
    }

    /**
     * 获取 任务原始,服务代码
     *
     * @return task_source_service_code - 任务原始,服务代码
     */
    public String getSourceServiceCode() {
        return sourceServiceCode;
    }

    /**
     * 设置 任务原始,服务代码
     *
     * @param sourceServiceCode - 任务原始,服务代码
     */
    public TaskBean setSourceServiceCode(String sourceServiceCode) {
        this.sourceServiceCode = sourceServiceCode == null ? null : sourceServiceCode.trim();
        return this;
    }

    /**
     * 获取 任务原始,钥匙编号
     *
     * @return task_source_safe_key_number - 任务原始,钥匙编号
     */
    public String getSourceSafeKeyNumber() {
        return sourceSafeKeyNumber;
    }

    /**
     * 设置 任务原始,钥匙编号
     *
     * @param sourceSafeKeyNumber - 任务原始,钥匙编号
     */
    public TaskBean setSourceSafeKeyNumber(String sourceSafeKeyNumber) {
        this.sourceSafeKeyNumber = sourceSafeKeyNumber == null ? null : sourceSafeKeyNumber.trim();
        return this;
    }

    /**
     * 获取 任务原始,描述 - 需要在APP中显示
     *
     * @return task_source_description - 任务原始,描述 - 需要在APP中显示
     */
    public String getSourceDescription() {
        return sourceDescription;
    }

    /**
     * 设置 任务原始,描述 - 需要在APP中显示
     *
     * @param sourceDescription - 任务原始,描述 - 需要在APP中显示
     */
    public TaskBean setSourceDescription(String sourceDescription) {
        this.sourceDescription = sourceDescription == null ? null : sourceDescription.trim();
        return this;
    }

    /**
     * 获取 任务原始,该任务是否生效; 该字段目前主要是sioXml导入的任务开关【ENABLE[启用]、DISABLE[禁用]】
     *
     * @return task_source_availability - 任务原始,该任务是否生效; 该字段目前主要是sioXml导入的任务开关【ENABLE[启用]、DISABLE[禁用]】
     */
    public String getSourceAvailability() {
        return sourceAvailability;
    }

    /**
     * 设置 任务原始,该任务是否生效; 该字段目前主要是sioXml导入的任务开关【ENABLE[启用]、DISABLE[禁用]】
     *
     * @param sourceAvailability - 任务原始,该任务是否生效; 该字段目前主要是sioXml导入的任务开关【ENABLE[启用]、DISABLE[禁用]】
     */
    public TaskBean setSourceAvailability(String sourceAvailability) {
        this.sourceAvailability = sourceAvailability == null ? null : sourceAvailability.trim();
        return this;
    }

    /**
     * 获取 任务复合ID,组成方式【|4|26|20161118|1101|1|】【|SIO公司内部ID|SIO公司网点内部ID|路线日期[yyyyMMdd]|路线ID|任务ID|】【date:2016-12-12 by:supeng】
     *
     * @return task_source_task_original_complex_id - 任务复合ID,组成方式【|4|26|20161118|1101|1|】【|SIO公司内部ID|SIO公司网点内部ID|路线日期[yyyyMMdd]|路线ID|任务ID|】【date:2016-12-12 by:supeng】
     */
    public String getSourceOriginalComplexId() {
        return sourceOriginalComplexId;
    }

    /**
     * 设置 任务复合ID,组成方式【|4|26|20161118|1101|1|】【|SIO公司内部ID|SIO公司网点内部ID|路线日期[yyyyMMdd]|路线ID|任务ID|】【date:2016-12-12 by:supeng】
     *
     * @param sourceOriginalComplexId - 任务复合ID,组成方式【|4|26|20161118|1101|1|】【|SIO公司内部ID|SIO公司网点内部ID|路线日期[yyyyMMdd]|路线ID|任务ID|】【date:2016-12-12 by:supeng】
     */
    public TaskBean setSourceOriginalComplexId(String sourceOriginalComplexId) {
        this.sourceOriginalComplexId = sourceOriginalComplexId == null ? null : sourceOriginalComplexId.trim();
        return this;
    }

    /**
     *
     * @return task_last_generate_xml_task_status
     */
    public String getLastGenerateXmlTaskStatus() {
        return lastGenerateXmlTaskStatus;
    }

    /**
     *
     * @param lastGenerateXmlTaskStatus - 
     */
    public TaskBean setLastGenerateXmlTaskStatus(String lastGenerateXmlTaskStatus) {
        this.lastGenerateXmlTaskStatus = lastGenerateXmlTaskStatus == null ? null : lastGenerateXmlTaskStatus.trim();
        return this;
    }
}