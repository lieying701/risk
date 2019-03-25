package com.chinalife.risksurvey.entity;

import java.math.BigDecimal;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Transient;

import org.hibernate.annotations.GenericGenerator;

import com.chinalife.base.entity.AbstractBaseEntity;

/**
 * 基本信息
 */
@Entity
@Table(name = "survey_basic")
public class SurveyBasicEO extends AbstractBaseEntity {

    /**
     * serialVersionUID
     */
    private static final long serialVersionUID = 65242098784534606L;
    /** 主键 */
    private String pkId;
    /** 外键 */
    private String rptId;
    /** 风勘任务号 */
    private String surveyId;
    /** 存款 */
    private BigDecimal deposit;
    /** 机器设备 */
    private String machine;
    /** 是否足额投保 */
    private String fullCoverFlag;
    /** 是否承保营业中断 */
    private String bizInterruptFlag;
    /** 营业中断保险金额 */
    private BigDecimal bizInterruptCoverAmnt;
    /** 赔偿期限 */
    private BigDecimal claimPeriod;
    /** 总体风险描述及综合评价 */
    private String overallDesc;
    /** 防灾防损建议 */
    private String disasterPrevSug;
    /** 承保建议 */
    private String coverRecognize;
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
    @Id
    @GeneratedValue(generator = "uuid")
    @GenericGenerator(name = "uuid", strategy = "org.hibernate.id.UUIDGenerator")
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
     * 风勘任务号
     * 
     * @return the surveyId
     */
    @Column(length = 50)
    public String getSurveyId() {
        return this.surveyId;
    }

    /**
     * 风勘任务号
     * 
     * @param surveyId
     *            风勘任务号
     */
    public void setSurveyId(String surveyId) {
        this.surveyId = surveyId;
    }

    /**
     * 存款
     * 
     * @return the deposit
     */

    public BigDecimal getDeposit() {
        return this.deposit;
    }

    /**
     * 存款
     * 
     * @param deposit
     *            存款
     */
    public void setDeposit(BigDecimal deposit) {
        this.deposit = deposit;
    }

    /**
     * 机器设备
     * 
     * @return the machine
     */
    @Column(length = 500)
    public String getMachine() {
        return this.machine;
    }

    /**
     * 机器设备
     * 
     * @param machine
     *            机器设备
     */
    public void setMachine(String machine) {
        this.machine = machine;
    }

    /**
     * 是否足额投保
     * 
     * @return the fullCoverFlag
     */
    @Column(length = 12)
    public String getFullCoverFlag() {
        return this.fullCoverFlag;
    }

    /**
     * 是否足额投保
     * 
     * @param fullCoverFlag
     *            是否足额投保
     */
    public void setFullCoverFlag(String fullCoverFlag) {
        this.fullCoverFlag = fullCoverFlag;
    }

    /**
     * 是否承保营业中断
     * 
     * @return the bizInterruptFlag
     */
    @Column(length = 12)
    public String getBizInterruptFlag() {
        return this.bizInterruptFlag;
    }

    /**
     * 是否承保营业中断
     * 
     * @param bizInterruptFlag
     *            是否承保营业中断
     */
    public void setBizInterruptFlag(String bizInterruptFlag) {
        this.bizInterruptFlag = bizInterruptFlag;
    }

    /**
     * 营业中断保险金额
     * 
     * @return the bizInterruptCoverAmnt
     */

    public BigDecimal getBizInterruptCoverAmnt() {
        return this.bizInterruptCoverAmnt;
    }

    /**
     * 营业中断保险金额
     * 
     * @param bizInterruptCoverAmnt
     *            营业中断保险金额
     */
    public void setBizInterruptCoverAmnt(BigDecimal bizInterruptCoverAmnt) {
        this.bizInterruptCoverAmnt = bizInterruptCoverAmnt;
    }

    /**
     * 赔偿期限
     * 
     * @return the claimPeriod
     */

    public BigDecimal getClaimPeriod() {
        return this.claimPeriod;
    }

    /**
     * 赔偿期限
     * 
     * @param claimPeriod
     *            赔偿期限
     */
    public void setClaimPeriod(BigDecimal claimPeriod) {
        this.claimPeriod = claimPeriod;
    }

    /**
     * 总体风险描述及综合评价
     * 
     * @return the overallDesc
     */
    @Column(length = 3999)
    public String getOverallDesc() {
        return this.overallDesc;
    }

    /**
     * 总体风险描述及综合评价
     * 
     * @param overallDesc
     *            总体风险描述及综合评价
     */
    public void setOverallDesc(String overallDesc) {
        this.overallDesc = overallDesc;
    }

    /**
     * 防灾防损建议
     * 
     * @return the disasterPrevSug
     */
    @Column(length = 3999)
    public String getDisasterPrevSug() {
        return this.disasterPrevSug;
    }

    /**
     * 防灾防损建议
     * 
     * @param disasterPrevSug
     *            防灾防损建议
     */
    public void setDisasterPrevSug(String disasterPrevSug) {
        this.disasterPrevSug = disasterPrevSug;
    }

    /**
     * 承保建议
     * 
     * @return the coverRecognize
     */
    @Column(length = 3999)
    public String getCoverRecognize() {
        return this.coverRecognize;
    }

    /**
     * 承保建议
     * 
     * @param coverRecognize
     *            承保建议
     */
    public void setCoverRecognize(String coverRecognize) {
        this.coverRecognize = coverRecognize;
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
    
    @Override
    public void setId(Object id) {
        if (id != null) {
            this.pkId = (String) id;
        } else {
            this.pkId = null;
        }
    }

    @Override
    @Transient
    public Object getId() {
        return this.pkId;
    }

}