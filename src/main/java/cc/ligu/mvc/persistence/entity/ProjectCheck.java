package cc.ligu.mvc.persistence.entity;

import java.io.Serializable;

public class ProjectCheck implements Serializable {
    /**
     * 
     */
    private Integer id;

    /**
     * 关联project_info的id
     */
    private Integer projectId;

    /**
     * 工程地点
     */
    private String location;

    /**
     * 工程状态[在建,整改,完成]
     */
    private String status;

    /**
     * 巡检时间
     */
    private Long checkTime;

    /**
     * 巡检人员
     */
    private String checkPerson;

    /**
     * 监理人员
     */
    private String managePerson;

    /**
     * 处理方式[整改,无]
     */
    private String dealWay;

    /**
     * 现场情况说明
     */
    private String localDesc;

    /**
     * 现场照片
     */
    private String localPics;

    /**
     * project_check
     */
    private static final long serialVersionUID = 1L;

    /**
     * 获取
     * @return id 
     */
    public Integer getId() {
        return id;
    }

    /**
     * 设置
     * @param id 
     */
    public void setId(Integer id) {
        this.id = id;
    }

    /**
     * 获取关联project_info的id
     * @return project_id 关联project_info的id
     */
    public Integer getProjectId() {
        return projectId;
    }

    /**
     * 设置关联project_info的id
     * @param projectId 关联project_info的id
     */
    public void setProjectId(Integer projectId) {
        this.projectId = projectId;
    }

    /**
     * 获取工程地点
     * @return location 工程地点
     */
    public String getLocation() {
        return location;
    }

    /**
     * 设置工程地点
     * @param location 工程地点
     */
    public void setLocation(String location) {
        this.location = location == null ? null : location.trim();
    }

    /**
     * 获取工程状态[在建,整改,完成]
     * @return status 工程状态[在建,整改,完成]
     */
    public String getStatus() {
        return status;
    }

    /**
     * 设置工程状态[在建,整改,完成]
     * @param status 工程状态[在建,整改,完成]
     */
    public void setStatus(String status) {
        this.status = status == null ? null : status.trim();
    }

    /**
     * 获取巡检时间
     * @return check_time 巡检时间
     */
    public Long getCheckTime() {
        return checkTime;
    }

    /**
     * 设置巡检时间
     * @param checkTime 巡检时间
     */
    public void setCheckTime(Long checkTime) {
        this.checkTime = checkTime;
    }

    /**
     * 获取巡检人员
     * @return check_person 巡检人员
     */
    public String getCheckPerson() {
        return checkPerson;
    }

    /**
     * 设置巡检人员
     * @param checkPerson 巡检人员
     */
    public void setCheckPerson(String checkPerson) {
        this.checkPerson = checkPerson == null ? null : checkPerson.trim();
    }

    /**
     * 获取监理人员
     * @return manage_person 监理人员
     */
    public String getManagePerson() {
        return managePerson;
    }

    /**
     * 设置监理人员
     * @param managePerson 监理人员
     */
    public void setManagePerson(String managePerson) {
        this.managePerson = managePerson == null ? null : managePerson.trim();
    }

    /**
     * 获取处理方式[整改,无]
     * @return deal_way 处理方式[整改,无]
     */
    public String getDealWay() {
        return dealWay;
    }

    /**
     * 设置处理方式[整改,无]
     * @param dealWay 处理方式[整改,无]
     */
    public void setDealWay(String dealWay) {
        this.dealWay = dealWay == null ? null : dealWay.trim();
    }

    /**
     * 获取现场情况说明
     * @return local_desc 现场情况说明
     */
    public String getLocalDesc() {
        return localDesc;
    }

    /**
     * 设置现场情况说明
     * @param localDesc 现场情况说明
     */
    public void setLocalDesc(String localDesc) {
        this.localDesc = localDesc == null ? null : localDesc.trim();
    }

    /**
     * 获取现场照片
     * @return local_pics 现场照片
     */
    public String getLocalPics() {
        return localPics;
    }

    /**
     * 设置现场照片
     * @param localPics 现场照片
     */
    public void setLocalPics(String localPics) {
        this.localPics = localPics == null ? null : localPics.trim();
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
        ProjectCheck other = (ProjectCheck) that;
        return (this.getId() == null ? other.getId() == null : this.getId().equals(other.getId()))
            && (this.getProjectId() == null ? other.getProjectId() == null : this.getProjectId().equals(other.getProjectId()))
            && (this.getLocation() == null ? other.getLocation() == null : this.getLocation().equals(other.getLocation()))
            && (this.getStatus() == null ? other.getStatus() == null : this.getStatus().equals(other.getStatus()))
            && (this.getCheckTime() == null ? other.getCheckTime() == null : this.getCheckTime().equals(other.getCheckTime()))
            && (this.getCheckPerson() == null ? other.getCheckPerson() == null : this.getCheckPerson().equals(other.getCheckPerson()))
            && (this.getManagePerson() == null ? other.getManagePerson() == null : this.getManagePerson().equals(other.getManagePerson()))
            && (this.getDealWay() == null ? other.getDealWay() == null : this.getDealWay().equals(other.getDealWay()))
            && (this.getLocalDesc() == null ? other.getLocalDesc() == null : this.getLocalDesc().equals(other.getLocalDesc()))
            && (this.getLocalPics() == null ? other.getLocalPics() == null : this.getLocalPics().equals(other.getLocalPics()));
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((getId() == null) ? 0 : getId().hashCode());
        result = prime * result + ((getProjectId() == null) ? 0 : getProjectId().hashCode());
        result = prime * result + ((getLocation() == null) ? 0 : getLocation().hashCode());
        result = prime * result + ((getStatus() == null) ? 0 : getStatus().hashCode());
        result = prime * result + ((getCheckTime() == null) ? 0 : getCheckTime().hashCode());
        result = prime * result + ((getCheckPerson() == null) ? 0 : getCheckPerson().hashCode());
        result = prime * result + ((getManagePerson() == null) ? 0 : getManagePerson().hashCode());
        result = prime * result + ((getDealWay() == null) ? 0 : getDealWay().hashCode());
        result = prime * result + ((getLocalDesc() == null) ? 0 : getLocalDesc().hashCode());
        result = prime * result + ((getLocalPics() == null) ? 0 : getLocalPics().hashCode());
        return result;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", id=").append(id);
        sb.append(", projectId=").append(projectId);
        sb.append(", location=").append(location);
        sb.append(", status=").append(status);
        sb.append(", checkTime=").append(checkTime);
        sb.append(", checkPerson=").append(checkPerson);
        sb.append(", managePerson=").append(managePerson);
        sb.append(", dealWay=").append(dealWay);
        sb.append(", localDesc=").append(localDesc);
        sb.append(", localPics=").append(localPics);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}