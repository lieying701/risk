package com.chinalife.risksurvey.task.service.underwriting.impl;


import com.chinalife.base.exception.StandardRuntimeException;
import com.chinalife.risksurvey.entity.SurveyDispatchEO;
import com.chinalife.risksurvey.entity.SurveyTaskEO;
import com.chinalife.risksurvey.enums.SurveyStatusEnums;
import com.chinalife.risksurvey.service.ISurveyDispatchService;
import com.chinalife.risksurvey.task.constants.OperationType;
import com.chinalife.risksurvey.task.constants.TaskStatusEnum;
import com.chinalife.risksurvey.task.service.AbstractTaskSecurityService;
import org.activiti.engine.delegate.DelegateTask;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;


import java.util.Map;


/**
 * 录入风勘报告
 *
 * @version 1
 * @author: yuanqiang
 */
@Component("riskSuveyReportService")
public class RisksuveyReportService extends AbstractTaskSecurityService {
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
        surveyTask.setSurveyStatus(SurveyStatusEnums.UNCOMMITTED.getCode());

        surveyTask.setCategory(taskType);
        this.saveNewSurveyTask(delegateTask, surveyTask, TaskStatusEnum.Pending,SurveyStatusEnums.UNCOMMITTED, OperationType.NORMAL);
    }


    /**
     * 任务完成时更新自定义业务任务状态
     * 当为产品组合时，拆分各个ActualId并更新其状态，若不为产品组合，则更新状态并更新InsuranceTask信息
     */
    @Override
    public void complete(DelegateTask delegateTask, Map<String, Object> processDefinitionMap, String schemeName,
                         String surveyId, String taskType) {
        SurveyTaskEO surveyTaskEO = this.surveyTaskService.findByTaskId(delegateTask.getId(), null);
        if (surveyTaskEO == null) {
            LOGGER.info("{}---查询不到该风堪任务taskId:[{}]！", this.getClass().getSimpleName(), delegateTask.getId());
            throw new StandardRuntimeException("无法提交，请检查用户在当前登录机构下是否有录单权限");
        }
        // FIXME 从可分派转至录入风勘信息 此处丰富任务各字段示处理
        this.completeSurveyTask(surveyTaskEO, SurveyStatusEnums.SUBMITTED, null);
        delegateTask.setVariable(NEXT_UW_LEVEL, null);
        this.syncTask(surveyTaskEO, delegateTask);
    }
}
