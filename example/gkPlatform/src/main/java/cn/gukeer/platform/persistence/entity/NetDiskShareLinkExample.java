package cn.gukeer.platform.persistence.entity;

import java.util.ArrayList;
import java.util.List;

public class NetDiskShareLinkExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public NetDiskShareLinkExample() {
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

        public Criteria andTeacherIdIsNull() {
            addCriterion("teacher_id is null");
            return (Criteria) this;
        }

        public Criteria andTeacherIdIsNotNull() {
            addCriterion("teacher_id is not null");
            return (Criteria) this;
        }

        public Criteria andTeacherIdEqualTo(String value) {
            addCriterion("teacher_id =", value, "teacherId");
            return (Criteria) this;
        }

        public Criteria andTeacherIdNotEqualTo(String value) {
            addCriterion("teacher_id <>", value, "teacherId");
            return (Criteria) this;
        }

        public Criteria andTeacherIdGreaterThan(String value) {
            addCriterion("teacher_id >", value, "teacherId");
            return (Criteria) this;
        }

        public Criteria andTeacherIdGreaterThanOrEqualTo(String value) {
            addCriterion("teacher_id >=", value, "teacherId");
            return (Criteria) this;
        }

        public Criteria andTeacherIdLessThan(String value) {
            addCriterion("teacher_id <", value, "teacherId");
            return (Criteria) this;
        }

        public Criteria andTeacherIdLessThanOrEqualTo(String value) {
            addCriterion("teacher_id <=", value, "teacherId");
            return (Criteria) this;
        }

        public Criteria andTeacherIdLike(String value) {
            addCriterion("teacher_id like", value, "teacherId");
            return (Criteria) this;
        }

        public Criteria andTeacherIdNotLike(String value) {
            addCriterion("teacher_id not like", value, "teacherId");
            return (Criteria) this;
        }

        public Criteria andTeacherIdIn(List<String> values) {
            addCriterion("teacher_id in", values, "teacherId");
            return (Criteria) this;
        }

        public Criteria andTeacherIdNotIn(List<String> values) {
            addCriterion("teacher_id not in", values, "teacherId");
            return (Criteria) this;
        }

        public Criteria andTeacherIdBetween(String value1, String value2) {
            addCriterion("teacher_id between", value1, value2, "teacherId");
            return (Criteria) this;
        }

        public Criteria andTeacherIdNotBetween(String value1, String value2) {
            addCriterion("teacher_id not between", value1, value2, "teacherId");
            return (Criteria) this;
        }

        public Criteria andLinkIsNull() {
            addCriterion("link is null");
            return (Criteria) this;
        }

        public Criteria andLinkIsNotNull() {
            addCriterion("link is not null");
            return (Criteria) this;
        }

        public Criteria andLinkEqualTo(String value) {
            addCriterion("link =", value, "link");
            return (Criteria) this;
        }

        public Criteria andLinkNotEqualTo(String value) {
            addCriterion("link <>", value, "link");
            return (Criteria) this;
        }

        public Criteria andLinkGreaterThan(String value) {
            addCriterion("link >", value, "link");
            return (Criteria) this;
        }

        public Criteria andLinkGreaterThanOrEqualTo(String value) {
            addCriterion("link >=", value, "link");
            return (Criteria) this;
        }

        public Criteria andLinkLessThan(String value) {
            addCriterion("link <", value, "link");
            return (Criteria) this;
        }

        public Criteria andLinkLessThanOrEqualTo(String value) {
            addCriterion("link <=", value, "link");
            return (Criteria) this;
        }

        public Criteria andLinkLike(String value) {
            addCriterion("link like", value, "link");
            return (Criteria) this;
        }

        public Criteria andLinkNotLike(String value) {
            addCriterion("link not like", value, "link");
            return (Criteria) this;
        }

        public Criteria andLinkIn(List<String> values) {
            addCriterion("link in", values, "link");
            return (Criteria) this;
        }

        public Criteria andLinkNotIn(List<String> values) {
            addCriterion("link not in", values, "link");
            return (Criteria) this;
        }

        public Criteria andLinkBetween(String value1, String value2) {
            addCriterion("link between", value1, value2, "link");
            return (Criteria) this;
        }

        public Criteria andLinkNotBetween(String value1, String value2) {
            addCriterion("link not between", value1, value2, "link");
            return (Criteria) this;
        }

        public Criteria andSharedTeacherIdIsNull() {
            addCriterion("shared_teacher_id is null");
            return (Criteria) this;
        }

        public Criteria andSharedTeacherIdIsNotNull() {
            addCriterion("shared_teacher_id is not null");
            return (Criteria) this;
        }

        public Criteria andSharedTeacherIdEqualTo(String value) {
            addCriterion("shared_teacher_id =", value, "sharedTeacherId");
            return (Criteria) this;
        }

