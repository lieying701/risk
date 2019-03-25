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
 * 公路铁路工程风险
 */
@Entity
@Table(name = "survey_railway")
public class SurveyRailwayEO extends AbstractBaseEntity {

    /**
     * serialVersionUID
     */
    private static final long serialVersionUID = 2738560897376180562L;
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
    /** 公路铁路标段名称 */
    private String railwayName;
    /** 路段桩号起号 */
    private BigDecimal roadStartNum;
    /** 路段桩号止号 */
    private BigDecimal roadEndNum;
    /** 拟承保标段全长 */
    private BigDecimal coverBidsLength;
    /** 桥梁全长 */
    private BigDecimal bridgeLen;
    /** 特大桥(总长) */
    private BigDecimal bigBridgeLen;
    /** 特大桥 */
    private BigDecimal bigBridge;
    /** 特大桥桥梁类型 */
    private String bigBridgeType;
    /** 中桥(总长) */
    private BigDecimal middleBridgeLen;
    /** 中桥 */
    private BigDecimal middleBridge;
    /** 中桥桥梁类型 */
    private String middleBridgeType;
    /** 小桥(总长) */
    private BigDecimal samllBridgeLen;
    /** 小桥 */
    private BigDecimal samllBridge;
    /** 隧道(总长) */
    private BigDecimal tunnelLen;
    /** 隧道 */
    private BigDecimal tunnel;
    /** 立交桥 */
    private BigDecimal overpass;
    /** 互通立交桥 */
    private BigDecimal interchange;
    /** 公路交叉桥 */
    private BigDecimal highwayCrossBridge;
    /** 人行立交桥 */
    private BigDecimal pedestrianOverpass;
    /** 车站总数 */
    private BigDecimal stationNum;
    /** 地下工程总长 */
    private BigDecimal undergroundConLen;
    /** 地下车站数 */
    private BigDecimal undergroundStationNum;
    /** 单洞隧道长 */
    private BigDecimal singleTunnelLen;
    /** 双洞隧道长 */
    private BigDecimal twoTunnelLen;
    /** 高架工程总长 */
    private BigDecimal viaductConLen;
    /** 高架车站数 */
    private BigDecimal viaductStationNum;
    /** 明挖施工总长 */
    private BigDecimal opencutConLen;
    /** 明挖车站数 */
    private BigDecimal opencutStationNum;
    /** 穿过江河名称 */
    private String crossRiverName;
    /** 穿过江河宽度 */
    private BigDecimal crossRiverWidth;
    /** 公路铁路备注 */
    private String railwayRmk;
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
     * 公路铁路标段名称
     * 
     * @return the railwayName
     */
    @Column(length = 500)
    public String getRailwayName() {
        return this.railwayName;
    }

    /**
     * 公路铁路标段名称
     * 
     * @param railwayName
     *            公路铁路标段名称
     */
    public void setRailwayName(String railwayName) {
        this.railwayName = railwayName;
    }

    /**
     * 路段桩号起号
     * 
     * @return the roadStartNum
     */

    public BigDecimal getRoadStartNum() {
        return this.roadStartNum;
    }

    /**
     * 路段桩号起号
     * 
     * @param roadStartNum
     *            路段桩号起号
     */
    public void setRoadStartNum(BigDecimal roadStartNum) {
        this.roadStartNum = roadStartNum;
    }

    /**
     * 路段桩号止号
     * 
     * @return the roadEndNum
     */

    public BigDecimal getRoadEndNum() {
        return this.roadEndNum;
    }

    /**
     * 路段桩号止号
     * 
     * @param roadEndNum
     *            路段桩号止号
     */
    public void setRoadEndNum(BigDecimal roadEndNum) {
        this.roadEndNum = roadEndNum;
    }

    /**
     * 拟承保标段全长
     * 
     * @return the coverBidsLength
     */
    @Column(length = 14)
    public BigDecimal getCoverBidsLength() {
        return this.coverBidsLength;
    }

    /**
     * 拟承保标段全长
     * 
     * @param coverBidsLength
     *            拟承保标段全长
     */
    public void setCoverBidsLength(BigDecimal coverBidsLength) {
        this.coverBidsLength = coverBidsLength;
    }

    /**
     * 桥梁全长
     * 
     * @return the bridgeLen
     */
    @Column(length = 14)
    public BigDecimal getBridgeLen() {
        return this.bridgeLen;
    }

    /**
     * 桥梁全长
     * 
     * @param bridgeLen
     *            桥梁全长
     */
    public void setBridgeLen(BigDecimal bridgeLen) {
        this.bridgeLen = bridgeLen;
    }

    /**
     * 特大桥(总长)
     * 
     * @return the bigBridgeLen
     */
    @Column(length = 14)
    public BigDecimal getBigBridgeLen() {
        return this.bigBridgeLen;
    }

    /**
     * 特大桥(总长)
     * 
     * @param bigBridgeLen
     *            特大桥(总长)
     */
    public void setBigBridgeLen(BigDecimal bigBridgeLen) {
        this.bigBridgeLen = bigBridgeLen;
    }

    /**
     * 特大桥
     * 
     * @return the bigBridge
     */

