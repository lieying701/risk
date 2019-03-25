package com.chinalife.risksurvey.task.vo;

import java.io.Serializable;
import java.util.Map;

/**
 * @author baiyunfei
 *
 */
public class ProcessParamEntity implements Serializable {

    /**
     * @Fields serialVersionUID : 序列号
     */
    private static final long serialVersionUID = -268062254838830706L;

    /** 流程定义KEY */
    private String processDefinitionKey;

    /** 分表名称 */
    private String schemaName;

    /** 实体surveyIds的以,号相 */
    private String surveyIds;

    /** 任务类型 */
    private String taskType;

    /** 参数 */
    private Map<String, Object> parameters;

    public String getProcessDefinitionKey() {
        return processDefinitionKey;
    }

    public void setProcessDefinitionKey(String processDefinitionKey) {
        this.processDefinitionKey = processDefinitionKey;
    }

    public String getSchemaName() {
        return schemaName;
    }

    public void setSchemaName(String schemaName) {
        this.schemaName = schemaName;
    }

    public String getSurveyIds() {
        return surveyIds;
    }

    public void setSurveyIds(String surveyIds) {
        this.surveyIds = surveyIds;
    }

    public String getTaskType() {
        return taskType;
    }

    public void setTaskType(String taskType) {
        this.taskType = taskType;
    }

    public Map<String, Object> getParameters() {
        return parameters;
    }

    public void setParameters(Map<String, Object> parameters) {
        this.parameters = parameters;
    }

}
