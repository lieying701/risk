package com.chinalife.risksurvey.controller;

import java.util.Map;

import com.chinalife.base.controller.IBaseController;
import com.chinalife.base.util.Pagination;

import com.chinalife.risksurvey.component.ISurveyTaskQueryComponent;

import com.chinalife.risksurvey.entity.SurveyTaskEO;

import com.chinalife.risksurvey.repository.ISurveyTaskQueryRepository;

import com.chinalife.risksurvey.service.ISurveyTaskQueryService;


/**   
 * 包名称： com.chinalife.risksurvey.controller 
 * 类名称：ISurveyTaskQueryController<br/>    
 * 类描述：<br/>  
 * @version <br/>   
  
 */  
public interface ISurveyTaskQueryController extends IBaseController<SurveyTaskEO, ISurveyTaskQueryRepository,ISurveyTaskQueryComponent ,ISurveyTaskQueryService> {
    /**
     * @param parameters 條件
     * @param from  页
     * @param limit  数
     * @param sorting  排序
     * @return  EO
     */
    Pagination<SurveyTaskEO> getMyDoingTaskPages(Map<String, Object> parameters, int from, int limit, String sorting);
    
    /** 未分配任务查询
     * @param parameter 条件
     * @param from  页
     * @param limit  数
     * @param sorting  排序
     * @return  mainEO
     */
    public Pagination<SurveyTaskEO> findUnassignrisk(Map<String, Object> parameter, Integer from, Integer limit, String sorting);

}
