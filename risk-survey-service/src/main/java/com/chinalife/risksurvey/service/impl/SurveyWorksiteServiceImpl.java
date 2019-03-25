package com.chinalife.risksurvey.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.chinalife.risksurvey.component.ISurveyWorksiteComponent;
import com.chinalife.risksurvey.entity.SurveyWorksiteEO;
import com.chinalife.risksurvey.service.ISurveyWorksiteService;

/**
 * 工地概况 surveyWorksiteService
 */
@Service("surveyWorksiteService")
public class SurveyWorksiteServiceImpl implements ISurveyWorksiteService {

    /**
     * surveyWorksiteComponent
     */
    @Autowired
    private ISurveyWorksiteComponent surveyWorksiteComponent;
    
    @Override
    public Object insertOrUpdateSurveyWorksite(SurveyWorksiteEO surveyWorksiteEO) {
       
        return surveyWorksiteComponent.insertOrUpdateSurveyWorksite(surveyWorksiteEO);
    }

}
