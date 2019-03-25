package com.chinalife.risksurvey.vo;

import java.io.Serializable;

/**
 * 风勘录入VO
 */
public class WindProspectingInputVo implements Serializable {

    /**
     * @Fields serialVersionUID : TODO
     */
    private static final long serialVersionUID = 3794285595097752913L;
    /**
     * originatingTaskCommitVo 风勘提交vo
     */
    private OriginatingTaskCommitVo originatingTaskCommitVo;
    /**
     * riskSurveyContentVo 风勘内容vo
     */
    private RiskSurveyContentVo riskSurveyContentVo;
    /**
     * riskSurveyVo 风勘报价vo
     */
    private RiskSurveyVo riskSurveyVo;
    /**
     * surveyBridgeVo 风勘vo4
     */
    private SurveyBridgeVo surveyBridgeVo;
    /**
     * surveyRailwayVo 风勘vo5
     */
    private SurveyRailwayVo surveyRailwayVo;
    /**
     * surveyId 风勘任务号
     */
    private String surveyId;
    /**
     * surveyMainId 风勘主表id
     */
    private String surveyMainId;

    public OriginatingTaskCommitVo getOriginatingTaskCommitVo() {
        return originatingTaskCommitVo;
    }

    public void setOriginatingTaskCommitVo(OriginatingTaskCommitVo originatingTaskCommitVo) {
        this.originatingTaskCommitVo = originatingTaskCommitVo;
    }

    public RiskSurveyContentVo getRiskSurveyContentVo() {
        return riskSurveyContentVo;
    }

    public void setRiskSurveyContentVo(RiskSurveyContentVo riskSurveyContentVo) {
        this.riskSurveyContentVo = riskSurveyContentVo;
    }

    public RiskSurveyVo getRiskSurveyVo() {
        return riskSurveyVo;
    }

    public void setRiskSurveyVo(RiskSurveyVo riskSurveyVo) {
        this.riskSurveyVo = riskSurveyVo;
    }

    public SurveyBridgeVo getSurveyBridgeVo() {
        return surveyBridgeVo;
    }

    public void setSurveyBridgeVo(SurveyBridgeVo surveyBridgeVo) {
        this.surveyBridgeVo = surveyBridgeVo;
    }

    public SurveyRailwayVo getSurveyRailwayVo() {
        return surveyRailwayVo;
    }

    public void setSurveyRailwayVo(SurveyRailwayVo surveyRailwayVo) {
        this.surveyRailwayVo = surveyRailwayVo;
    }

    public String getSurveyId() {
        return surveyId;
    }

    public void setSurveyId(String surveyId) {
        this.surveyId = surveyId;
    }

    public String getSurveyMainId() {
        return surveyMainId;
    }

    public void setSurveyMainId(String surveyMainId) {
        this.surveyMainId = surveyMainId;
    }
    
    

}
