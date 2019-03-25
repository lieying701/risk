package com.chinalife.risksurvey.component;

import java.util.List;

import com.chinalife.risksurvey.entity.SurveyTunnelEO;

/**
 * 隧道施工风险 SurveyTunnelEO
 */
public interface ISurveyTunnelComponent {

    /**
     * 
     * @param surveyTunnelEO surveyTunnelEO
     * @return Object
     */
    public Object insertOrUpdateSurveyTunnel(List<SurveyTunnelEO> surveyTunnelEO);
}
