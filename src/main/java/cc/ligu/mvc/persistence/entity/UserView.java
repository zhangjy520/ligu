package cc.ligu.mvc.persistence.entity;

import java.io.Serializable;
import java.util.List;

public class UserView implements Serializable {
    /**
     * 主键ID
     */
    private Integer id;

    /**
     * 登录名
     */
    private String username;

    /**
     * 密码
     */
    private String password;

    /**
     * 关联oa_person的主键
     */
    private Integer refId;

    /**
     * 用户头像
     */
    private String photoUrl;

    /**
     * 姓名
     */
    private String name;

    /**
     * 人员角色类别:1超级管理员 2人员审核管理员(主任) 3项目管理员(移动公司项目经理) 4施工管理员(施工方项目经理) 5施工工人
     */
    private Integer type;

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
     * 证件号码
     */
    private String identityNum;

    /**
     * 证件图片地址url
     */
    private String identityImg;

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
     * 所在项目id,关联oa_item主键
     */
    private Integer itemId;

    /**
     * 承包公司
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
     * 姓名
     */
    private String createUserName;

    /**
     * 创建人
     */
    private Integer createBy;

    /**
     * 创建日期(时间戳格式)
     */
    private Long createDate;

    private List<PersonSalary> salaryList;

    public List<PersonSalary> getSalaryList() {
        return salaryList;
    }

    public UserView setSalaryList(List<PersonSalary> salaryList) {
        this.salaryList = salaryList;
        return this;
    }

    /**
     * v_user
     */
    private static final long serialVersionUID = 1L;

    /**
     * 获取主键ID
     * @return id 主键ID
     */
    public Integer getId() {
        return id;
    }

    /**
     * 设置主键ID
     * @param id 主键ID
     */
    public void setId(Integer id) {
        this.id = id;
    }

    /**
     * 获取登录名
     * @return username 登录名
     */
    public String getUsername() {
        return username;
    }

    /**
     * 设置登录名
     * @param username 登录名
     */
    public void setUsername(String username) {
        this.username = username == null ? null : username.trim();
    }

    /**
     * 获取密码
     * @return password 密码
     */
    public String getPassword() {
        return password;
    }

    /**
     * 设置密码
     * @param password 密码
     */
    public void setPassword(String password) {
        this.password = password == null ? null : password.trim();
    }

    /**
     * 获取关联oa_person的主键
     * @return ref_id 关联oa_person的主键
     */
    public Integer getRefId() {
        return refId;
    }

    /**
     * 设置关联oa_person的主键
     * @param refId 关联oa_person的主键
     */
    public void setRefId(Integer refId) {
        this.refId = refId;
    }

    /**
     * 获取用户头像
     * @return photo_url 用户头像
     */
    public String getPhotoUrl() {
        return photoUrl;
    }

