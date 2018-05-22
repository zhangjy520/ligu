package cn.gukeer.platform.persistence.entity;

import java.io.Serializable;

public class NetDiskShareLink implements Serializable {
    private String id;

    private String schoolId;

    private String teacherId;

    private String link;

    private String sharedTeacherId;

    private Integer shareType;

    private String fileName;

    private Boolean isDir;

    private Integer expireDate;

    private String token;

    private Boolean canPreview;

    private Boolean canDownlod;

    private Boolean isExpired;

    private String email;

    private String path;

    private String repoName;

    private Long createTime;

    private String timeStrCreate;

    private String timeStrUpdate;

    private String fileSize;

    private static final long serialVersionUID = 1L;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id == null ? null : id.trim();
    }

    public String getSchoolId() {
        return schoolId;
    }

    public void setSchoolId(String schoolId) {
        this.schoolId = schoolId == null ? null : schoolId.trim();
    }

    public String getTeacherId() {
        return teacherId;
    }

    public void setTeacherId(String teacherId) {
        this.teacherId = teacherId == null ? null : teacherId.trim();
    }

    public String getLink() {
        return link;
    }

    public void setLink(String link) {
        this.link = link == null ? null : link.trim();
    }

    public String getSharedTeacherId() {
        return sharedTeacherId;
    }

    public void setSharedTeacherId(String sharedTeacherId) {
        this.sharedTeacherId = sharedTeacherId == null ? null : sharedTeacherId.trim();
    }

    public Integer getShareType() {
        return shareType;
    }

    public void setShareType(Integer shareType) {
        this.shareType = shareType;
    }

    public String getFileName() {
        return fileName;
    }

    public void setFileName(String fileName) {
        this.fileName = fileName == null ? null : fileName.trim();
    }

    public Boolean getIsDir() {
        return isDir;
    }

    public void setIsDir(Boolean isDir) {
        this.isDir = isDir;
    }

    public Integer getExpireDate() {
        return expireDate;
    }

    public void setExpireDate(Integer expireDate) {
        this.expireDate = expireDate;
    }

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token == null ? null : token.trim();
    }

    public Boolean getCanPreview() {
        return canPreview;
    }

    public void setCanPreview(Boolean canPreview) {
        this.canPreview = canPreview;
    }

    public Boolean getCanDownlod() {
        return canDownlod;
    }

    public void setCanDownlod(Boolean canDownlod) {
        this.canDownlod = canDownlod;
    }

    public Boolean getIsExpired() {
        return isExpired;
    }

    public void setIsExpired(Boolean isExpired) {
        this.isExpired = isExpired;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email == null ? null : email.trim();
    }

    public String getPath() {
        return path;
    }

    public void setPath(String path) {
        this.path = path == null ? null : path.trim();
    }

    public String getRepoName() {
        return repoName;
    }

    public void setRepoName(String repoName) {
        this.repoName = repoName == null ? null : repoName.trim();
    }

    public Long getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Long createTime) {
        this.createTime = createTime;
    }

    public String getTimeStrCreate() {
        return timeStrCreate;
    }

    public void setTimeStrCreate(String timeStrCreate) {
        this.timeStrCreate = timeStrCreate == null ? null : timeStrCreate.trim();
    }

    public String getTimeStrUpdate() {
        return timeStrUpdate;
    }

    public void setTimeStrUpdate(String timeStrUpdate) {
        this.timeStrUpdate = timeStrUpdate == null ? null : timeStrUpdate.trim();
    }

    public String getFileSize() {
        return fileSize;
    }

    public void setFileSize(String fileSize) {
        this.fileSize = fileSize == null ? null : fileSize.trim();
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
        NetDiskShareLink other = (NetDiskShareLink) that;
        return (this.getId() == null ? other.getId() == null : this.getId().equals(other.getId()))
            && (this.getSchoolId() == null ? other.getSchoolId() == null : this.getSchoolId().equals(other.getSchoolId()))
            && (this.getTeacherId() == null ? other.getTeacherId() == null : this.getTeacherId().equals(other.getTeacherId()))
            && (this.getLink() == null ? other.getLink() == null : this.getLink().equals(other.getLink()))
            && (this.getSharedTeacherId() == null ? other.getSharedTeacherId() == null : this.getSharedTeacherId().equals(other.getSharedTeacherId()))
            && (this.getShareType() == null ? other.getShareType() == null : this.getShareType().equals(other.getShareType()))
            && (this.getFileName() == null ? other.getFileName() == null : this.getFileName().equals(other.getFileName()))
            && (this.getIsDir() == null ? other.getIsDir() == null : this.getIsDir().equals(other.getIsDir()))
            && (this.getExpireDate() == null ? other.getExpireDate() == null : this.getExpireDate().equals(other.getExpireDate()))
            && (this.getToken() == null ? other.getToken() == null : this.getToken().equals(other.getToken()))
            && (this.getCanPreview() == null ? other.getCanPreview() == null : this.getCanPreview().equals(other.getCanPreview()))
            && (this.getCanDownlod() == null ? other.getCanDownlod() == null : this.getCanDownlod().equals(other.getCanDownlod()))
            && (this.getIsExpired() == null ? other.getIsExpired() == null : this.getIsExpired().equals(other.getIsExpired()))
            && (this.getEmail() == null ? other.getEmail() == null : this.getEmail().equals(other.getEmail()))
            && (this.getPath() == null ? other.getPath() == null : this.getPath().equals(other.getPath()))
            && (this.getRepoName() == null ? other.getRepoName() == null : this.getRepoName().equals(other.getRepoName()))
            && (this.getCreateTime() == null ? other.getCreateTime() == null : this.getCreateTime().equals(other.getCreateTime()))
            && (this.getTimeStrCreate() == null ? other.getTimeStrCreate() == null : this.getTimeStrCreate().equals(other.getTimeStrCreate()))
            && (this.getTimeStrUpdate() == null ? other.getTimeStrUpdate() == null : this.getTimeStrUpdate().equals(other.getTimeStrUpdate()))
            && (this.getFileSize() == null ? other.getFileSize() == null : this.getFileSize().equals(other.getFileSize()));
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((getId() == null) ? 0 : getId().hashCode());
        result = prime * result + ((getSchoolId() == null) ? 0 : getSchoolId().hashCode());
        result = prime * result + ((getTeacherId() == null) ? 0 : getTeacherId().hashCode());
        result = prime * result + ((getLink() == null) ? 0 : getLink().hashCode());
        result = prime * result + ((getSharedTeacherId() == null) ? 0 : getSharedTeacherId().hashCode());
        result = prime * result + ((getShareType() == null) ? 0 : getShareType().hashCode());
        result = prime * result + ((getFileName() == null) ? 0 : getFileName().hashCode());
        result = prime * result + ((getIsDir() == null) ? 0 : getIsDir().hashCode());
        result = prime * result + ((getExpireDate() == null) ? 0 : getExpireDate().hashCode());
        result = prime * result + ((getToken() == null) ? 0 : getToken().hashCode());
        result = prime * result + ((getCanPreview() == null) ? 0 : getCanPreview().hashCode());
        result = prime * result + ((getCanDownlod() == null) ? 0 : getCanDownlod().hashCode());
        result = prime * result + ((getIsExpired() == null) ? 0 : getIsExpired().hashCode());
        result = prime * result + ((getEmail() == null) ? 0 : getEmail().hashCode());
        result = prime * result + ((getPath() == null) ? 0 : getPath().hashCode());
        result = prime * result + ((getRepoName() == null) ? 0 : getRepoName().hashCode());
        result = prime * result + ((getCreateTime() == null) ? 0 : getCreateTime().hashCode());
        result = prime * result + ((getTimeStrCreate() == null) ? 0 : getTimeStrCreate().hashCode());
        result = prime * result + ((getTimeStrUpdate() == null) ? 0 : getTimeStrUpdate().hashCode());
        result = prime * result + ((getFileSize() == null) ? 0 : getFileSize().hashCode());
        return result;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", id=").append(id);
        sb.append(", schoolId=").append(schoolId);
        sb.append(", teacherId=").append(teacherId);
        sb.append(", link=").append(link);
        sb.append(", sharedTeacherId=").append(sharedTeacherId);
        sb.append(", shareType=").append(shareType);
        sb.append(", fileName=").append(fileName);
        sb.append(", isDir=").append(isDir);
        sb.append(", expireDate=").append(expireDate);
        sb.append(", token=").append(token);
        sb.append(", canPreview=").append(canPreview);
        sb.append(", canDownlod=").append(canDownlod);
        sb.append(", isExpired=").append(isExpired);
        sb.append(", email=").append(email);
        sb.append(", path=").append(path);
        sb.append(", repoName=").append(repoName);
        sb.append(", createTime=").append(createTime);
        sb.append(", timeStrCreate=").append(timeStrCreate);
        sb.append(", timeStrUpdate=").append(timeStrUpdate);
        sb.append(", fileSize=").append(fileSize);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}