package com.chinalife.risksurvey.task.service.underwriting.impl;


import com.chinalife.risksurvey.entity.SurveyTaskEO;
import com.chinalife.risksurvey.enums.SurveyStatusEnums;
import com.chinalife.risksurvey.task.constants.ContractBusinessType;
import com.chinalife.risksurvey.task.constants.TaskStatusEnum;
import com.chinalife.risksurvey.task.service.AbstractTaskEventService;
import com.chinalife.workflow.entity.TaskEO;
import org.activiti.engine.delegate.DelegateExecution;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import java.util.Map;

/**
 * 风勘派工
 *
 * @author yuanqiang
 * @version 1
 */
@Component("riskSuveyAssignService")
public class RiskSuveyAssignService extends AbstractTaskEventService {

    /**
     * logger
     */
    private static final Logger LOGGER = LoggerFactory.getLogger(RiskSuveyAssignService.class);

    /**
     *
     *
     * @param execution
     *            execution
     * @param processDefinitionMap
     *            parameter map
     * @param schemeName
     *            schema
     * @param surveyId
     *            surveyId
     */
    public void onEvent(DelegateExecution execution, Map<String, Object> processDefinitionMap, String schemeName,
                        String surveyId) {
        TaskEO taskEO = this.getTask(execution);
        String taskType = execution.getVariable(ContractBusinessType.taskType.toString()) != null
                ? (String) execution.getVariable(ContractBusinessType.taskType.toString()) : null;
                
        SurveyTaskEO surveyTask = this.getSurveyTask(taskEO, Long.parseLong(surveyId), taskType);
        surveyTask.setSurveyStatus(SurveyStatusEnums.UNASSIGNED.getCode());
        surveyTask.setStatus(TaskStatusEnum.Processed.getCode());
        execution.setVariable(MULTI_INSTANCE_RESULT, null);
        String multiInstanceResult = "UW";
        execution.setVariable(MULTI_INSTANCE_RESULT, multiInstanceResult);
        this.syncTask(surveyTask, taskEO);
       
    }
}
