package com.chinalife.risksurvey.service;

import java.util.List;

import com.chinalife.risksurvey.entity.SurveyStationEO;

/**
 * 车站施工风险 SurveyStationEO
 */
public interface ISurveyStationService {

    /**
     * 
     * @param surveyStationEO surveyStationEO
     * @return Object
     */
    public Object insertOrUpdateSurveyStation(List<SurveyStationEO> surveyStationEO);
}
