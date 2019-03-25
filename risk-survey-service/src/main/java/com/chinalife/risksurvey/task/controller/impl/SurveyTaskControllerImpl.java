package com.chinalife.risksurvey.task.controller.impl;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;

import com.chinalife.risksurvey.entity.SurveyTaskEO;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.chinalife.base.util.Pagination;
import com.chinalife.rbac.entity.RbacUserEO;
import com.chinalife.rbac.filter.service.ICurrentRbacUserService;
import com.chinalife.risksurvey.task.controller.ISurveyTaskController;
import com.chinalife.risksurvey.task.service.ISurveyTaskService;

/**
 * base insrurance task
 *
 * @author jzhou237
 * @version 1
 */
@RestController("surveyTaskController")
@RequestMapping("/controller/risksurvey/surveytask")
public class SurveyTaskControllerImpl implements ISurveyTaskController {

    /**
     * rbacUserService
     */
    @Autowired
    protected ICurrentRbacUserService rbacUserService;

    /**
     * surveyTaskService
     */
    @Autowired
    protected ISurveyTaskService surveyTaskService;

    @GetMapping(value = "/findAllVariable", produces = "application/json;charset=utf-8")
    @ResponseBody
    @Override
    public Map<String, Object> findAllVariable(@RequestParam("taskId") String taskId) {
        return this.surveyTaskService.findAllVariable(taskId);
    }

    @GetMapping(value = "/findAllBySurveyId", produces = "application/json;charset=utf-8")
    @ResponseBody
    @Override
    public Map<String, Object> findAllBySurveyId(@RequestParam("surveyId") Long surveyId) {
        return this.surveyTaskService.findAllBySurveyId(surveyId);
    }

    @PostMapping(value = "/updateFlowVariable", produces = "application/json;charset=utf-8")
    @ResponseBody
    @Override
    public Map<String, Object> updateFlowVariable(@RequestBody Map<String, Object> variableMap,
            @RequestParam("taskId") String taskId) {
        return this.surveyTaskService.updateFlowVariable(taskId, variableMap);
    }

    @GetMapping(value = "/findAllUwLevel", produces = "application/json;charset=utf-8")
    @ResponseBody
    @Override
    public List<String> findAllUwLevel(@RequestParam("surveyId") Long surveyId) {
        RbacUserEO rbacUserEO = this.rbacUserService.findCurrentUser();

        /*
         * BusinessEntity businessEntity =
         * businessEntityService.getCachedBusinessEntity(null, surveyId);
         * ContractBusinessEntity contractBusinessEntity = new
         * ContractBusinessEntity(businessEntity); PlcMainEO plcMainEO =
         * contractBusinessEntity.getPlcMain(); return
         * this.insuranceTaskService.findAllUwLevel(rbacUserEO.getLoginName(),
         * plcMainEO.getProductCode(),
         * PROFILE_AUDIT_PATH.getKindByBusinessType(plcMainEO.getBusinessType())
         * );
         */
        return null;
    }

    @RequestMapping(value = "/reportTask")
    @ResponseBody
    @Override
    public Boolean reportTask(@RequestParam("taskId") String taskId,
            @RequestParam(value = "newOwner", required = false) String newOwner,
            @RequestParam(value = "comments", required = false) String comments) {
        return this.surveyTaskService.submitSuperiorTask(taskId, newOwner, comments);
    }

    @Override
    @RequestMapping(value = "/completeTask")
    public Boolean completeTask(@RequestParam(value = "schemaName", required = false) String schemaName,
            @RequestParam(value = "taskId") String taskId, @RequestBody(required = false) Map<String, Object> obj) {
        Boolean rs = surveyTaskService.completeTask(schemaName, taskId, obj);

        return rs;
    }

    @Override
    @RequestMapping(value = "/complainTask")
    @ResponseBody
    public SurveyTaskEO complainTask(String taskId, String suggestComment) {

        return surveyTaskService.complainTask(taskId, suggestComment, rbacUserService.findCurrentUser());
    }

