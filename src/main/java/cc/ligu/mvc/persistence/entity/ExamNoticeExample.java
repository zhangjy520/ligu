package cc.ligu.mvc.persistence.entity;

import java.util.ArrayList;
import java.util.List;

public class ExamNoticeExample {
    /**
     * exam_notice
     */
    protected String orderByClause;

    /**
     * exam_notice
     */
    protected boolean distinct;

    /**
     * exam_notice
     */
    protected List<Criteria> oredCriteria;

    public ExamNoticeExample() {
        oredCriteria = new ArrayList<Criteria>();
    }

    public void setOrderByClause(String orderByClause) {
        this.orderByClause = orderByClause;
    }

    public String getOrderByClause() {
        return orderByClause;
    }

    public void setDistinct(boolean distinct) {
        this.distinct = distinct;
    }

    public boolean isDistinct() {
        return distinct;
    }

    public List<Criteria> getOredCriteria() {
        return oredCriteria;
    }

    public void or(Criteria criteria) {
        oredCriteria.add(criteria);
    }

    public Criteria or() {
        Criteria criteria = createCriteriaInternal();
        oredCriteria.add(criteria);
        return criteria;
    }

    public Criteria createCriteria() {
        Criteria criteria = createCriteriaInternal();
        if (oredCriteria.size() == 0) {
            oredCriteria.add(criteria);
        }
        return criteria;
    }

    protected Criteria createCriteriaInternal() {
        Criteria criteria = new Criteria();
        return criteria;
    }

    public void clear() {
        oredCriteria.clear();
        orderByClause = null;
        distinct = false;
    }

    /**
     * exam_notice 2019-04-03
     */
    protected abstract static class GeneratedCriteria {
        protected List<Criterion> criteria;

        protected GeneratedCriteria() {
            super();
            criteria = new ArrayList<Criterion>();
        }

        public boolean isValid() {
            return criteria.size() > 0;
        }

        public List<Criterion> getAllCriteria() {
            return criteria;
        }

        public List<Criterion> getCriteria() {
            return criteria;
        }

        protected void addCriterion(String condition) {
            if (condition == null) {
                throw new RuntimeException("Value for condition cannot be null");
            }
            criteria.add(new Criterion(condition));
        }

        protected void addCriterion(String condition, Object value, String property) {
            if (value == null) {
                throw new RuntimeException("Value for " + property + " cannot be null");
            }
            criteria.add(new Criterion(condition, value));
        }

        protected void addCriterion(String condition, Object value1, Object value2, String property) {
            if (value1 == null || value2 == null) {
                throw new RuntimeException("Between values for " + property + " cannot be null");
            }
            criteria.add(new Criterion(condition, value1, value2));
        }

        public Criteria andIdIsNull() {
            addCriterion("id is null");
            return (Criteria) this;
        }

        public Criteria andIdIsNotNull() {
            addCriterion("id is not null");
            return (Criteria) this;
        }

