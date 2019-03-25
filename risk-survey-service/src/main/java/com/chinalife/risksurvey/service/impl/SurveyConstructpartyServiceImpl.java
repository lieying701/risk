package com.chinalife.risksurvey.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.chinalife.risksurvey.component.ISurveyConstructpartyComponent;
import com.chinalife.risksurvey.entity.SurveyConstructpartyEO;
import com.chinalife.risksurvey.service.ISurveyConstructpartyService;

/**
 * surveyConstructpartyService
 */
@Service("surveyConstructpartyService")
public class SurveyConstructpartyServiceImpl implements ISurveyConstructpartyService {

    /**
     * surveyConstructpartyComponent
     */
    @Autowired
    private ISurveyConstructpartyComponent surveyConstructpartyComponent;
    
    @Override
    public Object insertOrUpdateSurveyConstructparty(SurveyConstructpartyEO surveyConstructpartyEO) {
        
        return surveyConstructpartyComponent.insertOrUpdateSurveyConstructparty(surveyConstructpartyEO);
    }

}
