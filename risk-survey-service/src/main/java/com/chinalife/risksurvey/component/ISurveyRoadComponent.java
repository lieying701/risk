package com.chinalife.risksurvey.component;

import java.util.List;

import com.chinalife.risksurvey.entity.SurveyRoadEO;

/**
 * 道路施工风险 SurveyRoadEO
 */
public interface ISurveyRoadComponent {

    /**
     * 
     * @param surveyRoadEO surveyRoadEO
     * @return Object
     */
    public Object insertOrUpdateSurveyRoad(List<SurveyRoadEO> surveyRoadEO);
}
