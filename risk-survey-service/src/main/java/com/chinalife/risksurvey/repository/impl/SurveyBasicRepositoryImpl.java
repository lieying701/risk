package com.chinalife.risksurvey.repository.impl;

import org.springframework.stereotype.Repository;

import com.chinalife.base.repository.impl.GPBaseRepositoryImpl;
import com.chinalife.risksurvey.entity.SurveyBasicEO;
import com.chinalife.risksurvey.repository.ISurveyBasicRepository;

/**
 * 风险评价 surveyBasicRepository
 */
@Repository("surveyBasicRepository")
public class SurveyBasicRepositoryImpl extends GPBaseRepositoryImpl<SurveyBasicEO> implements ISurveyBasicRepository {

    @Override
    public void insertSurveyBasic(SurveyBasicEO surveyBasicEO) {

        this.insert(surveyBasicEO);
    }

}
