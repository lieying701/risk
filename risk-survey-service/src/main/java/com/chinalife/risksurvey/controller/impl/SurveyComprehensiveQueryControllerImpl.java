package com.chinalife.risksurvey.controller.impl;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;


import com.chinalife.base.controller.impl.BaseControllerImpl;
import com.chinalife.base.util.Pagination;
import com.chinalife.risksurvey.component.ISurveyComprehensiveQueryComponent;
import com.chinalife.risksurvey.controller.ISurveyComprehensiveQueryController;
import com.chinalife.risksurvey.entity.SurveyMainEO;
import com.chinalife.risksurvey.repository.ISurveyComprehensiveQueryRepository;
import com.chinalife.risksurvey.service.ISurveyComprehensiveQueryService;
import com.chinalife.risksurvey.vo.SurveyComprehensiveQueryVo;

/**    
 * 综合查询
 */  
@RestController("surveyComprehensiveQueryController")
@RequestMapping("/controller/risksurvey/query")
public class SurveyComprehensiveQueryControllerImpl extends
        BaseControllerImpl<SurveyMainEO, ISurveyComprehensiveQueryRepository, ISurveyComprehensiveQueryComponent, ISurveyComprehensiveQueryService>
        implements ISurveyComprehensiveQueryController {
   
    /**
     * surveyComprehensiveQueryService
     */
    @Autowired
    private ISurveyComprehensiveQueryService surveyComprehensiveQueryService;
    
    @Override
    @RequestMapping(value = "/comprehensive")
    @ResponseBody
    public Pagination<SurveyComprehensiveQueryVo> comprehensiveQuery(
            @RequestBody(required = false) Map<String, Object> parameter, @RequestParam("from") Integer from,
            @RequestParam("limit") Integer limit, @RequestParam(value = "sorting", required = false) String sorting) {
        return surveyComprehensiveQueryService.comprehensiveQuery(parameter, from, limit, sorting);
    }

}
