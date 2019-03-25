package com.chinalife.risksurvey.component.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.chinalife.risksurvey.component.ISurveyStationComponent;
import com.chinalife.risksurvey.entity.SurveyStationEO;
import com.chinalife.risksurvey.repository.ISurveyStationRepository;

/**
 * 车站施工风险 surveyStationComponent
 */
@Component("surveyStationComponent")
public class SurveyStationComponentImpl implements ISurveyStationComponent {

    /**
     * surveyStationRepository
     */
    @Autowired
    private ISurveyStationRepository surveyStationRepository;
    
    @Override
    public Object insertOrUpdateSurveyStation(List<SurveyStationEO> surveyStationEO) {
        surveyStationRepository.insertOrUpdateAll(surveyStationEO);
        
        return "success";
    }

}
