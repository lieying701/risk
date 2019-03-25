package com.chinalife.risksurvey.component.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.chinalife.risksurvey.component.ISurveyBridgeComponent;
import com.chinalife.risksurvey.entity.SurveyBridgeEO;
import com.chinalife.risksurvey.repository.ISurveyBridgeRepository;

/**
 * 桥梁施工风险 surveyBridgeComponent
 */
@Component("surveyBridgeComponent")
public class SurveyBridgeComponentImpl implements ISurveyBridgeComponent {

    /**
     * surveyBridgeRepository
     */
    @Autowired
    private ISurveyBridgeRepository surveyBridgeRepository;
    
    @Override
    public Object insertOrUpdateSurveyBridge(List<SurveyBridgeEO> surveyBridgeEO) {
        surveyBridgeRepository.insertOrUpdateAll(surveyBridgeEO);
        
        return "success";
    }

}
