package com.chinalife.risksurvey.component;

import java.util.List;

import com.chinalife.risksurvey.entity.SurveyBridgeEO;

/**
 * 桥梁施工风险 SurveyBridgeEO
 */
public interface ISurveyBridgeComponent {

    /**
     * 
     * @param surveyBridgeEO surveyBridgeEO
     * @return Object
     */
    public  Object insertOrUpdateSurveyBridge(List<SurveyBridgeEO> surveyBridgeEO);
}
