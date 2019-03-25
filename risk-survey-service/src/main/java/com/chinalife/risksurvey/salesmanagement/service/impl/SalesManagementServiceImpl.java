package com.chinalife.risksurvey.salesmanagement.service.impl;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.chinalife.hr.core.entity.StructureEO;
import com.chinalife.risksurvey.salesmanagement.component.ISalesManagementComponent;
import com.chinalife.risksurvey.salesmanagement.service.ISalesManagementService;

/**
 * 销管系统接口
 * 包名称： com.chinalife.risksurvey.salesmanagement.service.impl 
 * 类名称：SalesManagementServiceImpl<br/>    
 * 类描述：<br/>  
 * @version <br/>   
 */
@RestController("salesmanagementService")
@RequestMapping("/controller/risksurvey/salesmanagement")
public class SalesManagementServiceImpl implements ISalesManagementService {
    /**
     * 注入销管component
     */
    @Autowired
    private ISalesManagementComponent salesmanagementComponent;

    @Override
    public Map<String, String> getCurrentUser() {
        return salesmanagementComponent.getCurrentUser();
    }

    @Override
    public StructureEO findByPartyId(String parentId) {
        return salesmanagementComponent.findByPartyId(parentId);
    }
     
}
