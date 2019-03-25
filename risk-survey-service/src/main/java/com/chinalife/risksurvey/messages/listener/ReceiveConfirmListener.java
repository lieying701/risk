package com.chinalife.risksurvey.messages.listener;

import com.rabbitmq.client.Channel;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.amqp.core.Message;
import org.springframework.amqp.rabbit.core.ChannelAwareMessageListener;
import org.springframework.stereotype.Component;

/**
 * receiveConfirmListener
 */
@Component("receiveConfirmListener")
public class ReceiveConfirmListener implements ChannelAwareMessageListener {

    /**
     * LOGGER
     */
    private static final Logger LOGGER = LoggerFactory.getLogger(ReceiveConfirmListener.class);

    @Override
    public void onMessage(Message message, Channel channel) throws Exception {
        try {
            if (LOGGER.isInfoEnabled()) {
                LOGGER.info("consumer--:" + message.getMessageProperties() + ":" + new String(message.getBody()));
            }
            channel.basicAck(message.getMessageProperties().getDeliveryTag(), false);
        } catch (Exception e) {
            channel.basicNack(message.getMessageProperties().getDeliveryTag(), false, false);
            if (LOGGER.isErrorEnabled()) {
                LOGGER.error(e.getMessage(), e);
            }
        }
    }

}
