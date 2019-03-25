package com.chinalife.risksurvey.messages.producer;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.amqp.core.AmqpTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

/**
 * AmqpMessageSender
 */
@Component("messageSender")
public class AmqpMessageSender implements IMessageSender {

    /**
     * LOGGER
     */
    private static final Logger LOGGER = LoggerFactory.getLogger(AmqpMessageSender.class);

    /**
     * amqpTemplate
     */
    @Autowired
    @Qualifier("amqpTemplate")
    private AmqpTemplate amqpTemplate;

    /**
     * send
     * @param message message
     */
    @Override
    public void send(Object message) {
        LOGGER.info(String.format("Send Message: [%s]", message));

        this.amqpTemplate.convertAndSend(message);

        LOGGER.info("Send success");
    }

    @Override
    public void send(String routingKey, Object message) {
        LOGGER.info(String.format("Send to Routing [%s], Message: [%s]", routingKey, message));

        this.amqpTemplate.convertAndSend(routingKey, message);

        LOGGER.info(String.format("Send to Routing [%s] success", routingKey));
    }

    @Override
    public Object sendAndReceive(Object message) {
        LOGGER.info(String.format("Send Message: [%s]", message));

        Object response = this.amqpTemplate.convertSendAndReceive(message);

        LOGGER.info(String.format("Send success. Responsed Message: [%s]", response));
        return response;
    }

    @Override
    public Object sendAndReceive(String routingKey, Object message) {
        LOGGER.info(String.format("Send to Routing [%s], Message: [%s]", routingKey, message));

        Object response = this.amqpTemplate.convertSendAndReceive(routingKey, message);

        LOGGER.info(String.format("Send to Routing [%s] success. Responsed Message: [%s]", routingKey, response));
        return response;
    }

}
