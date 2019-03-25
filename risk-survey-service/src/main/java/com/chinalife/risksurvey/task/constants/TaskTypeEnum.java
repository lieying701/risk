package com.chinalife.risksurvey.task.constants;

import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * 工作流审批类型
 *
 * @author admin
 * @version 1
 */
public enum TaskTypeEnum {

    /**
     * 1.合作关系锁定
     * 2.合作关系解除
     * 3.注销 
     * 4.恢复 
     * 5.新增第三方资源
     * 6.修改第三方资源 
     * 7.新增合作关系 
     * 8.修改合作关系
     * 9.合作关系解锁
     */

    /**
     * 1.合作关系锁定
     */
    COOPER_RELATIONSHIP_LOCK("lockPartnershipApply", "合作关系锁定", "risksurvey/basicInformation/surveyBasicInfomation.html"),

    /**
     * 1.合作关系锁定审核
     */
    UW_COOPER_RELATIONSHIP_LOCK("lockPartnershipApplyUW", "合作关系锁定审核", ""),

    /**
     * 2.合作关系解除
     */
    COOPER_RELATIONSHIP_REMOVE("unlockPartnershipApply", "合作关系解除", "risksurvey/basicInformation/surveyBasicInfomation.html"),

    /**
     * 2.合作关系解除审核
     */
    UW_COOPER_RELATIONSHIP_REMOVE("unlockPartnershipApplyUW", "合作关系解除审核", ""),

    /**
     * 3.注销
     */
    CANCEL("cancleSurveyPartyApply", "注销", "risksurvey/basicInformation/surveyBasicInfomation.html"),

    /**
     * 3.注销审核
     */
    UW_CANCEL("cancleSurveyPartyApplyUW", "注销审核", ""),

    /**
     * 4.恢复
     */
    RECOVERY("recoverSurveyPartyApply", "恢复", "risksurvey/basicInformation/surveyBasicInfomation.html"),

    /**
     * 4.恢复审核
     */
    UW_RECOVERY("recoverSurveyPartyApplyUW", "恢复审核", ""),

    /**
     * 5.新增第三方资源
     */
    SURVEY_PARTY_ADD("addSurveyPartyApply", "新增第三方资源", "risksurvey/basicInformation/surveyBasicInfomation.html"),

    /**
     * 5.新增第三方资源审核
     */
    UW_SURVEY_PARTY_ADD("addSurveyPartyApplyUW", "新增第三方资源审核", ""),

    /**
     * 6.修改第三方资源
     */
    SURVEY_PARTY_UPD("modifySurveyPartyApply", "修改第三方资源", "risksurvey/basicInformation/surveyBasicInfomation.html"),

    /**
     * 6.修改第三方资源审核
     */
    UW_SURVEY_PARTY_UPD("modifySurveyPartyApplyUW", "修改第三方资源审核", ""),

    /**
     * 7.新增合作关系
     */
    COOPER_RELATIONSHIP_ADD("addPartnershipApply", "新增合作关系", "risksurvey/basicInformation/surveyBasicInfomation.html"),

    /**
     * 7.新增合作关系审核
     */
    UW_COOPER_RELATIONSHIP_ADD("addPartnershipApplyUW", "新增合作关系审核", ""),

    /**
     * 8.修改合作关系
     */
    COOPER_RELATIONSHIP_UPD("modifyPartnershipApply", "修改合作关系", "risksurvey/basicInformation/surveyBasicInfomation.html"),

    /**
     * 8.修改合作关系审核
     */
    UW_COOPER_RELATIONSHIP_UPD("modifyPartnershipApplyUW", "修改合作关系审核", ""),
    /**
     * 9.合作关系解锁
     */
    COOPER_RELATIONSHIP_UNLOCK("unLockPartnershipApply", "合作关系锁定", "risksurvey/basicInformation/surveyBasicInfomation.html"),

    /**
     * 9.合作关系解锁审核
     */
    UW_COOPER_RELATIONSHIP_UNLOCK("unLockPartnershipApplyUW", "合作关系锁定审核", ""),;

    /**
     * logger
     */
    private static final Logger LOGGER = LoggerFactory.getLogger(TaskTypeEnum.class);

    /**
     * code
     */
    private String code;

    /**
     * description
     */
    private String description;

    /**
     * 关联页面配置
     */
    private String url;

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    /**
     * TaskTypeEnum构造器
     * 
     * @param code
     *            code
     * @param description
     *            description
     * @param url
     *            url
     */
    TaskTypeEnum(String code, String description, String url) {
        this.code = code;
        this.description = description;
        this.url = url;
    }

    /**
     * status of
     *
     * @param code
     *            code
     *
     * @return taskTypeEnum
     */
    public static TaskTypeEnum statusOf(String code) {
        for (TaskTypeEnum taskTypeEnum : values()) {
            if (StringUtils.equals(code, taskTypeEnum.getCode())) {
                return taskTypeEnum;
            }
        }
        LOGGER.error("{}---查询不到任务类型:{}", "statusOf", code);
        return null;
    }

}
