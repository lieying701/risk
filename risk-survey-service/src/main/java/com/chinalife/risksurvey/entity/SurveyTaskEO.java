package com.chinalife.risksurvey.entity;

import com.chinalife.base.entity.AbstractBaseEntity;
import com.chinalife.base.entity.IBaseEntity;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Transient;
import java.util.Date;

/**
 * 包名称： com.chinalife.uw.entity 类名称：SurveyTaskEO<br/>
 * 类描述：任务摘要信息类<br/>
 * 创建人：@author axue016<br/>
 * 创建时间：Jun 20, 2017/1:51:08 PM
 */
/**   
 * 包名称： com.chinalife.risksurvey.entity 
 * 类名称：SurveyTaskEO<br/>    
 * 类描述：<br/>  
 * @version <br/>   
 */  
@Entity
@Table(name = "act_survey_task")
public class SurveyTaskEO extends AbstractBaseEntity implements IBaseEntity {

    /**
     * uid
     */
    private static final long serialVersionUID = -4072942583374380123L;

    /**
     * 主键id
     */
    private Long businessId;

    /**
     * 关联任务号
     */
    private String taskId;

    /**
     * url路径
     */
    private String formKey;

    /**
     * 业务单号
     */
    private String businessNo;

    /**
     * 任务类型
     *
     * @see com.chinalife.risksurvey.task.constants.TaskTypeEnum
     */
    private String category;

    /**
     * 任务状态
     */
    private String status;

    /**
     * 核保等级
     */
    private String uwLevel;

    /**
     * 核保通过等级
     */
    private String finalUwLevel;

    /**
     * surveyMain主键
     */
    private Long surveyId;
  

    /**
     * 风勘名称
     */
    private String surveyName;

    /**
     * 风勘类型
     */
    private String surveyType;

    /**
     * 任务提交生成时间
     */
    private Date submitTime;

    /**
     * 创建人
     */
    private String createUserName;
    /**
     * 任务执行人名
     */
    private String assigneeName;

    /**
     * 任务执行人代码
     */
    private String assignee;

    /**
     * 任务获取时间
     */
    private Date fetchTime;

    /**
     * 任务开始时间
     */
    private Date startTime;
    /**
     * 初次进入核保时间
     */
    private Date firstUWTime;

    /**
     * 前次进入核保时间
     */
    private Date preUWTime;

    /**
     * 当前核保时间
     */
    private Date currentUWTime;

    /**
     * 截止时间
     */
    private Date dueTime;
    /**
     * 完成时间
     */

    private Date endTime;
    /**
     * 最新标识
     */
    private String newFlag;
    /**
     * 操作类型
     * <p/>
     *
     * @see com.chinalife.risksurvey.task.constants.OperationType
     */
    private String operationType;

    /**
     * 申请原因
     */
    private String requestReason;

    /**
     * 序号
     */
    private Integer serialNo;
    
    
    /**
     *  业务状态
     */
    private String surveyStatus;
    
    /**
     * 投保人ID
     */
    private String applicantCode;
    /**
     * 投保人名称
     */
    private String applicantName;
    /**
     * 被保人标识
     */
    private String insurantCode;
    /**
     * 被保人名称
     */
    private String insurantName;
    
    /**
     * 业务任务发起时间
     */
    private Date taskStarterDate;
    /**
     * 业务任务发起人名称
     */
    private String taskStarterName ;
    
    /**
     * 风堪查勘员
     */
    private String surveyer;
    
    /**
     * 产品
     */
    private String product;
    /**
     * 可售产品代码 
     */
    private String productCode;
    /**
     * 可售产品名称 
     */
    private String productName;
    
    /**
     * 出单机构 
     */
    private String makeCom;
    
    /**
     * 出单机构 
     */
    private String  makeComName; 
    /**
     * 车牌号 
     */
    private String plateNo;
    
    /**
     *  任务申请机构
     */
    private String applyDept;
    /**
     *  任务申请机构名称
     */
    private String applyDeptName;


    
    
    @Transient
    public Object getId() {
        return businessId;
    }

    @Override
    public void setId(Object id) {
        if (id != null) {
            this.businessId = (long) id;
        } else {
            this.businessId = null;
        }
    }

    public static long getSerialVersionUID() {
        return serialVersionUID;
    }

    @Id
    public Long getBusinessId() {
        return businessId;
    }

    public void setBusinessId(Long businessId) {
        this.businessId = businessId;
    }

    public String getTaskId() {
        return taskId;
    }

    public void setTaskId(String taskId) {
        this.taskId = taskId;
    }

    public String getFormKey() {
        return formKey;
    }

    public void setFormKey(String formKey) {
        this.formKey = formKey;
    }

    public String getBusinessNo() {
        return businessNo;
    }

