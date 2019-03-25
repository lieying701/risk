package com.chinalife.risksurvey.repository;

import com.chinalife.base.repository.IGPBaseRepository;
import com.chinalife.risksurvey.entity.SurveyRelBusinessEO;

/**
 * SurveyRelBusinessEO
 * 关联业务表 
 */
public interface ISurveyRelBusinessRepository extends IGPBaseRepository<SurveyRelBusinessEO> {

    /**
     * 向关联业务表中添加信息
     * @param surveyRelBusinessEO
     *        surveyRelBusinessEO
     */
    public void insertSurveyRelBusiness(SurveyRelBusinessEO surveyRelBusinessEO);

    /**
     * @param surveyId surveyId
     * @return SurveyRelBusinessEO
     */
    public SurveyRelBusinessEO findLastSurveyRelBusinessEOBySurveyId(String surveyId);

    /**
     * @param businessNo businessNo
     * @return SurveyRelBusinessEO
     */
    public SurveyRelBusinessEO findSurveyIdExist(String businessNo);


}
