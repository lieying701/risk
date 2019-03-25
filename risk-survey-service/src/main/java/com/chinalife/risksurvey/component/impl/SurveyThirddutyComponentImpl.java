package com.chinalife.risksurvey.component.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.chinalife.risksurvey.component.ISurveyThirddutyComponent;
import com.chinalife.risksurvey.entity.SurveyThirddutyEO;
import com.chinalife.risksurvey.repository.ISurveyThirddutyRepository;

/**
 * 第三者责任风险
 */
@Component("surveyThirddutyComponent")
public class SurveyThirddutyComponentImpl implements ISurveyThirddutyComponent {

    /**
     * surveyThirddutyRepository
     */
    @Autowired
    private ISurveyThirddutyRepository surveyThirddutyRepository;

    @Override
    public Object insertOrUpdateSurveyThirdduty(List<SurveyThirddutyEO> surveyThirddutyEO) {
        surveyThirddutyRepository.insertOrUpdateAll(surveyThirddutyEO);
        
        return "success";  
    }
}