        public Criteria andSharedTeacherIdNotEqualTo(String value) {
            addCriterion("shared_teacher_id <>", value, "sharedTeacherId");
            return (Criteria) this;
        }

        public Criteria andSharedTeacherIdGreaterThan(String value) {
            addCriterion("shared_teacher_id >", value, "sharedTeacherId");
            return (Criteria) this;
        }

        public Criteria andSharedTeacherIdGreaterThanOrEqualTo(String value) {
            addCriterion("shared_teacher_id >=", value, "sharedTeacherId");
            return (Criteria) this;
        }

        public Criteria andSharedTeacherIdLessThan(String value) {
            addCriterion("shared_teacher_id <", value, "sharedTeacherId");
            return (Criteria) this;
        }

        public Criteria andSharedTeacherIdLessThanOrEqualTo(String value) {
            addCriterion("shared_teacher_id <=", value, "sharedTeacherId");
            return (Criteria) this;
        }

        public Criteria andSharedTeacherIdLike(String value) {
            addCriterion("shared_teacher_id like", value, "sharedTeacherId");
            return (Criteria) this;
        }

        public Criteria andSharedTeacherIdNotLike(String value) {
            addCriterion("shared_teacher_id not like", value, "sharedTeacherId");
            return (Criteria) this;
        }

        public Criteria andSharedTeacherIdIn(List<String> values) {
            addCriterion("shared_teacher_id in", values, "sharedTeacherId");
            return (Criteria) this;
        }

        public Criteria andSharedTeacherIdNotIn(List<String> values) {
            addCriterion("shared_teacher_id not in", values, "sharedTeacherId");
            return (Criteria) this;
        }

        public Criteria andSharedTeacherIdBetween(String value1, String value2) {
            addCriterion("shared_teacher_id between", value1, value2, "sharedTeacherId");
            return (Criteria) this;
        }

        public Criteria andSharedTeacherIdNotBetween(String value1, String value2) {
            addCriterion("shared_teacher_id not between", value1, value2, "sharedTeacherId");
            return (Criteria) this;
        }

        public Criteria andShareTypeIsNull() {
            addCriterion("share_type is null");
            return (Criteria) this;
        }

        public Criteria andShareTypeIsNotNull() {
            addCriterion("share_type is not null");
            return (Criteria) this;
        }

        public Criteria andShareTypeEqualTo(Integer value) {
            addCriterion("share_type =", value, "shareType");
            return (Criteria) this;
        }

        public Criteria andShareTypeNotEqualTo(Integer value) {
            addCriterion("share_type <>", value, "shareType");
            return (Criteria) this;
        }

        public Criteria andShareTypeGreaterThan(Integer value) {
            addCriterion("share_type >", value, "shareType");
            return (Criteria) this;
        }

        public Criteria andShareTypeGreaterThanOrEqualTo(Integer value) {
            addCriterion("share_type >=", value, "shareType");
            return (Criteria) this;
        }

        public Criteria andShareTypeLessThan(Integer value) {
            addCriterion("share_type <", value, "shareType");
            return (Criteria) this;
        }

        public Criteria andShareTypeLessThanOrEqualTo(Integer value) {
            addCriterion("share_type <=", value, "shareType");
            return (Criteria) this;
        }

        public Criteria andShareTypeIn(List<Integer> values) {
            addCriterion("share_type in", values, "shareType");
            return (Criteria) this;
        }

        public Criteria andShareTypeNotIn(List<Integer> values) {
            addCriterion("share_type not in", values, "shareType");
            return (Criteria) this;
        }

        public Criteria andShareTypeBetween(Integer value1, Integer value2) {
            addCriterion("share_type between", value1, value2, "shareType");
            return (Criteria) this;
        }

        public Criteria andShareTypeNotBetween(Integer value1, Integer value2) {
            addCriterion("share_type not between", value1, value2, "shareType");
            return (Criteria) this;
        }

        public Criteria andFileNameIsNull() {
            addCriterion("file_name is null");
            return (Criteria) this;
        }

        public Criteria andFileNameIsNotNull() {
            addCriterion("file_name is not null");
            return (Criteria) this;
        }

        public Criteria andFileNameEqualTo(String value) {
            addCriterion("file_name =", value, "fileName");
            return (Criteria) this;
        }

        public Criteria andFileNameNotEqualTo(String value) {
            addCriterion("file_name <>", value, "fileName");
            return (Criteria) this;
        }

        public Criteria andFileNameGreaterThan(String value) {
            addCriterion("file_name >", value, "fileName");
            return (Criteria) this;
        }

        public Criteria andFileNameGreaterThanOrEqualTo(String value) {
            addCriterion("file_name >=", value, "fileName");
            return (Criteria) this;
        }

