package cc.ligu.mvc.persistence.entity;

import java.util.ArrayList;
import java.util.List;

public class PersonExamHistoryExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public PersonExamHistoryExample() {
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

        public Criteria andPersonIdIsNull() {
            addCriterion("person_id is null");
            return (Criteria) this;
        }

        public Criteria andPersonIdIsNotNull() {
            addCriterion("person_id is not null");
            return (Criteria) this;
        }

        public Criteria andPersonIdEqualTo(Integer value) {
            addCriterion("person_id =", value, "personId");
            return (Criteria) this;
        }

        public Criteria andPersonIdNotEqualTo(Integer value) {
            addCriterion("person_id <>", value, "personId");
            return (Criteria) this;
        }

        public Criteria andPersonIdGreaterThan(Integer value) {
            addCriterion("person_id >", value, "personId");
            return (Criteria) this;
        }

        public Criteria andPersonIdGreaterThanOrEqualTo(Integer value) {
            addCriterion("person_id >=", value, "personId");
            return (Criteria) this;
        }

        public Criteria andPersonIdLessThan(Integer value) {
            addCriterion("person_id <", value, "personId");
            return (Criteria) this;
        }

        public Criteria andPersonIdLessThanOrEqualTo(Integer value) {
            addCriterion("person_id <=", value, "personId");
            return (Criteria) this;
        }

        public Criteria andPersonIdIn(List<Integer> values) {
            addCriterion("person_id in", values, "personId");
            return (Criteria) this;
        }

        public Criteria andPersonIdNotIn(List<Integer> values) {
            addCriterion("person_id not in", values, "personId");
            return (Criteria) this;
        }

        public Criteria andPersonIdBetween(Integer value1, Integer value2) {
            addCriterion("person_id between", value1, value2, "personId");
            return (Criteria) this;
        }

        public Criteria andPersonIdNotBetween(Integer value1, Integer value2) {
            addCriterion("person_id not between", value1, value2, "personId");
            return (Criteria) this;
        }

        public Criteria andFullScoreIsNull() {
            addCriterion("full_score is null");
            return (Criteria) this;
        }

        public Criteria andFullScoreIsNotNull() {
            addCriterion("full_score is not null");
            return (Criteria) this;
        }

        public Criteria andFullScoreEqualTo(String value) {
            addCriterion("full_score =", value, "fullScore");
            return (Criteria) this;
        }

        public Criteria andFullScoreNotEqualTo(String value) {
            addCriterion("full_score <>", value, "fullScore");
            return (Criteria) this;
        }

        public Criteria andFullScoreGreaterThan(String value) {
            addCriterion("full_score >", value, "fullScore");
            return (Criteria) this;
        }

        public Criteria andFullScoreGreaterThanOrEqualTo(String value) {
            addCriterion("full_score >=", value, "fullScore");
            return (Criteria) this;
        }

        public Criteria andFullScoreLessThan(String value) {
            addCriterion("full_score <", value, "fullScore");
            return (Criteria) this;
        }

        public Criteria andFullScoreLessThanOrEqualTo(String value) {
            addCriterion("full_score <=", value, "fullScore");
            return (Criteria) this;
        }

        public Criteria andFullScoreLike(String value) {
            addCriterion("full_score like", value, "fullScore");
            return (Criteria) this;
        }

        public Criteria andFullScoreNotLike(String value) {
            addCriterion("full_score not like", value, "fullScore");
            return (Criteria) this;
        }

        public Criteria andFullScoreIn(List<String> values) {
            addCriterion("full_score in", values, "fullScore");
            return (Criteria) this;
        }

        public Criteria andFullScoreNotIn(List<String> values) {
            addCriterion("full_score not in", values, "fullScore");
            return (Criteria) this;
        }

        public Criteria andFullScoreBetween(String value1, String value2) {
            addCriterion("full_score between", value1, value2, "fullScore");
            return (Criteria) this;
        }

        public Criteria andFullScoreNotBetween(String value1, String value2) {
            addCriterion("full_score not between", value1, value2, "fullScore");
            return (Criteria) this;
        }

        public Criteria andObtainScoreIsNull() {
            addCriterion("obtain_score is null");
            return (Criteria) this;
        }

        public Criteria andObtainScoreIsNotNull() {
            addCriterion("obtain_score is not null");
            return (Criteria) this;
        }

        public Criteria andObtainScoreEqualTo(String value) {
            addCriterion("obtain_score =", value, "obtainScore");
            return (Criteria) this;
        }

        public Criteria andObtainScoreNotEqualTo(String value) {
            addCriterion("obtain_score <>", value, "obtainScore");
            return (Criteria) this;
        }

        public Criteria andObtainScoreGreaterThan(String value) {
            addCriterion("obtain_score >", value, "obtainScore");
            return (Criteria) this;
        }

        public Criteria andObtainScoreGreaterThanOrEqualTo(String value) {
            addCriterion("obtain_score >=", value, "obtainScore");
            return (Criteria) this;
        }

        public Criteria andObtainScoreLessThan(String value) {
            addCriterion("obtain_score <", value, "obtainScore");
            return (Criteria) this;
        }

        public Criteria andObtainScoreLessThanOrEqualTo(String value) {
            addCriterion("obtain_score <=", value, "obtainScore");
            return (Criteria) this;
        }

        public Criteria andObtainScoreLike(String value) {
            addCriterion("obtain_score like", value, "obtainScore");
            return (Criteria) this;
        }

