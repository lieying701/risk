package com.chinalife.risksurvey.messages.vo;

import com.chinalife.risksurvey.entity.SurveyTaskEO;

/**
 * TaskSummaryRequest
 */
public class TaskSummaryRequest {

    /**
     * 投保人
     */
    private String applicant;// 投保人
    /**
     * 被保险人
     */
    private String insurant;// 被保险人
    /**
     * 客户等级
     */
    private String customerLevel; // 客户等级
    /**
     * 批次号码
     */
    private String batchNumber;// 批次号码
    /**
     * 险种大类
     */
    private String insuranceClass;// 险种大类
    /**
     * 销售渠道
     */
    private String distributionChannel;// 销售渠道
    /**
     * 关注标签
     */
    private String attentionLabels;// 关注标签 [label1,label2,...]
    /**
     * 风险等级
     */
    private String riskLevel;// 风险等级
    /**
     * 总保额
     */
    private String grossLine;// 总保额
    /**
     * 总保费
     */
    private String grossPremium;// 总保费
    /**
     * 紧急度[high:高, medium:中 , low:低]
     */
    private String urgencyLevel;// 紧急度[high:高, medium:中 , low:低]
    /**
     * 版本号码
     */
    private String version;// 版本号码
    /**
     * 业务来源
     */
    private String taskResource;// 业务来源

    /**
     * TaskSummaryRequest
     */
    public TaskSummaryRequest() {
    }

    /**
     * TaskSummaryRequest
     * 
     * @param surveyTaskEO
     *            surveyTaskEO
     */
    public TaskSummaryRequest(SurveyTaskEO surveyTaskEO) {
        // TODO: should be confirmed
        this.riskLevel = null;
        this.grossLine = null;
        this.grossPremium = null;
        this.version = null;
    }

    public String getApplicant() {
        return applicant;
    }

    public void setApplicant(String applicant) {
        this.applicant = applicant;
    }

    public String getInsurant() {
        return insurant;
    }

    public void setInsurant(String insurant) {
        this.insurant = insurant;
    }

    public String getCustomerLevel() {
        return customerLevel;
    }

    public void setCustomerLevel(String customerLevel) {
        this.customerLevel = customerLevel;
    }

    public String getBatchNumber() {
        return batchNumber;
    }

    public void setBatchNumber(String batchNumber) {
        this.batchNumber = batchNumber;
    }

    public String getInsuranceClass() {
        return insuranceClass;
    }

    public void setInsuranceClass(String insuranceClass) {
        this.insuranceClass = insuranceClass;
    }

    public String getDistributionChannel() {
        return distributionChannel;
    }

    public void setDistributionChannel(String distributionChannel) {
        this.distributionChannel = distributionChannel;
    }

    public String getAttentionLabels() {
        return attentionLabels;
    }

    public void setAttentionLabels(String attentionLabels) {
        this.attentionLabels = attentionLabels;
    }

    public String getRiskLevel() {
        return riskLevel;
    }

    public void setRiskLevel(String riskLevel) {
        this.riskLevel = riskLevel;
    }

    public String getGrossLine() {
        return grossLine;
    }

    public void setGrossLine(String grossLine) {
        this.grossLine = grossLine;
    }

    public String getGrossPremium() {
        return grossPremium;
    }

    public void setGrossPremium(String grossPremium) {
        this.grossPremium = grossPremium;
    }

    public String getUrgencyLevel() {
        return urgencyLevel;
    }

    public void setUrgencyLevel(String urgencyLevel) {
        this.urgencyLevel = urgencyLevel;
    }

    public String getVersion() {
        return version;
    }

    public void setVersion(String version) {
        this.version = version;
    }

    public String getTaskResource() {
        return taskResource;
    }

    public void setTaskResource(String taskResource) {
        this.taskResource = taskResource;
    }
}
