package com.chinalife.risksurvey.task.service;

import java.util.List;
import java.util.Map;

import com.chinalife.base.service.IBaseService;
import com.chinalife.base.util.Pagination;
import com.chinalife.rbac.entity.RbacUserEO;
import com.chinalife.risksurvey.entity.SurveyTaskEO;
import com.chinalife.risksurvey.task.component.ISurveyTaskComponent;
import com.chinalife.risksurvey.task.repository.ISurveyTaskRepository;

/**
 * 包名称： com.chinalife.uw.service 类名称：ISurveyTaskService<br/>
 * 类描述：<br/>
 * 创建人：@author axue016@pwc.com<br/>
 * 创建时间：Jun 16, 2017/2:10:38 PM<br/>
 */
public interface ISurveyTaskService extends IBaseService<SurveyTaskEO, ISurveyTaskRepository, ISurveyTaskComponent> {

    /**
     * 查询当前用户所属机构对产品的审核权限级别
     *
     * @param userLoginName
     *            userId
     * @param productCode
     *            classCode
     * @param profile
     *            profile
     *
     * @return list
     */
    List<String> findAllUwLevel(String userLoginName, String productCode, String profile);

    /**
     * 查询任务流中所有的参数
     *
     * @param taskId
     *            taskId
     *
     * @return map
     */
    Map<String, Object> findAllVariable(String taskId);

    /**
     * update the flow variable
     *
     * @param taskId
     *            taskId
     * @param variableMap
     *            map
     *
     * @return boolean
     */
    Map<String, Object> updateFlowVariable(String taskId, Map<String, Object> variableMap);

    /**
     * get all variable
     *
     * @param surveyId
     *            surveyId
     *
     * @return map
     */
    Map<String, Object> findAllBySurveyId(Long surveyId);

    /**
     * 查询核保核批任务
     *
     * @param parameters
     *            参数
     * @param from
     *            开始位置
     * @param limit
     *            分页大小
     * @param sorting
     *            排序
     * @param kindList
     *            kind
     *
     * @return pagination
     */
    Pagination<SurveyTaskEO> findUwInsuranceTaskPagination(Map<String, Object> parameters, int from, int limit,
                                                           String sorting, List<String> kindList);

    /**
     * 完成当前任务节点
     *
     * @param taskId
     *            任务ID
     * @param obj
     *            参数
     * @param schemaName
     *            schema
     *
     * @return boolean
     */
    Boolean completeTask(String schemaName, String taskId, Map<String, Object> obj);

    /**
     * find task
     *
     * @param taskId
     *            taskid
     * @param kindList
     *            kind
     *
     * @return insuranceTaskEO
     */
    SurveyTaskEO findByTaskId(String taskId, List<String> kindList);

    /**
     * 领取任务
     *
     * @param taskIds
     *            taskIds
     * @param kindList
     *            kind
     *
     * @return boolean
     */
    Boolean reviceTask(String taskIds, List<String> kindList);

    /**
     * 指派任务
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
    Boolean assignTask(String taskIds, String userLoginName, String businessType);

    /**
     * 强制指派到人
     *
     * @param taskIds
     *            taskIds
     * @param userLoginName
     *            userId
     * @param businessType
     *            kind
     *
     * @return boolean
     */
    Boolean forceAssignTask(String taskIds, String userLoginName, String businessType);

    /**
     * 提交上级核保
     *
     * @param taskId
     *            taskid
     * @param newOwner
     *            organization
     * @param comments
     *            comments
     *
     * @return boolean
     */
    Boolean submitSuperiorTask(String taskId, String newOwner, String comments);

    /**
     * 通过核保
     *
     * @param comments
     *            comments
     * @param rbacUserEO
     *            user
     * @param taskId
     *            taskId
     * @param kindList
     *            kind
     *
     * @return SurveyTaskEO
     */
    SurveyTaskEO passTask(String comments, RbacUserEO rbacUserEO, String taskId, List<String> kindList);

    /**
     * 开始处理核保，修改状态为处理中
     *
     * @param taskId
     *            taskId
     * @param rbacUserEO
     *            user
     * @param kindList
     *            kind
     *
     * @return insuranceTaskEO
     */
    Boolean processTask(String taskId, RbacUserEO rbacUserEO, List<String> kindList);

    /**
     * 通过actualId查询InsuranceTaskEO对象
     *
     * @param surveyIds
     *            surveyIds
     * @param kindList
     *            kind
     *
     * @return String
     */
    String findTaskIdBySurveyId(String surveyIds, List<String> kindList);

