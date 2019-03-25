package com.chinalife.risksurvey.service;

import com.chinalife.risksurvey.entity.SurveyItemlistEO;

/**
 * 风勘项 SurveyItemlistEO
 */
public interface ISurveyItemlistService {

    /**
     * 
     * @param surveyItemlistEO surveyItemlistEO
     * @return Object
     */
    public Object insertSurveyItemlist(SurveyItemlistEO surveyItemlistEO);
    
    /**
     * 
     * @param surveyItemlistEO surveyItemlistEO
     * @return Object
     */
    public Object updateSurveyItemlist(SurveyItemlistEO surveyItemlistEO);
}
