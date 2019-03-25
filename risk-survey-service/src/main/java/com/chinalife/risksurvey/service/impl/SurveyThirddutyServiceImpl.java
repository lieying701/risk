package com.chinalife.risksurvey.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.chinalife.risksurvey.component.ISurveyThirddutyComponent;
import com.chinalife.risksurvey.entity.SurveyThirddutyEO;
import com.chinalife.risksurvey.service.ISurveyThirddutyService;

/**
 * 第三方责任风险 surveyThirddutyService
 */
@Service("surveyThirddutyService")
public class SurveyThirddutyServiceImpl implements ISurveyThirddutyService {

    /**
     * surveyThirddutyComponent
     */
    @Autowired
    private ISurveyThirddutyComponent surveyThirddutyComponent;
    
    @Override
    public Object insertOrUpdateSurveyThirdduty(List<SurveyThirddutyEO> surveyThirddutyEO) {
        
        return surveyThirddutyComponent.insertOrUpdateSurveyThirdduty(surveyThirddutyEO);
    }

}
