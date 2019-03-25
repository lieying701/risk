package com.chinalife.risksurvey.service;

import java.util.List;

import com.chinalife.base.service.IBaseService;
import com.chinalife.risksurvey.component.ISurveyCustomerComponent;
import com.chinalife.risksurvey.entity.SurveyCustomerEO;
import com.chinalife.risksurvey.repository.ISurveyCustomerRepository;

/**
 * 客户信息 SurveyCustomerEO
 */
public interface ISurveyCustomerService extends IBaseService<SurveyCustomerEO, ISurveyCustomerRepository, ISurveyCustomerComponent> {
    
    /**
     * 
     * @param surveyCustomer surveyCustomer
     * @return Object
     */
    public Object insertSurveyCustomer(List<SurveyCustomerEO> surveyCustomer);
    
    /**
     * 
     * @param surveyCustomer surveyCustomer
     * @return Object
     */
    public Object updateSurveyCustomer(SurveyCustomerEO surveyCustomer);
}
