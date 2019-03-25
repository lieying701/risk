package com.chinalife.risksurvey.component.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.chinalife.risksurvey.component.ISurveyConstructpartyComponent;
import com.chinalife.risksurvey.entity.SurveyConstructpartyEO;
import com.chinalife.risksurvey.repository.ISurveyConstructpartyRepository;

/**
 * 工程相关方信息 surveyConstructpartyComponent
 */
@Component("surveyConstructpartyComponent")
public class SurveyConstructpartyComponentImpl implements ISurveyConstructpartyComponent {

    /**
     * surveyConstructpartyRepository
     */
    @Autowired
    private ISurveyConstructpartyRepository surveyConstructpartyRepository;
    
    @Override
    public Object insertOrUpdateSurveyConstructparty(SurveyConstructpartyEO surveyConstructpartyEO) {
        surveyConstructpartyRepository.insertOrUpdate(surveyConstructpartyEO);
        
        return "success";
    }

}
