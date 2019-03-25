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
 * 车站施工风险
 */
@Entity
@Table(name = "survey_station")
public class SurveyStationEO extends AbstractBaseEntity {

    /**
     * serialVersionUID
     */
    private static final long serialVersionUID = 5938770340349307635L;
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
    /** 车站工程地址和名称 */
    private String stationName;
    /** 基坑深度 */
    private BigDecimal basePitDepth;
    /** 基坑面积 */
    private BigDecimal basePitArea;
    /** 地下水水位 */
    private BigDecimal groundWaterLevel;
    /** 工程造价 */
    private BigDecimal buildConstructCost;
    /** 车站施工 */
    private String stationConstructRmk;
    /** 明挖支护结构代码 */
    private String openSupportStructCode;
    /** 明挖支护结构 */
    private String openSupportStruct;
    /** 明挖车站层数 */
    private BigDecimal openStationLayer;
    /** 明挖车站跨数 */
    private BigDecimal openStationSpin;
    /** 暗挖支护结构代码 */
    private String closeSupportStructCode;
    /** 暗挖支护结构 */
    private String closeSupportStruct;
    /** 暗挖车站层数 */
    private BigDecimal closeStationLayer;
    /** 暗挖车站跨数 */
    private BigDecimal closeStationSpin;
    /** 暗挖车站名称 */
    private String closeStationName;
    /** 分步暗挖支护结构代码 */
    private String stepSupportStructCode;
    /** 分步暗挖支护结构 */
    private String stepSupportStruct;
    /** 分步暗挖车站层数 */
    private BigDecimal stepStationLayer;
    /** 分步暗挖车站跨数 */
    private BigDecimal stepStationSpin;
    /** 分步暗挖车站名称 */
    private String stepStationName;
    /** 暗挖PBA法车站层数 */
    private BigDecimal pbaStationLayer;
    /** 暗挖PBA法车站跨数 */
    private BigDecimal pbaStationSpin;
    /** 暗挖PBA法车站名称 */
    private String pbaStationName;
    /** 地下施工小导洞长 */
    private BigDecimal ugConHoldLength;
    /** 地下施工小导洞宽 */
    private BigDecimal ugConHoldWidth;
    /** 地下施工小导洞高 */
    private BigDecimal ugConHoldHigh;
    /** 暗挖PBA法基坑深度 */
    private BigDecimal pbaBasePitDepth;
    /** 支撑数 */
    private BigDecimal pbaSupportNum;
    /** 第一层地下承压水深度 */
    private BigDecimal firstUgPressureDepth;
    /** 第二层地下承压水深度 */
    private BigDecimal secUgPressureDepth;
    /** 施工方法 */
    private String pbaConMethod;
    /** 周围建筑物类型 */
    private String surroundBuildType;
    /** 周边建筑与工程所在地距离 */
    private BigDecimal surroundAndConDistance;
    /** 车站施工风险备注 */
    private String stationRmk;
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
     * 车站工程地址和名称
     * 
     * @return the stationName
     */
    @Column(length = 500)
    public String getStationName() {
        return this.stationName;
    }

    /**
     * 车站工程地址和名称
     * 
     * @param stationName
     *            车站工程地址和名称
     */
    public void setStationName(String stationName) {
        this.stationName = stationName;
    }

    /**
     * 基坑深度
     * 
     * @return the basePitDepth
     */
    @Column(length = 14)
    public BigDecimal getBasePitDepth() {
        return this.basePitDepth;
    }

    /**
     * 基坑深度
     * 
     * @param basePitDepth
     *            基坑深度
     */
    public void setBasePitDepth(BigDecimal basePitDepth) {
        this.basePitDepth = basePitDepth;
    }

    /**
     * 基坑面积
     * 
     * @return the basePitArea
     */
    @Column(length = 14)
    public BigDecimal getBasePitArea() {
        return this.basePitArea;
    }

    /**
     * 基坑面积
     * 
     * @param basePitArea
     *            基坑面积
     */
    public void setBasePitArea(BigDecimal basePitArea) {
        this.basePitArea = basePitArea;
    }

    /**
     * 地下水水位
     * 
     * @return the groundWaterLevel
     */
    @Column(length = 14)
    public BigDecimal getGroundWaterLevel() {
        return this.groundWaterLevel;
    }

