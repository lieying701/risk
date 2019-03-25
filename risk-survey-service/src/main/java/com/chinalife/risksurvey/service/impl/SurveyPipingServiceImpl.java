package com.chinalife.risksurvey.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.chinalife.risksurvey.component.ISurveyPipingComponent;
import com.chinalife.risksurvey.entity.SurveyPipingEO;
import com.chinalife.risksurvey.service.ISurveyPipingService;

/**
 * 管道施工风险 surveyPipingService
 */
@Service("surveyPipingService")
public class SurveyPipingServiceImpl implements ISurveyPipingService {

    /**
     * surveyPipingComponent
     */
    @Autowired
    private ISurveyPipingComponent surveyPipingComponent;
    
    @Override
    public Object insertOrUpdateSurveyPiping(List<SurveyPipingEO> surveyPipingEO) {
        
        return surveyPipingComponent.insertOrUpdateSurveyPiping(surveyPipingEO);
    }

}
