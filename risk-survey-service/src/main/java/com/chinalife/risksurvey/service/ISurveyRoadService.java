package com.chinalife.risksurvey.service;

import java.util.List;

import com.chinalife.risksurvey.entity.SurveyRoadEO;


/**
 * 道路施工风险 SurveyRoadEO
 */
public interface ISurveyRoadService {

    /**
     * 
     * @param surveyRoadEO surveyRoadEO
     * @return Object
     */
    public Object insertOrUpdateSurveyRoad(List<SurveyRoadEO> surveyRoadEO);
}
