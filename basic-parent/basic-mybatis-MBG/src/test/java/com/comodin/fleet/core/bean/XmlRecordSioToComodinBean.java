package com.comodin.fleet.core.bean;

import com.comodin.basic.util.date.DateUtil;
import com.comodin.basic.validation.IBaseValidGroup;
import com.comodin.basic.validation.constraints.*;
import com.comodin.fleet.constants.i18n.XmlRecordSioToComodinBeanI18nConstant;
import java.io.Serializable;
import java.util.Date;
import javax.persistence.*;
import javax.validation.constraints.*;
import org.hibernate.validator.constraints.*;
import org.springframework.format.annotation.DateTimeFormat;

@SuppressWarnings({"unused", "SpringAutowiredFieldsWarningInspection", "StatementWithEmptyBody", "WeakerAccess", "DefaultAnnotationParam"})
@Entity
@Table(name = "t_xml_record_sio_to_comodin")
public class XmlRecordSioToComodinBean implements Serializable {
    /**
     * <pre>
     * DB remark: 数据库主键ID
     * DB column: xml_id	BIGINT(19)	<--->	id	java.lang.Long
     * DB is  Nullable: false
     * DB defaultValue: null
     * </pre>
     */
    @NotNull(message = "{" + XmlRecordSioToComodinBeanI18nConstant.XML_RECORD_SIO_TO_COMODIN_BEAN_ID_NOT_NULL + "}", groups = {IBaseValidGroup.Update.class})
    @ValidLength(max = 19, message = "{" + XmlRecordSioToComodinBeanI18nConstant.XML_RECORD_SIO_TO_COMODIN_BEAN_ID_LENGTH + "}", groups = {IBaseValidGroup.Update.class})
    @Column(name = "xml_id", length = 19, nullable = false)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    private Long id;

    /**
     * <pre>
     * DB remark: sioToComodin上传xml,类型
     * DB column: xml_file_type	VARCHAR(11)	<--->	fileType	java.lang.String
     * DB is  Nullable: true
     * DB defaultValue: null
     * </pre>
     */
    @Length(max = 11, message = "{" + XmlRecordSioToComodinBeanI18nConstant.XML_RECORD_SIO_TO_COMODIN_BEAN_FILE_TYPE_LENGTH + "}", groups = {IBaseValidGroup.Add.class, IBaseValidGroup.Update.class})
    @Column(name = "xml_file_type", length = 11, nullable = true)
    private String fileType;

    /**
     * <pre>
     * DB remark: sioToComodin上传xml,原始文件名
     * DB column: xml_file_origin_name	VARCHAR(100)	<--->	fileOriginName	java.lang.String
     * DB is  Nullable: true
     * DB defaultValue: null
     * </pre>
     */
    @Length(max = 100, message = "{" + XmlRecordSioToComodinBeanI18nConstant.XML_RECORD_SIO_TO_COMODIN_BEAN_FILE_ORIGIN_NAME_LENGTH + "}", groups = {IBaseValidGroup.Add.class, IBaseValidGroup.Update.class})
    @Column(name = "xml_file_origin_name", length = 100, nullable = true)
    private String fileOriginName;

    /**
     * <pre>
     * DB remark: sioToComodin上传xml,保存的路径
     * DB column: xml_file_full_path_name	VARCHAR(300)	<--->	fileFullPathName	java.lang.String
     * DB is  Nullable: true
     * DB defaultValue: null
     * </pre>
     */
    @Length(max = 300, message = "{" + XmlRecordSioToComodinBeanI18nConstant.XML_RECORD_SIO_TO_COMODIN_BEAN_FILE_FULL_PATH_NAME_LENGTH + "}", groups = {IBaseValidGroup.Add.class, IBaseValidGroup.Update.class})
    @Column(name = "xml_file_full_path_name", length = 300, nullable = true)
    private String fileFullPathName;

