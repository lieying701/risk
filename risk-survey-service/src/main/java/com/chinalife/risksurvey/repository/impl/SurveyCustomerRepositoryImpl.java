package com.chinalife.risksurvey.repository.impl;

import org.springframework.stereotype.Repository;

import com.chinalife.base.repository.impl.GPBaseRepositoryImpl;

import com.chinalife.risksurvey.entity.SurveyCustomerEO;
import com.chinalife.risksurvey.repository.ISurveyCustomerRepository;

/**
 * surveyCustomerEO
 * 客户信息 
 */
@Repository("surveyCustomerRepository")
public class SurveyCustomerRepositoryImpl extends GPBaseRepositoryImpl<SurveyCustomerEO> 
            implements ISurveyCustomerRepository {

    @Override
    public void insertSurveyCustomer(SurveyCustomerEO surveyCustomerEO) {
        
        this.insert(surveyCustomerEO);
        
    }
    

}
