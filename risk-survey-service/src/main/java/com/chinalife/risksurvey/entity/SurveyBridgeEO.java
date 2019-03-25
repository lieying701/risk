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
 * 桥梁施工风险
 */
@Entity
@Table(name = "survey_bridge")
public class SurveyBridgeEO extends AbstractBaseEntity {

    /**
     * serialVersionUID
     */
    private static final long serialVersionUID = -7439482699456587891L;
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
    /** 桥梁工程名称 */
    private String bridgeName;
    /** 桥梁桩号起号 */
    private BigDecimal bridgeStartNum;
    /** 桥梁桩号止号 */
    private BigDecimal bridgeEndNum;
    /** 桥梁类型代码 */
    private String bridgeTypeCode;
    /** 桥梁类型 */
    private String bridgeType;
    /** 其他桥梁类型说明 */
    private String elseBridgeTypeRmk;
    /** 桥梁材质代码 */
    private String bridgeMaterialCode;
    /** 桥梁材质 */
    private String bridgeMaterial;
    /** 其他桥梁材质说明 */
    private String elseBridgeMaterialRmk;
    /** 工程造价 */
    private BigDecimal buildConstructCost;
    /** 桥梁长度 */
    private BigDecimal bridgeLen;
    /** 桥梁最大跨度 */
    private BigDecimal bigBridgeSpan;
    /** 是否跨越河流 */
    private String crossRiverFlag;
    /** 跨越河流的宽度 */
    private BigDecimal crossRiverWidth;
    /** 江河是否通航 */
    private String navigationFlag;
    /** 设计单位 */
    private String designCo;
    /** 设计资质代码 */
    private String designAptitudeCode;
    /** 设计资质 */
    private String designAptitude;
    /** 监理单位 */
    private String superviseCo;
    /** 监理资质代码 */
    private String supAptitudeCode;
    /** 监理资质 */
    private String supAptitude;
    /** 施工单位 */
    private String constructCo;
    /** 施工单位资质代码 */
    private String constructAptitudeCode;
    /** 施工单位资质 */
    private String constructAptitude;
    /** 该河汛期起始月 */
    private BigDecimal floodPeriodStrat;
    /** 该河汛期终止月 */
    private BigDecimal floodPeriodEnd;
    /** 涉水工期安排 */
    private String wadingPeriodArrange;
    /** 桥址地形代码 */
    private String bridgeAddrTypeCode;
    /** 桥址地形 */
    private String bridgeAddrType;
    /** 其他桥址地形说明 */
    private String elseBridgeAddrRmk;
    /** 桥桩基直径 */
    private BigDecimal pileDiameter;
    /** 桩长 */
    private BigDecimal pileLen;
    /** 施工方法代码 */
    private String pileConMethodCode;
    /** 施工方法 */
    private String pileConMethod;
    /** 其他桥墩、台、柱施工方法 */
    private String elsePileConMethod;
    /** 桥梁施工方法代码 */
    private String bridgeConMethodCode;
    /** 桥梁施工方法 */
    private String bridgeConMethod;
    /** 其他桥梁施工方法 */
    private String elseBridgeConMethod;
    /** 桥梁施工备注 */
    private String bridgeConRmk;
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
     * 桥梁工程名称
     * 
     * @return the bridgeName
     */
    @Column(length = 500)
    public String getBridgeName() {
        return this.bridgeName;
    }

    /**
     * 桥梁工程名称
     * 
     * @param bridgeName
     *            桥梁工程名称
     */
    public void setBridgeName(String bridgeName) {
        this.bridgeName = bridgeName;
    }

    /**
     * 桥梁桩号起号
     * 
     * @return the bridgeStartNum
     */

    public BigDecimal getBridgeStartNum() {
        return this.bridgeStartNum;
    }

    /**
     * 桥梁桩号起号
     * 
     * @param bridgeStartNum
     *            桥梁桩号起号
     */
    public void setBridgeStartNum(BigDecimal bridgeStartNum) {
        this.bridgeStartNum = bridgeStartNum;
    }

    /**
     * 桥梁桩号止号
     * 
     * @return the bridgeEndNum
     */

    public BigDecimal getBridgeEndNum() {
        return this.bridgeEndNum;
    }

