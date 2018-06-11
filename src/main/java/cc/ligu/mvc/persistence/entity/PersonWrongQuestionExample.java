package cc.ligu.mvc.persistence.entity;

import java.util.ArrayList;
import java.util.List;

public class PersonWrongQuestionExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public PersonWrongQuestionExample() {
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

        public Criteria andQuestionIdIsNull() {
            addCriterion("question_id is null");
            return (Criteria) this;
        }

        public Criteria andQuestionIdIsNotNull() {
            addCriterion("question_id is not null");
            return (Criteria) this;
        }

        public Criteria andQuestionIdEqualTo(Integer value) {
            addCriterion("question_id =", value, "questionId");
            return (Criteria) this;
        }

        public Criteria andQuestionIdNotEqualTo(Integer value) {
            addCriterion("question_id <>", value, "questionId");
            return (Criteria) this;
        }

        public Criteria andQuestionIdGreaterThan(Integer value) {
            addCriterion("question_id >", value, "questionId");
            return (Criteria) this;
        }

        public Criteria andQuestionIdGreaterThanOrEqualTo(Integer value) {
            addCriterion("question_id >=", value, "questionId");
            return (Criteria) this;
        }

        public Criteria andQuestionIdLessThan(Integer value) {
            addCriterion("question_id <", value, "questionId");
            return (Criteria) this;
        }

        public Criteria andQuestionIdLessThanOrEqualTo(Integer value) {
            addCriterion("question_id <=", value, "questionId");
            return (Criteria) this;
        }

        public Criteria andQuestionIdIn(List<Integer> values) {
            addCriterion("question_id in", values, "questionId");
            return (Criteria) this;
        }

        public Criteria andQuestionIdNotIn(List<Integer> values) {
            addCriterion("question_id not in", values, "questionId");
            return (Criteria) this;
        }

        public Criteria andQuestionIdBetween(Integer value1, Integer value2) {
            addCriterion("question_id between", value1, value2, "questionId");
            return (Criteria) this;
        }

        public Criteria andQuestionIdNotBetween(Integer value1, Integer value2) {
            addCriterion("question_id not between", value1, value2, "questionId");
            return (Criteria) this;
        }

        public Criteria andYourAnswerIsNull() {
            addCriterion("your_answer is null");
            return (Criteria) this;
        }

        public Criteria andYourAnswerIsNotNull() {
            addCriterion("your_answer is not null");
            return (Criteria) this;
        }

        public Criteria andYourAnswerEqualTo(String value) {
            addCriterion("your_answer =", value, "yourAnswer");
            return (Criteria) this;
        }

        public Criteria andYourAnswerNotEqualTo(String value) {
            addCriterion("your_answer <>", value, "yourAnswer");
            return (Criteria) this;
        }

        public Criteria andYourAnswerGreaterThan(String value) {
            addCriterion("your_answer >", value, "yourAnswer");
            return (Criteria) this;
        }

        public Criteria andYourAnswerGreaterThanOrEqualTo(String value) {
            addCriterion("your_answer >=", value, "yourAnswer");
            return (Criteria) this;
        }

        public Criteria andYourAnswerLessThan(String value) {
            addCriterion("your_answer <", value, "yourAnswer");
            return (Criteria) this;
        }

        public Criteria andYourAnswerLessThanOrEqualTo(String value) {
            addCriterion("your_answer <=", value, "yourAnswer");
            return (Criteria) this;
        }

        public Criteria andYourAnswerLike(String value) {
            addCriterion("your_answer like", value, "yourAnswer");
            return (Criteria) this;
        }

        public Criteria andYourAnswerNotLike(String value) {
            addCriterion("your_answer not like", value, "yourAnswer");
            return (Criteria) this;
        }

        public Criteria andYourAnswerIn(List<String> values) {
            addCriterion("your_answer in", values, "yourAnswer");
            return (Criteria) this;
        }

        public Criteria andYourAnswerNotIn(List<String> values) {
            addCriterion("your_answer not in", values, "yourAnswer");
            return (Criteria) this;
        }

        public Criteria andYourAnswerBetween(String value1, String value2) {
            addCriterion("your_answer between", value1, value2, "yourAnswer");
            return (Criteria) this;
        }

        public Criteria andYourAnswerNotBetween(String value1, String value2) {
            addCriterion("your_answer not between", value1, value2, "yourAnswer");
            return (Criteria) this;
        }

        public Criteria andCorrectAnswerIsNull() {
            addCriterion("correct_answer is null");
            return (Criteria) this;
        }

        public Criteria andCorrectAnswerIsNotNull() {
            addCriterion("correct_answer is not null");
            return (Criteria) this;
        }

        public Criteria andCorrectAnswerEqualTo(String value) {
            addCriterion("correct_answer =", value, "correctAnswer");
            return (Criteria) this;
        }

        public Criteria andCorrectAnswerNotEqualTo(String value) {
            addCriterion("correct_answer <>", value, "correctAnswer");
            return (Criteria) this;
        }

        public Criteria andCorrectAnswerGreaterThan(String value) {
            addCriterion("correct_answer >", value, "correctAnswer");
            return (Criteria) this;
        }

        public Criteria andCorrectAnswerGreaterThanOrEqualTo(String value) {
            addCriterion("correct_answer >=", value, "correctAnswer");
            return (Criteria) this;
        }

        public Criteria andCorrectAnswerLessThan(String value) {
            addCriterion("correct_answer <", value, "correctAnswer");
            return (Criteria) this;
        }

        public Criteria andCorrectAnswerLessThanOrEqualTo(String value) {
            addCriterion("correct_answer <=", value, "correctAnswer");
            return (Criteria) this;
        }

        public Criteria andCorrectAnswerLike(String value) {
            addCriterion("correct_answer like", value, "correctAnswer");
            return (Criteria) this;
        }

        public Criteria andCorrectAnswerNotLike(String value) {
            addCriterion("correct_answer not like", value, "correctAnswer");
            return (Criteria) this;
        }

        public Criteria andCorrectAnswerIn(List<String> values) {
            addCriterion("correct_answer in", values, "correctAnswer");
            return (Criteria) this;
        }

        public Criteria andCorrectAnswerNotIn(List<String> values) {
            addCriterion("correct_answer not in", values, "correctAnswer");
            return (Criteria) this;
        }

        public Criteria andCorrectAnswerBetween(String value1, String value2) {
            addCriterion("correct_answer between", value1, value2, "correctAnswer");
            return (Criteria) this;
        }

        public Criteria andCorrectAnswerNotBetween(String value1, String value2) {
            addCriterion("correct_answer not between", value1, value2, "correctAnswer");
            return (Criteria) this;
        }

        public Criteria andYourAnswerLikeInsensitive(String value) {
            addCriterion("upper(your_answer) like", value.toUpperCase(), "yourAnswer");
            return (Criteria) this;
        }

        public Criteria andCorrectAnswerLikeInsensitive(String value) {
            addCriterion("upper(correct_answer) like", value.toUpperCase(), "correctAnswer");
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