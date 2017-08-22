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
@Table(name = "t_comprobantes_bag_number")
public class ComprobantesBagNumberBean implements Serializable {
    /**
     * <pre>
     * DB remark: 数据库主键ID
     * DB column: bag_number_id	BIGINT(20)	<--->	id	java.lang.Long
     * DB is  Nullable: false
     * DB defaultValue: null
     * </pre>
     */
    @NotNull(message = "{COMPROBANTES_BAG_NUMBER_BEAN_ID_NOT_NULL}", groups = {IBaseValidGroup.Add.class, IBaseValidGroup.Update.class})
    @ValidLength(max = 20, message = "{COMPROBANTES_BAG_NUMBER_BEAN_ID_LENGTH}", groups = {IBaseValidGroup.Add.class, IBaseValidGroup.Update.class})
    @Id
    @Column(name = "bag_number_id", length = 20, nullable = false)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    /**
     * <pre>
     * DB remark: 票据的ID
     * DB column: bag_number_comprobantes_id	BIGINT(20)	<--->	comprobantesId	java.lang.Long
     * DB is  Nullable: false
     * DB defaultValue: null
     * </pre>
     */
    @NotNull(message = "{COMPROBANTES_BAG_NUMBER_BEAN_COMPROBANTES_ID_NOT_NULL}", groups = {IBaseValidGroup.Add.class, IBaseValidGroup.Update.class})
    @ValidLength(max = 20, message = "{COMPROBANTES_BAG_NUMBER_BEAN_COMPROBANTES_ID_LENGTH}", groups = {IBaseValidGroup.Add.class, IBaseValidGroup.Update.class})
    @Column(name = "bag_number_comprobantes_id", length = 20, nullable = false)
    private Long comprobantesId;

    /**
     * <pre>
     * DB remark: 票据钱袋子的编号
     * DB column: bag_number_serial_code	VARCHAR(12)	<--->	serialCode	java.lang.String
     * DB is  Nullable: false
     * DB defaultValue: null
     * </pre>
     */
    @NotBlank(message = "{COMPROBANTES_BAG_NUMBER_BEAN_SERIAL_CODE_NOT_BLANK}", groups = {IBaseValidGroup.Add.class, IBaseValidGroup.Update.class})
    @Length(max = 12, message = "{COMPROBANTES_BAG_NUMBER_BEAN_SERIAL_CODE_LENGTH}", groups = {IBaseValidGroup.Add.class, IBaseValidGroup.Update.class})
    @Column(name = "bag_number_serial_code", length = 12, nullable = false)
    private String serialCode;

    /**
     * <pre>
     * DB remark: 创建时间
     * DB column: bag_number_create_timestamp	TIMESTAMP(19)	<--->	createTimestamp	java.util.Date
     * DB is  Nullable: false
     * DB defaultValue: CURRENT_TIMESTAMP
     * </pre>
     */
    @ValidDateTimeFormat(pattern = DateUtil.DATE_PATTERN_YYYY_MM_DD_HH_MM_SS , message = "{COMPROBANTES_BAG_NUMBER_BEAN_CREATE_TIMESTAMP_DATE_TIME_FORMAT}", groups = {IBaseValidGroup.Add.class, IBaseValidGroup.Update.class})
    @DateTimeFormat(pattern = DateUtil.DATE_PATTERN_YYYY_MM_DD_HH_MM_SS)
    @NotNull(message = "{COMPROBANTES_BAG_NUMBER_BEAN_CREATE_TIMESTAMP_NOT_NULL}", groups = {IBaseValidGroup.Add.class, IBaseValidGroup.Update.class})
    @Column(name = "bag_number_create_timestamp", length = 19, nullable = false)
    private Date createTimestamp;

    /**
     * <pre>
     * DB remark: 谁新增了该票据,与crew_username字段关联
     * DB column: bag_number_create_by	VARCHAR(20)	<--->	createBy	java.lang.String
     * DB is  Nullable: false
     * DB defaultValue: null
     * </pre>
     */
    @NotBlank(message = "{COMPROBANTES_BAG_NUMBER_BEAN_CREATE_BY_NOT_BLANK}", groups = {IBaseValidGroup.Add.class, IBaseValidGroup.Update.class})
    @Length(max = 20, message = "{COMPROBANTES_BAG_NUMBER_BEAN_CREATE_BY_LENGTH}", groups = {IBaseValidGroup.Add.class, IBaseValidGroup.Update.class})
    @Column(name = "bag_number_create_by", length = 20, nullable = false)
    private String createBy;

