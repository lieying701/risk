package com.chinalife.risksurvey.task.controller;

import java.util.List;
import java.util.Map;

import com.chinalife.rbac.entity.RbacUserEO;
import com.chinalife.risksurvey.entity.SurveyTaskEO;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.chinalife.base.util.Pagination;

/**
 * 包名称： com.chinalife.uw.controller 类名称：ISurveyTaskController<br/>
 * 类描述：保单任务处理 创建人：@author axue016@pwc.com<br/>
 * 创建时间：Jun 16, 2017/2:12:43 PM<br/>
 */
public interface ISurveyTaskController {

    /**
     * 查询任务流所有参数
     *
     * @param taskId
     *            taskId
     *
     * @return map
     */
    Map<String, Object> findAllVariable(String taskId);

    /**
     * 查询产品在用户下的的核保权限
     *
     * @param surveyId
     *            surveyId
     *
     * @return list
     */
    List<String> findAllUwLevel(Long surveyId);

    /**
     * update the flow variable
     *
     * @param variableMap
     *            map
     * @param taskId
     *            taskId
     *
     * @return boolean
     */
    Map<String, Object> updateFlowVariable(Map<String, Object> variableMap, String taskId);

    /**
     * 根据任务ID查询SurveyTaskEO
     *
     * @param taskId    taskId
     *
     * @return SurveyTaskEO
     */
    SurveyTaskEO findSurveyTaskEOByTaskId(String taskId);

    /**
     * 增加置顶接口，通过传入参数taskId，topFlag.通过taskId更新topFlag的值
     *
     * @param parameters
     *            parameter
     *
     * @return surveyTaskEO
     */
    @RequestMapping(value = "/topInsuranceTask", method = RequestMethod.POST, produces = "application/json;charset=utf-8")
    @ResponseBody
    SurveyTaskEO topInsuranceTask(@RequestBody Map<String, Object> parameters);

    /**
     * 分配任务
     *
     * @param taskIds
     *            taskIds
     * @param ownerName
     *            ownerName
     *
     * @return boolean
     */
    Boolean assignTask(String taskIds, String ownerName);

    /**
     * 强制指派
     *
     * @param taskIds
     *            任务ID
     * @param newOwner
     *            强制执行人
     *
     * @return boolean
     */
    Boolean forceAssignTask(String taskIds, String newOwner);

    /**
     * 放弃任务
     *
     * @param taskId
     *            taskId
     *
     * @return boolean
     */
    Boolean giveupTask(String taskId);

    /**
     * 领取任务
     *
     * @param taskIds
     *            任务ID集合
     *
     * @return boolean
     */
    Boolean reviceTask(String taskIds);

    /**
     * 关闭任务，通用，返回下个任务节点的新任务Id
     *
     * @param schemaName
     *            schema
     * @param taskId
     *            taskid
     * @param obj
     *            obj
     *
     * @return boolean
     */
    @RequestMapping(value = "/completeTask", method = RequestMethod.POST, produces = "application/json;charset=utf-8")
    Boolean completeTask(@RequestParam(value = "schemaName", required = false) String schemaName,
                         @RequestParam("taskId") String taskId, @RequestBody Map<String, Object> obj);

    /**
     * 提交上级核保
     *
     * @param taskId
     *            taskId
     * @param newOwner
     *            newOwner
     * @param comments
     *            comments
     *
     * @return boolean
     */
    Boolean reportTask(String taskId, String newOwner, String comments);

    /**
     * 撤回核保单
     *
     * @param taskId
     *            taskId
     * @param comments
     *            comments
     *
     * @return SurveyTaskEO
     */
    SurveyTaskEO recallTask(@RequestParam("taskId") String taskId, @RequestParam("comments") String comments);

    /**
     * 开始处理，修改状态为处理中
     *
     * @param taskId
     *            taskId
     *
     * @return SurveyTaskEO
     */
    Boolean processTask(String taskId);

