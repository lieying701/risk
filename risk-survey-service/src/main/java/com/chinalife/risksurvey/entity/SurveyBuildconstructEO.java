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
 * 楼宇工程风险
 */
@Entity
@Table(name = "survey_buildconstruct")
public class SurveyBuildconstructEO extends AbstractBaseEntity {

    /**
     * serialVersionUID
     */
    private static final long serialVersionUID = 2880502891643033083L;
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
    /** 楼宇工程名称 */
    private String buildConstructName;
    /** 工程造价 */
    private BigDecimal buildConstructCost;
    /** 楼宇结构类型代码 */
    private String buildConTypeCode;
    /** 楼宇结构类型 */
    private String buildConType;
    /** 其他结构类型说明 */
    private String elseBuildConTypeRmk;
    /** 超高层建筑标识 */
    private BigDecimal overHighBuildFlag;
    /** 地上层数 */
    private BigDecimal floorOverground;
    /** 地上高度(米) */
    private BigDecimal heightOverground;
    /** 地下层数 */
    private BigDecimal floorUnderground;
    /** 地下深度(米) */
    private BigDecimal depthUnderground;
    /** 地上结构施工方法 */
    private String conMeasOverground;
    /** 地下结构施工方法 */
    private String conMeasUnderground;
    /** 基坑深度 */
    private BigDecimal basePitDepth;
    /** 基坑支护类型 */
    private String basePitSupportType;
    /** 基坑降水方法 */
    private String basePitRainMeas;
    /** 周边沉降监测方法 */
    private String monitorSettlleMeas;
    /** 是否包含装修装饰工程 */
    private String concludeDecorateFlag;
    /** 附属设备试车期 */
    private String attachEquipTestPeriod;
    /** 楼宇工程备注 */
    private String buildConRmk;
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
     * 楼宇工程名称
     * 
     * @return the buildConstructName
     */
    @Column(length = 500)
    public String getBuildConstructName() {
        return this.buildConstructName;
    }

