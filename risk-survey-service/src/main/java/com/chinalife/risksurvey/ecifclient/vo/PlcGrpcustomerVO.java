package com.chinalife.risksurvey.ecifclient.vo;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

/**
 * 非自然人VO
 *
 * @author: marscheng
 * @date: 2017-12-02 下午4:13
 */
public class PlcGrpcustomerVO implements Serializable {
    /**
     *
     */
    private static final long serialVersionUID = -4255451286312022129L;

    /** 组织机构类型 */
    private String organizationType;
    /** 组织机构类型名称 */
    private String organizationName;
    /** 行业分类代码 */
    private String industryCategory;
    /** 行业分类名称 */
    private String industryCategoryName;
    /** 主营业务 */
    private String mainBussiness;
    /** 注册地址 */
    private String registyAddress;
    /** 所有权性质 */
    private String ownshipNature;
    /** 通信地址 */
    private String mailAddress;
    /** 通信地址所属邮编 */
    private String mailAddressPost;
    /** 法定代表人姓名 */
    private String applialeaderName;
    /** 法定代表人证件类型 */
    private String applialeaderType;
    /** 法定代表人证件类型名称 */
    private String applialeaderTypeName;
    /** 法定代表人证件号码 */
    private String applialeaderId;
    /** 参加社会统筹标志 */
    private String societyStatFlag;
    /** 团体社保登记号 */
    private String socialGrpInsuNo;
    /** 投保等级 */
    private String insuranceGrade;
    /** 重客等级 */
    private String mainCustomerGrade;
    /** 被保险人与受益人关联号 */
    private String linkNo;
    /** 受益人类型 */
    private String benefitType;
    /** 受益人类型名称 */
    private String benefitTypeName;
    /** 受益人顺序 */
    private String benefitSerialNo;
    /** 负责人姓名 */
    private String responsibleName;
    /** 负责人证件类型名称 */
    private String responsibleCerTypeName;
    /** 控股股东/实际控制人姓名 */
    private String shareholdersName;
    /** 传真 */
    private String facsimile;
    /** 控股股东/实际控制人证件类型名称 */
    private String shareholdersCerTypeName;
    /** 控股股东/实际控制人证件类型 */
    private String shareholdersCerType;
    /** 控股股东/实际控制人证件号码 */
    private String shareholdersCerNo;
    /** 注册所在地代码 */
    private String registeredPlaceCode;
    /** 注册所在地 */
    private String registeredPlace;
    /** 负责人证件类型 */
    private String responsibleCerType;
    /** 负责人证件号码 */
    private String responsibleCerNo;
    /** 税务登记证号 */
    private String taxRegistrationNo;
    /** 办公电话 */
    private String officePhone;
    /** 邮箱 */
    private String email;
    /** 手机号码 */
    private String mobile;
    /** 营业执照号码 */
    private String busiLicense;
    /** 受益比例 */
    private BigDecimal benefitRate;
    /** 负责人证件有效起期 */
    private Date responsibleCerStartDate;
    /** 负责人证件有效止期 */
    private Date responsibleCerEndDate;
    /** 法定代表人证件有效起始日期 */
    private Date applialeaderCerStartDate;
    /** 法定代表人证件有效终止日期 */
    private Date applialeaderCerEndDate;
    /** 控股股东/实际控制人证件有效起期 */
    private Date shareholdersCerStartDate;
    /** 控股股东/实际控制人证件有效止期 */
    private Date shareholdersCerEndDate;
    /** 营业执照有效起始日期 */
    private Date busiLicenseStartDate;
    /** 营业执照有效终止日期 */
    private Date busiLicenseEndDate;
    /** 创建员代码 */
    private String createUserId;
    /** 修改员代码 */
    private String updateUserId;
    /** 创建时间 */
    private Date createDate;
    /** 修改时间 */
    private Date updateDate;
    /** 机构ID */
    private String structureId;
    /** 所属人ID */
    private String ownerUserId;

    public String getOrganizationType() {
        return organizationType;
    }

    public void setOrganizationType(String organizationType) {
        this.organizationType = organizationType;
    }

    public String getOrganizationName() {
        return organizationName;
    }

    public void setOrganizationName(String organizationName) {
        this.organizationName = organizationName;
    }

    public String getIndustryCategory() {
        return industryCategory;
    }

    public void setIndustryCategory(String industryCategory) {
        this.industryCategory = industryCategory;
    }

    public String getIndustryCategoryName() {
        return industryCategoryName;
    }

    public void setIndustryCategoryName(String industryCategoryName) {
        this.industryCategoryName = industryCategoryName;
    }

