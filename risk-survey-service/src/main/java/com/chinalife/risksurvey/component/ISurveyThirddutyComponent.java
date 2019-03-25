package com.chinalife.risksurvey.component;

import java.util.List;

import com.chinalife.risksurvey.entity.SurveyThirddutyEO;

/**
 * 第三者责任风险 SurveyThirddutyEO
 */
public interface ISurveyThirddutyComponent {

    /**
     * 
     * @param surveyThirddutyEO
     *            surveyThirddutyEO
     * @return Object
     */
    public Object insertOrUpdateSurveyThirdduty(List<SurveyThirddutyEO> surveyThirddutyEO);
}
