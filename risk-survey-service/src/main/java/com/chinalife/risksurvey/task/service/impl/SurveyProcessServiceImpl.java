package com.chinalife.risksurvey.task.service.impl;

import com.chinalife.risksurvey.entity.SurveyTaskEO;
import com.chinalife.risksurvey.task.constants.ContractBusinessType;
import com.chinalife.risksurvey.task.constants.TaskStatusEnum;
import com.chinalife.risksurvey.task.service.ISurveyProcessService;
import com.chinalife.risksurvey.task.service.ISurveyTaskService;
import com.chinalife.risksurvey.task.vo.ProcessParamEntity;
import com.chinalife.workflow.entity.ProcessInstanceEO;
import com.chinalife.workflow.entity.ProcessInstanceEO.BusinessKeyType;
import com.chinalife.workflow.entity.TaskEO;
import com.chinalife.workflow.service.IProcessInstanceService;
import com.chinalife.workflow.service.ITaskService;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 包名称： com.chinalife.uw.service.impl 类名称：SurveyProcessServiceImpl<br/>
 * 类描述：<br/>
 * 创建人：@author axue016<br/>
 * 创建时间：Jun 22, 2017/9:53:37 AM<br/>
 */
@RestController("surveyProcessService")
@RequestMapping("/service/risksurvey/process")
public class SurveyProcessServiceImpl implements ISurveyProcessService {

    /**
     * process instance service
     */
    @Autowired
    private IProcessInstanceService processInstanceService;

    /**
     * insuranceTaskService
     */
    @Autowired
    private ISurveyTaskService surveyTaskService;

    /**
     * task service
     */
    @Autowired
    private ITaskService taskService;

    @RequestMapping("/startProcessByKey")
    @Override
    public String startProcess(ProcessParamEntity processParamEntity) {
        Map<String, Object> processVariables = new HashMap<>();
        processVariables.put(BusinessKeyType.caseId.toString(), processParamEntity.getSurveyIds());
        processVariables.put(BusinessKeyType.schemaName.toString(), processParamEntity.getSchemaName());
        processVariables.put(ContractBusinessType.taskType.toString(), processParamEntity.getTaskType());
        processVariables.put(ContractBusinessType.processDefinitionMap.name(), processParamEntity.getParameters());
        String taskId = this.checkExistProcess(Long.valueOf(processParamEntity.getSurveyIds()));
        if (StringUtils.isEmpty(taskId)) {
            ProcessInstanceEO processInstanceEO = processInstanceService.startProcessInstanceByKey(
                    processParamEntity.getProcessDefinitionKey(), processParamEntity.getSurveyIds(),
                    processVariables);
            taskId = findTaskId(processInstanceEO);
        }

        return taskId;
    }

    @Override
    public String startProcess(@RequestParam(value = "schemaName", required = false) String schemaName,
            @RequestParam(value = "surveyId") Long surveyId,
            @RequestParam(value = "processDefinitionKey") String processDefinitionKey,
            @RequestParam(value = "taskType", required = false) String taskType,
            @RequestBody(required = false) Map<String, Object> paramMap) {

        if (paramMap == null) {
            paramMap = new HashMap<>();
        }

        Map<String, Object> processVariables = new HashMap<>();
        processVariables.put(BusinessKeyType.caseId.toString(), surveyId.toString());
        processVariables.put(BusinessKeyType.schemaName.toString(), schemaName);
        processVariables.put(ContractBusinessType.taskType.toString(), taskType);
        processVariables.put(ContractBusinessType.processDefinitionMap.name(), paramMap);

        String taskId = this.checkExistProcess(surveyId);

        if (StringUtils.isEmpty(taskId)) {
            ProcessInstanceEO processInstanceEO = processInstanceService.startProcessInstanceByKey(processDefinitionKey,
                    surveyId.toString(), processVariables);
            taskId = findTaskId(processInstanceEO);
        }

        return taskId;
    }

    /**
     * find task id
     *
     * @param processInstanceEO
     *            process instance EO
     *
     * @return taskId
     */
    private String findTaskId(ProcessInstanceEO processInstanceEO) {
        String taskId = "";
        if (processInstanceEO != null) {
            List<TaskEO> taskList = taskService.getTasks(processInstanceEO.getId());
            if (taskList != null && !taskList.isEmpty()) {
                TaskEO taskEO = taskList.get(0);
                taskId = taskEO.getId();
            }
        }
        return taskId;
    }

    /**
     * check the exist the process instance
     *
     * @param surveyId
     *            survey id
     *
     * @return existing task id
     */
    private String checkExistProcess(Long surveyId) {
        SurveyTaskEO surveyTaskEO = this.surveyTaskService.findLastTaskBySurveyId(surveyId, null);
        if (surveyTaskEO != null && (TaskStatusEnum.isProcessing(surveyTaskEO.getStatus())
                || TaskStatusEnum.isPending(surveyTaskEO.getStatus()))) {
            return surveyTaskEO.getTaskId();
        }
        return null;
    }

}
