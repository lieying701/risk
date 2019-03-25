package com.chinalife.risksurvey.salesmanagement.component.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.chinalife.base.context.BaseContext;
import com.chinalife.base.context.BaseContextManager;
import com.chinalife.hr.core.entity.StructureEO;
import com.chinalife.hr.core.service.IStructureRlshipService;
import com.chinalife.integration.sales.service.ISalesService;
import com.chinalife.rbac.domain.LoginStructure;
import com.chinalife.rbac.entity.RbacUserEO;
import com.chinalife.rbac.filter.service.ICurrentRbacUserService;
import com.chinalife.risksurvey.constant.StructureRlshipTypeEnum;
import com.chinalife.risksurvey.salesmanagement.component.ISalesManagementComponent;

/**
 * 销管系统接口
 * 包名称： com.chinalife.risksurvey.salesmanagement.component.impl 
 * 类名称：SalesManagementComponentImpl<br/>    
 * 类描述：<br/>  
 * @version <br/>   
 */

@Component("salesManagementComponent")
public class SalesManagementComponentImpl implements ISalesManagementComponent {

    /**
     * 引入打印日志方法
     */
    protected Logger logger = LoggerFactory.getLogger(this.getClass());

    /**
     * 注入销管接口service
     */
    @Autowired
    private ISalesService salesService;

    /**
     * 注入登录机构服务
     */
    @Autowired
    private ICurrentRbacUserService rbacUserService;
    
    /**
     * 注入平台接口service
     */
    @Autowired
    private IStructureRlshipService structureRlshipService;
    
    /**
     * 获得登录机构
     * 
     * @return String
     */
    
    @Override
    public Map<String, String> getCurrentUser() {
        RbacUserEO user = rbacUserService.findCurrentUser();
        String loginStructureId = (String) BaseContextManager.get().get(BaseContext.PreferenceName.loginStructureId);
        String ownedStructureId = (String) BaseContextManager.get().get(BaseContext.PreferenceName.ownedStructureId);
        String partyId = (String) BaseContextManager.get().get(BaseContext.PreferenceName.partyId);
        String userId = (String) BaseContextManager.get().get(BaseContext.PreferenceName.userId);
        
        if (loginStructureId != null) {
            if (logger.isInfoEnabled()) {
                logger.info("登录机构【" + loginStructureId + "】");
            }
            Map<String, String> userInfo = new HashMap<String, String>();
            userInfo.put("userId", userId);
            userInfo.put("partyId", partyId);
            userInfo.put("ownedStructureId", ownedStructureId);
            userInfo.put("loginStructureId", loginStructureId);
            return userInfo;
        } else {
            if (user != null) {
                if (logger.isInfoEnabled()) {
                    logger.info("用户【" + user.getLoginName() + "】【" + user.getOwnedStructureId() + "】");
                }
                Map<String, String> userInfo = new HashMap<String, String>();
                userInfo.put("userId", user.getUserId());
                userInfo.put("ownedStructureId", user.getOwnedStructureId());
                List<LoginStructure> loginStructures = user.getLoginStructures();
                
                for (int i = 0; i < loginStructures.size(); i++) {
                    loginStructureId = loginStructures.get(i).getStructureId();
                }
                userInfo.put("loginStructureId", loginStructureId);
                return userInfo;
            } else {
                return null;
            }
        }
    }
    
    /**
     * 查询归属部门所在省级代码
     */
    @Override
    public StructureEO findByPartyId(String parentId) {
        long start = System.currentTimeMillis();
        StructureEO findByPartyId = structureRlshipService.findByPartyId(StructureRlshipTypeEnum.SalesManage.getCode(),
                parentId);
        logger.info(
                "SalesManagementComponentImpl.findByPartyId?parentId={} 调用structureRlshipService.findByPartyId耗时：{} ms.",
                parentId, (System.currentTimeMillis() - start));
        if (findByPartyId != null) {
            return findByPartyId;
        } else {
            return null;
        }
    }

}
