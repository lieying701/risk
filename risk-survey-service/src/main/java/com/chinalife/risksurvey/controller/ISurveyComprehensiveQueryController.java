package com.chinalife.risksurvey.controller;

import java.util.Map;

import com.chinalife.base.controller.IBaseController;
import com.chinalife.base.util.Pagination;

import com.chinalife.risksurvey.component.ISurveyComprehensiveQueryComponent;
import com.chinalife.risksurvey.entity.SurveyMainEO;
import com.chinalife.risksurvey.repository.ISurveyComprehensiveQueryRepository;
import com.chinalife.risksurvey.service.ISurveyComprehensiveQueryService;
import com.chinalife.risksurvey.vo.SurveyComprehensiveQueryVo;

/**
 * 综合查询
 */
public interface ISurveyComprehensiveQueryController extends IBaseController<SurveyMainEO, ISurveyComprehensiveQueryRepository, ISurveyComprehensiveQueryComponent, ISurveyComprehensiveQueryService> {

    /** 未分配任务查询
     * @param parameter 条件
     * @param from  页
     * @param limit  数
     * @param sorting  排序
     * @return  mainEO
     */
    public Pagination<SurveyComprehensiveQueryVo> comprehensiveQuery(Map<String, Object> parameter, Integer from, Integer limit, String sorting);
    
    
}
