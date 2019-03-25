package com.chinalife.risksurvey.vo;

import java.io.Serializable;
import java.util.Date;

import org.springframework.data.annotation.Id;
import org.springframework.data.elasticsearch.annotations.Field;

import com.chinalife.risksurvey.entity.SurveyMainEO;

/**   
 *  综合查询vo   
 */  
public class SurveyComprehensiveQueryVo extends SurveyMainEO implements Serializable {
    
    /**
     * serialVersionUID
     */
    private static final long serialVersionUID = -3651998252372748446L;

    /** 索引Id */
    @Field
    @Id
    private String indexId;
    
    /** 风勘任务号 */
    private String surveyId;
    
    /** 风险查勘部门 */
    private String surveyerDivision;
    
    /** 任务发起时间 */
    private Date taskStarterDate;
    
    /** 任务状态 */
    private String status;
    
    /** customerName 关系人中文名字*/
    private String customerName;
    
    /** 可售产品代码 */
    private String productCode;

    /** 业务单号 */
    private String businessNo;

    public String getSurveyId() {
        return surveyId;
    }

    public void setSurveyId(String surveyId) {
        this.surveyId = surveyId;
    }

    public String getSurveyerDivision() {
        return surveyerDivision;
    }

    public void setSurveyerDivision(String surveyerDivision) {
        this.surveyerDivision = surveyerDivision;
    }

    public Date getTaskStarterDate() {
        return taskStarterDate;
    }

    public void setTaskStarterDate(Date taskStarterDate) {
        this.taskStarterDate = taskStarterDate;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
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

    public String getIndexId() {
        return indexId;
    }

    public void setIndexId(String indexId) {
        this.indexId = indexId;
    }
    
}
