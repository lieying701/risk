package com.chinalife.risksurvey.ecifclient.service;

import com.chinalife.integration.ecif.webservice.PartyIdObj;
import com.chinalife.integration.ecif.webservice.PartyRegistrationKeyInfo;
import com.chinalife.integration.ecif.webservice.Telephone;
import com.chinalife.risksurvey.ecifclient.vo.GetCustomeResponseBody;
/**
 * 客户信息处理
 * 包名称： com.chinalife.risksurvey.ecifclient.service 
 * 类名称：IECIFClientService<br/>    
 * 类描述：<br/>  
 * @version <br/>   
 */

public interface IECIFClientService {
    /**
     * @Description: 通过客户id或者三证信息或者电话号码查询客户信息
     * @param sysId
     *            系统id
     * @param interruptFlag
     *            中断出单标志
     * @param customerType
     *            客户类型
     * @param partyIdObj
     *            客户id
     * @param partyRegistrationKeyInfo
     *            三证信息
     * @param telephone
     *            电话信息
     * @return ecif请求结果封装类
     */
    GetCustomeResponseBody getCustomer(String sysId, String interruptFlag, String customerType, PartyIdObj partyIdObj,
            PartyRegistrationKeyInfo partyRegistrationKeyInfo, Telephone telephone);
}
