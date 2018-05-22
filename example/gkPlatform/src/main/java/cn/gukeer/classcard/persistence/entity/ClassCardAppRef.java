package cn.gukeer.classcard.persistence.entity;

import java.io.Serializable;

public class ClassCardAppRef implements Serializable {
    private String id;

    private String classCardId;

    private String classCardAppId;

    private String schoolId;

    private Integer delFlag;

    private Long createDate;

    private Long updateDate;

    private String createBy;

    private String updateBy;

    private Long feedBackTime;

    private Integer feedBackStatus;

    private String feedBackRemarks;

    private Integer uninstallStatus;

    private static final long serialVersionUID = 1L;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id == null ? null : id.trim();
    }

    public String getClassCardId() {
        return classCardId;
    }

    public void setClassCardId(String classCardId) {
        this.classCardId = classCardId == null ? null : classCardId.trim();
    }

    public String getClassCardAppId() {
        return classCardAppId;
    }

    public void setClassCardAppId(String classCardAppId) {
        this.classCardAppId = classCardAppId == null ? null : classCardAppId.trim();
    }

    public String getSchoolId() {
        return schoolId;
    }

    public void setSchoolId(String schoolId) {
        this.schoolId = schoolId == null ? null : schoolId.trim();
    }

    public Integer getDelFlag() {
        return delFlag;
    }

    public void setDelFlag(Integer delFlag) {
        this.delFlag = delFlag;
    }

    public Long getCreateDate() {
        return createDate;
    }

    public void setCreateDate(Long createDate) {
        this.createDate = createDate;
    }

    public Long getUpdateDate() {
        return updateDate;
    }

    public void setUpdateDate(Long updateDate) {
        this.updateDate = updateDate;
    }

    public String getCreateBy() {
        return createBy;
    }

    public void setCreateBy(String createBy) {
        this.createBy = createBy == null ? null : createBy.trim();
    }

    public String getUpdateBy() {
        return updateBy;
    }

    public void setUpdateBy(String updateBy) {
        this.updateBy = updateBy == null ? null : updateBy.trim();
    }

    public Long getFeedBackTime() {
        return feedBackTime;
    }

    public void setFeedBackTime(Long feedBackTime) {
        this.feedBackTime = feedBackTime;
    }

    public Integer getFeedBackStatus() {
        return feedBackStatus;
    }

    public void setFeedBackStatus(Integer feedBackStatus) {
        this.feedBackStatus = feedBackStatus;
    }

    public String getFeedBackRemarks() {
        return feedBackRemarks;
    }

    public void setFeedBackRemarks(String feedBackRemarks) {
        this.feedBackRemarks = feedBackRemarks == null ? null : feedBackRemarks.trim();
    }

    public Integer getUninstallStatus() {
        return uninstallStatus;
    }

    public void setUninstallStatus(Integer uninstallStatus) {
        this.uninstallStatus = uninstallStatus;
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
        ClassCardAppRef other = (ClassCardAppRef) that;
        return (this.getId() == null ? other.getId() == null : this.getId().equals(other.getId()))
            && (this.getClassCardId() == null ? other.getClassCardId() == null : this.getClassCardId().equals(other.getClassCardId()))
            && (this.getClassCardAppId() == null ? other.getClassCardAppId() == null : this.getClassCardAppId().equals(other.getClassCardAppId()))
            && (this.getSchoolId() == null ? other.getSchoolId() == null : this.getSchoolId().equals(other.getSchoolId()))
            && (this.getDelFlag() == null ? other.getDelFlag() == null : this.getDelFlag().equals(other.getDelFlag()))
            && (this.getCreateDate() == null ? other.getCreateDate() == null : this.getCreateDate().equals(other.getCreateDate()))
            && (this.getUpdateDate() == null ? other.getUpdateDate() == null : this.getUpdateDate().equals(other.getUpdateDate()))
            && (this.getCreateBy() == null ? other.getCreateBy() == null : this.getCreateBy().equals(other.getCreateBy()))
            && (this.getUpdateBy() == null ? other.getUpdateBy() == null : this.getUpdateBy().equals(other.getUpdateBy()))
            && (this.getFeedBackTime() == null ? other.getFeedBackTime() == null : this.getFeedBackTime().equals(other.getFeedBackTime()))
            && (this.getFeedBackStatus() == null ? other.getFeedBackStatus() == null : this.getFeedBackStatus().equals(other.getFeedBackStatus()))
            && (this.getFeedBackRemarks() == null ? other.getFeedBackRemarks() == null : this.getFeedBackRemarks().equals(other.getFeedBackRemarks()))
            && (this.getUninstallStatus() == null ? other.getUninstallStatus() == null : this.getUninstallStatus().equals(other.getUninstallStatus()));
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((getId() == null) ? 0 : getId().hashCode());
        result = prime * result + ((getClassCardId() == null) ? 0 : getClassCardId().hashCode());
        result = prime * result + ((getClassCardAppId() == null) ? 0 : getClassCardAppId().hashCode());
        result = prime * result + ((getSchoolId() == null) ? 0 : getSchoolId().hashCode());
        result = prime * result + ((getDelFlag() == null) ? 0 : getDelFlag().hashCode());
        result = prime * result + ((getCreateDate() == null) ? 0 : getCreateDate().hashCode());
        result = prime * result + ((getUpdateDate() == null) ? 0 : getUpdateDate().hashCode());
        result = prime * result + ((getCreateBy() == null) ? 0 : getCreateBy().hashCode());
        result = prime * result + ((getUpdateBy() == null) ? 0 : getUpdateBy().hashCode());
        result = prime * result + ((getFeedBackTime() == null) ? 0 : getFeedBackTime().hashCode());
        result = prime * result + ((getFeedBackStatus() == null) ? 0 : getFeedBackStatus().hashCode());
        result = prime * result + ((getFeedBackRemarks() == null) ? 0 : getFeedBackRemarks().hashCode());
        result = prime * result + ((getUninstallStatus() == null) ? 0 : getUninstallStatus().hashCode());
        return result;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", id=").append(id);
        sb.append(", classCardId=").append(classCardId);
        sb.append(", classCardAppId=").append(classCardAppId);
        sb.append(", schoolId=").append(schoolId);
        sb.append(", delFlag=").append(delFlag);
        sb.append(", createDate=").append(createDate);
        sb.append(", updateDate=").append(updateDate);
        sb.append(", createBy=").append(createBy);
        sb.append(", updateBy=").append(updateBy);
        sb.append(", feedBackTime=").append(feedBackTime);
        sb.append(", feedBackStatus=").append(feedBackStatus);
        sb.append(", feedBackRemarks=").append(feedBackRemarks);
        sb.append(", uninstallStatus=").append(uninstallStatus);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}