package com.chinalife.risksurvey.messages.service.impl;

import com.chinalife.base.util.JsonUtils;
import com.chinalife.collaboration.entity.MessageTopicEO;
import com.chinalife.collaboration.server.message.Actor;
import com.chinalife.collaboration.server.message.Attachment;
import com.chinalife.collaboration.service.IMessageService;
import com.chinalife.collaboration.service.IMessageTopicService;
import com.chinalife.rbac.entity.RbacUserEO;
import com.chinalife.rbac.service.IRbacUserService;
import com.chinalife.risksurvey.messages.enums.ContractMessageTopicEnum;
import com.chinalife.risksurvey.messages.service.IContractMessageTopicService;
import org.apache.commons.collections4.CollectionUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * message topic service
 *
 * @author jzhou237
 * @version 1
 */
@Component
public class ContractMessageTopicServiceImpl implements IContractMessageTopicService {

    /**
     * logger
     */
    private static final Logger LOGGER = LoggerFactory.getLogger(ContractMessageTopicServiceImpl.class);

    /**
     * business no
     */
    public static final String BUSINESS_NO = "businessNo";

    /**
     * business type
     */
    public static final String BUSINESS_TYPE = "businessType";

    /**
     * task type
     */
    public static final String TASK_TYPE = "taskType";

    /**
     * message topic service
     */
    @Autowired
    private IMessageTopicService messageTopicService;

    /**
     * message service
     */
    @Autowired
    private IMessageService messageService;

    /**
     * rbacUserService
     */
    @Autowired
    private IRbacUserService rbacUserService;

    @Override
    public Map<String, Object> sendTopic(ContractMessageTopicEnum contractMessageTopicEnum, List<String> assigneeList,
                                         Map<String, Object> parameters) {
        return this.sendTopic(contractMessageTopicEnum, assigneeList, parameters, new ArrayList<>());
    }

    @Override
    public Map<String, Object> sendTopic(ContractMessageTopicEnum contractMessageTopicEnum, List<String> assigneeList,
                                         Map<String, Object> parameters, List<Attachment> attachmentList) {
        LOGGER.info("{}.{}---ContractMessageTopicEnum:[{}], Parameters:[{}], Attachment:[{}], AssigneeList:{}",
                this.getClass().getSimpleName(), "sendTopic", contractMessageTopicEnum.name(),
                JsonUtils.toJsonString(parameters, false), JsonUtils.toJsonString(attachmentList, false),
                JsonUtils.toJsonString(assigneeList, false));

        final Map<String, Object> RESPONSE = new HashMap<>();
        if (contractMessageTopicEnum == null) {
            return RESPONSE;
        }

        // 获取当前消息发送点的枚举
        Map params = contractMessageTopicEnum.genQueryParams();

        List<Actor> actorList = new ArrayList<>();
        if (CollectionUtils.isNotEmpty(assigneeList)) {
            for (String loginName : assigneeList) {
                RbacUserEO rbacUserEO = this.rbacUserService.findByLoginName(loginName);
                if (rbacUserEO != null) {
                    actorList.add(new Actor(Actor.ActorType.User, rbacUserEO.getUserId()));
                }
            }
            LOGGER.info("{}.{}---消息通知人员列表:{}", this.getClass().getSimpleName(), "sendTopic",
                    JsonUtils.toJsonString(actorList, false));
        }

        // 查询主题信息
        MessageTopicEO topicEo = messageTopicService.findLatestObject(params);
        if (topicEo != null) {
            new Thread(new Runnable() {
                @Override
                public void run() {
                    try {
                        Map<String, Object> result = messageService.sendMessage(topicEo.getMessageTopicId(), actorList, parameters,
                                attachmentList);
                        LOGGER.info("{}.{}--- Response:{}", this.getClass().getSimpleName(), "sendTopic",
                                JsonUtils.toJsonString(result, false));
                        if (result != null) {
                            RESPONSE.putAll(result);
                        }
                    } catch (Exception e) {
                        LOGGER.error("{}.{}---发送消息失败", this.getClass().getSimpleName(), "sendTopic");
                        LOGGER.error(e.getMessage(), e);
                    }
                }
            }).start();

        } else {
            LOGGER.error("{}.{}---查询不到MessageTopicEO,查询参数为:{}", this.getClass().getSimpleName(), "sendTopic",
                    JsonUtils.toJsonString(params, false));
        }

        return RESPONSE;
    }
}
