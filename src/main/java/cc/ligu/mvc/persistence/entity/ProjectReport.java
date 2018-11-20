package cc.ligu.mvc.persistence.entity;

import java.io.Serializable;
import java.util.List;

public class ProjectReport implements Serializable {
    /**
     * 主键
     */
    private Integer id;

    /**
     * 工程全名
     */
    private String projectName;

    /**
     * 工程简称
     */
    private String projectSimpleName;

    /**
     * 工程报告图片
     */
    private String projectPic;

    /**
     * 工程完成描述
     */
    private String projectDesc;

    /**
     * 工程附件1,工程附件2
     */
    private String projectAttach;

    /**
     * 工程负责人1,工程负责人2
     */
    private String manager;

    /**
     * 工程责任公司/项目组名称
     */
    private String company;

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
     * project_report
     */
    private static final long serialVersionUID = 1L;

    private List<String> picList;
    private List<String> attchList;

    public List<String> getPicList() {
        return picList;
    }

    public ProjectReport setPicList(List<String> picList) {
        this.picList = picList;
        return this;
    }

    public List<String> getAttchList() {
        return attchList;
    }

    public ProjectReport setAttchList(List<String> attchList) {
        this.attchList = attchList;
        return this;
    }

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
     * 获取工程全名
     * @return project_name 工程全名
     */
    public String getProjectName() {
        return projectName;
    }

    /**
     * 设置工程全名
     * @param projectName 工程全名
     */
    public void setProjectName(String projectName) {
        this.projectName = projectName == null ? null : projectName.trim();
    }

    /**
     * 获取工程简称
     * @return project_simple_name 工程简称
     */
    public String getProjectSimpleName() {
        return projectSimpleName;
    }

    /**
     * 设置工程简称
     * @param projectSimpleName 工程简称
     */
    public void setProjectSimpleName(String projectSimpleName) {
        this.projectSimpleName = projectSimpleName == null ? null : projectSimpleName.trim();
    }

    /**
     * 获取工程报告图片
     * @return project_pic 工程报告图片
     */
    public String getProjectPic() {
        return projectPic;
    }

    /**
     * 设置工程报告图片
     * @param projectPic 工程报告图片
     */
    public void setProjectPic(String projectPic) {
        this.projectPic = projectPic == null ? null : projectPic.trim();
    }

    /**
     * 获取工程完成描述
     * @return project_desc 工程完成描述
     */
    public String getProjectDesc() {
        return projectDesc;
    }

    /**
     * 设置工程完成描述
     * @param projectDesc 工程完成描述
     */
    public void setProjectDesc(String projectDesc) {
        this.projectDesc = projectDesc == null ? null : projectDesc.trim();
    }

    /**
     * 获取工程附件1,工程附件2
     * @return project_attach 工程附件1,工程附件2
     */
    public String getProjectAttach() {
        return projectAttach;
    }

    /**
     * 设置工程附件1,工程附件2
     * @param projectAttach 工程附件1,工程附件2
     */
    public void setProjectAttach(String projectAttach) {
        this.projectAttach = projectAttach == null ? null : projectAttach.trim();
    }

    /**
     * 获取工程负责人1,工程负责人2
     * @return manager 工程负责人1,工程负责人2
     */
    public String getManager() {
        return manager;
    }

    /**
     * 设置工程负责人1,工程负责人2
     * @param manager 工程负责人1,工程负责人2
     */
    public void setManager(String manager) {
        this.manager = manager == null ? null : manager.trim();
    }

    /**
     * 获取工程责任公司/项目组名称
     * @return company 工程责任公司/项目组名称
     */
    public String getCompany() {
        return company;
    }

    /**
     * 设置工程责任公司/项目组名称
     * @param company 工程责任公司/项目组名称
     */
    public void setCompany(String company) {
        this.company = company == null ? null : company.trim();
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
        ProjectReport other = (ProjectReport) that;
        return (this.getId() == null ? other.getId() == null : this.getId().equals(other.getId()))
            && (this.getProjectName() == null ? other.getProjectName() == null : this.getProjectName().equals(other.getProjectName()))
            && (this.getProjectSimpleName() == null ? other.getProjectSimpleName() == null : this.getProjectSimpleName().equals(other.getProjectSimpleName()))
            && (this.getProjectPic() == null ? other.getProjectPic() == null : this.getProjectPic().equals(other.getProjectPic()))
            && (this.getProjectDesc() == null ? other.getProjectDesc() == null : this.getProjectDesc().equals(other.getProjectDesc()))
            && (this.getProjectAttach() == null ? other.getProjectAttach() == null : this.getProjectAttach().equals(other.getProjectAttach()))
            && (this.getManager() == null ? other.getManager() == null : this.getManager().equals(other.getManager()))
            && (this.getCompany() == null ? other.getCompany() == null : this.getCompany().equals(other.getCompany()))
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
        result = prime * result + ((getProjectName() == null) ? 0 : getProjectName().hashCode());
        result = prime * result + ((getProjectSimpleName() == null) ? 0 : getProjectSimpleName().hashCode());
        result = prime * result + ((getProjectPic() == null) ? 0 : getProjectPic().hashCode());
        result = prime * result + ((getProjectDesc() == null) ? 0 : getProjectDesc().hashCode());
        result = prime * result + ((getProjectAttach() == null) ? 0 : getProjectAttach().hashCode());
        result = prime * result + ((getManager() == null) ? 0 : getManager().hashCode());
        result = prime * result + ((getCompany() == null) ? 0 : getCompany().hashCode());
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
        sb.append(", projectName=").append(projectName);
        sb.append(", projectSimpleName=").append(projectSimpleName);
        sb.append(", projectPic=").append(projectPic);
        sb.append(", projectDesc=").append(projectDesc);
        sb.append(", projectAttach=").append(projectAttach);
        sb.append(", manager=").append(manager);
        sb.append(", company=").append(company);
        sb.append(", createDate=").append(createDate);
        sb.append(", createBy=").append(createBy);
        sb.append(", updateDate=").append(updateDate);
        sb.append(", updateBy=").append(updateBy);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}