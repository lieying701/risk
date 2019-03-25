package com.chinalife.risksurvey.controller.impl;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.chinalife.base.controller.impl.BaseControllerImpl;
import com.chinalife.risksurvey.component.ISurveyDispatchComponent;

import com.chinalife.risksurvey.controller.ISurveyDispatchController;
import com.chinalife.risksurvey.entity.SurveyDispatchEO;

import com.chinalife.risksurvey.repository.ISurveyDispatchRepository;

import com.chinalife.risksurvey.service.ISurveyDispatchService;


/**   
 * 包名称： com.chinalife.risksurvey.controller.impl 
 * 类名称：SurveyDispatchControllerImpl<br/>    
 * 类描述：<br/>  
 * @version <br/>   
 * 
 */  
@RestController("surveyDispatchController")
@RequestMapping("/controller/risksurvey/SurveyDispatch")
public class SurveyDispatchControllerImpl extends
        BaseControllerImpl<SurveyDispatchEO, ISurveyDispatchRepository, ISurveyDispatchComponent, ISurveyDispatchService>
        implements ISurveyDispatchController {

    /**
     * surveyDispatchService
     */
    @Autowired
    private ISurveyDispatchService surveyDispatchService;
    
    @Override
    @RequestMapping(value = "/findBySurveyId")
    public SurveyDispatchEO findBySurveyId(String surveyId) {
        
        return surveyDispatchService.findBySurveyId(surveyId);
    }

    @Override
    @RequestMapping(value = "/ommitDispatch")
    @ResponseBody
    public String commitDispatch(@RequestBody Map<String, Object> parameters) {
        
        return surveyDispatchService.commitDispatch(parameters);
    }

    
    
    
    

}
