package com.chinalife.risksurvey.controller.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.chinalife.risksurvey.controller.IOriginatingTaskController;
import com.chinalife.risksurvey.service.ISurveyMainService;
import com.chinalife.risksurvey.vo.OriginatingTaskCommitVo;

/**
 * @author: wl
 * @date: 2018年12月10日 发起风勘
 */
@RestController("originatingTaskController")
@RequestMapping("/controller/risksurvey/originating")
public class OriginatingTaskControllerImpl implements IOriginatingTaskController {

    /**
     * originatingTaskService
     */
    @Autowired
    private ISurveyMainService surveyMainService;

    @Override
    @RequestMapping(value = "/originatingTaskSave")
    @ResponseBody
    public Object originatingTaskCommit(@RequestBody OriginatingTaskCommitVo commitVo) {

        return surveyMainService.originatingTaskCommit(commitVo);
    }

}
