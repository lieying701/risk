package com.chinalife.risksurvey.task.service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.List;
import java.util.Map;
import java.util.UUID;

import com.chinalife.risksurvey.entity.SurveyTaskEO;
import org.activiti.engine.delegate.DelegateExecution;
import org.activiti.engine.delegate.DelegateTask;
import org.apache.commons.collections4.CollectionUtils;
import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;

import com.chinalife.base.util.JsonUtils;
import com.chinalife.rbac.entity.RbacUserEO;
import com.chinalife.rbac.filter.service.ICurrentRbacUserService;
import com.chinalife.rbac.service.IRbacUserService;
import com.chinalife.risksurvey.entity.UWSuggestionEO;
import com.chinalife.risksurvey.enums.SurveyStatusEnums;
import com.chinalife.risksurvey.messages.service.queue.ITaskCollectionMessageService;
import com.chinalife.risksurvey.task.component.IUWSuggestionComponent;
import com.chinalife.risksurvey.task.constants.CommonConstants;
import com.chinalife.risksurvey.task.constants.ContractBusinessType;
import com.chinalife.risksurvey.task.constants.OperationType;
import com.chinalife.risksurvey.task.constants.TaskStatusEnum;
import com.chinalife.risksurvey.utils.DateUtils;
import com.chinalife.workflow.entity.TaskEO;
import com.chinalife.workflow.service.ITaskService;

/**
 * abstract class for task execution
 *
 * @author jzhou237
 * @version 1
 */
public abstract class AbstractTaskEventService implements ITaskEventService {

    /**
     * next uw level
     */
    protected static final String NEXT_UW_LEVEL = "nextUwLevel";

    /**
     * logger
     */
    protected static final Logger LOGGER = LoggerFactory.getLogger(AbstractTaskEventService.class);

    /**
     * reinsurance switch
     */
    protected static final Boolean CALL_REINSURANCE = Boolean.TRUE;

    /**
     * multi instance result
     */
    public static final String MULTI_INSTANCE_RESULT = "multiInstanceResult";

    /**
     * multi product info
     */
    public static final String MULTI_PRODUCT_INFO = "multiProductInfo";

    /**
     * auto audit result message
     */
    public static final String AUTO_AUDIT_MESSAGE = "autoAuditMessage";

    /**
     * auto audit result
     */
    public static final String AUTO_AUDIT_RESULT = "autoAuditResult";

    /**
     * coins status
     */
    public static final String COINS_STATUS = "coinsStatus";

    /**
     * multi config list
     */
    public static final String MULTI_CONFIG_LIST = "multiConfigList";

    /**
     * coins config list
     */
    public static final String COINS_CONFIG_LIST = "coinsConfigList";

    /**
     * 最低核保通过级别
     */
    public static final String FINAL_UW_LEVEL = "finalUwLevel";

    /**
     * UW_MEMBER_CODE
     */
    protected static final String UW_MEMBER_CODE = "uwMemberCode";

    /**
     * UW_MEMBER
     */
    protected static final String UW_MEMBER = "uwMember";

    /**
     * presurveyId
     */
    public static final String PRE_ACTUAL_ID = "preSurveyId";

    /**
     * taskService
     */
    @Autowired
    protected ITaskService taskService;

    /**
     * rbacUserService
     */
    @Autowired
    protected IRbacUserService userService;

    /**
     * currentUserService
     */
    @Autowired
    protected ICurrentRbacUserService currentUserService;

    /**
     * taskCollectionMessageHandler
     */
    @Autowired
    protected ITaskCollectionMessageService taskCollectionMessageHandler;

    /**
     * surveyTaskService
     */
    @Autowired
    protected ISurveyTaskService surveyTaskService;

    /**
     * uwSuggestionComponent
     */
    @Autowired
    protected IUWSuggestionComponent uwSuggestionComponent;

    /**
     * get parent task
     *
     * @param task
     *            task
     * @return taskEO
     */
    protected TaskEO getParentTask(DelegateTask task) {
        List<TaskEO> taskEOList = this.taskService.getTasks(task.getProcessInstanceId());
        return CollectionUtils.isNotEmpty(taskEOList) ? taskEOList.get(0) : null;
    }

