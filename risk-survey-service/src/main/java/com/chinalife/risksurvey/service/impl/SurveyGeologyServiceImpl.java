package com.chinalife.risksurvey.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.chinalife.risksurvey.component.ISurveyGeologyComponent;
import com.chinalife.risksurvey.entity.SurveyGeologyEO;
import com.chinalife.risksurvey.service.ISurveyGeologyService;

/**
 * surveyGeologyService
 */
@Service("surveyGeologyService")
public class SurveyGeologyServiceImpl implements ISurveyGeologyService {

    /**
     * surveyGeologyComponent
     */
    @Autowired
    private ISurveyGeologyComponent surveyGeologyComponent;

    @Override
    public Object insertOrUpdateSurveyGeology(SurveyGeologyEO surveyGeologyEO) {

        return surveyGeologyComponent.insertOrUpdateSurveyGeology(surveyGeologyEO);
    }

}
