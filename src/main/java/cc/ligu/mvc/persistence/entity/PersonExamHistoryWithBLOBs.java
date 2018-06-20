package cc.ligu.mvc.persistence.entity;

import java.io.Serializable;

public class PersonExamHistoryWithBLOBs extends PersonExamHistory implements Serializable {
    private String questionIds;

    private String wrongIds;

    private static final long serialVersionUID = 1L;

    public String getQuestionIds() {
        return questionIds;
    }

    public void setQuestionIds(String questionIds) {
        this.questionIds = questionIds == null ? null : questionIds.trim();
    }

    public String getWrongIds() {
        return wrongIds;
    }

    public void setWrongIds(String wrongIds) {
        this.wrongIds = wrongIds == null ? null : wrongIds.trim();
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
        PersonExamHistoryWithBLOBs other = (PersonExamHistoryWithBLOBs) that;
        return (this.getId() == null ? other.getId() == null : this.getId().equals(other.getId()))
            && (this.getPersonId() == null ? other.getPersonId() == null : this.getPersonId().equals(other.getPersonId()))
            && (this.getFullScore() == null ? other.getFullScore() == null : this.getFullScore().equals(other.getFullScore()))
            && (this.getObtainScore() == null ? other.getObtainScore() == null : this.getObtainScore().equals(other.getObtainScore()))
            && (this.getExamTime() == null ? other.getExamTime() == null : this.getExamTime().equals(other.getExamTime()))
            && (this.getExamType() == null ? other.getExamType() == null : this.getExamType().equals(other.getExamType()))
            && (this.getQuestionIds() == null ? other.getQuestionIds() == null : this.getQuestionIds().equals(other.getQuestionIds()))
            && (this.getWrongIds() == null ? other.getWrongIds() == null : this.getWrongIds().equals(other.getWrongIds()));
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
        result = prime * result + ((getQuestionIds() == null) ? 0 : getQuestionIds().hashCode());
        result = prime * result + ((getWrongIds() == null) ? 0 : getWrongIds().hashCode());
        return result;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", questionIds=").append(questionIds);
        sb.append(", wrongIds=").append(wrongIds);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}