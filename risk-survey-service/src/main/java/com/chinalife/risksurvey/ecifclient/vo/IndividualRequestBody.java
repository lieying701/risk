package com.chinalife.risksurvey.ecifclient.vo;

import java.io.Serializable;

/**
 * 客户存入ecfi的实体
 *
 * @author: marscheng
 * @date: 2017-11-22 下午3:34
 */
public class IndividualRequestBody implements Serializable {
    private static final long serialVersionUID = 8868849503241170453L;

    /**
     * 客户代码
     */
    private String customerCode;
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
     * 家庭地址
     */
    private String homeAddress;
    /**
     * 通讯地址
     */
    private String postalAddress;
    /**
     * 联系电话
     */
    private String phoneNumber;
    /**
     * 联系手机
     */
    private String mobile;
    /**
     * 微信
     */
    private String weChat;
    /**
     * 联系邮箱
     */
    private String email;
    /**
     * 家庭地址邮编
     */
    private String homePost;
    /**
     * 联系地址邮编
     */
    private String contactPost;

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

    public String getIdname() {
        return idname;
    }

    public void setIdname(String idname) {
        this.idname = idname;
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

    public String getHomeAddress() {
        return homeAddress;
    }

    public void setHomeAddress(String homeAddress) {
        this.homeAddress = homeAddress;
    }

    public String getPostalAddress() {
        return postalAddress;
    }

    public void setPostalAddress(String postalAddress) {
        this.postalAddress = postalAddress;
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

    public String getWeChat() {
        return weChat;
    }

    public void setWeChat(String weChat) {
        this.weChat = weChat;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getHomePost() {
        return homePost;
    }

    public void setHomePost(String homePost) {
        this.homePost = homePost;
    }


    public String getRegistId() {
        return registId;
    }

    public void setRegistId(String registId) {
        this.registId = registId;
    }

    public String getContactPost() {
        return contactPost;
    }

    public void setContactPost(String contactPost) {
        this.contactPost = contactPost;
    }

    public String getDeathDate() {
        return deathDate;
    }

    public void setDeathDate(String deathDate) {
        this.deathDate = deathDate;
    }
}
