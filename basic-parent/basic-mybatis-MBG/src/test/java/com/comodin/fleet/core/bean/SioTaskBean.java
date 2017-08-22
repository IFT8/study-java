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

@SuppressWarnings({"unused", "UnusedReturnValue", "SameParameterValue"})
@Table(name = "t_sio_task")
public class SioTaskBean implements Serializable {
    /**
     * <pre>
     * DB remark: 数据库主键ID
     * DB column: task_id	BIGINT(19)	<--->	id	java.lang.Long
     * DB is  Nullable: false
     * DB defaultValue: null
     * </pre>
     */
    @NotNull(message = "{SIO_TASK_BEAN_ID_NOT_NULL}", groups = {IBaseValidGroup.Add.class, IBaseValidGroup.Update.class})
    @ValidLength(max = 19, message = "{SIO_TASK_BEAN_ID_LENGTH}", groups = {IBaseValidGroup.Add.class, IBaseValidGroup.Update.class})
    @Id
    @Column(name = "task_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    /**
     * <pre>
     * DB remark: SIO任务ID组成方式【|4|26|20161118|1101|1|】【|SIO公司内部ID|SIO公司网点内部ID|路线日期[yyyyMMdd]|路线ID|任务ID|】【date:2016-12-12 by:supeng】
     * DB column: task_task_original_complex_id	VARCHAR(100)	<--->	taskOriginalComplexId	java.lang.String
     * DB is  Nullable: true
     * DB defaultValue: null
     * </pre>
     */
    @Length(max = 100, message = "{SIO_TASK_BEAN_TASK_ORIGINAL_COMPLEX_ID_LENGTH}", groups = {IBaseValidGroup.Add.class, IBaseValidGroup.Update.class})
    @Column(name = "task_task_original_complex_id")
    private String taskOriginalComplexId;

    /**
     * <pre>
     * DB remark: 任务来源于SIO某分公司，SIO分公司内部编号
     * DB column: task_route_company_internal_id	CHAR(15)	<--->	routeCompanyInternalId	java.lang.String
     * DB is  Nullable: true
     * DB defaultValue: null
     * </pre>
     */
    @Length(max = 15, message = "{SIO_TASK_BEAN_ROUTE_COMPANY_INTERNAL_ID_LENGTH}", groups = {IBaseValidGroup.Add.class, IBaseValidGroup.Update.class})
    @Column(name = "task_route_company_internal_id")
    private String routeCompanyInternalId;

    /**
     * <pre>
     * DB remark: 任务来源于SIO某分公司的哪个分支网点，SIO分支网点的内部编号
     * DB column: task_route_branch_internal_id	VARCHAR(15)	<--->	routeBranchInternalId	java.lang.String
     * DB is  Nullable: true
     * DB defaultValue: null
     * </pre>
     */
    @Length(max = 15, message = "{SIO_TASK_BEAN_ROUTE_BRANCH_INTERNAL_ID_LENGTH}", groups = {IBaseValidGroup.Add.class, IBaseValidGroup.Update.class})
    @Column(name = "task_route_branch_internal_id")
    private String routeBranchInternalId;

    /**
     * <pre>
     * DB remark: 路线日期 [即任务服务日期]
     * DB column: task_route_service_date	CHAR(10)	<--->	routeServiceDate	java.lang.String
     * DB is  Nullable: true
     * DB defaultValue: null
     * </pre>
     */
    @Length(max = 10, message = "{SIO_TASK_BEAN_ROUTE_SERVICE_DATE_LENGTH}", groups = {IBaseValidGroup.Add.class, IBaseValidGroup.Update.class})
    @Column(name = "task_route_service_date")
    private String routeServiceDate;

    /**
     * <pre>
     * DB remark: 路线ID
     * DB column: task_route_id	VARCHAR(10)	<--->	routeId	java.lang.String
     * DB is  Nullable: true
     * DB defaultValue: null
     * </pre>
     */
    @Length(max = 10, message = "{SIO_TASK_BEAN_ROUTE_ID_LENGTH}", groups = {IBaseValidGroup.Add.class, IBaseValidGroup.Update.class})
    @Column(name = "task_route_id")
    private String routeId;

    /**
     * <pre>
     * DB remark: 路线状态类型，详情参考 Rules.xls中的 工作表 Tes中
     * DB column: task_route_status	VARCHAR(25)	<--->	routeStatus	java.lang.String
     * DB is  Nullable: true
     * DB defaultValue: null
     * </pre>
     */
    @Length(max = 25, message = "{SIO_TASK_BEAN_ROUTE_STATUS_LENGTH}", groups = {IBaseValidGroup.Add.class, IBaseValidGroup.Update.class})
    @Column(name = "task_route_status")
    private String routeStatus;

    @Length(max = 25, message = "{SIO_TASK_BEAN_ROUTE_USERNAME_LENGTH}", groups = {IBaseValidGroup.Add.class, IBaseValidGroup.Update.class})
    @Column(name = "task_route_username")
    private String routeUsername;

    @Length(max = 25, message = "{SIO_TASK_BEAN_ROUTE_PASSWORD_LENGTH}", groups = {IBaseValidGroup.Add.class, IBaseValidGroup.Update.class})
    @Column(name = "task_route_password")
    private String routePassword;

    /**
     * <pre>
     * DB remark: SIO某分支网点，内部任务ID
     * DB column: task_task_id	VARCHAR(15)	<--->	taskId	java.lang.String
     * DB is  Nullable: true
     * DB defaultValue: null
     * </pre>
     */
    @Length(max = 15, message = "{SIO_TASK_BEAN_TASK_ID_LENGTH}", groups = {IBaseValidGroup.Add.class, IBaseValidGroup.Update.class})
    @Column(name = "task_task_id")
    private String taskId;

    /**
     * <pre>
     * DB remark: 任务顺序 app comodin定义顺序
     * DB column: task_route_order	INTEGER(10)	<--->	routeOrder	java.lang.Integer
     * DB is  Nullable: true
     * DB defaultValue: null
     * </pre>
     */
    @ValidLength(max = 10, message = "{SIO_TASK_BEAN_ROUTE_ORDER_LENGTH}", groups = {IBaseValidGroup.Add.class, IBaseValidGroup.Update.class})
    @Column(name = "task_route_order")
    private Integer routeOrder;

    /**
     * <pre>
     * DB remark: 服务类型  即 comodin中 任务生成方式；0代表按计划服务；#代表按需服务
     * DB column: task_generated_type	VARCHAR(20)	<--->	generatedType	java.lang.String
     * DB is  Nullable: true
     * DB defaultValue: null
     * </pre>
     */
    @Length(max = 20, message = "{SIO_TASK_BEAN_GENERATED_TYPE_LENGTH}", groups = {IBaseValidGroup.Add.class, IBaseValidGroup.Update.class})
    @Column(name = "task_generated_type")
    private String generatedType;

    /**
     * <pre>
     * DB remark: 任务类型 详细看 Rules.xml工作表 Ten中说明
     * DB column: task_service_type	VARCHAR(20)	<--->	serviceType	java.lang.String
     * DB is  Nullable: true
     * DB defaultValue: null
     * </pre>
     */
    @Length(max = 20, message = "{SIO_TASK_BEAN_SERVICE_TYPE_LENGTH}", groups = {IBaseValidGroup.Add.class, IBaseValidGroup.Update.class})
    @Column(name = "task_service_type")
    private String serviceType;

    /**
     * <pre>
     * DB remark: SIO服务代码
     * DB column: task_service_code	VARCHAR(20)	<--->	serviceCode	java.lang.String
     * DB is  Nullable: true
     * DB defaultValue: null
     * </pre>
     */
    @Length(max = 20, message = "{SIO_TASK_BEAN_SERVICE_CODE_LENGTH}", groups = {IBaseValidGroup.Add.class, IBaseValidGroup.Update.class})
    @Column(name = "task_service_code")
    private String serviceCode;

    /**
     * <pre>
     * DB remark: 任务描述 - 需要在APP中显示
     * DB column: task_description	VARCHAR(255)	<--->	description	java.lang.String
     * DB is  Nullable: true
     * DB defaultValue: null
     * </pre>
     */
    @Length(max = 255, message = "{SIO_TASK_BEAN_DESCRIPTION_LENGTH}", groups = {IBaseValidGroup.Add.class, IBaseValidGroup.Update.class})
    @Column(name = "task_description")
    private String description;

    /**
     * <pre>
     * DB remark: 保险箱密钥号 钥匙编号
     * DB column: task_safe_key_number	VARCHAR(20)	<--->	safeKeyNumber	java.lang.String
     * DB is  Nullable: true
     * DB defaultValue: null
     * </pre>
     */
    @Length(max = 20, message = "{SIO_TASK_BEAN_SAFE_KEY_NUMBER_LENGTH}", groups = {IBaseValidGroup.Add.class, IBaseValidGroup.Update.class})
    @Column(name = "task_safe_key_number")
    private String safeKeyNumber;

    /**
     * <pre>
     * DB remark: 钱袋子总数
     * DB column: task_money_bags_total_number	VARCHAR(20)	<--->	moneyBagsTotalNumber	java.lang.String
     * DB is  Nullable: true
     * DB defaultValue: null
     * </pre>
     */
    @Length(max = 20, message = "{SIO_TASK_BEAN_MONEY_BAGS_TOTAL_NUMBER_LENGTH}", groups = {IBaseValidGroup.Add.class, IBaseValidGroup.Update.class})
    @Column(name = "task_money_bags_total_number")
    private String moneyBagsTotalNumber;

    /**
     * <pre>
     * DB remark: 票据总数
     * DB column: task_comprobantes_total_number	VARCHAR(20)	<--->	comprobantesTotalNumber	java.lang.String
     * DB is  Nullable: true
     * DB defaultValue: null
     * </pre>
     */
    @Length(max = 20, message = "{SIO_TASK_BEAN_COMPROBANTES_TOTAL_NUMBER_LENGTH}", groups = {IBaseValidGroup.Add.class, IBaseValidGroup.Update.class})
    @Column(name = "task_comprobantes_total_number")
    private String comprobantesTotalNumber;

    /**
     * <pre>
     * DB remark: 任务状态
     * DB column: task_status	VARCHAR(25)	<--->	status	java.lang.String
     * DB is  Nullable: true
     * DB defaultValue: null
     * </pre>
     */
    @Length(max = 25, message = "{SIO_TASK_BEAN_STATUS_LENGTH}", groups = {IBaseValidGroup.Add.class, IBaseValidGroup.Update.class})
    @Column(name = "task_status")
    private String status;

    /**
     * <pre>
     * DB remark: 任务注释
     * DB column: task_notes	VARCHAR(100)	<--->	notes	java.lang.String
     * DB is  Nullable: true
     * DB defaultValue: null
     * </pre>
     */
    @Length(max = 100, message = "{SIO_TASK_BEAN_NOTES_LENGTH}", groups = {IBaseValidGroup.Add.class, IBaseValidGroup.Update.class})
    @Column(name = "task_notes")
    private String notes;

    /**
     * <pre>
     * DB remark: 发件方，分支，ID【重复节点，在发件人中有】
     * DB column: task_xml_sender_branch_internal_id	VARCHAR(15)	<--->	xmlSenderBranchInternalId	java.lang.String
     * DB is  Nullable: true
     * DB defaultValue: null
     * </pre>
     */
    @Length(max = 15, message = "{SIO_TASK_BEAN_XML_SENDER_BRANCH_INTERNAL_ID_LENGTH}", groups = {IBaseValidGroup.Add.class, IBaseValidGroup.Update.class})
    @Column(name = "task_xml_sender_branch_internal_id")
    private String xmlSenderBranchInternalId;

    /**
     * <pre>
     * DB remark: 发件方，分支，窗口服务【重复节点，在发件人中有】
     * DB column: task_xml_sender_window_service_time	CHAR(8)	<--->	xmlSenderWindowServiceTime	java.lang.String
     * DB is  Nullable: true
     * DB defaultValue: null
     * </pre>
     */
    @Length(max = 8, message = "{SIO_TASK_BEAN_XML_SENDER_WINDOW_SERVICE_TIME_LENGTH}", groups = {IBaseValidGroup.Add.class, IBaseValidGroup.Update.class})
    @Column(name = "task_xml_sender_window_service_time")
    private String xmlSenderWindowServiceTime;

    /**
     * <pre>
     * DB remark: 发件方，分支，窗口服务，实时
     * DB column: task_xml_sender_window_service_duration	VARCHAR(5)	<--->	xmlSenderWindowServiceDuration	java.lang.String
     * DB is  Nullable: true
     * DB defaultValue: null
     * </pre>
     */
    @Length(max = 5, message = "{SIO_TASK_BEAN_XML_SENDER_WINDOW_SERVICE_DURATION_LENGTH}", groups = {IBaseValidGroup.Add.class, IBaseValidGroup.Update.class})
    @Column(name = "task_xml_sender_window_service_duration")
    private String xmlSenderWindowServiceDuration;

    /**
     * <pre>
     * DB remark: 收件方，分支，ID【重复节点，在收件人中有】
     * DB column: task_xml_receiver_branch_internal_id	VARCHAR(15)	<--->	xmlReceiverBranchInternalId	java.lang.String
     * DB is  Nullable: true
     * DB defaultValue: null
     * </pre>
     */
    @Length(max = 15, message = "{SIO_TASK_BEAN_XML_RECEIVER_BRANCH_INTERNAL_ID_LENGTH}", groups = {IBaseValidGroup.Add.class, IBaseValidGroup.Update.class})
    @Column(name = "task_xml_receiver_branch_internal_id")
    private String xmlReceiverBranchInternalId;

    /**
     * <pre>
     * DB remark: 收件方，分支，窗口服务【重复节点，在收件人中有】
     * DB column: task_xml_receiver_window_service_time	CHAR(8)	<--->	xmlReceiverWindowServiceTime	java.lang.String
     * DB is  Nullable: true
     * DB defaultValue: null
     * </pre>
     */
    @Length(max = 8, message = "{SIO_TASK_BEAN_XML_RECEIVER_WINDOW_SERVICE_TIME_LENGTH}", groups = {IBaseValidGroup.Add.class, IBaseValidGroup.Update.class})
    @Column(name = "task_xml_receiver_window_service_time")
    private String xmlReceiverWindowServiceTime;

    /**
     * <pre>
     * DB remark: 收件方，分支，窗口服务，实时
     * DB column: task_xml_receiver_window_service_duration	VARCHAR(5)	<--->	xmlReceiverWindowServiceDuration	java.lang.String
     * DB is  Nullable: true
     * DB defaultValue: null
     * </pre>
     */
    @Length(max = 5, message = "{SIO_TASK_BEAN_XML_RECEIVER_WINDOW_SERVICE_DURATION_LENGTH}", groups = {IBaseValidGroup.Add.class, IBaseValidGroup.Update.class})
    @Column(name = "task_xml_receiver_window_service_duration")
    private String xmlReceiverWindowServiceDuration;

    /**
     * <pre>
     * DB remark: SIO系统，任务是否有电子票据【1有电子票据，2没有电子票据】
     * DB column: task_config_whether_electronic_bill	VARCHAR(20)	<--->	configWhetherElectronicBill	java.lang.String
     * DB is  Nullable: true
     * DB defaultValue: null
     * </pre>
     */
    @Length(max = 20, message = "{SIO_TASK_BEAN_CONFIG_WHETHER_ELECTRONIC_BILL_LENGTH}", groups = {IBaseValidGroup.Add.class, IBaseValidGroup.Update.class})
    @Column(name = "task_config_whether_electronic_bill")
    private String configWhetherElectronicBill;

    /**
     * <pre>
     * DB remark: 送钱任务，取消【钱还没有送到客户】钱要返回到金库，值为1；其他的就为0
     * DB column: task_config_cancel_money_back_party	VARCHAR(20)	<--->	configCancelMoneyBackParty	java.lang.String
     * DB is  Nullable: true
     * DB defaultValue: null
     * </pre>
     */
    @Length(max = 20, message = "{SIO_TASK_BEAN_CONFIG_CANCEL_MONEY_BACK_PARTY_LENGTH}", groups = {IBaseValidGroup.Add.class, IBaseValidGroup.Update.class})
    @Column(name = "task_config_cancel_money_back_party")
    private String configCancelMoneyBackParty;

    /**
     * <pre>
     * DB remark: SIO任务，是否需要现场点钞
     * DB column: task_config_whether_site_counting	VARCHAR(20)	<--->	configWhetherSiteCounting	java.lang.String
     * DB is  Nullable: true
     * DB defaultValue: null
     * </pre>
     */
    @Length(max = 20, message = "{SIO_TASK_BEAN_CONFIG_WHETHER_SITE_COUNTING_LENGTH}", groups = {IBaseValidGroup.Add.class, IBaseValidGroup.Update.class})
    @Column(name = "task_config_whether_site_counting")
    private String configWhetherSiteCounting;

    /**
     * <pre>
     * DB remark: ATM的编号【SIDE】，暂时不考虑，后期会再使用
     * DB column: task_config_atm_id	VARCHAR(20)	<--->	configAtmId	java.lang.String
     * DB is  Nullable: true
     * DB defaultValue: null
     * </pre>
     */
    @Length(max = 20, message = "{SIO_TASK_BEAN_CONFIG_ATM_ID_LENGTH}", groups = {IBaseValidGroup.Add.class, IBaseValidGroup.Update.class})
    @Column(name = "task_config_atm_id")
    private String configAtmId;

    /**
     * <pre>
     * DB remark: SIO任务是现场发工资的，0代表正常，1代表要现场发钱的
     * DB column: task_config_whether_site_wages	VARCHAR(20)	<--->	configWhetherSiteWages	java.lang.String
     * DB is  Nullable: true
     * DB defaultValue: null
     * </pre>
     */
    @Length(max = 20, message = "{SIO_TASK_BEAN_CONFIG_WHETHER_SITE_WAGES_LENGTH}", groups = {IBaseValidGroup.Add.class, IBaseValidGroup.Update.class})
    @Column(name = "task_config_whether_site_wages")
    private String configWhetherSiteWages;

    /**
     * <pre>
     * DB remark: 该XML是由哪一方传入，1代表由comodin传入到KIOSKOLIN；0代表由KIOSKOLIN传入到comodin
     * DB column: task_config_xml_source_side	VARCHAR(20)	<--->	configXmlSourceSide	java.lang.String
     * DB is  Nullable: true
     * DB defaultValue: null
     * </pre>
     */
    @Length(max = 20, message = "{SIO_TASK_BEAN_CONFIG_XML_SOURCE_SIDE_LENGTH}", groups = {IBaseValidGroup.Add.class, IBaseValidGroup.Update.class})
    @Column(name = "task_config_xml_source_side")
    private String configXmlSourceSide;

    /**
     * <pre>
     * DB remark: 当前这个任务是：interChange之前[ORIG]，还是之后interChange之后[DEST]
     * DB column: task_inter_change_type	VARCHAR(20)	<--->	interChangeType	java.lang.String
     * DB is  Nullable: true
     * DB defaultValue: null
     * </pre>
     */
    @Length(max = 20, message = "{SIO_TASK_BEAN_INTER_CHANGE_TYPE_LENGTH}", groups = {IBaseValidGroup.Add.class, IBaseValidGroup.Update.class})
    @Column(name = "task_inter_change_type")
    private String interChangeType;

    /**
     * <pre>
     * DB remark: interChange到哪个公司
     * DB column: task_inter_change_company_internal_id	VARCHAR(20)	<--->	interChangeCompanyInternalId	java.lang.String
     * DB is  Nullable: true
     * DB defaultValue: null
     * </pre>
     */
    @Length(max = 20, message = "{SIO_TASK_BEAN_INTER_CHANGE_COMPANY_INTERNAL_ID_LENGTH}", groups = {IBaseValidGroup.Add.class, IBaseValidGroup.Update.class})
    @Column(name = "task_inter_change_company_internal_id")
    private String interChangeCompanyInternalId;

    /**
     * <pre>
     * DB remark: interChange到哪个公司哪个网点
     * DB column: task_inter_change_branch_internal_id	VARCHAR(20)	<--->	interChangeBranchInternalId	java.lang.String
     * DB is  Nullable: true
     * DB defaultValue: null
     * </pre>
     */
    @Length(max = 20, message = "{SIO_TASK_BEAN_INTER_CHANGE_BRANCH_INTERNAL_ID_LENGTH}", groups = {IBaseValidGroup.Add.class, IBaseValidGroup.Update.class})
    @Column(name = "task_inter_change_branch_internal_id")
    private String interChangeBranchInternalId;

    /**
     * <pre>
     * DB remark: interChange到哪个公司哪个网点的哪一条路线
     * DB column: task_inter_change_route_id	VARCHAR(20)	<--->	interChangeRouteId	java.lang.String
     * DB is  Nullable: true
     * DB defaultValue: null
     * </pre>
     */
    @Length(max = 20, message = "{SIO_TASK_BEAN_INTER_CHANGE_ROUTE_ID_LENGTH}", groups = {IBaseValidGroup.Add.class, IBaseValidGroup.Update.class})
    @Column(name = "task_inter_change_route_id")
    private String interChangeRouteId;

    /**
     * <pre>
     * DB remark: interChange到哪一天日期
     * DB column: task_inter_change_service_date	VARCHAR(20)	<--->	interChangeServiceDate	java.lang.String
     * DB is  Nullable: true
     * DB defaultValue: null
     * </pre>
     */
    @Length(max = 20, message = "{SIO_TASK_BEAN_INTER_CHANGE_SERVICE_DATE_LENGTH}", groups = {IBaseValidGroup.Add.class, IBaseValidGroup.Update.class})
    @Column(name = "task_inter_change_service_date")
    private String interChangeServiceDate;

    /**
     * <pre>
     * DB remark: interchange的任务ID
     * DB column: task_inter_change_task_id	VARCHAR(20)	<--->	interChangeTaskId	java.lang.String
     * DB is  Nullable: true
     * DB defaultValue: null
     * </pre>
     */
    @Length(max = 20, message = "{SIO_TASK_BEAN_INTER_CHANGE_TASK_ID_LENGTH}", groups = {IBaseValidGroup.Add.class, IBaseValidGroup.Update.class})
    @Column(name = "task_inter_change_task_id")
    private String interChangeTaskId;

    /**
     * <pre>
     * DB remark: 发件方，分支，ID
     * DB column: task_sender_branch_internal_id	VARCHAR(15)	<--->	senderBranchInternalId	java.lang.String
     * DB is  Nullable: true
     * DB defaultValue: null
     * </pre>
     */
    @Length(max = 15, message = "{SIO_TASK_BEAN_SENDER_BRANCH_INTERNAL_ID_LENGTH}", groups = {IBaseValidGroup.Add.class, IBaseValidGroup.Update.class})
    @Column(name = "task_sender_branch_internal_id")
    private String senderBranchInternalId;

    /**
     * <pre>
     * DB remark: 发件方，分支，窗口服务
     * DB column: task_sender_window_service_time	CHAR(8)	<--->	senderWindowServiceTime	java.lang.String
     * DB is  Nullable: true
     * DB defaultValue: null
     * </pre>
     */
    @Length(max = 8, message = "{SIO_TASK_BEAN_SENDER_WINDOW_SERVICE_TIME_LENGTH}", groups = {IBaseValidGroup.Add.class, IBaseValidGroup.Update.class})
    @Column(name = "task_sender_window_service_time")
    private String senderWindowServiceTime;

    @Length(max = 50, message = "{SIO_TASK_BEAN_SENDER_CHECK_INN_LENGTH}", groups = {IBaseValidGroup.Add.class, IBaseValidGroup.Update.class})
    @Column(name = "task_sender_check_inn")
    private String senderCheckInn;

    @Length(max = 50, message = "{SIO_TASK_BEAN_SENDER_CHECK_OUT_LENGTH}", groups = {IBaseValidGroup.Add.class, IBaseValidGroup.Update.class})
    @Column(name = "task_sender_check_out")
    private String senderCheckOut;

    /**
     * <pre>
     * DB remark: 发件方，分支，名称
     * DB column: task_sender_branch_name	VARCHAR(100)	<--->	senderBranchName	java.lang.String
     * DB is  Nullable: true
     * DB defaultValue: null
     * </pre>
     */
    @Length(max = 100, message = "{SIO_TASK_BEAN_SENDER_BRANCH_NAME_LENGTH}", groups = {IBaseValidGroup.Add.class, IBaseValidGroup.Update.class})
    @Column(name = "task_sender_branch_name")
    private String senderBranchName;

    /**
     * <pre>
     * DB remark: 发件方，分支，地址（街道）
     * DB column: task_sender_branch_address_street	VARCHAR(100)	<--->	senderBranchAddressStreet	java.lang.String
     * DB is  Nullable: true
     * DB defaultValue: null
     * </pre>
     */
    @Length(max = 100, message = "{SIO_TASK_BEAN_SENDER_BRANCH_ADDRESS_STREET_LENGTH}", groups = {IBaseValidGroup.Add.class, IBaseValidGroup.Update.class})
    @Column(name = "task_sender_branch_address_street")
    private String senderBranchAddressStreet;

    /**
     * <pre>
     * DB remark: 发件方，分支，地址（数字）
     * DB column: task_sender_branch_address_number	VARCHAR(50)	<--->	senderBranchAddressNumber	java.lang.String
     * DB is  Nullable: true
     * DB defaultValue: null
     * </pre>
     */
    @Length(max = 50, message = "{SIO_TASK_BEAN_SENDER_BRANCH_ADDRESS_NUMBER_LENGTH}", groups = {IBaseValidGroup.Add.class, IBaseValidGroup.Update.class})
    @Column(name = "task_sender_branch_address_number")
    private String senderBranchAddressNumber;

    /**
     * <pre>
     * DB remark: 发件方，分支，位置（纬度）
     * DB column: task_sender_branch_latitude	VARCHAR(15)	<--->	senderBranchLatitude	java.lang.String
     * DB is  Nullable: true
     * DB defaultValue: null
     * </pre>
     */
    @Length(max = 15, message = "{SIO_TASK_BEAN_SENDER_BRANCH_LATITUDE_LENGTH}", groups = {IBaseValidGroup.Add.class, IBaseValidGroup.Update.class})
    @Column(name = "task_sender_branch_latitude")
    private String senderBranchLatitude;

    /**
     * <pre>
     * DB remark: 发件方，分支，位置（经度）
     * DB column: task_sender_branch_longitude	VARCHAR(15)	<--->	senderBranchLongitude	java.lang.String
     * DB is  Nullable: true
     * DB defaultValue: null
     * </pre>
     */
    @Length(max = 15, message = "{SIO_TASK_BEAN_SENDER_BRANCH_LONGITUDE_LENGTH}", groups = {IBaseValidGroup.Add.class, IBaseValidGroup.Update.class})
    @Column(name = "task_sender_branch_longitude")
    private String senderBranchLongitude;

    /**
     * <pre>
     * DB remark: 收件方，分支，ID
     * DB column: task_receiver_branch_internal_id	VARCHAR(15)	<--->	receiverBranchInternalId	java.lang.String
     * DB is  Nullable: true
     * DB defaultValue: null
     * </pre>
     */
    @Length(max = 15, message = "{SIO_TASK_BEAN_RECEIVER_BRANCH_INTERNAL_ID_LENGTH}", groups = {IBaseValidGroup.Add.class, IBaseValidGroup.Update.class})
    @Column(name = "task_receiver_branch_internal_id")
    private String receiverBranchInternalId;

    /**
     * <pre>
     * DB remark: 收件方，分支，窗口服务
     * DB column: task_receiver_window_service_time	CHAR(8)	<--->	receiverWindowServiceTime	java.lang.String
     * DB is  Nullable: true
     * DB defaultValue: null
     * </pre>
     */
    @Length(max = 8, message = "{SIO_TASK_BEAN_RECEIVER_WINDOW_SERVICE_TIME_LENGTH}", groups = {IBaseValidGroup.Add.class, IBaseValidGroup.Update.class})
    @Column(name = "task_receiver_window_service_time")
    private String receiverWindowServiceTime;

    @Length(max = 50, message = "{SIO_TASK_BEAN_RECEIVER_CHECK_INN_LENGTH}", groups = {IBaseValidGroup.Add.class, IBaseValidGroup.Update.class})
    @Column(name = "task_receiver_check_inn")
    private String receiverCheckInn;

    @Length(max = 50, message = "{SIO_TASK_BEAN_RECEIVER_CHECK_OUT_LENGTH}", groups = {IBaseValidGroup.Add.class, IBaseValidGroup.Update.class})
    @Column(name = "task_receiver_check_out")
    private String receiverCheckOut;

    /**
     * <pre>
     * DB remark: 收件方，分支，名称
     * DB column: task_receiver_branch_name	VARCHAR(100)	<--->	receiverBranchName	java.lang.String
     * DB is  Nullable: true
     * DB defaultValue: null
     * </pre>
     */
    @Length(max = 100, message = "{SIO_TASK_BEAN_RECEIVER_BRANCH_NAME_LENGTH}", groups = {IBaseValidGroup.Add.class, IBaseValidGroup.Update.class})
    @Column(name = "task_receiver_branch_name")
    private String receiverBranchName;

    /**
     * <pre>
     * DB remark: 收件方，分支，地址（街道）
     * DB column: task_receiver_branch_address_street	VARCHAR(100)	<--->	receiverBranchAddressStreet	java.lang.String
     * DB is  Nullable: true
     * DB defaultValue: null
     * </pre>
     */
    @Length(max = 100, message = "{SIO_TASK_BEAN_RECEIVER_BRANCH_ADDRESS_STREET_LENGTH}", groups = {IBaseValidGroup.Add.class, IBaseValidGroup.Update.class})
    @Column(name = "task_receiver_branch_address_street")
    private String receiverBranchAddressStreet;

    /**
     * <pre>
     * DB remark: 收件方，分支，地址（数字）
     * DB column: task_receiver_branch_address_number	VARCHAR(50)	<--->	receiverBranchAddressNumber	java.lang.String
     * DB is  Nullable: true
     * DB defaultValue: null
     * </pre>
     */
    @Length(max = 50, message = "{SIO_TASK_BEAN_RECEIVER_BRANCH_ADDRESS_NUMBER_LENGTH}", groups = {IBaseValidGroup.Add.class, IBaseValidGroup.Update.class})
    @Column(name = "task_receiver_branch_address_number")
    private String receiverBranchAddressNumber;

    /**
     * <pre>
     * DB remark: 收件方，分支，位置（纬度）
     * DB column: task_receiver_branch_latitude	VARCHAR(15)	<--->	receiverBranchLatitude	java.lang.String
     * DB is  Nullable: true
     * DB defaultValue: null
     * </pre>
     */
    @Length(max = 15, message = "{SIO_TASK_BEAN_RECEIVER_BRANCH_LATITUDE_LENGTH}", groups = {IBaseValidGroup.Add.class, IBaseValidGroup.Update.class})
    @Column(name = "task_receiver_branch_latitude")
    private String receiverBranchLatitude;

    /**
     * <pre>
     * DB remark: 收件方，分支，位置（经度）
     * DB column: task_receiver_branch_longitude	VARCHAR(15)	<--->	receiverBranchLongitude	java.lang.String
     * DB is  Nullable: true
     * DB defaultValue: null
     * </pre>
     */
    @Length(max = 15, message = "{SIO_TASK_BEAN_RECEIVER_BRANCH_LONGITUDE_LENGTH}", groups = {IBaseValidGroup.Add.class, IBaseValidGroup.Update.class})
    @Column(name = "task_receiver_branch_longitude")
    private String receiverBranchLongitude;

    /**
     * <pre>
     * DB remark: 车辆，SIO内部编号
     * DB column: task_vehicle_internal_id	VARCHAR(15)	<--->	vehicleInternalId	java.lang.String
     * DB is  Nullable: true
     * DB defaultValue: null
     * </pre>
     */
    @Length(max = 15, message = "{SIO_TASK_BEAN_VEHICLE_INTERNAL_ID_LENGTH}", groups = {IBaseValidGroup.Add.class, IBaseValidGroup.Update.class})
    @Column(name = "task_vehicle_internal_id")
    private String vehicleInternalId;

    /**
     * <pre>
     * DB remark: 车辆，车牌号
     * DB column: task_vehicle_license_plate	VARCHAR(20)	<--->	vehicleLicensePlate	java.lang.String
     * DB is  Nullable: true
     * DB defaultValue: null
     * </pre>
     */
    @Length(max = 20, message = "{SIO_TASK_BEAN_VEHICLE_LICENSE_PLATE_LENGTH}", groups = {IBaseValidGroup.Add.class, IBaseValidGroup.Update.class})
    @Column(name = "task_vehicle_license_plate")
    private String vehicleLicensePlate;

    /**
     * <pre>
     * DB remark: 车辆，描述信息
     * DB column: task_vehicle_description	VARCHAR(80)	<--->	vehicleDescription	java.lang.String
     * DB is  Nullable: true
     * DB defaultValue: null
     * </pre>
     */
    @Length(max = 80, message = "{SIO_TASK_BEAN_VEHICLE_DESCRIPTION_LENGTH}", groups = {IBaseValidGroup.Add.class, IBaseValidGroup.Update.class})
    @Column(name = "task_vehicle_description")
    private String vehicleDescription;

    /**
     * <pre>
     * DB remark: 车辆，货币容量
     * DB column: task_vehicle_currency_capacity	VARCHAR(15)	<--->	vehicleCurrencyCapacity	java.lang.String
     * DB is  Nullable: true
     * DB defaultValue: null
     * </pre>
     */
    @Length(max = 15, message = "{SIO_TASK_BEAN_VEHICLE_CURRENCY_CAPACITY_LENGTH}", groups = {IBaseValidGroup.Add.class, IBaseValidGroup.Update.class})
    @Column(name = "task_vehicle_currency_capacity")
    private String vehicleCurrencyCapacity;

    /**
     * <pre>
     * DB remark: 司机，SIO内部编号
     * DB column: task_driver_internal_id	VARCHAR(15)	<--->	driverInternalId	java.lang.String
     * DB is  Nullable: true
     * DB defaultValue: null
     * </pre>
     */
    @Length(max = 15, message = "{SIO_TASK_BEAN_DRIVER_INTERNAL_ID_LENGTH}", groups = {IBaseValidGroup.Add.class, IBaseValidGroup.Update.class})
    @Column(name = "task_driver_internal_id")
    private String driverInternalId;

    /**
     * <pre>
     * DB remark: 司机，姓名
     * DB column: task_driver_full_name	VARCHAR(50)	<--->	driverFullName	java.lang.String
     * DB is  Nullable: true
     * DB defaultValue: null
     * </pre>
     */
    @Length(max = 50, message = "{SIO_TASK_BEAN_DRIVER_FULL_NAME_LENGTH}", groups = {IBaseValidGroup.Add.class, IBaseValidGroup.Update.class})
    @Column(name = "task_driver_full_name")
    private String driverFullName;

    /**
     * <pre>
     * DB remark: 司机，父亲姓
     * DB column: task_driver_father_last_name	VARCHAR(50)	<--->	driverFatherLastName	java.lang.String
     * DB is  Nullable: true
     * DB defaultValue: null
     * </pre>
     */
    @Length(max = 50, message = "{SIO_TASK_BEAN_DRIVER_FATHER_LAST_NAME_LENGTH}", groups = {IBaseValidGroup.Add.class, IBaseValidGroup.Update.class})
    @Column(name = "task_driver_father_last_name")
    private String driverFatherLastName;

    /**
     * <pre>
     * DB remark: 司机，母亲姓
     * DB column: task_driver_mother_last_name	VARCHAR(50)	<--->	driverMotherLastName	java.lang.String
     * DB is  Nullable: true
     * DB defaultValue: null
     * </pre>
     */
    @Length(max = 50, message = "{SIO_TASK_BEAN_DRIVER_MOTHER_LAST_NAME_LENGTH}", groups = {IBaseValidGroup.Add.class, IBaseValidGroup.Update.class})
    @Column(name = "task_driver_mother_last_name")
    private String driverMotherLastName;

    /**
     * <pre>
     * DB remark: 司机，SIO内部部门，ID
     * DB column: task_driver_sio_department_id	VARCHAR(13)	<--->	driverSioDepartmentId	java.lang.String
     * DB is  Nullable: true
     * DB defaultValue: null
     * </pre>
     */
    @Length(max = 13, message = "{SIO_TASK_BEAN_DRIVER_SIO_DEPARTMENT_ID_LENGTH}", groups = {IBaseValidGroup.Add.class, IBaseValidGroup.Update.class})
    @Column(name = "task_driver_sio_department_id")
    private String driverSioDepartmentId;

    /**
     * <pre>
     * DB remark: 司机，SIO内部部门，描述
     * DB column: task_driver_sio_department_description	VARCHAR(100)	<--->	driverSioDepartmentDescription	java.lang.String
     * DB is  Nullable: true
     * DB defaultValue: null
     * </pre>
     */
    @Length(max = 100, message = "{SIO_TASK_BEAN_DRIVER_SIO_DEPARTMENT_DESCRIPTION_LENGTH}", groups = {IBaseValidGroup.Add.class, IBaseValidGroup.Update.class})
    @Column(name = "task_driver_sio_department_description")
    private String driverSioDepartmentDescription;

    /**
     * <pre>
     * DB remark: 司机，SIO内部角色，ID
     * DB column: task_driver_sio_role_id	VARCHAR(13)	<--->	driverSioRoleId	java.lang.String
     * DB is  Nullable: true
     * DB defaultValue: null
     * </pre>
     */
    @Length(max = 13, message = "{SIO_TASK_BEAN_DRIVER_SIO_ROLE_ID_LENGTH}", groups = {IBaseValidGroup.Add.class, IBaseValidGroup.Update.class})
    @Column(name = "task_driver_sio_role_id")
    private String driverSioRoleId;

    /**
     * <pre>
     * DB remark: 司机，SIO内部角色，描述
     * DB column: task_driver_sio_role_description	VARCHAR(100)	<--->	driverSioRoleDescription	java.lang.String
     * DB is  Nullable: true
     * DB defaultValue: null
     * </pre>
     */
    @Length(max = 100, message = "{SIO_TASK_BEAN_DRIVER_SIO_ROLE_DESCRIPTION_LENGTH}", groups = {IBaseValidGroup.Add.class, IBaseValidGroup.Update.class})
    @Column(name = "task_driver_sio_role_description")
    private String driverSioRoleDescription;

    /**
     * <pre>
     * DB remark: 司机，sio与comodin对应角色
     * DB column: task_driver_crew_type	CHAR(8)	<--->	driverCrewType	java.lang.String
     * DB is  Nullable: true
     * DB defaultValue: null
     * </pre>
     */
    @Length(max = 8, message = "{SIO_TASK_BEAN_DRIVER_CREW_TYPE_LENGTH}", groups = {IBaseValidGroup.Add.class, IBaseValidGroup.Update.class})
    @Column(name = "task_driver_crew_type")
    private String driverCrewType;

    /**
     * <pre>
     * DB remark: 出纳员，SIO内部编号
     * DB column: task_cashier_internal_id	VARCHAR(15)	<--->	cashierInternalId	java.lang.String
     * DB is  Nullable: true
     * DB defaultValue: null
     * </pre>
     */
    @Length(max = 15, message = "{SIO_TASK_BEAN_CASHIER_INTERNAL_ID_LENGTH}", groups = {IBaseValidGroup.Add.class, IBaseValidGroup.Update.class})
    @Column(name = "task_cashier_internal_id")
    private String cashierInternalId;

    /**
     * <pre>
     * DB remark: 出纳员，姓名
     * DB column: task_cashier_full_name	VARCHAR(50)	<--->	cashierFullName	java.lang.String
     * DB is  Nullable: true
     * DB defaultValue: null
     * </pre>
     */
    @Length(max = 50, message = "{SIO_TASK_BEAN_CASHIER_FULL_NAME_LENGTH}", groups = {IBaseValidGroup.Add.class, IBaseValidGroup.Update.class})
    @Column(name = "task_cashier_full_name")
    private String cashierFullName;

    /**
     * <pre>
     * DB remark: 出纳员，父亲姓
     * DB column: task_cashier_father_last_name	VARCHAR(50)	<--->	cashierFatherLastName	java.lang.String
     * DB is  Nullable: true
     * DB defaultValue: null
     * </pre>
     */
    @Length(max = 50, message = "{SIO_TASK_BEAN_CASHIER_FATHER_LAST_NAME_LENGTH}", groups = {IBaseValidGroup.Add.class, IBaseValidGroup.Update.class})
    @Column(name = "task_cashier_father_last_name")
    private String cashierFatherLastName;

    /**
     * <pre>
     * DB remark: 出纳员，母亲姓
     * DB column: task_cashier_mother_last_name	VARCHAR(50)	<--->	cashierMotherLastName	java.lang.String
     * DB is  Nullable: true
     * DB defaultValue: null
     * </pre>
     */
    @Length(max = 50, message = "{SIO_TASK_BEAN_CASHIER_MOTHER_LAST_NAME_LENGTH}", groups = {IBaseValidGroup.Add.class, IBaseValidGroup.Update.class})
    @Column(name = "task_cashier_mother_last_name")
    private String cashierMotherLastName;

    /**
     * <pre>
     * DB remark: 出纳员，SIO内部部门，ID
     * DB column: task_cashier_sio_department_id	VARCHAR(13)	<--->	cashierSioDepartmentId	java.lang.String
     * DB is  Nullable: true
     * DB defaultValue: null
     * </pre>
     */
    @Length(max = 13, message = "{SIO_TASK_BEAN_CASHIER_SIO_DEPARTMENT_ID_LENGTH}", groups = {IBaseValidGroup.Add.class, IBaseValidGroup.Update.class})
    @Column(name = "task_cashier_sio_department_id")
    private String cashierSioDepartmentId;

    /**
     * <pre>
     * DB remark: 出纳员，SIO内部部门，描述
     * DB column: task_cashier_sio_department_description	VARCHAR(100)	<--->	cashierSioDepartmentDescription	java.lang.String
     * DB is  Nullable: true
     * DB defaultValue: null
     * </pre>
     */
    @Length(max = 100, message = "{SIO_TASK_BEAN_CASHIER_SIO_DEPARTMENT_DESCRIPTION_LENGTH}", groups = {IBaseValidGroup.Add.class, IBaseValidGroup.Update.class})
    @Column(name = "task_cashier_sio_department_description")
    private String cashierSioDepartmentDescription;

    /**
     * <pre>
     * DB remark: 出纳员，SIO内部角色，ID
     * DB column: task_cashier_sio_role_id	VARCHAR(13)	<--->	cashierSioRoleId	java.lang.String
     * DB is  Nullable: true
     * DB defaultValue: null
     * </pre>
     */
    @Length(max = 13, message = "{SIO_TASK_BEAN_CASHIER_SIO_ROLE_ID_LENGTH}", groups = {IBaseValidGroup.Add.class, IBaseValidGroup.Update.class})
    @Column(name = "task_cashier_sio_role_id")
    private String cashierSioRoleId;

    /**
     * <pre>
     * DB remark: 出纳员，SIO内部角色，描述
     * DB column: task_cashier_sio_role_description	VARCHAR(100)	<--->	cashierSioRoleDescription	java.lang.String
     * DB is  Nullable: true
     * DB defaultValue: null
     * </pre>
     */
    @Length(max = 100, message = "{SIO_TASK_BEAN_CASHIER_SIO_ROLE_DESCRIPTION_LENGTH}", groups = {IBaseValidGroup.Add.class, IBaseValidGroup.Update.class})
    @Column(name = "task_cashier_sio_role_description")
    private String cashierSioRoleDescription;

    /**
     * <pre>
     * DB remark: 出纳员，sio与comodin对应角色
     * DB column: task_cashier_crew_type	CHAR(8)	<--->	cashierCrewType	java.lang.String
     * DB is  Nullable: true
     * DB defaultValue: null
     * </pre>
     */
    @Length(max = 8, message = "{SIO_TASK_BEAN_CASHIER_CREW_TYPE_LENGTH}", groups = {IBaseValidGroup.Add.class, IBaseValidGroup.Update.class})
    @Column(name = "task_cashier_crew_type")
    private String cashierCrewType;

    /**
     * <pre>
     * DB remark: 保镖1，SIO内部编号
     * DB column: task_security1_internal_id	VARCHAR(15)	<--->	security1InternalId	java.lang.String
     * DB is  Nullable: true
     * DB defaultValue: null
     * </pre>
     */
    @Length(max = 15, message = "{SIO_TASK_BEAN_SECURITY1_INTERNAL_ID_LENGTH}", groups = {IBaseValidGroup.Add.class, IBaseValidGroup.Update.class})
    @Column(name = "task_security1_internal_id")
    private String security1InternalId;

    /**
     * <pre>
     * DB remark: 保镖1，姓名
     * DB column: task_security1_full_name	VARCHAR(50)	<--->	security1FullName	java.lang.String
     * DB is  Nullable: true
     * DB defaultValue: null
     * </pre>
     */
    @Length(max = 50, message = "{SIO_TASK_BEAN_SECURITY1_FULL_NAME_LENGTH}", groups = {IBaseValidGroup.Add.class, IBaseValidGroup.Update.class})
    @Column(name = "task_security1_full_name")
    private String security1FullName;

    /**
     * <pre>
     * DB remark: 保镖1，父亲姓
     * DB column: task_security1_father_last_name	VARCHAR(50)	<--->	security1FatherLastName	java.lang.String
     * DB is  Nullable: true
     * DB defaultValue: null
     * </pre>
     */
    @Length(max = 50, message = "{SIO_TASK_BEAN_SECURITY1_FATHER_LAST_NAME_LENGTH}", groups = {IBaseValidGroup.Add.class, IBaseValidGroup.Update.class})
    @Column(name = "task_security1_father_last_name")
    private String security1FatherLastName;

    /**
     * <pre>
     * DB remark: 保镖1，母亲姓
     * DB column: task_security1_mother_last_name	VARCHAR(50)	<--->	security1MotherLastName	java.lang.String
     * DB is  Nullable: true
     * DB defaultValue: null
     * </pre>
     */
    @Length(max = 50, message = "{SIO_TASK_BEAN_SECURITY1_MOTHER_LAST_NAME_LENGTH}", groups = {IBaseValidGroup.Add.class, IBaseValidGroup.Update.class})
    @Column(name = "task_security1_mother_last_name")
    private String security1MotherLastName;

    /**
     * <pre>
     * DB remark: 保镖1，SIO内部部门，ID
     * DB column: task_security1_sio_department_id	VARCHAR(13)	<--->	security1SioDepartmentId	java.lang.String
     * DB is  Nullable: true
     * DB defaultValue: null
     * </pre>
     */
    @Length(max = 13, message = "{SIO_TASK_BEAN_SECURITY1_SIO_DEPARTMENT_ID_LENGTH}", groups = {IBaseValidGroup.Add.class, IBaseValidGroup.Update.class})
    @Column(name = "task_security1_sio_department_id")
    private String security1SioDepartmentId;

    /**
     * <pre>
     * DB remark: 保镖1，SIO内部部门，描述
     * DB column: task_security1_sio_department_description	VARCHAR(100)	<--->	security1SioDepartmentDescription	java.lang.String
     * DB is  Nullable: true
     * DB defaultValue: null
     * </pre>
     */
    @Length(max = 100, message = "{SIO_TASK_BEAN_SECURITY1_SIO_DEPARTMENT_DESCRIPTION_LENGTH}", groups = {IBaseValidGroup.Add.class, IBaseValidGroup.Update.class})
    @Column(name = "task_security1_sio_department_description")
    private String security1SioDepartmentDescription;

    /**
     * <pre>
     * DB remark: 保镖1，SIO内部角色，ID
     * DB column: task_security1_sio_role_id	VARCHAR(13)	<--->	security1SioRoleId	java.lang.String
     * DB is  Nullable: true
     * DB defaultValue: null
     * </pre>
     */
    @Length(max = 13, message = "{SIO_TASK_BEAN_SECURITY1_SIO_ROLE_ID_LENGTH}", groups = {IBaseValidGroup.Add.class, IBaseValidGroup.Update.class})
    @Column(name = "task_security1_sio_role_id")
    private String security1SioRoleId;

    /**
     * <pre>
     * DB remark: 保镖1，SIO内部角色，描述
     * DB column: task_security1_sio_role_description	VARCHAR(100)	<--->	security1SioRoleDescription	java.lang.String
     * DB is  Nullable: true
     * DB defaultValue: null
     * </pre>
     */
    @Length(max = 100, message = "{SIO_TASK_BEAN_SECURITY1_SIO_ROLE_DESCRIPTION_LENGTH}", groups = {IBaseValidGroup.Add.class, IBaseValidGroup.Update.class})
    @Column(name = "task_security1_sio_role_description")
    private String security1SioRoleDescription;

    /**
     * <pre>
     * DB remark: 保镖1，sio与comodin对应角色
     * DB column: task_security1_crew_type	CHAR(8)	<--->	security1CrewType	java.lang.String
     * DB is  Nullable: true
     * DB defaultValue: null
     * </pre>
     */
    @Length(max = 8, message = "{SIO_TASK_BEAN_SECURITY1_CREW_TYPE_LENGTH}", groups = {IBaseValidGroup.Add.class, IBaseValidGroup.Update.class})
    @Column(name = "task_security1_crew_type")
    private String security1CrewType;

    /**
     * <pre>
     * DB remark: 保镖2，SIO内部编号
     * DB column: task_security2_internal_id	VARCHAR(15)	<--->	security2InternalId	java.lang.String
     * DB is  Nullable: true
     * DB defaultValue: null
     * </pre>
     */
    @Length(max = 15, message = "{SIO_TASK_BEAN_SECURITY2_INTERNAL_ID_LENGTH}", groups = {IBaseValidGroup.Add.class, IBaseValidGroup.Update.class})
    @Column(name = "task_security2_internal_id")
    private String security2InternalId;

    /**
     * <pre>
     * DB remark: 保镖2，姓名
     * DB column: task_security2_full_name	VARCHAR(50)	<--->	security2FullName	java.lang.String
     * DB is  Nullable: true
     * DB defaultValue: null
     * </pre>
     */
    @Length(max = 50, message = "{SIO_TASK_BEAN_SECURITY2_FULL_NAME_LENGTH}", groups = {IBaseValidGroup.Add.class, IBaseValidGroup.Update.class})
    @Column(name = "task_security2_full_name")
    private String security2FullName;

    /**
     * <pre>
     * DB remark: 保镖2，父亲姓
     * DB column: task_security2_father_last_name	VARCHAR(50)	<--->	security2FatherLastName	java.lang.String
     * DB is  Nullable: true
     * DB defaultValue: null
     * </pre>
     */
    @Length(max = 50, message = "{SIO_TASK_BEAN_SECURITY2_FATHER_LAST_NAME_LENGTH}", groups = {IBaseValidGroup.Add.class, IBaseValidGroup.Update.class})
    @Column(name = "task_security2_father_last_name")
    private String security2FatherLastName;

    /**
     * <pre>
     * DB remark: 保镖2，母亲姓
     * DB column: task_security2_mother_last_name	VARCHAR(50)	<--->	security2MotherLastName	java.lang.String
     * DB is  Nullable: true
     * DB defaultValue: null
     * </pre>
     */
    @Length(max = 50, message = "{SIO_TASK_BEAN_SECURITY2_MOTHER_LAST_NAME_LENGTH}", groups = {IBaseValidGroup.Add.class, IBaseValidGroup.Update.class})
    @Column(name = "task_security2_mother_last_name")
    private String security2MotherLastName;

    /**
     * <pre>
     * DB remark: 保镖2，SIO内部部门，ID
     * DB column: task_security2_sio_department_id	VARCHAR(13)	<--->	security2SioDepartmentId	java.lang.String
     * DB is  Nullable: true
     * DB defaultValue: null
     * </pre>
     */
    @Length(max = 13, message = "{SIO_TASK_BEAN_SECURITY2_SIO_DEPARTMENT_ID_LENGTH}", groups = {IBaseValidGroup.Add.class, IBaseValidGroup.Update.class})
    @Column(name = "task_security2_sio_department_id")
    private String security2SioDepartmentId;

    /**
     * <pre>
     * DB remark: 保镖2，SIO内部部门，描述
     * DB column: task_security2_sio_department_description	VARCHAR(100)	<--->	security2SioDepartmentDescription	java.lang.String
     * DB is  Nullable: true
     * DB defaultValue: null
     * </pre>
     */
    @Length(max = 100, message = "{SIO_TASK_BEAN_SECURITY2_SIO_DEPARTMENT_DESCRIPTION_LENGTH}", groups = {IBaseValidGroup.Add.class, IBaseValidGroup.Update.class})
    @Column(name = "task_security2_sio_department_description")
    private String security2SioDepartmentDescription;

    /**
     * <pre>
     * DB remark: 保镖2，SIO内部角色，ID
     * DB column: task_security2_sio_role_id	VARCHAR(13)	<--->	security2SioRoleId	java.lang.String
     * DB is  Nullable: true
     * DB defaultValue: null
     * </pre>
     */
    @Length(max = 13, message = "{SIO_TASK_BEAN_SECURITY2_SIO_ROLE_ID_LENGTH}", groups = {IBaseValidGroup.Add.class, IBaseValidGroup.Update.class})
    @Column(name = "task_security2_sio_role_id")
    private String security2SioRoleId;

    /**
     * <pre>
     * DB remark: 保镖2，SIO内部角色，描述
     * DB column: task_security2_sio_role_description	VARCHAR(100)	<--->	security2SioRoleDescription	java.lang.String
     * DB is  Nullable: true
     * DB defaultValue: null
     * </pre>
     */
    @Length(max = 100, message = "{SIO_TASK_BEAN_SECURITY2_SIO_ROLE_DESCRIPTION_LENGTH}", groups = {IBaseValidGroup.Add.class, IBaseValidGroup.Update.class})
    @Column(name = "task_security2_sio_role_description")
    private String security2SioRoleDescription;

    /**
     * <pre>
     * DB remark: 保镖2，sio与comodin对应角色
     * DB column: task_security2_crew_type	CHAR(8)	<--->	security2CrewType	java.lang.String
     * DB is  Nullable: true
     * DB defaultValue: null
     * </pre>
     */
    @Length(max = 8, message = "{SIO_TASK_BEAN_SECURITY2_CREW_TYPE_LENGTH}", groups = {IBaseValidGroup.Add.class, IBaseValidGroup.Update.class})
    @Column(name = "task_security2_crew_type")
    private String security2CrewType;

    /**
     * <pre>
     * DB remark: 保镖3，SIO内部编号
     * DB column: task_security3_internal_id	VARCHAR(15)	<--->	security3InternalId	java.lang.String
     * DB is  Nullable: true
     * DB defaultValue: null
     * </pre>
     */
    @Length(max = 15, message = "{SIO_TASK_BEAN_SECURITY3_INTERNAL_ID_LENGTH}", groups = {IBaseValidGroup.Add.class, IBaseValidGroup.Update.class})
    @Column(name = "task_security3_internal_id")
    private String security3InternalId;

    /**
     * <pre>
     * DB remark: 保镖3，姓名
     * DB column: task_security3_full_name	VARCHAR(50)	<--->	security3FullName	java.lang.String
     * DB is  Nullable: true
     * DB defaultValue: null
     * </pre>
     */
    @Length(max = 50, message = "{SIO_TASK_BEAN_SECURITY3_FULL_NAME_LENGTH}", groups = {IBaseValidGroup.Add.class, IBaseValidGroup.Update.class})
    @Column(name = "task_security3_full_name")
    private String security3FullName;

    /**
     * <pre>
     * DB remark: 保镖3，父亲姓
     * DB column: task_security3_father_last_name	VARCHAR(50)	<--->	security3FatherLastName	java.lang.String
     * DB is  Nullable: true
     * DB defaultValue: null
     * </pre>
     */
    @Length(max = 50, message = "{SIO_TASK_BEAN_SECURITY3_FATHER_LAST_NAME_LENGTH}", groups = {IBaseValidGroup.Add.class, IBaseValidGroup.Update.class})
    @Column(name = "task_security3_father_last_name")
    private String security3FatherLastName;

    /**
     * <pre>
     * DB remark: 保镖3，母亲姓
     * DB column: task_security3_mother_last_name	VARCHAR(50)	<--->	security3MotherLastName	java.lang.String
     * DB is  Nullable: true
     * DB defaultValue: null
     * </pre>
     */
    @Length(max = 50, message = "{SIO_TASK_BEAN_SECURITY3_MOTHER_LAST_NAME_LENGTH}", groups = {IBaseValidGroup.Add.class, IBaseValidGroup.Update.class})
    @Column(name = "task_security3_mother_last_name")
    private String security3MotherLastName;

    /**
     * <pre>
     * DB remark: 保镖3，SIO内部部门，ID
     * DB column: task_security3_sio_department_id	VARCHAR(13)	<--->	security3SioDepartmentId	java.lang.String
     * DB is  Nullable: true
     * DB defaultValue: null
     * </pre>
     */
    @Length(max = 13, message = "{SIO_TASK_BEAN_SECURITY3_SIO_DEPARTMENT_ID_LENGTH}", groups = {IBaseValidGroup.Add.class, IBaseValidGroup.Update.class})
    @Column(name = "task_security3_sio_department_id")
    private String security3SioDepartmentId;

    /**
     * <pre>
     * DB remark: 保镖3，SIO内部部门，描述
     * DB column: task_security3_sio_department_description	VARCHAR(100)	<--->	security3SioDepartmentDescription	java.lang.String
     * DB is  Nullable: true
     * DB defaultValue: null
     * </pre>
     */
    @Length(max = 100, message = "{SIO_TASK_BEAN_SECURITY3_SIO_DEPARTMENT_DESCRIPTION_LENGTH}", groups = {IBaseValidGroup.Add.class, IBaseValidGroup.Update.class})
    @Column(name = "task_security3_sio_department_description")
    private String security3SioDepartmentDescription;

    /**
     * <pre>
     * DB remark: 保镖3，SIO内部角色，ID
     * DB column: task_security3_sio_role_id	VARCHAR(13)	<--->	security3SioRoleId	java.lang.String
     * DB is  Nullable: true
     * DB defaultValue: null
     * </pre>
     */
    @Length(max = 13, message = "{SIO_TASK_BEAN_SECURITY3_SIO_ROLE_ID_LENGTH}", groups = {IBaseValidGroup.Add.class, IBaseValidGroup.Update.class})
    @Column(name = "task_security3_sio_role_id")
    private String security3SioRoleId;

    /**
     * <pre>
     * DB remark: 保镖3，SIO内部角色，描述
     * DB column: task_security3_sio_role_description	VARCHAR(100)	<--->	security3SioRoleDescription	java.lang.String
     * DB is  Nullable: true
     * DB defaultValue: null
     * </pre>
     */
    @Length(max = 100, message = "{SIO_TASK_BEAN_SECURITY3_SIO_ROLE_DESCRIPTION_LENGTH}", groups = {IBaseValidGroup.Add.class, IBaseValidGroup.Update.class})
    @Column(name = "task_security3_sio_role_description")
    private String security3SioRoleDescription;

    /**
     * <pre>
     * DB remark: 保镖3，sio与comodin对应角色
     * DB column: task_security3_crew_type	CHAR(8)	<--->	security3CrewType	java.lang.String
     * DB is  Nullable: true
     * DB defaultValue: null
     * </pre>
     */
    @Length(max = 8, message = "{SIO_TASK_BEAN_SECURITY3_CREW_TYPE_LENGTH}", groups = {IBaseValidGroup.Add.class, IBaseValidGroup.Update.class})
    @Column(name = "task_security3_crew_type")
    private String security3CrewType;

    /**
     * <pre>
     * DB remark: 保镖4，SIO内部编号
     * DB column: task_security4_internal_id	VARCHAR(15)	<--->	security4InternalId	java.lang.String
     * DB is  Nullable: true
     * DB defaultValue: null
     * </pre>
     */
    @Length(max = 15, message = "{SIO_TASK_BEAN_SECURITY4_INTERNAL_ID_LENGTH}", groups = {IBaseValidGroup.Add.class, IBaseValidGroup.Update.class})
    @Column(name = "task_security4_internal_id")
    private String security4InternalId;

    /**
     * <pre>
     * DB remark: 保镖4，姓名
     * DB column: task_security4_full_name	VARCHAR(50)	<--->	security4FullName	java.lang.String
     * DB is  Nullable: true
     * DB defaultValue: null
     * </pre>
     */
    @Length(max = 50, message = "{SIO_TASK_BEAN_SECURITY4_FULL_NAME_LENGTH}", groups = {IBaseValidGroup.Add.class, IBaseValidGroup.Update.class})
    @Column(name = "task_security4_full_name")
    private String security4FullName;

    /**
     * <pre>
     * DB remark: 保镖4，父亲姓
     * DB column: task_security4_father_last_name	VARCHAR(50)	<--->	security4FatherLastName	java.lang.String
     * DB is  Nullable: true
     * DB defaultValue: null
     * </pre>
     */
    @Length(max = 50, message = "{SIO_TASK_BEAN_SECURITY4_FATHER_LAST_NAME_LENGTH}", groups = {IBaseValidGroup.Add.class, IBaseValidGroup.Update.class})
    @Column(name = "task_security4_father_last_name")
    private String security4FatherLastName;

    /**
     * <pre>
     * DB remark: 保镖4，母亲姓
     * DB column: task_security4_mother_last_name	VARCHAR(50)	<--->	security4MotherLastName	java.lang.String
     * DB is  Nullable: true
     * DB defaultValue: null
     * </pre>
     */
    @Length(max = 50, message = "{SIO_TASK_BEAN_SECURITY4_MOTHER_LAST_NAME_LENGTH}", groups = {IBaseValidGroup.Add.class, IBaseValidGroup.Update.class})
    @Column(name = "task_security4_mother_last_name")
    private String security4MotherLastName;

    /**
     * <pre>
     * DB remark: 保镖4，SIO内部部门，ID
     * DB column: task_security4_sio_department_id	VARCHAR(13)	<--->	security4SioDepartmentId	java.lang.String
     * DB is  Nullable: true
     * DB defaultValue: null
     * </pre>
     */
    @Length(max = 13, message = "{SIO_TASK_BEAN_SECURITY4_SIO_DEPARTMENT_ID_LENGTH}", groups = {IBaseValidGroup.Add.class, IBaseValidGroup.Update.class})
    @Column(name = "task_security4_sio_department_id")
    private String security4SioDepartmentId;

    /**
     * <pre>
     * DB remark: 保镖4，SIO内部部门，描述
     * DB column: task_security4_sio_department_description	VARCHAR(100)	<--->	security4SioDepartmentDescription	java.lang.String
     * DB is  Nullable: true
     * DB defaultValue: null
     * </pre>
     */
    @Length(max = 100, message = "{SIO_TASK_BEAN_SECURITY4_SIO_DEPARTMENT_DESCRIPTION_LENGTH}", groups = {IBaseValidGroup.Add.class, IBaseValidGroup.Update.class})
    @Column(name = "task_security4_sio_department_description")
    private String security4SioDepartmentDescription;

    /**
     * <pre>
     * DB remark: 保镖4，SIO内部角色，ID
     * DB column: task_security4_sio_role_id	VARCHAR(13)	<--->	security4SioRoleId	java.lang.String
     * DB is  Nullable: true
     * DB defaultValue: null
     * </pre>
     */
    @Length(max = 13, message = "{SIO_TASK_BEAN_SECURITY4_SIO_ROLE_ID_LENGTH}", groups = {IBaseValidGroup.Add.class, IBaseValidGroup.Update.class})
    @Column(name = "task_security4_sio_role_id")
    private String security4SioRoleId;

    /**
     * <pre>
     * DB remark: 保镖4，SIO内部角色，描述
     * DB column: task_security4_sio_role_description	VARCHAR(100)	<--->	security4SioRoleDescription	java.lang.String
     * DB is  Nullable: true
     * DB defaultValue: null
     * </pre>
     */
    @Length(max = 100, message = "{SIO_TASK_BEAN_SECURITY4_SIO_ROLE_DESCRIPTION_LENGTH}", groups = {IBaseValidGroup.Add.class, IBaseValidGroup.Update.class})
    @Column(name = "task_security4_sio_role_description")
    private String security4SioRoleDescription;

    /**
     * <pre>
     * DB remark: 保镖4，sio与comodin对应角色
     * DB column: task_security4_crew_type	CHAR(8)	<--->	security4CrewType	java.lang.String
     * DB is  Nullable: true
     * DB defaultValue: null
     * </pre>
     */
    @Length(max = 8, message = "{SIO_TASK_BEAN_SECURITY4_CREW_TYPE_LENGTH}", groups = {IBaseValidGroup.Add.class, IBaseValidGroup.Update.class})
    @Column(name = "task_security4_crew_type")
    private String security4CrewType;

    /**
     * <pre>
     * DB remark: 计数者，SIO内部编号
     * DB column: task_counter_internal_id	VARCHAR(15)	<--->	counterInternalId	java.lang.String
     * DB is  Nullable: true
     * DB defaultValue: null
     * </pre>
     */
    @Length(max = 15, message = "{SIO_TASK_BEAN_COUNTER_INTERNAL_ID_LENGTH}", groups = {IBaseValidGroup.Add.class, IBaseValidGroup.Update.class})
    @Column(name = "task_counter_internal_id")
    private String counterInternalId;

    /**
     * <pre>
     * DB remark: 计数者，姓名
     * DB column: task_counter_full_name	VARCHAR(50)	<--->	counterFullName	java.lang.String
     * DB is  Nullable: true
     * DB defaultValue: null
     * </pre>
     */
    @Length(max = 50, message = "{SIO_TASK_BEAN_COUNTER_FULL_NAME_LENGTH}", groups = {IBaseValidGroup.Add.class, IBaseValidGroup.Update.class})
    @Column(name = "task_counter_full_name")
    private String counterFullName;

    /**
     * <pre>
     * DB remark: 计数者，父亲姓
     * DB column: task_counter_father_last_name	VARCHAR(50)	<--->	counterFatherLastName	java.lang.String
     * DB is  Nullable: true
     * DB defaultValue: null
     * </pre>
     */
    @Length(max = 50, message = "{SIO_TASK_BEAN_COUNTER_FATHER_LAST_NAME_LENGTH}", groups = {IBaseValidGroup.Add.class, IBaseValidGroup.Update.class})
    @Column(name = "task_counter_father_last_name")
    private String counterFatherLastName;

    /**
     * <pre>
     * DB remark: 计数者，母亲姓
     * DB column: task_counter_mother_last_name	VARCHAR(50)	<--->	counterMotherLastName	java.lang.String
     * DB is  Nullable: true
     * DB defaultValue: null
     * </pre>
     */
    @Length(max = 50, message = "{SIO_TASK_BEAN_COUNTER_MOTHER_LAST_NAME_LENGTH}", groups = {IBaseValidGroup.Add.class, IBaseValidGroup.Update.class})
    @Column(name = "task_counter_mother_last_name")
    private String counterMotherLastName;

    /**
     * <pre>
     * DB remark: 计数者，SIO内部部门，ID
     * DB column: task_counter_sio_department_id	VARCHAR(13)	<--->	counterSioDepartmentId	java.lang.String
     * DB is  Nullable: true
     * DB defaultValue: null
     * </pre>
     */
    @Length(max = 13, message = "{SIO_TASK_BEAN_COUNTER_SIO_DEPARTMENT_ID_LENGTH}", groups = {IBaseValidGroup.Add.class, IBaseValidGroup.Update.class})
    @Column(name = "task_counter_sio_department_id")
    private String counterSioDepartmentId;

    /**
     * <pre>
     * DB remark: 计数者，SIO内部部门，描述
     * DB column: task_counter_sio_department_description	VARCHAR(100)	<--->	counterSioDepartmentDescription	java.lang.String
     * DB is  Nullable: true
     * DB defaultValue: null
     * </pre>
     */
    @Length(max = 100, message = "{SIO_TASK_BEAN_COUNTER_SIO_DEPARTMENT_DESCRIPTION_LENGTH}", groups = {IBaseValidGroup.Add.class, IBaseValidGroup.Update.class})
    @Column(name = "task_counter_sio_department_description")
    private String counterSioDepartmentDescription;

    /**
     * <pre>
     * DB remark: 计数者，SIO内部角色，ID
     * DB column: task_counter_sio_role_id	VARCHAR(13)	<--->	counterSioRoleId	java.lang.String
     * DB is  Nullable: true
     * DB defaultValue: null
     * </pre>
     */
    @Length(max = 13, message = "{SIO_TASK_BEAN_COUNTER_SIO_ROLE_ID_LENGTH}", groups = {IBaseValidGroup.Add.class, IBaseValidGroup.Update.class})
    @Column(name = "task_counter_sio_role_id")
    private String counterSioRoleId;

    /**
     * <pre>
     * DB remark: 计数者，SIO内部角色，描述
     * DB column: task_counter_sio_role_description	VARCHAR(100)	<--->	counterSioRoleDescription	java.lang.String
     * DB is  Nullable: true
     * DB defaultValue: null
     * </pre>
     */
    @Length(max = 100, message = "{SIO_TASK_BEAN_COUNTER_SIO_ROLE_DESCRIPTION_LENGTH}", groups = {IBaseValidGroup.Add.class, IBaseValidGroup.Update.class})
    @Column(name = "task_counter_sio_role_description")
    private String counterSioRoleDescription;

    /**
     * <pre>
     * DB remark: 计数者，sio与comodin对应角色
     * DB column: task_counter_crew_type	CHAR(8)	<--->	counterCrewType	java.lang.String
     * DB is  Nullable: true
     * DB defaultValue: null
     * </pre>
     */
    @Length(max = 8, message = "{SIO_TASK_BEAN_COUNTER_CREW_TYPE_LENGTH}", groups = {IBaseValidGroup.Add.class, IBaseValidGroup.Update.class})
    @Column(name = "task_counter_crew_type")
    private String counterCrewType;

    /**
     * <pre>
     * DB remark: 付款人，SIO内部编号
     * DB column: task_drawee_internal_id	VARCHAR(15)	<--->	draweeInternalId	java.lang.String
     * DB is  Nullable: true
     * DB defaultValue: null
     * </pre>
     */
    @Length(max = 15, message = "{SIO_TASK_BEAN_DRAWEE_INTERNAL_ID_LENGTH}", groups = {IBaseValidGroup.Add.class, IBaseValidGroup.Update.class})
    @Column(name = "task_drawee_internal_id")
    private String draweeInternalId;

    /**
     * <pre>
     * DB remark: 付款人，姓名
     * DB column: task_drawee_full_name	VARCHAR(50)	<--->	draweeFullName	java.lang.String
     * DB is  Nullable: true
     * DB defaultValue: null
     * </pre>
     */
    @Length(max = 50, message = "{SIO_TASK_BEAN_DRAWEE_FULL_NAME_LENGTH}", groups = {IBaseValidGroup.Add.class, IBaseValidGroup.Update.class})
    @Column(name = "task_drawee_full_name")
    private String draweeFullName;

    /**
     * <pre>
     * DB remark: 付款人，父亲姓
     * DB column: task_drawee_father_last_name	VARCHAR(50)	<--->	draweeFatherLastName	java.lang.String
     * DB is  Nullable: true
     * DB defaultValue: null
     * </pre>
     */
    @Length(max = 50, message = "{SIO_TASK_BEAN_DRAWEE_FATHER_LAST_NAME_LENGTH}", groups = {IBaseValidGroup.Add.class, IBaseValidGroup.Update.class})
    @Column(name = "task_drawee_father_last_name")
    private String draweeFatherLastName;

    /**
     * <pre>
     * DB remark: 付款人，母亲姓
     * DB column: task_drawee_mother_last_name	VARCHAR(50)	<--->	draweeMotherLastName	java.lang.String
     * DB is  Nullable: true
     * DB defaultValue: null
     * </pre>
     */
    @Length(max = 50, message = "{SIO_TASK_BEAN_DRAWEE_MOTHER_LAST_NAME_LENGTH}", groups = {IBaseValidGroup.Add.class, IBaseValidGroup.Update.class})
    @Column(name = "task_drawee_mother_last_name")
    private String draweeMotherLastName;

    /**
     * <pre>
     * DB remark: 付款人，SIO内部部门，ID
     * DB column: task_drawee_sio_department_id	VARCHAR(13)	<--->	draweeSioDepartmentId	java.lang.String
     * DB is  Nullable: true
     * DB defaultValue: null
     * </pre>
     */
    @Length(max = 13, message = "{SIO_TASK_BEAN_DRAWEE_SIO_DEPARTMENT_ID_LENGTH}", groups = {IBaseValidGroup.Add.class, IBaseValidGroup.Update.class})
    @Column(name = "task_drawee_sio_department_id")
    private String draweeSioDepartmentId;

    /**
     * <pre>
     * DB remark: 付款人，SIO内部部门，描述
     * DB column: task_drawee_sio_department_description	VARCHAR(100)	<--->	draweeSioDepartmentDescription	java.lang.String
     * DB is  Nullable: true
     * DB defaultValue: null
     * </pre>
     */
    @Length(max = 100, message = "{SIO_TASK_BEAN_DRAWEE_SIO_DEPARTMENT_DESCRIPTION_LENGTH}", groups = {IBaseValidGroup.Add.class, IBaseValidGroup.Update.class})
    @Column(name = "task_drawee_sio_department_description")
    private String draweeSioDepartmentDescription;

    /**
     * <pre>
     * DB remark: 付款人，SIO内部角色，ID
     * DB column: task_drawee_sio_role_id	VARCHAR(13)	<--->	draweeSioRoleId	java.lang.String
     * DB is  Nullable: true
     * DB defaultValue: null
     * </pre>
     */
    @Length(max = 13, message = "{SIO_TASK_BEAN_DRAWEE_SIO_ROLE_ID_LENGTH}", groups = {IBaseValidGroup.Add.class, IBaseValidGroup.Update.class})
    @Column(name = "task_drawee_sio_role_id")
    private String draweeSioRoleId;

    /**
     * <pre>
     * DB remark: 付款人，SIO内部角色，描述
     * DB column: task_drawee_sio_role_description	VARCHAR(100)	<--->	draweeSioRoleDescription	java.lang.String
     * DB is  Nullable: true
     * DB defaultValue: null
     * </pre>
     */
    @Length(max = 100, message = "{SIO_TASK_BEAN_DRAWEE_SIO_ROLE_DESCRIPTION_LENGTH}", groups = {IBaseValidGroup.Add.class, IBaseValidGroup.Update.class})
    @Column(name = "task_drawee_sio_role_description")
    private String draweeSioRoleDescription;

    /**
     * <pre>
     * DB remark: 付款人，sio与comodin对应角色
     * DB column: task_drawee_crew_type	CHAR(8)	<--->	draweeCrewType	java.lang.String
     * DB is  Nullable: true
     * DB defaultValue: null
     * </pre>
     */
    @Length(max = 8, message = "{SIO_TASK_BEAN_DRAWEE_CREW_TYPE_LENGTH}", groups = {IBaseValidGroup.Add.class, IBaseValidGroup.Update.class})
    @Column(name = "task_drawee_crew_type")
    private String draweeCrewType;

    /**
     * <pre>
     * DB remark: XML，每个任务的最后的员工节点
     * DB column: task_crew_crew_json	VARCHAR(1024)	<--->	crewCrewJson	java.lang.String
     * DB is  Nullable: true
     * DB defaultValue: null
     * </pre>
     */
    @Length(max = 1024, message = "{SIO_TASK_BEAN_CREW_CREW_JSON_LENGTH}", groups = {IBaseValidGroup.Add.class, IBaseValidGroup.Update.class})
    @Column(name = "task_crew_crew_json")
    private String crewCrewJson;

    /**
     * <pre>
     * DB remark: 创建时间
     * DB column: task_create_timestamp	TIMESTAMP(19)	<--->	createTimestamp	java.util.Date
     * DB is  Nullable: false
     * DB defaultValue: CURRENT_TIMESTAMP
     * </pre>
     */
    @ValidDateTimeFormat(pattern = DateUtil.DATE_PATTERN_YYYY_MM_DD_HH_MM_SS , message = "{SIO_TASK_BEAN_CREATE_TIMESTAMP_DATE_TIME_FORMAT}", groups = {IBaseValidGroup.Add.class, IBaseValidGroup.Update.class})
    @DateTimeFormat(pattern = DateUtil.DATE_PATTERN_YYYY_MM_DD_HH_MM_SS)
    @NotNull(message = "{SIO_TASK_BEAN_CREATE_TIMESTAMP_NOT_NULL}", groups = {IBaseValidGroup.Add.class, IBaseValidGroup.Update.class})
    @Column(name = "task_create_timestamp")
    private Date createTimestamp;

    /**
     * <pre>
     * DB remark: 谁新增了该员工,与crew_username字段关联 若为系统生成创建者为:SYSTEM
     * DB column: task_create_by	VARCHAR(20)	<--->	createBy	java.lang.String
     * DB is  Nullable: false
     * DB defaultValue: null
     * </pre>
     */
    @NotBlank(message = "{SIO_TASK_BEAN_CREATE_BY_NOT_BLANK}", groups = {IBaseValidGroup.Add.class, IBaseValidGroup.Update.class})
    @Length(max = 20, message = "{SIO_TASK_BEAN_CREATE_BY_LENGTH}", groups = {IBaseValidGroup.Add.class, IBaseValidGroup.Update.class})
    @Column(name = "task_create_by")
    private String createBy;

    /**
     * <pre>
     * DB remark: 逻辑删除标志【N[正常]，Y[删除]】
     * DB column: task_delete_flag	CHAR(1)	<--->	deleteFlag	java.lang.String
     * DB is  Nullable: false
     * DB defaultValue: N
     * </pre>
     */
    @NotBlank(message = "{SIO_TASK_BEAN_DELETE_FLAG_NOT_BLANK}", groups = {IBaseValidGroup.Add.class, IBaseValidGroup.Update.class})
    @Length(max = 1, message = "{SIO_TASK_BEAN_DELETE_FLAG_LENGTH}", groups = {IBaseValidGroup.Add.class, IBaseValidGroup.Update.class})
    @Column(name = "task_delete_flag")
    private String deleteFlag;

    private static final long serialVersionUID = 1L;

    /**
     * 获取 数据库主键ID
     *
     * @return task_id - 数据库主键ID
     */
    public Long getId() {
        return id;
    }

    /**
     * 设置 数据库主键ID
     *
     * @param id - 数据库主键ID
     */
    public SioTaskBean setId(Long id) {
        this.id = id;
        return this;
    }

    /**
     * 获取 SIO任务ID组成方式【|4|26|20161118|1101|1|】【|SIO公司内部ID|SIO公司网点内部ID|路线日期[yyyyMMdd]|路线ID|任务ID|】【date:2016-12-12 by:supeng】
     *
     * @return task_task_original_complex_id - SIO任务ID组成方式【|4|26|20161118|1101|1|】【|SIO公司内部ID|SIO公司网点内部ID|路线日期[yyyyMMdd]|路线ID|任务ID|】【date:2016-12-12 by:supeng】
     */
    public String getTaskOriginalComplexId() {
        return taskOriginalComplexId;
    }

    /**
     * 设置 SIO任务ID组成方式【|4|26|20161118|1101|1|】【|SIO公司内部ID|SIO公司网点内部ID|路线日期[yyyyMMdd]|路线ID|任务ID|】【date:2016-12-12 by:supeng】
     *
     * @param taskOriginalComplexId - SIO任务ID组成方式【|4|26|20161118|1101|1|】【|SIO公司内部ID|SIO公司网点内部ID|路线日期[yyyyMMdd]|路线ID|任务ID|】【date:2016-12-12 by:supeng】
     */
    public SioTaskBean setTaskOriginalComplexId(String taskOriginalComplexId) {
        this.taskOriginalComplexId = taskOriginalComplexId == null ? null : taskOriginalComplexId.trim();
        return this;
    }

    /**
     * 获取 任务来源于SIO某分公司，SIO分公司内部编号
     *
     * @return task_route_company_internal_id - 任务来源于SIO某分公司，SIO分公司内部编号
     */
    public String getRouteCompanyInternalId() {
        return routeCompanyInternalId;
    }

    /**
     * 设置 任务来源于SIO某分公司，SIO分公司内部编号
     *
     * @param routeCompanyInternalId - 任务来源于SIO某分公司，SIO分公司内部编号
     */
    public SioTaskBean setRouteCompanyInternalId(String routeCompanyInternalId) {
        this.routeCompanyInternalId = routeCompanyInternalId == null ? null : routeCompanyInternalId.trim();
        return this;
    }

    /**
     * 获取 任务来源于SIO某分公司的哪个分支网点，SIO分支网点的内部编号
     *
     * @return task_route_branch_internal_id - 任务来源于SIO某分公司的哪个分支网点，SIO分支网点的内部编号
     */
    public String getRouteBranchInternalId() {
        return routeBranchInternalId;
    }

    /**
     * 设置 任务来源于SIO某分公司的哪个分支网点，SIO分支网点的内部编号
     *
     * @param routeBranchInternalId - 任务来源于SIO某分公司的哪个分支网点，SIO分支网点的内部编号
     */
    public SioTaskBean setRouteBranchInternalId(String routeBranchInternalId) {
        this.routeBranchInternalId = routeBranchInternalId == null ? null : routeBranchInternalId.trim();
        return this;
    }

    /**
     * 获取 路线日期 [即任务服务日期]
     *
     * @return task_route_service_date - 路线日期 [即任务服务日期]
     */
    public String getRouteServiceDate() {
        return routeServiceDate;
    }

    /**
     * 设置 路线日期 [即任务服务日期]
     *
     * @param routeServiceDate - 路线日期 [即任务服务日期]
     */
    public SioTaskBean setRouteServiceDate(String routeServiceDate) {
        this.routeServiceDate = routeServiceDate == null ? null : routeServiceDate.trim();
        return this;
    }

    /**
     * 获取 路线ID
     *
     * @return task_route_id - 路线ID
     */
    public String getRouteId() {
        return routeId;
    }

    /**
     * 设置 路线ID
     *
     * @param routeId - 路线ID
     */
    public SioTaskBean setRouteId(String routeId) {
        this.routeId = routeId == null ? null : routeId.trim();
        return this;
    }

    /**
     * 获取 路线状态类型，详情参考 Rules.xls中的 工作表 Tes中
     *
     * @return task_route_status - 路线状态类型，详情参考 Rules.xls中的 工作表 Tes中
     */
    public String getRouteStatus() {
        return routeStatus;
    }

    /**
     * 设置 路线状态类型，详情参考 Rules.xls中的 工作表 Tes中
     *
     * @param routeStatus - 路线状态类型，详情参考 Rules.xls中的 工作表 Tes中
     */
    public SioTaskBean setRouteStatus(String routeStatus) {
        this.routeStatus = routeStatus == null ? null : routeStatus.trim();
        return this;
    }

    /**
     *
     * @return task_route_username
     */
    public String getRouteUsername() {
        return routeUsername;
    }

    /**
     *
     * @param routeUsername - 
     */
    public SioTaskBean setRouteUsername(String routeUsername) {
        this.routeUsername = routeUsername == null ? null : routeUsername.trim();
        return this;
    }

    /**
     *
     * @return task_route_password
     */
    public String getRoutePassword() {
        return routePassword;
    }

    /**
     *
     * @param routePassword - 
     */
    public SioTaskBean setRoutePassword(String routePassword) {
        this.routePassword = routePassword == null ? null : routePassword.trim();
        return this;
    }

    /**
     * 获取 SIO某分支网点，内部任务ID
     *
     * @return task_task_id - SIO某分支网点，内部任务ID
     */
    public String getTaskId() {
        return taskId;
    }

    /**
     * 设置 SIO某分支网点，内部任务ID
     *
     * @param taskId - SIO某分支网点，内部任务ID
     */
    public SioTaskBean setTaskId(String taskId) {
        this.taskId = taskId == null ? null : taskId.trim();
        return this;
    }

    /**
     * 获取 任务顺序 app comodin定义顺序
     *
     * @return task_route_order - 任务顺序 app comodin定义顺序
     */
    public Integer getRouteOrder() {
        return routeOrder;
    }

    /**
     * 设置 任务顺序 app comodin定义顺序
     *
     * @param routeOrder - 任务顺序 app comodin定义顺序
     */
    public SioTaskBean setRouteOrder(Integer routeOrder) {
        this.routeOrder = routeOrder;
        return this;
    }

    /**
     * 获取 服务类型  即 comodin中 任务生成方式；0代表按计划服务；#代表按需服务
     *
     * @return task_generated_type - 服务类型  即 comodin中 任务生成方式；0代表按计划服务；#代表按需服务
     */
    public String getGeneratedType() {
        return generatedType;
    }

    /**
     * 设置 服务类型  即 comodin中 任务生成方式；0代表按计划服务；#代表按需服务
     *
     * @param generatedType - 服务类型  即 comodin中 任务生成方式；0代表按计划服务；#代表按需服务
     */
    public SioTaskBean setGeneratedType(String generatedType) {
        this.generatedType = generatedType == null ? null : generatedType.trim();
        return this;
    }

    /**
     * 获取 任务类型 详细看 Rules.xml工作表 Ten中说明
     *
     * @return task_service_type - 任务类型 详细看 Rules.xml工作表 Ten中说明
     */
    public String getServiceType() {
        return serviceType;
    }

    /**
     * 设置 任务类型 详细看 Rules.xml工作表 Ten中说明
     *
     * @param serviceType - 任务类型 详细看 Rules.xml工作表 Ten中说明
     */
    public SioTaskBean setServiceType(String serviceType) {
        this.serviceType = serviceType == null ? null : serviceType.trim();
        return this;
    }

    /**
     * 获取 SIO服务代码
     *
     * @return task_service_code - SIO服务代码
     */
    public String getServiceCode() {
        return serviceCode;
    }

    /**
     * 设置 SIO服务代码
     *
     * @param serviceCode - SIO服务代码
     */
    public SioTaskBean setServiceCode(String serviceCode) {
        this.serviceCode = serviceCode == null ? null : serviceCode.trim();
        return this;
    }

    /**
     * 获取 任务描述 - 需要在APP中显示
     *
     * @return task_description - 任务描述 - 需要在APP中显示
     */
    public String getDescription() {
        return description;
    }

    /**
     * 设置 任务描述 - 需要在APP中显示
     *
     * @param description - 任务描述 - 需要在APP中显示
     */
    public SioTaskBean setDescription(String description) {
        this.description = description == null ? null : description.trim();
        return this;
    }

    /**
     * 获取 保险箱密钥号 钥匙编号
     *
     * @return task_safe_key_number - 保险箱密钥号 钥匙编号
     */
    public String getSafeKeyNumber() {
        return safeKeyNumber;
    }

    /**
     * 设置 保险箱密钥号 钥匙编号
     *
     * @param safeKeyNumber - 保险箱密钥号 钥匙编号
     */
    public SioTaskBean setSafeKeyNumber(String safeKeyNumber) {
        this.safeKeyNumber = safeKeyNumber == null ? null : safeKeyNumber.trim();
        return this;
    }

    /**
     * 获取 钱袋子总数
     *
     * @return task_money_bags_total_number - 钱袋子总数
     */
    public String getMoneyBagsTotalNumber() {
        return moneyBagsTotalNumber;
    }

    /**
     * 设置 钱袋子总数
     *
     * @param moneyBagsTotalNumber - 钱袋子总数
     */
    public SioTaskBean setMoneyBagsTotalNumber(String moneyBagsTotalNumber) {
        this.moneyBagsTotalNumber = moneyBagsTotalNumber == null ? null : moneyBagsTotalNumber.trim();
        return this;
    }

    /**
     * 获取 票据总数
     *
     * @return task_comprobantes_total_number - 票据总数
     */
    public String getComprobantesTotalNumber() {
        return comprobantesTotalNumber;
    }

    /**
     * 设置 票据总数
     *
     * @param comprobantesTotalNumber - 票据总数
     */
    public SioTaskBean setComprobantesTotalNumber(String comprobantesTotalNumber) {
        this.comprobantesTotalNumber = comprobantesTotalNumber == null ? null : comprobantesTotalNumber.trim();
        return this;
    }

    /**
     * 获取 任务状态
     *
     * @return task_status - 任务状态
     */
    public String getStatus() {
        return status;
    }

    /**
     * 设置 任务状态
     *
     * @param status - 任务状态
     */
    public SioTaskBean setStatus(String status) {
        this.status = status == null ? null : status.trim();
        return this;
    }

    /**
     * 获取 任务注释
     *
     * @return task_notes - 任务注释
     */
    public String getNotes() {
        return notes;
    }

    /**
     * 设置 任务注释
     *
     * @param notes - 任务注释
     */
    public SioTaskBean setNotes(String notes) {
        this.notes = notes == null ? null : notes.trim();
        return this;
    }

    /**
     * 获取 发件方，分支，ID【重复节点，在发件人中有】
     *
     * @return task_xml_sender_branch_internal_id - 发件方，分支，ID【重复节点，在发件人中有】
     */
    public String getXmlSenderBranchInternalId() {
        return xmlSenderBranchInternalId;
    }

    /**
     * 设置 发件方，分支，ID【重复节点，在发件人中有】
     *
     * @param xmlSenderBranchInternalId - 发件方，分支，ID【重复节点，在发件人中有】
     */
    public SioTaskBean setXmlSenderBranchInternalId(String xmlSenderBranchInternalId) {
        this.xmlSenderBranchInternalId = xmlSenderBranchInternalId == null ? null : xmlSenderBranchInternalId.trim();
        return this;
    }

    /**
     * 获取 发件方，分支，窗口服务【重复节点，在发件人中有】
     *
     * @return task_xml_sender_window_service_time - 发件方，分支，窗口服务【重复节点，在发件人中有】
     */
    public String getXmlSenderWindowServiceTime() {
        return xmlSenderWindowServiceTime;
    }

    /**
     * 设置 发件方，分支，窗口服务【重复节点，在发件人中有】
     *
     * @param xmlSenderWindowServiceTime - 发件方，分支，窗口服务【重复节点，在发件人中有】
     */
    public SioTaskBean setXmlSenderWindowServiceTime(String xmlSenderWindowServiceTime) {
        this.xmlSenderWindowServiceTime = xmlSenderWindowServiceTime == null ? null : xmlSenderWindowServiceTime.trim();
        return this;
    }

    /**
     * 获取 发件方，分支，窗口服务，实时
     *
     * @return task_xml_sender_window_service_duration - 发件方，分支，窗口服务，实时
     */
    public String getXmlSenderWindowServiceDuration() {
        return xmlSenderWindowServiceDuration;
    }

    /**
     * 设置 发件方，分支，窗口服务，实时
     *
     * @param xmlSenderWindowServiceDuration - 发件方，分支，窗口服务，实时
     */
    public SioTaskBean setXmlSenderWindowServiceDuration(String xmlSenderWindowServiceDuration) {
        this.xmlSenderWindowServiceDuration = xmlSenderWindowServiceDuration == null ? null : xmlSenderWindowServiceDuration.trim();
        return this;
    }

    /**
     * 获取 收件方，分支，ID【重复节点，在收件人中有】
     *
     * @return task_xml_receiver_branch_internal_id - 收件方，分支，ID【重复节点，在收件人中有】
     */
    public String getXmlReceiverBranchInternalId() {
        return xmlReceiverBranchInternalId;
    }

    /**
     * 设置 收件方，分支，ID【重复节点，在收件人中有】
     *
     * @param xmlReceiverBranchInternalId - 收件方，分支，ID【重复节点，在收件人中有】
     */
    public SioTaskBean setXmlReceiverBranchInternalId(String xmlReceiverBranchInternalId) {
        this.xmlReceiverBranchInternalId = xmlReceiverBranchInternalId == null ? null : xmlReceiverBranchInternalId.trim();
        return this;
    }

    /**
     * 获取 收件方，分支，窗口服务【重复节点，在收件人中有】
     *
     * @return task_xml_receiver_window_service_time - 收件方，分支，窗口服务【重复节点，在收件人中有】
     */
    public String getXmlReceiverWindowServiceTime() {
        return xmlReceiverWindowServiceTime;
    }

    /**
     * 设置 收件方，分支，窗口服务【重复节点，在收件人中有】
     *
     * @param xmlReceiverWindowServiceTime - 收件方，分支，窗口服务【重复节点，在收件人中有】
     */
    public SioTaskBean setXmlReceiverWindowServiceTime(String xmlReceiverWindowServiceTime) {
        this.xmlReceiverWindowServiceTime = xmlReceiverWindowServiceTime == null ? null : xmlReceiverWindowServiceTime.trim();
        return this;
    }

    /**
     * 获取 收件方，分支，窗口服务，实时
     *
     * @return task_xml_receiver_window_service_duration - 收件方，分支，窗口服务，实时
     */
    public String getXmlReceiverWindowServiceDuration() {
        return xmlReceiverWindowServiceDuration;
    }

    /**
     * 设置 收件方，分支，窗口服务，实时
     *
     * @param xmlReceiverWindowServiceDuration - 收件方，分支，窗口服务，实时
     */
    public SioTaskBean setXmlReceiverWindowServiceDuration(String xmlReceiverWindowServiceDuration) {
        this.xmlReceiverWindowServiceDuration = xmlReceiverWindowServiceDuration == null ? null : xmlReceiverWindowServiceDuration.trim();
        return this;
    }

    /**
     * 获取 SIO系统，任务是否有电子票据【1有电子票据，2没有电子票据】
     *
     * @return task_config_whether_electronic_bill - SIO系统，任务是否有电子票据【1有电子票据，2没有电子票据】
     */
    public String getConfigWhetherElectronicBill() {
        return configWhetherElectronicBill;
    }

    /**
     * 设置 SIO系统，任务是否有电子票据【1有电子票据，2没有电子票据】
     *
     * @param configWhetherElectronicBill - SIO系统，任务是否有电子票据【1有电子票据，2没有电子票据】
     */
    public SioTaskBean setConfigWhetherElectronicBill(String configWhetherElectronicBill) {
        this.configWhetherElectronicBill = configWhetherElectronicBill == null ? null : configWhetherElectronicBill.trim();
        return this;
    }

    /**
     * 获取 送钱任务，取消【钱还没有送到客户】钱要返回到金库，值为1；其他的就为0
     *
     * @return task_config_cancel_money_back_party - 送钱任务，取消【钱还没有送到客户】钱要返回到金库，值为1；其他的就为0
     */
    public String getConfigCancelMoneyBackParty() {
        return configCancelMoneyBackParty;
    }

    /**
     * 设置 送钱任务，取消【钱还没有送到客户】钱要返回到金库，值为1；其他的就为0
     *
     * @param configCancelMoneyBackParty - 送钱任务，取消【钱还没有送到客户】钱要返回到金库，值为1；其他的就为0
     */
    public SioTaskBean setConfigCancelMoneyBackParty(String configCancelMoneyBackParty) {
        this.configCancelMoneyBackParty = configCancelMoneyBackParty == null ? null : configCancelMoneyBackParty.trim();
        return this;
    }

    /**
     * 获取 SIO任务，是否需要现场点钞
     *
     * @return task_config_whether_site_counting - SIO任务，是否需要现场点钞
     */
    public String getConfigWhetherSiteCounting() {
        return configWhetherSiteCounting;
    }

    /**
     * 设置 SIO任务，是否需要现场点钞
     *
     * @param configWhetherSiteCounting - SIO任务，是否需要现场点钞
     */
    public SioTaskBean setConfigWhetherSiteCounting(String configWhetherSiteCounting) {
        this.configWhetherSiteCounting = configWhetherSiteCounting == null ? null : configWhetherSiteCounting.trim();
        return this;
    }

    /**
     * 获取 ATM的编号【SIDE】，暂时不考虑，后期会再使用
     *
     * @return task_config_atm_id - ATM的编号【SIDE】，暂时不考虑，后期会再使用
     */
    public String getConfigAtmId() {
        return configAtmId;
    }

    /**
     * 设置 ATM的编号【SIDE】，暂时不考虑，后期会再使用
     *
     * @param configAtmId - ATM的编号【SIDE】，暂时不考虑，后期会再使用
     */
    public SioTaskBean setConfigAtmId(String configAtmId) {
        this.configAtmId = configAtmId == null ? null : configAtmId.trim();
        return this;
    }

    /**
     * 获取 SIO任务是现场发工资的，0代表正常，1代表要现场发钱的
     *
     * @return task_config_whether_site_wages - SIO任务是现场发工资的，0代表正常，1代表要现场发钱的
     */
    public String getConfigWhetherSiteWages() {
        return configWhetherSiteWages;
    }

    /**
     * 设置 SIO任务是现场发工资的，0代表正常，1代表要现场发钱的
     *
     * @param configWhetherSiteWages - SIO任务是现场发工资的，0代表正常，1代表要现场发钱的
     */
    public SioTaskBean setConfigWhetherSiteWages(String configWhetherSiteWages) {
        this.configWhetherSiteWages = configWhetherSiteWages == null ? null : configWhetherSiteWages.trim();
        return this;
    }

    /**
     * 获取 该XML是由哪一方传入，1代表由comodin传入到KIOSKOLIN；0代表由KIOSKOLIN传入到comodin
     *
     * @return task_config_xml_source_side - 该XML是由哪一方传入，1代表由comodin传入到KIOSKOLIN；0代表由KIOSKOLIN传入到comodin
     */
    public String getConfigXmlSourceSide() {
        return configXmlSourceSide;
    }

    /**
     * 设置 该XML是由哪一方传入，1代表由comodin传入到KIOSKOLIN；0代表由KIOSKOLIN传入到comodin
     *
     * @param configXmlSourceSide - 该XML是由哪一方传入，1代表由comodin传入到KIOSKOLIN；0代表由KIOSKOLIN传入到comodin
     */
    public SioTaskBean setConfigXmlSourceSide(String configXmlSourceSide) {
        this.configXmlSourceSide = configXmlSourceSide == null ? null : configXmlSourceSide.trim();
        return this;
    }

    /**
     * 获取 当前这个任务是：interChange之前[ORIG]，还是之后interChange之后[DEST]
     *
     * @return task_inter_change_type - 当前这个任务是：interChange之前[ORIG]，还是之后interChange之后[DEST]
     */
    public String getInterChangeType() {
        return interChangeType;
    }

    /**
     * 设置 当前这个任务是：interChange之前[ORIG]，还是之后interChange之后[DEST]
     *
     * @param interChangeType - 当前这个任务是：interChange之前[ORIG]，还是之后interChange之后[DEST]
     */
    public SioTaskBean setInterChangeType(String interChangeType) {
        this.interChangeType = interChangeType == null ? null : interChangeType.trim();
        return this;
    }

    /**
     * 获取 interChange到哪个公司
     *
     * @return task_inter_change_company_internal_id - interChange到哪个公司
     */
    public String getInterChangeCompanyInternalId() {
        return interChangeCompanyInternalId;
    }

    /**
     * 设置 interChange到哪个公司
     *
     * @param interChangeCompanyInternalId - interChange到哪个公司
     */
    public SioTaskBean setInterChangeCompanyInternalId(String interChangeCompanyInternalId) {
        this.interChangeCompanyInternalId = interChangeCompanyInternalId == null ? null : interChangeCompanyInternalId.trim();
        return this;
    }

    /**
     * 获取 interChange到哪个公司哪个网点
     *
     * @return task_inter_change_branch_internal_id - interChange到哪个公司哪个网点
     */
    public String getInterChangeBranchInternalId() {
        return interChangeBranchInternalId;
    }

    /**
     * 设置 interChange到哪个公司哪个网点
     *
     * @param interChangeBranchInternalId - interChange到哪个公司哪个网点
     */
    public SioTaskBean setInterChangeBranchInternalId(String interChangeBranchInternalId) {
        this.interChangeBranchInternalId = interChangeBranchInternalId == null ? null : interChangeBranchInternalId.trim();
        return this;
    }

    /**
     * 获取 interChange到哪个公司哪个网点的哪一条路线
     *
     * @return task_inter_change_route_id - interChange到哪个公司哪个网点的哪一条路线
     */
    public String getInterChangeRouteId() {
        return interChangeRouteId;
    }

    /**
     * 设置 interChange到哪个公司哪个网点的哪一条路线
     *
     * @param interChangeRouteId - interChange到哪个公司哪个网点的哪一条路线
     */
    public SioTaskBean setInterChangeRouteId(String interChangeRouteId) {
        this.interChangeRouteId = interChangeRouteId == null ? null : interChangeRouteId.trim();
        return this;
    }

    /**
     * 获取 interChange到哪一天日期
     *
     * @return task_inter_change_service_date - interChange到哪一天日期
     */
    public String getInterChangeServiceDate() {
        return interChangeServiceDate;
    }

    /**
     * 设置 interChange到哪一天日期
     *
     * @param interChangeServiceDate - interChange到哪一天日期
     */
    public SioTaskBean setInterChangeServiceDate(String interChangeServiceDate) {
        this.interChangeServiceDate = interChangeServiceDate == null ? null : interChangeServiceDate.trim();
        return this;
    }

    /**
     * 获取 interchange的任务ID
     *
     * @return task_inter_change_task_id - interchange的任务ID
     */
    public String getInterChangeTaskId() {
        return interChangeTaskId;
    }

    /**
     * 设置 interchange的任务ID
     *
     * @param interChangeTaskId - interchange的任务ID
     */
    public SioTaskBean setInterChangeTaskId(String interChangeTaskId) {
        this.interChangeTaskId = interChangeTaskId == null ? null : interChangeTaskId.trim();
        return this;
    }

    /**
     * 获取 发件方，分支，ID
     *
     * @return task_sender_branch_internal_id - 发件方，分支，ID
     */
    public String getSenderBranchInternalId() {
        return senderBranchInternalId;
    }

    /**
     * 设置 发件方，分支，ID
     *
     * @param senderBranchInternalId - 发件方，分支，ID
     */
    public SioTaskBean setSenderBranchInternalId(String senderBranchInternalId) {
        this.senderBranchInternalId = senderBranchInternalId == null ? null : senderBranchInternalId.trim();
        return this;
    }

    /**
     * 获取 发件方，分支，窗口服务
     *
     * @return task_sender_window_service_time - 发件方，分支，窗口服务
     */
    public String getSenderWindowServiceTime() {
        return senderWindowServiceTime;
    }

    /**
     * 设置 发件方，分支，窗口服务
     *
     * @param senderWindowServiceTime - 发件方，分支，窗口服务
     */
    public SioTaskBean setSenderWindowServiceTime(String senderWindowServiceTime) {
        this.senderWindowServiceTime = senderWindowServiceTime == null ? null : senderWindowServiceTime.trim();
        return this;
    }

    /**
     *
     * @return task_sender_check_inn
     */
    public String getSenderCheckInn() {
        return senderCheckInn;
    }

    /**
     *
     * @param senderCheckInn - 
     */
    public SioTaskBean setSenderCheckInn(String senderCheckInn) {
        this.senderCheckInn = senderCheckInn == null ? null : senderCheckInn.trim();
        return this;
    }

    /**
     *
     * @return task_sender_check_out
     */
    public String getSenderCheckOut() {
        return senderCheckOut;
    }

    /**
     *
     * @param senderCheckOut - 
     */
    public SioTaskBean setSenderCheckOut(String senderCheckOut) {
        this.senderCheckOut = senderCheckOut == null ? null : senderCheckOut.trim();
        return this;
    }

    /**
     * 获取 发件方，分支，名称
     *
     * @return task_sender_branch_name - 发件方，分支，名称
     */
    public String getSenderBranchName() {
        return senderBranchName;
    }

    /**
     * 设置 发件方，分支，名称
     *
     * @param senderBranchName - 发件方，分支，名称
     */
    public SioTaskBean setSenderBranchName(String senderBranchName) {
        this.senderBranchName = senderBranchName == null ? null : senderBranchName.trim();
        return this;
    }

    /**
     * 获取 发件方，分支，地址（街道）
     *
     * @return task_sender_branch_address_street - 发件方，分支，地址（街道）
     */
    public String getSenderBranchAddressStreet() {
        return senderBranchAddressStreet;
    }

    /**
     * 设置 发件方，分支，地址（街道）
     *
     * @param senderBranchAddressStreet - 发件方，分支，地址（街道）
     */
    public SioTaskBean setSenderBranchAddressStreet(String senderBranchAddressStreet) {
        this.senderBranchAddressStreet = senderBranchAddressStreet == null ? null : senderBranchAddressStreet.trim();
        return this;
    }

    /**
     * 获取 发件方，分支，地址（数字）
     *
     * @return task_sender_branch_address_number - 发件方，分支，地址（数字）
     */
    public String getSenderBranchAddressNumber() {
        return senderBranchAddressNumber;
    }

    /**
     * 设置 发件方，分支，地址（数字）
     *
     * @param senderBranchAddressNumber - 发件方，分支，地址（数字）
     */
    public SioTaskBean setSenderBranchAddressNumber(String senderBranchAddressNumber) {
        this.senderBranchAddressNumber = senderBranchAddressNumber == null ? null : senderBranchAddressNumber.trim();
        return this;
    }

    /**
     * 获取 发件方，分支，位置（纬度）
     *
     * @return task_sender_branch_latitude - 发件方，分支，位置（纬度）
     */
    public String getSenderBranchLatitude() {
        return senderBranchLatitude;
    }

    /**
     * 设置 发件方，分支，位置（纬度）
     *
     * @param senderBranchLatitude - 发件方，分支，位置（纬度）
     */
    public SioTaskBean setSenderBranchLatitude(String senderBranchLatitude) {
        this.senderBranchLatitude = senderBranchLatitude == null ? null : senderBranchLatitude.trim();
        return this;
    }

    /**
     * 获取 发件方，分支，位置（经度）
     *
     * @return task_sender_branch_longitude - 发件方，分支，位置（经度）
     */
    public String getSenderBranchLongitude() {
        return senderBranchLongitude;
    }

    /**
     * 设置 发件方，分支，位置（经度）
     *
     * @param senderBranchLongitude - 发件方，分支，位置（经度）
     */
    public SioTaskBean setSenderBranchLongitude(String senderBranchLongitude) {
        this.senderBranchLongitude = senderBranchLongitude == null ? null : senderBranchLongitude.trim();
        return this;
    }

    /**
     * 获取 收件方，分支，ID
     *
     * @return task_receiver_branch_internal_id - 收件方，分支，ID
     */
    public String getReceiverBranchInternalId() {
        return receiverBranchInternalId;
    }

    /**
     * 设置 收件方，分支，ID
     *
     * @param receiverBranchInternalId - 收件方，分支，ID
     */
    public SioTaskBean setReceiverBranchInternalId(String receiverBranchInternalId) {
        this.receiverBranchInternalId = receiverBranchInternalId == null ? null : receiverBranchInternalId.trim();
        return this;
    }

    /**
     * 获取 收件方，分支，窗口服务
     *
     * @return task_receiver_window_service_time - 收件方，分支，窗口服务
     */
    public String getReceiverWindowServiceTime() {
        return receiverWindowServiceTime;
    }

    /**
     * 设置 收件方，分支，窗口服务
     *
     * @param receiverWindowServiceTime - 收件方，分支，窗口服务
     */
    public SioTaskBean setReceiverWindowServiceTime(String receiverWindowServiceTime) {
        this.receiverWindowServiceTime = receiverWindowServiceTime == null ? null : receiverWindowServiceTime.trim();
        return this;
    }

    /**
     *
     * @return task_receiver_check_inn
     */
    public String getReceiverCheckInn() {
        return receiverCheckInn;
    }

    /**
     *
     * @param receiverCheckInn - 
     */
    public SioTaskBean setReceiverCheckInn(String receiverCheckInn) {
        this.receiverCheckInn = receiverCheckInn == null ? null : receiverCheckInn.trim();
        return this;
    }

    /**
     *
     * @return task_receiver_check_out
     */
    public String getReceiverCheckOut() {
        return receiverCheckOut;
    }

    /**
     *
     * @param receiverCheckOut - 
     */
    public SioTaskBean setReceiverCheckOut(String receiverCheckOut) {
        this.receiverCheckOut = receiverCheckOut == null ? null : receiverCheckOut.trim();
        return this;
    }

    /**
     * 获取 收件方，分支，名称
     *
     * @return task_receiver_branch_name - 收件方，分支，名称
     */
    public String getReceiverBranchName() {
        return receiverBranchName;
    }

    /**
     * 设置 收件方，分支，名称
     *
     * @param receiverBranchName - 收件方，分支，名称
     */
    public SioTaskBean setReceiverBranchName(String receiverBranchName) {
        this.receiverBranchName = receiverBranchName == null ? null : receiverBranchName.trim();
        return this;
    }

    /**
     * 获取 收件方，分支，地址（街道）
     *
     * @return task_receiver_branch_address_street - 收件方，分支，地址（街道）
     */
    public String getReceiverBranchAddressStreet() {
        return receiverBranchAddressStreet;
    }

    /**
     * 设置 收件方，分支，地址（街道）
     *
     * @param receiverBranchAddressStreet - 收件方，分支，地址（街道）
     */
    public SioTaskBean setReceiverBranchAddressStreet(String receiverBranchAddressStreet) {
        this.receiverBranchAddressStreet = receiverBranchAddressStreet == null ? null : receiverBranchAddressStreet.trim();
        return this;
    }

    /**
     * 获取 收件方，分支，地址（数字）
     *
     * @return task_receiver_branch_address_number - 收件方，分支，地址（数字）
     */
    public String getReceiverBranchAddressNumber() {
        return receiverBranchAddressNumber;
    }

    /**
     * 设置 收件方，分支，地址（数字）
     *
     * @param receiverBranchAddressNumber - 收件方，分支，地址（数字）
     */
    public SioTaskBean setReceiverBranchAddressNumber(String receiverBranchAddressNumber) {
        this.receiverBranchAddressNumber = receiverBranchAddressNumber == null ? null : receiverBranchAddressNumber.trim();
        return this;
    }

    /**
     * 获取 收件方，分支，位置（纬度）
     *
     * @return task_receiver_branch_latitude - 收件方，分支，位置（纬度）
     */
    public String getReceiverBranchLatitude() {
        return receiverBranchLatitude;
    }

    /**
     * 设置 收件方，分支，位置（纬度）
     *
     * @param receiverBranchLatitude - 收件方，分支，位置（纬度）
     */
    public SioTaskBean setReceiverBranchLatitude(String receiverBranchLatitude) {
        this.receiverBranchLatitude = receiverBranchLatitude == null ? null : receiverBranchLatitude.trim();
        return this;
    }

    /**
     * 获取 收件方，分支，位置（经度）
     *
     * @return task_receiver_branch_longitude - 收件方，分支，位置（经度）
     */
    public String getReceiverBranchLongitude() {
        return receiverBranchLongitude;
    }

    /**
     * 设置 收件方，分支，位置（经度）
     *
     * @param receiverBranchLongitude - 收件方，分支，位置（经度）
     */
    public SioTaskBean setReceiverBranchLongitude(String receiverBranchLongitude) {
        this.receiverBranchLongitude = receiverBranchLongitude == null ? null : receiverBranchLongitude.trim();
        return this;
    }

    /**
     * 获取 车辆，SIO内部编号
     *
     * @return task_vehicle_internal_id - 车辆，SIO内部编号
     */
    public String getVehicleInternalId() {
        return vehicleInternalId;
    }

    /**
     * 设置 车辆，SIO内部编号
     *
     * @param vehicleInternalId - 车辆，SIO内部编号
     */
    public SioTaskBean setVehicleInternalId(String vehicleInternalId) {
        this.vehicleInternalId = vehicleInternalId == null ? null : vehicleInternalId.trim();
        return this;
    }

    /**
     * 获取 车辆，车牌号
     *
     * @return task_vehicle_license_plate - 车辆，车牌号
     */
    public String getVehicleLicensePlate() {
        return vehicleLicensePlate;
    }

    /**
     * 设置 车辆，车牌号
     *
     * @param vehicleLicensePlate - 车辆，车牌号
     */
    public SioTaskBean setVehicleLicensePlate(String vehicleLicensePlate) {
        this.vehicleLicensePlate = vehicleLicensePlate == null ? null : vehicleLicensePlate.trim();
        return this;
    }

    /**
     * 获取 车辆，描述信息
     *
     * @return task_vehicle_description - 车辆，描述信息
     */
    public String getVehicleDescription() {
        return vehicleDescription;
    }

    /**
     * 设置 车辆，描述信息
     *
     * @param vehicleDescription - 车辆，描述信息
     */
    public SioTaskBean setVehicleDescription(String vehicleDescription) {
        this.vehicleDescription = vehicleDescription == null ? null : vehicleDescription.trim();
        return this;
    }

    /**
     * 获取 车辆，货币容量
     *
     * @return task_vehicle_currency_capacity - 车辆，货币容量
     */
    public String getVehicleCurrencyCapacity() {
        return vehicleCurrencyCapacity;
    }

    /**
     * 设置 车辆，货币容量
     *
     * @param vehicleCurrencyCapacity - 车辆，货币容量
     */
    public SioTaskBean setVehicleCurrencyCapacity(String vehicleCurrencyCapacity) {
        this.vehicleCurrencyCapacity = vehicleCurrencyCapacity == null ? null : vehicleCurrencyCapacity.trim();
        return this;
    }

    /**
     * 获取 司机，SIO内部编号
     *
     * @return task_driver_internal_id - 司机，SIO内部编号
     */
    public String getDriverInternalId() {
        return driverInternalId;
    }

    /**
     * 设置 司机，SIO内部编号
     *
     * @param driverInternalId - 司机，SIO内部编号
     */
    public SioTaskBean setDriverInternalId(String driverInternalId) {
        this.driverInternalId = driverInternalId == null ? null : driverInternalId.trim();
        return this;
    }

    /**
     * 获取 司机，姓名
     *
     * @return task_driver_full_name - 司机，姓名
     */
    public String getDriverFullName() {
        return driverFullName;
    }

    /**
     * 设置 司机，姓名
     *
     * @param driverFullName - 司机，姓名
     */
    public SioTaskBean setDriverFullName(String driverFullName) {
        this.driverFullName = driverFullName == null ? null : driverFullName.trim();
        return this;
    }

    /**
     * 获取 司机，父亲姓
     *
     * @return task_driver_father_last_name - 司机，父亲姓
     */
    public String getDriverFatherLastName() {
        return driverFatherLastName;
    }

    /**
     * 设置 司机，父亲姓
     *
     * @param driverFatherLastName - 司机，父亲姓
     */
    public SioTaskBean setDriverFatherLastName(String driverFatherLastName) {
        this.driverFatherLastName = driverFatherLastName == null ? null : driverFatherLastName.trim();
        return this;
    }

    /**
     * 获取 司机，母亲姓
     *
     * @return task_driver_mother_last_name - 司机，母亲姓
     */
    public String getDriverMotherLastName() {
        return driverMotherLastName;
    }

    /**
     * 设置 司机，母亲姓
     *
     * @param driverMotherLastName - 司机，母亲姓
     */
    public SioTaskBean setDriverMotherLastName(String driverMotherLastName) {
        this.driverMotherLastName = driverMotherLastName == null ? null : driverMotherLastName.trim();
        return this;
    }

    /**
     * 获取 司机，SIO内部部门，ID
     *
     * @return task_driver_sio_department_id - 司机，SIO内部部门，ID
     */
    public String getDriverSioDepartmentId() {
        return driverSioDepartmentId;
    }

    /**
     * 设置 司机，SIO内部部门，ID
     *
     * @param driverSioDepartmentId - 司机，SIO内部部门，ID
     */
    public SioTaskBean setDriverSioDepartmentId(String driverSioDepartmentId) {
        this.driverSioDepartmentId = driverSioDepartmentId == null ? null : driverSioDepartmentId.trim();
        return this;
    }

    /**
     * 获取 司机，SIO内部部门，描述
     *
     * @return task_driver_sio_department_description - 司机，SIO内部部门，描述
     */
    public String getDriverSioDepartmentDescription() {
        return driverSioDepartmentDescription;
    }

    /**
     * 设置 司机，SIO内部部门，描述
     *
     * @param driverSioDepartmentDescription - 司机，SIO内部部门，描述
     */
    public SioTaskBean setDriverSioDepartmentDescription(String driverSioDepartmentDescription) {
        this.driverSioDepartmentDescription = driverSioDepartmentDescription == null ? null : driverSioDepartmentDescription.trim();
        return this;
    }

    /**
     * 获取 司机，SIO内部角色，ID
     *
     * @return task_driver_sio_role_id - 司机，SIO内部角色，ID
     */
    public String getDriverSioRoleId() {
        return driverSioRoleId;
    }

    /**
     * 设置 司机，SIO内部角色，ID
     *
     * @param driverSioRoleId - 司机，SIO内部角色，ID
     */
    public SioTaskBean setDriverSioRoleId(String driverSioRoleId) {
        this.driverSioRoleId = driverSioRoleId == null ? null : driverSioRoleId.trim();
        return this;
    }

    /**
     * 获取 司机，SIO内部角色，描述
     *
     * @return task_driver_sio_role_description - 司机，SIO内部角色，描述
     */
    public String getDriverSioRoleDescription() {
        return driverSioRoleDescription;
    }

    /**
     * 设置 司机，SIO内部角色，描述
     *
     * @param driverSioRoleDescription - 司机，SIO内部角色，描述
     */
    public SioTaskBean setDriverSioRoleDescription(String driverSioRoleDescription) {
        this.driverSioRoleDescription = driverSioRoleDescription == null ? null : driverSioRoleDescription.trim();
        return this;
    }

    /**
     * 获取 司机，sio与comodin对应角色
     *
     * @return task_driver_crew_type - 司机，sio与comodin对应角色
     */
    public String getDriverCrewType() {
        return driverCrewType;
    }

    /**
     * 设置 司机，sio与comodin对应角色
     *
     * @param driverCrewType - 司机，sio与comodin对应角色
     */
    public SioTaskBean setDriverCrewType(String driverCrewType) {
        this.driverCrewType = driverCrewType == null ? null : driverCrewType.trim();
        return this;
    }

    /**
     * 获取 出纳员，SIO内部编号
     *
     * @return task_cashier_internal_id - 出纳员，SIO内部编号
     */
    public String getCashierInternalId() {
        return cashierInternalId;
    }

    /**
     * 设置 出纳员，SIO内部编号
     *
     * @param cashierInternalId - 出纳员，SIO内部编号
     */
    public SioTaskBean setCashierInternalId(String cashierInternalId) {
        this.cashierInternalId = cashierInternalId == null ? null : cashierInternalId.trim();
        return this;
    }

    /**
     * 获取 出纳员，姓名
     *
     * @return task_cashier_full_name - 出纳员，姓名
     */
    public String getCashierFullName() {
        return cashierFullName;
    }

    /**
     * 设置 出纳员，姓名
     *
     * @param cashierFullName - 出纳员，姓名
     */
    public SioTaskBean setCashierFullName(String cashierFullName) {
        this.cashierFullName = cashierFullName == null ? null : cashierFullName.trim();
        return this;
    }

    /**
     * 获取 出纳员，父亲姓
     *
     * @return task_cashier_father_last_name - 出纳员，父亲姓
     */
    public String getCashierFatherLastName() {
        return cashierFatherLastName;
    }

    /**
     * 设置 出纳员，父亲姓
     *
     * @param cashierFatherLastName - 出纳员，父亲姓
     */
    public SioTaskBean setCashierFatherLastName(String cashierFatherLastName) {
        this.cashierFatherLastName = cashierFatherLastName == null ? null : cashierFatherLastName.trim();
        return this;
    }

    /**
     * 获取 出纳员，母亲姓
     *
     * @return task_cashier_mother_last_name - 出纳员，母亲姓
     */
    public String getCashierMotherLastName() {
        return cashierMotherLastName;
    }

    /**
     * 设置 出纳员，母亲姓
     *
     * @param cashierMotherLastName - 出纳员，母亲姓
     */
    public SioTaskBean setCashierMotherLastName(String cashierMotherLastName) {
        this.cashierMotherLastName = cashierMotherLastName == null ? null : cashierMotherLastName.trim();
        return this;
    }

    /**
     * 获取 出纳员，SIO内部部门，ID
     *
     * @return task_cashier_sio_department_id - 出纳员，SIO内部部门，ID
     */
    public String getCashierSioDepartmentId() {
        return cashierSioDepartmentId;
    }

    /**
     * 设置 出纳员，SIO内部部门，ID
     *
     * @param cashierSioDepartmentId - 出纳员，SIO内部部门，ID
     */
    public SioTaskBean setCashierSioDepartmentId(String cashierSioDepartmentId) {
        this.cashierSioDepartmentId = cashierSioDepartmentId == null ? null : cashierSioDepartmentId.trim();
        return this;
    }

    /**
     * 获取 出纳员，SIO内部部门，描述
     *
     * @return task_cashier_sio_department_description - 出纳员，SIO内部部门，描述
     */
    public String getCashierSioDepartmentDescription() {
        return cashierSioDepartmentDescription;
    }

    /**
     * 设置 出纳员，SIO内部部门，描述
     *
     * @param cashierSioDepartmentDescription - 出纳员，SIO内部部门，描述
     */
    public SioTaskBean setCashierSioDepartmentDescription(String cashierSioDepartmentDescription) {
        this.cashierSioDepartmentDescription = cashierSioDepartmentDescription == null ? null : cashierSioDepartmentDescription.trim();
        return this;
    }

    /**
     * 获取 出纳员，SIO内部角色，ID
     *
     * @return task_cashier_sio_role_id - 出纳员，SIO内部角色，ID
     */
    public String getCashierSioRoleId() {
        return cashierSioRoleId;
    }

    /**
     * 设置 出纳员，SIO内部角色，ID
     *
     * @param cashierSioRoleId - 出纳员，SIO内部角色，ID
     */
    public SioTaskBean setCashierSioRoleId(String cashierSioRoleId) {
        this.cashierSioRoleId = cashierSioRoleId == null ? null : cashierSioRoleId.trim();
        return this;
    }

    /**
     * 获取 出纳员，SIO内部角色，描述
     *
     * @return task_cashier_sio_role_description - 出纳员，SIO内部角色，描述
     */
    public String getCashierSioRoleDescription() {
        return cashierSioRoleDescription;
    }

    /**
     * 设置 出纳员，SIO内部角色，描述
     *
     * @param cashierSioRoleDescription - 出纳员，SIO内部角色，描述
     */
    public SioTaskBean setCashierSioRoleDescription(String cashierSioRoleDescription) {
        this.cashierSioRoleDescription = cashierSioRoleDescription == null ? null : cashierSioRoleDescription.trim();
        return this;
    }

    /**
     * 获取 出纳员，sio与comodin对应角色
     *
     * @return task_cashier_crew_type - 出纳员，sio与comodin对应角色
     */
    public String getCashierCrewType() {
        return cashierCrewType;
    }

    /**
     * 设置 出纳员，sio与comodin对应角色
     *
     * @param cashierCrewType - 出纳员，sio与comodin对应角色
     */
    public SioTaskBean setCashierCrewType(String cashierCrewType) {
        this.cashierCrewType = cashierCrewType == null ? null : cashierCrewType.trim();
        return this;
    }

    /**
     * 获取 保镖1，SIO内部编号
     *
     * @return task_security1_internal_id - 保镖1，SIO内部编号
     */
    public String getSecurity1InternalId() {
        return security1InternalId;
    }

    /**
     * 设置 保镖1，SIO内部编号
     *
     * @param security1InternalId - 保镖1，SIO内部编号
     */
    public SioTaskBean setSecurity1InternalId(String security1InternalId) {
        this.security1InternalId = security1InternalId == null ? null : security1InternalId.trim();
        return this;
    }

    /**
     * 获取 保镖1，姓名
     *
     * @return task_security1_full_name - 保镖1，姓名
     */
    public String getSecurity1FullName() {
        return security1FullName;
    }

    /**
     * 设置 保镖1，姓名
     *
     * @param security1FullName - 保镖1，姓名
     */
    public SioTaskBean setSecurity1FullName(String security1FullName) {
        this.security1FullName = security1FullName == null ? null : security1FullName.trim();
        return this;
    }

    /**
     * 获取 保镖1，父亲姓
     *
     * @return task_security1_father_last_name - 保镖1，父亲姓
     */
    public String getSecurity1FatherLastName() {
        return security1FatherLastName;
    }

    /**
     * 设置 保镖1，父亲姓
     *
     * @param security1FatherLastName - 保镖1，父亲姓
     */
    public SioTaskBean setSecurity1FatherLastName(String security1FatherLastName) {
        this.security1FatherLastName = security1FatherLastName == null ? null : security1FatherLastName.trim();
        return this;
    }

    /**
     * 获取 保镖1，母亲姓
     *
     * @return task_security1_mother_last_name - 保镖1，母亲姓
     */
    public String getSecurity1MotherLastName() {
        return security1MotherLastName;
    }

    /**
     * 设置 保镖1，母亲姓
     *
     * @param security1MotherLastName - 保镖1，母亲姓
     */
    public SioTaskBean setSecurity1MotherLastName(String security1MotherLastName) {
        this.security1MotherLastName = security1MotherLastName == null ? null : security1MotherLastName.trim();
        return this;
    }

    /**
     * 获取 保镖1，SIO内部部门，ID
     *
     * @return task_security1_sio_department_id - 保镖1，SIO内部部门，ID
     */
    public String getSecurity1SioDepartmentId() {
        return security1SioDepartmentId;
    }

    /**
     * 设置 保镖1，SIO内部部门，ID
     *
     * @param security1SioDepartmentId - 保镖1，SIO内部部门，ID
     */
    public SioTaskBean setSecurity1SioDepartmentId(String security1SioDepartmentId) {
        this.security1SioDepartmentId = security1SioDepartmentId == null ? null : security1SioDepartmentId.trim();
        return this;
    }

    /**
     * 获取 保镖1，SIO内部部门，描述
     *
     * @return task_security1_sio_department_description - 保镖1，SIO内部部门，描述
     */
    public String getSecurity1SioDepartmentDescription() {
        return security1SioDepartmentDescription;
    }

    /**
     * 设置 保镖1，SIO内部部门，描述
     *
     * @param security1SioDepartmentDescription - 保镖1，SIO内部部门，描述
     */
    public SioTaskBean setSecurity1SioDepartmentDescription(String security1SioDepartmentDescription) {
        this.security1SioDepartmentDescription = security1SioDepartmentDescription == null ? null : security1SioDepartmentDescription.trim();
        return this;
    }

    /**
     * 获取 保镖1，SIO内部角色，ID
     *
     * @return task_security1_sio_role_id - 保镖1，SIO内部角色，ID
     */
    public String getSecurity1SioRoleId() {
        return security1SioRoleId;
    }

    /**
     * 设置 保镖1，SIO内部角色，ID
     *
     * @param security1SioRoleId - 保镖1，SIO内部角色，ID
     */
    public SioTaskBean setSecurity1SioRoleId(String security1SioRoleId) {
        this.security1SioRoleId = security1SioRoleId == null ? null : security1SioRoleId.trim();
        return this;
    }

    /**
     * 获取 保镖1，SIO内部角色，描述
     *
     * @return task_security1_sio_role_description - 保镖1，SIO内部角色，描述
     */
    public String getSecurity1SioRoleDescription() {
        return security1SioRoleDescription;
    }

    /**
     * 设置 保镖1，SIO内部角色，描述
     *
     * @param security1SioRoleDescription - 保镖1，SIO内部角色，描述
     */
    public SioTaskBean setSecurity1SioRoleDescription(String security1SioRoleDescription) {
        this.security1SioRoleDescription = security1SioRoleDescription == null ? null : security1SioRoleDescription.trim();
        return this;
    }

    /**
     * 获取 保镖1，sio与comodin对应角色
     *
     * @return task_security1_crew_type - 保镖1，sio与comodin对应角色
     */
    public String getSecurity1CrewType() {
        return security1CrewType;
    }

    /**
     * 设置 保镖1，sio与comodin对应角色
     *
     * @param security1CrewType - 保镖1，sio与comodin对应角色
     */
    public SioTaskBean setSecurity1CrewType(String security1CrewType) {
        this.security1CrewType = security1CrewType == null ? null : security1CrewType.trim();
        return this;
    }

    /**
     * 获取 保镖2，SIO内部编号
     *
     * @return task_security2_internal_id - 保镖2，SIO内部编号
     */
    public String getSecurity2InternalId() {
        return security2InternalId;
    }

    /**
     * 设置 保镖2，SIO内部编号
     *
     * @param security2InternalId - 保镖2，SIO内部编号
     */
    public SioTaskBean setSecurity2InternalId(String security2InternalId) {
        this.security2InternalId = security2InternalId == null ? null : security2InternalId.trim();
        return this;
    }

    /**
     * 获取 保镖2，姓名
     *
     * @return task_security2_full_name - 保镖2，姓名
     */
    public String getSecurity2FullName() {
        return security2FullName;
    }

    /**
     * 设置 保镖2，姓名
     *
     * @param security2FullName - 保镖2，姓名
     */
    public SioTaskBean setSecurity2FullName(String security2FullName) {
        this.security2FullName = security2FullName == null ? null : security2FullName.trim();
        return this;
    }

    /**
     * 获取 保镖2，父亲姓
     *
     * @return task_security2_father_last_name - 保镖2，父亲姓
     */
    public String getSecurity2FatherLastName() {
        return security2FatherLastName;
    }

    /**
     * 设置 保镖2，父亲姓
     *
     * @param security2FatherLastName - 保镖2，父亲姓
     */
    public SioTaskBean setSecurity2FatherLastName(String security2FatherLastName) {
        this.security2FatherLastName = security2FatherLastName == null ? null : security2FatherLastName.trim();
        return this;
    }

    /**
     * 获取 保镖2，母亲姓
     *
     * @return task_security2_mother_last_name - 保镖2，母亲姓
     */
    public String getSecurity2MotherLastName() {
        return security2MotherLastName;
    }

    /**
     * 设置 保镖2，母亲姓
     *
     * @param security2MotherLastName - 保镖2，母亲姓
     */
    public SioTaskBean setSecurity2MotherLastName(String security2MotherLastName) {
        this.security2MotherLastName = security2MotherLastName == null ? null : security2MotherLastName.trim();
        return this;
    }

    /**
     * 获取 保镖2，SIO内部部门，ID
     *
     * @return task_security2_sio_department_id - 保镖2，SIO内部部门，ID
     */
    public String getSecurity2SioDepartmentId() {
        return security2SioDepartmentId;
    }

    /**
     * 设置 保镖2，SIO内部部门，ID
     *
     * @param security2SioDepartmentId - 保镖2，SIO内部部门，ID
     */
    public SioTaskBean setSecurity2SioDepartmentId(String security2SioDepartmentId) {
        this.security2SioDepartmentId = security2SioDepartmentId == null ? null : security2SioDepartmentId.trim();
        return this;
    }

    /**
     * 获取 保镖2，SIO内部部门，描述
     *
     * @return task_security2_sio_department_description - 保镖2，SIO内部部门，描述
     */
    public String getSecurity2SioDepartmentDescription() {
        return security2SioDepartmentDescription;
    }

    /**
     * 设置 保镖2，SIO内部部门，描述
     *
     * @param security2SioDepartmentDescription - 保镖2，SIO内部部门，描述
     */
    public SioTaskBean setSecurity2SioDepartmentDescription(String security2SioDepartmentDescription) {
        this.security2SioDepartmentDescription = security2SioDepartmentDescription == null ? null : security2SioDepartmentDescription.trim();
        return this;
    }

    /**
     * 获取 保镖2，SIO内部角色，ID
     *
     * @return task_security2_sio_role_id - 保镖2，SIO内部角色，ID
     */
    public String getSecurity2SioRoleId() {
        return security2SioRoleId;
    }

    /**
     * 设置 保镖2，SIO内部角色，ID
     *
     * @param security2SioRoleId - 保镖2，SIO内部角色，ID
     */
    public SioTaskBean setSecurity2SioRoleId(String security2SioRoleId) {
        this.security2SioRoleId = security2SioRoleId == null ? null : security2SioRoleId.trim();
        return this;
    }

    /**
     * 获取 保镖2，SIO内部角色，描述
     *
     * @return task_security2_sio_role_description - 保镖2，SIO内部角色，描述
     */
    public String getSecurity2SioRoleDescription() {
        return security2SioRoleDescription;
    }

    /**
     * 设置 保镖2，SIO内部角色，描述
     *
     * @param security2SioRoleDescription - 保镖2，SIO内部角色，描述
     */
    public SioTaskBean setSecurity2SioRoleDescription(String security2SioRoleDescription) {
        this.security2SioRoleDescription = security2SioRoleDescription == null ? null : security2SioRoleDescription.trim();
        return this;
    }

    /**
     * 获取 保镖2，sio与comodin对应角色
     *
     * @return task_security2_crew_type - 保镖2，sio与comodin对应角色
     */
    public String getSecurity2CrewType() {
        return security2CrewType;
    }

    /**
     * 设置 保镖2，sio与comodin对应角色
     *
     * @param security2CrewType - 保镖2，sio与comodin对应角色
     */
    public SioTaskBean setSecurity2CrewType(String security2CrewType) {
        this.security2CrewType = security2CrewType == null ? null : security2CrewType.trim();
        return this;
    }

    /**
     * 获取 保镖3，SIO内部编号
     *
     * @return task_security3_internal_id - 保镖3，SIO内部编号
     */
    public String getSecurity3InternalId() {
        return security3InternalId;
    }

    /**
     * 设置 保镖3，SIO内部编号
     *
     * @param security3InternalId - 保镖3，SIO内部编号
     */
    public SioTaskBean setSecurity3InternalId(String security3InternalId) {
        this.security3InternalId = security3InternalId == null ? null : security3InternalId.trim();
        return this;
    }

    /**
     * 获取 保镖3，姓名
     *
     * @return task_security3_full_name - 保镖3，姓名
     */
    public String getSecurity3FullName() {
        return security3FullName;
    }

    /**
     * 设置 保镖3，姓名
     *
     * @param security3FullName - 保镖3，姓名
     */
    public SioTaskBean setSecurity3FullName(String security3FullName) {
        this.security3FullName = security3FullName == null ? null : security3FullName.trim();
        return this;
    }

    /**
     * 获取 保镖3，父亲姓
     *
     * @return task_security3_father_last_name - 保镖3，父亲姓
     */
    public String getSecurity3FatherLastName() {
        return security3FatherLastName;
    }

    /**
     * 设置 保镖3，父亲姓
     *
     * @param security3FatherLastName - 保镖3，父亲姓
     */
    public SioTaskBean setSecurity3FatherLastName(String security3FatherLastName) {
        this.security3FatherLastName = security3FatherLastName == null ? null : security3FatherLastName.trim();
        return this;
    }

    /**
     * 获取 保镖3，母亲姓
     *
     * @return task_security3_mother_last_name - 保镖3，母亲姓
     */
    public String getSecurity3MotherLastName() {
        return security3MotherLastName;
    }

    /**
     * 设置 保镖3，母亲姓
     *
     * @param security3MotherLastName - 保镖3，母亲姓
     */
    public SioTaskBean setSecurity3MotherLastName(String security3MotherLastName) {
        this.security3MotherLastName = security3MotherLastName == null ? null : security3MotherLastName.trim();
        return this;
    }

    /**
     * 获取 保镖3，SIO内部部门，ID
     *
     * @return task_security3_sio_department_id - 保镖3，SIO内部部门，ID
     */
    public String getSecurity3SioDepartmentId() {
        return security3SioDepartmentId;
    }

    /**
     * 设置 保镖3，SIO内部部门，ID
     *
     * @param security3SioDepartmentId - 保镖3，SIO内部部门，ID
     */
    public SioTaskBean setSecurity3SioDepartmentId(String security3SioDepartmentId) {
        this.security3SioDepartmentId = security3SioDepartmentId == null ? null : security3SioDepartmentId.trim();
        return this;
    }

    /**
     * 获取 保镖3，SIO内部部门，描述
     *
     * @return task_security3_sio_department_description - 保镖3，SIO内部部门，描述
     */
    public String getSecurity3SioDepartmentDescription() {
        return security3SioDepartmentDescription;
    }

    /**
     * 设置 保镖3，SIO内部部门，描述
     *
     * @param security3SioDepartmentDescription - 保镖3，SIO内部部门，描述
     */
    public SioTaskBean setSecurity3SioDepartmentDescription(String security3SioDepartmentDescription) {
        this.security3SioDepartmentDescription = security3SioDepartmentDescription == null ? null : security3SioDepartmentDescription.trim();
        return this;
    }

    /**
     * 获取 保镖3，SIO内部角色，ID
     *
     * @return task_security3_sio_role_id - 保镖3，SIO内部角色，ID
     */
    public String getSecurity3SioRoleId() {
        return security3SioRoleId;
    }

    /**
     * 设置 保镖3，SIO内部角色，ID
     *
     * @param security3SioRoleId - 保镖3，SIO内部角色，ID
     */
    public SioTaskBean setSecurity3SioRoleId(String security3SioRoleId) {
        this.security3SioRoleId = security3SioRoleId == null ? null : security3SioRoleId.trim();
        return this;
    }

    /**
     * 获取 保镖3，SIO内部角色，描述
     *
     * @return task_security3_sio_role_description - 保镖3，SIO内部角色，描述
     */
    public String getSecurity3SioRoleDescription() {
        return security3SioRoleDescription;
    }

    /**
     * 设置 保镖3，SIO内部角色，描述
     *
     * @param security3SioRoleDescription - 保镖3，SIO内部角色，描述
     */
    public SioTaskBean setSecurity3SioRoleDescription(String security3SioRoleDescription) {
        this.security3SioRoleDescription = security3SioRoleDescription == null ? null : security3SioRoleDescription.trim();
        return this;
    }

    /**
     * 获取 保镖3，sio与comodin对应角色
     *
     * @return task_security3_crew_type - 保镖3，sio与comodin对应角色
     */
    public String getSecurity3CrewType() {
        return security3CrewType;
    }

    /**
     * 设置 保镖3，sio与comodin对应角色
     *
     * @param security3CrewType - 保镖3，sio与comodin对应角色
     */
    public SioTaskBean setSecurity3CrewType(String security3CrewType) {
        this.security3CrewType = security3CrewType == null ? null : security3CrewType.trim();
        return this;
    }

    /**
     * 获取 保镖4，SIO内部编号
     *
     * @return task_security4_internal_id - 保镖4，SIO内部编号
     */
    public String getSecurity4InternalId() {
        return security4InternalId;
    }

    /**
     * 设置 保镖4，SIO内部编号
     *
     * @param security4InternalId - 保镖4，SIO内部编号
     */
    public SioTaskBean setSecurity4InternalId(String security4InternalId) {
        this.security4InternalId = security4InternalId == null ? null : security4InternalId.trim();
        return this;
    }

    /**
     * 获取 保镖4，姓名
     *
     * @return task_security4_full_name - 保镖4，姓名
     */
    public String getSecurity4FullName() {
        return security4FullName;
    }

    /**
     * 设置 保镖4，姓名
     *
     * @param security4FullName - 保镖4，姓名
     */
    public SioTaskBean setSecurity4FullName(String security4FullName) {
        this.security4FullName = security4FullName == null ? null : security4FullName.trim();
        return this;
    }

    /**
     * 获取 保镖4，父亲姓
     *
     * @return task_security4_father_last_name - 保镖4，父亲姓
     */
    public String getSecurity4FatherLastName() {
        return security4FatherLastName;
    }

    /**
     * 设置 保镖4，父亲姓
     *
     * @param security4FatherLastName - 保镖4，父亲姓
     */
    public SioTaskBean setSecurity4FatherLastName(String security4FatherLastName) {
        this.security4FatherLastName = security4FatherLastName == null ? null : security4FatherLastName.trim();
        return this;
    }

    /**
     * 获取 保镖4，母亲姓
     *
     * @return task_security4_mother_last_name - 保镖4，母亲姓
     */
    public String getSecurity4MotherLastName() {
        return security4MotherLastName;
    }

    /**
     * 设置 保镖4，母亲姓
     *
     * @param security4MotherLastName - 保镖4，母亲姓
     */
    public SioTaskBean setSecurity4MotherLastName(String security4MotherLastName) {
        this.security4MotherLastName = security4MotherLastName == null ? null : security4MotherLastName.trim();
        return this;
    }

    /**
     * 获取 保镖4，SIO内部部门，ID
     *
     * @return task_security4_sio_department_id - 保镖4，SIO内部部门，ID
     */
    public String getSecurity4SioDepartmentId() {
        return security4SioDepartmentId;
    }

    /**
     * 设置 保镖4，SIO内部部门，ID
     *
     * @param security4SioDepartmentId - 保镖4，SIO内部部门，ID
     */
    public SioTaskBean setSecurity4SioDepartmentId(String security4SioDepartmentId) {
        this.security4SioDepartmentId = security4SioDepartmentId == null ? null : security4SioDepartmentId.trim();
        return this;
    }

    /**
     * 获取 保镖4，SIO内部部门，描述
     *
     * @return task_security4_sio_department_description - 保镖4，SIO内部部门，描述
     */
    public String getSecurity4SioDepartmentDescription() {
        return security4SioDepartmentDescription;
    }

    /**
     * 设置 保镖4，SIO内部部门，描述
     *
     * @param security4SioDepartmentDescription - 保镖4，SIO内部部门，描述
     */
    public SioTaskBean setSecurity4SioDepartmentDescription(String security4SioDepartmentDescription) {
        this.security4SioDepartmentDescription = security4SioDepartmentDescription == null ? null : security4SioDepartmentDescription.trim();
        return this;
    }

    /**
     * 获取 保镖4，SIO内部角色，ID
     *
     * @return task_security4_sio_role_id - 保镖4，SIO内部角色，ID
     */
    public String getSecurity4SioRoleId() {
        return security4SioRoleId;
    }

    /**
     * 设置 保镖4，SIO内部角色，ID
     *
     * @param security4SioRoleId - 保镖4，SIO内部角色，ID
     */
    public SioTaskBean setSecurity4SioRoleId(String security4SioRoleId) {
        this.security4SioRoleId = security4SioRoleId == null ? null : security4SioRoleId.trim();
        return this;
    }

    /**
     * 获取 保镖4，SIO内部角色，描述
     *
     * @return task_security4_sio_role_description - 保镖4，SIO内部角色，描述
     */
    public String getSecurity4SioRoleDescription() {
        return security4SioRoleDescription;
    }

    /**
     * 设置 保镖4，SIO内部角色，描述
     *
     * @param security4SioRoleDescription - 保镖4，SIO内部角色，描述
     */
    public SioTaskBean setSecurity4SioRoleDescription(String security4SioRoleDescription) {
        this.security4SioRoleDescription = security4SioRoleDescription == null ? null : security4SioRoleDescription.trim();
        return this;
    }

    /**
     * 获取 保镖4，sio与comodin对应角色
     *
     * @return task_security4_crew_type - 保镖4，sio与comodin对应角色
     */
    public String getSecurity4CrewType() {
        return security4CrewType;
    }

    /**
     * 设置 保镖4，sio与comodin对应角色
     *
     * @param security4CrewType - 保镖4，sio与comodin对应角色
     */
    public SioTaskBean setSecurity4CrewType(String security4CrewType) {
        this.security4CrewType = security4CrewType == null ? null : security4CrewType.trim();
        return this;
    }

    /**
     * 获取 计数者，SIO内部编号
     *
     * @return task_counter_internal_id - 计数者，SIO内部编号
     */
    public String getCounterInternalId() {
        return counterInternalId;
    }

    /**
     * 设置 计数者，SIO内部编号
     *
     * @param counterInternalId - 计数者，SIO内部编号
     */
    public SioTaskBean setCounterInternalId(String counterInternalId) {
        this.counterInternalId = counterInternalId == null ? null : counterInternalId.trim();
        return this;
    }

    /**
     * 获取 计数者，姓名
     *
     * @return task_counter_full_name - 计数者，姓名
     */
    public String getCounterFullName() {
        return counterFullName;
    }

    /**
     * 设置 计数者，姓名
     *
     * @param counterFullName - 计数者，姓名
     */
    public SioTaskBean setCounterFullName(String counterFullName) {
        this.counterFullName = counterFullName == null ? null : counterFullName.trim();
        return this;
    }

    /**
     * 获取 计数者，父亲姓
     *
     * @return task_counter_father_last_name - 计数者，父亲姓
     */
    public String getCounterFatherLastName() {
        return counterFatherLastName;
    }

    /**
     * 设置 计数者，父亲姓
     *
     * @param counterFatherLastName - 计数者，父亲姓
     */
    public SioTaskBean setCounterFatherLastName(String counterFatherLastName) {
        this.counterFatherLastName = counterFatherLastName == null ? null : counterFatherLastName.trim();
        return this;
    }

    /**
     * 获取 计数者，母亲姓
     *
     * @return task_counter_mother_last_name - 计数者，母亲姓
     */
    public String getCounterMotherLastName() {
        return counterMotherLastName;
    }

    /**
     * 设置 计数者，母亲姓
     *
     * @param counterMotherLastName - 计数者，母亲姓
     */
    public SioTaskBean setCounterMotherLastName(String counterMotherLastName) {
        this.counterMotherLastName = counterMotherLastName == null ? null : counterMotherLastName.trim();
        return this;
    }

    /**
     * 获取 计数者，SIO内部部门，ID
     *
     * @return task_counter_sio_department_id - 计数者，SIO内部部门，ID
     */
    public String getCounterSioDepartmentId() {
        return counterSioDepartmentId;
    }

    /**
     * 设置 计数者，SIO内部部门，ID
     *
     * @param counterSioDepartmentId - 计数者，SIO内部部门，ID
     */
    public SioTaskBean setCounterSioDepartmentId(String counterSioDepartmentId) {
        this.counterSioDepartmentId = counterSioDepartmentId == null ? null : counterSioDepartmentId.trim();
        return this;
    }

    /**
     * 获取 计数者，SIO内部部门，描述
     *
     * @return task_counter_sio_department_description - 计数者，SIO内部部门，描述
     */
    public String getCounterSioDepartmentDescription() {
        return counterSioDepartmentDescription;
    }

    /**
     * 设置 计数者，SIO内部部门，描述
     *
     * @param counterSioDepartmentDescription - 计数者，SIO内部部门，描述
     */
    public SioTaskBean setCounterSioDepartmentDescription(String counterSioDepartmentDescription) {
        this.counterSioDepartmentDescription = counterSioDepartmentDescription == null ? null : counterSioDepartmentDescription.trim();
        return this;
    }

    /**
     * 获取 计数者，SIO内部角色，ID
     *
     * @return task_counter_sio_role_id - 计数者，SIO内部角色，ID
     */
    public String getCounterSioRoleId() {
        return counterSioRoleId;
    }

    /**
     * 设置 计数者，SIO内部角色，ID
     *
     * @param counterSioRoleId - 计数者，SIO内部角色，ID
     */
    public SioTaskBean setCounterSioRoleId(String counterSioRoleId) {
        this.counterSioRoleId = counterSioRoleId == null ? null : counterSioRoleId.trim();
        return this;
    }

    /**
     * 获取 计数者，SIO内部角色，描述
     *
     * @return task_counter_sio_role_description - 计数者，SIO内部角色，描述
     */
    public String getCounterSioRoleDescription() {
        return counterSioRoleDescription;
    }

    /**
     * 设置 计数者，SIO内部角色，描述
     *
     * @param counterSioRoleDescription - 计数者，SIO内部角色，描述
     */
    public SioTaskBean setCounterSioRoleDescription(String counterSioRoleDescription) {
        this.counterSioRoleDescription = counterSioRoleDescription == null ? null : counterSioRoleDescription.trim();
        return this;
    }

    /**
     * 获取 计数者，sio与comodin对应角色
     *
     * @return task_counter_crew_type - 计数者，sio与comodin对应角色
     */
    public String getCounterCrewType() {
        return counterCrewType;
    }

    /**
     * 设置 计数者，sio与comodin对应角色
     *
     * @param counterCrewType - 计数者，sio与comodin对应角色
     */
    public SioTaskBean setCounterCrewType(String counterCrewType) {
        this.counterCrewType = counterCrewType == null ? null : counterCrewType.trim();
        return this;
    }

    /**
     * 获取 付款人，SIO内部编号
     *
     * @return task_drawee_internal_id - 付款人，SIO内部编号
     */
    public String getDraweeInternalId() {
        return draweeInternalId;
    }

    /**
     * 设置 付款人，SIO内部编号
     *
     * @param draweeInternalId - 付款人，SIO内部编号
     */
    public SioTaskBean setDraweeInternalId(String draweeInternalId) {
        this.draweeInternalId = draweeInternalId == null ? null : draweeInternalId.trim();
        return this;
    }

    /**
     * 获取 付款人，姓名
     *
     * @return task_drawee_full_name - 付款人，姓名
     */
    public String getDraweeFullName() {
        return draweeFullName;
    }

    /**
     * 设置 付款人，姓名
     *
     * @param draweeFullName - 付款人，姓名
     */
    public SioTaskBean setDraweeFullName(String draweeFullName) {
        this.draweeFullName = draweeFullName == null ? null : draweeFullName.trim();
        return this;
    }

    /**
     * 获取 付款人，父亲姓
     *
     * @return task_drawee_father_last_name - 付款人，父亲姓
     */
    public String getDraweeFatherLastName() {
        return draweeFatherLastName;
    }

    /**
     * 设置 付款人，父亲姓
     *
     * @param draweeFatherLastName - 付款人，父亲姓
     */
    public SioTaskBean setDraweeFatherLastName(String draweeFatherLastName) {
        this.draweeFatherLastName = draweeFatherLastName == null ? null : draweeFatherLastName.trim();
        return this;
    }

    /**
     * 获取 付款人，母亲姓
     *
     * @return task_drawee_mother_last_name - 付款人，母亲姓
     */
    public String getDraweeMotherLastName() {
        return draweeMotherLastName;
    }

    /**
     * 设置 付款人，母亲姓
     *
     * @param draweeMotherLastName - 付款人，母亲姓
     */
    public SioTaskBean setDraweeMotherLastName(String draweeMotherLastName) {
        this.draweeMotherLastName = draweeMotherLastName == null ? null : draweeMotherLastName.trim();
        return this;
    }

    /**
     * 获取 付款人，SIO内部部门，ID
     *
     * @return task_drawee_sio_department_id - 付款人，SIO内部部门，ID
     */
    public String getDraweeSioDepartmentId() {
        return draweeSioDepartmentId;
    }

    /**
     * 设置 付款人，SIO内部部门，ID
     *
     * @param draweeSioDepartmentId - 付款人，SIO内部部门，ID
     */
    public SioTaskBean setDraweeSioDepartmentId(String draweeSioDepartmentId) {
        this.draweeSioDepartmentId = draweeSioDepartmentId == null ? null : draweeSioDepartmentId.trim();
        return this;
    }

    /**
     * 获取 付款人，SIO内部部门，描述
     *
     * @return task_drawee_sio_department_description - 付款人，SIO内部部门，描述
     */
    public String getDraweeSioDepartmentDescription() {
        return draweeSioDepartmentDescription;
    }

    /**
     * 设置 付款人，SIO内部部门，描述
     *
     * @param draweeSioDepartmentDescription - 付款人，SIO内部部门，描述
     */
    public SioTaskBean setDraweeSioDepartmentDescription(String draweeSioDepartmentDescription) {
        this.draweeSioDepartmentDescription = draweeSioDepartmentDescription == null ? null : draweeSioDepartmentDescription.trim();
        return this;
    }

    /**
     * 获取 付款人，SIO内部角色，ID
     *
     * @return task_drawee_sio_role_id - 付款人，SIO内部角色，ID
     */
    public String getDraweeSioRoleId() {
        return draweeSioRoleId;
    }

    /**
     * 设置 付款人，SIO内部角色，ID
     *
     * @param draweeSioRoleId - 付款人，SIO内部角色，ID
     */
    public SioTaskBean setDraweeSioRoleId(String draweeSioRoleId) {
        this.draweeSioRoleId = draweeSioRoleId == null ? null : draweeSioRoleId.trim();
        return this;
    }

    /**
     * 获取 付款人，SIO内部角色，描述
     *
     * @return task_drawee_sio_role_description - 付款人，SIO内部角色，描述
     */
    public String getDraweeSioRoleDescription() {
        return draweeSioRoleDescription;
    }

    /**
     * 设置 付款人，SIO内部角色，描述
     *
     * @param draweeSioRoleDescription - 付款人，SIO内部角色，描述
     */
    public SioTaskBean setDraweeSioRoleDescription(String draweeSioRoleDescription) {
        this.draweeSioRoleDescription = draweeSioRoleDescription == null ? null : draweeSioRoleDescription.trim();
        return this;
    }

    /**
     * 获取 付款人，sio与comodin对应角色
     *
     * @return task_drawee_crew_type - 付款人，sio与comodin对应角色
     */
    public String getDraweeCrewType() {
        return draweeCrewType;
    }

    /**
     * 设置 付款人，sio与comodin对应角色
     *
     * @param draweeCrewType - 付款人，sio与comodin对应角色
     */
    public SioTaskBean setDraweeCrewType(String draweeCrewType) {
        this.draweeCrewType = draweeCrewType == null ? null : draweeCrewType.trim();
        return this;
    }

    /**
     * 获取 XML，每个任务的最后的员工节点
     *
     * @return task_crew_crew_json - XML，每个任务的最后的员工节点
     */
    public String getCrewCrewJson() {
        return crewCrewJson;
    }

    /**
     * 设置 XML，每个任务的最后的员工节点
     *
     * @param crewCrewJson - XML，每个任务的最后的员工节点
     */
    public SioTaskBean setCrewCrewJson(String crewCrewJson) {
        this.crewCrewJson = crewCrewJson == null ? null : crewCrewJson.trim();
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
    public SioTaskBean setCreateTimestamp(Date createTimestamp) {
        this.createTimestamp = createTimestamp;
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
    public SioTaskBean setCreateBy(String createBy) {
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
    public SioTaskBean setDeleteFlag(String deleteFlag) {
        this.deleteFlag = deleteFlag == null ? null : deleteFlag.trim();
        return this;
    }
}