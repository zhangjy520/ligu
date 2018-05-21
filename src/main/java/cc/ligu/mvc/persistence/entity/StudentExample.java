package cc.ligu.mvc.persistence.entity;

import java.util.ArrayList;
import java.util.List;

public class StudentExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public StudentExample() {
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

        public Criteria andSchoolIdIsNull() {
            addCriterion("school_id is null");
            return (Criteria) this;
        }

        public Criteria andSchoolIdIsNotNull() {
            addCriterion("school_id is not null");
            return (Criteria) this;
        }

        public Criteria andSchoolIdEqualTo(Integer value) {
            addCriterion("school_id =", value, "schoolId");
            return (Criteria) this;
        }

        public Criteria andSchoolIdNotEqualTo(Integer value) {
            addCriterion("school_id <>", value, "schoolId");
            return (Criteria) this;
        }

        public Criteria andSchoolIdGreaterThan(Integer value) {
            addCriterion("school_id >", value, "schoolId");
            return (Criteria) this;
        }

        public Criteria andSchoolIdGreaterThanOrEqualTo(Integer value) {
            addCriterion("school_id >=", value, "schoolId");
            return (Criteria) this;
        }

        public Criteria andSchoolIdLessThan(Integer value) {
            addCriterion("school_id <", value, "schoolId");
            return (Criteria) this;
        }

        public Criteria andSchoolIdLessThanOrEqualTo(Integer value) {
            addCriterion("school_id <=", value, "schoolId");
            return (Criteria) this;
        }

        public Criteria andSchoolIdIn(List<Integer> values) {
            addCriterion("school_id in", values, "schoolId");
            return (Criteria) this;
        }

        public Criteria andSchoolIdNotIn(List<Integer> values) {
            addCriterion("school_id not in", values, "schoolId");
            return (Criteria) this;
        }

        public Criteria andSchoolIdBetween(Integer value1, Integer value2) {
            addCriterion("school_id between", value1, value2, "schoolId");
            return (Criteria) this;
        }

        public Criteria andSchoolIdNotBetween(Integer value1, Integer value2) {
            addCriterion("school_id not between", value1, value2, "schoolId");
            return (Criteria) this;
        }

        public Criteria andClassIdIsNull() {
            addCriterion("class_id is null");
            return (Criteria) this;
        }

        public Criteria andClassIdIsNotNull() {
            addCriterion("class_id is not null");
            return (Criteria) this;
        }

        public Criteria andClassIdEqualTo(Integer value) {
            addCriterion("class_id =", value, "classId");
            return (Criteria) this;
        }

        public Criteria andClassIdNotEqualTo(Integer value) {
            addCriterion("class_id <>", value, "classId");
            return (Criteria) this;
        }

        public Criteria andClassIdGreaterThan(Integer value) {
            addCriterion("class_id >", value, "classId");
            return (Criteria) this;
        }

        public Criteria andClassIdGreaterThanOrEqualTo(Integer value) {
            addCriterion("class_id >=", value, "classId");
            return (Criteria) this;
        }

        public Criteria andClassIdLessThan(Integer value) {
            addCriterion("class_id <", value, "classId");
            return (Criteria) this;
        }

        public Criteria andClassIdLessThanOrEqualTo(Integer value) {
            addCriterion("class_id <=", value, "classId");
            return (Criteria) this;
        }

        public Criteria andClassIdIn(List<Integer> values) {
            addCriterion("class_id in", values, "classId");
            return (Criteria) this;
        }

        public Criteria andClassIdNotIn(List<Integer> values) {
            addCriterion("class_id not in", values, "classId");
            return (Criteria) this;
        }

        public Criteria andClassIdBetween(Integer value1, Integer value2) {
            addCriterion("class_id between", value1, value2, "classId");
            return (Criteria) this;
        }

        public Criteria andClassIdNotBetween(Integer value1, Integer value2) {
            addCriterion("class_id not between", value1, value2, "classId");
            return (Criteria) this;
        }

        public Criteria andStudentAccountIsNull() {
            addCriterion("student_account is null");
            return (Criteria) this;
        }

        public Criteria andStudentAccountIsNotNull() {
            addCriterion("student_account is not null");
            return (Criteria) this;
        }

        public Criteria andStudentAccountEqualTo(String value) {
            addCriterion("student_account =", value, "studentAccount");
            return (Criteria) this;
        }

        public Criteria andStudentAccountNotEqualTo(String value) {
            addCriterion("student_account <>", value, "studentAccount");
            return (Criteria) this;
        }

        public Criteria andStudentAccountGreaterThan(String value) {
            addCriterion("student_account >", value, "studentAccount");
            return (Criteria) this;
        }

        public Criteria andStudentAccountGreaterThanOrEqualTo(String value) {
            addCriterion("student_account >=", value, "studentAccount");
            return (Criteria) this;
        }

        public Criteria andStudentAccountLessThan(String value) {
            addCriterion("student_account <", value, "studentAccount");
            return (Criteria) this;
        }

        public Criteria andStudentAccountLessThanOrEqualTo(String value) {
            addCriterion("student_account <=", value, "studentAccount");
            return (Criteria) this;
        }

        public Criteria andStudentAccountLike(String value) {
            addCriterion("student_account like", value, "studentAccount");
            return (Criteria) this;
        }

        public Criteria andStudentAccountNotLike(String value) {
            addCriterion("student_account not like", value, "studentAccount");
            return (Criteria) this;
        }

        public Criteria andStudentAccountIn(List<String> values) {
            addCriterion("student_account in", values, "studentAccount");
            return (Criteria) this;
        }

        public Criteria andStudentAccountNotIn(List<String> values) {
            addCriterion("student_account not in", values, "studentAccount");
            return (Criteria) this;
        }

        public Criteria andStudentAccountBetween(String value1, String value2) {
            addCriterion("student_account between", value1, value2, "studentAccount");
            return (Criteria) this;
        }

        public Criteria andStudentAccountNotBetween(String value1, String value2) {
            addCriterion("student_account not between", value1, value2, "studentAccount");
            return (Criteria) this;
        }

        public Criteria andPatriachAccountIsNull() {
            addCriterion("patriach_account is null");
            return (Criteria) this;
        }

        public Criteria andPatriachAccountIsNotNull() {
            addCriterion("patriach_account is not null");
            return (Criteria) this;
        }

        public Criteria andPatriachAccountEqualTo(String value) {
            addCriterion("patriach_account =", value, "patriachAccount");
            return (Criteria) this;
        }

        public Criteria andPatriachAccountNotEqualTo(String value) {
            addCriterion("patriach_account <>", value, "patriachAccount");
            return (Criteria) this;
        }

        public Criteria andPatriachAccountGreaterThan(String value) {
            addCriterion("patriach_account >", value, "patriachAccount");
            return (Criteria) this;
        }

        public Criteria andPatriachAccountGreaterThanOrEqualTo(String value) {
            addCriterion("patriach_account >=", value, "patriachAccount");
            return (Criteria) this;
        }

        public Criteria andPatriachAccountLessThan(String value) {
            addCriterion("patriach_account <", value, "patriachAccount");
            return (Criteria) this;
        }

        public Criteria andPatriachAccountLessThanOrEqualTo(String value) {
            addCriterion("patriach_account <=", value, "patriachAccount");
            return (Criteria) this;
        }

        public Criteria andPatriachAccountLike(String value) {
            addCriterion("patriach_account like", value, "patriachAccount");
            return (Criteria) this;
        }

        public Criteria andPatriachAccountNotLike(String value) {
            addCriterion("patriach_account not like", value, "patriachAccount");
            return (Criteria) this;
        }

        public Criteria andPatriachAccountIn(List<String> values) {
            addCriterion("patriach_account in", values, "patriachAccount");
            return (Criteria) this;
        }

        public Criteria andPatriachAccountNotIn(List<String> values) {
            addCriterion("patriach_account not in", values, "patriachAccount");
            return (Criteria) this;
        }

        public Criteria andPatriachAccountBetween(String value1, String value2) {
            addCriterion("patriach_account between", value1, value2, "patriachAccount");
            return (Criteria) this;
        }

        public Criteria andPatriachAccountNotBetween(String value1, String value2) {
            addCriterion("patriach_account not between", value1, value2, "patriachAccount");
            return (Criteria) this;
        }

        public Criteria andXsxmIsNull() {
            addCriterion("xsxm is null");
            return (Criteria) this;
        }

        public Criteria andXsxmIsNotNull() {
            addCriterion("xsxm is not null");
            return (Criteria) this;
        }

        public Criteria andXsxmEqualTo(String value) {
            addCriterion("xsxm =", value, "xsxm");
            return (Criteria) this;
        }

        public Criteria andXsxmNotEqualTo(String value) {
            addCriterion("xsxm <>", value, "xsxm");
            return (Criteria) this;
        }

        public Criteria andXsxmGreaterThan(String value) {
            addCriterion("xsxm >", value, "xsxm");
            return (Criteria) this;
        }

        public Criteria andXsxmGreaterThanOrEqualTo(String value) {
            addCriterion("xsxm >=", value, "xsxm");
            return (Criteria) this;
        }

        public Criteria andXsxmLessThan(String value) {
            addCriterion("xsxm <", value, "xsxm");
            return (Criteria) this;
        }

        public Criteria andXsxmLessThanOrEqualTo(String value) {
            addCriterion("xsxm <=", value, "xsxm");
            return (Criteria) this;
        }

        public Criteria andXsxmLike(String value) {
            addCriterion("xsxm like", value, "xsxm");
            return (Criteria) this;
        }

        public Criteria andXsxmNotLike(String value) {
            addCriterion("xsxm not like", value, "xsxm");
            return (Criteria) this;
        }

        public Criteria andXsxmIn(List<String> values) {
            addCriterion("xsxm in", values, "xsxm");
            return (Criteria) this;
        }

        public Criteria andXsxmNotIn(List<String> values) {
            addCriterion("xsxm not in", values, "xsxm");
            return (Criteria) this;
        }

        public Criteria andXsxmBetween(String value1, String value2) {
            addCriterion("xsxm between", value1, value2, "xsxm");
            return (Criteria) this;
        }

        public Criteria andXsxmNotBetween(String value1, String value2) {
            addCriterion("xsxm not between", value1, value2, "xsxm");
            return (Criteria) this;
        }

        public Criteria andXmpyIsNull() {
            addCriterion("xmpy is null");
            return (Criteria) this;
        }

        public Criteria andXmpyIsNotNull() {
            addCriterion("xmpy is not null");
            return (Criteria) this;
        }

        public Criteria andXmpyEqualTo(String value) {
            addCriterion("xmpy =", value, "xmpy");
            return (Criteria) this;
        }

        public Criteria andXmpyNotEqualTo(String value) {
            addCriterion("xmpy <>", value, "xmpy");
            return (Criteria) this;
        }

        public Criteria andXmpyGreaterThan(String value) {
            addCriterion("xmpy >", value, "xmpy");
            return (Criteria) this;
        }

        public Criteria andXmpyGreaterThanOrEqualTo(String value) {
            addCriterion("xmpy >=", value, "xmpy");
            return (Criteria) this;
        }

        public Criteria andXmpyLessThan(String value) {
            addCriterion("xmpy <", value, "xmpy");
            return (Criteria) this;
        }

        public Criteria andXmpyLessThanOrEqualTo(String value) {
            addCriterion("xmpy <=", value, "xmpy");
            return (Criteria) this;
        }

        public Criteria andXmpyLike(String value) {
            addCriterion("xmpy like", value, "xmpy");
            return (Criteria) this;
        }

        public Criteria andXmpyNotLike(String value) {
            addCriterion("xmpy not like", value, "xmpy");
            return (Criteria) this;
        }

        public Criteria andXmpyIn(List<String> values) {
            addCriterion("xmpy in", values, "xmpy");
            return (Criteria) this;
        }

        public Criteria andXmpyNotIn(List<String> values) {
            addCriterion("xmpy not in", values, "xmpy");
            return (Criteria) this;
        }

        public Criteria andXmpyBetween(String value1, String value2) {
            addCriterion("xmpy between", value1, value2, "xmpy");
            return (Criteria) this;
        }

        public Criteria andXmpyNotBetween(String value1, String value2) {
            addCriterion("xmpy not between", value1, value2, "xmpy");
            return (Criteria) this;
        }

