package cc.ligu.mvc.persistence.entity;

import cc.ligu.common.utils.excel.annotation.ExcelField;

import java.io.Serializable;

public class Person implements Serializable {
    /**
     * 主键
     */
    private Integer id;

    /**
     * 姓名
     */
    private String name;

    /**
     * 人员角色类别:1超级管理员 2人员审核管理员(主任) 3项目管理员(移动公司项目经理) 4施工管理员(施工方项目经理) 5施工工人
     */
    private Integer type;
    private String typeName;


    /**
     * 角色名称
     */
    private String roleName;

    /**
     * 角色权限
     */
    private String rolePermission;

    /**
     * 性别
     */
    private String gender;

    /**
     * 联系方式
     */
    private String contact;

    /**
     * 证件类型
     */
    private String identityType;

    /**
     * 证件号码
     */
    private String identityNum;

    /**
     * 保险情况
     */
    private String insurancePurchases;

    /**
     * 薪资情况
     */
    private String salaryDetails;

    /**
     * 现住址
     */
    private String address;

    /**
     * 审核状态[0未审核 1已审核]
     */
    private Integer status;

    /**
     * 承保公司
     */
    private String company;

    /**
     * 所在项目id,关联oa_item主键
     */
    private Integer itemId;

    /**
     * 项目名称
     */
    private String itemName;

    /**
     * 施工单位专业
     */
    private String professionalUnit;

    /**
     * 黑名单状态[0正常 ,1黑名单待审，2黑名单人员]
     */
    private Integer blackFlag;

    /**
     * 备注
     */
    private String remark;

    /**
     * 创建日期(时间戳格式)
     */
    private Long createDate;

    /**
     * 创建人
     */
    private Integer createBy;

    /**
     * 修改日期(时间戳格式)
     */
    private Long updateDate;

    /**
     * 修改人
     */
    private Integer updateBy;

    /**
     * 逻辑删除标记[0正常,1已删除,2黑名单]
     */
    private Integer delFlag;

    /**
     * oa_person
     */
    private static final long serialVersionUID = 1L;

    /**
     * 获取主键
     * @return id 主键
     */
    public Integer getId() {
        return id;
    }

    /**
     * 设置主键
     * @param id 主键
     */
    public void setId(Integer id) {
        this.id = id;
    }

    /**
     * 获取姓名
     * @return name 姓名
     */
    @ExcelField(title = "姓名", align = 2, sort = 1, groups = {1, 2})
    public String getName() {
        return name;
    }

    /**
     * 设置姓名
     * @param name 姓名
     */
    public void setName(String name) {
        this.name = name == null ? null : name.trim();
    }

    /**
     * 获取人员角色类别:1超级管理员 2人员审核管理员(主任) 3项目管理员(移动公司项目经理) 4施工管理员(施工方项目经理) 5施工工人
     * @return type 人员角色类别:1 超级管理员 2 人员审核管理员(主任) 3 项目管理员(移动公司项目经理) 4 施工管理员(施工方项目经理) 5 施工工人
     */
    public Integer getType() {
        return type;
    }

    @ExcelField(title = "人员身份", align = 2, sort = 9, groups = {1, 2},isnull=1,isDropDown = 1,dropDownList = {"人员审核管理员","项目管理员","施工管理员","施工工人"})
    public String getTypeName() {
        return typeName;
    }

    public void setTypeName(String typeName) {
        this.typeName = typeName;
    }

    /**
     * 设置人员角色类别:1超级管理员 2人员审核管理员(主任) 3项目管理员(移动公司项目经理) 4施工管理员(施工方项目经理) 5施工工人
     * @param type 人员角色类别:1超级管理员 2人员审核管理员(主任) 3项目管理员(移动公司项目经理) 4施工管理员(施工方项目经理) 5施工工人
     */
    public void setType(Integer type) {
        this.type = type;
    }

    /**
     * 获取角色名称
     * @return role_name 角色名称
     */
    public String getRoleName() {
        return roleName;
    }

    /**
     * 设置角色名称
     * @param roleName 角色名称
     */
    public void setRoleName(String roleName) {
        this.roleName = roleName == null ? null : roleName.trim();
    }

    /**
     * 获取角色权限
     * @return role_permission 角色权限
     */
    public String getRolePermission() {
        return rolePermission;
    }

    /**
     * 设置角色权限
     * @param rolePermission 角色权限
     */
    public void setRolePermission(String rolePermission) {
        this.rolePermission = rolePermission == null ? null : rolePermission.trim();
    }

