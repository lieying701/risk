package com.chinalife.risksurvey.repository.impl;

import org.springframework.stereotype.Repository;

import com.chinalife.base.repository.impl.GPBaseRepositoryImpl;
import com.chinalife.risksurvey.entity.SurveyConstructpartyEO;
import com.chinalife.risksurvey.repository.ISurveyConstructpartyRepository;

/**
 * 工程相关方信息 surveyConstructpartyRepository
 */
@Repository("surveyConstructpartyRepository")
public class SurveyConstructpartyRepositoryImpl extends GPBaseRepositoryImpl<SurveyConstructpartyEO>
        implements ISurveyConstructpartyRepository {

    @Override
    public void insertSurveyConstructparty(SurveyConstructpartyEO surveyConstructpartyEO) {

        this.insert(surveyConstructpartyEO);

    }

}