    /**
     * get Task
     *
     * @param taskId
     *            taskId
     * @return taskEO
     */
    protected TaskEO getTask(String taskId) {
        return this.taskService.get(taskId);
    }

    /**
     * 获取当前任务EO， 首先根据参数中的任务ID查询，若没有则通过processInstanceId查询
     *
     * @param execution
     *            execution
     * @return taskEO
     */
    protected TaskEO getTask(DelegateExecution execution) {
        TaskEO taskEO = null;
        Object currentTaskIdObj = execution.getVariable(ContractBusinessType.currentTaskId.name());
        if (currentTaskIdObj != null) {
            taskEO = this.getTask((String) currentTaskIdObj);
        }
        if (taskEO == null) {
            List<TaskEO> taskEOList = this.taskService.getTasks(execution.getProcessInstanceId());
            taskEO = CollectionUtils.isNotEmpty(taskEOList) ? taskEOList.get(0) : null;
        }

        return taskEO;
    }

 
    /**  更新InsuranceTask的状态 和任务执行人
     * @param surveyTaskEO surveyTaskEO
     * @param taskStatus surveyTaskEO
     * @param surveyStatus surveyTaskEO
     * @param userCode surveyTaskEO
     */
    protected void updateSurveyTask(SurveyTaskEO surveyTaskEO,TaskStatusEnum taskStatus, SurveyStatusEnums surveyStatus, 
                                   String userCode) {
        RbacUserEO rbacUserEO = this.getUser(userCode);
        if (rbacUserEO != null) {
            surveyTaskEO.setAssigneeName(rbacUserEO.getName());
            surveyTaskEO.setAssignee(rbacUserEO.getLoginName());
        } else {
            LOGGER.error("查询不到用户信息，ID:{}", userCode);
        }
        this.updateSurveyTask(surveyTaskEO, taskStatus,surveyStatus);
    }

   
    /** 更新InsuranceTask的状态
     * @param surveyTaskEO surveyTaskEO
     * @param taskStatus taskStatus
     * @param surveyStatus surveyStatus
     */
    protected void updateSurveyTask(SurveyTaskEO surveyTaskEO,TaskStatusEnum taskStatus, SurveyStatusEnums surveyStatus) {
        surveyTaskEO.setStatus(taskStatus.getCode());
        surveyTaskEO.setSurveyStatus(surveyStatus.getCode());;
        surveyTaskEO.setUpdateDate(DateUtils.getCurrentDate());// 修改时间
        surveyTaskService.update(surveyTaskEO);
    }

    
    /** 完成任务，更新状态以及操作类型
     * @param surveyTaskEO surveyTaskEO
     * @param surveyStatusEnums surveyStatusEnums
     * @param operationType operationType
     */
    protected void completeSurveyTask(SurveyTaskEO surveyTaskEO, SurveyStatusEnums surveyStatusEnums,
                                     OperationType operationType) {
        if (operationType != null) {
            surveyTaskEO.setOperationType(operationType.getCode());
        }

        this.updateSurveyTask(surveyTaskEO, TaskStatusEnum.Processed, surveyStatusEnums);
    }

  
   
    /** 完成任务，更新状态、操作类型和操作者
     * @param surveyTaskEO surveyTaskEO
     * @param surveyStatusEnums surveyStatusEnums
     * @param operationType operationType
     * @param userCode userCode
     */
    protected void completeSurveyTask(SurveyTaskEO surveyTaskEO, SurveyStatusEnums surveyStatusEnums,
            OperationType operationType, String userCode) {
        if (operationType != null) {
            surveyTaskEO.setOperationType(operationType.getCode());
        }
        this.updateSurveyTask(surveyTaskEO, TaskStatusEnum.Processed, surveyStatusEnums, userCode);
    }

    /**
     * create listener
     *
     * @param delegateTask
     *            task
     * @param processDefinitionMap
     *            parameter map
     */
    @Override
    public void create(DelegateTask delegateTask, Map<String, Object> processDefinitionMap, String schemeName,
            String surveyId, String taskType) {
        LOGGER.info("Before execute Task [" + delegateTask.getId() + "]");
    }

