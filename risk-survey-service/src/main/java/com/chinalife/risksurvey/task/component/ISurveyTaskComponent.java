package com.chinalife.risksurvey.task.component;

import java.util.List;
import java.util.Map;
import java.util.function.Function;

import com.chinalife.base.component.IBaseComponent;
import com.chinalife.base.util.Pagination;
import com.chinalife.rbac.entity.RbacUserEO;
import com.chinalife.risksurvey.entity.SurveyTaskEO;
import com.chinalife.risksurvey.task.repository.ISurveyTaskRepository;

/**
 * 包名称： com.chinalife.contract.component 类名称：ISurveyTaskComponent<br/>
 * 类描述：<br/>
 * 创建人：@author axue016<br/>
 * 创建时间：Jun 20, 2017/3:33:38 PM<br/>
 */
public interface ISurveyTaskComponent extends IBaseComponent<SurveyTaskEO, ISurveyTaskRepository> {

    /**
     * 查询当前任务流中的所有参数
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
     * @return Map<String, Object>
     */
    Map<String, Object> updateFlowVariable(String taskId, Map<String, Object> variableMap);

    /**
     * 根据surveyId查找最新更改的数据
     *
     * @param surveyId
     *            surveyId
     * @param kindList
     *            kind
     *
     * @return SurveyTaskEO
     */
    SurveyTaskEO findLastTaskBySurveyId(Long surveyId, List<String> kindList);

    /**
     * 修改临分状态
     *
     * @param surveyId
     *            surveyId
     * @param status
     *            status
     *
     * @return SurveyTaskEO
     */
    SurveyTaskEO updateInquiryStatus(Long surveyId, String status);

    /**
     * find task
     *
     * @param taskId
     *            taskId
     * @param kindList
     *            kind
     *
     * @return SurveyTaskEO
     */
    SurveyTaskEO findTaskByTaskId(String taskId, List<String> kindList);

    /**
     * 完成任务
     *
     * @param schemaName
     *            分表
     * @param taskId
     *            任务ID
     * @param obj
     *            obj
     *
     * @return boolean
     */
    Boolean completeTask(String schemaName, String taskId, Map<String, Object> obj);

    /**
     * 分页查询核保核批任务
     *
     * @param parameters
     *            参数
     * @param from
     *            开始位置
     * @param limit
     *            限制
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
     * 查询状态不为Processed的核保单
     *
     * @param surveyId
     *            surveyId
     * @param kindList
     *            kind
     *
     * @return SurveyTaskEO
     */
    SurveyTaskEO findUndoneBySurveyId(Long surveyId, List<String> kindList);

    /**
     * 撤回核保单
     *
     * @param taskId
     *            taskID
     * @param comments
     *            comments
     * @param rbacUserEO
     *            user
     * @param kindList
     *            kind list
     *
     * @return SurveyTaskEO
     */
    SurveyTaskEO recallTask(String taskId, String comments, RbacUserEO rbacUserEO, List<String> kindList);

    /**
     * 指派任务
     *
     * @param taskIdList
     *            任务ID集合
     * @param loginName
     *            用户
     * @param kindList
     *            kind
     * @param validation
     *            validation
     *
     * @return boolean
     */
    Boolean assignTask(List<String> taskIdList, String loginName, List<String> kindList,
                       Function<SurveyTaskEO, Boolean> validation);

    /**
     * 核保通过
     *
     * @param surveyTaskEO
     *            surveyTaskEO
     * @param comments
     *            comments
     * @param taskId
     *            taskId
     *
     * @return SurveyTaskEO
     */
    SurveyTaskEO passTask(SurveyTaskEO surveyTaskEO, String comments, String taskId);

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
     * 提交上级核保
     *
     * @param taskId
     *            taskId
     *
     * @param newOwner
     *            organization
     * @param comments
     *            comments
     * @return boolean
     */
    Boolean submitSuperiorTask(String taskId, String newOwner, String comments);

    /**
     * 核保退回修改
     *
     * @param comments
     *            comments
     * @param taskId
     *            taskId
     * @param uwLevel
     *            uwLevel
     * @param toClerk
     *            toClerk
     *
     * @return boolean
     */
    Boolean rejectTask(String comments, String taskId, String uwLevel, Boolean toClerk);

    /**
     * 任务从待分配到待处理
     *
     * @param taskId
     *            任务ID
     * @param rbacUserEO
     *            用户
     * @param kindList
     *            kind
     *
     * @return boolean
     */
    Boolean processTask(String taskId, RbacUserEO rbacUserEO, List<String> kindList);

    /**
     * 根据task查找状态不为已完成的记录
     *
     * @param taskId
     *            taskId
     * @param kindList
     *            kind
     *
     * @return SurveyTaskEO
     */
    SurveyTaskEO findUndoneByTaskId(String taskId, List<String> kindList);

    /**
     * 查找未完成的task
     *
     * @param taskIds
     *            taskIds
     * @param kindList
     *            kind
     *
     * @return list
     */
    List<SurveyTaskEO> findUndoneByTaskIds(List<String> taskIds, List<String> kindList);

    /**
     * complain task
     *
     * @param taskId
     *            taskId
     * @param suggestComment
     *            comments
     * @param findCurrentUser
     *            user
     *
     * @return SurveyTaskEO
     */
    SurveyTaskEO complainTask(String taskId, String suggestComment, RbacUserEO findCurrentUser);

    /**
     * find all
     *
     * @param surveyId
     *            surveyId
     *
     * @return map
     */
    Map<String, Object> findAllBySurveyId(Long surveyId);

    /**
     * retreat to clerk
     *
     * @param schema
     *            schema
     * @param surveyId
     *            surveyId
     * @param processDefinitionKey
     *            processDefinationKey
     *
     * @return boolean
     */
    Boolean retreatToClerk(String schema, Long surveyId, String processDefinitionKey);

    /**
     * find all uw path
     *
     * @param rbacUserEO
     *            rbacUserEO
     * @param productCode
     *            productCode
     * @param profile
     *            profile
     *
     * @return list
     */
    List<String> findUwPath(RbacUserEO rbacUserEO, String productCode, String profile);

    /**
     * cancel task
     *
     * @param schema
     *            schema
     * @param surveyIds
     *            surveyIds
     * @param cancelCode
     *            cancelCode
     * @param comments
     *            comments
     * @return boolean
     */
    Boolean cancelTask(String schema, Long surveyIds, String cancelCode, String comments);

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
     * 根据surveyId查询所有有最新标志的任务，一盘只有一条；
     * 
     * @param surveyId
     *            surveyId
     * @return List<SurveyTaskEO>
     */
    List<SurveyTaskEO> getAllNewBySurveyId(Long surveyId);

    /**
     * 查询条件——风勘名称的任务表查询接口
     * 
     * @param parameters
     *            风勘部分名称及审批任务类型
     * @return List<String>
     */
    List<String> getSurveyNameList(Map<String, Object> parameters);

    /**
     * 更新
     * @param surveyTaskEO surveyTaskEO
     */
    void updateSurveyTask(SurveyTaskEO surveyTaskEO);

    /**
     * @param comments comments
     * @param taskId taskId
     * @param uwLevel uwLevel
     * @param toClerk toClerk
     * @return Boolean
     */
    Boolean suppTask(String comments, String taskId, String uwLevel, Boolean toClerk);
}