    public BigDecimal getBigBridge() {
        return this.bigBridge;
    }

    /**
     * 特大桥
     * 
     * @param bigBridge
     *            特大桥
     */
    public void setBigBridge(BigDecimal bigBridge) {
        this.bigBridge = bigBridge;
    }

    /**
     * 特大桥桥梁类型
     * 
     * @return the bigBridgeType
     */
    @Column(length = 255)
    public String getBigBridgeType() {
        return this.bigBridgeType;
    }

    /**
     * 特大桥桥梁类型
     * 
     * @param bigBridgeType
     *            特大桥桥梁类型
     */
    public void setBigBridgeType(String bigBridgeType) {
        this.bigBridgeType = bigBridgeType;
    }

    /**
     * 中桥(总长)
     * 
     * @return the middleBridgeLen
     */
    @Column(length = 14)
    public BigDecimal getMiddleBridgeLen() {
        return this.middleBridgeLen;
    }

    /**
     * 中桥(总长)
     * 
     * @param middleBridgeLen
     *            中桥(总长)
     */
    public void setMiddleBridgeLen(BigDecimal middleBridgeLen) {
        this.middleBridgeLen = middleBridgeLen;
    }

    /**
     * 中桥
     * 
     * @return the middleBridge
     */

    public BigDecimal getMiddleBridge() {
        return this.middleBridge;
    }

    /**
     * 中桥
     * 
     * @param middleBridge
     *            中桥
     */
    public void setMiddleBridge(BigDecimal middleBridge) {
        this.middleBridge = middleBridge;
    }

    /**
     * 中桥桥梁类型
     * 
     * @return the middleBridgeType
     */
    @Column(length = 255)
    public String getMiddleBridgeType() {
        return this.middleBridgeType;
    }

    /**
     * 中桥桥梁类型
     * 
     * @param middleBridgeType
     *            中桥桥梁类型
     */
    public void setMiddleBridgeType(String middleBridgeType) {
        this.middleBridgeType = middleBridgeType;
    }

    /**
     * 小桥(总长)
     * 
     * @return the samllBridgeLen
     */
    @Column(length = 14)
    public BigDecimal getSamllBridgeLen() {
        return this.samllBridgeLen;
    }

    /**
     * 小桥(总长)
     * 
     * @param samllBridgeLen
     *            小桥(总长)
     */
    public void setSamllBridgeLen(BigDecimal samllBridgeLen) {
        this.samllBridgeLen = samllBridgeLen;
    }

    /**
     * 小桥
     * 
     * @return the samllBridge
     */

    public BigDecimal getSamllBridge() {
        return this.samllBridge;
    }

    /**
     * 小桥
     * 
     * @param samllBridge
     *            小桥
     */
    public void setSamllBridge(BigDecimal samllBridge) {
        this.samllBridge = samllBridge;
    }

    /**
     * 隧道(总长)
     * 
     * @return the tunnelLen
     */
    @Column(length = 14)
    public BigDecimal getTunnelLen() {
        return this.tunnelLen;
    }

    /**
     * 隧道(总长)
     * 
     * @param tunnelLen
     *            隧道(总长)
     */
    public void setTunnelLen(BigDecimal tunnelLen) {
        this.tunnelLen = tunnelLen;
    }

    /**
     * 隧道
     * 
     * @return the tunnel
     */

    public BigDecimal getTunnel() {
        return this.tunnel;
    }

    /**
     * 隧道
     * 
     * @param tunnel
     *            隧道
     */
    public void setTunnel(BigDecimal tunnel) {
        this.tunnel = tunnel;
    }

    /**
     * 立交桥
     * 
     * @return the overpass
     */

    public BigDecimal getOverpass() {
        return this.overpass;
    }

    /**
     * 立交桥
     * 
     * @param overpass
     *            立交桥
     */
    public void setOverpass(BigDecimal overpass) {
        this.overpass = overpass;
    }

    /**
     * 互通立交桥
     * 
     * @return the interchange
     */

    public BigDecimal getInterchange() {
        return this.interchange;
    }

    /**
     * 互通立交桥
     * 
     * @param interchange
     *            互通立交桥
     */
    public void setInterchange(BigDecimal interchange) {
        this.interchange = interchange;
    }

    /**
     * 公路交叉桥
     * 
     * @return the highwayCrossBridge
     */

    public BigDecimal getHighwayCrossBridge() {
        return this.highwayCrossBridge;
    }

    /**
     * 公路交叉桥
     * 
     * @param highwayCrossBridge
     *            公路交叉桥
     */
    public void setHighwayCrossBridge(BigDecimal highwayCrossBridge) {
        this.highwayCrossBridge = highwayCrossBridge;
    }

    /**
     * 人行立交桥
     * 
     * @return the pedestrianOverpass
     */

    public BigDecimal getPedestrianOverpass() {
        return this.pedestrianOverpass;
    }

    /**
     * 人行立交桥
     * 
     * @param pedestrianOverpass
     *            人行立交桥
     */
    public void setPedestrianOverpass(BigDecimal pedestrianOverpass) {
        this.pedestrianOverpass = pedestrianOverpass;
    }