    /**
     * 获取性别
     * @return gender 性别
     */
    @ExcelField(title = "性别", align = 2, sort = 2, groups = {1, 2},isnull=1,isDropDown = 1,dropDownList = {"男","女"})
    public String getGender() {
        return gender;
    }

    /**
     * 设置性别
     * @param gender 性别
     */
    public void setGender(String gender) {
        this.gender = gender == null ? null : gender.trim();
    }

    /**
     * 获取联系方式
     * @return contact 联系方式
     */
    @ExcelField(title = "联系方式", align = 2, sort = 3, groups = {1, 2})
    public String getContact() {
        return contact;
    }

    /**
     * 设置联系方式
     * @param contact 联系方式
     */
    public void setContact(String contact) {
        this.contact = contact == null ? null : contact.trim();
    }

    /**
     * 获取证件类型
     * @return identity_type 证件类型
     */
    @ExcelField(title = "证件类型", align = 2, sort = 4, groups = {1, 2})
    public String getIdentityType() {
        return identityType;
    }

    /**
     * 设置证件类型
     * @param identityType 证件类型
     */
    public void setIdentityType(String identityType) {
        this.identityType = identityType == null ? null : identityType.trim();
    }

    /**
     * 获取证件号码
     * @return identity_num 证件号码
     */
    @ExcelField(title = "证件号码", align = 2, sort = 5, groups = {1, 2})
    public String getIdentityNum() {
        return identityNum;
    }

    /**
     * 设置证件号码
     * @param identityNum 证件号码
     */
    public void setIdentityNum(String identityNum) {
        this.identityNum = identityNum == null ? null : identityNum.trim();
    }

    /**
     * 获取保险情况
     * @return insurance_purchases 保险情况
     */
    @ExcelField(title = "保险信息", align = 2, sort = 6, groups = {1, 2})
    public String getInsurancePurchases() {
        return insurancePurchases;
    }

    /**
     * 设置保险情况
     * @param insurancePurchases 保险情况
     */
    public void setInsurancePurchases(String insurancePurchases) {
        this.insurancePurchases = insurancePurchases == null ? null : insurancePurchases.trim();
    }

    /**
     * 获取薪资情况
     * @return salary_details 薪资情况
     */
    @ExcelField(title = "薪资信息", align = 2, sort = 7, groups = {1, 2})
    public String getSalaryDetails() {
        return salaryDetails;
    }

    /**
     * 设置薪资情况
     * @param salaryDetails 薪资情况
     */
    public void setSalaryDetails(String salaryDetails) {
        this.salaryDetails = salaryDetails == null ? null : salaryDetails.trim();
    }

    /**
     * 获取现住址
     * @return address 现住址
     */
    @ExcelField(title = "现住址", align = 2, sort = 8, groups = {1, 2})
    public String getAddress() {
        return address;
    }

    /**
     * 设置现住址
     * @param address 现住址
     */
    public void setAddress(String address) {
        this.address = address == null ? null : address.trim();
    }

    /**
     * 获取审核状态[0未审核 1已审核]
     * @return status 审核状态[0未审核 1已审核]
     */
    public Integer getStatus() {
        return status;
    }

    /**
     * 设置审核状态[0未审核 1已审核]
     * @param status 审核状态[0未审核 1已审核]
     */
    public void setStatus(Integer status) {
        this.status = status;
    }

    /**
     * 获取承保公司
     * @return company 承保公司
     */
    public String getCompany() {
        return company;
    }

    /**
     * 设置承保公司
     * @param company 承保公司
     */
    public void setCompany(String company) {
        this.company = company == null ? null : company.trim();
    }

    /**
     * 获取所在项目id,关联oa_item主键
     * @return item_id 所在项目id,关联oa_item主键
     */
    public Integer getItemId() {
        return itemId;
    }

    /**
     * 设置所在项目id,关联oa_item主键
     * @param itemId 所在项目id,关联oa_item主键
     */
    public void setItemId(Integer itemId) {
        this.itemId = itemId;
    }

    /**
     * 获取项目名称
     * @return item_name 项目名称
     */
    public String getItemName() {
        return itemName;
    }

    /**
     * 设置项目名称
     * @param itemName 项目名称
     */
    public void setItemName(String itemName) {
        this.itemName = itemName == null ? null : itemName.trim();
    }

    /**
     * 获取施工单位专业
     * @return professional_unit 施工单位专业
     */
    @ExcelField(title = "施工单位专业", align = 2, sort = 10, groups = {1, 2})
    public String getProfessionalUnit() {
        return professionalUnit;
    }

    /**
     * 设置施工单位专业
     * @param professionalUnit 施工单位专业
     */
    public void setProfessionalUnit(String professionalUnit) {
        this.professionalUnit = professionalUnit == null ? null : professionalUnit.trim();
    }