        public Criteria andFileNameLessThan(String value) {
            addCriterion("file_name <", value, "fileName");
            return (Criteria) this;
        }

        public Criteria andFileNameLessThanOrEqualTo(String value) {
            addCriterion("file_name <=", value, "fileName");
            return (Criteria) this;
        }

        public Criteria andFileNameLike(String value) {
            addCriterion("file_name like", value, "fileName");
            return (Criteria) this;
        }

        public Criteria andFileNameNotLike(String value) {
            addCriterion("file_name not like", value, "fileName");
            return (Criteria) this;
        }

        public Criteria andFileNameIn(List<String> values) {
            addCriterion("file_name in", values, "fileName");
            return (Criteria) this;
        }

        public Criteria andFileNameNotIn(List<String> values) {
            addCriterion("file_name not in", values, "fileName");
            return (Criteria) this;
        }

        public Criteria andFileNameBetween(String value1, String value2) {
            addCriterion("file_name between", value1, value2, "fileName");
            return (Criteria) this;
        }

        public Criteria andFileNameNotBetween(String value1, String value2) {
            addCriterion("file_name not between", value1, value2, "fileName");
            return (Criteria) this;
        }

        public Criteria andIsDirIsNull() {
            addCriterion("is_dir is null");
            return (Criteria) this;
        }

        public Criteria andIsDirIsNotNull() {
            addCriterion("is_dir is not null");
            return (Criteria) this;
        }

        public Criteria andIsDirEqualTo(Boolean value) {
            addCriterion("is_dir =", value, "isDir");
            return (Criteria) this;
        }

        public Criteria andIsDirNotEqualTo(Boolean value) {
            addCriterion("is_dir <>", value, "isDir");
            return (Criteria) this;
        }

        public Criteria andIsDirGreaterThan(Boolean value) {
            addCriterion("is_dir >", value, "isDir");
            return (Criteria) this;
        }

        public Criteria andIsDirGreaterThanOrEqualTo(Boolean value) {
            addCriterion("is_dir >=", value, "isDir");
            return (Criteria) this;
        }

        public Criteria andIsDirLessThan(Boolean value) {
            addCriterion("is_dir <", value, "isDir");
            return (Criteria) this;
        }

        public Criteria andIsDirLessThanOrEqualTo(Boolean value) {
            addCriterion("is_dir <=", value, "isDir");
            return (Criteria) this;
        }

        public Criteria andIsDirIn(List<Boolean> values) {
            addCriterion("is_dir in", values, "isDir");
            return (Criteria) this;
        }

        public Criteria andIsDirNotIn(List<Boolean> values) {
            addCriterion("is_dir not in", values, "isDir");
            return (Criteria) this;
        }

        public Criteria andIsDirBetween(Boolean value1, Boolean value2) {
            addCriterion("is_dir between", value1, value2, "isDir");
            return (Criteria) this;
        }

        public Criteria andIsDirNotBetween(Boolean value1, Boolean value2) {
            addCriterion("is_dir not between", value1, value2, "isDir");
            return (Criteria) this;
        }

        public Criteria andExpireDateIsNull() {
            addCriterion("expire_date is null");
            return (Criteria) this;
        }

        public Criteria andExpireDateIsNotNull() {
            addCriterion("expire_date is not null");
            return (Criteria) this;
        }

        public Criteria andExpireDateEqualTo(Integer value) {
            addCriterion("expire_date =", value, "expireDate");
            return (Criteria) this;
        }

        public Criteria andExpireDateNotEqualTo(Integer value) {
            addCriterion("expire_date <>", value, "expireDate");
            return (Criteria) this;
        }

        public Criteria andExpireDateGreaterThan(Integer value) {
            addCriterion("expire_date >", value, "expireDate");
            return (Criteria) this;
        }

        public Criteria andExpireDateGreaterThanOrEqualTo(Integer value) {
            addCriterion("expire_date >=", value, "expireDate");
            return (Criteria) this;
        }

        public Criteria andExpireDateLessThan(Integer value) {
            addCriterion("expire_date <", value, "expireDate");
            return (Criteria) this;
        }

        public Criteria andExpireDateLessThanOrEqualTo(Integer value) {
            addCriterion("expire_date <=", value, "expireDate");
            return (Criteria) this;
        }

        public Criteria andExpireDateIn(List<Integer> values) {
            addCriterion("expire_date in", values, "expireDate");
            return (Criteria) this;
        }

        public Criteria andExpireDateNotIn(List<Integer> values) {
            addCriterion("expire_date not in", values, "expireDate");
            return (Criteria) this;
        }

        public Criteria andExpireDateBetween(Integer value1, Integer value2) {
            addCriterion("expire_date between", value1, value2, "expireDate");
            return (Criteria) this;
        }

