package com.chinalife.risksurvey.component;

import com.chinalife.risksurvey.entity.SurveySecurityEO;

/**
 * 保安状况 SurveySecurityEO
 */
public interface ISurveySecurityComponent {

    /**
     * 
     * @param surveySecurityEO surveySecurityEO
     * @return Object
     */
    public Object insertOrUpdateSurveySecurity(SurveySecurityEO surveySecurityEO);
}