    /**
     * find undone task by surveyId
     *
     * @param surveyId
     *            surveyId
     * @param kindList
     *            kind
     *
     * @return insuranceTaskEO
     */
    SurveyTaskEO findLastTaskBySurveyId(Long surveyId, List<String> kindList);

    /**
     * 撤回操作
     *
     * @param taskId
     *            taskId
     * @param comments
     *            comments
     * @param userCode
     *            userCode
     * @param kindList
     *            kindList
     *
     * @return insuranceTaskEO
     */
    SurveyTaskEO recallTask(String taskId, String comments, RbacUserEO userCode, List<String> kindList);

    /**
     * 退回
     *
     * @param taskId
     *            taskId
     * @param comments
     *            comments
     * @param uwLevel
     *            uwLevel
     * @param toClerk
     *            toClerk
     * @param kindList
     *            kind
     *
     * @return boolean
     */
    Boolean rejectTask(String taskId, String comments, String uwLevel, Boolean toClerk, List<String> kindList);

    /**
     * 放弃任务
     *
     * @param taskId
     *            taskId
     * @param kindList
     *            kind
     *
     * @return boolean
     */
    Boolean giveupTask(String taskId, List<String> kindList);

    /**
     * 申诉任务
     *
     * @param taskId
     *            taskId
     * @param suggestComment
     *            comments
     * @param findCurrentUser
     *            user
     *
     * @return insuranceTaskEO
     */

    SurveyTaskEO complainTask(String taskId, String suggestComment, RbacUserEO findCurrentUser);

    /**
     * top insurance task
     *
     * @param parameters
     *            parameter
     * @param kindList
     *            kind
     *
     * @return insuranceTaskEO
     */
    SurveyTaskEO topInsuranceTask(Map<String, Object> parameters, List<String> kindList);

    /**
     * retreat to clerk
     *
     * @param schema
     *            schema
     * @param surveyId
     *            surveyId
     * @param processInstanceKey
     *            kindList
     *
     * @return boolean
     */
    Boolean retreatToClerk(String schema, Long surveyId, String processInstanceKey);

    /**
     * cancel task
     *
     * @param schema
     *            schema
     * @param surveyId
     *            surveyId
     * @param comments
     *            comments
     * @param cancelCode
     *            cancelCode
     *
     * @return String
     */
    String cancelTask(String schema, Long surveyId, String cancelCode, String comments);

    /**
     * 获取批改查询的最新任务
     *
     * @param surveyIdList
     *            surveyIdList
     *
     * @return List<SurveyTaskEO>
     */
    List<SurveyTaskEO> findLastBySurveyIds(String surveyIdList);

    /**
     * find assignee
     *
     * @param taskIdList
     *            task id list
     * @param kind
     *            kind
     *
     * @return list
     */
    List<RbacUserEO> findAssignee(List<String> taskIdList, String kind);

    /**
     * 根据surveyId查询任务记录条数
     * 
     * @param surveyId
     *            surveyId
     * @return Long
     */
    Long getCountBySurveyId(Long surveyId);

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
     * 修改之前最新标志
     * 
     * @param surveyId
     *            surveyId
     * @return Boolean
     */
    Boolean updateBeforeNewFlag(Long surveyId);

    /**
     * 查询条件——风勘名称的任务表查询接口
     * 
     * @param parameters
     *            风勘部分名称及审批任务类型
     * @return List<String>
     */
    List<String> getSurveyNameList(Map<String, Object> parameters);

    /**
     * 风勘派工
     *
     * @param taskId
     *            任务ID
     * @param userLoginName
     *            用户
     * @param businessType
     *            kind
     */
    void surveyAssignTask(String taskId, String userLoginName, String businessType);

    /**
     * 更新
     * @param surveyTaskEO surveyTaskEO
     * @return Boolean
     */
    Boolean updateSurveyTask(SurveyTaskEO surveyTaskEO);


    /**  补充风堪
     * @param taskId taskId
     * @param comments comments
     * @param uwLevel uwLevel
     * @param toClerk toClerk
     * @param kindList kindList
     * @return Boolean
     */
    Boolean suppTask(String taskId, String comments, String uwLevel, Boolean toClerk, List<String> kindList);

    /**
     * 通过taskId获得当前风勘员
     * @param parameter parameter
     * @return SurveyTaskEO
     */
    SurveyTaskEO getSurveyerByTaskId(Map<String, Object> parameter);

}
