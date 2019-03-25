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
 * 工艺流程
 */
@Entity
@Table(name = "survey_installtech")
public class SurveyInstalltechEO extends AbstractBaseEntity {

    /**
     * serialVersionUID
     */
    private static final long serialVersionUID = 728457468996830155L;
    /** 主键 */
    private String pkId;
    /** 外键 */
    private String rptId;
    /** 序号 */
    private BigDecimal num;
    /** 工艺流程简介 */
    private String techFlowRmk;
    /** 有无高温高压设备 */
    private String highTempEquipFlag;
    /** 设备名称 */
    private String equipmentName;
    /** 压力 */
    private BigDecimal pressure;
    /** 温度 */
    private BigDecimal temperature;
    /** 易损部位 */
    private String easyDamagePart;
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
     * 工艺流程简介
     * 
     * @return the techFlowRmk
     */
    @Column(length = 500)
    public String getTechFlowRmk() {
        return this.techFlowRmk;
    }

    /**
     * 工艺流程简介
     * 
     * @param techFlowRmk
     *            工艺流程简介
     */
    public void setTechFlowRmk(String techFlowRmk) {
        this.techFlowRmk = techFlowRmk;
    }

    /**
     * 有无高温高压设备
     * 
     * @return the highTempEquipFlag
     */
    @Column(length = 12)
    public String getHighTempEquipFlag() {
        return this.highTempEquipFlag;
    }

    /**
     * 有无高温高压设备
     * 
     * @param highTempEquipFlag
     *            有无高温高压设备
     */
    public void setHighTempEquipFlag(String highTempEquipFlag) {
        this.highTempEquipFlag = highTempEquipFlag;
    }

    /**
     * 设备名称
     * 
     * @return the equipmentName
     */
    @Column(length = 255)
    public String getEquipmentName() {
        return this.equipmentName;
    }

    /**
     * 设备名称
     * 
     * @param equipmentName
     *            设备名称
     */
    public void setEquipmentName(String equipmentName) {
        this.equipmentName = equipmentName;
    }

    /**
     * 压力
     * 
     * @return the pressure
     */
    @Column(length = 14)
    public BigDecimal getPressure() {
        return this.pressure;
    }

    /**
     * 压力
     * 
     * @param pressure
     *            压力
     */
    public void setPressure(BigDecimal pressure) {
        this.pressure = pressure;
    }

    /**
     * 温度
     * 
     * @return the temperature
     */
    @Column(length = 14)
    public BigDecimal getTemperature() {
        return this.temperature;
    }

    /**
     * 温度
     * 
     * @param temperature
     *            温度
     */
    public void setTemperature(BigDecimal temperature) {
        this.temperature = temperature;
    }

    /**
     * 易损部位
     * 
     * @return the easyDamagePart
     */
    @Column(length = 500)
    public String getEasyDamagePart() {
        return this.easyDamagePart;
    }

    /**
     * 易损部位
     * 
     * @param easyDamagePart
     *            易损部位
     */
    public void setEasyDamagePart(String easyDamagePart) {
        this.easyDamagePart = easyDamagePart;
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