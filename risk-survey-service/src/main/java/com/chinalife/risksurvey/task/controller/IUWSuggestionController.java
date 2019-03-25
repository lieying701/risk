package com.chinalife.risksurvey.task.controller;

import java.util.List;

import com.chinalife.risksurvey.entity.UWSuggestionEO;

/**
 * 包名称： com.chinalife.risksurvey.task.controller
 * 类名称：IUWSuggesTionContorller<br/>
 * 类描述：<br/>
 * 创建人：@author YQ<br/>
 * 创建时间：aug 9, 2018/10:33:38 AM<br/>
 */
public interface IUWSuggestionController {

    /**
     * 根据实体ID查询
     * 
     * @param surveyId
     *            参数
     * @return List
     */
    List<UWSuggestionEO> findUWSuggesTionByActualId(Long surveyId);

    /**
     * 新增保存
     * 
     * @param suggesTionEO
     *            实体
     * @return UWSuggestionEO
     */
    UWSuggestionEO saveUWSuggesTion(UWSuggestionEO suggesTionEO);// 新增保存

    /**
     * 修改意见往来
     * 
     * @param suggesTionEO
     *            实体
     * @return UWSuggestionEO
     */
    UWSuggestionEO updateUWSuggesTion(UWSuggestionEO suggesTionEO);
}
