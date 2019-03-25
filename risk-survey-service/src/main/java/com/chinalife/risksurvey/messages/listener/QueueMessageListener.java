package com.chinalife.risksurvey.messages.listener;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.amqp.core.Message;
import org.springframework.amqp.core.MessageListener;
import org.springframework.stereotype.Component;

/**
 * QueueMessageListener
 */
@Component("queueListener")
public class QueueMessageListener implements MessageListener {

    /**
     * LOGGER
     */
    private static final Logger LOGGER = LoggerFactory.getLogger(QueueMessageListener.class);

    @Override
    public void onMessage(Message message) {
        LOGGER.info(String.format("Receive Message:[%s]", message));

    }

}
