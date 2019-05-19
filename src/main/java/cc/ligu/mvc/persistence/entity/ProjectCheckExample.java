package cc.ligu.mvc.persistence.entity;

import java.util.ArrayList;
import java.util.List;

public class ProjectCheckExample {
    /**
     * project_check
     */
    protected String orderByClause;

    /**
     * project_check
     */
    protected boolean distinct;

    /**
     * project_check
     */
    protected List<Criteria> oredCriteria;

    public ProjectCheckExample() {
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
     * project_check 2019-05-19
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

        public Criteria andProjectIdIsNull() {
            addCriterion("project_id is null");
            return (Criteria) this;
        }

        public Criteria andProjectIdIsNotNull() {
            addCriterion("project_id is not null");
            return (Criteria) this;
        }

        public Criteria andProjectIdEqualTo(Integer value) {
            addCriterion("project_id =", value, "projectId");
            return (Criteria) this;
        }

        public Criteria andProjectIdNotEqualTo(Integer value) {
            addCriterion("project_id <>", value, "projectId");
            return (Criteria) this;
        }

        public Criteria andProjectIdGreaterThan(Integer value) {
            addCriterion("project_id >", value, "projectId");
            return (Criteria) this;
        }

        public Criteria andProjectIdGreaterThanOrEqualTo(Integer value) {
            addCriterion("project_id >=", value, "projectId");
            return (Criteria) this;
        }

        public Criteria andProjectIdLessThan(Integer value) {
            addCriterion("project_id <", value, "projectId");
            return (Criteria) this;
        }

        public Criteria andProjectIdLessThanOrEqualTo(Integer value) {
            addCriterion("project_id <=", value, "projectId");
            return (Criteria) this;
        }

        public Criteria andProjectIdIn(List<Integer> values) {
            addCriterion("project_id in", values, "projectId");
            return (Criteria) this;
        }

        public Criteria andProjectIdNotIn(List<Integer> values) {
            addCriterion("project_id not in", values, "projectId");
            return (Criteria) this;
        }

        public Criteria andProjectIdBetween(Integer value1, Integer value2) {
            addCriterion("project_id between", value1, value2, "projectId");
            return (Criteria) this;
        }

        public Criteria andProjectIdNotBetween(Integer value1, Integer value2) {
            addCriterion("project_id not between", value1, value2, "projectId");
            return (Criteria) this;
        }

        public Criteria andLocationIsNull() {
            addCriterion("location is null");
            return (Criteria) this;
        }

        public Criteria andLocationIsNotNull() {
            addCriterion("location is not null");
            return (Criteria) this;
        }

        public Criteria andLocationEqualTo(String value) {
            addCriterion("location =", value, "location");
            return (Criteria) this;
        }

        public Criteria andLocationNotEqualTo(String value) {
            addCriterion("location <>", value, "location");
            return (Criteria) this;
        }

        public Criteria andLocationGreaterThan(String value) {
            addCriterion("location >", value, "location");
            return (Criteria) this;
        }

        public Criteria andLocationGreaterThanOrEqualTo(String value) {
            addCriterion("location >=", value, "location");
            return (Criteria) this;
        }

        public Criteria andLocationLessThan(String value) {
            addCriterion("location <", value, "location");
            return (Criteria) this;
        }

        public Criteria andLocationLessThanOrEqualTo(String value) {
            addCriterion("location <=", value, "location");
            return (Criteria) this;
        }

        public Criteria andLocationLike(String value) {
            addCriterion("location like", value, "location");
            return (Criteria) this;
        }

        public Criteria andLocationNotLike(String value) {
            addCriterion("location not like", value, "location");
            return (Criteria) this;
        }

        public Criteria andLocationIn(List<String> values) {
            addCriterion("location in", values, "location");
            return (Criteria) this;
        }

        public Criteria andLocationNotIn(List<String> values) {
            addCriterion("location not in", values, "location");
            return (Criteria) this;
        }

        public Criteria andLocationBetween(String value1, String value2) {
            addCriterion("location between", value1, value2, "location");
            return (Criteria) this;
        }

        public Criteria andLocationNotBetween(String value1, String value2) {
            addCriterion("location not between", value1, value2, "location");
            return (Criteria) this;
        }

        public Criteria andStatusIsNull() {
            addCriterion("status is null");
            return (Criteria) this;
        }

        public Criteria andStatusIsNotNull() {
            addCriterion("status is not null");
            return (Criteria) this;
        }

        public Criteria andStatusEqualTo(String value) {
            addCriterion("status =", value, "status");
            return (Criteria) this;
        }

        public Criteria andStatusNotEqualTo(String value) {
            addCriterion("status <>", value, "status");
            return (Criteria) this;
        }

        public Criteria andStatusGreaterThan(String value) {
            addCriterion("status >", value, "status");
            return (Criteria) this;
        }

        public Criteria andStatusGreaterThanOrEqualTo(String value) {
            addCriterion("status >=", value, "status");
            return (Criteria) this;
        }

        public Criteria andStatusLessThan(String value) {
            addCriterion("status <", value, "status");
            return (Criteria) this;
        }

        public Criteria andStatusLessThanOrEqualTo(String value) {
            addCriterion("status <=", value, "status");
            return (Criteria) this;
        }

        public Criteria andStatusLike(String value) {
            addCriterion("status like", value, "status");
            return (Criteria) this;
        }

        public Criteria andStatusNotLike(String value) {
            addCriterion("status not like", value, "status");
            return (Criteria) this;
        }

        public Criteria andStatusIn(List<String> values) {
            addCriterion("status in", values, "status");
            return (Criteria) this;
        }

        public Criteria andStatusNotIn(List<String> values) {
            addCriterion("status not in", values, "status");
            return (Criteria) this;
        }

        public Criteria andStatusBetween(String value1, String value2) {
            addCriterion("status between", value1, value2, "status");
            return (Criteria) this;
        }

        public Criteria andStatusNotBetween(String value1, String value2) {
            addCriterion("status not between", value1, value2, "status");
            return (Criteria) this;
        }

        public Criteria andCheckTimeIsNull() {
            addCriterion("check_time is null");
            return (Criteria) this;
        }

        public Criteria andCheckTimeIsNotNull() {
            addCriterion("check_time is not null");
            return (Criteria) this;
        }

        public Criteria andCheckTimeEqualTo(Long value) {
            addCriterion("check_time =", value, "checkTime");
            return (Criteria) this;
        }

        public Criteria andCheckTimeNotEqualTo(Long value) {
            addCriterion("check_time <>", value, "checkTime");
            return (Criteria) this;
        }

        public Criteria andCheckTimeGreaterThan(Long value) {
            addCriterion("check_time >", value, "checkTime");
            return (Criteria) this;
        }

        public Criteria andCheckTimeGreaterThanOrEqualTo(Long value) {
            addCriterion("check_time >=", value, "checkTime");
            return (Criteria) this;
        }

        public Criteria andCheckTimeLessThan(Long value) {
            addCriterion("check_time <", value, "checkTime");
            return (Criteria) this;
        }

        public Criteria andCheckTimeLessThanOrEqualTo(Long value) {
            addCriterion("check_time <=", value, "checkTime");
            return (Criteria) this;
        }

        public Criteria andCheckTimeIn(List<Long> values) {
            addCriterion("check_time in", values, "checkTime");
            return (Criteria) this;
        }

        public Criteria andCheckTimeNotIn(List<Long> values) {
            addCriterion("check_time not in", values, "checkTime");
            return (Criteria) this;
        }

        public Criteria andCheckTimeBetween(Long value1, Long value2) {
            addCriterion("check_time between", value1, value2, "checkTime");
            return (Criteria) this;
        }

        public Criteria andCheckTimeNotBetween(Long value1, Long value2) {
            addCriterion("check_time not between", value1, value2, "checkTime");
            return (Criteria) this;
        }

        public Criteria andCheckPersonIsNull() {
            addCriterion("check_person is null");
            return (Criteria) this;
        }

        public Criteria andCheckPersonIsNotNull() {
            addCriterion("check_person is not null");
            return (Criteria) this;
        }

        public Criteria andCheckPersonEqualTo(String value) {
            addCriterion("check_person =", value, "checkPerson");
            return (Criteria) this;
        }

        public Criteria andCheckPersonNotEqualTo(String value) {
            addCriterion("check_person <>", value, "checkPerson");
            return (Criteria) this;
        }

        public Criteria andCheckPersonGreaterThan(String value) {
            addCriterion("check_person >", value, "checkPerson");
            return (Criteria) this;
        }

        public Criteria andCheckPersonGreaterThanOrEqualTo(String value) {
            addCriterion("check_person >=", value, "checkPerson");
            return (Criteria) this;
        }

        public Criteria andCheckPersonLessThan(String value) {
            addCriterion("check_person <", value, "checkPerson");
            return (Criteria) this;
        }

        public Criteria andCheckPersonLessThanOrEqualTo(String value) {
            addCriterion("check_person <=", value, "checkPerson");
            return (Criteria) this;
        }

        public Criteria andCheckPersonLike(String value) {
            addCriterion("check_person like", value, "checkPerson");
            return (Criteria) this;
        }

        public Criteria andCheckPersonNotLike(String value) {
            addCriterion("check_person not like", value, "checkPerson");
            return (Criteria) this;
        }

        public Criteria andCheckPersonIn(List<String> values) {
            addCriterion("check_person in", values, "checkPerson");
            return (Criteria) this;
        }

        public Criteria andCheckPersonNotIn(List<String> values) {
            addCriterion("check_person not in", values, "checkPerson");
            return (Criteria) this;
        }

        public Criteria andCheckPersonBetween(String value1, String value2) {
            addCriterion("check_person between", value1, value2, "checkPerson");
            return (Criteria) this;
        }

        public Criteria andCheckPersonNotBetween(String value1, String value2) {
            addCriterion("check_person not between", value1, value2, "checkPerson");
            return (Criteria) this;
        }

        public Criteria andManagePersonIsNull() {
            addCriterion("manage_person is null");
            return (Criteria) this;
        }

        public Criteria andManagePersonIsNotNull() {
            addCriterion("manage_person is not null");
            return (Criteria) this;
        }

        public Criteria andManagePersonEqualTo(String value) {
            addCriterion("manage_person =", value, "managePerson");
            return (Criteria) this;
        }

        public Criteria andManagePersonNotEqualTo(String value) {
            addCriterion("manage_person <>", value, "managePerson");
            return (Criteria) this;
        }

        public Criteria andManagePersonGreaterThan(String value) {
            addCriterion("manage_person >", value, "managePerson");
            return (Criteria) this;
        }

        public Criteria andManagePersonGreaterThanOrEqualTo(String value) {
            addCriterion("manage_person >=", value, "managePerson");
            return (Criteria) this;
        }

        public Criteria andManagePersonLessThan(String value) {
            addCriterion("manage_person <", value, "managePerson");
            return (Criteria) this;
        }

        public Criteria andManagePersonLessThanOrEqualTo(String value) {
            addCriterion("manage_person <=", value, "managePerson");
            return (Criteria) this;
        }

        public Criteria andManagePersonLike(String value) {
            addCriterion("manage_person like", value, "managePerson");
            return (Criteria) this;
        }

        public Criteria andManagePersonNotLike(String value) {
            addCriterion("manage_person not like", value, "managePerson");
            return (Criteria) this;
        }

        public Criteria andManagePersonIn(List<String> values) {
            addCriterion("manage_person in", values, "managePerson");
            return (Criteria) this;
        }

        public Criteria andManagePersonNotIn(List<String> values) {
            addCriterion("manage_person not in", values, "managePerson");
            return (Criteria) this;
        }

        public Criteria andManagePersonBetween(String value1, String value2) {
            addCriterion("manage_person between", value1, value2, "managePerson");
            return (Criteria) this;
        }

        public Criteria andManagePersonNotBetween(String value1, String value2) {
            addCriterion("manage_person not between", value1, value2, "managePerson");
            return (Criteria) this;
        }

        public Criteria andDealWayIsNull() {
            addCriterion("deal_way is null");
            return (Criteria) this;
        }

        public Criteria andDealWayIsNotNull() {
            addCriterion("deal_way is not null");
            return (Criteria) this;
        }

        public Criteria andDealWayEqualTo(String value) {
            addCriterion("deal_way =", value, "dealWay");
            return (Criteria) this;
        }

        public Criteria andDealWayNotEqualTo(String value) {
            addCriterion("deal_way <>", value, "dealWay");
            return (Criteria) this;
        }

        public Criteria andDealWayGreaterThan(String value) {
            addCriterion("deal_way >", value, "dealWay");
            return (Criteria) this;
        }

        public Criteria andDealWayGreaterThanOrEqualTo(String value) {
            addCriterion("deal_way >=", value, "dealWay");
            return (Criteria) this;
        }

        public Criteria andDealWayLessThan(String value) {
            addCriterion("deal_way <", value, "dealWay");
            return (Criteria) this;
        }

        public Criteria andDealWayLessThanOrEqualTo(String value) {
            addCriterion("deal_way <=", value, "dealWay");
            return (Criteria) this;
        }

        public Criteria andDealWayLike(String value) {
            addCriterion("deal_way like", value, "dealWay");
            return (Criteria) this;
        }

        public Criteria andDealWayNotLike(String value) {
            addCriterion("deal_way not like", value, "dealWay");
            return (Criteria) this;
        }

        public Criteria andDealWayIn(List<String> values) {
            addCriterion("deal_way in", values, "dealWay");
            return (Criteria) this;
        }

        public Criteria andDealWayNotIn(List<String> values) {
            addCriterion("deal_way not in", values, "dealWay");
            return (Criteria) this;
        }

        public Criteria andDealWayBetween(String value1, String value2) {
            addCriterion("deal_way between", value1, value2, "dealWay");
            return (Criteria) this;
        }

        public Criteria andDealWayNotBetween(String value1, String value2) {
            addCriterion("deal_way not between", value1, value2, "dealWay");
            return (Criteria) this;
        }

        public Criteria andLocalDescIsNull() {
            addCriterion("local_desc is null");
            return (Criteria) this;
        }

        public Criteria andLocalDescIsNotNull() {
            addCriterion("local_desc is not null");
            return (Criteria) this;
        }

        public Criteria andLocalDescEqualTo(String value) {
            addCriterion("local_desc =", value, "localDesc");
            return (Criteria) this;
        }

        public Criteria andLocalDescNotEqualTo(String value) {
            addCriterion("local_desc <>", value, "localDesc");
            return (Criteria) this;
        }

        public Criteria andLocalDescGreaterThan(String value) {
            addCriterion("local_desc >", value, "localDesc");
            return (Criteria) this;
        }

        public Criteria andLocalDescGreaterThanOrEqualTo(String value) {
            addCriterion("local_desc >=", value, "localDesc");
            return (Criteria) this;
        }

        public Criteria andLocalDescLessThan(String value) {
            addCriterion("local_desc <", value, "localDesc");
            return (Criteria) this;
        }

        public Criteria andLocalDescLessThanOrEqualTo(String value) {
            addCriterion("local_desc <=", value, "localDesc");
            return (Criteria) this;
        }

        public Criteria andLocalDescLike(String value) {
            addCriterion("local_desc like", value, "localDesc");
            return (Criteria) this;
        }

        public Criteria andLocalDescNotLike(String value) {
            addCriterion("local_desc not like", value, "localDesc");
            return (Criteria) this;
        }

        public Criteria andLocalDescIn(List<String> values) {
            addCriterion("local_desc in", values, "localDesc");
            return (Criteria) this;
        }

        public Criteria andLocalDescNotIn(List<String> values) {
            addCriterion("local_desc not in", values, "localDesc");
            return (Criteria) this;
        }

        public Criteria andLocalDescBetween(String value1, String value2) {
            addCriterion("local_desc between", value1, value2, "localDesc");
            return (Criteria) this;
        }

        public Criteria andLocalDescNotBetween(String value1, String value2) {
            addCriterion("local_desc not between", value1, value2, "localDesc");
            return (Criteria) this;
        }

        public Criteria andLocalPicsIsNull() {
            addCriterion("local_pics is null");
            return (Criteria) this;
        }

        public Criteria andLocalPicsIsNotNull() {
            addCriterion("local_pics is not null");
            return (Criteria) this;
        }

        public Criteria andLocalPicsEqualTo(String value) {
            addCriterion("local_pics =", value, "localPics");
            return (Criteria) this;
        }

        public Criteria andLocalPicsNotEqualTo(String value) {
            addCriterion("local_pics <>", value, "localPics");
            return (Criteria) this;
        }

        public Criteria andLocalPicsGreaterThan(String value) {
            addCriterion("local_pics >", value, "localPics");
            return (Criteria) this;
        }

        public Criteria andLocalPicsGreaterThanOrEqualTo(String value) {
            addCriterion("local_pics >=", value, "localPics");
            return (Criteria) this;
        }

        public Criteria andLocalPicsLessThan(String value) {
            addCriterion("local_pics <", value, "localPics");
            return (Criteria) this;
        }

        public Criteria andLocalPicsLessThanOrEqualTo(String value) {
            addCriterion("local_pics <=", value, "localPics");
            return (Criteria) this;
        }

        public Criteria andLocalPicsLike(String value) {
            addCriterion("local_pics like", value, "localPics");
            return (Criteria) this;
        }

        public Criteria andLocalPicsNotLike(String value) {
            addCriterion("local_pics not like", value, "localPics");
            return (Criteria) this;
        }

        public Criteria andLocalPicsIn(List<String> values) {
            addCriterion("local_pics in", values, "localPics");
            return (Criteria) this;
        }

        public Criteria andLocalPicsNotIn(List<String> values) {
            addCriterion("local_pics not in", values, "localPics");
            return (Criteria) this;
        }

        public Criteria andLocalPicsBetween(String value1, String value2) {
            addCriterion("local_pics between", value1, value2, "localPics");
            return (Criteria) this;
        }

        public Criteria andLocalPicsNotBetween(String value1, String value2) {
            addCriterion("local_pics not between", value1, value2, "localPics");
            return (Criteria) this;
        }

        public Criteria andLocationLikeInsensitive(String value) {
            addCriterion("upper(location) like", value.toUpperCase(), "location");
            return (Criteria) this;
        }

        public Criteria andStatusLikeInsensitive(String value) {
            addCriterion("upper(status) like", value.toUpperCase(), "status");
            return (Criteria) this;
        }

        public Criteria andCheckPersonLikeInsensitive(String value) {
            addCriterion("upper(check_person) like", value.toUpperCase(), "checkPerson");
            return (Criteria) this;
        }

        public Criteria andManagePersonLikeInsensitive(String value) {
            addCriterion("upper(manage_person) like", value.toUpperCase(), "managePerson");
            return (Criteria) this;
        }

        public Criteria andDealWayLikeInsensitive(String value) {
            addCriterion("upper(deal_way) like", value.toUpperCase(), "dealWay");
            return (Criteria) this;
        }

        public Criteria andLocalDescLikeInsensitive(String value) {
            addCriterion("upper(local_desc) like", value.toUpperCase(), "localDesc");
            return (Criteria) this;
        }

        public Criteria andLocalPicsLikeInsensitive(String value) {
            addCriterion("upper(local_pics) like", value.toUpperCase(), "localPics");
            return (Criteria) this;
        }
    }

    /**
     * project_check
     */
    public static class Criteria extends GeneratedCriteria {

        protected Criteria() {
            super();
        }
    }

    /**
     * project_check 2019-05-19
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