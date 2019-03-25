package com.chinalife.risksurvey.component.impl;

import com.chinalife.base.component.impl.BaseComponentImpl;

import java.util.HashMap;
import java.util.Map;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import com.chinalife.risksurvey.component.ISurveyRelBusinessComponent;
import com.chinalife.risksurvey.entity.SurveyMainEO;
import com.chinalife.risksurvey.entity.SurveyRelBusinessEO;
import com.chinalife.risksurvey.repository.ISurveyMainRepository;
import com.chinalife.risksurvey.repository.ISurveyRelBusinessRepository;

/**
 * surveyRelBusinessComponent
 * 关联业务表
 */
@Component("surveyRelBusinessComponent")
public class SurveyRelBusinessComponentImpl  extends BaseComponentImpl<SurveyRelBusinessEO, ISurveyRelBusinessRepository> implements ISurveyRelBusinessComponent {

    /**
     * surveyRelBusinessRepository
     */
    @Autowired
    private ISurveyRelBusinessRepository surveyRelBusinessRepository;
    /**
     * surveyMainRepository
     */
    @Autowired
    private ISurveyMainRepository  surveyMainRepository; 
    
    @Override
    public Object insertOrUpdateSurveyRelBusiness(SurveyRelBusinessEO surveyRelBusinessEO) {
        surveyRelBusinessRepository.insertOrUpdate(surveyRelBusinessEO);
        
        return "success";
    }


    @Override
    public Map<String, Object> findSurveyIdExist(String businessNo) {
        Map<String, Object> map = new HashMap<String, Object>();
        SurveyRelBusinessEO surveyRelBusinessEO = surveyRelBusinessRepository.findSurveyIdExist(businessNo);
        if (surveyRelBusinessEO != null) {
            SurveyMainEO surveyMainEO = surveyMainRepository.getSurveyMainBySurveyId(surveyRelBusinessEO.getSurveyId());
            if (surveyMainEO.getModifyNo() != null) {
                map.put("businessNo", surveyRelBusinessEO.getBusinessNo());
                map.put("surveyId", surveyRelBusinessEO.getSurveyId());
                map.put("modifyNo", surveyMainEO.getModifyNo());
            } else {
                map.put("businessNo", surveyRelBusinessEO.getBusinessNo());
                map.put("surveyId", surveyRelBusinessEO.getSurveyId());
                map.put("surveyTimes", surveyRelBusinessEO.getSurveyTimes());
            } 
        } else {
            map.put("message", "unexist");
        }
        return map;
    }

    @Override
    public SurveyRelBusinessEO findLastSurveyRelBusinessEOBySurveyId(String surveyId) {
        
        return surveyRelBusinessRepository.findLastSurveyRelBusinessEOBySurveyId(surveyId);
    }
    

    @Override
    public Object updateSurveyRelBusiness(SurveyRelBusinessEO surveyRelBusinessEO) {
        surveyRelBusinessRepository.update(surveyRelBusinessEO);
        
        return "business";
    }

}
