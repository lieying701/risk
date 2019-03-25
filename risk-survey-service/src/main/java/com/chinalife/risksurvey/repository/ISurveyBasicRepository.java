package com.chinalife.risksurvey.repository;

import com.chinalife.base.repository.IGPBaseRepository;
import com.chinalife.risksurvey.entity.SurveyBasicEO;

/**
 * 风险评价 SurveyBasicEO
 */
public interface ISurveyBasicRepository extends IGPBaseRepository<SurveyBasicEO> {

    /**
     * 
     * @param surveyBasicEO
     *            surveyBasicEO
     */
    public void insertSurveyBasic(SurveyBasicEO surveyBasicEO);
}
