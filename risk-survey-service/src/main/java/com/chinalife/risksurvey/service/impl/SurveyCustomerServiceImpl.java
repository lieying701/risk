package com.chinalife.risksurvey.service.impl;

import com.chinalife.base.service.impl.BaseServiceImpl;
import com.chinalife.risksurvey.repository.ISurveyCustomerRepository;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.chinalife.risksurvey.component.ISurveyCustomerComponent;
import com.chinalife.risksurvey.entity.SurveyCustomerEO;
import com.chinalife.risksurvey.service.ISurveyCustomerService;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * wl 包名称： com.chinalife.risksurvey.service.impl
 * 类名称：SurveyCustomerServiceImpl<br/>
 * 类描述：<br/>
 * 
 * @version <br/>
 *          TODO
 */
@Service("surveyCustomerService")
@RequestMapping("/service/risksurvey/surveyCustomer")
public class SurveyCustomerServiceImpl extends BaseServiceImpl<SurveyCustomerEO, ISurveyCustomerRepository, ISurveyCustomerComponent>
        implements ISurveyCustomerService {

    /**
     * surveyCustomerComponent
     */
    @Autowired
    private ISurveyCustomerComponent surveyCustomerComponent;

    @Override
    public Object insertSurveyCustomer(List<SurveyCustomerEO> surveyCustomer) {

        return surveyCustomerComponent.insertSurveyCustomer(surveyCustomer);
    }
    
    @Override
    public Object updateSurveyCustomer(SurveyCustomerEO surveyCustomer) {

        return surveyCustomerComponent.updateSurveyCustomer(surveyCustomer);
    }
}
