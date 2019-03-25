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
 * 工地概况
 */
@Entity
@Table(name = "survey_worksite")
public class SurveyWorksiteEO extends AbstractBaseEntity {

    /**
     * serialVersionUID
     */
    private static final long serialVersionUID = -7676595589151622136L;
    /** 主键 */
    private String pkId;
    /** 外键 */
    private String rptId;
    /** 营地施工人员数量 */
    private BigDecimal numCampsiteWorker;
    /** 营房结构类型 */
    private String barrackType;
    /** 营地选址周边情况 */
    private String barrackAddressInfo;
    /** 营房周边是否存在地质灾害 */
    private String barrackGeologicHazard;
    /** 物料类型 */
    private String materialType;
    /** 存储方式代码 */
    private String storeTypeCode;
    /** 存储方式 */
    private String storeType;
    /** 物料储量 */
    private BigDecimal materialStoreNum;
    /** 物料价值 */
    private BigDecimal materialAmnt;
    /** 是否高于洪水位置 */
    private String materialHighFloodFlag;
    /** 是否采取防风防漏措施 */
    private String materialWindbreakFlag;
    /** 物料存储地点周边情况 */
    private String materialAddressInfo;
    /** 物料地址是否存在地质灾害 */
    private String materialGeologicHazard;
    /** 消防灭火设备充足标识 */
    private String fullFireFightEquipFlag;
    /** 消防器材使用培训标识 */
    private String useFireFightEquipFlag;
    /** 防火间距充足标识 */
    private String fullFireFightDistFlag;
    /** 有效管理标识 */
    private String validManageFlag;
    /** 安全三宝是否齐全 */
    private String threeSafetyToolFlag;
    /** 工地现场是否整洁 */
    private String worksiteNeatFlag;
    /** 良好接线标识 */
    private String goodWiringFlag;
    /** 是否为旧路改造工程 */
    private String reformEngineerFlag;
    /** 原材料危险程度 */
    private String rawStockRiskDegree;
    /** 最危险的原材料 */
    private String mostRiskRawStock;
    /** 冰冻保护措施 */
    private String frozenProtectMeasure;
    /** 工地概况备注 */
    private String worksiteRmk;
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
     * 营地施工人员数量
     * 
     * @return the numCampsiteWorker
     */

    public BigDecimal getNumCampsiteWorker() {
        return this.numCampsiteWorker;
    }

    /**
     * 营地施工人员数量
     * 
     * @param numCampsiteWorker
     *            营地施工人员数量
     */
    public void setNumCampsiteWorker(BigDecimal numCampsiteWorker) {
        this.numCampsiteWorker = numCampsiteWorker;
    }

    /**
     * 营房结构类型
     * 
     * @return the barrackType
     */
    @Column(length = 255)
    public String getBarrackType() {
        return this.barrackType;
    }

    /**
     * 营房结构类型
     * 
     * @param barrackType
     *            营房结构类型
     */
    public void setBarrackType(String barrackType) {
        this.barrackType = barrackType;
    }

    /**
     * 营地选址周边情况
     * 
     * @return the barrackAddressInfo
     */
    @Column(length = 500)
    public String getBarrackAddressInfo() {
        return this.barrackAddressInfo;
    }

    /**
     * 营地选址周边情况
     * 
     * @param barrackAddressInfo
     *            营地选址周边情况
     */
    public void setBarrackAddressInfo(String barrackAddressInfo) {
        this.barrackAddressInfo = barrackAddressInfo;
    }

    /**
     * 营房周边是否存在地质灾害
     * 
     * @return the barrackGeologicHazard
     */
    @Column(length = 12)
    public String getBarrackGeologicHazard() {
        return this.barrackGeologicHazard;
    }

    /**
     * 营房周边是否存在地质灾害
     * 
     * @param barrackGeologicHazard
     *            营房周边是否存在地质灾害
     */
    public void setBarrackGeologicHazard(String barrackGeologicHazard) {
        this.barrackGeologicHazard = barrackGeologicHazard;
    }

    /**
     * 物料类型
     * 
     * @return the materialType
     */
    @Column(length = 120)
    public String getMaterialType() {
        return this.materialType;
    }

    /**
     * 物料类型
     * 
     * @param materialType
     *            物料类型
     */
    public void setMaterialType(String materialType) {
        this.materialType = materialType;
    }

    /**
     * 存储方式代码
     * 
     * @return the storeTypeCode
     */
    @Column(length = 50)
    public String getStoreTypeCode() {
        return this.storeTypeCode;
    }

