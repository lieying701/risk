package com.chinalife.risksurvey.service;

import java.util.List;

import com.chinalife.risksurvey.entity.SurveyInstalltechEO;

/**
 * 工艺流程 SurveyInstalltechEO
 */
public interface ISurveyInstalltechService {

    /**
     * 
     * @param surveyInstalltechEO surveyInstalltechEO
     * @return Object
     */
    public Object insertOrUpdateSurveyInstalltech(List<SurveyInstalltechEO> surveyInstalltechEO);
}
