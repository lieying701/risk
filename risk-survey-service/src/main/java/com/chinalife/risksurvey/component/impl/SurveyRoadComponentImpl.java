package com.chinalife.risksurvey.component.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.chinalife.risksurvey.component.ISurveyRoadComponent;
import com.chinalife.risksurvey.entity.SurveyRoadEO;
import com.chinalife.risksurvey.repository.ISurveyRoadRepository;

/**
 * 道路施工风险 surveyRoadComponent
 */
@Component("surveyRoadComponent")
public class SurveyRoadComponentImpl implements ISurveyRoadComponent {

    /**
     * surveyRoadRepository
     */
    @Autowired
    private ISurveyRoadRepository surveyRoadRepository;
    
    @Override
    public Object insertOrUpdateSurveyRoad(List<SurveyRoadEO> surveyRoadEO) {
        surveyRoadRepository.insertOrUpdateAll(surveyRoadEO);
        
        return "success";
    }

}
