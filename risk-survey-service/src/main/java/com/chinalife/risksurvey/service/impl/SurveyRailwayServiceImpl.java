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
import com.chinalife.risksurvey.component.ISurveyRailwayComponent;
import com.chinalife.risksurvey.entity.SurveyRailwayEO;
import com.chinalife.risksurvey.entity.SurveyRoadEO;
import com.chinalife.risksurvey.entity.SurveySecurityEO;
import com.chinalife.risksurvey.entity.SurveyStationEO;
import com.chinalife.risksurvey.entity.SurveyTunnelEO;
import com.chinalife.risksurvey.service.ISurveyRailwayService;
import com.chinalife.risksurvey.service.ISurveyRoadService;
import com.chinalife.risksurvey.service.ISurveySecurityService;
import com.chinalife.risksurvey.service.ISurveyStationService;
import com.chinalife.risksurvey.service.ISurveyTunnelService;
import com.chinalife.risksurvey.vo.SurveyRailwayVo;

/**
 * 风勘录入 {@link SurveyRailwayVo}
 */
@Service("surveyRailwayService")
public class SurveyRailwayServiceImpl implements ISurveyRailwayService {

    /**
     * surveyRailwayComponent
     */
    @Autowired
    private ISurveyRailwayComponent surveyRailwayComponent;

    /**
     * surveyRoadService
     */
    @Autowired
    private ISurveyRoadService surveyRoadService;

    /**
     * surveySecurityService
     */
    @Autowired
    private ISurveySecurityService surveySecurityService;

    /**
     * surveyStationService
     */
    @Autowired
    private ISurveyStationService surveyStationService;

    /**
     * surveyTunnelService
     */
    @Autowired
    private ISurveyTunnelService surveyTunnelService;

    /**
     * LOGGER
     */
    private static final Logger LOGGER = LoggerFactory.getLogger(SurveyRailwayServiceImpl.class);

    @Override
    public Object surveyRailway(SurveyRailwayVo surveyRailwayVo) {
        Map<String, Object> commitMap = new HashMap<String, Object>();
        String railway = "";
        String road = "";
        String security = "";
        String station = "";
        String tunnel = "";
        try {
            if (surveyRailwayVo != null && !"".equals(surveyRailwayVo)) {
                List<SurveyRailwayEO> surveyRailway = surveyRailwayVo.getSurveyRailway();
                List<SurveyRailwayEO> surveyRail = new ArrayList<>();
                if (surveyRailway != null && surveyRailway.size() > 0) {
                    for (SurveyRailwayEO surveyRailwayEO : surveyRailway) {
                        surveyRailwayEO.setRptId(surveyRailwayVo.getSurveyMainId());
                        surveyRail.add(surveyRailwayEO);
                    }
                    railway = surveyRailwayComponent.insertOrUpdateSurveyRailway(surveyRail).toString();
                }
                List<SurveyRoadEO> surveyRoad = surveyRailwayVo.getSurveyRoad();
                List<SurveyRoadEO> surveyRo = new ArrayList<>();
                if (surveyRoad != null && surveyRoad.size() > 0) {
                    for (SurveyRoadEO surveyRoadEO : surveyRoad) {
                        surveyRoadEO.setRptId(surveyRailwayVo.getSurveyMainId());
                        surveyRo.add(surveyRoadEO);
                    }
                    road = surveyRoadService.insertOrUpdateSurveyRoad(surveyRo).toString();
                }
                if (surveyRailwayVo.getSurveySecurity() != null) {
                    SurveySecurityEO surveySecurity = surveyRailwayVo.getSurveySecurity();
                    surveySecurity.setRptId(surveyRailwayVo.getSurveyMainId());
                    security = surveySecurityService.insertOrUpdateSurveySecurity(surveySecurity).toString();
                }

                List<SurveyStationEO> surveyStation = surveyRailwayVo.getSurveyStation();
                List<SurveyStationEO> surveySta = new ArrayList<>();
                if (surveyStation != null && surveyStation.size() > 0) {
                    for (SurveyStationEO surveyStationEO : surveyStation) {
                        surveyStationEO.setRptId(surveyRailwayVo.getSurveyMainId());
                        surveySta.add(surveyStationEO);
                    }
                    station = surveyStationService.insertOrUpdateSurveyStation(surveySta).toString();
                }
                List<SurveyTunnelEO> surveyTunnel = surveyRailwayVo.getSurveyTunnel();
                List<SurveyTunnelEO> surveyTun = new ArrayList<>();
                if (surveyTunnel != null && surveyTunnel.size() > 0) {
                    for (SurveyTunnelEO surveyTunnelEO : surveyTunnel) {
                        surveyTunnelEO.setRptId(surveyRailwayVo.getSurveyMainId());
                        surveyTun.add(surveyTunnelEO);
                    }
                    tunnel = surveyTunnelService.insertOrUpdateSurveyTunnel(surveyTun).toString();
                }
                if (railway != null && road != null && security != null  && station != null && tunnel != null) {
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
