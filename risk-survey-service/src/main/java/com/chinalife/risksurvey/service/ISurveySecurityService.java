package com.chinalife.risksurvey.service;

import com.chinalife.risksurvey.entity.SurveySecurityEO;

/**
 * 保安状况 SurveySecurityEO
 */
public interface ISurveySecurityService {

    /**
     * 
     * @param surveySecurityEO surveySecurityEO
     * @return Object
     */
    public Object insertOrUpdateSurveySecurity(SurveySecurityEO surveySecurityEO);
}
