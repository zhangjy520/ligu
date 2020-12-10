package cc.ligu.mvc.persistence.entity;

import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

public class MoneyExample {
    /**
     * money
     */
    protected String orderByClause;

    /**
     * money
     */
    protected boolean distinct;

    /**
     * money
     */
    protected List<Criteria> oredCriteria;

    public MoneyExample() {
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
     * money 2020-09-15
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

        protected void addCriterionForJDBCDate(String condition, Date value, String property) {
            if (value == null) {
                throw new RuntimeException("Value for " + property + " cannot be null");
            }
            addCriterion(condition, new java.sql.Date(value.getTime()), property);
        }

        protected void addCriterionForJDBCDate(String condition, List<Date> values, String property) {
            if (values == null || values.size() == 0) {
                throw new RuntimeException("Value list for " + property + " cannot be null or empty");
            }
            List<java.sql.Date> dateList = new ArrayList<java.sql.Date>();
            Iterator<Date> iter = values.iterator();
            while (iter.hasNext()) {
                dateList.add(new java.sql.Date(iter.next().getTime()));
            }
            addCriterion(condition, dateList, property);
        }

        protected void addCriterionForJDBCDate(String condition, Date value1, Date value2, String property) {
            if (value1 == null || value2 == null) {
                throw new RuntimeException("Between values for " + property + " cannot be null");
            }
            addCriterion(condition, new java.sql.Date(value1.getTime()), new java.sql.Date(value2.getTime()), property);
        }

        public Criteria andMoneyNameIsNull() {
            addCriterion("money_name is null");
            return (Criteria) this;
        }

        public Criteria andMoneyNameIsNotNull() {
            addCriterion("money_name is not null");
            return (Criteria) this;
        }

        public Criteria andMoneyNameEqualTo(String value) {
            addCriterion("money_name =", value, "moneyName");
            return (Criteria) this;
        }

        public Criteria andMoneyNameNotEqualTo(String value) {
            addCriterion("money_name <>", value, "moneyName");
            return (Criteria) this;
        }

        public Criteria andMoneyNameGreaterThan(String value) {
            addCriterion("money_name >", value, "moneyName");
            return (Criteria) this;
        }

        public Criteria andMoneyNameGreaterThanOrEqualTo(String value) {
            addCriterion("money_name >=", value, "moneyName");
            return (Criteria) this;
        }

        public Criteria andMoneyNameLessThan(String value) {
            addCriterion("money_name <", value, "moneyName");
            return (Criteria) this;
        }

        public Criteria andMoneyNameLessThanOrEqualTo(String value) {
            addCriterion("money_name <=", value, "moneyName");
            return (Criteria) this;
        }

        public Criteria andMoneyNameLike(String value) {
            addCriterion("money_name like", value, "moneyName");
            return (Criteria) this;
        }

        public Criteria andMoneyNameNotLike(String value) {
            addCriterion("money_name not like", value, "moneyName");
            return (Criteria) this;
        }

        public Criteria andMoneyNameIn(List<String> values) {
            addCriterion("money_name in", values, "moneyName");
            return (Criteria) this;
        }

        public Criteria andMoneyNameNotIn(List<String> values) {
            addCriterion("money_name not in", values, "moneyName");
            return (Criteria) this;
        }

        public Criteria andMoneyNameBetween(String value1, String value2) {
            addCriterion("money_name between", value1, value2, "moneyName");
            return (Criteria) this;
        }

        public Criteria andMoneyNameNotBetween(String value1, String value2) {
            addCriterion("money_name not between", value1, value2, "moneyName");
            return (Criteria) this;
        }

        public Criteria andMoneyDateIsNull() {
            addCriterion("money_date is null");
            return (Criteria) this;
        }

        public Criteria andMoneyDateIsNotNull() {
            addCriterion("money_date is not null");
            return (Criteria) this;
        }

        public Criteria andMoneyDateEqualTo(Date value) {
            addCriterionForJDBCDate("money_date =", value, "moneyDate");
            return (Criteria) this;
        }

        public Criteria andMoneyDateNotEqualTo(Date value) {
            addCriterionForJDBCDate("money_date <>", value, "moneyDate");
            return (Criteria) this;
        }

        public Criteria andMoneyDateGreaterThan(Date value) {
            addCriterionForJDBCDate("money_date >", value, "moneyDate");
            return (Criteria) this;
        }

        public Criteria andMoneyDateGreaterThanOrEqualTo(Date value) {
            addCriterionForJDBCDate("money_date >=", value, "moneyDate");
            return (Criteria) this;
        }

        public Criteria andMoneyDateLessThan(Date value) {
            addCriterionForJDBCDate("money_date <", value, "moneyDate");
            return (Criteria) this;
        }

        public Criteria andMoneyDateLessThanOrEqualTo(Date value) {
            addCriterionForJDBCDate("money_date <=", value, "moneyDate");
            return (Criteria) this;
        }

        public Criteria andMoneyDateIn(List<Date> values) {
            addCriterionForJDBCDate("money_date in", values, "moneyDate");
            return (Criteria) this;
        }

        public Criteria andMoneyDateNotIn(List<Date> values) {
            addCriterionForJDBCDate("money_date not in", values, "moneyDate");
            return (Criteria) this;
        }

        public Criteria andMoneyDateBetween(Date value1, Date value2) {
            addCriterionForJDBCDate("money_date between", value1, value2, "moneyDate");
            return (Criteria) this;
        }

        public Criteria andMoneyDateNotBetween(Date value1, Date value2) {
            addCriterionForJDBCDate("money_date not between", value1, value2, "moneyDate");
            return (Criteria) this;
        }

        public Criteria andTodayDetailIsNull() {
            addCriterion("today_detail is null");
            return (Criteria) this;
        }

        public Criteria andTodayDetailIsNotNull() {
            addCriterion("today_detail is not null");
            return (Criteria) this;
        }

        public Criteria andTodayDetailEqualTo(String value) {
            addCriterion("today_detail =", value, "todayDetail");
            return (Criteria) this;
        }

        public Criteria andTodayDetailNotEqualTo(String value) {
            addCriterion("today_detail <>", value, "todayDetail");
            return (Criteria) this;
        }

        public Criteria andTodayDetailGreaterThan(String value) {
            addCriterion("today_detail >", value, "todayDetail");
            return (Criteria) this;
        }

        public Criteria andTodayDetailGreaterThanOrEqualTo(String value) {
            addCriterion("today_detail >=", value, "todayDetail");
            return (Criteria) this;
        }

        public Criteria andTodayDetailLessThan(String value) {
            addCriterion("today_detail <", value, "todayDetail");
            return (Criteria) this;
        }

        public Criteria andTodayDetailLessThanOrEqualTo(String value) {
            addCriterion("today_detail <=", value, "todayDetail");
            return (Criteria) this;
        }

        public Criteria andTodayDetailLike(String value) {
            addCriterion("today_detail like", value, "todayDetail");
            return (Criteria) this;
        }

        public Criteria andTodayDetailNotLike(String value) {
            addCriterion("today_detail not like", value, "todayDetail");
            return (Criteria) this;
        }

        public Criteria andTodayDetailIn(List<String> values) {
            addCriterion("today_detail in", values, "todayDetail");
            return (Criteria) this;
        }

        public Criteria andTodayDetailNotIn(List<String> values) {
            addCriterion("today_detail not in", values, "todayDetail");
            return (Criteria) this;
        }

        public Criteria andTodayDetailBetween(String value1, String value2) {
            addCriterion("today_detail between", value1, value2, "todayDetail");
            return (Criteria) this;
        }

        public Criteria andTodayDetailNotBetween(String value1, String value2) {
            addCriterion("today_detail not between", value1, value2, "todayDetail");
            return (Criteria) this;
        }

        public Criteria andMoneyNameLikeInsensitive(String value) {
            addCriterion("upper(money_name) like", value.toUpperCase(), "moneyName");
            return (Criteria) this;
        }

        public Criteria andTodayDetailLikeInsensitive(String value) {
            addCriterion("upper(today_detail) like", value.toUpperCase(), "todayDetail");
            return (Criteria) this;
        }
    }

    /**
     * money
     */
    public static class Criteria extends GeneratedCriteria {

        protected Criteria() {
            super();
        }
    }

    /**
     * money 2020-09-15
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