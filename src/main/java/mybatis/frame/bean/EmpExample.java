package mybatis.frame.bean;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class EmpExample {
    /**
     * emp
     */
    protected String orderByClause;

    /**
     * emp
     */
    protected boolean distinct;

    /**
     * emp
     */
    protected List<Criteria> oredCriteria;

    public EmpExample() {
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
     * emp 2020-07-03
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

        public Criteria andEidIsNull() {
            addCriterion("eid is null");
            return (Criteria) this;
        }

        public Criteria andEidIsNotNull() {
            addCriterion("eid is not null");
            return (Criteria) this;
        }

        public Criteria andEidEqualTo(Integer value) {
            addCriterion("eid =", value, "eid");
            return (Criteria) this;
        }

        public Criteria andEidNotEqualTo(Integer value) {
            addCriterion("eid <>", value, "eid");
            return (Criteria) this;
        }

        public Criteria andEidGreaterThan(Integer value) {
            addCriterion("eid >", value, "eid");
            return (Criteria) this;
        }

        public Criteria andEidGreaterThanOrEqualTo(Integer value) {
            addCriterion("eid >=", value, "eid");
            return (Criteria) this;
        }

        public Criteria andEidLessThan(Integer value) {
            addCriterion("eid <", value, "eid");
            return (Criteria) this;
        }

        public Criteria andEidLessThanOrEqualTo(Integer value) {
            addCriterion("eid <=", value, "eid");
            return (Criteria) this;
        }

        public Criteria andEidIn(List<Integer> values) {
            addCriterion("eid in", values, "eid");
            return (Criteria) this;
        }

        public Criteria andEidNotIn(List<Integer> values) {
            addCriterion("eid not in", values, "eid");
            return (Criteria) this;
        }

        public Criteria andEidBetween(Integer value1, Integer value2) {
            addCriterion("eid between", value1, value2, "eid");
            return (Criteria) this;
        }

        public Criteria andEidNotBetween(Integer value1, Integer value2) {
            addCriterion("eid not between", value1, value2, "eid");
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

        public Criteria andMoneyIsNull() {
            addCriterion("money is null");
            return (Criteria) this;
        }

        public Criteria andMoneyIsNotNull() {
            addCriterion("money is not null");
            return (Criteria) this;
        }

        public Criteria andMoneyEqualTo(BigDecimal value) {
            addCriterion("money =", value, "money");
            return (Criteria) this;
        }

        public Criteria andMoneyNotEqualTo(BigDecimal value) {
            addCriterion("money <>", value, "money");
            return (Criteria) this;
        }

        public Criteria andMoneyGreaterThan(BigDecimal value) {
            addCriterion("money >", value, "money");
            return (Criteria) this;
        }

        public Criteria andMoneyGreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("money >=", value, "money");
            return (Criteria) this;
        }

        public Criteria andMoneyLessThan(BigDecimal value) {
            addCriterion("money <", value, "money");
            return (Criteria) this;
        }

        public Criteria andMoneyLessThanOrEqualTo(BigDecimal value) {
            addCriterion("money <=", value, "money");
            return (Criteria) this;
        }

        public Criteria andMoneyIn(List<BigDecimal> values) {
            addCriterion("money in", values, "money");
            return (Criteria) this;
        }

        public Criteria andMoneyNotIn(List<BigDecimal> values) {
            addCriterion("money not in", values, "money");
            return (Criteria) this;
        }

        public Criteria andMoneyBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("money between", value1, value2, "money");
            return (Criteria) this;
        }

        public Criteria andMoneyNotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("money not between", value1, value2, "money");
            return (Criteria) this;
        }

        public Criteria andEffortIsNull() {
            addCriterion("effort is null");
            return (Criteria) this;
        }

        public Criteria andEffortIsNotNull() {
            addCriterion("effort is not null");
            return (Criteria) this;
        }

        public Criteria andEffortEqualTo(String value) {
            addCriterion("effort =", value, "effort");
            return (Criteria) this;
        }

        public Criteria andEffortNotEqualTo(String value) {
            addCriterion("effort <>", value, "effort");
            return (Criteria) this;
        }

        public Criteria andEffortGreaterThan(String value) {
            addCriterion("effort >", value, "effort");
            return (Criteria) this;
        }

        public Criteria andEffortGreaterThanOrEqualTo(String value) {
            addCriterion("effort >=", value, "effort");
            return (Criteria) this;
        }

        public Criteria andEffortLessThan(String value) {
            addCriterion("effort <", value, "effort");
            return (Criteria) this;
        }

        public Criteria andEffortLessThanOrEqualTo(String value) {
            addCriterion("effort <=", value, "effort");
            return (Criteria) this;
        }

        public Criteria andEffortLike(String value) {
            addCriterion("effort like", value, "effort");
            return (Criteria) this;
        }

        public Criteria andEffortNotLike(String value) {
            addCriterion("effort not like", value, "effort");
            return (Criteria) this;
        }

        public Criteria andEffortIn(List<String> values) {
            addCriterion("effort in", values, "effort");
            return (Criteria) this;
        }

        public Criteria andEffortNotIn(List<String> values) {
            addCriterion("effort not in", values, "effort");
            return (Criteria) this;
        }

        public Criteria andEffortBetween(String value1, String value2) {
            addCriterion("effort between", value1, value2, "effort");
            return (Criteria) this;
        }

        public Criteria andEffortNotBetween(String value1, String value2) {
            addCriterion("effort not between", value1, value2, "effort");
            return (Criteria) this;
        }

        public Criteria andSectIsNull() {
            addCriterion("sect is null");
            return (Criteria) this;
        }

        public Criteria andSectIsNotNull() {
            addCriterion("sect is not null");
            return (Criteria) this;
        }

        public Criteria andSectEqualTo(String value) {
            addCriterion("sect =", value, "sect");
            return (Criteria) this;
        }

        public Criteria andSectNotEqualTo(String value) {
            addCriterion("sect <>", value, "sect");
            return (Criteria) this;
        }

        public Criteria andSectGreaterThan(String value) {
            addCriterion("sect >", value, "sect");
            return (Criteria) this;
        }

        public Criteria andSectGreaterThanOrEqualTo(String value) {
            addCriterion("sect >=", value, "sect");
            return (Criteria) this;
        }

        public Criteria andSectLessThan(String value) {
            addCriterion("sect <", value, "sect");
            return (Criteria) this;
        }

        public Criteria andSectLessThanOrEqualTo(String value) {
            addCriterion("sect <=", value, "sect");
            return (Criteria) this;
        }

        public Criteria andSectLike(String value) {
            addCriterion("sect like", value, "sect");
            return (Criteria) this;
        }

        public Criteria andSectNotLike(String value) {
            addCriterion("sect not like", value, "sect");
            return (Criteria) this;
        }

        public Criteria andSectIn(List<String> values) {
            addCriterion("sect in", values, "sect");
            return (Criteria) this;
        }

        public Criteria andSectNotIn(List<String> values) {
            addCriterion("sect not in", values, "sect");
            return (Criteria) this;
        }

        public Criteria andSectBetween(String value1, String value2) {
            addCriterion("sect between", value1, value2, "sect");
            return (Criteria) this;
        }

        public Criteria andSectNotBetween(String value1, String value2) {
            addCriterion("sect not between", value1, value2, "sect");
            return (Criteria) this;
        }

        public Criteria andAgeIsNull() {
            addCriterion("age is null");
            return (Criteria) this;
        }

        public Criteria andAgeIsNotNull() {
            addCriterion("age is not null");
            return (Criteria) this;
        }

        public Criteria andAgeEqualTo(Integer value) {
            addCriterion("age =", value, "age");
            return (Criteria) this;
        }

        public Criteria andAgeNotEqualTo(Integer value) {
            addCriterion("age <>", value, "age");
            return (Criteria) this;
        }

        public Criteria andAgeGreaterThan(Integer value) {
            addCriterion("age >", value, "age");
            return (Criteria) this;
        }

        public Criteria andAgeGreaterThanOrEqualTo(Integer value) {
            addCriterion("age >=", value, "age");
            return (Criteria) this;
        }

        public Criteria andAgeLessThan(Integer value) {
            addCriterion("age <", value, "age");
            return (Criteria) this;
        }

        public Criteria andAgeLessThanOrEqualTo(Integer value) {
            addCriterion("age <=", value, "age");
            return (Criteria) this;
        }

        public Criteria andAgeIn(List<Integer> values) {
            addCriterion("age in", values, "age");
            return (Criteria) this;
        }

        public Criteria andAgeNotIn(List<Integer> values) {
            addCriterion("age not in", values, "age");
            return (Criteria) this;
        }

        public Criteria andAgeBetween(Integer value1, Integer value2) {
            addCriterion("age between", value1, value2, "age");
            return (Criteria) this;
        }

        public Criteria andAgeNotBetween(Integer value1, Integer value2) {
            addCriterion("age not between", value1, value2, "age");
            return (Criteria) this;
        }

        public Criteria andDate1IsNull() {
            addCriterion("date1 is null");
            return (Criteria) this;
        }

        public Criteria andDate1IsNotNull() {
            addCriterion("date1 is not null");
            return (Criteria) this;
        }

        public Criteria andDate1EqualTo(Date value) {
            addCriterion("date1 =", value, "date1");
            return (Criteria) this;
        }

        public Criteria andDate1NotEqualTo(Date value) {
            addCriterion("date1 <>", value, "date1");
            return (Criteria) this;
        }

        public Criteria andDate1GreaterThan(Date value) {
            addCriterion("date1 >", value, "date1");
            return (Criteria) this;
        }

        public Criteria andDate1GreaterThanOrEqualTo(Date value) {
            addCriterion("date1 >=", value, "date1");
            return (Criteria) this;
        }

        public Criteria andDate1LessThan(Date value) {
            addCriterion("date1 <", value, "date1");
            return (Criteria) this;
        }

        public Criteria andDate1LessThanOrEqualTo(Date value) {
            addCriterion("date1 <=", value, "date1");
            return (Criteria) this;
        }

        public Criteria andDate1In(List<Date> values) {
            addCriterion("date1 in", values, "date1");
            return (Criteria) this;
        }

        public Criteria andDate1NotIn(List<Date> values) {
            addCriterion("date1 not in", values, "date1");
            return (Criteria) this;
        }

        public Criteria andDate1Between(Date value1, Date value2) {
            addCriterion("date1 between", value1, value2, "date1");
            return (Criteria) this;
        }

        public Criteria andDate1NotBetween(Date value1, Date value2) {
            addCriterion("date1 not between", value1, value2, "date1");
            return (Criteria) this;
        }

        public Criteria andDate2IsNull() {
            addCriterion("date2 is null");
            return (Criteria) this;
        }

        public Criteria andDate2IsNotNull() {
            addCriterion("date2 is not null");
            return (Criteria) this;
        }

        public Criteria andDate2EqualTo(Date value) {
            addCriterion("date2 =", value, "date2");
            return (Criteria) this;
        }

        public Criteria andDate2NotEqualTo(Date value) {
            addCriterion("date2 <>", value, "date2");
            return (Criteria) this;
        }

        public Criteria andDate2GreaterThan(Date value) {
            addCriterion("date2 >", value, "date2");
            return (Criteria) this;
        }

        public Criteria andDate2GreaterThanOrEqualTo(Date value) {
            addCriterion("date2 >=", value, "date2");
            return (Criteria) this;
        }

        public Criteria andDate2LessThan(Date value) {
            addCriterion("date2 <", value, "date2");
            return (Criteria) this;
        }

        public Criteria andDate2LessThanOrEqualTo(Date value) {
            addCriterion("date2 <=", value, "date2");
            return (Criteria) this;
        }

        public Criteria andDate2In(List<Date> values) {
            addCriterion("date2 in", values, "date2");
            return (Criteria) this;
        }

        public Criteria andDate2NotIn(List<Date> values) {
            addCriterion("date2 not in", values, "date2");
            return (Criteria) this;
        }

        public Criteria andDate2Between(Date value1, Date value2) {
            addCriterion("date2 between", value1, value2, "date2");
            return (Criteria) this;
        }

        public Criteria andDate2NotBetween(Date value1, Date value2) {
            addCriterion("date2 not between", value1, value2, "date2");
            return (Criteria) this;
        }
    }

    /**
     * emp
     */
    public static class Criteria extends GeneratedCriteria {

        protected Criteria() {
            super();
        }
    }

    /**
     * emp 2020-07-03
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