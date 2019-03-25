package com.chinalife.risksurvey.task.repository;

import java.util.List;

import com.chinalife.base.repository.IGPBaseRepository;
import com.chinalife.risksurvey.entity.UWSuggestionEO;

/**
 * 包名称： com.chinalife.risksurvey.task.repository
 * 类名称：IUWSuggestionRepository<br/>
 * 类描述：<br/>
 * 创建人：@author YQ<br/>
 * 创建时间：aug 9, 2018/10:33:38 AM<br/>
 */
public interface IUWSuggestionRepository extends IGPBaseRepository<UWSuggestionEO> {

    /**
     * 修改意见往来
     * 
     * @param suggesTionEO
     *            实体
     */
    void updateUWSuggestion(UWSuggestionEO suggesTionEO);

    /**
     * 根据实体id查询
     * 
     * @param surveyId
     *            参数
     * @return List
     */
    List<UWSuggestionEO> findUWSuggestionBySurveyId(Long surveyId);

    /**
     * 查询所有再保沟通历史
     *
     * @param surveyId
     *            参数
     * @param type
     *            参数
     * @return List
     */
    List<UWSuggestionEO> findBySurveyIdAndType(Long surveyId, String type);

    /**
     * 根据实体id查询 order by outflowtime
     *
     * @param surveyId
     *            参数
     *
     * @return List
     */
    List<UWSuggestionEO> findUWSuggestionBySurveyIdOrderbyOutFlowTime(Long surveyId);
    
    /**
     * 新增保存
     * 
     * @param suggesTionEO
     *            实体
     */
    public void saveUWSuggestion(UWSuggestionEO suggesTionEO);
}
