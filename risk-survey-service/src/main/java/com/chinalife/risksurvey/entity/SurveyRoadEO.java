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
 * 道路施工风险
 */
@Entity
@Table(name = "survey_road")
public class SurveyRoadEO extends AbstractBaseEntity {

    /**
     * serialVersionUID
     */
    private static final long serialVersionUID = -6608969562852705938L;
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
    /** 路段名称 */
    private String roadName;
    /** 路段桩号起号 */
    private BigDecimal roadStartNum;
    /** 路段桩号止号 */
    private BigDecimal roadEndNum;
    /** 桥隧占比 */
    private BigDecimal bridgeTunnelRate;
    /** 路堤、路基 */
    private BigDecimal roadbedLen;
    /** 路基边坡度 */
    private String roadbedGrade;
    /** 平均坡高 */
    private BigDecimal averageGrade;
    /** 最大坡度 */
    private BigDecimal bigGrade;
    /** 坡高大于20米 */
    private BigDecimal gradeHigherTwenty;
    /** 坡高大于20米占比 */
    private BigDecimal gradeHigherTwentyRate;
    /** 坡高大于12米 */
    private BigDecimal gradeHigherTwelve;
    /** 坡高大于12米占比 */
    private BigDecimal gradeHigherTwelveRate;
    /** 路堑路基 */
    private BigDecimal cuttingRoadbedLen;
    /** 最高挖方高度 */
    private BigDecimal highCutHeight;
    /** 路堑最大坡高 */
    private BigDecimal bigCuttingGrade;
    /** 路堑边坡平台 */
    private BigDecimal cuttingHighwallPlate;
    /** 最高边坡 */
    private BigDecimal highHighwall;
    /** 半挖半填道路 */
    private BigDecimal halfDugHalfFillRoad;
    /** 路堤最大坡高 */
    private BigDecimal bigEmbackmentGrade;
    /** 半挖路堑最大坡高 */
    private BigDecimal bigHalfDugCuttingGrade;
    /** 边坡护理代码 */
    private String highwallNurseCode;
    /** 边坡护理 */
    private String highwallNurse;
    /** 其他边坡护理说明 */
    private String elseHighwallNurseRmk;
    /** 边坡加固代码 */
    private String highwallFastenCode;
    /** 边坡加固 */
    private String highwallFasten;
    /** 其他边坡加固说明 */
    private String elseHighwallFastenRmk;
    /** 软土地质成相代码 */
    private String softsoilGeologyCode;
    /** 软土地质成相 */
    private String softsoilGeology;
    /** 软土路坡高小于等于3米 */
    private BigDecimal lowThreeSoftsoilGrade;
    /** 软土路坡高大于等于3米 */
    private BigDecimal highThreeSoftsoilGrade;
    /** 有无软土路基 */
    private String softsoilRoadbedFlag;
    /** 软土地基处理代码 */
    private String softsoilRoadbedCode;
    /** 软土地基处理 */
    private String softsoilRoadbed;
    /** 其他软土地基处理说明 */
    private String elseSoftsoilRoadbedRmk;
    /** 道路施工备注 */
    private String roadRmk;
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
     * 路段名称
     * 
     * @return the roadName
     */
    @Column(length = 500)
    public String getRoadName() {
        return this.roadName;
    }

