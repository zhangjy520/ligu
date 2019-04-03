package cc.ligu.mvc.persistence.entity;

import java.io.Serializable;

public class NoticeMessage implements Serializable {
    /**
     * 消息主键
     */
    private Integer id;

    /**
     * 消息时间[时间戳]
     */
    private String noticeTime;

    /**
     * 消息类型[1薪资未发 2保险未发 3保险过期 4薪资过期 5考试消息 6其他]
     */
    private Integer type;

    /**
     * 通知发起人(person_id)
     */
    private Integer noticeFrom;

    /**
     * 通知通知人(person_id1,person_id2)
     */
    private Integer noticeTo;

    /**
     * 是否读取:[0未读 1已读]
     */
    private Integer isRead;

    /**
     * 消息标题
     */
    private String title;

    /**
     * 消息内容
     */
    private String message;

    /**
     * 消息标识(张三+考试相关通知.发过不再发)
     */
    private String flag;

    /**
     * 备注
     */
    private String remark;

    /**
     * 逻辑删除标记[0正常,1已删除,2黑名单]
     */
    private Integer delFlag;

    /**
     * notice_message
     */
    private static final long serialVersionUID = 1L;

    /**
     * 获取消息主键
     * @return id 消息主键
     */
    public Integer getId() {
        return id;
    }

    /**
     * 设置消息主键
     * @param id 消息主键
     */
    public void setId(Integer id) {
        this.id = id;
    }

    /**
     * 获取消息时间[时间戳]
     * @return notice_time 消息时间[时间戳]
     */
    public String getNoticeTime() {
        return noticeTime;
    }

    /**
     * 设置消息时间[时间戳]
     * @param noticeTime 消息时间[时间戳]
     */
    public void setNoticeTime(String noticeTime) {
        this.noticeTime = noticeTime == null ? null : noticeTime.trim();
    }

    /**
     * 获取消息类型[1薪资未发 2保险未发 3保险过期 4薪资过期 5考试消息 6其他]
     * @return type 消息类型[1薪资未发 2保险未发 3保险过期 4薪资过期 5考试消息 6其他]
     */
    public Integer getType() {
        return type;
    }

    /**
     * 设置消息类型[1薪资未发 2保险未发 3保险过期 4薪资过期 5考试消息 6其他]
     * @param type 消息类型[1薪资未发 2保险未发 3保险过期 4薪资过期 5考试消息 6其他]
     */
    public void setType(Integer type) {
        this.type = type;
    }

    /**
     * 获取通知发起人(person_id)
     * @return notice_from 通知发起人(person_id)
     */
    public Integer getNoticeFrom() {
        return noticeFrom;
    }

    /**
     * 设置通知发起人(person_id)
     * @param noticeFrom 通知发起人(person_id)
     */
    public void setNoticeFrom(Integer noticeFrom) {
        this.noticeFrom = noticeFrom;
    }

    /**
     * 获取通知通知人(person_id1,person_id2)
     * @return notice_to 通知通知人(person_id1,person_id2)
     */
    public Integer getNoticeTo() {
        return noticeTo;
    }

    /**
     * 设置通知通知人(person_id1,person_id2)
     * @param noticeTo 通知通知人(person_id1,person_id2)
     */
    public void setNoticeTo(Integer noticeTo) {
        this.noticeTo = noticeTo;
    }

    /**
     * 获取是否读取:[0未读 1已读]
     * @return is_read 是否读取:[0未读 1已读]
     */
    public Integer getIsRead() {
        return isRead;
    }

    /**
     * 设置是否读取:[0未读 1已读]
     * @param isRead 是否读取:[0未读 1已读]
     */
    public void setIsRead(Integer isRead) {
        this.isRead = isRead;
    }

    /**
     * 获取消息标题
     * @return title 消息标题
     */
    public String getTitle() {
        return title;
    }

    /**
     * 设置消息标题
     * @param title 消息标题
     */
    public void setTitle(String title) {
        this.title = title == null ? null : title.trim();
    }

    /**
     * 获取消息内容
     * @return message 消息内容
     */
    public String getMessage() {
        return message;
    }

    /**
     * 设置消息内容
     * @param message 消息内容
     */
    public void setMessage(String message) {
        this.message = message == null ? null : message.trim();
    }

    /**
     * 获取消息标识(张三+考试相关通知.发过不再发)
     * @return flag 消息标识(张三+考试相关通知.发过不再发)
     */
    public String getFlag() {
        return flag;
    }

    /**
     * 设置消息标识(张三+考试相关通知.发过不再发)
     * @param flag 消息标识(张三+考试相关通知.发过不再发)
     */
    public void setFlag(String flag) {
        this.flag = flag == null ? null : flag.trim();
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
        NoticeMessage other = (NoticeMessage) that;
        return (this.getId() == null ? other.getId() == null : this.getId().equals(other.getId()))
            && (this.getNoticeTime() == null ? other.getNoticeTime() == null : this.getNoticeTime().equals(other.getNoticeTime()))
            && (this.getType() == null ? other.getType() == null : this.getType().equals(other.getType()))
            && (this.getNoticeFrom() == null ? other.getNoticeFrom() == null : this.getNoticeFrom().equals(other.getNoticeFrom()))
            && (this.getNoticeTo() == null ? other.getNoticeTo() == null : this.getNoticeTo().equals(other.getNoticeTo()))
            && (this.getIsRead() == null ? other.getIsRead() == null : this.getIsRead().equals(other.getIsRead()))
            && (this.getTitle() == null ? other.getTitle() == null : this.getTitle().equals(other.getTitle()))
            && (this.getMessage() == null ? other.getMessage() == null : this.getMessage().equals(other.getMessage()))
            && (this.getFlag() == null ? other.getFlag() == null : this.getFlag().equals(other.getFlag()))
            && (this.getRemark() == null ? other.getRemark() == null : this.getRemark().equals(other.getRemark()))
            && (this.getDelFlag() == null ? other.getDelFlag() == null : this.getDelFlag().equals(other.getDelFlag()));
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((getId() == null) ? 0 : getId().hashCode());
        result = prime * result + ((getNoticeTime() == null) ? 0 : getNoticeTime().hashCode());
        result = prime * result + ((getType() == null) ? 0 : getType().hashCode());
        result = prime * result + ((getNoticeFrom() == null) ? 0 : getNoticeFrom().hashCode());
        result = prime * result + ((getNoticeTo() == null) ? 0 : getNoticeTo().hashCode());
        result = prime * result + ((getIsRead() == null) ? 0 : getIsRead().hashCode());
        result = prime * result + ((getTitle() == null) ? 0 : getTitle().hashCode());
        result = prime * result + ((getMessage() == null) ? 0 : getMessage().hashCode());
        result = prime * result + ((getFlag() == null) ? 0 : getFlag().hashCode());
        result = prime * result + ((getRemark() == null) ? 0 : getRemark().hashCode());
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
        sb.append(", noticeTime=").append(noticeTime);
        sb.append(", type=").append(type);
        sb.append(", noticeFrom=").append(noticeFrom);
        sb.append(", noticeTo=").append(noticeTo);
        sb.append(", isRead=").append(isRead);
        sb.append(", title=").append(title);
        sb.append(", message=").append(message);
        sb.append(", flag=").append(flag);
        sb.append(", remark=").append(remark);
        sb.append(", delFlag=").append(delFlag);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}