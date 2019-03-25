package com.chinalife.risksurvey.repository.impl;

import org.springframework.stereotype.Repository;

import com.chinalife.base.repository.impl.GPBaseRepositoryImpl;
import com.chinalife.risksurvey.entity.SurveyConstructbasicEO;
import com.chinalife.risksurvey.repository.ISurveyConstructbasicRepository;

/**
 * 工程险基本信息 surveyConstructbasicRepository
 */
@Repository("surveyConstructbasicRepository")
public class SurveyConstructbasicRepositoryImpl extends GPBaseRepositoryImpl<SurveyConstructbasicEO>
        implements ISurveyConstructbasicRepository {

    @Override
    public void insertSurveyConstructbasic(SurveyConstructbasicEO surveyConstructbasicEO) {

        this.insert(surveyConstructbasicEO);
    }

}
