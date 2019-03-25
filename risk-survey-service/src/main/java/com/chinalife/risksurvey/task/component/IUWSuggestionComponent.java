package com.chinalife.risksurvey.task.component;

import java.util.List;

import com.chinalife.base.component.IBaseComponent;
import com.chinalife.risksurvey.entity.UWSuggestionEO;
import com.chinalife.risksurvey.task.repository.IUWSuggestionRepository;

/**
 * 包名称： com.chinalife.risksurvey.task.component 类名称：IUWSuggestionComponent<br/>
 * 类描述：<br/>
 * 创建人：@author YQ<br/>
 * 创建时间：aug 9, 2018/10:33:38 AM<br/>
 */
public interface IUWSuggestionComponent extends IBaseComponent<UWSuggestionEO, IUWSuggestionRepository> {

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
     * @param suggestionEO
     *            实体
     */
    void saveUWSuggestion(UWSuggestionEO suggestionEO);

    /**
     * 查询所有再保沟通历史
     *
     * @param surveyId
     *            参数
     * @param type
     *            参数
     * @return List<UWSuggestionEO>
     */
    List<UWSuggestionEO> findBySurveyIdAndType(Long surveyId, String type);

    /**
     * 修改意见往来
     * 
     * @param suggestionEO
     *            实体
     */
    public void updateUWSuggestion(UWSuggestionEO suggestionEO);

    /**
     * 根据实体id查询
     * order by outflowtime
     *
     * @param surveyId 参数
     * @return List<UWSuggestionEO>
     */
    List<UWSuggestionEO> findUWSuggestionBySurveyIdOrderbyOutFlowTime(Long surveyId);

}