        public Criteria andExpireDateNotBetween(Integer value1, Integer value2) {
            addCriterion("expire_date not between", value1, value2, "expireDate");
            return (Criteria) this;
        }

        public Criteria andTokenIsNull() {
            addCriterion("token is null");
            return (Criteria) this;
        }

        public Criteria andTokenIsNotNull() {
            addCriterion("token is not null");
            return (Criteria) this;
        }

        public Criteria andTokenEqualTo(String value) {
            addCriterion("token =", value, "token");
            return (Criteria) this;
        }

        public Criteria andTokenNotEqualTo(String value) {
            addCriterion("token <>", value, "token");
            return (Criteria) this;
        }

        public Criteria andTokenGreaterThan(String value) {
            addCriterion("token >", value, "token");
            return (Criteria) this;
        }

        public Criteria andTokenGreaterThanOrEqualTo(String value) {
            addCriterion("token >=", value, "token");
            return (Criteria) this;
        }

        public Criteria andTokenLessThan(String value) {
            addCriterion("token <", value, "token");
            return (Criteria) this;
        }

        public Criteria andTokenLessThanOrEqualTo(String value) {
            addCriterion("token <=", value, "token");
            return (Criteria) this;
        }

        public Criteria andTokenLike(String value) {
            addCriterion("token like", value, "token");
            return (Criteria) this;
        }

        public Criteria andTokenNotLike(String value) {
            addCriterion("token not like", value, "token");
            return (Criteria) this;
        }

        public Criteria andTokenIn(List<String> values) {
            addCriterion("token in", values, "token");
            return (Criteria) this;
        }

        public Criteria andTokenNotIn(List<String> values) {
            addCriterion("token not in", values, "token");
            return (Criteria) this;
        }

        public Criteria andTokenBetween(String value1, String value2) {
            addCriterion("token between", value1, value2, "token");
            return (Criteria) this;
        }

        public Criteria andTokenNotBetween(String value1, String value2) {
            addCriterion("token not between", value1, value2, "token");
            return (Criteria) this;
        }

        public Criteria andCanPreviewIsNull() {
            addCriterion("can_preview is null");
            return (Criteria) this;
        }

        public Criteria andCanPreviewIsNotNull() {
            addCriterion("can_preview is not null");
            return (Criteria) this;
        }

        public Criteria andCanPreviewEqualTo(Boolean value) {
            addCriterion("can_preview =", value, "canPreview");
            return (Criteria) this;
        }

        public Criteria andCanPreviewNotEqualTo(Boolean value) {
            addCriterion("can_preview <>", value, "canPreview");
            return (Criteria) this;
        }

        public Criteria andCanPreviewGreaterThan(Boolean value) {
            addCriterion("can_preview >", value, "canPreview");
            return (Criteria) this;
        }

        public Criteria andCanPreviewGreaterThanOrEqualTo(Boolean value) {
            addCriterion("can_preview >=", value, "canPreview");
            return (Criteria) this;
        }

        public Criteria andCanPreviewLessThan(Boolean value) {
            addCriterion("can_preview <", value, "canPreview");
            return (Criteria) this;
        }

        public Criteria andCanPreviewLessThanOrEqualTo(Boolean value) {
            addCriterion("can_preview <=", value, "canPreview");
            return (Criteria) this;
        }

        public Criteria andCanPreviewIn(List<Boolean> values) {
            addCriterion("can_preview in", values, "canPreview");
            return (Criteria) this;
        }

        public Criteria andCanPreviewNotIn(List<Boolean> values) {
            addCriterion("can_preview not in", values, "canPreview");
            return (Criteria) this;
        }

        public Criteria andCanPreviewBetween(Boolean value1, Boolean value2) {
            addCriterion("can_preview between", value1, value2, "canPreview");
            return (Criteria) this;
        }

        public Criteria andCanPreviewNotBetween(Boolean value1, Boolean value2) {
            addCriterion("can_preview not between", value1, value2, "canPreview");
            return (Criteria) this;
        }

        public Criteria andCanDownlodIsNull() {
            addCriterion("can_downlod is null");
            return (Criteria) this;
        }

        public Criteria andCanDownlodIsNotNull() {
            addCriterion("can_downlod is not null");
            return (Criteria) this;
        }

        public Criteria andCanDownlodEqualTo(Boolean value) {
            addCriterion("can_downlod =", value, "canDownlod");
            return (Criteria) this;
        }

        public Criteria andCanDownlodNotEqualTo(Boolean value) {
            addCriterion("can_downlod <>", value, "canDownlod");
            return (Criteria) this;
        }

        public Criteria andCanDownlodGreaterThan(Boolean value) {
            addCriterion("can_downlod >", value, "canDownlod");
            return (Criteria) this;
        }

        public Criteria andCanDownlodGreaterThanOrEqualTo(Boolean value) {
            addCriterion("can_downlod >=", value, "canDownlod");
            return (Criteria) this;
        }

