package cc.ligu.mvc.persistence.entity;

import cc.ligu.common.utils.excel.annotation.ExcelField;

import java.io.Serializable;

public class Person implements Serializable {
    private Integer id;

    private String name;

    private Integer type;

    private String roleName;

    private String rolePermission;

    private String gender;

    private String contact;

    private String identityNum;

    private String insurancePurchases;

    private String salaryDetails;

    private String address;

    private Integer status;

    private String company;

    private Integer itemId;

    private String itemName;

    private String professionalUnit;

    private Integer blackFlag;

    private String remark;

    private Long createDate;

    private Integer createBy;

    private Long updateDate;

    private Integer updateBy;

    private Integer delFlag;

    private static final long serialVersionUID = 1L;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    @ExcelField(title = "姓名", align = 2, sort = 1, groups = {1, 2})
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name == null ? null : name.trim();
    }

    public Integer getType() {
        return type;
    }

    public void setType(Integer type) {
        this.type = type;
    }

    public String getRoleName() {
        return roleName;
    }

    public void setRoleName(String roleName) {
        this.roleName = roleName == null ? null : roleName.trim();
    }

    public String getRolePermission() {
        return rolePermission;
    }

    public void setRolePermission(String rolePermission) {
        this.rolePermission = rolePermission == null ? null : rolePermission.trim();
    }
    @ExcelField(title = "性别", align = 2, sort = 2, groups = {1, 2},isnull=1,isDropDown = 1,dropDownList = {"男","女"})
    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender == null ? null : gender.trim();
    }
    @ExcelField(title = "联系方式", align = 2, sort = 3, groups = {1, 2})
    public String getContact() {
        return contact;
    }

    public void setContact(String contact) {
        this.contact = contact == null ? null : contact.trim();
    }
    @ExcelField(title = "身份证号", align = 2, sort = 4, groups = {1, 2})
    public String getIdentityNum() {
        return identityNum;
    }

    public void setIdentityNum(String identityNum) {
        this.identityNum = identityNum == null ? null : identityNum.trim();
    }
    @ExcelField(title = "保险信息", align = 2, sort = 5, groups = {1, 2})
    public String getInsurancePurchases() {
        return insurancePurchases;
    }

    public void setInsurancePurchases(String insurancePurchases) {
        this.insurancePurchases = insurancePurchases == null ? null : insurancePurchases.trim();
    }
    @ExcelField(title = "薪资信息", align = 2, sort = 6, groups = {1, 2})
    public String getSalaryDetails() {
        return salaryDetails;
    }

    public void setSalaryDetails(String salaryDetails) {
        this.salaryDetails = salaryDetails == null ? null : salaryDetails.trim();
    }
    @ExcelField(title = "现住址", align = 2, sort = 7, groups = {1, 2})
    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address == null ? null : address.trim();
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }
    @ExcelField(title = "承包公司", align = 2, sort = 9, groups = {1, 2})
    public String getCompany() {
        return company;
    }

    public void setCompany(String company) {
        this.company = company == null ? null : company.trim();
    }

    public Integer getItemId() {
        return itemId;
    }

    public void setItemId(Integer itemId) {
        this.itemId = itemId;
    }

    public String getItemName() {
        return itemName;
    }

    public void setItemName(String itemName) {
        this.itemName = itemName == null ? null : itemName.trim();
    }
    @ExcelField(title = "施工单位专业", align = 2, sort = 8, groups = {1, 2})
    public String getProfessionalUnit() {
        return professionalUnit;
    }

    public void setProfessionalUnit(String professionalUnit) {
        this.professionalUnit = professionalUnit == null ? null : professionalUnit.trim();
    }

    public Integer getBlackFlag() {
        return blackFlag;
    }

    public void setBlackFlag(Integer blackFlag) {
        this.blackFlag = blackFlag;
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark == null ? null : remark.trim();
    }

    public Long getCreateDate() {
        return createDate;
    }

    public void setCreateDate(Long createDate) {
        this.createDate = createDate;
    }

    public Integer getCreateBy() {
        return createBy;
    }

    public void setCreateBy(Integer createBy) {
        this.createBy = createBy;
    }

    public Long getUpdateDate() {
        return updateDate;
    }

    public void setUpdateDate(Long updateDate) {
        this.updateDate = updateDate;
    }

    public Integer getUpdateBy() {
        return updateBy;
    }

    public void setUpdateBy(Integer updateBy) {
        this.updateBy = updateBy;
    }

    public Integer getDelFlag() {
        return delFlag;
    }

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