    /**
     * <pre>
     * DB remark: sioToComodin上传xml,任务来源于SIO某分公司,SIO分公司内部编号
     * DB column: xml_route_company_internal_id	VARCHAR(15)	<--->	routeCompanyInternalId	java.lang.String
     * DB is  Nullable: true
     * DB defaultValue: null
     * </pre>
     */
    @Length(max = 15, message = "{" + XmlRecordSioToComodinBeanI18nConstant.XML_RECORD_SIO_TO_COMODIN_BEAN_ROUTE_COMPANY_INTERNAL_ID_LENGTH + "}", groups = {IBaseValidGroup.Add.class, IBaseValidGroup.Update.class})
    @Column(name = "xml_route_company_internal_id", length = 15, nullable = true)
    private String routeCompanyInternalId;

    /**
     * <pre>
     * DB remark: sioToComodin上传xml,任务来源于SIO某分公司的哪个分支网点,SIO分支网点的内部编号
     * DB column: xml_route_branch_internal_id	VARCHAR(15)	<--->	routeBranchInternalId	java.lang.String
     * DB is  Nullable: true
     * DB defaultValue: null
     * </pre>
     */
    @Length(max = 15, message = "{" + XmlRecordSioToComodinBeanI18nConstant.XML_RECORD_SIO_TO_COMODIN_BEAN_ROUTE_BRANCH_INTERNAL_ID_LENGTH + "}", groups = {IBaseValidGroup.Add.class, IBaseValidGroup.Update.class})
    @Column(name = "xml_route_branch_internal_id", length = 15, nullable = true)
    private String routeBranchInternalId;

    /**
     * <pre>
     * DB remark: sioToComodin上传xml,路线日期 [即任务服务日期]
     * DB column: xml_route_service_date	CHAR(10)	<--->	routeServiceDate	java.lang.String
     * DB is  Nullable: true
     * DB defaultValue: null
     * </pre>
     */
    @Length(max = 10, message = "{" + XmlRecordSioToComodinBeanI18nConstant.XML_RECORD_SIO_TO_COMODIN_BEAN_ROUTE_SERVICE_DATE_LENGTH + "}", groups = {IBaseValidGroup.Add.class, IBaseValidGroup.Update.class})
    @Column(name = "xml_route_service_date", length = 10, nullable = true)
    private String routeServiceDate;

    /**
     * <pre>
     * DB remark: sioToComodin上传xml,路线ID
     * DB column: xml_route_id	VARCHAR(10)	<--->	routeId	java.lang.String
     * DB is  Nullable: true
     * DB defaultValue: null
     * </pre>
     */
    @Length(max = 10, message = "{" + XmlRecordSioToComodinBeanI18nConstant.XML_RECORD_SIO_TO_COMODIN_BEAN_ROUTE_ID_LENGTH + "}", groups = {IBaseValidGroup.Add.class, IBaseValidGroup.Update.class})
    @Column(name = "xml_route_id", length = 10, nullable = true)
    private String routeId;

    /**
     * <pre>
     * DB remark: sioToComodin上传xml,comodin,返回给sio的状态码
     * DB column: xml_result_status	VARCHAR(25)	<--->	resultStatus	java.lang.String
     * DB is  Nullable: true
     * DB defaultValue: null
     * </pre>
     */
    @Length(max = 25, message = "{" + XmlRecordSioToComodinBeanI18nConstant.XML_RECORD_SIO_TO_COMODIN_BEAN_RESULT_STATUS_LENGTH + "}", groups = {IBaseValidGroup.Add.class, IBaseValidGroup.Update.class})
    @Column(name = "xml_result_status", length = 25, nullable = true)
    private String resultStatus;

    /**
     * <pre>
     * DB remark: sioToComodin上传xml,comodin,返回给sio的消息
     * DB column: xml_result_message	VARCHAR(2048)	<--->	resultMessage	java.lang.String
     * DB is  Nullable: true
     * DB defaultValue: null
     * </pre>
     */
    @Length(max = 2048, message = "{" + XmlRecordSioToComodinBeanI18nConstant.XML_RECORD_SIO_TO_COMODIN_BEAN_RESULT_MESSAGE_LENGTH + "}", groups = {IBaseValidGroup.Add.class, IBaseValidGroup.Update.class})
    @Column(name = "xml_result_message", length = 2048, nullable = true)
    private String resultMessage;

