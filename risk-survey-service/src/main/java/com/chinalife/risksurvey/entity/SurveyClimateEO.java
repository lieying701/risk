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
 * 气候水文
 */
@Entity
@Table(name = "survey_climate")
public class SurveyClimateEO extends AbstractBaseEntity {

    /**
     * serialVersionUID
     */
    private static final long serialVersionUID = 3721485057946005298L;
    /** 主键 */
    private String pkId;
    /** 外键 */
    private String rptId;
    /** 年平均气温 */
    private String averageAnnualTemp;
    /** 年最高气温 */
    private String highestAnnualTemp;
    /** 年最低气温 */
    private String lowestAnnualTemp;
    /** 近10年最大降雨量mm每小时 */
    private BigDecimal tenBiggestRainfallhour;
    /** 近10年最大降雨量mm每天 */
    private BigDecimal tenBiggestRainfallDay;
    /** 近50年最大降雨量mm每天 */
    private BigDecimal fiftyBiggestRainfallDay;
    /** 近50年最大降雨量mm每小时 */
    private BigDecimal fiftyBiggestRainfallHour;
    /** 工程所在地雨季月 */
    private BigDecimal rainsmonthConstructSite;
    /** 雨季降雨量占全年百分比 */
    private BigDecimal rainfallRateInRainsea;
    /** 每年暴雨分布在几月 */
    private BigDecimal annualRainsDistribute;
    /** 全年6级以上大风日数 */
    private BigDecimal daysAnnualSixLevWind;
    /** 大风日数最多的两个季节 */
    private String mostBigWindDaySeason;
    /** 台风频率 */
    private BigDecimal typhoonRate;
    /** 近五年最大风力 */
    private BigDecimal fiftyBiggestWind;
    /** 有无龙卷风 */
    private String tornadoFlag;
    /** 龙卷风频率 */
    private BigDecimal tornadoRate;
    /** 距离最近的江河名称 */
    private String nearestRiver;
    /** 10年内最高水位 */
    private BigDecimal tenHighestWater;
    /** 50年来最低水位 */
    private BigDecimal fiftyYearLowestWater;
    /** 气候水文备注 */
    private String climateRmk;
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
     * 年平均气温
     * 
     * @return the averageAnnualTemp
     */
    @Column(length = 120)
    public String getAverageAnnualTemp() {
        return this.averageAnnualTemp;
    }

    /**
     * 年平均气温
     * 
     * @param averageAnnualTemp
     *            年平均气温
     */
    public void setAverageAnnualTemp(String averageAnnualTemp) {
        this.averageAnnualTemp = averageAnnualTemp;
    }

    /**
     * 年最高气温
     * 
     * @return the highestAnnualTemp
     */
    @Column(length = 120)
    public String getHighestAnnualTemp() {
        return this.highestAnnualTemp;
    }

    /**
     * 年最高气温
     * 
     * @param highestAnnualTemp
     *            年最高气温
     */
    public void setHighestAnnualTemp(String highestAnnualTemp) {
        this.highestAnnualTemp = highestAnnualTemp;
    }

    /**
     * 年最低气温
     * 
     * @return the lowestAnnualTemp
     */
    @Column(length = 120)
    public String getLowestAnnualTemp() {
        return this.lowestAnnualTemp;
    }

    /**
     * 年最低气温
     * 
     * @param lowestAnnualTemp
     *            年最低气温
     */
    public void setLowestAnnualTemp(String lowestAnnualTemp) {
        this.lowestAnnualTemp = lowestAnnualTemp;
    }

    /**
     * 近10年最大降雨量mm每小时
     * 
     * @return the tenBiggestRainfallhour
     */
    @Column(length = 14)
    public BigDecimal getTenBiggestRainfallhour() {
        return this.tenBiggestRainfallhour;
    }

    /**
     * 近10年最大降雨量mm每小时
     * 
     * @param tenBiggestRainfallhour
     *            近10年最大降雨量mm每小时
     */
    public void setTenBiggestRainfallhour(BigDecimal tenBiggestRainfallhour) {
        this.tenBiggestRainfallhour = tenBiggestRainfallhour;
    }