    public String getMainBussiness() {
        return mainBussiness;
    }

    public void setMainBussiness(String mainBussiness) {
        this.mainBussiness = mainBussiness;
    }

    public String getRegistyAddress() {
        return registyAddress;
    }

    public void setRegistyAddress(String registyAddress) {
        this.registyAddress = registyAddress;
    }

    public String getOwnshipNature() {
        return ownshipNature;
    }

    public void setOwnshipNature(String ownshipNature) {
        this.ownshipNature = ownshipNature;
    }

    public String getMailAddress() {
        return mailAddress;
    }

    public void setMailAddress(String mailAddress) {
        this.mailAddress = mailAddress;
    }

    public String getMailAddressPost() {
        return mailAddressPost;
    }

    public void setMailAddressPost(String mailAddressPost) {
        this.mailAddressPost = mailAddressPost;
    }

    public String getApplialeaderName() {
        return applialeaderName;
    }

    public void setApplialeaderName(String applialeaderName) {
        this.applialeaderName = applialeaderName;
    }

    public String getApplialeaderType() {
        return applialeaderType;
    }

    public void setApplialeaderType(String applialeaderType) {
        this.applialeaderType = applialeaderType;
    }

    public String getApplialeaderTypeName() {
        return applialeaderTypeName;
    }

    public void setApplialeaderTypeName(String applialeaderTypeName) {
        this.applialeaderTypeName = applialeaderTypeName;
    }

    public String getApplialeaderId() {
        return applialeaderId;
    }

    public void setApplialeaderId(String applialeaderId) {
        this.applialeaderId = applialeaderId;
    }

    public String getSocietyStatFlag() {
        return societyStatFlag;
    }

    public void setSocietyStatFlag(String societyStatFlag) {
        this.societyStatFlag = societyStatFlag;
    }

    public String getSocialGrpInsuNo() {
        return socialGrpInsuNo;
    }

    public void setSocialGrpInsuNo(String socialGrpInsuNo) {
        this.socialGrpInsuNo = socialGrpInsuNo;
    }

    public String getInsuranceGrade() {
        return insuranceGrade;
    }

    public void setInsuranceGrade(String insuranceGrade) {
        this.insuranceGrade = insuranceGrade;
    }

    public String getMainCustomerGrade() {
        return mainCustomerGrade;
    }

    public void setMainCustomerGrade(String mainCustomerGrade) {
        this.mainCustomerGrade = mainCustomerGrade;
    }

    public String getLinkNo() {
        return linkNo;
    }

    public void setLinkNo(String linkNo) {
        this.linkNo = linkNo;
    }

    public String getBenefitType() {
        return benefitType;
    }

    public void setBenefitType(String benefitType) {
        this.benefitType = benefitType;
    }

    public String getBenefitTypeName() {
        return benefitTypeName;
    }

    public void setBenefitTypeName(String benefitTypeName) {
        this.benefitTypeName = benefitTypeName;
    }

    public String getBenefitSerialNo() {
        return benefitSerialNo;
    }

    public void setBenefitSerialNo(String benefitSerialNo) {
        this.benefitSerialNo = benefitSerialNo;
    }

    public BigDecimal getBenefitRate() {
        return benefitRate;
    }

    public void setBenefitRate(BigDecimal benefitRate) {
        this.benefitRate = benefitRate;
    }

    public String getCreateUserId() {
        return createUserId;
    }

    public void setCreateUserId(String createUserId) {
        this.createUserId = createUserId;
    }

    public String getUpdateUserId() {
        return updateUserId;
    }

    public void setUpdateUserId(String updateUserId) {
        this.updateUserId = updateUserId;
    }

    public Date getCreateDate() {
        return createDate;
    }

    public void setCreateDate(Date createDate) {
        this.createDate = createDate;
    }

    public Date getUpdateDate() {
        return updateDate;
    }

    public void setUpdateDate(Date updateDate) {
        this.updateDate = updateDate;
    }

    public String getStructureId() {
        return structureId;
    }

    public void setStructureId(String structureId) {
        this.structureId = structureId;
    }

    public String getOwnerUserId() {
        return ownerUserId;
    }

    public void setOwnerUserId(String ownerUserId) {
        this.ownerUserId = ownerUserId;
    }

    public String getResponsibleName() {
        return responsibleName;
    }

    public void setResponsibleName(String responsibleName) {
        this.responsibleName = responsibleName;
    }

    public String getResponsibleCerTypeName() {
        return responsibleCerTypeName;
    }

