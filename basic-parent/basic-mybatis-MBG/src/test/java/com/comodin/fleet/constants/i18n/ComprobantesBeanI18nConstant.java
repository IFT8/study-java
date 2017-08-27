package com.comodin.fleet.constants.i18n;

@SuppressWarnings({"unused", "SpringAutowiredFieldsWarningInspection", "StatementWithEmptyBody"})
public class ComprobantesBeanI18nConstant  {

    /**
     * 票据类型【ORDINARY[普通票据]、VISIT[即取消任务或取消某些票据时，需要到客户店里签收的回执单（访问票据）、POINT_MONEY[点钞票据]]】date:2016-12-12 by:supeng
     */
    public static final String COMPROBANTES_BEAN_TYPE_LENGTH = "COMPROBANTES_BEAN_TYPE_LENGTH";
    /**
     * 逻辑删除标志【N[正常]，Y[删除]】
     */
    public static final String COMPROBANTES_BEAN_DELETE_FLAG_LENGTH = "COMPROBANTES_BEAN_DELETE_FLAG_LENGTH";
    /**
     * 票据对应的钱袋子数量,暂时没有记录每个钱袋子的编号
     */
    public static final String COMPROBANTES_BEAN_PACKAGE_NUMBER_NOT_NULL = "COMPROBANTES_BEAN_PACKAGE_NUMBER_NOT_NULL";
    /**
     * 票据的编号,司机完成任务时候输入或扫描二维码输入
     */
    public static final String COMPROBANTES_BEAN_CODE_NOT_BLANK = "COMPROBANTES_BEAN_CODE_NOT_BLANK";
    /**
     * 状态【RECEIVE_BILL_CP[收钱票据]、SEND_BILL_CE[送钱票据]、SEND_BILL_NOT_YET_DELIVERED_CS[送钱票据，还未交付]、SEND_BILL_NOT_USED_RETURN_CR[送钱票据，还未使用，直接返回回来的票据Return]、VISIT_BILL_CC[访问票据，即取消任务，或者票据，回执单]】
     */
    public static final String COMPROBANTES_BEAN_STATUS_NOT_BLANK = "COMPROBANTES_BEAN_STATUS_NOT_BLANK";
    public static final String COMPROBANTES_BEAN_UPDATE_TIMESTAMP_NOT_NULL = "COMPROBANTES_BEAN_UPDATE_TIMESTAMP_NOT_NULL";
    /**
     * 取消票据的,回执行单【目前需求,只有责任方为Client时,才有回执单】
     */
    public static final String COMPROBANTES_BEAN_CANCEL_SINGLE_RECEIPT_LENGTH = "COMPROBANTES_BEAN_CANCEL_SINGLE_RECEIPT_LENGTH";
    /**
     * 货币类型,USD MXN,XXX...
     */
    public static final String COMPROBANTES_BEAN_CURRENCY_ISO_CODE_NOT_BLANK = "COMPROBANTES_BEAN_CURRENCY_ISO_CODE_NOT_BLANK";
    /**
     * 票据是否有效【ENABLE[启用]、DISABLE[失效]】将原有comprobantes_status 改成 comprobantes_availability【date:2016-12-12 by:supeng】
     */
    public static final String COMPROBANTES_BEAN_AVAILABILITY_NOT_BLANK = "COMPROBANTES_BEAN_AVAILABILITY_NOT_BLANK";
    /**
     * 取消票据的,责任方【CIT,CLIENT】
     */
    public static final String COMPROBANTES_BEAN_CANCEL_RESPONSIBLE_PARTY_LENGTH = "COMPROBANTES_BEAN_CANCEL_RESPONSIBLE_PARTY_LENGTH";
    /**
     * 签名图片文件名
     */
    public static final String COMPROBANTES_BEAN_SIGNATURE_PICTURE_LENGTH = "COMPROBANTES_BEAN_SIGNATURE_PICTURE_LENGTH";
    /**
     * 客户网点代号
     */
    public static final String COMPROBANTES_BEAN_BRANCH_CODE_LENGTH = "COMPROBANTES_BEAN_BRANCH_CODE_LENGTH";
    /**
     * 创建时间
     */
    public static final String COMPROBANTES_BEAN_CREATE_TIMESTAMP_NOT_NULL = "COMPROBANTES_BEAN_CREATE_TIMESTAMP_NOT_NULL";
    /**
     * 票据来源，哪一方生成的任务【SIO公司导入进来分两种：[SIO_0_KIOSKOLIN、SIO_1_COMODIN]，COMODIN[comodin手工创建]，EXCEL[excel批量导入]】
     */
    public static final String COMPROBANTES_BEAN_GENERATE_SOURCE_PARTY_LENGTH = "COMPROBANTES_BEAN_GENERATE_SOURCE_PARTY_LENGTH";
    /**
     * 票据是否有效【ENABLE[启用]、DISABLE[失效]】将原有comprobantes_status 改成 comprobantes_availability【date:2016-12-12 by:supeng】
     */
    public static final String COMPROBANTES_BEAN_AVAILABILITY_LENGTH = "COMPROBANTES_BEAN_AVAILABILITY_LENGTH";
    /**
     * 数据库主键ID
     */
    public static final String COMPROBANTES_BEAN_ID_NOT_NULL = "COMPROBANTES_BEAN_ID_NOT_NULL";
    /**
     * client To client 任务类型时，在客户取钱后签名图片文件名
     */
    public static final String COMPROBANTES_BEAN_PART_SIGNATURE_PICTURE_LENGTH = "COMPROBANTES_BEAN_PART_SIGNATURE_PICTURE_LENGTH";
    /**
     * client To client 任务类型时，在客户取钱后拍照图片文件名
     */
    public static final String COMPROBANTES_BEAN_PART_EVIDENCE_PICTURE_LENGTH = "COMPROBANTES_BEAN_PART_EVIDENCE_PICTURE_LENGTH";
    /**
     * 票据的编号,司机完成任务时候输入或扫描二维码输入
     */
    public static final String COMPROBANTES_BEAN_CODE_LENGTH = "COMPROBANTES_BEAN_CODE_LENGTH";
    /**
     * 谁新增了该员工,与crew_username字段关联
     */
    public static final String COMPROBANTES_BEAN_CREATE_BY_NOT_BLANK = "COMPROBANTES_BEAN_CREATE_BY_NOT_BLANK";
    /**
     * 票据来源，哪一方生成的任务【SIO公司导入进来分两种：[SIO_0_KIOSKOLIN、SIO_1_COMODIN]，COMODIN[comodin手工创建]，EXCEL[excel批量导入]】
     */
    public static final String COMPROBANTES_BEAN_GENERATE_SOURCE_PARTY_NOT_BLANK = "COMPROBANTES_BEAN_GENERATE_SOURCE_PARTY_NOT_BLANK";
    /**
     * 数据库主键ID
     */
    public static final String COMPROBANTES_BEAN_ID_LENGTH = "COMPROBANTES_BEAN_ID_LENGTH";
    /**
     * 货币内部编号，各运钞分公司对货币有着不同的设定
     */
    public static final String COMPROBANTES_BEAN_CURRENCY_INTERNAL_ID_LENGTH = "COMPROBANTES_BEAN_CURRENCY_INTERNAL_ID_LENGTH";
    /**
     * 货币类型,USD MXN,XXX...
     */
    public static final String COMPROBANTES_BEAN_CURRENCY_ISO_CODE_LENGTH = "COMPROBANTES_BEAN_CURRENCY_ISO_CODE_LENGTH";
    /**
     * 票据对应的任务id, t_task.task_task_id关联,一个任务有多个票据
     */
    public static final String COMPROBANTES_BEAN_TASK_ID_LENGTH = "COMPROBANTES_BEAN_TASK_ID_LENGTH";
    /**
     * 逻辑删除标志【N[正常]，Y[删除]】
     */
    public static final String COMPROBANTES_BEAN_DELETE_FLAG_NOT_BLANK = "COMPROBANTES_BEAN_DELETE_FLAG_NOT_BLANK";
    /**
     * 票据对应的任务id, t_task.task_pk_id关联,一个任务有多个票据
     */
    public static final String COMPROBANTES_BEAN_TASK_PK_ID_NOT_NULL = "COMPROBANTES_BEAN_TASK_PK_ID_NOT_NULL";
    /**
     * 拍照图片文件名
     */
    public static final String COMPROBANTES_BEAN_EVIDENCE_PICTURE_LENGTH = "COMPROBANTES_BEAN_EVIDENCE_PICTURE_LENGTH";
    /**
     * 取消票据的备注
     */
    public static final String COMPROBANTES_BEAN_CANCEL_COMMENT_LENGTH = "COMPROBANTES_BEAN_CANCEL_COMMENT_LENGTH";
    /**
     * 状态【RECEIVE_BILL_CP[收钱票据]、SEND_BILL_CE[送钱票据]、SEND_BILL_NOT_YET_DELIVERED_CS[送钱票据，还未交付]、SEND_BILL_NOT_USED_RETURN_CR[送钱票据，还未使用，直接返回回来的票据Return]、VISIT_BILL_CC[访问票据，即取消任务，或者票据，回执单]】
     */
    public static final String COMPROBANTES_BEAN_STATUS_LENGTH = "COMPROBANTES_BEAN_STATUS_LENGTH";
    /**
     * 票据对应的任务id, t_task.task_task_id关联,一个任务有多个票据
     */
    public static final String COMPROBANTES_BEAN_TASK_ID_NOT_NULL = "COMPROBANTES_BEAN_TASK_ID_NOT_NULL";
    /**
     * 票据对应的任务id, t_task.task_pk_id关联,一个任务有多个票据
     */
    public static final String COMPROBANTES_BEAN_TASK_PK_ID_LENGTH = "COMPROBANTES_BEAN_TASK_PK_ID_LENGTH";
    /**
     * 谁新增了该员工,与crew_username字段关联
     */
    public static final String COMPROBANTES_BEAN_CREATE_BY_LENGTH = "COMPROBANTES_BEAN_CREATE_BY_LENGTH";
    public static final String COMPROBANTES_BEAN_UPDATE_TIMESTAMP_DATE_TIME_FORMAT = "COMPROBANTES_BEAN_UPDATE_TIMESTAMP_DATE_TIME_FORMAT";
    /**
     * 取消票据的,理由,t_setting.setting_key,关联
     */
    public static final String COMPROBANTES_BEAN_CANCEL_REASON_LENGTH = "COMPROBANTES_BEAN_CANCEL_REASON_LENGTH";
    /**
     * 票据来源，原始Comprobantes号，【date:2016-12-12 by:supeng】
     */
    public static final String COMPROBANTES_BEAN_SOURCE_BILL_ORIGINAL_CODE_LENGTH = "COMPROBANTES_BEAN_SOURCE_BILL_ORIGINAL_CODE_LENGTH";
    /**
     * 票据对应的钱袋子编号,多个编号以|隔开,例|123|456|789|
     */
    public static final String COMPROBANTES_BEAN_BAG_SERIAL_NUMBERS_LENGTH = "COMPROBANTES_BEAN_BAG_SERIAL_NUMBERS_LENGTH";
    /**
     * 票据类型【ORDINARY[普通票据]、VISIT[即取消任务或取消某些票据时，需要到客户店里签收的回执单（访问票据）、POINT_MONEY[点钞票据]]】date:2016-12-12 by:supeng
     */
    public static final String COMPROBANTES_BEAN_TYPE_NOT_BLANK = "COMPROBANTES_BEAN_TYPE_NOT_BLANK";
    /**
     * 创建时间
     */
    public static final String COMPROBANTES_BEAN_CREATE_TIMESTAMP_DATE_TIME_FORMAT = "COMPROBANTES_BEAN_CREATE_TIMESTAMP_DATE_TIME_FORMAT";
    /**
     * 票据对应的钱袋子数量,暂时没有记录每个钱袋子的编号
     */
    public static final String COMPROBANTES_BEAN_PACKAGE_NUMBER_LENGTH = "COMPROBANTES_BEAN_PACKAGE_NUMBER_LENGTH";
    /**
     * 取消票据的,钱回退处
     */
    public static final String COMPROBANTES_BEAN_CANCEL_MONEY_BACK_PARTY_LENGTH = "COMPROBANTES_BEAN_CANCEL_MONEY_BACK_PARTY_LENGTH";

}