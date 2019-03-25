package com.chinalife.risksurvey.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.chinalife.risksurvey.component.ISurveySecurityComponent;
import com.chinalife.risksurvey.entity.SurveySecurityEO;
import com.chinalife.risksurvey.service.ISurveySecurityService;

/**
 * 保安状况 surveySecurityService
 */
@Service("surveySecurityService")
public class SurveySecurityServiceImpl implements ISurveySecurityService {

    /**
     * surveySecurityComponent
     */
    @Autowired
    private ISurveySecurityComponent surveySecurityComponent;
    
    @Override
    public Object insertOrUpdateSurveySecurity(SurveySecurityEO surveySecurityEO) {
        
        return surveySecurityComponent.insertOrUpdateSurveySecurity(surveySecurityEO);
    }

}
