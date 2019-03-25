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
 * 管道施工风险
 */
@Entity
@Table(name = "survey_piping")
public class SurveyPipingEO extends AbstractBaseEntity {

    /**
     * serialVersionUID
     */
    private static final long serialVersionUID = 6377871769275718060L;
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
    /** 管道桩号起号 */
    private BigDecimal pipingStartNum;
    /** 管道桩号止号 */
    private BigDecimal pipingEndNum;
    /** 工程造价 */
    private BigDecimal buildConstructCost;
    /** 管道类型代码 */
    private String pipingTypeCode;
    /** 管道类型 */
    private String pipingType;
    /** 其他管道类型 */
    private String elsePipingType;
    /** 管道对接方式代码 */
    private String pipingLinkTypeCode;
    /** 管道对接方式 */
    private String pipingLinkType;
    /** 其他管道对接方式 */
    private String elsePipingLinkType;
    /** 施工方法 */
    private String constructMethod;
    /** 有无爆破作业 */
    private String blastingOperateFlag;
    /** 管道深埋 */
    private BigDecimal pipingBuryDepth;
    /** 是否要穿越河流 */
    private String crossRiverFlag;
    /** 所穿越河流的宽度 */
    private BigDecimal crossRiverWidth;
    /** 穿越河流施工方法 */
    private String crossRiverConMethod;
    /** 该河汛期分布在几月 */
    private BigDecimal floodPeriodMonth;
    /** 涉水工期安排 */
    private String wadingPeriodArrange;
    /** 有无经过特殊地质地段 */
    private String passSpecGeologyArea;
    /** 特殊地质地段类型代码 */
    private String specGeologyTypeCode;
    /** 特殊地质地段类型 */
    private String specGeologyType;
    /** 其他特殊地质地段类型 */
    private String elseSpecGeologyType;
    /** 第三者免受伤害方法 */
    private String protectThirdPartyMethod;
    /** 管道施工风险备注 */
    private String pipingRmk;
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
     * 管道桩号起号
     * 
     * @return the pipingStartNum
     */

    public BigDecimal getPipingStartNum() {
        return this.pipingStartNum;
    }

    /**
     * 管道桩号起号
     * 
     * @param pipingStartNum
     *            管道桩号起号
     */
    public void setPipingStartNum(BigDecimal pipingStartNum) {
        this.pipingStartNum = pipingStartNum;
    }

    /**
     * 管道桩号止号
     * 
     * @return the pipingEndNum
     */

    public BigDecimal getPipingEndNum() {
        return this.pipingEndNum;
    }

    /**
     * 管道桩号止号
     * 
     * @param pipingEndNum
     *            管道桩号止号
     */
    public void setPipingEndNum(BigDecimal pipingEndNum) {
        this.pipingEndNum = pipingEndNum;
    }

    /**
     * 工程造价
     * 
     * @return the buildConstructCost
     */
    @Column(length = 14)
    public BigDecimal getBuildConstructCost() {
        return this.buildConstructCost;
    }

    /**
     * 工程造价
     * 
     * @param buildConstructCost
     *            工程造价
     */
    public void setBuildConstructCost(BigDecimal buildConstructCost) {
        this.buildConstructCost = buildConstructCost;
    }

    /**
     * 管道类型代码
     * 
     * @return the pipingTypeCode
     */
    @Column(length = 12)
    public String getPipingTypeCode() {
        return this.pipingTypeCode;
    }

    /**
     * 管道类型代码
     * 
     * @param pipingTypeCode
     *            管道类型代码
     */
    public void setPipingTypeCode(String pipingTypeCode) {
        this.pipingTypeCode = pipingTypeCode;
    }

    /**
     * 管道类型
     * 
     * @return the pipingType
     */
    @Column(length = 120)
    public String getPipingType() {
        return this.pipingType;
    }

    /**
     * 管道类型
     * 
     * @param pipingType
     *            管道类型
     */
    public void setPipingType(String pipingType) {
        this.pipingType = pipingType;
    }

    /**
     * 其他管道类型
     * 
     * @return the elsePipingType
     */
    @Column(length = 500)
    public String getElsePipingType() {
        return this.elsePipingType;
    }

