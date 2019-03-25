package com.chinalife.risksurvey.service.impl;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestMapping;


import com.chinalife.base.service.impl.BaseServiceImpl;
import com.chinalife.base.util.Pagination;
import com.chinalife.risksurvey.component.ISurveyComprehensiveQueryComponent;
import com.chinalife.risksurvey.entity.SurveyMainEO;
import com.chinalife.risksurvey.repository.ISurveyComprehensiveQueryRepository;
import com.chinalife.risksurvey.service.ISurveyComprehensiveQueryService;
import com.chinalife.risksurvey.vo.SurveyComprehensiveQueryVo;

/**   
 * surveyComprehensiveQueryService
 */  
@Service("surveyComprehensiveQueryService")
@RequestMapping("/service/contract/query")
public class SurveyComprehensiveQueryServiceImpl
        extends BaseServiceImpl<SurveyMainEO, ISurveyComprehensiveQueryRepository, ISurveyComprehensiveQueryComponent>
        implements ISurveyComprehensiveQueryService {
    
    /**
     * surveyComprehensiveQueryComponent
     */
    @Autowired 
    private ISurveyComprehensiveQueryComponent  surveyComprehensiveQueryComponent;
    
    @Override
    public Pagination<SurveyComprehensiveQueryVo> comprehensiveQuery(Map<String, Object> parameter, Integer from, Integer limit, String sorting) {
        
        return surveyComprehensiveQueryComponent.comprehensiveQuery(parameter, from, limit, sorting);
    }
    
}
