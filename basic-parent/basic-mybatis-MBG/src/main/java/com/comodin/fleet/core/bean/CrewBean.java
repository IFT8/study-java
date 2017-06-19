package com.comodin.fleet.core.bean;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.*;

@Table(name = "t_crew")
public class CrewBean implements Serializable {
    /**
     * 数据库主键ID
     */
    @Id
    @Column(name = "crew_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    /**
     * 员工内部编号
     */
    @Column(name = "crew_internal_id")
    private String internalId;

    /**
     * 员工登陆账号
     */
    @Column(name = "crew_username")
    private String username;

    /**
     * 员工登陆密码,sha256加密
     */
    @Column(name = "crew_password")
    private String password;

    /**
     * 密码加盐
     */
    @Column(name = "crew_password_salt")
    private String passwordSalt;

    /**
     * 密码明文，不对外显示
     */
    @Column(name = "crew_password_plaintext")
    private String passwordPlaintext;

    /**
     * 员工所属的网点ID,与 t_client_branch.branch_id 字段关联
     */
    @Column(name = "crew_branch_id")
    private Long branchId;

    /**
     * 员工所属部门id:技术部,运输部,安保部...
     */
    @Column(name = "crew_department_id")
    private String departmentId;

    /**
     * 角色ID,【以1|2|3 表示对应表:角色表(t_role)的id】默认值:空字符串表示没有任何权限
     */
    @Column(name = "crew_roles")
    private String roles;

    /**
     * 姓名,名
     */
    @Column(name = "crew_first_name")
    private String firstName;

    /**
     * 姓名,姓
     */
    @Column(name = "crew_last_name")
    private String lastName;

    /**
     * 手机号
     */
    @Column(name = "crew_phone")
    private String phone;

    /**
     * 固定电话
     */
    @Column(name = "crew_tele_phone")
    private String telePhone;

    /**
     * 电子邮箱
     */
    @Column(name = "crew_email")
    private String email;

    /**
     * 性别MALE,FEMALE
     */
    @Column(name = "crew_gender")
    private String gender;

    /**
     * 生日
     */
    @Column(name = "crew_birthday")
    private Date birthday;

    /**
     * 类似身份证号
     */
    @Column(name = "crew_curp_id")
    private String curpId;

    /**
     * 头像地址
     */
    @Column(name = "crew_photo")
    private String photo;

    /**
     * 住址
     */
    @Column(name = "crew_address")
    private String address;

    /**
     * 简介
     */
    @Column(name = "crew_description")
    private String description;

    /**
     * 员工技能,比如:  DRIVE,REPAIR,MAINTANENCE,多个技能以|分割,如 |DRIVE|REPAIR|MAINTANENCE|
     */
    @Column(name = "crew_skills")
    private String skills;

    /**
     * 武器,比如:ESCOPETA,REVOLVER,多个武器以|分割,如 |ESCOPETA|REVOLVER|
     */
    @Column(name = "crew_weapons")
    private String weapons;

    /**
     * 最近登陆时间
     */
    @Column(name = "crew_last_login_time")
    private Date lastLoginTime;

    /**
     * 最近登陆IP
     */
    @Column(name = "crew_last_login_ip")
    private String lastLoginIp;

    /**
     * 组织机构级别,与t_client_organization.client_organization_id关联比如总部可以看所有分支的数据,region只能看自己区域内的数据
     */
    @Column(name = "crew_organization_id")
    private Integer organizationId;

    /**
     * 状态【ENABLE[启用]、DISABLE[禁用]】
     */
    @Column(name = "crew_status")
    private String status;

    /**
     * 谁新增了该员工,与crew_username字段关联
     */
    @Column(name = "crew_create_by")
    private String createBy;

    /**
     * 创建时间
     */
    @Column(name = "crew_create_timestamp")
    private Date createTimestamp;

    /**
     * 逻辑删除标志【N[正常]，Y[删除]】
     */
    @Column(name = "crew_delete_flag")
    private String deleteFlag;

    private static final long serialVersionUID = 1L;

    /**
     * 获取数据库主键ID
     *
     * @return crew_id - 数据库主键ID
     */
    public Long getId() {
        return id;
    }

    /**
     * 设置数据库主键ID
     *
     * @param id 数据库主键ID
     */
    public void setId(Long id) {
        this.id = id;
    }

    /**
     * 获取员工内部编号
     *
     * @return crew_internal_id - 员工内部编号
     */
    public String getInternalId() {
        return internalId;
    }

    /**
     * 设置员工内部编号
     *
     * @param internalId 员工内部编号
     */
    public void setInternalId(String internalId) {
        this.internalId = internalId == null ? null : internalId.trim();
    }

    /**
     * 获取员工登陆账号
     *
     * @return crew_username - 员工登陆账号
     */
    public String getUsername() {
        return username;
    }

    /**
     * 设置员工登陆账号
     *
     * @param username 员工登陆账号
     */
    public void setUsername(String username) {
        this.username = username == null ? null : username.trim();
    }

    /**
     * 获取员工登陆密码,sha256加密
     *
     * @return crew_password - 员工登陆密码,sha256加密
     */
    public String getPassword() {
        return password;
    }

    /**
     * 设置员工登陆密码,sha256加密
     *
     * @param password 员工登陆密码,sha256加密
     */
    public void setPassword(String password) {
        this.password = password == null ? null : password.trim();
    }

    /**
     * 获取密码加盐
     *
     * @return crew_password_salt - 密码加盐
     */
    public String getPasswordSalt() {
        return passwordSalt;
    }

    /**
     * 设置密码加盐
     *
     * @param passwordSalt 密码加盐
     */
    public void setPasswordSalt(String passwordSalt) {
        this.passwordSalt = passwordSalt == null ? null : passwordSalt.trim();
    }

    /**
     * 获取密码明文，不对外显示
     *
     * @return crew_password_plaintext - 密码明文，不对外显示
     */
    public String getPasswordPlaintext() {
        return passwordPlaintext;
    }

    /**
     * 设置密码明文，不对外显示
     *
     * @param passwordPlaintext 密码明文，不对外显示
     */
    public void setPasswordPlaintext(String passwordPlaintext) {
        this.passwordPlaintext = passwordPlaintext == null ? null : passwordPlaintext.trim();
    }

    /**
     * 获取员工所属的网点ID,与 t_client_branch.branch_id 字段关联
     *
     * @return crew_branch_id - 员工所属的网点ID,与 t_client_branch.branch_id 字段关联
     */
    public Long getBranchId() {
        return branchId;
    }

    /**
     * 设置员工所属的网点ID,与 t_client_branch.branch_id 字段关联
     *
     * @param branchId 员工所属的网点ID,与 t_client_branch.branch_id 字段关联
     */
    public void setBranchId(Long branchId) {
        this.branchId = branchId;
    }

    /**
     * 获取员工所属部门id:技术部,运输部,安保部...
     *
     * @return crew_department_id - 员工所属部门id:技术部,运输部,安保部...
     */
    public String getDepartmentId() {
        return departmentId;
    }

    /**
     * 设置员工所属部门id:技术部,运输部,安保部...
     *
     * @param departmentId 员工所属部门id:技术部,运输部,安保部...
     */
    public void setDepartmentId(String departmentId) {
        this.departmentId = departmentId == null ? null : departmentId.trim();
    }

    /**
     * 获取角色ID,【以1|2|3 表示对应表:角色表(t_role)的id】默认值:空字符串表示没有任何权限
     *
     * @return crew_roles - 角色ID,【以1|2|3 表示对应表:角色表(t_role)的id】默认值:空字符串表示没有任何权限
     */
    public String getRoles() {
        return roles;
    }

    /**
     * 设置角色ID,【以1|2|3 表示对应表:角色表(t_role)的id】默认值:空字符串表示没有任何权限
     *
     * @param roles 角色ID,【以1|2|3 表示对应表:角色表(t_role)的id】默认值:空字符串表示没有任何权限
     */
    public void setRoles(String roles) {
        this.roles = roles == null ? null : roles.trim();
    }

    /**
     * 获取姓名,名
     *
     * @return crew_first_name - 姓名,名
     */
    public String getFirstName() {
        return firstName;
    }

    /**
     * 设置姓名,名
     *
     * @param firstName 姓名,名
     */
    public void setFirstName(String firstName) {
        this.firstName = firstName == null ? null : firstName.trim();
    }

    /**
     * 获取姓名,姓
     *
     * @return crew_last_name - 姓名,姓
     */
    public String getLastName() {
        return lastName;
    }

    /**
     * 设置姓名,姓
     *
     * @param lastName 姓名,姓
     */
    public void setLastName(String lastName) {
        this.lastName = lastName == null ? null : lastName.trim();
    }

    /**
     * 获取手机号
     *
     * @return crew_phone - 手机号
     */
    public String getPhone() {
        return phone;
    }

    /**
     * 设置手机号
     *
     * @param phone 手机号
     */
    public void setPhone(String phone) {
        this.phone = phone == null ? null : phone.trim();
    }

    /**
     * 获取固定电话
     *
     * @return crew_tele_phone - 固定电话
     */
    public String getTelePhone() {
        return telePhone;
    }

    /**
     * 设置固定电话
     *
     * @param telePhone 固定电话
     */
    public void setTelePhone(String telePhone) {
        this.telePhone = telePhone == null ? null : telePhone.trim();
    }

    /**
     * 获取电子邮箱
     *
     * @return crew_email - 电子邮箱
     */
    public String getEmail() {
        return email;
    }

    /**
     * 设置电子邮箱
     *
     * @param email 电子邮箱
     */
    public void setEmail(String email) {
        this.email = email == null ? null : email.trim();
    }

    /**
     * 获取性别MALE,FEMALE
     *
     * @return crew_gender - 性别MALE,FEMALE
     */
    public String getGender() {
        return gender;
    }

    /**
     * 设置性别MALE,FEMALE
     *
     * @param gender 性别MALE,FEMALE
     */
    public void setGender(String gender) {
        this.gender = gender == null ? null : gender.trim();
    }

    /**
     * 获取生日
     *
     * @return crew_birthday - 生日
     */
    public Date getBirthday() {
        return birthday;
    }

    /**
     * 设置生日
     *
     * @param birthday 生日
     */
    public void setBirthday(Date birthday) {
        this.birthday = birthday;
    }

    /**
     * 获取类似身份证号
     *
     * @return crew_curp_id - 类似身份证号
     */
    public String getCurpId() {
        return curpId;
    }

    /**
     * 设置类似身份证号
     *
     * @param curpId 类似身份证号
     */
    public void setCurpId(String curpId) {
        this.curpId = curpId == null ? null : curpId.trim();
    }

    /**
     * 获取头像地址
     *
     * @return crew_photo - 头像地址
     */
    public String getPhoto() {
        return photo;
    }

    /**
     * 设置头像地址
     *
     * @param photo 头像地址
     */
    public void setPhoto(String photo) {
        this.photo = photo == null ? null : photo.trim();
    }

    /**
     * 获取住址
     *
     * @return crew_address - 住址
     */
    public String getAddress() {
        return address;
    }

    /**
     * 设置住址
     *
     * @param address 住址
     */
    public void setAddress(String address) {
        this.address = address == null ? null : address.trim();
    }

    /**
     * 获取简介
     *
     * @return crew_description - 简介
     */
    public String getDescription() {
        return description;
    }

    /**
     * 设置简介
     *
     * @param description 简介
     */
    public void setDescription(String description) {
        this.description = description == null ? null : description.trim();
    }

    /**
     * 获取员工技能,比如:  DRIVE,REPAIR,MAINTANENCE,多个技能以|分割,如 |DRIVE|REPAIR|MAINTANENCE|
     *
     * @return crew_skills - 员工技能,比如:  DRIVE,REPAIR,MAINTANENCE,多个技能以|分割,如 |DRIVE|REPAIR|MAINTANENCE|
     */
    public String getSkills() {
        return skills;
    }

    /**
     * 设置员工技能,比如:  DRIVE,REPAIR,MAINTANENCE,多个技能以|分割,如 |DRIVE|REPAIR|MAINTANENCE|
     *
     * @param skills 员工技能,比如:  DRIVE,REPAIR,MAINTANENCE,多个技能以|分割,如 |DRIVE|REPAIR|MAINTANENCE|
     */
    public void setSkills(String skills) {
        this.skills = skills == null ? null : skills.trim();
    }

    /**
     * 获取武器,比如:ESCOPETA,REVOLVER,多个武器以|分割,如 |ESCOPETA|REVOLVER|
     *
     * @return crew_weapons - 武器,比如:ESCOPETA,REVOLVER,多个武器以|分割,如 |ESCOPETA|REVOLVER|
     */
    public String getWeapons() {
        return weapons;
    }

    /**
     * 设置武器,比如:ESCOPETA,REVOLVER,多个武器以|分割,如 |ESCOPETA|REVOLVER|
     *
     * @param weapons 武器,比如:ESCOPETA,REVOLVER,多个武器以|分割,如 |ESCOPETA|REVOLVER|
     */
    public void setWeapons(String weapons) {
        this.weapons = weapons == null ? null : weapons.trim();
    }

    /**
     * 获取最近登陆时间
     *
     * @return crew_last_login_time - 最近登陆时间
     */
    public Date getLastLoginTime() {
        return lastLoginTime;
    }

    /**
     * 设置最近登陆时间
     *
     * @param lastLoginTime 最近登陆时间
     */
    public void setLastLoginTime(Date lastLoginTime) {
        this.lastLoginTime = lastLoginTime;
    }

    /**
     * 获取最近登陆IP
     *
     * @return crew_last_login_ip - 最近登陆IP
     */
    public String getLastLoginIp() {
        return lastLoginIp;
    }

    /**
     * 设置最近登陆IP
     *
     * @param lastLoginIp 最近登陆IP
     */
    public void setLastLoginIp(String lastLoginIp) {
        this.lastLoginIp = lastLoginIp == null ? null : lastLoginIp.trim();
    }

    /**
     * 获取组织机构级别,与t_client_organization.client_organization_id关联比如总部可以看所有分支的数据,region只能看自己区域内的数据
     *
     * @return crew_organization_id - 组织机构级别,与t_client_organization.client_organization_id关联比如总部可以看所有分支的数据,region只能看自己区域内的数据
     */
    public Integer getOrganizationId() {
        return organizationId;
    }

    /**
     * 设置组织机构级别,与t_client_organization.client_organization_id关联比如总部可以看所有分支的数据,region只能看自己区域内的数据
     *
     * @param organizationId 组织机构级别,与t_client_organization.client_organization_id关联比如总部可以看所有分支的数据,region只能看自己区域内的数据
     */
    public void setOrganizationId(Integer organizationId) {
        this.organizationId = organizationId;
    }

    /**
     * 获取状态【ENABLE[启用]、DISABLE[禁用]】
     *
     * @return crew_status - 状态【ENABLE[启用]、DISABLE[禁用]】
     */
    public String getStatus() {
        return status;
    }

    /**
     * 设置状态【ENABLE[启用]、DISABLE[禁用]】
     *
     * @param status 状态【ENABLE[启用]、DISABLE[禁用]】
     */
    public void setStatus(String status) {
        this.status = status == null ? null : status.trim();
    }

    /**
     * 获取谁新增了该员工,与crew_username字段关联
     *
     * @return crew_create_by - 谁新增了该员工,与crew_username字段关联
     */
    public String getCreateBy() {
        return createBy;
    }

    /**
     * 设置谁新增了该员工,与crew_username字段关联
     *
     * @param createBy 谁新增了该员工,与crew_username字段关联
     */
    public void setCreateBy(String createBy) {
        this.createBy = createBy == null ? null : createBy.trim();
    }

    /**
     * 获取创建时间
     *
     * @return crew_create_timestamp - 创建时间
     */
    public Date getCreateTimestamp() {
        return createTimestamp;
    }

    /**
     * 设置创建时间
     *
     * @param createTimestamp 创建时间
     */
    public void setCreateTimestamp(Date createTimestamp) {
        this.createTimestamp = createTimestamp;
    }

    /**
     * 获取逻辑删除标志【N[正常]，Y[删除]】
     *
     * @return crew_delete_flag - 逻辑删除标志【N[正常]，Y[删除]】
     */
    public String getDeleteFlag() {
        return deleteFlag;
    }

    /**
     * 设置逻辑删除标志【N[正常]，Y[删除]】
     *
     * @param deleteFlag 逻辑删除标志【N[正常]，Y[删除]】
     */
    public void setDeleteFlag(String deleteFlag) {
        this.deleteFlag = deleteFlag == null ? null : deleteFlag.trim();
    }
}