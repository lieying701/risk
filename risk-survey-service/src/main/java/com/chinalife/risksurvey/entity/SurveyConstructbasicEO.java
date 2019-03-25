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
 * 工程险基本信息
 */
@Entity
@Table(name = "survey_constructbasic")
public class SurveyConstructbasicEO extends AbstractBaseEntity {

    /**
     * 
     */
    private static final long serialVersionUID = -8748553829783415111L;
    /** 主键 */
    private String pkId;
    /** 外键 */
    private String rptId;
    /** 工程一级类型代码 */
    private String constructTypeFstCode;
    /** 工程一级类型名称 */
    private String constructTypeFstName;
    /** 工程二级类型代码 */
    private String constructTypeSecCode;
    /** 工程二级类型名称 */
    private String constructTypeSecName;
    /** 工程三级类型代码 */
    private String constructTypeCode;
    /** 工程三级类型名称 */
    private String constructTypeName;
    /** 工程项目名称 */
    private String constructName;
    /** 工程地址 */
    private String constructAddress;
    /** 邮编 */
    private BigDecimal post;
    /** 定位1 */
    private String locationFirst;
    /** 定位2 */
    private String locationSec;
    /** 定位3 */
    private String locationThr;
    /** 地震 */
    private String earthquake;
    /** 台暴风 */
    private String typhoon;
    /** 洪水暴雨 */
    private String flood;
    /** 其他自然灾害 */
    private String elseNatureCalamity;
    /** 工程总投资金额 */
    private BigDecimal investAmount;
    /** 投保金额 */
    private BigDecimal coverAmount;
    /** 资金来源 */
    private String fundSource;
    /** 占地面积 */
    private BigDecimal totalArea;
    /** 单位造价 */
    private BigDecimal unitAmount;
    /** 工程起期 */
    private Date startfixDate;
    /** 工程止期 */
    private Date endfixDate;
    /** 是否包含保证期 */
    private String containsPeriodFlag;
    /** 保证期长度 */
    private BigDecimal guaranteePeriod;
    /** 计划保险长度 */
    private BigDecimal planCoverPeriod;
    /** 工程基本信息备注 */
    private String basicRmk;
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
     * 工程一级类型代码
     * 
     * @return the constructTypeFstCode
     */
    @Column(length = 50)
    public String getConstructTypeFstCode() {
        return this.constructTypeFstCode;
    }

    /**
     * 工程一级类型代码
     * 
     * @param constructTypeFstCode
     *            工程一级类型代码
     */
    public void setConstructTypeFstCode(String constructTypeFstCode) {
        this.constructTypeFstCode = constructTypeFstCode;
    }

    /**
     * 工程一级类型名称
     * 
     * @return the constructTypeFstName
     */
    @Column(length = 120)
    public String getConstructTypeFstName() {
        return this.constructTypeFstName;
    }

    /**
     * 工程一级类型名称
     * 
     * @param constructTypeFstName
     *            工程一级类型名称
     */
    public void setConstructTypeFstName(String constructTypeFstName) {
        this.constructTypeFstName = constructTypeFstName;
    }

    /**
     * 工程二级类型代码
     * 
     * @return the constructTypeSecCode
     */
    @Column(length = 50)
    public String getConstructTypeSecCode() {
        return this.constructTypeSecCode;
    }

    /**
     * 工程二级类型代码
     * 
     * @param constructTypeSecCode
     *            工程二级类型代码
     */
    public void setConstructTypeSecCode(String constructTypeSecCode) {
        this.constructTypeSecCode = constructTypeSecCode;
    }

    /**
     * 工程二级类型名称
     * 
     * @return the constructTypeSecName
     */
    @Column(length = 120)
    public String getConstructTypeSecName() {
        return this.constructTypeSecName;
    }

    /**
     * 工程二级类型名称
     * 
     * @param constructTypeSecName
     *            工程二级类型名称
     */
    public void setConstructTypeSecName(String constructTypeSecName) {
        this.constructTypeSecName = constructTypeSecName;
    }

    /**
     * 工程三级类型代码
     * 
     * @return the constructTypeCode
     */
    @Column(length = 50)
    public String getConstructTypeCode() {
        return this.constructTypeCode;
    }