    /**
     * complete listener
     *
     * @param delegateTask
     *            task
     * @param processDefinitionMap
     *            parameter map
     * @param schemeName
     *            scheme name
     * @param surveyId
     *            surveyId
     * @param taskType
     *            taskType
     */
    @Override
    public void complete(DelegateTask delegateTask, Map<String, Object> processDefinitionMap, String schemeName,
            String surveyId, String taskType) {
        LOGGER.info("After execute Task [" + delegateTask.getId() + "]");
    }

    /**
     * 同步任务
     *
     * @param surveyTaskEO
     *            surveyTaskEO
     * @param task
     *            task
     */
    protected void syncTask(SurveyTaskEO surveyTaskEO, DelegateTask task) {
        this.taskCollectionMessageHandler.send(surveyTaskEO, task);
    }

    /**
     * 同步任务
     *
     * @param surveyTaskEO
     *            surveyTaskEO
     * @param task
     *            task
     */
    protected void syncTask(SurveyTaskEO surveyTaskEO, TaskEO task) {
        this.taskCollectionMessageHandler.send(surveyTaskEO, task);
    }

    /**
     * 更新PLC_MAIN的数据，执行任务具体操作，同步任务状态
     *
     * @param execution
     *            execution
     * @param processDefinitionMap
     *            parameter map
     * @param schemeName
     *            schema
     * @param surveyId
     *            surveyId
     */
    @Override
    public void onEvent(DelegateExecution execution, Map<String, Object> processDefinitionMap, String schemeName,
            Long surveyId) {
        TaskEO taskEO = this.getTask(execution);
        SurveyTaskEO surveyTaskEO = this.doTask(taskEO, processDefinitionMap, schemeName, surveyId);
        this.syncTask(surveyTaskEO, taskEO);
    }

    /**
     * do task
     *
     * @param taskEO
     *            taskEO
     * @param processDefinitionMap
     *            parameter map
     * @param schemeName
     *            schema
     * @param surveyId
     *            surveyId
     * @return surveyTaskEO
     */
    protected SurveyTaskEO doTask(TaskEO taskEO, Map<String, Object> processDefinitionMap, String schemeName,
                                  Long surveyId) {
        return null;
    }

    /**
     * delete listener
     *
     * @param delegateTask
     *            delegate task
     * @param schemeName
     *            schema
     * @param surveyId
     *            surveyId
     */
    @Override
    public void delete(DelegateTask delegateTask, String schemeName, Long surveyId) {

    }

    /**
     * 用于流程中的逻辑判断
     *
     * @param execution
     *            execution
     * @param processDefinitionMap
     *            parameter map
     * @param targetValue
     *            target value
     * @return boolean
     */
    @Override
    public boolean condition(DelegateExecution execution, Map<String, Object> processDefinitionMap,
            String targetValue) {
        String operationType = (String) processDefinitionMap.get("operationType");
        return StringUtils.equals(operationType, targetValue);
    }

    /**
     * get user
     *
     * @param loginName
     *            user login name
     * @return rbacUserEO
     */
    protected RbacUserEO getUser(String loginName) {
        return this.userService.findByLoginName(loginName);
    }

    /**
     * 以“，”拆分字符串
     *
     * @param ids
     *            ids
     * @return List
     */
    protected List<String> getIdList(String ids) {
        String[] idArray = ids.split(",");
        return Arrays.asList(idArray);
    }

    /**
     * 以“，”拆分字符串
     *
     * @param ids
     *            ids
     * @return list
     */
    protected List<String> getIdList(Object ids) {
        if (ids == null) {
            return new ArrayList<>();
        }
        return getIdList((String) ids);
    }

    /**
     * 获取appHeadId
     *
     * @param delegateTask
     *            delegate task
     * @return long
     */
    protected Long getAppHeadId(DelegateTask delegateTask) {
        Object appHeadIdObj = delegateTask.getVariable(ContractBusinessType.appHeadId.name());
        return appHeadIdObj != null ? (Long) appHeadIdObj : null;
    }

