package com.chinalife.risksurvey.component;

import java.util.List;

import com.chinalife.risksurvey.entity.SurveyInstallliftEO;

/**
 * 吊装工程 SurveyInstallliftEO
 */
public interface ISurveyInstallliftComponent {

    /**
     * 
     * @param surveyInstallliftEO surveyInstallliftEO
     * @return Object
     */
    public Object insertOrUpdateSurveyInstalllift(List<SurveyInstallliftEO> surveyInstallliftEO);
}
