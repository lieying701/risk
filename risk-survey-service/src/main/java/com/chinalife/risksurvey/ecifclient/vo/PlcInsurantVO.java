package com.chinalife.risksurvey.ecifclient.vo;

import java.io.Serializable;
import java.util.Date;

/**
 * 关系人vo
 *
 * @author: marscheng
 * @date: 2017-12-02 下午4:09
 */
public class PlcInsurantVO implements Serializable {
    /**
     *
     */
    private static final long serialVersionUID = -4101698979471258905L;

    /** 序号 */
    private String serialNo;
    /** 关系人类型 */
    private String customerType;
    /** 关系人类型名称 */
    private String customerTypeName;
    /** 关系人证件识别ID */
    private String registId;
    /** 关系人角色标志 */
    private String customerFlag;
    /** 关系人角色名称 */
    private String customerFlagName;
    /** 关系人代码 */
    private String customerCode;
    /** 关系人本地客户id */
    private String customerCodeId;
    /** 关系人中文姓名 */
    private String customerName;
    /** 关系人英文名称 */
    private String customerEName;
    /** 关系人证件类型 */
    private String identifyType;
    /** 关系人证件名称 */
    private String identifyName;
    /** 关系人证件号码 */
    private String identifyNumber;
    /** 关系人证件有效起期 */
    private Date identifyEffectiveStartDate;
    /** 关系人证件有效止期 */
    private Date identifyEffectiveEndDate;
    /** 关系人证件长期有效标志 */
    private String longtermEffectiveFlag;
    /** 关系人等级 */
    private String customerGrade;
    /** 关系人等级名称 */
    private String customerGradeName;
    /** 关系人风险等级 */
    private String customerRiskGrade;
    /** 关系人风险等级名称 */
    private String customerRiskGradeName;
    /** 联系人姓名 */
    private String linkerName;
    /** 联系人电话 */
    private String linkerPhoneNo;
    /** 联系人手机 */
    private String linkerMobile;
    /** 联系人邮箱 */
    private String linkerEmail;
    /** 联系人邮编 */
    private String linkerPost;
    /** 联系人地址 */
    private String linkerAddress;
    /** 总行名称 */
    private String headBankName;
    /** 开户银行名称 */
    private String despositBankName;
    /** 开户银行CNAPS */
    private String despositBankCnaps;
    /** 开户银行账户 */
    private String despositBankAccount;
    /** 账户属性 */
    private String accountType;
    /** 账户属性名称 */
    private String accountTypeName;
    /** 是否关联方 */
    private String isLink;
    /** 银行账号 */
    private String accountNo;
    /** 银行账户名称 */
    private String accountName;
    /** 账户省份 */
    private String accountProvince;
    /** 账户城市 */
    private String accountCity;
    /** 账户币别 */
    private String currencyCode;
    /** 标的序号 */
    private String itemNo;
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
    /** 同投保人标志 */
    private String sameFlag;
    /** 银行卡/会员卡号 */
    private String cardNo;
    /** 银行卡/会员卡名称 */
    private String cardName;
    /** 证件签发机关 */
    private String signDepartmentName;
 
    
    public String getSerialNo() {
        return serialNo;
    }

    public void setSerialNo(String serialNo) {
        this.serialNo = serialNo;
    }

    public String getCustomerType() {
        return customerType;
    }

    public void setCustomerType(String customerType) {
        this.customerType = customerType;
    }

    public String getCustomerFlag() {
        return customerFlag;
    }

    public void setCustomerFlag(String customerFlag) {
        this.customerFlag = customerFlag;
    }

    public String getCustomerFlagName() {
        return customerFlagName;
    }

    public void setCustomerFlagName(String customerFlagName) {
        this.customerFlagName = customerFlagName;
    }

    public String getCustomerCode() {
        return customerCode;
    }

    public void setCustomerCode(String customerCode) {
        this.customerCode = customerCode;
    }

    public String getCustomerCodeId() {
        return customerCodeId;
    }

    public void setCustomerCodeId(String customerCodeId) {
        this.customerCodeId = customerCodeId;
    }

    public String getCustomerName() {
        return customerName;
    }

    public void setCustomerName(String customerName) {
        this.customerName = customerName;
    }

    public String getCustomerEName() {
        return customerEName;
    }

    public void setCustomerEName(String customerEName) {
        this.customerEName = customerEName;
    }

    public String getIdentifyType() {
        return identifyType;
    }

    public void setIdentifyType(String identifyType) {
        this.identifyType = identifyType;
    }

    public String getIdentifyName() {
        return identifyName;
    }

    public void setIdentifyName(String identifyName) {
        this.identifyName = identifyName;
    }

    public String getIdentifyNumber() {
        return identifyNumber;
    }

    public void setIdentifyNumber(String identifyNumber) {
        this.identifyNumber = identifyNumber;
    }

    public Date getIdentifyEffectiveStartDate() {
        return identifyEffectiveStartDate;
    }

    public void setIdentifyEffectiveStartDate(Date identifyEffectiveStartDate) {
        this.identifyEffectiveStartDate = identifyEffectiveStartDate;
    }

    public Date getIdentifyEffectiveEndDate() {
        return identifyEffectiveEndDate;
    }

