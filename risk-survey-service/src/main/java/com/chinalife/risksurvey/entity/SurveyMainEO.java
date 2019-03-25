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
 * 风勘主表
 */
@Entity
@Table(name = "survey_main")
public class SurveyMainEO extends AbstractBaseEntity {

    /**
     * 
     */
    private static final long serialVersionUID = 3429740455585629787L;
    /** 主键 */
    private String pkId;
    /** 风勘任务号 */
    private String surveyId;
    /** 修改序号 */
    private BigDecimal modifyNo;
    /** 最新标识 */
    private String newFlag;
    /** 任务发起人 */
    private String taskStarter;
    /** 任务发起人名称 */
    private String taskStarterName;
    /** 任务发起时间 */
    private Date taskStarterDate;
    /** 任务状态 */
    private String status;
    /** 任务分类：正常、退回、上报 */
    private String taskType;
    /** 任务申请机构二级 */
    private String applyDeptSec;
    /** 任务申请机构二级名称 */
    private String applyDeptSecName;
    /** 任务申请机构三级 */
    private String applyDeptThr;
    /** 任务申请机构三级名称 */
    private String applyDeptThrName;
    /** 任务申请机构 */
    private String applyDept;
    /** 任务申请机构名称 */
    private String applyDeptName;
    /** 风勘报告归属机构二级 */
    private String reportDeptSec;
    /** 风勘报告归属机构名称二级 */
    private String reportDeptNameSec;
    /** 风勘报告归属机构三级 */
    private String reportDeptThr;
    /** 风勘报告归属机构名称三级 */
    private String reportDeptNameThr;
    /** 风勘报告归属机构 */
    private String reportDept;
    /** 风勘报告归属机构名称 */
    private String reportDeptName;
    /** 审核人代码 */
    private String approceOperCode;
    /** 审核人 */
    private String approceOper;
    /** 审核结果 */
    private String approceOpn;
    /** 审核时间 */
    private Date approceTime;
    /** 审核意见 */
    private String approceRmk;
    /** 查勘报告质量评估代码 */
    private String qualityAssessCode;
    /** 查勘报告质量评估 */
    private String qualityAssess;
    /** 查勘报告时效性代码 */
    private String reportTimeCode;
    /** 查勘报告时效性 */
    private String reportTime;
    /** 产品 */
    private String product;
    /** 可售产品代码 */
    private String productCode;
    /** 可售产品 */
    private String productName;
    /** 保险金额 */
    private BigDecimal amount;
    /** 风险查勘员 */
    private String surveyer;
    /** 风险查勘日期 */
    private Date surveyerDate;
    /** 风险查勘类型 */
    private String surveyerType;
    /** 风险查勘部门 */
    private String surveyerDivision;
    /** 风险查勘部门代码 */
    private String surveyerDivisionCode;
    /** 报告制作人 */
    private String reportProducer;
    /** 报告制作日期 */
    private Date reportProduceDate;
    /** 车牌号 */
    private String plateNo;
    /** 风勘报告摘要 */
    private String reportSummary;
    /** 风勘结果描述 */
    private String reportDescribe;
    /** 是否委托第三方 */
    private String entrustFlag;
    /** 第三方代码 */
    private String thirdPartyCode;
    /** 第三方名称 */
    private String thirdPartyName;
    /** 创建员代码 */
    /* private String createUserID; */
    /** 修改员代码 */
    /* private String updateUserID; */
    /** 创建时间 */
    private Date createDate;
    /** 修改时间 */
    private Date updateDate;
    /** 查勘次数 */
    private BigDecimal surveyTimes;


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
     * 修改序号
     * 
     * @return the modifyNo
     */

    public BigDecimal getModifyNo() {
        return this.modifyNo;
    }

    /**
     * 修改序号
     * 
     * @param modifyNo
     *            修改序号
     */
    public void setModifyNo(BigDecimal modifyNo) {
        this.modifyNo = modifyNo;
    }


    /**
     * 任务发起人
     * 
     * @return the taskStarter
     */
    @Column(length = 50)
    public String getTaskStarter() {
        return this.taskStarter;
    }

    /**
     * 任务发起人
     * 
     * @param taskStarter
     *            任务发起人
     */
    public void setTaskStarter(String taskStarter) {
        this.taskStarter = taskStarter;
    }

