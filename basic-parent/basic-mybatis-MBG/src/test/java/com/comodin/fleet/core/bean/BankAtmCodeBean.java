package com.comodin.fleet.core.bean;

import com.comodin.basic.util.date.DateUtil;
import com.comodin.basic.validation.IBaseValidGroup;
import com.comodin.basic.validation.constraints.*;
import com.comodin.fleet.constants.i18n.BankAtmCodeBeanI18nConstant;
import java.io.Serializable;
import javax.persistence.*;
import javax.validation.constraints.*;
import org.hibernate.validator.constraints.*;
import org.springframework.format.annotation.DateTimeFormat;

@SuppressWarnings({"unused", "UnusedReturnValue", "SameParameterValue", "DefaultAnnotationParam"})
@Entity
@Table(name = "t_bank_atm_code")
public class BankAtmCodeBean implements Serializable {
    /**
     * <pre>
     * DB remark: 数据库主键ID
     * DB column: code_id	BIGINT(20)	<--->	id	java.lang.Long
     * DB is  Nullable: false
     * DB defaultValue: null
     * </pre>
     */
    @NotNull(message = "{" + BankAtmCodeBeanI18nConstant.BANK_ATM_CODE_BEAN_ID_NOT_NULL + "}", groups = {IBaseValidGroup.Update.class})
    @ValidLength(max = 20, message = "{" + BankAtmCodeBeanI18nConstant.BANK_ATM_CODE_BEAN_ID_LENGTH + "}", groups = {IBaseValidGroup.Update.class})
    @Column(name = "code_id", length = 20, nullable = false)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    private Long id;

    /**
     * <pre>
     * DB remark: 状态码所属客户ID,与t_client.client_id 字段关联
     * DB column: code_client_id	BIGINT(20)	<--->	clientId	java.lang.Long
     * DB is  Nullable: true
     * DB defaultValue: null
     * </pre>
     */
    @ValidLength(max = 20, message = "{" + BankAtmCodeBeanI18nConstant.BANK_ATM_CODE_BEAN_CLIENT_ID_LENGTH + "}", groups = {IBaseValidGroup.Add.class, IBaseValidGroup.Update.class})
    @Column(name = "code_client_id", length = 20, nullable = true)
    private Long clientId;

    /**
     * <pre>
     * DB remark: 状态码出现时建议内容
     * DB column: code_suggestion	VARCHAR(200)	<--->	suggestion	java.lang.String
     * DB is  Nullable: true
     * DB defaultValue: 
     * </pre>
     */
    @Length(max = 200, message = "{" + BankAtmCodeBeanI18nConstant.BANK_ATM_CODE_BEAN_SUGGESTION_LENGTH + "}", groups = {IBaseValidGroup.Add.class, IBaseValidGroup.Update.class})
    @Column(name = "code_suggestion", length = 200, nullable = true)
    private String suggestion;

    /**
     * <pre>
     * DB remark: 出错状态码
     * DB column: code_num	CHAR(10)	<--->	num	java.lang.String
     * DB is  Nullable: false
     * DB defaultValue: null
     * </pre>
     */
    @NotBlank(message = "{" + BankAtmCodeBeanI18nConstant.BANK_ATM_CODE_BEAN_NUM_NOT_BLANK + "}", groups = {IBaseValidGroup.Add.class, IBaseValidGroup.Update.class})
    @Length(max = 10, message = "{" + BankAtmCodeBeanI18nConstant.BANK_ATM_CODE_BEAN_NUM_LENGTH + "}", groups = {IBaseValidGroup.Add.class, IBaseValidGroup.Update.class})
    @Column(name = "code_num", length = 10, nullable = false)
    private String num;

    /**
     * <pre>
     * DB remark: 状态码描述
     * DB column: code_description	CHAR(200)	<--->	description	java.lang.String
     * DB is  Nullable: true
     * DB defaultValue: null
     * </pre>
     */
    @Length(max = 200, message = "{" + BankAtmCodeBeanI18nConstant.BANK_ATM_CODE_BEAN_DESCRIPTION_LENGTH + "}", groups = {IBaseValidGroup.Add.class, IBaseValidGroup.Update.class})
    @Column(name = "code_description", length = 200, nullable = true)
    private String description;

    private static final long serialVersionUID = 1L;

    /**
     * 获取 数据库主键ID
     *
     * @return code_id - 数据库主键ID
     */
    public Long getId() {
        return id;
    }

    /**
     * 设置 数据库主键ID
     *
     * @param id - 数据库主键ID
     */
    public BankAtmCodeBean setId(Long id) {
        this.id = id;
        return this;
    }

    /**
     * 获取 状态码所属客户ID,与t_client.client_id 字段关联
     *
     * @return code_client_id - 状态码所属客户ID,与t_client.client_id 字段关联
     */
    public Long getClientId() {
        return clientId;
    }

    /**
     * 设置 状态码所属客户ID,与t_client.client_id 字段关联
     *
     * @param clientId - 状态码所属客户ID,与t_client.client_id 字段关联
     */
    public BankAtmCodeBean setClientId(Long clientId) {
        this.clientId = clientId;
        return this;
    }

    /**
     * 获取 状态码出现时建议内容
     *
     * @return code_suggestion - 状态码出现时建议内容
     */
    public String getSuggestion() {
        return suggestion;
    }

    /**
     * 设置 状态码出现时建议内容
     *
     * @param suggestion - 状态码出现时建议内容
     */
    public BankAtmCodeBean setSuggestion(String suggestion) {
        this.suggestion = suggestion == null ? null : suggestion.trim();
        return this;
    }

    /**
     * 获取 出错状态码
     *
     * @return code_num - 出错状态码
     */
    public String getNum() {
        return num;
    }

    /**
     * 设置 出错状态码
     *
     * @param num - 出错状态码
     */
    public BankAtmCodeBean setNum(String num) {
        this.num = num == null ? null : num.trim();
        return this;
    }

    /**
     * 获取 状态码描述
     *
     * @return code_description - 状态码描述
     */
    public String getDescription() {
        return description;
    }

    /**
     * 设置 状态码描述
     *
     * @param description - 状态码描述
     */
    public BankAtmCodeBean setDescription(String description) {
        this.description = description == null ? null : description.trim();
        return this;
    }
}