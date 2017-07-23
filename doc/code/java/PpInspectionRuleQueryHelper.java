/**
 *  introspectedTable.getFullyQualifiedTable().getComment()
 * PpInspectionRuleQueryHelper.java
 * Copyright(C) 2015-2015 xxxxxx公司
 * All rights reserved.
 * -----------------------------------------------
 * 2017-07-23 Created
 */
package java;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class PpInspectionRuleQueryHelper {
    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database table pp_inspection_rule
     *
     * @mbggenerated Sun Jul 23 12:39:36 CST 2017
     */
    protected String orderByClause;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database table pp_inspection_rule
     *
     * @mbggenerated Sun Jul 23 12:39:36 CST 2017
     */
    protected boolean distinct;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database table pp_inspection_rule
     *
     * @mbggenerated Sun Jul 23 12:39:36 CST 2017
     */
    protected List<Criteria> oredCriteria;

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table pp_inspection_rule
     *
     * @mbggenerated Sun Jul 23 12:39:36 CST 2017
     */
    public PpInspectionRuleQueryHelper() {
        oredCriteria = new ArrayList<Criteria>();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table pp_inspection_rule
     *
     * @mbggenerated Sun Jul 23 12:39:36 CST 2017
     */
    public void setOrderByClause(String orderByClause) {
        this.orderByClause = orderByClause;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table pp_inspection_rule
     *
     * @mbggenerated Sun Jul 23 12:39:36 CST 2017
     */
    public String getOrderByClause() {
        return orderByClause;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table pp_inspection_rule
     *
     * @mbggenerated Sun Jul 23 12:39:36 CST 2017
     */
    public void setDistinct(boolean distinct) {
        this.distinct = distinct;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table pp_inspection_rule
     *
     * @mbggenerated Sun Jul 23 12:39:36 CST 2017
     */
    public boolean isDistinct() {
        return distinct;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table pp_inspection_rule
     *
     * @mbggenerated Sun Jul 23 12:39:36 CST 2017
     */
    public List<Criteria> getOredCriteria() {
        return oredCriteria;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table pp_inspection_rule
     *
     * @mbggenerated Sun Jul 23 12:39:36 CST 2017
     */
    public void or(Criteria criteria) {
        oredCriteria.add(criteria);
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table pp_inspection_rule
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
     * This method corresponds to the database table pp_inspection_rule
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
     * This method corresponds to the database table pp_inspection_rule
     *
     * @mbggenerated Sun Jul 23 12:39:36 CST 2017
     */
    protected Criteria createCriteriaInternal() {
        Criteria criteria = new Criteria();
        return criteria;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table pp_inspection_rule
     *
     * @mbggenerated Sun Jul 23 12:39:36 CST 2017
     */
    public void clear() {
        oredCriteria.clear();
        orderByClause = null;
        distinct = false;
    }

    /**
     * 抽检规则设置表
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

        public Criteria andCompIdIsNull() {
            addCriterion("COMP_ID is null");
            return (Criteria) this;
        }

        public Criteria andCompIdIsNotNull() {
            addCriterion("COMP_ID is not null");
            return (Criteria) this;
        }

        public Criteria andCompIdEqualTo(Long value) {
            addCriterion("COMP_ID =", value, "compId");
            return (Criteria) this;
        }

        public Criteria andCompIdNotEqualTo(Long value) {
            addCriterion("COMP_ID <>", value, "compId");
            return (Criteria) this;
        }

        public Criteria andCompIdGreaterThan(Long value) {
            addCriterion("COMP_ID >", value, "compId");
            return (Criteria) this;
        }

        public Criteria andCompIdGreaterThanOrEqualTo(Long value) {
            addCriterion("COMP_ID >=", value, "compId");
            return (Criteria) this;
        }

        public Criteria andCompIdLessThan(Long value) {
            addCriterion("COMP_ID <", value, "compId");
            return (Criteria) this;
        }

        public Criteria andCompIdLessThanOrEqualTo(Long value) {
            addCriterion("COMP_ID <=", value, "compId");
            return (Criteria) this;
        }

        public Criteria andCompIdIn(List<Long> values) {
            addCriterion("COMP_ID in", values, "compId");
            return (Criteria) this;
        }

        public Criteria andCompIdNotIn(List<Long> values) {
            addCriterion("COMP_ID not in", values, "compId");
            return (Criteria) this;
        }

        public Criteria andCompIdBetween(Long value1, Long value2) {
            addCriterion("COMP_ID between", value1, value2, "compId");
            return (Criteria) this;
        }

        public Criteria andCompIdNotBetween(Long value1, Long value2) {
            addCriterion("COMP_ID not between", value1, value2, "compId");
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

        public Criteria andMaterialIsNull() {
            addCriterion("MATERIAL is null");
            return (Criteria) this;
        }

        public Criteria andMaterialIsNotNull() {
            addCriterion("MATERIAL is not null");
            return (Criteria) this;
        }

        public Criteria andMaterialEqualTo(String value) {
            addCriterion("MATERIAL =", value, "material");
            return (Criteria) this;
        }

        public Criteria andMaterialNotEqualTo(String value) {
            addCriterion("MATERIAL <>", value, "material");
            return (Criteria) this;
        }

        public Criteria andMaterialGreaterThan(String value) {
            addCriterion("MATERIAL >", value, "material");
            return (Criteria) this;
        }

        public Criteria andMaterialGreaterThanOrEqualTo(String value) {
            addCriterion("MATERIAL >=", value, "material");
            return (Criteria) this;
        }

        public Criteria andMaterialLessThan(String value) {
            addCriterion("MATERIAL <", value, "material");
            return (Criteria) this;
        }

        public Criteria andMaterialLessThanOrEqualTo(String value) {
            addCriterion("MATERIAL <=", value, "material");
            return (Criteria) this;
        }

        public Criteria andMaterialLike(String value) {
            addCriterion("MATERIAL like", value, "material");
            return (Criteria) this;
        }

        public Criteria andMaterialNotLike(String value) {
            addCriterion("MATERIAL not like", value, "material");
            return (Criteria) this;
        }

        public Criteria andMaterialIn(List<String> values) {
            addCriterion("MATERIAL in", values, "material");
            return (Criteria) this;
        }

        public Criteria andMaterialNotIn(List<String> values) {
            addCriterion("MATERIAL not in", values, "material");
            return (Criteria) this;
        }

        public Criteria andMaterialBetween(String value1, String value2) {
            addCriterion("MATERIAL between", value1, value2, "material");
            return (Criteria) this;
        }

        public Criteria andMaterialNotBetween(String value1, String value2) {
            addCriterion("MATERIAL not between", value1, value2, "material");
            return (Criteria) this;
        }

        public Criteria andPpClassIsNull() {
            addCriterion("PP_CLASS is null");
            return (Criteria) this;
        }

        public Criteria andPpClassIsNotNull() {
            addCriterion("PP_CLASS is not null");
            return (Criteria) this;
        }

        public Criteria andPpClassEqualTo(String value) {
            addCriterion("PP_CLASS =", value, "ppClass");
            return (Criteria) this;
        }

        public Criteria andPpClassNotEqualTo(String value) {
            addCriterion("PP_CLASS <>", value, "ppClass");
            return (Criteria) this;
        }

        public Criteria andPpClassGreaterThan(String value) {
            addCriterion("PP_CLASS >", value, "ppClass");
            return (Criteria) this;
        }

        public Criteria andPpClassGreaterThanOrEqualTo(String value) {
            addCriterion("PP_CLASS >=", value, "ppClass");
            return (Criteria) this;
        }

        public Criteria andPpClassLessThan(String value) {
            addCriterion("PP_CLASS <", value, "ppClass");
            return (Criteria) this;
        }

        public Criteria andPpClassLessThanOrEqualTo(String value) {
            addCriterion("PP_CLASS <=", value, "ppClass");
            return (Criteria) this;
        }

        public Criteria andPpClassLike(String value) {
            addCriterion("PP_CLASS like", value, "ppClass");
            return (Criteria) this;
        }

        public Criteria andPpClassNotLike(String value) {
            addCriterion("PP_CLASS not like", value, "ppClass");
            return (Criteria) this;
        }

        public Criteria andPpClassIn(List<String> values) {
            addCriterion("PP_CLASS in", values, "ppClass");
            return (Criteria) this;
        }

        public Criteria andPpClassNotIn(List<String> values) {
            addCriterion("PP_CLASS not in", values, "ppClass");
            return (Criteria) this;
        }

        public Criteria andPpClassBetween(String value1, String value2) {
            addCriterion("PP_CLASS between", value1, value2, "ppClass");
            return (Criteria) this;
        }

        public Criteria andPpClassNotBetween(String value1, String value2) {
            addCriterion("PP_CLASS not between", value1, value2, "ppClass");
            return (Criteria) this;
        }

        public Criteria andJacketedPipeIsNull() {
            addCriterion("JACKETED_PIPE is null");
            return (Criteria) this;
        }

        public Criteria andJacketedPipeIsNotNull() {
            addCriterion("JACKETED_PIPE is not null");
            return (Criteria) this;
        }

        public Criteria andJacketedPipeEqualTo(String value) {
            addCriterion("JACKETED_PIPE =", value, "jacketedPipe");
            return (Criteria) this;
        }

        public Criteria andJacketedPipeNotEqualTo(String value) {
            addCriterion("JACKETED_PIPE <>", value, "jacketedPipe");
            return (Criteria) this;
        }

        public Criteria andJacketedPipeGreaterThan(String value) {
            addCriterion("JACKETED_PIPE >", value, "jacketedPipe");
            return (Criteria) this;
        }

        public Criteria andJacketedPipeGreaterThanOrEqualTo(String value) {
            addCriterion("JACKETED_PIPE >=", value, "jacketedPipe");
            return (Criteria) this;
        }

        public Criteria andJacketedPipeLessThan(String value) {
            addCriterion("JACKETED_PIPE <", value, "jacketedPipe");
            return (Criteria) this;
        }

        public Criteria andJacketedPipeLessThanOrEqualTo(String value) {
            addCriterion("JACKETED_PIPE <=", value, "jacketedPipe");
            return (Criteria) this;
        }

        public Criteria andJacketedPipeLike(String value) {
            addCriterion("JACKETED_PIPE like", value, "jacketedPipe");
            return (Criteria) this;
        }

        public Criteria andJacketedPipeNotLike(String value) {
            addCriterion("JACKETED_PIPE not like", value, "jacketedPipe");
            return (Criteria) this;
        }

        public Criteria andJacketedPipeIn(List<String> values) {
            addCriterion("JACKETED_PIPE in", values, "jacketedPipe");
            return (Criteria) this;
        }

        public Criteria andJacketedPipeNotIn(List<String> values) {
            addCriterion("JACKETED_PIPE not in", values, "jacketedPipe");
            return (Criteria) this;
        }

        public Criteria andJacketedPipeBetween(String value1, String value2) {
            addCriterion("JACKETED_PIPE between", value1, value2, "jacketedPipe");
            return (Criteria) this;
        }

        public Criteria andJacketedPipeNotBetween(String value1, String value2) {
            addCriterion("JACKETED_PIPE not between", value1, value2, "jacketedPipe");
            return (Criteria) this;
        }

        public Criteria andInspectionCodeIsNull() {
            addCriterion("INSPECTION_CODE is null");
            return (Criteria) this;
        }

        public Criteria andInspectionCodeIsNotNull() {
            addCriterion("INSPECTION_CODE is not null");
            return (Criteria) this;
        }

        public Criteria andInspectionCodeEqualTo(String value) {
            addCriterion("INSPECTION_CODE =", value, "inspectionCode");
            return (Criteria) this;
        }

        public Criteria andInspectionCodeNotEqualTo(String value) {
            addCriterion("INSPECTION_CODE <>", value, "inspectionCode");
            return (Criteria) this;
        }

        public Criteria andInspectionCodeGreaterThan(String value) {
            addCriterion("INSPECTION_CODE >", value, "inspectionCode");
            return (Criteria) this;
        }

        public Criteria andInspectionCodeGreaterThanOrEqualTo(String value) {
            addCriterion("INSPECTION_CODE >=", value, "inspectionCode");
            return (Criteria) this;
        }

        public Criteria andInspectionCodeLessThan(String value) {
            addCriterion("INSPECTION_CODE <", value, "inspectionCode");
            return (Criteria) this;
        }

        public Criteria andInspectionCodeLessThanOrEqualTo(String value) {
            addCriterion("INSPECTION_CODE <=", value, "inspectionCode");
            return (Criteria) this;
        }

        public Criteria andInspectionCodeLike(String value) {
            addCriterion("INSPECTION_CODE like", value, "inspectionCode");
            return (Criteria) this;
        }

        public Criteria andInspectionCodeNotLike(String value) {
            addCriterion("INSPECTION_CODE not like", value, "inspectionCode");
            return (Criteria) this;
        }

        public Criteria andInspectionCodeIn(List<String> values) {
            addCriterion("INSPECTION_CODE in", values, "inspectionCode");
            return (Criteria) this;
        }

        public Criteria andInspectionCodeNotIn(List<String> values) {
            addCriterion("INSPECTION_CODE not in", values, "inspectionCode");
            return (Criteria) this;
        }

        public Criteria andInspectionCodeBetween(String value1, String value2) {
            addCriterion("INSPECTION_CODE between", value1, value2, "inspectionCode");
            return (Criteria) this;
        }

        public Criteria andInspectionCodeNotBetween(String value1, String value2) {
            addCriterion("INSPECTION_CODE not between", value1, value2, "inspectionCode");
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

        public Criteria andMaterialLikeInsensitive(String value) {
            addCriterion("upper(MATERIAL) like", value.toUpperCase(), "material");
            return (Criteria) this;
        }

        public Criteria andPpClassLikeInsensitive(String value) {
            addCriterion("upper(PP_CLASS) like", value.toUpperCase(), "ppClass");
            return (Criteria) this;
        }

        public Criteria andJacketedPipeLikeInsensitive(String value) {
            addCriterion("upper(JACKETED_PIPE) like", value.toUpperCase(), "jacketedPipe");
            return (Criteria) this;
        }

        public Criteria andInspectionCodeLikeInsensitive(String value) {
            addCriterion("upper(INSPECTION_CODE) like", value.toUpperCase(), "inspectionCode");
            return (Criteria) this;
        }
    }

    /**
     * This class was generated by MyBatis Generator.
     * This class corresponds to the database table pp_inspection_rule
     *
     * @mbggenerated do_not_delete_during_merge Sun Jul 23 12:39:36 CST 2017
     */
    public static class Criteria extends GeneratedCriteria {

        protected Criteria() {
            super();
        }
    }

    /**
     * 抽检规则设置表
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