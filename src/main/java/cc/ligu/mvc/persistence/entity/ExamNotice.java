package cc.ligu.mvc.persistence.entity;

import java.io.Serializable;
import java.util.List;

public class ExamNotice implements Serializable {
    /**
     * 考试主键
     */
    private Integer id;

    /**
     * 考试名字
     */
    private String examName;

    /**
     * 考试开始时间
     */
    private String dateBegin;

    /**
     * 考试结束时间
     */
    private String dateEnd;

    /**
     * 逻辑删除标记[0正常,1已删除]
     */
    private Integer delFlag;

    /**
     * 
     */
    private String remark;

    /**
     * 考试题目列表
     */
    private String questionIds;

    //是否参加过该考试
    private boolean isIn;
    private List<Question> questionList;

    public boolean isIn() {
        return isIn;
    }

    public void setIn(boolean in) {
        isIn = in;
    }

    public List<Question> getQuestionList() {
        return questionList;
    }

    public void setQuestionList(List<Question> questionList) {
        this.questionList = questionList;
    }

    /**
     * exam_notice
     */
    private static final long serialVersionUID = 1L;

    /**
     * 获取考试主键
     * @return id 考试主键
     */
    public Integer getId() {
        return id;
    }

    /**
     * 设置考试主键
     * @param id 考试主键
     */
    public void setId(Integer id) {
        this.id = id;
    }

    /**
     * 获取考试名字
     * @return exam_name 考试名字
     */
    public String getExamName() {
        return examName;
    }

    /**
     * 设置考试名字
     * @param examName 考试名字
     */
    public void setExamName(String examName) {
        this.examName = examName == null ? null : examName.trim();
    }

    /**
     * 获取考试开始时间
     * @return date_begin 考试开始时间
     */
    public String getDateBegin() {
        return dateBegin;
    }

    /**
     * 设置考试开始时间
     * @param dateBegin 考试开始时间
     */
    public void setDateBegin(String dateBegin) {
        this.dateBegin = dateBegin == null ? null : dateBegin.trim();
    }

    /**
     * 获取考试结束时间
     * @return date_end 考试结束时间
     */
    public String getDateEnd() {
        return dateEnd;
    }

    /**
     * 设置考试结束时间
     * @param dateEnd 考试结束时间
     */
    public void setDateEnd(String dateEnd) {
        this.dateEnd = dateEnd == null ? null : dateEnd.trim();
    }

    /**
     * 获取逻辑删除标记[0正常,1已删除]
     * @return del_flag 逻辑删除标记[0正常,1已删除]
     */
    public Integer getDelFlag() {
        return delFlag;
    }

    /**
     * 设置逻辑删除标记[0正常,1已删除]
     * @param delFlag 逻辑删除标记[0正常,1已删除]
     */
    public void setDelFlag(Integer delFlag) {
        this.delFlag = delFlag;
    }

    /**
     * 获取
     * @return remark 
     */
    public String getRemark() {
        return remark;
    }

    /**
     * 设置
     * @param remark 
     */
    public void setRemark(String remark) {
        this.remark = remark == null ? null : remark.trim();
    }

    /**
     * 获取考试题目列表
     * @return question_ids 考试题目列表
     */
    public String getQuestionIds() {
        return questionIds;
    }

    /**
     * 设置考试题目列表
     * @param questionIds 考试题目列表
     */
    public void setQuestionIds(String questionIds) {
        this.questionIds = questionIds == null ? null : questionIds.trim();
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
        ExamNotice other = (ExamNotice) that;
        return (this.getId() == null ? other.getId() == null : this.getId().equals(other.getId()))
            && (this.getExamName() == null ? other.getExamName() == null : this.getExamName().equals(other.getExamName()))
            && (this.getDateBegin() == null ? other.getDateBegin() == null : this.getDateBegin().equals(other.getDateBegin()))
            && (this.getDateEnd() == null ? other.getDateEnd() == null : this.getDateEnd().equals(other.getDateEnd()))
            && (this.getDelFlag() == null ? other.getDelFlag() == null : this.getDelFlag().equals(other.getDelFlag()))
            && (this.getRemark() == null ? other.getRemark() == null : this.getRemark().equals(other.getRemark()))
            && (this.getQuestionIds() == null ? other.getQuestionIds() == null : this.getQuestionIds().equals(other.getQuestionIds()));
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((getId() == null) ? 0 : getId().hashCode());
        result = prime * result + ((getExamName() == null) ? 0 : getExamName().hashCode());
        result = prime * result + ((getDateBegin() == null) ? 0 : getDateBegin().hashCode());
        result = prime * result + ((getDateEnd() == null) ? 0 : getDateEnd().hashCode());
        result = prime * result + ((getDelFlag() == null) ? 0 : getDelFlag().hashCode());
        result = prime * result + ((getRemark() == null) ? 0 : getRemark().hashCode());
        result = prime * result + ((getQuestionIds() == null) ? 0 : getQuestionIds().hashCode());
        return result;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", id=").append(id);
        sb.append(", examName=").append(examName);
        sb.append(", dateBegin=").append(dateBegin);
        sb.append(", dateEnd=").append(dateEnd);
        sb.append(", delFlag=").append(delFlag);
        sb.append(", remark=").append(remark);
        sb.append(", questionIds=").append(questionIds);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}