    /**
     * 任务发起人名称
     * 
     * @return the taskStarterName
     */
    @Column(length = 120)
    public String getTaskStarterName() {
        return this.taskStarterName;
    }

    /**
     * 任务发起人名称
     * 
     * @param taskStarterName
     *            任务发起人名称
     */
    public void setTaskStarterName(String taskStarterName) {
        this.taskStarterName = taskStarterName;
    }

    /**
     * 任务发起时间
     * 
     * @return the taskStarterDate
     */

    public Date getTaskStarterDate() {
        return this.taskStarterDate;
    }

    /**
     * 任务发起时间
     * 
     * @param taskStarterDate
     *            任务发起时间
     */
    public void setTaskStarterDate(Date taskStarterDate) {
        this.taskStarterDate = taskStarterDate;
    }

    /**
     * 任务状态
     * 
     * @return the status
     */
    @Column(length = 12)
    public String getStatus() {
        return this.status;
    }

    /**
     * 任务状态
     * 
     * @param status
     *            任务状态
     */
    public void setStatus(String status) {
        this.status = status;
    }

    /**
     * 任务分类：正常、退回、上报
     * 
     * @return the taskType
     */
    @Column(length = 12)
    public String getTaskType() {
        return this.taskType;
    }

    /**
     * 任务分类：正常、退回、上报
     * 
     * @param taskType
     *            任务分类：正常、退回、上报
     */
    public void setTaskType(String taskType) {
        this.taskType = taskType;
    }

    /**
     * 任务申请机构二级
     * 
     * @return the applyDeptSec
     */
    @Column(length = 12)
    public String getApplyDeptSec() {
        return this.applyDeptSec;
    }

    /**
     * 任务申请机构二级
     * 
     * @param applyDeptSec
     *            任务申请机构二级
     */
    public void setApplyDeptSec(String applyDeptSec) {
        this.applyDeptSec = applyDeptSec;
    }

    /**
     * 任务申请机构二级名称
     * 
     * @return the applyDeptSecName
     */
    @Column(length = 50)
    public String getApplyDeptSecName() {
        return this.applyDeptSecName;
    }

    /**
     * 任务申请机构二级名称
     * 
     * @param applyDeptSecName
     *            任务申请机构二级名称
     */
    public void setApplyDeptSecName(String applyDeptSecName) {
        this.applyDeptSecName = applyDeptSecName;
    }

    /**
     * 任务申请机构三级
     * 
     * @return the applyDeptThr
     */
    @Column(length = 12)
    public String getApplyDeptThr() {
        return this.applyDeptThr;
    }

    /**
     * 任务申请机构三级
     * 
     * @param applyDeptThr
     *            任务申请机构三级
     */
    public void setApplyDeptThr(String applyDeptThr) {
        this.applyDeptThr = applyDeptThr;
    }

    /**
     * 任务申请机构三级名称
     * 
     * @return the applyDeptThrName
     */
    @Column(length = 50)
    public String getApplyDeptThrName() {
        return this.applyDeptThrName;
    }

    /**
     * 任务申请机构三级名称
     * 
     * @param applyDeptThrName
     *            任务申请机构三级名称
     */
    public void setApplyDeptThrName(String applyDeptThrName) {
        this.applyDeptThrName = applyDeptThrName;
    }

    /**
     * 任务申请机构
     * 
     * @return the applyDept
     */
    @Column(length = 12)
    public String getApplyDept() {
        return this.applyDept;
    }

    /**
     * 任务申请机构
     * 
     * @param applyDept
     *            任务申请机构
     */
    public void setApplyDept(String applyDept) {
        this.applyDept = applyDept;
    }

    /**
     * 任务申请机构名称
     * 
     * @return the applyDeptName
     */
    @Column(length = 50)
    public String getApplyDeptName() {
        return this.applyDeptName;
    }

    /**
     * 任务申请机构名称
     * 
     * @param applyDeptName
     *            任务申请机构名称
     */
    public void setApplyDeptName(String applyDeptName) {
        this.applyDeptName = applyDeptName;
    }

    /**
     * 风勘报告归属机构二级
     * 
     * @return the reportDeptSec
     */
    @Column(length = 12)
    public String getReportDeptSec() {
        return this.reportDeptSec;
    }

