package com.chinalife.risksurvey.task.constructor;

import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.ArrayList;
import java.util.List;

/**
 * contract resource
 *
 * @author jzhou237
 * @version 1
 */
public enum ContractResourceEnum {

    /**
     * 用于查询对应的核保路径
     */
    PROFILE_AUDIT_PATH("underwriting", "underwriting", "underwriting"),

    /**
     * 费用调整、费用预警报表
     */
    COST_CONFIG(new String[]{"costConfig.costAdjust", "costConfig.costWarning"}),

    /**
     * 投保，批改，报价的查询
     */
    POLICY_QUERY("pc.apm.applicationQuery", "pc.edm.endorsementQuery", "qc.qm.quotationQuery"),
    /**
     * 车险投保，批改，报价的查询
     */
    CAR_POLICY_QUERY("pc.apm.autoapplicationInquiry", "pc.edm.autoendorseInquiry", "pc.apm.autopolicyInquiry"),
    /**
     * 录入
     */
    POLICY_RECORD("pc.apm.application", "pc.edm.endorsementApply", "qc.qm.quotationApply"),
    /**
     * 录入
     */
    CAR_POLICY_RECORD("pc.apm.autoproductRender", "pc.edm.autoendorseInquiry", "qc.qm.quotationApply"),
    /**
     * 审核任务查询
     */
    INSURANCE_TASK_QUERY("pc.uw.underwritingTaskQuery", "pc.uw.underwritingTaskQuery", "uw.qm.quotationTaskQuery"),
    /**
     * 车险审核任务查询
     */
    CAR_INSURANCE_TASK_QUERY("pc.uw.autouwTask", "pc.uw.autouwTask", "pc.uw.autouwTask"),

    /**
     * insurance task assign
     */
    INSURANCE_TASK_ASSIGN("pc.uw.underwritingTaskAssign", "pc.uw.endorsementTaskAssign", "pc.uw.quotationTaskAssign"),

    /**
     * insurance task force assign
     */
    INSURANCE_TASK_FORCE_ASSIGN("pc.uw.underwritingTaskForceAssign", "pc.uw.endorsementTaskForceAssign", "pc.uw.quotationTaskForceAssign"),
    /**
     * 审核任务处理
     */
    INSURANCE_TASK_EXECUTE("pc.uw.underwritingProcess", "pc.uw.underwritingProcess", "uw.qm.quotationProcess");

    /**
     * logger
     */
    private static final Logger LOGGER = LoggerFactory.getLogger(ContractResourceEnum.class);

    /**
     * constructor
     *
     * @param proposalKind proposal kind
     * @param endorseKind  endorse kind
     * @param quoteKind    quote kind
     */
    ContractResourceEnum(String proposalKind, String endorseKind, String quoteKind) {
        this.proposalKind = proposalKind;
        this.endorseKind = endorseKind;
        this.quoteKind = quoteKind;
    }

    /**
     * @param costType costType
     */

    ContractResourceEnum(String[] costType) {
        for (String type : costType) {
            costConfigList.add(type);
        }
    }


    /**
     * proposal kind
     */
    private String proposalKind;

    /**
     * proposal kind
     */
    private List<String> costConfigList = new ArrayList<>();


    /**
     * endorse kind
     */
    private String endorseKind;

    /**
     * quote kind
     */
    private String quoteKind;


    /**
     * 获取销售费用关联kind
     *
     * @return List<String>
     */
    public List<String> getcostConfigKindList() {
        return this.costConfigList;
    }

    /**
     * get kind
     *
     * @param businessType business type
     * @return kind
     */
    public String getKindByBusinessType(String businessType) {
        String kind = proposalKind;
        if (StringUtils.equals("67", businessType) || StringUtils.equals("67", businessType)) {
            kind = endorseKind;
        } else if (StringUtils.equals("61", businessType) || StringUtils.equals("61", businessType)) {
            kind = quoteKind;
        }
        LOGGER.info("业务类型[{}]对应的资源Kind为[{}].", businessType, kind);
        return kind;
    }

    /**
     * match the kind
     *
     * @param kind kind
     * @return boolean
     */
    public boolean match(String kind) {
        return StringUtils.equals(this.proposalKind, kind) || StringUtils.equals(this.endorseKind, kind) || StringUtils.equals(this.quoteKind, kind);
    }

    public String getProposalKind() {
        return proposalKind;
    }

    public String getEndorseKind() {
        return endorseKind;
    }

    public String getQuoteKind() {
        return quoteKind;
    }
}
