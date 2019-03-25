package com.chinalife.risksurvey.service;

import java.util.List;

import com.chinalife.risksurvey.entity.SurveyInstallliftEO;

/**
 * 吊装工程 SurveyInstallliftEO
 */
public interface ISurveyInstallliftService {

    /**
     * 
     * @param surveyInstallliftEO surveyInstallliftEO
     * @return Object
     */
    public Object insertOrUpdateSurveyInstalllift(List<SurveyInstallliftEO> surveyInstallliftEO);
}