    /**
     * 风勘报告归属机构二级
     * 
     * @param reportDeptSec
     *            风勘报告归属机构二级
     */
    public void setReportDeptSec(String reportDeptSec) {
        this.reportDeptSec = reportDeptSec;
    }

    /**
     * 风勘报告归属机构名称二级
     * 
     * @return the reportDeptNameSec
     */
    @Column(length = 50)
    public String getReportDeptNameSec() {
        return this.reportDeptNameSec;
    }

    /**
     * 风勘报告归属机构名称二级
     * 
     * @param reportDeptNameSec
     *            风勘报告归属机构名称二级
     */
    public void setReportDeptNameSec(String reportDeptNameSec) {
        this.reportDeptNameSec = reportDeptNameSec;
    }

    /**
     * 风勘报告归属机构三级
     * 
     * @return the reportDeptThr
     */
    @Column(length = 12)
    public String getReportDeptThr() {
        return this.reportDeptThr;
    }

    /**
     * 风勘报告归属机构三级
     * 
     * @param reportDeptThr
     *            风勘报告归属机构三级
     */
    public void setReportDeptThr(String reportDeptThr) {
        this.reportDeptThr = reportDeptThr;
    }

    /**
     * 风勘报告归属机构名称三级
     * 
     * @return the reportDeptNameThr
     */
    @Column(length = 50)
    public String getReportDeptNameThr() {
        return this.reportDeptNameThr;
    }

    /**
     * 风勘报告归属机构名称三级
     * 
     * @param reportDeptNameThr
     *            风勘报告归属机构名称三级
     */
    public void setReportDeptNameThr(String reportDeptNameThr) {
        this.reportDeptNameThr = reportDeptNameThr;
    }

    /**
     * 风勘报告归属机构
     * 
     * @return the reportDept
     */
    @Column(length = 12)
    public String getReportDept() {
        return this.reportDept;
    }

    /**
     * 风勘报告归属机构
     * 
     * @param reportDept
     *            风勘报告归属机构
     */
    public void setReportDept(String reportDept) {
        this.reportDept = reportDept;
    }

    /**
     * 风勘报告归属机构名称
     * 
     * @return the reportDeptName
     */
    @Column(length = 50)
    public String getReportDeptName() {
        return this.reportDeptName;
    }

    /**
     * 风勘报告归属机构名称
     * 
     * @param reportDeptName
     *            风勘报告归属机构名称
     */
    public void setReportDeptName(String reportDeptName) {
        this.reportDeptName = reportDeptName;
    }

    /**
     * 审核人代码
     * 
     * @return the approceOperCode
     */
    @Column(length = 50)
    public String getApproceOperCode() {
        return this.approceOperCode;
    }

    /**
     * 审核人代码
     * 
     * @param approceOperCode
     *            审核人代码
     */
    public void setApproceOperCode(String approceOperCode) {
        this.approceOperCode = approceOperCode;
    }

    /**
     * 审核人
     * 
     * @return the approceOper
     */
    @Column(length = 120)
    public String getApproceOper() {
        return this.approceOper;
    }

    /**
     * 审核人
     * 
     * @param approceOper
     *            审核人
     */
    public void setApproceOper(String approceOper) {
        this.approceOper = approceOper;
    }

    /**
     * 审核结果
     * 
     * @return the approceOpn
     */
    @Column(length = 12)
    public String getApproceOpn() {
        return this.approceOpn;
    }

    /**
     * 审核结果
     * 
     * @param approceOpn
     *            审核结果
     */
    public void setApproceOpn(String approceOpn) {
        this.approceOpn = approceOpn;
    }

    /**
     * 审核时间
     * 
     * @return the approceTime
     */

    public Date getApproceTime() {
        return this.approceTime;
    }

    /**
     * 审核时间
     * 
     * @param approceTime
     *            审核时间
     */
    public void setApproceTime(Date approceTime) {
        this.approceTime = approceTime;
    }

    /**
     * 审核意见
     * 
     * @return the approceRmk
     */
    @Column(length = 3999)
    public String getApproceRmk() {
        return this.approceRmk;
    }

    /**
     * 审核意见
     * 
     * @param approceRmk
     *            审核意见
     */
    public void setApproceRmk(String approceRmk) {
        this.approceRmk = approceRmk;
    }

    /**
     * 查勘报告质量评估代码
     * 
     * @return the qualityAssessCode
     */
    @Column(length = 12)
    public String getQualityAssessCode() {
        return this.qualityAssessCode;
    }

