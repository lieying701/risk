package com.chinalife.risksurvey.component;

import java.util.Map;

import com.chinalife.base.component.IBaseComponent;
import com.chinalife.risksurvey.entity.SurveyRelBusinessEO;
import com.chinalife.risksurvey.repository.ISurveyRelBusinessRepository;

/**
 * component
 * 包名称： com.chinalife.risksurvey.component 
 */
public interface ISurveyRelBusinessComponent extends IBaseComponent<SurveyRelBusinessEO, ISurveyRelBusinessRepository> {
    
    /**
     * 
     * @param surveyRelBusinessEO surveyRelBusinessEO
     * @return Object
     */
    public Object insertOrUpdateSurveyRelBusiness(SurveyRelBusinessEO surveyRelBusinessEO);


    /**
     * @param bussinessNo bussinessNo
     * @return Map
     */ 
    public Map<String, Object> findSurveyIdExist(String bussinessNo);

    /**
     * @param surveyId surveyId
     * @return  SurveyRelBusinessEO
     */
    public SurveyRelBusinessEO findLastSurveyRelBusinessEOBySurveyId(String surveyId);

    
    /**
     * 
     * @param surveyRelBusinessEO surveyRelBusinessEO
     * @return Object
     */
    public Object updateSurveyRelBusiness(SurveyRelBusinessEO surveyRelBusinessEO);

}
