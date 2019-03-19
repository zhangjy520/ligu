package cc.ligu.mvc.persistence.entity;

import java.io.Serializable;

public class PvpPerson implements Serializable {
    /**
     * 对战id
     */
    private Integer id;

    /**
     * 人AId
     */
    private Integer personAId;

    /**
     * 人BId[人机对战无值]
     */
    private Integer personBId;

    /**
     * 题目id(2,3,4,10)这是一套试题的题目id集合
     */
    private String questionIds;

    /**
     * 人A得分
     */
    private String personAScore;

    /**
     * 人B得分[B可能是人，可能是电脑]
     */
    private String personBScore;

    /**
     * 对战时间
     */
    private String pvpTime;

    /**
     * 对战类型[0人机对战 1人人对战]
     */
    private Integer pvpType;

    /**
     * 人A当前积分总和(对战前的积分,总积分需要加上this分)
     */
    private Integer personACurrentJifen;

    /**
     * 人A此局得失积分(正负)
     */
    private Integer personAThisScore;

    /**
     * 人A当前段位(根据积分计算段位)
     */
    private Integer personAchievementId;

    /**
     * 对战是否完成[0未完成 1已完成]
     */
    private Integer complete;

    /**
     * pvp_person
     */
    private static final long serialVersionUID = 1L;

    /**
     * 获取对战id
     * @return id 对战id
     */
    public Integer getId() {
        return id;
    }

    /**
     * 设置对战id
     * @param id 对战id
     */
    public void setId(Integer id) {
        this.id = id;
    }

    /**
     * 获取人AId
     * @return person_a_id 人AId
     */
    public Integer getPersonAId() {
        return personAId;
    }

    /**
     * 设置人AId
     * @param personAId 人AId
     */
    public void setPersonAId(Integer personAId) {
        this.personAId = personAId;
    }

    /**
     * 获取人BId[人机对战无值]
     * @return person_b_id 人BId[人机对战无值]
     */
    public Integer getPersonBId() {
        return personBId;
    }

    /**
     * 设置人BId[人机对战无值]
     * @param personBId 人BId[人机对战无值]
     */
    public void setPersonBId(Integer personBId) {
        this.personBId = personBId;
    }

    /**
     * 获取题目id(2,3,4,10)这是一套试题的题目id集合
     * @return question_ids 题目id(2,3,4,10)这是一套试题的题目id集合
     */
    public String getQuestionIds() {
        return questionIds;
    }

    /**
     * 设置题目id(2,3,4,10)这是一套试题的题目id集合
     * @param questionIds 题目id(2,3,4,10)这是一套试题的题目id集合
     */
    public void setQuestionIds(String questionIds) {
        this.questionIds = questionIds == null ? null : questionIds.trim();
    }

    /**
     * 获取人A得分
     * @return person_a_score 人A得分
     */
    public String getPersonAScore() {
        return personAScore;
    }

    /**
     * 设置人A得分
     * @param personAScore 人A得分
     */
    public void setPersonAScore(String personAScore) {
        this.personAScore = personAScore == null ? null : personAScore.trim();
    }

    /**
     * 获取人B得分[B可能是人，可能是电脑]
     * @return person_b_score 人B得分[B可能是人，可能是电脑]
     */
    public String getPersonBScore() {
        return personBScore;
    }

    /**
     * 设置人B得分[B可能是人，可能是电脑]
     * @param personBScore 人B得分[B可能是人，可能是电脑]
     */
    public void setPersonBScore(String personBScore) {
        this.personBScore = personBScore == null ? null : personBScore.trim();
    }

    /**
     * 获取对战时间
     * @return pvp_time 对战时间
     */
    public String getPvpTime() {
        return pvpTime;
    }

    /**
     * 设置对战时间
     * @param pvpTime 对战时间
     */
    public void setPvpTime(String pvpTime) {
        this.pvpTime = pvpTime == null ? null : pvpTime.trim();
    }

    /**
     * 获取对战类型[0人机对战 1人人对战]
     * @return pvp_type 对战类型[0人机对战 1人人对战]
     */
    public Integer getPvpType() {
        return pvpType;
    }

    /**
     * 设置对战类型[0人机对战 1人人对战]
     * @param pvpType 对战类型[0人机对战 1人人对战]
     */
    public void setPvpType(Integer pvpType) {
        this.pvpType = pvpType;
    }

    /**
     * 获取人A当前积分总和(对战前的积分,总积分需要加上this分)
     * @return person_a_current_jifen 人A当前积分总和(对战前的积分,总积分需要加上this分)
     */
    public Integer getPersonACurrentJifen() {
        return personACurrentJifen;
    }

    /**
     * 设置人A当前积分总和(对战前的积分,总积分需要加上this分)
     * @param personACurrentJifen 人A当前积分总和(对战前的积分,总积分需要加上this分)
     */
    public void setPersonACurrentJifen(Integer personACurrentJifen) {
        this.personACurrentJifen = personACurrentJifen;
    }

