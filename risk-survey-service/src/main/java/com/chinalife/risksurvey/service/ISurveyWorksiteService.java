package com.chinalife.risksurvey.service;

import com.chinalife.risksurvey.entity.SurveyWorksiteEO;

/**
 * 工地概况 SurveyWorksiteEO
 */
public interface ISurveyWorksiteService {

    /**
     * 
     * @param surveyWorksiteEO
     *            surveyWorksiteEO
     * @return Object
     */
    public Object insertOrUpdateSurveyWorksite(SurveyWorksiteEO surveyWorksiteEO);
}