        public Criteria andObtainScoreNotLike(String value) {
            addCriterion("obtain_score not like", value, "obtainScore");
            return (Criteria) this;
        }

        public Criteria andObtainScoreIn(List<String> values) {
            addCriterion("obtain_score in", values, "obtainScore");
            return (Criteria) this;
        }

        public Criteria andObtainScoreNotIn(List<String> values) {
            addCriterion("obtain_score not in", values, "obtainScore");
            return (Criteria) this;
        }

        public Criteria andObtainScoreBetween(String value1, String value2) {
            addCriterion("obtain_score between", value1, value2, "obtainScore");
            return (Criteria) this;
        }

        public Criteria andObtainScoreNotBetween(String value1, String value2) {
            addCriterion("obtain_score not between", value1, value2, "obtainScore");
            return (Criteria) this;
        }

        public Criteria andExamTimeIsNull() {
            addCriterion("exam_time is null");
            return (Criteria) this;
        }

        public Criteria andExamTimeIsNotNull() {
            addCriterion("exam_time is not null");
            return (Criteria) this;
        }

        public Criteria andExamTimeEqualTo(String value) {
            addCriterion("exam_time =", value, "examTime");
            return (Criteria) this;
        }

        public Criteria andExamTimeNotEqualTo(String value) {
            addCriterion("exam_time <>", value, "examTime");
            return (Criteria) this;
        }

        public Criteria andExamTimeGreaterThan(String value) {
            addCriterion("exam_time >", value, "examTime");
            return (Criteria) this;
        }

        public Criteria andExamTimeGreaterThanOrEqualTo(String value) {
            addCriterion("exam_time >=", value, "examTime");
            return (Criteria) this;
        }

        public Criteria andExamTimeLessThan(String value) {
            addCriterion("exam_time <", value, "examTime");
            return (Criteria) this;
        }

        public Criteria andExamTimeLessThanOrEqualTo(String value) {
            addCriterion("exam_time <=", value, "examTime");
            return (Criteria) this;
        }

        public Criteria andExamTimeLike(String value) {
            addCriterion("exam_time like", value, "examTime");
            return (Criteria) this;
        }

        public Criteria andExamTimeNotLike(String value) {
            addCriterion("exam_time not like", value, "examTime");
            return (Criteria) this;
        }

        public Criteria andExamTimeIn(List<String> values) {
            addCriterion("exam_time in", values, "examTime");
            return (Criteria) this;
        }

        public Criteria andExamTimeNotIn(List<String> values) {
            addCriterion("exam_time not in", values, "examTime");
            return (Criteria) this;
        }

        public Criteria andExamTimeBetween(String value1, String value2) {
            addCriterion("exam_time between", value1, value2, "examTime");
            return (Criteria) this;
        }

        public Criteria andExamTimeNotBetween(String value1, String value2) {
            addCriterion("exam_time not between", value1, value2, "examTime");
            return (Criteria) this;
        }

        public Criteria andExamTypeIsNull() {
            addCriterion("exam_type is null");
            return (Criteria) this;
        }

        public Criteria andExamTypeIsNotNull() {
            addCriterion("exam_type is not null");
            return (Criteria) this;
        }

        public Criteria andExamTypeEqualTo(Integer value) {
            addCriterion("exam_type =", value, "examType");
            return (Criteria) this;
        }

        public Criteria andExamTypeNotEqualTo(Integer value) {
            addCriterion("exam_type <>", value, "examType");
            return (Criteria) this;
        }

        public Criteria andExamTypeGreaterThan(Integer value) {
            addCriterion("exam_type >", value, "examType");
            return (Criteria) this;
        }

        public Criteria andExamTypeGreaterThanOrEqualTo(Integer value) {
            addCriterion("exam_type >=", value, "examType");
            return (Criteria) this;
        }

        public Criteria andExamTypeLessThan(Integer value) {
            addCriterion("exam_type <", value, "examType");
            return (Criteria) this;
        }

        public Criteria andExamTypeLessThanOrEqualTo(Integer value) {
            addCriterion("exam_type <=", value, "examType");
            return (Criteria) this;
        }

        public Criteria andExamTypeIn(List<Integer> values) {
            addCriterion("exam_type in", values, "examType");
            return (Criteria) this;
        }

        public Criteria andExamTypeNotIn(List<Integer> values) {
            addCriterion("exam_type not in", values, "examType");
            return (Criteria) this;
        }

        public Criteria andExamTypeBetween(Integer value1, Integer value2) {
            addCriterion("exam_type between", value1, value2, "examType");
            return (Criteria) this;
        }

        public Criteria andExamTypeNotBetween(Integer value1, Integer value2) {
            addCriterion("exam_type not between", value1, value2, "examType");
            return (Criteria) this;
        }

        public Criteria andFullScoreLikeInsensitive(String value) {
            addCriterion("upper(full_score) like", value.toUpperCase(), "fullScore");
            return (Criteria) this;
        }

        public Criteria andObtainScoreLikeInsensitive(String value) {
            addCriterion("upper(obtain_score) like", value.toUpperCase(), "obtainScore");
            return (Criteria) this;
        }

        public Criteria andExamTimeLikeInsensitive(String value) {
            addCriterion("upper(exam_time) like", value.toUpperCase(), "examTime");
            return (Criteria) this;
        }
    }

    public static class Criteria extends GeneratedCriteria {

        protected Criteria() {
            super();
        }
    }

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