    /**
     * 设置用户头像
     * @param photoUrl 用户头像
     */
    public void setPhotoUrl(String photoUrl) {
        this.photoUrl = photoUrl == null ? null : photoUrl.trim();
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
     * 获取人员角色类别:1超级管理员 2人员审核管理员(主任) 3项目管理员(移动公司项目经理) 4施工管理员(施工方项目经理) 5施工工人
     * @return type 人员角色类别:1超级管理员 2人员审核管理员(主任) 3项目管理员(移动公司项目经理) 4施工管理员(施工方项目经理) 5施工工人
     */
    public Integer getType() {
        return type;
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
     * 获取证件号码
     * @return identity_num 证件号码
     */
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
     * 获取证件图片地址url
     * @return identity_img 证件图片地址url
     */
    public String getIdentityImg() {
        return identityImg;
    }

    /**
     * 设置证件图片地址url
     * @param identityImg 证件图片地址url
     */
    public void setIdentityImg(String identityImg) {
        this.identityImg = identityImg == null ? null : identityImg.trim();
    }

    /**
     * 获取保险情况
     * @return insurance_purchases 保险情况
     */
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
     * 获取承包公司
     * @return item_name 承包公司
     */
    public String getItemName() {
        return itemName;
    }

    /**
     * 设置承包公司
     * @param itemName 承包公司
     */
    public void setItemName(String itemName) {
        this.itemName = itemName == null ? null : itemName.trim();
    }

    /**
     * 获取施工单位专业
     * @return professional_unit 施工单位专业
     */
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
     * 获取姓名
     * @return create_user_name 姓名
     */
    public String getCreateUserName() {
        return createUserName;
    }

    /**
     * 设置姓名
     * @param createUserName 姓名
     */
    public void setCreateUserName(String createUserName) {
        this.createUserName = createUserName == null ? null : createUserName.trim();
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
        UserView other = (UserView) that;
        return (this.getId() == null ? other.getId() == null : this.getId().equals(other.getId()))
            && (this.getUsername() == null ? other.getUsername() == null : this.getUsername().equals(other.getUsername()))
            && (this.getPassword() == null ? other.getPassword() == null : this.getPassword().equals(other.getPassword()))
            && (this.getRefId() == null ? other.getRefId() == null : this.getRefId().equals(other.getRefId()))
            && (this.getPhotoUrl() == null ? other.getPhotoUrl() == null : this.getPhotoUrl().equals(other.getPhotoUrl()))
            && (this.getName() == null ? other.getName() == null : this.getName().equals(other.getName()))
            && (this.getType() == null ? other.getType() == null : this.getType().equals(other.getType()))
            && (this.getRoleName() == null ? other.getRoleName() == null : this.getRoleName().equals(other.getRoleName()))
            && (this.getRolePermission() == null ? other.getRolePermission() == null : this.getRolePermission().equals(other.getRolePermission()))
            && (this.getGender() == null ? other.getGender() == null : this.getGender().equals(other.getGender()))
            && (this.getContact() == null ? other.getContact() == null : this.getContact().equals(other.getContact()))
            && (this.getIdentityNum() == null ? other.getIdentityNum() == null : this.getIdentityNum().equals(other.getIdentityNum()))
            && (this.getIdentityImg() == null ? other.getIdentityImg() == null : this.getIdentityImg().equals(other.getIdentityImg()))
            && (this.getInsurancePurchases() == null ? other.getInsurancePurchases() == null : this.getInsurancePurchases().equals(other.getInsurancePurchases()))
            && (this.getSalaryDetails() == null ? other.getSalaryDetails() == null : this.getSalaryDetails().equals(other.getSalaryDetails()))
            && (this.getAddress() == null ? other.getAddress() == null : this.getAddress().equals(other.getAddress()))
            && (this.getStatus() == null ? other.getStatus() == null : this.getStatus().equals(other.getStatus()))
            && (this.getItemId() == null ? other.getItemId() == null : this.getItemId().equals(other.getItemId()))
            && (this.getItemName() == null ? other.getItemName() == null : this.getItemName().equals(other.getItemName()))
            && (this.getProfessionalUnit() == null ? other.getProfessionalUnit() == null : this.getProfessionalUnit().equals(other.getProfessionalUnit()))
            && (this.getBlackFlag() == null ? other.getBlackFlag() == null : this.getBlackFlag().equals(other.getBlackFlag()))
            && (this.getCreateUserName() == null ? other.getCreateUserName() == null : this.getCreateUserName().equals(other.getCreateUserName()))
            && (this.getCreateBy() == null ? other.getCreateBy() == null : this.getCreateBy().equals(other.getCreateBy()))
            && (this.getCreateDate() == null ? other.getCreateDate() == null : this.getCreateDate().equals(other.getCreateDate()));
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((getId() == null) ? 0 : getId().hashCode());
        result = prime * result + ((getUsername() == null) ? 0 : getUsername().hashCode());
        result = prime * result + ((getPassword() == null) ? 0 : getPassword().hashCode());
        result = prime * result + ((getRefId() == null) ? 0 : getRefId().hashCode());
        result = prime * result + ((getPhotoUrl() == null) ? 0 : getPhotoUrl().hashCode());
        result = prime * result + ((getName() == null) ? 0 : getName().hashCode());
        result = prime * result + ((getType() == null) ? 0 : getType().hashCode());
        result = prime * result + ((getRoleName() == null) ? 0 : getRoleName().hashCode());
        result = prime * result + ((getRolePermission() == null) ? 0 : getRolePermission().hashCode());
        result = prime * result + ((getGender() == null) ? 0 : getGender().hashCode());
        result = prime * result + ((getContact() == null) ? 0 : getContact().hashCode());
        result = prime * result + ((getIdentityNum() == null) ? 0 : getIdentityNum().hashCode());
        result = prime * result + ((getIdentityImg() == null) ? 0 : getIdentityImg().hashCode());
        result = prime * result + ((getInsurancePurchases() == null) ? 0 : getInsurancePurchases().hashCode());
        result = prime * result + ((getSalaryDetails() == null) ? 0 : getSalaryDetails().hashCode());
        result = prime * result + ((getAddress() == null) ? 0 : getAddress().hashCode());
        result = prime * result + ((getStatus() == null) ? 0 : getStatus().hashCode());
        result = prime * result + ((getItemId() == null) ? 0 : getItemId().hashCode());
        result = prime * result + ((getItemName() == null) ? 0 : getItemName().hashCode());
        result = prime * result + ((getProfessionalUnit() == null) ? 0 : getProfessionalUnit().hashCode());
        result = prime * result + ((getBlackFlag() == null) ? 0 : getBlackFlag().hashCode());
        result = prime * result + ((getCreateUserName() == null) ? 0 : getCreateUserName().hashCode());
        result = prime * result + ((getCreateBy() == null) ? 0 : getCreateBy().hashCode());
        result = prime * result + ((getCreateDate() == null) ? 0 : getCreateDate().hashCode());
        return result;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", id=").append(id);
        sb.append(", username=").append(username);
        sb.append(", password=").append(password);
        sb.append(", refId=").append(refId);
        sb.append(", photoUrl=").append(photoUrl);
        sb.append(", name=").append(name);
        sb.append(", type=").append(type);
        sb.append(", roleName=").append(roleName);
        sb.append(", rolePermission=").append(rolePermission);
        sb.append(", gender=").append(gender);
        sb.append(", contact=").append(contact);
        sb.append(", identityNum=").append(identityNum);
        sb.append(", identityImg=").append(identityImg);
        sb.append(", insurancePurchases=").append(insurancePurchases);
        sb.append(", salaryDetails=").append(salaryDetails);
        sb.append(", address=").append(address);
        sb.append(", status=").append(status);
        sb.append(", itemId=").append(itemId);
        sb.append(", itemName=").append(itemName);
        sb.append(", professionalUnit=").append(professionalUnit);
        sb.append(", blackFlag=").append(blackFlag);
        sb.append(", createUserName=").append(createUserName);
        sb.append(", createBy=").append(createBy);
        sb.append(", createDate=").append(createDate);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}