package com.chinalife.risksurvey.task.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.chinalife.base.service.impl.BaseServiceImpl;
import com.chinalife.risksurvey.entity.UWSuggestionEO;
import com.chinalife.risksurvey.task.component.IUWSuggestionComponent;
import com.chinalife.risksurvey.task.repository.IUWSuggestionRepository;
import com.chinalife.risksurvey.task.service.IUWSuggestionService;

/**
 * 包名称： com.chinalife.risksurvey.task.service.impl
 * 类名称：UWSuggestionServiceImpl<br/>
 * 类描述：<br/>
 * 创建人：@author YQ<br/>
 * 创建时间：aug 9, 2018/10:33:38 AM<br/>
 */
@RestController("uwSuggestionService")
@RequestMapping("/service/risksurvey/uwSuggestion")
public class UWSuggestionServiceImpl
        extends BaseServiceImpl<UWSuggestionEO, IUWSuggestionRepository, IUWSuggestionComponent>
        implements IUWSuggestionService {
    /**
     * 建议的业务逻辑层
     */
    @Autowired
    private IUWSuggestionComponent uwSuggestionComponent;

    /**
     * 根据实体id查询
     */
    @Override
    public List<UWSuggestionEO> findUWSuggestionBySurveyId(Long surveyId) {
        return uwSuggestionComponent.findUWSuggestionBySurveyId(surveyId);
    }

    /**
     * 新增保存
     */
    @Override
    public void saveUWSuggestion(UWSuggestionEO suggesTionEO) {
        uwSuggestionComponent.saveUWSuggestion(suggesTionEO);
    }

    /**
     * 修改意见往来
     */
    @Override
    public void updateUWSuggestion(UWSuggestionEO suggesTionEO) {
        uwSuggestionComponent.updateUWSuggestion(suggesTionEO);
    }

    /**
     * 根据实体id查询 order by OutFlowTime
     *
     * @param surveyId
     *            参数
     *
     * @return List
     */
    @Override
    public List<UWSuggestionEO> findUWSuggestionBySurveyIdOrderbyOutFlowTime(Long surveyId) {
        return this.uwSuggestionComponent.findUWSuggestionBySurveyIdOrderbyOutFlowTime(surveyId);
    }
}