    /**
     * 工程三级类型代码
     * 
     * @param constructTypeCode
     *            工程三级类型代码
     */
    public void setConstructTypeCode(String constructTypeCode) {
        this.constructTypeCode = constructTypeCode;
    }

    /**
     * 工程三级类型名称
     * 
     * @return the constructTypeName
     */
    @Column(length = 120)
    public String getConstructTypeName() {
        return this.constructTypeName;
    }

    /**
     * 工程三级类型名称
     * 
     * @param constructTypeName
     *            工程三级类型名称
     */
    public void setConstructTypeName(String constructTypeName) {
        this.constructTypeName = constructTypeName;
    }

    /**
     * 工程项目名称
     * 
     * @return the constructName
     */
    @Column(length = 255)
    public String getConstructName() {
        return this.constructName;
    }

    /**
     * 工程项目名称
     * 
     * @param constructName
     *            工程项目名称
     */
    public void setConstructName(String constructName) {
        this.constructName = constructName;
    }

    /**
     * 工程地址
     * 
     * @return the constructAddress
     */
    @Column(length = 500)
    public String getConstructAddress() {
        return this.constructAddress;
    }

    /**
     * 工程地址
     * 
     * @param constructAddress
     *            工程地址
     */
    public void setConstructAddress(String constructAddress) {
        this.constructAddress = constructAddress;
    }

    /**
     * 邮编
     * 
     * @return the post
     */

    public BigDecimal getPost() {
        return this.post;
    }

    /**
     * 邮编
     * 
     * @param post
     *            邮编
     */
    public void setPost(BigDecimal post) {
        this.post = post;
    }

    /**
     * 定位1
     * 
     * @return the locationFirst
     */
    @Column(length = 120)
    public String getLocationFirst() {
        return this.locationFirst;
    }

    /**
     * 定位1
     * 
     * @param locationFirst
     *            定位1
     */
    public void setLocationFirst(String locationFirst) {
        this.locationFirst = locationFirst;
    }

    /**
     * 定位2
     * 
     * @return the locationSec
     */
    @Column(length = 120)
    public String getLocationSec() {
        return this.locationSec;
    }

    /**
     * 定位2
     * 
     * @param locationSec
     *            定位2
     */
    public void setLocationSec(String locationSec) {
        this.locationSec = locationSec;
    }

    /**
     * 定位3
     * 
     * @return the locationThr
     */
    @Column(length = 120)
    public String getLocationThr() {
        return this.locationThr;
    }

    /**
     * 定位3
     * 
     * @param locationThr
     *            定位3
     */
    public void setLocationThr(String locationThr) {
        this.locationThr = locationThr;
    }

    /**
     * 地震
     * 
     * @return the earthquake
     */
    @Column(length = 12)
    public String getEarthquake() {
        return this.earthquake;
    }

    /**
     * 地震
     * 
     * @param earthquake
     *            地震
     */
    public void setEarthquake(String earthquake) {
        this.earthquake = earthquake;
    }

    /**
     * 台暴风
     * 
     * @return the typhoon
     */
    @Column(length = 12)
    public String getTyphoon() {
        return this.typhoon;
    }

    /**
     * 台暴风
     * 
     * @param typhoon
     *            台暴风
     */
    public void setTyphoon(String typhoon) {
        this.typhoon = typhoon;
    }

    /**
     * 洪水暴雨
     * 
     * @return the flood
     */
    @Column(length = 12)
    public String getFlood() {
        return this.flood;
    }

    /**
     * 洪水暴雨
     * 
     * @param flood
     *            洪水暴雨
     */
    public void setFlood(String flood) {
        this.flood = flood;
    }

    /**
     * 其他自然灾害
     * 
     * @return the elseNatureCalamity
     */
    @Column(length = 12)
    public String getElseNatureCalamity() {
        return this.elseNatureCalamity;
    }

    /**
     * 其他自然灾害
     * 
     * @param elseNatureCalamity
     *            其他自然灾害
     */
    public void setElseNatureCalamity(String elseNatureCalamity) {
        this.elseNatureCalamity = elseNatureCalamity;
    }