        public Criteria andYwmIsNull() {
            addCriterion("ywm is null");
            return (Criteria) this;
        }

        public Criteria andYwmIsNotNull() {
            addCriterion("ywm is not null");
            return (Criteria) this;
        }

        public Criteria andYwmEqualTo(String value) {
            addCriterion("ywm =", value, "ywm");
            return (Criteria) this;
        }

        public Criteria andYwmNotEqualTo(String value) {
            addCriterion("ywm <>", value, "ywm");
            return (Criteria) this;
        }

        public Criteria andYwmGreaterThan(String value) {
            addCriterion("ywm >", value, "ywm");
            return (Criteria) this;
        }

        public Criteria andYwmGreaterThanOrEqualTo(String value) {
            addCriterion("ywm >=", value, "ywm");
            return (Criteria) this;
        }

        public Criteria andYwmLessThan(String value) {
            addCriterion("ywm <", value, "ywm");
            return (Criteria) this;
        }

        public Criteria andYwmLessThanOrEqualTo(String value) {
            addCriterion("ywm <=", value, "ywm");
            return (Criteria) this;
        }

        public Criteria andYwmLike(String value) {
            addCriterion("ywm like", value, "ywm");
            return (Criteria) this;
        }

        public Criteria andYwmNotLike(String value) {
            addCriterion("ywm not like", value, "ywm");
            return (Criteria) this;
        }

        public Criteria andYwmIn(List<String> values) {
            addCriterion("ywm in", values, "ywm");
            return (Criteria) this;
        }

        public Criteria andYwmNotIn(List<String> values) {
            addCriterion("ywm not in", values, "ywm");
            return (Criteria) this;
        }

        public Criteria andYwmBetween(String value1, String value2) {
            addCriterion("ywm between", value1, value2, "ywm");
            return (Criteria) this;
        }

        public Criteria andYwmNotBetween(String value1, String value2) {
            addCriterion("ywm not between", value1, value2, "ywm");
            return (Criteria) this;
        }

        public Criteria andYsbjIsNull() {
            addCriterion("ysbj is null");
            return (Criteria) this;
        }

        public Criteria andYsbjIsNotNull() {
            addCriterion("ysbj is not null");
            return (Criteria) this;
        }

        public Criteria andYsbjEqualTo(String value) {
            addCriterion("ysbj =", value, "ysbj");
            return (Criteria) this;
        }

        public Criteria andYsbjNotEqualTo(String value) {
            addCriterion("ysbj <>", value, "ysbj");
            return (Criteria) this;
        }

        public Criteria andYsbjGreaterThan(String value) {
            addCriterion("ysbj >", value, "ysbj");
            return (Criteria) this;
        }

        public Criteria andYsbjGreaterThanOrEqualTo(String value) {
            addCriterion("ysbj >=", value, "ysbj");
            return (Criteria) this;
        }

        public Criteria andYsbjLessThan(String value) {
            addCriterion("ysbj <", value, "ysbj");
            return (Criteria) this;
        }

        public Criteria andYsbjLessThanOrEqualTo(String value) {
            addCriterion("ysbj <=", value, "ysbj");
            return (Criteria) this;
        }

        public Criteria andYsbjLike(String value) {
            addCriterion("ysbj like", value, "ysbj");
            return (Criteria) this;
        }

        public Criteria andYsbjNotLike(String value) {
            addCriterion("ysbj not like", value, "ysbj");
            return (Criteria) this;
        }

        public Criteria andYsbjIn(List<String> values) {
            addCriterion("ysbj in", values, "ysbj");
            return (Criteria) this;
        }

        public Criteria andYsbjNotIn(List<String> values) {
            addCriterion("ysbj not in", values, "ysbj");
            return (Criteria) this;
        }

        public Criteria andYsbjBetween(String value1, String value2) {
            addCriterion("ysbj between", value1, value2, "ysbj");
            return (Criteria) this;
        }

        public Criteria andYsbjNotBetween(String value1, String value2) {
            addCriterion("ysbj not between", value1, value2, "ysbj");
            return (Criteria) this;
        }

        public Criteria andXsxbIsNull() {
            addCriterion("xsxb is null");
            return (Criteria) this;
        }

        public Criteria andXsxbIsNotNull() {
            addCriterion("xsxb is not null");
            return (Criteria) this;
        }

        public Criteria andXsxbEqualTo(Integer value) {
            addCriterion("xsxb =", value, "xsxb");
            return (Criteria) this;
        }

        public Criteria andXsxbNotEqualTo(Integer value) {
            addCriterion("xsxb <>", value, "xsxb");
            return (Criteria) this;
        }

        public Criteria andXsxbGreaterThan(Integer value) {
            addCriterion("xsxb >", value, "xsxb");
            return (Criteria) this;
        }

        public Criteria andXsxbGreaterThanOrEqualTo(Integer value) {
            addCriterion("xsxb >=", value, "xsxb");
            return (Criteria) this;
        }

        public Criteria andXsxbLessThan(Integer value) {
            addCriterion("xsxb <", value, "xsxb");
            return (Criteria) this;
        }

        public Criteria andXsxbLessThanOrEqualTo(Integer value) {
            addCriterion("xsxb <=", value, "xsxb");
            return (Criteria) this;
        }

        public Criteria andXsxbIn(List<Integer> values) {
            addCriterion("xsxb in", values, "xsxb");
            return (Criteria) this;
        }

        public Criteria andXsxbNotIn(List<Integer> values) {
            addCriterion("xsxb not in", values, "xsxb");
            return (Criteria) this;
        }

        public Criteria andXsxbBetween(Integer value1, Integer value2) {
            addCriterion("xsxb between", value1, value2, "xsxb");
            return (Criteria) this;
        }

        public Criteria andXsxbNotBetween(Integer value1, Integer value2) {
            addCriterion("xsxb not between", value1, value2, "xsxb");
            return (Criteria) this;
        }

        public Criteria andXssgIsNull() {
            addCriterion("xssg is null");
            return (Criteria) this;
        }

        public Criteria andXssgIsNotNull() {
            addCriterion("xssg is not null");
            return (Criteria) this;
        }

        public Criteria andXssgEqualTo(Integer value) {
            addCriterion("xssg =", value, "xssg");
            return (Criteria) this;
        }

        public Criteria andXssgNotEqualTo(Integer value) {
            addCriterion("xssg <>", value, "xssg");
            return (Criteria) this;
        }

        public Criteria andXssgGreaterThan(Integer value) {
            addCriterion("xssg >", value, "xssg");
            return (Criteria) this;
        }

        public Criteria andXssgGreaterThanOrEqualTo(Integer value) {
            addCriterion("xssg >=", value, "xssg");
            return (Criteria) this;
        }

        public Criteria andXssgLessThan(Integer value) {
            addCriterion("xssg <", value, "xssg");
            return (Criteria) this;
        }

        public Criteria andXssgLessThanOrEqualTo(Integer value) {
            addCriterion("xssg <=", value, "xssg");
            return (Criteria) this;
        }

        public Criteria andXssgIn(List<Integer> values) {
            addCriterion("xssg in", values, "xssg");
            return (Criteria) this;
        }

        public Criteria andXssgNotIn(List<Integer> values) {
            addCriterion("xssg not in", values, "xssg");
            return (Criteria) this;
        }

        public Criteria andXssgBetween(Integer value1, Integer value2) {
            addCriterion("xssg between", value1, value2, "xssg");
            return (Criteria) this;
        }

        public Criteria andXssgNotBetween(Integer value1, Integer value2) {
            addCriterion("xssg not between", value1, value2, "xssg");
            return (Criteria) this;
        }

        public Criteria andXstzIsNull() {
            addCriterion("xstz is null");
            return (Criteria) this;
        }

        public Criteria andXstzIsNotNull() {
            addCriterion("xstz is not null");
            return (Criteria) this;
        }

        public Criteria andXstzEqualTo(Integer value) {
            addCriterion("xstz =", value, "xstz");
            return (Criteria) this;
        }

        public Criteria andXstzNotEqualTo(Integer value) {
            addCriterion("xstz <>", value, "xstz");
            return (Criteria) this;
        }

        public Criteria andXstzGreaterThan(Integer value) {
            addCriterion("xstz >", value, "xstz");
            return (Criteria) this;
        }

        public Criteria andXstzGreaterThanOrEqualTo(Integer value) {
            addCriterion("xstz >=", value, "xstz");
            return (Criteria) this;
        }

        public Criteria andXstzLessThan(Integer value) {
            addCriterion("xstz <", value, "xstz");
            return (Criteria) this;
        }

        public Criteria andXstzLessThanOrEqualTo(Integer value) {
            addCriterion("xstz <=", value, "xstz");
            return (Criteria) this;
        }

        public Criteria andXstzIn(List<Integer> values) {
            addCriterion("xstz in", values, "xstz");
            return (Criteria) this;
        }

        public Criteria andXstzNotIn(List<Integer> values) {
            addCriterion("xstz not in", values, "xstz");
            return (Criteria) this;
        }

        public Criteria andXstzBetween(Integer value1, Integer value2) {
            addCriterion("xstz between", value1, value2, "xstz");
            return (Criteria) this;
        }

        public Criteria andXstzNotBetween(Integer value1, Integer value2) {
            addCriterion("xstz not between", value1, value2, "xstz");
            return (Criteria) this;
        }

        public Criteria andXjhIsNull() {
            addCriterion("xjh is null");
            return (Criteria) this;
        }

        public Criteria andXjhIsNotNull() {
            addCriterion("xjh is not null");
            return (Criteria) this;
        }

        public Criteria andXjhEqualTo(String value) {
            addCriterion("xjh =", value, "xjh");
            return (Criteria) this;
        }

        public Criteria andXjhNotEqualTo(String value) {
            addCriterion("xjh <>", value, "xjh");
            return (Criteria) this;
        }

        public Criteria andXjhGreaterThan(String value) {
            addCriterion("xjh >", value, "xjh");
            return (Criteria) this;
        }

        public Criteria andXjhGreaterThanOrEqualTo(String value) {
            addCriterion("xjh >=", value, "xjh");
            return (Criteria) this;
        }

        public Criteria andXjhLessThan(String value) {
            addCriterion("xjh <", value, "xjh");
            return (Criteria) this;
        }

        public Criteria andXjhLessThanOrEqualTo(String value) {
            addCriterion("xjh <=", value, "xjh");
            return (Criteria) this;
        }

        public Criteria andXjhLike(String value) {
            addCriterion("xjh like", value, "xjh");
            return (Criteria) this;
        }

        public Criteria andXjhNotLike(String value) {
            addCriterion("xjh not like", value, "xjh");
            return (Criteria) this;
        }

        public Criteria andXjhIn(List<String> values) {
            addCriterion("xjh in", values, "xjh");
            return (Criteria) this;
        }

        public Criteria andXjhNotIn(List<String> values) {
            addCriterion("xjh not in", values, "xjh");
            return (Criteria) this;
        }

        public Criteria andXjhBetween(String value1, String value2) {
            addCriterion("xjh between", value1, value2, "xjh");
            return (Criteria) this;
        }

        public Criteria andXjhNotBetween(String value1, String value2) {
            addCriterion("xjh not between", value1, value2, "xjh");
            return (Criteria) this;
        }

        public Criteria andXhIsNull() {
            addCriterion("xh is null");
            return (Criteria) this;
        }

        public Criteria andXhIsNotNull() {
            addCriterion("xh is not null");
            return (Criteria) this;
        }

        public Criteria andXhEqualTo(String value) {
            addCriterion("xh =", value, "xh");
            return (Criteria) this;
        }

        public Criteria andXhNotEqualTo(String value) {
            addCriterion("xh <>", value, "xh");
            return (Criteria) this;
        }

        public Criteria andXhGreaterThan(String value) {
            addCriterion("xh >", value, "xh");
            return (Criteria) this;
        }

        public Criteria andXhGreaterThanOrEqualTo(String value) {
            addCriterion("xh >=", value, "xh");
            return (Criteria) this;
        }

        public Criteria andXhLessThan(String value) {
            addCriterion("xh <", value, "xh");
            return (Criteria) this;
        }

