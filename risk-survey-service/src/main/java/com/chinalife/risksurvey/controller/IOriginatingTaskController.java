package com.chinalife.risksurvey.controller;

import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.chinalife.risksurvey.vo.OriginatingTaskCommitVo;

/**
 * 发起风勘任务controller
 * 
 * @author: wl
 */
@RestController("originatingTaskController")
@RequestMapping("/controller/risksurvey/originating")
public interface IOriginatingTaskController {

    /**
     * wl
     * 
     * @param commitVo
     *            vo
     * @return object
     */
    public Object originatingTaskCommit(@RequestBody OriginatingTaskCommitVo commitVo);

}
