package com.chinalife.risksurvey.vo;

import java.io.Serializable;

import com.chinalife.risksurvey.entity.SurveyConstructbasicEO;
import com.chinalife.risksurvey.entity.SurveyConstructpartyEO;
import com.chinalife.risksurvey.entity.SurveyGeologyEO;
import com.chinalife.risksurvey.entity.SurveyWorksiteEO;

/**
 * 风险查勘内容vo
 * @author wanglei
 */
public class RiskSurveyContentVo implements Serializable {

    /**
     * @Fields serialVersionUID : TODO
     */
    private static final long serialVersionUID = -6690737405977693164L;
    
    /**
     * @Fields surveyConstructbasic : 工程基本信息
     */
    private SurveyConstructbasicEO surveyConstructbasic;
    
    /**
     * @Fields surveyConstructparty : 工程相关方信息
     */
    private SurveyConstructpartyEO surveyConstructparty;
    
    /**
     * @Fields surveyGeology : 地质地貌信息
     */
    private SurveyGeologyEO surveyGeology;
    
    /**
     * @Fields surveyWorksite : 工地概况
     */
    private SurveyWorksiteEO surveyWorksite;
    
    /**
     * @Fields surveyMainId : 风勘主表id
     */
    private String surveyMainId;

    public SurveyConstructbasicEO getSurveyConstructbasic() {
        return surveyConstructbasic;
    }

    public void setSurveyConstructbasic(SurveyConstructbasicEO surveyConstructbasic) {
        this.surveyConstructbasic = surveyConstructbasic;
    }

    public SurveyConstructpartyEO getSurveyConstructparty() {
        return surveyConstructparty;
    }

    public void setSurveyConstructparty(SurveyConstructpartyEO surveyConstructparty) {
        this.surveyConstructparty = surveyConstructparty;
    }

    public SurveyGeologyEO getSurveyGeology() {
        return surveyGeology;
    }

    public void setSurveyGeology(SurveyGeologyEO surveyGeology) {
        this.surveyGeology = surveyGeology;
    }

    public SurveyWorksiteEO getSurveyWorksite() {
        return surveyWorksite;
    }

    public void setSurveyWorksite(SurveyWorksiteEO surveyWorksite) {
        this.surveyWorksite = surveyWorksite;
    }

    public String getSurveyMainId() {
        return surveyMainId;
    }

    public void setSurveyMainId(String surveyMainId) {
        this.surveyMainId = surveyMainId;
    }

}
