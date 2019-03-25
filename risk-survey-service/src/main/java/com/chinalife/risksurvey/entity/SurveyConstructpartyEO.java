package com.chinalife.risksurvey.entity;

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
 * 工程相关方信息
 */
@Entity
@Table(name = "survey_constructparty")
public class SurveyConstructpartyEO extends AbstractBaseEntity {

    /**
     * 
     */
    private static final long serialVersionUID = 8255956263068166835L;
    /** 主键 */
    private String pkId;
    /** 外键 */
    private String rptId;
    /** 工程所有人 */
    private String constructPeople;
    /** 业务同类项目经验 */
    private String samePrjExper;
    /** 地址勘察单位 */
    private String addressSurveyCo;
    /** 勘察资质代码 */
    private String surveyAptitudeCode;
    /** 勘察资质 */
    private String surveyAptitude;
    /** 勘察同类工程经验标识 */
    private String sameEngSuveyExperFlag;
    /** 勘察同类工程经验 */
    private String sameEngSuveyExper;
    /** 设计单位 */
    private String designCo;
    /** 设计资质代码 */
    private String designAptitudeCode;
    /** 设计资质 */
    private String designAptitude;
    /** 设计同类工程经验标识 */
    private String sameEngDesignExperFlag;
    /** 设计同类工程经验 */
    private String sameEngDesignExper;
    /** 监理单位 */
    private String superviseCo;
    /** 监理资质代码 */
    private String supAptitudeCode;
    /** 监理资质 */
    private String supAptitude;
    /** 监理同类工程经验标识 */
    private String sameEngSupExperFlag;
    /** 监理同类工程经验 */
    private String sameEngSupExper;
    /** 工程总承包商 */
    private String contractor;
    /** 总承包商资质 */
    private String contractorAptitude;
    /** 工程分承包商 */
    private String branchContractor;
    /** 分承包商资质 */
    private String branchContractorAptitude;
    /** 其他施工单位 */
    private String elseConstructCo;
    /** 施工同类工程经验标识 */
    private String sameEngConExperFlag;
    /** 施工同类工程经验 */
    private String sameEngConExper;
    /** 投保方案中被保险人范围 */
    private String insuranceRange;
    /** 工程相关方备注 */
    private String relatePartyRmk;
    /** 创建时间 */
    private Date createDate;
    /** 修改时间 */
    private Date updateDate;

    /**
     * 主键
     * 
     * @return the pkId
     */
    @Id
    @Column(length = 50)
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
     * 工程所有人
     * 
     * @return the constructPeople
     */
    @Column(length = 120)
    public String getConstructPeople() {
        return this.constructPeople;
    }

    /**
     * 工程所有人
     * 
     * @param constructPeople
     *            工程所有人
     */
    public void setConstructPeople(String constructPeople) {
        this.constructPeople = constructPeople;
    }

    /**
     * 业务同类项目经验
     * 
     * @return the samePrjExper
     */
    @Column(length = 255)
    public String getSamePrjExper() {
        return this.samePrjExper;
    }

    /**
     * 业务同类项目经验
     * 
     * @param samePrjExper
     *            业务同类项目经验
     */
    public void setSamePrjExper(String samePrjExper) {
        this.samePrjExper = samePrjExper;
    }

    /**
     * 地址勘察单位
     * 
     * @return the addressSurveyCo
     */
    @Column(length = 120)
    public String getAddressSurveyCo() {
        return this.addressSurveyCo;
    }

    /**
     * 地址勘察单位
     * 
     * @param addressSurveyCo
     *            地址勘察单位
     */
    public void setAddressSurveyCo(String addressSurveyCo) {
        this.addressSurveyCo = addressSurveyCo;
    }

    /**
     * 勘察资质代码
     * 
     * @return the surveyAptitudeCode
     */
    @Column(length = 12)
    public String getSurveyAptitudeCode() {
        return this.surveyAptitudeCode;
    }

    /**
     * 勘察资质代码
     * 
     * @param surveyAptitudeCode
     *            勘察资质代码
     */
    public void setSurveyAptitudeCode(String surveyAptitudeCode) {
        this.surveyAptitudeCode = surveyAptitudeCode;
    }

    /**
     * 勘察资质
     * 
     * @return the surveyAptitude
     */
    @Column(length = 120)
    public String getSurveyAptitude() {
        return this.surveyAptitude;
    }

    /**
     * 勘察资质
     * 
     * @param surveyAptitude
     *            勘察资质
     */
    public void setSurveyAptitude(String surveyAptitude) {
        this.surveyAptitude = surveyAptitude;
    }

