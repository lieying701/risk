package com.chinalife.risksurvey.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.chinalife.risksurvey.component.ISurveyRoadComponent;
import com.chinalife.risksurvey.entity.SurveyRoadEO;
import com.chinalife.risksurvey.service.ISurveyRoadService;

/**
 * 道路施工风险 surveyRoadService
 */
@Service("surveyRoadService")
public class SurveyRoadServiceImpl implements ISurveyRoadService {

    /**
     * surveyRoadComponent
     */
    @Autowired
    private ISurveyRoadComponent surveyRoadComponent;
    
    @Override
    public Object insertOrUpdateSurveyRoad(List<SurveyRoadEO> surveyRoadEO) {
        
        return surveyRoadComponent.insertOrUpdateSurveyRoad(surveyRoadEO);
    }

}
