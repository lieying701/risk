package com.chinalife.risksurvey.service;

import java.util.List;

import com.chinalife.risksurvey.entity.SurveyThirddutyEO;

/**
 * 第三方责任风险 SurveyThirddutyEO
 */
public interface ISurveyThirddutyService {

    /**
     * 
     * @param surveyThirddutyEO surveyThirddutyEO
     * @return Object
     */
    public Object insertOrUpdateSurveyThirdduty(List<SurveyThirddutyEO> surveyThirddutyEO);
}