    /**
     * 勘察同类工程经验标识
     * 
     * @return the sameEngSuveyExperFlag
     */
    @Column(length = 12)
    public String getSameEngSuveyExperFlag() {
        return this.sameEngSuveyExperFlag;
    }

    /**
     * 勘察同类工程经验标识
     * 
     * @param sameEngSuveyExperFlag
     *            勘察同类工程经验标识
     */
    public void setSameEngSuveyExperFlag(String sameEngSuveyExperFlag) {
        this.sameEngSuveyExperFlag = sameEngSuveyExperFlag;
    }

    /**
     * 勘察同类工程经验
     * 
     * @return the sameEngSuveyExper
     */
    @Column(length = 255)
    public String getSameEngSuveyExper() {
        return this.sameEngSuveyExper;
    }

    /**
     * 勘察同类工程经验
     * 
     * @param sameEngSuveyExper
     *            勘察同类工程经验
     */
    public void setSameEngSuveyExper(String sameEngSuveyExper) {
        this.sameEngSuveyExper = sameEngSuveyExper;
    }

    /**
     * 设计单位
     * 
     * @return the designCo
     */
    @Column(length = 120)
    public String getDesignCo() {
        return this.designCo;
    }

    /**
     * 设计单位
     * 
     * @param designCo
     *            设计单位
     */
    public void setDesignCo(String designCo) {
        this.designCo = designCo;
    }

    /**
     * 设计资质代码
     * 
     * @return the designAptitudeCode
     */
    @Column(length = 12)
    public String getDesignAptitudeCode() {
        return this.designAptitudeCode;
    }

    /**
     * 设计资质代码
     * 
     * @param designAptitudeCode
     *            设计资质代码
     */
    public void setDesignAptitudeCode(String designAptitudeCode) {
        this.designAptitudeCode = designAptitudeCode;
    }

    /**
     * 设计资质
     * 
     * @return the designAptitude
     */
    @Column(length = 120)
    public String getDesignAptitude() {
        return this.designAptitude;
    }

    /**
     * 设计资质
     * 
     * @param designAptitude
     *            设计资质
     */
    public void setDesignAptitude(String designAptitude) {
        this.designAptitude = designAptitude;
    }

    /**
     * 设计同类工程经验标识
     * 
     * @return the sameEngDesignExperFlag
     */
    @Column(length = 12)
    public String getSameEngDesignExperFlag() {
        return this.sameEngDesignExperFlag;
    }

    /**
     * 设计同类工程经验标识
     * 
     * @param sameEngDesignExperFlag
     *            设计同类工程经验标识
     */
    public void setSameEngDesignExperFlag(String sameEngDesignExperFlag) {
        this.sameEngDesignExperFlag = sameEngDesignExperFlag;
    }

    /**
     * 设计同类工程经验
     * 
     * @return the sameEngDesignExper
     */
    @Column(length = 255)
    public String getSameEngDesignExper() {
        return this.sameEngDesignExper;
    }

    /**
     * 设计同类工程经验
     * 
     * @param sameEngDesignExper
     *            设计同类工程经验
     */
    public void setSameEngDesignExper(String sameEngDesignExper) {
        this.sameEngDesignExper = sameEngDesignExper;
    }

    /**
     * 监理单位
     * 
     * @return the superviseCo
     */
    @Column(length = 120)
    public String getSuperviseCo() {
        return this.superviseCo;
    }

    /**
     * 监理单位
     * 
     * @param superviseCo
     *            监理单位
     */
    public void setSuperviseCo(String superviseCo) {
        this.superviseCo = superviseCo;
    }

    /**
     * 监理资质代码
     * 
     * @return the supAptitudeCode
     */
    @Column(length = 12)
    public String getSupAptitudeCode() {
        return this.supAptitudeCode;
    }

    /**
     * 监理资质代码
     * 
     * @param supAptitudeCode
     *            监理资质代码
     */
    public void setSupAptitudeCode(String supAptitudeCode) {
        this.supAptitudeCode = supAptitudeCode;
    }

    /**
     * 监理资质
     * 
     * @return the supAptitude
     */
    @Column(length = 120)
    public String getSupAptitude() {
        return this.supAptitude;
    }

    /**
     * 监理资质
     * 
     * @param supAptitude
     *            监理资质
     */
    public void setSupAptitude(String supAptitude) {
        this.supAptitude = supAptitude;
    }

    /**
     * 监理同类工程经验标识
     * 
     * @return the sameEngSupExperFlag
     */
    @Column(length = 12)
    public String getSameEngSupExperFlag() {
        return this.sameEngSupExperFlag;
    }

