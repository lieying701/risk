package com.chinalife.risksurvey.service.impl;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


import com.chinalife.base.service.impl.BaseServiceImpl;
import com.chinalife.base.util.Pagination;


import com.chinalife.risksurvey.component.ISurveyTaskQueryComponent;
import com.chinalife.risksurvey.entity.SurveyTaskEO;
import com.chinalife.risksurvey.repository.ISurveyTaskQueryRepository;
import com.chinalife.risksurvey.service.ISurveyTaskQueryService;


/**
 * 包名称： com.chinalife.risksurvey.service.impl
 * 类名称：SurveyTaskQueryServiceImpl<br/>
 * 类描述：<br/>
 * 
 * @version <br/>
 * 
 */

@RestController("surveyTaskQueryService")
@RequestMapping("/service/risksurvery/surveyTaskQueryService")
public class SurveyTaskQueryServiceImpl
        extends BaseServiceImpl<SurveyTaskEO, ISurveyTaskQueryRepository, ISurveyTaskQueryComponent>
        implements ISurveyTaskQueryService {

 

    /**
     * ISurveyTaskQueryComponent
     */
    @Autowired
    ISurveyTaskQueryComponent surveyTaskQueryComponent;

    @Override
    public Pagination<SurveyTaskEO> getMyDoingTaskPages(Map<String, Object> parameters, int from,
            int limit, String sorting) {
       
        return surveyTaskQueryComponent.getMyDoingTaskPages(parameters, from, limit, sorting);
    }
    
    @Override
    public Pagination<SurveyTaskEO> findUnassignrisk(Map<String, Object> parameter, Integer from, Integer limit, String sorting) {
        
        return surveyTaskQueryComponent.findUnassignrisk(parameter, from, limit, sorting);
    }
}