        public Criteria andIdEqualTo(Integer value) {
            addCriterion("id =", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdNotEqualTo(Integer value) {
            addCriterion("id <>", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdGreaterThan(Integer value) {
            addCriterion("id >", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdGreaterThanOrEqualTo(Integer value) {
            addCriterion("id >=", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdLessThan(Integer value) {
            addCriterion("id <", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdLessThanOrEqualTo(Integer value) {
            addCriterion("id <=", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdIn(List<Integer> values) {
            addCriterion("id in", values, "id");
            return (Criteria) this;
        }

        public Criteria andIdNotIn(List<Integer> values) {
            addCriterion("id not in", values, "id");
            return (Criteria) this;
        }

        public Criteria andIdBetween(Integer value1, Integer value2) {
            addCriterion("id between", value1, value2, "id");
            return (Criteria) this;
        }

        public Criteria andIdNotBetween(Integer value1, Integer value2) {
            addCriterion("id not between", value1, value2, "id");
            return (Criteria) this;
        }

        public Criteria andExamNameIsNull() {
            addCriterion("exam_name is null");
            return (Criteria) this;
        }

        public Criteria andExamNameIsNotNull() {
            addCriterion("exam_name is not null");
            return (Criteria) this;
        }

        public Criteria andExamNameEqualTo(String value) {
            addCriterion("exam_name =", value, "examName");
            return (Criteria) this;
        }

        public Criteria andExamNameNotEqualTo(String value) {
            addCriterion("exam_name <>", value, "examName");
            return (Criteria) this;
        }

        public Criteria andExamNameGreaterThan(String value) {
            addCriterion("exam_name >", value, "examName");
            return (Criteria) this;
        }

        public Criteria andExamNameGreaterThanOrEqualTo(String value) {
            addCriterion("exam_name >=", value, "examName");
            return (Criteria) this;
        }

        public Criteria andExamNameLessThan(String value) {
            addCriterion("exam_name <", value, "examName");
            return (Criteria) this;
        }

        public Criteria andExamNameLessThanOrEqualTo(String value) {
            addCriterion("exam_name <=", value, "examName");
            return (Criteria) this;
        }

        public Criteria andExamNameLike(String value) {
            addCriterion("exam_name like", value, "examName");
            return (Criteria) this;
        }

        public Criteria andExamNameNotLike(String value) {
            addCriterion("exam_name not like", value, "examName");
            return (Criteria) this;
        }

        public Criteria andExamNameIn(List<String> values) {
            addCriterion("exam_name in", values, "examName");
            return (Criteria) this;
        }

        public Criteria andExamNameNotIn(List<String> values) {
            addCriterion("exam_name not in", values, "examName");
            return (Criteria) this;
        }

        public Criteria andExamNameBetween(String value1, String value2) {
            addCriterion("exam_name between", value1, value2, "examName");
            return (Criteria) this;
        }

        public Criteria andExamNameNotBetween(String value1, String value2) {
            addCriterion("exam_name not between", value1, value2, "examName");
            return (Criteria) this;
        }

        public Criteria andDateBeginIsNull() {
            addCriterion("date_begin is null");
            return (Criteria) this;
        }

        public Criteria andDateBeginIsNotNull() {
            addCriterion("date_begin is not null");
            return (Criteria) this;
        }

        public Criteria andDateBeginEqualTo(String value) {
            addCriterion("date_begin =", value, "dateBegin");
            return (Criteria) this;
        }

        public Criteria andDateBeginNotEqualTo(String value) {
            addCriterion("date_begin <>", value, "dateBegin");
            return (Criteria) this;
        }

        public Criteria andDateBeginGreaterThan(String value) {
            addCriterion("date_begin >", value, "dateBegin");
            return (Criteria) this;
        }

        public Criteria andDateBeginGreaterThanOrEqualTo(String value) {
            addCriterion("date_begin >=", value, "dateBegin");
            return (Criteria) this;
        }

        public Criteria andDateBeginLessThan(String value) {
            addCriterion("date_begin <", value, "dateBegin");
            return (Criteria) this;
        }

        public Criteria andDateBeginLessThanOrEqualTo(String value) {
            addCriterion("date_begin <=", value, "dateBegin");
            return (Criteria) this;
        }

        public Criteria andDateBeginLike(String value) {
            addCriterion("date_begin like", value, "dateBegin");
            return (Criteria) this;
        }

        public Criteria andDateBeginNotLike(String value) {
            addCriterion("date_begin not like", value, "dateBegin");
            return (Criteria) this;
        }

        public Criteria andDateBeginIn(List<String> values) {
            addCriterion("date_begin in", values, "dateBegin");
            return (Criteria) this;
        }

        public Criteria andDateBeginNotIn(List<String> values) {
            addCriterion("date_begin not in", values, "dateBegin");
            return (Criteria) this;
        }

        public Criteria andDateBeginBetween(String value1, String value2) {
            addCriterion("date_begin between", value1, value2, "dateBegin");
            return (Criteria) this;
        }

        public Criteria andDateBeginNotBetween(String value1, String value2) {
            addCriterion("date_begin not between", value1, value2, "dateBegin");
            return (Criteria) this;
        }

        public Criteria andDateEndIsNull() {
            addCriterion("date_end is null");
            return (Criteria) this;
        }

        public Criteria andDateEndIsNotNull() {
            addCriterion("date_end is not null");
            return (Criteria) this;
        }

        public Criteria andDateEndEqualTo(String value) {
            addCriterion("date_end =", value, "dateEnd");
            return (Criteria) this;
        }

        public Criteria andDateEndNotEqualTo(String value) {
            addCriterion("date_end <>", value, "dateEnd");
            return (Criteria) this;
        }

        public Criteria andDateEndGreaterThan(String value) {
            addCriterion("date_end >", value, "dateEnd");
            return (Criteria) this;
        }

        public Criteria andDateEndGreaterThanOrEqualTo(String value) {
            addCriterion("date_end >=", value, "dateEnd");
            return (Criteria) this;
        }

        public Criteria andDateEndLessThan(String value) {
            addCriterion("date_end <", value, "dateEnd");
            return (Criteria) this;
        }

        public Criteria andDateEndLessThanOrEqualTo(String value) {
            addCriterion("date_end <=", value, "dateEnd");
            return (Criteria) this;
        }

        public Criteria andDateEndLike(String value) {
            addCriterion("date_end like", value, "dateEnd");
            return (Criteria) this;
        }

        public Criteria andDateEndNotLike(String value) {
            addCriterion("date_end not like", value, "dateEnd");
            return (Criteria) this;
        }

        public Criteria andDateEndIn(List<String> values) {
            addCriterion("date_end in", values, "dateEnd");
            return (Criteria) this;
        }

        public Criteria andDateEndNotIn(List<String> values) {
            addCriterion("date_end not in", values, "dateEnd");
            return (Criteria) this;
        }

        public Criteria andDateEndBetween(String value1, String value2) {
            addCriterion("date_end between", value1, value2, "dateEnd");
            return (Criteria) this;
        }

        public Criteria andDateEndNotBetween(String value1, String value2) {
            addCriterion("date_end not between", value1, value2, "dateEnd");
            return (Criteria) this;
        }

        public Criteria andDelFlagIsNull() {
            addCriterion("del_flag is null");
            return (Criteria) this;
        }

        public Criteria andDelFlagIsNotNull() {
            addCriterion("del_flag is not null");
            return (Criteria) this;
        }

        public Criteria andDelFlagEqualTo(Integer value) {
            addCriterion("del_flag =", value, "delFlag");
            return (Criteria) this;
        }

        public Criteria andDelFlagNotEqualTo(Integer value) {
            addCriterion("del_flag <>", value, "delFlag");
            return (Criteria) this;
        }

        public Criteria andDelFlagGreaterThan(Integer value) {
            addCriterion("del_flag >", value, "delFlag");
            return (Criteria) this;
        }

        public Criteria andDelFlagGreaterThanOrEqualTo(Integer value) {
            addCriterion("del_flag >=", value, "delFlag");
            return (Criteria) this;
        }

        public Criteria andDelFlagLessThan(Integer value) {
            addCriterion("del_flag <", value, "delFlag");
            return (Criteria) this;
        }

        public Criteria andDelFlagLessThanOrEqualTo(Integer value) {
            addCriterion("del_flag <=", value, "delFlag");
            return (Criteria) this;
        }

        public Criteria andDelFlagIn(List<Integer> values) {
            addCriterion("del_flag in", values, "delFlag");
            return (Criteria) this;
        }

        public Criteria andDelFlagNotIn(List<Integer> values) {
            addCriterion("del_flag not in", values, "delFlag");
            return (Criteria) this;
        }

        public Criteria andDelFlagBetween(Integer value1, Integer value2) {
            addCriterion("del_flag between", value1, value2, "delFlag");
            return (Criteria) this;
        }

        public Criteria andDelFlagNotBetween(Integer value1, Integer value2) {
            addCriterion("del_flag not between", value1, value2, "delFlag");
            return (Criteria) this;
        }

        public Criteria andRemarkIsNull() {
            addCriterion("remark is null");
            return (Criteria) this;
        }

        public Criteria andRemarkIsNotNull() {
            addCriterion("remark is not null");
            return (Criteria) this;
        }

        public Criteria andRemarkEqualTo(String value) {
            addCriterion("remark =", value, "remark");
            return (Criteria) this;
        }

        public Criteria andRemarkNotEqualTo(String value) {
            addCriterion("remark <>", value, "remark");
            return (Criteria) this;
        }

        public Criteria andRemarkGreaterThan(String value) {
            addCriterion("remark >", value, "remark");
            return (Criteria) this;
        }

        public Criteria andRemarkGreaterThanOrEqualTo(String value) {
            addCriterion("remark >=", value, "remark");
            return (Criteria) this;
        }

        public Criteria andRemarkLessThan(String value) {
            addCriterion("remark <", value, "remark");
            return (Criteria) this;
        }

        public Criteria andRemarkLessThanOrEqualTo(String value) {
            addCriterion("remark <=", value, "remark");
            return (Criteria) this;
        }

        public Criteria andRemarkLike(String value) {
            addCriterion("remark like", value, "remark");
            return (Criteria) this;
        }

        public Criteria andRemarkNotLike(String value) {
            addCriterion("remark not like", value, "remark");
            return (Criteria) this;
        }

        public Criteria andRemarkIn(List<String> values) {
            addCriterion("remark in", values, "remark");
            return (Criteria) this;
        }

        public Criteria andRemarkNotIn(List<String> values) {
            addCriterion("remark not in", values, "remark");
            return (Criteria) this;
        }

        public Criteria andRemarkBetween(String value1, String value2) {
            addCriterion("remark between", value1, value2, "remark");
            return (Criteria) this;
        }

        public Criteria andRemarkNotBetween(String value1, String value2) {
            addCriterion("remark not between", value1, value2, "remark");
            return (Criteria) this;
        }

        public Criteria andQuestionIdsIsNull() {
            addCriterion("question_ids is null");
            return (Criteria) this;
        }

        public Criteria andQuestionIdsIsNotNull() {
            addCriterion("question_ids is not null");
            return (Criteria) this;
        }

        public Criteria andQuestionIdsEqualTo(String value) {
            addCriterion("question_ids =", value, "questionIds");
            return (Criteria) this;
        }

        public Criteria andQuestionIdsNotEqualTo(String value) {
            addCriterion("question_ids <>", value, "questionIds");
            return (Criteria) this;
        }

        public Criteria andQuestionIdsGreaterThan(String value) {
            addCriterion("question_ids >", value, "questionIds");
            return (Criteria) this;
        }

        public Criteria andQuestionIdsGreaterThanOrEqualTo(String value) {
            addCriterion("question_ids >=", value, "questionIds");
            return (Criteria) this;
        }

        public Criteria andQuestionIdsLessThan(String value) {
            addCriterion("question_ids <", value, "questionIds");
            return (Criteria) this;
        }

        public Criteria andQuestionIdsLessThanOrEqualTo(String value) {
            addCriterion("question_ids <=", value, "questionIds");
            return (Criteria) this;
        }

        public Criteria andQuestionIdsLike(String value) {
            addCriterion("question_ids like", value, "questionIds");
            return (Criteria) this;
        }

        public Criteria andQuestionIdsNotLike(String value) {
            addCriterion("question_ids not like", value, "questionIds");
            return (Criteria) this;
        }

        public Criteria andQuestionIdsIn(List<String> values) {
            addCriterion("question_ids in", values, "questionIds");
            return (Criteria) this;
        }

        public Criteria andQuestionIdsNotIn(List<String> values) {
            addCriterion("question_ids not in", values, "questionIds");
            return (Criteria) this;
        }

        public Criteria andQuestionIdsBetween(String value1, String value2) {
            addCriterion("question_ids between", value1, value2, "questionIds");
            return (Criteria) this;
        }

        public Criteria andQuestionIdsNotBetween(String value1, String value2) {
            addCriterion("question_ids not between", value1, value2, "questionIds");
            return (Criteria) this;
        }

        public Criteria andExamNameLikeInsensitive(String value) {
            addCriterion("upper(exam_name) like", value.toUpperCase(), "examName");
            return (Criteria) this;
        }

        public Criteria andDateBeginLikeInsensitive(String value) {
            addCriterion("upper(date_begin) like", value.toUpperCase(), "dateBegin");
            return (Criteria) this;
        }

        public Criteria andDateEndLikeInsensitive(String value) {
            addCriterion("upper(date_end) like", value.toUpperCase(), "dateEnd");
            return (Criteria) this;
        }

        public Criteria andRemarkLikeInsensitive(String value) {
            addCriterion("upper(remark) like", value.toUpperCase(), "remark");
            return (Criteria) this;
        }

        public Criteria andQuestionIdsLikeInsensitive(String value) {
            addCriterion("upper(question_ids) like", value.toUpperCase(), "questionIds");
            return (Criteria) this;
        }
    }

    /**
     * exam_notice
     */
    public static class Criteria extends GeneratedCriteria {

        protected Criteria() {
            super();
        }
    }

    /**
     * exam_notice 2019-04-03
     */
    public static class Criterion {
        private String condition;

        private Object value;

        private Object secondValue;

        private boolean noValue;

        private boolean singleValue;

        private boolean betweenValue;

        private boolean listValue;

        private String typeHandler;

        public String getCondition() {
            return condition;
        }

        public Object getValue() {
            return value;
        }

        public Object getSecondValue() {
            return secondValue;
        }

        public boolean isNoValue() {
            return noValue;
        }

        public boolean isSingleValue() {
            return singleValue;
        }

        public boolean isBetweenValue() {
            return betweenValue;
        }

        public boolean isListValue() {
            return listValue;
        }

        public String getTypeHandler() {
            return typeHandler;
        }

        protected Criterion(String condition) {
            super();
            this.condition = condition;
            this.typeHandler = null;
            this.noValue = true;
        }

        protected Criterion(String condition, Object value, String typeHandler) {
            super();
            this.condition = condition;
            this.value = value;
            this.typeHandler = typeHandler;
            if (value instanceof List<?>) {
                this.listValue = true;
            } else {
                this.singleValue = true;
            }
        }

        protected Criterion(String condition, Object value) {
            this(condition, value, null);
        }

        protected Criterion(String condition, Object value, Object secondValue, String typeHandler) {
            super();
            this.condition = condition;
            this.value = value;
            this.secondValue = secondValue;
            this.typeHandler = typeHandler;
            this.betweenValue = true;
        }

        protected Criterion(String condition, Object value, Object secondValue) {
            this(condition, value, secondValue, null);
        }
    }
}