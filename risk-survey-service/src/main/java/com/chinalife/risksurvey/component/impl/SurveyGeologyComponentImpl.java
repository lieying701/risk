package com.chinalife.risksurvey.component.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.chinalife.risksurvey.component.ISurveyGeologyComponent;
import com.chinalife.risksurvey.entity.SurveyGeologyEO;
import com.chinalife.risksurvey.repository.ISurveyGeologyRepository;

/**
 * 地址地貌信息 surveyGeologyComponent
 */
@Component("surveyGeologyComponent")
public class SurveyGeologyComponentImpl implements ISurveyGeologyComponent {

    /**
     * surveyGeologyRepository
     */
    @Autowired
    private ISurveyGeologyRepository surveyGeologyRepository;

    @Override
    public Object insertOrUpdateSurveyGeology(SurveyGeologyEO surveyGeologyEO) {
        surveyGeologyRepository.insertOrUpdate(surveyGeologyEO);
        
        return "success";
    }

}
