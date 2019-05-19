package cc.ligu.mvc.persistence.entity;

import cc.ligu.common.utils.excel.annotation.ExcelField;

import java.io.Serializable;

public class ProjectInfo implements Serializable {
    /**
     * 工程ID
     */
    private Integer id;

    /**
     * 工程所属区县
     */
    private String area;

    /**
     * 所属专业
     */
    private String profession;

    /**
     * 工程年份
     */
    private String projectYear;

    /**
     * 工程名称
     */
    private String projectName;

    /**
     * 施工单位名称
     */
    private String companyUnit;

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
     * project_info
     */
    private static final long serialVersionUID = 1L;

    /**
     * 获取工程ID
     * @return id 工程ID
     */
    public Integer getId() {
        return id;
    }

    /**
     * 设置工程ID
     * @param id 工程ID
     */
    public void setId(Integer id) {
        this.id = id;
    }

    /**
     * 获取工程所属区县
     * @return area 工程所属区县
     */
    @ExcelField(title = "区县", align = 2, sort = 1, groups = {1, 2}, isnull = 1)
    public String getArea() {
        return area;
    }

    /**
     * 设置工程所属区县
     * @param area 工程所属区县
     */
    public void setArea(String area) {
        this.area = area == null ? null : area.trim();
    }

    /**
     * 获取所属专业
     * @return profession 所属专业
     */
    @ExcelField(title = "专业", align = 2, sort = 4, groups = {1, 2}, isnull = 1)
    public String getProfession() {
        return profession;
    }

    /**
     * 设置所属专业
     * @param profession 所属专业
     */
    public void setProfession(String profession) {
        this.profession = profession == null ? null : profession.trim();
    }

    /**
     * 获取工程年份
     * @return project_year 工程年份
     */
    @ExcelField(title = "工程年份", align = 2, sort = 2, groups = {1, 2}, isnull = 1)
    public String getProjectYear() {
        return projectYear;
    }

    /**
     * 设置工程年份
     * @param projectYear 工程年份
     */
    public void setProjectYear(String projectYear) {
        this.projectYear = projectYear == null ? null : projectYear.trim();
    }

    /**
     * 获取工程名称
     * @return project_name 工程名称
     */
    @ExcelField(title = "工程名称", align = 2, sort = 5, groups = {1, 2}, isnull = 1)
    public String getProjectName() {
        return projectName;
    }

    /**
     * 设置工程名称
     * @param projectName 工程名称
     */
    public void setProjectName(String projectName) {
        this.projectName = projectName == null ? null : projectName.trim();
    }

    /**
     * 获取施工单位名称
     * @return company_unit 施工单位名称
     */
    @ExcelField(title = "施工单位名称", align = 2, sort = 3, groups = {1, 2}, isnull = 1)
    public String getCompanyUnit() {
        return companyUnit;
    }

    /**
     * 设置施工单位名称
     * @param companyUnit 施工单位名称
     */
    public void setCompanyUnit(String companyUnit) {
        this.companyUnit = companyUnit == null ? null : companyUnit.trim();
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
        ProjectInfo other = (ProjectInfo) that;
        return (this.getId() == null ? other.getId() == null : this.getId().equals(other.getId()))
            && (this.getArea() == null ? other.getArea() == null : this.getArea().equals(other.getArea()))
            && (this.getProfession() == null ? other.getProfession() == null : this.getProfession().equals(other.getProfession()))
            && (this.getProjectYear() == null ? other.getProjectYear() == null : this.getProjectYear().equals(other.getProjectYear()))
            && (this.getProjectName() == null ? other.getProjectName() == null : this.getProjectName().equals(other.getProjectName()))
            && (this.getCompanyUnit() == null ? other.getCompanyUnit() == null : this.getCompanyUnit().equals(other.getCompanyUnit()))
            && (this.getCreateDate() == null ? other.getCreateDate() == null : this.getCreateDate().equals(other.getCreateDate()))
            && (this.getCreateBy() == null ? other.getCreateBy() == null : this.getCreateBy().equals(other.getCreateBy()))
            && (this.getUpdateDate() == null ? other.getUpdateDate() == null : this.getUpdateDate().equals(other.getUpdateDate()))
            && (this.getUpdateBy() == null ? other.getUpdateBy() == null : this.getUpdateBy().equals(other.getUpdateBy()));
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((getId() == null) ? 0 : getId().hashCode());
        result = prime * result + ((getArea() == null) ? 0 : getArea().hashCode());
        result = prime * result + ((getProfession() == null) ? 0 : getProfession().hashCode());
        result = prime * result + ((getProjectYear() == null) ? 0 : getProjectYear().hashCode());
        result = prime * result + ((getProjectName() == null) ? 0 : getProjectName().hashCode());
        result = prime * result + ((getCompanyUnit() == null) ? 0 : getCompanyUnit().hashCode());
        result = prime * result + ((getCreateDate() == null) ? 0 : getCreateDate().hashCode());
        result = prime * result + ((getCreateBy() == null) ? 0 : getCreateBy().hashCode());
        result = prime * result + ((getUpdateDate() == null) ? 0 : getUpdateDate().hashCode());
        result = prime * result + ((getUpdateBy() == null) ? 0 : getUpdateBy().hashCode());
        return result;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", id=").append(id);
        sb.append(", area=").append(area);
        sb.append(", profession=").append(profession);
        sb.append(", projectYear=").append(projectYear);
        sb.append(", projectName=").append(projectName);
        sb.append(", companyUnit=").append(companyUnit);
        sb.append(", createDate=").append(createDate);
        sb.append(", createBy=").append(createBy);
        sb.append(", updateDate=").append(updateDate);
        sb.append(", updateBy=").append(updateBy);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}