    /**
     * <pre>
     * DB remark: 逻辑删除标志【N[正常]，Y[删除]】
     * DB column: bag_number_delete_flag	CHAR(1)	<--->	deleteFlag	java.lang.String
     * DB is  Nullable: false
     * DB defaultValue: N
     * </pre>
     */
    @NotBlank(message = "{COMPROBANTES_BAG_NUMBER_BEAN_DELETE_FLAG_NOT_BLANK}", groups = {IBaseValidGroup.Add.class, IBaseValidGroup.Update.class})
    @Length(max = 1, message = "{COMPROBANTES_BAG_NUMBER_BEAN_DELETE_FLAG_LENGTH}", groups = {IBaseValidGroup.Add.class, IBaseValidGroup.Update.class})
    @Column(name = "bag_number_delete_flag", length = 1, nullable = false)
    private String deleteFlag;

    private static final long serialVersionUID = 1L;

    /**
     * 获取 数据库主键ID
     *
     * @return bag_number_id - 数据库主键ID
     */
    public Long getId() {
        return id;
    }

    /**
     * 设置 数据库主键ID
     *
     * @param id - 数据库主键ID
     */
    public ComprobantesBagNumberBean setId(Long id) {
        this.id = id;
        return this;
    }

    /**
     * 获取 票据的ID
     *
     * @return bag_number_comprobantes_id - 票据的ID
     */
    public Long getComprobantesId() {
        return comprobantesId;
    }

    /**
     * 设置 票据的ID
     *
     * @param comprobantesId - 票据的ID
     */
    public ComprobantesBagNumberBean setComprobantesId(Long comprobantesId) {
        this.comprobantesId = comprobantesId;
        return this;
    }

    /**
     * 获取 票据钱袋子的编号
     *
     * @return bag_number_serial_code - 票据钱袋子的编号
     */
    public String getSerialCode() {
        return serialCode;
    }

    /**
     * 设置 票据钱袋子的编号
     *
     * @param serialCode - 票据钱袋子的编号
     */
    public ComprobantesBagNumberBean setSerialCode(String serialCode) {
        this.serialCode = serialCode == null ? null : serialCode.trim();
        return this;
    }

    /**
     * 获取 创建时间
     *
     * @return bag_number_create_timestamp - 创建时间
     */
    public Date getCreateTimestamp() {
        return createTimestamp;
    }

    /**
     * 设置 创建时间
     *
     * @param createTimestamp - 创建时间
     */
    public ComprobantesBagNumberBean setCreateTimestamp(Date createTimestamp) {
        this.createTimestamp = createTimestamp;
        return this;
    }

    /**
     * 获取 谁新增了该票据,与crew_username字段关联
     *
     * @return bag_number_create_by - 谁新增了该票据,与crew_username字段关联
     */
    public String getCreateBy() {
        return createBy;
    }

    /**
     * 设置 谁新增了该票据,与crew_username字段关联
     *
     * @param createBy - 谁新增了该票据,与crew_username字段关联
     */
    public ComprobantesBagNumberBean setCreateBy(String createBy) {
        this.createBy = createBy == null ? null : createBy.trim();
        return this;
    }

    /**
     * 获取 逻辑删除标志【N[正常]，Y[删除]】
     *
     * @return bag_number_delete_flag - 逻辑删除标志【N[正常]，Y[删除]】
     */
    public String getDeleteFlag() {
        return deleteFlag;
    }

    /**
     * 设置 逻辑删除标志【N[正常]，Y[删除]】
     *
     * @param deleteFlag - 逻辑删除标志【N[正常]，Y[删除]】
     */
    public ComprobantesBagNumberBean setDeleteFlag(String deleteFlag) {
        this.deleteFlag = deleteFlag == null ? null : deleteFlag.trim();
        return this;
    }
}