    public void setResponsibleCerTypeName(String responsibleCerTypeName) {
        this.responsibleCerTypeName = responsibleCerTypeName;
    }

    public String getShareholdersName() {
        return shareholdersName;
    }

    public void setShareholdersName(String shareholdersName) {
        this.shareholdersName = shareholdersName;
    }

    public String getFacsimile() {
        return facsimile;
    }

    public void setFacsimile(String facsimile) {
        this.facsimile = facsimile;
    }

    public String getShareholdersCerTypeName() {
        return shareholdersCerTypeName;
    }

    public void setShareholdersCerTypeName(String shareholdersCerTypeName) {
        this.shareholdersCerTypeName = shareholdersCerTypeName;
    }

    public String getShareholdersCerType() {
        return shareholdersCerType;
    }

    public void setShareholdersCerType(String shareholdersCerType) {
        this.shareholdersCerType = shareholdersCerType;
    }

    public String getShareholdersCerNo() {
        return shareholdersCerNo;
    }

    public void setShareholdersCerNo(String shareholdersCerNo) {
        this.shareholdersCerNo = shareholdersCerNo;
    }

    public String getRegisteredPlaceCode() {
        return registeredPlaceCode;
    }

    public void setRegisteredPlaceCode(String registeredPlaceCode) {
        this.registeredPlaceCode = registeredPlaceCode;
    }

    public String getRegisteredPlace() {
        return registeredPlace;
    }

    public void setRegisteredPlace(String registeredPlace) {
        this.registeredPlace = registeredPlace;
    }

    public String getResponsibleCerType() {
        return responsibleCerType;
    }

    public void setResponsibleCerType(String responsibleCerType) {
        this.responsibleCerType = responsibleCerType;
    }

    public String getResponsibleCerNo() {
        return responsibleCerNo;
    }

    public void setResponsibleCerNo(String responsibleCerNo) {
        this.responsibleCerNo = responsibleCerNo;
    }

    public String getTaxRegistrationNo() {
        return taxRegistrationNo;
    }

    public void setTaxRegistrationNo(String taxRegistrationNo) {
        this.taxRegistrationNo = taxRegistrationNo;
    }

    public String getOfficePhone() {
        return officePhone;
    }

    public void setOfficePhone(String officePhone) {
        this.officePhone = officePhone;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getMobile() {
        return mobile;
    }

    public void setMobile(String mobile) {
        this.mobile = mobile;
    }

    public String getBusiLicense() {
        return busiLicense;
    }

    public void setBusiLicense(String busiLicense) {
        this.busiLicense = busiLicense;
    }

    public Date getResponsibleCerStartDate() {
        return responsibleCerStartDate;
    }

    public void setResponsibleCerStartDate(Date responsibleCerStartDate) {
        this.responsibleCerStartDate = responsibleCerStartDate;
    }

    public Date getResponsibleCerEndDate() {
        return responsibleCerEndDate;
    }

    public void setResponsibleCerEndDate(Date responsibleCerEndDate) {
        this.responsibleCerEndDate = responsibleCerEndDate;
    }

    public Date getApplialeaderCerStartDate() {
        return applialeaderCerStartDate;
    }

    public void setApplialeaderCerStartDate(Date applialeaderCerStartDate) {
        this.applialeaderCerStartDate = applialeaderCerStartDate;
    }

    public Date getApplialeaderCerEndDate() {
        return applialeaderCerEndDate;
    }

    public void setApplialeaderCerEndDate(Date applialeaderCerEndDate) {
        this.applialeaderCerEndDate = applialeaderCerEndDate;
    }

    public Date getShareholdersCerStartDate() {
        return shareholdersCerStartDate;
    }

    public void setShareholdersCerStartDate(Date shareholdersCerStartDate) {
        this.shareholdersCerStartDate = shareholdersCerStartDate;
    }

    public Date getShareholdersCerEndDate() {
        return shareholdersCerEndDate;
    }

    public void setShareholdersCerEndDate(Date shareholdersCerEndDate) {
        this.shareholdersCerEndDate = shareholdersCerEndDate;
    }

    public Date getBusiLicenseStartDate() {
        return busiLicenseStartDate;
    }

    public void setBusiLicenseStartDate(Date busiLicenseStartDate) {
        this.busiLicenseStartDate = busiLicenseStartDate;
    }

    public Date getBusiLicenseEndDate() {
        return busiLicenseEndDate;
    }

    public void setBusiLicenseEndDate(Date busiLicenseEndDate) {
        this.busiLicenseEndDate = busiLicenseEndDate;
    }
}