    /**
     * <pre>
     * DB remark: 创建时间
     * DB column: xml_create_timestamp	TIMESTAMP(19)	<--->	createTimestamp	java.util.Date
     * DB is  Nullable: false
     * DB defaultValue: CURRENT_TIMESTAMP
     * </pre>
     */
    @ValidDateTimeFormat(pattern = DateUtil.DATE_PATTERN_YYYY_MM_DD_HH_MM_SS, message = "{" + XmlRecordSioToComodinBeanI18nConstant.XML_RECORD_SIO_TO_COMODIN_BEAN_CREATE_TIMESTAMP_DATE_TIME_FORMAT + "}", groups = {IBaseValidGroup.Add.class, IBaseValidGroup.Update.class})
    @DateTimeFormat(pattern = DateUtil.DATE_PATTERN_YYYY_MM_DD_HH_MM_SS)
    @NotNull(message = "{" + XmlRecordSioToComodinBeanI18nConstant.XML_RECORD_SIO_TO_COMODIN_BEAN_CREATE_TIMESTAMP_NOT_NULL + "}", groups = {IBaseValidGroup.Add.class, IBaseValidGroup.Update.class})
    @Column(name = "xml_create_timestamp", length = 19, nullable = false)
    private Date createTimestamp;

    /**
     * <pre>
     * DB remark: 谁新增了该员工,与crew_username字段关联 若为系统生成创建者为:SYSTEM
     * DB column: xml_create_by	VARCHAR(20)	<--->	createBy	java.lang.String
     * DB is  Nullable: false
     * DB defaultValue: null
     * </pre>
     */
    @NotBlank(message = "{" + XmlRecordSioToComodinBeanI18nConstant.XML_RECORD_SIO_TO_COMODIN_BEAN_CREATE_BY_NOT_BLANK + "}", groups = {IBaseValidGroup.Add.class, IBaseValidGroup.Update.class})
    @Length(max = 20, message = "{" + XmlRecordSioToComodinBeanI18nConstant.XML_RECORD_SIO_TO_COMODIN_BEAN_CREATE_BY_LENGTH + "}", groups = {IBaseValidGroup.Add.class, IBaseValidGroup.Update.class})
    @Column(name = "xml_create_by", length = 20, nullable = false)
    private String createBy;

    /**
     * <pre>
     * DB remark: 逻辑删除标志【N[正常],Y[删除]】
     * DB column: xml_delete_flag	CHAR(1)	<--->	deleteFlag	java.lang.String
     * DB is  Nullable: false
     * DB defaultValue: N
     * </pre>
     */
    @NotBlank(message = "{" + XmlRecordSioToComodinBeanI18nConstant.XML_RECORD_SIO_TO_COMODIN_BEAN_DELETE_FLAG_NOT_BLANK + "}", groups = {IBaseValidGroup.Add.class, IBaseValidGroup.Update.class})
    @Length(max = 1, message = "{" + XmlRecordSioToComodinBeanI18nConstant.XML_RECORD_SIO_TO_COMODIN_BEAN_DELETE_FLAG_LENGTH + "}", groups = {IBaseValidGroup.Add.class, IBaseValidGroup.Update.class})
    @Column(name = "xml_delete_flag", length = 1, nullable = false)
    private String deleteFlag;

    /**
     * <pre>
     * DB remark: sioToComodin上传xml,comodin,返回给sio的JSON字符串
     * DB column: xml_result_original	LONGVARCHAR(65535)	<--->	resultOriginal	java.lang.String
     * DB is  Nullable: true
     * DB defaultValue: null
     * </pre>
     */
    @Length(max = 65535, message = "{" + XmlRecordSioToComodinBeanI18nConstant.XML_RECORD_SIO_TO_COMODIN_BEAN_RESULT_ORIGINAL_LENGTH + "}", groups = {IBaseValidGroup.Add.class, IBaseValidGroup.Update.class})
    @Column(name = "xml_result_original", length = 65535, nullable = true)
    private String resultOriginal;

    private static final long serialVersionUID = 1L;

    /**
     * 获取 数据库主键ID
     *
     * @return xml_id - 数据库主键ID
     */
    public Long getId() {
        return id;
    }

    /**
     * 设置 数据库主键ID
     *
     * @param id - 数据库主键ID
     */
    public XmlRecordSioToComodinBean setId(Long id) {
        this.id = id;
        return this;
    }

