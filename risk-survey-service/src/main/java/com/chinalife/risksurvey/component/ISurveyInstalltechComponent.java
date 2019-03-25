package com.chinalife.risksurvey.component;

import java.util.List;

import com.chinalife.risksurvey.entity.SurveyInstalltechEO;

/**
 * 工艺流程 SurveyInstalltechEO
 */
public interface ISurveyInstalltechComponent {

    /**
     * 
     * @param surveyInstalltechEO surveyInstalltechEO
     * @return Object
     */
    public Object insertOrUpdateSurveyInstalltech(List<SurveyInstalltechEO> surveyInstalltechEO);
}
