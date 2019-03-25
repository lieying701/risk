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
 * 安装试车风险
 */
@Entity
@Table(name = "survey_install")
public class SurveyInstallEO extends AbstractBaseEntity {

    /**
     * serialVersionUID
     */
    private static final long serialVersionUID = 2886707729203112477L;
    /** 主键 */
    private String pkId;
    /** 外键 */
    private String rptId;
    /** 序号 */
    private BigDecimal num;
    /** 工程造价占整体工程造价 */
    private BigDecimal buildAllConCostRate;
    /** 工程造价占计划投保金额 */
    private BigDecimal buildCoverConCostRate;
    /** 主要原料 */
    private String mainMaterial;
    /** 主要产品 */
    private String mainProduct;
    /** 产量 */
    private String yield;
    /** 突然停电造成的损失 */
    private String suddenPowerCutLoss;
    /** 供电可靠性 */
    private String powerSupplyReliability;
    /** 有无自备发电机 */
    private String haveGeneratorsFlag;
    /** 5年以上同业经验比例 */
    private BigDecimal aboveFiveSameTradeRate;
    /** 2至5年同业经验比例 */
    private BigDecimal twoFiveSameTradeRate;
    /** 2年以下同业经验比例 */
    private BigDecimal belowTwoSameTradeRate;
    /** 人员同类项目经验 */
    private String sameProjectExperience;
    /** 试车起期 */
    private Date testStartTime;
    /** 保证起期 */
    private Date guaranteeStartTime;
    /** 试车止期 */
    private Date testEndTime;
    /** 保证止期 */
    private Date guaranteeEndTime;
    /** 安装试车风险备注 */
    private String installRmk;
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
     * 序号
     * 
     * @return the num
     */

    public BigDecimal getNum() {
        return this.num;
    }

    /**
     * 序号
     * 
     * @param num
     *            序号
     */
    public void setNum(BigDecimal num) {
        this.num = num;
    }

    /**
     * 工程造价占整体工程造价
     * 
     * @return the buildAllConCostRate
     */
    @Column(length = 18)
    public BigDecimal getBuildAllConCostRate() {
        return this.buildAllConCostRate;
    }

    /**
     * 工程造价占整体工程造价
     * 
     * @param buildAllConCostRate
     *            工程造价占整体工程造价
     */
    public void setBuildAllConCostRate(BigDecimal buildAllConCostRate) {
        this.buildAllConCostRate = buildAllConCostRate;
    }

    /**
     * 工程造价占计划投保金额
     * 
     * @return the buildCoverConCostRate
     */
    @Column(length = 18)
    public BigDecimal getBuildCoverConCostRate() {
        return this.buildCoverConCostRate;
    }

    /**
     * 工程造价占计划投保金额
     * 
     * @param buildCoverConCostRate
     *            工程造价占计划投保金额
     */
    public void setBuildCoverConCostRate(BigDecimal buildCoverConCostRate) {
        this.buildCoverConCostRate = buildCoverConCostRate;
    }

    /**
     * 主要原料
     * 
     * @return the mainMaterial
     */
    @Column(length = 255)
    public String getMainMaterial() {
        return this.mainMaterial;
    }

    /**
     * 主要原料
     * 
     * @param mainMaterial
     *            主要原料
     */
    public void setMainMaterial(String mainMaterial) {
        this.mainMaterial = mainMaterial;
    }

    /**
     * 主要产品
     * 
     * @return the mainProduct
     */
    @Column(length = 255)
    public String getMainProduct() {
        return this.mainProduct;
    }

    /**
     * 主要产品
     * 
     * @param mainProduct
     *            主要产品
     */
    public void setMainProduct(String mainProduct) {
        this.mainProduct = mainProduct;
    }

    /**
     * 产量
     * 
     * @return the yield
     */
    @Column(length = 255)
    public String getYield() {
        return this.yield;
    }

    /**
     * 产量
     * 
     * @param yield
     *            产量
     */
    public void setYield(String yield) {
        this.yield = yield;
    }

    /**
     * 突然停电造成的损失
     * 
     * @return the suddenPowerCutLoss
     */
    @Column(length = 12)
    public String getSuddenPowerCutLoss() {
        return this.suddenPowerCutLoss;
    }

    /**
     * 突然停电造成的损失
     * 
     * @param suddenPowerCutLoss
     *            突然停电造成的损失
     */
    public void setSuddenPowerCutLoss(String suddenPowerCutLoss) {
        this.suddenPowerCutLoss = suddenPowerCutLoss;
    }

    /**
     * 供电可靠性
     * 
     * @return the powerSupplyReliability
     */
    @Column(length = 12)
    public String getPowerSupplyReliability() {
        return this.powerSupplyReliability;
    }