    /**
     * 其他管道类型
     * 
     * @param elsePipingType
     *            其他管道类型
     */
    public void setElsePipingType(String elsePipingType) {
        this.elsePipingType = elsePipingType;
    }

    /**
     * 管道对接方式代码
     * 
     * @return the pipingLinkTypeCode
     */
    @Column(length = 12)
    public String getPipingLinkTypeCode() {
        return this.pipingLinkTypeCode;
    }

    /**
     * 管道对接方式代码
     * 
     * @param pipingLinkTypeCode
     *            管道对接方式代码
     */
    public void setPipingLinkTypeCode(String pipingLinkTypeCode) {
        this.pipingLinkTypeCode = pipingLinkTypeCode;
    }

    /**
     * 管道对接方式
     * 
     * @return the pipingLinkType
     */
    @Column(length = 120)
    public String getPipingLinkType() {
        return this.pipingLinkType;
    }

    /**
     * 管道对接方式
     * 
     * @param pipingLinkType
     *            管道对接方式
     */
    public void setPipingLinkType(String pipingLinkType) {
        this.pipingLinkType = pipingLinkType;
    }

    /**
     * 其他管道对接方式
     * 
     * @return the elsePipingLinkType
     */
    @Column(length = 500)
    public String getElsePipingLinkType() {
        return this.elsePipingLinkType;
    }

    /**
     * 其他管道对接方式
     * 
     * @param elsePipingLinkType
     *            其他管道对接方式
     */
    public void setElsePipingLinkType(String elsePipingLinkType) {
        this.elsePipingLinkType = elsePipingLinkType;
    }

    /**
     * 施工方法
     * 
     * @return the constructMethod
     */
    @Column(length = 500)
    public String getConstructMethod() {
        return this.constructMethod;
    }

    /**
     * 施工方法
     * 
     * @param constructMethod
     *            施工方法
     */
    public void setConstructMethod(String constructMethod) {
        this.constructMethod = constructMethod;
    }

    /**
     * 有无爆破作业
     * 
     * @return the blastingOperateFlag
     */
    @Column(length = 12)
    public String getBlastingOperateFlag() {
        return this.blastingOperateFlag;
    }

    /**
     * 有无爆破作业
     * 
     * @param blastingOperateFlag
     *            有无爆破作业
     */
    public void setBlastingOperateFlag(String blastingOperateFlag) {
        this.blastingOperateFlag = blastingOperateFlag;
    }

    /**
     * 管道深埋
     * 
     * @return the pipingBuryDepth
     */
    @Column(length = 14)
    public BigDecimal getPipingBuryDepth() {
        return this.pipingBuryDepth;
    }

    /**
     * 管道深埋
     * 
     * @param pipingBuryDepth
     *            管道深埋
     */
    public void setPipingBuryDepth(BigDecimal pipingBuryDepth) {
        this.pipingBuryDepth = pipingBuryDepth;
    }

    /**
     * 是否要穿越河流
     * 
     * @return the crossRiverFlag
     */
    @Column(length = 12)
    public String getCrossRiverFlag() {
        return this.crossRiverFlag;
    }

    /**
     * 是否要穿越河流
     * 
     * @param crossRiverFlag
     *            是否要穿越河流
     */
    public void setCrossRiverFlag(String crossRiverFlag) {
        this.crossRiverFlag = crossRiverFlag;
    }

    /**
     * 所穿越河流的宽度
     * 
     * @return the crossRiverWidth
     */
    @Column(length = 14)
    public BigDecimal getCrossRiverWidth() {
        return this.crossRiverWidth;
    }

    /**
     * 所穿越河流的宽度
     * 
     * @param crossRiverWidth
     *            所穿越河流的宽度
     */
    public void setCrossRiverWidth(BigDecimal crossRiverWidth) {
        this.crossRiverWidth = crossRiverWidth;
    }

    /**
     * 穿越河流施工方法
     * 
     * @return the crossRiverConMethod
     */
    @Column(length = 120)
    public String getCrossRiverConMethod() {
        return this.crossRiverConMethod;
    }

