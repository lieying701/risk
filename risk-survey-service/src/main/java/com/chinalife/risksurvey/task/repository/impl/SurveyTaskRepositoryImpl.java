package com.chinalife.risksurvey.task.repository.impl;

import java.util.List;

import org.apache.commons.collections.CollectionUtils;
import org.springframework.stereotype.Repository;

import com.chinalife.base.repository.impl.GPBaseRepositoryImpl;
import com.chinalife.base.util.ObjectUtils;
import com.chinalife.risksurvey.entity.SurveyTaskEO;
import com.chinalife.risksurvey.task.constants.TaskStatusEnum;
import com.chinalife.risksurvey.task.repository.ISurveyTaskRepository;

/**
 * 包名称： com.chinalife.uw.repository.impl 类名称：SurveyTaskRepositoryImpl<br/>
 * 类描述：insuranceTaskRepository<br/>
 * 创建人：@author axue016<br/>
 * 创建时间：Jun 20, 2017/3:24:21 PM<br/>
 */
@Repository("surveyTaskRepository")
public class SurveyTaskRepositoryImpl extends GPBaseRepositoryImpl<SurveyTaskEO> implements ISurveyTaskRepository {

    @Override
    public SurveyTaskEO findTaskByTaskId(String taskId, List<String> kindList) {
        List<SurveyTaskEO> list = this.listByCondition("taskId = ? ", ObjectUtils.asArray(taskId), "");
        return CollectionUtils.isNotEmpty(list) ? list.get(0) : null;
    }

    @Override
    public SurveyTaskEO findUndoneTaskBySurveyId(Long surveyId, List<String> kindList) {
        // return this.findByCondition("surveyId=? and status!=?",
        // ObjectUtils.asArray(surveyId,
        // TaskStatusEnum.Processed.getCode()), " serialNo desc ");
        return this.findByCondition("surveyId=? and status!=? ",
                ObjectUtils.asArray(surveyId, TaskStatusEnum.Processed.getCode()), "  serialNo desc ");
    }

    @Override
    public SurveyTaskEO findLastTaskBySurveyId(Long surveyId, List<String> kindList) {
        return this.findByCondition("surveyId=?  and newFlag='1'", ObjectUtils.asArray(surveyId), " serialNo desc ");
    }

    @Override
    public SurveyTaskEO findUndoneByTaskId(String taskId, List<String> kindList) {
        List<SurveyTaskEO> list = this.listByCondition(" taskId=? and status!=? ",
                ObjectUtils.asArray(taskId, TaskStatusEnum.Processed.getCode()), " serialNo desc ");
        return CollectionUtils.isEmpty(list) ? null : list.get(0);
    }

    @Override
    public List<SurveyTaskEO> findUndoneByTaskIds(List<String> taskIds, List<String> kindList) {

        StringBuilder sb = new StringBuilder();
        Object[] paramArray = new Object[taskIds.size() + 1];
        paramArray[0] = TaskStatusEnum.Processed.getCode();
        for (int i = 0; i < taskIds.size(); i++) {
            paramArray[i + 1] = taskIds.get(i);
            sb.append("?");
            if (i != taskIds.size() - 1) {
                sb.append(",");
            }
        }

        return this.listByCondition(" status!=? and taskId in ( " + sb.toString() + " )", paramArray,
                " updateDate desc ");
    }

    /**
     * 获取批改查询的最新任务
     *
     * @param surveyIdArray
     *            surveyIdArray
     *
     * @return List<SurveyTaskEO>
     */
    @Override
    public List<SurveyTaskEO> findLastBySurveyIds(String[] surveyIdArray) {
        String surveyStr = String.join(",", surveyIdArray);
        List<SurveyTaskEO> list = this.listByCondition(" surveyId in (" + surveyStr + ") and newFlag='1'", null, "serialNo desc");
        return CollectionUtils.isEmpty(list) ? null : list;
    }

    /**
     * 根据surveyId查询任务记录条数
     *
     * @param surveyId
     *            surveyId
     * @return Long
     */
    @Override
    public Long getCountBySurveyId(Long surveyId) {

        long count = this.findCountByCondition("surveyId=? ", ObjectUtils.asArray(surveyId));

        return count;
    }

    /**
     * 根据surveyId查询所有有最新标志的任务，一盘只有一条；
     */
    @Override
    public List<SurveyTaskEO> getAllNewBySurveyId(Long surveyId) {
        return this.listByCondition("surveyId=? and newFlag='1'", ObjectUtils.asArray(surveyId), "");
    }
}
