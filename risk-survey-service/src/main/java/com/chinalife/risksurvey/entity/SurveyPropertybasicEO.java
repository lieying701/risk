package com.chinalife.risksurvey.entity;

import java.math.BigDecimal;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

import com.chinalife.spec.entity.InternalFixedActualEO;

/**
 * 财产险基本信息
 */
@Entity
@Table(name = "survey_propertybasic")
public class SurveyPropertybasicEO extends InternalFixedActualEO {

    /** 主键 */
    private String pkId;
    /** 外键 */
    private String rptId;
    /** 标的地址 */
    private String propAddress;
    /** 邮编 */
    private BigDecimal post;
    /** 经度 */
    private String longitude;
    /** 纬度 */
    private String latitude;
    /** 行业类型一级代码 */
    private String industryCategoryFstCode;
    /** 行业类型二级代码 */
    private String industryCategorySecCode;
    /** 行业类型三级代码 */
    private String industryCategoryCode;
    /** 行业类型一级名称 */
    private String industryCategoryFstName;
    /** 行业类型二级名称 */
    private String industryCategorySecName;
    /** 行业类型三级名称 */
    private String industryCategoryName;
    /** 工程地址 */
    private String constructAddress;
    /** 营业范围 */
    private String locationFirst;
    /** 企业性质代码 */
    private String enterpriseNatureCode;
    /** 企业性质 */
    private String enterpriseNatureName;
    /** 占用性质代码 */
    private String possessNatureCode;
    /** 占用性质 */
    private String possessNatureName;
    /** 开业年限 */
    private BigDecimal openYears;
    /** 周工作日 */
    private BigDecimal workDays;
    /** 员工总数 */
    private BigDecimal empTotalNum;
    /** 标的情况综述 */
    private String itemSummary;
    /** 创建员代码 */
    private String createUserID;
    /** 修改员代码 */
    private String updateUserID;
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
     * 标的地址
     * 
     * @return the propAddress
     */
    @Column(length = 500)
    public String getPropAddress() {
        return this.propAddress;
    }

    /**
     * 标的地址
     * 
     * @param propAddress
     *            标的地址
     */
    public void setPropAddress(String propAddress) {
        this.propAddress = propAddress;
    }

    /**
     * 邮编
     * 
     * @return the post
     */

    public BigDecimal getPost() {
        return this.post;
    }

    /**
     * 邮编
     * 
     * @param post
     *            邮编
     */
    public void setPost(BigDecimal post) {
        this.post = post;
    }

    /**
     * 经度
     * 
     * @return the longitude
     */
    @Column(length = 200)
    public String getLongitude() {
        return this.longitude;
    }

    /**
     * 经度
     * 
     * @param longitude
     *            经度
     */
    public void setLongitude(String longitude) {
        this.longitude = longitude;
    }

    /**
     * 纬度
     * 
     * @return the latitude
     */
    @Column(length = 200)
    public String getLatitude() {
        return this.latitude;
    }

    /**
     * 纬度
     * 
     * @param latitude
     *            纬度
     */
    public void setLatitude(String latitude) {
        this.latitude = latitude;
    }

    /**
     * 行业类型一级代码
     * 
     * @return the industryCategoryFstCode
     */
    @Column(length = 50)
    public String getIndustryCategoryFstCode() {
        return this.industryCategoryFstCode;
    }

    /**
     * 行业类型一级代码
     * 
     * @param industryCategoryFstCode
     *            行业类型一级代码
     */
    public void setIndustryCategoryFstCode(String industryCategoryFstCode) {
        this.industryCategoryFstCode = industryCategoryFstCode;
    }

    /**
     * 行业类型二级代码
     * 
     * @return the industryCategorySecCode
     */
    @Column(length = 50)
    public String getIndustryCategorySecCode() {
        return this.industryCategorySecCode;
    }

    /**
     * 行业类型二级代码
     * 
     * @param industryCategorySecCode
     *            行业类型二级代码
     */
    public void setIndustryCategorySecCode(String industryCategorySecCode) {
        this.industryCategorySecCode = industryCategorySecCode;
    }

    /**
     * 行业类型三级代码
     * 
     * @return the industryCategoryCode
     */
    @Column(length = 50)
    public String getIndustryCategoryCode() {
        return this.industryCategoryCode;
    }

    /**
     * 行业类型三级代码
     * 
     * @param industryCategoryCode
     *            行业类型三级代码
     */
    public void setIndustryCategoryCode(String industryCategoryCode) {
        this.industryCategoryCode = industryCategoryCode;
    }

    /**
     * 行业类型一级名称
     * 
     * @return the industryCategoryFstName
     */
    @Column(length = 500)
    public String getIndustryCategoryFstName() {
        return this.industryCategoryFstName;
    }

    /**
     * 行业类型一级名称
     * 
     * @param industryCategoryFstName
     *            行业类型一级名称
     */
    public void setIndustryCategoryFstName(String industryCategoryFstName) {
        this.industryCategoryFstName = industryCategoryFstName;
    }

    /**
     * 行业类型二级名称
     * 
     * @return the industryCategorySecName
     */
    @Column(length = 500)
    public String getIndustryCategorySecName() {
        return this.industryCategorySecName;
    }

