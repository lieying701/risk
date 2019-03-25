package com.chinalife.risksurvey.salesmanagement.controller;

import java.util.Map;

import org.springframework.web.bind.annotation.RequestMapping;

import com.chinalife.hr.core.entity.StructureEO;

/**
 * 包名称： com.chinalife.risksurvey.salesmanagement.controller 
 * 类名称：ISalesManagementController
 * 类描述：销管系统接口
 */

@RequestMapping("/controller/risksurvey/salesmanagement")
public interface ISalesManagementController {
    /**
     * 获取当前登录用户
     * @return Map<String, String>
     */

    Map<String, String> getCurrentUser();
    /**
     * 查询归属部门所在省级代码
     * 
     * @param parentId
     *            归属部门
     * @return StructureEO
     */
    
    StructureEO findByPartyId(String parentId);
}
