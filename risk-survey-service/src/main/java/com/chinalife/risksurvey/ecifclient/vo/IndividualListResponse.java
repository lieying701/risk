package com.chinalife.risksurvey.ecifclient.vo;

import java.io.Serializable;

/**
 * @Description: 多条个人信息
 * @author: marscheng
 * @date: 2017年10月13日 下午4:40:26
 * 
 */
public class IndividualListResponse implements Serializable {

    /**
     * @Fields serialVersionUID : TODO
     */
    private static final long serialVersionUID = 5071573440386089156L;

    /**
     * 证件号码
     */
    private String idno;
    /**
     * 客户id
     */
    private String partyId;
    /**
     * 客户类型
     */
    private String partyTypeCode;
    /**
     * 客户名称
     */
    private String idname;
    /**
     * 证件类型
     */
    private String idtypeCode;
    /**
     * 性别
     */
    private String customerGender;
    /**
     * 客户状态
     */
    private String customerStatus;
    /**
     * 客户英文名称
     */
    private String customerEName;
    /**
     * 手机号码
     */
    private String mobile;
    /**
     * 家庭电话
     */
    private String phoneNumber;
    /**
     * 联系地址
     */
    private String address;
    /**
     * 邮编
     */
    private String post;

    public String getIdno() {
        return idno;
    }

    public void setIdno(String idno) {
        this.idno = idno;
    }

    public String getPartyId() {
        return partyId;
    }

    public void setPartyId(String partyId) {
        this.partyId = partyId;
    }

    public String getPartyTypeCode() {
        return partyTypeCode;
    }

    public void setPartyTypeCode(String partyTypeCode) {
        this.partyTypeCode = partyTypeCode;
    }

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
     * @return the customerGender
     */
    public String getCustomerGender() {
        return customerGender;
    }

    /**
     * @param customerGender
     *            the customerGender to set
     */
    public void setCustomerGender(String customerGender) {
        this.customerGender = customerGender;
    }

    /**
     * @return the customerStatus
     */
    public String getCustomerStatus() {
        return customerStatus;
    }

    /**
     * @param customerStatus
     *            the customerStatus to set
     */
    public void setCustomerStatus(String customerStatus) {
        this.customerStatus = customerStatus;
    }

    public String getCustomerEName() {
        return customerEName;
    }

    public void setCustomerEName(String customerEName) {
        this.customerEName = customerEName;
    }

    public String getMobile() {
        return mobile;
    }

    public void setMobile(String mobile) {
        this.mobile = mobile;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getPost() {
        return post;
    }

    public void setPost(String post) {
        this.post = post;
    }
    
}
