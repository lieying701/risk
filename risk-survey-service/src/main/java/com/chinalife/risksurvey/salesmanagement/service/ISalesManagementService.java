package com.chinalife.risksurvey.salesmanagement.service;

import java.util.Map;

import com.chinalife.hr.core.entity.StructureEO;

/**
 * 销管系统接口
 * 包名称： com.chinalife.risksurvey.salesmanagement.service 
 * 类名称：ISalesManagementService<br/>    
 * 类描述：<br/>  
 * @version <br/>   
 */
public interface ISalesManagementService {

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
