package cc.ligu.mvc.persistence.entity;

import cc.ligu.common.utils.excel.annotation.ExcelField;

import java.io.Serializable;

public class PersonExamHistory implements Serializable {
    private Integer id;

    private Integer personId;

    private String fullScore;

    private String obtainScore;

    private String examTime;

    private Integer examType;

    private String personName;//考试人员名字
    private String personIdCard;//考试人员身份证

    @ExcelField(title = "姓名", align = 2, sort = 1, groups = {1, 2}, isnull = 1)
    public String getPersonName() {
        return personName;
    }

    public PersonExamHistory setPersonName(String personName) {
        this.personName = personName;
        return this;
    }

    @ExcelField(title = "身份证", align = 2, sort = 2, groups = {1, 2}, isnull = 1)
    public String getPersonIdCard() {
        return personIdCard;
    }

    public PersonExamHistory setPersonIdCard(String personIdCard) {
        this.personIdCard = personIdCard;
        return this;
    }

    private static final long serialVersionUID = 1L;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getPersonId() {
        return personId;
    }

    public void setPersonId(Integer personId) {
        this.personId = personId;
    }

    public String getFullScore() {
        return fullScore;
    }

    public void setFullScore(String fullScore) {
        this.fullScore = fullScore == null ? null : fullScore.trim();
    }

    @ExcelField(title = "考试分数", align = 2, sort = 4, groups = {1, 2}, isnull = 1)
    public String getObtainScore() {
        return obtainScore;
    }

    public void setObtainScore(String obtainScore) {
        this.obtainScore = obtainScore == null ? null : obtainScore.trim();
    }

    @ExcelField(title = "考试时间", align = 2, sort = 3, groups = {1, 2}, isnull = 1)
    public String getExamTime() {
        return examTime;
    }

    public void setExamTime(String examTime) {
        this.examTime = examTime == null ? null : examTime.trim();
    }

    public Integer getExamType() {
        return examType;
    }

    public void setExamType(Integer examType) {
        this.examType = examType;
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
        PersonExamHistory other = (PersonExamHistory) that;
        return (this.getId() == null ? other.getId() == null : this.getId().equals(other.getId()))
            && (this.getPersonId() == null ? other.getPersonId() == null : this.getPersonId().equals(other.getPersonId()))
            && (this.getFullScore() == null ? other.getFullScore() == null : this.getFullScore().equals(other.getFullScore()))
            && (this.getObtainScore() == null ? other.getObtainScore() == null : this.getObtainScore().equals(other.getObtainScore()))
            && (this.getExamTime() == null ? other.getExamTime() == null : this.getExamTime().equals(other.getExamTime()))
            && (this.getExamType() == null ? other.getExamType() == null : this.getExamType().equals(other.getExamType()));
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((getId() == null) ? 0 : getId().hashCode());
        result = prime * result + ((getPersonId() == null) ? 0 : getPersonId().hashCode());
        result = prime * result + ((getFullScore() == null) ? 0 : getFullScore().hashCode());
        result = prime * result + ((getObtainScore() == null) ? 0 : getObtainScore().hashCode());
        result = prime * result + ((getExamTime() == null) ? 0 : getExamTime().hashCode());
        result = prime * result + ((getExamType() == null) ? 0 : getExamType().hashCode());
        return result;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", id=").append(id);
        sb.append(", personId=").append(personId);
        sb.append(", fullScore=").append(fullScore);
        sb.append(", obtainScore=").append(obtainScore);
        sb.append(", examTime=").append(examTime);
        sb.append(", examType=").append(examType);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}