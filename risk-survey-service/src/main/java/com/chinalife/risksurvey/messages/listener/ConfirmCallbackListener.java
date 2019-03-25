package com.chinalife.risksurvey.messages.listener;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.amqp.rabbit.core.RabbitTemplate.ConfirmCallback;
import org.springframework.amqp.rabbit.support.CorrelationData;
import org.springframework.stereotype.Component;

/**
 * confirmCallbackListener
 */
@Component("confirmCallbackListener")
public class ConfirmCallbackListener implements ConfirmCallback {
    /**
     * LOGGER
     */
    private static final Logger LOGGER = LoggerFactory.getLogger(ConfirmCallbackListener.class);

    @Override
    public void confirm(CorrelationData correlationData, boolean ack, String cause) {
        LOGGER.info("confirm--:correlationData:" + correlationData + ",ack:" + ack + ",cause:" + cause);
    }

}
