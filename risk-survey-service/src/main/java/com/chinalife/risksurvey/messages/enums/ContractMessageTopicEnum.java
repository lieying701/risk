package com.chinalife.risksurvey.messages.enums;

import com.chinalife.base.entity.IStatusEntity;

import java.util.HashMap;
import java.util.Map;

/**
 * 合约中心 消息枚举类
 * @author gzhang081
 *
 */
public enum ContractMessageTopicEnum {

    /** 合约中心-报价 */
    CONTRACT_QUOTATION_APPLY_NOTICE("QA01", "报价申请-报价通知"),

    /** 合约中心-保单 */
    // Undwrt001("UW01","投保-条款/产品签发通知?同PF01"),
    
    CONTRACT_INSURANCE_CREATE_NOTICE("UW02", "续保-续保提醒"),
    /** */
    CONTRACT_INSURANCE_QUOTE_NOTICE("UW03", "续保-续保报价提醒"),
    /** */
    CONTRACT_RISK_TASK_NOTICE("UW04", "风勘-任务提醒"),
    /** */
    CONTRACT_PAYMENT_NOTICES_NOTICE("UW09", "缴费-缴费通知书发送"),
    /** */
    CONTRACT_PAYMENT_RECEIPT_ADVANCE("UW10", "缴费-预收收据发送"),
    /** */
    CONTRACT_PAYMENT_URL_PUSH("UW11", "缴费-缴费链接推送"),
    
    // Undwrt001("UW12","协议-协议续转提醒"),
    // Undwrt001("UW13","协议-协议超额提醒"),
    // Undwrt001("UW14","协议-预收保费不足提醒"),
    // Undwrt001("UW15","协议-每月保单清单发送"),
    // Undwrt001("UW16","协议-每周保单清单发送"),
    // Undwrt001("UW17","协议-预收保费缴纳提醒"),

    /** 合约中心-流程审核 */
    CONTRACT_CHECK_TASK_NOTICE("GEN01", "审核-任务提醒"),
    /** */
    CONTRACT_CHECK_PRODUCT_NOTICE("GEN04", "审核-审核通过通知"),
    /** */
    CONTRACT_QUOTATION_TASK_NOTICE("GEN02", "报价-审核通过通知"),
    /** */
    CONTRACT_POLICY_TASK_NOTICE("GEN03", "核保、核批审核通过通知"),
    /** */
    CONTRACT_POLICY_ELECPOLICY_EMAIL("ELECP_02", "电子保单邮件"),
    /** */
    CONTRACT_POLICY_ELECPOLICY_SMS("SSPM_01", "电子报单短信");

    /** */
    private String desc;
    /** */
    private String kind;

    /**
     * 构造方法
     * @param kind 值
     * @param desc 描述
     */
    private ContractMessageTopicEnum(String kind, String desc) {
        this.kind = kind;
        this.desc = desc;
    }

    public String getDesc() {
        return desc;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }

    public String getKind() {
        return kind;
    }

    public void setKind(String kind) {
        this.kind = kind;
    }

    /**
     * 查询有效数据的参数
     * 
     * @return Map
     */
    public Map<String, Object> genQueryParams() {
        Map<String, Object> map = new HashMap<String, Object>();
        map.put("source", kind);
        map.put("status", IStatusEntity.Status.Effective.toString());
        return map;
    }
}