    /**
     * 地下水水位
     * 
     * @param groundWaterLevel
     *            地下水水位
     */
    public void setGroundWaterLevel(BigDecimal groundWaterLevel) {
        this.groundWaterLevel = groundWaterLevel;
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
     * 车站施工
     * 
     * @return the stationConstructRmk
     */
    @Column(length = 3999)
    public String getStationConstructRmk() {
        return this.stationConstructRmk;
    }

    /**
     * 车站施工
     * 
     * @param stationConstructRmk
     *            车站施工
     */
    public void setStationConstructRmk(String stationConstructRmk) {
        this.stationConstructRmk = stationConstructRmk;
    }

    /**
     * 明挖支护结构代码
     * 
     * @return the openSupportStructCode
     */
    @Column(length = 50)
    public String getOpenSupportStructCode() {
        return this.openSupportStructCode;
    }

    /**
     * 明挖支护结构代码
     * 
     * @param openSupportStructCode
     *            明挖支护结构代码
     */
    public void setOpenSupportStructCode(String openSupportStructCode) {
        this.openSupportStructCode = openSupportStructCode;
    }

    /**
     * 明挖支护结构
     * 
     * @return the openSupportStruct
     */
    @Column(length = 120)
    public String getOpenSupportStruct() {
        return this.openSupportStruct;
    }

    /**
     * 明挖支护结构
     * 
     * @param openSupportStruct
     *            明挖支护结构
     */
    public void setOpenSupportStruct(String openSupportStruct) {
        this.openSupportStruct = openSupportStruct;
    }

    /**
     * 明挖车站层数
     * 
     * @return the openStationLayer
     */

    public BigDecimal getOpenStationLayer() {
        return this.openStationLayer;
    }

    /**
     * 明挖车站层数
     * 
     * @param openStationLayer
     *            明挖车站层数
     */
    public void setOpenStationLayer(BigDecimal openStationLayer) {
        this.openStationLayer = openStationLayer;
    }

    /**
     * 明挖车站跨数
     * 
     * @return the openStationSpin
     */

    public BigDecimal getOpenStationSpin() {
        return this.openStationSpin;
    }

    /**
     * 明挖车站跨数
     * 
     * @param openStationSpin
     *            明挖车站跨数
     */
    public void setOpenStationSpin(BigDecimal openStationSpin) {
        this.openStationSpin = openStationSpin;
    }

    /**
     * 暗挖支护结构代码
     * 
     * @return the closeSupportStructCode
     */
    @Column(length = 50)
    public String getCloseSupportStructCode() {
        return this.closeSupportStructCode;
    }

    /**
     * 暗挖支护结构代码
     * 
     * @param closeSupportStructCode
     *            暗挖支护结构代码
     */
    public void setCloseSupportStructCode(String closeSupportStructCode) {
        this.closeSupportStructCode = closeSupportStructCode;
    }

    /**
     * 暗挖支护结构
     * 
     * @return the closeSupportStruct
     */
    @Column(length = 120)
    public String getCloseSupportStruct() {
        return this.closeSupportStruct;
    }

    /**
     * 暗挖支护结构
     * 
     * @param closeSupportStruct
     *            暗挖支护结构
     */
    public void setCloseSupportStruct(String closeSupportStruct) {
        this.closeSupportStruct = closeSupportStruct;
    }

    /**
     * 暗挖车站层数
     * 
     * @return the closeStationLayer
     */

    public BigDecimal getCloseStationLayer() {
        return this.closeStationLayer;
    }

    /**
     * 暗挖车站层数
     * 
     * @param closeStationLayer
     *            暗挖车站层数
     */
    public void setCloseStationLayer(BigDecimal closeStationLayer) {
        this.closeStationLayer = closeStationLayer;
    }

    /**
     * 暗挖车站跨数
     * 
     * @return the closeStationSpin
     */

    public BigDecimal getCloseStationSpin() {
        return this.closeStationSpin;
    }

    /**
     * 暗挖车站跨数
     * 
     * @param closeStationSpin
     *            暗挖车站跨数
     */
    public void setCloseStationSpin(BigDecimal closeStationSpin) {
        this.closeStationSpin = closeStationSpin;
    }

    /**
     * 暗挖车站名称
     * 
     * @return the closeStationName
     */
    @Column(length = 120)
    public String getCloseStationName() {
        return this.closeStationName;
    }

    /**
     * 暗挖车站名称
     * 
     * @param closeStationName
     *            暗挖车站名称
     */
    public void setCloseStationName(String closeStationName) {
        this.closeStationName = closeStationName;
    }

    /**
     * 分步暗挖支护结构代码
     * 
     * @return the stepSupportStructCode
     */
    @Column(length = 50)
    public String getStepSupportStructCode() {
        return this.stepSupportStructCode;
    }

    /**
     * 分步暗挖支护结构代码
     * 
     * @param stepSupportStructCode
     *            分步暗挖支护结构代码
     */
    public void setStepSupportStructCode(String stepSupportStructCode) {
        this.stepSupportStructCode = stepSupportStructCode;
    }

    /**
     * 分步暗挖支护结构
     * 
     * @return the stepSupportStruct
     */
    @Column(length = 120)
    public String getStepSupportStruct() {
        return this.stepSupportStruct;
    }

    /**
     * 分步暗挖支护结构
     * 
     * @param stepSupportStruct
     *            分步暗挖支护结构
     */
    public void setStepSupportStruct(String stepSupportStruct) {
        this.stepSupportStruct = stepSupportStruct;
    }

    /**
     * 分步暗挖车站层数
     * 
     * @return the stepStationLayer
     */

    public BigDecimal getStepStationLayer() {
        return this.stepStationLayer;
    }

    /**
     * 分步暗挖车站层数
     * 
     * @param stepStationLayer
     *            分步暗挖车站层数
     */
    public void setStepStationLayer(BigDecimal stepStationLayer) {
        this.stepStationLayer = stepStationLayer;
    }

    /**
     * 分步暗挖车站跨数
     * 
     * @return the stepStationSpin
     */

    public BigDecimal getStepStationSpin() {
        return this.stepStationSpin;
    }

    /**
     * 分步暗挖车站跨数
     * 
     * @param stepStationSpin
     *            分步暗挖车站跨数
     */
    public void setStepStationSpin(BigDecimal stepStationSpin) {
        this.stepStationSpin = stepStationSpin;
    }

    /**
     * 分步暗挖车站名称
     * 
     * @return the stepStationName
     */
    @Column(length = 120)
    public String getStepStationName() {
        return this.stepStationName;
    }

    /**
     * 分步暗挖车站名称
     * 
     * @param stepStationName
     *            分步暗挖车站名称
     */
    public void setStepStationName(String stepStationName) {
        this.stepStationName = stepStationName;
    }

    /**
     * 暗挖PBA法车站层数
     * 
     * @return the pbaStationLayer
     */

    public BigDecimal getPbaStationLayer() {
        return this.pbaStationLayer;
    }

    /**
     * 暗挖PBA法车站层数
     * 
     * @param pbaStationLayer
     *            暗挖PBA法车站层数
     */
    public void setPbaStationLayer(BigDecimal pbaStationLayer) {
        this.pbaStationLayer = pbaStationLayer;
    }

    /**
     * 暗挖PBA法车站跨数
     * 
     * @return the pbaStationSpin
     */

    public BigDecimal getPbaStationSpin() {
        return this.pbaStationSpin;
    }

    /**
     * 暗挖PBA法车站跨数
     * 
     * @param pbaStationSpin
     *            暗挖PBA法车站跨数
     */
    public void setPbaStationSpin(BigDecimal pbaStationSpin) {
        this.pbaStationSpin = pbaStationSpin;
    }

    /**
     * 暗挖PBA法车站名称
     * 
     * @return the pbaStationName
     */
    @Column(length = 120)
    public String getPbaStationName() {
        return this.pbaStationName;
    }

    /**
     * 暗挖PBA法车站名称
     * 
     * @param pbaStationName
     *            暗挖PBA法车站名称
     */
    public void setPbaStationName(String pbaStationName) {
        this.pbaStationName = pbaStationName;
    }

    /**
     * 地下施工小导洞长
     * 
     * @return the ugConHoldLength
     */
    @Column(length = 14)
    public BigDecimal getUgConHoldLength() {
        return this.ugConHoldLength;
    }

    /**
     * 地下施工小导洞长
     * 
     * @param ugConHoldLength
     *            地下施工小导洞长
     */
    public void setUgConHoldLength(BigDecimal ugConHoldLength) {
        this.ugConHoldLength = ugConHoldLength;
    }

    /**
     * 地下施工小导洞宽
     * 
     * @return the ugConHoldWidth
     */
    @Column(length = 14)
    public BigDecimal getUgConHoldWidth() {
        return this.ugConHoldWidth;
    }

    /**
     * 地下施工小导洞宽
     * 
     * @param ugConHoldWidth
     *            地下施工小导洞宽
     */
    public void setUgConHoldWidth(BigDecimal ugConHoldWidth) {
        this.ugConHoldWidth = ugConHoldWidth;
    }

    /**
     * 地下施工小导洞高
     * 
     * @return the ugConHoldHigh
     */
    @Column(length = 14)
    public BigDecimal getUgConHoldHigh() {
        return this.ugConHoldHigh;
    }

    /**
     * 地下施工小导洞高
     * 
     * @param ugConHoldHigh
     *            地下施工小导洞高
     */
    public void setUgConHoldHigh(BigDecimal ugConHoldHigh) {
        this.ugConHoldHigh = ugConHoldHigh;
    }

    /**
     * 暗挖PBA法基坑深度
     * 
     * @return the pbaBasePitDepth
     */
    @Column(length = 14)
    public BigDecimal getPbaBasePitDepth() {
        return this.pbaBasePitDepth;
    }

    /**
     * 暗挖PBA法基坑深度
     * 
     * @param pbaBasePitDepth
     *            暗挖PBA法基坑深度
     */
    public void setPbaBasePitDepth(BigDecimal pbaBasePitDepth) {
        this.pbaBasePitDepth = pbaBasePitDepth;
    }

    /**
     * 支撑数
     * 
     * @return the pbaSupportNum
     */

    public BigDecimal getPbaSupportNum() {
        return this.pbaSupportNum;
    }

    /**
     * 支撑数
     * 
     * @param pbaSupportNum
     *            支撑数
     */
    public void setPbaSupportNum(BigDecimal pbaSupportNum) {
        this.pbaSupportNum = pbaSupportNum;
    }

    /**
     * 第一层地下承压水深度
     * 
     * @return the firstUgPressureDepth
     */
    @Column(length = 14)
    public BigDecimal getFirstUgPressureDepth() {
        return this.firstUgPressureDepth;
    }

    /**
     * 第一层地下承压水深度
     * 
     * @param firstUgPressureDepth
     *            第一层地下承压水深度
     */
    public void setFirstUgPressureDepth(BigDecimal firstUgPressureDepth) {
        this.firstUgPressureDepth = firstUgPressureDepth;
    }

    /**
     * 第二层地下承压水深度
     * 
     * @return the secUgPressureDepth
     */
    @Column(length = 14)
    public BigDecimal getSecUgPressureDepth() {
        return this.secUgPressureDepth;
    }

    /**
     * 第二层地下承压水深度
     * 
     * @param secUgPressureDepth
     *            第二层地下承压水深度
     */
    public void setSecUgPressureDepth(BigDecimal secUgPressureDepth) {
        this.secUgPressureDepth = secUgPressureDepth;
    }

    /**
     * 施工方法
     * 
     * @return the pbaConMethod
     */
    @Column(length = 12)
    public String getPbaConMethod() {
        return this.pbaConMethod;
    }

    /**
     * 施工方法
     * 
     * @param pbaConMethod
     *            施工方法
     */
    public void setPbaConMethod(String pbaConMethod) {
        this.pbaConMethod = pbaConMethod;
    }

    /**
     * 周围建筑物类型
     * 
     * @return the surroundBuildType
     */
    @Column(length = 500)
    public String getSurroundBuildType() {
        return this.surroundBuildType;
    }

    /**
     * 周围建筑物类型
     * 
     * @param surroundBuildType
     *            周围建筑物类型
     */
    public void setSurroundBuildType(String surroundBuildType) {
        this.surroundBuildType = surroundBuildType;
    }

    /**
     * 周边建筑与工程所在地距离
     * 
     * @return the surroundAndConDistance
     */
    @Column(length = 14)
    public BigDecimal getSurroundAndConDistance() {
        return this.surroundAndConDistance;
    }

    /**
     * 周边建筑与工程所在地距离
     * 
     * @param surroundAndConDistance
     *            周边建筑与工程所在地距离
     */
    public void setSurroundAndConDistance(BigDecimal surroundAndConDistance) {
        this.surroundAndConDistance = surroundAndConDistance;
    }

    /**
     * 车站施工风险备注
     * 
     * @return the stationRmk
     */
    @Column(length = 500)
    public String getStationRmk() {
        return this.stationRmk;
    }

    /**
     * 车站施工风险备注
     * 
     * @param stationRmk
     *            车站施工风险备注
     */
    public void setStationRmk(String stationRmk) {
        this.stationRmk = stationRmk;
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