        public Criteria andXhLessThanOrEqualTo(String value) {
            addCriterion("xh <=", value, "xh");
            return (Criteria) this;
        }

        public Criteria andXhLike(String value) {
            addCriterion("xh like", value, "xh");
            return (Criteria) this;
        }

        public Criteria andXhNotLike(String value) {
            addCriterion("xh not like", value, "xh");
            return (Criteria) this;
        }

        public Criteria andXhIn(List<String> values) {
            addCriterion("xh in", values, "xh");
            return (Criteria) this;
        }

        public Criteria andXhNotIn(List<String> values) {
            addCriterion("xh not in", values, "xh");
            return (Criteria) this;
        }

        public Criteria andXhBetween(String value1, String value2) {
            addCriterion("xh between", value1, value2, "xh");
            return (Criteria) this;
        }

        public Criteria andXhNotBetween(String value1, String value2) {
            addCriterion("xh not between", value1, value2, "xh");
            return (Criteria) this;
        }

        public Criteria andQgxjhIsNull() {
            addCriterion("qgxjh is null");
            return (Criteria) this;
        }

        public Criteria andQgxjhIsNotNull() {
            addCriterion("qgxjh is not null");
            return (Criteria) this;
        }

        public Criteria andQgxjhEqualTo(String value) {
            addCriterion("qgxjh =", value, "qgxjh");
            return (Criteria) this;
        }

        public Criteria andQgxjhNotEqualTo(String value) {
            addCriterion("qgxjh <>", value, "qgxjh");
            return (Criteria) this;
        }

        public Criteria andQgxjhGreaterThan(String value) {
            addCriterion("qgxjh >", value, "qgxjh");
            return (Criteria) this;
        }

        public Criteria andQgxjhGreaterThanOrEqualTo(String value) {
            addCriterion("qgxjh >=", value, "qgxjh");
            return (Criteria) this;
        }

        public Criteria andQgxjhLessThan(String value) {
            addCriterion("qgxjh <", value, "qgxjh");
            return (Criteria) this;
        }

        public Criteria andQgxjhLessThanOrEqualTo(String value) {
            addCriterion("qgxjh <=", value, "qgxjh");
            return (Criteria) this;
        }

        public Criteria andQgxjhLike(String value) {
            addCriterion("qgxjh like", value, "qgxjh");
            return (Criteria) this;
        }

        public Criteria andQgxjhNotLike(String value) {
            addCriterion("qgxjh not like", value, "qgxjh");
            return (Criteria) this;
        }

        public Criteria andQgxjhIn(List<String> values) {
            addCriterion("qgxjh in", values, "qgxjh");
            return (Criteria) this;
        }

        public Criteria andQgxjhNotIn(List<String> values) {
            addCriterion("qgxjh not in", values, "qgxjh");
            return (Criteria) this;
        }

        public Criteria andQgxjhBetween(String value1, String value2) {
            addCriterion("qgxjh between", value1, value2, "qgxjh");
            return (Criteria) this;
        }

        public Criteria andQgxjhNotBetween(String value1, String value2) {
            addCriterion("qgxjh not between", value1, value2, "qgxjh");
            return (Criteria) this;
        }

        public Criteria andJyidIsNull() {
            addCriterion("jyid is null");
            return (Criteria) this;
        }

        public Criteria andJyidIsNotNull() {
            addCriterion("jyid is not null");
            return (Criteria) this;
        }

        public Criteria andJyidEqualTo(String value) {
            addCriterion("jyid =", value, "jyid");
            return (Criteria) this;
        }

        public Criteria andJyidNotEqualTo(String value) {
            addCriterion("jyid <>", value, "jyid");
            return (Criteria) this;
        }

        public Criteria andJyidGreaterThan(String value) {
            addCriterion("jyid >", value, "jyid");
            return (Criteria) this;
        }

        public Criteria andJyidGreaterThanOrEqualTo(String value) {
            addCriterion("jyid >=", value, "jyid");
            return (Criteria) this;
        }

        public Criteria andJyidLessThan(String value) {
            addCriterion("jyid <", value, "jyid");
            return (Criteria) this;
        }

        public Criteria andJyidLessThanOrEqualTo(String value) {
            addCriterion("jyid <=", value, "jyid");
            return (Criteria) this;
        }

        public Criteria andJyidLike(String value) {
            addCriterion("jyid like", value, "jyid");
            return (Criteria) this;
        }

        public Criteria andJyidNotLike(String value) {
            addCriterion("jyid not like", value, "jyid");
            return (Criteria) this;
        }

        public Criteria andJyidIn(List<String> values) {
            addCriterion("jyid in", values, "jyid");
            return (Criteria) this;
        }

        public Criteria andJyidNotIn(List<String> values) {
            addCriterion("jyid not in", values, "jyid");
            return (Criteria) this;
        }

        public Criteria andJyidBetween(String value1, String value2) {
            addCriterion("jyid between", value1, value2, "jyid");
            return (Criteria) this;
        }

        public Criteria andJyidNotBetween(String value1, String value2) {
            addCriterion("jyid not between", value1, value2, "jyid");
            return (Criteria) this;
        }

        public Criteria andCsrqIsNull() {
            addCriterion("csrq is null");
            return (Criteria) this;
        }

        public Criteria andCsrqIsNotNull() {
            addCriterion("csrq is not null");
            return (Criteria) this;
        }

        public Criteria andCsrqEqualTo(Long value) {
            addCriterion("csrq =", value, "csrq");
            return (Criteria) this;
        }

        public Criteria andCsrqNotEqualTo(Long value) {
            addCriterion("csrq <>", value, "csrq");
            return (Criteria) this;
        }

        public Criteria andCsrqGreaterThan(Long value) {
            addCriterion("csrq >", value, "csrq");
            return (Criteria) this;
        }

        public Criteria andCsrqGreaterThanOrEqualTo(Long value) {
            addCriterion("csrq >=", value, "csrq");
            return (Criteria) this;
        }

        public Criteria andCsrqLessThan(Long value) {
            addCriterion("csrq <", value, "csrq");
            return (Criteria) this;
        }

        public Criteria andCsrqLessThanOrEqualTo(Long value) {
            addCriterion("csrq <=", value, "csrq");
            return (Criteria) this;
        }

        public Criteria andCsrqIn(List<Long> values) {
            addCriterion("csrq in", values, "csrq");
            return (Criteria) this;
        }

        public Criteria andCsrqNotIn(List<Long> values) {
            addCriterion("csrq not in", values, "csrq");
            return (Criteria) this;
        }

        public Criteria andCsrqBetween(Long value1, Long value2) {
            addCriterion("csrq between", value1, value2, "csrq");
            return (Criteria) this;
        }

        public Criteria andCsrqNotBetween(Long value1, Long value2) {
            addCriterion("csrq not between", value1, value2, "csrq");
            return (Criteria) this;
        }

        public Criteria andSydIsNull() {
            addCriterion("syd is null");
            return (Criteria) this;
        }

        public Criteria andSydIsNotNull() {
            addCriterion("syd is not null");
            return (Criteria) this;
        }

        public Criteria andSydEqualTo(String value) {
            addCriterion("syd =", value, "syd");
            return (Criteria) this;
        }

        public Criteria andSydNotEqualTo(String value) {
            addCriterion("syd <>", value, "syd");
            return (Criteria) this;
        }

        public Criteria andSydGreaterThan(String value) {
            addCriterion("syd >", value, "syd");
            return (Criteria) this;
        }

        public Criteria andSydGreaterThanOrEqualTo(String value) {
            addCriterion("syd >=", value, "syd");
            return (Criteria) this;
        }

        public Criteria andSydLessThan(String value) {
            addCriterion("syd <", value, "syd");
            return (Criteria) this;
        }

        public Criteria andSydLessThanOrEqualTo(String value) {
            addCriterion("syd <=", value, "syd");
            return (Criteria) this;
        }

        public Criteria andSydLike(String value) {
            addCriterion("syd like", value, "syd");
            return (Criteria) this;
        }

        public Criteria andSydNotLike(String value) {
            addCriterion("syd not like", value, "syd");
            return (Criteria) this;
        }

        public Criteria andSydIn(List<String> values) {
            addCriterion("syd in", values, "syd");
            return (Criteria) this;
        }

        public Criteria andSydNotIn(List<String> values) {
            addCriterion("syd not in", values, "syd");
            return (Criteria) this;
        }

        public Criteria andSydBetween(String value1, String value2) {
            addCriterion("syd between", value1, value2, "syd");
            return (Criteria) this;
        }

        public Criteria andSydNotBetween(String value1, String value2) {
            addCriterion("syd not between", value1, value2, "syd");
            return (Criteria) this;
        }

        public Criteria andYxzjlxIsNull() {
            addCriterion("yxzjlx is null");
            return (Criteria) this;
        }

        public Criteria andYxzjlxIsNotNull() {
            addCriterion("yxzjlx is not null");
            return (Criteria) this;
        }

        public Criteria andYxzjlxEqualTo(String value) {
            addCriterion("yxzjlx =", value, "yxzjlx");
            return (Criteria) this;
        }

        public Criteria andYxzjlxNotEqualTo(String value) {
            addCriterion("yxzjlx <>", value, "yxzjlx");
            return (Criteria) this;
        }

        public Criteria andYxzjlxGreaterThan(String value) {
            addCriterion("yxzjlx >", value, "yxzjlx");
            return (Criteria) this;
        }

        public Criteria andYxzjlxGreaterThanOrEqualTo(String value) {
            addCriterion("yxzjlx >=", value, "yxzjlx");
            return (Criteria) this;
        }

        public Criteria andYxzjlxLessThan(String value) {
            addCriterion("yxzjlx <", value, "yxzjlx");
            return (Criteria) this;
        }

        public Criteria andYxzjlxLessThanOrEqualTo(String value) {
            addCriterion("yxzjlx <=", value, "yxzjlx");
            return (Criteria) this;
        }

        public Criteria andYxzjlxLike(String value) {
            addCriterion("yxzjlx like", value, "yxzjlx");
            return (Criteria) this;
        }

        public Criteria andYxzjlxNotLike(String value) {
            addCriterion("yxzjlx not like", value, "yxzjlx");
            return (Criteria) this;
        }

        public Criteria andYxzjlxIn(List<String> values) {
            addCriterion("yxzjlx in", values, "yxzjlx");
            return (Criteria) this;
        }

        public Criteria andYxzjlxNotIn(List<String> values) {
            addCriterion("yxzjlx not in", values, "yxzjlx");
            return (Criteria) this;
        }

        public Criteria andYxzjlxBetween(String value1, String value2) {
            addCriterion("yxzjlx between", value1, value2, "yxzjlx");
            return (Criteria) this;
        }

        public Criteria andYxzjlxNotBetween(String value1, String value2) {
            addCriterion("yxzjlx not between", value1, value2, "yxzjlx");
            return (Criteria) this;
        }

        public Criteria andYxzjhIsNull() {
            addCriterion("yxzjh is null");
            return (Criteria) this;
        }

        public Criteria andYxzjhIsNotNull() {
            addCriterion("yxzjh is not null");
            return (Criteria) this;
        }

        public Criteria andYxzjhEqualTo(String value) {
            addCriterion("yxzjh =", value, "yxzjh");
            return (Criteria) this;
        }

        public Criteria andYxzjhNotEqualTo(String value) {
            addCriterion("yxzjh <>", value, "yxzjh");
            return (Criteria) this;
        }

        public Criteria andYxzjhGreaterThan(String value) {
            addCriterion("yxzjh >", value, "yxzjh");
            return (Criteria) this;
        }

        public Criteria andYxzjhGreaterThanOrEqualTo(String value) {
            addCriterion("yxzjh >=", value, "yxzjh");
            return (Criteria) this;
        }

        public Criteria andYxzjhLessThan(String value) {
            addCriterion("yxzjh <", value, "yxzjh");
            return (Criteria) this;
        }

        public Criteria andYxzjhLessThanOrEqualTo(String value) {
            addCriterion("yxzjh <=", value, "yxzjh");
            return (Criteria) this;
        }

        public Criteria andYxzjhLike(String value) {
            addCriterion("yxzjh like", value, "yxzjh");
            return (Criteria) this;
        }

        public Criteria andYxzjhNotLike(String value) {
            addCriterion("yxzjh not like", value, "yxzjh");
            return (Criteria) this;
        }

