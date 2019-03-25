package com.chinalife.risksurvey.task.component.impl;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.function.Function;

import com.chinalife.risksurvey.entity.SurveyTaskEO;
import com.chinalife.risksurvey.task.component.ISurveyTaskComponent;
import org.activiti.engine.HistoryService;
import org.activiti.engine.RuntimeService;
import org.activiti.engine.history.HistoricTaskInstance;
import org.activiti.engine.history.HistoricVariableInstance;
import org.apache.commons.collections4.CollectionUtils;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.chinalife.base.component.impl.BaseComponentImpl;
import com.chinalife.base.context.BaseContext;
import com.chinalife.base.context.BaseContextManager;
import com.chinalife.base.database.QueryObject;
import com.chinalife.base.database.QueryObject.QueryType;
import com.chinalife.base.database.QueryObjectFactory;
import com.chinalife.base.exception.StandardRuntimeException;
import com.chinalife.base.util.Pagination;
import com.chinalife.hr.core.entity.StructureEO;
import com.chinalife.hr.core.service.IStructureService;
import com.chinalife.rbac.domain.LoginStructure;
import com.chinalife.rbac.entity.RbacUserEO;
import com.chinalife.rbac.service.IRbacUserService;
import com.chinalife.risksurvey.entity.UWSuggestionEO;
import com.chinalife.risksurvey.task.constants.CommonConstants;
import com.chinalife.risksurvey.task.constants.ContractBusinessType;
import com.chinalife.risksurvey.task.constants.OperationType;
import com.chinalife.risksurvey.task.constants.TaskStatusEnum;
import com.chinalife.risksurvey.task.constants.TaskTypeEnum;
import com.chinalife.risksurvey.task.repository.ISurveyTaskRepository;
import com.chinalife.risksurvey.utils.DateUtils;
import com.chinalife.risksurvey.utils.QueryCondition;
import com.chinalife.risksurvey.utils.QueryCondition.QueryConditionOperatorType;
import com.chinalife.workflow.component.ITaskComponent;
import com.chinalife.workflow.entity.TaskEO;
import com.chinalife.workflow.service.ITaskService;

/**
 * 包名称： com.chinalife.uw.component.impl 类名称：SurveyTaskComponentImpl<br/>
 * 类描述：<br/>
 * 创建人：@author axue016<br/>
 * 创建时间：Jun 20, 2017/3:38:10 PM<br/>
 */
