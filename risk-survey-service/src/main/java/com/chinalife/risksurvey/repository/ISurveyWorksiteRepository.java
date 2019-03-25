package com.chinalife.risksurvey.repository;

import com.chinalife.base.repository.IGPBaseRepository;
import com.chinalife.risksurvey.entity.SurveyWorksiteEO;

/**
 * SurveyWorksiteEO 工地概况
 */
public interface ISurveyWorksiteRepository extends IGPBaseRepository<SurveyWorksiteEO> {

    /**
     * 
     * @param surveyWorksiteEO
     *            surveyWorksiteEO
     */
    public void insertSurveyWorksite(SurveyWorksiteEO surveyWorksiteEO);
}