    /**
     * 获取一个新的任务对象
     *
     * @param delegateTask
     *            delegate task
     * @param surveyId
     *            surveyId
     * @param taskType
     *            task type
     * @return insuranceTaskEO
     */
    protected SurveyTaskEO getSurveyTask(DelegateTask delegateTask, Long surveyId, String taskType) {
        TaskEO parentTask = getParentTask(delegateTask);
        SurveyTaskEO newSurveyTask = new SurveyTaskEO();
        if (parentTask != null) {
            newSurveyTask = this.getSurveyTask(parentTask, surveyId, taskType);
            newSurveyTask.setId(null);
            newSurveyTask.setAssignee(null);
            newSurveyTask.setAssigneeName(null);
        }
        return newSurveyTask;
    }

    /**
     * 获取一个新的任务对象
     *
     * @param taskEO
     *            taskEO
     * @param surveyId
     *            surveyId
     * @param taskType
     *            task type
     * @return insuranceTaskEO
     */
    protected SurveyTaskEO getSurveyTask(TaskEO taskEO, Long surveyId, String taskType) {
        SurveyTaskEO surveyTaskEO = new SurveyTaskEO();
        if (taskEO != null) {
            SurveyTaskEO oldSurveyTaskEO = this.surveyTaskService.findLastTaskBySurveyId(surveyId, null);
            BeanUtils.copyProperties(oldSurveyTaskEO, surveyTaskEO);
            surveyTaskEO.setId(null);
            surveyTaskEO.setTaskId(taskEO.getId());
        }
        surveyTaskEO.setSurveyId(surveyId);
        surveyTaskEO.setCategory(taskType);
        return surveyTaskEO;
    }


    /** 保存一个新的任务，用于user task
     * @param delegateTask delegateTask
     * @param surveyTaskEO surveyTaskEO
     * @param taskStatus taskStatus
     * @param surveyStatus surveyStatus
     * @param operationType operationType
     */
    protected void saveNewSurveyTask(DelegateTask delegateTask, SurveyTaskEO surveyTaskEO, TaskStatusEnum taskStatus,
            SurveyStatusEnums surveyStatus,  OperationType operationType) {
        // RbacUserEO currentUser = currentUserService.findCurrentUser();
        // if (currentUser == null ||
        // StringUtils.isEmpty(currentUser.getOwnedStructureId())) {
        // LOGGER.info("{}---获取登录机构异常:[{}]", this.getClass().getSimpleName(),
        // "saveNewSurveyTask()");
        // throw new StandardRuntimeException("当前登录用户机构设置异常！");
        // }
        // surveyTaskEO.setPartitionId(currentUser.getPartitionId());
        // surveyTaskEO.setStructureId(currentUser.getOwnedStructureId());
        // surveyTaskEO.setTenantId(currentUser.getTenantId());
        // surveyTaskEO.setCreateUserName(currentUser.getName());
        // surveyTaskEO.setCreateUserId(currentUser.getLoginName());
        surveyTaskEO.setTaskId(delegateTask.getId());// 任务ID
        surveyTaskEO.setFormKey(delegateTask.getFormKey());// 页面扭转URL

        //surveyTaskEO.setAssignee(currentUser.getLoginName());
        //surveyTaskEO.setAssigneeName(currentUser.getName());
        //if (StringUtils.isEmpty(delegateTask.getAssignee())) {
        //    surveyTaskEO.setAssigneeName(null);
        //}
        surveyTaskEO.setStatus(taskStatus.getCode());
        surveyTaskEO.setSurveyStatus(surveyStatus.getCode());
        if (operationType != null) {
            surveyTaskEO.setOperationType(operationType.getCode());
        }
        this.saveNewSurveyTask(surveyTaskEO);
    }

