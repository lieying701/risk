package com.chinalife.risksurvey.component.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.chinalife.risksurvey.component.ISurveyConstructbasicComponent;
import com.chinalife.risksurvey.entity.SurveyConstructbasicEO;
import com.chinalife.risksurvey.repository.ISurveyConstructbasicRepository;

/**
 * 工程险基本信息 surveyConstructbasicComponent
 */
@Component("surveyConstructbasicComponent")
public class SurveyConstructbasicComponentImpl implements ISurveyConstructbasicComponent {

    /**
     * surveyConstructbasicRepository
     */
    @Autowired
    private ISurveyConstructbasicRepository surveyConstructbasicRepository;
    
    @Override
    public Object insertOrUpdateSurveyConstructbasic(SurveyConstructbasicEO surveyConstructbasicEO) {
        surveyConstructbasicRepository.insertOrUpdate(surveyConstructbasicEO);
        
        return "success";
    }

}
