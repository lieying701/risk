package com.chinalife.risksurvey.repository.impl;

import org.springframework.stereotype.Repository;

import com.chinalife.base.repository.impl.GPBaseRepositoryImpl;
import com.chinalife.risksurvey.entity.SurveyBuildconstructEO;
import com.chinalife.risksurvey.repository.ISurveyBuildconstructRepository;

/**
 * 楼宇工程风险 surveyBuildconstructRepository
 */
@Repository("surveyBuildconstructRepository")
public class SurveyBuildconstructRepositoryImpl extends GPBaseRepositoryImpl<SurveyBuildconstructEO>
        implements ISurveyBuildconstructRepository {

    @Override
    public void insertSurveyBuildconstruct(SurveyBuildconstructEO surveyBuildconstructEO) {
        
        this.insert(surveyBuildconstructEO);
    }

}