@Component("surveyTaskComponent")
public class SurveyTaskComponentImpl extends BaseComponentImpl<SurveyTaskEO, ISurveyTaskRepository>
        implements ISurveyTaskComponent {

    /**
     * rbacUserService
     */
    @Autowired
    private IRbacUserService userService;

    /**
     * taskComponent
     */
    @Autowired
    private ITaskComponent taskComponent;

    /**
     * taskService
     */
    @Autowired
    private ITaskService taskService;

    /**
     * runtimeService
     */
    @Autowired
    private RuntimeService runtimeService;

    /**
     * historyService
     */
    @Autowired
    private HistoryService historyService;

    /**
     * structureservice
     */
    @Autowired
    private IStructureService structureService;

    @Override
    public Map<String, Object> findAllVariable(String taskId) {
        TaskEO taskEO = this.taskService.get(taskId);
        Map<String, Object> variableMap = new HashMap<>();
        if (taskEO != null) {
            variableMap.putAll(this.runtimeService.getVariables(taskEO.getExecutionId()));
        } else {
            HistoricTaskInstance historicTaskInstance = historyService.createHistoricTaskInstanceQuery().finished()
                    .taskId(taskId).orderByProcessDefinitionId().desc().singleResult();
            if (historicTaskInstance != null) {
                List<HistoricVariableInstance> historicVariableInstanceList = historyService
                        .createHistoricVariableInstanceQuery()
                        .processInstanceId(historicTaskInstance.getProcessInstanceId()).list();
                if (CollectionUtils.isNotEmpty(historicVariableInstanceList)) {
                    for (HistoricVariableInstance historicVariableInstance : historicVariableInstanceList) {
                        variableMap.put(historicVariableInstance.getVariableName(),
                                historicVariableInstance.getValue());
                    }
                }
            }
        }
        return variableMap;
    }

    @Override
    public Map<String, Object> updateFlowVariable(String taskId, Map<String, Object> variableMap) {
        TaskEO taskEO = this.taskService.get(taskId);
        Map<String, Object> savedVariableMap = new HashMap<>();
        if (taskEO != null) {
            savedVariableMap = this.runtimeService.getVariables(taskEO.getExecutionId());
            savedVariableMap.putAll(variableMap);
            this.runtimeService.setVariables(taskEO.getExecutionId(), savedVariableMap);
        } else {
            logger.warn("{}.{}---任务不存在或已完成[]", this.getClass().getSimpleName(), "updateFlowVariable", taskId);
        }
        return savedVariableMap;
    }

    @Override
    public Map<String, Object> findAllBySurveyId(Long surveyId) {
        SurveyTaskEO surveyTaskEO = this.getBaseRepository().findLastTaskBySurveyId(surveyId, null);
        Map<String, Object> variableMap = new HashMap<>();
        if (surveyTaskEO != null) {
            variableMap = findAllVariable(surveyTaskEO.getTaskId());
            variableMap.put("taskId", surveyTaskEO.getTaskId());
        }
        return variableMap;
    }

    @Override
    public SurveyTaskEO findTaskByTaskId(String taskId, List<String> kindList) {
        return this.getBaseRepository().findTaskByTaskId(taskId, kindList);
    }

    @Override
    public Pagination<SurveyTaskEO> findUwInsuranceTaskPagination(Map<String, Object> parameter, int from, int limit,
                                                                  String sorting, List<String> kindList) {

        return null;
    }

    @Override
    public SurveyTaskEO findUndoneBySurveyId(Long surveyId, List<String> kindList) {
        return this.getBaseRepository().findUndoneTaskBySurveyId(surveyId, kindList);
    }

    @Override
    public SurveyTaskEO updateInquiryStatus(Long surveyId, String status) {
        SurveyTaskEO surveyTaskEO = this.getBaseRepository().findLastTaskBySurveyId(surveyId, null);
        if (surveyTaskEO == null) {
            throw new StandardRuntimeException("任务未查询到!");
        }
        if (surveyTaskEO != null && StringUtils.isNotBlank(status)) {
            surveyTaskEO.setUpdateDate(DateUtils.getCurrentDate());
            // surveyTaskEO.setInquiryStatus(status);
            this.update(surveyTaskEO);
        }
        return surveyTaskEO;
    }

    @Override
    public SurveyTaskEO findLastTaskBySurveyId(Long surveyId, List<String> kindList) {
        return this.getBaseRepository().findLastTaskBySurveyId(surveyId, kindList);
    }
    // -------------------以下是流程控制部分，请不要随意删除修改---------------------------------------

    @Override
    public Boolean processTask(String taskId, RbacUserEO rbacUserEO, List<String> kindList) {
        Boolean result = Boolean.FALSE;
        SurveyTaskEO surveyTaskEO = this.findTaskByTaskId(taskId, kindList);
        if (surveyTaskEO == null) {
            logger.error("查询不到Task，taskId为：{}", taskId);
            throw new StandardRuntimeException("查询不到该任务：" + taskId);
        } else if (rbacUserEO == null) {
            logger.error("当前登录用户信息为空{}", rbacUserEO);
            throw new StandardRuntimeException("请登录");
        } else if (rbacUserEO != null && StringUtils.isNotEmpty(surveyTaskEO.getAssignee())
                && !StringUtils.equals(surveyTaskEO.getAssignee(), rbacUserEO.getLoginName())) {
            throw new StandardRuntimeException("该任务" + surveyTaskEO.getAssigneeName() + "正在处理。");
        } else if (TaskStatusEnum.isPending(surveyTaskEO.getStatus())) {
            surveyTaskEO.setFetchTime(DateUtils.getCurrentDate());
            surveyTaskEO.setStatus(TaskStatusEnum.Processing.getCode());
            surveyTaskEO.setSubmitTime(DateUtils.getCurrentDate());
            surveyTaskEO.setStartTime(DateUtils.getCurrentDate());
            this.getBaseRepository().update(surveyTaskEO);
            result = Boolean.TRUE;
        }
        return result;
    }

    @Override
    public SurveyTaskEO recallTask(String taskId, String comments, RbacUserEO rbacUserEO, List<String> kindList) {
        if (rbacUserEO == null) {
            throw new StandardRuntimeException("请登录");
        }
        SurveyTaskEO surveyTaskEO = this.getBaseRepository().findTaskByTaskId(taskId, kindList);
        if (surveyTaskEO == null) {
            throw new StandardRuntimeException("该用户无权限，请检查用户权限配置");
        }
        SurveyTaskEO nextSurveyTaskEO = this.getBaseRepository().findLastTaskBySurveyId(surveyTaskEO.getSurveyId(),
                kindList);
        if (TaskStatusEnum.isProcessing(nextSurveyTaskEO.getStatus())
                || TaskStatusEnum.isProcessed(nextSurveyTaskEO.getStatus())) {
            logger.info("{}.{}---当前任务状态为:{}", this.getClass().getSimpleName(), "recallTask", surveyTaskEO.getStatus());
            throw new StandardRuntimeException("该任务已被[" + nextSurveyTaskEO.getAssigneeName() + "]处理，无法回撤");
        }

        Map<String, Object> paramMap = new HashMap<>();
        if (StringUtils.isNotEmpty(comments)) {
            UWSuggestionEO uwSuggestionEO = new UWSuggestionEO();
            uwSuggestionEO.setSuggestComment(comments);
            uwSuggestionEO.setSuggestType(UWSuggestionEO.SuggestionType.Recall.toString());
            paramMap.put(CommonConstants.UW_SUGGEST, uwSuggestionEO);
        }
        paramMap.put(CommonConstants.OPERATION_TYPE, OperationType.RECALL.getCode());
        paramMap.put(CommonConstants.ASSIGNEE, rbacUserEO.getLoginName());
        this.completeTask("", nextSurveyTaskEO.getTaskId(), paramMap);
        return null;
    }

    @SuppressWarnings("unchecked")
    @Override
    public Boolean completeTask(String schemaName, String taskId, Map<String, Object> requestParamMap) {

        if (StringUtils.isBlank(taskId)) {
            logger.error("任务ID为空, ID:{}", taskId);
            throw new StandardRuntimeException("查询不到任务");
        }
        TaskEO taskEO = this.taskComponent.get(taskId);
        try {
            if (requestParamMap != null && taskEO != null) {
                Map<String, Object> variables1 = runtimeService.getVariables(taskEO.getProcessInstanceId());
                Map<String, Object> paramMap = (Map<String, Object>) variables1
                        .get(ContractBusinessType.processDefinitionMap.name());
                if (paramMap == null) {
                    variables1.put(ContractBusinessType.processDefinitionMap.name(), requestParamMap);
                } else {
                    paramMap.putAll(requestParamMap);
                }
                variables1.put(ContractBusinessType.currentTaskId.name(), taskId);
                runtimeService.setVariables(taskEO.getProcessInstanceId(), variables1);
            }
            this.taskService.complete(taskId, new HashMap<>(), false);
            return Boolean.TRUE;
        } catch (Exception ex) {
            logger.error("Fail to Execute Task [" + taskId + "], Message:" + ex.getMessage(), ex);
            String message = this.handlerException(ex);
            if (StringUtils.isEmpty(message)) {
                int causeLevel = 3;
                int stackIndex = 0;
                Throwable cause = ex.getCause();
                while (StringUtils.isEmpty(message) && cause != null && stackIndex < causeLevel) {
                    message = this.handlerException(cause);
                    cause = cause.getCause();
                    stackIndex++;
                }
            }
            throw new StandardRuntimeException(StringUtils.isEmpty(message) ? "任务执行失败: " + ex : message, ex);
        }
    }

    /**
     * exception handler
     *
     * @param throwable
     *            e
     *
     * @return string
     */
    private String handlerException(Throwable throwable) {
        String message = null;
        if (throwable != null && throwable instanceof StandardRuntimeException) {
            StandardRuntimeException standardRuntimeException = (StandardRuntimeException) throwable;
            message = standardRuntimeException.getKey();
        }
        return message;
    }

    @Override
    public SurveyTaskEO passTask(SurveyTaskEO surveyTaskEo, String comments, String taskId) {
        Map<String, Object> paramMap = new HashMap<>();
        paramMap.put(CommonConstants.OPERATION_TYPE, OperationType.PASS.getCode());
        this.completeTask("", taskId, paramMap);
        return surveyTaskEo;
    }

    @Override
    public Boolean assignTask(List<String> taskIdList, String loginName, List<String> kindList,
            Function<SurveyTaskEO, Boolean> validation) {
        RbacUserEO rbacUserEO = this.userService.findByLoginName(loginName);
        // RbacUserEO rbacUserEO = this.userService.findByLoginName(loginName);
        if (rbacUserEO == null) {
            throw new StandardRuntimeException("用户[登录名:" + loginName + "]不存在");
        }
        List<SurveyTaskEO> insuranceTaskList = this.findUndoneByTaskIds(taskIdList, kindList);

        for (SurveyTaskEO surveyTaskEO : insuranceTaskList) {
            if (!validation.apply(surveyTaskEO)) {
                throw new StandardRuntimeException("查询不到任务！");
            }
            if (TaskStatusEnum.isPending(surveyTaskEO.getStatus())
                    || TaskStatusEnum.isProcessing(surveyTaskEO.getStatus())) {
                this.taskService.changeAssignee(surveyTaskEO.getTaskId(), rbacUserEO.getLoginName());
            }
            surveyTaskEO.setAssignee(rbacUserEO.getLoginName());
            surveyTaskEO.setAssigneeName(rbacUserEO.getName());
            surveyTaskEO.setFetchTime(DateUtils.getCurrentDate());
            surveyTaskEO.setStatus(TaskStatusEnum.Pending.getCode());
            this.getBaseRepository().update(surveyTaskEO);

            List<String> assigneeList = new ArrayList<>();
            assigneeList.add(rbacUserEO.getLoginName());
        }
        return Boolean.TRUE;
    }

    @Override
    public Boolean submitSuperiorTask(String taskId, String uwLevel, String comments) {
        Map<String, Object> paramMap = new HashMap<>();
        if (StringUtils.isNotEmpty(comments)) {
            UWSuggestionEO uwSuggestionEO = new UWSuggestionEO();
            uwSuggestionEO.setSuggestComment(comments);
            uwSuggestionEO.setSuggestType(UWSuggestionEO.SuggestionType.Submit.toString());
            paramMap.put(CommonConstants.UW_SUGGEST, uwSuggestionEO);
        }
        paramMap.put("operationType", OperationType.SUBMIT.getCode());
        paramMap.put(CommonConstants.UW_LEVEL, uwLevel);
        this.completeTask("", taskId, paramMap);
        return Boolean.FALSE;
    }

    @Override
    public Boolean giveupTask(String taskId) {
        Map<String, Object> paramMap = new HashMap<>();
        paramMap.put("operationType", OperationType.GIVE_UP.getCode());
        this.completeTask("", taskId, paramMap);
        return Boolean.TRUE;
    }

    @Override
    public Boolean rejectTask(String comments, String taskId, String uwLevel, Boolean toClerk) {
        Map<String, Object> paramMap = new HashMap<>();
        paramMap.put("operationType", OperationType.REJECT.getCode());
        paramMap.put(CommonConstants.UW_LEVEL, uwLevel);
        paramMap.put(CommonConstants.TO_CLERK, toClerk);
        this.completeTask("", taskId, paramMap);
        return Boolean.TRUE;
    }
    
    @Override
    public Boolean suppTask(String comments, String taskId, String uwLevel, Boolean toClerk) {
        Map<String, Object> paramMap = new HashMap<>();
        paramMap.put("operationType", OperationType.SUPP.getCode());
        paramMap.put(CommonConstants.UW_LEVEL, uwLevel);
        paramMap.put(CommonConstants.TO_CLERK, toClerk);
        this.completeTask("", taskId, paramMap);
        return Boolean.TRUE;
    }

    @Override
    public SurveyTaskEO findUndoneByTaskId(String taskId, List<String> kindList) {
        return this.getBaseRepository().findUndoneByTaskId(taskId, kindList);
    }

    @Override
    public List<SurveyTaskEO> findUndoneByTaskIds(List<String> taskIds, List<String> kindList) {
        return this.getBaseRepository().findUndoneByTaskIds(taskIds, kindList);
    }

    @Override
    public SurveyTaskEO complainTask(String taskId, String suggestComment, RbacUserEO findCurrentUser) {
        Map<String, Object> paramMap = new HashMap<>();
        paramMap.put("operationType", OperationType.COMPLAIN.getCode());
        this.completeTask("", taskId, paramMap);
        return null;
    }

    @Override
    public Boolean retreatToClerk(String schema, Long surveyId, String processDefinitionKey) {
        // 不用该方法
        return Boolean.TRUE;
    }

    @Override
    public List<String> findUwPath(RbacUserEO rbacUserEO, String productCode, String profile) {
        if (rbacUserEO == null) {
            logger.error("{}.{}---用户信息为Null", this.getClass().getSimpleName(), "findUwPath");
            throw new StandardRuntimeException("用户登录信息为空，请重新登录");
        }
        List<String> uwLevelList = new ArrayList<>();
        String structureId = null;
        LoginStructure loginStructure = rbacUserEO.getCurrentLoginStructure();
        if (loginStructure == null) {
            Object loginStructureIdObj = BaseContextManager.get().get(BaseContext.PreferenceName.loginStructureId);
            structureId = loginStructureIdObj != null ? (String) loginStructureIdObj : rbacUserEO.getOwnedStructureId();
        } else {
            structureId = loginStructure.getStructureId();
        }
        StructureEO structureEO = this.structureService.getByPartyId(structureId);

        /*
         * while (uwLevelList.isEmpty()) { logger.info("{}.{}---机构信息:{}",
         * this.getClass().getSimpleName(), "findAllUwLevel",
         * JsonUtils.toJsonString(structureEO, false)); if (structureEO == null)
         * { break; } logger.
         * info("{}.{}---查询审核路径配置。条件[kind:{}, productCode:{}, structureId:{}, profile:{}]"
         * , this.getClass().getSimpleName(), "findAllUwLevel",
         * CommonConstants.KIND_UW_LEVEL, productCode, structureEO.getPartyId(),
         * profile); List<BusinessPreferenceEO> businessPreferenceEOList =
         * this.businessConfigService
         * .getBusinessConfigEOForLevel(CommonConstants.KIND_UW_LEVEL,
         * productCode, structureEO.getPartyId(), null, null, null, profile);
         * logger.info("{}.{}---查询审核路径配置。结果:{}",
         * this.getClass().getSimpleName(), "findAllUwLevel",
         * JsonUtils.toJsonString(businessPreferenceEOList, false)); if
         * (CollectionUtils.isNotEmpty(businessPreferenceEOList)) {
         * BusinessPreferenceEO businessPreferenceEO =
         * businessPreferenceEOList.get(0); String[] uwLevels =
         * businessPreferenceEO.getValue().split(","); uwLevelList =
         * Arrays.asList(uwLevels); logger.info("{}.{}---获取该产品的审核权限配置：{}",
         * this.getClass().getSimpleName(), "findAllUwLevel",
         * businessPreferenceEO.getValue()); break; } if
         * (StringUtils.equals(structureEO.getStructureLevel(), "1")) { throw
         * new StandardRuntimeException( "该用户[" + rbacUserEO.getLoginName() +
         * "，机构：" + structureId + "]对于产品[" + productCode + "]无核保权限"); }
         * structureEO = structureService.findParentByPartyId(CommonConstants.
         * STRUCTURE_SHIP_TYPE, structureEO.getPartyId()); }
         */
        return uwLevelList;
    }

    @Override
    public Boolean cancelTask(String schema, Long surveyId, String cancelCode, String comments) {
        return true;
    }

    /**
     * 获取批改查询的最新任务
     *
     * @param surveyIdList
     *            surveyIdList
     *
     * @return List<SurveyTaskEO>
     */
    public List<SurveyTaskEO> findLastBySurveyIds(String surveyIdList) {
        if (StringUtils.isEmpty(surveyIdList)) {
            return null;
        }

        String[] surveyIdArray = surveyIdList.split(",");

        return this.getBaseRepository().findLastBySurveyIds(surveyIdArray);
    }

    /**
     * 根据surveyId查询任务记录条数
     * 
     * @param surveyId
     *            surveyId
     * @return Long
     */
    @Override
    public Long getCountBySurveyId(Long surveyId) {
        return this.getBaseRepository().getCountBySurveyId(surveyId);
    }

    /**
     * 根据条件查询任务分页列表
     */
    @Override
    public Pagination<SurveyTaskEO> getAuditTaskPages(Map<String, Object> parameters, int from, int limit,
                                                      String sorting) {
        StringBuilder hqlSb = new StringBuilder();
        QueryCondition queryCondition = new QueryCondition();
        if (parameters != null) {
            for (Entry<String, Object> entry : parameters.entrySet()) {
                Object entryValue = entry.getValue();
                if (entryValue == null) {
                    continue;
                }
                if (entryValue instanceof String && ("All".equalsIgnoreCase(String.valueOf(entryValue))
                        || "".equalsIgnoreCase(String.valueOf(entryValue)))) {
                    continue;
                }
                // 我的审批
                if (entry.getKey().equalsIgnoreCase("createUserId")) {
                    QueryCondition.AndFilter andFilter = new QueryCondition().new AndFilter();
                    andFilter.setKey(entry.getKey());
                    andFilter.setV(String.valueOf(entryValue).trim() + "%");
                    andFilter.setOperatorType(QueryConditionOperatorType.LIKE);
                    queryCondition.addAddFilter(andFilter);
                    continue;
                }
                // 风勘名称
                if (entry.getKey().equalsIgnoreCase("surveyName")) {
                    QueryCondition.AndFilter andFilter = new QueryCondition().new AndFilter();
                    andFilter.setKey(entry.getKey());
                    andFilter.setV(String.valueOf(entryValue).trim() + "%");
                    // andFilter.setV("%" + String.valueOf(entryValue).trim() +
                    // "%");
                    andFilter.setOperatorType(QueryConditionOperatorType.LIKE);
                    queryCondition.addAddFilter(andFilter);
                    continue;
                }
                // 风勘类型
                if (entry.getKey().equalsIgnoreCase("surveyType")) {
                    QueryCondition.AndFilter andFilter = new QueryCondition().new AndFilter();
                    andFilter.setKey(entry.getKey());
                    andFilter.setV(String.valueOf(entryValue).trim() + "%");
                    andFilter.setOperatorType(QueryConditionOperatorType.LIKE);
                    queryCondition.addAddFilter(andFilter);
                    continue;
                }
                // 审批状态 FIXME
                if (entry.getKey().equalsIgnoreCase("status")) {
                    QueryCondition.AndFilter andFilter = new QueryCondition().new AndFilter();
                    andFilter.setKey("status");
                    andFilter.setV(String.valueOf(entryValue).trim() + "%");
                    andFilter.setOperatorType(QueryConditionOperatorType.LIKE);
                    queryCondition.addAddFilter(andFilter);
                    continue;
                }
                // 风勘合作关系锁定与解锁审核时的处理
                if (entry.getKey().equalsIgnoreCase("category")) {
                    QueryCondition.AndFilter andFilter = new QueryCondition().new AndFilter();
                    if (entryValue instanceof String && StringUtils.isNotEmpty((String) entryValue)) {
                        andFilter.setKey("category");
                        andFilter.setV(String.valueOf(entryValue).trim() + "%");
                        andFilter.setOperatorType(QueryConditionOperatorType.LIKE);
                        queryCondition.addAddFilter(andFilter);
                        continue;
                    } else if (entryValue instanceof Collection
                            && CollectionUtils.isNotEmpty((List<String>) entryValue)) {
                        andFilter.setKey("category");
                        andFilter.setV((ArrayList) entryValue);
                        andFilter.setOperatorType(QueryConditionOperatorType.IN);
                        queryCondition.addAddFilter(andFilter);
                        continue;

                    }
                }
            }
            // 审批状态默认设定
            if (!parameters.containsKey("status")) {
                QueryCondition.AndFilter andFilter = new QueryCondition().new AndFilter();
                andFilter.setKey("status");
                // FIXME 1.未设定权限查询限制；2.写死只能查到待处理审批状态的任务
                andFilter.setV(String.valueOf(TaskStatusEnum.Pending.getCode()).trim() + "%");
                andFilter.setOperatorType(QueryConditionOperatorType.LIKE);
                queryCondition.addAddFilter(andFilter);
            }
            // 普通审核 查询屏蔽风勘合作关系锁定与解锁
            if (!parameters.containsKey("category")) {
                List<String> arrayList = new ArrayList<String>();
                arrayList.add(TaskTypeEnum.UW_COOPER_RELATIONSHIP_LOCK.getCode());
                arrayList.add(TaskTypeEnum.UW_COOPER_RELATIONSHIP_UNLOCK.getCode());
                QueryCondition.AndFilter andFilter = new QueryCondition().new AndFilter();
                andFilter.setKey("category");
                andFilter.setV(arrayList);
                andFilter.setOperatorType(QueryConditionOperatorType.NOTIN);
                queryCondition.addAddFilter(andFilter);
            }
        }
        hqlSb.append(queryCondition.getSql());
        hqlSb.append(" and newFlag = '1'");
        sorting = StringUtils.trimToEmpty(sorting);
        if ("".equalsIgnoreCase(sorting)) {
            sorting = "submitTime desc";
        }
        return this.getBaseRepository().find(hqlSb.toString(), from, limit, queryCondition.getValues().toArray(),
                sorting);
    }

    /**
     * 根据surveyId查询所有有最新标志的任务，一盘只有一条；
     */
    @Override
    public List<SurveyTaskEO> getAllNewBySurveyId(Long surveyId) {
        return this.getBaseRepository().getAllNewBySurveyId(surveyId);
    }

    @Override
    public List<String> getSurveyNameList(Map<String, Object> parameters) {
        StringBuilder hqlSb = new StringBuilder("select distinct surveyName from act_survey_task where 1=1 ");
        QueryCondition queryCondition = new QueryCondition();
        if (!parameters.containsKey("category")) {
            List<String> arrayList = new ArrayList<String>();
            arrayList.add(TaskTypeEnum.UW_COOPER_RELATIONSHIP_LOCK.getCode());
            arrayList.add(TaskTypeEnum.UW_COOPER_RELATIONSHIP_UNLOCK.getCode());
            QueryCondition.AndFilter andFilter = new QueryCondition().new AndFilter();
            andFilter.setKey("category");
            andFilter.setV(arrayList);
            andFilter.setOperatorType(QueryConditionOperatorType.NOTIN);
            queryCondition.addAddFilter(andFilter);
        } else {
            QueryCondition.AndFilter andFilter = new QueryCondition().new AndFilter();
            andFilter.setKey("category");
            andFilter.setV(parameters.get("category"));
            andFilter.setOperatorType(QueryConditionOperatorType.IN);
            queryCondition.addAddFilter(andFilter);
        }
        if (parameters.containsKey("namePart")) {
            QueryCondition.AndFilter andFilter = new QueryCondition().new AndFilter();
            andFilter.setKey("surveyName");
            andFilter.setV("%" + parameters.get("namePart") + "%");
            andFilter.setOperatorType(QueryConditionOperatorType.LIKE);
            queryCondition.addAddFilter(andFilter);
        }
        hqlSb.append(queryCondition.getSql());
        QueryObject queryObject = QueryObjectFactory.createClause(hqlSb.toString(),
                queryCondition.getValues().toArray(), null, null, QueryType.Sql);
        return (List<String>) this.getBaseRepository().getBaseQueryRepository().find(queryObject);
    }

    @Override
    public void updateSurveyTask(SurveyTaskEO surveyTaskEO) {
        this.update(surveyTaskEO);
    }
}