        public Criteria andCanDownlodLessThan(Boolean value) {
            addCriterion("can_downlod <", value, "canDownlod");
            return (Criteria) this;
        }

        public Criteria andCanDownlodLessThanOrEqualTo(Boolean value) {
            addCriterion("can_downlod <=", value, "canDownlod");
            return (Criteria) this;
        }

        public Criteria andCanDownlodIn(List<Boolean> values) {
            addCriterion("can_downlod in", values, "canDownlod");
            return (Criteria) this;
        }

        public Criteria andCanDownlodNotIn(List<Boolean> values) {
            addCriterion("can_downlod not in", values, "canDownlod");
            return (Criteria) this;
        }

        public Criteria andCanDownlodBetween(Boolean value1, Boolean value2) {
            addCriterion("can_downlod between", value1, value2, "canDownlod");
            return (Criteria) this;
        }

        public Criteria andCanDownlodNotBetween(Boolean value1, Boolean value2) {
            addCriterion("can_downlod not between", value1, value2, "canDownlod");
            return (Criteria) this;
        }

        public Criteria andIsExpiredIsNull() {
            addCriterion("is_expired is null");
            return (Criteria) this;
        }

        public Criteria andIsExpiredIsNotNull() {
            addCriterion("is_expired is not null");
            return (Criteria) this;
        }

        public Criteria andIsExpiredEqualTo(Boolean value) {
            addCriterion("is_expired =", value, "isExpired");
            return (Criteria) this;
        }

        public Criteria andIsExpiredNotEqualTo(Boolean value) {
            addCriterion("is_expired <>", value, "isExpired");
            return (Criteria) this;
        }

        public Criteria andIsExpiredGreaterThan(Boolean value) {
            addCriterion("is_expired >", value, "isExpired");
            return (Criteria) this;
        }

        public Criteria andIsExpiredGreaterThanOrEqualTo(Boolean value) {
            addCriterion("is_expired >=", value, "isExpired");
            return (Criteria) this;
        }

        public Criteria andIsExpiredLessThan(Boolean value) {
            addCriterion("is_expired <", value, "isExpired");
            return (Criteria) this;
        }

        public Criteria andIsExpiredLessThanOrEqualTo(Boolean value) {
            addCriterion("is_expired <=", value, "isExpired");
            return (Criteria) this;
        }

        public Criteria andIsExpiredIn(List<Boolean> values) {
            addCriterion("is_expired in", values, "isExpired");
            return (Criteria) this;
        }

        public Criteria andIsExpiredNotIn(List<Boolean> values) {
            addCriterion("is_expired not in", values, "isExpired");
            return (Criteria) this;
        }

        public Criteria andIsExpiredBetween(Boolean value1, Boolean value2) {
            addCriterion("is_expired between", value1, value2, "isExpired");
            return (Criteria) this;
        }

        public Criteria andIsExpiredNotBetween(Boolean value1, Boolean value2) {
            addCriterion("is_expired not between", value1, value2, "isExpired");
            return (Criteria) this;
        }

        public Criteria andEmailIsNull() {
            addCriterion("email is null");
            return (Criteria) this;
        }

        public Criteria andEmailIsNotNull() {
            addCriterion("email is not null");
            return (Criteria) this;
        }

        public Criteria andEmailEqualTo(String value) {
            addCriterion("email =", value, "email");
            return (Criteria) this;
        }

        public Criteria andEmailNotEqualTo(String value) {
            addCriterion("email <>", value, "email");
            return (Criteria) this;
        }

        public Criteria andEmailGreaterThan(String value) {
            addCriterion("email >", value, "email");
            return (Criteria) this;
        }

        public Criteria andEmailGreaterThanOrEqualTo(String value) {
            addCriterion("email >=", value, "email");
            return (Criteria) this;
        }

        public Criteria andEmailLessThan(String value) {
            addCriterion("email <", value, "email");
            return (Criteria) this;
        }

        public Criteria andEmailLessThanOrEqualTo(String value) {
            addCriterion("email <=", value, "email");
            return (Criteria) this;
        }

        public Criteria andEmailLike(String value) {
            addCriterion("email like", value, "email");
            return (Criteria) this;
        }

        public Criteria andEmailNotLike(String value) {
            addCriterion("email not like", value, "email");
            return (Criteria) this;
        }

        public Criteria andEmailIn(List<String> values) {
            addCriterion("email in", values, "email");
            return (Criteria) this;
        }

        public Criteria andEmailNotIn(List<String> values) {
            addCriterion("email not in", values, "email");
            return (Criteria) this;
        }

        public Criteria andEmailBetween(String value1, String value2) {
            addCriterion("email between", value1, value2, "email");
            return (Criteria) this;
        }

