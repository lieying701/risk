package com.chinalife.risksurvey.vo;

import java.io.Serializable;
import java.util.List;

import org.springframework.data.annotation.Id;
import org.springframework.data.elasticsearch.annotations.Field;

import com.chinalife.risksurvey.entity.SurveyBasicEO;
import com.chinalife.risksurvey.entity.SurveyCustomerEO;
import com.chinalife.risksurvey.entity.SurveyItemlistEO;
import com.chinalife.risksurvey.entity.SurveyMainEO;
import com.chinalife.risksurvey.entity.SurveyRelBusinessEO;

/**
 * 创建风勘提交vo
 * @author wanglei
 */
public class OriginatingTaskCommitVo implements Serializable {

    /**
     * @Fields serialVersionUID : TODO
     */
    private static final long serialVersionUID = -6446026301757684379L;
    
    /** 索引Id */
    @Field
    @Id
    private String indexId;

    /**
     * @Fields surveyMain : 风勘主信息
     */
    private SurveyMainEO surveyMain;

    /**
     * @Fields surveyCustomer : 客户信息
     */
    private List<SurveyCustomerEO> surveyCustomer;

    /**
     * @Fields surveyRelBusiness : 关联业务表
     */
    private SurveyRelBusinessEO surveyRelBusiness;
    
    /**
     * @Fields surveyBasic : 风勘基本信息表
     */
    private SurveyBasicEO surveyBasic;
    
    /**
     * @Fields surveyItemlist : 风勘基本信息表
     */
    private SurveyItemlistEO surveyItemlist;
    
    /**
     * @Fields structureId : 机构代码
     */
    private String structureId;
    
    /**
     * @Fields surveyId : 风勘任务编号
     */
    private String surveyId;
    
    /**
     * @Fields surveyMainId : 风勘主表id
     */
    private String surveyMainId;
    
    /**
     * @Fields operation_type : 0暂存 1提交
     */
    private String operationType;

    public SurveyMainEO getSurveyMain() {
        return surveyMain;
    }

    public void setSurveyMain(SurveyMainEO surveyMain) {
        this.surveyMain = surveyMain;
    }

    public List<SurveyCustomerEO> getSurveyCustomer() {
        return surveyCustomer;
    }

    public void setSurveyCustomer(List<SurveyCustomerEO> surveyCustomer) {
        this.surveyCustomer = surveyCustomer;
    }

    public SurveyRelBusinessEO getSurveyRelBusiness() {
        return surveyRelBusiness;
    }

    public void setSurveyRelBusiness(SurveyRelBusinessEO surveyRelBusiness) {
        this.surveyRelBusiness = surveyRelBusiness;
    }

    public String getStructureId() {
        return structureId;
    }

    public void setStructureId(String structureId) {
        this.structureId = structureId;
    }

    public String getSurveyId() {
        return surveyId;
    }

    public void setSurveyId(String surveyId) {
        this.surveyId = surveyId;
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

    public String getIndexId() {
        return indexId;
    }

    public void setIndexId(String indexId) {
        this.indexId = indexId;
    }

    public String getSurveyMainId() {
        return surveyMainId;
    }

    public void setSurveyMainId(String surveyMainId) {
        this.surveyMainId = surveyMainId;
    }

    public String getOperationType() {
        return operationType;
    }

    public void setOperation_type(String operationType) {
        this.operationType = operationType;
    }

    

}
