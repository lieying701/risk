package com.chinalife.risksurvey.task.service.underwriting.impl;


import com.chinalife.risksurvey.entity.SurveyDispatchEO;
import com.chinalife.risksurvey.entity.SurveyTaskEO;
import com.chinalife.risksurvey.enums.SurveyStatusEnums;
import com.chinalife.risksurvey.service.ISurveyDispatchService;
import com.chinalife.risksurvey.task.constants.CommonConstants;
import com.chinalife.risksurvey.task.constants.OperationType;
import com.chinalife.risksurvey.task.constants.TaskStatusEnum;
import com.chinalife.risksurvey.task.service.AbstractTaskSecurityService;
import org.activiti.engine.delegate.DelegateTask;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Map;

/**
 * 风勘评估
 *
 * @version 1
 * @author: yuanqiang
 */
@Component("riskSurveyEvaluationService")
public class RiskSurveyEvaluationService extends AbstractTaskSecurityService {

    /**
     * surveyDispatchService
     */
    @Autowired
    private ISurveyDispatchService surveyDispatchService;
    
    /**
     * 创建第一个节点的任务， 该任务是录入任务的初始化阶段，数据不完整，不用同步到insuranceTask中
     *
     * @param delegateTask 流程任务节点
     * @param schemeName   分表名称
     * @param surveyId    风勘任务号
     * @param taskType     任务类型
     */
    @Override
    public void create(DelegateTask delegateTask, Map<String, Object> processDefinitionMap, String schemeName,
                       String surveyId, String taskType) {
       
        SurveyTaskEO surveyTask = this.getSurveyTask(delegateTask, Long.parseLong(surveyId), taskType);
        SurveyDispatchEO surveyDispatchEO = surveyDispatchService.findBySurveyId(surveyId);
        surveyTask.setAssignee(surveyDispatchEO.getOperatorCode());
        surveyTask.setAssigneeName(surveyDispatchEO.getOperator());
        OperationType operationType = OperationType
                .getOperationType((String) processDefinitionMap.get(CommonConstants.OPERATION_TYPE));
        if (operationType != null && operationType.isReject()) {
            this.saveNewSurveyTask(delegateTask, surveyTask, TaskStatusEnum.Pending,
                    SurveyStatusEnums.MODIFY, operationType);
            LOGGER.info("{}---操作类型为:[{}]，surveyTask业务状态改为:[{}]", this.getClass().getSimpleName(),
                    operationType.getCode(), SurveyStatusEnums.MODIFY.getCode());
        } else if (operationType != null
                && operationType.idSupp()) {
            this.saveNewSurveyTask(delegateTask, surveyTask, TaskStatusEnum.Pending,
                    SurveyStatusEnums.ADDTASKENTERING, operationType);
            LOGGER.info("{}---操作类型为:[{}]，surveyTask业务状态改为:[{}]", this.getClass().getSimpleName(),
                    operationType.getCode(), SurveyStatusEnums.ADDTASKENTERING.getCode());
        } else {
            this.saveNewSurveyTask(delegateTask, surveyTask, TaskStatusEnum.Pending,
                    SurveyStatusEnums.SUBMITTED, OperationType.NORMAL);
            LOGGER.info("{}---操作类型为:[{}]，surveyTask业务状态改为:[{}]", this.getClass().getSimpleName(),
                    OperationType.NORMAL, SurveyStatusEnums.SUBMITTED.getCode());
        }
    }

    /**
     * 任务完成时更新自定义业务任务状态
     * 当为产品组合时，拆分各个ActualId并更新其状态，若不为产品组合，则更新状态并更新InsuranceTask信息
     */
    @Override
    public void complete(DelegateTask delegateTask, Map<String, Object> processDefinitionMap, String schemeName,
                         String surveyId, String taskType) {

    }
}
