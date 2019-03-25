/**
 * @Description: TODO
 * @date: 2017年10月17日
 * @author: marscheng
 * @version: 1.0.0
 * @Copyright: 2017 www.chinalife-p.com.cn Inc. All rights reserved. 
 */

package com.chinalife.risksurvey.ecifclient.vo;

import java.io.Serializable;

import com.chinalife.integration.ecif.webservice.PageInput;
import com.chinalife.integration.ecif.webservice.PartyIdObj;
import com.chinalife.integration.ecif.webservice.PolicySearchObject;

/**
 * @Description: 获取保单信息请求实体
 * @author: marscheng
 * @date: 2017年10月17日 下午4:54:19
 * 
 */
public class GetPolicyRequestBody implements Serializable {

    /**
     * @Fields serialVersionUID : TODO
     */
    private static final long serialVersionUID = -6483051493420915826L;

    /**
     * 客户id
     */
    private PartyIdObj partyIdObj;
    /**
     * 分页信息
     */
    private PageInput pageInput;
    /**
     *  查询信息，包括起终保时间，险种类型
     */
    private PolicySearchObject policySearchObject;

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
     * @return the pageInput
     */
    public PageInput getPageInput() {
        return pageInput;
    }

    /**
     * @param pageInput
     *            the pageInput to set
     */
    public void setPageInput(PageInput pageInput) {
        this.pageInput = pageInput;
    }

    /**
     * @return the policySearchObject
     */
    public PolicySearchObject getPolicySearchObject() {
        return policySearchObject;
    }

    /**
     * @param policySearchObject
     *            the policySearchObject to set
     */
    public void setPolicySearchObject(PolicySearchObject policySearchObject) {
        this.policySearchObject = policySearchObject;
    }

}
