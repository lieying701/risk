package com.chinalife.risksurvey.messages.service.queue;

import com.chinalife.risksurvey.entity.SurveyTaskEO;
import com.chinalife.workflow.entity.TaskEO;
import org.activiti.engine.delegate.DelegateTask;

import java.util.function.Consumer;

/**
 * ITaskCollectionMessageService
 */
public interface ITaskCollectionMessageService {

    /**
     * 同步任务状态
     * 
     * @param surveyTaskEO surveyTaskEO
     * @param taskEO taskEO
     * @param callback callback
     */
    void send(SurveyTaskEO surveyTaskEO, TaskEO taskEO, Consumer<String> callback);

    /**
     * 同步任务状态
     * 
     * @param surveyTaskEO surveyTaskEO
     * @param taskEO taskEO
     */
    void send(SurveyTaskEO surveyTaskEO, TaskEO taskEO);

    /**
     * 同步任务状态
     * 
     * @param surveyTaskEO surveyTaskEO
     * @param task task
     */
    void send(SurveyTaskEO surveyTaskEO, DelegateTask task);
}
