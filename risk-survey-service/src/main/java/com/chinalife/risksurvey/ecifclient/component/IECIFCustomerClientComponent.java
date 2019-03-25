package com.chinalife.risksurvey.ecifclient.component;

import com.chinalife.integration.ecif.webservice.PartyIdObj;
import com.chinalife.integration.ecif.webservice.PartyRegistrationKeyInfo;
import com.chinalife.integration.ecif.webservice.Telephone;
import com.chinalife.risksurvey.ecifclient.vo.GetCustomeResponseBody;
/**
 * 包名称： com.chinalife.risksurvey.ecifclient.component 
 * 类名称：IECIFCustomerClientComponent<br/>    
 * 类描述：<br/>  
 * @version <br/>   
 */

public interface IECIFCustomerClientComponent {

    /**
     * @param sysId                    系统id
     * @param interruptFlag            中断出单标志
     * @param customerType             客户类型
     * @param partyIdObj               客户id
     * @param partyRegistrationKeyInfo 三证信息
     * @param telephone                电话信息
     * @return ecif请求结果封装类
     * @Description: 通过客户id或者三证信息或者电话号码查询客户信息
     */
    GetCustomeResponseBody getCustomer(String sysId, String interruptFlag, String customerType, PartyIdObj partyIdObj,
                                       PartyRegistrationKeyInfo partyRegistrationKeyInfo, Telephone telephone);

}
