package com.chinalife.risksurvey.repository;

import com.chinalife.base.repository.IGPBaseRepository;
import com.chinalife.risksurvey.entity.SurveyConstructbasicEO;

/**
 * 工程险基本信息 SurveyConstructbasicEO
 */
public interface ISurveyConstructbasicRepository extends IGPBaseRepository<SurveyConstructbasicEO> {
    /**
     * 
     * @param surveyConstructbasicEO
     *            surveyConstructbasicEO
     */
    public void insertSurveyConstructbasic(SurveyConstructbasicEO surveyConstructbasicEO);

}