    /**
     * 工程总投资金额
     * 
     * @return the investAmount
     */
    @Column(length = 14)
    public BigDecimal getInvestAmount() {
        return this.investAmount;
    }

    /**
     * 工程总投资金额
     * 
     * @param investAmount
     *            工程总投资金额
     */
    public void setInvestAmount(BigDecimal investAmount) {
        this.investAmount = investAmount;
    }

    /**
     * 投保金额
     * 
     * @return the coverAmount
     */
    @Column(length = 14)
    public BigDecimal getCoverAmount() {
        return this.coverAmount;
    }

    /**
     * 投保金额
     * 
     * @param coverAmount
     *            投保金额
     */
    public void setCoverAmount(BigDecimal coverAmount) {
        this.coverAmount = coverAmount;
    }

    /**
     * 资金来源
     * 
     * @return the fundSource
     */
    @Column(length = 500)
    public String getFundSource() {
        return this.fundSource;
    }

    /**
     * 资金来源
     * 
     * @param fundSource
     *            资金来源
     */
    public void setFundSource(String fundSource) {
        this.fundSource = fundSource;
    }

    /**
     * 占地面积
     * 
     * @return the totalArea
     */
    @Column(length = 14)
    public BigDecimal getTotalArea() {
        return this.totalArea;
    }

    /**
     * 占地面积
     * 
     * @param totalArea
     *            占地面积
     */
    public void setTotalArea(BigDecimal totalArea) {
        this.totalArea = totalArea;
    }

    /**
     * 单位造价
     * 
     * @return the unitAmount
     */
    @Column(length = 14)
    public BigDecimal getUnitAmount() {
        return this.unitAmount;
    }

    /**
     * 单位造价
     * 
     * @param unitAmount
     *            单位造价
     */
    public void setUnitAmount(BigDecimal unitAmount) {
        this.unitAmount = unitAmount;
    }

    /**
     * 工程起期
     * 
     * @return the startfixDate
     */

    public Date getStartfixDate() {
        return this.startfixDate;
    }

    /**
     * 工程起期
     * 
     * @param startfixDate
     *            工程起期
     */
    public void setStartfixDate(Date startfixDate) {
        this.startfixDate = startfixDate;
    }

    /**
     * 工程止期
     * 
     * @return the endfixDate
     */

    public Date getEndfixDate() {
        return this.endfixDate;
    }

    /**
     * 工程止期
     * 
     * @param endfixDate
     *            工程止期
     */
    public void setEndfixDate(Date endfixDate) {
        this.endfixDate = endfixDate;
    }

    /**
     * 是否包含保证期
     * 
     * @return the containsPeriodFlag
     */
    @Column(length = 12)
    public String getContainsPeriodFlag() {
        return this.containsPeriodFlag;
    }

    /**
     * 是否包含保证期
     * 
     * @param containsPeriodFlag
     *            是否包含保证期
     */
    public void setContainsPeriodFlag(String containsPeriodFlag) {
        this.containsPeriodFlag = containsPeriodFlag;
    }

    /**
     * 保证期长度
     * 
     * @return the guaranteePeriod
     */

    public BigDecimal getGuaranteePeriod() {
        return this.guaranteePeriod;
    }

    /**
     * 保证期长度
     * 
     * @param guaranteePeriod
     *            保证期长度
     */
    public void setGuaranteePeriod(BigDecimal guaranteePeriod) {
        this.guaranteePeriod = guaranteePeriod;
    }

    /**
     * 计划保险长度
     * 
     * @return the planCoverPeriod
     */

    public BigDecimal getPlanCoverPeriod() {
        return this.planCoverPeriod;
    }

    /**
     * 计划保险长度
     * 
     * @param planCoverPeriod
     *            计划保险长度
     */
    public void setPlanCoverPeriod(BigDecimal planCoverPeriod) {
        this.planCoverPeriod = planCoverPeriod;
    }

    /**
     * 工程基本信息备注
     * 
     * @return the basicRmk
     */
    @Column(length = 500)
    public String getBasicRmk() {
        return this.basicRmk;
    }

    /**
     * 工程基本信息备注
     * 
     * @param basicRmk
     *            工程基本信息备注
     */
    public void setBasicRmk(String basicRmk) {
        this.basicRmk = basicRmk;
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