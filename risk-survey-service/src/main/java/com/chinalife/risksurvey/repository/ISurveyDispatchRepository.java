package com.chinalife.risksurvey.repository;

import com.chinalife.base.repository.IGPBaseRepository;
import com.chinalife.risksurvey.entity.SurveyDispatchEO;

/**   
 * 包名称： com.chinalife.risksurvey.repository 
 * 类名称：ISurveyDispatchRepository<br/>    
 * 类描述：<br/>  
 * @version <br/>   
 *   
 */  
public interface ISurveyDispatchRepository extends IGPBaseRepository<SurveyDispatchEO> {
    
    /**
     * @param surveyId
     *            SurveyId
     * @return SurveyDispatchEO
     */
    public SurveyDispatchEO findBySurveyId(String surveyId);

  
    /**
     * @param surveyDispatchEO surveyDispatchEO
     */
    public void insertSurveyDispatchEO(SurveyDispatchEO surveyDispatchEO);
    
    /**
     * @param surveyDispatchEO surveyDispatchEO
     */
    public void updateSurveyDispatchEO(SurveyDispatchEO surveyDispatchEO);
}
