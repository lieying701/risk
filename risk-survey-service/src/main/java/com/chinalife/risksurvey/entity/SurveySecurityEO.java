package com.chinalife.risksurvey.entity;

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
 * 保安状况
 */
@Entity
@Table(name = "survey_security")
public class SurveySecurityEO extends AbstractBaseEntity {

    /**
     * serialVersionUID
     */
    private static final long serialVersionUID = -7402724181568688363L;
    /** 主键 */
    private String pkId;
    /** 外键 */
    private String rptId;
    /** 是否有足够执勤保安 */
    private String enoughSecurityFlag;
    /** 是否24小时值班 */
    private String hour24DutyFlag;
    /** 是否有健全的值班记录 */
    private String enoughDutyRecordFlag;
    /** 是否有围墙及监控设备 */
    private String miniorEquipmentFlag;
    /** 保安状况备注 */
    private String securityRmk;
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
     * 是否有足够执勤保安
     * 
     * @return the enoughSecurityFlag
     */
    @Column(length = 12)
    public String getEnoughSecurityFlag() {
        return this.enoughSecurityFlag;
    }

    /**
     * 是否有足够执勤保安
     * 
     * @param enoughSecurityFlag
     *            是否有足够执勤保安
     */
    public void setEnoughSecurityFlag(String enoughSecurityFlag) {
        this.enoughSecurityFlag = enoughSecurityFlag;
    }

    /**
     * 是否24小时值班
     * 
     * @return the 24HourDutyFlag
     */
    @Column(length = 12)
    public String get24HourDutyFlag() {
        return this.hour24DutyFlag;
    }

    /**
     * 是否24小时值班
     * 
     * @param hour24DutyFlag
     *            是否24小时值班
     */
    public void set24HourDutyFlag(String hour24DutyFlag) {
        this.hour24DutyFlag = hour24DutyFlag;
    }

    /**
     * 是否有健全的值班记录
     * 
     * @return the enoughDutyRecordFlag
     */
    @Column(length = 12)
    public String getEnoughDutyRecordFlag() {
        return this.enoughDutyRecordFlag;
    }

    /**
     * 是否有健全的值班记录
     * 
     * @param enoughDutyRecordFlag
     *            是否有健全的值班记录
     */
    public void setEnoughDutyRecordFlag(String enoughDutyRecordFlag) {
        this.enoughDutyRecordFlag = enoughDutyRecordFlag;
    }

    /**
     * 是否有围墙及监控设备
     * 
     * @return the miniorEquipmentFlag
     */
    @Column(length = 12)
    public String getMiniorEquipmentFlag() {
        return this.miniorEquipmentFlag;
    }

    /**
     * 是否有围墙及监控设备
     * 
     * @param miniorEquipmentFlag
     *            是否有围墙及监控设备
     */
    public void setMiniorEquipmentFlag(String miniorEquipmentFlag) {
        this.miniorEquipmentFlag = miniorEquipmentFlag;
    }

    /**
     * 保安状况备注
     * 
     * @return the securityRmk
     */
    @Column(length = 500)
    public String getSecurityRmk() {
        return this.securityRmk;
    }

    /**
     * 保安状况备注
     * 
     * @param securityRmk
     *            保安状况备注
     */
    public void setSecurityRmk(String securityRmk) {
        this.securityRmk = securityRmk;
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