package com.chinalife.risksurvey.vo;

import java.io.Serializable;
import java.util.List;

import com.chinalife.risksurvey.entity.SurveyBasicEO;
import com.chinalife.risksurvey.entity.SurveyBuildconstructEO;
import com.chinalife.risksurvey.entity.SurveyItemlistEO;
import com.chinalife.risksurvey.entity.SurveyThirddutyEO;

/**
 * 风险vo
 * @author wanglei 
 */
public class RiskSurveyVo implements Serializable {

    /**
     * @Fields serialVersionUID : TODO
     */
    private static final long serialVersionUID = 6126541095468981102L;
    
    /**
     * @Fields surveyBuildconstruct : 楼宇工程风险
     */
    private List<SurveyBuildconstructEO> surveyBuildconstruct;
    
    /**
     * @Fields surveyThirdduty : 第三者责任风险
     */
    private List<SurveyThirddutyEO> surveyThirdduty;
    
    /**
     * @Fields surveyBasic : 基本信息
     */
    private SurveyBasicEO surveyBasic;
    
    /**
     * @Fields surveyItemlist : 风勘项
     */
    private SurveyItemlistEO surveyItemlist;

    /**
     * @Fields surveyId : 任务编号
     */
    private String surveyId;
    
    /**
     * @Fields surveyMainId : 风勘主表id
     */
    private String surveyMainId;

    public List<SurveyBuildconstructEO> getSurveyBuildconstruct() {
        return surveyBuildconstruct;
    }

    public void setSurveyBuildconstruct(List<SurveyBuildconstructEO> surveyBuildconstruct) {
        this.surveyBuildconstruct = surveyBuildconstruct;
    }

    public List<SurveyThirddutyEO> getSurveyThirdduty() {
        return surveyThirdduty;
    }

    public void setSurveyThirdduty(List<SurveyThirddutyEO> surveyThirdduty) {
        this.surveyThirdduty = surveyThirdduty;
    }

    public SurveyBasicEO getSurveyBasic() {
        return surveyBasic;
    }

    public void setSurveyBasic(SurveyBasicEO surveyBasic) {
        this.surveyBasic = surveyBasic;
    }

    public SurveyItemlistEO getSurveyItemlist() {
        return surveyItemlist;
    }

    public void setSurveyItemlist(SurveyItemlistEO surveyItemlist) {
        this.surveyItemlist = surveyItemlist;
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