    /**
     * 获取 sioToComodin上传xml,类型
     *
     * @return xml_file_type - sioToComodin上传xml,类型
     */
    public String getFileType() {
        return fileType;
    }

    /**
     * 设置 sioToComodin上传xml,类型
     *
     * @param fileType - sioToComodin上传xml,类型
     */
    public XmlRecordSioToComodinBean setFileType(String fileType) {
        this.fileType = fileType == null ? null : fileType.trim();
        return this;
    }

    /**
     * 获取 sioToComodin上传xml,原始文件名
     *
     * @return xml_file_origin_name - sioToComodin上传xml,原始文件名
     */
    public String getFileOriginName() {
        return fileOriginName;
    }

    /**
     * 设置 sioToComodin上传xml,原始文件名
     *
     * @param fileOriginName - sioToComodin上传xml,原始文件名
     */
    public XmlRecordSioToComodinBean setFileOriginName(String fileOriginName) {
        this.fileOriginName = fileOriginName == null ? null : fileOriginName.trim();
        return this;
    }

    /**
     * 获取 sioToComodin上传xml,保存的路径
     *
     * @return xml_file_full_path_name - sioToComodin上传xml,保存的路径
     */
    public String getFileFullPathName() {
        return fileFullPathName;
    }

    /**
     * 设置 sioToComodin上传xml,保存的路径
     *
     * @param fileFullPathName - sioToComodin上传xml,保存的路径
     */
    public XmlRecordSioToComodinBean setFileFullPathName(String fileFullPathName) {
        this.fileFullPathName = fileFullPathName == null ? null : fileFullPathName.trim();
        return this;
    }

    /**
     * 获取 sioToComodin上传xml,任务来源于SIO某分公司,SIO分公司内部编号
     *
     * @return xml_route_company_internal_id - sioToComodin上传xml,任务来源于SIO某分公司,SIO分公司内部编号
     */
    public String getRouteCompanyInternalId() {
        return routeCompanyInternalId;
    }

    /**
     * 设置 sioToComodin上传xml,任务来源于SIO某分公司,SIO分公司内部编号
     *
     * @param routeCompanyInternalId - sioToComodin上传xml,任务来源于SIO某分公司,SIO分公司内部编号
     */
    public XmlRecordSioToComodinBean setRouteCompanyInternalId(String routeCompanyInternalId) {
        this.routeCompanyInternalId = routeCompanyInternalId == null ? null : routeCompanyInternalId.trim();
        return this;
    }

    /**
     * 获取 sioToComodin上传xml,任务来源于SIO某分公司的哪个分支网点,SIO分支网点的内部编号
     *
     * @return xml_route_branch_internal_id - sioToComodin上传xml,任务来源于SIO某分公司的哪个分支网点,SIO分支网点的内部编号
     */
    public String getRouteBranchInternalId() {
        return routeBranchInternalId;
    }

    /**
     * 设置 sioToComodin上传xml,任务来源于SIO某分公司的哪个分支网点,SIO分支网点的内部编号
     *
     * @param routeBranchInternalId - sioToComodin上传xml,任务来源于SIO某分公司的哪个分支网点,SIO分支网点的内部编号
     */
    public XmlRecordSioToComodinBean setRouteBranchInternalId(String routeBranchInternalId) {
        this.routeBranchInternalId = routeBranchInternalId == null ? null : routeBranchInternalId.trim();
        return this;
    }

    /**
     * 获取 sioToComodin上传xml,路线日期 [即任务服务日期]
     *
     * @return xml_route_service_date - sioToComodin上传xml,路线日期 [即任务服务日期]
     */
    public String getRouteServiceDate() {
        return routeServiceDate;
    }

    /**
     * 设置 sioToComodin上传xml,路线日期 [即任务服务日期]
     *
     * @param routeServiceDate - sioToComodin上传xml,路线日期 [即任务服务日期]
     */
    public XmlRecordSioToComodinBean setRouteServiceDate(String routeServiceDate) {
        this.routeServiceDate = routeServiceDate == null ? null : routeServiceDate.trim();
        return this;
    }

