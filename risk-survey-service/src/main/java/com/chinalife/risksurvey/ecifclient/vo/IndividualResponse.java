package com.chinalife.risksurvey.ecifclient.vo;

import java.io.Serializable;

/**
 * @Description: 单条个人信息
 * @author: marscheng
 * @date: 2017年10月13日 下午4:39:50
 */
public class IndividualResponse implements Serializable {

    /**
     * @Fields serialVersionUID : TODO
     */
    private static final long serialVersionUID = -7159277221615582270L;

    /**
     * 客户代码
     */
    private String customerCode;

    /**
     * 身份证有效日期
     */
    private String identityEffetiveStartDate;
    /**
     * 身份证有效日期
     */
    private String identityEffetiveEndDate;
    /**
     * 客户名称
     */
    private String idname;
    /**
     * 证件类型
     */
    private String idtypeCode;
    /**
     * 证件号码
     */
    private String idno;
    /**
     * 证件识别id
     */
    private String registId;
    /**
     * 年龄
     */
    private int age;
    /**
     * 性别
     */
    private String sex;
    /**
     * 生日
     */
    private String birthDate;
    /**
     * 死亡日期
     */
    private String deathDate;
    /**
     * 国籍
     */
    private String countryCode;

    /**
     * 关系人国籍名称
     */
    private String citizenshipName;

    /**
     * 民族代码
     */
    private String nationality;
    /**
     * 婚姻状况代码
     */
    private String marriage;
    /**
     * 结婚日期
     */
    private String marriageDate;
    /**
     * 学历代码
     */
    private String degree;
    /**
     * 行业代码
     */
    private String industryCategory;

    /**
     * 职业代码
     */

    private String occupationCode;

    /**
     * 职业名称
     */
    private String occupationCodeName;

    /**
     * 入司时间
     */
    private String enterTime;
    /**
     * 单位名称
     */
    private String occupationName;
    /**
     * 收入币种
     */
    private String incomeCurrency;
    /**
     * 年收入
     */
    private Long income;
    /**
     * 社保编号
     */
    private String socialInsuNo;
    /**
     * 地址
     */
    private String address;
    /**
     * 联系电话
     */
    private String phoneNumber;
    /**
     * 联系电话重复数量
     */
    private String phoneNumberRepeatNo;
    /**
     * 联系手机
     */
    private String mobile;

    /**
     * 手机号码重复数量
     */
    private String mobileRepeatNo;
    /**
     * 微信
     */
    private String weChat;
    /**
     * 邮箱
     */
    private String email;
    /**
     * 邮编
     */
    private String post;
    /**
     * 境外标识 0境外 1境内
     */
    private String isWithinForeign;
    /**
     * 客户等级
     */
    private String customerGrade;
    /**
     * 客户风险等级(自动)
     */
    private String autoRiskLevelCode;
    /**
     * 客户风险等级(人工)
     */
    private String manualRiskLevelCode;

    /** 客户英文名称 */
    private String customerEName;

    /** 家庭地址 */
    private String homeAddress;

    /** 签发机关 */
    private String signDepartmentName;

    public String getCustomerCode() {
        return customerCode;
    }

    public void setCustomerCode(String customerCode) {
        this.customerCode = customerCode;
    }

    public String getIdentityEffetiveEndDate() {
        return identityEffetiveEndDate;
    }

