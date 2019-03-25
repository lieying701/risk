package com.chinalife.risksurvey.task.repository;

import com.chinalife.base.repository.IGPBaseRepository;
import com.chinalife.risksurvey.entity.SurveyTaskEO;

import java.util.List;

/**
 * 包名称： com.chinalife.uw.repository 类名称：ISurveyTaskRepository<br/>
 * 类描述：<br/>
 * 创建人：@author axue016<br/>
 * 创建时间：Jun 20, 2017/3:23:02 PM<br/>
 */
public interface ISurveyTaskRepository extends IGPBaseRepository<SurveyTaskEO> {
    /**
     * find
     *
     * @param taskId
     *            taskId
     * @param kindList
     *            kind
     *
     * @return SurveyTaskEO
     */
    SurveyTaskEO findTaskByTaskId(String taskId, List<String> kindList);

    /**
     * find undone task
     *
     * @param surveyId
     *            surveyId
     * @param kindList
     *            kind
     *
     * @return SurveyTaskEO
     */
    SurveyTaskEO findUndoneTaskBySurveyId(Long surveyId, List<String> kindList);

    /**
     * 根据surveyId查找最新更改的数据
     *
     * @param surveyId
     *            surveyId
     * @param kindList
     *            kind
     *
     * @return SurveyTaskEO
     */
    SurveyTaskEO findLastTaskBySurveyId(Long surveyId, List<String> kindList);

    /**
     * 查找未完成的任务
     *
     * @param taskId
     *            taskId
     * @param kindList
     *            kind
     *
     * @return SurveyTaskEO
     */
    SurveyTaskEO findUndoneByTaskId(String taskId, List<String> kindList);

    /**
     * find undone by taskIds
     *
     * @param taskIds
     *            taskIds
     * @param kindList
     *            kind
     *
     * @return list
     */
    List<SurveyTaskEO> findUndoneByTaskIds(List<String> taskIds, List<String> kindList);

    /**
     * 获取批改查询的最新任务
     *
     * @param surveyIdArray
     *            surveyIdArray
     *
     * @return List<SurveyTaskEO>
     */
    List<SurveyTaskEO> findLastBySurveyIds(String[] surveyIdArray);

    /**
     * 根据surveyId查询任务记录条数
     * 
     * @param surveyId
     *            surveyId
     * @return Long
     */
    Long getCountBySurveyId(Long surveyId);

    /**
     * 根据surveyId查询所有有最新标志的任务，一盘只有一条；
     * 
     * @param surveyId
     *            surveyId
     * @return List<SurveyTaskEO>
     */
    List<SurveyTaskEO> getAllNewBySurveyId(Long surveyId);
}