    /**
     * 存储方式代码
     * 
     * @param storeTypeCode
     *            存储方式代码
     */
    public void setStoreTypeCode(String storeTypeCode) {
        this.storeTypeCode = storeTypeCode;
    }

    /**
     * 存储方式
     * 
     * @return the storeType
     */
    @Column(length = 120)
    public String getStoreType() {
        return this.storeType;
    }

    /**
     * 存储方式
     * 
     * @param storeType
     *            存储方式
     */
    public void setStoreType(String storeType) {
        this.storeType = storeType;
    }

    /**
     * 物料储量
     * 
     * @return the materialStoreNum
     */

    public BigDecimal getMaterialStoreNum() {
        return this.materialStoreNum;
    }

    /**
     * 物料储量
     * 
     * @param materialStoreNum
     *            物料储量
     */
    public void setMaterialStoreNum(BigDecimal materialStoreNum) {
        this.materialStoreNum = materialStoreNum;
    }

    /**
     * 物料价值
     * 
     * @return the materialAmnt
     */
    @Column(length = 18)
    public BigDecimal getMaterialAmnt() {
        return this.materialAmnt;
    }

    /**
     * 物料价值
     * 
     * @param materialAmnt
     *            物料价值
     */
    public void setMaterialAmnt(BigDecimal materialAmnt) {
        this.materialAmnt = materialAmnt;
    }

    /**
     * 是否高于洪水位置
     * 
     * @return the materialHighFloodFlag
     */
    @Column(length = 12)
    public String getMaterialHighFloodFlag() {
        return this.materialHighFloodFlag;
    }

    /**
     * 是否高于洪水位置
     * 
     * @param materialHighFloodFlag
     *            是否高于洪水位置
     */
    public void setMaterialHighFloodFlag(String materialHighFloodFlag) {
        this.materialHighFloodFlag = materialHighFloodFlag;
    }

    /**
     * 是否采取防风防漏措施
     * 
     * @return the materialWindbreakFlag
     */
    @Column(length = 12)
    public String getMaterialWindbreakFlag() {
        return this.materialWindbreakFlag;
    }

    /**
     * 是否采取防风防漏措施
     * 
     * @param materialWindbreakFlag
     *            是否采取防风防漏措施
     */
    public void setMaterialWindbreakFlag(String materialWindbreakFlag) {
        this.materialWindbreakFlag = materialWindbreakFlag;
    }

    /**
     * 物料存储地点周边情况
     * 
     * @return the materialAddressInfo
     */
    @Column(length = 500)
    public String getMaterialAddressInfo() {
        return this.materialAddressInfo;
    }

    /**
     * 物料存储地点周边情况
     * 
     * @param materialAddressInfo
     *            物料存储地点周边情况
     */
    public void setMaterialAddressInfo(String materialAddressInfo) {
        this.materialAddressInfo = materialAddressInfo;
    }

    /**
     * 物料地址是否存在地质灾害
     * 
     * @return the materialGeologicHazard
     */
    @Column(length = 12)
    public String getMaterialGeologicHazard() {
        return this.materialGeologicHazard;
    }

    /**
     * 物料地址是否存在地质灾害
     * 
     * @param materialGeologicHazard
     *            物料地址是否存在地质灾害
     */
    public void setMaterialGeologicHazard(String materialGeologicHazard) {
        this.materialGeologicHazard = materialGeologicHazard;
    }

    /**
     * 消防灭火设备充足标识
     * 
     * @return the fullFireFightEquipFlag
     */
    @Column(length = 12)
    public String getFullFireFightEquipFlag() {
        return this.fullFireFightEquipFlag;
    }

    /**
     * 消防灭火设备充足标识
     * 
     * @param fullFireFightEquipFlag
     *            消防灭火设备充足标识
     */
    public void setFullFireFightEquipFlag(String fullFireFightEquipFlag) {
        this.fullFireFightEquipFlag = fullFireFightEquipFlag;
    }

    /**
     * 消防器材使用培训标识
     * 
     * @return the useFireFightEquipFlag
     */
    @Column(length = 12)
    public String getUseFireFightEquipFlag() {
        return this.useFireFightEquipFlag;
    }

    /**
     * 消防器材使用培训标识
     * 
     * @param useFireFightEquipFlag
     *            消防器材使用培训标识
     */
    public void setUseFireFightEquipFlag(String useFireFightEquipFlag) {
        this.useFireFightEquipFlag = useFireFightEquipFlag;
    }

    /**
     * 防火间距充足标识
     * 
     * @return the fullFireFightDistFlag
     */
    @Column(length = 12)
    public String getFullFireFightDistFlag() {
        return this.fullFireFightDistFlag;
    }

