package com.chinalife.risksurvey.component.impl;

import com.chinalife.base.component.impl.BaseComponentImpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.chinalife.risksurvey.component.ISurveyCustomerComponent;
import com.chinalife.risksurvey.entity.SurveyCustomerEO;
import com.chinalife.risksurvey.repository.ISurveyCustomerRepository;

/**
 * surveyCustomerComponent
 * 客户信息
 */
@Component("surveyCustomerComponent")
public class SurveyCustomerComponentImpl extends BaseComponentImpl<SurveyCustomerEO, ISurveyCustomerRepository> implements ISurveyCustomerComponent {

    /**
     * surveyCustomerRepository
     */
    @Autowired
    private ISurveyCustomerRepository surveyCustomerRepository;
    
    @Override
    public Object insertSurveyCustomer(List<SurveyCustomerEO> surveyCustomerEO) {
        surveyCustomerRepository.insertOrUpdateAll(surveyCustomerEO);
        
        return "success";
    }

    @Override
    public Object updateSurveyCustomer(SurveyCustomerEO surveyCustomerEO) {
        surveyCustomerRepository.update(surveyCustomerEO);
        
        return "customer";
    }
}