    /**
     * 近10年最大降雨量mm每天
     * 
     * @return the tenBiggestRainfallDay
     */
    @Column(length = 14)
    public BigDecimal getTenBiggestRainfallDay() {
        return this.tenBiggestRainfallDay;
    }

    /**
     * 近10年最大降雨量mm每天
     * 
     * @param tenBiggestRainfallDay
     *            近10年最大降雨量mm每天
     */
    public void setTenBiggestRainfallDay(BigDecimal tenBiggestRainfallDay) {
        this.tenBiggestRainfallDay = tenBiggestRainfallDay;
    }

    /**
     * 近50年最大降雨量mm每天
     * 
     * @return the fiftyBiggestRainfallDay
     */
    @Column(length = 14)
    public BigDecimal getFiftyBiggestRainfallDay() {
        return this.fiftyBiggestRainfallDay;
    }

    /**
     * 近50年最大降雨量mm每天
     * 
     * @param fiftyBiggestRainfallDay
     *            近50年最大降雨量mm每天
     */
    public void setFiftyBiggestRainfallDay(BigDecimal fiftyBiggestRainfallDay) {
        this.fiftyBiggestRainfallDay = fiftyBiggestRainfallDay;
    }

    /**
     * 近50年最大降雨量mm每小时
     * 
     * @return the fiftyBiggestRainfallHour
     */
    @Column(length = 14)
    public BigDecimal getFiftyBiggestRainfallHour() {
        return this.fiftyBiggestRainfallHour;
    }

    /**
     * 近50年最大降雨量mm每小时
     * 
     * @param fiftyBiggestRainfallHour
     *            近50年最大降雨量mm每小时
     */
    public void setFiftyBiggestRainfallHour(BigDecimal fiftyBiggestRainfallHour) {
        this.fiftyBiggestRainfallHour = fiftyBiggestRainfallHour;
    }

    /**
     * 工程所在地雨季月
     * 
     * @return the rainsmonthConstructSite
     */

    public BigDecimal getRainsmonthConstructSite() {
        return this.rainsmonthConstructSite;
    }

    /**
     * 工程所在地雨季月
     * 
     * @param rainsmonthConstructSite
     *            工程所在地雨季月
     */
    public void setRainsmonthConstructSite(BigDecimal rainsmonthConstructSite) {
        this.rainsmonthConstructSite = rainsmonthConstructSite;
    }

    /**
     * 雨季降雨量占全年百分比
     * 
     * @return the rainfallRateInRainsea
     */
    @Column(length = 18)
    public BigDecimal getRainfallRateInRainsea() {
        return this.rainfallRateInRainsea;
    }

    /**
     * 雨季降雨量占全年百分比
     * 
     * @param rainfallRateInRainsea
     *            雨季降雨量占全年百分比
     */
    public void setRainfallRateInRainsea(BigDecimal rainfallRateInRainsea) {
        this.rainfallRateInRainsea = rainfallRateInRainsea;
    }

    /**
     * 每年暴雨分布在几月
     * 
     * @return the annualRainsDistribute
     */

    public BigDecimal getAnnualRainsDistribute() {
        return this.annualRainsDistribute;
    }

    /**
     * 每年暴雨分布在几月
     * 
     * @param annualRainsDistribute
     *            每年暴雨分布在几月
     */
    public void setAnnualRainsDistribute(BigDecimal annualRainsDistribute) {
        this.annualRainsDistribute = annualRainsDistribute;
    }

    /**
     * 全年6级以上大风日数
     * 
     * @return the daysAnnualSixLevWind
     */

    public BigDecimal getDaysAnnualSixLevWind() {
        return this.daysAnnualSixLevWind;
    }

    /**
     * 全年6级以上大风日数
     * 
     * @param daysAnnualSixLevWind
     *            全年6级以上大风日数
     */
    public void setDaysAnnualSixLevWind(BigDecimal daysAnnualSixLevWind) {
        this.daysAnnualSixLevWind = daysAnnualSixLevWind;
    }