    /**
     * 楼宇工程名称
     * 
     * @param buildConstructName
     *            楼宇工程名称
     */
    public void setBuildConstructName(String buildConstructName) {
        this.buildConstructName = buildConstructName;
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
     * 楼宇结构类型代码
     * 
     * @return the buildConTypeCode
     */
    @Column(length = 12)
    public String getBuildConTypeCode() {
        return this.buildConTypeCode;
    }

    /**
     * 楼宇结构类型代码
     * 
     * @param buildConTypeCode
     *            楼宇结构类型代码
     */
    public void setBuildConTypeCode(String buildConTypeCode) {
        this.buildConTypeCode = buildConTypeCode;
    }

    /**
     * 楼宇结构类型
     * 
     * @return the buildConType
     */
    @Column(length = 120)
    public String getBuildConType() {
        return this.buildConType;
    }

    /**
     * 楼宇结构类型
     * 
     * @param buildConType
     *            楼宇结构类型
     */
    public void setBuildConType(String buildConType) {
        this.buildConType = buildConType;
    }

    /**
     * 其他结构类型说明
     * 
     * @return the elseBuildConTypeRmk
     */
    @Column(length = 500)
    public String getElseBuildConTypeRmk() {
        return this.elseBuildConTypeRmk;
    }

    /**
     * 其他结构类型说明
     * 
     * @param elseBuildConTypeRmk
     *            其他结构类型说明
     */
    public void setElseBuildConTypeRmk(String elseBuildConTypeRmk) {
        this.elseBuildConTypeRmk = elseBuildConTypeRmk;
    }

    /**
     * 超高层建筑标识
     * 
     * @return the overHighBuildFlag
     */

    public BigDecimal getOverHighBuildFlag() {
        return this.overHighBuildFlag;
    }

    /**
     * 超高层建筑标识
     * 
     * @param overHighBuildFlag
     *            超高层建筑标识
     */
    public void setOverHighBuildFlag(BigDecimal overHighBuildFlag) {
        this.overHighBuildFlag = overHighBuildFlag;
    }

    /**
     * 地上层数
     * 
     * @return the floorOverground
     */

    public BigDecimal getFloorOverground() {
        return this.floorOverground;
    }

    /**
     * 地上层数
     * 
     * @param floorOverground
     *            地上层数
     */
    public void setFloorOverground(BigDecimal floorOverground) {
        this.floorOverground = floorOverground;
    }

    /**
     * 地上高度(米)
     * 
     * @return the heightOverground
     */
    @Column(length = 14)
    public BigDecimal getHeightOverground() {
        return this.heightOverground;
    }

    /**
     * 地上高度(米)
     * 
     * @param heightOverground
     *            地上高度(米)
     */
    public void setHeightOverground(BigDecimal heightOverground) {
        this.heightOverground = heightOverground;
    }

    /**
     * 地下层数
     * 
     * @return the floorUnderground
     */

    public BigDecimal getFloorUnderground() {
        return this.floorUnderground;
    }

    /**
     * 地下层数
     * 
     * @param floorUnderground
     *            地下层数
     */
    public void setFloorUnderground(BigDecimal floorUnderground) {
        this.floorUnderground = floorUnderground;
    }

    /**
     * 地下深度(米)
     * 
     * @return the depthUnderground
     */
    @Column(length = 14)
    public BigDecimal getDepthUnderground() {
        return this.depthUnderground;
    }

    /**
     * 地下深度(米)
     * 
     * @param depthUnderground
     *            地下深度(米)
     */
    public void setDepthUnderground(BigDecimal depthUnderground) {
        this.depthUnderground = depthUnderground;
    }

    /**
     * 地上结构施工方法
     * 
     * @return the conMeasOverground
     */
    @Column(length = 500)
    public String getConMeasOverground() {
        return this.conMeasOverground;
    }

    /**
     * 地上结构施工方法
     * 
     * @param conMeasOverground
     *            地上结构施工方法
     */
    public void setConMeasOverground(String conMeasOverground) {
        this.conMeasOverground = conMeasOverground;
    }

    /**
     * 地下结构施工方法
     * 
     * @return the conMeasUnderground
     */
    @Column(length = 500)
    public String getConMeasUnderground() {
        return this.conMeasUnderground;
    }

    /**
     * 地下结构施工方法
     * 
     * @param conMeasUnderground
     *            地下结构施工方法
     */
    public void setConMeasUnderground(String conMeasUnderground) {
        this.conMeasUnderground = conMeasUnderground;
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
     * 基坑支护类型
     * 
     * @return the basePitSupportType
     */
    @Column(length = 500)
    public String getBasePitSupportType() {
        return this.basePitSupportType;
    }

    /**
     * 基坑支护类型
     * 
     * @param basePitSupportType
     *            基坑支护类型
     */
    public void setBasePitSupportType(String basePitSupportType) {
        this.basePitSupportType = basePitSupportType;
    }

    /**
     * 基坑降水方法
     * 
     * @return the basePitRainMeas
     */
    @Column(length = 500)
    public String getBasePitRainMeas() {
        return this.basePitRainMeas;
    }

    /**
     * 基坑降水方法
     * 
     * @param basePitRainMeas
     *            基坑降水方法
     */
    public void setBasePitRainMeas(String basePitRainMeas) {
        this.basePitRainMeas = basePitRainMeas;
    }

    /**
     * 周边沉降监测方法
     * 
     * @return the monitorSettlleMeas
     */
    @Column(length = 500)
    public String getMonitorSettlleMeas() {
        return this.monitorSettlleMeas;
    }

    /**
     * 周边沉降监测方法
     * 
     * @param monitorSettlleMeas
     *            周边沉降监测方法
     */
    public void setMonitorSettlleMeas(String monitorSettlleMeas) {
        this.monitorSettlleMeas = monitorSettlleMeas;
    }

    /**
     * 是否包含装修装饰工程
     * 
     * @return the concludeDecorateFlag
     */
    @Column(length = 12)
    public String getConcludeDecorateFlag() {
        return this.concludeDecorateFlag;
    }

    /**
     * 是否包含装修装饰工程
     * 
     * @param concludeDecorateFlag
     *            是否包含装修装饰工程
     */
    public void setConcludeDecorateFlag(String concludeDecorateFlag) {
        this.concludeDecorateFlag = concludeDecorateFlag;
    }

    /**
     * 附属设备试车期
     * 
     * @return the attachEquipTestPeriod
     */
    @Column(length = 50)
    public String getAttachEquipTestPeriod() {
        return this.attachEquipTestPeriod;
    }

    /**
     * 附属设备试车期
     * 
     * @param attachEquipTestPeriod
     *            附属设备试车期
     */
    public void setAttachEquipTestPeriod(String attachEquipTestPeriod) {
        this.attachEquipTestPeriod = attachEquipTestPeriod;
    }

    /**
     * 楼宇工程备注
     * 
     * @return the buildConRmk
     */
    @Column(length = 500)
    public String getBuildConRmk() {
        return this.buildConRmk;
    }

    /**
     * 楼宇工程备注
     * 
     * @param buildConRmk
     *            楼宇工程备注
     */
    public void setBuildConRmk(String buildConRmk) {
        this.buildConRmk = buildConRmk;
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