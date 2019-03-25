package com.chinalife.risksurvey.component.impl;

import java.util.Map;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.chinalife.base.component.impl.BaseComponentImpl;

import com.chinalife.base.exception.StandardRuntimeException;
import com.chinalife.rbac.entity.RbacUserEO;
import com.chinalife.rbac.filter.service.ICurrentRbacUserService;
import com.chinalife.risksurvey.component.ISurveyDispatchComponent;

import com.chinalife.risksurvey.entity.SurveyDispatchEO;
import com.chinalife.risksurvey.entity.SurveyMainEO;
import com.chinalife.risksurvey.repository.ISurveyDispatchRepository;
import com.chinalife.risksurvey.repository.ISurveyMainRepository;


/**   
 * 包名称： com.chinalife.risksurvey.component.impl 
 * 类名称：SurveyDispatchComponentImpl<br/>    
 * 类描述：<br/>  
 * @version <br/>   
 *      
 */  
@Component("surveyDispatchComponent")
public class SurveyDispatchComponentImpl extends BaseComponentImpl<SurveyDispatchEO, ISurveyDispatchRepository> implements ISurveyDispatchComponent {
    /**
     * surDispatchRepository
     */
    @Autowired 
    private ISurveyDispatchRepository surDispatchRepository;
    
    /**
     * surveyMainRepository
     */
    @Autowired 
    private ISurveyMainRepository  surveyMainRepository;
    
    /**
     * currentUserService
     */
    @Autowired
    private ICurrentRbacUserService currentUserService;
    
    @Override
    public SurveyDispatchEO findBySurveyId(String surveyId) {
        
        return surDispatchRepository.findBySurveyId(surveyId);
    }
    
    //暂时没用  注意  ！！！
    @Override
    public String commitDispatchAll(Map<String, Object> parameters) {
        RbacUserEO currentUser = currentUserService.findCurrentUser(); 

        if (currentUser == null) {
            throw new StandardRuntimeException("请登录");
        }
        parameters.put("createUserID", currentUser.getLoginName());
        
        String surveyId = (String) parameters.get("surveyId");
        SurveyMainEO surveyMainEO = surveyMainRepository.getSurveyMainBySurveyId(surveyId);
        SurveyDispatchEO surveyDispatchEO = surDispatchRepository.findBySurveyId(surveyId);
        try {
            if (surveyMainEO != null) {
              
                surveyMainEO.setSurveyer(parameters.get("surveyer").toString());
                surveyMainEO.setSurveyerDivisionCode(parameters.get("ownedStructureId").toString());
                surveyMainEO.setSurveyerDivision(parameters.get("ownedStructureName").toString());
                surveyMainRepository.updateSurveyMain(surveyMainEO);
            }
            if (surveyDispatchEO == null) {

                surveyDispatchEO.setSurveyId(parameters.get("surveyId").toString());
                surveyDispatchEO.setRedisptType("1");
                surveyDispatchEO.setOperatorCode(parameters.get("ownedStructureName").toString());
                surveyDispatchEO.setOperator(parameters.get("ownedStructureName").toString());
                surDispatchRepository.insertSurveyDispatchEO(surveyDispatchEO);
            } else {
                SurveyDispatchEO newSurveyDispatchEO = new SurveyDispatchEO();
                BeanUtils.copyProperties(surveyDispatchEO, newSurveyDispatchEO);
                newSurveyDispatchEO.setRedisptType("2");
                newSurveyDispatchEO.setOperatorCode(parameters.get("ownedStructureName").toString());
                newSurveyDispatchEO.setOperator(parameters.get("ownedStructureName").toString());
                newSurveyDispatchEO.setOldOperator(surveyDispatchEO.getOperator());
                newSurveyDispatchEO.setOldOperatorCode(surveyDispatchEO.getOperateDeptCode());
                surDispatchRepository.update(surveyDispatchEO);
            }
             
        

            return "success";
        } catch (Exception e) {
            // TODO: handle exception

            throw new StandardRuntimeException(e);

        }
                              
        
    }




}
