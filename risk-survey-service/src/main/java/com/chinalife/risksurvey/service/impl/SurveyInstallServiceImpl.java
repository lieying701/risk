package com.chinalife.risksurvey.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.chinalife.risksurvey.component.ISurveyInstallComponent;
import com.chinalife.risksurvey.entity.SurveyInstallEO;
import com.chinalife.risksurvey.service.ISurveyInstallService;

/**
 * 安装试车风险 surveyInstallService
 */
@Service("surveyInstallService")
public class SurveyInstallServiceImpl implements ISurveyInstallService {

    /**
     * surveyInstallComponent
     */
    @Autowired
    private ISurveyInstallComponent surveyInstallComponent;
    
    @Override
    public Object insertOrUpdateSurveyInstall(List<SurveyInstallEO> surveyInstallEO) {
        
        return surveyInstallComponent.insertOrUpdateSurveyInstall(surveyInstallEO);
    }

}
