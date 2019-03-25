package com.chinalife.risksurvey.service;

import java.util.List;

import com.chinalife.risksurvey.entity.SurveyClimateEO;

/**
 * 气候水文 SurveyClimateEO
 */
public interface ISurveyClimateService {

    /**
     * 
     * @param surveyClimateEO surveyClimateEO
     * @return Object
     */
    public Object insertOrUpdateSurveyClimate(List<SurveyClimateEO> surveyClimateEO);
}
