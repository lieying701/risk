package com.chinalife.risksurvey.repository;

import com.chinalife.base.repository.IGPBaseRepository;
import com.chinalife.risksurvey.entity.SurveyCustomerEO;

/**
 * SurveyCustomerEO
 * 客户信息EO 
 */
public interface ISurveyCustomerRepository extends IGPBaseRepository<SurveyCustomerEO> {
    
    /**
     * 发起风勘 添加客户信息
     * @param surveyCustomerEO
     *        surveyCustomerEO
     */
    public void insertSurveyCustomer(SurveyCustomerEO surveyCustomerEO);
        

}
