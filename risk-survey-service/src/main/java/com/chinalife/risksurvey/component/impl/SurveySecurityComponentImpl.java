package com.chinalife.risksurvey.component.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.chinalife.risksurvey.component.ISurveySecurityComponent;
import com.chinalife.risksurvey.entity.SurveySecurityEO;
import com.chinalife.risksurvey.repository.ISurveySecurityRepository;

/**
 * 保安状况 surveySecurityComponent
 */
@Component("surveySecurityComponent")
public class SurveySecurityComponentImpl implements ISurveySecurityComponent {

    /**
     * surveySecurityRepository
     */
    @Autowired
    private ISurveySecurityRepository surveySecurityRepository;
    
    @Override
    public Object insertOrUpdateSurveySecurity(SurveySecurityEO surveySecurityEO) {
        surveySecurityRepository.insertOrUpdate(surveySecurityEO);
        
        return "success";
    }

}
