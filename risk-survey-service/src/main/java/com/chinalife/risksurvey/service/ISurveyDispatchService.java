package com.chinalife.risksurvey.service;


import java.util.Map;

import com.chinalife.base.service.IBaseService;
import com.chinalife.risksurvey.component.ISurveyDispatchComponent;
import com.chinalife.risksurvey.entity.SurveyDispatchEO;
import com.chinalife.risksurvey.repository.ISurveyDispatchRepository;

/**   
 * 包名称： com.chinalife.risksurvey.service 
 * 类名称：ISurveyDispatchService<br/>    
 * 类描述：<br/>  
 * @version <br/>   
 *     
 */  
public interface ISurveyDispatchService extends IBaseService<SurveyDispatchEO, ISurveyDispatchRepository,ISurveyDispatchComponent> {
    
    /**  根据surveyId 查询 派工任务
     * @param surveyId surveyId
     * @return SurveyDispatchEO
     */
    public SurveyDispatchEO findBySurveyId(String surveyId);

    /**  提交派工（ 暂时没用）
     * @param parameters parameters
     * @return String
     */
    public String commitDispatch(Map<String, Object> parameters);
    

    

}
