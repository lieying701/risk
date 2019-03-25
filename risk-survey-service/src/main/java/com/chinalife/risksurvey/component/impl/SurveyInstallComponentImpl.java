package com.chinalife.risksurvey.component.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.chinalife.risksurvey.component.ISurveyInstallComponent;
import com.chinalife.risksurvey.entity.SurveyInstallEO;
import com.chinalife.risksurvey.repository.ISurveyInstallRepository;

/**
 * 安装试车风险 surveyInstallComponent
 */
@Component("surveyInstallComponent")
public class SurveyInstallComponentImpl implements ISurveyInstallComponent {

    /**
     * surveyInstallRepository
     */
    @Autowired
    private ISurveyInstallRepository surveyInstallRepository;
    
    @Override
    public Object insertOrUpdateSurveyInstall(List<SurveyInstallEO> surveyInstallEO) {
        surveyInstallRepository.insertOrUpdateAll(surveyInstallEO);
        
        return "success";
    }

}
