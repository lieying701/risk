package com.chinalife.risksurvey.task.service;

import java.util.Map;

import org.activiti.engine.delegate.DelegateExecution;
import org.activiti.engine.delegate.DelegateTask;

/**
 * ITaskEventService 包名称： com.chinalife.risksurvey.task.service
 * 类名称：ITaskEventService<br/>
 * 类描述：<br/>
 * 
 * @version <br/>
 */
public interface ITaskEventService {

    /**
     * 创建任务事件监听
     *
     * @param delegateTask  delegateTask
     * @param processDefinitionMap  processDefinitionMap
     * @param schemeName    schemeName
     * @param surveyId  surveyId
     * @param taskType  taskType
     */
    void create(DelegateTask delegateTask, Map<String, Object> processDefinitionMap, String schemeName,
                String surveyId, String taskType);

    /**
     * 完成任务事件监听
     *
     * @param delegateTask  delegateTask
     * @param processDefinitionMap  processDefinitionMap
     * @param schemeName    schemeName
     * @param surveyId      surveyId
     * @param taskType  taskType
     */
    void complete(DelegateTask delegateTask, Map<String, Object> processDefinitionMap, String schemeName,
                  String surveyId, String taskType);

    /**
     * 删除任务事件监听
     *
     * @param delegateTask
     *            delegateTask
     * @param schemeName
     *            schemeName
     * @param surveyId
     *            surveyId
     */
    void delete(DelegateTask delegateTask, String schemeName, Long surveyId);

    /**
     * 根据操作类型进行逻辑分支判断
     *
     * @param execution
     *            execution
     * @param processDefinitionMap
     *            processDefinitionMap
     * @param targetValue
     *            targetValue
     * @return boolean
     */
    boolean condition(DelegateExecution execution, Map<String, Object> processDefinitionMap, String targetValue);

    /**
     * Service任务处理事件
     *
     * @param execution
     *            execution
     * @param processDefinitionMap
     *            processDefinitionMap
     * @param schemeName
     *            schemeName
     * @param surveyId
     *            surveyId
     */
    void onEvent(DelegateExecution execution, Map<String, Object> processDefinitionMap, String schemeName,
                 Long surveyId);

}
