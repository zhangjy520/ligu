package cc.ligu.mvc.persistence.entity;

import java.io.Serializable;

public class Item implements Serializable {
    /**
     * 主键ID
     */
    private Integer id;

    /**
     * 父项目ID
     */
    private Integer parentId;

    /**
     * 项目名称
     */
    private String name;

    /**
     * 项目排序
     */
    private Integer sort;

    /**
     * 项目编号
     */
    private String code;

    /**
     * 项目类型
     */
    private Integer type;

    /**
     * 项目等级
     */
    private Integer grade;

    /**
     * 负责人id,关联oa_person主键
     */
    private Integer master;

    /**
     * 负责人姓名
     */
    private String masterName;

    /**
     * 施工单位名称
     */
    private String companyName;

    /**
     * 项目标识,唯一
     */
    private String itemFlag;

    /**
     * 项目周期
     */
    private String itemCycle;

    /**
     * 创建时间
     */
    private Long createDate;

    /**
     * 更新者
     */
    private Integer updateBy;

    /**
     * 更新时间
     */
    private Long updateDate;

    /**
     * 逻辑删除标记（0：显示；1：隐藏）
     */
    private Integer delFlag;

    /**
     * 备注信息
     */
    private String remarks;

    /**
     * 创建者
     */
    private Integer createBy;

    /**
     * oa_item
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
     * 获取父项目ID
     * @return parent_id 父项目ID
     */
    public Integer getParentId() {
        return parentId;
    }

    /**
     * 设置父项目ID
     * @param parentId 父项目ID
     */
    public void setParentId(Integer parentId) {
        this.parentId = parentId;
    }

    /**
     * 获取项目名称
     * @return name 项目名称
     */
    public String getName() {
        return name;
    }

    /**
     * 设置项目名称
     * @param name 项目名称
     */
    public void setName(String name) {
        this.name = name == null ? null : name.trim();
    }

    /**
     * 获取项目排序
     * @return sort 项目排序
     */
    public Integer getSort() {
        return sort;
    }

    /**
     * 设置项目排序
     * @param sort 项目排序
     */
    public void setSort(Integer sort) {
        this.sort = sort;
    }

    /**
     * 获取项目编号
     * @return code 项目编号
     */
    public String getCode() {
        return code;
    }

    /**
     * 设置项目编号
     * @param code 项目编号
     */
    public void setCode(String code) {
        this.code = code == null ? null : code.trim();
    }

    /**
     * 获取项目类型
     * @return type 项目类型
     */
    public Integer getType() {
        return type;
    }

    /**
     * 设置项目类型
     * @param type 项目类型
     */
    public void setType(Integer type) {
        this.type = type;
    }

    /**
     * 获取项目等级
     * @return grade 项目等级
     */
    public Integer getGrade() {
        return grade;
    }

    /**
     * 设置项目等级
     * @param grade 项目等级
     */
    public void setGrade(Integer grade) {
        this.grade = grade;
    }

    /**
     * 获取负责人id,关联oa_person主键
     * @return master 负责人id,关联oa_person主键
     */
    public Integer getMaster() {
        return master;
    }

    /**
     * 设置负责人id,关联oa_person主键
     * @param master 负责人id,关联oa_person主键
     */
    public void setMaster(Integer master) {
        this.master = master;
    }

    /**
     * 获取负责人姓名
     * @return master_name 负责人姓名
     */
    public String getMasterName() {
        return masterName;
    }

    /**
     * 设置负责人姓名
     * @param masterName 负责人姓名
     */
    public void setMasterName(String masterName) {
        this.masterName = masterName == null ? null : masterName.trim();
    }

    /**
     * 获取施工单位名称
     * @return company_name 施工单位名称
     */
    public String getCompanyName() {
        return companyName;
    }

    /**
     * 设置施工单位名称
     * @param companyName 施工单位名称
     */
    public void setCompanyName(String companyName) {
        this.companyName = companyName == null ? null : companyName.trim();
    }

    /**
     * 获取项目标识,唯一
     * @return item_flag 项目标识,唯一
     */
    public String getItemFlag() {
        return itemFlag;
    }

    /**
     * 设置项目标识,唯一
     * @param itemFlag 项目标识,唯一
     */
    public void setItemFlag(String itemFlag) {
        this.itemFlag = itemFlag == null ? null : itemFlag.trim();
    }

    /**
     * 获取项目周期
     * @return item_cycle 项目周期
     */
    public String getItemCycle() {
        return itemCycle;
    }

    /**
     * 设置项目周期
     * @param itemCycle 项目周期
     */
    public void setItemCycle(String itemCycle) {
        this.itemCycle = itemCycle == null ? null : itemCycle.trim();
    }

    /**
     * 获取创建时间
     * @return create_date 创建时间
     */
    public Long getCreateDate() {
        return createDate;
    }

    /**
     * 设置创建时间
     * @param createDate 创建时间
     */
    public void setCreateDate(Long createDate) {
        this.createDate = createDate;
    }

    /**
     * 获取更新者
     * @return update_by 更新者
     */
    public Integer getUpdateBy() {
        return updateBy;
    }

    /**
     * 设置更新者
     * @param updateBy 更新者
     */
    public void setUpdateBy(Integer updateBy) {
        this.updateBy = updateBy;
    }

    /**
     * 获取更新时间
     * @return update_date 更新时间
     */
    public Long getUpdateDate() {
        return updateDate;
    }

    /**
     * 设置更新时间
     * @param updateDate 更新时间
     */
    public void setUpdateDate(Long updateDate) {
        this.updateDate = updateDate;
    }