    /**
     * 大风日数最多的两个季节
     * 
     * @return the mostBigWindDaySeason
     */
    @Column(length = 120)
    public String getMostBigWindDaySeason() {
        return this.mostBigWindDaySeason;
    }

    /**
     * 大风日数最多的两个季节
     * 
     * @param mostBigWindDaySeason
     *            大风日数最多的两个季节
     */
    public void setMostBigWindDaySeason(String mostBigWindDaySeason) {
        this.mostBigWindDaySeason = mostBigWindDaySeason;
    }

    /**
     * 台风频率
     * 
     * @return the typhoonRate
     */

    public BigDecimal getTyphoonRate() {
        return this.typhoonRate;
    }

    /**
     * 台风频率
     * 
     * @param typhoonRate
     *            台风频率
     */
    public void setTyphoonRate(BigDecimal typhoonRate) {
        this.typhoonRate = typhoonRate;
    }

    /**
     * 近五年最大风力
     * 
     * @return the fiftyBiggestWind
     */

    public BigDecimal getFiftyBiggestWind() {
        return this.fiftyBiggestWind;
    }

    /**
     * 近五年最大风力
     * 
     * @param fiftyBiggestWind
     *            近五年最大风力
     */
    public void setFiftyBiggestWind(BigDecimal fiftyBiggestWind) {
        this.fiftyBiggestWind = fiftyBiggestWind;
    }

    /**
     * 有无龙卷风
     * 
     * @return the tornadoFlag
     */
    @Column(length = 12)
    public String getTornadoFlag() {
        return this.tornadoFlag;
    }

    /**
     * 有无龙卷风
     * 
     * @param tornadoFlag
     *            有无龙卷风
     */
    public void setTornadoFlag(String tornadoFlag) {
        this.tornadoFlag = tornadoFlag;
    }

    /**
     * 龙卷风频率
     * 
     * @return the tornadoRate
     */

    public BigDecimal getTornadoRate() {
        return this.tornadoRate;
    }

    /**
     * 龙卷风频率
     * 
     * @param tornadoRate
     *            龙卷风频率
     */
    public void setTornadoRate(BigDecimal tornadoRate) {
        this.tornadoRate = tornadoRate;
    }

    /**
     * 距离最近的江河名称
     * 
     * @return the nearestRiver
     */
    @Column(length = 255)
    public String getNearestRiver() {
        return this.nearestRiver;
    }

    /**
     * 距离最近的江河名称
     * 
     * @param nearestRiver
     *            距离最近的江河名称
     */
    public void setNearestRiver(String nearestRiver) {
        this.nearestRiver = nearestRiver;
    }

    /**
     * 10年内最高水位
     * 
     * @return the tenHighestWater
     */
    @Column(length = 14)
    public BigDecimal getTenHighestWater() {
        return this.tenHighestWater;
    }

    /**
     * 10年内最高水位
     * 
     * @param tenHighestWater
     *            10年内最高水位
     */
    public void setTenHighestWater(BigDecimal tenHighestWater) {
        this.tenHighestWater = tenHighestWater;
    }

    /**
     * 50年来最低水位
     * 
     * @return the fiftyYearLowestWater
     */
    @Column(length = 14)
    public BigDecimal getFiftyYearLowestWater() {
        return this.fiftyYearLowestWater;
    }

    /**
     * 50年来最低水位
     * 
     * @param fiftyYearLowestWater
     *            50年来最低水位
     */
    public void setFiftyYearLowestWater(BigDecimal fiftyYearLowestWater) {
        this.fiftyYearLowestWater = fiftyYearLowestWater;
    }

    /**
     * 气候水文备注
     * 
     * @return the climateRmk
     */
    @Column(length = 500)
    public String getClimateRmk() {
        return this.climateRmk;
    }

    /**
     * 气候水文备注
     * 
     * @param climateRmk
     *            气候水文备注
     */
    public void setClimateRmk(String climateRmk) {
        this.climateRmk = climateRmk;
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