    /**
     * 桥梁桩号止号
     * 
     * @param bridgeEndNum
     *            桥梁桩号止号
     */
    public void setBridgeEndNum(BigDecimal bridgeEndNum) {
        this.bridgeEndNum = bridgeEndNum;
    }

    /**
     * 桥梁类型代码
     * 
     * @return the bridgeTypeCode
     */
    @Column(length = 50)
    public String getBridgeTypeCode() {
        return this.bridgeTypeCode;
    }

    /**
     * 桥梁类型代码
     * 
     * @param bridgeTypeCode
     *            桥梁类型代码
     */
    public void setBridgeTypeCode(String bridgeTypeCode) {
        this.bridgeTypeCode = bridgeTypeCode;
    }

    /**
     * 桥梁类型
     * 
     * @return the bridgeType
     */
    @Column(length = 120)
    public String getBridgeType() {
        return this.bridgeType;
    }

    /**
     * 桥梁类型
     * 
     * @param bridgeType
     *            桥梁类型
     */
    public void setBridgeType(String bridgeType) {
        this.bridgeType = bridgeType;
    }

    /**
     * 其他桥梁类型说明
     * 
     * @return the elseBridgeTypeRmk
     */
    @Column(length = 500)
    public String getElseBridgeTypeRmk() {
        return this.elseBridgeTypeRmk;
    }

    /**
     * 其他桥梁类型说明
     * 
     * @param elseBridgeTypeRmk
     *            其他桥梁类型说明
     */
    public void setElseBridgeTypeRmk(String elseBridgeTypeRmk) {
        this.elseBridgeTypeRmk = elseBridgeTypeRmk;
    }

    /**
     * 桥梁材质代码
     * 
     * @return the bridgeMaterialCode
     */
    @Column(length = 50)
    public String getBridgeMaterialCode() {
        return this.bridgeMaterialCode;
    }

    /**
     * 桥梁材质代码
     * 
     * @param bridgeMaterialCode
     *            桥梁材质代码
     */
    public void setBridgeMaterialCode(String bridgeMaterialCode) {
        this.bridgeMaterialCode = bridgeMaterialCode;
    }

    /**
     * 桥梁材质
     * 
     * @return the bridgeMaterial
     */
    @Column(length = 120)
    public String getBridgeMaterial() {
        return this.bridgeMaterial;
    }

    /**
     * 桥梁材质
     * 
     * @param bridgeMaterial
     *            桥梁材质
     */
    public void setBridgeMaterial(String bridgeMaterial) {
        this.bridgeMaterial = bridgeMaterial;
    }

    /**
     * 其他桥梁材质说明
     * 
     * @return the elseBridgeMaterialRmk
     */
    @Column(length = 500)
    public String getElseBridgeMaterialRmk() {
        return this.elseBridgeMaterialRmk;
    }

