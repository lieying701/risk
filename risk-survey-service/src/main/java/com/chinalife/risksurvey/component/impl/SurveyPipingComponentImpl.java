package com.chinalife.risksurvey.component.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.chinalife.risksurvey.component.ISurveyPipingComponent;
import com.chinalife.risksurvey.entity.SurveyPipingEO;
import com.chinalife.risksurvey.repository.ISurveyPipingRepository;

/**
 * 管道施工风险 surveyPipingComponent
 */
@Component("surveyPipingComponent")
public class SurveyPipingComponentImpl implements ISurveyPipingComponent {

    /**
     * surveyPipingRepository
     */
    @Autowired
    private ISurveyPipingRepository surveyPipingRepository;
    
    @Override
    public Object insertOrUpdateSurveyPiping(List<SurveyPipingEO> surveyPipingEO) {
        surveyPipingRepository.insertOrUpdateAll(surveyPipingEO);
        
        return "success";
    }

}
