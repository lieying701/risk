package com.chinalife.risksurvey.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.chinalife.risksurvey.component.ISurveyItemlistComponent;
import com.chinalife.risksurvey.entity.SurveyItemlistEO;
import com.chinalife.risksurvey.service.ISurveyItemlistService;

/**
 * 风勘项 surveyItemlistService
 */
@Service("surveyItemlistService")
public class SurveyItemlistServiceImpl implements ISurveyItemlistService {

    /**
     * surveyItemlistComponent
     */
    @Autowired
    private ISurveyItemlistComponent surveyItemlistComponent;
    
    @Override
    public Object insertSurveyItemlist(SurveyItemlistEO surveyItemlistEO) {
        
        return surveyItemlistComponent.insertSurveyItemlist(surveyItemlistEO);
    }

    @Override
    public Object updateSurveyItemlist(SurveyItemlistEO surveyItemlistEO) {
        surveyItemlistComponent.updateSurveyItemlist(surveyItemlistEO);
        
        return "itemlist";
    }

}
