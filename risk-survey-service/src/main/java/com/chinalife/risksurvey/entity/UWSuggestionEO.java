package com.chinalife.risksurvey.entity;

import com.chinalife.base.entity.AbstractBaseEntity;
import com.chinalife.base.entity.IBaseEntity;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Transient;
import java.util.Date;

/**
 * 包名称： com.chinalife.uw.entity 类名称：UWSuggesTionEO<br/>
 * 类描述：保单核保意见<br/>
 * 创建人：@author axue016<br/>
 * 创建时间：Jun 20, 2017/1:51:08 PM<br/>
 */
@Entity
@Table(name = "SURVEY_suggestion")
public class UWSuggestionEO extends AbstractBaseEntity implements IBaseEntity {

    /**
     *
     */
    private static final long serialVersionUID = -3303410813788741589L;

    /**
     * type
     */
    public enum SuggestionType {
        /**
         * type
         */
        Agree, Reject, Recall, UWSuggestion, Complain, Submit, Cancel, Pass, AutoDown, UwSubmit, waitingCoinsLink
    }

    /**
     * 意见标识
     */

    private String suggesTionId;
    /**
     * surveyId
     */

    private Long surveyId;

    /**
     * task id
     */
    private String taskId;

    /**
     * uw level
     */
    private String uwLevel;

    /**
     * 意见类型
     */
    private String suggestType;

    /**
     * lineNo
     */
    private Long lineNo;

    /**
     * 意见内容
     */
    private String suggestComment;

    /**
     * 退回原因代码
     */
    private String returnCode;
    /**
     * 创建人
     */
    private String creatorName;

    /**
     * 录入人login name
     */
    private String creatorCode;
    /**
     * 公司代码
     */
    private String structureName;

    /**
     * structure code
     */
    private String structureCode;

    /**
     * 部门名称
     */
    private String departName;

    /**
     * depart code
     */
    private String departCode;

    /**
     * 结果 1:通过 0：不通过
     */
    private String result;

    /**
     * 流入时间
     */
    private Date inflowTime;

    /**
     * 流出时间
     */
    private Date outflowTime;

    @Id
    @Column(name = "SUGGESTIONID")
    @GeneratedValue(generator = "uuid")
    @GenericGenerator(name = "uuid", strategy = "org.hibernate.id.UUIDGenerator")
    public String getSuggesTionId() {
        return suggesTionId;
    }

    public void setSuggesTionId(String suggesTionId) {
        this.suggesTionId = suggesTionId;
    }

    @Column(name = "ReturnCode")
    public String getReturnCode() {
        return returnCode;
    }

    public void setReturnCode(String returnCode) {
        this.returnCode = returnCode;
    }

    public static long getSerialversionuid() {
        return serialVersionUID;
    }

    @Transient
    @Override
    public Object getId() {
        return this.suggesTionId;
    }

    @Override
    public void setId(Object arg0) {
        this.suggesTionId = String.valueOf(arg0);
    }

    public Long getSurveyId() {
        return surveyId;
    }

    public void setSurveyId(Long surveyId) {
        this.surveyId = surveyId;
    }

    public String getResult() {
        return result;
    }

    public void setResult(String result) {
        this.result = result;
    }

    public String getSuggestType() {
        return suggestType;
    }

    public void setSuggestType(String suggestType) {
        this.suggestType = suggestType;
    }

    public String getSuggestComment() {

        return suggestComment;
    }

    public void setSuggestComment(String suggestComment) {
        this.suggestComment = suggestComment;
    }

    public String getStructureName() {
        return structureName;
    }

    public void setStructureName(String structureName) {
        this.structureName = structureName;
    }

    public String getCreatorName() {
        return creatorName;
    }

    public void setCreatorName(String creatorName) {
        this.creatorName = creatorName;
    }

    public String getDepartName() {
        return departName;
    }

    public void setDepartName(String departName) {
        this.departName = departName;
    }

    public String getStructureCode() {
        return structureCode;
    }

    public void setStructureCode(String structureCode) {
        this.structureCode = structureCode;
    }

    public String getDepartCode() {
        return departCode;
    }

    public void setDepartCode(String departCode) {
        this.departCode = departCode;
    }

    public String getTaskId() {
        return taskId;
    }

    public void setTaskId(String taskId) {
        this.taskId = taskId;
    }

    public String getUwLevel() {
        return uwLevel;
    }

    public void setUwLevel(String uwLevel) {
        this.uwLevel = uwLevel;
    }

    public String getCreatorCode() {
        return creatorCode;
    }

    public void setCreatorCode(String creatorCode) {
        this.creatorCode = creatorCode;
    }

    public Long getLineNo() {
        return lineNo;
    }

    public void setLineNo(Long lineNo) {
        this.lineNo = lineNo;
    }

    public Date getInflowTime() {
        return inflowTime;
    }

    public void setInflowTime(Date inflowTime) {
        this.inflowTime = inflowTime;
    }

    public Date getOutflowTime() {
        return outflowTime;
    }

    public void setOutflowTime(Date outflowTime) {
        this.outflowTime = outflowTime;
    }
}
