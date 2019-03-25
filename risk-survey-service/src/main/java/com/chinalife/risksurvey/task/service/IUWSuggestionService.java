package com.chinalife.risksurvey.task.service;

import java.util.List;

import com.chinalife.base.service.IBaseService;
import com.chinalife.risksurvey.entity.UWSuggestionEO;
import com.chinalife.risksurvey.task.component.IUWSuggestionComponent;
import com.chinalife.risksurvey.task.repository.IUWSuggestionRepository;

/**
 * 包名称： com.chinalife.risksurvey.task.service 类名称：IUWSuggestionService<br/>
 * 类描述：<br/>
 * 创建人：@author YQ<br/>
 * 创建时间：aug 9, 2018/10:33:38 AM<br/>
 */
public interface IUWSuggestionService
        extends IBaseService<UWSuggestionEO, IUWSuggestionRepository, IUWSuggestionComponent> {

    /**
     * 根据实体id查询
     * 
     * @param surveyId
     *            参数
     * @return List
     */
    List<UWSuggestionEO> findUWSuggestionBySurveyId(Long surveyId);

    
    /**
     * 新增保存
     * 
     * @param suggesTionEO
     *            实体
     */
    void saveUWSuggestion(UWSuggestionEO suggesTionEO);

    /**
     * 修改意见往来
     * 
     * @param suggesTionEO
     *            实体
     */
    void updateUWSuggestion(UWSuggestionEO suggesTionEO);

    /**
     * 根据实体id查询
     * order by outflowTime
     *
     * @param surveyId
     *            参数
     * @return List
     */
    List<UWSuggestionEO> findUWSuggestionBySurveyIdOrderbyOutFlowTime(Long surveyId);


}