    /**
     * 获取 sioToComodin上传xml,路线ID
     *
     * @return xml_route_id - sioToComodin上传xml,路线ID
     */
    public String getRouteId() {
        return routeId;
    }

    /**
     * 设置 sioToComodin上传xml,路线ID
     *
     * @param routeId - sioToComodin上传xml,路线ID
     */
    public XmlRecordSioToComodinBean setRouteId(String routeId) {
        this.routeId = routeId == null ? null : routeId.trim();
        return this;
    }

    /**
     * 获取 sioToComodin上传xml,comodin,返回给sio的状态码
     *
     * @return xml_result_status - sioToComodin上传xml,comodin,返回给sio的状态码
     */
    public String getResultStatus() {
        return resultStatus;
    }

    /**
     * 设置 sioToComodin上传xml,comodin,返回给sio的状态码
     *
     * @param resultStatus - sioToComodin上传xml,comodin,返回给sio的状态码
     */
    public XmlRecordSioToComodinBean setResultStatus(String resultStatus) {
        this.resultStatus = resultStatus == null ? null : resultStatus.trim();
        return this;
    }

    /**
     * 获取 sioToComodin上传xml,comodin,返回给sio的消息
     *
     * @return xml_result_message - sioToComodin上传xml,comodin,返回给sio的消息
     */
    public String getResultMessage() {
        return resultMessage;
    }

    /**
     * 设置 sioToComodin上传xml,comodin,返回给sio的消息
     *
     * @param resultMessage - sioToComodin上传xml,comodin,返回给sio的消息
     */
    public XmlRecordSioToComodinBean setResultMessage(String resultMessage) {
        this.resultMessage = resultMessage == null ? null : resultMessage.trim();
        return this;
    }

    /**
     * 获取 创建时间
     *
     * @return xml_create_timestamp - 创建时间
     */
    public Date getCreateTimestamp() {
        return createTimestamp;
    }

    /**
     * 设置 创建时间
     *
     * @param createTimestamp - 创建时间
     */
    public XmlRecordSioToComodinBean setCreateTimestamp(Date createTimestamp) {
        this.createTimestamp = createTimestamp;
        return this;
    }

    /**
     * 获取 谁新增了该员工,与crew_username字段关联 若为系统生成创建者为:SYSTEM
     *
     * @return xml_create_by - 谁新增了该员工,与crew_username字段关联 若为系统生成创建者为:SYSTEM
     */
    public String getCreateBy() {
        return createBy;
    }

    /**
     * 设置 谁新增了该员工,与crew_username字段关联 若为系统生成创建者为:SYSTEM
     *
     * @param createBy - 谁新增了该员工,与crew_username字段关联 若为系统生成创建者为:SYSTEM
     */
    public XmlRecordSioToComodinBean setCreateBy(String createBy) {
        this.createBy = createBy == null ? null : createBy.trim();
        return this;
    }

    /**
     * 获取 逻辑删除标志【N[正常],Y[删除]】
     *
     * @return xml_delete_flag - 逻辑删除标志【N[正常],Y[删除]】
     */
    public String getDeleteFlag() {
        return deleteFlag;
    }

    /**
     * 设置 逻辑删除标志【N[正常],Y[删除]】
     *
     * @param deleteFlag - 逻辑删除标志【N[正常],Y[删除]】
     */
    public XmlRecordSioToComodinBean setDeleteFlag(String deleteFlag) {
        this.deleteFlag = deleteFlag == null ? null : deleteFlag.trim();
        return this;
    }

    /**
     * 获取 sioToComodin上传xml,comodin,返回给sio的JSON字符串
     *
     * @return xml_result_original - sioToComodin上传xml,comodin,返回给sio的JSON字符串
     */
    public String getResultOriginal() {
        return resultOriginal;
    }

    /**
     * 设置 sioToComodin上传xml,comodin,返回给sio的JSON字符串
     *
     * @param resultOriginal - sioToComodin上传xml,comodin,返回给sio的JSON字符串
     */
    public XmlRecordSioToComodinBean setResultOriginal(String resultOriginal) {
        this.resultOriginal = resultOriginal == null ? null : resultOriginal.trim();
        return this;
    }
}