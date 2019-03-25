package com.chinalife.risksurvey.component.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.chinalife.risksurvey.component.ISurveyInstallliftComponent;
import com.chinalife.risksurvey.entity.SurveyInstallliftEO;
import com.chinalife.risksurvey.repository.ISurveyInstallliftRepository;

/**
 * 吊装工程情况 surveyInstallliftComponent
 */
@Component("surveyInstallliftComponent")
public class SurveyInstallliftComponentImpl implements ISurveyInstallliftComponent {

    /**
     * surveyInstallliftRepository
     */
    @Autowired
    private ISurveyInstallliftRepository surveyInstallliftRepository;
    
    @Override
    public Object insertOrUpdateSurveyInstalllift(List<SurveyInstallliftEO> surveyInstallliftEO) {
        surveyInstallliftRepository.insertOrUpdateAll(surveyInstallliftEO);
        
        return "success";
    }

}
