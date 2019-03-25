package com.chinalife.risksurvey.task.service.impl;

import com.chinalife.base.exception.StandardRuntimeException;
import com.chinalife.base.service.impl.BaseServiceImpl;
import com.chinalife.base.util.JsonUtils;
import com.chinalife.base.util.ObjectUtils;
import com.chinalife.base.util.Pagination;
import com.chinalife.hr.core.entity.StructureEO;
import com.chinalife.hr.core.service.IStructureRlshipService;
import com.chinalife.rbac.domain.LoginStructure;
import com.chinalife.rbac.entity.RbacUserEO;
import com.chinalife.rbac.filter.service.ICurrentRbacUserService;
import com.chinalife.rbac.service.IRbacParameterPermissionService;
import com.chinalife.rbac.service.IRbacUserService;
import com.chinalife.risksurvey.entity.SurveyDispatchEO;
import com.chinalife.risksurvey.entity.SurveyMainEO;
import com.chinalife.risksurvey.entity.SurveyTaskEO;
import com.chinalife.risksurvey.enums.SurveyStatusEnums;
import com.chinalife.risksurvey.service.ISurveyDispatchService;
import com.chinalife.risksurvey.service.ISurveyMainService;
import com.chinalife.risksurvey.task.component.ISurveyTaskComponent;
import com.chinalife.risksurvey.task.constants.TaskStatusEnum;
import com.chinalife.risksurvey.task.repository.ISurveyTaskRepository;
import com.chinalife.risksurvey.task.service.ISurveyTaskService;
import com.chinalife.risksurvey.task.service.underwriting.impl.RiskSuveyAssignService;
import com.chinalife.type.exception.service.IExceptionService;
import org.apache.commons.collections4.CollectionUtils;
import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.function.Function;

/**
 * 包名称： com.chinalife.uw.service.impl 类名称：SurveyTaskServiceImpl<br/>
 * 类描述：<br/>
 * 创建人：@author axue016@pwc.com<br/>
 * 创建时间：Jun 16, 2017/1:50:48 PM<br/>
 */
