package com.chinalife.risksurvey.messages.service.queue.impl;

import com.chinalife.risksurvey.entity.SurveyTaskEO;
import com.chinalife.risksurvey.messages.producer.IMessageSender;
import com.chinalife.risksurvey.messages.service.queue.ITaskCollectionMessageService;
import com.chinalife.risksurvey.messages.vo.TaskCollectionRequest;
import com.chinalife.workflow.entity.TaskEO;
import org.activiti.engine.delegate.DelegateTask;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

import java.util.function.Consumer;

/**
 * TaskCollectionMessageServiceImpl
 */
@Component
public class TaskCollectionMessageServiceImpl implements ITaskCollectionMessageService {

    /**
     * TASK_COLLECTION_QUEUE_ROUTING
     */
    private static final String TASK_COLLECTION_QUEUE_ROUTING = "WB_TASK_COLLECTION_DEFAULT_KEY";

    /**
     * LOGGER
     */
    private static final Logger LOGGER = LoggerFactory.getLogger(TaskCollectionMessageServiceImpl.class);

    /**
     * messageSender
     */
    @Autowired
    @Qualifier("messageSender")
    private IMessageSender messageSender;

    @Override
    public void send(SurveyTaskEO surveyTaskEO, TaskEO taskEO, Consumer<String> callback) {
        TaskCollectionRequest taskCollectionRequest = new TaskCollectionRequest(surveyTaskEO, taskEO);
        this.send(taskCollectionRequest, callback);
    }

    @Override
    public void send(SurveyTaskEO surveyTaskEO, TaskEO taskEO) {
        this.send(surveyTaskEO, taskEO, null);
    }

    @Override
    public void send(SurveyTaskEO surveyTaskEO, DelegateTask task) {
        this.send(new TaskCollectionRequest(surveyTaskEO, task), null);
    }

    /**
     * send
     * @param taskCollectionRequest taskCollectionRequest
     * @param callback callback
     */
    private void send(TaskCollectionRequest taskCollectionRequest, Consumer<String> callback) {
        try {
            this.messageSender.send(TASK_COLLECTION_QUEUE_ROUTING, taskCollectionRequest);
        } catch (Exception e) {
            LOGGER.error(e.getMessage(), e);
            if (callback != null) {
                callback.accept(e.getMessage());
            }
        }
    }
}
