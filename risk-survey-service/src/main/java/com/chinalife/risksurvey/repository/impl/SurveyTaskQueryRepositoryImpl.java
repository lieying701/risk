package com.chinalife.risksurvey.repository.impl;


import java.util.List;
import java.util.Map;


import org.springframework.stereotype.Repository;

import com.chinalife.base.repository.impl.GPBaseRepositoryImpl;
import com.chinalife.base.util.JsonUtils;
import com.chinalife.base.util.Pagination;

import com.chinalife.risksurvey.entity.SurveyTaskEO;
import com.chinalife.risksurvey.enums.SurveyStatusEnums;
import com.chinalife.risksurvey.repository.ISurveyTaskQueryRepository;
import com.chinalife.risksurvey.utils.QueryCondition;


/**
 * 
 * @version <br/>
 */
@Repository("surveyTaskQueryRepository")
public class SurveyTaskQueryRepositoryImpl extends GPBaseRepositoryImpl<SurveyTaskEO>
        implements ISurveyTaskQueryRepository {

    /**
     * 待办任务
     */
    @SuppressWarnings("unchecked")
    @Override
    public Pagination<SurveyTaskEO> findSurveyTask(Map<String, Object> parameters,
            QueryCondition queryCondition, Integer from, Integer limit) {
        String hql = "select t " + " from SurveyTaskEO t ";
        StringBuilder sb = new StringBuilder();
        sb.append(" where 1 = 1 and newFlag = '1'");
        sb.append(queryCondition.getSql());
        sb.append("  and t.surveyStatus in (?,?,?,?)");
        String desc = queryCondition.getSort();
        List<Object> values = queryCondition.getValues();
        values.add(SurveyStatusEnums.SAVE.getCode());
        values.add(SurveyStatusEnums.ASSIGNED.getCode());
        values.add(SurveyStatusEnums.UNCOMMITTED.getCode());
        values.add(SurveyStatusEnums.ADDTASKENTERING.getCode());
        
        // 被保险人
        if (parameters != null) {
            String insurantName = (String) parameters.get("insurantName");
            if (null != insurantName && insurantName.length() > 0) {
                // sb.append("and c.customerFlag = ?");
                sb.append(" and t.insurantName like ?   ");
                values.add("%" + insurantName + "%");
         
            }
            String taskStarterDate = (String) parameters.get("taskStarterDate");
            if (null != taskStarterDate && !"".equals(taskStarterDate)) {
                taskStarterDate = taskStarterDate.substring(0, 10);
                sb.append(
                        " and to_date(to_char(t.taskStarterDate,'yyyy-MM-dd'),'yyyy-MM-dd') <= to_date( ?,'yyyy-MM-dd') ");
                values.add(taskStarterDate);
            }
        }
       
        if (desc == null || desc.trim().length() == 0) {
            sb.append(" order by t.surveyId desc ");
        }
         
        String hqlStr = hql + sb;
        long startTime = System.currentTimeMillis();
        Pagination<SurveyTaskEO> l = (Pagination<SurveyTaskEO>) getBaseQueryRepository().findPagination(hqlStr,
                values.toArray(), from, limit);
        long endTime = System.currentTimeMillis();
        long totalTime = endTime - startTime;

        if (logger.isWarnEnabled() && totalTime > 1000000) {
            logger.warn("HQL耗时【{}】ms，HQL【{}】，参数表【{}】,from【{}】,limit【{}】", totalTime, hqlStr,
                    JsonUtils.toJsonString(values, false), from, limit);
        }
        Pagination<SurveyTaskEO> result = new Pagination<SurveyTaskEO>();
        result.setEntityCount$(l.getEntityCount$());
        if (l.getData$() == null || l.getData$().size() == 0) {
            return null;
        }
        List<SurveyTaskEO> list = l.getData$();
        result.setData$(list);
        result.setFrom(from);
        result.setLimit(limit);

        return result;

    }
    
    /**
     * 未分派任务查询
     */
    @SuppressWarnings("unchecked")
    @Override
    public Pagination<SurveyTaskEO> listSurveyMains(Map<String, Object> parameter,
            QueryCondition queryCondition, Integer from, Integer limit) {

        String hql = "select t from SurveyTaskEO t ";
        StringBuilder sb = new StringBuilder();
        sb.append(" where 1=1 and newFlag = '1' ");
        sb.append(queryCondition.getSql());
        sb.append(" and t.surveyStatus = ? ");
        String desc = queryCondition.getSort();
        List<Object> values = queryCondition.getValues();
        values.add(SurveyStatusEnums.UNASSIGNED.getCode());
        // values.add(0,"未分配");
        // 被保险人
        if (parameter != null) {
            String insurantName = (String) parameter.get("insurantName");
            if (null != insurantName && insurantName.length() > 0) {
                // sb.append("and c.customerFlag = ?");
                sb.append(" and t.insurantName like ? ");
                values.add("%" + insurantName + "%");
         
            }
            String taskStarterDate = (String) parameter.get("taskStarterDate");
            if (null != taskStarterDate && !"".equals(taskStarterDate)) {
                taskStarterDate = taskStarterDate.substring(0, 10);
                sb.append(
                        " and to_date(to_char(t.taskStarterDate,'yyyy-MM-dd'),'yyyy-MM-dd') <= to_date( ?,'yyyy-MM-dd') ");
                values.add(taskStarterDate);
            }
        }

        if (desc == null || desc.trim().length() == 0) {
            sb.append(" order by t.surveyId desc ");
        }
        String hqlStr = hql + sb;
        long startTime = System.currentTimeMillis();
        Pagination<SurveyTaskEO> l =  (Pagination<SurveyTaskEO>) getBaseQueryRepository().findPagination(hqlStr,
                values.toArray(), from, limit);
        long endTime = System.currentTimeMillis();
        long totalTime = endTime - startTime;

        if (logger.isWarnEnabled() && totalTime > 1000000) {
            logger.warn("HQL耗时【{}】ms，HQL【{}】，参数表【{}】,from【{}】,limit【{}】", totalTime, hqlStr,
                    JsonUtils.toJsonString(values, false), from, limit);
        }
        Pagination<SurveyTaskEO> result = new Pagination<SurveyTaskEO>();
        result.setEntityCount$(l.getEntityCount$());
        if (l.getData$() == null || l.getData$().size() == 0) {
            return null;
        }

        List<SurveyTaskEO> list = l.getData$();
        result.setData$(list);
        result.setFrom(from);
        result.setLimit(limit);

        return result;
    }

}