        public Criteria andYxzjhIn(List<String> values) {
            addCriterion("yxzjh in", values, "yxzjh");
            return (Criteria) this;
        }

        public Criteria andYxzjhNotIn(List<String> values) {
            addCriterion("yxzjh not in", values, "yxzjh");
            return (Criteria) this;
        }

        public Criteria andYxzjhBetween(String value1, String value2) {
            addCriterion("yxzjh between", value1, value2, "yxzjh");
            return (Criteria) this;
        }

        public Criteria andYxzjhNotBetween(String value1, String value2) {
            addCriterion("yxzjh not between", value1, value2, "yxzjh");
            return (Criteria) this;
        }

        public Criteria andSfbjgbIsNull() {
            addCriterion("sfbjgb is null");
            return (Criteria) this;
        }

        public Criteria andSfbjgbIsNotNull() {
            addCriterion("sfbjgb is not null");
            return (Criteria) this;
        }

        public Criteria andSfbjgbEqualTo(String value) {
            addCriterion("sfbjgb =", value, "sfbjgb");
            return (Criteria) this;
        }

        public Criteria andSfbjgbNotEqualTo(String value) {
            addCriterion("sfbjgb <>", value, "sfbjgb");
            return (Criteria) this;
        }

        public Criteria andSfbjgbGreaterThan(String value) {
            addCriterion("sfbjgb >", value, "sfbjgb");
            return (Criteria) this;
        }

        public Criteria andSfbjgbGreaterThanOrEqualTo(String value) {
            addCriterion("sfbjgb >=", value, "sfbjgb");
            return (Criteria) this;
        }

        public Criteria andSfbjgbLessThan(String value) {
            addCriterion("sfbjgb <", value, "sfbjgb");
            return (Criteria) this;
        }

        public Criteria andSfbjgbLessThanOrEqualTo(String value) {
            addCriterion("sfbjgb <=", value, "sfbjgb");
            return (Criteria) this;
        }

        public Criteria andSfbjgbLike(String value) {
            addCriterion("sfbjgb like", value, "sfbjgb");
            return (Criteria) this;
        }

        public Criteria andSfbjgbNotLike(String value) {
            addCriterion("sfbjgb not like", value, "sfbjgb");
            return (Criteria) this;
        }

        public Criteria andSfbjgbIn(List<String> values) {
            addCriterion("sfbjgb in", values, "sfbjgb");
            return (Criteria) this;
        }

        public Criteria andSfbjgbNotIn(List<String> values) {
            addCriterion("sfbjgb not in", values, "sfbjgb");
            return (Criteria) this;
        }

        public Criteria andSfbjgbBetween(String value1, String value2) {
            addCriterion("sfbjgb between", value1, value2, "sfbjgb");
            return (Criteria) this;
        }

        public Criteria andSfbjgbNotBetween(String value1, String value2) {
            addCriterion("sfbjgb not between", value1, value2, "sfbjgb");
            return (Criteria) this;
        }

        public Criteria andSfjsIsNull() {
            addCriterion("sfjs is null");
            return (Criteria) this;
        }

        public Criteria andSfjsIsNotNull() {
            addCriterion("sfjs is not null");
            return (Criteria) this;
        }

        public Criteria andSfjsEqualTo(String value) {
            addCriterion("sfjs =", value, "sfjs");
            return (Criteria) this;
        }

        public Criteria andSfjsNotEqualTo(String value) {
            addCriterion("sfjs <>", value, "sfjs");
            return (Criteria) this;
        }

        public Criteria andSfjsGreaterThan(String value) {
            addCriterion("sfjs >", value, "sfjs");
            return (Criteria) this;
        }

        public Criteria andSfjsGreaterThanOrEqualTo(String value) {
            addCriterion("sfjs >=", value, "sfjs");
            return (Criteria) this;
        }

        public Criteria andSfjsLessThan(String value) {
            addCriterion("sfjs <", value, "sfjs");
            return (Criteria) this;
        }

        public Criteria andSfjsLessThanOrEqualTo(String value) {
            addCriterion("sfjs <=", value, "sfjs");
            return (Criteria) this;
        }

        public Criteria andSfjsLike(String value) {
            addCriterion("sfjs like", value, "sfjs");
            return (Criteria) this;
        }

        public Criteria andSfjsNotLike(String value) {
            addCriterion("sfjs not like", value, "sfjs");
            return (Criteria) this;
        }

        public Criteria andSfjsIn(List<String> values) {
            addCriterion("sfjs in", values, "sfjs");
            return (Criteria) this;
        }

        public Criteria andSfjsNotIn(List<String> values) {
            addCriterion("sfjs not in", values, "sfjs");
            return (Criteria) this;
        }

        public Criteria andSfjsBetween(String value1, String value2) {
            addCriterion("sfjs between", value1, value2, "sfjs");
            return (Criteria) this;
        }

        public Criteria andSfjsNotBetween(String value1, String value2) {
            addCriterion("sfjs not between", value1, value2, "sfjs");
            return (Criteria) this;
        }

        public Criteria andSfcjIsNull() {
            addCriterion("sfcj is null");
            return (Criteria) this;
        }

        public Criteria andSfcjIsNotNull() {
            addCriterion("sfcj is not null");
            return (Criteria) this;
        }

        public Criteria andSfcjEqualTo(String value) {
            addCriterion("sfcj =", value, "sfcj");
            return (Criteria) this;
        }

        public Criteria andSfcjNotEqualTo(String value) {
            addCriterion("sfcj <>", value, "sfcj");
            return (Criteria) this;
        }

        public Criteria andSfcjGreaterThan(String value) {
            addCriterion("sfcj >", value, "sfcj");
            return (Criteria) this;
        }

        public Criteria andSfcjGreaterThanOrEqualTo(String value) {
            addCriterion("sfcj >=", value, "sfcj");
            return (Criteria) this;
        }

        public Criteria andSfcjLessThan(String value) {
            addCriterion("sfcj <", value, "sfcj");
            return (Criteria) this;
        }

        public Criteria andSfcjLessThanOrEqualTo(String value) {
            addCriterion("sfcj <=", value, "sfcj");
            return (Criteria) this;
        }

        public Criteria andSfcjLike(String value) {
            addCriterion("sfcj like", value, "sfcj");
            return (Criteria) this;
        }

        public Criteria andSfcjNotLike(String value) {
            addCriterion("sfcj not like", value, "sfcj");
            return (Criteria) this;
        }

        public Criteria andSfcjIn(List<String> values) {
            addCriterion("sfcj in", values, "sfcj");
            return (Criteria) this;
        }

        public Criteria andSfcjNotIn(List<String> values) {
            addCriterion("sfcj not in", values, "sfcj");
            return (Criteria) this;
        }

        public Criteria andSfcjBetween(String value1, String value2) {
            addCriterion("sfcj between", value1, value2, "sfcj");
            return (Criteria) this;
        }

        public Criteria andSfcjNotBetween(String value1, String value2) {
            addCriterion("sfcj not between", value1, value2, "sfcj");
            return (Criteria) this;
        }

        public Criteria andSfsbtIsNull() {
            addCriterion("sfsbt is null");
            return (Criteria) this;
        }

        public Criteria andSfsbtIsNotNull() {
            addCriterion("sfsbt is not null");
            return (Criteria) this;
        }

        public Criteria andSfsbtEqualTo(String value) {
            addCriterion("sfsbt =", value, "sfsbt");
            return (Criteria) this;
        }

        public Criteria andSfsbtNotEqualTo(String value) {
            addCriterion("sfsbt <>", value, "sfsbt");
            return (Criteria) this;
        }

        public Criteria andSfsbtGreaterThan(String value) {
            addCriterion("sfsbt >", value, "sfsbt");
            return (Criteria) this;
        }

        public Criteria andSfsbtGreaterThanOrEqualTo(String value) {
            addCriterion("sfsbt >=", value, "sfsbt");
            return (Criteria) this;
        }

        public Criteria andSfsbtLessThan(String value) {
            addCriterion("sfsbt <", value, "sfsbt");
            return (Criteria) this;
        }

        public Criteria andSfsbtLessThanOrEqualTo(String value) {
            addCriterion("sfsbt <=", value, "sfsbt");
            return (Criteria) this;
        }

        public Criteria andSfsbtLike(String value) {
            addCriterion("sfsbt like", value, "sfsbt");
            return (Criteria) this;
        }

        public Criteria andSfsbtNotLike(String value) {
            addCriterion("sfsbt not like", value, "sfsbt");
            return (Criteria) this;
        }

        public Criteria andSfsbtIn(List<String> values) {
            addCriterion("sfsbt in", values, "sfsbt");
            return (Criteria) this;
        }

        public Criteria andSfsbtNotIn(List<String> values) {
            addCriterion("sfsbt not in", values, "sfsbt");
            return (Criteria) this;
        }

        public Criteria andSfsbtBetween(String value1, String value2) {
            addCriterion("sfsbt between", value1, value2, "sfsbt");
            return (Criteria) this;
        }

        public Criteria andSfsbtNotBetween(String value1, String value2) {
            addCriterion("sfsbt not between", value1, value2, "sfsbt");
            return (Criteria) this;
        }

        public Criteria andSbtxhIsNull() {
            addCriterion("sbtxh is null");
            return (Criteria) this;
        }

        public Criteria andSbtxhIsNotNull() {
            addCriterion("sbtxh is not null");
            return (Criteria) this;
        }

        public Criteria andSbtxhEqualTo(String value) {
            addCriterion("sbtxh =", value, "sbtxh");
            return (Criteria) this;
        }

        public Criteria andSbtxhNotEqualTo(String value) {
            addCriterion("sbtxh <>", value, "sbtxh");
            return (Criteria) this;
        }

        public Criteria andSbtxhGreaterThan(String value) {
            addCriterion("sbtxh >", value, "sbtxh");
            return (Criteria) this;
        }

        public Criteria andSbtxhGreaterThanOrEqualTo(String value) {
            addCriterion("sbtxh >=", value, "sbtxh");
            return (Criteria) this;
        }

        public Criteria andSbtxhLessThan(String value) {
            addCriterion("sbtxh <", value, "sbtxh");
            return (Criteria) this;
        }

        public Criteria andSbtxhLessThanOrEqualTo(String value) {
            addCriterion("sbtxh <=", value, "sbtxh");
            return (Criteria) this;
        }

        public Criteria andSbtxhLike(String value) {
            addCriterion("sbtxh like", value, "sbtxh");
            return (Criteria) this;
        }

        public Criteria andSbtxhNotLike(String value) {
            addCriterion("sbtxh not like", value, "sbtxh");
            return (Criteria) this;
        }

        public Criteria andSbtxhIn(List<String> values) {
            addCriterion("sbtxh in", values, "sbtxh");
            return (Criteria) this;
        }

        public Criteria andSbtxhNotIn(List<String> values) {
            addCriterion("sbtxh not in", values, "sbtxh");
            return (Criteria) this;
        }

        public Criteria andSbtxhBetween(String value1, String value2) {
            addCriterion("sbtxh between", value1, value2, "sbtxh");
            return (Criteria) this;
        }

        public Criteria andSbtxhNotBetween(String value1, String value2) {
            addCriterion("sbtxh not between", value1, value2, "sbtxh");
            return (Criteria) this;
        }

        public Criteria andXslbIsNull() {
            addCriterion("xslb is null");
            return (Criteria) this;
        }

        public Criteria andXslbIsNotNull() {
            addCriterion("xslb is not null");
            return (Criteria) this;
        }

        public Criteria andXslbEqualTo(String value) {
            addCriterion("xslb =", value, "xslb");
            return (Criteria) this;
        }

        public Criteria andXslbNotEqualTo(String value) {
            addCriterion("xslb <>", value, "xslb");
            return (Criteria) this;
        }

        public Criteria andXslbGreaterThan(String value) {
            addCriterion("xslb >", value, "xslb");
            return (Criteria) this;
        }

        public Criteria andXslbGreaterThanOrEqualTo(String value) {
            addCriterion("xslb >=", value, "xslb");
            return (Criteria) this;
        }

        public Criteria andXslbLessThan(String value) {
            addCriterion("xslb <", value, "xslb");
            return (Criteria) this;
        }

