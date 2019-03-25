package com.chinalife.risksurvey.ecifclient.vo;

import java.io.Serializable;

/**
 * @Description: 多条组织信息
 * @author: marscheng
 * @date: 2017年10月13日 下午4:42:04
 * 
 */
public class OrgnizationListResponse implements Serializable {

    /**
     * @Fields serialVersionUID : TODO
     */
    private static final long serialVersionUID = -4904662615118966494L;

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
     * 客户状态
     */
    private String customerStatus;
    /**
     * 客户英文名称
     */
    private String customerEName;
    /**
     * 联系人
     */
    private String linkerName;
    /**
     * 手机号码
     */
    private String linkerMobile;
    /**
     * 办公电话
     */
    private String linkerPhoneNo;
    /**
     * 通信地址
     */
    private String mailAddress;
    /**
     * 邮编
     */
    private String mailAddressPost;
    
    

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
    
}
