package com.chinalife.risksurvey.ecifclient.vo;

import java.io.Serializable;

/**
 * 组织客户信息送ecif实体
 *
 * @author: marscheng
 * @date: 2017-11-23 上午11:27
 */
public class OrgnizationRequestBody implements Serializable {

    private static final long serialVersionUID = 7038476206956543117L;
    /**
     * 客户代码
     */
    private String customerCode;
    /**
     * 客户名称
     */
    private String customerName;
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
    private String bizScope;
    /**
     * 经济类型代码
     */
    private String economicTypeCode;
    /**
     * 营业执照号码
     */
    private String busilicense;
    /**
     * 税务登记号码(国税)
     */
    private String nationalTaxregistrationNo;
    /**
     * 税务登记号码(地税)
     */
    private String localTaxregistrationNo;
    /**
     * 机构人数
     */
    private Long organizationPeopleNumber;
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


    //*********************以下为反洗钱的信息****************************

    /**
     * 法人代表姓名
     */
    private String applialeaderName;
    /**
     * 法人代表证件类型
     */
    private String applialeaderType;
    /**
     * 法人代表证件号码
     */
    private String applialeaderId;
    /**
     * 控股股东名称
     */
    private String shareHolderName;
    /**
     * 控股股东证件号码
     */
    private String shareHolderIdentifyNumber;
    /**
     * 控股股东证件类型
     */
    private String shareHolderIdentifyType;
    /**
     * 负责人姓名
     */
    private String principalName;
    /**
     * 负责人证件类型
     */
    private String principalIdentifyType;
    /**
     * 负责人证件号码
     */
    private String principalIdentifyNumber;

    public String getCustomerCode() {
        return customerCode;
    }

    public void setCustomerCode(String customerCode) {
        this.customerCode = customerCode;
    }

    public String getCustomerName() {
        return customerName;
    }

    public void setCustomerName(String customerName) {
        this.customerName = customerName;
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

    public String getBusilicense() {
        return busilicense;
    }

    public void setBusilicense(String busilicense) {
        this.busilicense = busilicense;
    }

    public String getNationalTaxregistrationNo() {
        return nationalTaxregistrationNo;
    }

    public void setNationalTaxregistrationNo(String nationalTaxregistrationNo) {
        this.nationalTaxregistrationNo = nationalTaxregistrationNo;
    }

    public String getLocalTaxregistrationNo() {
        return localTaxregistrationNo;
    }

    public void setLocalTaxregistrationNo(String localTaxregistrationNo) {
        this.localTaxregistrationNo = localTaxregistrationNo;
    }

    public Long getOrganizationPeopleNumber() {
        return organizationPeopleNumber;
    }

    public void setOrganizationPeopleNumber(Long organizationPeopleNumber) {
        this.organizationPeopleNumber = organizationPeopleNumber;
    }

    public String getRegistyAddress() {
        return registyAddress;
    }

    public void setRegistyAddress(String registyAddress) {
        this.registyAddress = registyAddress;
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

    public String getIdtypeCode() {
        return idtypeCode;
    }

    public void setIdtypeCode(String idtypeCode) {
        this.idtypeCode = idtypeCode;
    }

    public String getIdno() {
        return idno;
    }

    public void setIdno(String idno) {
        this.idno = idno;
    }

    public String getLinkerName() {
        return linkerName;
    }

    public void setLinkerName(String linkerName) {
        this.linkerName = linkerName;
    }

    public String getLinkerMobile() {
        return linkerMobile;
    }

    public void setLinkerMobile(String linkerMobile) {
        this.linkerMobile = linkerMobile;
    }

    public String getLinkerPhoneNo() {
        return linkerPhoneNo;
    }

    public void setLinkerPhoneNo(String linkerPhoneNo) {
        this.linkerPhoneNo = linkerPhoneNo;
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

    public String getApplialeaderId() {
        return applialeaderId;
    }

    public void setApplialeaderId(String applialeaderId) {
        this.applialeaderId = applialeaderId;
    }

    public String getShareHolderName() {
        return shareHolderName;
    }

    public void setShareHolderName(String shareHolderName) {
        this.shareHolderName = shareHolderName;
    }

    public String getShareHolderIdentifyNumber() {
        return shareHolderIdentifyNumber;
    }

    public void setShareHolderIdentifyNumber(String shareHolderIdentifyNumber) {
        this.shareHolderIdentifyNumber = shareHolderIdentifyNumber;
    }

    public String getShareHolderIdentifyType() {
        return shareHolderIdentifyType;
    }

    public void setShareHolderIdentifyType(String shareHolderIdentifyType) {
        this.shareHolderIdentifyType = shareHolderIdentifyType;
    }

    public String getPrincipalName() {
        return principalName;
    }

    public void setPrincipalName(String principalName) {
        this.principalName = principalName;
    }

    public String getPrincipalIdentifyType() {
        return principalIdentifyType;
    }

    public void setPrincipalIdentifyType(String principalIdentifyType) {
        this.principalIdentifyType = principalIdentifyType;
    }

    public String getPrincipalIdentifyNumber() {
        return principalIdentifyNumber;
    }

    public void setPrincipalIdentifyNumber(String principalIdentifyNumber) {
        this.principalIdentifyNumber = principalIdentifyNumber;
    }

    public String getRegistId() {
        return registId;
    }

    public void setRegistId(String registId) {
        this.registId = registId;
    }

    public String getIdentityEffetiveEndDate() {
        return identityEffetiveEndDate;
    }

    public void setIdentityEffetiveEndDate(String identityEffetiveEndDate) {
        this.identityEffetiveEndDate = identityEffetiveEndDate;
    }

    public String getBizScope() {
        return bizScope;
    }

    public void setBizScope(String bizScope) {
        this.bizScope = bizScope;
    }

    public String getEconomicTypeCode() {
        return economicTypeCode;
    }

    public void setEconomicTypeCode(String economicTypeCode) {
        this.economicTypeCode = economicTypeCode;
    }
}