        public Criteria andEmailNotBetween(String value1, String value2) {
            addCriterion("email not between", value1, value2, "email");
            return (Criteria) this;
        }

        public Criteria andPathIsNull() {
            addCriterion("path is null");
            return (Criteria) this;
        }

        public Criteria andPathIsNotNull() {
            addCriterion("path is not null");
            return (Criteria) this;
        }

        public Criteria andPathEqualTo(String value) {
            addCriterion("path =", value, "path");
            return (Criteria) this;
        }

        public Criteria andPathNotEqualTo(String value) {
            addCriterion("path <>", value, "path");
            return (Criteria) this;
        }

        public Criteria andPathGreaterThan(String value) {
            addCriterion("path >", value, "path");
            return (Criteria) this;
        }

        public Criteria andPathGreaterThanOrEqualTo(String value) {
            addCriterion("path >=", value, "path");
            return (Criteria) this;
        }

        public Criteria andPathLessThan(String value) {
            addCriterion("path <", value, "path");
            return (Criteria) this;
        }

        public Criteria andPathLessThanOrEqualTo(String value) {
            addCriterion("path <=", value, "path");
            return (Criteria) this;
        }

        public Criteria andPathLike(String value) {
            addCriterion("path like", value, "path");
            return (Criteria) this;
        }

        public Criteria andPathNotLike(String value) {
            addCriterion("path not like", value, "path");
            return (Criteria) this;
        }

        public Criteria andPathIn(List<String> values) {
            addCriterion("path in", values, "path");
            return (Criteria) this;
        }

        public Criteria andPathNotIn(List<String> values) {
            addCriterion("path not in", values, "path");
            return (Criteria) this;
        }

        public Criteria andPathBetween(String value1, String value2) {
            addCriterion("path between", value1, value2, "path");
            return (Criteria) this;
        }

        public Criteria andPathNotBetween(String value1, String value2) {
            addCriterion("path not between", value1, value2, "path");
            return (Criteria) this;
        }

        public Criteria andRepoNameIsNull() {
            addCriterion("repo_name is null");
            return (Criteria) this;
        }

        public Criteria andRepoNameIsNotNull() {
            addCriterion("repo_name is not null");
            return (Criteria) this;
        }

        public Criteria andRepoNameEqualTo(String value) {
            addCriterion("repo_name =", value, "repoName");
            return (Criteria) this;
        }

        public Criteria andRepoNameNotEqualTo(String value) {
            addCriterion("repo_name <>", value, "repoName");
            return (Criteria) this;
        }

        public Criteria andRepoNameGreaterThan(String value) {
            addCriterion("repo_name >", value, "repoName");
            return (Criteria) this;
        }

        public Criteria andRepoNameGreaterThanOrEqualTo(String value) {
            addCriterion("repo_name >=", value, "repoName");
            return (Criteria) this;
        }

        public Criteria andRepoNameLessThan(String value) {
            addCriterion("repo_name <", value, "repoName");
            return (Criteria) this;
        }

        public Criteria andRepoNameLessThanOrEqualTo(String value) {
            addCriterion("repo_name <=", value, "repoName");
            return (Criteria) this;
        }

        public Criteria andRepoNameLike(String value) {
            addCriterion("repo_name like", value, "repoName");
            return (Criteria) this;
        }

        public Criteria andRepoNameNotLike(String value) {
            addCriterion("repo_name not like", value, "repoName");
            return (Criteria) this;
        }

        public Criteria andRepoNameIn(List<String> values) {
            addCriterion("repo_name in", values, "repoName");
            return (Criteria) this;
        }

        public Criteria andRepoNameNotIn(List<String> values) {
            addCriterion("repo_name not in", values, "repoName");
            return (Criteria) this;
        }

        public Criteria andRepoNameBetween(String value1, String value2) {
            addCriterion("repo_name between", value1, value2, "repoName");
            return (Criteria) this;
        }

        public Criteria andRepoNameNotBetween(String value1, String value2) {
            addCriterion("repo_name not between", value1, value2, "repoName");
            return (Criteria) this;
        }

        public Criteria andCreateTimeIsNull() {
            addCriterion("create_time is null");
            return (Criteria) this;
        }

        public Criteria andCreateTimeIsNotNull() {
            addCriterion("create_time is not null");
            return (Criteria) this;
        }

