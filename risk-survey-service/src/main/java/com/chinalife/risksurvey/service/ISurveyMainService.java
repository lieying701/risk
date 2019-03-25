package com.chinalife.risksurvey.service;

import java.util.Map;

import com.chinalife.base.service.IBaseService;
import com.chinalife.risksurvey.component.ISurveyMainComponent;
import com.chinalife.risksurvey.entity.SurveyMainEO;
import com.chinalife.risksurvey.repository.ISurveyMainRepository;
import com.chinalife.risksurvey.vo.OriginatingTaskCommitVo;

/**
 * 风勘主表服务接口
 * ISurveyMainService
 *
 * @version 1
 * @author: yuanqiang
 */
public interface ISurveyMainService extends IBaseService<SurveyMainEO, ISurveyMainRepository, ISurveyMainComponent> {

    /**
     * 通过风勘任务号查询
     *
     * @param surveyId surveyId
     * @return SurveyMainEO
     */
    SurveyMainEO getSurveyMainBySurveyId(String surveyId);

    /**
     *
     * @param commitVo commitVo
     * @return Object
     */
    public Object originatingTaskCommit(OriginatingTaskCommitVo commitVo);

    /**
     * @param surveyId surveyId
     * @return Map
     */
    public Map<String, Object> getCommitVoToAdd(String surveyId);
    
    
   

}

