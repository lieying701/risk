package com.chinalife.risksurvey.repository;

import com.chinalife.base.repository.IGPBaseRepository;
import com.chinalife.risksurvey.entity.SurveyGeologyEO;

/**
 * 地址地貌信息 SurveyGeologyEO
 */
public interface ISurveyGeologyRepository extends IGPBaseRepository<SurveyGeologyEO> {
    /**
     * 
     * @param surveyGeologyEO
     *            surveyGeologyEO
     */
    public void insertSurveyGeology(SurveyGeologyEO surveyGeologyEO);
}