    /**
     * 查勘报告质量评估代码
     * 
     * @param qualityAssessCode
     *            查勘报告质量评估代码
     */
    public void setQualityAssessCode(String qualityAssessCode) {
        this.qualityAssessCode = qualityAssessCode;
    }

    /**
     * 查勘报告质量评估
     * 
     * @return the qualityAssess
     */
    @Column(length = 500)
    public String getQualityAssess() {
        return this.qualityAssess;
    }

    /**
     * 查勘报告质量评估
     * 
     * @param qualityAssess
     *            查勘报告质量评估
     */
    public void setQualityAssess(String qualityAssess) {
        this.qualityAssess = qualityAssess;
    }

    /**
     * 查勘报告时效性代码
     * 
     * @return the reportTimeCode
     */
    @Column(length = 12)
    public String getReportTimeCode() {
        return this.reportTimeCode;
    }

    /**
     * 查勘报告时效性代码
     * 
     * @param reportTimeCode
     *            查勘报告时效性代码
     */
    public void setReportTimeCode(String reportTimeCode) {
        this.reportTimeCode = reportTimeCode;
    }

    /**
     * 查勘报告时效性
     * 
     * @return the reportTime
     */
    @Column(length = 500)
    public String getReportTime() {
        return this.reportTime;
    }

    /**
     * 查勘报告时效性
     * 
     * @param reportTime
     *            查勘报告时效性
     */
    public void setReportTime(String reportTime) {
        this.reportTime = reportTime;
    }

    /**
     * 产品
     * 
     * @return the product
     */
    @Column(length = 255)
    public String getProduct() {
        return this.product;
    }

    /**
     * 产品
     * 
     * @param product
     *            产品
     */
    public void setProduct(String product) {
        this.product = product;
    }

    /**
     * 可售产品代码
     * 
     * @return the productCode
     */
    @Column(length = 50)
    public String getProductCode() {
        return this.productCode;
    }

    /**
     * 可售产品代码
     * 
     * @param productCode
     *            可售产品代码
     */
    public void setProductCode(String productCode) {
        this.productCode = productCode;
    }

    /**
     * 可售产品
     * 
     * @return the productName
     */
    @Column(length = 120)
    public String getProductName() {
        return this.productName;
    }

    /**
     * 可售产品
     * 
     * @param productName
     *            可售产品
     */
    public void setProductName(String productName) {
        this.productName = productName;
    }

    /**
     * 保险金额
     * 
     * @return the amount
     */
    @Column(length = 14)
    public BigDecimal getAmount() {
        return this.amount;
    }

    /**
     * 保险金额
     * 
     * @param amount
     *            保险金额
     */
    public void setAmount(BigDecimal amount) {
        this.amount = amount;
    }

    /**
     * 风险查勘员
     * 
     * @return the surveyer
     */
    @Column(length = 120)
    public String getSurveyer() {
        return this.surveyer;
    }

    /**
     * 风险查勘员
     * 
     * @param surveyer
     *            风险查勘员
     */
    public void setSurveyer(String surveyer) {
        this.surveyer = surveyer;
    }

    /**
     * 风险查勘日期
     * 
     * @return the surveyerDate
     */

    public Date getSurveyerDate() {
        return this.surveyerDate;
    }

    /**
     * 风险查勘日期
     * 
     * @param surveyerDate
     *            风险查勘日期
     */
    public void setSurveyerDate(Date surveyerDate) {
        this.surveyerDate = surveyerDate;
    }

    /**
     * 风险查勘类型
     * 
     * @return the surveyerType
     */
    @Column(length = 255)
    public String getSurveyerType() {
        return this.surveyerType;
    }

    /**
     * 风险查勘类型
     * 
     * @param surveyerType
     *            风险查勘类型
     */
    public void setSurveyerType(String surveyerType) {
        this.surveyerType = surveyerType;
    }

    /**
     * 风险查勘部门
     * 
     * @return the surveyerDivision
     */
    @Column(length = 120)
    public String getSurveyerDivision() {
        return this.surveyerDivision;
    }

    /**
     * 风险查勘部门
     * 
     * @param surveyerDivision
     *            风险查勘部门
     */
    public void setSurveyerDivision(String surveyerDivision) {
        this.surveyerDivision = surveyerDivision;
    }