    /**
     * 保存一个新的任务，用于一般创建，不更新任务相关的字段
     *
     * @param surveyTaskEO
     *            surveyTaskEO
     */
    protected void saveNewSurveyTask(SurveyTaskEO surveyTaskEO) {
        surveyTaskEO.setCreateDate(DateUtils.getCurrentDate());// 创建者时间
        /*
         * if (StringUtils.isEmpty(surveyTaskEO.getUwLevel())) {
         * surveyTaskEO.setUwLevel(MockConstant.getCurrentRecorder().getGrade());
         * // 核保等级 }
         */
        surveyTaskEO.setSubmitTime(DateUtils.getCurrentDate());
        // 设置序号：先根据surveyId查询记录条数，再放入serialNo中，条数+1
        // select count(1) from act_survey_task where thridPartyId=?;
        Long num = this.surveyTaskService.getCountBySurveyId(surveyTaskEO.getSurveyId());
        if (num > 0) {
            surveyTaskService.updateBeforeNewFlag(surveyTaskEO.getSurveyId());
        }
        surveyTaskEO.setSerialNo(num.intValue() + 1);
        surveyTaskEO.setStartTime(DateUtils.getCurrentDate());
        surveyTaskEO.setNewFlag("1");
        surveyTaskEO.setBusinessId(Long.parseLong(getOrderIdByUUId().substring(0, 10)));
           
        this.surveyTaskService.insert(surveyTaskEO);
    }

    /**
     * save the suggestion
     *
     * @param surveyTaskEO
     *            surveyTask eo
     * @param processDefinitionMap
     *            map
     * @param clearMapFlag
     *            clearMapFlag
     *
     * @return suggestion eo
     */
    protected UWSuggestionEO storeSuggestion(SurveyTaskEO surveyTaskEO, Map<String, Object> processDefinitionMap,
                                             Boolean clearMapFlag) {
        Object uwSuggestOb = processDefinitionMap.get(CommonConstants.UW_SUGGEST);
        if (uwSuggestOb == null) {
            return null;
        }
        RbacUserEO rbacUserEO = this.currentUserService.findCurrentUser();
        if (rbacUserEO == null) {
            rbacUserEO = new RbacUserEO();
        }
        UWSuggestionEO uwSuggestionEO = JsonUtils.toJavaObject(uwSuggestOb, UWSuggestionEO.class);
        uwSuggestionEO.setCreateDate(DateUtils.getCurrentDate());
        uwSuggestionEO.setCreateUserId(rbacUserEO.getUserId());
        uwSuggestionEO.setOwnerUserId(
                rbacUserEO.getOwnerUserId() == null ? rbacUserEO.getUserId() : rbacUserEO.getOwnerUserId());
        uwSuggestionEO.setStructureId(rbacUserEO.getOwnedStructureId());
        uwSuggestionEO.setTenantId(rbacUserEO.getTenantId());
        uwSuggestionEO.setUpdateDate(new Date());
        uwSuggestionEO.setUpdateUserId(rbacUserEO.getIdentifyNumber());
        uwSuggestionEO.setSurveyId(surveyTaskEO.getSurveyId());
        uwSuggestionEO.setCreatorName(rbacUserEO.getName());
        uwSuggestionEO.setDepartName(rbacUserEO.getOwnedStructureName());
        uwSuggestionEO.setTaskId(surveyTaskEO.getTaskId());
        uwSuggestionEO.setUwLevel(surveyTaskEO.getUwLevel());
        uwSuggestionEO.setCreatorCode(rbacUserEO.getLoginName());
        uwSuggestionEO.setStructureCode(rbacUserEO.getOwnedStructureId());
        uwSuggestionEO.setInflowTime(surveyTaskEO.getSubmitTime());
        uwSuggestionEO.setOutflowTime(new Date());
        this.uwSuggestionComponent.saveUWSuggestion(uwSuggestionEO);
        // 是否清除审批意见
        if (clearMapFlag) {
            processDefinitionMap.put(CommonConstants.UW_SUGGEST, null);
        }
        return uwSuggestionEO;
    }
    
    /**
     * @return String
     */
    public static String getOrderIdByUUId() {
        int machineId = 1;// 最大支持1-9个集群机器部署
        int hashCodeV = UUID.randomUUID().toString().hashCode();
        if (hashCodeV < 0) {
            hashCodeV = -hashCodeV;
        }
        // 0 代表前面补充0
        // 4 代表长度为4
        // d 代表参数为正数型
        return machineId + String.format("%015d", hashCodeV);
    }
}
