
package com.chinalife.risksurvey.messages.service;

import com.chinalife.collaboration.server.message.Attachment;
import com.chinalife.risksurvey.messages.enums.ContractMessageTopicEnum;

import java.util.List;
import java.util.Map;

/**
 * message topic service
 *
 * @author jzhou237
 * @version 1
 */
public interface IContractMessageTopicService {

    /**
     * send the topic message
     *
     * @param contractMessageTopicEnum
     *            contract message topic enum
     * @param assigneeList
     *            assigneelist
     * @param parameters
     *            parameters
     * @return boolean
     */
    Map<String, Object> sendTopic(ContractMessageTopicEnum contractMessageTopicEnum, List<String> assigneeList,
            Map<String, Object> parameters);

    /**
     * send the topic message with attachment
     *
     * @param contractMessageTopicEnum
     *            contract message topic enum
     * @param assigneeList
     *            assigneelist
     * @param parameters
     *            parameters
     * @param attachmentList
     *            attachment
     * @return boolean
     */
    Map<String, Object> sendTopic(ContractMessageTopicEnum contractMessageTopicEnum, List<String> assigneeList,
            Map<String, Object> parameters, List<Attachment> attachmentList);
}
