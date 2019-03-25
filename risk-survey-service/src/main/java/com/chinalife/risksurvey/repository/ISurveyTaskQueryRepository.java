package com.chinalife.risksurvey.repository;

import java.util.Map;

import com.chinalife.base.repository.IGPBaseRepository;
import com.chinalife.base.util.Pagination;

import com.chinalife.risksurvey.entity.SurveyTaskEO;

import com.chinalife.risksurvey.utils.QueryCondition;


/**   
 * 包名称： com.chinalife.risksurvey.repository 
 * 类名称：ISurveyTaskQueryRepository<br/>    
 * 类描述：<br/>  
 * @version <br/>   

 */  
public interface ISurveyTaskQueryRepository extends IGPBaseRepository<SurveyTaskEO> {

    /**
     * @param parameters
     *            parameters
     * @param queryCondition
     *            queryCondition
     * @param from 
     *            from
     * @param limit
     *            limit
     * @return SurveyTaskEO
     */
    public Pagination<SurveyTaskEO> findSurveyTask(Map<String, Object> parameters,
            QueryCondition queryCondition, Integer from, Integer limit);

    /**
     * @param parameter parameter
     * @param queryCondition queryCondition
     * @param from  from
     * @param limit limit
     * @return SurveyTaskEO
     */
    public Pagination<SurveyTaskEO> listSurveyMains(Map<String, Object> parameter,
            QueryCondition queryCondition, Integer from, Integer limit);


}
