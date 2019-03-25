package com.chinalife.risksurvey.ecifclient.controller;

import com.chinalife.risksurvey.ecifclient.vo.GetCustomeResponseBody;
import com.chinalife.risksurvey.ecifclient.vo.GetCustomerRequestBody;

/**
 * ecif客户请求接口
 * 包名称： com.chinalife.risksurvey.ecifclient.controller 
 * 类名称：IECIFClientController<br/>    
 * 类描述：<br/>  
 * @version <br/>   
 */
public interface IECIFClientController {

    /**
     * @param sysId         系统id
     * @param interruptFlag 中断出单标志
     * @param customerType  客户类型
     * @param requestBody   客户请求实体
     * @return ecif请求结果封装类
     * @Description: 通过客户id或者三证信息或者电话号码查询客户信息
     */
    GetCustomeResponseBody getCustomer(String sysId, String interruptFlag, String customerType,
                                       GetCustomerRequestBody requestBody);
}
