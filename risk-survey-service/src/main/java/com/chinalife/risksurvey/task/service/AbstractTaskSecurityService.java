package com.chinalife.risksurvey.task.service;

import java.util.ArrayList;
import java.util.List;

import com.chinalife.risksurvey.entity.SurveyTaskEO;
import org.apache.commons.collections4.CollectionUtils;
import org.apache.commons.lang3.StringUtils;

import com.chinalife.base.exception.StandardRuntimeException;
import com.chinalife.workflow.entity.TaskEO;

/**
 * 处理核保权限
 *
 * @author jzhou237
 * @version 1
 */
public abstract class AbstractTaskSecurityService extends AbstractTaskEventService {

    /**
     * next uw level
     */
    protected static final String NEXT_UW_LEVEL = "nextUwLevel";

    /**
     * 获取当前审核等级的下一级别
     *
     * @param surveyTaskEO
     *            业务任务信息
     * @param uwLevelList
     *            核保级别列表
     *
     * @return nextUwLevel
     */
    protected String getNextUwLevel(SurveyTaskEO surveyTaskEO, List<String> uwLevelList) {
        String nextUwLevel = null;
        if (!StringUtils.equals(surveyTaskEO.getUwLevel(), uwLevelList.get(uwLevelList.size() - 1))) {
            int currentIndex = uwLevelList.indexOf(surveyTaskEO.getUwLevel());
            nextUwLevel = uwLevelList.get(currentIndex + 1);
        }
        return nextUwLevel;
    }

    /**
     * 获取当前审核等级的前一级别
     *
     * @param surveyTaskEO
     *            业务任务信息
     * @param uwLevelList
     *            核保级别列表
     *
     * @return preUwLevel
     */
    protected String getPreUwLevel(SurveyTaskEO surveyTaskEO, List<String> uwLevelList) {
        if (StringUtils.equals(surveyTaskEO.getUwLevel(),
                CollectionUtils.isEmpty(uwLevelList) ? null : uwLevelList.get(0))) {
            return null;
        } else if (!uwLevelList.contains(surveyTaskEO.getUwLevel())) {
            throw new StandardRuntimeException("核保等级无效，请检查核保权限配置");
        }
        int currentIndex = uwLevelList.indexOf(surveyTaskEO.getUwLevel());
        return uwLevelList.get(currentIndex - 1);
    }

    /**
     * 检查核保通过的权限
     * 
     * @param surveyTaskEO
     *            业务任务信息
     * @param taskEO
     *            流程任务信息
     * @param productCode
     *            classCode
     */
    protected void checkComplete(SurveyTaskEO surveyTaskEO, TaskEO taskEO, String productCode) {

        /*
         * if (!StringUtils.equals(surveyTaskEO.getAuditType(),
         * SurveyTaskEO.AuditType.Manual.toString())) {
         * LOGGER.info("{}.{}---当前任务的人核类型不为人核[{}]，不需要进行校验",
         * this.getClass().getSimpleName(), "checkComplete",
         * surveyTaskEO.getAuditType()); return; }
         */

        LOGGER.info("UwLevel:{}, FinalUwLevel:{} ", surveyTaskEO.getUwLevel(), surveyTaskEO.getFinalUwLevel());

        // 获取核保员最高核保权限
        List<String> kindList = new ArrayList<>();
        // kindList.add(INSURANCE_TASK_QUERY.getKindByBusinessType(surveyTaskEO.getBusinessNoType()));
        // RbacUserEO rbacUser = rbacUserService.findCurrentUser();
        List<String> uwLevelList = new ArrayList<>();
        // this.underwritingSecurity.getUnderwritingLevel(rbacUser, kindList);

        int finalUwLevelIndex = uwLevelList.indexOf(surveyTaskEO.getFinalUwLevel());
        // int uwLevelIndex = uwLevelList.indexOf(surveyTaskEO.getUwLevel());

        // 权限高的用户可以直接核保通过权限低的单
        if (!uwLevelList.isEmpty()) {
            if (finalUwLevelIndex >= 0) {
                surveyTaskEO.setUwLevel(surveyTaskEO.getFinalUwLevel());
                LOGGER.info("用户[{}]拥有{}的权限，可以审核通过", taskEO.getAssignee(), surveyTaskEO.getFinalUwLevel());
                return;
            } else {
                throw new StandardRuntimeException("该审核通过最低级别为[" + surveyTaskEO.getFinalUwLevel() + "],当前核保人最高核保权限为["
                        + uwLevelList.get(uwLevelList.size() - 1) + "],请提交上级");
            }
        } else {
            throw new StandardRuntimeException("无核保通过权限,请提交上级核保");
        }

    }

