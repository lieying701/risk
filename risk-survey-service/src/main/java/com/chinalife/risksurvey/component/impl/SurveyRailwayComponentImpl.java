package com.chinalife.risksurvey.component.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.chinalife.risksurvey.component.ISurveyRailwayComponent;
import com.chinalife.risksurvey.entity.SurveyRailwayEO;
import com.chinalife.risksurvey.repository.ISurveyRailwayRepository;

/**
 * 公路铁路工程风险 surveyRailwayComponent
 */
@Component("surveyRailwayComponent")
public class SurveyRailwayComponentImpl implements ISurveyRailwayComponent {

    /**
     * surveyRailwayRepository
     */
    @Autowired
    private ISurveyRailwayRepository surveyRailwayRepository;
    
    @Override
    public Object insertOrUpdateSurveyRailway(List<SurveyRailwayEO> surveyRailwayEO) {
        surveyRailwayRepository.insertOrUpdateAll(surveyRailwayEO);
        
        return "success";
    }

}