        public Criteria andCreateTimeEqualTo(Long value) {
            addCriterion("create_time =", value, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeNotEqualTo(Long value) {
            addCriterion("create_time <>", value, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeGreaterThan(Long value) {
            addCriterion("create_time >", value, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeGreaterThanOrEqualTo(Long value) {
            addCriterion("create_time >=", value, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeLessThan(Long value) {
            addCriterion("create_time <", value, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeLessThanOrEqualTo(Long value) {
            addCriterion("create_time <=", value, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeIn(List<Long> values) {
            addCriterion("create_time in", values, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeNotIn(List<Long> values) {
            addCriterion("create_time not in", values, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeBetween(Long value1, Long value2) {
            addCriterion("create_time between", value1, value2, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeNotBetween(Long value1, Long value2) {
            addCriterion("create_time not between", value1, value2, "createTime");
            return (Criteria) this;
        }

        public Criteria andTimeStrCreateIsNull() {
            addCriterion("time_str_create is null");
            return (Criteria) this;
        }

        public Criteria andTimeStrCreateIsNotNull() {
            addCriterion("time_str_create is not null");
            return (Criteria) this;
        }

        public Criteria andTimeStrCreateEqualTo(String value) {
            addCriterion("time_str_create =", value, "timeStrCreate");
            return (Criteria) this;
        }

        public Criteria andTimeStrCreateNotEqualTo(String value) {
            addCriterion("time_str_create <>", value, "timeStrCreate");
            return (Criteria) this;
        }

        public Criteria andTimeStrCreateGreaterThan(String value) {
            addCriterion("time_str_create >", value, "timeStrCreate");
            return (Criteria) this;
        }

        public Criteria andTimeStrCreateGreaterThanOrEqualTo(String value) {
            addCriterion("time_str_create >=", value, "timeStrCreate");
            return (Criteria) this;
        }

        public Criteria andTimeStrCreateLessThan(String value) {
            addCriterion("time_str_create <", value, "timeStrCreate");
            return (Criteria) this;
        }

        public Criteria andTimeStrCreateLessThanOrEqualTo(String value) {
            addCriterion("time_str_create <=", value, "timeStrCreate");
            return (Criteria) this;
        }

        public Criteria andTimeStrCreateLike(String value) {
            addCriterion("time_str_create like", value, "timeStrCreate");
            return (Criteria) this;
        }

        public Criteria andTimeStrCreateNotLike(String value) {
            addCriterion("time_str_create not like", value, "timeStrCreate");
            return (Criteria) this;
        }

        public Criteria andTimeStrCreateIn(List<String> values) {
            addCriterion("time_str_create in", values, "timeStrCreate");
            return (Criteria) this;
        }

        public Criteria andTimeStrCreateNotIn(List<String> values) {
            addCriterion("time_str_create not in", values, "timeStrCreate");
            return (Criteria) this;
        }

        public Criteria andTimeStrCreateBetween(String value1, String value2) {
            addCriterion("time_str_create between", value1, value2, "timeStrCreate");
            return (Criteria) this;
        }

        public Criteria andTimeStrCreateNotBetween(String value1, String value2) {
            addCriterion("time_str_create not between", value1, value2, "timeStrCreate");
            return (Criteria) this;
        }

        public Criteria andTimeStrUpdateIsNull() {
            addCriterion("time_str_update is null");
            return (Criteria) this;
        }

        public Criteria andTimeStrUpdateIsNotNull() {
            addCriterion("time_str_update is not null");
            return (Criteria) this;
        }

        public Criteria andTimeStrUpdateEqualTo(String value) {
            addCriterion("time_str_update =", value, "timeStrUpdate");
            return (Criteria) this;
        }

        public Criteria andTimeStrUpdateNotEqualTo(String value) {
            addCriterion("time_str_update <>", value, "timeStrUpdate");
            return (Criteria) this;
        }

        public Criteria andTimeStrUpdateGreaterThan(String value) {
            addCriterion("time_str_update >", value, "timeStrUpdate");
            return (Criteria) this;
        }

        public Criteria andTimeStrUpdateGreaterThanOrEqualTo(String value) {
            addCriterion("time_str_update >=", value, "timeStrUpdate");
            return (Criteria) this;
        }

        public Criteria andTimeStrUpdateLessThan(String value) {
            addCriterion("time_str_update <", value, "timeStrUpdate");
            return (Criteria) this;
        }

        public Criteria andTimeStrUpdateLessThanOrEqualTo(String value) {
            addCriterion("time_str_update <=", value, "timeStrUpdate");
            return (Criteria) this;
        }

        public Criteria andTimeStrUpdateLike(String value) {
            addCriterion("time_str_update like", value, "timeStrUpdate");
            return (Criteria) this;
        }

        public Criteria andTimeStrUpdateNotLike(String value) {
            addCriterion("time_str_update not like", value, "timeStrUpdate");
            return (Criteria) this;
        }

        public Criteria andTimeStrUpdateIn(List<String> values) {
            addCriterion("time_str_update in", values, "timeStrUpdate");
            return (Criteria) this;
        }

        public Criteria andTimeStrUpdateNotIn(List<String> values) {
            addCriterion("time_str_update not in", values, "timeStrUpdate");
            return (Criteria) this;
        }

        public Criteria andTimeStrUpdateBetween(String value1, String value2) {
            addCriterion("time_str_update between", value1, value2, "timeStrUpdate");
            return (Criteria) this;
        }

        public Criteria andTimeStrUpdateNotBetween(String value1, String value2) {
            addCriterion("time_str_update not between", value1, value2, "timeStrUpdate");
            return (Criteria) this;
        }

        public Criteria andFileSizeIsNull() {
            addCriterion("file_size is null");
            return (Criteria) this;
        }

        public Criteria andFileSizeIsNotNull() {
            addCriterion("file_size is not null");
            return (Criteria) this;
        }

        public Criteria andFileSizeEqualTo(String value) {
            addCriterion("file_size =", value, "fileSize");
            return (Criteria) this;
        }

        public Criteria andFileSizeNotEqualTo(String value) {
            addCriterion("file_size <>", value, "fileSize");
            return (Criteria) this;
        }

        public Criteria andFileSizeGreaterThan(String value) {
            addCriterion("file_size >", value, "fileSize");
            return (Criteria) this;
        }

        public Criteria andFileSizeGreaterThanOrEqualTo(String value) {
            addCriterion("file_size >=", value, "fileSize");
            return (Criteria) this;
        }

        public Criteria andFileSizeLessThan(String value) {
            addCriterion("file_size <", value, "fileSize");
            return (Criteria) this;
        }

        public Criteria andFileSizeLessThanOrEqualTo(String value) {
            addCriterion("file_size <=", value, "fileSize");
            return (Criteria) this;
        }

        public Criteria andFileSizeLike(String value) {
            addCriterion("file_size like", value, "fileSize");
            return (Criteria) this;
        }

        public Criteria andFileSizeNotLike(String value) {
            addCriterion("file_size not like", value, "fileSize");
            return (Criteria) this;
        }

        public Criteria andFileSizeIn(List<String> values) {
            addCriterion("file_size in", values, "fileSize");
            return (Criteria) this;
        }

        public Criteria andFileSizeNotIn(List<String> values) {
            addCriterion("file_size not in", values, "fileSize");
            return (Criteria) this;
        }

        public Criteria andFileSizeBetween(String value1, String value2) {
            addCriterion("file_size between", value1, value2, "fileSize");
            return (Criteria) this;
        }

        public Criteria andFileSizeNotBetween(String value1, String value2) {
            addCriterion("file_size not between", value1, value2, "fileSize");
            return (Criteria) this;
        }

        public Criteria andIdLikeInsensitive(String value) {
            addCriterion("upper(id) like", value.toUpperCase(), "id");
            return (Criteria) this;
        }

        public Criteria andSchoolIdLikeInsensitive(String value) {
            addCriterion("upper(school_id) like", value.toUpperCase(), "schoolId");
            return (Criteria) this;
        }

        public Criteria andTeacherIdLikeInsensitive(String value) {
            addCriterion("upper(teacher_id) like", value.toUpperCase(), "teacherId");
            return (Criteria) this;
        }

        public Criteria andLinkLikeInsensitive(String value) {
            addCriterion("upper(link) like", value.toUpperCase(), "link");
            return (Criteria) this;
        }

        public Criteria andSharedTeacherIdLikeInsensitive(String value) {
            addCriterion("upper(shared_teacher_id) like", value.toUpperCase(), "sharedTeacherId");
            return (Criteria) this;
        }

        public Criteria andFileNameLikeInsensitive(String value) {
            addCriterion("upper(file_name) like", value.toUpperCase(), "fileName");
            return (Criteria) this;
        }

        public Criteria andTokenLikeInsensitive(String value) {
            addCriterion("upper(token) like", value.toUpperCase(), "token");
            return (Criteria) this;
        }

        public Criteria andEmailLikeInsensitive(String value) {
            addCriterion("upper(email) like", value.toUpperCase(), "email");
            return (Criteria) this;
        }

        public Criteria andPathLikeInsensitive(String value) {
            addCriterion("upper(path) like", value.toUpperCase(), "path");
            return (Criteria) this;
        }

        public Criteria andRepoNameLikeInsensitive(String value) {
            addCriterion("upper(repo_name) like", value.toUpperCase(), "repoName");
            return (Criteria) this;
        }

        public Criteria andTimeStrCreateLikeInsensitive(String value) {
            addCriterion("upper(time_str_create) like", value.toUpperCase(), "timeStrCreate");
            return (Criteria) this;
        }

        public Criteria andTimeStrUpdateLikeInsensitive(String value) {
            addCriterion("upper(time_str_update) like", value.toUpperCase(), "timeStrUpdate");
            return (Criteria) this;
        }

        public Criteria andFileSizeLikeInsensitive(String value) {
            addCriterion("upper(file_size) like", value.toUpperCase(), "fileSize");
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