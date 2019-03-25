package com.chinalife.risksurvey.repository;

import java.util.Map;

import com.chinalife.base.repository.IGPBaseRepository;
import com.chinalife.base.util.Pagination;
import com.chinalife.risksurvey.entity.SurveyMainEO;
import com.chinalife.risksurvey.utils.QueryCondition;
import com.chinalife.risksurvey.vo.SurveyComprehensiveQueryVo;

/**      
 * 综合查询     
 */  
public interface ISurveyComprehensiveQueryRepository extends IGPBaseRepository<SurveyMainEO> {

   

    /**
     * @param parameter parameter
     * @param queryCondition queryCondition
     * @param from  from
     * @param limit limit
     * @return SurveyComprehensiveQueryVo
     */
    public Pagination<SurveyComprehensiveQueryVo> listSurveyMains(Map<String, Object> parameter,
            QueryCondition queryCondition, Integer from, Integer limit);

}
