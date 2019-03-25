package com.chinalife.risksurvey.vo;

import java.util.Date;

/**   
 * 包名称： com.chinalife.risksurvey.vo 
 * 类名称：SurveyMainBusinessCustomerVO<br/>    
 * 类描述：<br/>  
 * @version <br/>   
 *     
 */  
public class SurveyMainBusinessCustomerVO {
    
    /** 风勘任务号 */
    private String surveyId;
    
    /** customerCode */
    // private String customerCode;
    
    /** customerName 关系人中文名字*/
    private String customerName;
    
    /** 可售产品代码 */
    private String productCode;
    
    /** 可售产品 */
    //private String productName;

    /** 业务单号 */
    private String businessNo;
    
    /** 任务状态 */
    private String status;
    
    /** 任务发起人 */
    private String taskStarter;
    
    /** 任务申请机构 */
    private String applyDept;
    
    /** 任务申请机构名称 */
    private String applyDeptName;
    
    /** 车牌号 */
    private String plateNo;
    
    /** 任务发起时间 */
    private Date taskStarterDate;
    
    public String getSurveyId() {
        return surveyId;
    }

    public void setSurveyId(String surveyId) {
        this.surveyId = surveyId;
    }

    public String getCustomerName() {
        return customerName;
    }

    public void setCustomerName(String customerName) {
        this.customerName = customerName;
    }

    public String getProductCode() {
        return productCode;
    }

    public void setProductCode(String productCode) {
        this.productCode = productCode;
    }

    public String getBusinessNo() {
        return businessNo;
    }

    public void setBusinessNo(String businessNo) {
        this.businessNo = businessNo;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getTaskStarter() {
        return taskStarter;
    }

    public void setTaskStarter(String taskStarter) {
        this.taskStarter = taskStarter;
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

    public String getPlateNo() {
        return plateNo;
    }

    public void setPlateNo(String plateNo) {
        this.plateNo = plateNo;
    }

    public Date getTaskStarterDate() {
        return taskStarterDate;
    }

    public void setTaskStarterDate(Date taskStarterDate) {
        this.taskStarterDate = taskStarterDate;
    }
}
