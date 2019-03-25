package com.chinalife.risksurvey.ecifclient.vo;

import java.io.Serializable;
import java.util.List;

/**
 * 保存客户信息返回报文
 *
 * @author: marscheng
 * @date: 2017-11-22 下午5:01
 */
public class SaveCustomerResponseBody implements Serializable {
    private static final long serialVersionUID = 106997431408526060L;

    /**
     * ecif返回消息
     */
    private String ecifInfo;
    /**
     * 请求结果
     */
    private String responseCode;
    /**
     * 客户标志key(idname+idtype+idno)
     */
    private String customerKey;
    /**
     * 客户代码
     */
    private String customerCode;
    /**
     * 证件识别id
     */
    private String registId;

    /**
     * 电话信息
     */
    private List<PhoneVO> phones;

    public String getEcifInfo() {
        return ecifInfo;
    }

    public void setEcifInfo(String ecifInfo) {
        this.ecifInfo = ecifInfo;
    }

    public String getResponseCode() {
        return responseCode;
    }

    public void setResponseCode(String responseCode) {
        this.responseCode = responseCode;
    }

    public String getCustomerCode() {
        return customerCode;
    }

    public void setCustomerCode(String customerCode) {
        this.customerCode = customerCode;
    }

    public String getRegistId() {
        return registId;
    }

    public void setRegistId(String registId) {
        this.registId = registId;
    }

    public String getCustomerKey() {
        return customerKey;
    }

    public void setCustomerKey(String customerKey) {
        this.customerKey = customerKey;
    }

    public List<PhoneVO> getPhones() {
        return phones;
    }

    public void setPhones(List<PhoneVO> phones) {
        this.phones = phones;
    }
}
