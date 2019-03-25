package com.chinalife.risksurvey.controller;

import java.util.Map;

import com.chinalife.base.controller.IBaseController;
import com.chinalife.risksurvey.component.ISurveyDispatchComponent;

import com.chinalife.risksurvey.entity.SurveyDispatchEO;

import com.chinalife.risksurvey.repository.ISurveyDispatchRepository;

import com.chinalife.risksurvey.service.ISurveyDispatchService;


/**    派工表     
 * 包名称： com.chinalife.risksurvey.controller 
 * 类名称：ISurveyDispatchController<br/>    
 * 类描述：<br/>  
 * @version <br/>   
 * 
 */  
public interface ISurveyDispatchController extends IBaseController<SurveyDispatchEO, ISurveyDispatchRepository,ISurveyDispatchComponent ,ISurveyDispatchService> {

    /**
     * 根据 surveyId 查询 派工任务
     *
     * @param surveyId
     *            SurveyId
     * @return SurveyDispatchEO
     */
    public SurveyDispatchEO findBySurveyId(String surveyId);

    /**
     * 提交派工
     * 
     * @param parameters
     *            parameters
     * @return String
     */
    public String commitDispatch(Map<String, Object> parameters);

}
