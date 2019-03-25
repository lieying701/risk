package com.chinalife.risksurvey.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.chinalife.risksurvey.component.ISurveyInstallliftComponent;
import com.chinalife.risksurvey.entity.SurveyInstallliftEO;
import com.chinalife.risksurvey.service.ISurveyInstallliftService;

/**
 * 吊装工程 surveyInstallliftService
 */
@Service("surveyInstallliftService")
public class SurveyInstallliftServiceImpl implements ISurveyInstallliftService {

    /**
     * surveyInstallliftComponent
     */
    @Autowired
    private ISurveyInstallliftComponent surveyInstallliftComponent;
    
    @Override
    public Object insertOrUpdateSurveyInstalllift(List<SurveyInstallliftEO> surveyInstallliftEO) {
        
        return surveyInstallliftComponent.insertOrUpdateSurveyInstalllift(surveyInstallliftEO);
    }

}