    /**
     * 供电可靠性
     * 
     * @param powerSupplyReliability
     *            供电可靠性
     */
    public void setPowerSupplyReliability(String powerSupplyReliability) {
        this.powerSupplyReliability = powerSupplyReliability;
    }

    /**
     * 有无自备发电机
     * 
     * @return the haveGeneratorsFlag
     */
    @Column(length = 12)
    public String getHaveGeneratorsFlag() {
        return this.haveGeneratorsFlag;
    }

    /**
     * 有无自备发电机
     * 
     * @param haveGeneratorsFlag
     *            有无自备发电机
     */
    public void setHaveGeneratorsFlag(String haveGeneratorsFlag) {
        this.haveGeneratorsFlag = haveGeneratorsFlag;
    }

    /**
     * 5年以上同业经验比例
     * 
     * @return the aboveFiveSameTradeRate
     */

    public BigDecimal getAboveFiveSameTradeRate() {
        return this.aboveFiveSameTradeRate;
    }

    /**
     * 5年以上同业经验比例
     * 
     * @param aboveFiveSameTradeRate
     *            5年以上同业经验比例
     */
    public void setAboveFiveSameTradeRate(BigDecimal aboveFiveSameTradeRate) {
        this.aboveFiveSameTradeRate = aboveFiveSameTradeRate;
    }

    /**
     * 2至5年同业经验比例
     * 
     * @return the twoFiveSameTradeRate
     */

    public BigDecimal getTwoFiveSameTradeRate() {
        return this.twoFiveSameTradeRate;
    }

    /**
     * 2至5年同业经验比例
     * 
     * @param twoFiveSameTradeRate
     *            2至5年同业经验比例
     */
    public void setTwoFiveSameTradeRate(BigDecimal twoFiveSameTradeRate) {
        this.twoFiveSameTradeRate = twoFiveSameTradeRate;
    }

    /**
     * 2年以下同业经验比例
     * 
     * @return the belowTwoSameTradeRate
     */

    public BigDecimal getBelowTwoSameTradeRate() {
        return this.belowTwoSameTradeRate;
    }

    /**
     * 2年以下同业经验比例
     * 
     * @param belowTwoSameTradeRate
     *            2年以下同业经验比例
     */
    public void setBelowTwoSameTradeRate(BigDecimal belowTwoSameTradeRate) {
        this.belowTwoSameTradeRate = belowTwoSameTradeRate;
    }

    /**
     * 人员同类项目经验
     * 
     * @return the sameProjectExperience
     */
    @Column(length = 500)
    public String getSameProjectExperience() {
        return this.sameProjectExperience;
    }

    /**
     * 人员同类项目经验
     * 
     * @param sameProjectExperience
     *            人员同类项目经验
     */
    public void setSameProjectExperience(String sameProjectExperience) {
        this.sameProjectExperience = sameProjectExperience;
    }

    /**
     * 试车起期
     * 
     * @return the testStartTime
     */

    public Date getTestStartTime() {
        return this.testStartTime;
    }

    /**
     * 试车起期
     * 
     * @param testStartTime
     *            试车起期
     */
    public void setTestStartTime(Date testStartTime) {
        this.testStartTime = testStartTime;
    }

    /**
     * 保证起期
     * 
     * @return the guaranteeStartTime
     */

    public Date getGuaranteeStartTime() {
        return this.guaranteeStartTime;
    }

    /**
     * 保证起期
     * 
     * @param guaranteeStartTime
     *            保证起期
     */
    public void setGuaranteeStartTime(Date guaranteeStartTime) {
        this.guaranteeStartTime = guaranteeStartTime;
    }

    /**
     * 试车止期
     * 
     * @return the testEndTime
     */

    public Date getTestEndTime() {
        return this.testEndTime;
    }

    /**
     * 试车止期
     * 
     * @param testEndTime
     *            试车止期
     */
    public void setTestEndTime(Date testEndTime) {
        this.testEndTime = testEndTime;
    }

    /**
     * 保证止期
     * 
     * @return the guaranteeEndTime
     */

    public Date getGuaranteeEndTime() {
        return this.guaranteeEndTime;
    }

    /**
     * 保证止期
     * 
     * @param guaranteeEndTime
     *            保证止期
     */
    public void setGuaranteeEndTime(Date guaranteeEndTime) {
        this.guaranteeEndTime = guaranteeEndTime;
    }

    /**
     * 安装试车风险备注
     * 
     * @return the installRmk
     */
    @Column(length = 500)
    public String getInstallRmk() {
        return this.installRmk;
    }

    /**
     * 安装试车风险备注
     * 
     * @param installRmk
     *            安装试车风险备注
     */
    public void setInstallRmk(String installRmk) {
        this.installRmk = installRmk;
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