@RestController("surveyTaskService")
@RequestMapping("/service/risksurvey/task")
public class SurveyTaskServiceImpl extends BaseServiceImpl<SurveyTaskEO, ISurveyTaskRepository, ISurveyTaskComponent>
        implements ISurveyTaskService {

    /**
     * LOGGER
     */
    private static final Logger LOGGER = LoggerFactory.getLogger(RiskSuveyAssignService.class);

    /**
     * surveyTaskComponent
     */
    @Autowired
    private ISurveyTaskComponent surveyTaskComponent;

    /**
     * IExceptionService
     */
    @Autowired
    private IExceptionService exceptionService;

    /**
     * rbacUserService
     */
    @Autowired
    private IRbacUserService rbacUserService;

    /**
     * currentUserService
     */
    @Autowired
    private ICurrentRbacUserService currentUserService;

    /**
     * structure rlship service
     */
    @Autowired
    private IStructureRlshipService structureRlshipService;

    /**
     * parameter permission service
     */
    @Autowired
    private IRbacParameterPermissionService rbacParameterPermissionService;

    /**
     * insuranceTaskService
     */
    @Autowired
    protected ISurveyDispatchService surveyDispatchService;
    
    /**
     * surveyMainService
     */
    @Autowired
    private ISurveyMainService  surveyMainService;

    @Override
    public SurveyTaskEO findLastTaskBySurveyId(Long surveyId, List<String> kindList) {
        return this.surveyTaskComponent.findLastTaskBySurveyId(surveyId, kindList);
    }

    @Override
    public List<String> findAllUwLevel(String userLoginName, String productCode, String profile) {
        RbacUserEO rbacUserEO = this.rbacUserService.findByLoginName(userLoginName);
        if (rbacUserEO == null) {
            LOGGER.error("查询不到该用户[{}]的信息", userLoginName);
            throw new StandardRuntimeException("查询不到该用户[" + userLoginName + "]的信息");
        }
        return this.surveyTaskComponent.findUwPath(rbacUserEO, productCode, profile);
    }

    @Override
    public Map<String, Object> updateFlowVariable(String taskId, Map<String, Object> variableMap) {
        return this.surveyTaskComponent.updateFlowVariable(taskId, variableMap);
    }

    @Override
    public Map<String, Object> findAllVariable(String taskId) {
        return this.surveyTaskComponent.findAllVariable(taskId);
    }

    @Override
    public Pagination<SurveyTaskEO> findUwInsuranceTaskPagination(Map<String, Object> parameters, int from, int limit,
                                                                  String sorting, List<String> kindList) {
        return this.getBaseComponent().findUwInsuranceTaskPagination(parameters, from, limit, sorting, kindList);
    }

    @Override
    public SurveyTaskEO findByTaskId(String taskId, List<String> kindList) {
        return surveyTaskComponent.findTaskByTaskId(taskId, kindList);
    }

    @Override
    public String findTaskIdBySurveyId(String surveyIds, List<String> kindList) {
        if (StringUtils.isBlank(surveyIds)) {
            return "failed";
        }
        String taskId = null;
        if (surveyIds.contains(",")) {
            String[] surveyIdArray = surveyIds.split(",");
            StringBuffer returnSb = new StringBuffer();
            for (String surveyId : surveyIdArray) {
                if (StringUtils.isNotBlank(surveyId)) {
                    if (StringUtils.isNotBlank(getTaskIdWithCheck(Long.valueOf(surveyId), kindList))) {
                        returnSb.append(getTaskIdWithCheck(Long.valueOf(surveyId), kindList));
                        returnSb.append(",");
                    }
                }
            }
            taskId = returnSb.toString();
        } else {
            taskId = this.getTaskIdWithCheck(Long.valueOf(surveyIds), kindList);
        }
        return taskId;
    }

    /**
     * 根据surveyId查询任务id
     *
     * @param surveyId
     *            surveyId
     * @param kindList
     *            kind
     *
     * @return taskId
     */
    private String getTaskIdWithCheck(Long surveyId, List<String> kindList) {
        SurveyTaskEO surveyTaskEO = surveyTaskComponent.findUndoneBySurveyId(surveyId, kindList);
        if (surveyTaskEO != null) {
            return surveyTaskEO.getTaskId();
        } else {
            return null;
        }
        // throw new StandardRuntimeException("投保单状态不符合要求，请仔细检查！");
    }

    @Override
    public Boolean processTask(String taskId, RbacUserEO rbacUserEO, List<String> kindList) {
        return this.surveyTaskComponent.processTask(taskId, rbacUserEO, kindList);
    }

    @Override
    public SurveyTaskEO recallTask(String taskId, String comments, RbacUserEO rbacUserEO, List<String> kindList) {
        try {
            return this.surveyTaskComponent.recallTask(taskId, comments.trim(), rbacUserEO, kindList);
        } catch (StandardRuntimeException e) {
            LOGGER.error(e.getKey(), e);
            throw new StandardRuntimeException(e.getKey(), exceptionService.getFormatDescription(e.getKey()));
        }
    }

    @Override
    public SurveyTaskEO passTask(String comments, RbacUserEO rbacUserEO, String taskId, List<String> kindList) {
        String commentsTrim = comments == null ? null : comments.trim();
        SurveyTaskEO surveyTaskEo = this.surveyTaskComponent.findUndoneByTaskId(taskId, kindList);
        if (surveyTaskEo == null) {
            LOGGER.error("查询不到该任务，taskId：{}", taskId);
            throw new StandardRuntimeException("用户[" + rbacUserEO.getName() + "]查询不到该任务[" + taskId + "]");
        }
        //TaskStatusEnum.passChecking(surveyTaskEo.getStatus());
        return this.surveyTaskComponent.passTask(surveyTaskEo, commentsTrim, taskId);
    }

    @Override
    public Boolean reviceTask(String taskIds, List<String> kindList) {
        // RbacUserEO rbacUserEO =
        // this.currentRbacUserService.findCurrentUser();
        // Function<SurveyTaskEO, Boolean> validationFunction = insuranceTaskEO
        // -> TaskStatusEnum
        // .canBeAssigned(insuranceTaskEO.getStatus());
        // return this.assignTask(taskIds, rbacUserEO.getLoginName(), kindList,
        // validationFunction);
        return null;
    }

    @Override
    public Boolean forceAssignTask(String taskIds, String userLoginName, String businessType) {
        // List<String> kindList =
        // SurveyTaskEO.findResourceKindByBusiness(businessType);
        // List<RbacDataPermissionEO> rbacDataPermissionEOList =
        // contractSecurity
        // .getDataPermission(INSURANCE_TASK_FORCE_ASSIGN.getKindByBusinessType(businessType));
        // if (CollectionUtils.isEmpty(rbacDataPermissionEOList)) {
        // // throw new StandardRuntimeException("当前用户无强行指派任务权限");
        // }
        List<String> kindList = new ArrayList<>();
        Function<SurveyTaskEO, Boolean> validationFunction = insuranceTaskEO -> TaskStatusEnum
                .canBeForceAssign(insuranceTaskEO.getStatus());
        return this.assignTask(taskIds, userLoginName, kindList, validationFunction);
    }

    @Override
    public Boolean assignTask(String taskIds, String userLoginName, String businessType) {
        // List<String> kindList =
        // SurveyTaskEO.findResourceKindByBusiness(businessType);
        // List<RbacDataPermissionEO> rbacDataPermissionEOList =
        // contractSecurity
        // .getDataPermission(INSURANCE_TASK_ASSIGN.getKindByBusinessType(businessType));
        // if (CollectionUtils.isEmpty(rbacDataPermissionEOList)) {
        // // throw new StandardRuntimeException("当前用户无指派任务权限");
        // }
        // List<String> kindList = new ArrayList<>();
        // Function<SurveyTaskEO, Boolean> validationFunction = insuranceTaskEO
        // -> TaskStatusEnum
        // .canBeAssigned(insuranceTaskEO.getStatus());
        // return this.assignTask(taskIds, userLoginName, kindList,
        // validationFunction);
        return true;
    }

    /**
     * assign task
     *
     * @param taskIds
     *            taskIds
     * @param userLoginName
     *            userLoginName
     * @param kindList
     *            kindList
     * @param validation
     *            validation
     *
     * @return boolean
     */
    private Boolean assignTask(String taskIds, String userLoginName, List<String> kindList,
            Function<SurveyTaskEO, Boolean> validation) {
        String[] taskIdArray = taskIds.split(",");

        List<String> taskIdsList = new ArrayList<>();

        for (String taskId : taskIdArray) {
            if (StringUtils.isEmpty(taskId)) {
                continue;
            }
            taskIdsList.add(taskId);
        }

        try {
            return this.getBaseComponent().assignTask(taskIdsList, userLoginName, kindList, validation);
        } catch (StandardRuntimeException e) {
            LOGGER.error(e.getKey(), e);
            throw new StandardRuntimeException(e.getKey(), exceptionService.getFormatDescription(e.getKey()));
        }
    }

    @Override
    public Boolean submitSuperiorTask(String taskId, String newOwner, String comments) {
        try {
            return this.getBaseComponent().submitSuperiorTask(taskId, newOwner, comments);
        } catch (StandardRuntimeException e) {
            LOGGER.error(e.getKey(), e);
            throw new StandardRuntimeException(e.getKey(), exceptionService.getFormatDescription(e.getKey()));
        }
    }

    @Override
    public Boolean completeTask(String schemaName, String taskId, Map<String, Object> obj) {
        try {
            return this.surveyTaskComponent.completeTask(schemaName, taskId, obj);
        } catch (StandardRuntimeException e) {
            LOGGER.error(e.getKey(), e);
            throw new StandardRuntimeException(e.getKey(), exceptionService.getFormatDescription(e.getKey()));
        }
    }

    @Override
    public Boolean rejectTask(String taskId, String comments, String uwLevel, Boolean toClerk, List<String> kindList) {
        SurveyTaskEO surveyTaskEo = this.surveyTaskComponent.findUndoneByTaskId(taskId, kindList);
        if (surveyTaskEo == null) {
            LOGGER.error("查询不到该任务，taskId：{}", taskId);
            throw new StandardRuntimeException("未查询到任务!");
        }
        TaskStatusEnum.rejectChecking(surveyTaskEo.getStatus());
        try {
            return this.surveyTaskComponent.rejectTask(comments, taskId, uwLevel, toClerk);
        } catch (StandardRuntimeException e) {
            throw new StandardRuntimeException(e.getKey(), exceptionService.getFormatDescription(e.getKey()));
        }
    }

    @Override
    public Boolean giveupTask(String taskId, List<String> kindList) {
        SurveyTaskEO surveyTaskEo = this.surveyTaskComponent.findUndoneByTaskId(taskId, kindList);
        if (surveyTaskEo == null) {
            LOGGER.error("查询不到该任务，taskId：{}", taskId);
            throw new StandardRuntimeException("未查询到任务!");
        }
        TaskStatusEnum.giveUpChecking(surveyTaskEo.getStatus());
        try {
            return this.surveyTaskComponent.giveupTask(taskId);
        } catch (StandardRuntimeException e) {
            throw new StandardRuntimeException(e.getKey(), exceptionService.getFormatDescription(e.getKey()));
        }
    }

    /*
     * @see com.chinalife.contract.insurance.service.IInsuranceTaskService#
     * findAllBySurveyId(java.lang.Long)
     */
    @Override
    public Map<String, Object> findAllBySurveyId(Long surveyId) {

        return this.surveyTaskComponent.findAllBySurveyId(surveyId);
    }

    @Override
    public SurveyTaskEO complainTask(String taskId, String suggestComment, RbacUserEO findCurrentUser) {
        return this.surveyTaskComponent.complainTask(taskId, suggestComment, findCurrentUser);
    }

    @Override
    public SurveyTaskEO topInsuranceTask(Map<String, Object> parameters, List<String> kindList) {
        String taskId = "";
        for (Map.Entry<String, Object> entry : parameters.entrySet()) {
            if (entry.getKey().equals("taskId")) {
                taskId = String.valueOf(entry.getValue());
            }
        }
        SurveyTaskEO surveyTaskEO = this.findByTaskId(taskId, kindList);
        if (surveyTaskEO == null) {
            return null;
        }
        surveyTaskComponent.update(surveyTaskEO);
        return surveyTaskEO;
    }

    @Override
    public Boolean retreatToClerk(String schema, Long surveyId, String processInstanceKey) {
        return this.surveyTaskComponent.retreatToClerk(schema, surveyId, processInstanceKey);
    }

    @Override
    public String cancelTask(String schema, Long surveyIds, String cancelCode, String comments) {

        if (this.surveyTaskComponent.cancelTask(schema, surveyIds, cancelCode, comments)) {
            return "success";
        } else {
            return "fail";
        }

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
        return this.surveyTaskComponent.findLastBySurveyIds(surveyIdList);
    }

    @Override
    public List<RbacUserEO> findAssignee(List<String> taskIdList, String kind) {
        String structurePath = null;
        List<LoginStructure> loginStructureList = this.currentUserService.findCurrentUser().getLoginStructures();
        if (CollectionUtils.isNotEmpty(loginStructureList)) {
            StructureEO structureEO = structureRlshipService.findByPartyId(
                    "Underwriting", loginStructureList.get(0).getStructureId());
            if (structureEO != null) {
                structurePath = structureEO.getStructurePath();
            }
        }

        List<String> kindList = new ArrayList<>();
        kindList.add(kind);
        Set<String> uwLevelSet = new HashSet<>();
        List<SurveyTaskEO> surveyTaskList = new ArrayList<>();
        for (String taskId : taskIdList) {
            SurveyTaskEO surveyTaskEO = this.surveyTaskComponent.findTaskByTaskId(taskId, kindList);
            if (surveyTaskEO != null) {
                surveyTaskList.add(surveyTaskEO);
                taskIdList.remove(surveyTaskEO.getTaskId());
                uwLevelSet.add(surveyTaskEO.getUwLevel());
            }
        }
        LOGGER.info("{}.{}---未查询到的任务ID：{}", this.getClass().getSimpleName(), "findAssignee",
                JsonUtils.toJsonString(taskIdList, false));
        LOGGER.info("{}.{}---任务的审核级别为：{}", this.getClass().getSimpleName(), "findAssignee",
                JsonUtils.toJsonString(uwLevelSet, false));
        if (CollectionUtils.isNotEmpty(taskIdList)) {
            throw new StandardRuntimeException("任务[" + taskIdList.toArray() + "]已完成，无法指派");
        } else if (uwLevelSet.size() > 1) {
            throw new StandardRuntimeException("指派的任务中包含不同级别[" + uwLevelSet.toArray() + "]，请分别指派");
        }
        String uwLevel = uwLevelSet.iterator().next();
        LOGGER.info("{}.{}---查询可指派用户的参数为：Kind:[{}], ParameterValue:[{}], StructurePath:[{}]",
                this.getClass().getSimpleName(), "findAssignee", kind, uwLevel,
                structurePath);
        List<RbacUserEO> rbacUserEOList = rbacParameterPermissionService.findParameterPermissions(kind,
                "UWApprovalLevel01", uwLevel, structurePath);
        LOGGER.info("{}.{}---查询到的用户数为[{}]", this.getClass().getSimpleName(), "findAssignee", rbacUserEOList.size());
        return rbacUserEOList;
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
        return this.surveyTaskComponent.getCountBySurveyId(surveyId);
    }

    /**
     * 根据条件查询任务分页列表
     */
    @Override
    public Pagination<SurveyTaskEO> getAuditTaskPages(Map<String, Object> parameters, int from, int limit,
                                                      String sorting) {
        return this.surveyTaskComponent.getAuditTaskPages(parameters, from, limit, sorting);
    }

    /**
     * 根据条件查询我的任务分页列表
     */
    @Override
    public Pagination<SurveyTaskEO> getMyTaskPages(Map<String, Object> parameters, int from, int limit, String sorting) {
        RbacUserEO currentUser = currentUserService.findCurrentUser();
        if (currentUser == null) {
            throw new StandardRuntimeException("请登录");
        }
        parameters.put("createUserId", currentUser.getLoginName());
        return this.getAuditTaskPages(parameters, from, limit, sorting);
    }

    /**
     * 修改之前最新标志
     */
    @Override
    public Boolean updateBeforeNewFlag(Long surveyId) {
        List<SurveyTaskEO> surveyTaskList = this.surveyTaskComponent.getAllNewBySurveyId(surveyId);
        for (SurveyTaskEO surveyTaskEO : surveyTaskList) {
            surveyTaskEO.setNewFlag("0");
        }
        surveyTaskComponent.updateAll(surveyTaskList);
        return true;
    }

    @Override
    public List<String> getSurveyNameList(Map<String, Object> parameters) {
        return surveyTaskComponent.getSurveyNameList(parameters);
    }

    @Override
    public void surveyAssignTask(String taskId, String userLoginName, String businessType) {
        RbacUserEO currentUser = this.currentUserService.findCurrentUser();
        if (currentUser == null) {
            throw new StandardRuntimeException("请登录");
        }
        
        RbacUserEO survyAssignUser = rbacUserService.findByLoginName(userLoginName);
        if (survyAssignUser == null) {
            throw new StandardRuntimeException("指派用户不存在");
        }
        SurveyTaskEO surveyTaskEO = this.findByTaskId(taskId, null);
        if (surveyTaskEO == null) {
            LOGGER.info("{}---查询不到该核保任务taskId:[{}]！", this.getClass().getSimpleName(), taskId);
            throw new StandardRuntimeException("无法提交审核，请检查用户在当前登录机构下是否有录单权限");
        } else {
            surveyTaskEO.setSurveyStatus(SurveyStatusEnums.ASSIGNED.getCode());
            this.update(surveyTaskEO);
        }
        SurveyDispatchEO surveyDispatch = this.surveyDispatchService.findBySurveyId(String.valueOf(surveyTaskEO.getSurveyId()));
        // 前端存基本信息值可不写此段
        if (null == surveyDispatch) {
            surveyDispatch = new SurveyDispatchEO();
            surveyDispatch.setSurveyId(String.valueOf(surveyTaskEO.getSurveyId()));
            surveyDispatch.setTaskNo(taskId);
            surveyDispatch.setNum(BigDecimal.ONE);
            surveyDispatch.setNewFalg("1");
        } else {
            surveyDispatch.setNum(surveyDispatch.getNum().add(BigDecimal.ONE));
        }
        surveyDispatch.setOldOperatorCode(surveyDispatch.getOperatorCode());
        surveyDispatch.setOldOperator(surveyDispatch.getOperator());
        surveyDispatch.setOldOperDeptCode(surveyDispatch.getDsptatchDeptCode());
        surveyDispatch.setOldOperDept(surveyDispatch.getOperateDept());
        surveyDispatch.setOperatorCode(survyAssignUser.getLoginName());
        surveyDispatch.setOperator(survyAssignUser.getName());
        surveyDispatch.setOperateDeptCode(survyAssignUser.getOwnedStructureId());
        surveyDispatch.setOperateDept(survyAssignUser.getOwnedStructureName()); 
        surveyDispatch.setDsptatchOperCode(currentUser.getLoginName());
        surveyDispatch.setDsptatchDept(currentUser.getName());
        surveyDispatch.setDsptatchDeptCode(currentUser.getOwnedStructureId());
        this.surveyDispatchService.insert(surveyDispatch);
        surveyTaskEO.setAssignee(survyAssignUser.getLoginName());
        surveyTaskEO.setAssigneeName(survyAssignUser.getName());
        this.getBaseComponent().updateSurveyTask(surveyTaskEO);
        SurveyMainEO surveyMainEO = surveyMainService.getSurveyMainBySurveyId(String.valueOf(surveyTaskEO.getSurveyId()));
        if (surveyMainEO != null) {
            surveyMainEO.setSurveyer(survyAssignUser.getLoginName());
            surveyMainEO.setSurveyerDivision(survyAssignUser.getOwnedStructureId());
            surveyMainEO.setSurveyerDivision(survyAssignUser.getOwnedStructureName());
            surveyMainEO.setStatus(SurveyStatusEnums.ASSIGNED.getCode());
            this.surveyMainService.update(surveyMainEO);
        }

    }

    @Override
    public Boolean updateSurveyTask(SurveyTaskEO surveyTaskEO) {
        surveyTaskComponent.updateSurveyTask(surveyTaskEO);
        return true;
    }

    @Override
    public Boolean suppTask(String taskId, String comments, String uwLevel, Boolean toClerk, List<String> kindList) {
        SurveyTaskEO surveyTaskEo = this.surveyTaskComponent.findUndoneByTaskId(taskId, kindList);
        if (surveyTaskEo == null) {
            LOGGER.error("查询不到该任务，taskId：{}", taskId);
            throw new StandardRuntimeException("未查询到任务!");
        }
        //TaskStatusEnum.rejectChecking(surveyTaskEo.getStatus());
        try {
            return this.surveyTaskComponent.suppTask(comments, taskId, uwLevel, toClerk);
        } catch (StandardRuntimeException e) {
            throw new StandardRuntimeException(e.getKey(), exceptionService.getFormatDescription(e.getKey()));
        }
    }
    
    @Override
    public SurveyTaskEO getSurveyerByTaskId(Map<String,Object> parameter) {
        String taskId = parameter.get("taskId").toString();
        return this.findByCondition("taskId = ?  and newFlag = '1'", ObjectUtils.asArray(taskId), " serialNo desc ");
    }
}

