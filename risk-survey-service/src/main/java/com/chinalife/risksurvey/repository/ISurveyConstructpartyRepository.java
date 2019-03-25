package com.chinalife.risksurvey.repository;

import com.chinalife.base.repository.IGPBaseRepository;
import com.chinalife.risksurvey.entity.SurveyConstructpartyEO;

/**
 * 工程相关方信息 SurveyConstructpartyEO
 */
public interface ISurveyConstructpartyRepository extends IGPBaseRepository<SurveyConstructpartyEO> {

    /**
     * 
     * @param surveyConstructpartyEO
     *            surveyConstructpartyEO
     */
    public void insertSurveyConstructparty(SurveyConstructpartyEO surveyConstructpartyEO);
}
