package com.chinalife.risksurvey.service;

import java.util.List;

import com.chinalife.risksurvey.entity.SurveyTunnelEO;

/**
 * 隧道施工风险 SurveyTunnelEO
 */
public interface ISurveyTunnelService {

    /**
     * 
     * @param surveyTunnelEO surveyTunnelEO
     * @return Object
     */
    public Object insertOrUpdateSurveyTunnel(List<SurveyTunnelEO> surveyTunnelEO);
}
