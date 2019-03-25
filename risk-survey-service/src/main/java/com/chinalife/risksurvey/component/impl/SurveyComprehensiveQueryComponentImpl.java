package com.chinalife.risksurvey.component.impl;

import java.lang.reflect.Field;
import java.text.ParseException;
import java.util.ArrayList;

import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;


import com.chinalife.base.component.impl.BaseComponentImpl;

import com.chinalife.base.util.Pagination;

import com.chinalife.risksurvey.component.ISurveyComprehensiveQueryComponent;
import com.chinalife.risksurvey.entity.SurveyCustomerEO;
import com.chinalife.risksurvey.entity.SurveyMainEO;
import com.chinalife.risksurvey.entity.SurveyRelBusinessEO;
import com.chinalife.risksurvey.repository.ISurveyComprehensiveQueryRepository;
import com.chinalife.risksurvey.utils.DateUtils;
import com.chinalife.risksurvey.utils.QueryCondition;
import com.chinalife.risksurvey.utils.QueryCondition.AndFilter;
import com.chinalife.risksurvey.utils.QueryCondition.QueryConditionOperatorType;
import com.chinalife.risksurvey.vo.SurveyComprehensiveQueryVo;

/**      
 * 综合查询
 */  
@Component("surveyComprehensiveQueryComponent")
public class SurveyComprehensiveQueryComponentImpl extends BaseComponentImpl<SurveyMainEO, ISurveyComprehensiveQueryRepository>
        implements ISurveyComprehensiveQueryComponent {

    /**
     * surveyComprehensiveQueryRepository
     */
    @Autowired
    ISurveyComprehensiveQueryRepository surveyComprehensiveQueryRepository;

    @Override
    public Pagination<SurveyComprehensiveQueryVo> comprehensiveQuery(Map<String, Object> parameter, Integer from,
            Integer limit, String sorting) {
        QueryCondition queryCondition = new QueryCondition();
        List<String> businessTypeList = new ArrayList<String>();

        return querySurveyMain(queryCondition, businessTypeList, parameter, from, limit, sorting);

    }

    /**
     * @param queryCondition queryCondition
     * @param businessTypeList businessTypeList
     * @param parameter parameter
     * @param from from
     * @param limit limit
     * @param sorting sorting
     * @return  SurveyMainBusinessCustomerVO
     */
    @SuppressWarnings("unused")
    private Pagination<SurveyComprehensiveQueryVo> querySurveyMain(QueryCondition queryCondition,
            List<String> businessTypeList, Map<String, Object> parameter, Integer from, Integer limit, String sorting) {
        initSurveyQueryCondition(parameter, queryCondition);

        // initPlcBasicQueryConditionTB(parameter, queryCondition);

        /*
         * initBasicAndMainQueryCondition(parameter, queryCondition); if
         * (StringUtil.isNull(String.valueOf(parameter.get("policyNo"))) &&
         * StringUtil.isNull(String.valueOf(parameter.get("proposalNo")))) {
         * initSpecialQueryCondition(parameter, queryCondition);
         * initPlcBasicQueryCondition(parameter, queryCondition); }
         */
        initComprehensiveQueryCondition(parameter, queryCondition);
        if ("structureId".equals(sorting)) {
            sorting = "m." + sorting;
        }
        queryCondition.setSort(sorting);

        return surveyComprehensiveQueryRepository.listSurveyMains(parameter, queryCondition, from, limit);

    }
    
    /**
     * @param parameter
     *            a
     * @param queryCondition
     *            a
     *            投保单
     * @Description: 封装日期类型参数
     */
    
    protected void initComprehensiveQueryCondition(Map<String, Object> parameter, QueryCondition queryCondition) {

        // 是否包含投保单号，报价单号，产品组合编号
        // boolean containsNo = (parameter.containsKey("proposalNo") &&
        // parameter.get("proposalNo") != null)
        // || (parameter.containsKey("quoteNo") && parameter.get("quoteNo") !=
        // null)
        // || (parameter.containsKey("productCombineNo") &&
        // parameter.get("productCombineNo") != null);
        // 风险查勘日期
        if ((parameter.containsKey("surveyerDateBegin") && parameter.get("surveyerDateBegin") != null)) {
            AndFilter andFilter = new QueryCondition().new AndFilter();
            andFilter.setKey("to_char(m.surveyerDate,'yyyy-MM-dd')");
            // andFilter.setV((String) parameter.get("startTimeBegin"));
            try {
                andFilter.setV(DateUtils
                        .formatDate(DateUtils.parseDate((String) parameter.get("surveyerDateBegin"), "yyyy-MM-dd")));
            } catch (ParseException e) {
                e.printStackTrace();
            }
            andFilter.setOperatorType(QueryConditionOperatorType.MOST);
            queryCondition.addAddFilter(andFilter);
        }
        if ((parameter.containsKey("surveyerDateEnd") && parameter.get("surveyerDateEnd") != null)) {

            AndFilter andFilter = new QueryCondition().new AndFilter();
            andFilter.setKey("to_char(m.surveyerDate ,'yyyy-MM-dd')");
            // andFilter.setV((String) parameter.get("startTimeEnd"));
            try {
                andFilter.setV(DateUtils
                        .formatDate(DateUtils.parseDate((String) parameter.get("surveyerDateEnd"), "yyyy-MM-dd")));
            } catch (ParseException e) {
                e.printStackTrace();
            }
            andFilter.setOperatorType(QueryConditionOperatorType.LEAST);
            queryCondition.addAddFilter(andFilter);
        }

        // 报告生成日期
        if ((parameter.containsKey("reportProduceDateBegin") && parameter.get("reportProduceDateBegin") != null)) {
            AndFilter andFilter = new QueryCondition().new AndFilter();
            andFilter.setKey("to_char(m.reportProduceDate,'yyyy-MM-dd')");
            // andFilter.setV((String) parameter.get("endTimeBegin"));
            try {
                andFilter.setV(DateUtils
                        .formatDate(DateUtils.parseDate((String) parameter.get("reportProduceDateBegin"), "yyyy-MM-dd")));
            } catch (ParseException e) {
                e.printStackTrace();
            }
            andFilter.setOperatorType(QueryConditionOperatorType.MOST);
            queryCondition.addAddFilter(andFilter);
        }
        if ((parameter.containsKey("reportProduceDateEnd") && parameter.get("reportProduceDateEnd") != null)) {
            AndFilter andFilter = new QueryCondition().new AndFilter();
            andFilter.setKey("to_char(m.reportProduceDate ,'yyyy-MM-dd')");
            // andFilter.setV((String) parameter.get("endTimeEnd"));
            try {
                andFilter.setV(
                        DateUtils.formatDate(DateUtils.parseDate((String) parameter.get("reportProduceDateEnd"), "yyyy-MM-dd")));
            } catch (ParseException e) {
                e.printStackTrace();
            }
            andFilter.setOperatorType(QueryConditionOperatorType.LEAST);
            queryCondition.addAddFilter(andFilter);
        }
        // 任务发起时间
        if ((parameter.containsKey("taskStarterDateBegin") && parameter.get("taskStarterDateBegin") != null)) {
            AndFilter andFilter = new QueryCondition().new AndFilter();
            andFilter.setKey("to_char(m.applicantDate,'yyyy-MM-dd')");
            // andFilter.setV((String) parameter.get("applicantDateBegin"));
            try {
                andFilter.setV(DateUtils
                        .formatDate(DateUtils.parseDate((String) parameter.get("applicantDateBegin"), "yyyy-MM-dd")));
            } catch (ParseException e) {
                e.printStackTrace();
            }
            andFilter.setOperatorType(QueryConditionOperatorType.MOST);
            queryCondition.addAddFilter(andFilter);
        }
        if ((parameter.containsKey("taskStarterDateEnd") && parameter.get("taskStarterDateEnd") != null)) {
            AndFilter andFilter = new QueryCondition().new AndFilter();
            andFilter.setKey("to_char(m.taskStarterDate ,'yyyy-MM-dd')");
            // andFilter.setV((String) parameter.get("applicantDateEnd"));
            try {
                andFilter.setV(DateUtils
                        .formatDate(DateUtils.parseDate((String) parameter.get("taskStarterDateEnd"), "yyyy-MM-dd")));
            } catch (ParseException e) {
                e.printStackTrace();
            }
            andFilter.setOperatorType(QueryConditionOperatorType.LEAST);
            queryCondition.addAddFilter(andFilter);
        }

    }

    /**
     * @param parameter  parameter
     * @param queryCondition  queryCondition
     */
    /*private void initPlcBasicQueryConditionTB(Map<String, Object> parameter,QueryCondition queryCondition) {
        // TODO Auto-generated method stub
        // 是否包含投保单号，报价单号，产品组合编号
        boolean containsNo = StringUtil.isNotNull(String.valueOf(parameter.get("policyNo")))
                || StringUtil.isNotNull(String.valueOf(parameter.get("proposalNo")))
                || StringUtil.isNotNull(String.valueOf(parameter.get("quoteNo")))
                || StringUtil.isNotNull(String.valueOf(parameter.get("productCombineNo")));
        rebuildQueryCondition(parameter, queryCondition, containsNo);
    }*/

    /**
     * 处理特殊的车险产品编码
     *
     * @param productCodeTemplate
     *            前台传入的特殊产品编码
     * @return 产品编码分类 050 交强 ； 051 商业
     */
    private String getProductByProductCodeTemplate(String productCodeTemplate) {
        String finalProductCode = "05%";
        if ("0".equals(productCodeTemplate)) {
            finalProductCode = "050%";
        }
        if ("1".equals(productCodeTemplate)) {
            finalProductCode = "051%";
        }

        return finalProductCode;

    }

    /**
     * 转换日期为String
     *
     * @param obj
     *            日期对象
     * @return 日期字符串
     */
    private String parseObjectToDate(Object obj) {
        try {
            return DateUtils.formatDate(DateUtils.parseDate((String) obj, "yyyy-MM-dd"));
        } catch (ParseException e) {
            e.printStackTrace();
            return null;
        }

    }

    /**
     * @param parameter
     *            a
     * @param queryCondition
     *            a
     * @Description: 封装日期类型参数
     */
    protected void initPlcBasicQueryCondition(Map<String, Object> parameter, QueryCondition queryCondition) {

        Map<String, Field> surveyMainFieldMap = this.findFiledByClassName(SurveyMainEO.class);
        Map<String, Field> surveyRelBusinessFieldMap = this.findFiledByClassName(SurveyRelBusinessEO.class);
        Map<String, Field> surveyCustomerFieldMap = this.findFiledByClassName(SurveyCustomerEO.class);

        for (Entry<String, Object> entry : parameter.entrySet()) {

            Object value = entry.getValue();
            String key = entry.getKey();
            String alais = "";
            String newKey = key.replaceAll("_begin", "").replaceAll("_end", "");
            Field field = null;
            if (surveyMainFieldMap.containsKey(newKey)) {
                alais = "m";
                field = surveyMainFieldMap.get(newKey);
            }
            if (surveyRelBusinessFieldMap.containsKey(newKey)) {
                alais = "r";
                field = surveyRelBusinessFieldMap.get(newKey);
            }
            if (surveyCustomerFieldMap.containsKey(newKey)) {
                alais = "c";
                field = surveyCustomerFieldMap.get(newKey);
            }
            if (!"".equals(value) && null != value && (value instanceof Date || (field != null
                    && field.getType().getName() == Date.class.getName() && value instanceof String))) {
                if (key.endsWith("_begin")) {
                    AndFilter andFilter = new QueryCondition().new AndFilter();
                    andFilter.setKey("to_char(" + alais + "." + newKey + ",'yyyy-MM-dd')");
                    andFilter.setV(parseObjectToDate(value));
                    andFilter.setOperatorType(QueryConditionOperatorType.MOST);
                    queryCondition.addAddFilter(andFilter);
                    continue;
                }
                if (key.endsWith("_end")) {
                    AndFilter andFilter = new QueryCondition().new AndFilter();
                    andFilter.setKey("to_char( " + alais + "." + newKey + ",'yyyy-MM-dd')");
                    andFilter.setV(parseObjectToDate(value));
                    andFilter.setOperatorType(QueryConditionOperatorType.LEAST);
                    queryCondition.addAddFilter(andFilter);
                    continue;
                }
                if (!key.endsWith("_end") && !key.endsWith("_begin")) {
                    AndFilter andFilterMost = new QueryCondition().new AndFilter();
                    andFilterMost.setKey("to_char(" + alais + "." + key + ",'yyyy-MM-dd') ");
                    andFilterMost.setV(parseObjectToDate(value));
                    andFilterMost.setOperatorType(QueryConditionOperatorType.MOST);
                    queryCondition.addAddFilter(andFilterMost);
                    AndFilter andFilterLeast = new QueryCondition().new AndFilter();
                    andFilterLeast.setKey("to_char( " + alais + "." + key + ",'yyyy-MM-dd' )");
                    andFilterLeast.setV(parseObjectToDate(value));
                    andFilterLeast.setOperatorType(QueryConditionOperatorType.LEAST);
                    queryCondition.addAddFilter(andFilterLeast);
                }
            }
        }

    }
   /* *//**
     * 
     * @param parameter parameter
     * @param queryCondition  queryCondition
     * @param containsNo containsNo
     *//*
    private void rebuildQueryCondition(Map<String, Object> parameter,QueryCondition queryCondition,
            boolean containsNo) {
        // TODO Auto-generated method stub

        // 起保日期
        if ((parameter.containsKey("startTimeBegin") && parameter.get("startTimeBegin") != null) && !containsNo) {
            AndFilter andFilter = new QueryCondition().new AndFilter();
            andFilter.setKey("to_char(m.startTime,'yyyy-MM-dd')");
            // andFilter.setV((String) parameter.get("startTimeBegin"));
            try {
                andFilter.setV(DateUtils
                        .formatDate(DateUtils.parseDate((String) parameter.get("startTimeBegin"), "yyyy-MM-dd")));
            } catch (ParseException e) {
                e.printStackTrace();
            }
            andFilter.setOperatorType(QueryConditionOperatorType.MOST);
            queryCondition.addAddFilter(andFilter);
        }
        if ((parameter.containsKey("startTimeEnd") && parameter.get("startTimeEnd") != null) && !containsNo) {

            AndFilter andFilter = new QueryCondition().new AndFilter();
            andFilter.setKey("to_char(m.startTime ,'yyyy-MM-dd')");
            // andFilter.setV((String) parameter.get("startTimeEnd"));
            try {
                andFilter.setV(DateUtils
                        .formatDate(DateUtils.parseDate((String) parameter.get("startTimeEnd"), "yyyy-MM-dd")));
            } catch (ParseException e) {
                e.printStackTrace();
            }
            andFilter.setOperatorType(QueryConditionOperatorType.LEAST);
            queryCondition.addAddFilter(andFilter);
        }

        // 终保日期
        if ((parameter.containsKey("endTimeBegin") && parameter.get("endTimeBegin") != null) && !containsNo) {
            AndFilter andFilter = new QueryCondition().new AndFilter();
            andFilter.setKey("to_char(m.endTime,'yyyy-MM-dd')");
            // andFilter.setV((String) parameter.get("endTimeBegin"));
            try {
                andFilter.setV(DateUtils
                        .formatDate(DateUtils.parseDate((String) parameter.get("endTimeBegin"), "yyyy-MM-dd")));
            } catch (ParseException e) {
                e.printStackTrace();
            }
            andFilter.setOperatorType(QueryConditionOperatorType.MOST);
            queryCondition.addAddFilter(andFilter);
        }
        if ((parameter.containsKey("endTimeEnd") && parameter.get("endTimeEnd") != null) && !containsNo) {
            AndFilter andFilter = new QueryCondition().new AndFilter();
            andFilter.setKey("to_char(m.endTime ,'yyyy-MM-dd')");
            // andFilter.setV((String) parameter.get("endTimeEnd"));
            try {
                andFilter.setV(
                        DateUtils.formatDate(DateUtils.parseDate((String) parameter.get("endTimeEnd"), "yyyy-MM-dd")));
            } catch (ParseException e) {
                e.printStackTrace();
            }
            andFilter.setOperatorType(QueryConditionOperatorType.LEAST);
            queryCondition.addAddFilter(andFilter);
        }
        // 投保日期
        if ((parameter.containsKey("applicantDateBegin") && parameter.get("applicantDateBegin") != null)) {
            AndFilter andFilter = new QueryCondition().new AndFilter();
            andFilter.setKey("to_char(m.applicantDate,'yyyy-MM-dd')");
            // andFilter.setV((String) parameter.get("applicantDateBegin"));
            try {
                andFilter.setV(DateUtils
                        .formatDate(DateUtils.parseDate((String) parameter.get("applicantDateBegin"), "yyyy-MM-dd")));
            } catch (ParseException e) {
                e.printStackTrace();
            }
            andFilter.setOperatorType(QueryConditionOperatorType.MOST);
            queryCondition.addAddFilter(andFilter);
        }
        if ((parameter.containsKey("applicantDateEnd") && parameter.get("applicantDateEnd") != null)) {
            AndFilter andFilter = new QueryCondition().new AndFilter();
            andFilter.setKey("to_char(m.applicantDate ,'yyyy-MM-dd')");
            // andFilter.setV((String) parameter.get("applicantDateEnd"));
            try {
                andFilter.setV(DateUtils
                        .formatDate(DateUtils.parseDate((String) parameter.get("applicantDateEnd"), "yyyy-MM-dd")));
            } catch (ParseException e) {
                e.printStackTrace();
            }
            andFilter.setOperatorType(QueryConditionOperatorType.LEAST);
            queryCondition.addAddFilter(andFilter);
        }

        // 制单日期
        if ((parameter.containsKey("makeDateStart") && parameter.get("makeDateStart") != null) && !containsNo) {
            AndFilter andFilter = new QueryCondition().new AndFilter();
            andFilter.setKey("to_char(m.makeDate,'yyyy-MM-dd')");
            // andFilter.setV((String) parameter.get("makeDateStart"));
            try {
                andFilter.setV(DateUtils
                        .formatDate(DateUtils.parseDate((String) parameter.get("makeDateStart"), "yyyy-MM-dd")));
            } catch (ParseException e) {
                e.printStackTrace();
            }
            andFilter.setOperatorType(QueryConditionOperatorType.MOST);
            queryCondition.addAddFilter(andFilter);
        }
        if ((parameter.containsKey("makeDateEnd") && parameter.get("makeDateEnd") != null) && !containsNo) {
            AndFilter andFilter = new QueryCondition().new AndFilter();
            andFilter.setKey("to_char(m.makeDate ,'yyyy-MM-dd')");
            // andFilter.setV((String) parameter.get("makeDateEnd"));
            try {
                andFilter.setV(
                        DateUtils.formatDate(DateUtils.parseDate((String) parameter.get("makeDateEnd"), "yyyy-MM-dd")));
            } catch (ParseException e) {
                e.printStackTrace();
            }
            andFilter.setOperatorType(QueryConditionOperatorType.LEAST);
            queryCondition.addAddFilter(andFilter);
        }
        // 核保日期
        if ((parameter.containsKey("uwConclueStartDate") && parameter.get("uwConclueStartDate") != null)
                && !containsNo) {
            AndFilter andFilter = new QueryCondition().new AndFilter();
            andFilter.setKey("to_char(m.uwConclueDate,'yyyy-MM-dd')");
            // andFilter.setV((String) parameter.get("uwConclueStartDate"));
            try {
                andFilter.setV(DateUtils
                        .formatDate(DateUtils.parseDate((String) parameter.get("uwConclueStartDate"), "yyyy-MM-dd")));
            } catch (ParseException e) {
                e.printStackTrace();
            }
            andFilter.setOperatorType(QueryConditionOperatorType.MOST);
            queryCondition.addAddFilter(andFilter);
        }
        if ((parameter.containsKey("uwConclueEndDate") && parameter.get("uwConclueEndDate") != null) && !containsNo) {
            AndFilter andFilter = new QueryCondition().new AndFilter();
            andFilter.setKey("to_char(m.uwConclueDate ,'yyyy-MM-dd')");
            // andFilter.setV((String) parameter.get("uwConclueEndDate"));
            try {
                andFilter.setV(DateUtils
                        .formatDate(DateUtils.parseDate((String) parameter.get("uwConclueEndDate"), "yyyy-MM-dd")));
            } catch (ParseException e) {
                e.printStackTrace();
            }
            andFilter.setOperatorType(QueryConditionOperatorType.LEAST);
            queryCondition.addAddFilter(andFilter);
        }
        // 签单日期
        if ((parameter.containsKey("signDateBegin") && parameter.get("signDateBegin") != null)) {
            AndFilter andFilter = new QueryCondition().new AndFilter();
            andFilter.setKey("to_char(m.signDate,'yyyy-MM-dd')");
            // andFilter.setV((String) parameter.get("uwConclueStartDate"));
            try {
                andFilter.setV(DateUtils
                        .formatDate(DateUtils.parseDate((String) parameter.get("signDateBegin"), "yyyy-MM-dd")));
            } catch (ParseException e) {
                e.printStackTrace();
            }
            andFilter.setOperatorType(QueryConditionOperatorType.MOST);
            queryCondition.addAddFilter(andFilter);
        }
        if ((parameter.containsKey("signDateEnd") && parameter.get("signDateEnd") != null)) {
            AndFilter andFilter = new QueryCondition().new AndFilter();
            andFilter.setKey("to_char(m.signDate ,'yyyy-MM-dd')");
            // andFilter.setV((String) parameter.get("uwConclueEndDate"));
            try {
                andFilter.setV(
                        DateUtils.formatDate(DateUtils.parseDate((String) parameter.get("signDateEnd"), "yyyy-MM-dd")));
            } catch (ParseException e) {
                e.printStackTrace();
            }
            andFilter.setOperatorType(QueryConditionOperatorType.LEAST);
            queryCondition.addAddFilter(andFilter);
        }
    }*/

    /**
     * @param parameter parameter
     * @param queryCondition queryCondition
     */
    private void initSurveyQueryCondition(Map<String, Object> parameter, QueryCondition queryCondition) {
        // TODO Auto-generated method stub
        if (parameter == null) {
            return;

        }
        Map<String, Field> surveyMainFieldMap = this.findFiledByClassName(SurveyMainEO.class);
        Map<String, Field> surveyRelBusinessFieldMap = this.findFiledByClassName(SurveyRelBusinessEO.class);
        Map<String, Field> surveyCustomerFieldMap = this.findFiledByClassName(SurveyCustomerEO.class);
        for (Entry<String, Object> entry : parameter.entrySet()) {
            String key = entry.getKey();
            if (surveyMainFieldMap.containsKey(key)) {
                // SurveyMainFieldMap中字段
                Field field = surveyMainFieldMap.get(key);
                Class<?> type = field.getType();
                Object o = entry.getValue();
                if (o instanceof String && String.class.getName() == type.getName()) {
                    if (StringUtils.isBlank(String.valueOf(o))) {
                        continue;
                    }
                    AndFilter andFilter = new QueryCondition().new AndFilter();
                    andFilter.setAlias("m");
                    andFilter.setKey(key);
                    if ("surveyId".equals(key)) {
                        andFilter.setV(o);
                        andFilter.setOperatorType(QueryConditionOperatorType.EQUAL);
                    } else {
                        andFilter.setV((String) o + "%");
                        andFilter.setOperatorType(QueryConditionOperatorType.LIKE);
                    }
                    queryCondition.addAddFilter(andFilter);
                }
                if (o instanceof Integer && Integer.class.getName() == type.getName()) {
                    if (StringUtils.isBlank(String.valueOf(o))) {
                        continue;
                    }
                    AndFilter andFilter = new QueryCondition().new AndFilter();
                    andFilter.setAlias("m");
                    andFilter.setKey(key);
                    andFilter.setV(o);
                    andFilter.setOperatorType(QueryConditionOperatorType.EQUAL);
                    queryCondition.addAddFilter(andFilter);
                }
                if (o instanceof Double && Double.class.getName() == type.getName()) {
                    if (StringUtils.isBlank(String.valueOf(o))) {
                        continue;
                    }
                    AndFilter andFilter = new QueryCondition().new AndFilter();
                    andFilter.setAlias("m");
                    andFilter.setKey(key);
                    andFilter.setV(o);
                    andFilter.setOperatorType(QueryConditionOperatorType.EQUAL);
                    queryCondition.addAddFilter(andFilter);
                }
                if (o instanceof Long && Long.class.getName() == type.getName()) {
                    if (StringUtils.isBlank(String.valueOf(o))) {
                        continue;
                    }
                    AndFilter andFilter = new QueryCondition().new AndFilter();
                    andFilter.setAlias("m");
                    andFilter.setKey(key);
                    andFilter.setV(o);
                    andFilter.setOperatorType(QueryConditionOperatorType.EQUAL);
                    queryCondition.addAddFilter(andFilter);
                }
                if (o instanceof java.util.Collection) {

                    AndFilter andFilter = new QueryCondition().new AndFilter();
                    andFilter.setAlias("m");
                    andFilter.setKey(key);
                    andFilter.setV(o);
                    andFilter.setOperatorType(QueryConditionOperatorType.IN);
                    queryCondition.addAddFilter(andFilter);

                }
            }
            if (surveyRelBusinessFieldMap.containsKey(key)) {
                // SurveyRelBusinessFieldMap中字段
                Field field = surveyRelBusinessFieldMap.get(key);
                Class<?> type = field.getType();
                Object o = entry.getValue();
                if (o instanceof String && String.class.getName() == type.getName()) {
                    if (StringUtils.isBlank(String.valueOf(o))) {
                        continue;
                    }
                    AndFilter andFilter = new QueryCondition().new AndFilter();
                    andFilter.setAlias("r");
                    andFilter.setKey(key);
                    if ("surveyId".equals(key)) {
                        andFilter.setV(o);
                        andFilter.setOperatorType(QueryConditionOperatorType.EQUAL);
                    } else {
                        andFilter.setV((String) o + "%");
                        andFilter.setOperatorType(QueryConditionOperatorType.LIKE);
                    }
                    queryCondition.addAddFilter(andFilter);
                }
                if (o instanceof Integer && Integer.class.getName() == type.getName()) {
                    if (StringUtils.isBlank(String.valueOf(o))) {
                        continue;
                    }
                    AndFilter andFilter = new QueryCondition().new AndFilter();
                    andFilter.setAlias("r");
                    andFilter.setKey(key);
                    andFilter.setV(o);
                    andFilter.setOperatorType(QueryConditionOperatorType.EQUAL);
                    queryCondition.addAddFilter(andFilter);
                }
                if (o instanceof Double && Double.class.getName() == type.getName()) {
                    if (StringUtils.isBlank(String.valueOf(o))) {
                        continue;
                    }
                    AndFilter andFilter = new QueryCondition().new AndFilter();
                    andFilter.setAlias("r");
                    andFilter.setKey(key);
                    andFilter.setV(o);
                    andFilter.setOperatorType(QueryConditionOperatorType.EQUAL);
                    queryCondition.addAddFilter(andFilter);
                }
                if (o instanceof Long && Long.class.getName() == type.getName()) {
                    if (StringUtils.isBlank(String.valueOf(o))) {
                        continue;
                    }
                    AndFilter andFilter = new QueryCondition().new AndFilter();
                    andFilter.setAlias("r");
                    andFilter.setKey(key);
                    andFilter.setV(o);
                    andFilter.setOperatorType(QueryConditionOperatorType.EQUAL);
                    queryCondition.addAddFilter(andFilter);
                }
                if (o instanceof java.util.Collection) {

                    AndFilter andFilter = new QueryCondition().new AndFilter();
                    andFilter.setAlias("r");
                    andFilter.setKey(key);
                    andFilter.setV(o);
                    andFilter.setOperatorType(QueryConditionOperatorType.IN);
                    queryCondition.addAddFilter(andFilter);

                }
            }
            if (surveyCustomerFieldMap.containsKey(key)) {
                // plcBasic中字段
                Field field = surveyCustomerFieldMap.get(key);
                Class<?> type = field.getType();
                Object o = entry.getValue();
                if (o instanceof String && String.class.getName() == type.getName() && !"customerName".equals(key)) {
                    if (StringUtils.isBlank(String.valueOf(o))) {
                        continue;
                    }
                    AndFilter andFilter = new QueryCondition().new AndFilter();
                    andFilter.setAlias("c");
                    andFilter.setKey(key);
                    if ("surveyId".equals(key)) {
                        andFilter.setV(o);
                        andFilter.setOperatorType(QueryConditionOperatorType.EQUAL);
                    } else {
                        andFilter.setV((String) o + "%");
                        andFilter.setOperatorType(QueryConditionOperatorType.LIKE);
                    }

                    queryCondition.addAddFilter(andFilter);
                }
                if (o instanceof Integer && Integer.class.getName() == type.getName()) {
                    if (StringUtils.isBlank(String.valueOf(o))) {
                        continue;
                    }
                    AndFilter andFilter = new QueryCondition().new AndFilter();
                    andFilter.setAlias("c");
                    andFilter.setKey(key);
                    andFilter.setV(o);
                    andFilter.setOperatorType(QueryConditionOperatorType.EQUAL);
                    queryCondition.addAddFilter(andFilter);
                }
                if (o instanceof Double && Double.class.getName() == type.getName()) {
                    if (StringUtils.isBlank(String.valueOf(o))) {
                        continue;
                    }
                    AndFilter andFilter = new QueryCondition().new AndFilter();
                    andFilter.setAlias("c");
                    andFilter.setKey(key);
                    andFilter.setV(o);
                    andFilter.setOperatorType(QueryConditionOperatorType.EQUAL);
                    queryCondition.addAddFilter(andFilter);
                }
                if (o instanceof Long && Long.class.getName() == type.getName()) {
                    if (StringUtils.isBlank(String.valueOf(o))) {
                        continue;
                    }
                    AndFilter andFilter = new QueryCondition().new AndFilter();
                    andFilter.setAlias("c");
                    andFilter.setKey(key);
                    andFilter.setV(o);
                    andFilter.setOperatorType(QueryConditionOperatorType.EQUAL);
                    queryCondition.addAddFilter(andFilter);
                }
                if (o instanceof java.util.Collection) {

                    AndFilter andFilter = new QueryCondition().new AndFilter();
                    andFilter.setAlias("c");
                    andFilter.setKey(key);
                    andFilter.setV(o);
                    andFilter.setOperatorType(QueryConditionOperatorType.IN);
                    queryCondition.addAddFilter(andFilter);

                }
            }
        }

    }


    /**
     * @param className className
     * @return map
     */
    @SuppressWarnings({ "unchecked" })
    private Map<String, Field> findFiledByClassName(Class className) {

        Field[] fields = className.getDeclaredFields();

        Map<String, Field> filedMap = new HashMap<String, Field>();

        for (Field f : fields) {
            filedMap.put(f.getName(), f);
        }
        return filedMap;

    }
}
