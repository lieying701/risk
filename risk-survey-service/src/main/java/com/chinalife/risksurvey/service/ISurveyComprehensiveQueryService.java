package com.chinalife.risksurvey.service;

import java.util.Map;

import com.chinalife.base.service.IBaseService;
import com.chinalife.base.util.Pagination;
import com.chinalife.risksurvey.component.ISurveyComprehensiveQueryComponent;
import com.chinalife.risksurvey.entity.SurveyMainEO;
import com.chinalife.risksurvey.repository.ISurveyComprehensiveQueryRepository;
import com.chinalife.risksurvey.vo.SurveyComprehensiveQueryVo;

/**
 * 综合查询
 */
public interface ISurveyComprehensiveQueryService
        extends IBaseService<SurveyMainEO, ISurveyComprehensiveQueryRepository, ISurveyComprehensiveQueryComponent> {

    /**
     * @param parameter
     *            parameter
     * @param from
     *            from
     * @param limit
     *            limit
     * @param sorting
     *            sorting
     * @return SurveyComprehensiveQueryVo
     */
    public Pagination<SurveyComprehensiveQueryVo> comprehensiveQuery(Map<String, Object> parameter, Integer from,
            Integer limit, String sorting);

}