    /**
     * 获取黑名单状态[0正常 ,1黑名单待审，2黑名单人员]
     * @return black_flag 黑名单状态[0正常 ,1黑名单待审，2黑名单人员]
     */
    public Integer getBlackFlag() {
        return blackFlag;
    }

    /**
     * 设置黑名单状态[0正常 ,1黑名单待审，2黑名单人员]
     * @param blackFlag 黑名单状态[0正常 ,1黑名单待审，2黑名单人员]
     */
    public void setBlackFlag(Integer blackFlag) {
        this.blackFlag = blackFlag;
    }

    /**
     * 获取备注
     * @return remark 备注
     */
    public String getRemark() {
        return remark;
    }

    /**
     * 设置备注
     * @param remark 备注
     */
    public void setRemark(String remark) {
        this.remark = remark == null ? null : remark.trim();
    }

    /**
     * 获取创建日期(时间戳格式)
     * @return create_date 创建日期(时间戳格式)
     */
    public Long getCreateDate() {
        return createDate;
    }

    /**
     * 设置创建日期(时间戳格式)
     * @param createDate 创建日期(时间戳格式)
     */
    public void setCreateDate(Long createDate) {
        this.createDate = createDate;
    }

    /**
     * 获取创建人
     * @return create_by 创建人
     */
    public Integer getCreateBy() {
        return createBy;
    }

    /**
     * 设置创建人
     * @param createBy 创建人
     */
    public void setCreateBy(Integer createBy) {
        this.createBy = createBy;
    }

    /**
     * 获取修改日期(时间戳格式)
     * @return update_date 修改日期(时间戳格式)
     */
    public Long getUpdateDate() {
        return updateDate;
    }

    /**
     * 设置修改日期(时间戳格式)
     * @param updateDate 修改日期(时间戳格式)
     */
    public void setUpdateDate(Long updateDate) {
        this.updateDate = updateDate;
    }

    /**
     * 获取修改人
     * @return update_by 修改人
     */
    public Integer getUpdateBy() {
        return updateBy;
    }

    /**
     * 设置修改人
     * @param updateBy 修改人
     */
    public void setUpdateBy(Integer updateBy) {
        this.updateBy = updateBy;
    }

    /**
     * 获取逻辑删除标记[0正常,1已删除,2黑名单]
     * @return del_flag 逻辑删除标记[0正常,1已删除,2黑名单]
     */
    public Integer getDelFlag() {
        return delFlag;
    }

    /**
     * 设置逻辑删除标记[0正常,1已删除,2黑名单]
     * @param delFlag 逻辑删除标记[0正常,1已删除,2黑名单]
     */
    public void setDelFlag(Integer delFlag) {
        this.delFlag = delFlag;
    }

