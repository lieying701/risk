package com.chinalife.risksurvey.service;

import java.util.Map;

import com.chinalife.base.service.IBaseService;
import com.chinalife.risksurvey.component.ISurveyRelBusinessComponent;
import com.chinalife.risksurvey.entity.SurveyRelBusinessEO;
import com.chinalife.risksurvey.repository.ISurveyRelBusinessRepository;

/**
 * 包名称： com.chinalife.risksurvey.service 
 */
public interface ISurveyRelBusinessService extends IBaseService<SurveyRelBusinessEO, ISurveyRelBusinessRepository, ISurveyRelBusinessComponent> {
    
    /**
     * 
     * @param surveyRelBusiness surveyRelBusiness
     * @return Object
     */
    public Object insertOrUpdateSurveyRelBusiness(SurveyRelBusinessEO surveyRelBusiness);

    
    
    /**   查询是否该保单号存在 风堪任务
     * @param bussinessNo bussinessNo
     * @return map
     */
    public Map<String,Object> findSurveyIdExist(String bussinessNo);
    
    
    /** 查询最新的关联业务信息
     * @param surveyId surveyId
     * @return SurveyRelBusinessEO
     */
    public  SurveyRelBusinessEO findLastSurveyRelBusinessEOBySurveyId(String surveyId);

    
    /**
     * 
     * @param surveyRelBusiness surveyRelBusiness
     * @return Object
     */
    public Object updateSurveyRelBusiness(SurveyRelBusinessEO surveyRelBusiness);

}
