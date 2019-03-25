package com.chinalife.risksurvey.repository.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Repository;

import com.chinalife.base.repository.impl.GPBaseRepositoryImpl;
import com.chinalife.base.util.JsonUtils;
import com.chinalife.base.util.Pagination;

import com.chinalife.risksurvey.entity.SurveyCustomerEO;
import com.chinalife.risksurvey.entity.SurveyMainEO;
import com.chinalife.risksurvey.entity.SurveyRelBusinessEO;
import com.chinalife.risksurvey.repository.ISurveyComprehensiveQueryRepository;
import com.chinalife.risksurvey.utils.QueryCondition;
import com.chinalife.risksurvey.vo.SurveyComprehensiveQueryVo;

/**
 * 综合查询
 */
@SuppressWarnings("unchecked")
@Repository("surveyComprehensiveQueryRepository")
public class SurveyComprehensiveQueryRepositoryImpl extends GPBaseRepositoryImpl<SurveyMainEO>
        implements ISurveyComprehensiveQueryRepository {

    @Override
    public Pagination<SurveyComprehensiveQueryVo> listSurveyMains(Map<String, Object> parameter,
            QueryCondition queryCondition, Integer from, Integer limit) {

        String hql = "select m,c,r" + " from SurveyMainEO m left join SurveyCustomerEO c on m.surveyId = c.surveyId "
                + " left join SurveyRelBusinessEO r on m.surveyId = r.surveyId";
        StringBuilder sb = new StringBuilder();
        sb.append(" where 1=1");
        //sb.append("  and m.status = ? ");

        String desc = queryCondition.getSort();
        List<Object> values = queryCondition.getValues();
        int i = 0;
        // 保险人和被保险人
        if (parameter != null) {
            String applicantName = (String) parameter.get("applicantName");
            if (null != applicantName && applicantName.length() > 0) {
                // sb.append("and c.customerFlag = ?");
                sb.append(" and c.customerName like ?  ");
                values.add(0, "%" + applicantName + "%");
                sb.append("or c.customereName like  ? ");
                values.add(1, "%" + applicantName + "%");
                i = i + 2;
            }
            String insurantName = (String) parameter.get("insurantName");
            if (null != insurantName && insurantName.length() > 0) {
                sb.append(" and c.customerName like ?  ");
                values.add(i, "%" + insurantName + "%");
                sb.append("or c.customereName like  ? ");
                values.add(i + 1, "%" + insurantName + "%");
            }
        }
        sb.append(queryCondition.getSql());

        if (desc == null || desc.trim().length() == 0) {
            sb.append(" order by m.taskStarterDate desc ");
        }
        String hqlStr = hql + sb;
        long startTime = System.currentTimeMillis();
        Pagination<Object[]> l = (Pagination<Object[]>) getBaseQueryRepository().findPagination(hqlStr,
                values.toArray(), from, limit);
        long endTime = System.currentTimeMillis();
        long totalTime = endTime - startTime;

        if (logger.isWarnEnabled() && totalTime > 1000000) {
            logger.warn("HQL耗时【{}】ms，HQL【{}】，参数表【{}】,from【{}】,limit【{}】", totalTime, hqlStr,
                    JsonUtils.toJsonString(values, false), from, limit);
        }
        Pagination<SurveyComprehensiveQueryVo> result = new Pagination<SurveyComprehensiveQueryVo>();
        result.setEntityCount$(l.getEntityCount$());
        if (l.getData$() == null || l.getData$().size() == 0) {
            return null;
        }

        List<Object[]> list = l.getData$();
        List<SurveyComprehensiveQueryVo> resultList = new ArrayList<SurveyComprehensiveQueryVo>();
        for (Object[] ob : list) {
            SurveyComprehensiveQueryVo comprehensive = new SurveyComprehensiveQueryVo();
            SurveyMainEO surveyMainEO = (SurveyMainEO) ob[0];
            SurveyRelBusinessEO surveyRelBusinessEO = (SurveyRelBusinessEO) ob[2];
            SurveyCustomerEO surveyCustomerEO = (SurveyCustomerEO) ob[1];
            if (surveyRelBusinessEO != null) {
                BeanUtils.copyProperties(surveyRelBusinessEO, comprehensive);
            }
            BeanUtils.copyProperties(surveyMainEO, comprehensive);
            if (surveyCustomerEO != null) {
                BeanUtils.copyProperties(surveyCustomerEO, comprehensive);
            }
            comprehensive.setIndexId(surveyMainEO.getPkId());
            resultList.add(comprehensive);
        }
        result.setData$(resultList);
        result.setFrom(from);
        result.setLimit(limit);

        return result;
    }
}
