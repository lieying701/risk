package com.chinalife.risksurvey.messages.vo;

import org.activiti.engine.delegate.DelegateTask;

import com.chinalife.risksurvey.entity.SurveyTaskEO;
import com.chinalife.workflow.entity.TaskEO;

/**
 * TaskCollectionRequest
 */
public class TaskCollectionRequest {

    /**
     * 任务编号 必须
     */
    private String taskNumber; // 任务编号 必须
    /**
     * 任务来源系统（来源业务系统）的编号 必须
     */
    private String taskSystemNumber;// 任务来源系统（来源业务系统）的编号 必须
    /**
     * 任务类型（各系统同步的任务类型） 必须
     */
    private String taskType;// 任务类型（各系统同步的任务类型） 必须
    /**
     * 任务状态代码[Distributed:待分配Pending:待处理Processing:正在处理Returned:已退回Processed:已处理]
     * 必须
     */
    private String taskStatus;
    /**
     * 任务状态备注值(对于任务状态的真实值)
     */
    private String taskStatusRemark;// 任务状态备注值(对于任务状态的真实值)
    /**
     * 任务结果状态代码[Unfinished:无完成 Success:成功 Failure:失败] 必须
     */
    private String taskResultStatus;//
    /**
     * 任务结果状态备注值(对应任务结果状态的真实值)
     */
    private String taskResultStatusRemark;// 任务结果状态备注值(对应任务结果状态的真实值)
    /**
     * 任务状态变更时间 必须
     */
    private Long taskStatusChangeTime; // 任务状态变更时间 必须
    /**
     * 任务机构代码 必须
     */
    private String taskOrganizationCode;// 任务机构代码 必须
    /**
     * 任务所属产品 必须
     */
    private String taskProduct;// 任务所属产品 必须
    /**
     * 任务分组 必须(按业务实际)
     */
    private String workGroup;// 任务分组 必须(按业务实际)
    /**
     * 任务归属人 必须(按业务实际)
     */
    private String worker;// 任务归属人 必须(按业务实际)
    /**
     * 同步开始时间戳 必须
     */
    private Long syncStartTime; // 同步开始时间戳 必须
    /**
     * 消息通知组,多组时英文逗号间隔
     */
    private String msgNotifyGroup;// 消息通知组,多组时英文逗号间隔
    /**
     * 消息通知人,多人时英文逗号间隔
     */
    private String msgNotifyPeople;// 消息通知人,多人时英文逗号间隔
    /**
     * 删除标识[Effective:有效,Deleted:已删除] 必须
     */
    private String deleteInd;// 删除标识[Effective:有效,Deleted:已删除] 必须
    /**
     * taskSummary
     */
    private TaskSummaryRequest taskSummary;

    /**
     * TaskCollectionRequest
     */
    public TaskCollectionRequest() {
    }

    /**
     * TaskCollectionRequest
     * 
     * @param surveyTaskEO
     *            surveyTaskEO
     * @param taskEO
     *            taskEO
     */
    public TaskCollectionRequest(SurveyTaskEO surveyTaskEO, TaskEO taskEO) {
        this.initFromInsuranceTask(surveyTaskEO);
        this.taskNumber = taskEO.getId();
        this.worker = taskEO.getAssignee();
    }

    /**
     * TaskCollectionRequest
     * 
     * @param surveyTaskEO
     *            surveyTaskEO
     * @param task
     *            task
     */
    public TaskCollectionRequest(SurveyTaskEO surveyTaskEO, DelegateTask task) {
        this.initFromInsuranceTask(surveyTaskEO);
        this.taskNumber = task.getId();
        this.worker = task.getAssignee();
    }

