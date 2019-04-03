package cc.ligu.mvc.persistence.entity;

import java.io.Serializable;

public class RefPersonExam implements Serializable {
    /**
     * 关联主键
     */
    private Integer id;

    /**
     * 参加考试人ID
     */
    private Integer personId;

    /**
     * 考试ID
     */
    private Integer examId;

    /**
     * 参加考试时间戳
     */
    private String examTime;

    /**
     * ref_exam_person
     */
    private static final long serialVersionUID = 1L;

    /**
     * 获取关联主键
     * @return id 关联主键
     */
    public Integer getId() {
        return id;
    }

    /**
     * 设置关联主键
     * @param id 关联主键
     */
    public void setId(Integer id) {
        this.id = id;
    }

    /**
     * 获取参加考试人ID
     * @return person_id 参加考试人ID
     */
    public Integer getPersonId() {
        return personId;
    }

    /**
     * 设置参加考试人ID
     * @param personId 参加考试人ID
     */
    public void setPersonId(Integer personId) {
        this.personId = personId;
    }

    /**
     * 获取考试ID
     * @return exam_id 考试ID
     */
    public Integer getExamId() {
        return examId;
    }

    /**
     * 设置考试ID
     * @param examId 考试ID
     */
    public void setExamId(Integer examId) {
        this.examId = examId;
    }

    /**
     * 获取参加考试时间戳
     * @return exam_time 参加考试时间戳
     */
    public String getExamTime() {
        return examTime;
    }

    /**
     * 设置参加考试时间戳
     * @param examTime 参加考试时间戳
     */
    public void setExamTime(String examTime) {
        this.examTime = examTime == null ? null : examTime.trim();
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
        RefPersonExam other = (RefPersonExam) that;
        return (this.getId() == null ? other.getId() == null : this.getId().equals(other.getId()))
            && (this.getPersonId() == null ? other.getPersonId() == null : this.getPersonId().equals(other.getPersonId()))
            && (this.getExamId() == null ? other.getExamId() == null : this.getExamId().equals(other.getExamId()))
            && (this.getExamTime() == null ? other.getExamTime() == null : this.getExamTime().equals(other.getExamTime()));
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((getId() == null) ? 0 : getId().hashCode());
        result = prime * result + ((getPersonId() == null) ? 0 : getPersonId().hashCode());
        result = prime * result + ((getExamId() == null) ? 0 : getExamId().hashCode());
        result = prime * result + ((getExamTime() == null) ? 0 : getExamTime().hashCode());
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
        sb.append(", examId=").append(examId);
        sb.append(", examTime=").append(examTime);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}