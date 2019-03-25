package com.chinalife.risksurvey.component;

import java.util.List;

import com.chinalife.base.component.IBaseComponent;
import com.chinalife.risksurvey.entity.SurveyCustomerEO;
import com.chinalife.risksurvey.repository.ISurveyCustomerRepository;

/**
 * component
 * 包名称： com.chinalife.risksurvey.component 
 */
public interface ISurveyCustomerComponent  extends IBaseComponent<SurveyCustomerEO, ISurveyCustomerRepository> {
    
    /**
     * 
     * @param surveyCustomer surveyCustomerEO
     * @return Object
     */
    public Object insertSurveyCustomer(List<SurveyCustomerEO> surveyCustomer);
    
    /**
     * 
     * @param surveyCustomerEO surveyCustomerEO
     * @return Object
     */
    public Object updateSurveyCustomer(SurveyCustomerEO surveyCustomerEO);
}