    public void setIdentityEffetiveEndDate(String identityEffetiveEndDate) {
        this.identityEffetiveEndDate = identityEffetiveEndDate;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    /**
     * @return the idname
     */
    public String getIdname() {
        return idname;
    }

    /**
     * @param idname
     *            the idname to set
     */
    public void setIdname(String idname) {
        this.idname = idname;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    public String getBirthDate() {
        return birthDate;
    }

    public void setBirthDate(String birthDate) {
        this.birthDate = birthDate;
    }

    public String getCountryCode() {
        return countryCode;
    }

    public void setCountryCode(String countryCode) {
        this.countryCode = countryCode;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getMobile() {
        return mobile;
    }

    public void setMobile(String mobile) {
        this.mobile = mobile;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPost() {
        return post;
    }

    public void setPost(String post) {
        this.post = post;
    }

    public String getIsWithinForeign() {
        return isWithinForeign;
    }

    public void setIsWithinForeign(String isWithinForeign) {
        this.isWithinForeign = isWithinForeign;
    }

    public String getCustomerGrade() {
        return customerGrade;
    }

    public void setCustomerGrade(String customerGrade) {
        this.customerGrade = customerGrade;
    }

    public String getAutoRiskLevelCode() {
        return autoRiskLevelCode;
    }

    public void setAutoRiskLevelCode(String autoRiskLevelCode) {
        this.autoRiskLevelCode = autoRiskLevelCode;
    }

    public String getManualRiskLevelCode() {
        return manualRiskLevelCode;
    }

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
     * @param idtypeCode
     *            the idtypeCode to set
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
     * @param idno
     *            the idno to set
     */
    public void setIdno(String idno) {
        this.idno = idno;
    }

    public String getMobileRepeatNo() {
        return mobileRepeatNo;
    }

    public void setMobileRepeatNo(String mobileRepeatNo) {
        this.mobileRepeatNo = mobileRepeatNo;
    }

    public String getPhoneNumberRepeatNo() {
        return phoneNumberRepeatNo;
    }

    public void setPhoneNumberRepeatNo(String phoneNumberRepeatNo) {
        this.phoneNumberRepeatNo = phoneNumberRepeatNo;
    }

    public String getRegistId() {
        return registId;
    }

    public void setRegistId(String registId) {
        this.registId = registId;
    }

    public String getNationality() {
        return nationality;
    }

    public void setNationality(String nationality) {
        this.nationality = nationality;
    }

    public String getMarriage() {
        return marriage;
    }

    public void setMarriage(String marriage) {
        this.marriage = marriage;
    }

    public String getMarriageDate() {
        return marriageDate;
    }

    public void setMarriageDate(String marriageDate) {
        this.marriageDate = marriageDate;
    }

    public String getDegree() {
        return degree;
    }

    public void setDegree(String degree) {
        this.degree = degree;
    }

    public String getIndustryCategory() {
        return industryCategory;
    }

    public void setIndustryCategory(String industryCategory) {
        this.industryCategory = industryCategory;
    }

    public String getOccupationCode() {
        return occupationCode;
    }

    public void setOccupationCode(String occupationCode) {
        this.occupationCode = occupationCode;
    }

    public String getEnterTime() {
        return enterTime;
    }

    public void setEnterTime(String enterTime) {
        this.enterTime = enterTime;
    }

    public String getOccupationName() {
        return occupationName;
    }

    public void setOccupationName(String occupationName) {
        this.occupationName = occupationName;
    }

    public String getIncomeCurrency() {
        return incomeCurrency;
    }

    public void setIncomeCurrency(String incomeCurrency) {
        this.incomeCurrency = incomeCurrency;
    }

    public Long getIncome() {
        return income;
    }

    public void setIncome(Long income) {
        this.income = income;
    }

    public String getSocialInsuNo() {
        return socialInsuNo;
    }

    public void setSocialInsuNo(String socialInsuNo) {
        this.socialInsuNo = socialInsuNo;
    }

    public String getWeChat() {
        return weChat;
    }

    public void setWeChat(String weChat) {
        this.weChat = weChat;
    }

    public String getDeathDate() {
        return deathDate;
    }

    public void setDeathDate(String deathDate) {
        this.deathDate = deathDate;
    }

    public String getIdentityEffetiveStartDate() {
        return identityEffetiveStartDate;
    }

    public void setIdentityEffetiveStartDate(String identityEffetiveStartDate) {
        this.identityEffetiveStartDate = identityEffetiveStartDate;
    }

    public String getCustomerEName() {
        return customerEName;
    }

    public void setCustomerEName(String customerEName) {
        this.customerEName = customerEName;
    }

    public String getHomeAddress() {
        return homeAddress;
    }

    public void setHomeAddress(String homeAddress) {
        this.homeAddress = homeAddress;
    }

    public String getSignDepartmentName() {
        return signDepartmentName;
    }

    public void setSignDepartmentName(String signDepartmentName) {
        this.signDepartmentName = signDepartmentName;
    }

    public String getCitizenshipName() {
        return citizenshipName;
    }

    public void setCitizenshipName(String citizenshipName) {
        this.citizenshipName = citizenshipName;
    }

    public String getOccupationCodeName() {
        return occupationCodeName;
    }

    public void setOccupationCodeName(String occupationCodeName) {
        this.occupationCodeName = occupationCodeName;
    }

}
