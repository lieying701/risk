package com.chinalife.risksurvey.ecifclient.vo;

import java.io.Serializable;

import com.chinalife.integration.ecif.webservice.PartyIdObj;
import com.chinalife.integration.ecif.webservice.PartyRegistrationKeyInfo;
import com.chinalife.integration.ecif.webservice.Telephone;

/**
 * @Description: 客户信息请求实体类
 * @author: marscheng
 * @date: 2017年10月13日 下午2:20:50
 *
 */
public class GetCustomerRequestBody implements Serializable {

    /**
     * @Fields serialVersionUID : TODO
     */
    private static final long serialVersionUID = 6939606735867549293L;
    /**
     * 客户ID
     */
    private PartyIdObj partyIdObj;
    /**
     * 三证信息
     */
    private PartyRegistrationKeyInfo partyRegistrationKeyInfo;
    /**
     * 电话信息
     */
    private Telephone telephone;

    /**
     * @return the partyIdObj
     */
    public PartyIdObj getPartyIdObj() {
        return partyIdObj;
    }

    /**
     * @param partyIdObj
     *            the partyIdObj to set
     */
    public void setPartyIdObj(PartyIdObj partyIdObj) {
        this.partyIdObj = partyIdObj;
    }

    /**
     * @return the partyRegistrationKeyInfo
     */
    public PartyRegistrationKeyInfo getPartyRegistrationKeyInfo() {
        return partyRegistrationKeyInfo;
    }

    /**
     * @param partyRegistrationKeyInfo
     *            the partyRegistrationKeyInfo to set
     */
    public void setPartyRegistrationKeyInfo(PartyRegistrationKeyInfo partyRegistrationKeyInfo) {
        this.partyRegistrationKeyInfo = partyRegistrationKeyInfo;
    }

    /**
     * @return the telephone
     */
    public Telephone getTelephone() {
        return telephone;
    }

    /**
     * @param telephone
     *            the telephone to set
     */
    public void setTelephone(Telephone telephone) {
        this.telephone = telephone;
    }

}
