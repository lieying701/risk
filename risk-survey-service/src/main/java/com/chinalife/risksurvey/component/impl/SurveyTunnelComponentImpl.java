package com.chinalife.risksurvey.component.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.chinalife.risksurvey.component.ISurveyTunnelComponent;
import com.chinalife.risksurvey.entity.SurveyTunnelEO;
import com.chinalife.risksurvey.repository.ISurveyTunnelRepository;

/**
 * 隧道施工风险 surveyTunnelComponent
 */
@Component("surveyTunnelComponent")
public class SurveyTunnelComponentImpl implements ISurveyTunnelComponent {

    /**
     * surveyTunnelRepository
     */
    @Autowired
    private ISurveyTunnelRepository surveyTunnelRepository;
    
    @Override
    public Object insertOrUpdateSurveyTunnel(List<SurveyTunnelEO> surveyTunnelEO) {
        surveyTunnelRepository.insertOrUpdateAll(surveyTunnelEO);
        
        return "success";
    }

}
