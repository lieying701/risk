package com.chinalife.risksurvey.service;

import java.util.List;

import com.chinalife.risksurvey.entity.SurveyInstallequipEO;

/**
 * 主要设备生产线 SurveyInstallequipEO
 */
public interface ISurveyInstallequipService {

    /**
     * 
     * @param surveyInstallequipEO surveyInstallequipEO
     * @return Object
     */
    public Object insertOrUpdateSurveyInstallequip(List<SurveyInstallequipEO> surveyInstallequipEO);
}