    /**
     * 路段名称
     * 
     * @param roadName
     *            路段名称
     */
    public void setRoadName(String roadName) {
        this.roadName = roadName;
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
     * 桥隧占比
     * 
     * @return the bridgeTunnelRate
     */
    @Column(length = 18)
    public BigDecimal getBridgeTunnelRate() {
        return this.bridgeTunnelRate;
    }

    /**
     * 桥隧占比
     * 
     * @param bridgeTunnelRate
     *            桥隧占比
     */
    public void setBridgeTunnelRate(BigDecimal bridgeTunnelRate) {
        this.bridgeTunnelRate = bridgeTunnelRate;
    }

    /**
     * 路堤、路基
     * 
     * @return the roadbedLen
     */
    @Column(length = 14)
    public BigDecimal getRoadbedLen() {
        return this.roadbedLen;
    }

    /**
     * 路堤、路基
     * 
     * @param roadbedLen
     *            路堤、路基
     */
    public void setRoadbedLen(BigDecimal roadbedLen) {
        this.roadbedLen = roadbedLen;
    }

    /**
     * 路基边坡度
     * 
     * @return the roadbedGrade
     */
    @Column(length = 50)
    public String getRoadbedGrade() {
        return this.roadbedGrade;
    }

    /**
     * 路基边坡度
     * 
     * @param roadbedGrade
     *            路基边坡度
     */
    public void setRoadbedGrade(String roadbedGrade) {
        this.roadbedGrade = roadbedGrade;
    }

    /**
     * 平均坡高
     * 
     * @return the averageGrade
     */
    @Column(length = 14)
    public BigDecimal getAverageGrade() {
        return this.averageGrade;
    }

    /**
     * 平均坡高
     * 
     * @param averageGrade
     *            平均坡高
     */
    public void setAverageGrade(BigDecimal averageGrade) {
        this.averageGrade = averageGrade;
    }

    /**
     * 最大坡度
     * 
     * @return the bigGrade
     */
    @Column(length = 14)
    public BigDecimal getBigGrade() {
        return this.bigGrade;
    }

    /**
     * 最大坡度
     * 
     * @param bigGrade
     *            最大坡度
     */
    public void setBigGrade(BigDecimal bigGrade) {
        this.bigGrade = bigGrade;
    }

    /**
     * 坡高大于20米
     * 
     * @return the gradeHigherTwenty
     */
    @Column(length = 14)
    public BigDecimal getGradeHigherTwenty() {
        return this.gradeHigherTwenty;
    }

    /**
     * 坡高大于20米
     * 
     * @param gradeHigherTwenty
     *            坡高大于20米
     */
    public void setGradeHigherTwenty(BigDecimal gradeHigherTwenty) {
        this.gradeHigherTwenty = gradeHigherTwenty;
    }

    /**
     * 坡高大于20米占比
     * 
     * @return the gradeHigherTwentyRate
     */
    @Column(length = 18)
    public BigDecimal getGradeHigherTwentyRate() {
        return this.gradeHigherTwentyRate;
    }

    /**
     * 坡高大于20米占比
     * 
     * @param gradeHigherTwentyRate
     *            坡高大于20米占比
     */
    public void setGradeHigherTwentyRate(BigDecimal gradeHigherTwentyRate) {
        this.gradeHigherTwentyRate = gradeHigherTwentyRate;
    }

    /**
     * 坡高大于12米
     * 
     * @return the gradeHigherTwelve
     */
    @Column(length = 14)
    public BigDecimal getGradeHigherTwelve() {
        return this.gradeHigherTwelve;
    }

    /**
     * 坡高大于12米
     * 
     * @param gradeHigherTwelve
     *            坡高大于12米
     */
    public void setGradeHigherTwelve(BigDecimal gradeHigherTwelve) {
        this.gradeHigherTwelve = gradeHigherTwelve;
    }

    /**
     * 坡高大于12米占比
     * 
     * @return the gradeHigherTwelveRate
     */
    @Column(length = 18)
    public BigDecimal getGradeHigherTwelveRate() {
        return this.gradeHigherTwelveRate;
    }

    /**
     * 坡高大于12米占比
     * 
     * @param gradeHigherTwelveRate
     *            坡高大于12米占比
     */
    public void setGradeHigherTwelveRate(BigDecimal gradeHigherTwelveRate) {
        this.gradeHigherTwelveRate = gradeHigherTwelveRate;
    }

    /**
     * 路堑路基
     * 
     * @return the cuttingRoadbedLen
     */
    @Column(length = 14)
    public BigDecimal getCuttingRoadbedLen() {
        return this.cuttingRoadbedLen;
    }

    /**
     * 路堑路基
     * 
     * @param cuttingRoadbedLen
     *            路堑路基
     */
    public void setCuttingRoadbedLen(BigDecimal cuttingRoadbedLen) {
        this.cuttingRoadbedLen = cuttingRoadbedLen;
    }

    /**
     * 最高挖方高度
     * 
     * @return the highCutHeight
     */
    @Column(length = 14)
    public BigDecimal getHighCutHeight() {
        return this.highCutHeight;
    }

    /**
     * 最高挖方高度
     * 
     * @param highCutHeight
     *            最高挖方高度
     */
    public void setHighCutHeight(BigDecimal highCutHeight) {
        this.highCutHeight = highCutHeight;
    }

    /**
     * 路堑最大坡高
     * 
     * @return the bigCuttingGrade
     */
    @Column(length = 14)
    public BigDecimal getBigCuttingGrade() {
        return this.bigCuttingGrade;
    }

    /**
     * 路堑最大坡高
     * 
     * @param bigCuttingGrade
     *            路堑最大坡高
     */
    public void setBigCuttingGrade(BigDecimal bigCuttingGrade) {
        this.bigCuttingGrade = bigCuttingGrade;
    }

    /**
     * 路堑边坡平台
     * 
     * @return the cuttingHighwallPlate
     */

    public BigDecimal getCuttingHighwallPlate() {
        return this.cuttingHighwallPlate;
    }

    /**
     * 路堑边坡平台
     * 
     * @param cuttingHighwallPlate
     *            路堑边坡平台
     */
    public void setCuttingHighwallPlate(BigDecimal cuttingHighwallPlate) {
        this.cuttingHighwallPlate = cuttingHighwallPlate;
    }

    /**
     * 最高边坡
     * 
     * @return the HighHighwall
     */

    public BigDecimal getHighHighwall() {
        return this.highHighwall;
    }

    /**
     * 最高边坡
     * 
     * @param highHighwall
     *            最高边坡
     */
    public void setHighHighwall(BigDecimal highHighwall) {
        this.highHighwall = highHighwall;
    }

    /**
     * 半挖半填道路
     * 
     * @return the halfDugHalfFillRoad
     */
    @Column(length = 14)
    public BigDecimal getHalfDugHalfFillRoad() {
        return this.halfDugHalfFillRoad;
    }

    /**
     * 半挖半填道路
     * 
     * @param halfDugHalfFillRoad
     *            半挖半填道路
     */
    public void setHalfDugHalfFillRoad(BigDecimal halfDugHalfFillRoad) {
        this.halfDugHalfFillRoad = halfDugHalfFillRoad;
    }

    /**
     * 路堤最大坡高
     * 
     * @return the bigEmbackmentGrade
     */
    @Column(length = 14)
    public BigDecimal getBigEmbackmentGrade() {
        return this.bigEmbackmentGrade;
    }

    /**
     * 路堤最大坡高
     * 
     * @param bigEmbackmentGrade
     *            路堤最大坡高
     */
    public void setBigEmbackmentGrade(BigDecimal bigEmbackmentGrade) {
        this.bigEmbackmentGrade = bigEmbackmentGrade;
    }

    /**
     * 半挖路堑最大坡高
     * 
     * @return the bigHalfDugCuttingGrade
     */
    @Column(length = 14)
    public BigDecimal getBigHalfDugCuttingGrade() {
        return this.bigHalfDugCuttingGrade;
    }

    /**
     * 半挖路堑最大坡高
     * 
     * @param bigHalfDugCuttingGrade
     *            半挖路堑最大坡高
     */
    public void setBigHalfDugCuttingGrade(BigDecimal bigHalfDugCuttingGrade) {
        this.bigHalfDugCuttingGrade = bigHalfDugCuttingGrade;
    }

    /**
     * 边坡护理代码
     * 
     * @return the highwallNurseCode
     */
    @Column(length = 12)
    public String getHighwallNurseCode() {
        return this.highwallNurseCode;
    }

    /**
     * 边坡护理代码
     * 
     * @param highwallNurseCode
     *            边坡护理代码
     */
    public void setHighwallNurseCode(String highwallNurseCode) {
        this.highwallNurseCode = highwallNurseCode;
    }

    /**
     * 边坡护理
     * 
     * @return the highwallNurse
     */
    @Column(length = 255)
    public String getHighwallNurse() {
        return this.highwallNurse;
    }

    /**
     * 边坡护理
     * 
     * @param highwallNurse
     *            边坡护理
     */
    public void setHighwallNurse(String highwallNurse) {
        this.highwallNurse = highwallNurse;
    }

    /**
     * 其他边坡护理说明
     * 
     * @return the elseHighwallNurseRmk
     */
    @Column(length = 255)
    public String getElseHighwallNurseRmk() {
        return this.elseHighwallNurseRmk;
    }

    /**
     * 其他边坡护理说明
     * 
     * @param elseHighwallNurseRmk
     *            其他边坡护理说明
     */
    public void setElseHighwallNurseRmk(String elseHighwallNurseRmk) {
        this.elseHighwallNurseRmk = elseHighwallNurseRmk;
    }

    /**
     * 边坡加固代码
     * 
     * @return the highwallFastenCode
     */
    @Column(length = 12)
    public String getHighwallFastenCode() {
        return this.highwallFastenCode;
    }

    /**
     * 边坡加固代码
     * 
     * @param highwallFastenCode
     *            边坡加固代码
     */
    public void setHighwallFastenCode(String highwallFastenCode) {
        this.highwallFastenCode = highwallFastenCode;
    }

    /**
     * 边坡加固
     * 
     * @return the highwallFasten
     */
    @Column(length = 120)
    public String getHighwallFasten() {
        return this.highwallFasten;
    }

    /**
     * 边坡加固
     * 
     * @param highwallFasten
     *            边坡加固
     */
    public void setHighwallFasten(String highwallFasten) {
        this.highwallFasten = highwallFasten;
    }

    /**
     * 其他边坡加固说明
     * 
     * @return the elseHighwallFastenRmk
     */
    @Column(length = 500)
    public String getElseHighwallFastenRmk() {
        return this.elseHighwallFastenRmk;
    }

    /**
     * 其他边坡加固说明
     * 
     * @param elseHighwallFastenRmk
     *            其他边坡加固说明
     */
    public void setElseHighwallFastenRmk(String elseHighwallFastenRmk) {
        this.elseHighwallFastenRmk = elseHighwallFastenRmk;
    }

    /**
     * 软土地质成相代码
     * 
     * @return the softsoilGeologyCode
     */
    @Column(length = 12)
    public String getSoftsoilGeologyCode() {
        return this.softsoilGeologyCode;
    }

    /**
     * 软土地质成相代码
     * 
     * @param softsoilGeologyCode
     *            软土地质成相代码
     */
    public void setSoftsoilGeologyCode(String softsoilGeologyCode) {
        this.softsoilGeologyCode = softsoilGeologyCode;
    }

    /**
     * 软土地质成相
     * 
     * @return the softsoilGeology
     */
    @Column(length = 255)
    public String getSoftsoilGeology() {
        return this.softsoilGeology;
    }

    /**
     * 软土地质成相
     * 
     * @param softsoilGeology
     *            软土地质成相
     */
    public void setSoftsoilGeology(String softsoilGeology) {
        this.softsoilGeology = softsoilGeology;
    }

    /**
     * 软土路坡高小于等于3米
     * 
     * @return the lowThreeSoftsoilGrade
     */
    @Column(length = 14)
    public BigDecimal getLowThreeSoftsoilGrade() {
        return this.lowThreeSoftsoilGrade;
    }

    /**
     * 软土路坡高小于等于3米
     * 
     * @param lowThreeSoftsoilGrade
     *            软土路坡高小于等于3米
     */
    public void setLowThreeSoftsoilGrade(BigDecimal lowThreeSoftsoilGrade) {
        this.lowThreeSoftsoilGrade = lowThreeSoftsoilGrade;
    }

    /**
     * 软土路坡高大于等于3米
     * 
     * @return the highThreeSoftsoilGrade
     */
    @Column(length = 14)
    public BigDecimal getHighThreeSoftsoilGrade() {
        return this.highThreeSoftsoilGrade;
    }

    /**
     * 软土路坡高大于等于3米
     * 
     * @param highThreeSoftsoilGrade
     *            软土路坡高大于等于3米
     */
    public void setHighThreeSoftsoilGrade(BigDecimal highThreeSoftsoilGrade) {
        this.highThreeSoftsoilGrade = highThreeSoftsoilGrade;
    }

    /**
     * 有无软土路基
     * 
     * @return the softsoilRoadbedFlag
     */
    @Column(length = 255)
    public String getSoftsoilRoadbedFlag() {
        return this.softsoilRoadbedFlag;
    }

    /**
     * 有无软土路基
     * 
     * @param softsoilRoadbedFlag
     *            有无软土路基
     */
    public void setSoftsoilRoadbedFlag(String softsoilRoadbedFlag) {
        this.softsoilRoadbedFlag = softsoilRoadbedFlag;
    }

    /**
     * 软土地基处理代码
     * 
     * @return the softsoilRoadbedCode
     */
    @Column(length = 12)
    public String getSoftsoilRoadbedCode() {
        return this.softsoilRoadbedCode;
    }

    /**
     * 软土地基处理代码
     * 
     * @param softsoilRoadbedCode
     *            软土地基处理代码
     */
    public void setSoftsoilRoadbedCode(String softsoilRoadbedCode) {
        this.softsoilRoadbedCode = softsoilRoadbedCode;
    }

    /**
     * 软土地基处理
     * 
     * @return the softsoilRoadbed
     */
    @Column(length = 255)
    public String getSoftsoilRoadbed() {
        return this.softsoilRoadbed;
    }

    /**
     * 软土地基处理
     * 
     * @param softsoilRoadbed
     *            软土地基处理
     */
    public void setSoftsoilRoadbed(String softsoilRoadbed) {
        this.softsoilRoadbed = softsoilRoadbed;
    }

    /**
     * 其他软土地基处理说明
     * 
     * @return the elseSoftsoilRoadbedRmk
     */
    @Column(length = 500)
    public String getElseSoftsoilRoadbedRmk() {
        return this.elseSoftsoilRoadbedRmk;
    }

    /**
     * 其他软土地基处理说明
     * 
     * @param elseSoftsoilRoadbedRmk
     *            其他软土地基处理说明
     */
    public void setElseSoftsoilRoadbedRmk(String elseSoftsoilRoadbedRmk) {
        this.elseSoftsoilRoadbedRmk = elseSoftsoilRoadbedRmk;
    }

    /**
     * 道路施工备注
     * 
     * @return the roadRmk
     */
    @Column(length = 500)
    public String getRoadRmk() {
        return this.roadRmk;
    }

    /**
     * 道路施工备注
     * 
     * @param roadRmk
     *            道路施工备注
     */
    public void setRoadRmk(String roadRmk) {
        this.roadRmk = roadRmk;
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