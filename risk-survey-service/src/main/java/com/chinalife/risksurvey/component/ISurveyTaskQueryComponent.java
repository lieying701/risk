package com.chinalife.risksurvey.component;

import java.util.Map;

import com.chinalife.base.component.IBaseComponent;

import com.chinalife.base.util.Pagination;
import com.chinalife.risksurvey.entity.SurveyTaskEO;
import com.chinalife.risksurvey.repository.ISurveyTaskQueryRepository;



/**   
 * 包名称： com.chinalife.risksurvey.component 
 * 类名称：ISurveyTaskQueryComponent<br/>    
 * 类描述：<br/>  
 * @version <br/>   
 */  
public interface ISurveyTaskQueryComponent  extends IBaseComponent<SurveyTaskEO, ISurveyTaskQueryRepository> {

    /**
     * 根据条件查询我的代办任务分页列表
     * 
     * @param parameters
     *            parameters
     * @param from
     *            from
     * @param limit
     *            limit
     * @param sorting
     *            sorting
     * @return Pagination
     */
    Pagination<SurveyTaskEO> getMyDoingTaskPages(Map<String, Object> parameters, int from, int limit,
            String sorting);
 
    /**
     * @param parameter  parameter
     * @param from from
     * @param limit limit
     * @param sorting sorting
     * @return surveyTaskEO
     */
    public Pagination<SurveyTaskEO> findUnassignrisk(Map<String, Object> parameter, Integer from, Integer limit,
            String sorting);
}
