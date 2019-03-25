package com.chinalife.risksurvey.component.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.chinalife.risksurvey.component.ISurveyBasicComponent;
import com.chinalife.risksurvey.entity.SurveyBasicEO;
import com.chinalife.risksurvey.repository.ISurveyBasicRepository;

/**
 * 风险评价 surveyBasicComponent
 */
@Component("surveyBasicComponent")
public class SurveyBasicComponentImpl implements ISurveyBasicComponent {

    /**
     * surveyBasicRepository
     */
    @Autowired
    private ISurveyBasicRepository surveyBasicRepository;
    
    @Override
    public Object insertOrUpdateSurveyBasic(SurveyBasicEO surveyBasicEO) {
        surveyBasicRepository.insertOrUpdate(surveyBasicEO);
        
        return "success";
    }

}
