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
 * 地质地貌信息
 */
@Entity
@Table(name = "survey_geology")
public class SurveyGeologyEO extends AbstractBaseEntity {

    /**
     * 
     */
    private static final long serialVersionUID = 5386048946510350101L;
    /** 主键 */
    private String pkId;
    /** 外键 */
    private String rptId;
    /** 地形 */
    private String terrain;
    /** 褶皱 */
    private String fold;
    /** 节理 */
    private String cleftiness;
    /** 断层 */
    private String fault;
    /** 工程经过断层 */
    private String constructAfterFault;
    /** 最大断裂带为 */
    private String biggestFaultZone;
    /** 工程场地岩土分层 */
    private String siteGroundLayer;
    /** 地层岩性描述 */
    private String lithologyDesc;
    /** 历史记录次数 */
    private BigDecimal hisRecordTms;
    /** 最近一次有震感地震 */
    private BigDecimal latestEarthquk;
    /** 区域地震烈度 */
    private BigDecimal zoneEarthqukIntensity;
    /** 不良地质 */
    private String badGeology;
    /** 特殊岩土 */
    private String specialGround;
    /** 其他特殊岩土说明 */
    private String specialGroundRmk;
    /** 发生过滑坡泥石流等地质灾害标识 */
    private String landsideFlag;
    /** 有无软基路段 */
    private String softbaseFlag;
    /** 软基路段长度为 */
    private BigDecimal softbaseLen;
    /** 有无高填土工程 */
    private String highsoilFlag;
    /** 高填土工程长度为 */
    private BigDecimal highsoilLen;
    /** 地址地貌备注 */
    private String geologyRmk;
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
     * 地形
     * 
     * @return the terrain
     */
    @Column(length = 50)
    public String getTerrain() {
        return this.terrain;
    }

    /**
     * 地形
     * 
     * @param terrain
     *            地形
     */
    public void setTerrain(String terrain) {
        this.terrain = terrain;
    }

    /**
     * 褶皱
     * 
     * @return the fold
     */
    @Column(length = 50)
    public String getFold() {
        return this.fold;
    }

    /**
     * 褶皱
     * 
     * @param fold
     *            褶皱
     */
    public void setFold(String fold) {
        this.fold = fold;
    }

    /**
     * 节理
     * 
     * @return the cleftiness
     */
    @Column(length = 50)
    public String getCleftiness() {
        return this.cleftiness;
    }

    /**
     * 节理
     * 
     * @param cleftiness
     *            节理
     */
    public void setCleftiness(String cleftiness) {
        this.cleftiness = cleftiness;
    }

    /**
     * 断层
     * 
     * @return the fault
     */
    @Column(length = 50)
    public String getFault() {
        return this.fault;
    }

    /**
     * 断层
     * 
     * @param fault
     *            断层
     */
    public void setFault(String fault) {
        this.fault = fault;
    }

    /**
     * 工程经过断层
     * 
     * @return the constructAfterFault
     */
    @Column(length = 500)
    public String getConstructAfterFault() {
        return this.constructAfterFault;
    }

    /**
     * 工程经过断层
     * 
     * @param constructAfterFault
     *            工程经过断层
     */
    public void setConstructAfterFault(String constructAfterFault) {
        this.constructAfterFault = constructAfterFault;
    }

    /**
     * 最大断裂带为
     * 
     * @return the biggestFaultZone
     */
    @Column(length = 500)
    public String getBiggestFaultZone() {
        return this.biggestFaultZone;
    }

    /**
     * 最大断裂带为
     * 
     * @param biggestFaultZone
     *            最大断裂带为
     */
    public void setBiggestFaultZone(String biggestFaultZone) {
        this.biggestFaultZone = biggestFaultZone;
    }

    /**
     * 工程场地岩土分层
     * 
     * @return the siteGroundLayer
     */
    @Column(length = 500)
    public String getSiteGroundLayer() {
        return this.siteGroundLayer;
    }

    /**
     * 工程场地岩土分层
     * 
     * @param siteGroundLayer
     *            工程场地岩土分层
     */
    public void setSiteGroundLayer(String siteGroundLayer) {
        this.siteGroundLayer = siteGroundLayer;
    }

    /**
     * 地层岩性描述
     * 
     * @return the lithologyDesc
     */
    @Column(length = 500)
    public String getLithologyDesc() {
        return this.lithologyDesc;
    }

    /**
     * 地层岩性描述
     * 
     * @param lithologyDesc
     *            地层岩性描述
     */
    public void setLithologyDesc(String lithologyDesc) {
        this.lithologyDesc = lithologyDesc;
    }

    /**
     * 历史记录次数
     * 
     * @return the hisRecordTms
     */

    public BigDecimal getHisRecordTms() {
        return this.hisRecordTms;
    }

