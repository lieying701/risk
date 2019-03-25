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
 * 关联业务表
 */
@Entity
@Table(name = "survey_relbusiness")
public class SurveyRelBusinessEO extends AbstractBaseEntity {

    /**
     * 
     */
    private static final long serialVersionUID = 4729104965607777136L;
    /** 主键 */
    private String pkId;
    /** 风勘任务号 */
    private String surveyId;
    /** 业务单号 */
    private String businessNo;
    /** 业务类型 */
    private String businessType;
    /** 报价单号 */
    private String quoteNo;
    /** 投保单号 */
    private String proposalNo;
    /** 保单号 */
    private String policyNo;
    /** 批改申请单号 */
    private String endorseSequenceNo;
    /** 批单号 */
    private String endorseNo;
    /** 是否有效关联 */
    private String validflag;
    /** 出单机构 */
    private String makeCom;
    /** 出单机构名称 */
    private String makeComName;
    /** 查勘次数 */
    private BigDecimal surveyTimes;
    /** 创建员代码 */
    /* private String createUserID; */
    /** 修改员代码 */
    /* private String updateUserID; */
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
     * 业务单号
     * 
     * @return the businessNo
     */
    @Column(length = 50)
    public String getBusinessNo() {
        return this.businessNo;
    }

    /**
     * 业务单号
     * 
     * @param businessNo
     *            业务单号
     */
    public void setBusinessNo(String businessNo) {
        this.businessNo = businessNo;
    }

    /**
     * 业务类型
     * 
     * @return the businessType
     */
    @Column(length = 12)
    public String getBusinessType() {
        return this.businessType;
    }

    /**
     * 业务类型
     * 
     * @param businessType
     *            业务类型
     */
    public void setBusinessType(String businessType) {
        this.businessType = businessType;
    }

    /**
     * 报价单号
     * 
     * @return the quoteNo
     */
    @Column(length = 50)
    public String getQuoteNo() {
        return this.quoteNo;
    }

    /**
     * 报价单号
     * 
     * @param quoteNo
     *            报价单号
     */
    public void setQuoteNo(String quoteNo) {
        this.quoteNo = quoteNo;
    }

    /**
     * 投保单号
     * 
     * @return the proposalNo
     */
    @Column(length = 50)
    public String getProposalNo() {
        return this.proposalNo;
    }

    /**
     * 投保单号
     * 
     * @param proposalNo
     *            投保单号
     */
    public void setProposalNo(String proposalNo) {
        this.proposalNo = proposalNo;
    }

    /**
     * 保单号
     * 
     * @return the policyNo
     */
    @Column(length = 50)
    public String getPolicyNo() {
        return this.policyNo;
    }

    /**
     * 保单号
     * 
     * @param policyNo
     *            保单号
     */
    public void setPolicyNo(String policyNo) {
        this.policyNo = policyNo;
    }

    /**
     * 批改申请单号
     * 
     * @return the endorseSequenceNo
     */
    @Column(length = 50)
    public String getEndorseSequenceNo() {
        return this.endorseSequenceNo;
    }

    /**
     * 批改申请单号
     * 
     * @param endorseSequenceNo
     *            批改申请单号
     */
    public void setEndorseSequenceNo(String endorseSequenceNo) {
        this.endorseSequenceNo = endorseSequenceNo;
    }

    /**
     * 批单号
     * 
     * @return the endorseNo
     */
    @Column(length = 50)
    public String getEndorseNo() {
        return this.endorseNo;
    }

    /**
     * 批单号
     * 
     * @param endorseNo
     *            批单号
     */
    public void setEndorseNo(String endorseNo) {
        this.endorseNo = endorseNo;
    }

    /**
     * 是否有效关联
     * 
     * @return the validflag
     */
    @Column(length = 12)
    public String getValidflag() {
        return this.validflag;
    }

    /**
     * 是否有效关联
     * 
     * @param validflag
     *            是否有效关联
     */
    public void setValidflag(String validflag) {
        this.validflag = validflag;
    }

    /**
     * 出单机构
     * 
     * @return the makeCom
     */
    @Column(length = 12)
    public String getMakeCom() {
        return this.makeCom;
    }

    /**
     * 出单机构
     * 
     * @param makeCom
     *            出单机构
     */
    public void setMakeCom(String makeCom) {
        this.makeCom = makeCom;
    }

    /**
     * 出单机构名称
     * 
     * @return the makeComName
     */
    @Column(length = 50)
    public String getMakeComName() {
        return this.makeComName;
    }

    /**
     * 出单机构名称
     * 
     * @param makeComName
     *            出单机构名称
     */
    public void setMakeComName(String makeComName) {
        this.makeComName = makeComName;
    }

    /**
     * 查勘次数
     * 
     * @return the surveyTimes
     */

    public BigDecimal getSurveyTimes() {
        return this.surveyTimes;
    }

    /**
     * 查勘次数
     * 
     * @param surveyTimes
     *            查勘次数
     */
    public void setSurveyTimes(BigDecimal surveyTimes) {
        this.surveyTimes = surveyTimes;
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