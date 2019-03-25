package com.chinalife.risksurvey.component;

import java.util.List;

import com.chinalife.risksurvey.entity.SurveyBuildconstructEO;

/**
 * 楼宇工程风险 SurveyBuildconstructEO
 */
public interface ISurveyBuildconstructComponent {

    /**
     * 
     * @param surveyBuildconstructEO
     *            surveyBuildconstructEO
     * @return Object
     */
    public Object insertOrUpdateSurveyBuildconstruct(List<SurveyBuildconstructEO> surveyBuildconstructEO);
}
