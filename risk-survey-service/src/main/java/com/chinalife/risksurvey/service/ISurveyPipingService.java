package com.chinalife.risksurvey.service;

import java.util.List;

import com.chinalife.risksurvey.entity.SurveyPipingEO;

/**
 * 管道施工风险 SurveyPipingEO
 */
public interface ISurveyPipingService {

    /**
     * 
     * @param surveyPipingEO surveyPipingEO
     * @return Object
     */
    public Object insertOrUpdateSurveyPiping(List<SurveyPipingEO> surveyPipingEO);
}
