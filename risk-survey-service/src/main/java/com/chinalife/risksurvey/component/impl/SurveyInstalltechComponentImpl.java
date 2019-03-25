package com.chinalife.risksurvey.component.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.chinalife.risksurvey.component.ISurveyInstalltechComponent;
import com.chinalife.risksurvey.entity.SurveyInstalltechEO;
import com.chinalife.risksurvey.repository.ISurveyInstalltechRepository;

/**
 * 工艺流程 surveyInstalltechComponent
 */
@Component("surveyInstalltechComponent")
public class SurveyInstalltechComponentImpl implements ISurveyInstalltechComponent {

    /**
     * surveyInstalltechRepository
     */
    @Autowired
    private ISurveyInstalltechRepository surveyInstalltechRepository;
    
    @Override
    public Object insertOrUpdateSurveyInstalltech(List<SurveyInstalltechEO> surveyInstalltechEO) {
        surveyInstalltechRepository.insertOrUpdateAll(surveyInstalltechEO);
        
        return "success";
    }

}
