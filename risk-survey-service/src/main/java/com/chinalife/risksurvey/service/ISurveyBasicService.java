package com.chinalife.risksurvey.service;

import com.chinalife.risksurvey.entity.SurveyBasicEO;
import com.chinalife.risksurvey.vo.RiskSurveyVo;

/**
 * {@link RiskSurveyVo}
 */
public interface ISurveyBasicService {

    /**
     * 
     * @param riskSurveyVo
     *            riskSurveyVo
     * @return Object
     */
    public Object riskSurvey(RiskSurveyVo riskSurveyVo);
    
    /**
     * 
     * @param surveyBasicEO surveyBasicEO
     * @return Object
     */
    public Object insertOrUpdateSurveyBasic(SurveyBasicEO surveyBasicEO);
}