    /**
     * 其他桥梁材质说明
     * 
     * @param elseBridgeMaterialRmk
     *            其他桥梁材质说明
     */
    public void setElseBridgeMaterialRmk(String elseBridgeMaterialRmk) {
        this.elseBridgeMaterialRmk = elseBridgeMaterialRmk;
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
     * 桥梁长度
     * 
     * @return the bridgeLen
     */
    @Column(length = 14)
    public BigDecimal getBridgeLen() {
        return this.bridgeLen;
    }

    /**
     * 桥梁长度
     * 
     * @param bridgeLen
     *            桥梁长度
     */
    public void setBridgeLen(BigDecimal bridgeLen) {
        this.bridgeLen = bridgeLen;
    }

    /**
     * 桥梁最大跨度
     * 
     * @return the bigBridgeSpan
     */
    @Column(length = 14)
    public BigDecimal getBigBridgeSpan() {
        return this.bigBridgeSpan;
    }

    /**
     * 桥梁最大跨度
     * 
     * @param bigBridgeSpan
     *            桥梁最大跨度
     */
    public void setBigBridgeSpan(BigDecimal bigBridgeSpan) {
        this.bigBridgeSpan = bigBridgeSpan;
    }

    /**
     * 是否跨越河流
     * 
     * @return the crossRiverFlag
     */
    @Column(length = 12)
    public String getCrossRiverFlag() {
        return this.crossRiverFlag;
    }

    /**
     * 是否跨越河流
     * 
     * @param crossRiverFlag
     *            是否跨越河流
     */
    public void setCrossRiverFlag(String crossRiverFlag) {
        this.crossRiverFlag = crossRiverFlag;
    }

    /**
     * 跨越河流的宽度
     * 
     * @return the crossRiverWidth
     */
    @Column(length = 14)
    public BigDecimal getCrossRiverWidth() {
        return this.crossRiverWidth;
    }

    /**
     * 跨越河流的宽度
     * 
     * @param crossRiverWidth
     *            跨越河流的宽度
     */
    public void setCrossRiverWidth(BigDecimal crossRiverWidth) {
        this.crossRiverWidth = crossRiverWidth;
    }

    /**
     * 江河是否通航
     * 
     * @return the navigationFlag
     */
    @Column(length = 12)
    public String getNavigationFlag() {
        return this.navigationFlag;
    }

    /**
     * 江河是否通航
     * 
     * @param navigationFlag
     *            江河是否通航
     */
    public void setNavigationFlag(String navigationFlag) {
        this.navigationFlag = navigationFlag;
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
     * 施工单位
     * 
     * @return the constructCo
     */
    @Column(length = 120)
    public String getConstructCo() {
        return this.constructCo;
    }

    /**
     * 施工单位
     * 
     * @param constructCo
     *            施工单位
     */
    public void setConstructCo(String constructCo) {
        this.constructCo = constructCo;
    }

    /**
     * 施工单位资质代码
     * 
     * @return the constructAptitudeCode
     */
    @Column(length = 12)
    public String getConstructAptitudeCode() {
        return this.constructAptitudeCode;
    }

    /**
     * 施工单位资质代码
     * 
     * @param constructAptitudeCode
     *            施工单位资质代码
     */
    public void setConstructAptitudeCode(String constructAptitudeCode) {
        this.constructAptitudeCode = constructAptitudeCode;
    }

    /**
     * 施工单位资质
     * 
     * @return the constructAptitude
     */
    @Column(length = 120)
    public String getConstructAptitude() {
        return this.constructAptitude;
    }

    /**
     * 施工单位资质
     * 
     * @param constructAptitude
     *            施工单位资质
     */
    public void setConstructAptitude(String constructAptitude) {
        this.constructAptitude = constructAptitude;
    }

    /**
     * 该河汛期起始月
     * 
     * @return the floodPeriodStrat
     */

    public BigDecimal getFloodPeriodStrat() {
        return this.floodPeriodStrat;
    }

    /**
     * 该河汛期起始月
     * 
     * @param floodPeriodStrat
     *            该河汛期起始月
     */
    public void setFloodPeriodStrat(BigDecimal floodPeriodStrat) {
        this.floodPeriodStrat = floodPeriodStrat;
    }

    /**
     * 该河汛期终止月
     * 
     * @return the floodPeriodEnd
     */

    public BigDecimal getFloodPeriodEnd() {
        return this.floodPeriodEnd;
    }

    /**
     * 该河汛期终止月
     * 
     * @param floodPeriodEnd
     *            该河汛期终止月
     */
    public void setFloodPeriodEnd(BigDecimal floodPeriodEnd) {
        this.floodPeriodEnd = floodPeriodEnd;
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
     * 桥址地形代码
     * 
     * @return the bridgeAddrTypeCode
     */
    @Column(length = 12)
    public String getBridgeAddrTypeCode() {
        return this.bridgeAddrTypeCode;
    }

    /**
     * 桥址地形代码
     * 
     * @param bridgeAddrTypeCode
     *            桥址地形代码
     */
    public void setBridgeAddrTypeCode(String bridgeAddrTypeCode) {
        this.bridgeAddrTypeCode = bridgeAddrTypeCode;
    }

    /**
     * 桥址地形
     * 
     * @return the bridgeAddrType
     */
    @Column(length = 255)
    public String getBridgeAddrType() {
        return this.bridgeAddrType;
    }

    /**
     * 桥址地形
     * 
     * @param bridgeAddrType
     *            桥址地形
     */
    public void setBridgeAddrType(String bridgeAddrType) {
        this.bridgeAddrType = bridgeAddrType;
    }

    /**
     * 其他桥址地形说明
     * 
     * @return the elseBridgeAddrRmk
     */
    @Column(length = 255)
    public String getElseBridgeAddrRmk() {
        return this.elseBridgeAddrRmk;
    }

    /**
     * 其他桥址地形说明
     * 
     * @param elseBridgeAddrRmk
     *            其他桥址地形说明
     */
    public void setElseBridgeAddrRmk(String elseBridgeAddrRmk) {
        this.elseBridgeAddrRmk = elseBridgeAddrRmk;
    }

    /**
     * 桥桩基直径
     * 
     * @return the pileDiameter
     */
    @Column(length = 14)
    public BigDecimal getPileDiameter() {
        return this.pileDiameter;
    }

    /**
     * 桥桩基直径
     * 
     * @param pileDiameter
     *            桥桩基直径
     */
    public void setPileDiameter(BigDecimal pileDiameter) {
        this.pileDiameter = pileDiameter;
    }

    /**
     * 桩长
     * 
     * @return the pileLen
     */
    @Column(length = 14)
    public BigDecimal getPileLen() {
        return this.pileLen;
    }

    /**
     * 桩长
     * 
     * @param pileLen
     *            桩长
     */
    public void setPileLen(BigDecimal pileLen) {
        this.pileLen = pileLen;
    }

    /**
     * 施工方法代码
     * 
     * @return the pileConMethodCode
     */
    @Column(length = 12)
    public String getPileConMethodCode() {
        return this.pileConMethodCode;
    }

    /**
     * 施工方法代码
     * 
     * @param pileConMethodCode
     *            施工方法代码
     */
    public void setPileConMethodCode(String pileConMethodCode) {
        this.pileConMethodCode = pileConMethodCode;
    }

    /**
     * 施工方法
     * 
     * @return the pileConMethod
     */
    @Column(length = 255)
    public String getPileConMethod() {
        return this.pileConMethod;
    }

    /**
     * 施工方法
     * 
     * @param pileConMethod
     *            施工方法
     */
    public void setPileConMethod(String pileConMethod) {
        this.pileConMethod = pileConMethod;
    }

    /**
     * 其他桥墩、台、柱施工方法
     * 
     * @return the elsePileConMethod
     */
    @Column(length = 255)
    public String getElsePileConMethod() {
        return this.elsePileConMethod;
    }

    /**
     * 其他桥墩、台、柱施工方法
     * 
     * @param elsePileConMethod
     *            其他桥墩、台、柱施工方法
     */
    public void setElsePileConMethod(String elsePileConMethod) {
        this.elsePileConMethod = elsePileConMethod;
    }

    /**
     * 桥梁施工方法代码
     * 
     * @return the bridgeConMethodCode
     */
    @Column(length = 12)
    public String getBridgeConMethodCode() {
        return this.bridgeConMethodCode;
    }

    /**
     * 桥梁施工方法代码
     * 
     * @param bridgeConMethodCode
     *            桥梁施工方法代码
     */
    public void setBridgeConMethodCode(String bridgeConMethodCode) {
        this.bridgeConMethodCode = bridgeConMethodCode;
    }

    /**
     * 桥梁施工方法
     * 
     * @return the bridgeConMethod
     */
    @Column(length = 255)
    public String getBridgeConMethod() {
        return this.bridgeConMethod;
    }

    /**
     * 桥梁施工方法
     * 
     * @param bridgeConMethod
     *            桥梁施工方法
     */
    public void setBridgeConMethod(String bridgeConMethod) {
        this.bridgeConMethod = bridgeConMethod;
    }

    /**
     * 其他桥梁施工方法
     * 
     * @return the elseBridgeConMethod
     */
    @Column(length = 255)
    public String getElseBridgeConMethod() {
        return this.elseBridgeConMethod;
    }

    /**
     * 其他桥梁施工方法
     * 
     * @param elseBridgeConMethod
     *            其他桥梁施工方法
     */
    public void setElseBridgeConMethod(String elseBridgeConMethod) {
        this.elseBridgeConMethod = elseBridgeConMethod;
    }

    /**
     * 桥梁施工备注
     * 
     * @return the bridgeConRmk
     */
    @Column(length = 500)
    public String getBridgeConRmk() {
        return this.bridgeConRmk;
    }

    /**
     * 桥梁施工备注
     * 
     * @param bridgeConRmk
     *            桥梁施工备注
     */
    public void setBridgeConRmk(String bridgeConRmk) {
        this.bridgeConRmk = bridgeConRmk;
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