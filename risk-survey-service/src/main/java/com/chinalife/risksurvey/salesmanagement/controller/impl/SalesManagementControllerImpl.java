package com.chinalife.risksurvey.salesmanagement.controller.impl;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.chinalife.hr.core.entity.StructureEO;
import com.chinalife.rbac.filter.service.ICurrentRbacUserService;
import com.chinalife.risksurvey.salesmanagement.controller.ISalesManagementController;
import com.chinalife.risksurvey.salesmanagement.service.ISalesManagementService;

/**
 * 销管系统接口
 * 包名称： com.chinalife.risksurvey.salesmanagement.controller.impl 
 * 类名称：SalesManagementControllerImpl<br/>    
 * 类描述：<br/>  
 * @version <br/>   
 */
@RestController("salesManagementController")
@RequestMapping("/controller/risksurvey/salesmanagement")
public class SalesManagementControllerImpl implements ISalesManagementController {

    /**
     * 注入销管service
     */
    @Autowired
    private ISalesManagementService salesmanagementService;

    /**
     * 注入登录机构服务
     */
    @Autowired
    private ICurrentRbacUserService rbacUserService;
    
    
    /**
     * 获取当前登录用户
     */
    @Override
    @RequestMapping(value = "getCurrentUser")
    public Map<String, String> getCurrentUser() {
        return salesmanagementService.getCurrentUser();
    }
    
    /**
     * 查询归属部门所在省级代码
     */
    @Override
    @RequestMapping(value = "findByPartyId")
    public StructureEO findByPartyId(@RequestParam(value = "parentId", required = true) String parentId) {
        return salesmanagementService.findByPartyId(parentId);
    }

}
