package com.chinalife.risksurvey.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.chinalife.risksurvey.component.ISurveyTunnelComponent;
import com.chinalife.risksurvey.entity.SurveyTunnelEO;
import com.chinalife.risksurvey.service.ISurveyTunnelService;

/**
 * 隧道施工风险 surveyTunnelService
 */
@Service("surveyTunnelService")
public class SurveyTunnelServiceImpl implements ISurveyTunnelService {

    /**
     * surveyTunnelComponent
     */
    @Autowired
    private ISurveyTunnelComponent surveyTunnelComponent;
    
    @Override
    public Object insertOrUpdateSurveyTunnel(List<SurveyTunnelEO> surveyTunnelEO) {
        
        return surveyTunnelComponent.insertOrUpdateSurveyTunnel(surveyTunnelEO);
    }

}