    /**
     * 检查回撤权限
     *
     * @param surveyTaskEO
     *            业务任务信息
     * @param taskEO
     *            流程任务信息
     * @param productCode
     *            class code
     * @param assigneeId
     *            回撤接收人员id
     *
     * @return preUwLevel
     */
    protected String checkRecallLevel(SurveyTaskEO surveyTaskEO, TaskEO taskEO, String productCode, Object assigneeId) {
        if (assigneeId == null) {
            throw new StandardRuntimeException("没有申请回撤人员信息，请登录后重试");
        }
        // PROFILE_AUDIT_PATH.getKindByTaskType(surveyTaskEO.getCategory())
        List<String> uwLevelList = this.surveyTaskService.findAllUwLevel((String) assigneeId, productCode, null);
        String preUwLevel = getPreUwLevel(surveyTaskEO, uwLevelList);
        if (StringUtils.isEmpty(preUwLevel)) {
            throw new StandardRuntimeException("当前核保级别[" + surveyTaskEO.getUwLevel() + "]为最低审核级别，无法回撤");
        }
        return preUwLevel;
    }

    /**
     * 检查是否允许提交至上级审核。若没有选择提交级别，则默认提交至下一级别
     *
     * @param surveyTaskEO
     *            业务任务信息
     * @param taskEO
     *            流程任务信息
     * @param productCode
     *            产品分类
     * @param submitUwLevel
     *            提交级别
     *
     * @return submitUwLevel
     */
    protected String checkSubmit(SurveyTaskEO surveyTaskEO, TaskEO taskEO, String productCode, Object submitUwLevel) {
        // PROFILE_AUDIT_PATH.getKindByTaskType(surveyTaskEO.getCategory())
        List<String> uwLevelList = this.surveyTaskService.findAllUwLevel(taskEO.getAssignee(), productCode, null);
        String nextUwLevel = getNextUwLevel(surveyTaskEO, uwLevelList);
        if (StringUtils.isEmpty(nextUwLevel)) {
            throw new StandardRuntimeException("当前核保级别为最高级别，无法提交");
        }
        String uwLevel = (String) submitUwLevel;
        if (StringUtils.isEmpty(uwLevel)) {
            LOGGER.warn("没有选择提交核保权限，默认提交至下级权限[{}]", nextUwLevel);
            uwLevel = nextUwLevel;
        } else if (!uwLevelList.contains(submitUwLevel)) {
            throw new StandardRuntimeException(
                    "该用户[ID:" + taskEO.getAssignee() + "]对产品[" + productCode + "]的核保权限中不包括" + submitUwLevel);
        } else if (uwLevelList.indexOf(surveyTaskEO.getUwLevel()) >= uwLevelList.indexOf(submitUwLevel)) {
            throw new StandardRuntimeException("当前核保权限为[" + surveyTaskEO.getUwLevel() + "]，无法提交至[" + uwLevel + "]级别");
        }
        return uwLevel;
    }

    /**
     * 检查退回权限
     *
     * @param surveyTaskEO
     *            业务任务信息
     * @param taskEO
     *            流程任务信息
     * @param productCode
     *            产品分类
     * @param rejectUwLevelObj
     *            退回级别
     *
     * @return rejectUwLevel
     */
    protected String checkReject(SurveyTaskEO surveyTaskEO, TaskEO taskEO, String productCode, Object rejectUwLevelObj) {
        // PROFILE_AUDIT_PATH.getKindByTaskType(surveyTaskEO.getCategory())
        List<String> uwLevelList = this.surveyTaskService.findAllUwLevel(surveyTaskEO.getAssignee(), productCode, null);
        String rejectUwLevel = (String) rejectUwLevelObj;
        //FIXME
        /*if (StringUtils.isEmpty(rejectUwLevel)) {
            rejectUwLevel = getPreUwLevel(surveyTaskEO, uwLevelList);
        } else if (!uwLevelList.contains(rejectUwLevel)) {
            throw new StandardRuntimeException("当前产品[" + productCode + "]核保权限中不包括" + rejectUwLevel);
        } else if (uwLevelList.indexOf(rejectUwLevel) >= uwLevelList.indexOf(surveyTaskEO.getUwLevel())) {
            throw new StandardRuntimeException(
                    "当前核保权限[" + surveyTaskEO.getUwLevel() + "]级别低于退回级别[" + rejectUwLevel + "]，无法退回");
        }*/
        return rejectUwLevel;
    }
}
