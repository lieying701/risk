package com.chinalife.risksurvey.service.impl;

import com.chinalife.base.service.impl.BaseServiceImpl;
import com.chinalife.risksurvey.repository.ISurveyRelBusinessRepository;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.chinalife.risksurvey.component.ISurveyRelBusinessComponent;
import com.chinalife.risksurvey.entity.SurveyRelBusinessEO;
import com.chinalife.risksurvey.service.ISurveyRelBusinessService;

import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * wl 包名称： com.chinalife.risksurvey.service.impl
 * 类名称：SurveyRelBusinessServiceImpl<br/>
 * 类描述：<br/>
 * 
 * @version <br/>
 *          TODO
 */
@Service("surveyRelBusinessService")
@RequestMapping("/service/risksurvey/surveyRelBusiness")
public class SurveyRelBusinessServiceImpl extends BaseServiceImpl<SurveyRelBusinessEO, ISurveyRelBusinessRepository, ISurveyRelBusinessComponent> implements ISurveyRelBusinessService {

    /**
     * surveyRelBusinessComponent
     */
    @Autowired
    private ISurveyRelBusinessComponent surveyRelBusinessComponent;

    @Override
    @RequestMapping("insertSurveyRelBusiness")
    public Object insertOrUpdateSurveyRelBusiness(SurveyRelBusinessEO surveyRelBusiness) {

        return surveyRelBusinessComponent.insertOrUpdateSurveyRelBusiness(surveyRelBusiness);
    }


    @Override
    @RequestMapping("findSurveyIdExist")
    public Map<String, Object> findSurveyIdExist(String bussinessNo) {
        
        return surveyRelBusinessComponent.findSurveyIdExist(bussinessNo);
    }

    @Override
    @RequestMapping("findLastSurveyRelBusinessEOBySurveyId")
    @ResponseBody
    public SurveyRelBusinessEO findLastSurveyRelBusinessEOBySurveyId(@RequestBody String surveyId) {
        
        return surveyRelBusinessComponent.findLastSurveyRelBusinessEOBySurveyId(surveyId);
    }


    @Override
    public Object updateSurveyRelBusiness(SurveyRelBusinessEO surveyRelBusiness) {
        surveyRelBusinessComponent.updateSurveyRelBusiness(surveyRelBusiness);
        
        return "business";
    }

}
