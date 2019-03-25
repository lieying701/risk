package com.chinalife.risksurvey.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.chinalife.risksurvey.component.ISurveyInstalltechComponent;
import com.chinalife.risksurvey.entity.SurveyInstalltechEO;
import com.chinalife.risksurvey.service.ISurveyInstalltechService;

/**
 * 工艺流程 surveyInstalltechService
 */
@Service("surveyInstalltechService")
public class SurveyInstalltechServiceImpl implements ISurveyInstalltechService {

    /**
     * surveyInstalltechComponent
     */
    @Autowired
    private ISurveyInstalltechComponent surveyInstalltechComponent;
    
    @Override
    public Object insertOrUpdateSurveyInstalltech(List<SurveyInstalltechEO> surveyInstalltechEO) {
        
        return surveyInstalltechComponent.insertOrUpdateSurveyInstalltech(surveyInstalltechEO);
    }

}
