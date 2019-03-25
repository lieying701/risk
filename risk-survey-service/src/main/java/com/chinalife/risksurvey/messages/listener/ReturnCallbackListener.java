package com.chinalife.risksurvey.messages.listener;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.amqp.core.Message;
import org.springframework.amqp.rabbit.core.RabbitTemplate.ReturnCallback;
import org.springframework.stereotype.Component;

/**
 * ReturnCallbackListener
 */
@Component("returnCallbackListener")
public class ReturnCallbackListener implements ReturnCallback {

    /**
     * LOGGER
     */
    private static final Logger LOGGER = LoggerFactory.getLogger(ReturnCallbackListener.class);

    /**
     * returnedMessage
     * @param message message
     * @param replyCode replyCode
     * @param replyText replyText
     * @param exchange exchange
     * @param routingKey routingKey
     */
    @Override
    public void returnedMessage(Message message, int replyCode, String replyText, String exchange, String routingKey) {
        if (LOGGER.isInfoEnabled()) {
            LOGGER.info("return--message:" + new String(message.getBody()) + ",replyCode:" + replyCode + ",replyText:"
                    + replyText + ",exchange:" + exchange + ",routingKey:" + routingKey);
        }
    }

}
