package com.chinalife.risksurvey.component;

import java.util.List;

import com.chinalife.risksurvey.entity.SurveyInstallEO;

/**
 * 安装试车风险 SurveyInstallEO
 */
public interface ISurveyInstallComponent {

    /**
     * 
     * @param surveyInstallEO surveyInstallEO
     * @return Object
     */
    public Object insertOrUpdateSurveyInstall(List<SurveyInstallEO> surveyInstallEO);
}
