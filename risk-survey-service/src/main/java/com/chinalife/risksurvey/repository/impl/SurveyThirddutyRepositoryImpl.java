package com.chinalife.risksurvey.repository.impl;

import org.springframework.stereotype.Repository;

import com.chinalife.base.repository.impl.GPBaseRepositoryImpl;
import com.chinalife.risksurvey.entity.SurveyThirddutyEO;
import com.chinalife.risksurvey.repository.ISurveyThirddutyRepository;

/**
 * 第三者责任风险 surveyThirddutyRepository
 */
@Repository("surveyThirddutyRepository")
public class SurveyThirddutyRepositoryImpl extends GPBaseRepositoryImpl<SurveyThirddutyEO>
        implements ISurveyThirddutyRepository {

    @Override
    public void insertSurveyThirdduty(SurveyThirddutyEO surveyThirddutyEO) {
       
        this.insert(surveyThirddutyEO);
        
    }

}