        public Criteria andXslbLessThanOrEqualTo(String value) {
            addCriterion("xslb <=", value, "xslb");
            return (Criteria) this;
        }

        public Criteria andXslbLike(String value) {
            addCriterion("xslb like", value, "xslb");
            return (Criteria) this;
        }

        public Criteria andXslbNotLike(String value) {
            addCriterion("xslb not like", value, "xslb");
            return (Criteria) this;
        }

        public Criteria andXslbIn(List<String> values) {
            addCriterion("xslb in", values, "xslb");
            return (Criteria) this;
        }

        public Criteria andXslbNotIn(List<String> values) {
            addCriterion("xslb not in", values, "xslb");
            return (Criteria) this;
        }

        public Criteria andXslbBetween(String value1, String value2) {
            addCriterion("xslb between", value1, value2, "xslb");
            return (Criteria) this;
        }

        public Criteria andXslbNotBetween(String value1, String value2) {
            addCriterion("xslb not between", value1, value2, "xslb");
            return (Criteria) this;
        }

        public Criteria andGbIsNull() {
            addCriterion("gb is null");
            return (Criteria) this;
        }

        public Criteria andGbIsNotNull() {
            addCriterion("gb is not null");
            return (Criteria) this;
        }

        public Criteria andGbEqualTo(String value) {
            addCriterion("gb =", value, "gb");
            return (Criteria) this;
        }

        public Criteria andGbNotEqualTo(String value) {
            addCriterion("gb <>", value, "gb");
            return (Criteria) this;
        }

        public Criteria andGbGreaterThan(String value) {
            addCriterion("gb >", value, "gb");
            return (Criteria) this;
        }

        public Criteria andGbGreaterThanOrEqualTo(String value) {
            addCriterion("gb >=", value, "gb");
            return (Criteria) this;
        }

        public Criteria andGbLessThan(String value) {
            addCriterion("gb <", value, "gb");
            return (Criteria) this;
        }

        public Criteria andGbLessThanOrEqualTo(String value) {
            addCriterion("gb <=", value, "gb");
            return (Criteria) this;
        }

        public Criteria andGbLike(String value) {
            addCriterion("gb like", value, "gb");
            return (Criteria) this;
        }

        public Criteria andGbNotLike(String value) {
            addCriterion("gb not like", value, "gb");
            return (Criteria) this;
        }

        public Criteria andGbIn(List<String> values) {
            addCriterion("gb in", values, "gb");
            return (Criteria) this;
        }

        public Criteria andGbNotIn(List<String> values) {
            addCriterion("gb not in", values, "gb");
            return (Criteria) this;
        }

        public Criteria andGbBetween(String value1, String value2) {
            addCriterion("gb between", value1, value2, "gb");
            return (Criteria) this;
        }

        public Criteria andGbNotBetween(String value1, String value2) {
            addCriterion("gb not between", value1, value2, "gb");
            return (Criteria) this;
        }

        public Criteria andMzIsNull() {
            addCriterion("mz is null");
            return (Criteria) this;
        }

        public Criteria andMzIsNotNull() {
            addCriterion("mz is not null");
            return (Criteria) this;
        }

        public Criteria andMzEqualTo(String value) {
            addCriterion("mz =", value, "mz");
            return (Criteria) this;
        }

        public Criteria andMzNotEqualTo(String value) {
            addCriterion("mz <>", value, "mz");
            return (Criteria) this;
        }

        public Criteria andMzGreaterThan(String value) {
            addCriterion("mz >", value, "mz");
            return (Criteria) this;
        }

        public Criteria andMzGreaterThanOrEqualTo(String value) {
            addCriterion("mz >=", value, "mz");
            return (Criteria) this;
        }

        public Criteria andMzLessThan(String value) {
            addCriterion("mz <", value, "mz");
            return (Criteria) this;
        }

        public Criteria andMzLessThanOrEqualTo(String value) {
            addCriterion("mz <=", value, "mz");
            return (Criteria) this;
        }

        public Criteria andMzLike(String value) {
            addCriterion("mz like", value, "mz");
            return (Criteria) this;
        }

        public Criteria andMzNotLike(String value) {
            addCriterion("mz not like", value, "mz");
            return (Criteria) this;
        }

        public Criteria andMzIn(List<String> values) {
            addCriterion("mz in", values, "mz");
            return (Criteria) this;
        }

        public Criteria andMzNotIn(List<String> values) {
            addCriterion("mz not in", values, "mz");
            return (Criteria) this;
        }

        public Criteria andMzBetween(String value1, String value2) {
            addCriterion("mz between", value1, value2, "mz");
            return (Criteria) this;
        }

        public Criteria andMzNotBetween(String value1, String value2) {
            addCriterion("mz not between", value1, value2, "mz");
            return (Criteria) this;
        }

        public Criteria andJgIsNull() {
            addCriterion("jg is null");
            return (Criteria) this;
        }

        public Criteria andJgIsNotNull() {
            addCriterion("jg is not null");
            return (Criteria) this;
        }

        public Criteria andJgEqualTo(String value) {
            addCriterion("jg =", value, "jg");
            return (Criteria) this;
        }

        public Criteria andJgNotEqualTo(String value) {
            addCriterion("jg <>", value, "jg");
            return (Criteria) this;
        }

        public Criteria andJgGreaterThan(String value) {
            addCriterion("jg >", value, "jg");
            return (Criteria) this;
        }

        public Criteria andJgGreaterThanOrEqualTo(String value) {
            addCriterion("jg >=", value, "jg");
            return (Criteria) this;
        }

        public Criteria andJgLessThan(String value) {
            addCriterion("jg <", value, "jg");
            return (Criteria) this;
        }

        public Criteria andJgLessThanOrEqualTo(String value) {
            addCriterion("jg <=", value, "jg");
            return (Criteria) this;
        }

        public Criteria andJgLike(String value) {
            addCriterion("jg like", value, "jg");
            return (Criteria) this;
        }

        public Criteria andJgNotLike(String value) {
            addCriterion("jg not like", value, "jg");
            return (Criteria) this;
        }

        public Criteria andJgIn(List<String> values) {
            addCriterion("jg in", values, "jg");
            return (Criteria) this;
        }

        public Criteria andJgNotIn(List<String> values) {
            addCriterion("jg not in", values, "jg");
            return (Criteria) this;
        }

        public Criteria andJgBetween(String value1, String value2) {
            addCriterion("jg between", value1, value2, "jg");
            return (Criteria) this;
        }

        public Criteria andJgNotBetween(String value1, String value2) {
            addCriterion("jg not between", value1, value2, "jg");
            return (Criteria) this;
        }

        public Criteria andZzmmIsNull() {
            addCriterion("zzmm is null");
            return (Criteria) this;
        }

        public Criteria andZzmmIsNotNull() {
            addCriterion("zzmm is not null");
            return (Criteria) this;
        }

        public Criteria andZzmmEqualTo(String value) {
            addCriterion("zzmm =", value, "zzmm");
            return (Criteria) this;
        }

        public Criteria andZzmmNotEqualTo(String value) {
            addCriterion("zzmm <>", value, "zzmm");
            return (Criteria) this;
        }

        public Criteria andZzmmGreaterThan(String value) {
            addCriterion("zzmm >", value, "zzmm");
            return (Criteria) this;
        }

        public Criteria andZzmmGreaterThanOrEqualTo(String value) {
            addCriterion("zzmm >=", value, "zzmm");
            return (Criteria) this;
        }

        public Criteria andZzmmLessThan(String value) {
            addCriterion("zzmm <", value, "zzmm");
            return (Criteria) this;
        }

        public Criteria andZzmmLessThanOrEqualTo(String value) {
            addCriterion("zzmm <=", value, "zzmm");
            return (Criteria) this;
        }

        public Criteria andZzmmLike(String value) {
            addCriterion("zzmm like", value, "zzmm");
            return (Criteria) this;
        }

        public Criteria andZzmmNotLike(String value) {
            addCriterion("zzmm not like", value, "zzmm");
            return (Criteria) this;
        }

        public Criteria andZzmmIn(List<String> values) {
            addCriterion("zzmm in", values, "zzmm");
            return (Criteria) this;
        }

        public Criteria andZzmmNotIn(List<String> values) {
            addCriterion("zzmm not in", values, "zzmm");
            return (Criteria) this;
        }

        public Criteria andZzmmBetween(String value1, String value2) {
            addCriterion("zzmm between", value1, value2, "zzmm");
            return (Criteria) this;
        }

        public Criteria andZzmmNotBetween(String value1, String value2) {
            addCriterion("zzmm not between", value1, value2, "zzmm");
            return (Criteria) this;
        }

        public Criteria andJdfsIsNull() {
            addCriterion("jdfs is null");
            return (Criteria) this;
        }

        public Criteria andJdfsIsNotNull() {
            addCriterion("jdfs is not null");
            return (Criteria) this;
        }

        public Criteria andJdfsEqualTo(String value) {
            addCriterion("jdfs =", value, "jdfs");
            return (Criteria) this;
        }

        public Criteria andJdfsNotEqualTo(String value) {
            addCriterion("jdfs <>", value, "jdfs");
            return (Criteria) this;
        }

        public Criteria andJdfsGreaterThan(String value) {
            addCriterion("jdfs >", value, "jdfs");
            return (Criteria) this;
        }

        public Criteria andJdfsGreaterThanOrEqualTo(String value) {
            addCriterion("jdfs >=", value, "jdfs");
            return (Criteria) this;
        }

        public Criteria andJdfsLessThan(String value) {
            addCriterion("jdfs <", value, "jdfs");
            return (Criteria) this;
        }

        public Criteria andJdfsLessThanOrEqualTo(String value) {
            addCriterion("jdfs <=", value, "jdfs");
            return (Criteria) this;
        }

        public Criteria andJdfsLike(String value) {
            addCriterion("jdfs like", value, "jdfs");
            return (Criteria) this;
        }

        public Criteria andJdfsNotLike(String value) {
            addCriterion("jdfs not like", value, "jdfs");
            return (Criteria) this;
        }

        public Criteria andJdfsIn(List<String> values) {
            addCriterion("jdfs in", values, "jdfs");
            return (Criteria) this;
        }

        public Criteria andJdfsNotIn(List<String> values) {
            addCriterion("jdfs not in", values, "jdfs");
            return (Criteria) this;
        }

        public Criteria andJdfsBetween(String value1, String value2) {
            addCriterion("jdfs between", value1, value2, "jdfs");
            return (Criteria) this;
        }

        public Criteria andJdfsNotBetween(String value1, String value2) {
            addCriterion("jdfs not between", value1, value2, "jdfs");
            return (Criteria) this;
        }

        public Criteria andXzzIsNull() {
            addCriterion("xzz is null");
            return (Criteria) this;
        }

        public Criteria andXzzIsNotNull() {
            addCriterion("xzz is not null");
            return (Criteria) this;
        }

        public Criteria andXzzEqualTo(String value) {
            addCriterion("xzz =", value, "xzz");
            return (Criteria) this;
        }

        public Criteria andXzzNotEqualTo(String value) {
            addCriterion("xzz <>", value, "xzz");
            return (Criteria) this;
        }

        public Criteria andXzzGreaterThan(String value) {
            addCriterion("xzz >", value, "xzz");
            return (Criteria) this;
        }

        public Criteria andXzzGreaterThanOrEqualTo(String value) {
            addCriterion("xzz >=", value, "xzz");
            return (Criteria) this;
        }

        public Criteria andXzzLessThan(String value) {
            addCriterion("xzz <", value, "xzz");
            return (Criteria) this;
        }

        public Criteria andXzzLessThanOrEqualTo(String value) {
            addCriterion("xzz <=", value, "xzz");
            return (Criteria) this;
        }

        public Criteria andXzzLike(String value) {
            addCriterion("xzz like", value, "xzz");
            return (Criteria) this;
        }

        public Criteria andXzzNotLike(String value) {
            addCriterion("xzz not like", value, "xzz");
            return (Criteria) this;
        }

        public Criteria andXzzIn(List<String> values) {
            addCriterion("xzz in", values, "xzz");
            return (Criteria) this;
        }

        public Criteria andXzzNotIn(List<String> values) {
            addCriterion("xzz not in", values, "xzz");
            return (Criteria) this;
        }

