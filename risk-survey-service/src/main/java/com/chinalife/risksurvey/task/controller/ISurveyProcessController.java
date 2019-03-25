package com.chinalife.risksurvey.task.controller;

import com.chinalife.base.util.Pagination;
import com.chinalife.risksurvey.task.vo.ProcessParamEntity;
import com.chinalife.workflow.entity.ProcessInstanceEO;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.Date;
import java.util.List;
import java.util.Map;

/**
 * 版权 @Copyright: 2017 www.chinalife-p.com Inc. All rights reserved.
 * 项目名称：policy-center-service<br/>
 * 文件名称： ISurveyProcessController.java<br/>
 * 包名：com.chinalife.uw.controller 创建人：@author axue016@pwc.com<br/>
 * 创建时间：Jun 19, 2017/3:55:05 PM<br/>
 * 修改人：axue016@pwc.com<br/>
 * 修改时间：Jun 19, 2017/3:55:05 PM<br/>
 * 修改备注：<br/>
 * 包名称： com.chinalife.uw.controller 类名称：ISurveyProcessController 类描述：
 * 
 * @version
 */
public interface ISurveyProcessController {

    /**
     * 
     * @Description: 启动流程
     * @param processParamEntity
     *            流程参数实体
     * @return 任务ID
     */
    public String startProcess(@RequestBody ProcessParamEntity processParamEntity);

    /**
     * @Description: 启动流程
     * @param schemaName
     *            分表名称，可以为空 分表名称，可以为空
     * @param surveyId
     *            角色实体的唯一编号
     * @param processDefinitionId
     *            流程定义号
     * @param taskType
     *            请施李金添加注释
     * @param paramMap
     *            请施李金添加注释
     * @return String
     */
    @RequestMapping("/startProcess")
    public String startProcess(@RequestParam(value = "schemaName", required = false) String schemaName,
                               @RequestParam(value = "surveyId") Long surveyId,
                               @RequestParam(value = "processDefinitionId") String processDefinitionId,
                               @RequestParam(value = "taskType", required = false) String taskType,
                               @RequestBody(required = false) Map<String, Object> paramMap);

    /**
     * @Description: 启动流程
     *
     *
     * @param schemaName
     *            分表名称，可以为空
     * @param surveyId
     *            角色实体的唯一编号
     * @param processDefinitionId
     *            请施李金添加注释
     * @param effectiveDate
     *            请施李金添加注释
     * @return ProcessInstanceEO 请施李金添加注释
     */
    @RequestMapping("/startProcessInstanceById")
    public ProcessInstanceEO startProcessInstanceById(
            @RequestParam(value = "schemaName", required = false) String schemaName,
            @RequestParam(value = "surveyId") Long surveyId,
            @RequestParam(value = "processDefinitionId") String processDefinitionId,
            @RequestParam(value = "effectiveDate") Date effectiveDate);

    /**
     * @Description: 分页查询流程实例
     * @param parameters
     *            请施李金添加注释
     * @param from
     *            请施李金添加注释
     * @param limit
     *            请施李金添加注释
     * @return Pagination 请施李金添加注释
     */
    @RequestMapping("/getPage")
    public @ResponseBody Pagination<?> get(@RequestBody Map<String, Object> parameters,
                                           @RequestParam(value = "from") Integer from, @RequestParam(value = "limit") Integer limit);

    /**
     * @Description: 查询流程实例
     * @param id
     *            请施李金添加注释
     * @return ProcessInstanceEO
     */
    @RequestMapping("/get")
    public @ResponseBody ProcessInstanceEO get(@RequestParam(value = "id") String id);

    /**
     * @Description: 查询流程实例
     * @param parameters
     *            请施李金添加注释
     * @return List<ProcessInstanceEO>
     */
    @RequestMapping("/getAll")
    public List<ProcessInstanceEO> getAll(@RequestBody Map<String, Object> parameters);
}
