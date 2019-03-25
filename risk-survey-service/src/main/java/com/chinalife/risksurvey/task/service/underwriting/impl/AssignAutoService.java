package com.chinalife.risksurvey.task.service.underwriting.impl;

import com.chinalife.risksurvey.task.service.AbstractTaskEventService;
import org.activiti.engine.delegate.DelegateExecution;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import java.util.Map;

/**
 * 自动派工
 *
 * @author yuanqiang
 * @version 1
 */
@Component("assignAutoService")
public class AssignAutoService extends AbstractTaskEventService {

    /**
     * logger
     */
    private static final Logger LOGGER = LoggerFactory.getLogger(RiskSuveyAssignService.class);

    /**
     * @param execution            execution
     * @param processDefinitionMap parameter map
     * @param schemeName           schema
     * @param thirdPartyId         thirdPartyId
     */
    public void onEvent(DelegateExecution execution, Map<String, Object> processDefinitionMap, String schemeName,
                        Long thirdPartyId) {
        //FIXME
        LOGGER.info("获取权限start----------------------------------------");
        execution.setVariable(NEXT_UW_LEVEL, "");
        LOGGER.info("获取权限end----------------------------------------");
    }
}
