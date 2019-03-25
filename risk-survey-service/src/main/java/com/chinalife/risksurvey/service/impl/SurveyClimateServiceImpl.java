package com.chinalife.risksurvey.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.chinalife.risksurvey.component.ISurveyClimateComponent;
import com.chinalife.risksurvey.entity.SurveyClimateEO;
import com.chinalife.risksurvey.service.ISurveyClimateService;

/**
 * 气候水文 surveyClimateService
 */
@Service("surveyClimateService")
public class SurveyClimateServiceImpl implements ISurveyClimateService {

    /**
     * surveyClimateComponent
     */
    @Autowired
    private ISurveyClimateComponent surveyClimateComponent;
    
    @Override
    public Object insertOrUpdateSurveyClimate(List<SurveyClimateEO> surveyClimateEO) {
        
        return surveyClimateComponent.insertOrUpdateSurveyClimate(surveyClimateEO);
    }

}