    @Override
    public boolean equals(Object that) {
        if (this == that) {
            return true;
        }
        if (that == null) {
            return false;
        }
        if (getClass() != that.getClass()) {
            return false;
        }
        Person other = (Person) that;
        return (this.getId() == null ? other.getId() == null : this.getId().equals(other.getId()))
            && (this.getName() == null ? other.getName() == null : this.getName().equals(other.getName()))
            && (this.getType() == null ? other.getType() == null : this.getType().equals(other.getType()))
            && (this.getRoleName() == null ? other.getRoleName() == null : this.getRoleName().equals(other.getRoleName()))
            && (this.getRolePermission() == null ? other.getRolePermission() == null : this.getRolePermission().equals(other.getRolePermission()))
            && (this.getGender() == null ? other.getGender() == null : this.getGender().equals(other.getGender()))
            && (this.getContact() == null ? other.getContact() == null : this.getContact().equals(other.getContact()))
            && (this.getIdentityType() == null ? other.getIdentityType() == null : this.getIdentityType().equals(other.getIdentityType()))
            && (this.getIdentityNum() == null ? other.getIdentityNum() == null : this.getIdentityNum().equals(other.getIdentityNum()))
            && (this.getInsurancePurchases() == null ? other.getInsurancePurchases() == null : this.getInsurancePurchases().equals(other.getInsurancePurchases()))
            && (this.getSalaryDetails() == null ? other.getSalaryDetails() == null : this.getSalaryDetails().equals(other.getSalaryDetails()))
            && (this.getAddress() == null ? other.getAddress() == null : this.getAddress().equals(other.getAddress()))
            && (this.getStatus() == null ? other.getStatus() == null : this.getStatus().equals(other.getStatus()))
            && (this.getCompany() == null ? other.getCompany() == null : this.getCompany().equals(other.getCompany()))
            && (this.getItemId() == null ? other.getItemId() == null : this.getItemId().equals(other.getItemId()))
            && (this.getItemName() == null ? other.getItemName() == null : this.getItemName().equals(other.getItemName()))
            && (this.getProfessionalUnit() == null ? other.getProfessionalUnit() == null : this.getProfessionalUnit().equals(other.getProfessionalUnit()))
            && (this.getBlackFlag() == null ? other.getBlackFlag() == null : this.getBlackFlag().equals(other.getBlackFlag()))
            && (this.getRemark() == null ? other.getRemark() == null : this.getRemark().equals(other.getRemark()))
            && (this.getCreateDate() == null ? other.getCreateDate() == null : this.getCreateDate().equals(other.getCreateDate()))
            && (this.getCreateBy() == null ? other.getCreateBy() == null : this.getCreateBy().equals(other.getCreateBy()))
            && (this.getUpdateDate() == null ? other.getUpdateDate() == null : this.getUpdateDate().equals(other.getUpdateDate()))
            && (this.getUpdateBy() == null ? other.getUpdateBy() == null : this.getUpdateBy().equals(other.getUpdateBy()))
            && (this.getDelFlag() == null ? other.getDelFlag() == null : this.getDelFlag().equals(other.getDelFlag()));
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((getId() == null) ? 0 : getId().hashCode());
        result = prime * result + ((getName() == null) ? 0 : getName().hashCode());
        result = prime * result + ((getType() == null) ? 0 : getType().hashCode());
        result = prime * result + ((getRoleName() == null) ? 0 : getRoleName().hashCode());
        result = prime * result + ((getRolePermission() == null) ? 0 : getRolePermission().hashCode());
        result = prime * result + ((getGender() == null) ? 0 : getGender().hashCode());
        result = prime * result + ((getContact() == null) ? 0 : getContact().hashCode());
        result = prime * result + ((getIdentityType() == null) ? 0 : getIdentityType().hashCode());
        result = prime * result + ((getIdentityNum() == null) ? 0 : getIdentityNum().hashCode());
        result = prime * result + ((getInsurancePurchases() == null) ? 0 : getInsurancePurchases().hashCode());
        result = prime * result + ((getSalaryDetails() == null) ? 0 : getSalaryDetails().hashCode());
        result = prime * result + ((getAddress() == null) ? 0 : getAddress().hashCode());
        result = prime * result + ((getStatus() == null) ? 0 : getStatus().hashCode());
        result = prime * result + ((getCompany() == null) ? 0 : getCompany().hashCode());
        result = prime * result + ((getItemId() == null) ? 0 : getItemId().hashCode());
        result = prime * result + ((getItemName() == null) ? 0 : getItemName().hashCode());
        result = prime * result + ((getProfessionalUnit() == null) ? 0 : getProfessionalUnit().hashCode());
        result = prime * result + ((getBlackFlag() == null) ? 0 : getBlackFlag().hashCode());
        result = prime * result + ((getRemark() == null) ? 0 : getRemark().hashCode());
        result = prime * result + ((getCreateDate() == null) ? 0 : getCreateDate().hashCode());
        result = prime * result + ((getCreateBy() == null) ? 0 : getCreateBy().hashCode());
        result = prime * result + ((getUpdateDate() == null) ? 0 : getUpdateDate().hashCode());
        result = prime * result + ((getUpdateBy() == null) ? 0 : getUpdateBy().hashCode());
        result = prime * result + ((getDelFlag() == null) ? 0 : getDelFlag().hashCode());
        return result;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", id=").append(id);
        sb.append(", name=").append(name);
        sb.append(", type=").append(type);
        sb.append(", roleName=").append(roleName);
        sb.append(", rolePermission=").append(rolePermission);
        sb.append(", gender=").append(gender);
        sb.append(", contact=").append(contact);
        sb.append(", identityType=").append(identityType);
        sb.append(", identityNum=").append(identityNum);
        sb.append(", insurancePurchases=").append(insurancePurchases);
        sb.append(", salaryDetails=").append(salaryDetails);
        sb.append(", address=").append(address);
        sb.append(", status=").append(status);
        sb.append(", company=").append(company);
        sb.append(", itemId=").append(itemId);
        sb.append(", itemName=").append(itemName);
        sb.append(", professionalUnit=").append(professionalUnit);
        sb.append(", blackFlag=").append(blackFlag);
        sb.append(", remark=").append(remark);
        sb.append(", createDate=").append(createDate);
        sb.append(", createBy=").append(createBy);
        sb.append(", updateDate=").append(updateDate);
        sb.append(", updateBy=").append(updateBy);
        sb.append(", delFlag=").append(delFlag);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}