    /**
     * 历史记录次数
     * 
     * @param hisRecordTms
     *            历史记录次数
     */
    public void setHisRecordTms(BigDecimal hisRecordTms) {
        this.hisRecordTms = hisRecordTms;
    }

    /**
     * 最近一次有震感地震
     * 
     * @return the latestEarthquk
     */

    public BigDecimal getLatestEarthquk() {
        return this.latestEarthquk;
    }

    /**
     * 最近一次有震感地震
     * 
     * @param latestEarthquk
     *            最近一次有震感地震
     */
    public void setLatestEarthquk(BigDecimal latestEarthquk) {
        this.latestEarthquk = latestEarthquk;
    }

    /**
     * 区域地震烈度
     * 
     * @return the zoneEarthqukIntensity
     */

    public BigDecimal getZoneEarthqukIntensity() {
        return this.zoneEarthqukIntensity;
    }

    /**
     * 区域地震烈度
     * 
     * @param zoneEarthqukIntensity
     *            区域地震烈度
     */
    public void setZoneEarthqukIntensity(BigDecimal zoneEarthqukIntensity) {
        this.zoneEarthqukIntensity = zoneEarthqukIntensity;
    }

    /**
     * 不良地质
     * 
     * @return the badGeology
     */
    @Column(length = 50)
    public String getBadGeology() {
        return this.badGeology;
    }

    /**
     * 不良地质
     * 
     * @param badGeology
     *            不良地质
     */
    public void setBadGeology(String badGeology) {
        this.badGeology = badGeology;
    }

    /**
     * 特殊岩土
     * 
     * @return the specialGround
     */
    @Column(length = 50)
    public String getSpecialGround() {
        return this.specialGround;
    }

    /**
     * 特殊岩土
     * 
     * @param specialGround
     *            特殊岩土
     */
    public void setSpecialGround(String specialGround) {
        this.specialGround = specialGround;
    }

    /**
     * 其他特殊岩土说明
     * 
     * @return the specialGroundRmk
     */
    @Column(length = 200)
    public String getSpecialGroundRmk() {
        return this.specialGroundRmk;
    }

    /**
     * 其他特殊岩土说明
     * 
     * @param specialGroundRmk
     *            其他特殊岩土说明
     */
    public void setSpecialGroundRmk(String specialGroundRmk) {
        this.specialGroundRmk = specialGroundRmk;
    }

    /**
     * 发生过滑坡泥石流等地质灾害标识
     * 
     * @return the landsideFlag
     */
    @Column(length = 12)
    public String getLandsideFlag() {
        return this.landsideFlag;
    }

    /**
     * 发生过滑坡泥石流等地质灾害标识
     * 
     * @param landsideFlag
     *            发生过滑坡泥石流等地质灾害标识
     */
    public void setLandsideFlag(String landsideFlag) {
        this.landsideFlag = landsideFlag;
    }

    /**
     * 有无软基路段
     * 
     * @return the softbaseFlag
     */
    @Column(length = 12)
    public String getSoftbaseFlag() {
        return this.softbaseFlag;
    }

    /**
     * 有无软基路段
     * 
     * @param softbaseFlag
     *            有无软基路段
     */
    public void setSoftbaseFlag(String softbaseFlag) {
        this.softbaseFlag = softbaseFlag;
    }

    /**
     * 软基路段长度为
     * 
     * @return the softbaseLen
     */
    @Column(length = 14)
    public BigDecimal getSoftbaseLen() {
        return this.softbaseLen;
    }

    /**
     * 软基路段长度为
     * 
     * @param softbaseLen
     *            软基路段长度为
     */
    public void setSoftbaseLen(BigDecimal softbaseLen) {
        this.softbaseLen = softbaseLen;
    }

    /**
     * 有无高填土工程
     * 
     * @return the highsoilFlag
     */
    @Column(length = 12)
    public String getHighsoilFlag() {
        return this.highsoilFlag;
    }

    /**
     * 有无高填土工程
     * 
     * @param highsoilFlag
     *            有无高填土工程
     */
    public void setHighsoilFlag(String highsoilFlag) {
        this.highsoilFlag = highsoilFlag;
    }

    /**
     * 高填土工程长度为
     * 
     * @return the highsoilLen
     */
    @Column(length = 14)
    public BigDecimal getHighsoilLen() {
        return this.highsoilLen;
    }

    /**
     * 高填土工程长度为
     * 
     * @param highsoilLen
     *            高填土工程长度为
     */
    public void setHighsoilLen(BigDecimal highsoilLen) {
        this.highsoilLen = highsoilLen;
    }

    /**
     * 地址地貌备注
     * 
     * @return the geologyRmk
     */
    @Column(length = 500)
    public String getGeologyRmk() {
        return this.geologyRmk;
    }

    /**
     * 地址地貌备注
     * 
     * @param geologyRmk
     *            地址地貌备注
     */
    public void setGeologyRmk(String geologyRmk) {
        this.geologyRmk = geologyRmk;
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