    /**
     * 风险查勘部门代码
     * 
     * @return the surveyerDivisionCode
     */
    @Column(length = 50)
    public String getSurveyerDivisionCode() {
        return this.surveyerDivisionCode;
    }

    /**
     * 风险查勘部门代码
     * 
     * @param surveyerDivisionCode
     *            风险查勘部门代码
     */
    public void setSurveyerDivisionCode(String surveyerDivisionCode) {
        this.surveyerDivisionCode = surveyerDivisionCode;
    }

    /**
     * 报告制作人
     * 
     * @return the reportProducer
     */
    @Column(length = 120)
    public String getReportProducer() {
        return this.reportProducer;
    }

    /**
     * 报告制作人
     * 
     * @param reportProducer
     *            报告制作人
     */
    public void setReportProducer(String reportProducer) {
        this.reportProducer = reportProducer;
    }

    /**
     * 报告制作日期
     * 
     * @return the reportProduceDate
     */

    public Date getReportProduceDate() {
        return this.reportProduceDate;
    }

    /**
     * 报告制作日期
     * 
     * @param reportProduceDate
     *            报告制作日期
     */
    public void setReportProduceDate(Date reportProduceDate) {
        this.reportProduceDate = reportProduceDate;
    }

    /**
     * 车牌号
     * 
     * @return the plateNo
     */
    @Column(length = 12)
    public String getPlateNo() {
        return this.plateNo;
    }

    /**
     * 车牌号
     * 
     * @param plateNo
     *            车牌号
     */
    public void setPlateNo(String plateNo) {
        this.plateNo = plateNo;
    }

    /**
     * 风勘报告摘要
     * 
     * @return the reportSummary
     */
    @Column(length = 3999)
    public String getReportSummary() {
        return this.reportSummary;
    }

    /**
     * 风勘报告摘要
     * 
     * @param reportSummary
     *            风勘报告摘要
     */
    public void setReportSummary(String reportSummary) {
        this.reportSummary = reportSummary;
    }

    /**
     * 风勘结果描述
     * 
     * @return the reportDescribe
     */
    @Column(length = 3999)
    public String getReportDescribe() {
        return this.reportDescribe;
    }

    /**
     * 风勘结果描述
     * 
     * @param reportDescribe
     *            风勘结果描述
     */
    public void setReportDescribe(String reportDescribe) {
        this.reportDescribe = reportDescribe;
    }

    /**
     * 是否委托第三方
     * 
     * @return the entrustFlag
     */
    @Column(length = 12)
    public String getEntrustFlag() {
        return this.entrustFlag;
    }

    /**
     * 是否委托第三方
     * 
     * @param entrustFlag
     *            是否委托第三方
     */
    public void setEntrustFlag(String entrustFlag) {
        this.entrustFlag = entrustFlag;
    }

    /**
     * 第三方代码
     * 
     * @return the thirdPartyCode
     */
    @Column(length = 50)
    public String getThirdPartyCode() {
        return this.thirdPartyCode;
    }

    /**
     * 第三方代码
     * 
     * @param thirdPartyCode
     *            第三方代码
     */
    public void setThirdPartyCode(String thirdPartyCode) {
        this.thirdPartyCode = thirdPartyCode;
    }

    /**
     * 第三方名称
     * 
     * @return the thirdPartyName
     */
    @Column(length = 120)
    public String getThirdPartyName() {
        return this.thirdPartyName;
    }

    /**
     * 第三方名称
     * 
     * @param thirdPartyName
     *            第三方名称
     */
    public void setThirdPartyName(String thirdPartyName) {
        this.thirdPartyName = thirdPartyName;
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
    
    /**
     * 最新标识
     * 
     * @return the newFlag
     */
    @Column(length = 20)
    public String getNewFlag() {
        return this.newFlag;
    }

    /**
     * 最新标识
     * 
     * @param newFlag
     *            最新标识
     */
    public void setNewFlag(String newFlag) {
        this.newFlag = newFlag;
    }

    
    /**
     * 修改次数
     * 
     * @return the surveyTimes
     */
    public BigDecimal getSurveyTimes() {
        return surveyTimes;
    }

    /**
     * 修改次数
     * 
     * @param surveyTimes 修改次数
     */
    public void setSurveyTimes(BigDecimal surveyTimes) {
        this.surveyTimes = surveyTimes;
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