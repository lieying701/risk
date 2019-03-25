package com.chinalife.risksurvey.component.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.chinalife.risksurvey.component.ISurveyInstallequipComponent;
import com.chinalife.risksurvey.entity.SurveyInstallequipEO;
import com.chinalife.risksurvey.repository.ISurveyInstallequipRepository;

/**
 * 主要设备生产线 surveyInstallequipComponent
 */
@Component("surveyInstallequipComponent")
public class SurveyInstallequipComponentImpl implements ISurveyInstallequipComponent {

    /**
     * surveyInstallequipRepository
     */
    @Autowired
    private ISurveyInstallequipRepository surveyInstallequipRepository;
    
    @Override
    public Object insertOrUpdateSurveyInstallequip(List<SurveyInstallequipEO> surveyInstallequipEO) {
        surveyInstallequipRepository.insertOrUpdateAll(surveyInstallequipEO);
        
        return "success";
    }

}
