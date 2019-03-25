package com.chinalife.risksurvey.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.chinalife.risksurvey.component.ISurveyStationComponent;
import com.chinalife.risksurvey.entity.SurveyStationEO;
import com.chinalife.risksurvey.service.ISurveyStationService;

/**
 * 车站施工风险 surveyStationService
 */
@Service("surveyStationService")
public class SurveyStationServiceImpl implements ISurveyStationService {

    /**
     * surveyStationComponent
     */
    @Autowired
    private ISurveyStationComponent surveyStationComponent;
    
    @Override
    public Object insertOrUpdateSurveyStation(List<SurveyStationEO> surveyStationEO) {
        
        return surveyStationComponent.insertOrUpdateSurveyStation(surveyStationEO);
    }

}
