package com.chinalife.risksurvey.service;

import java.util.Map;

import com.chinalife.risksurvey.vo.OriginatingTaskCommitVo;

/**
 * 风勘主表服务接口
 * ISurveyMainService
 *
 * @version 1
 * @author: yuanqiang
 */
public interface ISurveyMainInputService  {

    /**
     * @param commitVo commitVo
     * @return Object
     */
    public Object originatingTaskCommit(OriginatingTaskCommitVo commitVo);
    
    /**
     * 
     * @param parameter parameter
     * @return map
     */
    public Map<String,Object> getWindReport(Map<String, Object> parameter);

}