    /**
     * 获取人A此局得失积分(正负)
     * @return person_a_this_score 人A此局得失积分(正负)
     */
    public Integer getPersonAThisScore() {
        return personAThisScore;
    }

    /**
     * 设置人A此局得失积分(正负)
     * @param personAThisScore 人A此局得失积分(正负)
     */
    public void setPersonAThisScore(Integer personAThisScore) {
        this.personAThisScore = personAThisScore;
    }

    /**
     * 获取人A当前段位(根据积分计算段位)
     * @return person_achievement_id 人A当前段位(根据积分计算段位)
     */
    public Integer getPersonAchievementId() {
        return personAchievementId;
    }

    /**
     * 设置人A当前段位(根据积分计算段位)
     * @param personAchievementId 人A当前段位(根据积分计算段位)
     */
    public void setPersonAchievementId(Integer personAchievementId) {
        this.personAchievementId = personAchievementId;
    }

    /**
     * 获取对战是否完成[0未完成 1已完成]
     * @return complete 对战是否完成[0未完成 1已完成]
     */
    public Integer getComplete() {
        return complete;
    }

    /**
     * 设置对战是否完成[0未完成 1已完成]
     * @param complete 对战是否完成[0未完成 1已完成]
     */
    public void setComplete(Integer complete) {
        this.complete = complete;
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
        PvpPerson other = (PvpPerson) that;
        return (this.getId() == null ? other.getId() == null : this.getId().equals(other.getId()))
            && (this.getPersonAId() == null ? other.getPersonAId() == null : this.getPersonAId().equals(other.getPersonAId()))
            && (this.getPersonBId() == null ? other.getPersonBId() == null : this.getPersonBId().equals(other.getPersonBId()))
            && (this.getQuestionIds() == null ? other.getQuestionIds() == null : this.getQuestionIds().equals(other.getQuestionIds()))
            && (this.getPersonAScore() == null ? other.getPersonAScore() == null : this.getPersonAScore().equals(other.getPersonAScore()))
            && (this.getPersonBScore() == null ? other.getPersonBScore() == null : this.getPersonBScore().equals(other.getPersonBScore()))
            && (this.getPvpTime() == null ? other.getPvpTime() == null : this.getPvpTime().equals(other.getPvpTime()))
            && (this.getPvpType() == null ? other.getPvpType() == null : this.getPvpType().equals(other.getPvpType()))
            && (this.getPersonACurrentJifen() == null ? other.getPersonACurrentJifen() == null : this.getPersonACurrentJifen().equals(other.getPersonACurrentJifen()))
            && (this.getPersonAThisScore() == null ? other.getPersonAThisScore() == null : this.getPersonAThisScore().equals(other.getPersonAThisScore()))
            && (this.getPersonAchievementId() == null ? other.getPersonAchievementId() == null : this.getPersonAchievementId().equals(other.getPersonAchievementId()))
            && (this.getComplete() == null ? other.getComplete() == null : this.getComplete().equals(other.getComplete()));
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((getId() == null) ? 0 : getId().hashCode());
        result = prime * result + ((getPersonAId() == null) ? 0 : getPersonAId().hashCode());
        result = prime * result + ((getPersonBId() == null) ? 0 : getPersonBId().hashCode());
        result = prime * result + ((getQuestionIds() == null) ? 0 : getQuestionIds().hashCode());
        result = prime * result + ((getPersonAScore() == null) ? 0 : getPersonAScore().hashCode());
        result = prime * result + ((getPersonBScore() == null) ? 0 : getPersonBScore().hashCode());
        result = prime * result + ((getPvpTime() == null) ? 0 : getPvpTime().hashCode());
        result = prime * result + ((getPvpType() == null) ? 0 : getPvpType().hashCode());
        result = prime * result + ((getPersonACurrentJifen() == null) ? 0 : getPersonACurrentJifen().hashCode());
        result = prime * result + ((getPersonAThisScore() == null) ? 0 : getPersonAThisScore().hashCode());
        result = prime * result + ((getPersonAchievementId() == null) ? 0 : getPersonAchievementId().hashCode());
        result = prime * result + ((getComplete() == null) ? 0 : getComplete().hashCode());
        return result;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", id=").append(id);
        sb.append(", personAId=").append(personAId);
        sb.append(", personBId=").append(personBId);
        sb.append(", questionIds=").append(questionIds);
        sb.append(", personAScore=").append(personAScore);
        sb.append(", personBScore=").append(personBScore);
        sb.append(", pvpTime=").append(pvpTime);
        sb.append(", pvpType=").append(pvpType);
        sb.append(", personACurrentJifen=").append(personACurrentJifen);
        sb.append(", personAThisScore=").append(personAThisScore);
        sb.append(", personAchievementId=").append(personAchievementId);
        sb.append(", complete=").append(complete);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}