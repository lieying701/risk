package com.chinalife.risksurvey.repository.impl;

import org.springframework.stereotype.Repository;

import com.chinalife.base.repository.impl.GPBaseRepositoryImpl;
import com.chinalife.risksurvey.entity.SurveyGeologyEO;
import com.chinalife.risksurvey.repository.ISurveyGeologyRepository;

/**
 * 地址地貌信息 surveyGeologyRepository
 */
@Repository("surveyGeologyRepository")
public class SurveyGeologyRepositoryImpl extends GPBaseRepositoryImpl<SurveyGeologyEO>
        implements ISurveyGeologyRepository {

    @Override
    public void insertSurveyGeology(SurveyGeologyEO surveyGeologyEO) {

        this.insert(surveyGeologyEO);

    }

}