        public Criteria andXzzBetween(String value1, String value2) {
            addCriterion("xzz between", value1, value2, "xzz");
            return (Criteria) this;
        }

        public Criteria andXzzNotBetween(String value1, String value2) {
            addCriterion("xzz not between", value1, value2, "xzz");
            return (Criteria) this;
        }

        public Criteria andTxdzIsNull() {
            addCriterion("txdz is null");
            return (Criteria) this;
        }

        public Criteria andTxdzIsNotNull() {
            addCriterion("txdz is not null");
            return (Criteria) this;
        }

        public Criteria andTxdzEqualTo(String value) {
            addCriterion("txdz =", value, "txdz");
            return (Criteria) this;
        }

        public Criteria andTxdzNotEqualTo(String value) {
            addCriterion("txdz <>", value, "txdz");
            return (Criteria) this;
        }

        public Criteria andTxdzGreaterThan(String value) {
            addCriterion("txdz >", value, "txdz");
            return (Criteria) this;
        }

        public Criteria andTxdzGreaterThanOrEqualTo(String value) {
            addCriterion("txdz >=", value, "txdz");
            return (Criteria) this;
        }

        public Criteria andTxdzLessThan(String value) {
            addCriterion("txdz <", value, "txdz");
            return (Criteria) this;
        }

        public Criteria andTxdzLessThanOrEqualTo(String value) {
            addCriterion("txdz <=", value, "txdz");
            return (Criteria) this;
        }

        public Criteria andTxdzLike(String value) {
            addCriterion("txdz like", value, "txdz");
            return (Criteria) this;
        }

        public Criteria andTxdzNotLike(String value) {
            addCriterion("txdz not like", value, "txdz");
            return (Criteria) this;
        }

        public Criteria andTxdzIn(List<String> values) {
            addCriterion("txdz in", values, "txdz");
            return (Criteria) this;
        }

        public Criteria andTxdzNotIn(List<String> values) {
            addCriterion("txdz not in", values, "txdz");
            return (Criteria) this;
        }

        public Criteria andTxdzBetween(String value1, String value2) {
            addCriterion("txdz between", value1, value2, "txdz");
            return (Criteria) this;
        }

        public Criteria andTxdzNotBetween(String value1, String value2) {
            addCriterion("txdz not between", value1, value2, "txdz");
            return (Criteria) this;
        }

        public Criteria andHkxzIsNull() {
            addCriterion("hkxz is null");
            return (Criteria) this;
        }

        public Criteria andHkxzIsNotNull() {
            addCriterion("hkxz is not null");
            return (Criteria) this;
        }

        public Criteria andHkxzEqualTo(String value) {
            addCriterion("hkxz =", value, "hkxz");
            return (Criteria) this;
        }

        public Criteria andHkxzNotEqualTo(String value) {
            addCriterion("hkxz <>", value, "hkxz");
            return (Criteria) this;
        }

        public Criteria andHkxzGreaterThan(String value) {
            addCriterion("hkxz >", value, "hkxz");
            return (Criteria) this;
        }

        public Criteria andHkxzGreaterThanOrEqualTo(String value) {
            addCriterion("hkxz >=", value, "hkxz");
            return (Criteria) this;
        }

        public Criteria andHkxzLessThan(String value) {
            addCriterion("hkxz <", value, "hkxz");
            return (Criteria) this;
        }

        public Criteria andHkxzLessThanOrEqualTo(String value) {
            addCriterion("hkxz <=", value, "hkxz");
            return (Criteria) this;
        }

        public Criteria andHkxzLike(String value) {
            addCriterion("hkxz like", value, "hkxz");
            return (Criteria) this;
        }

        public Criteria andHkxzNotLike(String value) {
            addCriterion("hkxz not like", value, "hkxz");
            return (Criteria) this;
        }

        public Criteria andHkxzIn(List<String> values) {
            addCriterion("hkxz in", values, "hkxz");
            return (Criteria) this;
        }

        public Criteria andHkxzNotIn(List<String> values) {
            addCriterion("hkxz not in", values, "hkxz");
            return (Criteria) this;
        }

        public Criteria andHkxzBetween(String value1, String value2) {
            addCriterion("hkxz between", value1, value2, "hkxz");
            return (Criteria) this;
        }

        public Criteria andHkxzNotBetween(String value1, String value2) {
            addCriterion("hkxz not between", value1, value2, "hkxz");
            return (Criteria) this;
        }

        public Criteria andHkszdIsNull() {
            addCriterion("hkszd is null");
            return (Criteria) this;
        }

        public Criteria andHkszdIsNotNull() {
            addCriterion("hkszd is not null");
            return (Criteria) this;
        }

        public Criteria andHkszdEqualTo(String value) {
            addCriterion("hkszd =", value, "hkszd");
            return (Criteria) this;
        }

        public Criteria andHkszdNotEqualTo(String value) {
            addCriterion("hkszd <>", value, "hkszd");
            return (Criteria) this;
        }

        public Criteria andHkszdGreaterThan(String value) {
            addCriterion("hkszd >", value, "hkszd");
            return (Criteria) this;
        }

        public Criteria andHkszdGreaterThanOrEqualTo(String value) {
            addCriterion("hkszd >=", value, "hkszd");
            return (Criteria) this;
        }

        public Criteria andHkszdLessThan(String value) {
            addCriterion("hkszd <", value, "hkszd");
            return (Criteria) this;
        }

        public Criteria andHkszdLessThanOrEqualTo(String value) {
            addCriterion("hkszd <=", value, "hkszd");
            return (Criteria) this;
        }

        public Criteria andHkszdLike(String value) {
            addCriterion("hkszd like", value, "hkszd");
            return (Criteria) this;
        }

        public Criteria andHkszdNotLike(String value) {
            addCriterion("hkszd not like", value, "hkszd");
            return (Criteria) this;
        }

        public Criteria andHkszdIn(List<String> values) {
            addCriterion("hkszd in", values, "hkszd");
            return (Criteria) this;
        }

        public Criteria andHkszdNotIn(List<String> values) {
            addCriterion("hkszd not in", values, "hkszd");
            return (Criteria) this;
        }

        public Criteria andHkszdBetween(String value1, String value2) {
            addCriterion("hkszd between", value1, value2, "hkszd");
            return (Criteria) this;
        }

        public Criteria andHkszdNotBetween(String value1, String value2) {
            addCriterion("hkszd not between", value1, value2, "hkszd");
            return (Criteria) this;
        }

        public Criteria andHkszdxxdzIsNull() {
            addCriterion("hkszdxxdz is null");
            return (Criteria) this;
        }

        public Criteria andHkszdxxdzIsNotNull() {
            addCriterion("hkszdxxdz is not null");
            return (Criteria) this;
        }

        public Criteria andHkszdxxdzEqualTo(String value) {
            addCriterion("hkszdxxdz =", value, "hkszdxxdz");
            return (Criteria) this;
        }

        public Criteria andHkszdxxdzNotEqualTo(String value) {
            addCriterion("hkszdxxdz <>", value, "hkszdxxdz");
            return (Criteria) this;
        }

        public Criteria andHkszdxxdzGreaterThan(String value) {
            addCriterion("hkszdxxdz >", value, "hkszdxxdz");
            return (Criteria) this;
        }

        public Criteria andHkszdxxdzGreaterThanOrEqualTo(String value) {
            addCriterion("hkszdxxdz >=", value, "hkszdxxdz");
            return (Criteria) this;
        }

        public Criteria andHkszdxxdzLessThan(String value) {
            addCriterion("hkszdxxdz <", value, "hkszdxxdz");
            return (Criteria) this;
        }

        public Criteria andHkszdxxdzLessThanOrEqualTo(String value) {
            addCriterion("hkszdxxdz <=", value, "hkszdxxdz");
            return (Criteria) this;
        }

        public Criteria andHkszdxxdzLike(String value) {
            addCriterion("hkszdxxdz like", value, "hkszdxxdz");
            return (Criteria) this;
        }

        public Criteria andHkszdxxdzNotLike(String value) {
            addCriterion("hkszdxxdz not like", value, "hkszdxxdz");
            return (Criteria) this;
        }

        public Criteria andHkszdxxdzIn(List<String> values) {
            addCriterion("hkszdxxdz in", values, "hkszdxxdz");
            return (Criteria) this;
        }

        public Criteria andHkszdxxdzNotIn(List<String> values) {
            addCriterion("hkszdxxdz not in", values, "hkszdxxdz");
            return (Criteria) this;
        }

        public Criteria andHkszdxxdzBetween(String value1, String value2) {
            addCriterion("hkszdxxdz between", value1, value2, "hkszdxxdz");
            return (Criteria) this;
        }

        public Criteria andHkszdxxdzNotBetween(String value1, String value2) {
            addCriterion("hkszdxxdz not between", value1, value2, "hkszdxxdz");
            return (Criteria) this;
        }

        public Criteria andSfabshkxsddIsNull() {
            addCriterion("sfabshkxsdd is null");
            return (Criteria) this;
        }

        public Criteria andSfabshkxsddIsNotNull() {
            addCriterion("sfabshkxsdd is not null");
            return (Criteria) this;
        }

        public Criteria andSfabshkxsddEqualTo(String value) {
            addCriterion("sfabshkxsdd =", value, "sfabshkxsdd");
            return (Criteria) this;
        }

        public Criteria andSfabshkxsddNotEqualTo(String value) {
            addCriterion("sfabshkxsdd <>", value, "sfabshkxsdd");
            return (Criteria) this;
        }

        public Criteria andSfabshkxsddGreaterThan(String value) {
            addCriterion("sfabshkxsdd >", value, "sfabshkxsdd");
            return (Criteria) this;
        }

        public Criteria andSfabshkxsddGreaterThanOrEqualTo(String value) {
            addCriterion("sfabshkxsdd >=", value, "sfabshkxsdd");
            return (Criteria) this;
        }

        public Criteria andSfabshkxsddLessThan(String value) {
            addCriterion("sfabshkxsdd <", value, "sfabshkxsdd");
            return (Criteria) this;
        }

        public Criteria andSfabshkxsddLessThanOrEqualTo(String value) {
            addCriterion("sfabshkxsdd <=", value, "sfabshkxsdd");
            return (Criteria) this;
        }

        public Criteria andSfabshkxsddLike(String value) {
            addCriterion("sfabshkxsdd like", value, "sfabshkxsdd");
            return (Criteria) this;
        }

        public Criteria andSfabshkxsddNotLike(String value) {
            addCriterion("sfabshkxsdd not like", value, "sfabshkxsdd");
            return (Criteria) this;
        }

        public Criteria andSfabshkxsddIn(List<String> values) {
            addCriterion("sfabshkxsdd in", values, "sfabshkxsdd");
            return (Criteria) this;
        }

        public Criteria andSfabshkxsddNotIn(List<String> values) {
            addCriterion("sfabshkxsdd not in", values, "sfabshkxsdd");
            return (Criteria) this;
        }

        public Criteria andSfabshkxsddBetween(String value1, String value2) {
            addCriterion("sfabshkxsdd between", value1, value2, "sfabshkxsdd");
            return (Criteria) this;
        }

        public Criteria andSfabshkxsddNotBetween(String value1, String value2) {
            addCriterion("sfabshkxsdd not between", value1, value2, "sfabshkxsdd");
            return (Criteria) this;
        }

        public Criteria andSfbsxjIsNull() {
            addCriterion("sfbsxj is null");
            return (Criteria) this;
        }

        public Criteria andSfbsxjIsNotNull() {
            addCriterion("sfbsxj is not null");
            return (Criteria) this;
        }

        public Criteria andSfbsxjEqualTo(String value) {
            addCriterion("sfbsxj =", value, "sfbsxj");
            return (Criteria) this;
        }

        public Criteria andSfbsxjNotEqualTo(String value) {
            addCriterion("sfbsxj <>", value, "sfbsxj");
            return (Criteria) this;
        }

        public Criteria andSfbsxjGreaterThan(String value) {
            addCriterion("sfbsxj >", value, "sfbsxj");
            return (Criteria) this;
        }

        public Criteria andSfbsxjGreaterThanOrEqualTo(String value) {
            addCriterion("sfbsxj >=", value, "sfbsxj");
            return (Criteria) this;
        }

