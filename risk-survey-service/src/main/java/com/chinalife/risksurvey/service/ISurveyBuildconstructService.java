package com.chinalife.risksurvey.service;

import java.util.List;

import com.chinalife.risksurvey.entity.SurveyBuildconstructEO;

/**
 * 楼宇工程风险 SurveyBuildconstructEO
 */
public interface ISurveyBuildconstructService {

    /**
     * 
     * @param surveyBuildconstructEO
     *            surveyBuildconstructEO
     * @return Object
     */
    public Object insertOrUpdateSurveyBuildconstruct(List<SurveyBuildconstructEO> surveyBuildconstructEO);
}