    @PostMapping(value = "/retreatToClerk", produces = "application/json;charset=utf-8")
    @ResponseBody
    @Override
    public Boolean retreatToClerk(@RequestParam(value = "schema", required = false) String schema,
            @RequestParam("surveyId") Long surveyId,
            @RequestParam("processInstanceKey") String processInstanceKey) {
        return this.surveyTaskService.retreatToClerk(schema, surveyId, processInstanceKey);
    }

    @PostMapping(value = "/cancelTask", produces = "application/jason;charset=utf-8")
    @ResponseBody
    @Override
    public String cancelTask(@RequestParam(value = "schema", required = false) String schema,
            @RequestParam("surveyId") Long surveyId,
            @RequestParam(value = "cancelCode", required = false) String cancelCode,
            @RequestParam(value = "comments", required = false) String comments) {
        return this.surveyTaskService.cancelTask(schema, surveyId, cancelCode, comments);
    }

    @Override
    @RequestMapping(value = "/recallTask", produces = "application/json;charset=utf-8")
    public SurveyTaskEO recallTask(@RequestParam("taskId") String taskId,
                                   @RequestParam(value = "comments", required = false) String comments) {
        return this.surveyTaskService.recallTask(taskId, comments, rbacUserService.findCurrentUser(), getKindList());
    }

    @GetMapping(value = "/getUwLevelList", produces = "application/json;charset=utf-8")
    @ResponseBody
    @Override
    public List<String> getUwLevelList(@RequestParam("productCode") String productCode) {
        RbacUserEO rbacUserEO = this.rbacUserService.findCurrentUser();
        return this.surveyTaskService.findAllUwLevel(rbacUserEO.getLoginName(), productCode, "underwriting");
    }

    @RequestMapping(value = "/reviceTask")
    @ResponseBody
    @Override
    public Boolean reviceTask(@RequestParam(value = "taskIds") String taskIds) {
        return this.surveyTaskService.reviceTask(taskIds, getKindList());
    }

    @RequestMapping(value = "/assignTask")
    @ResponseBody
    @Override
    public Boolean assignTask(@RequestParam("taskIds") String taskIds, @RequestParam("newOwner") String newOwner) {
        return this.surveyTaskService.assignTask(taskIds, newOwner, getBusinessType());
    }

    @RequestMapping(value = "/forceAssignTask")
    @ResponseBody
    @Override
    public Boolean forceAssignTask(@RequestParam("taskIds") String taskIds, @RequestParam("newOwner") String newOwner) {
        return this.surveyTaskService.forceAssignTask(taskIds, newOwner, getBusinessType());
    }

    @RequestMapping(value = "/findSurveyTaskEOByTaskId")
    @ResponseBody
    @Override
    public SurveyTaskEO findSurveyTaskEOByTaskId(@RequestParam("taskId") String taskId) {

        return this.surveyTaskService.findByTaskId(taskId, getKindList());
    }

    @Override
    @RequestMapping(value = "/retreatTask", produces = "application/json;charset=utf-8")
    @ResponseBody
    public Boolean retreatTask(@RequestParam(value = "comments", required = false) String comments, @RequestParam("taskId") String taskId,
            @RequestParam(value = "uwLevel", required = false) String uwLevel,
            @RequestParam(value = "toClerk", required = false) String toClerk) {
        return this.surveyTaskService.rejectTask(taskId, comments, uwLevel, Boolean.valueOf(toClerk), getKindList());
    }
    
    @Override
    @RequestMapping(value = "/suppTask", produces = "application/json;charset=utf-8")
    @ResponseBody
    public Boolean suppTask(@RequestParam(value = "comments", required = false) String comments, @RequestParam("taskId") String taskId,
            @RequestParam(value = "uwLevel", required = false) String uwLevel,
            @RequestParam(value = "toClerk", required = false) String toClerk) {
        return this.surveyTaskService.suppTask(taskId, comments, uwLevel, Boolean.valueOf(toClerk), getKindList());
    }
    
    @Override
    @RequestMapping(value = "/topInsuranceTask", method = RequestMethod.POST, produces = "application/json;charset=utf-8")
    @ResponseBody
    public SurveyTaskEO topInsuranceTask(@RequestBody Map<String, Object> parameters) {
        return this.surveyTaskService.topInsuranceTask(parameters, getKindList());
    }

