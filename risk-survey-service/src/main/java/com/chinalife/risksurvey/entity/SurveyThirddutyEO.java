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
 * 第三者责任风险
 */
@Entity
@Table(name = "survey_thirdduty")
public class SurveyThirddutyEO extends AbstractBaseEntity {

    /**
     * serialVersionUID
     */
    private static final long serialVersionUID = -1208869082428723236L;
    /** 主键 */
    private String pkId;
    /** 外键 */
    private String rptId;
    /** 序号 */
    private BigDecimal num;
    /** 周围建筑类型代码 */
    private String surroundBuildTypeCode;
    /** 周围建筑类型 */
    private String surroundBuildType;
    /** 其他周围建筑类型 */
    private String elseSurroundBuildType;
    /** 周边建筑结构类型和高度 */
    private String structureTypeAndHeight;
    /** 人流车流密集程度 */
    private String trafficDensity;
    /** 距离最近建筑/道路的距离 */
    private BigDecimal nearestBuildDistance;
    /** 周围地下管线代码 */
    private String ugPipelinesTypeCode;
    /** 周围地下管线 */
    private String ugPipelinesType;
    /** 其他周围地下管线 */
    private String elseugPipelinesType;
    /** 管线与工程之间的最近距离 */
    private BigDecimal distanceFromProject;
    /** 管线深埋 */
    private BigDecimal pipelineBuryDepth;
    /** 管线有工程的相对位置 */
    private String relativePositionCode;
    /** 有无爆破作业 */
    private String blastingOperateFlag;
    /** 针对三者责任的监控措施 */
    private String thirdMinitorMethod;
    /** 针对三者责任防灾防损措预案 */
    private String thirdDisasterPrevention;
    /** 是否设置警告标志 */
    private String hangWarnFlag;
    /** 是否会影响第三者财产 */
    private String affectThirdPropFlag;
    /** 第三者责任风险备注 */
    private String thirddutyRmk;
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
     * 周围建筑类型代码
     * 
     * @return the surroundBuildTypeCode
     */
    @Column(length = 12)
    public String getSurroundBuildTypeCode() {
        return this.surroundBuildTypeCode;
    }

    /**
     * 周围建筑类型代码
     * 
     * @param surroundBuildTypeCode
     *            周围建筑类型代码
     */
    public void setSurroundBuildTypeCode(String surroundBuildTypeCode) {
        this.surroundBuildTypeCode = surroundBuildTypeCode;
    }

    /**
     * 周围建筑类型
     * 
     * @return the surroundBuildType
     */
    @Column(length = 120)
    public String getSurroundBuildType() {
        return this.surroundBuildType;
    }

    /**
     * 周围建筑类型
     * 
     * @param surroundBuildType
     *            周围建筑类型
     */
    public void setSurroundBuildType(String surroundBuildType) {
        this.surroundBuildType = surroundBuildType;
    }

    /**
     * 其他周围建筑类型
     * 
     * @return the elseSurroundBuildType
     */
    @Column(length = 500)
    public String getElseSurroundBuildType() {
        return this.elseSurroundBuildType;
    }

    /**
     * 其他周围建筑类型
     * 
     * @param elseSurroundBuildType
     *            其他周围建筑类型
     */
    public void setElseSurroundBuildType(String elseSurroundBuildType) {
        this.elseSurroundBuildType = elseSurroundBuildType;
    }

    /**
     * 周边建筑结构类型和高度
     * 
     * @return the structureTypeAndHeight
     */
    @Column(length = 500)
    public String getStructureTypeAndHeight() {
        return this.structureTypeAndHeight;
    }

    /**
     * 周边建筑结构类型和高度
     * 
     * @param structureTypeAndHeight
     *            周边建筑结构类型和高度
     */
    public void setStructureTypeAndHeight(String structureTypeAndHeight) {
        this.structureTypeAndHeight = structureTypeAndHeight;
    }

    /**
     * 人流车流密集程度
     * 
     * @return the trafficDensity
     */
    @Column(length = 500)
    public String getTrafficDensity() {
        return this.trafficDensity;
    }

    /**
     * 人流车流密集程度
     * 
     * @param trafficDensity
     *            人流车流密集程度
     */
    public void setTrafficDensity(String trafficDensity) {
        this.trafficDensity = trafficDensity;
    }

    /**
     * 距离最近建筑/道路的距离
     * 
     * @return the nearestBuildDistance
     */
    @Column(length = 14)
    public BigDecimal getNearestBuildDistance() {
        return this.nearestBuildDistance;
    }

    /**
     * 距离最近建筑/道路的距离
     * 
     * @param nearestBuildDistance
     *            距离最近建筑/道路的距离
     */
    public void setNearestBuildDistance(BigDecimal nearestBuildDistance) {
        this.nearestBuildDistance = nearestBuildDistance;
    }

    /**
     * 周围地下管线代码
     * 
     * @return the ugPipelinesTypeCode
     */
    @Column(length = 12)
    public String getUgPipelinesTypeCode() {
        return this.ugPipelinesTypeCode;
    }