    /**
     * 获取逻辑删除标记（0：显示；1：隐藏）
     * @return del_flag 逻辑删除标记（0：显示；1：隐藏）
     */
    public Integer getDelFlag() {
        return delFlag;
    }

    /**
     * 设置逻辑删除标记（0：显示；1：隐藏）
     * @param delFlag 逻辑删除标记（0：显示；1：隐藏）
     */
    public void setDelFlag(Integer delFlag) {
        this.delFlag = delFlag;
    }

    /**
     * 获取备注信息
     * @return remarks 备注信息
     */
    public String getRemarks() {
        return remarks;
    }

    /**
     * 设置备注信息
     * @param remarks 备注信息
     */
    public void setRemarks(String remarks) {
        this.remarks = remarks == null ? null : remarks.trim();
    }

    /**
     * 获取创建者
     * @return create_by 创建者
     */
    public Integer getCreateBy() {
        return createBy;
    }

    /**
     * 设置创建者
     * @param createBy 创建者
     */
    public void setCreateBy(Integer createBy) {
        this.createBy = createBy;
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
        Item other = (Item) that;
        return (this.getId() == null ? other.getId() == null : this.getId().equals(other.getId()))
            && (this.getParentId() == null ? other.getParentId() == null : this.getParentId().equals(other.getParentId()))
            && (this.getName() == null ? other.getName() == null : this.getName().equals(other.getName()))
            && (this.getSort() == null ? other.getSort() == null : this.getSort().equals(other.getSort()))
            && (this.getCode() == null ? other.getCode() == null : this.getCode().equals(other.getCode()))
            && (this.getType() == null ? other.getType() == null : this.getType().equals(other.getType()))
            && (this.getGrade() == null ? other.getGrade() == null : this.getGrade().equals(other.getGrade()))
            && (this.getMaster() == null ? other.getMaster() == null : this.getMaster().equals(other.getMaster()))
            && (this.getMasterName() == null ? other.getMasterName() == null : this.getMasterName().equals(other.getMasterName()))
            && (this.getCompanyName() == null ? other.getCompanyName() == null : this.getCompanyName().equals(other.getCompanyName()))
            && (this.getItemFlag() == null ? other.getItemFlag() == null : this.getItemFlag().equals(other.getItemFlag()))
            && (this.getItemCycle() == null ? other.getItemCycle() == null : this.getItemCycle().equals(other.getItemCycle()))
            && (this.getCreateDate() == null ? other.getCreateDate() == null : this.getCreateDate().equals(other.getCreateDate()))
            && (this.getUpdateBy() == null ? other.getUpdateBy() == null : this.getUpdateBy().equals(other.getUpdateBy()))
            && (this.getUpdateDate() == null ? other.getUpdateDate() == null : this.getUpdateDate().equals(other.getUpdateDate()))
            && (this.getDelFlag() == null ? other.getDelFlag() == null : this.getDelFlag().equals(other.getDelFlag()))
            && (this.getRemarks() == null ? other.getRemarks() == null : this.getRemarks().equals(other.getRemarks()))
            && (this.getCreateBy() == null ? other.getCreateBy() == null : this.getCreateBy().equals(other.getCreateBy()));
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((getId() == null) ? 0 : getId().hashCode());
        result = prime * result + ((getParentId() == null) ? 0 : getParentId().hashCode());
        result = prime * result + ((getName() == null) ? 0 : getName().hashCode());
        result = prime * result + ((getSort() == null) ? 0 : getSort().hashCode());
        result = prime * result + ((getCode() == null) ? 0 : getCode().hashCode());
        result = prime * result + ((getType() == null) ? 0 : getType().hashCode());
        result = prime * result + ((getGrade() == null) ? 0 : getGrade().hashCode());
        result = prime * result + ((getMaster() == null) ? 0 : getMaster().hashCode());
        result = prime * result + ((getMasterName() == null) ? 0 : getMasterName().hashCode());
        result = prime * result + ((getCompanyName() == null) ? 0 : getCompanyName().hashCode());
        result = prime * result + ((getItemFlag() == null) ? 0 : getItemFlag().hashCode());
        result = prime * result + ((getItemCycle() == null) ? 0 : getItemCycle().hashCode());
        result = prime * result + ((getCreateDate() == null) ? 0 : getCreateDate().hashCode());
        result = prime * result + ((getUpdateBy() == null) ? 0 : getUpdateBy().hashCode());
        result = prime * result + ((getUpdateDate() == null) ? 0 : getUpdateDate().hashCode());
        result = prime * result + ((getDelFlag() == null) ? 0 : getDelFlag().hashCode());
        result = prime * result + ((getRemarks() == null) ? 0 : getRemarks().hashCode());
        result = prime * result + ((getCreateBy() == null) ? 0 : getCreateBy().hashCode());
        return result;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", id=").append(id);
        sb.append(", parentId=").append(parentId);
        sb.append(", name=").append(name);
        sb.append(", sort=").append(sort);
        sb.append(", code=").append(code);
        sb.append(", type=").append(type);
        sb.append(", grade=").append(grade);
        sb.append(", master=").append(master);
        sb.append(", masterName=").append(masterName);
        sb.append(", companyName=").append(companyName);
        sb.append(", itemFlag=").append(itemFlag);
        sb.append(", itemCycle=").append(itemCycle);
        sb.append(", createDate=").append(createDate);
        sb.append(", updateBy=").append(updateBy);
        sb.append(", updateDate=").append(updateDate);
        sb.append(", delFlag=").append(delFlag);
        sb.append(", remarks=").append(remarks);
        sb.append(", createBy=").append(createBy);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}