    @Override
    @RequestMapping(value = "/processTask", produces = "application/json;charset=utf-8")
    @ResponseBody
    public Boolean processTask(@RequestParam("taskId") String taskId) {
        return this.surveyTaskService.processTask(taskId, this.rbacUserService.findCurrentUser(), getKindList());
    }

    @Override
    @RequestMapping(value = "/passTask", produces = "application/json;charset=utf-8")
    @ResponseBody
    public SurveyTaskEO passTask(@RequestParam(value = "comments", required = false) String comments,
            @RequestParam("taskId") String taskId) {
        return this.surveyTaskService.passTask(comments, this.rbacUserService.findCurrentUser(), taskId, getKindList());
    }
    

    @RequestMapping(value = "/giveupTask")
    @ResponseBody
    @Override
    public Boolean giveupTask(String taskId) {
        return this.surveyTaskService.giveupTask(taskId, getKindList());
    }

    /**
     * getKindList
     *
     * @return kindList
     */
    protected List<String> getKindList() {
        return new ArrayList<>();
    }

    /**
     * get business type
     *
     * @return type
     */
    protected String getBusinessType() {
        return "";
    }

    /**
     * 根据条件查询任务分页列表
     */
    @ResponseBody
    @RequestMapping(value = "/getAuditTaskPages", produces = "application/json;charset=utf-8")
    @Override
    public Pagination<SurveyTaskEO> getAuditTaskPages(@RequestBody(required = false) Map<String, Object> parameters,
                                                      @RequestParam("from") int from, @RequestParam("limit") int limit,
                                                      @RequestParam(value = "sorting", required = false) String sorting) {
        return this.surveyTaskService.getAuditTaskPages(parameters, from, limit, sorting);
    }
    
    /**
     * 根据条件查询我的任务分页列表
     */
    @ResponseBody
    @RequestMapping(value = "/getMyTaskPages", produces = "application/json;charset=utf-8")
    @Override
    public Pagination<SurveyTaskEO> getMyTaskPages(@RequestBody(required = false) Map<String, Object> parameters,
                                                   @RequestParam("from") int from, @RequestParam("limit") int limit,
                                                   @RequestParam(value = "sorting", required = false) String sorting) {
        return this.surveyTaskService.getMyTaskPages(parameters, from, limit, sorting);
    }
    
    /**
     * 根据条件查询我的任务分页列表
     */
    @ResponseBody
    @RequestMapping(value = "/getSurveyNameList", produces = "application/json;charset=utf-8")
    @Override
    public List<String> getSurveyNameList(@RequestBody Map<String, Object> parameters) {
        return this.surveyTaskService.getSurveyNameList(parameters);
    }

    @Override
    @RequestMapping(value = "/findAssignUser", produces = "application/json;charset=utf-8")
    @ResponseBody
    public List<RbacUserEO> findAssignUser(@RequestBody List<String> taskIdList) {
        // FIXME 废弃
        return  null;
    }

    @RequestMapping(value = "/surveyAssignTask")
    @ResponseBody
    @Override
    public Boolean surveyAssignTask(String taskIds, String userLoginName, String businessType) {
        List<String> taskIdList = Arrays.asList(taskIds.split(","));
        for (String taskId : taskIdList) {
            this.surveyTaskService.surveyAssignTask(taskId, userLoginName, businessType);
        }
        return true;
    }
    
    @RequestMapping(value = "/surveyerByTaskId")
    @ResponseBody
    @Override
    public SurveyTaskEO getSurveyerByTaskId(@RequestBody(required = false) Map<String, Object> parameter) {
        
        return surveyTaskService.getSurveyerByTaskId(parameter);
    }
    
    @RequestMapping(value = "/surveyReAssignTask")
    @ResponseBody
    @Override
    public Boolean surveyReAssignTask(String taskIds, String userLoginName, String businessType) {
        List<String> taskIdList = Arrays.asList(taskIds.split(","));
        for (String taskId : taskIdList) {
            this.surveyTaskService.surveyAssignTask(taskId, userLoginName, businessType);
        }
        return true;
    }
}