        public Criteria andSfbsxjLessThan(String value) {
            addCriterion("sfbsxj <", value, "sfbsxj");
            return (Criteria) this;
        }

        public Criteria andSfbsxjLessThanOrEqualTo(String value) {
            addCriterion("sfbsxj <=", value, "sfbsxj");
            return (Criteria) this;
        }

        public Criteria andSfbsxjLike(String value) {
            addCriterion("sfbsxj like", value, "sfbsxj");
            return (Criteria) this;
        }

        public Criteria andSfbsxjNotLike(String value) {
            addCriterion("sfbsxj not like", value, "sfbsxj");
            return (Criteria) this;
        }

        public Criteria andSfbsxjIn(List<String> values) {
            addCriterion("sfbsxj in", values, "sfbsxj");
            return (Criteria) this;
        }

        public Criteria andSfbsxjNotIn(List<String> values) {
            addCriterion("sfbsxj not in", values, "sfbsxj");
            return (Criteria) this;
        }

        public Criteria andSfbsxjBetween(String value1, String value2) {
            addCriterion("sfbsxj between", value1, value2, "sfbsxj");
            return (Criteria) this;
        }

        public Criteria andSfbsxjNotBetween(String value1, String value2) {
            addCriterion("sfbsxj not between", value1, value2, "sfbsxj");
            return (Criteria) this;
        }

        public Criteria andZslbIsNull() {
            addCriterion("zslb is null");
            return (Criteria) this;
        }

        public Criteria andZslbIsNotNull() {
            addCriterion("zslb is not null");
            return (Criteria) this;
        }

        public Criteria andZslbEqualTo(String value) {
            addCriterion("zslb =", value, "zslb");
            return (Criteria) this;
        }

        public Criteria andZslbNotEqualTo(String value) {
            addCriterion("zslb <>", value, "zslb");
            return (Criteria) this;
        }

        public Criteria andZslbGreaterThan(String value) {
            addCriterion("zslb >", value, "zslb");
            return (Criteria) this;
        }

        public Criteria andZslbGreaterThanOrEqualTo(String value) {
            addCriterion("zslb >=", value, "zslb");
            return (Criteria) this;
        }

        public Criteria andZslbLessThan(String value) {
            addCriterion("zslb <", value, "zslb");
            return (Criteria) this;
        }

        public Criteria andZslbLessThanOrEqualTo(String value) {
            addCriterion("zslb <=", value, "zslb");
            return (Criteria) this;
        }

        public Criteria andZslbLike(String value) {
            addCriterion("zslb like", value, "zslb");
            return (Criteria) this;
        }

        public Criteria andZslbNotLike(String value) {
            addCriterion("zslb not like", value, "zslb");
            return (Criteria) this;
        }

        public Criteria andZslbIn(List<String> values) {
            addCriterion("zslb in", values, "zslb");
            return (Criteria) this;
        }

        public Criteria andZslbNotIn(List<String> values) {
            addCriterion("zslb not in", values, "zslb");
            return (Criteria) this;
        }

        public Criteria andZslbBetween(String value1, String value2) {
            addCriterion("zslb between", value1, value2, "zslb");
            return (Criteria) this;
        }

        public Criteria andZslbNotBetween(String value1, String value2) {
            addCriterion("zslb not between", value1, value2, "zslb");
            return (Criteria) this;
        }

        public Criteria andXszpIsNull() {
            addCriterion("xszp is null");
            return (Criteria) this;
        }

        public Criteria andXszpIsNotNull() {
            addCriterion("xszp is not null");
            return (Criteria) this;
        }

        public Criteria andXszpEqualTo(String value) {
            addCriterion("xszp =", value, "xszp");
            return (Criteria) this;
        }

        public Criteria andXszpNotEqualTo(String value) {
            addCriterion("xszp <>", value, "xszp");
            return (Criteria) this;
        }

        public Criteria andXszpGreaterThan(String value) {
            addCriterion("xszp >", value, "xszp");
            return (Criteria) this;
        }

        public Criteria andXszpGreaterThanOrEqualTo(String value) {
            addCriterion("xszp >=", value, "xszp");
            return (Criteria) this;
        }

        public Criteria andXszpLessThan(String value) {
            addCriterion("xszp <", value, "xszp");
            return (Criteria) this;
        }

        public Criteria andXszpLessThanOrEqualTo(String value) {
            addCriterion("xszp <=", value, "xszp");
            return (Criteria) this;
        }

        public Criteria andXszpLike(String value) {
            addCriterion("xszp like", value, "xszp");
            return (Criteria) this;
        }

        public Criteria andXszpNotLike(String value) {
            addCriterion("xszp not like", value, "xszp");
            return (Criteria) this;
        }

        public Criteria andXszpIn(List<String> values) {
            addCriterion("xszp in", values, "xszp");
            return (Criteria) this;
        }

        public Criteria andXszpNotIn(List<String> values) {
            addCriterion("xszp not in", values, "xszp");
            return (Criteria) this;
        }

        public Criteria andXszpBetween(String value1, String value2) {
            addCriterion("xszp between", value1, value2, "xszp");
            return (Criteria) this;
        }

        public Criteria andXszpNotBetween(String value1, String value2) {
            addCriterion("xszp not between", value1, value2, "xszp");
            return (Criteria) this;
        }

        public Criteria andDyzhIsNull() {
            addCriterion("dyzh is null");
            return (Criteria) this;
        }

        public Criteria andDyzhIsNotNull() {
            addCriterion("dyzh is not null");
            return (Criteria) this;
        }

        public Criteria andDyzhEqualTo(String value) {
            addCriterion("dyzh =", value, "dyzh");
            return (Criteria) this;
        }

        public Criteria andDyzhNotEqualTo(String value) {
            addCriterion("dyzh <>", value, "dyzh");
            return (Criteria) this;
        }

        public Criteria andDyzhGreaterThan(String value) {
            addCriterion("dyzh >", value, "dyzh");
            return (Criteria) this;
        }

        public Criteria andDyzhGreaterThanOrEqualTo(String value) {
            addCriterion("dyzh >=", value, "dyzh");
            return (Criteria) this;
        }

        public Criteria andDyzhLessThan(String value) {
            addCriterion("dyzh <", value, "dyzh");
            return (Criteria) this;
        }

        public Criteria andDyzhLessThanOrEqualTo(String value) {
            addCriterion("dyzh <=", value, "dyzh");
            return (Criteria) this;
        }

        public Criteria andDyzhLike(String value) {
            addCriterion("dyzh like", value, "dyzh");
            return (Criteria) this;
        }

        public Criteria andDyzhNotLike(String value) {
            addCriterion("dyzh not like", value, "dyzh");
            return (Criteria) this;
        }

        public Criteria andDyzhIn(List<String> values) {
            addCriterion("dyzh in", values, "dyzh");
            return (Criteria) this;
        }

        public Criteria andDyzhNotIn(List<String> values) {
            addCriterion("dyzh not in", values, "dyzh");
            return (Criteria) this;
        }

        public Criteria andDyzhBetween(String value1, String value2) {
            addCriterion("dyzh between", value1, value2, "dyzh");
            return (Criteria) this;
        }

        public Criteria andDyzhNotBetween(String value1, String value2) {
            addCriterion("dyzh not between", value1, value2, "dyzh");
            return (Criteria) this;
        }

        public Criteria andJzzhIsNull() {
            addCriterion("jzzh is null");
            return (Criteria) this;
        }

        public Criteria andJzzhIsNotNull() {
            addCriterion("jzzh is not null");
            return (Criteria) this;
        }

        public Criteria andJzzhEqualTo(String value) {
            addCriterion("jzzh =", value, "jzzh");
            return (Criteria) this;
        }

        public Criteria andJzzhNotEqualTo(String value) {
            addCriterion("jzzh <>", value, "jzzh");
            return (Criteria) this;
        }

        public Criteria andJzzhGreaterThan(String value) {
            addCriterion("jzzh >", value, "jzzh");
            return (Criteria) this;
        }

        public Criteria andJzzhGreaterThanOrEqualTo(String value) {
            addCriterion("jzzh >=", value, "jzzh");
            return (Criteria) this;
        }

        public Criteria andJzzhLessThan(String value) {
            addCriterion("jzzh <", value, "jzzh");
            return (Criteria) this;
        }

        public Criteria andJzzhLessThanOrEqualTo(String value) {
            addCriterion("jzzh <=", value, "jzzh");
            return (Criteria) this;
        }

        public Criteria andJzzhLike(String value) {
            addCriterion("jzzh like", value, "jzzh");
            return (Criteria) this;
        }

        public Criteria andJzzhNotLike(String value) {
            addCriterion("jzzh not like", value, "jzzh");
            return (Criteria) this;
        }

        public Criteria andJzzhIn(List<String> values) {
            addCriterion("jzzh in", values, "jzzh");
            return (Criteria) this;
        }

        public Criteria andJzzhNotIn(List<String> values) {
            addCriterion("jzzh not in", values, "jzzh");
            return (Criteria) this;
        }

        public Criteria andJzzhBetween(String value1, String value2) {
            addCriterion("jzzh between", value1, value2, "jzzh");
            return (Criteria) this;
        }

        public Criteria andJzzhNotBetween(String value1, String value2) {
            addCriterion("jzzh not between", value1, value2, "jzzh");
            return (Criteria) this;
        }

        public Criteria andRxndIsNull() {
            addCriterion("rxnd is null");
            return (Criteria) this;
        }

        public Criteria andRxndIsNotNull() {
            addCriterion("rxnd is not null");
            return (Criteria) this;
        }

        public Criteria andRxndEqualTo(String value) {
            addCriterion("rxnd =", value, "rxnd");
            return (Criteria) this;
        }

        public Criteria andRxndNotEqualTo(String value) {
            addCriterion("rxnd <>", value, "rxnd");
            return (Criteria) this;
        }

        public Criteria andRxndGreaterThan(String value) {
            addCriterion("rxnd >", value, "rxnd");
            return (Criteria) this;
        }

        public Criteria andRxndGreaterThanOrEqualTo(String value) {
            addCriterion("rxnd >=", value, "rxnd");
            return (Criteria) this;
        }

        public Criteria andRxndLessThan(String value) {
            addCriterion("rxnd <", value, "rxnd");
            return (Criteria) this;
        }

        public Criteria andRxndLessThanOrEqualTo(String value) {
            addCriterion("rxnd <=", value, "rxnd");
            return (Criteria) this;
        }

        public Criteria andRxndLike(String value) {
            addCriterion("rxnd like", value, "rxnd");
            return (Criteria) this;
        }

        public Criteria andRxndNotLike(String value) {
            addCriterion("rxnd not like", value, "rxnd");
            return (Criteria) this;
        }

        public Criteria andRxndIn(List<String> values) {
            addCriterion("rxnd in", values, "rxnd");
            return (Criteria) this;
        }

        public Criteria andRxndNotIn(List<String> values) {
            addCriterion("rxnd not in", values, "rxnd");
            return (Criteria) this;
        }

        public Criteria andRxndBetween(String value1, String value2) {
            addCriterion("rxnd between", value1, value2, "rxnd");
            return (Criteria) this;
        }

