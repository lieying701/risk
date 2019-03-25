package com.chinalife.risksurvey.service.impl;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.chinalife.base.exception.StandardRuntimeException;
import com.chinalife.risksurvey.component.ISurveyBridgeComponent;
import com.chinalife.risksurvey.entity.SurveyBridgeEO;
import com.chinalife.risksurvey.entity.SurveyClimateEO;
import com.chinalife.risksurvey.entity.SurveyInstallEO;
import com.chinalife.risksurvey.entity.SurveyInstallequipEO;
import com.chinalife.risksurvey.entity.SurveyInstallliftEO;
import com.chinalife.risksurvey.entity.SurveyInstalltechEO;
import com.chinalife.risksurvey.entity.SurveyPipingEO;
import com.chinalife.risksurvey.service.ISurveyBridgeService;
import com.chinalife.risksurvey.service.ISurveyClimateService;
import com.chinalife.risksurvey.service.ISurveyInstallService;
import com.chinalife.risksurvey.service.ISurveyInstallequipService;
import com.chinalife.risksurvey.service.ISurveyInstallliftService;
import com.chinalife.risksurvey.service.ISurveyInstalltechService;
import com.chinalife.risksurvey.service.ISurveyPipingService;
import com.chinalife.risksurvey.vo.SurveyBridgeVo;

/**
 * 风勘录入 {@link SurveyBridgeVo}
 */
@Service("surveyBridgeService")
public class SurveyBridgeServiceImpl implements ISurveyBridgeService {

    /**
     * surveyBridgeComponent
     */
    @Autowired
    private ISurveyBridgeComponent surveyBridgeComponent;
    /**
     * surveyClimateService
     */
    @Autowired
    private ISurveyClimateService surveyClimateService;
    /**
     * surveyInstallService
     */
    @Autowired
    private ISurveyInstallService surveyInstallService;
    /**
     * surveyInstallequipService
     */
    @Autowired
    private ISurveyInstallequipService surveyInstallequipService;
    /**
     * surveyInstallliftService
     */
    @Autowired
    private ISurveyInstallliftService surveyInstallliftService;
    /**
     * surveyInstalltechService
     */
    @Autowired
    private ISurveyInstalltechService surveyInstalltechService;
    /**
     * surveyPipingService
     */
    @Autowired
    private ISurveyPipingService surveyPipingService;

    /**
     * LOGGER
     */
    private static final Logger LOGGER = LoggerFactory.getLogger(SurveyBridgeServiceImpl.class);

