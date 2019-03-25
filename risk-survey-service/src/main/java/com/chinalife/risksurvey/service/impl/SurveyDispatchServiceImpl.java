package com.chinalife.risksurvey.service.impl;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;


import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.chinalife.base.service.impl.BaseServiceImpl;
import com.chinalife.risksurvey.component.ISurveyDispatchComponent;
import com.chinalife.risksurvey.entity.SurveyDispatchEO;

import com.chinalife.risksurvey.repository.ISurveyDispatchRepository;
import com.chinalife.risksurvey.service.ISurveyDispatchService;
import com.chinalife.risksurvey.service.ISurveyMainService;

/**   
 * 包名称： com.chinalife.risksurvey.service.impl 
 * 类名称：SurveyDispatchServiceImpl<br/>    
 * 类描述：<br/>  
 * @version <br/>   
 *      
 */ 
@RestController("surveyDispatchService")
@RequestMapping("/service/risksurvery/surveyDispatchService")
public class SurveyDispatchServiceImpl extends BaseServiceImpl<SurveyDispatchEO, ISurveyDispatchRepository,  ISurveyDispatchComponent> implements  ISurveyDispatchService {

    /**
     * surveyDispatchComponent
     */
    @Autowired
    private ISurveyDispatchComponent surveyDispatchComponent;
    /**
     * surveyMainService
     */
    @Autowired
    private ISurveyMainService  surveyMainService;
    
    @Override
    @RequestMapping(value = "/findBySurveyId")
    public SurveyDispatchEO findBySurveyId(String surveyId) {
        
        return surveyDispatchComponent.findBySurveyId(surveyId);
    }
    //（ 暂时没用
    
    @Override 
    @RequestMapping(value = "/commitDispatch")
    public String commitDispatch(Map<String, Object> parameters) {

        return surveyDispatchComponent.commitDispatchAll(parameters);
    }




    

}
