package cn.assupg.study.bean;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;


@Table(name = "t_department")
public class DepartmentBean implements Serializable {
    /**
     * 数据库主键ID
     */
    @Id
    @Column(name = "department_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    /**
     * 部门名称
     */
    @Column(name = "department_name")
    private String name;

    /**
     * 状态【ENABLE[启用]、DISABLE[禁用]】
     */
    @Column(name = "department_status")
    private String status;

    /**
     * 描述
     */
    @Column(name = "department_description")
    private String description;

    /**
     * 创建时间
     */
    @Column(name = "department_create_timestamp")
    private Date createTimestamp;

    /**
     * 逻辑删除标志【N[正常]，Y[删除]】
     */
    @Column(name = "department_delete_flag")
    private String deleteFlag;

    private static final long serialVersionUID = 1L;

    /**
     * 获取数据库主键ID
     *
     * @return department_id - 数据库主键ID
     */
    public Long getId() {
        return id;
    }

    /**
     * 设置数据库主键ID
     *
     * @param id 数据库主键ID
     */
    public DepartmentBean setId(Long id) {
        this.id = id;
        return this;
    }

    /**
     * 获取部门名称
     *
     * @return department_name - 部门名称
     */
    public String getName() {
        return name;
    }

    /**
     * 设置部门名称
     *
     * @param name 部门名称
     */
    public DepartmentBean setName(String name) {
        this.name = name == null ? null : name.trim();
        return this;
    }

    /**
     * 获取状态【ENABLE[启用]、DISABLE[禁用]】
     *
     * @return department_status - 状态【ENABLE[启用]、DISABLE[禁用]】
     */
    public String getStatus() {
        return status;
    }

    /**
     * 设置状态【ENABLE[启用]、DISABLE[禁用]】
     *
     * @param status 状态【ENABLE[启用]、DISABLE[禁用]】
     */
    public DepartmentBean setStatus(String status) {
        this.status = status == null ? null : status.trim();
        return this;
    }

    /**
     * 获取描述
     *
     * @return department_description - 描述
     */
    public String getDescription() {
        return description;
    }

    /**
     * 设置描述
     *
     * @param description 描述
     */
    public DepartmentBean setDescription(String description) {
        this.description = description == null ? null : description.trim();
        return this;
    }

    /**
     * 获取创建时间
     *
     * @return department_create_timestamp - 创建时间
     */
    public Date getCreateTimestamp() {
        return createTimestamp;
    }

    /**
     * 设置创建时间
     *
     * @param createTimestamp 创建时间
     */
    public DepartmentBean setCreateTimestamp(Date createTimestamp) {
        this.createTimestamp = createTimestamp;
        return this;
    }

    /**
     * 获取逻辑删除标志【N[正常]，Y[删除]】
     *
     * @return department_delete_flag - 逻辑删除标志【N[正常]，Y[删除]】
     */
    public String getDeleteFlag() {
        return deleteFlag;
    }

    /**
     * 设置逻辑删除标志【N[正常]，Y[删除]】
     *
     * @param deleteFlag 逻辑删除标志【N[正常]，Y[删除]】
     */
    public DepartmentBean setDeleteFlag(String deleteFlag) {
        this.deleteFlag = deleteFlag == null ? null : deleteFlag.trim();
        return this;
    }
}