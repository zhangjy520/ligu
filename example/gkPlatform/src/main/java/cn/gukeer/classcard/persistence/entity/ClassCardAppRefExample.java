package cn.gukeer.classcard.persistence.entity;

import java.util.ArrayList;
import java.util.List;

public class ClassCardAppRefExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public ClassCardAppRefExample() {
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

        public Criteria andIdEqualTo(String value) {
            addCriterion("id =", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdNotEqualTo(String value) {
            addCriterion("id <>", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdGreaterThan(String value) {
            addCriterion("id >", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdGreaterThanOrEqualTo(String value) {
            addCriterion("id >=", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdLessThan(String value) {
            addCriterion("id <", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdLessThanOrEqualTo(String value) {
            addCriterion("id <=", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdLike(String value) {
            addCriterion("id like", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdNotLike(String value) {
            addCriterion("id not like", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdIn(List<String> values) {
            addCriterion("id in", values, "id");
            return (Criteria) this;
        }

        public Criteria andIdNotIn(List<String> values) {
            addCriterion("id not in", values, "id");
            return (Criteria) this;
        }

        public Criteria andIdBetween(String value1, String value2) {
            addCriterion("id between", value1, value2, "id");
            return (Criteria) this;
        }

        public Criteria andIdNotBetween(String value1, String value2) {
            addCriterion("id not between", value1, value2, "id");
            return (Criteria) this;
        }

        public Criteria andClassCardIdIsNull() {
            addCriterion("class_card_id is null");
            return (Criteria) this;
        }

        public Criteria andClassCardIdIsNotNull() {
            addCriterion("class_card_id is not null");
            return (Criteria) this;
        }

        public Criteria andClassCardIdEqualTo(String value) {
            addCriterion("class_card_id =", value, "classCardId");
            return (Criteria) this;
        }

        public Criteria andClassCardIdNotEqualTo(String value) {
            addCriterion("class_card_id <>", value, "classCardId");
            return (Criteria) this;
        }

        public Criteria andClassCardIdGreaterThan(String value) {
            addCriterion("class_card_id >", value, "classCardId");
            return (Criteria) this;
        }

        public Criteria andClassCardIdGreaterThanOrEqualTo(String value) {
            addCriterion("class_card_id >=", value, "classCardId");
            return (Criteria) this;
        }

        public Criteria andClassCardIdLessThan(String value) {
            addCriterion("class_card_id <", value, "classCardId");
            return (Criteria) this;
        }

        public Criteria andClassCardIdLessThanOrEqualTo(String value) {
            addCriterion("class_card_id <=", value, "classCardId");
            return (Criteria) this;
        }

        public Criteria andClassCardIdLike(String value) {
            addCriterion("class_card_id like", value, "classCardId");
            return (Criteria) this;
        }

        public Criteria andClassCardIdNotLike(String value) {
            addCriterion("class_card_id not like", value, "classCardId");
            return (Criteria) this;
        }

        public Criteria andClassCardIdIn(List<String> values) {
            addCriterion("class_card_id in", values, "classCardId");
            return (Criteria) this;
        }

        public Criteria andClassCardIdNotIn(List<String> values) {
            addCriterion("class_card_id not in", values, "classCardId");
            return (Criteria) this;
        }

        public Criteria andClassCardIdBetween(String value1, String value2) {
            addCriterion("class_card_id between", value1, value2, "classCardId");
            return (Criteria) this;
        }

        public Criteria andClassCardIdNotBetween(String value1, String value2) {
            addCriterion("class_card_id not between", value1, value2, "classCardId");
            return (Criteria) this;
        }

        public Criteria andClassCardAppIdIsNull() {
            addCriterion("class_card_app_id is null");
            return (Criteria) this;
        }

        public Criteria andClassCardAppIdIsNotNull() {
            addCriterion("class_card_app_id is not null");
            return (Criteria) this;
        }

        public Criteria andClassCardAppIdEqualTo(String value) {
            addCriterion("class_card_app_id =", value, "classCardAppId");
            return (Criteria) this;
        }

        public Criteria andClassCardAppIdNotEqualTo(String value) {
            addCriterion("class_card_app_id <>", value, "classCardAppId");
            return (Criteria) this;
        }

        public Criteria andClassCardAppIdGreaterThan(String value) {
            addCriterion("class_card_app_id >", value, "classCardAppId");
            return (Criteria) this;
        }

        public Criteria andClassCardAppIdGreaterThanOrEqualTo(String value) {
            addCriterion("class_card_app_id >=", value, "classCardAppId");
            return (Criteria) this;
        }

        public Criteria andClassCardAppIdLessThan(String value) {
            addCriterion("class_card_app_id <", value, "classCardAppId");
            return (Criteria) this;
        }

        public Criteria andClassCardAppIdLessThanOrEqualTo(String value) {
            addCriterion("class_card_app_id <=", value, "classCardAppId");
            return (Criteria) this;
        }

        public Criteria andClassCardAppIdLike(String value) {
            addCriterion("class_card_app_id like", value, "classCardAppId");
            return (Criteria) this;
        }

        public Criteria andClassCardAppIdNotLike(String value) {
            addCriterion("class_card_app_id not like", value, "classCardAppId");
            return (Criteria) this;
        }

        public Criteria andClassCardAppIdIn(List<String> values) {
            addCriterion("class_card_app_id in", values, "classCardAppId");
            return (Criteria) this;
        }

        public Criteria andClassCardAppIdNotIn(List<String> values) {
            addCriterion("class_card_app_id not in", values, "classCardAppId");
            return (Criteria) this;
        }

        public Criteria andClassCardAppIdBetween(String value1, String value2) {
            addCriterion("class_card_app_id between", value1, value2, "classCardAppId");
            return (Criteria) this;
        }

        public Criteria andClassCardAppIdNotBetween(String value1, String value2) {
            addCriterion("class_card_app_id not between", value1, value2, "classCardAppId");
            return (Criteria) this;
        }

        public Criteria andSchoolIdIsNull() {
            addCriterion("school_id is null");
            return (Criteria) this;
        }

        public Criteria andSchoolIdIsNotNull() {
            addCriterion("school_id is not null");
            return (Criteria) this;
        }

        public Criteria andSchoolIdEqualTo(String value) {
            addCriterion("school_id =", value, "schoolId");
            return (Criteria) this;
        }

        public Criteria andSchoolIdNotEqualTo(String value) {
            addCriterion("school_id <>", value, "schoolId");
            return (Criteria) this;
        }

        public Criteria andSchoolIdGreaterThan(String value) {
            addCriterion("school_id >", value, "schoolId");
            return (Criteria) this;
        }

        public Criteria andSchoolIdGreaterThanOrEqualTo(String value) {
            addCriterion("school_id >=", value, "schoolId");
            return (Criteria) this;
        }

        public Criteria andSchoolIdLessThan(String value) {
            addCriterion("school_id <", value, "schoolId");
            return (Criteria) this;
        }

        public Criteria andSchoolIdLessThanOrEqualTo(String value) {
            addCriterion("school_id <=", value, "schoolId");
            return (Criteria) this;
        }

        public Criteria andSchoolIdLike(String value) {
            addCriterion("school_id like", value, "schoolId");
            return (Criteria) this;
        }

        public Criteria andSchoolIdNotLike(String value) {
            addCriterion("school_id not like", value, "schoolId");
            return (Criteria) this;
        }

        public Criteria andSchoolIdIn(List<String> values) {
            addCriterion("school_id in", values, "schoolId");
            return (Criteria) this;
        }

        public Criteria andSchoolIdNotIn(List<String> values) {
            addCriterion("school_id not in", values, "schoolId");
            return (Criteria) this;
        }

        public Criteria andSchoolIdBetween(String value1, String value2) {
            addCriterion("school_id between", value1, value2, "schoolId");
            return (Criteria) this;
        }

        public Criteria andSchoolIdNotBetween(String value1, String value2) {
            addCriterion("school_id not between", value1, value2, "schoolId");
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

        public Criteria andCreateDateIsNull() {
            addCriterion("create_date is null");
            return (Criteria) this;
        }

        public Criteria andCreateDateIsNotNull() {
            addCriterion("create_date is not null");
            return (Criteria) this;
        }

        public Criteria andCreateDateEqualTo(Long value) {
            addCriterion("create_date =", value, "createDate");
            return (Criteria) this;
        }

        public Criteria andCreateDateNotEqualTo(Long value) {
            addCriterion("create_date <>", value, "createDate");
            return (Criteria) this;
        }

        public Criteria andCreateDateGreaterThan(Long value) {
            addCriterion("create_date >", value, "createDate");
            return (Criteria) this;
        }

        public Criteria andCreateDateGreaterThanOrEqualTo(Long value) {
            addCriterion("create_date >=", value, "createDate");
            return (Criteria) this;
        }

        public Criteria andCreateDateLessThan(Long value) {
            addCriterion("create_date <", value, "createDate");
            return (Criteria) this;
        }

        public Criteria andCreateDateLessThanOrEqualTo(Long value) {
            addCriterion("create_date <=", value, "createDate");
            return (Criteria) this;
        }

        public Criteria andCreateDateIn(List<Long> values) {
            addCriterion("create_date in", values, "createDate");
            return (Criteria) this;
        }

        public Criteria andCreateDateNotIn(List<Long> values) {
            addCriterion("create_date not in", values, "createDate");
            return (Criteria) this;
        }

        public Criteria andCreateDateBetween(Long value1, Long value2) {
            addCriterion("create_date between", value1, value2, "createDate");
            return (Criteria) this;
        }

        public Criteria andCreateDateNotBetween(Long value1, Long value2) {
            addCriterion("create_date not between", value1, value2, "createDate");
            return (Criteria) this;
        }

        public Criteria andUpdateDateIsNull() {
            addCriterion("update_date is null");
            return (Criteria) this;
        }

        public Criteria andUpdateDateIsNotNull() {
            addCriterion("update_date is not null");
            return (Criteria) this;
        }

        public Criteria andUpdateDateEqualTo(Long value) {
            addCriterion("update_date =", value, "updateDate");
            return (Criteria) this;
        }

        public Criteria andUpdateDateNotEqualTo(Long value) {
            addCriterion("update_date <>", value, "updateDate");
            return (Criteria) this;
        }

        public Criteria andUpdateDateGreaterThan(Long value) {
            addCriterion("update_date >", value, "updateDate");
            return (Criteria) this;
        }

        public Criteria andUpdateDateGreaterThanOrEqualTo(Long value) {
            addCriterion("update_date >=", value, "updateDate");
            return (Criteria) this;
        }

        public Criteria andUpdateDateLessThan(Long value) {
            addCriterion("update_date <", value, "updateDate");
            return (Criteria) this;
        }

        public Criteria andUpdateDateLessThanOrEqualTo(Long value) {
            addCriterion("update_date <=", value, "updateDate");
            return (Criteria) this;
        }

        public Criteria andUpdateDateIn(List<Long> values) {
            addCriterion("update_date in", values, "updateDate");
            return (Criteria) this;
        }

        public Criteria andUpdateDateNotIn(List<Long> values) {
            addCriterion("update_date not in", values, "updateDate");
            return (Criteria) this;
        }

        public Criteria andUpdateDateBetween(Long value1, Long value2) {
            addCriterion("update_date between", value1, value2, "updateDate");
            return (Criteria) this;
        }

        public Criteria andUpdateDateNotBetween(Long value1, Long value2) {
            addCriterion("update_date not between", value1, value2, "updateDate");
            return (Criteria) this;
        }

        public Criteria andCreateByIsNull() {
            addCriterion("create_by is null");
            return (Criteria) this;
        }

        public Criteria andCreateByIsNotNull() {
            addCriterion("create_by is not null");
            return (Criteria) this;
        }

        public Criteria andCreateByEqualTo(String value) {
            addCriterion("create_by =", value, "createBy");
            return (Criteria) this;
        }

        public Criteria andCreateByNotEqualTo(String value) {
            addCriterion("create_by <>", value, "createBy");
            return (Criteria) this;
        }

        public Criteria andCreateByGreaterThan(String value) {
            addCriterion("create_by >", value, "createBy");
            return (Criteria) this;
        }

        public Criteria andCreateByGreaterThanOrEqualTo(String value) {
            addCriterion("create_by >=", value, "createBy");
            return (Criteria) this;
        }

        public Criteria andCreateByLessThan(String value) {
            addCriterion("create_by <", value, "createBy");
            return (Criteria) this;
        }

        public Criteria andCreateByLessThanOrEqualTo(String value) {
            addCriterion("create_by <=", value, "createBy");
            return (Criteria) this;
        }

        public Criteria andCreateByLike(String value) {
            addCriterion("create_by like", value, "createBy");
            return (Criteria) this;
        }

        public Criteria andCreateByNotLike(String value) {
            addCriterion("create_by not like", value, "createBy");
            return (Criteria) this;
        }

        public Criteria andCreateByIn(List<String> values) {
            addCriterion("create_by in", values, "createBy");
            return (Criteria) this;
        }

        public Criteria andCreateByNotIn(List<String> values) {
            addCriterion("create_by not in", values, "createBy");
            return (Criteria) this;
        }

        public Criteria andCreateByBetween(String value1, String value2) {
            addCriterion("create_by between", value1, value2, "createBy");
            return (Criteria) this;
        }

        public Criteria andCreateByNotBetween(String value1, String value2) {
            addCriterion("create_by not between", value1, value2, "createBy");
            return (Criteria) this;
        }

        public Criteria andUpdateByIsNull() {
            addCriterion("update_by is null");
            return (Criteria) this;
        }

        public Criteria andUpdateByIsNotNull() {
            addCriterion("update_by is not null");
            return (Criteria) this;
        }

        public Criteria andUpdateByEqualTo(String value) {
            addCriterion("update_by =", value, "updateBy");
            return (Criteria) this;
        }

        public Criteria andUpdateByNotEqualTo(String value) {
            addCriterion("update_by <>", value, "updateBy");
            return (Criteria) this;
        }

        public Criteria andUpdateByGreaterThan(String value) {
            addCriterion("update_by >", value, "updateBy");
            return (Criteria) this;
        }

        public Criteria andUpdateByGreaterThanOrEqualTo(String value) {
            addCriterion("update_by >=", value, "updateBy");
            return (Criteria) this;
        }

        public Criteria andUpdateByLessThan(String value) {
            addCriterion("update_by <", value, "updateBy");
            return (Criteria) this;
        }

        public Criteria andUpdateByLessThanOrEqualTo(String value) {
            addCriterion("update_by <=", value, "updateBy");
            return (Criteria) this;
        }

        public Criteria andUpdateByLike(String value) {
            addCriterion("update_by like", value, "updateBy");
            return (Criteria) this;
        }

        public Criteria andUpdateByNotLike(String value) {
            addCriterion("update_by not like", value, "updateBy");
            return (Criteria) this;
        }

        public Criteria andUpdateByIn(List<String> values) {
            addCriterion("update_by in", values, "updateBy");
            return (Criteria) this;
        }

        public Criteria andUpdateByNotIn(List<String> values) {
            addCriterion("update_by not in", values, "updateBy");
            return (Criteria) this;
        }

        public Criteria andUpdateByBetween(String value1, String value2) {
            addCriterion("update_by between", value1, value2, "updateBy");
            return (Criteria) this;
        }

        public Criteria andUpdateByNotBetween(String value1, String value2) {
            addCriterion("update_by not between", value1, value2, "updateBy");
            return (Criteria) this;
        }

        public Criteria andFeedBackTimeIsNull() {
            addCriterion("feed_back_time is null");
            return (Criteria) this;
        }

        public Criteria andFeedBackTimeIsNotNull() {
            addCriterion("feed_back_time is not null");
            return (Criteria) this;
        }

        public Criteria andFeedBackTimeEqualTo(Long value) {
            addCriterion("feed_back_time =", value, "feedBackTime");
            return (Criteria) this;
        }

        public Criteria andFeedBackTimeNotEqualTo(Long value) {
            addCriterion("feed_back_time <>", value, "feedBackTime");
            return (Criteria) this;
        }

        public Criteria andFeedBackTimeGreaterThan(Long value) {
            addCriterion("feed_back_time >", value, "feedBackTime");
            return (Criteria) this;
        }

        public Criteria andFeedBackTimeGreaterThanOrEqualTo(Long value) {
            addCriterion("feed_back_time >=", value, "feedBackTime");
            return (Criteria) this;
        }

        public Criteria andFeedBackTimeLessThan(Long value) {
            addCriterion("feed_back_time <", value, "feedBackTime");
            return (Criteria) this;
        }

        public Criteria andFeedBackTimeLessThanOrEqualTo(Long value) {
            addCriterion("feed_back_time <=", value, "feedBackTime");
            return (Criteria) this;
        }

        public Criteria andFeedBackTimeIn(List<Long> values) {
            addCriterion("feed_back_time in", values, "feedBackTime");
            return (Criteria) this;
        }

        public Criteria andFeedBackTimeNotIn(List<Long> values) {
            addCriterion("feed_back_time not in", values, "feedBackTime");
            return (Criteria) this;
        }

        public Criteria andFeedBackTimeBetween(Long value1, Long value2) {
            addCriterion("feed_back_time between", value1, value2, "feedBackTime");
            return (Criteria) this;
        }

        public Criteria andFeedBackTimeNotBetween(Long value1, Long value2) {
            addCriterion("feed_back_time not between", value1, value2, "feedBackTime");
            return (Criteria) this;
        }

        public Criteria andFeedBackStatusIsNull() {
            addCriterion("feed_back_status is null");
            return (Criteria) this;
        }

        public Criteria andFeedBackStatusIsNotNull() {
            addCriterion("feed_back_status is not null");
            return (Criteria) this;
        }

        public Criteria andFeedBackStatusEqualTo(Integer value) {
            addCriterion("feed_back_status =", value, "feedBackStatus");
            return (Criteria) this;
        }

        public Criteria andFeedBackStatusNotEqualTo(Integer value) {
            addCriterion("feed_back_status <>", value, "feedBackStatus");
            return (Criteria) this;
        }

        public Criteria andFeedBackStatusGreaterThan(Integer value) {
            addCriterion("feed_back_status >", value, "feedBackStatus");
            return (Criteria) this;
        }

        public Criteria andFeedBackStatusGreaterThanOrEqualTo(Integer value) {
            addCriterion("feed_back_status >=", value, "feedBackStatus");
            return (Criteria) this;
        }

        public Criteria andFeedBackStatusLessThan(Integer value) {
            addCriterion("feed_back_status <", value, "feedBackStatus");
            return (Criteria) this;
        }

        public Criteria andFeedBackStatusLessThanOrEqualTo(Integer value) {
            addCriterion("feed_back_status <=", value, "feedBackStatus");
            return (Criteria) this;
        }

        public Criteria andFeedBackStatusIn(List<Integer> values) {
            addCriterion("feed_back_status in", values, "feedBackStatus");
            return (Criteria) this;
        }

        public Criteria andFeedBackStatusNotIn(List<Integer> values) {
            addCriterion("feed_back_status not in", values, "feedBackStatus");
            return (Criteria) this;
        }

        public Criteria andFeedBackStatusBetween(Integer value1, Integer value2) {
            addCriterion("feed_back_status between", value1, value2, "feedBackStatus");
            return (Criteria) this;
        }

        public Criteria andFeedBackStatusNotBetween(Integer value1, Integer value2) {
            addCriterion("feed_back_status not between", value1, value2, "feedBackStatus");
            return (Criteria) this;
        }

        public Criteria andFeedBackRemarksIsNull() {
            addCriterion("feed_back_remarks is null");
            return (Criteria) this;
        }

        public Criteria andFeedBackRemarksIsNotNull() {
            addCriterion("feed_back_remarks is not null");
            return (Criteria) this;
        }

        public Criteria andFeedBackRemarksEqualTo(String value) {
            addCriterion("feed_back_remarks =", value, "feedBackRemarks");
            return (Criteria) this;
        }

        public Criteria andFeedBackRemarksNotEqualTo(String value) {
            addCriterion("feed_back_remarks <>", value, "feedBackRemarks");
            return (Criteria) this;
        }

        public Criteria andFeedBackRemarksGreaterThan(String value) {
            addCriterion("feed_back_remarks >", value, "feedBackRemarks");
            return (Criteria) this;
        }

        public Criteria andFeedBackRemarksGreaterThanOrEqualTo(String value) {
            addCriterion("feed_back_remarks >=", value, "feedBackRemarks");
            return (Criteria) this;
        }

        public Criteria andFeedBackRemarksLessThan(String value) {
            addCriterion("feed_back_remarks <", value, "feedBackRemarks");
            return (Criteria) this;
        }

        public Criteria andFeedBackRemarksLessThanOrEqualTo(String value) {
            addCriterion("feed_back_remarks <=", value, "feedBackRemarks");
            return (Criteria) this;
        }

        public Criteria andFeedBackRemarksLike(String value) {
            addCriterion("feed_back_remarks like", value, "feedBackRemarks");
            return (Criteria) this;
        }

        public Criteria andFeedBackRemarksNotLike(String value) {
            addCriterion("feed_back_remarks not like", value, "feedBackRemarks");
            return (Criteria) this;
        }

        public Criteria andFeedBackRemarksIn(List<String> values) {
            addCriterion("feed_back_remarks in", values, "feedBackRemarks");
            return (Criteria) this;
        }

        public Criteria andFeedBackRemarksNotIn(List<String> values) {
            addCriterion("feed_back_remarks not in", values, "feedBackRemarks");
            return (Criteria) this;
        }

        public Criteria andFeedBackRemarksBetween(String value1, String value2) {
            addCriterion("feed_back_remarks between", value1, value2, "feedBackRemarks");
            return (Criteria) this;
        }

        public Criteria andFeedBackRemarksNotBetween(String value1, String value2) {
            addCriterion("feed_back_remarks not between", value1, value2, "feedBackRemarks");
            return (Criteria) this;
        }

        public Criteria andUninstallStatusIsNull() {
            addCriterion("uninstall_status is null");
            return (Criteria) this;
        }

        public Criteria andUninstallStatusIsNotNull() {
            addCriterion("uninstall_status is not null");
            return (Criteria) this;
        }

        public Criteria andUninstallStatusEqualTo(Integer value) {
            addCriterion("uninstall_status =", value, "uninstallStatus");
            return (Criteria) this;
        }

        public Criteria andUninstallStatusNotEqualTo(Integer value) {
            addCriterion("uninstall_status <>", value, "uninstallStatus");
            return (Criteria) this;
        }

        public Criteria andUninstallStatusGreaterThan(Integer value) {
            addCriterion("uninstall_status >", value, "uninstallStatus");
            return (Criteria) this;
        }

        public Criteria andUninstallStatusGreaterThanOrEqualTo(Integer value) {
            addCriterion("uninstall_status >=", value, "uninstallStatus");
            return (Criteria) this;
        }

        public Criteria andUninstallStatusLessThan(Integer value) {
            addCriterion("uninstall_status <", value, "uninstallStatus");
            return (Criteria) this;
        }

        public Criteria andUninstallStatusLessThanOrEqualTo(Integer value) {
            addCriterion("uninstall_status <=", value, "uninstallStatus");
            return (Criteria) this;
        }

        public Criteria andUninstallStatusIn(List<Integer> values) {
            addCriterion("uninstall_status in", values, "uninstallStatus");
            return (Criteria) this;
        }

        public Criteria andUninstallStatusNotIn(List<Integer> values) {
            addCriterion("uninstall_status not in", values, "uninstallStatus");
            return (Criteria) this;
        }

        public Criteria andUninstallStatusBetween(Integer value1, Integer value2) {
            addCriterion("uninstall_status between", value1, value2, "uninstallStatus");
            return (Criteria) this;
        }

        public Criteria andUninstallStatusNotBetween(Integer value1, Integer value2) {
            addCriterion("uninstall_status not between", value1, value2, "uninstallStatus");
            return (Criteria) this;
        }

        public Criteria andIdLikeInsensitive(String value) {
            addCriterion("upper(id) like", value.toUpperCase(), "id");
            return (Criteria) this;
        }

        public Criteria andClassCardIdLikeInsensitive(String value) {
            addCriterion("upper(class_card_id) like", value.toUpperCase(), "classCardId");
            return (Criteria) this;
        }

        public Criteria andClassCardAppIdLikeInsensitive(String value) {
            addCriterion("upper(class_card_app_id) like", value.toUpperCase(), "classCardAppId");
            return (Criteria) this;
        }

        public Criteria andSchoolIdLikeInsensitive(String value) {
            addCriterion("upper(school_id) like", value.toUpperCase(), "schoolId");
            return (Criteria) this;
        }

        public Criteria andCreateByLikeInsensitive(String value) {
            addCriterion("upper(create_by) like", value.toUpperCase(), "createBy");
            return (Criteria) this;
        }

        public Criteria andUpdateByLikeInsensitive(String value) {
            addCriterion("upper(update_by) like", value.toUpperCase(), "updateBy");
            return (Criteria) this;
        }

        public Criteria andFeedBackRemarksLikeInsensitive(String value) {
            addCriterion("upper(feed_back_remarks) like", value.toUpperCase(), "feedBackRemarks");
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