    /**
     * initFromInsuranceTask
     * 
     * @param surveyTaskEO
     *            surveyTaskEO
     */
    private void initFromInsuranceTask(SurveyTaskEO surveyTaskEO) {
        /*
         * BusinessStatusEnum businessStatus =
         * BusinessStatusEnum.stateOf(surveyTaskEO.getOperationType());
         * TaskStatusEnum taskStatus =
         * TaskStatusEnum.statusOf(surveyTaskEO.getStatus()); if (businessStatus
         * == null || taskStatus == null) { return; } this.taskSystemNumber =
         * "B104"; this.taskType = surveyTaskEO.getCategory(); this.taskStatus =
         * businessStatus.isReject() ? CommonConstants.TASK_STATUS_RETURNED :
         * taskStatus.getCode(); this.taskStatusRemark =
         * businessStatus.isReject() ?
         * CommonConstants.TASK_STATUS_RETURNED_DESCRIPTION :
         * taskStatus.getDescription(); this.taskStatusChangeTime =
         * System.currentTimeMillis(); this.syncStartTime =
         * System.currentTimeMillis(); this.taskSummary = new
         * TaskSummaryRequest(surveyTaskEO); // TODO: to be confirmed
         * this.workGroup = surveyTaskEO.getCategory(); this.deleteInd =
         * CommonConstants.EFFECTIVE;
         */
    }

    public String getTaskNumber() {
        return taskNumber;
    }

    public void setTaskNumber(String taskNumber) {
        this.taskNumber = taskNumber;
    }

    public String getTaskSystemNumber() {
        return taskSystemNumber;
    }

    public void setTaskSystemNumber(String taskSystemNumber) {
        this.taskSystemNumber = taskSystemNumber;
    }

    public String getTaskType() {
        return taskType;
    }

    public void setTaskType(String taskType) {
        this.taskType = taskType;
    }

    public String getTaskStatus() {
        return taskStatus;
    }

    public void setTaskStatus(String taskStatus) {
        this.taskStatus = taskStatus;
    }

    public String getTaskStatusRemark() {
        return taskStatusRemark;
    }

    public void setTaskStatusRemark(String taskStatusRemark) {
        this.taskStatusRemark = taskStatusRemark;
    }

    public String getTaskResultStatus() {
        return taskResultStatus;
    }

    public void setTaskResultStatus(String taskResultStatus) {
        this.taskResultStatus = taskResultStatus;
    }

    public String getTaskResultStatusRemark() {
        return taskResultStatusRemark;
    }

    public void setTaskResultStatusRemark(String taskResultStatusRemark) {
        this.taskResultStatusRemark = taskResultStatusRemark;
    }

    public String getTaskOrganizationCode() {
        return taskOrganizationCode;
    }

    public void setTaskOrganizationCode(String taskOrganizationCode) {
        this.taskOrganizationCode = taskOrganizationCode;
    }

    public String getTaskProduct() {
        return taskProduct;
    }

    public void setTaskProduct(String taskProduct) {
        this.taskProduct = taskProduct;
    }

    public String getWorkGroup() {
        return workGroup;
    }

    public void setWorkGroup(String workGroup) {
        this.workGroup = workGroup;
    }

    public String getWorker() {
        return worker;
    }

    public void setWorker(String worker) {
        this.worker = worker;
    }

    public String getMsgNotifyGroup() {
        return msgNotifyGroup;
    }

    public void setMsgNotifyGroup(String msgNotifyGroup) {
        this.msgNotifyGroup = msgNotifyGroup;
    }

    public String getMsgNotifyPeople() {
        return msgNotifyPeople;
    }

    public void setMsgNotifyPeople(String msgNotifyPeople) {
        this.msgNotifyPeople = msgNotifyPeople;
    }

    public String getDeleteInd() {
        return deleteInd;
    }

    public void setDeleteInd(String deleteInd) {
        this.deleteInd = deleteInd;
    }

    public TaskSummaryRequest getTaskSummary() {
        return taskSummary;
    }

    public void setTaskSummary(TaskSummaryRequest taskSummary) {
        this.taskSummary = taskSummary;
    }

    public void setTaskStatusChangeTime(Long taskStatusChangeTime) {
        this.taskStatusChangeTime = taskStatusChangeTime;
    }

    public Long getSyncStartTime() {
        return syncStartTime;
    }

    public void setSyncStartTime(Long syncStartTime) {
        this.syncStartTime = syncStartTime;
    }

    public Long getTaskStatusChangeTime() {
        return taskStatusChangeTime;
    }
}