    public void setIdentifyEffectiveEndDate(Date identifyEffectiveEndDate) {
        this.identifyEffectiveEndDate = identifyEffectiveEndDate;
    }

    public String getLongtermEffectiveFlag() {
        return longtermEffectiveFlag;
    }

    public void setLongtermEffectiveFlag(String longtermEffectiveFlag) {
        this.longtermEffectiveFlag = longtermEffectiveFlag;
    }

    public String getCustomerGrade() {
        return customerGrade;
    }

    public void setCustomerGrade(String customerGrade) {
        this.customerGrade = customerGrade;
    }

    public String getCustomerGradeName() {
        return customerGradeName;
    }

    public void setCustomerGradeName(String customerGradeName) {
        this.customerGradeName = customerGradeName;
    }

    public String getCustomerRiskGrade() {
        return customerRiskGrade;
    }

    public void setCustomerRiskGrade(String customerRiskGrade) {
        this.customerRiskGrade = customerRiskGrade;
    }

    public String getCustomerRiskGradeName() {
        return customerRiskGradeName;
    }

    public void setCustomerRiskGradeName(String customerRiskGradeName) {
        this.customerRiskGradeName = customerRiskGradeName;
    }

    public String getLinkerName() {
        return linkerName;
    }

    public void setLinkerName(String linkerName) {
        this.linkerName = linkerName;
    }

    public String getLinkerPhoneNo() {
        return linkerPhoneNo;
    }

    public void setLinkerPhoneNo(String linkerPhoneNo) {
        this.linkerPhoneNo = linkerPhoneNo;
    }

    public String getLinkerMobile() {
        return linkerMobile;
    }

    public void setLinkerMobile(String linkerMobile) {
        this.linkerMobile = linkerMobile;
    }

    public String getLinkerEmail() {
        return linkerEmail;
    }

    public void setLinkerEmail(String linkerEmail) {
        this.linkerEmail = linkerEmail;
    }

    public String getLinkerPost() {
        return linkerPost;
    }

    public void setLinkerPost(String linkerPost) {
        this.linkerPost = linkerPost;
    }

    public String getLinkerAddress() {
        return linkerAddress;
    }

    public void setLinkerAddress(String linkerAddress) {
        this.linkerAddress = linkerAddress;
    }

    public String getHeadBankName() {
        return headBankName;
    }

    public void setHeadBankName(String headBankName) {
        this.headBankName = headBankName;
    }

    public String getDespositBankName() {
        return despositBankName;
    }

    public void setDespositBankName(String despositBankName) {
        this.despositBankName = despositBankName;
    }

    public String getDespositBankCnaps() {
        return despositBankCnaps;
    }

    public void setDespositBankCnaps(String despositBankCnaps) {
        this.despositBankCnaps = despositBankCnaps;
    }

    public String getDespositBankAccount() {
        return despositBankAccount;
    }

    public void setDespositBankAccount(String despositBankAccount) {
        this.despositBankAccount = despositBankAccount;
    }

    public String getAccountType() {
        return accountType;
    }

    public void setAccountType(String accountType) {
        this.accountType = accountType;
    }

    public String getAccountTypeName() {
        return accountTypeName;
    }

    public void setAccountTypeName(String accountTypeName) {
        this.accountTypeName = accountTypeName;
    }

    public String getIsLink() {
        return isLink;
    }

    public void setIsLink(String isLink) {
        this.isLink = isLink;
    }

    public String getAccountNo() {
        return accountNo;
    }

    public void setAccountNo(String accountNo) {
        this.accountNo = accountNo;
    }

    public String getAccountName() {
        return accountName;
    }

    public void setAccountName(String accountName) {
        this.accountName = accountName;
    }

    public String getAccountProvince() {
        return accountProvince;
    }

    public void setAccountProvince(String accountProvince) {
        this.accountProvince = accountProvince;
    }

    public String getAccountCity() {
        return accountCity;
    }

    public void setAccountCity(String accountCity) {
        this.accountCity = accountCity;
    }

    public String getCurrencyCode() {
        return currencyCode;
    }

    public void setCurrencyCode(String currencyCode) {
        this.currencyCode = currencyCode;
    }

    public String getItemNo() {
        return itemNo;
    }

    public void setItemNo(String itemNo) {
        this.itemNo = itemNo;
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

    public String getSameFlag() {
        return sameFlag;
    }

    public void setSameFlag(String sameFlag) {
        this.sameFlag = sameFlag;
    }

    public String getCardNo() {
        return cardNo;
    }

    public void setCardNo(String cardNo) {
        this.cardNo = cardNo;
    }

    public String getCardName() {
        return cardName;
    }

    public void setCardName(String cardName) {
        this.cardName = cardName;
    }

    public String getCustomerTypeName() {
        return customerTypeName;
    }

    public void setCustomerTypeName(String customerTypeName) {
        this.customerTypeName = customerTypeName;
    }

    public String getRegistId() {
        return registId;
    }

    public void setRegistId(String registId) {
        this.registId = registId;
    }

    public String getSignDepartmentName() {
        return signDepartmentName;
    }

    public void setSignDepartmentName(String signDepartmentName) {
        this.signDepartmentName = signDepartmentName;
    }

    
}
