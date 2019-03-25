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
 * 风勘项
 */
@Entity
@Table(name = "survey_itemlist")
public class SurveyItemlistEO extends AbstractBaseEntity {

    /**
     * 
     */
    private static final long serialVersionUID = -4800102184615463904L;
    /** 主键 */
    private String pkId;
    /** 外键 */
    private String rptId;
    /** 风勘任务号 */
    private String surveyId;
    /** 风勘项代码 */
    private String surveyItemCode;
    /** 风勘项名称 */
    private String surveyItem;
    /** 频度 */
    private BigDecimal frequency;
    /** 烈度 */
    private BigDecimal intensity;
    /** 风险等级 */
    private String riskLevel;
    /** 模块地址 */
    private String modelUrl;
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
     * 风勘项代码
     * 
     * @return the surveyItemCode
     */
    @Column(length = 50)
    public String getSurveyItemCode() {
        return this.surveyItemCode;
    }

    /**
     * 风勘项代码
     * 
     * @param surveyItemCode
     *            风勘项代码
     */
    public void setSurveyItemCode(String surveyItemCode) {
        this.surveyItemCode = surveyItemCode;
    }

    /**
     * 风勘项名称
     * 
     * @return the surveyItem
     */
    @Column(length = 500)
    public String getSurveyItem() {
        return this.surveyItem;
    }

    /**
     * 风勘项名称
     * 
     * @param surveyItem
     *            风勘项名称
     */
    public void setSurveyItem(String surveyItem) {
        this.surveyItem = surveyItem;
    }

    /**
     * 频度
     * 
     * @return the frequency
     */

    public BigDecimal getFrequency() {
        return this.frequency;
    }

    /**
     * 频度
     * 
     * @param frequency
     *            频度
     */
    public void setFrequency(BigDecimal frequency) {
        this.frequency = frequency;
    }

    /**
     * 烈度
     * 
     * @return the intensity
     */

    public BigDecimal getIntensity() {
        return this.intensity;
    }

    /**
     * 烈度
     * 
     * @param intensity
     *            烈度
     */
    public void setIntensity(BigDecimal intensity) {
        this.intensity = intensity;
    }

    /**
     * 风险等级
     * 
     * @return the riskLevel
     */
    @Column(length = 50)
    public String getRiskLevel() {
        return this.riskLevel;
    }

    /**
     * 风险等级
     * 
     * @param riskLevel
     *            风险等级
     */
    public void setRiskLevel(String riskLevel) {
        this.riskLevel = riskLevel;
    }

    /**
     * 模块地址
     * 
     * @return the modelUrl
     */
    @Column(length = 500)
    public String getModelUrl() {
        return this.modelUrl;
    }

    /**
     * 模块地址
     * 
     * @param modelUrl
     *            模块地址
     */
    public void setModelUrl(String modelUrl) {
        this.modelUrl = modelUrl;
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