    /**
     * 防火间距充足标识
     * 
     * @param fullFireFightDistFlag
     *            防火间距充足标识
     */
    public void setFullFireFightDistFlag(String fullFireFightDistFlag) {
        this.fullFireFightDistFlag = fullFireFightDistFlag;
    }

    /**
     * 有效管理标识
     * 
     * @return the validManageFlag
     */
    @Column(length = 12)
    public String getValidManageFlag() {
        return this.validManageFlag;
    }

    /**
     * 有效管理标识
     * 
     * @param validManageFlag
     *            有效管理标识
     */
    public void setValidManageFlag(String validManageFlag) {
        this.validManageFlag = validManageFlag;
    }

    /**
     * 安全三宝是否齐全
     * 
     * @return the threeSafetyToolFlag
     */
    @Column(length = 12)
    public String getThreeSafetyToolFlag() {
        return this.threeSafetyToolFlag;
    }

    /**
     * 安全三宝是否齐全
     * 
     * @param threeSafetyToolFlag
     *            安全三宝是否齐全
     */
    public void setThreeSafetyToolFlag(String threeSafetyToolFlag) {
        this.threeSafetyToolFlag = threeSafetyToolFlag;
    }

    /**
     * 工地现场是否整洁
     * 
     * @return the worksiteNeatFlag
     */
    @Column(length = 12)
    public String getWorksiteNeatFlag() {
        return this.worksiteNeatFlag;
    }

    /**
     * 工地现场是否整洁
     * 
     * @param worksiteNeatFlag
     *            工地现场是否整洁
     */
    public void setWorksiteNeatFlag(String worksiteNeatFlag) {
        this.worksiteNeatFlag = worksiteNeatFlag;
    }

    /**
     * 良好接线标识
     * 
     * @return the goodWiringFlag
     */
    @Column(length = 12)
    public String getGoodWiringFlag() {
        return this.goodWiringFlag;
    }

    /**
     * 良好接线标识
     * 
     * @param goodWiringFlag
     *            良好接线标识
     */
    public void setGoodWiringFlag(String goodWiringFlag) {
        this.goodWiringFlag = goodWiringFlag;
    }

    /**
     * 是否为旧路改造工程
     * 
     * @return the reformEngineerFlag
     */
    @Column(length = 12)
    public String getReformEngineerFlag() {
        return this.reformEngineerFlag;
    }

    /**
     * 是否为旧路改造工程
     * 
     * @param reformEngineerFlag
     *            是否为旧路改造工程
     */
    public void setReformEngineerFlag(String reformEngineerFlag) {
        this.reformEngineerFlag = reformEngineerFlag;
    }

    /**
     * 原材料危险程度
     * 
     * @return the rawStockRiskDegree
     */
    @Column(length = 500)
    public String getRawStockRiskDegree() {
        return this.rawStockRiskDegree;
    }

    /**
     * 原材料危险程度
     * 
     * @param rawStockRiskDegree
     *            原材料危险程度
     */
    public void setRawStockRiskDegree(String rawStockRiskDegree) {
        this.rawStockRiskDegree = rawStockRiskDegree;
    }

    /**
     * 最危险的原材料
     * 
     * @return the mostRiskRawStock
     */
    @Column(length = 500)
    public String getMostRiskRawStock() {
        return this.mostRiskRawStock;
    }

    /**
     * 最危险的原材料
     * 
     * @param mostRiskRawStock
     *            最危险的原材料
     */
    public void setMostRiskRawStock(String mostRiskRawStock) {
        this.mostRiskRawStock = mostRiskRawStock;
    }

    /**
     * 冰冻保护措施
     * 
     * @return the frozenProtectMeasure
     */
    @Column(length = 500)
    public String getFrozenProtectMeasure() {
        return this.frozenProtectMeasure;
    }

    /**
     * 冰冻保护措施
     * 
     * @param frozenProtectMeasure
     *            冰冻保护措施
     */
    public void setFrozenProtectMeasure(String frozenProtectMeasure) {
        this.frozenProtectMeasure = frozenProtectMeasure;
    }

    /**
     * 工地概况备注
     * 
     * @return the worksiteRmk
     */
    @Column(length = 500)
    public String getWorksiteRmk() {
        return this.worksiteRmk;
    }

    /**
     * 工地概况备注
     * 
     * @param worksiteRmk
     *            工地概况备注
     */
    public void setWorksiteRmk(String worksiteRmk) {
        this.worksiteRmk = worksiteRmk;
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