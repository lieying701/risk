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
import com.chinalife.risksurvey.component.ISurveyTaskQueryComponent;
import com.chinalife.risksurvey.controller.ISurveyTaskQueryController;

import com.chinalife.risksurvey.entity.SurveyTaskEO;
import com.chinalife.risksurvey.repository.ISurveyTaskQueryRepository;
import com.chinalife.risksurvey.service.ISurveyTaskQueryService;


/**   
 * 包名称： com.chinalife.risksurvey.controller.impl 
 * 类名称：SurveyTaskQueryControllerImpl<br/>    
 * 类描述：<br/>  
 * @version <br/>       
 */  
@RestController("surveyTaskQueryController")
@RequestMapping("/controller/risksurvey/surveytaskqueryall")
public class SurveyTaskQueryControllerImpl  extends BaseControllerImpl<SurveyTaskEO, ISurveyTaskQueryRepository,  ISurveyTaskQueryComponent,ISurveyTaskQueryService> 
    implements ISurveyTaskQueryController {
    
 
    
    /**
     * surveyTaskQueryService
     */
    @Autowired
    private ISurveyTaskQueryService surveyTaskQueryService;
    
    /**
     * 根据条件查询我的任务分页列表
     */
    
    @Override
    @RequestMapping(value = "/findTaskPages")
    @ResponseBody
    public Pagination<SurveyTaskEO> getMyDoingTaskPages(@RequestBody(required = false) Map<String, Object> parameters,
                                                   @RequestParam("from") int from, @RequestParam("limit") int limit,
                                                   @RequestParam(value = "sorting", required = false) String sorting) {
        return this.surveyTaskQueryService.getMyDoingTaskPages(parameters, from, limit, sorting);
    }
    
    @Override
    @RequestMapping(value = "/findUnassignrisk")
    @ResponseBody
    public Pagination<SurveyTaskEO> findUnassignrisk(
            @RequestBody(required = false) Map<String, Object> parameter, @RequestParam("from") Integer from,
            @RequestParam("limit") Integer limit, @RequestParam(value = "sorting", required = false) String sorting) {
        return surveyTaskQueryService.findUnassignrisk(parameter, from, limit, sorting);
    }
  
}
