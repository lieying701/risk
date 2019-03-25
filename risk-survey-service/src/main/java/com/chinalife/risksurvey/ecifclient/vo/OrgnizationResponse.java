package com.chinalife.risksurvey.ecifclient.vo;

import java.io.Serializable;

/**
 * @Description: 单条组织信息
 * @author: marscheng
 * @date: 2017年10月13日 下午4:41:20
 */
public class OrgnizationResponse implements Serializable {

    /**
     * @Fields serialVersionUID : TODO
     */
    private static final long serialVersionUID = -7470107052776368293L;
    /**
     * 客户代码
     */
    private String customerCode;
    /**
     * 客户名称
     */
    private String customerName;

    /**
     * 客户英文名称
     */
    private String customerEName;
    /**
     * 机构类型代码
     */
    private String organizationType;
    /**
     * 行业类型代码
     */
    private String industryCategory;
    /**
     * 经营范围
     */
    private String mainBusiness;
    /**
     * 经济类型代码
     */
    private String economicTypeCode;
    /**
     * 营业执照号码
     */
    private String busilicense;

    /**
     * 营业执照有效起期
     */
    private String busiLicenseStartDate;

    /**
     * 营业执照有效止期
     */
    private String busiLicenseEndDate;
    /**
     * 税务登记号码(国税)
     */
    private String taxregistrationNo;

    /**
     * 机构人数
     */
    private Long organizationPeopleNumber;

    /**
     * 注册所在地
     */
    private String registeredPlaceCode;
    
    
    /**
     * 注册所在地Name
     */
    private String registeredPlaceName;
    
    /**
     * 注册地址
     */
    private String registyAddress;
    /**
     * 通信地址
     */
    private String mailAddress;
    /**
     * 通信地址所属邮编
     */
    private String mailAddressPost;
    /**
     * 传真
     */
    private String facsimile;

    /**
     * 邮箱
     */
    private String email;
    /**
     * 证件识别id
     */
    private String registId;
    /**
     * 证件类型
     */
    private String idtypeCode;
    /**
     * 证件号码
     */
    private String idno;

    /**
     * 身份证生效日期
     */
    private String identityEffetiveStartDate;
    /**
     * 身份证有效日期
     */
    private String identityEffetiveEndDate;
    /**
     * 联系人名称
     */
    private String linkerName;
    /**
     * 联系人手机
     */
    private String linkerMobile;
    /**
     * 联系人固话
     */
    private String linkerPhoneNo;
    /**
     * 客户等级
     */
    private String customerGrade;
    /**
     * 自动生成重客等级
     */
    private String autoVIPLevelCode;
    /**
     * 人工重客等级
     */
    private String manualVIPLevelCode;

    /**
     * 客户风险等级(自动)
     */
    private String autoRiskLevelCode;
    /**
     * 客户风险等级(人工)
     */
    private String manualRiskLevelCode;

    /**
     * @return the customerCode
     */
    public String getCustomerCode() {
        return customerCode;
    }

    /**
     * @param customerCode the customerCode to set
     */
    public void setCustomerCode(String customerCode) {
        this.customerCode = customerCode;
    }

    /**
     * @return the customerName
     */
    public String getCustomerName() {
        return customerName;
    }

    /**
     * @param customerName the customerName to set
     */
    public void setCustomerName(String customerName) {
        this.customerName = customerName;
    }

    /**
     * @return the linkerName
     */
    public String getLinkerName() {
        return linkerName;
    }

    /**
     * @param linkerName the linkerName to set
     */
    public void setLinkerName(String linkerName) {
        this.linkerName = linkerName;
    }

    /**
     * @return the linkerMobile
     */
    public String getLinkerMobile() {
        return linkerMobile;
    }

    /**
     * @param linkerMobile the linkerMobile to set
     */
    public void setLinkerMobile(String linkerMobile) {
        this.linkerMobile = linkerMobile;
    }

    /**
     * @return the linkerPhoneNo
     */
    public String getLinkerPhoneNo() {
        return linkerPhoneNo;
    }

    /**
     * @param linkerPhoneNo the linkerPhoneNo to set
     */
    public void setLinkerPhoneNo(String linkerPhoneNo) {
        this.linkerPhoneNo = linkerPhoneNo;
    }

    /**
     * @return the registyAddress
     */
    public String getRegistyAddress() {
        return registyAddress;
    }

    /**
     * @param registyAddress the registyAddress to set
     */
    public void setRegistyAddress(String registyAddress) {
        this.registyAddress = registyAddress;
    }

    /**
     * @return the mailAddressPost
     */
    public String getMailAddressPost() {
        return mailAddressPost;
    }

    /**
     * @param mailAddressPost the mailAddressPost to set
     */
    public void setMailAddressPost(String mailAddressPost) {
        this.mailAddressPost = mailAddressPost;
    }

    /**
     * @return the customerGrade
     */
    public String getCustomerGrade() {
        return customerGrade;
    }

    /**
     * @param customerGrade the customerGrade to set
     */
    public void setCustomerGrade(String customerGrade) {
        this.customerGrade = customerGrade;
    }

