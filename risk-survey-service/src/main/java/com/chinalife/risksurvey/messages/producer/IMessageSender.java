package com.chinalife.risksurvey.messages.producer;

/**
 * IMessageSender
 */
public interface IMessageSender {

    /**
     * send
     * @param message message
     */
    void send(Object message);

    /**
     * send
     * @param routingKey routingKey
     * @param message message
     */
    void send(String routingKey, Object message);

    /**
     * sendAndReceive
     * @param message message
     * @return Object
     */
    Object sendAndReceive(Object message);

    /**
     * sendAndReceive
     * @param  routingKey routingKey
     * @param message message
     * @return Object
     */
    Object sendAndReceive(String routingKey, Object message);
}
