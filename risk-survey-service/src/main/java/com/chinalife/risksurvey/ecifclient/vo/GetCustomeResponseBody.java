package com.chinalife.risksurvey.ecifclient.vo;


/**
 * @Description: TODO
 * @date: 2017年10月15日
 * @author: marscheng
 * @version: 1.0.0
 * @Copyright: 2017 www.chinalife-p.com.cn Inc. All rights reserved. 
 */

import java.io.Serializable;
import java.util.List;

import com.chinalife.integration.payment.dto.accountinfomaintenancennuclearbean.AccountInfoVO;

/**
 * @Description: 客户信息返回实体
 * @author: marscheng
 * @date: 2017年10月15日 下午2:03:45
 * 
 */
public class GetCustomeResponseBody implements Serializable {

    /**
     * @Fields serialVersionUID : TODO
     */
    private static final long serialVersionUID = 6158235677463711883L;

    /** ecif返回消息 */
    private String ecifInfo;
    /** 请求结果 */
    private String responseCode;

    /** 是否多条数据 */
    private String ifMulti;

    /** 是否中断出单 */
    private String interruptFlag;
    /** 单条个人客户信息 */
    private IndividualResponse individualResponse;
    /** 多条个人客户信息 */
    private List<IndividualListResponse> individualListResponses;
    /** 单条组织客户信息 */
    private OrgnizationResponse orgnizationResponse;
    /** 多条组织客户信息 */
    private List<OrgnizationListResponse> orgnizationListResponses;
    /** 银行账户信息 */
    private AccountInfoVO accountInfoVO;

    /**
     * @return the individualResponse
     */
    public IndividualResponse getIndividualResponse() {
        return individualResponse;
    }

    /**
     * @param individualResponse
     *            the individualResponse to set
     */
    public void setIndividualResponse(IndividualResponse individualResponse) {
        this.individualResponse = individualResponse;
    }

    public List<IndividualListResponse> getIndividualListResponses() {
        return individualListResponses;
    }

    public void setIndividualListResponses(List<IndividualListResponse> individualListResponses) {
        this.individualListResponses = individualListResponses;
    }

    /**
     * @return the orgnizationResponse
     */
    public OrgnizationResponse getOrgnizationResponse() {
        return orgnizationResponse;
    }

    /**
     * @param orgnizationResponse
     *            the orgnizationResponse to set
     */
    public void setOrgnizationResponse(OrgnizationResponse orgnizationResponse) {
        this.orgnizationResponse = orgnizationResponse;
    }

    public List<OrgnizationListResponse> getOrgnizationListResponses() {
        return orgnizationListResponses;
    }

    public void setOrgnizationListResponses(List<OrgnizationListResponse> orgnizationListResponses) {
        this.orgnizationListResponses = orgnizationListResponses;
    }

    /**
     * @return the ecifInfo
     */
    public String getEcifInfo() {
        return ecifInfo;
    }

    /**
     * @param ecifInfo
     *            the ecifInfo to set
     */
    public void setEcifInfo(String ecifInfo) {
        this.ecifInfo = ecifInfo;
    }

    /**
     * @return the responseCode
     */
    public String getResponseCode() {
        return responseCode;
    }

    /**
     * @param responseCode
     *            the responseCode to set
     */
    public void setResponseCode(String responseCode) {
        this.responseCode = responseCode;
    }

    /**
     * @return the interruptFlag
     */
    public String getInterruptFlag() {
        return interruptFlag;
    }

    /**
     * @param interruptFlag
     *            the interruptFlag to set
     */
    public void setInterruptFlag(String interruptFlag) {
        this.interruptFlag = interruptFlag;
    }

    /**
     * @return the ifMulti
     */
    public String getIfMulti() {
        return ifMulti;
    }

    /**
     * @param ifMulti
     *            the ifMulti to set
     */
    public void setIfMulti(String ifMulti) {
        this.ifMulti = ifMulti;
    }

    public AccountInfoVO getAccountInfoVO() {
        return accountInfoVO;
    }

    public void setAccountInfoVO(AccountInfoVO accountInfoVO) {
        this.accountInfoVO = accountInfoVO;
    }
}
