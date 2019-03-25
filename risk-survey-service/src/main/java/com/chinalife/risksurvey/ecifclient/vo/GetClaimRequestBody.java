/**
 * @Description: TODO
 * @date: 2017年10月17日
 * @author: marscheng
 * @version: 1.0.0
 * @Copyright: 2017 www.chinalife-p.com.cn Inc. All rights reserved. 
 */

package com.chinalife.risksurvey.ecifclient.vo;

import com.chinalife.integration.ecif.webservice.PageInput;
import com.chinalife.integration.ecif.webservice.PartyIdObj;

import java.io.Serializable;

/**
 * @Description: 查询理赔案件信息请求实体
 * @author: marscheng
 * @date: 2017年10月17日 下午4:47:58
 * 
 */
public class GetClaimRequestBody implements Serializable {

    /**
     * @Fields serialVersionUID : TODO
     */
    private static final long serialVersionUID = -8594020406791323643L;
    /**
     * 客户id
     */
    private PartyIdObj partyIdObj;
    /**
     * 分页信息
     */
    private PageInput pageInput;

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

}
