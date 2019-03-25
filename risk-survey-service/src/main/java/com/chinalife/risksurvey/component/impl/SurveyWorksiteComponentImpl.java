package com.chinalife.risksurvey.component.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.chinalife.risksurvey.component.ISurveyWorksiteComponent;
import com.chinalife.risksurvey.entity.SurveyWorksiteEO;
import com.chinalife.risksurvey.repository.ISurveyWorksiteRepository;

/**
 * 工地概况 surveyWorksiteComponent
 */
@Component("surveyWorksiteComponent")
public class SurveyWorksiteComponentImpl implements ISurveyWorksiteComponent {

    /**
     * surveyWorksiteRepository
     */
    @Autowired
    private ISurveyWorksiteRepository surveyWorksiteRepository;
    
    @Override
    public Object insertOrUpdateSurveyWorksite(SurveyWorksiteEO surveyWorksiteEO) {
        surveyWorksiteRepository.insertOrUpdate(surveyWorksiteEO);
        
        return "success";
    }

}
