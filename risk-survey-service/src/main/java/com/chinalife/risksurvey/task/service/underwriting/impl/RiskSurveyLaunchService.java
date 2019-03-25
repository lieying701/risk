
package com.chinalife.risksurvey.task.service.underwriting.impl;

import com.chinalife.base.exception.StandardRuntimeException;
import com.chinalife.base.util.JsonUtils;
import com.chinalife.risksurvey.entity.SurveyMainEO;
import com.chinalife.risksurvey.entity.SurveyTaskEO;

import com.chinalife.risksurvey.enums.SurveyStatusEnums;
import com.chinalife.risksurvey.service.ISurveyMainService;

import com.chinalife.risksurvey.task.constants.OperationType;
import com.chinalife.risksurvey.task.constants.TaskStatusEnum;
import com.chinalife.risksurvey.task.service.AbstractTaskSecurityService;
import com.chinalife.workflow.entity.TaskEO;
import org.activiti.engine.delegate.DelegateTask;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Map;
import java.util.UUID;

/**
 * 发起风勘
 *
 * @version 1
 * @author: yuanqiang
 */
@Component("riskSurveyLaunchService")
public class RiskSurveyLaunchService extends AbstractTaskSecurityService {

    /**
     * surveyMainService
     */
    @Autowired
    private ISurveyMainService surveyMainService;

    /**
     * 创建第一个节点的任务， 该任务是录入任务的初始化阶段，数据不完整，不用同步到insuranceTask中
     */
    @Override
    public void create(DelegateTask delegateTask, Map<String, Object> processDefinitionMap, String schemeName,
                       String surveyId, String taskType) {
        TaskEO parentTaskEO = this.getParentTask(delegateTask);
        SurveyTaskEO surveyTask = this.getSurveyTask(parentTaskEO, Long.parseLong(surveyId), taskType);
        surveyTask.setCategory(taskType);
        SurveyMainEO surveyMain = surveyMainService.getSurveyMainBySurveyId(surveyId);
        //任务编号  （风堪任务号）
        surveyTask.setBusinessNo(surveyMain.getSurveyId());
        //任务执行人（任务发起人） 
        //surveyTask.setAssigneeName(surveyMain.getTaskStarterName());
        surveyTask.setAssignee(surveyMain.getTaskStarter());
     
        surveyTask.setApplyDept(surveyMain.getApplyDept());
        // surveyTask.setApplicantCode(applicantCode);
        // surveyTask.setApplicantName(applicantName);
        // surveyTask.setInsurantCode(insurantCode);
        // surveyTask.setInsurantName(insurantName);
        if (parentTaskEO != null) {
            this.saveNewSurveyTask(delegateTask, surveyTask,TaskStatusEnum.Pending,SurveyStatusEnums.ADDTASKENTERING,null);

        } else {
            this.saveNewSurveyTask(delegateTask, surveyTask, TaskStatusEnum.Pending,SurveyStatusEnums.TASKENTERING, OperationType.NORMAL);

        }
       
    }

    /**
     * 任务完成时更新自定义业务任务状态
     * 当为产品组合时，拆分各个ActualId并更新其状态，若不为产品组合，则更新状态并更新InsuranceTask信息
     */
    @Override
    public void complete(DelegateTask delegateTask, Map<String, Object> processDefinitionMap, String schemeName,
                         String surveyId, String taskType) {

        SurveyTaskEO surveyTask = this.surveyTaskService.findByTaskId(delegateTask.getId(), null);
        if (surveyTask == null) {
            LOGGER.info("{}---查询不到该风堪任务taskId:[{}],kind:[{}]！", this.getClass().getSimpleName(), delegateTask.getId(),
                    JsonUtils.toJsonString(taskType, false));
            throw new StandardRuntimeException("无法提交任务，请检查用户在当前登录机构下是否有录单权限");
        }
        
        /**
         * if (null == processDefinitionMap.get(CommonConstants.UW_SUGGEST)) {
         * UWSuggestionEO suggestionEO = new UWSuggestionEO();
         * suggestionEO.setSchemaName(schemeName);
         * suggestionEO.setSuggestComment("提交派工");
         * suggestionEO.setSuggestType(UWSuggestionEO.SuggestionType.UwSubmit.
         * name()); processDefinitionMap.put(CommonConstants.UW_SUGGEST,
         * suggestionEO); }
         */
        //this.storeSuggestion(surveyTask, processDefinitionMap, true);
        if (surveyTask.getSurveyStatus().equals(SurveyStatusEnums.ADDTASKENTERING.getCode())) {
            this.completeSurveyTask(surveyTask, SurveyStatusEnums.ADDTASKENTERING, null);
        } else {
            this.completeSurveyTask(surveyTask, SurveyStatusEnums.TASKENTERING, null);
        }
        delegateTask.setVariable(NEXT_UW_LEVEL, null);
        this.syncTask(surveyTask, delegateTask);
    }

    /**
     * @return String
     */
    public static String getOrderIdByUUId() {
        int machineId = 1;//最大支持1-9个集群机器部署
        int hashCodeV = UUID.randomUUID().toString().hashCode();
        if (hashCodeV < 0) {
            hashCodeV = - hashCodeV;
        }
        // 0 代表前面补充0     
        // 4 代表长度为4     
        // d 代表参数为正数型
        return machineId + String.format("%015d", hashCodeV);
    }
}