    /**
     * 行业类型二级名称
     * 
     * @param industryCategorySecName
     *            行业类型二级名称
     */
    public void setIndustryCategorySecName(String industryCategorySecName) {
        this.industryCategorySecName = industryCategorySecName;
    }

    /**
     * 行业类型三级名称
     * 
     * @return the industryCategoryName
     */
    @Column(length = 500)
    public String getIndustryCategoryName() {
        return this.industryCategoryName;
    }

    /**
     * 行业类型三级名称
     * 
     * @param industryCategoryName
     *            行业类型三级名称
     */
    public void setIndustryCategoryName(String industryCategoryName) {
        this.industryCategoryName = industryCategoryName;
    }

    /**
     * 工程地址
     * 
     * @return the constructAddress
     */
    @Column(length = 500)
    public String getConstructAddress() {
        return this.constructAddress;
    }

    /**
     * 工程地址
     * 
     * @param constructAddress
     *            工程地址
     */
    public void setConstructAddress(String constructAddress) {
        this.constructAddress = constructAddress;
    }

    /**
     * 营业范围
     * 
     * @return the locationFirst
     */
    @Column(length = 500)
    public String getLocationFirst() {
        return this.locationFirst;
    }

    /**
     * 营业范围
     * 
     * @param locationFirst
     *            营业范围
     */
    public void setLocationFirst(String locationFirst) {
        this.locationFirst = locationFirst;
    }

    /**
     * 企业性质代码
     * 
     * @return the enterpriseNatureCode
     */
    @Column(length = 50)
    public String getEnterpriseNatureCode() {
        return this.enterpriseNatureCode;
    }

    /**
     * 企业性质代码
     * 
     * @param enterpriseNatureCode
     *            企业性质代码
     */
    public void setEnterpriseNatureCode(String enterpriseNatureCode) {
        this.enterpriseNatureCode = enterpriseNatureCode;
    }

    /**
     * 企业性质
     * 
     * @return the enterpriseNatureName
     */
    @Column(length = 255)
    public String getEnterpriseNatureName() {
        return this.enterpriseNatureName;
    }

    /**
     * 企业性质
     * 
     * @param enterpriseNatureName
     *            企业性质
     */
    public void setEnterpriseNatureName(String enterpriseNatureName) {
        this.enterpriseNatureName = enterpriseNatureName;
    }

    /**
     * 占用性质代码
     * 
     * @return the possessNatureCode
     */
    @Column(length = 50)
    public String getPossessNatureCode() {
        return this.possessNatureCode;
    }

    /**
     * 占用性质代码
     * 
     * @param possessNatureCode
     *            占用性质代码
     */
    public void setPossessNatureCode(String possessNatureCode) {
        this.possessNatureCode = possessNatureCode;
    }

    /**
     * 占用性质
     * 
     * @return the possessNatureName
     */
    @Column(length = 255)
    public String getPossessNatureName() {
        return this.possessNatureName;
    }

    /**
     * 占用性质
     * 
     * @param possessNatureName
     *            占用性质
     */
    public void setPossessNatureName(String possessNatureName) {
        this.possessNatureName = possessNatureName;
    }

    /**
     * 开业年限
     * 
     * @return the openYears
     */

    public BigDecimal getOpenYears() {
        return this.openYears;
    }

    /**
     * 开业年限
     * 
     * @param openYears
     *            开业年限
     */
    public void setOpenYears(BigDecimal openYears) {
        this.openYears = openYears;
    }

    /**
     * 周工作日
     * 
     * @return the workDays
     */

    public BigDecimal getWorkDays() {
        return this.workDays;
    }

    /**
     * 周工作日
     * 
     * @param workDays
     *            周工作日
     */
    public void setWorkDays(BigDecimal workDays) {
        this.workDays = workDays;
    }

    /**
     * 员工总数
     * 
     * @return the empTotalNum
     */

    public BigDecimal getEmpTotalNum() {
        return this.empTotalNum;
    }

    /**
     * 员工总数
     * 
     * @param empTotalNum
     *            员工总数
     */
    public void setEmpTotalNum(BigDecimal empTotalNum) {
        this.empTotalNum = empTotalNum;
    }

    /**
     * 标的情况综述
     * 
     * @return the itemSummary
     */
    @Column(length = 500)
    public String getItemSummary() {
        return this.itemSummary;
    }

    /**
     * 标的情况综述
     * 
     * @param itemSummary
     *            标的情况综述
     */
    public void setItemSummary(String itemSummary) {
        this.itemSummary = itemSummary;
    }

    /**
     * 创建员代码
     * 
     * @return the createUserID
     */
    @Column(length = 50)
    public String getCreateUserID() {
        return this.createUserID;
    }

    /**
     * 创建员代码
     * 
     * @param createUserID
     *            创建员代码
     */
    public void setCreateUserID(String createUserID) {
        this.createUserID = createUserID;
    }

    /**
     * 修改员代码
     * 
     * @return the updateUserID
     */
    @Column(length = 50)
    public String getUpdateUserID() {
        return this.updateUserID;
    }

    /**
     * 修改员代码
     * 
     * @param updateUserID
     *            修改员代码
     */
    public void setUpdateUserID(String updateUserID) {
        this.updateUserID = updateUserID;
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

}