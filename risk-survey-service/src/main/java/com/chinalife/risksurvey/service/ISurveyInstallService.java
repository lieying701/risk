package com.chinalife.risksurvey.service;

import java.util.List;

import com.chinalife.risksurvey.entity.SurveyInstallEO;

/**
 * 安装试车风险 SurveyInstallEO
 */
public interface ISurveyInstallService {

    /**
     * 
     * @param surveyInstallEO
     *            surveyInstallEO
     * @return Object
     */
    public Object insertOrUpdateSurveyInstall(List<SurveyInstallEO> surveyInstallEO);
}
