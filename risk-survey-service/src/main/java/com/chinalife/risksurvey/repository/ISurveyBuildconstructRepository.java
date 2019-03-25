package com.chinalife.risksurvey.repository;

import com.chinalife.base.repository.IGPBaseRepository;
import com.chinalife.risksurvey.entity.SurveyBuildconstructEO;

/**
 * 楼宇工程风险 SurveyBuildconstructEO
 */
public interface ISurveyBuildconstructRepository extends IGPBaseRepository<SurveyBuildconstructEO> {

    /**
     * 
     * @param surveyBuildconstructEO
     *            surveyBuildconstructEO
     */
    public void insertSurveyBuildconstruct(SurveyBuildconstructEO surveyBuildconstructEO);
}
