package cc.ligu.mvc.persistence.entity;

import java.util.ArrayList;
import java.util.List;

public class PersonSalaryExample {
    /**
     * person_salary
     */
    protected String orderByClause;

    /**
     * person_salary
     */
    protected boolean distinct;

    /**
     * person_salary
     */
    protected List<Criteria> oredCriteria;

    public PersonSalaryExample() {
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
     * person_salary 2019-02-27
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

        public Criteria andPersonNameIsNull() {
            addCriterion("person_name is null");
            return (Criteria) this;
        }

        public Criteria andPersonNameIsNotNull() {
            addCriterion("person_name is not null");
            return (Criteria) this;
        }

        public Criteria andPersonNameEqualTo(String value) {
            addCriterion("person_name =", value, "personName");
            return (Criteria) this;
        }

        public Criteria andPersonNameNotEqualTo(String value) {
            addCriterion("person_name <>", value, "personName");
            return (Criteria) this;
        }

        public Criteria andPersonNameGreaterThan(String value) {
            addCriterion("person_name >", value, "personName");
            return (Criteria) this;
        }

        public Criteria andPersonNameGreaterThanOrEqualTo(String value) {
            addCriterion("person_name >=", value, "personName");
            return (Criteria) this;
        }

        public Criteria andPersonNameLessThan(String value) {
            addCriterion("person_name <", value, "personName");
            return (Criteria) this;
        }

        public Criteria andPersonNameLessThanOrEqualTo(String value) {
            addCriterion("person_name <=", value, "personName");
            return (Criteria) this;
        }

        public Criteria andPersonNameLike(String value) {
            addCriterion("person_name like", value, "personName");
            return (Criteria) this;
        }

        public Criteria andPersonNameNotLike(String value) {
            addCriterion("person_name not like", value, "personName");
            return (Criteria) this;
        }

        public Criteria andPersonNameIn(List<String> values) {
            addCriterion("person_name in", values, "personName");
            return (Criteria) this;
        }

        public Criteria andPersonNameNotIn(List<String> values) {
            addCriterion("person_name not in", values, "personName");
            return (Criteria) this;
        }

        public Criteria andPersonNameBetween(String value1, String value2) {
            addCriterion("person_name between", value1, value2, "personName");
            return (Criteria) this;
        }

        public Criteria andPersonNameNotBetween(String value1, String value2) {
            addCriterion("person_name not between", value1, value2, "personName");
            return (Criteria) this;
        }

        public Criteria andPersonNumIsNull() {
            addCriterion("person_num is null");
            return (Criteria) this;
        }

        public Criteria andPersonNumIsNotNull() {
            addCriterion("person_num is not null");
            return (Criteria) this;
        }

        public Criteria andPersonNumEqualTo(String value) {
            addCriterion("person_num =", value, "personNum");
            return (Criteria) this;
        }

        public Criteria andPersonNumNotEqualTo(String value) {
            addCriterion("person_num <>", value, "personNum");
            return (Criteria) this;
        }

        public Criteria andPersonNumGreaterThan(String value) {
            addCriterion("person_num >", value, "personNum");
            return (Criteria) this;
        }

        public Criteria andPersonNumGreaterThanOrEqualTo(String value) {
            addCriterion("person_num >=", value, "personNum");
            return (Criteria) this;
        }

        public Criteria andPersonNumLessThan(String value) {
            addCriterion("person_num <", value, "personNum");
            return (Criteria) this;
        }

        public Criteria andPersonNumLessThanOrEqualTo(String value) {
            addCriterion("person_num <=", value, "personNum");
            return (Criteria) this;
        }

        public Criteria andPersonNumLike(String value) {
            addCriterion("person_num like", value, "personNum");
            return (Criteria) this;
        }

        public Criteria andPersonNumNotLike(String value) {
            addCriterion("person_num not like", value, "personNum");
            return (Criteria) this;
        }

        public Criteria andPersonNumIn(List<String> values) {
            addCriterion("person_num in", values, "personNum");
            return (Criteria) this;
        }

        public Criteria andPersonNumNotIn(List<String> values) {
            addCriterion("person_num not in", values, "personNum");
            return (Criteria) this;
        }

        public Criteria andPersonNumBetween(String value1, String value2) {
            addCriterion("person_num between", value1, value2, "personNum");
            return (Criteria) this;
        }

        public Criteria andPersonNumNotBetween(String value1, String value2) {
            addCriterion("person_num not between", value1, value2, "personNum");
            return (Criteria) this;
        }

        public Criteria andSalaryLifeIsNull() {
            addCriterion("salary_life is null");
            return (Criteria) this;
        }

        public Criteria andSalaryLifeIsNotNull() {
            addCriterion("salary_life is not null");
            return (Criteria) this;
        }

        public Criteria andSalaryLifeEqualTo(String value) {
            addCriterion("salary_life =", value, "salaryLife");
            return (Criteria) this;
        }

        public Criteria andSalaryLifeNotEqualTo(String value) {
            addCriterion("salary_life <>", value, "salaryLife");
            return (Criteria) this;
        }

        public Criteria andSalaryLifeGreaterThan(String value) {
            addCriterion("salary_life >", value, "salaryLife");
            return (Criteria) this;
        }

        public Criteria andSalaryLifeGreaterThanOrEqualTo(String value) {
            addCriterion("salary_life >=", value, "salaryLife");
            return (Criteria) this;
        }

        public Criteria andSalaryLifeLessThan(String value) {
            addCriterion("salary_life <", value, "salaryLife");
            return (Criteria) this;
        }

        public Criteria andSalaryLifeLessThanOrEqualTo(String value) {
            addCriterion("salary_life <=", value, "salaryLife");
            return (Criteria) this;
        }

        public Criteria andSalaryLifeLike(String value) {
            addCriterion("salary_life like", value, "salaryLife");
            return (Criteria) this;
        }

        public Criteria andSalaryLifeNotLike(String value) {
            addCriterion("salary_life not like", value, "salaryLife");
            return (Criteria) this;
        }

        public Criteria andSalaryLifeIn(List<String> values) {
            addCriterion("salary_life in", values, "salaryLife");
            return (Criteria) this;
        }

        public Criteria andSalaryLifeNotIn(List<String> values) {
            addCriterion("salary_life not in", values, "salaryLife");
            return (Criteria) this;
        }

        public Criteria andSalaryLifeBetween(String value1, String value2) {
            addCriterion("salary_life between", value1, value2, "salaryLife");
            return (Criteria) this;
        }

        public Criteria andSalaryLifeNotBetween(String value1, String value2) {
            addCriterion("salary_life not between", value1, value2, "salaryLife");
            return (Criteria) this;
        }

        public Criteria andSalarySumIsNull() {
            addCriterion("salary_sum is null");
            return (Criteria) this;
        }

        public Criteria andSalarySumIsNotNull() {
            addCriterion("salary_sum is not null");
            return (Criteria) this;
        }

        public Criteria andSalarySumEqualTo(String value) {
            addCriterion("salary_sum =", value, "salarySum");
            return (Criteria) this;
        }

        public Criteria andSalarySumNotEqualTo(String value) {
            addCriterion("salary_sum <>", value, "salarySum");
            return (Criteria) this;
        }

        public Criteria andSalarySumGreaterThan(String value) {
            addCriterion("salary_sum >", value, "salarySum");
            return (Criteria) this;
        }

        public Criteria andSalarySumGreaterThanOrEqualTo(String value) {
            addCriterion("salary_sum >=", value, "salarySum");
            return (Criteria) this;
        }

        public Criteria andSalarySumLessThan(String value) {
            addCriterion("salary_sum <", value, "salarySum");
            return (Criteria) this;
        }

        public Criteria andSalarySumLessThanOrEqualTo(String value) {
            addCriterion("salary_sum <=", value, "salarySum");
            return (Criteria) this;
        }

        public Criteria andSalarySumLike(String value) {
            addCriterion("salary_sum like", value, "salarySum");
            return (Criteria) this;
        }

        public Criteria andSalarySumNotLike(String value) {
            addCriterion("salary_sum not like", value, "salarySum");
            return (Criteria) this;
        }

        public Criteria andSalarySumIn(List<String> values) {
            addCriterion("salary_sum in", values, "salarySum");
            return (Criteria) this;
        }

        public Criteria andSalarySumNotIn(List<String> values) {
            addCriterion("salary_sum not in", values, "salarySum");
            return (Criteria) this;
        }

        public Criteria andSalarySumBetween(String value1, String value2) {
            addCriterion("salary_sum between", value1, value2, "salarySum");
            return (Criteria) this;
        }

        public Criteria andSalarySumNotBetween(String value1, String value2) {
            addCriterion("salary_sum not between", value1, value2, "salarySum");
            return (Criteria) this;
        }

        public Criteria andTimeLifeIsNull() {
            addCriterion("time_life is null");
            return (Criteria) this;
        }

        public Criteria andTimeLifeIsNotNull() {
            addCriterion("time_life is not null");
            return (Criteria) this;
        }

        public Criteria andTimeLifeEqualTo(String value) {
            addCriterion("time_life =", value, "timeLife");
            return (Criteria) this;
        }

        public Criteria andTimeLifeNotEqualTo(String value) {
            addCriterion("time_life <>", value, "timeLife");
            return (Criteria) this;
        }

        public Criteria andTimeLifeGreaterThan(String value) {
            addCriterion("time_life >", value, "timeLife");
            return (Criteria) this;
        }

        public Criteria andTimeLifeGreaterThanOrEqualTo(String value) {
            addCriterion("time_life >=", value, "timeLife");
            return (Criteria) this;
        }

        public Criteria andTimeLifeLessThan(String value) {
            addCriterion("time_life <", value, "timeLife");
            return (Criteria) this;
        }

        public Criteria andTimeLifeLessThanOrEqualTo(String value) {
            addCriterion("time_life <=", value, "timeLife");
            return (Criteria) this;
        }

        public Criteria andTimeLifeLike(String value) {
            addCriterion("time_life like", value, "timeLife");
            return (Criteria) this;
        }

        public Criteria andTimeLifeNotLike(String value) {
            addCriterion("time_life not like", value, "timeLife");
            return (Criteria) this;
        }

        public Criteria andTimeLifeIn(List<String> values) {
            addCriterion("time_life in", values, "timeLife");
            return (Criteria) this;
        }

        public Criteria andTimeLifeNotIn(List<String> values) {
            addCriterion("time_life not in", values, "timeLife");
            return (Criteria) this;
        }

        public Criteria andTimeLifeBetween(String value1, String value2) {
            addCriterion("time_life between", value1, value2, "timeLife");
            return (Criteria) this;
        }

        public Criteria andTimeLifeNotBetween(String value1, String value2) {
            addCriterion("time_life not between", value1, value2, "timeLife");
            return (Criteria) this;
        }

        public Criteria andTimeSumIsNull() {
            addCriterion("time_sum is null");
            return (Criteria) this;
        }

        public Criteria andTimeSumIsNotNull() {
            addCriterion("time_sum is not null");
            return (Criteria) this;
        }

        public Criteria andTimeSumEqualTo(String value) {
            addCriterion("time_sum =", value, "timeSum");
            return (Criteria) this;
        }

        public Criteria andTimeSumNotEqualTo(String value) {
            addCriterion("time_sum <>", value, "timeSum");
            return (Criteria) this;
        }

        public Criteria andTimeSumGreaterThan(String value) {
            addCriterion("time_sum >", value, "timeSum");
            return (Criteria) this;
        }

        public Criteria andTimeSumGreaterThanOrEqualTo(String value) {
            addCriterion("time_sum >=", value, "timeSum");
            return (Criteria) this;
        }

        public Criteria andTimeSumLessThan(String value) {
            addCriterion("time_sum <", value, "timeSum");
            return (Criteria) this;
        }

        public Criteria andTimeSumLessThanOrEqualTo(String value) {
            addCriterion("time_sum <=", value, "timeSum");
            return (Criteria) this;
        }

        public Criteria andTimeSumLike(String value) {
            addCriterion("time_sum like", value, "timeSum");
            return (Criteria) this;
        }

        public Criteria andTimeSumNotLike(String value) {
            addCriterion("time_sum not like", value, "timeSum");
            return (Criteria) this;
        }

        public Criteria andTimeSumIn(List<String> values) {
            addCriterion("time_sum in", values, "timeSum");
            return (Criteria) this;
        }

        public Criteria andTimeSumNotIn(List<String> values) {
            addCriterion("time_sum not in", values, "timeSum");
            return (Criteria) this;
        }

        public Criteria andTimeSumBetween(String value1, String value2) {
            addCriterion("time_sum between", value1, value2, "timeSum");
            return (Criteria) this;
        }

        public Criteria andTimeSumNotBetween(String value1, String value2) {
            addCriterion("time_sum not between", value1, value2, "timeSum");
            return (Criteria) this;
        }

        public Criteria andZhengJuUrlsIsNull() {
            addCriterion("zheng_ju_urls is null");
            return (Criteria) this;
        }

        public Criteria andZhengJuUrlsIsNotNull() {
            addCriterion("zheng_ju_urls is not null");
            return (Criteria) this;
        }

        public Criteria andZhengJuUrlsEqualTo(String value) {
            addCriterion("zheng_ju_urls =", value, "zhengJuUrls");
            return (Criteria) this;
        }

        public Criteria andZhengJuUrlsNotEqualTo(String value) {
            addCriterion("zheng_ju_urls <>", value, "zhengJuUrls");
            return (Criteria) this;
        }

        public Criteria andZhengJuUrlsGreaterThan(String value) {
            addCriterion("zheng_ju_urls >", value, "zhengJuUrls");
            return (Criteria) this;
        }

        public Criteria andZhengJuUrlsGreaterThanOrEqualTo(String value) {
            addCriterion("zheng_ju_urls >=", value, "zhengJuUrls");
            return (Criteria) this;
        }

        public Criteria andZhengJuUrlsLessThan(String value) {
            addCriterion("zheng_ju_urls <", value, "zhengJuUrls");
            return (Criteria) this;
        }

        public Criteria andZhengJuUrlsLessThanOrEqualTo(String value) {
            addCriterion("zheng_ju_urls <=", value, "zhengJuUrls");
            return (Criteria) this;
        }

        public Criteria andZhengJuUrlsLike(String value) {
            addCriterion("zheng_ju_urls like", value, "zhengJuUrls");
            return (Criteria) this;
        }

        public Criteria andZhengJuUrlsNotLike(String value) {
            addCriterion("zheng_ju_urls not like", value, "zhengJuUrls");
            return (Criteria) this;
        }

        public Criteria andZhengJuUrlsIn(List<String> values) {
            addCriterion("zheng_ju_urls in", values, "zhengJuUrls");
            return (Criteria) this;
        }

        public Criteria andZhengJuUrlsNotIn(List<String> values) {
            addCriterion("zheng_ju_urls not in", values, "zhengJuUrls");
            return (Criteria) this;
        }

        public Criteria andZhengJuUrlsBetween(String value1, String value2) {
            addCriterion("zheng_ju_urls between", value1, value2, "zhengJuUrls");
            return (Criteria) this;
        }

        public Criteria andZhengJuUrlsNotBetween(String value1, String value2) {
            addCriterion("zheng_ju_urls not between", value1, value2, "zhengJuUrls");
            return (Criteria) this;
        }

        public Criteria andPersonNameLikeInsensitive(String value) {
            addCriterion("upper(person_name) like", value.toUpperCase(), "personName");
            return (Criteria) this;
        }

        public Criteria andPersonNumLikeInsensitive(String value) {
            addCriterion("upper(person_num) like", value.toUpperCase(), "personNum");
            return (Criteria) this;
        }

        public Criteria andSalaryLifeLikeInsensitive(String value) {
            addCriterion("upper(salary_life) like", value.toUpperCase(), "salaryLife");
            return (Criteria) this;
        }

        public Criteria andSalarySumLikeInsensitive(String value) {
            addCriterion("upper(salary_sum) like", value.toUpperCase(), "salarySum");
            return (Criteria) this;
        }

        public Criteria andTimeLifeLikeInsensitive(String value) {
            addCriterion("upper(time_life) like", value.toUpperCase(), "timeLife");
            return (Criteria) this;
        }

        public Criteria andTimeSumLikeInsensitive(String value) {
            addCriterion("upper(time_sum) like", value.toUpperCase(), "timeSum");
            return (Criteria) this;
        }

        public Criteria andZhengJuUrlsLikeInsensitive(String value) {
            addCriterion("upper(zheng_ju_urls) like", value.toUpperCase(), "zhengJuUrls");
            return (Criteria) this;
        }
    }

    /**
     * person_salary
     */
    public static class Criteria extends GeneratedCriteria {

        protected Criteria() {
            super();
        }
    }

    /**
     * person_salary 2019-02-27
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