    @Override
    public Object surveyBridge(SurveyBridgeVo surveyBridgeVo) {
        String bridge = "";
        String climate = "";
        String install = "";
        String installequip = "";
        String installlift = "";
        String installtech = "";
        String piping = "";
        Map<String, Object> commitMap = new HashMap<String, Object>();
        try {
            if (surveyBridgeVo != null && !"".equals(surveyBridgeVo)) {
                List<SurveyBridgeEO> surveyBridge = surveyBridgeVo.getSurveyBridge();
                List<SurveyBridgeEO> surveyBri = new ArrayList<>();
                if (surveyBridge != null && surveyBridge.size() > 0) {
                    for (SurveyBridgeEO surveyBridgeEO : surveyBridge) {
                        surveyBridgeEO.setRptId(surveyBridgeVo.getSurveyMainId());
                        surveyBri.add(surveyBridgeEO);
                    }
                    bridge = surveyBridgeComponent.insertOrUpdateSurveyBridge(surveyBri).toString();
                }
                List<SurveyClimateEO> surveyClimate = surveyBridgeVo.getSurveyClimate();
                List<SurveyClimateEO> surveyCli = new ArrayList<>();
                if (surveyClimate != null && surveyClimate.size() > 0) {
                    for (SurveyClimateEO surveyClimateEO : surveyClimate) {
                        surveyClimateEO.setRptId(surveyBridgeVo.getSurveyMainId());
                        surveyCli.add(surveyClimateEO);
                    }
                    climate = surveyClimateService.insertOrUpdateSurveyClimate(surveyCli).toString();
                }
                List<SurveyInstallEO> surveyInstall = surveyBridgeVo.getSurveyInstall();
                List<SurveyInstallEO> surveyIns = new ArrayList<>();
                if (surveyInstall != null && surveyInstall.size() > 0) {
                    for (SurveyInstallEO surveyInstallEO : surveyInstall) {
                        surveyInstallEO.setRptId(surveyBridgeVo.getSurveyMainId());
                        surveyIns.add(surveyInstallEO);
                    }
                    install = surveyInstallService.insertOrUpdateSurveyInstall(surveyIns).toString();
                }
                List<SurveyInstallequipEO> surveyInstallequip = surveyBridgeVo.getSurveyInstallequip();
                List<SurveyInstallequipEO> surveyquip = new ArrayList<>();
                if (surveyInstallequip != null && surveyInstallequip.size() > 0) {
                    for (SurveyInstallequipEO surveyInstallequipEO : surveyInstallequip) {
                        surveyInstallequipEO.setRptId(surveyBridgeVo.getSurveyMainId());
                        surveyquip.add(surveyInstallequipEO);
                    }
                    installequip = surveyInstallequipService.insertOrUpdateSurveyInstallequip(surveyquip).toString();
                }
                List<SurveyInstallliftEO> surveyInstalllift = surveyBridgeVo.getSurveyInstalllift();
                List<SurveyInstallliftEO> surveylift = new ArrayList<>();
                if (surveyInstalllift != null && surveyInstalllift.size() > 0) {
                    for (SurveyInstallliftEO surveyInstallliftEO : surveyInstalllift) {
                        surveyInstallliftEO.setRptId(surveyBridgeVo.getSurveyMainId());
                        surveylift.add(surveyInstallliftEO);
                    }
                    installlift = surveyInstallliftService.insertOrUpdateSurveyInstalllift(surveylift).toString();
                }
                List<SurveyInstalltechEO> surveyInstalltech = surveyBridgeVo.getSurveyInstalltech();
                List<SurveyInstalltechEO> surveytech = new ArrayList<>();
                if (surveyInstalltech != null && surveyInstalltech.size() > 0) {
                    for (SurveyInstalltechEO surveyInstalltechEO : surveyInstalltech) {
                        surveyInstalltechEO.setRptId(surveyBridgeVo.getSurveyMainId());
                        surveytech.add(surveyInstalltechEO);
                    }
                    installtech = surveyInstalltechService.insertOrUpdateSurveyInstalltech(surveytech).toString();
                }
                List<SurveyPipingEO> surveyPiping = surveyBridgeVo.getSurveyPiping();
                List<SurveyPipingEO> surveyPi = new ArrayList<>();
                if (surveyPiping != null && surveyPiping.size() > 0) {
                    for (SurveyPipingEO surveyPipingEO : surveyPiping) {
                        surveyPipingEO.setRptId(surveyBridgeVo.getSurveyMainId());
                        surveyPi.add(surveyPipingEO);
                    }
                    piping = surveyPipingService.insertOrUpdateSurveyPiping(surveyPi).toString();
                }

                if (bridge != null && climate != null && install != null && installequip != null 
                        && installlift != null && installtech != null  && piping != null) {
                    commitMap.put("status", "success");
                    commitMap.put("message", "提交成功");
                    LOGGER.info("commitMap:" + commitMap);
                } else {
                    commitMap.put("status", "false");
                    commitMap.put("message", "提交失败");
                    LOGGER.info("commitMap:" + commitMap);
                }
            } else {
                return null;
            }
        } catch (Exception e) {
            LOGGER.error("参数有误");
            throw new StandardRuntimeException("参数有误!", e);
        }
        return commitMap;
    }

}
