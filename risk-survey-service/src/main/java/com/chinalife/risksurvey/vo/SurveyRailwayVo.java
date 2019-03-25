package com.chinalife.risksurvey.vo;

import java.io.Serializable;
import java.util.List;

import com.chinalife.risksurvey.entity.SurveyRailwayEO;
import com.chinalife.risksurvey.entity.SurveyRoadEO;
import com.chinalife.risksurvey.entity.SurveySecurityEO;
import com.chinalife.risksurvey.entity.SurveyStationEO;
import com.chinalife.risksurvey.entity.SurveyTunnelEO;

/**
 * vo
 */
public class SurveyRailwayVo implements Serializable {

    /**
     * @Fields serialVersionUID : TODO
     */
    private static final long serialVersionUID = 8364741447809411263L;

    /**
     * @Fields surveyRailwayList : 公路铁路工程风险
     */
    private List<SurveyRailwayEO> surveyRailway;
    
    /**
     * @Fields surveyRoadList : 道路施工风险
     */
    private List<SurveyRoadEO> surveyRoad;
    
    /**
     * @Fields surveySecurity : 保安状况
     */
    private SurveySecurityEO surveySecurity;
    
    /**
     * @Fields surveyStationList : 车站施工风险
     */
    private List<SurveyStationEO> surveyStation;
    
    /**
     * @Fields surveyTunnelList : 隧道施工风险
     */
    private List<SurveyTunnelEO> surveyTunnel;
    
    /**
     * @Fields surveyMainId : 风勘主表id
     */
    private String surveyMainId;

    public List<SurveyRailwayEO> getSurveyRailway() {
        return surveyRailway;
    }

    public void setSurveyRailway(List<SurveyRailwayEO> surveyRailway) {
        this.surveyRailway = surveyRailway;
    }

    public List<SurveyRoadEO> getSurveyRoad() {
        return surveyRoad;
    }

    public void setSurveyRoad(List<SurveyRoadEO> surveyRoad) {
        this.surveyRoad = surveyRoad;
    }

    public SurveySecurityEO getSurveySecurity() {
        return surveySecurity;
    }

    public void setSurveySecurity(SurveySecurityEO surveySecurity) {
        this.surveySecurity = surveySecurity;
    }

    public List<SurveyStationEO> getSurveyStation() {
        return surveyStation;
    }

    public void setSurveyStation(List<SurveyStationEO> surveyStation) {
        this.surveyStation = surveyStation;
    }

    public List<SurveyTunnelEO> getSurveyTunnel() {
        return surveyTunnel;
    }

    public void setSurveyTunnel(List<SurveyTunnelEO> surveyTunnel) {
        this.surveyTunnel = surveyTunnel;
    }

    public String getSurveyMainId() {
        return surveyMainId;
    }

    public void setSurveyMainId(String surveyMainId) {
        this.surveyMainId = surveyMainId;
    }

    
    
}
