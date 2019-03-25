package com.chinalife.risksurvey.component.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.chinalife.risksurvey.component.ISurveyClimateComponent;
import com.chinalife.risksurvey.entity.SurveyClimateEO;
import com.chinalife.risksurvey.repository.ISurveyClimateRepository;

/**
 * 气候水文 surveyClimateComponent
 */
@Component("surveyClimateComponent")
public class SurveyClimateComponentImpl implements ISurveyClimateComponent {

    /**
     * surveyClimateRepository
     */
    @Autowired
    private ISurveyClimateRepository surveyClimateRepository;
    
    @Override
    public Object insertOrUpdateSurveyClimate(List<SurveyClimateEO> surveyClimateEO) {
        surveyClimateRepository.insertOrUpdateAll(surveyClimateEO);
        
        return "success";
    }

}
