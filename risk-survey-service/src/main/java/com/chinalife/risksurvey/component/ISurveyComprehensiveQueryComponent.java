package com.chinalife.risksurvey.component;

import java.util.Map;

import com.chinalife.base.component.IBaseComponent;
import com.chinalife.base.util.Pagination;

import com.chinalife.risksurvey.entity.SurveyMainEO;
import com.chinalife.risksurvey.repository.ISurveyComprehensiveQueryRepository;
import com.chinalife.risksurvey.vo.SurveyComprehensiveQueryVo;

/**
 * 包名称： com.chinalife.risksurvey.component 类名称：IListRiskSurveyComponent<br/>
 * 类描述：<br/>
 * 111
 * @version <br/>
 *          TODO
 */
public interface ISurveyComprehensiveQueryComponent extends IBaseComponent<SurveyMainEO, ISurveyComprehensiveQueryRepository> {

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
