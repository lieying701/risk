package com.chinalife.risksurvey.component;

import java.util.List;

import com.chinalife.risksurvey.entity.SurveyInstallequipEO;

/**
 * 主要设备生产线情况 SurveyInstallequipEO
 */
public interface ISurveyInstallequipComponent {

    /**
     * 
     * @param surveyInstallequipEO surveyInstallequipEO
     * @return Object
     */
    public Object insertOrUpdateSurveyInstallequip(List<SurveyInstallequipEO> surveyInstallequipEO);
}
