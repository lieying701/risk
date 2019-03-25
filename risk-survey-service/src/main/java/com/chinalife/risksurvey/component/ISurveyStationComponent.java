package com.chinalife.risksurvey.component;

import java.util.List;

import com.chinalife.risksurvey.entity.SurveyStationEO;

/**
 * 车站施工风险 SurveyStationEO
 */
public interface ISurveyStationComponent {

    /**
     * 
     * @param surveyStationEO surveyStationEO
     * @return Object
     */
    public Object insertOrUpdateSurveyStation(List<SurveyStationEO> surveyStationEO);
}
