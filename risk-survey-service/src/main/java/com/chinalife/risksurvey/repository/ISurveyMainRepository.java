package com.chinalife.risksurvey.repository;


import java.util.Map;

import com.chinalife.base.repository.IGPBaseRepository;
import com.chinalife.risksurvey.entity.SurveyMainEO;

/**
 * SurveyMainEO
 * 风勘主表 
 */
public interface ISurveyMainRepository extends IGPBaseRepository<SurveyMainEO> {
    /**
     * 发起风勘 添加风勘信息
     * @param surveyMainEO
     *        surveyMainEO
     */
    public void insertSurveyMain(SurveyMainEO surveyMainEO);

    /**
     * 通过风勘任务号查询
     *
     * @param surveyId surveyId
     * @return SurveyMainEO
     */
    SurveyMainEO getSurveyMainBySurveyId(String surveyId);
    
    /**
     * 更新
     * @param surveyMainEO
     *        surveyMainEO
     */
    public void updateSurveyMain(SurveyMainEO surveyMainEO);

    /**
     * @param surveyId  surveyId
     * @return Map
     */
    public Map<String, Object> getCommitVoToAdd(String surveyId);
    
    /**
     * 发起风勘回显数据
     * @param parameter parameter
     * @return Object
     */
    public Object getWindReport(Map<String, Object> parameter);
    
    /**
     * 工程险回显数据
     * @param parameter parameter
     * @return Object
     */
    public Object getItemlist(Map<String, Object> parameter);
    
    /**
     * 得到pkId
     * @param parameter parameter
     * @return Object
     */
    Object getPkId(Map<String, Object> parameter);

    /**
     * 获取风勘项
     * @param parameter parameter
     * @return Object
     */
    Object getModelUrl(Map<String, Object> parameter);
    
    /**
     * 得到pkid
     * @param surveyId surveyId
     * @return Object
     */
    String getPkidBySurveyId(String surveyId);
    
}
