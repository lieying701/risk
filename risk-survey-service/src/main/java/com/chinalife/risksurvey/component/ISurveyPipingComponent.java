package com.chinalife.risksurvey.component;

import java.util.List;

import com.chinalife.risksurvey.entity.SurveyPipingEO;

/**
 * 管道施工风险 SurveyPipingEO
 */
public interface ISurveyPipingComponent {

    /**
     * 
     * @param surveyPipingEO surveyPipingEO
     * @return Object
     */
    public Object insertOrUpdateSurveyPiping(List<SurveyPipingEO> surveyPipingEO);
}
