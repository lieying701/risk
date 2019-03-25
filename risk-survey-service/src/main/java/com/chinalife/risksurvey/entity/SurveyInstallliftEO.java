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
 * 吊装工程情况
 */
@Entity
@Table(name = "survey_installlift")
public class SurveyInstallliftEO extends AbstractBaseEntity {

    /**
     * serialVersionUID
     */
    private static final long serialVersionUID = -1104740874575913973L;
    /** 主键 */
    private String pkId;
    /** 外键 */
    private String rptId;
    /** 序号 */
    private BigDecimal num;
    /** 主要设备重量 */
    private String mainEquipWeight;
    /** 主要设备尺寸 */
    private String mainEquipSize;
    /** 吊装设备参数 */
    private String liftEquipParam;
    /** 是否有吊装倾覆验算 */
    private String overturnCheckFlag;
    /** 人员是否具备资质 */
    private String personQualifiedFlag;
    /** 吊装操作预案 */
    private String liftOperPlan;
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
     * 主要设备重量
     * 
     * @return the mainEquipWeight
     */
    @Column(length = 255)
    public String getMainEquipWeight() {
        return this.mainEquipWeight;
    }

    /**
     * 主要设备重量
     * 
     * @param mainEquipWeight
     *            主要设备重量
     */
    public void setMainEquipWeight(String mainEquipWeight) {
        this.mainEquipWeight = mainEquipWeight;
    }

    /**
     * 主要设备尺寸
     * 
     * @return the mainEquipSize
     */
    @Column(length = 255)
    public String getMainEquipSize() {
        return this.mainEquipSize;
    }

    /**
     * 主要设备尺寸
     * 
     * @param mainEquipSize
     *            主要设备尺寸
     */
    public void setMainEquipSize(String mainEquipSize) {
        this.mainEquipSize = mainEquipSize;
    }

    /**
     * 吊装设备参数
     * 
     * @return the liftEquipParam
     */
    @Column(length = 255)
    public String getLiftEquipParam() {
        return this.liftEquipParam;
    }

    /**
     * 吊装设备参数
     * 
     * @param liftEquipParam
     *            吊装设备参数
     */
    public void setLiftEquipParam(String liftEquipParam) {
        this.liftEquipParam = liftEquipParam;
    }

    /**
     * 是否有吊装倾覆验算
     * 
     * @return the overturnCheckFlag
     */
    @Column(length = 12)
    public String getOverturnCheckFlag() {
        return this.overturnCheckFlag;
    }

    /**
     * 是否有吊装倾覆验算
     * 
     * @param overturnCheckFlag
     *            是否有吊装倾覆验算
     */
    public void setOverturnCheckFlag(String overturnCheckFlag) {
        this.overturnCheckFlag = overturnCheckFlag;
    }

    /**
     * 人员是否具备资质
     * 
     * @return the personQualifiedFlag
     */
    @Column(length = 12)
    public String getPersonQualifiedFlag() {
        return this.personQualifiedFlag;
    }

    /**
     * 人员是否具备资质
     * 
     * @param personQualifiedFlag
     *            人员是否具备资质
     */
    public void setPersonQualifiedFlag(String personQualifiedFlag) {
        this.personQualifiedFlag = personQualifiedFlag;
    }

    /**
     * 吊装操作预案
     * 
     * @return the liftOperPlan
     */
    @Column(length = 500)
    public String getLiftOperPlan() {
        return this.liftOperPlan;
    }

    /**
     * 吊装操作预案
     * 
     * @param liftOperPlan
     *            吊装操作预案
     */
    public void setLiftOperPlan(String liftOperPlan) {
        this.liftOperPlan = liftOperPlan;
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