    /**
     * 车站总数
     * 
     * @return the stationNum
     */

    public BigDecimal getStationNum() {
        return this.stationNum;
    }

    /**
     * 车站总数
     * 
     * @param stationNum
     *            车站总数
     */
    public void setStationNum(BigDecimal stationNum) {
        this.stationNum = stationNum;
    }

    /**
     * 地下工程总长
     * 
     * @return the undergroundConLen
     */
    @Column(length = 14)
    public BigDecimal getUndergroundConLen() {
        return this.undergroundConLen;
    }

    /**
     * 地下工程总长
     * 
     * @param undergroundConLen
     *            地下工程总长
     */
    public void setUndergroundConLen(BigDecimal undergroundConLen) {
        this.undergroundConLen = undergroundConLen;
    }

    /**
     * 地下车站数
     * 
     * @return the undergroundStationNum
     */

    public BigDecimal getUndergroundStationNum() {
        return this.undergroundStationNum;
    }

    /**
     * 地下车站数
     * 
     * @param undergroundStationNum
     *            地下车站数
     */
    public void setUndergroundStationNum(BigDecimal undergroundStationNum) {
        this.undergroundStationNum = undergroundStationNum;
    }

    /**
     * 单洞隧道长
     * 
     * @return the singleTunnelLen
     */
    @Column(length = 14)
    public BigDecimal getSingleTunnelLen() {
        return this.singleTunnelLen;
    }

    /**
     * 单洞隧道长
     * 
     * @param singleTunnelLen
     *            单洞隧道长
     */
    public void setSingleTunnelLen(BigDecimal singleTunnelLen) {
        this.singleTunnelLen = singleTunnelLen;
    }

    /**
     * 双洞隧道长
     * 
     * @return the twoTunnelLen
     */
    @Column(length = 14)
    public BigDecimal getTwoTunnelLen() {
        return this.twoTunnelLen;
    }

    /**
     * 双洞隧道长
     * 
     * @param twoTunnelLen
     *            双洞隧道长
     */
    public void setTwoTunnelLen(BigDecimal twoTunnelLen) {
        this.twoTunnelLen = twoTunnelLen;
    }

    /**
     * 高架工程总长
     * 
     * @return the viaductConLen
     */
    @Column(length = 14)
    public BigDecimal getViaductConLen() {
        return this.viaductConLen;
    }

    /**
     * 高架工程总长
     * 
     * @param viaductConLen
     *            高架工程总长
     */
    public void setViaductConLen(BigDecimal viaductConLen) {
        this.viaductConLen = viaductConLen;
    }

    /**
     * 高架车站数
     * 
     * @return the viaductStationNum
     */

    public BigDecimal getViaductStationNum() {
        return this.viaductStationNum;
    }

    /**
     * 高架车站数
     * 
     * @param viaductStationNum
     *            高架车站数
     */
    public void setViaductStationNum(BigDecimal viaductStationNum) {
        this.viaductStationNum = viaductStationNum;
    }

    /**
     * 明挖施工总长
     * 
     * @return the opencutConLen
     */
    @Column(length = 14)
    public BigDecimal getOpencutConLen() {
        return this.opencutConLen;
    }

    /**
     * 明挖施工总长
     * 
     * @param opencutConLen
     *            明挖施工总长
     */
    public void setOpencutConLen(BigDecimal opencutConLen) {
        this.opencutConLen = opencutConLen;
    }

    /**
     * 明挖车站数
     * 
     * @return the opencutStationNum
     */

    public BigDecimal getOpencutStationNum() {
        return this.opencutStationNum;
    }

    /**
     * 明挖车站数
     * 
     * @param opencutStationNum
     *            明挖车站数
     */
    public void setOpencutStationNum(BigDecimal opencutStationNum) {
        this.opencutStationNum = opencutStationNum;
    }

    /**
     * 穿过江河名称
     * 
     * @return the crossRiverName
     */
    @Column(length = 255)
    public String getCrossRiverName() {
        return this.crossRiverName;
    }

    /**
     * 穿过江河名称
     * 
     * @param crossRiverName
     *            穿过江河名称
     */
    public void setCrossRiverName(String crossRiverName) {
        this.crossRiverName = crossRiverName;
    }

    /**
     * 穿过江河宽度
     * 
     * @return the crossRiverWidth
     */
    @Column(length = 14)
    public BigDecimal getCrossRiverWidth() {
        return this.crossRiverWidth;
    }

    /**
     * 穿过江河宽度
     * 
     * @param crossRiverWidth
     *            穿过江河宽度
     */
    public void setCrossRiverWidth(BigDecimal crossRiverWidth) {
        this.crossRiverWidth = crossRiverWidth;
    }

    /**
     * 公路铁路备注
     * 
     * @return the railwayRmk
     */
    @Column(length = 500)
    public String getRailwayRmk() {
        return this.railwayRmk;
    }

    /**
     * 公路铁路备注
     * 
     * @param railwayRmk
     *            公路铁路备注
     */
    public void setRailwayRmk(String railwayRmk) {
        this.railwayRmk = railwayRmk;
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