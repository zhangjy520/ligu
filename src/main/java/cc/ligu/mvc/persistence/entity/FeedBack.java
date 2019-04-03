package cc.ligu.mvc.persistence.entity;

import java.io.Serializable;

public class FeedBack implements Serializable {
    /**
     * 
     */
    private Integer id;

    /**
     * 反馈方式[1实名 2匿名]
     */
    private Integer way;

    /**
     * 反馈类型[1工资 2保险 3其他 ]
     */
    private Integer type;

    /**
     * 反馈时间
     */
    private Long time;

    /**
     * 反馈人员id(匿名投诉无值)
     */
    private Integer personId;

    /**
     * 反馈详情内容
     */
    private String content;

    /**
     * 图片证明,逗号分割多个图片
     */
    private String pics;

    /**
     * 处理人id
     */
    private Integer dealPersonId;

    /**
     * 处理时间
     */
    private Long dealTime;

    /**
     * 处理状态[1收到 2 处理中 3处理完毕 ]
     */
    private Integer dealStatus;

    /**
     * 处理结果及建议
     */
    private String dealSay;

    /**
     * feedback
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
     * 获取反馈方式[1实名 2匿名]
     * @return way 反馈方式[1实名 2匿名]
     */
    public Integer getWay() {
        return way;
    }

    /**
     * 设置反馈方式[1实名 2匿名]
     * @param way 反馈方式[1实名 2匿名]
     */
    public void setWay(Integer way) {
        this.way = way;
    }

    /**
     * 获取反馈类型[1工资 2保险 3其他 ]
     * @return type 反馈类型[1工资 2保险 3其他 ]
     */
    public Integer getType() {
        return type;
    }

    /**
     * 设置反馈类型[1工资 2保险 3其他 ]
     * @param type 反馈类型[1工资 2保险 3其他 ]
     */
    public void setType(Integer type) {
        this.type = type;
    }

    /**
     * 获取反馈时间
     * @return time 反馈时间
     */
    public Long getTime() {
        return time;
    }

    /**
     * 设置反馈时间
     * @param time 反馈时间
     */
    public void setTime(Long time) {
        this.time = time;
    }

    /**
     * 获取反馈人员id(匿名投诉无值)
     * @return person_id 反馈人员id(匿名投诉无值)
     */
    public Integer getPersonId() {
        return personId;
    }

    /**
     * 设置反馈人员id(匿名投诉无值)
     * @param personId 反馈人员id(匿名投诉无值)
     */
    public void setPersonId(Integer personId) {
        this.personId = personId;
    }

    /**
     * 获取反馈详情内容
     * @return content 反馈详情内容
     */
    public String getContent() {
        return content;
    }

    /**
     * 设置反馈详情内容
     * @param content 反馈详情内容
     */
    public void setContent(String content) {
        this.content = content == null ? null : content.trim();
    }

    /**
     * 获取图片证明,逗号分割多个图片
     * @return pics 图片证明,逗号分割多个图片
     */
    public String getPics() {
        return pics;
    }

    /**
     * 设置图片证明,逗号分割多个图片
     * @param pics 图片证明,逗号分割多个图片
     */
    public void setPics(String pics) {
        this.pics = pics == null ? null : pics.trim();
    }

    /**
     * 获取处理人id
     * @return deal_person_id 处理人id
     */
    public Integer getDealPersonId() {
        return dealPersonId;
    }

    /**
     * 设置处理人id
     * @param dealPersonId 处理人id
     */
    public void setDealPersonId(Integer dealPersonId) {
        this.dealPersonId = dealPersonId;
    }

    /**
     * 获取处理时间
     * @return deal_time 处理时间
     */
    public Long getDealTime() {
        return dealTime;
    }

    /**
     * 设置处理时间
     * @param dealTime 处理时间
     */
    public void setDealTime(Long dealTime) {
        this.dealTime = dealTime;
    }

    /**
     * 获取处理状态[1收到 2 处理中 3处理完毕 ]
     * @return deal_status 处理状态[1收到 2 处理中 3处理完毕 ]
     */
    public Integer getDealStatus() {
        return dealStatus;
    }

    /**
     * 设置处理状态[1收到 2 处理中 3处理完毕 ]
     * @param dealStatus 处理状态[1收到 2 处理中 3处理完毕 ]
     */
    public void setDealStatus(Integer dealStatus) {
        this.dealStatus = dealStatus;
    }

    /**
     * 获取处理结果及建议
     * @return deal_say 处理结果及建议
     */
    public String getDealSay() {
        return dealSay;
    }

    /**
     * 设置处理结果及建议
     * @param dealSay 处理结果及建议
     */
    public void setDealSay(String dealSay) {
        this.dealSay = dealSay == null ? null : dealSay.trim();
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
        FeedBack other = (FeedBack) that;
        return (this.getId() == null ? other.getId() == null : this.getId().equals(other.getId()))
            && (this.getWay() == null ? other.getWay() == null : this.getWay().equals(other.getWay()))
            && (this.getType() == null ? other.getType() == null : this.getType().equals(other.getType()))
            && (this.getTime() == null ? other.getTime() == null : this.getTime().equals(other.getTime()))
            && (this.getPersonId() == null ? other.getPersonId() == null : this.getPersonId().equals(other.getPersonId()))
            && (this.getContent() == null ? other.getContent() == null : this.getContent().equals(other.getContent()))
            && (this.getPics() == null ? other.getPics() == null : this.getPics().equals(other.getPics()))
            && (this.getDealPersonId() == null ? other.getDealPersonId() == null : this.getDealPersonId().equals(other.getDealPersonId()))
            && (this.getDealTime() == null ? other.getDealTime() == null : this.getDealTime().equals(other.getDealTime()))
            && (this.getDealStatus() == null ? other.getDealStatus() == null : this.getDealStatus().equals(other.getDealStatus()))
            && (this.getDealSay() == null ? other.getDealSay() == null : this.getDealSay().equals(other.getDealSay()));
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((getId() == null) ? 0 : getId().hashCode());
        result = prime * result + ((getWay() == null) ? 0 : getWay().hashCode());
        result = prime * result + ((getType() == null) ? 0 : getType().hashCode());
        result = prime * result + ((getTime() == null) ? 0 : getTime().hashCode());
        result = prime * result + ((getPersonId() == null) ? 0 : getPersonId().hashCode());
        result = prime * result + ((getContent() == null) ? 0 : getContent().hashCode());
        result = prime * result + ((getPics() == null) ? 0 : getPics().hashCode());
        result = prime * result + ((getDealPersonId() == null) ? 0 : getDealPersonId().hashCode());
        result = prime * result + ((getDealTime() == null) ? 0 : getDealTime().hashCode());
        result = prime * result + ((getDealStatus() == null) ? 0 : getDealStatus().hashCode());
        result = prime * result + ((getDealSay() == null) ? 0 : getDealSay().hashCode());
        return result;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", id=").append(id);
        sb.append(", way=").append(way);
        sb.append(", type=").append(type);
        sb.append(", time=").append(time);
        sb.append(", personId=").append(personId);
        sb.append(", content=").append(content);
        sb.append(", pics=").append(pics);
        sb.append(", dealPersonId=").append(dealPersonId);
        sb.append(", dealTime=").append(dealTime);
        sb.append(", dealStatus=").append(dealStatus);
        sb.append(", dealSay=").append(dealSay);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}