    public void setBusinessNo(String businessNo) {
        this.businessNo = businessNo;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getUwLevel() {
        return uwLevel;
    }

    public void setUwLevel(String uwLevel) {
        this.uwLevel = uwLevel;
    }

    public String getFinalUwLevel() {
        return finalUwLevel;
    }

    public void setFinalUwLevel(String finalUwLevel) {
        this.finalUwLevel = finalUwLevel;
    }

    public Long getSurveyId() {
        return surveyId;
    }

    public void setSurveyId(Long surveyId) {
        this.surveyId = surveyId;
    }

    public String getSurveyName() {
        return surveyName;
    }

    public void setSurveyName(String surveyName) {
        this.surveyName = surveyName;
    }

    public String getSurveyType() {
        return surveyType;
    }

    public void setSurveyType(String surveyType) {
        this.surveyType = surveyType;
    }

    public Date getSubmitTime() {
        return submitTime;
    }

    public void setSubmitTime(Date submitTime) {
        this.submitTime = submitTime;
    }

    public String getCreateUserName() {
        return createUserName;
    }

    public void setCreateUserName(String createUserName) {
        this.createUserName = createUserName;
    }

    public String getAssigneeName() {
        return assigneeName;
    }

    public void setAssigneeName(String assigneeName) {
        this.assigneeName = assigneeName;
    }

    public String getAssignee() {
        return assignee;
    }

    public void setAssignee(String assignee) {
        this.assignee = assignee;
    }

    public Date getFetchTime() {
        return fetchTime;
    }

    public void setFetchTime(Date fetchTime) {
        this.fetchTime = fetchTime;
    }

    public Date getFirstUWTime() {
        return firstUWTime;
    }

    public void setFirstUWTime(Date firstUWTime) {
        this.firstUWTime = firstUWTime;
    }

    public Date getPreUWTime() {
        return preUWTime;
    }

    public void setPreUWTime(Date preUWTime) {
        this.preUWTime = preUWTime;
    }

    public Date getCurrentUWTime() {
        return currentUWTime;
    }

    public void setCurrentUWTime(Date currentUWTime) {
        this.currentUWTime = currentUWTime;
    }

    public Date getDueTime() {
        return dueTime;
    }

    public void setDueTime(Date dueTime) {
        this.dueTime = dueTime;
    }

    public Date getEndTime() {
        return endTime;
    }

    public void setEndTime(Date endTime) {
        this.endTime = endTime;
    }

    public String getOperationType() {
        return operationType;
    }

    public void setOperationType(String operationType) {
        this.operationType = operationType;
    }

    public String getRequestReason() {
        return requestReason;
    }

    public void setRequestReason(String requestReason) {
        this.requestReason = requestReason;
    }

    public Integer getSerialNo() {
        return serialNo;
    }

    public void setSerialNo(Integer serialNo) {
        this.serialNo = serialNo;
    }

    public Date getStartTime() {
        return startTime;
    }

    public void setStartTime(Date startTime) {
        this.startTime = startTime;
    }

    public String getNewFlag() {
        return newFlag;
    }

    public void setNewFlag(String newFlag) {
        this.newFlag = newFlag;
    }

    public String getSurveyStatus() {
        return surveyStatus;
    }

    public void setSurveyStatus(String surveyStatus) {
        this.surveyStatus = surveyStatus;
    }

    public String getApplicantCode() {
        return applicantCode;
    }

    public void setApplicantCode(String applicantCode) {
        this.applicantCode = applicantCode;
    }

    public String getApplicantName() {
        return applicantName;
    }

    public void setApplicantName(String applicantName) {
        this.applicantName = applicantName;
    }

    public String getInsurantCode() {
        return insurantCode;
    }

    public void setInsurantCode(String insurantCode) {
        this.insurantCode = insurantCode;
    }

    public String getInsurantName() {
        return insurantName;
    }

    public void setInsurantName(String insurantName) {
        this.insurantName = insurantName;
    }

    public Date getTaskStarterDate() {
        return taskStarterDate;
    }

    public void setTaskStarterDate(Date taskStarterDate) {
        this.taskStarterDate = taskStarterDate;
    }

    public String getSurveyer() {
        return surveyer;
    }

    public void setSurveyer(String surveyer) {
        this.surveyer = surveyer;
    }

    public String getProduct() {
        return product;
    }

    public void setProduct(String product) {
        this.product = product;
    }

    public String getProductCode() {
        return productCode;
    }

    public void setProductCode(String productCode) {
        this.productCode = productCode;
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public String getMakeCom() {
        return makeCom;
    }

    public void setMakeCom(String makeCom) {
        this.makeCom = makeCom;
    }

    public String getMakeComName() {
        return makeComName;
    }

    public void setMakeComName(String makeComName) {
        this.makeComName = makeComName;
    }

    public String getTaskStarterName() {
        return taskStarterName;
    }

    public void setTaskStarterName(String taskStarterName) {
        this.taskStarterName = taskStarterName;
    }

    public String getPlateNo() {
        return plateNo;
    }

    public void setPlateNo(String plateNo) {
        this.plateNo = plateNo;
    }

    public String getApplyDept() {
        return applyDept;
    }

    public void setApplyDept(String applyDept) {
        this.applyDept = applyDept;
    }

    public String getApplyDeptName() {
        return applyDeptName;
    }

    public void setApplyDeptName(String applyDeptName) {
        this.applyDeptName = applyDeptName;
    }
}
