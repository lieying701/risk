package com.chinalife.risksurvey.task.service.underwriting.impl;


import com.chinalife.risksurvey.entity.SurveyMainEO;
import com.chinalife.risksurvey.entity.SurveyTaskEO;
import com.chinalife.risksurvey.enums.SurveyStatusEnums;
import com.chinalife.risksurvey.service.ISurveyMainService;
import com.chinalife.risksurvey.task.constants.ContractBusinessType;
import com.chinalife.risksurvey.task.constants.OperationType;

import com.chinalife.risksurvey.task.service.AbstractTaskEventService;
import com.chinalife.risksurvey.task.service.ISurveyTaskService;
import com.chinalife.workflow.entity.TaskEO;

import org.activiti.engine.delegate.DelegateExecution;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Map;

/**
 * 风勘通过
 *
 * @author yuanqiang
 * @version 1
 */
@Component("passService")
public class PassService extends AbstractTaskEventService {

    /**
     * logger
     */
    private static final Logger LOGGER = LoggerFactory.getLogger(RiskSuveyAssignService.class);
    
    /**
     * surveyMainService
     */
    @Autowired
    private ISurveyMainService surveyMainService;
    /**
     * surveyTaskService
     */
    @Autowired
    private ISurveyTaskService surveyTaskService;
    
    /**
     * @param execution            execution
     * @param processDefinitionMap parameter map
     * @param schemeName           schema
     * @param surveyId         surveyId
     */
    public void onEvent(DelegateExecution execution, Map<String, Object> processDefinitionMap, String schemeName,
                        String surveyId) {
        //FIXME
        LOGGER.info("获取权限start----------------------------------------");
        execution.setVariable(NEXT_UW_LEVEL, "");
        LOGGER.info("获取权限end----------------------------------------");
        TaskEO taskEO = this.getTask(execution);

        String taskType = execution.getVariable(ContractBusinessType.taskType.toString()) != null
                ? (String) execution.getVariable(ContractBusinessType.taskType.toString()) : null;
        SurveyTaskEO surveyTask = surveyTaskService.findLastTaskBySurveyId(Long.valueOf(surveyId), null);
        SurveyStatusEnums surveyStatus = SurveyStatusEnums.FINISH;
        SurveyMainEO surveyMain = surveyMainService.getSurveyMainBySurveyId(surveyId);
        surveyMain.setStatus(surveyStatus.getCode());
        surveyMainService.update(surveyMain);
        this.completeSurveyTask(surveyTask, surveyStatus, OperationType.PASS, surveyTask.getAssignee());
        this.syncTask(surveyTask, taskEO);
    }
}
