package com.chinalife.risksurvey.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.chinalife.risksurvey.component.ISurveyBuildconstructComponent;
import com.chinalife.risksurvey.entity.SurveyBuildconstructEO;
import com.chinalife.risksurvey.service.ISurveyBuildconstructService;

/**
 * 楼宇工程风险 surveyBuildconstructService
 */
@Service("surveyBuildconstructService")
public class SurveyBuildconstructServiceImpl implements ISurveyBuildconstructService {

    /**
     * surveyBuildconstructComponent
     */
    @Autowired
    private ISurveyBuildconstructComponent surveyBuildconstructComponent;
    
    @Override
    public Object insertOrUpdateSurveyBuildconstruct(List<SurveyBuildconstructEO> surveyBuildconstructEO) {
        
        return surveyBuildconstructComponent.insertOrUpdateSurveyBuildconstruct(surveyBuildconstructEO);
    }

}