    /**
     * 穿越河流施工方法
     * 
     * @param crossRiverConMethod
     *            穿越河流施工方法
     */
    public void setCrossRiverConMethod(String crossRiverConMethod) {
        this.crossRiverConMethod = crossRiverConMethod;
    }

    /**
     * 该河汛期分布在几月
     * 
     * @return the floodPeriodMonth
     */

    public BigDecimal getFloodPeriodMonth() {
        return this.floodPeriodMonth;
    }

    /**
     * 该河汛期分布在几月
     * 
     * @param floodPeriodMonth
     *            该河汛期分布在几月
     */
    public void setFloodPeriodMonth(BigDecimal floodPeriodMonth) {
        this.floodPeriodMonth = floodPeriodMonth;
    }

    /**
     * 涉水工期安排
     * 
     * @return the wadingPeriodArrange
     */
    @Column(length = 255)
    public String getWadingPeriodArrange() {
        return this.wadingPeriodArrange;
    }

    /**
     * 涉水工期安排
     * 
     * @param wadingPeriodArrange
     *            涉水工期安排
     */
    public void setWadingPeriodArrange(String wadingPeriodArrange) {
        this.wadingPeriodArrange = wadingPeriodArrange;
    }

    /**
     * 有无经过特殊地质地段
     * 
     * @return the passSpecGeologyArea
     */
    @Column(length = 12)
    public String getPassSpecGeologyArea() {
        return this.passSpecGeologyArea;
    }

    /**
     * 有无经过特殊地质地段
     * 
     * @param passSpecGeologyArea
     *            有无经过特殊地质地段
     */
    public void setPassSpecGeologyArea(String passSpecGeologyArea) {
        this.passSpecGeologyArea = passSpecGeologyArea;
    }

    /**
     * 特殊地质地段类型代码
     * 
     * @return the specGeologyTypeCode
     */
    @Column(length = 50)
    public String getSpecGeologyTypeCode() {
        return this.specGeologyTypeCode;
    }

    /**
     * 特殊地质地段类型代码
     * 
     * @param specGeologyTypeCode
     *            特殊地质地段类型代码
     */
    public void setSpecGeologyTypeCode(String specGeologyTypeCode) {
        this.specGeologyTypeCode = specGeologyTypeCode;
    }

    /**
     * 特殊地质地段类型
     * 
     * @return the specGeologyType
     */
    @Column(length = 120)
    public String getSpecGeologyType() {
        return this.specGeologyType;
    }

    /**
     * 特殊地质地段类型
     * 
     * @param specGeologyType
     *            特殊地质地段类型
     */
    public void setSpecGeologyType(String specGeologyType) {
        this.specGeologyType = specGeologyType;
    }

    /**
     * 其他特殊地质地段类型
     * 
     * @return the elseSpecGeologyType
     */
    @Column(length = 500)
    public String getElseSpecGeologyType() {
        return this.elseSpecGeologyType;
    }

    /**
     * 其他特殊地质地段类型
     * 
     * @param elseSpecGeologyType
     *            其他特殊地质地段类型
     */
    public void setElseSpecGeologyType(String elseSpecGeologyType) {
        this.elseSpecGeologyType = elseSpecGeologyType;
    }

    /**
     * 第三者免受伤害方法
     * 
     * @return the protectThirdPartyMethod
     */
    @Column(length = 500)
    public String getProtectThirdPartyMethod() {
        return this.protectThirdPartyMethod;
    }

    /**
     * 第三者免受伤害方法
     * 
     * @param protectThirdPartyMethod
     *            第三者免受伤害方法
     */
    public void setProtectThirdPartyMethod(String protectThirdPartyMethod) {
        this.protectThirdPartyMethod = protectThirdPartyMethod;
    }

    /**
     * 管道施工风险备注
     * 
     * @return the pipingRmk
     */
    @Column(length = 500)
    public String getPipingRmk() {
        return this.pipingRmk;
    }

    /**
     * 管道施工风险备注
     * 
     * @param pipingRmk
     *            管道施工风险备注
     */
    public void setPipingRmk(String pipingRmk) {
        this.pipingRmk = pipingRmk;
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