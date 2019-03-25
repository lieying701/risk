package com.chinalife.risksurvey.ecifclient.controller.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.chinalife.integration.ecif.service.IECIFService;
import com.chinalife.risksurvey.ecifclient.controller.IECIFClientController;
import com.chinalife.risksurvey.ecifclient.service.IECIFClientService;
import com.chinalife.risksurvey.ecifclient.vo.GetCustomeResponseBody;
import com.chinalife.risksurvey.ecifclient.vo.GetCustomerRequestBody;
/**
 * 包名称： com.chinalife.risksurvey.ecifclient.controller.impl 
 * 类名称：ECIFClientControllerImpl<br/>    
 * 类描述：<br/>  
 * @version <br/>   
 */

@RestController("ecifClientController")
@RequestMapping("/controller/risksurvey/ecifClient")
public class ECIFClientControllerImpl implements IECIFClientController {

    /**
     * service层注入
     */
    @Autowired
    private IECIFClientService ecifClientService;

    /**
     * ecif对接接口
     */
    @Autowired
    @Qualifier("ecifService")
    private IECIFService ecifService;
    
    @Override
    @RequestMapping(value = "/getCustomer", method = RequestMethod.POST)
    public GetCustomeResponseBody getCustomer(@RequestParam(value = "sysId", required = true) String sysId,
                                              @RequestParam(value = "interruptFlag", required = true) String interruptFlag,
                                              @RequestParam(value = "customerType", required = true) String customerType,
                                              @RequestBody(required = true) GetCustomerRequestBody requestBody) {
        return ecifClientService.getCustomer(sysId, interruptFlag, customerType, requestBody.getPartyIdObj(),
                requestBody.getPartyRegistrationKeyInfo(), requestBody.getTelephone());
    }

}
