package com.chinalife.risksurvey.component;

import com.chinalife.risksurvey.entity.SurveyItemlistEO;

/**
 * 风勘项
 */
public interface ISurveyItemlistComponent {

    /**
     * 
     * @param surveyItemlistEO
     *            surveyItemlistEO
     * @return Object
     */
    public Object insertSurveyItemlist(SurveyItemlistEO surveyItemlistEO);
    
    /**
     * 
     * @param surveyItemlistEO
     *            surveyItemlistEO
     * @return Object
     */
    public Object updateSurveyItemlist(SurveyItemlistEO surveyItemlistEO);
}
