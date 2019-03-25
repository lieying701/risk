package com.chinalife.risksurvey.repository;

import com.chinalife.base.repository.IGPBaseRepository;
import com.chinalife.risksurvey.entity.SurveyThirddutyEO;

/**
 * 第三者责任风险 SurveyThirddutyEO
 */
public interface ISurveyThirddutyRepository extends IGPBaseRepository<SurveyThirddutyEO> {

    /**
     * 
     * @param surveyThirddutyEO
     *            surveyThirddutyEO
     */
    public void insertSurveyThirdduty(SurveyThirddutyEO surveyThirddutyEO);
}
