/**
 *  introspectedTable.getFullyQualifiedTable().getComment()
 * PpLineWeldEntrustQueryHelper.java
 * Copyright(C) 2015-2015 xxxxxx公司
 * All rights reserved.
 * -----------------------------------------------
 * 2017-07-23 Created
 */
package java;

import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

public class PpLineWeldEntrustQueryHelper {
    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database table pp_line_weld_entrust
     *
     * @mbggenerated Sun Jul 23 12:39:36 CST 2017
     */
    protected String orderByClause;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database table pp_line_weld_entrust
     *
     * @mbggenerated Sun Jul 23 12:39:36 CST 2017
     */
    protected boolean distinct;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database table pp_line_weld_entrust
     *
     * @mbggenerated Sun Jul 23 12:39:36 CST 2017
     */
    protected List<Criteria> oredCriteria;

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table pp_line_weld_entrust
     *
     * @mbggenerated Sun Jul 23 12:39:36 CST 2017
     */
    public PpLineWeldEntrustQueryHelper() {
        oredCriteria = new ArrayList<Criteria>();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table pp_line_weld_entrust
     *
     * @mbggenerated Sun Jul 23 12:39:36 CST 2017
     */
    public void setOrderByClause(String orderByClause) {
        this.orderByClause = orderByClause;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table pp_line_weld_entrust
     *
     * @mbggenerated Sun Jul 23 12:39:36 CST 2017
     */
    public String getOrderByClause() {
        return orderByClause;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table pp_line_weld_entrust
     *
     * @mbggenerated Sun Jul 23 12:39:36 CST 2017
     */
    public void setDistinct(boolean distinct) {
        this.distinct = distinct;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table pp_line_weld_entrust
     *
     * @mbggenerated Sun Jul 23 12:39:36 CST 2017
     */
    public boolean isDistinct() {
        return distinct;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table pp_line_weld_entrust
     *
     * @mbggenerated Sun Jul 23 12:39:36 CST 2017
     */
    public List<Criteria> getOredCriteria() {
        return oredCriteria;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table pp_line_weld_entrust
     *
     * @mbggenerated Sun Jul 23 12:39:36 CST 2017
     */
    public void or(Criteria criteria) {
        oredCriteria.add(criteria);
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table pp_line_weld_entrust
     *
     * @mbggenerated Sun Jul 23 12:39:36 CST 2017
     */
    public Criteria or() {
        Criteria criteria = createCriteriaInternal();
        oredCriteria.add(criteria);
        return criteria;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table pp_line_weld_entrust
     *
     * @mbggenerated Sun Jul 23 12:39:36 CST 2017
     */
    public Criteria createCriteria() {
        Criteria criteria = createCriteriaInternal();
        if (oredCriteria.size() == 0) {
            oredCriteria.add(criteria);
        }
        return criteria;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table pp_line_weld_entrust
     *
     * @mbggenerated Sun Jul 23 12:39:36 CST 2017
     */
    protected Criteria createCriteriaInternal() {
        Criteria criteria = new Criteria();
        return criteria;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table pp_line_weld_entrust
     *
     * @mbggenerated Sun Jul 23 12:39:36 CST 2017
     */
    public void clear() {
        oredCriteria.clear();
        orderByClause = null;
        distinct = false;
    }

    /**
     * 管线-焊接委托记录表
     * 
     * @author 菠萝大象
     * @version 1.0 2017-07-23
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

        public Criteria andIdIsNull() {
            addCriterion("ID is null");
            return (Criteria) this;
        }

        public Criteria andIdIsNotNull() {
            addCriterion("ID is not null");
            return (Criteria) this;
        }

        public Criteria andIdEqualTo(Long value) {
            addCriterion("ID =", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdNotEqualTo(Long value) {
            addCriterion("ID <>", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdGreaterThan(Long value) {
            addCriterion("ID >", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdGreaterThanOrEqualTo(Long value) {
            addCriterion("ID >=", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdLessThan(Long value) {
            addCriterion("ID <", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdLessThanOrEqualTo(Long value) {
            addCriterion("ID <=", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdIn(List<Long> values) {
            addCriterion("ID in", values, "id");
            return (Criteria) this;
        }

        public Criteria andIdNotIn(List<Long> values) {
            addCriterion("ID not in", values, "id");
            return (Criteria) this;
        }

        public Criteria andIdBetween(Long value1, Long value2) {
            addCriterion("ID between", value1, value2, "id");
            return (Criteria) this;
        }

        public Criteria andIdNotBetween(Long value1, Long value2) {
            addCriterion("ID not between", value1, value2, "id");
            return (Criteria) this;
        }

        public Criteria andProjIdIsNull() {
            addCriterion("PROJ_ID is null");
            return (Criteria) this;
        }

        public Criteria andProjIdIsNotNull() {
            addCriterion("PROJ_ID is not null");
            return (Criteria) this;
        }

        public Criteria andProjIdEqualTo(Long value) {
            addCriterion("PROJ_ID =", value, "projId");
            return (Criteria) this;
        }

        public Criteria andProjIdNotEqualTo(Long value) {
            addCriterion("PROJ_ID <>", value, "projId");
            return (Criteria) this;
        }

        public Criteria andProjIdGreaterThan(Long value) {
            addCriterion("PROJ_ID >", value, "projId");
            return (Criteria) this;
        }

        public Criteria andProjIdGreaterThanOrEqualTo(Long value) {
            addCriterion("PROJ_ID >=", value, "projId");
            return (Criteria) this;
        }

        public Criteria andProjIdLessThan(Long value) {
            addCriterion("PROJ_ID <", value, "projId");
            return (Criteria) this;
        }

        public Criteria andProjIdLessThanOrEqualTo(Long value) {
            addCriterion("PROJ_ID <=", value, "projId");
            return (Criteria) this;
        }

        public Criteria andProjIdIn(List<Long> values) {
            addCriterion("PROJ_ID in", values, "projId");
            return (Criteria) this;
        }

        public Criteria andProjIdNotIn(List<Long> values) {
            addCriterion("PROJ_ID not in", values, "projId");
            return (Criteria) this;
        }

        public Criteria andProjIdBetween(Long value1, Long value2) {
            addCriterion("PROJ_ID between", value1, value2, "projId");
            return (Criteria) this;
        }

        public Criteria andProjIdNotBetween(Long value1, Long value2) {
            addCriterion("PROJ_ID not between", value1, value2, "projId");
            return (Criteria) this;
        }

        public Criteria andPipelineIdIsNull() {
            addCriterion("PIPELINE_ID is null");
            return (Criteria) this;
        }

        public Criteria andPipelineIdIsNotNull() {
            addCriterion("PIPELINE_ID is not null");
            return (Criteria) this;
        }

        public Criteria andPipelineIdEqualTo(Long value) {
            addCriterion("PIPELINE_ID =", value, "pipelineId");
            return (Criteria) this;
        }

        public Criteria andPipelineIdNotEqualTo(Long value) {
            addCriterion("PIPELINE_ID <>", value, "pipelineId");
            return (Criteria) this;
        }

        public Criteria andPipelineIdGreaterThan(Long value) {
            addCriterion("PIPELINE_ID >", value, "pipelineId");
            return (Criteria) this;
        }

        public Criteria andPipelineIdGreaterThanOrEqualTo(Long value) {
            addCriterion("PIPELINE_ID >=", value, "pipelineId");
            return (Criteria) this;
        }

        public Criteria andPipelineIdLessThan(Long value) {
            addCriterion("PIPELINE_ID <", value, "pipelineId");
            return (Criteria) this;
        }

        public Criteria andPipelineIdLessThanOrEqualTo(Long value) {
            addCriterion("PIPELINE_ID <=", value, "pipelineId");
            return (Criteria) this;
        }

        public Criteria andPipelineIdIn(List<Long> values) {
            addCriterion("PIPELINE_ID in", values, "pipelineId");
            return (Criteria) this;
        }

        public Criteria andPipelineIdNotIn(List<Long> values) {
            addCriterion("PIPELINE_ID not in", values, "pipelineId");
            return (Criteria) this;
        }

        public Criteria andPipelineIdBetween(Long value1, Long value2) {
            addCriterion("PIPELINE_ID between", value1, value2, "pipelineId");
            return (Criteria) this;
        }

        public Criteria andPipelineIdNotBetween(Long value1, Long value2) {
            addCriterion("PIPELINE_ID not between", value1, value2, "pipelineId");
            return (Criteria) this;
        }

        public Criteria andWeldIdIsNull() {
            addCriterion("WELD_ID is null");
            return (Criteria) this;
        }

        public Criteria andWeldIdIsNotNull() {
            addCriterion("WELD_ID is not null");
            return (Criteria) this;
        }

        public Criteria andWeldIdEqualTo(Long value) {
            addCriterion("WELD_ID =", value, "weldId");
            return (Criteria) this;
        }

        public Criteria andWeldIdNotEqualTo(Long value) {
            addCriterion("WELD_ID <>", value, "weldId");
            return (Criteria) this;
        }

        public Criteria andWeldIdGreaterThan(Long value) {
            addCriterion("WELD_ID >", value, "weldId");
            return (Criteria) this;
        }

        public Criteria andWeldIdGreaterThanOrEqualTo(Long value) {
            addCriterion("WELD_ID >=", value, "weldId");
            return (Criteria) this;
        }

        public Criteria andWeldIdLessThan(Long value) {
            addCriterion("WELD_ID <", value, "weldId");
            return (Criteria) this;
        }

        public Criteria andWeldIdLessThanOrEqualTo(Long value) {
            addCriterion("WELD_ID <=", value, "weldId");
            return (Criteria) this;
        }

        public Criteria andWeldIdIn(List<Long> values) {
            addCriterion("WELD_ID in", values, "weldId");
            return (Criteria) this;
        }

        public Criteria andWeldIdNotIn(List<Long> values) {
            addCriterion("WELD_ID not in", values, "weldId");
            return (Criteria) this;
        }

        public Criteria andWeldIdBetween(Long value1, Long value2) {
            addCriterion("WELD_ID between", value1, value2, "weldId");
            return (Criteria) this;
        }

        public Criteria andWeldIdNotBetween(Long value1, Long value2) {
            addCriterion("WELD_ID not between", value1, value2, "weldId");
            return (Criteria) this;
        }

        public Criteria andFlowNumIsNull() {
            addCriterion("FLOW_NUM is null");
            return (Criteria) this;
        }

        public Criteria andFlowNumIsNotNull() {
            addCriterion("FLOW_NUM is not null");
            return (Criteria) this;
        }

        public Criteria andFlowNumEqualTo(String value) {
            addCriterion("FLOW_NUM =", value, "flowNum");
            return (Criteria) this;
        }

        public Criteria andFlowNumNotEqualTo(String value) {
            addCriterion("FLOW_NUM <>", value, "flowNum");
            return (Criteria) this;
        }

        public Criteria andFlowNumGreaterThan(String value) {
            addCriterion("FLOW_NUM >", value, "flowNum");
            return (Criteria) this;
        }

        public Criteria andFlowNumGreaterThanOrEqualTo(String value) {
            addCriterion("FLOW_NUM >=", value, "flowNum");
            return (Criteria) this;
        }

        public Criteria andFlowNumLessThan(String value) {
            addCriterion("FLOW_NUM <", value, "flowNum");
            return (Criteria) this;
        }

        public Criteria andFlowNumLessThanOrEqualTo(String value) {
            addCriterion("FLOW_NUM <=", value, "flowNum");
            return (Criteria) this;
        }

        public Criteria andFlowNumLike(String value) {
            addCriterion("FLOW_NUM like", value, "flowNum");
            return (Criteria) this;
        }

        public Criteria andFlowNumNotLike(String value) {
            addCriterion("FLOW_NUM not like", value, "flowNum");
            return (Criteria) this;
        }

        public Criteria andFlowNumIn(List<String> values) {
            addCriterion("FLOW_NUM in", values, "flowNum");
            return (Criteria) this;
        }

        public Criteria andFlowNumNotIn(List<String> values) {
            addCriterion("FLOW_NUM not in", values, "flowNum");
            return (Criteria) this;
        }

        public Criteria andFlowNumBetween(String value1, String value2) {
            addCriterion("FLOW_NUM between", value1, value2, "flowNum");
            return (Criteria) this;
        }

        public Criteria andFlowNumNotBetween(String value1, String value2) {
            addCriterion("FLOW_NUM not between", value1, value2, "flowNum");
            return (Criteria) this;
        }

        public Criteria andCodeIsNull() {
            addCriterion("CODE is null");
            return (Criteria) this;
        }

        public Criteria andCodeIsNotNull() {
            addCriterion("CODE is not null");
            return (Criteria) this;
        }

        public Criteria andCodeEqualTo(String value) {
            addCriterion("CODE =", value, "code");
            return (Criteria) this;
        }

        public Criteria andCodeNotEqualTo(String value) {
            addCriterion("CODE <>", value, "code");
            return (Criteria) this;
        }

        public Criteria andCodeGreaterThan(String value) {
            addCriterion("CODE >", value, "code");
            return (Criteria) this;
        }

        public Criteria andCodeGreaterThanOrEqualTo(String value) {
            addCriterion("CODE >=", value, "code");
            return (Criteria) this;
        }

        public Criteria andCodeLessThan(String value) {
            addCriterion("CODE <", value, "code");
            return (Criteria) this;
        }

        public Criteria andCodeLessThanOrEqualTo(String value) {
            addCriterion("CODE <=", value, "code");
            return (Criteria) this;
        }

        public Criteria andCodeLike(String value) {
            addCriterion("CODE like", value, "code");
            return (Criteria) this;
        }

        public Criteria andCodeNotLike(String value) {
            addCriterion("CODE not like", value, "code");
            return (Criteria) this;
        }

        public Criteria andCodeIn(List<String> values) {
            addCriterion("CODE in", values, "code");
            return (Criteria) this;
        }

        public Criteria andCodeNotIn(List<String> values) {
            addCriterion("CODE not in", values, "code");
            return (Criteria) this;
        }

        public Criteria andCodeBetween(String value1, String value2) {
            addCriterion("CODE between", value1, value2, "code");
            return (Criteria) this;
        }

        public Criteria andCodeNotBetween(String value1, String value2) {
            addCriterion("CODE not between", value1, value2, "code");
            return (Criteria) this;
        }

        public Criteria andExpandCountIsNull() {
            addCriterion("EXPAND_COUNT is null");
            return (Criteria) this;
        }

        public Criteria andExpandCountIsNotNull() {
            addCriterion("EXPAND_COUNT is not null");
            return (Criteria) this;
        }

        public Criteria andExpandCountEqualTo(Integer value) {
            addCriterion("EXPAND_COUNT =", value, "expandCount");
            return (Criteria) this;
        }

        public Criteria andExpandCountNotEqualTo(Integer value) {
            addCriterion("EXPAND_COUNT <>", value, "expandCount");
            return (Criteria) this;
        }

        public Criteria andExpandCountGreaterThan(Integer value) {
            addCriterion("EXPAND_COUNT >", value, "expandCount");
            return (Criteria) this;
        }

        public Criteria andExpandCountGreaterThanOrEqualTo(Integer value) {
            addCriterion("EXPAND_COUNT >=", value, "expandCount");
            return (Criteria) this;
        }

        public Criteria andExpandCountLessThan(Integer value) {
            addCriterion("EXPAND_COUNT <", value, "expandCount");
            return (Criteria) this;
        }

        public Criteria andExpandCountLessThanOrEqualTo(Integer value) {
            addCriterion("EXPAND_COUNT <=", value, "expandCount");
            return (Criteria) this;
        }

        public Criteria andExpandCountIn(List<Integer> values) {
            addCriterion("EXPAND_COUNT in", values, "expandCount");
            return (Criteria) this;
        }

        public Criteria andExpandCountNotIn(List<Integer> values) {
            addCriterion("EXPAND_COUNT not in", values, "expandCount");
            return (Criteria) this;
        }

        public Criteria andExpandCountBetween(Integer value1, Integer value2) {
            addCriterion("EXPAND_COUNT between", value1, value2, "expandCount");
            return (Criteria) this;
        }

        public Criteria andExpandCountNotBetween(Integer value1, Integer value2) {
            addCriterion("EXPAND_COUNT not between", value1, value2, "expandCount");
            return (Criteria) this;
        }

        public Criteria andRepareCountIsNull() {
            addCriterion("REPARE_COUNT is null");
            return (Criteria) this;
        }

        public Criteria andRepareCountIsNotNull() {
            addCriterion("REPARE_COUNT is not null");
            return (Criteria) this;
        }

        public Criteria andRepareCountEqualTo(Integer value) {
            addCriterion("REPARE_COUNT =", value, "repareCount");
            return (Criteria) this;
        }

        public Criteria andRepareCountNotEqualTo(Integer value) {
            addCriterion("REPARE_COUNT <>", value, "repareCount");
            return (Criteria) this;
        }

        public Criteria andRepareCountGreaterThan(Integer value) {
            addCriterion("REPARE_COUNT >", value, "repareCount");
            return (Criteria) this;
        }

        public Criteria andRepareCountGreaterThanOrEqualTo(Integer value) {
            addCriterion("REPARE_COUNT >=", value, "repareCount");
            return (Criteria) this;
        }

        public Criteria andRepareCountLessThan(Integer value) {
            addCriterion("REPARE_COUNT <", value, "repareCount");
            return (Criteria) this;
        }

        public Criteria andRepareCountLessThanOrEqualTo(Integer value) {
            addCriterion("REPARE_COUNT <=", value, "repareCount");
            return (Criteria) this;
        }

        public Criteria andRepareCountIn(List<Integer> values) {
            addCriterion("REPARE_COUNT in", values, "repareCount");
            return (Criteria) this;
        }

        public Criteria andRepareCountNotIn(List<Integer> values) {
            addCriterion("REPARE_COUNT not in", values, "repareCount");
            return (Criteria) this;
        }

        public Criteria andRepareCountBetween(Integer value1, Integer value2) {
            addCriterion("REPARE_COUNT between", value1, value2, "repareCount");
            return (Criteria) this;
        }

        public Criteria andRepareCountNotBetween(Integer value1, Integer value2) {
            addCriterion("REPARE_COUNT not between", value1, value2, "repareCount");
            return (Criteria) this;
        }

        public Criteria andEntrustTypeIsNull() {
            addCriterion("ENTRUST_TYPE is null");
            return (Criteria) this;
        }

        public Criteria andEntrustTypeIsNotNull() {
            addCriterion("ENTRUST_TYPE is not null");
            return (Criteria) this;
        }

        public Criteria andEntrustTypeEqualTo(String value) {
            addCriterion("ENTRUST_TYPE =", value, "entrustType");
            return (Criteria) this;
        }

        public Criteria andEntrustTypeNotEqualTo(String value) {
            addCriterion("ENTRUST_TYPE <>", value, "entrustType");
            return (Criteria) this;
        }

        public Criteria andEntrustTypeGreaterThan(String value) {
            addCriterion("ENTRUST_TYPE >", value, "entrustType");
            return (Criteria) this;
        }

        public Criteria andEntrustTypeGreaterThanOrEqualTo(String value) {
            addCriterion("ENTRUST_TYPE >=", value, "entrustType");
            return (Criteria) this;
        }

        public Criteria andEntrustTypeLessThan(String value) {
            addCriterion("ENTRUST_TYPE <", value, "entrustType");
            return (Criteria) this;
        }

        public Criteria andEntrustTypeLessThanOrEqualTo(String value) {
            addCriterion("ENTRUST_TYPE <=", value, "entrustType");
            return (Criteria) this;
        }

        public Criteria andEntrustTypeLike(String value) {
            addCriterion("ENTRUST_TYPE like", value, "entrustType");
            return (Criteria) this;
        }

        public Criteria andEntrustTypeNotLike(String value) {
            addCriterion("ENTRUST_TYPE not like", value, "entrustType");
            return (Criteria) this;
        }

        public Criteria andEntrustTypeIn(List<String> values) {
            addCriterion("ENTRUST_TYPE in", values, "entrustType");
            return (Criteria) this;
        }

        public Criteria andEntrustTypeNotIn(List<String> values) {
            addCriterion("ENTRUST_TYPE not in", values, "entrustType");
            return (Criteria) this;
        }

        public Criteria andEntrustTypeBetween(String value1, String value2) {
            addCriterion("ENTRUST_TYPE between", value1, value2, "entrustType");
            return (Criteria) this;
        }

        public Criteria andEntrustTypeNotBetween(String value1, String value2) {
            addCriterion("ENTRUST_TYPE not between", value1, value2, "entrustType");
            return (Criteria) this;
        }

        public Criteria andEntrustDateIsNull() {
            addCriterion("ENTRUST_DATE is null");
            return (Criteria) this;
        }

        public Criteria andEntrustDateIsNotNull() {
            addCriterion("ENTRUST_DATE is not null");
            return (Criteria) this;
        }

        public Criteria andEntrustDateEqualTo(Date value) {
            addCriterionForJDBCDate("ENTRUST_DATE =", value, "entrustDate");
            return (Criteria) this;
        }

        public Criteria andEntrustDateNotEqualTo(Date value) {
            addCriterionForJDBCDate("ENTRUST_DATE <>", value, "entrustDate");
            return (Criteria) this;
        }

        public Criteria andEntrustDateGreaterThan(Date value) {
            addCriterionForJDBCDate("ENTRUST_DATE >", value, "entrustDate");
            return (Criteria) this;
        }

        public Criteria andEntrustDateGreaterThanOrEqualTo(Date value) {
            addCriterionForJDBCDate("ENTRUST_DATE >=", value, "entrustDate");
            return (Criteria) this;
        }

        public Criteria andEntrustDateLessThan(Date value) {
            addCriterionForJDBCDate("ENTRUST_DATE <", value, "entrustDate");
            return (Criteria) this;
        }

        public Criteria andEntrustDateLessThanOrEqualTo(Date value) {
            addCriterionForJDBCDate("ENTRUST_DATE <=", value, "entrustDate");
            return (Criteria) this;
        }

        public Criteria andEntrustDateIn(List<Date> values) {
            addCriterionForJDBCDate("ENTRUST_DATE in", values, "entrustDate");
            return (Criteria) this;
        }

        public Criteria andEntrustDateNotIn(List<Date> values) {
            addCriterionForJDBCDate("ENTRUST_DATE not in", values, "entrustDate");
            return (Criteria) this;
        }

        public Criteria andEntrustDateBetween(Date value1, Date value2) {
            addCriterionForJDBCDate("ENTRUST_DATE between", value1, value2, "entrustDate");
            return (Criteria) this;
        }

        public Criteria andEntrustDateNotBetween(Date value1, Date value2) {
            addCriterionForJDBCDate("ENTRUST_DATE not between", value1, value2, "entrustDate");
            return (Criteria) this;
        }

        public Criteria andRemarkIsNull() {
            addCriterion("REMARK is null");
            return (Criteria) this;
        }

        public Criteria andRemarkIsNotNull() {
            addCriterion("REMARK is not null");
            return (Criteria) this;
        }

        public Criteria andRemarkEqualTo(String value) {
            addCriterion("REMARK =", value, "remark");
            return (Criteria) this;
        }

        public Criteria andRemarkNotEqualTo(String value) {
            addCriterion("REMARK <>", value, "remark");
            return (Criteria) this;
        }

        public Criteria andRemarkGreaterThan(String value) {
            addCriterion("REMARK >", value, "remark");
            return (Criteria) this;
        }

        public Criteria andRemarkGreaterThanOrEqualTo(String value) {
            addCriterion("REMARK >=", value, "remark");
            return (Criteria) this;
        }

        public Criteria andRemarkLessThan(String value) {
            addCriterion("REMARK <", value, "remark");
            return (Criteria) this;
        }

        public Criteria andRemarkLessThanOrEqualTo(String value) {
            addCriterion("REMARK <=", value, "remark");
            return (Criteria) this;
        }

        public Criteria andRemarkLike(String value) {
            addCriterion("REMARK like", value, "remark");
            return (Criteria) this;
        }

        public Criteria andRemarkNotLike(String value) {
            addCriterion("REMARK not like", value, "remark");
            return (Criteria) this;
        }

        public Criteria andRemarkIn(List<String> values) {
            addCriterion("REMARK in", values, "remark");
            return (Criteria) this;
        }

        public Criteria andRemarkNotIn(List<String> values) {
            addCriterion("REMARK not in", values, "remark");
            return (Criteria) this;
        }

        public Criteria andRemarkBetween(String value1, String value2) {
            addCriterion("REMARK between", value1, value2, "remark");
            return (Criteria) this;
        }

        public Criteria andRemarkNotBetween(String value1, String value2) {
            addCriterion("REMARK not between", value1, value2, "remark");
            return (Criteria) this;
        }

        public Criteria andCreateTimeIsNull() {
            addCriterion("CREATE_TIME is null");
            return (Criteria) this;
        }

        public Criteria andCreateTimeIsNotNull() {
            addCriterion("CREATE_TIME is not null");
            return (Criteria) this;
        }

        public Criteria andCreateTimeEqualTo(Date value) {
            addCriterion("CREATE_TIME =", value, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeNotEqualTo(Date value) {
            addCriterion("CREATE_TIME <>", value, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeGreaterThan(Date value) {
            addCriterion("CREATE_TIME >", value, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeGreaterThanOrEqualTo(Date value) {
            addCriterion("CREATE_TIME >=", value, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeLessThan(Date value) {
            addCriterion("CREATE_TIME <", value, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeLessThanOrEqualTo(Date value) {
            addCriterion("CREATE_TIME <=", value, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeIn(List<Date> values) {
            addCriterion("CREATE_TIME in", values, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeNotIn(List<Date> values) {
            addCriterion("CREATE_TIME not in", values, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeBetween(Date value1, Date value2) {
            addCriterion("CREATE_TIME between", value1, value2, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeNotBetween(Date value1, Date value2) {
            addCriterion("CREATE_TIME not between", value1, value2, "createTime");
            return (Criteria) this;
        }

        public Criteria andDelFlagIsNull() {
            addCriterion("DEL_FLAG is null");
            return (Criteria) this;
        }

        public Criteria andDelFlagIsNotNull() {
            addCriterion("DEL_FLAG is not null");
            return (Criteria) this;
        }

        public Criteria andDelFlagEqualTo(Integer value) {
            addCriterion("DEL_FLAG =", value, "delFlag");
            return (Criteria) this;
        }

        public Criteria andDelFlagNotEqualTo(Integer value) {
            addCriterion("DEL_FLAG <>", value, "delFlag");
            return (Criteria) this;
        }

        public Criteria andDelFlagGreaterThan(Integer value) {
            addCriterion("DEL_FLAG >", value, "delFlag");
            return (Criteria) this;
        }

        public Criteria andDelFlagGreaterThanOrEqualTo(Integer value) {
            addCriterion("DEL_FLAG >=", value, "delFlag");
            return (Criteria) this;
        }

        public Criteria andDelFlagLessThan(Integer value) {
            addCriterion("DEL_FLAG <", value, "delFlag");
            return (Criteria) this;
        }

        public Criteria andDelFlagLessThanOrEqualTo(Integer value) {
            addCriterion("DEL_FLAG <=", value, "delFlag");
            return (Criteria) this;
        }

        public Criteria andDelFlagIn(List<Integer> values) {
            addCriterion("DEL_FLAG in", values, "delFlag");
            return (Criteria) this;
        }

        public Criteria andDelFlagNotIn(List<Integer> values) {
            addCriterion("DEL_FLAG not in", values, "delFlag");
            return (Criteria) this;
        }

        public Criteria andDelFlagBetween(Integer value1, Integer value2) {
            addCriterion("DEL_FLAG between", value1, value2, "delFlag");
            return (Criteria) this;
        }

        public Criteria andDelFlagNotBetween(Integer value1, Integer value2) {
            addCriterion("DEL_FLAG not between", value1, value2, "delFlag");
            return (Criteria) this;
        }

        public Criteria andFlowNumLikeInsensitive(String value) {
            addCriterion("upper(FLOW_NUM) like", value.toUpperCase(), "flowNum");
            return (Criteria) this;
        }

        public Criteria andCodeLikeInsensitive(String value) {
            addCriterion("upper(CODE) like", value.toUpperCase(), "code");
            return (Criteria) this;
        }

        public Criteria andEntrustTypeLikeInsensitive(String value) {
            addCriterion("upper(ENTRUST_TYPE) like", value.toUpperCase(), "entrustType");
            return (Criteria) this;
        }

        public Criteria andRemarkLikeInsensitive(String value) {
            addCriterion("upper(REMARK) like", value.toUpperCase(), "remark");
            return (Criteria) this;
        }
    }

    /**
     * This class was generated by MyBatis Generator.
     * This class corresponds to the database table pp_line_weld_entrust
     *
     * @mbggenerated do_not_delete_during_merge Sun Jul 23 12:39:36 CST 2017
     */
    public static class Criteria extends GeneratedCriteria {

        protected Criteria() {
            super();
        }
    }

    /**
     * 管线-焊接委托记录表
     * 
     * @author 菠萝大象
     * @version 1.0 2017-07-23
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