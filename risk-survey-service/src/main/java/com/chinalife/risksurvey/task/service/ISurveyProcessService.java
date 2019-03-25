
package com.chinalife.risksurvey.task.service;

import com.chinalife.risksurvey.task.vo.ProcessParamEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.Map;

/**
 * 包名称： com.chinalife.uw.service 类名称：ISurveyProcessService<br/>
 * 类描述：<br/>
 * 创建人：@author axue016<br/>
 * 创建时间：Jun 22, 2017/9:51:40 AM<br/>
 */
public interface ISurveyProcessService {
    /**
     * @param schemaName
     *            分表名称，可以为空
     * @param surveyId
     *            角色实体的唯一编号
     * @param processDefinitionKey
     *            流程定义号
     * @param taskType
     *            taskType
     * @param paramMap
     *            paramMap
     * @return String
     */
    @RequestMapping("/startProcess")
    public String startProcess(@RequestParam(value = "schemaName", required = false) String schemaName,
                               @RequestParam(value = "surveyId") Long surveyId,
                               @RequestParam(value = "processDefinitionKey") String processDefinitionKey,
                               @RequestParam(value = "taskType", required = false) String taskType,
                               @RequestBody(required = false) Map<String, Object> paramMap);

    /**
     * 
     * @Description: 启动流程
     * @param processParamEntity
     *            流程参数实体
     * @return 任务ID
     */
    @RequestMapping("/startProcessByKey")
    public String startProcess(@RequestBody ProcessParamEntity processParamEntity);
}
