package com.chinalife.risksurvey.component;

import java.util.Map;

import com.chinalife.base.component.IBaseComponent;

import com.chinalife.risksurvey.entity.SurveyDispatchEO;
import com.chinalife.risksurvey.repository.ISurveyDispatchRepository;


/**   
 * 包名称： com.chinalife.risksurvey.component 
 * 类名称：ISurveyDispatchComponent<br/>    
 * 类描述：<br/>  
 * @version <br/>   
 *     
 */  
public interface ISurveyDispatchComponent extends IBaseComponent<SurveyDispatchEO, ISurveyDispatchRepository> {

    /**
     * @param surveyId  surveyId
     * @return  SurveyDispatchEO
     */
    public SurveyDispatchEO findBySurveyId(String surveyId);

    /**
     * @param parameters parameters
     * @return String
     */
    public String commitDispatchAll(Map<String, Object> parameters);




}
