package com.comodin.fleet.constants.i18n;

@SuppressWarnings({"unused", "SpringAutowiredFieldsWarningInspection", "StatementWithEmptyBody"})
public class ClientBranchBeanI18nConstant  {

    /**
     * 逻辑删除标志【N[正常]，Y[删除]】
     */
    public static final String CLIENT_BRANCH_BEAN_DELETE_FLAG_LENGTH = "CLIENT_BRANCH_BEAN_DELETE_FLAG_LENGTH";
    /**
     * 网点地址
     */
    public static final String CLIENT_BRANCH_BEAN_ADDRESS_LENGTH = "CLIENT_BRANCH_BEAN_ADDRESS_LENGTH";
    /**
     * 网点类型【CIT,CLIENT,BANK...】
     */
    public static final String CLIENT_BRANCH_BEAN_TYPE_NOT_BLANK = "CLIENT_BRANCH_BEAN_TYPE_NOT_BLANK";
    /**
     * 客户的名称,与t_client.client_name冗余
     */
    public static final String CLIENT_BRANCH_BEAN_CLIENT_NAME_NOT_BLANK = "CLIENT_BRANCH_BEAN_CLIENT_NAME_NOT_BLANK";
    /**
     * 开关,收钱，取消任务，是否需要访问票据,Y需要,N不需要
     */
    public static final String CLIENT_BRANCH_BEAN_SWITCH_CANCEL_TASK_VISIT_BILL_BY_PICKUP_NOT_BLANK = "CLIENT_BRANCH_BEAN_SWITCH_CANCEL_TASK_VISIT_BILL_BY_PICKUP_NOT_BLANK";
    /**
     * 是否拍照签名才能完成任务,Y需要,N不需要
     */
    public static final String CLIENT_BRANCH_BEAN_NEED_SIGNATURE_FLAG_LENGTH = "CLIENT_BRANCH_BEAN_NEED_SIGNATURE_FLAG_LENGTH";
    /**
     * 网点坐标经度,浮点型
     */
    public static final String CLIENT_BRANCH_BEAN_LONGITUDE_NOT_BLANK = "CLIENT_BRANCH_BEAN_LONGITUDE_NOT_BLANK";
    /**
     * cancel时是否需要到任务点拍照,Y需要,N不需要
     */
    public static final String CLIENT_BRANCH_BEAN_NEED_PHOTOGRAPH_FLAG_NOT_BLANK = "CLIENT_BRANCH_BEAN_NEED_PHOTOGRAPH_FLAG_NOT_BLANK";
    /**
     * 创建人,与t_crew.crew_username字段关联
     */
    public static final String CLIENT_BRANCH_BEAN_CREATE_BY_NOT_BLANK = "CLIENT_BRANCH_BEAN_CREATE_BY_NOT_BLANK";
    /**
     * 网点保险箱钥匙编号
     */
    public static final String CLIENT_BRANCH_BEAN_SAFE_KEY_NUMBER_LENGTH = "CLIENT_BRANCH_BEAN_SAFE_KEY_NUMBER_LENGTH";
    /**
     * 是否需要分配路线,Y有,N无【备注:该分支,名下的司机,在登陆APP客户端时,是否弹出分配路线,开关[需求改变,是因为TanMeMe的任务是外部导入,已经分配好线路,车辆,司机,保镖,营业员 dateBy 2016-08-29]】
     */
    public static final String CLIENT_BRANCH_BEAN_ASSIGN_ROUTE_FLAG_LENGTH = "CLIENT_BRANCH_BEAN_ASSIGN_ROUTE_FLAG_LENGTH";
    /**
     * 是否达到目的才能开始任务,Y需要,N不需要
     */
    public static final String CLIENT_BRANCH_BEAN_NEED_ARRIVE_FLAG_NOT_BLANK = "CLIENT_BRANCH_BEAN_NEED_ARRIVE_FLAG_NOT_BLANK";
    /**
     * 网点时域【以GMT标准 America/Mexico_City为墨西哥时区】
     */
    public static final String CLIENT_BRANCH_BEAN_TIME_ZONE_LENGTH = "CLIENT_BRANCH_BEAN_TIME_ZONE_LENGTH";
    /**
     * 是否需要按顺序完成任务,Y需要,N不需要
     */
    public static final String CLIENT_BRANCH_BEAN_NEED_ORDER_FLAG_LENGTH = "CLIENT_BRANCH_BEAN_NEED_ORDER_FLAG_LENGTH";
    /**
     * 客户类型为[CLIENT]所属哪一个CIT的客户，与t_client.client_id 字段冗余，且类型为[CIT]；0为CIT
     */
    public static final String CLIENT_BRANCH_BEAN_CIT_ID_NOT_NULL = "CLIENT_BRANCH_BEAN_CIT_ID_NOT_NULL";
    /**
     * 是否需要打印,Y需要,N不需要
     */
    public static final String CLIENT_BRANCH_BEAN_NEED_PRINT_FLAG_LENGTH = "CLIENT_BRANCH_BEAN_NEED_PRINT_FLAG_LENGTH";
    /**
     * 网点名称
     */
    public static final String CLIENT_BRANCH_BEAN_NAME_NOT_BLANK = "CLIENT_BRANCH_BEAN_NAME_NOT_BLANK";
    /**
     * 是否需要分配路线,Y有,N无【备注:该分支,名下的司机,在登陆APP客户端时,是否弹出分配路线,开关[需求改变,是因为TanMeMe的任务是外部导入,已经分配好线路,车辆,司机,保镖,营业员 dateBy 2016-08-29]】
     */
    public static final String CLIENT_BRANCH_BEAN_ASSIGN_ROUTE_FLAG_NOT_BLANK = "CLIENT_BRANCH_BEAN_ASSIGN_ROUTE_FLAG_NOT_BLANK";
    /**
     * 创建人,与t_crew.crew_username字段关联
     */
    public static final String CLIENT_BRANCH_BEAN_CREATE_BY_LENGTH = "CLIENT_BRANCH_BEAN_CREATE_BY_LENGTH";
    /**
     * 数据库主键ID
     */
    public static final String CLIENT_BRANCH_BEAN_ID_LENGTH = "CLIENT_BRANCH_BEAN_ID_LENGTH";
    /**
     * 网点所属的客户ID,与t_client.client_id 字段关联
     */
    public static final String CLIENT_BRANCH_BEAN_CLIENT_ID_NOT_NULL = "CLIENT_BRANCH_BEAN_CLIENT_ID_NOT_NULL";
    /**
     * 开关,送钱，取消任务，是否需要访问票据,Y需要,N不需要
     */
    public static final String CLIENT_BRANCH_BEAN_SWITCH_CANCEL_TASK_VISIT_BILL_BY_DIRECTLY_TO_PICKUP_NOT_BLANK = "CLIENT_BRANCH_BEAN_SWITCH_CANCEL_TASK_VISIT_BILL_BY_DIRECTLY_TO_PICKUP_NOT_BLANK";
    /**
     * 客户类型为[CLIENT]所属哪一个CIT的客户，与t_client.client_id 字段冗余，且类型为[CIT]；0为CIT
     */
    public static final String CLIENT_BRANCH_BEAN_CIT_ID_LENGTH = "CLIENT_BRANCH_BEAN_CIT_ID_LENGTH";
    /**
     * 是否需要按顺序完成任务,Y需要,N不需要
     */
    public static final String CLIENT_BRANCH_BEAN_NEED_ORDER_FLAG_NOT_BLANK = "CLIENT_BRANCH_BEAN_NEED_ORDER_FLAG_NOT_BLANK";
    /**
     * 是否达到目的才能开始任务,Y需要,N不需要
     */
    public static final String CLIENT_BRANCH_BEAN_NEED_ARRIVE_FLAG_LENGTH = "CLIENT_BRANCH_BEAN_NEED_ARRIVE_FLAG_LENGTH";
    /**
     * 是否拍照签名才能完成任务,Y需要,N不需要
     */
    public static final String CLIENT_BRANCH_BEAN_NEED_SIGNATURE_FLAG_NOT_BLANK = "CLIENT_BRANCH_BEAN_NEED_SIGNATURE_FLAG_NOT_BLANK";
    /**
     * 是否需要分配收银员,Y有,N无【备注:该分支,名下的司机,在登陆APP客户端时,是否弹出分配收银员,开关[需求改变,是因为TanMeMe的任务是外部导入,已经分配好线路,车辆,司机,保镖,营业员 dateBy 2016-08-29]】
     */
    public static final String CLIENT_BRANCH_BEAN_ASSIGN_AUXILIARY_FLAG_LENGTH = "CLIENT_BRANCH_BEAN_ASSIGN_AUXILIARY_FLAG_LENGTH";
    /**
     * 网点用户在APP操作任务，任务数据同步到服务器的时间间隔，单位s（秒），默认900秒
     */
    public static final String CLIENT_BRANCH_BEAN_SYNCHRONOUS_INTERVAL_NOT_NULL = "CLIENT_BRANCH_BEAN_SYNCHRONOUS_INTERVAL_NOT_NULL";
    /**
     * 网点用户在APP操作任务，任务数据同步到服务器的时间间隔，单位s（秒），默认900秒
     */
    public static final String CLIENT_BRANCH_BEAN_SYNCHRONOUS_INTERVAL_LENGTH = "CLIENT_BRANCH_BEAN_SYNCHRONOUS_INTERVAL_LENGTH";
    /**
     * cancel时是否需要到任务点拍照,Y需要,N不需要
     */
    public static final String CLIENT_BRANCH_BEAN_NEED_PHOTOGRAPH_FLAG_LENGTH = "CLIENT_BRANCH_BEAN_NEED_PHOTOGRAPH_FLAG_LENGTH";
    /**
     * 网点坐标经度,浮点型
     */
    public static final String CLIENT_BRANCH_BEAN_LONGITUDE_LENGTH = "CLIENT_BRANCH_BEAN_LONGITUDE_LENGTH";
    /**
     * 开关,送钱，是否需要添加票据,Y需要,N不需要
     */
    public static final String CLIENT_BRANCH_BEAN_SWITCH_SEND_TASK_NEED_ADD_COMPROBANTES_NOT_BLANK = "CLIENT_BRANCH_BEAN_SWITCH_SEND_TASK_NEED_ADD_COMPROBANTES_NOT_BLANK";
    /**
     * 是否需要validate,Y需要,N不需要
     */
    public static final String CLIENT_BRANCH_BEAN_NEED_VALIDATE_FLAG_LENGTH = "CLIENT_BRANCH_BEAN_NEED_VALIDATE_FLAG_LENGTH";
    /**
     * 数据库主键ID
     */
    public static final String CLIENT_BRANCH_BEAN_ID_NOT_NULL = "CLIENT_BRANCH_BEAN_ID_NOT_NULL";
    /**
     * 是否需要分配车辆,Y有,N无【备注:该分支,名下的司机,在登陆APP客户端时,是否弹出分配车辆,开关[需求改变,是因为TanMeMe的任务是外部导入,已经分配好线路,车辆,司机,保镖,营业员 dateBy 2016-08-29]】
     */
    public static final String CLIENT_BRANCH_BEAN_ASSIGN_VEHICLE_FLAG_NOT_BLANK = "CLIENT_BRANCH_BEAN_ASSIGN_VEHICLE_FLAG_NOT_BLANK";
    /**
     * 创建时间
     */
    public static final String CLIENT_BRANCH_BEAN_CREATE_TIMESTAMP_DATE_TIME_FORMAT = "CLIENT_BRANCH_BEAN_CREATE_TIMESTAMP_DATE_TIME_FORMAT";
    /**
     * 网点所属的客户ID,与t_client.client_id 字段关联
     */
    public static final String CLIENT_BRANCH_BEAN_CLIENT_ID_LENGTH = "CLIENT_BRANCH_BEAN_CLIENT_ID_LENGTH";
    /**
     * 网点所属的客户内部ID,与t_client.client_internal_id 字段冗余
     */
    public static final String CLIENT_BRANCH_BEAN_CLIENT_INTERNAL_ID_NOT_BLANK = "CLIENT_BRANCH_BEAN_CLIENT_INTERNAL_ID_NOT_BLANK";
    /**
     * 网点所属的客户内部ID,与t_client.client_internal_id 字段冗余
     */
    public static final String CLIENT_BRANCH_BEAN_CLIENT_INTERNAL_ID_LENGTH = "CLIENT_BRANCH_BEAN_CLIENT_INTERNAL_ID_LENGTH";
    /**
     * 客户的名称,与t_client.client_name冗余
     */
    public static final String CLIENT_BRANCH_BEAN_CLIENT_NAME_LENGTH = "CLIENT_BRANCH_BEAN_CLIENT_NAME_LENGTH";
    /**
     * 网点内部ID
     */
    public static final String CLIENT_BRANCH_BEAN_INTERNAL_ID_LENGTH = "CLIENT_BRANCH_BEAN_INTERNAL_ID_LENGTH";
    /**
     * 开关,用户登录凭证，ip变化时用户登录凭证失不失效,Y失效,N不失效
     */
    public static final String CLIENT_BRANCH_BEAN_SWITCH_IP_CHANGE_TOKEN_EFFECTIVE_NOT_BLANK = "CLIENT_BRANCH_BEAN_SWITCH_IP_CHANGE_TOKEN_EFFECTIVE_NOT_BLANK";
    /**
     * 网点名称
     */
    public static final String CLIENT_BRANCH_BEAN_NAME_LENGTH = "CLIENT_BRANCH_BEAN_NAME_LENGTH";
    /**
     * 网点时域【以GMT标准 America/Mexico_City为墨西哥时区】
     */
    public static final String CLIENT_BRANCH_BEAN_TIME_ZONE_NOT_BLANK = "CLIENT_BRANCH_BEAN_TIME_ZONE_NOT_BLANK";
    /**
     * 网点坐标纬度,浮点型
     */
    public static final String CLIENT_BRANCH_BEAN_LATITUDE_NOT_BLANK = "CLIENT_BRANCH_BEAN_LATITUDE_NOT_BLANK";
    /**
     * 是否需要打印,Y需要,N不需要
     */
    public static final String CLIENT_BRANCH_BEAN_NEED_PRINT_FLAG_NOT_BLANK = "CLIENT_BRANCH_BEAN_NEED_PRINT_FLAG_NOT_BLANK";
    /**
     * 网点联系电话
     */
    public static final String CLIENT_BRANCH_BEAN_PHONE_LENGTH = "CLIENT_BRANCH_BEAN_PHONE_LENGTH";
    /**
     * 创建时间
     */
    public static final String CLIENT_BRANCH_BEAN_CREATE_TIMESTAMP_NOT_NULL = "CLIENT_BRANCH_BEAN_CREATE_TIMESTAMP_NOT_NULL";
    /**
     * 开关,收钱，取消任务，是否需要访问票据,Y需要,N不需要
     */
    public static final String CLIENT_BRANCH_BEAN_SWITCH_CANCEL_TASK_VISIT_BILL_BY_PICKUP_LENGTH = "CLIENT_BRANCH_BEAN_SWITCH_CANCEL_TASK_VISIT_BILL_BY_PICKUP_LENGTH";
    /**
     * 是否需要validate,Y需要,N不需要
     */
    public static final String CLIENT_BRANCH_BEAN_NEED_VALIDATE_FLAG_NOT_BLANK = "CLIENT_BRANCH_BEAN_NEED_VALIDATE_FLAG_NOT_BLANK";
    /**
     * 开关,送钱，取消任务，是否需要访问票据,Y需要,N不需要
     */
    public static final String CLIENT_BRANCH_BEAN_SWITCH_CANCEL_TASK_VISIT_BILL_BY_DIRECTLY_TO_DELIVERY_NOT_BLANK = "CLIENT_BRANCH_BEAN_SWITCH_CANCEL_TASK_VISIT_BILL_BY_DIRECTLY_TO_DELIVERY_NOT_BLANK";
    /**
     * 开关,送钱，取消任务，是否需要访问票据,Y需要,N不需要
     */
    public static final String CLIENT_BRANCH_BEAN_SWITCH_CANCEL_TASK_VISIT_BILL_BY_DIRECTLY_TO_PICKUP_LENGTH = "CLIENT_BRANCH_BEAN_SWITCH_CANCEL_TASK_VISIT_BILL_BY_DIRECTLY_TO_PICKUP_LENGTH";
    /**
     * 逻辑删除标志【N[正常]，Y[删除]】
     */
    public static final String CLIENT_BRANCH_BEAN_DELETE_FLAG_NOT_BLANK = "CLIENT_BRANCH_BEAN_DELETE_FLAG_NOT_BLANK";
    /**
     * 开关,送钱，取消任务，是否需要访问票据,Y需要,N不需要
     */
    public static final String CLIENT_BRANCH_BEAN_SWITCH_CANCEL_TASK_VISIT_BILL_BY_DELIVERY_NOT_BLANK = "CLIENT_BRANCH_BEAN_SWITCH_CANCEL_TASK_VISIT_BILL_BY_DELIVERY_NOT_BLANK";
    /**
     * 是否需要分配保镖,Y有,N无【备注:该分支,名下的司机,在登陆APP客户端时,是否弹出分配保镖,开关[需求改变,是因为TanMeMe的任务是外部导入,已经分配好线路,车辆,司机,保镖,营业员 dateBy 2016-08-29]】
     */
    public static final String CLIENT_BRANCH_BEAN_ASSIGN_GUARD_FLAG_NOT_BLANK = "CLIENT_BRANCH_BEAN_ASSIGN_GUARD_FLAG_NOT_BLANK";
    /**
     * 是否需要输入PIN码,Y需要,N不需要
     */
    public static final String CLIENT_BRANCH_BEAN_NEED_PIN_FLAG_LENGTH = "CLIENT_BRANCH_BEAN_NEED_PIN_FLAG_LENGTH";
    /**
     * 网点类型【CIT,CLIENT,BANK...】
     */
    public static final String CLIENT_BRANCH_BEAN_TYPE_LENGTH = "CLIENT_BRANCH_BEAN_TYPE_LENGTH";
    /**
     * 开关,用户登录凭证，ip变化时用户登录凭证失不失效,Y失效,N不失效
     */
    public static final String CLIENT_BRANCH_BEAN_SWITCH_IP_CHANGE_TOKEN_EFFECTIVE_LENGTH = "CLIENT_BRANCH_BEAN_SWITCH_IP_CHANGE_TOKEN_EFFECTIVE_LENGTH";
    /**
     * 开关,送钱，取消任务，是否需要访问票据,Y需要,N不需要
     */
    public static final String CLIENT_BRANCH_BEAN_SWITCH_CANCEL_TASK_VISIT_BILL_BY_DELIVERY_LENGTH = "CLIENT_BRANCH_BEAN_SWITCH_CANCEL_TASK_VISIT_BILL_BY_DELIVERY_LENGTH";
    /**
     * 是否需要输入PIN码,Y需要,N不需要
     */
    public static final String CLIENT_BRANCH_BEAN_NEED_PIN_FLAG_NOT_BLANK = "CLIENT_BRANCH_BEAN_NEED_PIN_FLAG_NOT_BLANK";
    /**
     * 开关,送钱，是否需要添加票据,Y需要,N不需要
     */
    public static final String CLIENT_BRANCH_BEAN_SWITCH_SEND_TASK_NEED_ADD_COMPROBANTES_LENGTH = "CLIENT_BRANCH_BEAN_SWITCH_SEND_TASK_NEED_ADD_COMPROBANTES_LENGTH";
    /**
     * 开关,送钱，取消任务，是否需要访问票据,Y需要,N不需要
     */
    public static final String CLIENT_BRANCH_BEAN_SWITCH_CANCEL_TASK_VISIT_BILL_BY_DIRECTLY_TO_DELIVERY_LENGTH = "CLIENT_BRANCH_BEAN_SWITCH_CANCEL_TASK_VISIT_BILL_BY_DIRECTLY_TO_DELIVERY_LENGTH";
    /**
     * 是否需要分配保镖,Y有,N无【备注:该分支,名下的司机,在登陆APP客户端时,是否弹出分配保镖,开关[需求改变,是因为TanMeMe的任务是外部导入,已经分配好线路,车辆,司机,保镖,营业员 dateBy 2016-08-29]】
     */
    public static final String CLIENT_BRANCH_BEAN_ASSIGN_GUARD_FLAG_LENGTH = "CLIENT_BRANCH_BEAN_ASSIGN_GUARD_FLAG_LENGTH";
    /**
     * 网点坐标纬度,浮点型
     */
    public static final String CLIENT_BRANCH_BEAN_LATITUDE_LENGTH = "CLIENT_BRANCH_BEAN_LATITUDE_LENGTH";
    /**
     * 是否需要分配车辆,Y有,N无【备注:该分支,名下的司机,在登陆APP客户端时,是否弹出分配车辆,开关[需求改变,是因为TanMeMe的任务是外部导入,已经分配好线路,车辆,司机,保镖,营业员 dateBy 2016-08-29]】
     */
    public static final String CLIENT_BRANCH_BEAN_ASSIGN_VEHICLE_FLAG_LENGTH = "CLIENT_BRANCH_BEAN_ASSIGN_VEHICLE_FLAG_LENGTH";
    /**
     * 是否需要分配收银员,Y有,N无【备注:该分支,名下的司机,在登陆APP客户端时,是否弹出分配收银员,开关[需求改变,是因为TanMeMe的任务是外部导入,已经分配好线路,车辆,司机,保镖,营业员 dateBy 2016-08-29]】
     */
    public static final String CLIENT_BRANCH_BEAN_ASSIGN_AUXILIARY_FLAG_NOT_BLANK = "CLIENT_BRANCH_BEAN_ASSIGN_AUXILIARY_FLAG_NOT_BLANK";

}