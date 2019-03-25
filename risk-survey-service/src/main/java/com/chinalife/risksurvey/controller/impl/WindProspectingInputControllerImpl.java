package com.chinalife.risksurvey.controller.impl;

import java.util.HashMap;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.chinalife.risksurvey.controller.IWindProspectingInputController;
import com.chinalife.risksurvey.service.ISurveyBasicService;
import com.chinalife.risksurvey.service.ISurveyBridgeService;
import com.chinalife.risksurvey.service.ISurveyConstructbasicService;
import com.chinalife.risksurvey.service.ISurveyMainInputService;
import com.chinalife.risksurvey.service.ISurveyRailwayService;
import com.chinalife.risksurvey.vo.OriginatingTaskCommitVo;
import com.chinalife.risksurvey.vo.RiskSurveyContentVo;
import com.chinalife.risksurvey.vo.RiskSurveyVo;
import com.chinalife.risksurvey.vo.SurveyBridgeVo;
import com.chinalife.risksurvey.vo.SurveyRailwayVo;
import com.chinalife.risksurvey.vo.WindProspectingInputVo;

/**
 * @author: wl
 * @date: 2018年12月14日 风勘录入
 */
@RestController("windProspectingInputController")
@RequestMapping("/controller/risksurvey/WindProspectingInput")
public class WindProspectingInputControllerImpl implements IWindProspectingInputController {

    /**
     * surveyMainInputService
     */
    @Autowired
    private ISurveyMainInputService surveyMainInputService;

    /**
     * surveyConstructbasicService
     */
    @Autowired
    private ISurveyConstructbasicService surveyConstructbasicService;

    /**
     * surveyBasicService
     */
    @Autowired
    private ISurveyBasicService surveyBasicService;

    /**
     * surveyBridgeService
     */
    @Autowired
    private ISurveyBridgeService surveyBridgeService;

    /**
     * surveyRailwayService
     */
    @Autowired
    private ISurveyRailwayService surveyRailwayService;

    /**
     * LOGGER
     */
    private static final Logger LOGGER = LoggerFactory.getLogger(WindProspectingInputControllerImpl.class);

    @SuppressWarnings("unchecked")
    @Override
    @RequestMapping(value = "/windProspectingInput")
    @ResponseBody
    public Object windProspectingInput(@RequestBody WindProspectingInputVo windProspectingInputVo) {
        Map<String, Object> map = new HashMap<String, Object>();
        String main = "";
        String content = "";
        String basic = "";
        String bridge = "";
        String railway = "";
        OriginatingTaskCommitVo commitVo = windProspectingInputVo.getOriginatingTaskCommitVo();
        String pkId = commitVo.getSurveyMain().getPkId();
        commitVo.setSurveyId(windProspectingInputVo.getSurveyId());
        Map<String, Object> surveyMain = (Map<String, Object>) surveyMainInputService.originatingTaskCommit(commitVo);

        RiskSurveyContentVo riskSurveyContentVo = windProspectingInputVo.getRiskSurveyContentVo();
        riskSurveyContentVo.setSurveyMainId(pkId);
        Map<String, Object> surveyContent = (Map<String, Object>) surveyConstructbasicService.windProspectingInput(riskSurveyContentVo);

        RiskSurveyVo riskSurveyVo = windProspectingInputVo.getRiskSurveyVo();
        riskSurveyVo.setSurveyId(windProspectingInputVo.getSurveyId());
        riskSurveyVo.setSurveyMainId(pkId);
        Map<String, Object> surveyBasic = (Map<String, Object>) surveyBasicService.riskSurvey(riskSurveyVo);

        SurveyBridgeVo surveyBridgeVo = windProspectingInputVo.getSurveyBridgeVo();
        surveyBridgeVo.setSurveyMainId(pkId);
        Map<String, Object> surveyBridge = (Map<String, Object>) surveyBridgeService.surveyBridge(surveyBridgeVo);
        
        SurveyRailwayVo surveyRailwayVo = windProspectingInputVo.getSurveyRailwayVo();
        surveyRailwayVo.setSurveyMainId(pkId);
        Map<String, Object> surveyRailway = (Map<String, Object>) surveyRailwayService.surveyRailway(surveyRailwayVo);
        
        if (surveyMain != null && !"".equals(surveyMain)) {
            main = surveyMain.get("status").toString();
        }
        if (surveyContent != null && !"".equals(surveyContent)) {
            content = surveyContent.get("status").toString();
        }
        if (surveyBasic != null && !"".equals(surveyBasic)) {
            basic = surveyBasic.get("status").toString();
        }
        if (surveyBridge != null && !"".equals(surveyBridge)) {
            bridge = surveyBridge.get("status").toString();
        }
        if (surveyRailway != null && !"".equals(surveyRailway)) {
            railway = surveyRailway.get("status").toString();
        }
        if (("success".equals(main) || "".equals(main)) && ("success".equals(content) || "".equals(content))
                && ("success".equals(basic) || "".equals(basic)) && ("success".equals(bridge) || "".equals(bridge))
                && ("success".equals(railway) || "".equals(railway))) {
            map.put("status", "success");
            map.put("message", "提交成功");
            LOGGER.info("风勘录入map:" + map);
        } else {
            map.put("status", "false");
            map.put("message", "提交失败");
            LOGGER.info("风勘录入map:" + map);
        }

        return map;
    }
    
    @Override
    @RequestMapping(value = "/getWindReport")
    @ResponseBody
    public Map<String,Object> getWindReport(@RequestBody(required = false) Map<String, Object> parameter) {
        
        return surveyMainInputService.getWindReport(parameter);
    }
}
