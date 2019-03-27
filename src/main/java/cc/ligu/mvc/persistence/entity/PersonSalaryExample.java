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
     * person_salary 2019-02-28
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

        public Criteria andFeeTypeIsNull() {
            addCriterion("fee_type is null");
            return (Criteria) this;
        }

        public Criteria andFeeTypeIsNotNull() {
            addCriterion("fee_type is not null");
            return (Criteria) this;
        }

        public Criteria andFeeTypeEqualTo(String value) {
            addCriterion("fee_type =", value, "feeType");
            return (Criteria) this;
        }

        public Criteria andFeeTypeNotEqualTo(String value) {
            addCriterion("fee_type <>", value, "feeType");
            return (Criteria) this;
        }

        public Criteria andFeeTypeGreaterThan(String value) {
            addCriterion("fee_type >", value, "feeType");
            return (Criteria) this;
        }

        public Criteria andFeeTypeGreaterThanOrEqualTo(String value) {
            addCriterion("fee_type >=", value, "feeType");
            return (Criteria) this;
        }

        public Criteria andFeeTypeLessThan(String value) {
            addCriterion("fee_type <", value, "feeType");
            return (Criteria) this;
        }

        public Criteria andFeeTypeLessThanOrEqualTo(String value) {
            addCriterion("fee_type <=", value, "feeType");
            return (Criteria) this;
        }

        public Criteria andFeeTypeLike(String value) {
            addCriterion("fee_type like", value, "feeType");
            return (Criteria) this;
        }

        public Criteria andFeeTypeNotLike(String value) {
            addCriterion("fee_type not like", value, "feeType");
            return (Criteria) this;
        }

        public Criteria andFeeTypeIn(List<String> values) {
            addCriterion("fee_type in", values, "feeType");
            return (Criteria) this;
        }

        public Criteria andFeeTypeNotIn(List<String> values) {
            addCriterion("fee_type not in", values, "feeType");
            return (Criteria) this;
        }

        public Criteria andFeeTypeBetween(String value1, String value2) {
            addCriterion("fee_type between", value1, value2, "feeType");
            return (Criteria) this;
        }

        public Criteria andFeeTypeNotBetween(String value1, String value2) {
            addCriterion("fee_type not between", value1, value2, "feeType");
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

        public Criteria andSendTimeIsNull() {
            addCriterion("send_time is null");
            return (Criteria) this;
        }

        public Criteria andSendTimeIsNotNull() {
            addCriterion("send_time is not null");
            return (Criteria) this;
        }

        public Criteria andSendTimeEqualTo(String value) {
            addCriterion("send_time =", value, "sendTime");
            return (Criteria) this;
        }

        public Criteria andSendTimeNotEqualTo(String value) {
            addCriterion("send_time <>", value, "sendTime");
            return (Criteria) this;
        }

        public Criteria andSendTimeGreaterThan(String value) {
            addCriterion("send_time >", value, "sendTime");
            return (Criteria) this;
        }

        public Criteria andSendTimeGreaterThanOrEqualTo(String value) {
            addCriterion("send_time >=", value, "sendTime");
            return (Criteria) this;
        }

        public Criteria andSendTimeLessThan(String value) {
            addCriterion("send_time <", value, "sendTime");
            return (Criteria) this;
        }

        public Criteria andSendTimeLessThanOrEqualTo(String value) {
            addCriterion("send_time <=", value, "sendTime");
            return (Criteria) this;
        }

        public Criteria andSendTimeLike(String value) {
            addCriterion("send_time like", value, "sendTime");
            return (Criteria) this;
        }

        public Criteria andSendTimeNotLike(String value) {
            addCriterion("send_time not like", value, "sendTime");
            return (Criteria) this;
        }

        public Criteria andSendTimeIn(List<String> values) {
            addCriterion("send_time in", values, "sendTime");
            return (Criteria) this;
        }

        public Criteria andSendTimeNotIn(List<String> values) {
            addCriterion("send_time not in", values, "sendTime");
            return (Criteria) this;
        }

        public Criteria andSendTimeBetween(String value1, String value2) {
            addCriterion("send_time between", value1, value2, "sendTime");
            return (Criteria) this;
        }

        public Criteria andSendTimeNotBetween(String value1, String value2) {
            addCriterion("send_time not between", value1, value2, "sendTime");
            return (Criteria) this;
        }

        public Criteria andSendMuchIsNull() {
            addCriterion("send_much is null");
            return (Criteria) this;
        }

        public Criteria andSendMuchIsNotNull() {
            addCriterion("send_much is not null");
            return (Criteria) this;
        }

        public Criteria andSendMuchEqualTo(String value) {
            addCriterion("send_much =", value, "sendMuch");
            return (Criteria) this;
        }

        public Criteria andSendMuchNotEqualTo(String value) {
            addCriterion("send_much <>", value, "sendMuch");
            return (Criteria) this;
        }

        public Criteria andSendMuchGreaterThan(String value) {
            addCriterion("send_much >", value, "sendMuch");
            return (Criteria) this;
        }

        public Criteria andSendMuchGreaterThanOrEqualTo(String value) {
            addCriterion("send_much >=", value, "sendMuch");
            return (Criteria) this;
        }

        public Criteria andSendMuchLessThan(String value) {
            addCriterion("send_much <", value, "sendMuch");
            return (Criteria) this;
        }

        public Criteria andSendMuchLessThanOrEqualTo(String value) {
            addCriterion("send_much <=", value, "sendMuch");
            return (Criteria) this;
        }

        public Criteria andSendMuchLike(String value) {
            addCriterion("send_much like", value, "sendMuch");
            return (Criteria) this;
        }

        public Criteria andSendMuchNotLike(String value) {
            addCriterion("send_much not like", value, "sendMuch");
            return (Criteria) this;
        }

        public Criteria andSendMuchIn(List<String> values) {
            addCriterion("send_much in", values, "sendMuch");
            return (Criteria) this;
        }

        public Criteria andSendMuchNotIn(List<String> values) {
            addCriterion("send_much not in", values, "sendMuch");
            return (Criteria) this;
        }

        public Criteria andSendMuchBetween(String value1, String value2) {
            addCriterion("send_much between", value1, value2, "sendMuch");
            return (Criteria) this;
        }

        public Criteria andSendMuchNotBetween(String value1, String value2) {
            addCriterion("send_much not between", value1, value2, "sendMuch");
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

        public Criteria andFeeTypeLikeInsensitive(String value) {
            addCriterion("upper(fee_type) like", value.toUpperCase(), "feeType");
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

        public Criteria andSendTimeLikeInsensitive(String value) {
            addCriterion("upper(send_time) like", value.toUpperCase(), "sendTime");
            return (Criteria) this;
        }

        public Criteria andSendMuchLikeInsensitive(String value) {
            addCriterion("upper(send_much) like", value.toUpperCase(), "sendMuch");
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
     * person_salary 2019-02-28
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