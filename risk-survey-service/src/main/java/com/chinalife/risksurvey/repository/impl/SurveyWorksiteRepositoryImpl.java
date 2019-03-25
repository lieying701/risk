package com.chinalife.risksurvey.repository.impl;

import org.springframework.stereotype.Repository;

import com.chinalife.base.repository.impl.GPBaseRepositoryImpl;
import com.chinalife.risksurvey.entity.SurveyWorksiteEO;
import com.chinalife.risksurvey.repository.ISurveyWorksiteRepository;

/**
 * surveyWorksiteRepository 工地概况
 */
@Repository("surveyWorksiteRepository")
public class SurveyWorksiteRepositoryImpl extends GPBaseRepositoryImpl<SurveyWorksiteEO>
        implements ISurveyWorksiteRepository {

    @Override
    public void insertSurveyWorksite(SurveyWorksiteEO surveyWorksiteEO) {

        this.insert(surveyWorksiteEO);

    }

}
