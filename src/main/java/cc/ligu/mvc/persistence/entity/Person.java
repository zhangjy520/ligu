package cc.ligu.mvc.persistence.entity;

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
     * 人员类别：1管理员 2施工人员
     */
    private Integer type;

    /**
     * 性别
     */
    private String gender;

    /**
     * 联系方式
     */
    private String contact;

    /**
     * 身份证号码
     */
    private String identityNum;

    /**
     * 薪资情况
     */
    private String salaryDetails;

    /**
     * 现住址
     */
    private String address;

    /**
     * 所在项目id,关联oa_item主键
     */
    private Integer itemId;

    /**
     * 项目名称
     */
    private String itemName;

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
     * 保险情况
     */
    private byte[] insurancePurchases;

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
     * 获取人员类别：1管理员 2施工人员
     * @return type 人员类别：1管理员 2施工人员
     */
    public Integer getType() {
        return type;
    }

    /**
     * 设置人员类别：1管理员 2施工人员
     * @param type 人员类别：1管理员 2施工人员
     */
    public void setType(Integer type) {
        this.type = type;
    }

    /**
     * 获取性别
     * @return gender 性别
     */
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
     * 获取身份证号码
     * @return identity_num 身份证号码
     */
    public String getIdentityNum() {
        return identityNum;
    }

    /**
     * 设置身份证号码
     * @param identityNum 身份证号码
     */
    public void setIdentityNum(String identityNum) {
        this.identityNum = identityNum == null ? null : identityNum.trim();
    }

    /**
     * 获取薪资情况
     * @return salary_details 薪资情况
     */
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

    /**
     * 获取保险情况
     * @return insurance_purchases 保险情况
     */
    public byte[] getInsurancePurchases() {
        return insurancePurchases;
    }

    /**
     * 设置保险情况
     * @param insurancePurchases 保险情况
     */
    public void setInsurancePurchases(byte[] insurancePurchases) {
        this.insurancePurchases = insurancePurchases;
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
            && (this.getGender() == null ? other.getGender() == null : this.getGender().equals(other.getGender()))
            && (this.getContact() == null ? other.getContact() == null : this.getContact().equals(other.getContact()))
            && (this.getIdentityNum() == null ? other.getIdentityNum() == null : this.getIdentityNum().equals(other.getIdentityNum()))
            && (this.getSalaryDetails() == null ? other.getSalaryDetails() == null : this.getSalaryDetails().equals(other.getSalaryDetails()))
            && (this.getAddress() == null ? other.getAddress() == null : this.getAddress().equals(other.getAddress()))
            && (this.getItemId() == null ? other.getItemId() == null : this.getItemId().equals(other.getItemId()))
            && (this.getItemName() == null ? other.getItemName() == null : this.getItemName().equals(other.getItemName()))
            && (this.getRemark() == null ? other.getRemark() == null : this.getRemark().equals(other.getRemark()))
            && (this.getCreateDate() == null ? other.getCreateDate() == null : this.getCreateDate().equals(other.getCreateDate()))
            && (this.getCreateBy() == null ? other.getCreateBy() == null : this.getCreateBy().equals(other.getCreateBy()))
            && (this.getUpdateDate() == null ? other.getUpdateDate() == null : this.getUpdateDate().equals(other.getUpdateDate()))
            && (this.getUpdateBy() == null ? other.getUpdateBy() == null : this.getUpdateBy().equals(other.getUpdateBy()))
            && (this.getDelFlag() == null ? other.getDelFlag() == null : this.getDelFlag().equals(other.getDelFlag()))
            && (this.getInsurancePurchases() == null ? other.getInsurancePurchases() == null : this.getInsurancePurchases().equals(other.getInsurancePurchases()));
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((getId() == null) ? 0 : getId().hashCode());
        result = prime * result + ((getName() == null) ? 0 : getName().hashCode());
        result = prime * result + ((getType() == null) ? 0 : getType().hashCode());
        result = prime * result + ((getGender() == null) ? 0 : getGender().hashCode());
        result = prime * result + ((getContact() == null) ? 0 : getContact().hashCode());
        result = prime * result + ((getIdentityNum() == null) ? 0 : getIdentityNum().hashCode());
        result = prime * result + ((getSalaryDetails() == null) ? 0 : getSalaryDetails().hashCode());
        result = prime * result + ((getAddress() == null) ? 0 : getAddress().hashCode());
        result = prime * result + ((getItemId() == null) ? 0 : getItemId().hashCode());
        result = prime * result + ((getItemName() == null) ? 0 : getItemName().hashCode());
        result = prime * result + ((getRemark() == null) ? 0 : getRemark().hashCode());
        result = prime * result + ((getCreateDate() == null) ? 0 : getCreateDate().hashCode());
        result = prime * result + ((getCreateBy() == null) ? 0 : getCreateBy().hashCode());
        result = prime * result + ((getUpdateDate() == null) ? 0 : getUpdateDate().hashCode());
        result = prime * result + ((getUpdateBy() == null) ? 0 : getUpdateBy().hashCode());
        result = prime * result + ((getDelFlag() == null) ? 0 : getDelFlag().hashCode());
        result = prime * result + ((getInsurancePurchases() == null) ? 0 : getInsurancePurchases().hashCode());
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
        sb.append(", gender=").append(gender);
        sb.append(", contact=").append(contact);
        sb.append(", identityNum=").append(identityNum);
        sb.append(", salaryDetails=").append(salaryDetails);
        sb.append(", address=").append(address);
        sb.append(", itemId=").append(itemId);
        sb.append(", itemName=").append(itemName);
        sb.append(", remark=").append(remark);
        sb.append(", createDate=").append(createDate);
        sb.append(", createBy=").append(createBy);
        sb.append(", updateDate=").append(updateDate);
        sb.append(", updateBy=").append(updateBy);
        sb.append(", delFlag=").append(delFlag);
        sb.append(", insurancePurchases=").append(insurancePurchases);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}