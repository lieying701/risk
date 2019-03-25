package com.chinalife.risksurvey.component.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.chinalife.risksurvey.component.ISurveyBuildconstructComponent;
import com.chinalife.risksurvey.entity.SurveyBuildconstructEO;
import com.chinalife.risksurvey.repository.ISurveyBuildconstructRepository;

/**
 * 楼宇工程风险 surveyBuildconstructComponent
 */
@Component("surveyBuildconstructComponent")
public class SurveyBuildconstructComponentImpl implements ISurveyBuildconstructComponent {

    /**
     * surveyBuildconstructRepository
     */
    @Autowired
    private ISurveyBuildconstructRepository surveyBuildconstructRepository;

    @Override
    public Object insertOrUpdateSurveyBuildconstruct(List<SurveyBuildconstructEO> surveyBuildconstructEO) {
        surveyBuildconstructRepository.insertOrUpdateAll(surveyBuildconstructEO);
        
        return "success";
    }

}
