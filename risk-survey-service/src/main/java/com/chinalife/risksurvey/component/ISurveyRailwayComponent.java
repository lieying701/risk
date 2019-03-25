package com.chinalife.risksurvey.component;

import java.util.List;

import com.chinalife.risksurvey.entity.SurveyRailwayEO;

/**
 * 公路铁路工程风险 SurveyRailwayEO
 */
public interface ISurveyRailwayComponent {

    /**
     * 
     * @param surveyRailwayEO surveyRailwayEO
     * @return Object
     */
    public Object insertOrUpdateSurveyRailway(List<SurveyRailwayEO> surveyRailwayEO);
}