    /**
     * @return the autoRiskLevelCode
     */
    public String getAutoRiskLevelCode() {
        return autoRiskLevelCode;
    }

    /**
     * @param autoRiskLevelCode the autoRiskLevelCode to set
     */
    public void setAutoRiskLevelCode(String autoRiskLevelCode) {
        this.autoRiskLevelCode = autoRiskLevelCode;
    }

    /**
     * @return the manualRiskLevelCode
     */
    public String getManualRiskLevelCode() {
        return manualRiskLevelCode;
    }

    /**
     * @param manualRiskLevelCode the manualRiskLevelCode to set
     */
    public void setManualRiskLevelCode(String manualRiskLevelCode) {
        this.manualRiskLevelCode = manualRiskLevelCode;
    }

    /**
     * @return the idtypeCode
     */
    public String getIdtypeCode() {
        return idtypeCode;
    }

    /**
     * @param idtypeCode the idtypeCode to set
     */
    public void setIdtypeCode(String idtypeCode) {
        this.idtypeCode = idtypeCode;
    }

    /**
     * @return the idno
     */
    public String getIdno() {
        return idno;
    }

    /**
     * @param idno the idno to set
     */
    public void setIdno(String idno) {
        this.idno = idno;
    }

    public String getMailAddress() {
        return mailAddress;
    }

    public void setMailAddress(String mailAddress) {
        this.mailAddress = mailAddress;
    }

    public String getRegistId() {
        return registId;
    }

    public void setRegistId(String registId) {
        this.registId = registId;
    }


    public String getAutoVIPLevelCode() {
        return autoVIPLevelCode;
    }

    public void setAutoVIPLevelCode(String autoVIPLevelCode) {
        this.autoVIPLevelCode = autoVIPLevelCode;
    }

    public String getManualVIPLevelCode() {
        return manualVIPLevelCode;
    }

    public void setManualVIPLevelCode(String manualVIPLevelCode) {
        this.manualVIPLevelCode = manualVIPLevelCode;
    }

    public String getOrganizationType() {
        return organizationType;
    }

    public void setOrganizationType(String organizationType) {
        this.organizationType = organizationType;
    }

    public String getIndustryCategory() {
        return industryCategory;
    }

    public void setIndustryCategory(String industryCategory) {
        this.industryCategory = industryCategory;
    }

    public String getMainBusiness() {
        return mainBusiness;
    }

    public void setMainBusiness(String mainBusiness) {
        this.mainBusiness = mainBusiness;
    }

    public String getEconomicTypeCode() {
        return economicTypeCode;
    }

    public void setEconomicTypeCode(String economicTypeCode) {
        this.economicTypeCode = economicTypeCode;
    }

    public String getBusilicense() {
        return busilicense;
    }

    public void setBusilicense(String busilicense) {
        this.busilicense = busilicense;
    }

    public String getBusiLicenseStartDate() {
        return busiLicenseStartDate;
    }

    public void setBusiLicenseStartDate(String busiLicenseStartDate) {
        this.busiLicenseStartDate = busiLicenseStartDate;
    }

    public String getBusiLicenseEndDate() {
        return busiLicenseEndDate;
    }

    public void setBusiLicenseEndDate(String busiLicenseEndDate) {
        this.busiLicenseEndDate = busiLicenseEndDate;
    }

    public String getTaxregistrationNo() {
        return taxregistrationNo;
    }

    public void setTaxregistrationNo(String taxregistrationNo) {
        this.taxregistrationNo = taxregistrationNo;
    }

    public Long getOrganizationPeopleNumber() {
        return organizationPeopleNumber;
    }

    public void setOrganizationPeopleNumber(Long organizationPeopleNumber) {
        this.organizationPeopleNumber = organizationPeopleNumber;
    }

    public String getRegisteredPlaceCode() {
        return registeredPlaceCode;
    }

    public void setRegisteredPlaceCode(String registeredPlaceCode) {
        this.registeredPlaceCode = registeredPlaceCode;
    }

    public String getIdentityEffetiveStartDate() {
        return identityEffetiveStartDate;
    }

    public void setIdentityEffetiveStartDate(String identityEffetiveStartDate) {
        this.identityEffetiveStartDate = identityEffetiveStartDate;
    }

    public String getIdentityEffetiveEndDate() {
        return identityEffetiveEndDate;
    }

    public void setIdentityEffetiveEndDate(String identityEffetiveEndDate) {
        this.identityEffetiveEndDate = identityEffetiveEndDate;
    }

    public String getCustomerEName() {
        return customerEName;
    }

    public void setCustomerEName(String customerEName) {
        this.customerEName = customerEName;
    }

    public String getFacsimile() {
        return facsimile;
    }

    public void setFacsimile(String facsimile) {
        this.facsimile = facsimile;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getRegisteredPlaceName() {
        return registeredPlaceName;
    }

    public void setRegisteredPlaceName(String registeredPlaceName) {
        this.registeredPlaceName = registeredPlaceName;
    }
    
}
