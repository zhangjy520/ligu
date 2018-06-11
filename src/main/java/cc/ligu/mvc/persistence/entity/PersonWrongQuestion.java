package cc.ligu.mvc.persistence.entity;

import java.io.Serializable;

public class PersonWrongQuestion implements Serializable {
    private Integer personId;

    private Integer questionId;

    private String yourAnswer;

    private String correctAnswer;

    private static final long serialVersionUID = 1L;

    public Integer getPersonId() {
        return personId;
    }

    public void setPersonId(Integer personId) {
        this.personId = personId;
    }

    public Integer getQuestionId() {
        return questionId;
    }

    public void setQuestionId(Integer questionId) {
        this.questionId = questionId;
    }

    public String getYourAnswer() {
        return yourAnswer;
    }

    public void setYourAnswer(String yourAnswer) {
        this.yourAnswer = yourAnswer == null ? null : yourAnswer.trim();
    }

    public String getCorrectAnswer() {
        return correctAnswer;
    }

    public void setCorrectAnswer(String correctAnswer) {
        this.correctAnswer = correctAnswer == null ? null : correctAnswer.trim();
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
        PersonWrongQuestion other = (PersonWrongQuestion) that;
        return (this.getPersonId() == null ? other.getPersonId() == null : this.getPersonId().equals(other.getPersonId()))
            && (this.getQuestionId() == null ? other.getQuestionId() == null : this.getQuestionId().equals(other.getQuestionId()))
            && (this.getYourAnswer() == null ? other.getYourAnswer() == null : this.getYourAnswer().equals(other.getYourAnswer()))
            && (this.getCorrectAnswer() == null ? other.getCorrectAnswer() == null : this.getCorrectAnswer().equals(other.getCorrectAnswer()));
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((getPersonId() == null) ? 0 : getPersonId().hashCode());
        result = prime * result + ((getQuestionId() == null) ? 0 : getQuestionId().hashCode());
        result = prime * result + ((getYourAnswer() == null) ? 0 : getYourAnswer().hashCode());
        result = prime * result + ((getCorrectAnswer() == null) ? 0 : getCorrectAnswer().hashCode());
        return result;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", personId=").append(personId);
        sb.append(", questionId=").append(questionId);
        sb.append(", yourAnswer=").append(yourAnswer);
        sb.append(", correctAnswer=").append(correctAnswer);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}