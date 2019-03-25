package com.chinalife.risksurvey.component.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.chinalife.risksurvey.component.ISurveyItemlistComponent;
import com.chinalife.risksurvey.entity.SurveyItemlistEO;
import com.chinalife.risksurvey.repository.ISurveyItemlistRepository;

/**
 * 风勘项 surveyItemlistComponent
 */
@Component("surveyItemlistComponent")
public class SurveyItemlistComponentImpl implements ISurveyItemlistComponent {

    /**
     * surveyItemlistRepository
     */
    @Autowired
    private ISurveyItemlistRepository surveyItemlistRepository;
    
    @Override
    public Object insertSurveyItemlist(SurveyItemlistEO surveyItemlistEO) {
        
        return surveyItemlistRepository.insert(surveyItemlistEO);
    }

    @Override
    public Object updateSurveyItemlist(SurveyItemlistEO surveyItemlistEO) {
        surveyItemlistRepository.update(surveyItemlistEO);
        
        return "itemlist";
    }

}
