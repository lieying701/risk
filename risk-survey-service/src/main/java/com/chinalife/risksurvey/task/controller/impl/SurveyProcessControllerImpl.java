package com.chinalife.risksurvey.task.controller.impl;

import java.util.Date;
import java.util.List;
import java.util.Map;

import com.chinalife.risksurvey.task.service.ISurveyProcessService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.chinalife.actual.service.IBusinessEntityService;
import com.chinalife.base.util.Pagination;
import com.chinalife.risksurvey.task.controller.ISurveyProcessController;
import com.chinalife.risksurvey.task.vo.ProcessParamEntity;
import com.chinalife.workflow.entity.ProcessInstanceEO;
import com.chinalife.workflow.service.IProcessInstanceService;

/**
 * 版权 @Copyright: 2017 www.chinalife-p.com Inc. All rights reserved.
 * 项目名称：policy-center-service<br/>
 * 文件名称： InsuranceProcessControllerImpl.java<br/>
 * 包名：com.chinalife.uw.controller.impl 创建人：@author axue016@pwc.com<br/>
 * 创建时间：Jun 19, 2017/4:02:46 PM<br/>
 * 修改人：axue016@pwc.com<br/>
 * 修改时间：Jun 19, 2017/4:02:46 PM<br/>
 * 修改备注：<br/>
 * 包名称： com.chinalife.uw.controller.impl 类名称：SurveyProcessControllerImpl<br/>
 * 类描述：活动流程处理类<br/>
 * 
 * @version <br/>
 *          TODO
 */
@RestController("surveyProcessController")
@RequestMapping("/controller/risksurvey/process")
public class SurveyProcessControllerImpl implements ISurveyProcessController {

    /** businessEntityService */
    @Autowired
    private IBusinessEntityService businessEntityService;

    /** processInstanceService */
    @Autowired
    private IProcessInstanceService processInstanceService;

    /** surveyProcessService */
    @Autowired
    private ISurveyProcessService surveyProcessService;

    @RequestMapping("/startProcessByKey")
    @Override
    public String startProcess(@RequestBody ProcessParamEntity processParamEntity) {

        return surveyProcessService.startProcess(processParamEntity);
    }

    @Override
    @RequestMapping("/startProcess")
    public String startProcess(@RequestParam(value = "schemaName", required = false) String schemaName,
            @RequestParam(value = "surveyId") Long surveyId,
            @RequestParam(value = "processDefinitionKey") String processDefinitionKey,
            @RequestParam(value = "taskType", required = false) String taskType,
            @RequestBody(required = false) Map<String, Object> paramMap) {

        return surveyProcessService.startProcess(schemaName, surveyId, processDefinitionKey, taskType, paramMap);
    }

    @Override
    @RequestMapping("/startProcessById")
    public ProcessInstanceEO startProcessInstanceById(
            @RequestParam(value = "schemaName", required = false) String schemaName,
            @RequestParam(value = "surveyId") Long surveyId,
            @RequestParam(value = "processDefinitionId") String processDefinitionId,
            @RequestParam(value = "effectiveDate") Date effectiveDate) {
        return businessEntityService.startProcessInstanceById(schemaName, surveyId, processDefinitionId,
                effectiveDate);
    }

    @Override
    @RequestMapping("/getPage")
    public @ResponseBody Pagination<?> get(@RequestBody Map<String, Object> parameters,
            @RequestParam(value = "from") Integer from, @RequestParam(value = "limit") Integer limit) {
        return processInstanceService.get(parameters, from, limit);
    }

    @Override
    @RequestMapping("/get")
    public @ResponseBody ProcessInstanceEO get(@RequestParam(value = "id") String id) {
        return processInstanceService.get(id);
    }

    @Override
    @RequestMapping("/getAll")
    public List<ProcessInstanceEO> getAll(@RequestBody Map<String, Object> parameters) {
        return processInstanceService.getAll(parameters);
    }
}
