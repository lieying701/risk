package com.chinalife.risksurvey.component.impl;


import java.util.Map;
import java.util.Map.Entry;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.chinalife.base.component.impl.BaseComponentImpl;
import com.chinalife.base.exception.StandardRuntimeException;
import com.chinalife.base.util.Pagination;
import com.chinalife.rbac.entity.RbacUserEO;
import com.chinalife.rbac.filter.service.ICurrentRbacUserService;
import com.chinalife.risksurvey.component.ISurveyTaskQueryComponent;
import com.chinalife.risksurvey.entity.SurveyTaskEO;
import com.chinalife.risksurvey.repository.ISurveyTaskQueryRepository;

import com.chinalife.risksurvey.utils.QueryCondition;

import com.chinalife.risksurvey.utils.QueryCondition.QueryConditionOperatorType;


/**
 * 包名称： com.chinalife.risksurvey.component.impl
 * 类名称：SurveyTaskQueryComponetImpl<br/>
 * 类描述：<br/>
 * 
 * @version <br/>
 */
@Component("surveyTaskQueryComponent")
public class SurveyTaskQueryComponentImpl extends BaseComponentImpl<SurveyTaskEO, ISurveyTaskQueryRepository>
        implements ISurveyTaskQueryComponent {

    /**
     * ISurveyTaskQueryRepository
     */
    @Autowired
    private ISurveyTaskQueryRepository surveyTaskQueryRepository;
    
    /**
     * currentUserService
     */
    @Autowired
    private ICurrentRbacUserService currentUserService;

    @Override
    public Pagination<SurveyTaskEO> getMyDoingTaskPages(Map<String, Object> parameters, int from,
            int limit, String sorting) {
        RbacUserEO currentUser = currentUserService.findCurrentUser(); 
        if (currentUser == null) {
            throw new StandardRuntimeException("请登录");
        }
        //parameters.put("surveyer", currentUser.getLoginName());
        
        QueryCondition queryCondition = new QueryCondition();
        
        return queryMyDoingSurveyTask(queryCondition, parameters, from, limit, sorting);

    }
    
    @Override
    public Pagination<SurveyTaskEO> findUnassignrisk(Map<String, Object> parameter, Integer from,
            Integer limit, String sorting) {
        RbacUserEO currentUser = currentUserService.findCurrentUser(); 
        if (currentUser == null) {
            throw new StandardRuntimeException("请登录");
        }
        //parameter.put("surveyer", currentUser.getLoginName());
        QueryCondition queryCondition = new QueryCondition();
        return queryUnassignSurveyMain(queryCondition, parameter, from, limit, sorting);

    }
    
    /**
     * @param queryCondition queryCondition
     * @param parameters parameters
     * @param from from
     * @param limit limit
     * @param sorting sorting
     * @return SurveyTaskEO
     */
    private Pagination<SurveyTaskEO> queryMyDoingSurveyTask(QueryCondition queryCondition,
            Map<String, Object> parameters, int from, int limit, String sorting) {
        initQuerySurveyTask(parameters,queryCondition);
        if ("newFlag".equals(sorting)) {
            sorting = "t." + sorting;
        }
        queryCondition.setSort(sorting);
        return surveyTaskQueryRepository.findSurveyTask(parameters, queryCondition, from, limit);
    }

    /**
     * @param queryCondition queryCondition
     * @param parameter parameter
     * @param from from
     * @param limit limit
     * @param sorting sorting
     * @return  SurveyTaskEO
     */
    private Pagination<SurveyTaskEO> queryUnassignSurveyMain(QueryCondition queryCondition,
            Map<String, Object> parameter, Integer from, Integer limit, String sorting) {
        initQuerySurveyTask(parameter,queryCondition);

        if ("newFlag".equals(sorting)) {
            sorting = "t." + sorting;
        }
        queryCondition.setSort(sorting);

        return surveyTaskQueryRepository.listSurveyMains(parameter, queryCondition, from, limit);

    }
    

    /**
     * @param parameters parameters
     * @param queryCondition queryCondition
     */
    public void initQuerySurveyTask(Map<String, Object> parameters, QueryCondition queryCondition) {

        if (parameters != null) {
            for (Entry<String, Object> entry : parameters.entrySet()) {
                Object entryValue = entry.getValue();
                if (entryValue == null) {
                    continue;
                }

                if (entry.getKey().equals("surveyer")) {
                    QueryCondition.AndFilter andFilter = new QueryCondition().new AndFilter();
                    andFilter.setAlias("t");
                    andFilter.setKey(entry.getKey());
                    andFilter.setV(String.valueOf(entryValue).trim());
                    andFilter.setOperatorType(QueryConditionOperatorType.EQUAL);
                    queryCondition.addAddFilter(andFilter);
                    continue;
                }
                // 任务编号
                if (entry.getKey().equals("surveyId")) {
                    QueryCondition.AndFilter andFilter = new QueryCondition().new AndFilter();
                    andFilter.setAlias("t");
                    andFilter.setKey(entry.getKey());
                    andFilter.setV(Long.valueOf(String.valueOf(entryValue).trim()));
                    andFilter.setOperatorType(QueryConditionOperatorType.EQUAL);
                    queryCondition.addAddFilter(andFilter);
                    continue;
                }
                if (entry.getKey().equals("businessNo")) {
                    QueryCondition.AndFilter andFilter = new QueryCondition().new AndFilter();
                    andFilter.setAlias("t");
                    andFilter.setKey(entry.getKey());
                    andFilter.setV(String.valueOf(entryValue).trim());
                    andFilter.setOperatorType(QueryConditionOperatorType.EQUAL);
                    queryCondition.addAddFilter(andFilter);
                    continue;
                }
                if (entry.getKey().equals("product")) {
                    QueryCondition.AndFilter andFilter = new QueryCondition().new AndFilter();
                    andFilter.setAlias("t");
                    andFilter.setKey(entry.getKey());
                    andFilter.setV(String.valueOf(entryValue).trim());
                    andFilter.setOperatorType(QueryConditionOperatorType.EQUAL);
                    queryCondition.addAddFilter(andFilter);
                    continue;
                }
                if (entry.getKey().equals("productCode")) {
                    QueryCondition.AndFilter andFilter = new QueryCondition().new AndFilter();
                    andFilter.setAlias("t");
                    andFilter.setKey(entry.getKey());
                    andFilter.setV(String.valueOf(entryValue).trim());
                    andFilter.setOperatorType(QueryConditionOperatorType.EQUAL);
                    queryCondition.addAddFilter(andFilter);
                    continue;
                }
                if (entry.getKey().equals("makeCom")) {
                    QueryCondition.AndFilter andFilter = new QueryCondition().new AndFilter();
                    andFilter.setAlias("t");
                    andFilter.setKey(entry.getKey());
                    andFilter.setV(String.valueOf(entryValue).trim());
                    andFilter.setOperatorType(QueryConditionOperatorType.EQUAL);
                    queryCondition.addAddFilter(andFilter);
                    continue;
                }
                if (entry.getKey().equals("taskStarterName")) {
                    QueryCondition.AndFilter andFilter = new QueryCondition().new AndFilter();
                    andFilter.setAlias("t");
                    andFilter.setKey(entry.getKey());
                    andFilter.setV(String.valueOf(entryValue).trim());
                    andFilter.setOperatorType(QueryConditionOperatorType.EQUAL);
                    queryCondition.addAddFilter(andFilter);
                    continue;
                }
                if (entry.getKey().equals("applyDept")) {
                    QueryCondition.AndFilter andFilter = new QueryCondition().new AndFilter();
                    andFilter.setAlias("t");
                    andFilter.setKey(entry.getKey());
                    andFilter.setV(String.valueOf(entryValue).trim());
                    andFilter.setOperatorType(QueryConditionOperatorType.EQUAL);
                    queryCondition.addAddFilter(andFilter);
                    continue;
                }
            }

        }
       
    }
}
