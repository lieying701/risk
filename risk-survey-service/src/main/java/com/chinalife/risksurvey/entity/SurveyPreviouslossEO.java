package com.chinalife.risksurvey.entity;

import java.math.BigDecimal;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

import com.chinalife.spec.entity.InternalFixedActualEO;

/**
 * 以往损失记录
 */
@Entity
@Table(name = "survey_previousloss")
public class SurveyPreviouslossEO extends InternalFixedActualEO {

    /** 主键 */
    private String pkId;
    /** 外键 */
    private String rptId;
    /** 损失原因类型代码 */
    private String lossReasonTypeCode;
    /** 损失原因类型 */
    private String lossReasonType;
    /** 损失时间 */
    private Date lossTime;
    /** 损失金额 */
    private BigDecimal lossAmount;
    /** 具体出险原因 */
    private String accidentReason;
    /** 相关防灾防损预案代码 */
    private String disasterPreventionCode;
    /** 相关防灾防损预案 */
    private String disasterPrevention;
    /** 创建员代码 */
    private String createUserID;
    /** 修改员代码 */
    private String updateUserID;
    /** 创建时间 */
    private Date createDate;
    /** 修改时间 */
    private Date updateDate;

    /**
     * 主键
     * 
     * @return the pkId
     */
    @Column(length = 50)
    public String getPkId() {
        return this.pkId;
    }

    /**
     * 主键
     * 
     * @param pkId
     *            主键
     */
    public void setPkId(String pkId) {
        this.pkId = pkId;
    }

    /**
     * 外键
     * 
     * @return the rptId
     */
    @Column(length = 50)
    public String getRptId() {
        return this.rptId;
    }

    /**
     * 外键
     * 
     * @param rptId
     *            外键
     */
    public void setRptId(String rptId) {
        this.rptId = rptId;
    }

    /**
     * 损失原因类型代码
     * 
     * @return the lossReasonTypeCode
     */
    @Column(length = 12)
    public String getLossReasonTypeCode() {
        return this.lossReasonTypeCode;
    }

    /**
     * 损失原因类型代码
     * 
     * @param lossReasonTypeCode
     *            损失原因类型代码
     */
    public void setLossReasonTypeCode(String lossReasonTypeCode) {
        this.lossReasonTypeCode = lossReasonTypeCode;
    }

    /**
     * 损失原因类型
     * 
     * @return the lossReasonType
     */
    @Column(length = 120)
    public String getLossReasonType() {
        return this.lossReasonType;
    }

    /**
     * 损失原因类型
     * 
     * @param lossReasonType
     *            损失原因类型
     */
    public void setLossReasonType(String lossReasonType) {
        this.lossReasonType = lossReasonType;
    }

    /**
     * 损失时间
     * 
     * @return the lossTime
     */

    public Date getLossTime() {
        return this.lossTime;
    }

    /**
     * 损失时间
     * 
     * @param lossTime
     *            损失时间
     */
    public void setLossTime(Date lossTime) {
        this.lossTime = lossTime;
    }

    /**
     * 损失金额
     * 
     * @return the lossAmount
     */
    @Column(length = 14)
    public BigDecimal getLossAmount() {
        return this.lossAmount;
    }

    /**
     * 损失金额
     * 
     * @param lossAmount
     *            损失金额
     */
    public void setLossAmount(BigDecimal lossAmount) {
        this.lossAmount = lossAmount;
    }

    /**
     * 具体出险原因
     * 
     * @return the accidentReason
     */
    @Column(length = 500)
    public String getAccidentReason() {
        return this.accidentReason;
    }

    /**
     * 具体出险原因
     * 
     * @param accidentReason
     *            具体出险原因
     */
    public void setAccidentReason(String accidentReason) {
        this.accidentReason = accidentReason;
    }

    /**
     * 相关防灾防损预案代码
     * 
     * @return the disasterPreventionCode
     */
    @Column(length = 12)
    public String getDisasterPreventionCode() {
        return this.disasterPreventionCode;
    }

    /**
     * 相关防灾防损预案代码
     * 
     * @param disasterPreventionCode
     *            相关防灾防损预案代码
     */
    public void setDisasterPreventionCode(String disasterPreventionCode) {
        this.disasterPreventionCode = disasterPreventionCode;
    }

    /**
     * 相关防灾防损预案
     * 
     * @return the disasterPrevention
     */
    @Column(length = 120)
    public String getDisasterPrevention() {
        return this.disasterPrevention;
    }

    /**
     * 相关防灾防损预案
     * 
     * @param disasterPrevention
     *            相关防灾防损预案
     */
    public void setDisasterPrevention(String disasterPrevention) {
        this.disasterPrevention = disasterPrevention;
    }

    /**
     * 创建员代码
     * 
     * @return the createUserID
     */
    @Column(length = 50)
    public String getCreateUserID() {
        return this.createUserID;
    }

    /**
     * 创建员代码
     * 
     * @param createUserID
     *            创建员代码
     */
    public void setCreateUserID(String createUserID) {
        this.createUserID = createUserID;
    }

    /**
     * 修改员代码
     * 
     * @return the updateUserID
     */
    @Column(length = 50)
    public String getUpdateUserID() {
        return this.updateUserID;
    }

    /**
     * 修改员代码
     * 
     * @param updateUserID
     *            修改员代码
     */
    public void setUpdateUserID(String updateUserID) {
        this.updateUserID = updateUserID;
    }

    /**
     * 创建时间
     * 
     * @return the createDate
     */

    public Date getCreateDate() {
        return this.createDate;
    }

    /**
     * 创建时间
     * 
     * @param createDate
     *            创建时间
     */
    public void setCreateDate(Date createDate) {
        this.createDate = createDate;
    }

    /**
     * 修改时间
     * 
     * @return the updateDate
     */

    public Date getUpdateDate() {
        return this.updateDate;
    }

    /**
     * 修改时间
     * 
     * @param updateDate
     *            修改时间
     */
    public void setUpdateDate(Date updateDate) {
        this.updateDate = updateDate;
    }

}