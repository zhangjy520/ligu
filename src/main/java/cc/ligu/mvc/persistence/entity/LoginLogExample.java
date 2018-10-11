package cc.ligu.mvc.persistence.entity;

import java.util.ArrayList;
import java.util.List;

public class LoginLogExample {
    /**
     * login_log
     */
    protected String orderByClause;

    /**
     * login_log
     */
    protected boolean distinct;

    /**
     * login_log
     */
    protected List<Criteria> oredCriteria;

    public LoginLogExample() {
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
     * login_log 2018-10-11
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

        public Criteria andSysUserIdIsNull() {
            addCriterion("sys_user_id is null");
            return (Criteria) this;
        }

        public Criteria andSysUserIdIsNotNull() {
            addCriterion("sys_user_id is not null");
            return (Criteria) this;
        }

        public Criteria andSysUserIdEqualTo(Integer value) {
            addCriterion("sys_user_id =", value, "sysUserId");
            return (Criteria) this;
        }

        public Criteria andSysUserIdNotEqualTo(Integer value) {
            addCriterion("sys_user_id <>", value, "sysUserId");
            return (Criteria) this;
        }

        public Criteria andSysUserIdGreaterThan(Integer value) {
            addCriterion("sys_user_id >", value, "sysUserId");
            return (Criteria) this;
        }

        public Criteria andSysUserIdGreaterThanOrEqualTo(Integer value) {
            addCriterion("sys_user_id >=", value, "sysUserId");
            return (Criteria) this;
        }

        public Criteria andSysUserIdLessThan(Integer value) {
            addCriterion("sys_user_id <", value, "sysUserId");
            return (Criteria) this;
        }

        public Criteria andSysUserIdLessThanOrEqualTo(Integer value) {
            addCriterion("sys_user_id <=", value, "sysUserId");
            return (Criteria) this;
        }

        public Criteria andSysUserIdIn(List<Integer> values) {
            addCriterion("sys_user_id in", values, "sysUserId");
            return (Criteria) this;
        }

        public Criteria andSysUserIdNotIn(List<Integer> values) {
            addCriterion("sys_user_id not in", values, "sysUserId");
            return (Criteria) this;
        }

        public Criteria andSysUserIdBetween(Integer value1, Integer value2) {
            addCriterion("sys_user_id between", value1, value2, "sysUserId");
            return (Criteria) this;
        }

        public Criteria andSysUserIdNotBetween(Integer value1, Integer value2) {
            addCriterion("sys_user_id not between", value1, value2, "sysUserId");
            return (Criteria) this;
        }

        public Criteria andRefPersonIdIsNull() {
            addCriterion("ref_person_id is null");
            return (Criteria) this;
        }

        public Criteria andRefPersonIdIsNotNull() {
            addCriterion("ref_person_id is not null");
            return (Criteria) this;
        }

        public Criteria andRefPersonIdEqualTo(Integer value) {
            addCriterion("ref_person_id =", value, "refPersonId");
            return (Criteria) this;
        }

        public Criteria andRefPersonIdNotEqualTo(Integer value) {
            addCriterion("ref_person_id <>", value, "refPersonId");
            return (Criteria) this;
        }

        public Criteria andRefPersonIdGreaterThan(Integer value) {
            addCriterion("ref_person_id >", value, "refPersonId");
            return (Criteria) this;
        }

        public Criteria andRefPersonIdGreaterThanOrEqualTo(Integer value) {
            addCriterion("ref_person_id >=", value, "refPersonId");
            return (Criteria) this;
        }

        public Criteria andRefPersonIdLessThan(Integer value) {
            addCriterion("ref_person_id <", value, "refPersonId");
            return (Criteria) this;
        }

        public Criteria andRefPersonIdLessThanOrEqualTo(Integer value) {
            addCriterion("ref_person_id <=", value, "refPersonId");
            return (Criteria) this;
        }

        public Criteria andRefPersonIdIn(List<Integer> values) {
            addCriterion("ref_person_id in", values, "refPersonId");
            return (Criteria) this;
        }

        public Criteria andRefPersonIdNotIn(List<Integer> values) {
            addCriterion("ref_person_id not in", values, "refPersonId");
            return (Criteria) this;
        }

        public Criteria andRefPersonIdBetween(Integer value1, Integer value2) {
            addCriterion("ref_person_id between", value1, value2, "refPersonId");
            return (Criteria) this;
        }

        public Criteria andRefPersonIdNotBetween(Integer value1, Integer value2) {
            addCriterion("ref_person_id not between", value1, value2, "refPersonId");
            return (Criteria) this;
        }

        public Criteria andUsernameIsNull() {
            addCriterion("username is null");
            return (Criteria) this;
        }

        public Criteria andUsernameIsNotNull() {
            addCriterion("username is not null");
            return (Criteria) this;
        }

        public Criteria andUsernameEqualTo(String value) {
            addCriterion("username =", value, "username");
            return (Criteria) this;
        }

        public Criteria andUsernameNotEqualTo(String value) {
            addCriterion("username <>", value, "username");
            return (Criteria) this;
        }

        public Criteria andUsernameGreaterThan(String value) {
            addCriterion("username >", value, "username");
            return (Criteria) this;
        }

        public Criteria andUsernameGreaterThanOrEqualTo(String value) {
            addCriterion("username >=", value, "username");
            return (Criteria) this;
        }

        public Criteria andUsernameLessThan(String value) {
            addCriterion("username <", value, "username");
            return (Criteria) this;
        }

        public Criteria andUsernameLessThanOrEqualTo(String value) {
            addCriterion("username <=", value, "username");
            return (Criteria) this;
        }

        public Criteria andUsernameLike(String value) {
            addCriterion("username like", value, "username");
            return (Criteria) this;
        }

        public Criteria andUsernameNotLike(String value) {
            addCriterion("username not like", value, "username");
            return (Criteria) this;
        }

        public Criteria andUsernameIn(List<String> values) {
            addCriterion("username in", values, "username");
            return (Criteria) this;
        }

        public Criteria andUsernameNotIn(List<String> values) {
            addCriterion("username not in", values, "username");
            return (Criteria) this;
        }

        public Criteria andUsernameBetween(String value1, String value2) {
            addCriterion("username between", value1, value2, "username");
            return (Criteria) this;
        }

        public Criteria andUsernameNotBetween(String value1, String value2) {
            addCriterion("username not between", value1, value2, "username");
            return (Criteria) this;
        }

        public Criteria andNameIsNull() {
            addCriterion("name is null");
            return (Criteria) this;
        }

        public Criteria andNameIsNotNull() {
            addCriterion("name is not null");
            return (Criteria) this;
        }

        public Criteria andNameEqualTo(String value) {
            addCriterion("name =", value, "name");
            return (Criteria) this;
        }

        public Criteria andNameNotEqualTo(String value) {
            addCriterion("name <>", value, "name");
            return (Criteria) this;
        }

        public Criteria andNameGreaterThan(String value) {
            addCriterion("name >", value, "name");
            return (Criteria) this;
        }

        public Criteria andNameGreaterThanOrEqualTo(String value) {
            addCriterion("name >=", value, "name");
            return (Criteria) this;
        }

        public Criteria andNameLessThan(String value) {
            addCriterion("name <", value, "name");
            return (Criteria) this;
        }

        public Criteria andNameLessThanOrEqualTo(String value) {
            addCriterion("name <=", value, "name");
            return (Criteria) this;
        }

        public Criteria andNameLike(String value) {
            addCriterion("name like", value, "name");
            return (Criteria) this;
        }

        public Criteria andNameNotLike(String value) {
            addCriterion("name not like", value, "name");
            return (Criteria) this;
        }

        public Criteria andNameIn(List<String> values) {
            addCriterion("name in", values, "name");
            return (Criteria) this;
        }

        public Criteria andNameNotIn(List<String> values) {
            addCriterion("name not in", values, "name");
            return (Criteria) this;
        }

        public Criteria andNameBetween(String value1, String value2) {
            addCriterion("name between", value1, value2, "name");
            return (Criteria) this;
        }

        public Criteria andNameNotBetween(String value1, String value2) {
            addCriterion("name not between", value1, value2, "name");
            return (Criteria) this;
        }

        public Criteria andLoginStatusIsNull() {
            addCriterion("login_status is null");
            return (Criteria) this;
        }

        public Criteria andLoginStatusIsNotNull() {
            addCriterion("login_status is not null");
            return (Criteria) this;
        }

        public Criteria andLoginStatusEqualTo(Integer value) {
            addCriterion("login_status =", value, "loginStatus");
            return (Criteria) this;
        }

        public Criteria andLoginStatusNotEqualTo(Integer value) {
            addCriterion("login_status <>", value, "loginStatus");
            return (Criteria) this;
        }

        public Criteria andLoginStatusGreaterThan(Integer value) {
            addCriterion("login_status >", value, "loginStatus");
            return (Criteria) this;
        }

        public Criteria andLoginStatusGreaterThanOrEqualTo(Integer value) {
            addCriterion("login_status >=", value, "loginStatus");
            return (Criteria) this;
        }

        public Criteria andLoginStatusLessThan(Integer value) {
            addCriterion("login_status <", value, "loginStatus");
            return (Criteria) this;
        }

        public Criteria andLoginStatusLessThanOrEqualTo(Integer value) {
            addCriterion("login_status <=", value, "loginStatus");
            return (Criteria) this;
        }

        public Criteria andLoginStatusIn(List<Integer> values) {
            addCriterion("login_status in", values, "loginStatus");
            return (Criteria) this;
        }

        public Criteria andLoginStatusNotIn(List<Integer> values) {
            addCriterion("login_status not in", values, "loginStatus");
            return (Criteria) this;
        }

        public Criteria andLoginStatusBetween(Integer value1, Integer value2) {
            addCriterion("login_status between", value1, value2, "loginStatus");
            return (Criteria) this;
        }

        public Criteria andLoginStatusNotBetween(Integer value1, Integer value2) {
            addCriterion("login_status not between", value1, value2, "loginStatus");
            return (Criteria) this;
        }

        public Criteria andLoginDateIsNull() {
            addCriterion("login_date is null");
            return (Criteria) this;
        }

        public Criteria andLoginDateIsNotNull() {
            addCriterion("login_date is not null");
            return (Criteria) this;
        }

        public Criteria andLoginDateEqualTo(Long value) {
            addCriterion("login_date =", value, "loginDate");
            return (Criteria) this;
        }

        public Criteria andLoginDateNotEqualTo(Long value) {
            addCriterion("login_date <>", value, "loginDate");
            return (Criteria) this;
        }

        public Criteria andLoginDateGreaterThan(Long value) {
            addCriterion("login_date >", value, "loginDate");
            return (Criteria) this;
        }

        public Criteria andLoginDateGreaterThanOrEqualTo(Long value) {
            addCriterion("login_date >=", value, "loginDate");
            return (Criteria) this;
        }

        public Criteria andLoginDateLessThan(Long value) {
            addCriterion("login_date <", value, "loginDate");
            return (Criteria) this;
        }

        public Criteria andLoginDateLessThanOrEqualTo(Long value) {
            addCriterion("login_date <=", value, "loginDate");
            return (Criteria) this;
        }

        public Criteria andLoginDateIn(List<Long> values) {
            addCriterion("login_date in", values, "loginDate");
            return (Criteria) this;
        }

        public Criteria andLoginDateNotIn(List<Long> values) {
            addCriterion("login_date not in", values, "loginDate");
            return (Criteria) this;
        }

        public Criteria andLoginDateBetween(Long value1, Long value2) {
            addCriterion("login_date between", value1, value2, "loginDate");
            return (Criteria) this;
        }

        public Criteria andLoginDateNotBetween(Long value1, Long value2) {
            addCriterion("login_date not between", value1, value2, "loginDate");
            return (Criteria) this;
        }

        public Criteria andLogoutDateIsNull() {
            addCriterion("logout_date is null");
            return (Criteria) this;
        }

        public Criteria andLogoutDateIsNotNull() {
            addCriterion("logout_date is not null");
            return (Criteria) this;
        }

        public Criteria andLogoutDateEqualTo(Long value) {
            addCriterion("logout_date =", value, "logoutDate");
            return (Criteria) this;
        }

        public Criteria andLogoutDateNotEqualTo(Long value) {
            addCriterion("logout_date <>", value, "logoutDate");
            return (Criteria) this;
        }

        public Criteria andLogoutDateGreaterThan(Long value) {
            addCriterion("logout_date >", value, "logoutDate");
            return (Criteria) this;
        }

        public Criteria andLogoutDateGreaterThanOrEqualTo(Long value) {
            addCriterion("logout_date >=", value, "logoutDate");
            return (Criteria) this;
        }

        public Criteria andLogoutDateLessThan(Long value) {
            addCriterion("logout_date <", value, "logoutDate");
            return (Criteria) this;
        }

        public Criteria andLogoutDateLessThanOrEqualTo(Long value) {
            addCriterion("logout_date <=", value, "logoutDate");
            return (Criteria) this;
        }

        public Criteria andLogoutDateIn(List<Long> values) {
            addCriterion("logout_date in", values, "logoutDate");
            return (Criteria) this;
        }

        public Criteria andLogoutDateNotIn(List<Long> values) {
            addCriterion("logout_date not in", values, "logoutDate");
            return (Criteria) this;
        }

        public Criteria andLogoutDateBetween(Long value1, Long value2) {
            addCriterion("logout_date between", value1, value2, "logoutDate");
            return (Criteria) this;
        }

        public Criteria andLogoutDateNotBetween(Long value1, Long value2) {
            addCriterion("logout_date not between", value1, value2, "logoutDate");
            return (Criteria) this;
        }

        public Criteria andLoginSourceIsNull() {
            addCriterion("login_source is null");
            return (Criteria) this;
        }

        public Criteria andLoginSourceIsNotNull() {
            addCriterion("login_source is not null");
            return (Criteria) this;
        }

        public Criteria andLoginSourceEqualTo(Integer value) {
            addCriterion("login_source =", value, "loginSource");
            return (Criteria) this;
        }

        public Criteria andLoginSourceNotEqualTo(Integer value) {
            addCriterion("login_source <>", value, "loginSource");
            return (Criteria) this;
        }

        public Criteria andLoginSourceGreaterThan(Integer value) {
            addCriterion("login_source >", value, "loginSource");
            return (Criteria) this;
        }

        public Criteria andLoginSourceGreaterThanOrEqualTo(Integer value) {
            addCriterion("login_source >=", value, "loginSource");
            return (Criteria) this;
        }

        public Criteria andLoginSourceLessThan(Integer value) {
            addCriterion("login_source <", value, "loginSource");
            return (Criteria) this;
        }

        public Criteria andLoginSourceLessThanOrEqualTo(Integer value) {
            addCriterion("login_source <=", value, "loginSource");
            return (Criteria) this;
        }

        public Criteria andLoginSourceIn(List<Integer> values) {
            addCriterion("login_source in", values, "loginSource");
            return (Criteria) this;
        }

        public Criteria andLoginSourceNotIn(List<Integer> values) {
            addCriterion("login_source not in", values, "loginSource");
            return (Criteria) this;
        }

        public Criteria andLoginSourceBetween(Integer value1, Integer value2) {
            addCriterion("login_source between", value1, value2, "loginSource");
            return (Criteria) this;
        }

        public Criteria andLoginSourceNotBetween(Integer value1, Integer value2) {
            addCriterion("login_source not between", value1, value2, "loginSource");
            return (Criteria) this;
        }

        public Criteria andLoginIdIsNull() {
            addCriterion("login_id is null");
            return (Criteria) this;
        }

        public Criteria andLoginIdIsNotNull() {
            addCriterion("login_id is not null");
            return (Criteria) this;
        }

        public Criteria andLoginIdEqualTo(String value) {
            addCriterion("login_id =", value, "loginId");
            return (Criteria) this;
        }

        public Criteria andLoginIdNotEqualTo(String value) {
            addCriterion("login_id <>", value, "loginId");
            return (Criteria) this;
        }

        public Criteria andLoginIdGreaterThan(String value) {
            addCriterion("login_id >", value, "loginId");
            return (Criteria) this;
        }

        public Criteria andLoginIdGreaterThanOrEqualTo(String value) {
            addCriterion("login_id >=", value, "loginId");
            return (Criteria) this;
        }

        public Criteria andLoginIdLessThan(String value) {
            addCriterion("login_id <", value, "loginId");
            return (Criteria) this;
        }

        public Criteria andLoginIdLessThanOrEqualTo(String value) {
            addCriterion("login_id <=", value, "loginId");
            return (Criteria) this;
        }

        public Criteria andLoginIdLike(String value) {
            addCriterion("login_id like", value, "loginId");
            return (Criteria) this;
        }

        public Criteria andLoginIdNotLike(String value) {
            addCriterion("login_id not like", value, "loginId");
            return (Criteria) this;
        }

        public Criteria andLoginIdIn(List<String> values) {
            addCriterion("login_id in", values, "loginId");
            return (Criteria) this;
        }

        public Criteria andLoginIdNotIn(List<String> values) {
            addCriterion("login_id not in", values, "loginId");
            return (Criteria) this;
        }

        public Criteria andLoginIdBetween(String value1, String value2) {
            addCriterion("login_id between", value1, value2, "loginId");
            return (Criteria) this;
        }

        public Criteria andLoginIdNotBetween(String value1, String value2) {
            addCriterion("login_id not between", value1, value2, "loginId");
            return (Criteria) this;
        }

        public Criteria andUsernameLikeInsensitive(String value) {
            addCriterion("upper(username) like", value.toUpperCase(), "username");
            return (Criteria) this;
        }

        public Criteria andNameLikeInsensitive(String value) {
            addCriterion("upper(name) like", value.toUpperCase(), "name");
            return (Criteria) this;
        }

        public Criteria andLoginIdLikeInsensitive(String value) {
            addCriterion("upper(login_id) like", value.toUpperCase(), "loginId");
            return (Criteria) this;
        }
    }

    /**
     * login_log
     */
    public static class Criteria extends GeneratedCriteria {

        protected Criteria() {
            super();
        }
    }

    /**
     * login_log 2018-10-11
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