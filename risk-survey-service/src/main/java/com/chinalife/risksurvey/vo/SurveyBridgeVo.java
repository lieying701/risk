package com.chinalife.risksurvey.vo;

import java.io.Serializable;
import java.util.List;

import com.chinalife.risksurvey.entity.SurveyBridgeEO;
import com.chinalife.risksurvey.entity.SurveyClimateEO;
import com.chinalife.risksurvey.entity.SurveyInstallEO;
import com.chinalife.risksurvey.entity.SurveyInstallequipEO;
import com.chinalife.risksurvey.entity.SurveyInstallliftEO;
import com.chinalife.risksurvey.entity.SurveyInstalltechEO;
import com.chinalife.risksurvey.entity.SurveyPipingEO;

/**
 * VO
 */
public class SurveyBridgeVo implements Serializable {

    /**
     * @Fields serialVersionUID : TODO
     */
    private static final long serialVersionUID = 7135058149386254850L;
    
    /**
     * @Fields surveyBridgeList : 桥梁施工风险
     */
    private List<SurveyBridgeEO> surveyBridge;
    
    /**
     * @Fields surveyClimate : 气候水文
     */
    private List<SurveyClimateEO> surveyClimate;
    
    /**
     * @Fields surveyInstallList : 安装试车风险
     */
    private List<SurveyInstallEO> surveyInstall;
    
    /**
     * @Fields surveyInstallequipList : 主要设备生产线情况
     */
    private List<SurveyInstallequipEO> surveyInstallequip;
    
    /**
     * @Fields surveyInstallliftList : 吊装工程情况
     */
    private List<SurveyInstallliftEO> surveyInstalllift;
    
    /**
     * @Fields surveyInstalltechList : 工艺流程
     */
    private List<SurveyInstalltechEO> surveyInstalltech;
    
    /**
     * @Fields surveyPipingList : 管道施工风险
     */
    private List<SurveyPipingEO> surveyPiping;
    
    /**
     *  @Fields surveyMainId : 风勘主表id
     */
    private String surveyMainId;

    public List<SurveyBridgeEO> getSurveyBridge() {
        return surveyBridge;
    }

    public void setSurveyBridge(List<SurveyBridgeEO> surveyBridge) {
        this.surveyBridge = surveyBridge;
    }

    public List<SurveyClimateEO> getSurveyClimate() {
        return surveyClimate;
    }

    public void setSurveyClimate(List<SurveyClimateEO> surveyClimate) {
        this.surveyClimate = surveyClimate;
    }

    public List<SurveyInstallEO> getSurveyInstall() {
        return surveyInstall;
    }

    public void setSurveyInstall(List<SurveyInstallEO> surveyInstall) {
        this.surveyInstall = surveyInstall;
    }

    public List<SurveyInstallequipEO> getSurveyInstallequip() {
        return surveyInstallequip;
    }

    public void setSurveyInstallequip(List<SurveyInstallequipEO> surveyInstallequip) {
        this.surveyInstallequip = surveyInstallequip;
    }

    public List<SurveyInstallliftEO> getSurveyInstalllift() {
        return surveyInstalllift;
    }

    public void setSurveyInstalllift(List<SurveyInstallliftEO> surveyInstalllift) {
        this.surveyInstalllift = surveyInstalllift;
    }

    public List<SurveyInstalltechEO> getSurveyInstalltech() {
        return surveyInstalltech;
    }

    public void setSurveyInstalltech(List<SurveyInstalltechEO> surveyInstalltech) {
        this.surveyInstalltech = surveyInstalltech;
    }

    public List<SurveyPipingEO> getSurveyPiping() {
        return surveyPiping;
    }

    public void setSurveyPiping(List<SurveyPipingEO> surveyPiping) {
        this.surveyPiping = surveyPiping;
    }

    public String getSurveyMainId() {
        return surveyMainId;
    }

    public void setSurveyMainId(String surveyMainId) {
        this.surveyMainId = surveyMainId;
    }

    

}