        public Criteria andRxndNotBetween(String value1, String value2) {
            addCriterion("rxnd not between", value1, value2, "rxnd");
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

        public Criteria andStatusEqualTo(Integer value) {
            addCriterion("status =", value, "status");
            return (Criteria) this;
        }

        public Criteria andStatusNotEqualTo(Integer value) {
            addCriterion("status <>", value, "status");
            return (Criteria) this;
        }

        public Criteria andStatusGreaterThan(Integer value) {
            addCriterion("status >", value, "status");
            return (Criteria) this;
        }

        public Criteria andStatusGreaterThanOrEqualTo(Integer value) {
            addCriterion("status >=", value, "status");
            return (Criteria) this;
        }

        public Criteria andStatusLessThan(Integer value) {
            addCriterion("status <", value, "status");
            return (Criteria) this;
        }

        public Criteria andStatusLessThanOrEqualTo(Integer value) {
            addCriterion("status <=", value, "status");
            return (Criteria) this;
        }

        public Criteria andStatusIn(List<Integer> values) {
            addCriterion("status in", values, "status");
            return (Criteria) this;
        }

        public Criteria andStatusNotIn(List<Integer> values) {
            addCriterion("status not in", values, "status");
            return (Criteria) this;
        }

        public Criteria andStatusBetween(Integer value1, Integer value2) {
            addCriterion("status between", value1, value2, "status");
            return (Criteria) this;
        }

        public Criteria andStatusNotBetween(Integer value1, Integer value2) {
            addCriterion("status not between", value1, value2, "status");
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

        public Criteria andRemarksIsNull() {
            addCriterion("remarks is null");
            return (Criteria) this;
        }

        public Criteria andRemarksIsNotNull() {
            addCriterion("remarks is not null");
            return (Criteria) this;
        }

        public Criteria andRemarksEqualTo(String value) {
            addCriterion("remarks =", value, "remarks");
            return (Criteria) this;
        }

        public Criteria andRemarksNotEqualTo(String value) {
            addCriterion("remarks <>", value, "remarks");
            return (Criteria) this;
        }

        public Criteria andRemarksGreaterThan(String value) {
            addCriterion("remarks >", value, "remarks");
            return (Criteria) this;
        }

        public Criteria andRemarksGreaterThanOrEqualTo(String value) {
            addCriterion("remarks >=", value, "remarks");
            return (Criteria) this;
        }

        public Criteria andRemarksLessThan(String value) {
            addCriterion("remarks <", value, "remarks");
            return (Criteria) this;
        }

        public Criteria andRemarksLessThanOrEqualTo(String value) {
            addCriterion("remarks <=", value, "remarks");
            return (Criteria) this;
        }

        public Criteria andRemarksLike(String value) {
            addCriterion("remarks like", value, "remarks");
            return (Criteria) this;
        }

        public Criteria andRemarksNotLike(String value) {
            addCriterion("remarks not like", value, "remarks");
            return (Criteria) this;
        }

        public Criteria andRemarksIn(List<String> values) {
            addCriterion("remarks in", values, "remarks");
            return (Criteria) this;
        }

        public Criteria andRemarksNotIn(List<String> values) {
            addCriterion("remarks not in", values, "remarks");
            return (Criteria) this;
        }

        public Criteria andRemarksBetween(String value1, String value2) {
            addCriterion("remarks between", value1, value2, "remarks");
            return (Criteria) this;
        }

        public Criteria andRemarksNotBetween(String value1, String value2) {
            addCriterion("remarks not between", value1, value2, "remarks");
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

        public Criteria andCreateByEqualTo(Integer value) {
            addCriterion("create_by =", value, "createBy");
            return (Criteria) this;
        }

        public Criteria andCreateByNotEqualTo(Integer value) {
            addCriterion("create_by <>", value, "createBy");
            return (Criteria) this;
        }

        public Criteria andCreateByGreaterThan(Integer value) {
            addCriterion("create_by >", value, "createBy");
            return (Criteria) this;
        }

        public Criteria andCreateByGreaterThanOrEqualTo(Integer value) {
            addCriterion("create_by >=", value, "createBy");
            return (Criteria) this;
        }

        public Criteria andCreateByLessThan(Integer value) {
            addCriterion("create_by <", value, "createBy");
            return (Criteria) this;
        }

        public Criteria andCreateByLessThanOrEqualTo(Integer value) {
            addCriterion("create_by <=", value, "createBy");
            return (Criteria) this;
        }

        public Criteria andCreateByIn(List<Integer> values) {
            addCriterion("create_by in", values, "createBy");
            return (Criteria) this;
        }

        public Criteria andCreateByNotIn(List<Integer> values) {
            addCriterion("create_by not in", values, "createBy");
            return (Criteria) this;
        }

        public Criteria andCreateByBetween(Integer value1, Integer value2) {
            addCriterion("create_by between", value1, value2, "createBy");
            return (Criteria) this;
        }

        public Criteria andCreateByNotBetween(Integer value1, Integer value2) {
            addCriterion("create_by not between", value1, value2, "createBy");
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

        public Criteria andUpdateByIsNull() {
            addCriterion("update_by is null");
            return (Criteria) this;
        }

        public Criteria andUpdateByIsNotNull() {
            addCriterion("update_by is not null");
            return (Criteria) this;
        }

        public Criteria andUpdateByEqualTo(Integer value) {
            addCriterion("update_by =", value, "updateBy");
            return (Criteria) this;
        }

        public Criteria andUpdateByNotEqualTo(Integer value) {
            addCriterion("update_by <>", value, "updateBy");
            return (Criteria) this;
        }

        public Criteria andUpdateByGreaterThan(Integer value) {
            addCriterion("update_by >", value, "updateBy");
            return (Criteria) this;
        }

        public Criteria andUpdateByGreaterThanOrEqualTo(Integer value) {
            addCriterion("update_by >=", value, "updateBy");
            return (Criteria) this;
        }

        public Criteria andUpdateByLessThan(Integer value) {
            addCriterion("update_by <", value, "updateBy");
            return (Criteria) this;
        }

        public Criteria andUpdateByLessThanOrEqualTo(Integer value) {
            addCriterion("update_by <=", value, "updateBy");
            return (Criteria) this;
        }

        public Criteria andUpdateByIn(List<Integer> values) {
            addCriterion("update_by in", values, "updateBy");
            return (Criteria) this;
        }

        public Criteria andUpdateByNotIn(List<Integer> values) {
            addCriterion("update_by not in", values, "updateBy");
            return (Criteria) this;
        }

        public Criteria andUpdateByBetween(Integer value1, Integer value2) {
            addCriterion("update_by between", value1, value2, "updateBy");
            return (Criteria) this;
        }

        public Criteria andUpdateByNotBetween(Integer value1, Integer value2) {
            addCriterion("update_by not between", value1, value2, "updateBy");
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

        public Criteria andStudentAccountLikeInsensitive(String value) {
            addCriterion("upper(student_account) like", value.toUpperCase(), "studentAccount");
            return (Criteria) this;
        }

        public Criteria andPatriachAccountLikeInsensitive(String value) {
            addCriterion("upper(patriach_account) like", value.toUpperCase(), "patriachAccount");
            return (Criteria) this;
        }

        public Criteria andXsxmLikeInsensitive(String value) {
            addCriterion("upper(xsxm) like", value.toUpperCase(), "xsxm");
            return (Criteria) this;
        }

        public Criteria andXmpyLikeInsensitive(String value) {
            addCriterion("upper(xmpy) like", value.toUpperCase(), "xmpy");
            return (Criteria) this;
        }

        public Criteria andYwmLikeInsensitive(String value) {
            addCriterion("upper(ywm) like", value.toUpperCase(), "ywm");
            return (Criteria) this;
        }

        public Criteria andYsbjLikeInsensitive(String value) {
            addCriterion("upper(ysbj) like", value.toUpperCase(), "ysbj");
            return (Criteria) this;
        }

        public Criteria andXjhLikeInsensitive(String value) {
            addCriterion("upper(xjh) like", value.toUpperCase(), "xjh");
            return (Criteria) this;
        }

        public Criteria andXhLikeInsensitive(String value) {
            addCriterion("upper(xh) like", value.toUpperCase(), "xh");
            return (Criteria) this;
        }

        public Criteria andQgxjhLikeInsensitive(String value) {
            addCriterion("upper(qgxjh) like", value.toUpperCase(), "qgxjh");
            return (Criteria) this;
        }

        public Criteria andJyidLikeInsensitive(String value) {
            addCriterion("upper(jyid) like", value.toUpperCase(), "jyid");
            return (Criteria) this;
        }

        public Criteria andSydLikeInsensitive(String value) {
            addCriterion("upper(syd) like", value.toUpperCase(), "syd");
            return (Criteria) this;
        }

        public Criteria andYxzjlxLikeInsensitive(String value) {
            addCriterion("upper(yxzjlx) like", value.toUpperCase(), "yxzjlx");
            return (Criteria) this;
        }

        public Criteria andYxzjhLikeInsensitive(String value) {
            addCriterion("upper(yxzjh) like", value.toUpperCase(), "yxzjh");
            return (Criteria) this;
        }

        public Criteria andSfbjgbLikeInsensitive(String value) {
            addCriterion("upper(sfbjgb) like", value.toUpperCase(), "sfbjgb");
            return (Criteria) this;
        }

        public Criteria andSfjsLikeInsensitive(String value) {
            addCriterion("upper(sfjs) like", value.toUpperCase(), "sfjs");
            return (Criteria) this;
        }

        public Criteria andSfcjLikeInsensitive(String value) {
            addCriterion("upper(sfcj) like", value.toUpperCase(), "sfcj");
            return (Criteria) this;
        }

        public Criteria andSfsbtLikeInsensitive(String value) {
            addCriterion("upper(sfsbt) like", value.toUpperCase(), "sfsbt");
            return (Criteria) this;
        }

        public Criteria andSbtxhLikeInsensitive(String value) {
            addCriterion("upper(sbtxh) like", value.toUpperCase(), "sbtxh");
            return (Criteria) this;
        }

        public Criteria andXslbLikeInsensitive(String value) {
            addCriterion("upper(xslb) like", value.toUpperCase(), "xslb");
            return (Criteria) this;
        }

        public Criteria andGbLikeInsensitive(String value) {
            addCriterion("upper(gb) like", value.toUpperCase(), "gb");
            return (Criteria) this;
        }

        public Criteria andMzLikeInsensitive(String value) {
            addCriterion("upper(mz) like", value.toUpperCase(), "mz");
            return (Criteria) this;
        }

        public Criteria andJgLikeInsensitive(String value) {
            addCriterion("upper(jg) like", value.toUpperCase(), "jg");
            return (Criteria) this;
        }

        public Criteria andZzmmLikeInsensitive(String value) {
            addCriterion("upper(zzmm) like", value.toUpperCase(), "zzmm");
            return (Criteria) this;
        }

        public Criteria andJdfsLikeInsensitive(String value) {
            addCriterion("upper(jdfs) like", value.toUpperCase(), "jdfs");
            return (Criteria) this;
        }

        public Criteria andXzzLikeInsensitive(String value) {
            addCriterion("upper(xzz) like", value.toUpperCase(), "xzz");
            return (Criteria) this;
        }

        public Criteria andTxdzLikeInsensitive(String value) {
            addCriterion("upper(txdz) like", value.toUpperCase(), "txdz");
            return (Criteria) this;
        }

        public Criteria andHkxzLikeInsensitive(String value) {
            addCriterion("upper(hkxz) like", value.toUpperCase(), "hkxz");
            return (Criteria) this;
        }

        public Criteria andHkszdLikeInsensitive(String value) {
            addCriterion("upper(hkszd) like", value.toUpperCase(), "hkszd");
            return (Criteria) this;
        }

        public Criteria andHkszdxxdzLikeInsensitive(String value) {
            addCriterion("upper(hkszdxxdz) like", value.toUpperCase(), "hkszdxxdz");
            return (Criteria) this;
        }

        public Criteria andSfabshkxsddLikeInsensitive(String value) {
            addCriterion("upper(sfabshkxsdd) like", value.toUpperCase(), "sfabshkxsdd");
            return (Criteria) this;
        }

        public Criteria andSfbsxjLikeInsensitive(String value) {
            addCriterion("upper(sfbsxj) like", value.toUpperCase(), "sfbsxj");
            return (Criteria) this;
        }

        public Criteria andZslbLikeInsensitive(String value) {
            addCriterion("upper(zslb) like", value.toUpperCase(), "zslb");
            return (Criteria) this;
        }

        public Criteria andXszpLikeInsensitive(String value) {
            addCriterion("upper(xszp) like", value.toUpperCase(), "xszp");
            return (Criteria) this;
        }

        public Criteria andDyzhLikeInsensitive(String value) {
            addCriterion("upper(dyzh) like", value.toUpperCase(), "dyzh");
            return (Criteria) this;
        }

        public Criteria andJzzhLikeInsensitive(String value) {
            addCriterion("upper(jzzh) like", value.toUpperCase(), "jzzh");
            return (Criteria) this;
        }

        public Criteria andRxndLikeInsensitive(String value) {
            addCriterion("upper(rxnd) like", value.toUpperCase(), "rxnd");
            return (Criteria) this;
        }

        public Criteria andRemarksLikeInsensitive(String value) {
            addCriterion("upper(remarks) like", value.toUpperCase(), "remarks");
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