    /**
     * 退回修改
     *
     * @param comments
     *            comments
     * @param taskId
     *            taskId
     * @param uwLevel
     *            uwLevel
     * @param toClerk
     *            toTemp
     *
     * @return SurveyTaskEO
     */
    Boolean retreatTask(String comments, String taskId, String uwLevel, String toClerk);

    /**
     * 根据surveyId查询流程中的所有参数
     *
     * @param surveyId
     *            surveyId
     *
     * @return map
     */
    Map<String, Object> findAllBySurveyId(@RequestParam("surveyId") Long surveyId);

    /**
     * 审核通过
     *
     * @param comments
     *            comments
     * @param taskId
     *            taskId
     *
     * @return surveyTaskEO
     */
    SurveyTaskEO passTask(@RequestParam("comments") String comments, @RequestParam("taskId") String taskId);

    /**
     * 申诉报价单
     *
     * @param coments
     *            comments
     * @param taskId
     *            taskId
     *
     * @return surveyTaskEO
     */
    SurveyTaskEO complainTask(@RequestParam("taskId") String taskId, @RequestParam("coments") String coments);

    /**
     * retreat to record clerk
     *
     * @param schema
     *            schema
     * @param surveyId
     *            surveyId
     * @param processInstanceKey
     *            processInstanceKey
     *
     * @return boolean
     */
    Boolean retreatToClerk(String schema, Long surveyId, String processInstanceKey);

    /**
     * cancel the task
     *
     * @param schema
     *            schema
     * @param surveyId
     *            surveyId
     * @param cancelCode
     *            cancelCode
     * @param comments
     *            comments
     *
     * @return String
     */
    String cancelTask(String schema, Long surveyId, String cancelCode, String comments);

    /**
     * 获得权限树
     * 
     * @param productCode
     *            productCode
     * @return List<String>
     */
    List<String> getUwLevelList(String productCode);

    /**
     * 根据条件查询任务分页列表
     * 
     * @param parameters
     *            parameters
     * @param from
     *            from
     * @param limit
     *            limit
     * @param sorting
     *            sorting
     * @return Pagination
     */
    Pagination<SurveyTaskEO> getAuditTaskPages(Map<String, Object> parameters, int from, int limit, String sorting);

    /**
     * 根据条件查询我的任务分页列表
     * 
     * @param parameters
     *            parameters
     * @param from
     *            from
     * @param limit
     *            limit
     * @param sorting
     *            sorting
     * @return Pagination
     */
    Pagination<SurveyTaskEO> getMyTaskPages(Map<String, Object> parameters, int from, int limit, String sorting);

    /**
     * 查询条件——风勘名称的任务表查询接口
     * 
     * @param parameters
     *            风勘部分名称及审批任务类型
     * @return List<String>
     */
    List<String> getSurveyNameList(Map<String, Object> parameters);

    /**
     * 查询可以指派的人
     *
     * @param taskIdList
     *            taskList
     *
     * @return 返回人员集合
     */
    List<RbacUserEO> findAssignUser(List<String> taskIdList);

    /**
     * 风勘派工
     *
     * @param taskIds
     *            任务ID
     * @param userLoginName
     *            用户
     * @param businessType
     *            kind
     *
     * @return boolean
     */
    Boolean surveyAssignTask(String taskIds, String userLoginName, String businessType);

    /**   补充风堪
     * @param comments comments
     * @param taskId taskId
     * @param uwLevel uwLevel
     * @param toClerk toClerk
     * @return Boolean
     */
    Boolean suppTask(String comments, String taskId, String uwLevel, String toClerk);

    /**
     * 通过taskId获得当前风勘员
     * @param parameter parameter
     * @return SurveyTaskEO
     */
    SurveyTaskEO getSurveyerByTaskId(Map<String, Object> parameter);

    /**
     * 风勘转派
     * @param taskIds 任务ID
     * @param userLoginName 用户名
     * @param businessType 类型
     * @return Boolean
     */
    Boolean surveyReAssignTask(String taskIds, String userLoginName, String businessType);

}
