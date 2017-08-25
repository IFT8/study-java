package com.comodin.fleet.constants.i18n;

@SuppressWarnings({"unused", "SpringAutowiredFieldsWarningInspection", "StatementWithEmptyBody"})
public class TaskBeanI18nConstant  {

    /**
     * 收银员班次,与shift_week_start_date,对应;【应在生成计划任务,根据人员安排时,设置值也要注意在变更路线时,设置值】
     */
    public static final String TASK_BEAN_CASHIER_SHIFT_LENGTH = "TASK_BEAN_CASHIER_SHIFT_LENGTH";
    /**
     * 收件人内部ID,与t_client.client_internal_id关联
     */
    public static final String TASK_BEAN_RECEIVER_CLIENT_INTERNAL_ID_LENGTH = "TASK_BEAN_RECEIVER_CLIENT_INTERNAL_ID_LENGTH";
    /**
     * 取消任务,理由,t_setting.setting_key,关联
     */
    public static final String TASK_BEAN_CANCEL_REASON_LENGTH = "TASK_BEAN_CANCEL_REASON_LENGTH";
    /**
     * 出纳员ID,与t_crew.crew_id冗余
     */
    public static final String TASK_BEAN_CASHIER_ID_LENGTH = "TASK_BEAN_CASHIER_ID_LENGTH";
    public static final String TASK_BEAN_LAST_GENERATE_XML_TASK_STATUS_LENGTH = "TASK_BEAN_LAST_GENERATE_XML_TASK_STATUS_LENGTH";
    /**
     * 收件人网点地址坐标纬度,浮点型,与t_client_branch.branch_latitude,关联
     */
    public static final String TASK_BEAN_RECEIVER_BRANCH_LATITUDE_LENGTH = "TASK_BEAN_RECEIVER_BRANCH_LATITUDE_LENGTH";
    /**
     * 车辆id,与t_vehicle关联
     */
    public static final String TASK_BEAN_VEHICLE_ID_LENGTH = "TASK_BEAN_VEHICLE_ID_LENGTH";
    /**
     * 保镖4名字,与t_crew.crew_first_name字段关联
     */
    public static final String TASK_BEAN_SECURITY4_FIRST_NAME_LENGTH = "TASK_BEAN_SECURITY4_FIRST_NAME_LENGTH";
    /**
     * 收件人网点执行服务时长,单位分钟,与t_task_contract.contract_receiver_time_window_duration,冗余
     */
    public static final String TASK_BEAN_RECEIVER_TIME_WINDOW_DURATION_LENGTH = "TASK_BEAN_RECEIVER_TIME_WINDOW_DURATION_LENGTH";
    /**
     * nip客户负责人username,在客户负责人与司机进行交接时,确认签收人的username
     */
    public static final String TASK_BEAN_NIP_CONFIRM_USERNAME_LENGTH = "TASK_BEAN_NIP_CONFIRM_USERNAME_LENGTH";
    /**
     * 任务是否需要现场数钞【NOT_COUNT[不需要]COUNT_TOTAL[统计总额]COUNT_DENOMINATION[统计面额]REAL_TIME_ARRIVAL[实时到账]】
     */
    public static final String TASK_BEAN_WHETHER_SITE_COUNTING_NOT_BLANK = "TASK_BEAN_WHETHER_SITE_COUNTING_NOT_BLANK";
    /**
     * 任务，到达目的（网点地址）时间，系统自动根据经纬度范围，推算出来的时间
     */
    public static final String TASK_BEAN_ARRIVAL_TIME_AUTO_CALC_DATE_TIME_FORMAT = "TASK_BEAN_ARRIVAL_TIME_AUTO_CALC_DATE_TIME_FORMAT";
    /**
     * 任务是否有效【ENABLE[启用]、DISABLE[禁用]】
     */
    public static final String TASK_BEAN_AVAILABILITY_LENGTH = "TASK_BEAN_AVAILABILITY_LENGTH";
    /**
     * 任务所需要的人数
     */
    public static final String TASK_BEAN_SERVICE_PERSON_NUMBER_LENGTH = "TASK_BEAN_SERVICE_PERSON_NUMBER_LENGTH";
    /**
     * 任务原始,描述 - 需要在APP中显示
     */
    public static final String TASK_BEAN_SOURCE_DESCRIPTION_LENGTH = "TASK_BEAN_SOURCE_DESCRIPTION_LENGTH";
    /**
     * 保镖4内部编号,与t_crew.crew_internal_id冗余
     */
    public static final String TASK_BEAN_SECURITY4_INTERNAL_ID_LENGTH = "TASK_BEAN_SECURITY4_INTERNAL_ID_LENGTH";
    /**
     * 发件人网点服务时间窗口开始时间,时间格式 hh:mm:ss,与t_task_contract.contract_sender_time_window_start,冗余
     */
    public static final String TASK_BEAN_SENDER_TIME_WINDOW_START_NOT_BLANK = "TASK_BEAN_SENDER_TIME_WINDOW_START_NOT_BLANK";
    /**
     * 收件人网点服务时间窗口开始时间,时间格式 hh:mm:ss,与t_task_contract.contract_receiver_time_window_start,冗余
     */
    public static final String TASK_BEAN_RECEIVER_TIME_WINDOW_START_NOT_BLANK = "TASK_BEAN_RECEIVER_TIME_WINDOW_START_NOT_BLANK";
    /**
     * 发件人网点执行服务时长,单位分钟,与t_task_contract.contract_sender_time_window_duration,冗余
     */
    public static final String TASK_BEAN_SENDER_TIME_WINDOW_DURATION_LENGTH = "TASK_BEAN_SENDER_TIME_WINDOW_DURATION_LENGTH";
    /**
     * 路线顺序,与t_task_contract.contract_route_order,关联
     */
    public static final String TASK_BEAN_ROUTE_ORDER_LENGTH = "TASK_BEAN_ROUTE_ORDER_LENGTH";
    /**
     * 任务状态,任务当下的状态 pending schedule assign_route assign_driver assign_guard assign_vehicle in_route in_processcomprobante completed inter_changed cancelled
     */
    public static final String TASK_BEAN_STATUS_LENGTH = "TASK_BEAN_STATUS_LENGTH";
    /**
     * 发件人客户ID,与t_client.client_id 字段关联
     */
    public static final String TASK_BEAN_SENDER_CLIENT_ID_LENGTH = "TASK_BEAN_SENDER_CLIENT_ID_LENGTH";
    /**
     * 客户到客户类型任务，收钱时的任务处理结束时间,目前系统根据,司机手机APP,在验收钞票与票据动作之后,completed任务,完成
     */
    public static final String TASK_BEAN_PARTIAL_PROCESS_END_TIMESTAMP_DATE_TIME_FORMAT = "TASK_BEAN_PARTIAL_PROCESS_END_TIMESTAMP_DATE_TIME_FORMAT";
    /**
     * 发件人网点内部ID,与t_client_branch.branch_internal_id 字段冗余
     */
    public static final String TASK_BEAN_SENDER_BRANCH_INTERNAL_ID_LENGTH = "TASK_BEAN_SENDER_BRANCH_INTERNAL_ID_LENGTH";
    /**
     * 收件人网点名称,与t_client_branch.branch_name 字段冗余
     */
    public static final String TASK_BEAN_RECEIVER_BRANCH_NAME_NOT_BLANK = "TASK_BEAN_RECEIVER_BRANCH_NAME_NOT_BLANK";
    /**
     * 收件人网点联系电话,与t_client_branch.branch_phone,关联
     */
    public static final String TASK_BEAN_RECEIVER_BRANCH_PHONE_LENGTH = "TASK_BEAN_RECEIVER_BRANCH_PHONE_LENGTH";
    /**
     * 任务是否需要现场数钞【NOT_COUNT[不需要]COUNT_TOTAL[统计总额]COUNT_DENOMINATION[统计面额]REAL_TIME_ARRIVAL[实时到账]】
     */
    public static final String TASK_BEAN_WHETHER_SITE_COUNTING_LENGTH = "TASK_BEAN_WHETHER_SITE_COUNTING_LENGTH";
    /**
     * 逻辑删除标志【N[正常]，Y[删除]】
     */
    public static final String TASK_BEAN_DELETE_FLAG_LENGTH = "TASK_BEAN_DELETE_FLAG_LENGTH";
    /**
     * 司机名字,与t_crew.crew_first_name字段关联
     */
    public static final String TASK_BEAN_DRIVER_FIRST_NAME_LENGTH = "TASK_BEAN_DRIVER_FIRST_NAME_LENGTH";
    /**
     * 任务完成结果描述
     */
    public static final String TASK_BEAN_DESCRIPTION_LENGTH = "TASK_BEAN_DESCRIPTION_LENGTH";
    /**
     * 发件人网点id,与t_task_contract.contract_sender_branch_id,关联
     */
    public static final String TASK_BEAN_SENDER_BRANCH_ID_LENGTH = "TASK_BEAN_SENDER_BRANCH_ID_LENGTH";
    /**
     * 任务是否有效【ENABLE[启用]、DISABLE[禁用]】
     */
    public static final String TASK_BEAN_AVAILABILITY_NOT_BLANK = "TASK_BEAN_AVAILABILITY_NOT_BLANK";
    /**
     * 客户到客户类型，任务，到达目的（网点地址）时间，人工输入的时间
     */
    public static final String TASK_BEAN_PARTIAL_ARRIVAL_TIME_MANUAL_INPUT_DATE_TIME_FORMAT = "TASK_BEAN_PARTIAL_ARRIVAL_TIME_MANUAL_INPUT_DATE_TIME_FORMAT";
    /**
     * 任务ID,与pk_id区别在于,业务场景:在 in_changed的时候,会生成两条记录task_pk_id 而task_id为同一条,且只有一条task_availability,为ENABLE
     */
    public static final String TASK_BEAN_TASK_ID_NOT_NULL = "TASK_BEAN_TASK_ID_NOT_NULL";
    /**
     * 保镖4姓氏,与t_crew.crew_last_name字段关联
     */
    public static final String TASK_BEAN_SECURITY4_LAST_NAME_LENGTH = "TASK_BEAN_SECURITY4_LAST_NAME_LENGTH";
    /**
     * 保镖3内部编号,与t_crew.crew_internal_id冗余
     */
    public static final String TASK_BEAN_SECURITY3_INTERNAL_ID_LENGTH = "TASK_BEAN_SECURITY3_INTERNAL_ID_LENGTH";
    /**
     * 发件人网点联系电话,与t_client_branch.branch_phone,关联
     */
    public static final String TASK_BEAN_SENDER_BRANCH_PHONE_LENGTH = "TASK_BEAN_SENDER_BRANCH_PHONE_LENGTH";
    /**
     * 数据库主键ID
     */
    public static final String TASK_BEAN_PK_ID_NOT_NULL = "TASK_BEAN_PK_ID_NOT_NULL";
    public static final String TASK_BEAN_UPDATE_TIMESTAMP_NOT_NULL = "TASK_BEAN_UPDATE_TIMESTAMP_NOT_NULL";
    /**
     * 取消任务,责任方【CIT,CLIENT】
     */
    public static final String TASK_BEAN_CANCEL_RESPONSIBLE_PARTY_LENGTH = "TASK_BEAN_CANCEL_RESPONSIBLE_PARTY_LENGTH";
    /**
     * 保镖2电话,与t_crew.crew_phone字段关联
     */
    public static final String TASK_BEAN_SECURITY2_PHONE_LENGTH = "TASK_BEAN_SECURITY2_PHONE_LENGTH";
    /**
     * 保镖4电话,与t_crew.crew_phone字段关联
     */
    public static final String TASK_BEAN_SECURITY4_PHONE_LENGTH = "TASK_BEAN_SECURITY4_PHONE_LENGTH";
    /**
     * APP司机部，每次回传的版本号
     */
    public static final String TASK_BEAN_APP_VERSION_DATE_TIME_FORMAT = "TASK_BEAN_APP_VERSION_DATE_TIME_FORMAT";
    /**
     * 保镖2班次,与shift_week_start_date,对应;【应在生成计划任务,根据人员安排时,设置值也要注意在变更路线时,设置值】
     */
    public static final String TASK_BEAN_SECURITY2_SHIFT_LENGTH = "TASK_BEAN_SECURITY2_SHIFT_LENGTH";
    /**
     * 客户到客户类型任务，收钱时的任务处理完成后,时效【ON_TIME 为及时、IN_ADVANCE 为早到、BE_LATE 为迟到、TIME_OUT 为超时】
     */
    public static final String TASK_BEAN_PARTIAL_PROCESS_TIMELINESS_LENGTH = "TASK_BEAN_PARTIAL_PROCESS_TIMELINESS_LENGTH";
    /**
     * 发件人网点地址坐标纬度,浮点型,与t_client_branch.branch_latitude,关联
     */
    public static final String TASK_BEAN_SENDER_BRANCH_LATITUDE_LENGTH = "TASK_BEAN_SENDER_BRANCH_LATITUDE_LENGTH";
    /**
     * 与t_vehicle.vehicle_internal_id冗余4位数字的内部编号
     */
    public static final String TASK_BEAN_VEHICLE_INTERNAL_ID_LENGTH = "TASK_BEAN_VEHICLE_INTERNAL_ID_LENGTH";
    /**
     * 收银员名字,与t_crew.crew_first_name字段关联
     */
    public static final String TASK_BEAN_CASHIER_FIRST_NAME_LENGTH = "TASK_BEAN_CASHIER_FIRST_NAME_LENGTH";
    /**
     * interchange任务时地址坐标纬度,浮点型
     */
    public static final String TASK_BEAN_INTER_CHANGE_LATITUDE_LENGTH = "TASK_BEAN_INTER_CHANGE_LATITUDE_LENGTH";
    /**
     * 与t_vehicle.vehicle_currency_capacity冗余,货币限定容量
     */
    public static final String TASK_BEAN_VEHICLE_CURRENCY_CAPACITY_LENGTH = "TASK_BEAN_VEHICLE_CURRENCY_CAPACITY_LENGTH";
    /**
     * ATM外部编号,在调用第三方接口里的唯一标识
     */
    public static final String TASK_BEAN_ATM_EXTERNAL_ID_LENGTH = "TASK_BEAN_ATM_EXTERNAL_ID_LENGTH";
    /**
     * 保镖3电话,与t_crew.crew_phone字段关联
     */
    public static final String TASK_BEAN_SECURITY3_PHONE_LENGTH = "TASK_BEAN_SECURITY3_PHONE_LENGTH";
    /**
     * 与t_vehicle.vehicle_armored_level冗余武装等级:none,light,medium,heavy
     */
    public static final String TASK_BEAN_VEHICLE_ARMORED_LEVEL_LENGTH = "TASK_BEAN_VEHICLE_ARMORED_LEVEL_LENGTH";
    /**
     * 任务是否为交接，已收到钱在车上【Y[任务是已完成]、N[任务未完成]】
     */
    public static final String TASK_BEAN_WHETHER_COMPLETED_NOT_BLANK = "TASK_BEAN_WHETHER_COMPLETED_NOT_BLANK";
    /**
     * 任务来源的,网点,内部ID【date:2016-12-12 by:supeng】
     */
    public static final String TASK_BEAN_SOURCE_BRANCH_INTERNAL_ID_LENGTH = "TASK_BEAN_SOURCE_BRANCH_INTERNAL_ID_LENGTH";
    /**
     * 保镖2username,与t_crew.crew_username冗余
     */
    public static final String TASK_BEAN_SECURITY2_USERNAME_LENGTH = "TASK_BEAN_SECURITY2_USERNAME_LENGTH";
    /**
     * 任务来源的,公司,内部ID【date:2016-12-12 by:supeng】
     */
    public static final String TASK_BEAN_SOURCE_COMPANY_INTERNAL_ID_LENGTH = "TASK_BEAN_SOURCE_COMPANY_INTERNAL_ID_LENGTH";
    /**
     * 创建时间
     */
    public static final String TASK_BEAN_CREATE_TIMESTAMP_NOT_NULL = "TASK_BEAN_CREATE_TIMESTAMP_NOT_NULL";
    /**
     * 完成任务（或者部分完成任务）时地址坐标经度,浮点型
     */
    public static final String TASK_BEAN_COMPLETE_LONGITUDE_LENGTH = "TASK_BEAN_COMPLETE_LONGITUDE_LENGTH";
    /**
     * 数据库主键ID
     */
    public static final String TASK_BEAN_PK_ID_LENGTH = "TASK_BEAN_PK_ID_LENGTH";
    /**
     * 保镖4班次,与shift_week_start_date,对应;【应在生成计划任务,根据人员安排时,设置值也要注意在变更路线时,设置值】
     */
    public static final String TASK_BEAN_SECURITY4_SHIFT_LENGTH = "TASK_BEAN_SECURITY4_SHIFT_LENGTH";
    /**
     * 任务处理完成后,时效【ON_TIME 为及时、IN_ADVANCE 为早到、BE_LATE 为迟到、TIME_OUT 为超时】
     */
    public static final String TASK_BEAN_PROCESS_TIMELINESS_LENGTH = "TASK_BEAN_PROCESS_TIMELINESS_LENGTH";
    /**
     * 取消任务,备注
     */
    public static final String TASK_BEAN_CANCEL_COMMENT_LENGTH = "TASK_BEAN_CANCEL_COMMENT_LENGTH";
    /**
     * 路线id,与t_task_contract.contract_route_id,关联
     */
    public static final String TASK_BEAN_ROUTE_ID_NOT_BLANK = "TASK_BEAN_ROUTE_ID_NOT_BLANK";
    /**
     * 收银员username,与t_crew.crew_username冗余
     */
    public static final String TASK_BEAN_CASHIER_USERNAME_LENGTH = "TASK_BEAN_CASHIER_USERNAME_LENGTH";
    /**
     * 收件人网点服务时间窗口结束时间,时间格式 hh:mm:ss,与t_task_contract.contract_receiver_time_window_end,冗余
     */
    public static final String TASK_BEAN_RECEIVER_TIME_WINDOW_END_NOT_BLANK = "TASK_BEAN_RECEIVER_TIME_WINDOW_END_NOT_BLANK";
    /**
     * 任务原始,服务类型【1_CLIENT_TO_CLIENT、2_RECEIVER_CLIENT_TO_BOVEDA、3_RECEIVER_CLIENT_TO_PROCESS、4_SENDER_BOVEDA_TO_CLIENT、5_SENDER_PROCESS_TO_CLIENT、6_SENDER_WAREHOUSE_TO_CLIENT】by:supeng date:2017-05-19
     */
    public static final String TASK_BEAN_SOURCE_SERVICE_TYPE_LENGTH = "TASK_BEAN_SOURCE_SERVICE_TYPE_LENGTH";
    /**
     * 收件人网点名称,与t_client_branch.branch_name 字段冗余
     */
    public static final String TASK_BEAN_RECEIVER_BRANCH_NAME_LENGTH = "TASK_BEAN_RECEIVER_BRANCH_NAME_LENGTH";
    /**
     * 收银员内部编号,与t_crew.crew_internal_id冗余
     */
    public static final String TASK_BEAN_CASHIER_INTERNAL_ID_LENGTH = "TASK_BEAN_CASHIER_INTERNAL_ID_LENGTH";
    /**
     * 司机电话,与t_crew.crew_phone字段关联
     */
    public static final String TASK_BEAN_DRIVER_PHONE_LENGTH = "TASK_BEAN_DRIVER_PHONE_LENGTH";
    /**
     * 保镖3username,与t_crew.crew_username冗余
     */
    public static final String TASK_BEAN_SECURITY3_USERNAME_LENGTH = "TASK_BEAN_SECURITY3_USERNAME_LENGTH";
    /**
     * 保镖1ID,与t_crew.crew_id冗余
     */
    public static final String TASK_BEAN_SECURITY1_ID_LENGTH = "TASK_BEAN_SECURITY1_ID_LENGTH";
    /**
     * 任务预设截止日期,目前ATM修复任务类型任务时才有该字段信息
     */
    public static final String TASK_BEAN_DEADLINE_LENGTH = "TASK_BEAN_DEADLINE_LENGTH";
    /**
     * nip客户负责人确认签收密码6位,MD5加密之后取前8位,与t_user.user_pass_code【该分支机构下,所有拥有nip密码的,JSON对象[{username:a1,passCode:123456},{username:a2,passCode:654321}]】
     */
    public static final String TASK_BEAN_NIP_USERNAME_PASS_CODE_LENGTH = "TASK_BEAN_NIP_USERNAME_PASS_CODE_LENGTH";
    /**
     * 任务原始,服务代码
     */
    public static final String TASK_BEAN_SOURCE_SERVICE_CODE_LENGTH = "TASK_BEAN_SOURCE_SERVICE_CODE_LENGTH";
    /**
     * 任务原始,钥匙编号
     */
    public static final String TASK_BEAN_SOURCE_SAFE_KEY_NUMBER_LENGTH = "TASK_BEAN_SOURCE_SAFE_KEY_NUMBER_LENGTH";
    /**
     * 任务来源的,网点,名【date:2016-12-12 by:supeng】
     */
    public static final String TASK_BEAN_SOURCE_BRANCH_NAME_LENGTH = "TASK_BEAN_SOURCE_BRANCH_NAME_LENGTH";
    /**
     * 发件人网点服务时间窗口结束时间,时间格式 hh:mm:ss,与t_task_contract.contract_sender_time_window_end,冗余
     */
    public static final String TASK_BEAN_SENDER_TIME_WINDOW_END_LENGTH = "TASK_BEAN_SENDER_TIME_WINDOW_END_LENGTH";
    /**
     * 任务处理结束时间,目前系统根据,司机手机APP,在验收钞票与票据动作之后,completed任务,完成
     */
    public static final String TASK_BEAN_PROCESS_END_TIMESTAMP_DATE_TIME_FORMAT = "TASK_BEAN_PROCESS_END_TIMESTAMP_DATE_TIME_FORMAT";
    /**
     * 保镖1班次,与shift_week_start_date,对应;【应在生成计划任务,根据人员安排时,设置值也要注意在变更路线时,设置值】
     */
    public static final String TASK_BEAN_SECURITY1_SHIFT_LENGTH = "TASK_BEAN_SECURITY1_SHIFT_LENGTH";
    /**
     * 保镖2名字,与t_crew.crew_first_name字段关联
     */
    public static final String TASK_BEAN_SECURITY2_FIRST_NAME_LENGTH = "TASK_BEAN_SECURITY2_FIRST_NAME_LENGTH";
    /**
     * 收件人网点服务时间窗口开始时间,时间格式 hh:mm:ss,与t_task_contract.contract_receiver_time_window_start,冗余
     */
    public static final String TASK_BEAN_RECEIVER_TIME_WINDOW_START_LENGTH = "TASK_BEAN_RECEIVER_TIME_WINDOW_START_LENGTH";
    /**
     * 与t_vehicle.vehicle_vin冗余车辆识别代号,全宇宙唯一代号
     */
    public static final String TASK_BEAN_VEHICLE_VIN_LENGTH = "TASK_BEAN_VEHICLE_VIN_LENGTH";
    /**
     * 收件人网点id,与t_task_contract.contract_receiver_branch_id,关联
     */
    public static final String TASK_BEAN_RECEIVER_BRANCH_ID_LENGTH = "TASK_BEAN_RECEIVER_BRANCH_ID_LENGTH";
    /**
     * 服务种类【WORKDAY[工作日], HOLIDAY[节假日], SATURDAY[周六], SUNDAY[周日]】,与t_task_contract.contract_service_line,关联
     */
    public static final String TASK_BEAN_SERVICE_LINE_LENGTH = "TASK_BEAN_SERVICE_LINE_LENGTH";
    /**
     * interchange任务时地址坐标经度,浮点型
     */
    public static final String TASK_BEAN_INTER_CHANGE_LONGITUDE_LENGTH = "TASK_BEAN_INTER_CHANGE_LONGITUDE_LENGTH";
    /**
     * 任务来源的,公司,名【date:2016-12-12 by:supeng】
     */
    public static final String TASK_BEAN_SOURCE_COMPANY_NAME_LENGTH = "TASK_BEAN_SOURCE_COMPANY_NAME_LENGTH";
    /**
     * 保镖2内部编号,与t_crew.crew_internal_id冗余
     */
    public static final String TASK_BEAN_SECURITY2_INTERNAL_ID_LENGTH = "TASK_BEAN_SECURITY2_INTERNAL_ID_LENGTH";
    /**
     * 发件人网点服务时间窗口结束时间,时间格式 hh:mm:ss,与t_task_contract.contract_sender_time_window_end,冗余
     */
    public static final String TASK_BEAN_SENDER_TIME_WINDOW_END_NOT_BLANK = "TASK_BEAN_SENDER_TIME_WINDOW_END_NOT_BLANK";
    /**
     * 保镖4ID,与t_crew.crew_id冗余
     */
    public static final String TASK_BEAN_SECURITY4_ID_LENGTH = "TASK_BEAN_SECURITY4_ID_LENGTH";
    /**
     * 保镖2姓氏,与t_crew.crew_last_name字段关联
     */
    public static final String TASK_BEAN_SECURITY2_LAST_NAME_LENGTH = "TASK_BEAN_SECURITY2_LAST_NAME_LENGTH";
    /**
     * 客户到客户类型，任务，到达目的（网点地址）时间，系统自动根据经纬度范围，推算出来的时间
     */
    public static final String TASK_BEAN_PARTIAL_ARRIVAL_TIME_AUTO_CALC_DATE_TIME_FORMAT = "TASK_BEAN_PARTIAL_ARRIVAL_TIME_AUTO_CALC_DATE_TIME_FORMAT";
    /**
     * 收件人网点地址,与t_client_branch.branch_address,关联
     */
    public static final String TASK_BEAN_RECEIVER_BRANCH_ADDRESS_LENGTH = "TASK_BEAN_RECEIVER_BRANCH_ADDRESS_LENGTH";
    /**
     * 任务是否为交接时，所生成的新任务【Y[任务是交换出来的新任务]、N[不是]】
     */
    public static final String TASK_BEAN_WHETHER_INTER_CHANGED_NOT_BLANK = "TASK_BEAN_WHETHER_INTER_CHANGED_NOT_BLANK";
    /**
     * 取消任务,回执单[访问票据单]【目前需求,只有责任方为Client时,才有回执单】
     */
    public static final String TASK_BEAN_CANCEL_SINGLE_RECEIPT_LENGTH = "TASK_BEAN_CANCEL_SINGLE_RECEIPT_LENGTH";
    /**
     * 保镖1名字,与t_crew.crew_first_name字段关联
     */
    public static final String TASK_BEAN_SECURITY1_FIRST_NAME_LENGTH = "TASK_BEAN_SECURITY1_FIRST_NAME_LENGTH";
    /**
     * 发件人名称,与t_task_contract.contract_sender_client_name,冗余
     */
    public static final String TASK_BEAN_SENDER_CLIENT_NAME_LENGTH = "TASK_BEAN_SENDER_CLIENT_NAME_LENGTH";
    /**
     * 发件人网点名称,与t_client_branch.branch_name 字段冗余
     */
    public static final String TASK_BEAN_SENDER_BRANCH_NAME_LENGTH = "TASK_BEAN_SENDER_BRANCH_NAME_LENGTH";
    /**
     * 客户到客户类型任务，收钱时的任务处理开始时间,目前系统根据,司机手机APP,在进入该客户分支店时,任务状态为:in_process任务,到达任务地址,开始处理
     */
    public static final String TASK_BEAN_PARTIAL_PROCESS_START_TIMESTAMP_DATE_TIME_FORMAT = "TASK_BEAN_PARTIAL_PROCESS_START_TIMESTAMP_DATE_TIME_FORMAT";
    /**
     * 任务原始,该任务是否生效; 该字段目前主要是sioXml导入的任务开关【ENABLE[启用]、DISABLE[禁用]】
     */
    public static final String TASK_BEAN_SOURCE_AVAILABILITY_LENGTH = "TASK_BEAN_SOURCE_AVAILABILITY_LENGTH";
    /**
     * 任务来源哪一方生成的任务【SIO公司导入进来分两种：[SIO_0_KIOSKOLIN、SIO_1_COMODIN]，COMODIN[comodin手工创建]，EXCEL[excel批量导入]】
     */
    public static final String TASK_BEAN_GENERATE_SOURCE_PARTY_LENGTH = "TASK_BEAN_GENERATE_SOURCE_PARTY_LENGTH";
    /**
     * 任务是否为交接时，所生成的新任务【Y[任务是交换出来的新任务]、N[不是]】
     */
    public static final String TASK_BEAN_WHETHER_INTER_CHANGED_LENGTH = "TASK_BEAN_WHETHER_INTER_CHANGED_LENGTH";
    /**
     * interchange,["",ORIG,DEST]【date:2017-07-28 by:supeng】
     */
    public static final String TASK_BEAN_INTER_CHANGE_TYPE_LENGTH = "TASK_BEAN_INTER_CHANGE_TYPE_LENGTH";
    /**
     * 收件人网点地址坐标经度,浮点型,与t_client_branch.branch_longitude,关联
     */
    public static final String TASK_BEAN_RECEIVER_BRANCH_LONGITUDE_LENGTH = "TASK_BEAN_RECEIVER_BRANCH_LONGITUDE_LENGTH";
    /**
     * 司机username,与t_crew.crew_username冗余
     */
    public static final String TASK_BEAN_DRIVER_USERNAME_LENGTH = "TASK_BEAN_DRIVER_USERNAME_LENGTH";
    /**
     * 任务原始,ID,【date:2016-12-12 by:supeng】
     */
    public static final String TASK_BEAN_SOURCE_TASK_ID_LENGTH = "TASK_BEAN_SOURCE_TASK_ID_LENGTH";
    /**
     * 发件人网点服务时间窗口开始时间,时间格式 hh:mm:ss,与t_task_contract.contract_sender_time_window_start,冗余
     */
    public static final String TASK_BEAN_SENDER_TIME_WINDOW_START_LENGTH = "TASK_BEAN_SENDER_TIME_WINDOW_START_LENGTH";
    /**
     * 任务处理开始时间,目前系统根据,司机手机APP,在进入该客户分支店时,任务状态为:in_process任务,到达任务地址,开始处理
     */
    public static final String TASK_BEAN_PROCESS_START_TIMESTAMP_DATE_TIME_FORMAT = "TASK_BEAN_PROCESS_START_TIMESTAMP_DATE_TIME_FORMAT";
    /**
     * 与t_vehicle.vehicle_tomtom_id 冗余,车辆实时数据外部标识
     */
    public static final String TASK_BEAN_VEHICLE_TOMTOM_ID_LENGTH = "TASK_BEAN_VEHICLE_TOMTOM_ID_LENGTH";
    /**
     * 与t_vehicle.vehicle_model冗余汽车型号
     */
    public static final String TASK_BEAN_VEHICLE_MODEL_LENGTH = "TASK_BEAN_VEHICLE_MODEL_LENGTH";
    /**
     * 司机姓氏,与t_crew.crew_last_name字段关联
     */
    public static final String TASK_BEAN_DRIVER_LAST_NAME_LENGTH = "TASK_BEAN_DRIVER_LAST_NAME_LENGTH";
    /**
     * 发件人网点地址,与t_client_branch.branch_address,关联
     */
    public static final String TASK_BEAN_SENDER_BRANCH_ADDRESS_LENGTH = "TASK_BEAN_SENDER_BRANCH_ADDRESS_LENGTH";
    /**
     * 收件人客户ID,与t_client.client_id 字段关联
     */
    public static final String TASK_BEAN_RECEIVER_CLIENT_ID_LENGTH = "TASK_BEAN_RECEIVER_CLIENT_ID_LENGTH";
    /**
     * 保镖1内部编号,与t_crew.crew_internal_id冗余
     */
    public static final String TASK_BEAN_SECURITY1_INTERNAL_ID_LENGTH = "TASK_BEAN_SECURITY1_INTERNAL_ID_LENGTH";
    /**
     * 保镖1电话,与t_crew.crew_phone字段关联
     */
    public static final String TASK_BEAN_SECURITY1_PHONE_LENGTH = "TASK_BEAN_SECURITY1_PHONE_LENGTH";
    /**
     * 服务类型,与t_task_contract.contract_service_type,关联
     */
    public static final String TASK_BEAN_SERVICE_TYPE_NOT_BLANK = "TASK_BEAN_SERVICE_TYPE_NOT_BLANK";
    /**
     * 任务执行日期,与t_task_contract.contract_cron_expression 服务日期表达式所定义生成
     */
    public static final String TASK_BEAN_SERVICE_DATE_LENGTH = "TASK_BEAN_SERVICE_DATE_LENGTH";
    /**
     * 路线id,与t_task_contract.contract_route_id,关联
     */
    public static final String TASK_BEAN_ROUTE_ID_LENGTH = "TASK_BEAN_ROUTE_ID_LENGTH";
    /**
     * 任务ID,与pk_id区别在于,业务场景:在 in_changed的时候,会生成两条记录task_pk_id 而task_id为同一条,且只有一条task_availability,为ENABLE
     */
    public static final String TASK_BEAN_TASK_ID_LENGTH = "TASK_BEAN_TASK_ID_LENGTH";
    /**
     * 保镖3名字,与t_crew.crew_first_name字段关联
     */
    public static final String TASK_BEAN_SECURITY3_FIRST_NAME_LENGTH = "TASK_BEAN_SECURITY3_FIRST_NAME_LENGTH";
    /**
     * 任务，到达目的（网点地址）时间，人工输入的时间
     */
    public static final String TASK_BEAN_ARRIVAL_TIME_MANUAL_INPUT_DATE_TIME_FORMAT = "TASK_BEAN_ARRIVAL_TIME_MANUAL_INPUT_DATE_TIME_FORMAT";
    /**
     * 司机shift,与shift_week_start_date,对应【应在生成计划任务,根据人员安排时,设置值也要注意在变更路线时,设置值】
     */
    public static final String TASK_BEAN_DRIVER_SHIFT_LENGTH = "TASK_BEAN_DRIVER_SHIFT_LENGTH";
    /**
     * 完成任务（或者部分完成任务）时地址坐标纬度,浮点型
     */
    public static final String TASK_BEAN_COMPLETE_LATITUDE_LENGTH = "TASK_BEAN_COMPLETE_LATITUDE_LENGTH";
    /**
     * 保镖3班次,与shift_week_start_date,对应;【应在生成计划任务,根据人员安排时,设置值也要注意在变更路线时,设置值】
     */
    public static final String TASK_BEAN_SECURITY3_SHIFT_LENGTH = "TASK_BEAN_SECURITY3_SHIFT_LENGTH";
    /**
     * 任务来源的,网点,ID【date:2016-12-12 by:supeng】
     */
    public static final String TASK_BEAN_SOURCE_BRANCH_ID_LENGTH = "TASK_BEAN_SOURCE_BRANCH_ID_LENGTH";
    /**
     * 司机ID,与t_crew.crew_id冗余
     */
    public static final String TASK_BEAN_DRIVER_ID_LENGTH = "TASK_BEAN_DRIVER_ID_LENGTH";
    /**
     * 与t_vehicle.vehicle_license冗余车牌号码
     */
    public static final String TASK_BEAN_VEHICLE_LICENSE_LENGTH = "TASK_BEAN_VEHICLE_LICENSE_LENGTH";
    /**
     * 任务状态,任务当下的状态 pending schedule assign_route assign_driver assign_guard assign_vehicle in_route in_processcomprobante completed inter_changed cancelled
     */
    public static final String TASK_BEAN_STATUS_NOT_BLANK = "TASK_BEAN_STATUS_NOT_BLANK";
    /**
     * 收件人网点内部ID,与t_client_branch.branch_internal_id 字段冗余
     */
    public static final String TASK_BEAN_RECEIVER_BRANCH_INTERNAL_ID_LENGTH = "TASK_BEAN_RECEIVER_BRANCH_INTERNAL_ID_LENGTH";
    /**
     * 收银员姓氏,与t_crew.crew_last_name字段关联
     */
    public static final String TASK_BEAN_CASHIER_LAST_NAME_LENGTH = "TASK_BEAN_CASHIER_LAST_NAME_LENGTH";
    /**
     * 保镖3姓氏,与t_crew.crew_last_name字段关联
     */
    public static final String TASK_BEAN_SECURITY3_LAST_NAME_LENGTH = "TASK_BEAN_SECURITY3_LAST_NAME_LENGTH";
    /**
     * 发件人网点地址坐标经度,浮点型,与t_client_branch.branch_longitude,关联
     */
    public static final String TASK_BEAN_SENDER_BRANCH_LONGITUDE_LENGTH = "TASK_BEAN_SENDER_BRANCH_LONGITUDE_LENGTH";
    /**
     * 班次类型【M[早班Morning]6am-1pm[06:00-13:00], A[中班Afternoon]2pm-6pm[14:00-18:00], N[晚班Night]6pm-12am[18:00-23:59], V[休假Vacations]】,以司机班次为任务班次,当前业务逻辑需求2016-08-22
     */
    public static final String TASK_BEAN_SHIFT_LENGTH = "TASK_BEAN_SHIFT_LENGTH";
    /**
     * 路线顺序,与t_task_contract.contract_route_order,关联
     */
    public static final String TASK_BEAN_ROUTE_ORDER_NOT_NULL = "TASK_BEAN_ROUTE_ORDER_NOT_NULL";
    /**
     * 保镖4username,与t_crew.crew_username冗余
     */
    public static final String TASK_BEAN_SECURITY4_USERNAME_LENGTH = "TASK_BEAN_SECURITY4_USERNAME_LENGTH";
    /**
     * 收件人名称,与t_task_contract.contract_receiver_client_name,冗余
     */
    public static final String TASK_BEAN_RECEIVER_CLIENT_NAME_LENGTH = "TASK_BEAN_RECEIVER_CLIENT_NAME_LENGTH";
    /**
     * 任务复合ID,组成方式【|4|26|20161118|1101|1|】【|SIO公司内部ID|SIO公司网点内部ID|路线日期[yyyyMMdd]|路线ID|任务ID|】【date:2016-12-12 by:supeng】
     */
    public static final String TASK_BEAN_SOURCE_ORIGINAL_COMPLEX_ID_LENGTH = "TASK_BEAN_SOURCE_ORIGINAL_COMPLEX_ID_LENGTH";
    /**
     * 创建时间
     */
    public static final String TASK_BEAN_CREATE_TIMESTAMP_DATE_TIME_FORMAT = "TASK_BEAN_CREATE_TIMESTAMP_DATE_TIME_FORMAT";
    /**
     * 逻辑删除标志【N[正常]，Y[删除]】
     */
    public static final String TASK_BEAN_DELETE_FLAG_NOT_BLANK = "TASK_BEAN_DELETE_FLAG_NOT_BLANK";
    /**
     * 与t_vehicle.vehicle_service_type冗余
     */
    public static final String TASK_BEAN_VEHICLE_SERVICE_TYPE_LENGTH = "TASK_BEAN_VEHICLE_SERVICE_TYPE_LENGTH";
    /**
     * 武装等级【NONE[无], LIGHT[一般], MEDIUM[中等], HEAVY[重型]】,与t_task_contract.contract_armored_level,关联
     */
    public static final String TASK_BEAN_ARMORED_LEVEL_LENGTH = "TASK_BEAN_ARMORED_LEVEL_LENGTH";
    /**
     * 服务类型,与t_task_contract.contract_service_type,关联
     */
    public static final String TASK_BEAN_SERVICE_TYPE_LENGTH = "TASK_BEAN_SERVICE_TYPE_LENGTH";
    /**
     * 发件人网点名称,与t_client_branch.branch_name 字段冗余
     */
    public static final String TASK_BEAN_SENDER_BRANCH_NAME_NOT_BLANK = "TASK_BEAN_SENDER_BRANCH_NAME_NOT_BLANK";
    /**
     * interchange,原先的任务复合ID，组成方式【|4|26|20161118|1101|1|】【|SIO公司内部ID|SIO公司网点内部ID|路线日期[yyyyMMdd]|路线ID|任务ID|】【date:2017-07-28 by:supeng】
     */
    public static final String TASK_BEAN_INTER_CHANGE_ORIGINAL_COMPLEX_ID_LENGTH = "TASK_BEAN_INTER_CHANGE_ORIGINAL_COMPLEX_ID_LENGTH";
    /**
     * 生成任务的方式【ON_CONTRACT[按合同], ON_DEMAND[按需求]】
     */
    public static final String TASK_BEAN_GENERATED_TYPE_LENGTH = "TASK_BEAN_GENERATED_TYPE_LENGTH";
    /**
     * 任务是否为交接，已收到钱在车上【Y[任务是已完成]、N[任务未完成]】
     */
    public static final String TASK_BEAN_WHETHER_COMPLETED_LENGTH = "TASK_BEAN_WHETHER_COMPLETED_LENGTH";
    /**
     * 取消任务,钱回退处
     */
    public static final String TASK_BEAN_CANCEL_MONEY_BACK_PARTY_LENGTH = "TASK_BEAN_CANCEL_MONEY_BACK_PARTY_LENGTH";
    /**
     * 司机内部编号,与t_crew.crew_internal_id冗余
     */
    public static final String TASK_BEAN_DRIVER_INTERNAL_ID_LENGTH = "TASK_BEAN_DRIVER_INTERNAL_ID_LENGTH";
    /**
     * 谁新增了该员工,与crew_username字段关联 若为系统生成创建者为:SYSTEM
     */
    public static final String TASK_BEAN_CREATE_BY_NOT_BLANK = "TASK_BEAN_CREATE_BY_NOT_BLANK";
    /**
     * 任务来源哪一方生成的任务【SIO公司导入进来分两种：[SIO_0_KIOSKOLIN、SIO_1_COMODIN]，COMODIN[comodin手工创建]，EXCEL[excel批量导入]】
     */
    public static final String TASK_BEAN_GENERATE_SOURCE_PARTY_NOT_BLANK = "TASK_BEAN_GENERATE_SOURCE_PARTY_NOT_BLANK";
    /**
     * 保镖1username,与t_crew.crew_username冗余
     */
    public static final String TASK_BEAN_SECURITY1_USERNAME_LENGTH = "TASK_BEAN_SECURITY1_USERNAME_LENGTH";
    /**
     * 收银员电话,与t_crew.crew_phone字段关联
     */
    public static final String TASK_BEAN_CASHIER_PHONE_LENGTH = "TASK_BEAN_CASHIER_PHONE_LENGTH";
    /**
     * 收银员passCode密码(员工登陆密码),MD5加密之后取前8位+登陆密码加盐,与t_user.user_pass_code【该分支机构下,所有拥有nip密码的,JSON对象 {"passCode":"4c2bf06d","passSalt":"_random_"}】
     */
    public static final String TASK_BEAN_CASHIER_PASS_CODE_LENGTH = "TASK_BEAN_CASHIER_PASS_CODE_LENGTH";
    /**
     * 保镖2ID,与t_crew.crew_id冗余
     */
    public static final String TASK_BEAN_SECURITY2_ID_LENGTH = "TASK_BEAN_SECURITY2_ID_LENGTH";
    public static final String TASK_BEAN_UPDATE_TIMESTAMP_DATE_TIME_FORMAT = "TASK_BEAN_UPDATE_TIMESTAMP_DATE_TIME_FORMAT";
    /**
     * 任务执行日期,与t_task_contract.contract_cron_expression 服务日期表达式所定义生成
     */
    public static final String TASK_BEAN_SERVICE_DATE_NOT_BLANK = "TASK_BEAN_SERVICE_DATE_NOT_BLANK";
    /**
     * 谁新增了该员工,与crew_username字段关联 若为系统生成创建者为:SYSTEM
     */
    public static final String TASK_BEAN_CREATE_BY_LENGTH = "TASK_BEAN_CREATE_BY_LENGTH";
    /**
     * 保镖1姓氏,与t_crew.crew_last_name字段关联
     */
    public static final String TASK_BEAN_SECURITY1_LAST_NAME_LENGTH = "TASK_BEAN_SECURITY1_LAST_NAME_LENGTH";
    /**
     * 任务来源的,公司,ID【date:2016-12-12 by:supeng】
     */
    public static final String TASK_BEAN_SOURCE_COMPANY_ID_LENGTH = "TASK_BEAN_SOURCE_COMPANY_ID_LENGTH";
    /**
     * 收件人网点服务时间窗口结束时间,时间格式 hh:mm:ss,与t_task_contract.contract_receiver_time_window_end,冗余
     */
    public static final String TASK_BEAN_RECEIVER_TIME_WINDOW_END_LENGTH = "TASK_BEAN_RECEIVER_TIME_WINDOW_END_LENGTH";
    /**
     * 发件人客户内部ID,与t_client.client_internal_id 字段冗余
     */
    public static final String TASK_BEAN_SENDER_CLIENT_INTERNAL_ID_LENGTH = "TASK_BEAN_SENDER_CLIENT_INTERNAL_ID_LENGTH";
    /**
     * 保镖3ID,与t_crew.crew_id冗余
     */
    public static final String TASK_BEAN_SECURITY3_ID_LENGTH = "TASK_BEAN_SECURITY3_ID_LENGTH";

}