    /**
     * 监理同类工程经验标识
     * 
     * @param sameEngSupExperFlag
     *            监理同类工程经验标识
     */
    public void setSameEngSupExperFlag(String sameEngSupExperFlag) {
        this.sameEngSupExperFlag = sameEngSupExperFlag;
    }

    /**
     * 监理同类工程经验
     * 
     * @return the sameEngSupExper
     */
    @Column(length = 255)
    public String getSameEngSupExper() {
        return this.sameEngSupExper;
    }

    /**
     * 监理同类工程经验
     * 
     * @param sameEngSupExper
     *            监理同类工程经验
     */
    public void setSameEngSupExper(String sameEngSupExper) {
        this.sameEngSupExper = sameEngSupExper;
    }

    /**
     * 工程总承包商
     * 
     * @return the contractor
     */
    @Column(length = 120)
    public String getContractor() {
        return this.contractor;
    }

    /**
     * 工程总承包商
     * 
     * @param contractor
     *            工程总承包商
     */
    public void setContractor(String contractor) {
        this.contractor = contractor;
    }

    /**
     * 总承包商资质
     * 
     * @return the contractorAptitude
     */
    @Column(length = 255)
    public String getContractorAptitude() {
        return this.contractorAptitude;
    }

    /**
     * 总承包商资质
     * 
     * @param contractorAptitude
     *            总承包商资质
     */
    public void setContractorAptitude(String contractorAptitude) {
        this.contractorAptitude = contractorAptitude;
    }

    /**
     * 工程分承包商
     * 
     * @return the branchContractor
     */
    @Column(length = 120)
    public String getBranchContractor() {
        return this.branchContractor;
    }

    /**
     * 工程分承包商
     * 
     * @param branchContractor
     *            工程分承包商
     */
    public void setBranchContractor(String branchContractor) {
        this.branchContractor = branchContractor;
    }

    /**
     * 分承包商资质
     * 
     * @return the branchContractorAptitude
     */
    @Column(length = 255)
    public String getBranchContractorAptitude() {
        return this.branchContractorAptitude;
    }

    /**
     * 分承包商资质
     * 
     * @param branchContractorAptitude
     *            分承包商资质
     */
    public void setBranchContractorAptitude(String branchContractorAptitude) {
        this.branchContractorAptitude = branchContractorAptitude;
    }

    /**
     * 其他施工单位
     * 
     * @return the elseConstructCo
     */
    @Column(length = 120)
    public String getElseConstructCo() {
        return this.elseConstructCo;
    }

    /**
     * 其他施工单位
     * 
     * @param elseConstructCo
     *            其他施工单位
     */
    public void setElseConstructCo(String elseConstructCo) {
        this.elseConstructCo = elseConstructCo;
    }

    /**
     * 施工同类工程经验标识
     * 
     * @return the sameEngConExperFlag
     */
    @Column(length = 12)
    public String getSameEngConExperFlag() {
        return this.sameEngConExperFlag;
    }

    /**
     * 施工同类工程经验标识
     * 
     * @param sameEngConExperFlag
     *            施工同类工程经验标识
     */
    public void setSameEngConExperFlag(String sameEngConExperFlag) {
        this.sameEngConExperFlag = sameEngConExperFlag;
    }

    /**
     * 施工同类工程经验
     * 
     * @return the sameEngConExper
     */
    @Column(length = 255)
    public String getSameEngConExper() {
        return this.sameEngConExper;
    }

    /**
     * 施工同类工程经验
     * 
     * @param sameEngConExper
     *            施工同类工程经验
     */
    public void setSameEngConExper(String sameEngConExper) {
        this.sameEngConExper = sameEngConExper;
    }

    /**
     * 投保方案中被保险人范围
     * 
     * @return the insuranceRange
     */
    @Column(length = 50)
    public String getInsuranceRange() {
        return this.insuranceRange;
    }

    /**
     * 投保方案中被保险人范围
     * 
     * @param insuranceRange
     *            投保方案中被保险人范围
     */
    public void setInsuranceRange(String insuranceRange) {
        this.insuranceRange = insuranceRange;
    }

    /**
     * 工程相关方备注
     * 
     * @return the relatePartyRmk
     */
    @Column(length = 500)
    public String getRelatePartyRmk() {
        return this.relatePartyRmk;
    }

    /**
     * 工程相关方备注
     * 
     * @param relatePartyRmk
     *            工程相关方备注
     */
    public void setRelatePartyRmk(String relatePartyRmk) {
        this.relatePartyRmk = relatePartyRmk;
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