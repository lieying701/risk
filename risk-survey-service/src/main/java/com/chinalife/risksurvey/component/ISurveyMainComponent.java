package com.chinalife.risksurvey.component;

import java.util.Map;

import com.chinalife.base.component.IBaseComponent;
import com.chinalife.risksurvey.entity.SurveyMainEO;
import com.chinalife.risksurvey.repository.ISurveyMainRepository;

/**
 * component 包名称： com.chinalife.risksurvey.component
 */
public interface ISurveyMainComponent extends IBaseComponent<SurveyMainEO, ISurveyMainRepository> {

    /**
     * 
     * @param surveyMainEO
     *            surveyMainEO
     * @return Object
     */
    public Object insertSurveyMain(SurveyMainEO surveyMainEO);
    
    /**
     * 
     * @param surveyMainEO surveyMainEO
     * @return Object
     */
    public Object updateSurveyMain(SurveyMainEO surveyMainEO);

    /**
     * 通过风勘任务号查询
     *
     * @param surveyId surveyId
     * @return SurveyMainEO
     */
    SurveyMainEO getSurveyMainBySurveyId(String surveyId);
    
    /**
     * 查看风勘报告
     * @param parameter parameter
     * @return map
     */
    public Map<String,Object> getWindReport(Map<String, Object> parameter);

    /**
     * @param surveyId surveyId
     * @return Map
     */
    public Map<String, Object> getCommitVoToAdd(String surveyId);
    
    /**
     * @param surveyId surveyId
     * @return String
     */
    public String getPkidBySurveyId(String surveyId);
}
