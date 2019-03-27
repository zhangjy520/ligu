package cc.ligu.mvc.persistence.entity;

import java.util.ArrayList;
import java.util.List;

public class PvpPersonExample {
    /**
     * pvp_person
     */
    protected String orderByClause;

    /**
     * pvp_person
     */
    protected boolean distinct;

    /**
     * pvp_person
     */
    protected List<Criteria> oredCriteria;

    public PvpPersonExample() {
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
     * pvp_person 2019-03-19
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

        public Criteria andPersonAIdIsNull() {
            addCriterion("person_a_id is null");
            return (Criteria) this;
        }

        public Criteria andPersonAIdIsNotNull() {
            addCriterion("person_a_id is not null");
            return (Criteria) this;
        }

        public Criteria andPersonAIdEqualTo(Integer value) {
            addCriterion("person_a_id =", value, "personAId");
            return (Criteria) this;
        }

        public Criteria andPersonAIdNotEqualTo(Integer value) {
            addCriterion("person_a_id <>", value, "personAId");
            return (Criteria) this;
        }

        public Criteria andPersonAIdGreaterThan(Integer value) {
            addCriterion("person_a_id >", value, "personAId");
            return (Criteria) this;
        }

        public Criteria andPersonAIdGreaterThanOrEqualTo(Integer value) {
            addCriterion("person_a_id >=", value, "personAId");
            return (Criteria) this;
        }

        public Criteria andPersonAIdLessThan(Integer value) {
            addCriterion("person_a_id <", value, "personAId");
            return (Criteria) this;
        }

        public Criteria andPersonAIdLessThanOrEqualTo(Integer value) {
            addCriterion("person_a_id <=", value, "personAId");
            return (Criteria) this;
        }

        public Criteria andPersonAIdIn(List<Integer> values) {
            addCriterion("person_a_id in", values, "personAId");
            return (Criteria) this;
        }

        public Criteria andPersonAIdNotIn(List<Integer> values) {
            addCriterion("person_a_id not in", values, "personAId");
            return (Criteria) this;
        }

        public Criteria andPersonAIdBetween(Integer value1, Integer value2) {
            addCriterion("person_a_id between", value1, value2, "personAId");
            return (Criteria) this;
        }

        public Criteria andPersonAIdNotBetween(Integer value1, Integer value2) {
            addCriterion("person_a_id not between", value1, value2, "personAId");
            return (Criteria) this;
        }

        public Criteria andPersonBIdIsNull() {
            addCriterion("person_b_id is null");
            return (Criteria) this;
        }

        public Criteria andPersonBIdIsNotNull() {
            addCriterion("person_b_id is not null");
            return (Criteria) this;
        }

        public Criteria andPersonBIdEqualTo(Integer value) {
            addCriterion("person_b_id =", value, "personBId");
            return (Criteria) this;
        }

        public Criteria andPersonBIdNotEqualTo(Integer value) {
            addCriterion("person_b_id <>", value, "personBId");
            return (Criteria) this;
        }

        public Criteria andPersonBIdGreaterThan(Integer value) {
            addCriterion("person_b_id >", value, "personBId");
            return (Criteria) this;
        }

        public Criteria andPersonBIdGreaterThanOrEqualTo(Integer value) {
            addCriterion("person_b_id >=", value, "personBId");
            return (Criteria) this;
        }

        public Criteria andPersonBIdLessThan(Integer value) {
            addCriterion("person_b_id <", value, "personBId");
            return (Criteria) this;
        }

        public Criteria andPersonBIdLessThanOrEqualTo(Integer value) {
            addCriterion("person_b_id <=", value, "personBId");
            return (Criteria) this;
        }

        public Criteria andPersonBIdIn(List<Integer> values) {
            addCriterion("person_b_id in", values, "personBId");
            return (Criteria) this;
        }

        public Criteria andPersonBIdNotIn(List<Integer> values) {
            addCriterion("person_b_id not in", values, "personBId");
            return (Criteria) this;
        }

        public Criteria andPersonBIdBetween(Integer value1, Integer value2) {
            addCriterion("person_b_id between", value1, value2, "personBId");
            return (Criteria) this;
        }

        public Criteria andPersonBIdNotBetween(Integer value1, Integer value2) {
            addCriterion("person_b_id not between", value1, value2, "personBId");
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

        public Criteria andPersonAScoreIsNull() {
            addCriterion("person_a_score is null");
            return (Criteria) this;
        }

        public Criteria andPersonAScoreIsNotNull() {
            addCriterion("person_a_score is not null");
            return (Criteria) this;
        }

        public Criteria andPersonAScoreEqualTo(String value) {
            addCriterion("person_a_score =", value, "personAScore");
            return (Criteria) this;
        }

        public Criteria andPersonAScoreNotEqualTo(String value) {
            addCriterion("person_a_score <>", value, "personAScore");
            return (Criteria) this;
        }

        public Criteria andPersonAScoreGreaterThan(String value) {
            addCriterion("person_a_score >", value, "personAScore");
            return (Criteria) this;
        }

        public Criteria andPersonAScoreGreaterThanOrEqualTo(String value) {
            addCriterion("person_a_score >=", value, "personAScore");
            return (Criteria) this;
        }

        public Criteria andPersonAScoreLessThan(String value) {
            addCriterion("person_a_score <", value, "personAScore");
            return (Criteria) this;
        }

        public Criteria andPersonAScoreLessThanOrEqualTo(String value) {
            addCriterion("person_a_score <=", value, "personAScore");
            return (Criteria) this;
        }

        public Criteria andPersonAScoreLike(String value) {
            addCriterion("person_a_score like", value, "personAScore");
            return (Criteria) this;
        }

        public Criteria andPersonAScoreNotLike(String value) {
            addCriterion("person_a_score not like", value, "personAScore");
            return (Criteria) this;
        }

        public Criteria andPersonAScoreIn(List<String> values) {
            addCriterion("person_a_score in", values, "personAScore");
            return (Criteria) this;
        }

        public Criteria andPersonAScoreNotIn(List<String> values) {
            addCriterion("person_a_score not in", values, "personAScore");
            return (Criteria) this;
        }

        public Criteria andPersonAScoreBetween(String value1, String value2) {
            addCriterion("person_a_score between", value1, value2, "personAScore");
            return (Criteria) this;
        }

        public Criteria andPersonAScoreNotBetween(String value1, String value2) {
            addCriterion("person_a_score not between", value1, value2, "personAScore");
            return (Criteria) this;
        }

        public Criteria andPersonBScoreIsNull() {
            addCriterion("person_b_score is null");
            return (Criteria) this;
        }

        public Criteria andPersonBScoreIsNotNull() {
            addCriterion("person_b_score is not null");
            return (Criteria) this;
        }

        public Criteria andPersonBScoreEqualTo(String value) {
            addCriterion("person_b_score =", value, "personBScore");
            return (Criteria) this;
        }

        public Criteria andPersonBScoreNotEqualTo(String value) {
            addCriterion("person_b_score <>", value, "personBScore");
            return (Criteria) this;
        }

        public Criteria andPersonBScoreGreaterThan(String value) {
            addCriterion("person_b_score >", value, "personBScore");
            return (Criteria) this;
        }

        public Criteria andPersonBScoreGreaterThanOrEqualTo(String value) {
            addCriterion("person_b_score >=", value, "personBScore");
            return (Criteria) this;
        }

        public Criteria andPersonBScoreLessThan(String value) {
            addCriterion("person_b_score <", value, "personBScore");
            return (Criteria) this;
        }

        public Criteria andPersonBScoreLessThanOrEqualTo(String value) {
            addCriterion("person_b_score <=", value, "personBScore");
            return (Criteria) this;
        }

        public Criteria andPersonBScoreLike(String value) {
            addCriterion("person_b_score like", value, "personBScore");
            return (Criteria) this;
        }

        public Criteria andPersonBScoreNotLike(String value) {
            addCriterion("person_b_score not like", value, "personBScore");
            return (Criteria) this;
        }

        public Criteria andPersonBScoreIn(List<String> values) {
            addCriterion("person_b_score in", values, "personBScore");
            return (Criteria) this;
        }

        public Criteria andPersonBScoreNotIn(List<String> values) {
            addCriterion("person_b_score not in", values, "personBScore");
            return (Criteria) this;
        }

        public Criteria andPersonBScoreBetween(String value1, String value2) {
            addCriterion("person_b_score between", value1, value2, "personBScore");
            return (Criteria) this;
        }

        public Criteria andPersonBScoreNotBetween(String value1, String value2) {
            addCriterion("person_b_score not between", value1, value2, "personBScore");
            return (Criteria) this;
        }

        public Criteria andPvpTimeIsNull() {
            addCriterion("pvp_time is null");
            return (Criteria) this;
        }

        public Criteria andPvpTimeIsNotNull() {
            addCriterion("pvp_time is not null");
            return (Criteria) this;
        }

        public Criteria andPvpTimeEqualTo(String value) {
            addCriterion("pvp_time =", value, "pvpTime");
            return (Criteria) this;
        }

        public Criteria andPvpTimeNotEqualTo(String value) {
            addCriterion("pvp_time <>", value, "pvpTime");
            return (Criteria) this;
        }

        public Criteria andPvpTimeGreaterThan(String value) {
            addCriterion("pvp_time >", value, "pvpTime");
            return (Criteria) this;
        }

        public Criteria andPvpTimeGreaterThanOrEqualTo(String value) {
            addCriterion("pvp_time >=", value, "pvpTime");
            return (Criteria) this;
        }

        public Criteria andPvpTimeLessThan(String value) {
            addCriterion("pvp_time <", value, "pvpTime");
            return (Criteria) this;
        }

        public Criteria andPvpTimeLessThanOrEqualTo(String value) {
            addCriterion("pvp_time <=", value, "pvpTime");
            return (Criteria) this;
        }

        public Criteria andPvpTimeLike(String value) {
            addCriterion("pvp_time like", value, "pvpTime");
            return (Criteria) this;
        }

        public Criteria andPvpTimeNotLike(String value) {
            addCriterion("pvp_time not like", value, "pvpTime");
            return (Criteria) this;
        }

        public Criteria andPvpTimeIn(List<String> values) {
            addCriterion("pvp_time in", values, "pvpTime");
            return (Criteria) this;
        }

        public Criteria andPvpTimeNotIn(List<String> values) {
            addCriterion("pvp_time not in", values, "pvpTime");
            return (Criteria) this;
        }

        public Criteria andPvpTimeBetween(String value1, String value2) {
            addCriterion("pvp_time between", value1, value2, "pvpTime");
            return (Criteria) this;
        }

        public Criteria andPvpTimeNotBetween(String value1, String value2) {
            addCriterion("pvp_time not between", value1, value2, "pvpTime");
            return (Criteria) this;
        }

        public Criteria andPvpTypeIsNull() {
            addCriterion("pvp_type is null");
            return (Criteria) this;
        }

        public Criteria andPvpTypeIsNotNull() {
            addCriterion("pvp_type is not null");
            return (Criteria) this;
        }

        public Criteria andPvpTypeEqualTo(Integer value) {
            addCriterion("pvp_type =", value, "pvpType");
            return (Criteria) this;
        }

        public Criteria andPvpTypeNotEqualTo(Integer value) {
            addCriterion("pvp_type <>", value, "pvpType");
            return (Criteria) this;
        }

        public Criteria andPvpTypeGreaterThan(Integer value) {
            addCriterion("pvp_type >", value, "pvpType");
            return (Criteria) this;
        }

        public Criteria andPvpTypeGreaterThanOrEqualTo(Integer value) {
            addCriterion("pvp_type >=", value, "pvpType");
            return (Criteria) this;
        }

        public Criteria andPvpTypeLessThan(Integer value) {
            addCriterion("pvp_type <", value, "pvpType");
            return (Criteria) this;
        }

        public Criteria andPvpTypeLessThanOrEqualTo(Integer value) {
            addCriterion("pvp_type <=", value, "pvpType");
            return (Criteria) this;
        }

        public Criteria andPvpTypeIn(List<Integer> values) {
            addCriterion("pvp_type in", values, "pvpType");
            return (Criteria) this;
        }

        public Criteria andPvpTypeNotIn(List<Integer> values) {
            addCriterion("pvp_type not in", values, "pvpType");
            return (Criteria) this;
        }

        public Criteria andPvpTypeBetween(Integer value1, Integer value2) {
            addCriterion("pvp_type between", value1, value2, "pvpType");
            return (Criteria) this;
        }

        public Criteria andPvpTypeNotBetween(Integer value1, Integer value2) {
            addCriterion("pvp_type not between", value1, value2, "pvpType");
            return (Criteria) this;
        }

        public Criteria andPersonACurrentJifenIsNull() {
            addCriterion("person_a_current_jifen is null");
            return (Criteria) this;
        }

        public Criteria andPersonACurrentJifenIsNotNull() {
            addCriterion("person_a_current_jifen is not null");
            return (Criteria) this;
        }

        public Criteria andPersonACurrentJifenEqualTo(Integer value) {
            addCriterion("person_a_current_jifen =", value, "personACurrentJifen");
            return (Criteria) this;
        }

        public Criteria andPersonACurrentJifenNotEqualTo(Integer value) {
            addCriterion("person_a_current_jifen <>", value, "personACurrentJifen");
            return (Criteria) this;
        }

        public Criteria andPersonACurrentJifenGreaterThan(Integer value) {
            addCriterion("person_a_current_jifen >", value, "personACurrentJifen");
            return (Criteria) this;
        }

        public Criteria andPersonACurrentJifenGreaterThanOrEqualTo(Integer value) {
            addCriterion("person_a_current_jifen >=", value, "personACurrentJifen");
            return (Criteria) this;
        }

        public Criteria andPersonACurrentJifenLessThan(Integer value) {
            addCriterion("person_a_current_jifen <", value, "personACurrentJifen");
            return (Criteria) this;
        }

        public Criteria andPersonACurrentJifenLessThanOrEqualTo(Integer value) {
            addCriterion("person_a_current_jifen <=", value, "personACurrentJifen");
            return (Criteria) this;
        }

        public Criteria andPersonACurrentJifenIn(List<Integer> values) {
            addCriterion("person_a_current_jifen in", values, "personACurrentJifen");
            return (Criteria) this;
        }

        public Criteria andPersonACurrentJifenNotIn(List<Integer> values) {
            addCriterion("person_a_current_jifen not in", values, "personACurrentJifen");
            return (Criteria) this;
        }

        public Criteria andPersonACurrentJifenBetween(Integer value1, Integer value2) {
            addCriterion("person_a_current_jifen between", value1, value2, "personACurrentJifen");
            return (Criteria) this;
        }

        public Criteria andPersonACurrentJifenNotBetween(Integer value1, Integer value2) {
            addCriterion("person_a_current_jifen not between", value1, value2, "personACurrentJifen");
            return (Criteria) this;
        }

        public Criteria andPersonAThisScoreIsNull() {
            addCriterion("person_a_this_score is null");
            return (Criteria) this;
        }

        public Criteria andPersonAThisScoreIsNotNull() {
            addCriterion("person_a_this_score is not null");
            return (Criteria) this;
        }

        public Criteria andPersonAThisScoreEqualTo(Integer value) {
            addCriterion("person_a_this_score =", value, "personAThisScore");
            return (Criteria) this;
        }

        public Criteria andPersonAThisScoreNotEqualTo(Integer value) {
            addCriterion("person_a_this_score <>", value, "personAThisScore");
            return (Criteria) this;
        }

        public Criteria andPersonAThisScoreGreaterThan(Integer value) {
            addCriterion("person_a_this_score >", value, "personAThisScore");
            return (Criteria) this;
        }

        public Criteria andPersonAThisScoreGreaterThanOrEqualTo(Integer value) {
            addCriterion("person_a_this_score >=", value, "personAThisScore");
            return (Criteria) this;
        }

        public Criteria andPersonAThisScoreLessThan(Integer value) {
            addCriterion("person_a_this_score <", value, "personAThisScore");
            return (Criteria) this;
        }

        public Criteria andPersonAThisScoreLessThanOrEqualTo(Integer value) {
            addCriterion("person_a_this_score <=", value, "personAThisScore");
            return (Criteria) this;
        }

        public Criteria andPersonAThisScoreIn(List<Integer> values) {
            addCriterion("person_a_this_score in", values, "personAThisScore");
            return (Criteria) this;
        }

        public Criteria andPersonAThisScoreNotIn(List<Integer> values) {
            addCriterion("person_a_this_score not in", values, "personAThisScore");
            return (Criteria) this;
        }

        public Criteria andPersonAThisScoreBetween(Integer value1, Integer value2) {
            addCriterion("person_a_this_score between", value1, value2, "personAThisScore");
            return (Criteria) this;
        }

        public Criteria andPersonAThisScoreNotBetween(Integer value1, Integer value2) {
            addCriterion("person_a_this_score not between", value1, value2, "personAThisScore");
            return (Criteria) this;
        }

        public Criteria andPersonAchievementIdIsNull() {
            addCriterion("person_achievement_id is null");
            return (Criteria) this;
        }

        public Criteria andPersonAchievementIdIsNotNull() {
            addCriterion("person_achievement_id is not null");
            return (Criteria) this;
        }

        public Criteria andPersonAchievementIdEqualTo(Integer value) {
            addCriterion("person_achievement_id =", value, "personAchievementId");
            return (Criteria) this;
        }

        public Criteria andPersonAchievementIdNotEqualTo(Integer value) {
            addCriterion("person_achievement_id <>", value, "personAchievementId");
            return (Criteria) this;
        }

        public Criteria andPersonAchievementIdGreaterThan(Integer value) {
            addCriterion("person_achievement_id >", value, "personAchievementId");
            return (Criteria) this;
        }

        public Criteria andPersonAchievementIdGreaterThanOrEqualTo(Integer value) {
            addCriterion("person_achievement_id >=", value, "personAchievementId");
            return (Criteria) this;
        }

        public Criteria andPersonAchievementIdLessThan(Integer value) {
            addCriterion("person_achievement_id <", value, "personAchievementId");
            return (Criteria) this;
        }

        public Criteria andPersonAchievementIdLessThanOrEqualTo(Integer value) {
            addCriterion("person_achievement_id <=", value, "personAchievementId");
            return (Criteria) this;
        }

        public Criteria andPersonAchievementIdIn(List<Integer> values) {
            addCriterion("person_achievement_id in", values, "personAchievementId");
            return (Criteria) this;
        }

        public Criteria andPersonAchievementIdNotIn(List<Integer> values) {
            addCriterion("person_achievement_id not in", values, "personAchievementId");
            return (Criteria) this;
        }

        public Criteria andPersonAchievementIdBetween(Integer value1, Integer value2) {
            addCriterion("person_achievement_id between", value1, value2, "personAchievementId");
            return (Criteria) this;
        }

        public Criteria andPersonAchievementIdNotBetween(Integer value1, Integer value2) {
            addCriterion("person_achievement_id not between", value1, value2, "personAchievementId");
            return (Criteria) this;
        }

        public Criteria andCompleteIsNull() {
            addCriterion("complete is null");
            return (Criteria) this;
        }

        public Criteria andCompleteIsNotNull() {
            addCriterion("complete is not null");
            return (Criteria) this;
        }

        public Criteria andCompleteEqualTo(Integer value) {
            addCriterion("complete =", value, "complete");
            return (Criteria) this;
        }

        public Criteria andCompleteNotEqualTo(Integer value) {
            addCriterion("complete <>", value, "complete");
            return (Criteria) this;
        }

        public Criteria andCompleteGreaterThan(Integer value) {
            addCriterion("complete >", value, "complete");
            return (Criteria) this;
        }

        public Criteria andCompleteGreaterThanOrEqualTo(Integer value) {
            addCriterion("complete >=", value, "complete");
            return (Criteria) this;
        }

        public Criteria andCompleteLessThan(Integer value) {
            addCriterion("complete <", value, "complete");
            return (Criteria) this;
        }

        public Criteria andCompleteLessThanOrEqualTo(Integer value) {
            addCriterion("complete <=", value, "complete");
            return (Criteria) this;
        }

        public Criteria andCompleteIn(List<Integer> values) {
            addCriterion("complete in", values, "complete");
            return (Criteria) this;
        }

        public Criteria andCompleteNotIn(List<Integer> values) {
            addCriterion("complete not in", values, "complete");
            return (Criteria) this;
        }

        public Criteria andCompleteBetween(Integer value1, Integer value2) {
            addCriterion("complete between", value1, value2, "complete");
            return (Criteria) this;
        }

        public Criteria andCompleteNotBetween(Integer value1, Integer value2) {
            addCriterion("complete not between", value1, value2, "complete");
            return (Criteria) this;
        }

        public Criteria andQuestionIdsLikeInsensitive(String value) {
            addCriterion("upper(question_ids) like", value.toUpperCase(), "questionIds");
            return (Criteria) this;
        }

        public Criteria andPersonAScoreLikeInsensitive(String value) {
            addCriterion("upper(person_a_score) like", value.toUpperCase(), "personAScore");
            return (Criteria) this;
        }

        public Criteria andPersonBScoreLikeInsensitive(String value) {
            addCriterion("upper(person_b_score) like", value.toUpperCase(), "personBScore");
            return (Criteria) this;
        }

        public Criteria andPvpTimeLikeInsensitive(String value) {
            addCriterion("upper(pvp_time) like", value.toUpperCase(), "pvpTime");
            return (Criteria) this;
        }
    }

    /**
     * pvp_person
     */
    public static class Criteria extends GeneratedCriteria {

        protected Criteria() {
            super();
        }
    }

    /**
     * pvp_person 2019-03-19
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