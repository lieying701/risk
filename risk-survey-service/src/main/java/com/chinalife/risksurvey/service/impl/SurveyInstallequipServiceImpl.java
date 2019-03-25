package com.chinalife.risksurvey.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.chinalife.risksurvey.component.ISurveyInstallequipComponent;
import com.chinalife.risksurvey.entity.SurveyInstallequipEO;
import com.chinalife.risksurvey.service.ISurveyInstallequipService;

/**
 * 主要设备生产线 surveyInstallequipService
 */
@Service("surveyInstallequipService")
public class SurveyInstallequipServiceImpl implements ISurveyInstallequipService {

    /**
     * surveyInstallequipComponent
     */
    @Autowired
    private ISurveyInstallequipComponent surveyInstallequipComponent;
    
    @Override
    public Object insertOrUpdateSurveyInstallequip(List<SurveyInstallequipEO> surveyInstallequipEO) {
        
        return surveyInstallequipComponent.insertOrUpdateSurveyInstallequip(surveyInstallequipEO);
    }

}
