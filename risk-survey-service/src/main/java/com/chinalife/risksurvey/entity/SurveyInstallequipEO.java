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
 * 主要设备生产线情况
 */
@Entity
@Table(name = "survey_installequip")
public class SurveyInstallequipEO extends AbstractBaseEntity {

    /**
     * serialVersionUID
     */
    private static final long serialVersionUID = -5936861671454829705L;
    /** 主键 */
    private String pkId;
    /** 外键 */
    private String rptId;
    /** 序号 */
    private BigDecimal num;
    /** 主要设备名称 */
    private String mainEquipName;
    /** 设备型号 */
    private String equipModel;
    /** 主要设备参数 */
    private String mainEquipParam;
    /** 单项造价 */
    private BigDecimal singleItemAmount;
    /** 制造商名称 */
    private BigDecimal manufacturer;
    /** 生产日期 */
    private Date produceTime;
    /** 设备价值 */
    private BigDecimal equipValue;
    /** 设备数量 */
    private BigDecimal equipNum;
    /** 是否属新设计设备 */
    private String newDesignEquipFlag;
    /** 是否在质量保证期内 */
    private String inGuaranteePeriodFlag;
    /** 是否淘汰设备 */
    private String eliminateEquipFlag;
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
     * 主要设备名称
     * 
     * @return the mainEquipName
     */
    @Column(length = 500)
    public String getMainEquipName() {
        return this.mainEquipName;
    }

    /**
     * 主要设备名称
     * 
     * @param mainEquipName
     *            主要设备名称
     */
    public void setMainEquipName(String mainEquipName) {
        this.mainEquipName = mainEquipName;
    }

    /**
     * 设备型号
     * 
     * @return the equipModel
     */
    @Column(length = 255)
    public String getEquipModel() {
        return this.equipModel;
    }

    /**
     * 设备型号
     * 
     * @param equipModel
     *            设备型号
     */
    public void setEquipModel(String equipModel) {
        this.equipModel = equipModel;
    }

    /**
     * 主要设备参数
     * 
     * @return the mainEquipParam
     */
    @Column(length = 255)
    public String getMainEquipParam() {
        return this.mainEquipParam;
    }

    /**
     * 主要设备参数
     * 
     * @param mainEquipParam
     *            主要设备参数
     */
    public void setMainEquipParam(String mainEquipParam) {
        this.mainEquipParam = mainEquipParam;
    }

    /**
     * 单项造价
     * 
     * @return the singleItemAmount
     */
    @Column(length = 14)
    public BigDecimal getSingleItemAmount() {
        return this.singleItemAmount;
    }

    /**
     * 单项造价
     * 
     * @param singleItemAmount
     *            单项造价
     */
    public void setSingleItemAmount(BigDecimal singleItemAmount) {
        this.singleItemAmount = singleItemAmount;
    }

    /**
     * 制造商名称
     * 
     * @return the manufacturer
     */
    @Column(length = 14)
    public BigDecimal getManufacturer() {
        return this.manufacturer;
    }

    /**
     * 制造商名称
     * 
     * @param manufacturer
     *            制造商名称
     */
    public void setManufacturer(BigDecimal manufacturer) {
        this.manufacturer = manufacturer;
    }

    /**
     * 生产日期
     * 
     * @return the produceTime
     */

    public Date getProduceTime() {
        return this.produceTime;
    }

    /**
     * 生产日期
     * 
     * @param produceTime
     *            生产日期
     */
    public void setProduceTime(Date produceTime) {
        this.produceTime = produceTime;
    }

    /**
     * 设备价值
     * 
     * @return the equipValue
     */
    @Column(length = 14)
    public BigDecimal getEquipValue() {
        return this.equipValue;
    }

    /**
     * 设备价值
     * 
     * @param equipValue
     *            设备价值
     */
    public void setEquipValue(BigDecimal equipValue) {
        this.equipValue = equipValue;
    }

    /**
     * 设备数量
     * 
     * @return the equipNum
     */

    public BigDecimal getEquipNum() {
        return this.equipNum;
    }

    /**
     * 设备数量
     * 
     * @param equipNum
     *            设备数量
     */
    public void setEquipNum(BigDecimal equipNum) {
        this.equipNum = equipNum;
    }

    /**
     * 是否属新设计设备
     * 
     * @return the newDesignEquipFlag
     */
    @Column(length = 12)
    public String getNewDesignEquipFlag() {
        return this.newDesignEquipFlag;
    }

    /**
     * 是否属新设计设备
     * 
     * @param newDesignEquipFlag
     *            是否属新设计设备
     */
    public void setNewDesignEquipFlag(String newDesignEquipFlag) {
        this.newDesignEquipFlag = newDesignEquipFlag;
    }

    /**
     * 是否在质量保证期内
     * 
     * @return the inGuaranteePeriodFlag
     */
    @Column(length = 12)
    public String getInGuaranteePeriodFlag() {
        return this.inGuaranteePeriodFlag;
    }

    /**
     * 是否在质量保证期内
     * 
     * @param inGuaranteePeriodFlag
     *            是否在质量保证期内
     */
    public void setInGuaranteePeriodFlag(String inGuaranteePeriodFlag) {
        this.inGuaranteePeriodFlag = inGuaranteePeriodFlag;
    }

    /**
     * 是否淘汰设备
     * 
     * @return the eliminateEquipFlag
     */
    @Column(length = 12)
    public String getEliminateEquipFlag() {
        return this.eliminateEquipFlag;
    }

    /**
     * 是否淘汰设备
     * 
     * @param eliminateEquipFlag
     *            是否淘汰设备
     */
    public void setEliminateEquipFlag(String eliminateEquipFlag) {
        this.eliminateEquipFlag = eliminateEquipFlag;
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