    /**
     * 周围地下管线代码
     * 
     * @param ugPipelinesTypeCode
     *            周围地下管线代码
     */
    public void setUgPipelinesTypeCode(String ugPipelinesTypeCode) {
        this.ugPipelinesTypeCode = ugPipelinesTypeCode;
    }

    /**
     * 周围地下管线
     * 
     * @return the ugPipelinesType
     */
    @Column(length = 120)
    public String getUgPipelinesType() {
        return this.ugPipelinesType;
    }

    /**
     * 周围地下管线
     * 
     * @param ugPipelinesType
     *            周围地下管线
     */
    public void setUgPipelinesType(String ugPipelinesType) {
        this.ugPipelinesType = ugPipelinesType;
    }

    /**
     * 其他周围地下管线
     * 
     * @return the elseugPipelinesType
     */
    @Column(length = 500)
    public String getElseugPipelinesType() {
        return this.elseugPipelinesType;
    }

    /**
     * 其他周围地下管线
     * 
     * @param elseugPipelinesType
     *            其他周围地下管线
     */
    public void setElseugPipelinesType(String elseugPipelinesType) {
        this.elseugPipelinesType = elseugPipelinesType;
    }

    /**
     * 管线与工程之间的最近距离
     * 
     * @return the distanceFromProject
     */
    @Column(length = 14)
    public BigDecimal getDistanceFromProject() {
        return this.distanceFromProject;
    }

    /**
     * 管线与工程之间的最近距离
     * 
     * @param distanceFromProject
     *            管线与工程之间的最近距离
     */
    public void setDistanceFromProject(BigDecimal distanceFromProject) {
        this.distanceFromProject = distanceFromProject;
    }

    /**
     * 管线深埋
     * 
     * @return the pipelineBuryDepth
     */
    @Column(length = 14)
    public BigDecimal getPipelineBuryDepth() {
        return this.pipelineBuryDepth;
    }

    /**
     * 管线深埋
     * 
     * @param pipelineBuryDepth
     *            管线深埋
     */
    public void setPipelineBuryDepth(BigDecimal pipelineBuryDepth) {
        this.pipelineBuryDepth = pipelineBuryDepth;
    }

    /**
     * 管线有工程的相对位置
     * 
     * @return the relativePositionCode
     */
    @Column(length = 12)
    public String getRelativePositionCode() {
        return this.relativePositionCode;
    }

    /**
     * 管线有工程的相对位置
     * 
     * @param relativePositionCode
     *            管线有工程的相对位置
     */
    public void setRelativePositionCode(String relativePositionCode) {
        this.relativePositionCode = relativePositionCode;
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
     * 针对三者责任的监控措施
     * 
     * @return the thirdMinitorMethod
     */
    @Column(length = 500)
    public String getThirdMinitorMethod() {
        return this.thirdMinitorMethod;
    }

    /**
     * 针对三者责任的监控措施
     * 
     * @param thirdMinitorMethod
     *            针对三者责任的监控措施
     */
    public void setThirdMinitorMethod(String thirdMinitorMethod) {
        this.thirdMinitorMethod = thirdMinitorMethod;
    }

    /**
     * 针对三者责任防灾防损措预案
     * 
     * @return the thirdDisasterPrevention
     */
    @Column(length = 500)
    public String getThirdDisasterPrevention() {
        return this.thirdDisasterPrevention;
    }

    /**
     * 针对三者责任防灾防损措预案
     * 
     * @param thirdDisasterPrevention
     *            针对三者责任防灾防损措预案
     */
    public void setThirdDisasterPrevention(String thirdDisasterPrevention) {
        this.thirdDisasterPrevention = thirdDisasterPrevention;
    }

    /**
     * 是否设置警告标志
     * 
     * @return the hangWarnFlag
     */
    @Column(length = 12)
    public String getHangWarnFlag() {
        return this.hangWarnFlag;
    }

    /**
     * 是否设置警告标志
     * 
     * @param hangWarnFlag
     *            是否设置警告标志
     */
    public void setHangWarnFlag(String hangWarnFlag) {
        this.hangWarnFlag = hangWarnFlag;
    }

    /**
     * 是否会影响第三者财产
     * 
     * @return the affectThirdPropFlag
     */
    @Column(length = 12)
    public String getAffectThirdPropFlag() {
        return this.affectThirdPropFlag;
    }

    /**
     * 是否会影响第三者财产
     * 
     * @param affectThirdPropFlag
     *            是否会影响第三者财产
     */
    public void setAffectThirdPropFlag(String affectThirdPropFlag) {
        this.affectThirdPropFlag = affectThirdPropFlag;
    }

    /**
     * 第三者责任风险备注
     * 
     * @return the thirddutyRmk
     */
    @Column(length = 500)
    public String getThirddutyRmk() {
        return this.thirddutyRmk;
    }

    /**
     * 第三者责任风险备注
     * 
     * @param thirddutyRmk
     *            第三者责任风险备注
     */
    public void setThirddutyRmk(String thirddutyRmk) {
        this.thirddutyRmk = thirddutyRmk;
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