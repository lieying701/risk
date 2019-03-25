package com.chinalife.risksurvey.service;

import com.chinalife.risksurvey.entity.SurveyGeologyEO;

/**
 * 地质地貌 SurveyGeologyEO
 */
public interface ISurveyGeologyService {

    /**
     * 
     * @param surveyGeologyEO surveyGeologyEO
     * @return Object
     */
    public Object insertOrUpdateSurveyGeology(SurveyGeologyEO surveyGeologyEO);
}
