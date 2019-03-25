package com.chinalife.risksurvey.constant;

/**
 * 包名称： com.chinalife.risksurvey.constant <br/>
 * 类名称：KeyConstrant<br/>
 * 类描述：<br/>
 * 
 * @version <br/>
 */
public interface KeyConstrant {

    /**
     * 真，是，有效
     */
    String TRUE = "1";
    /**
     * 假，否，无效
     */
    String FALSE = "0";

    /**
     * 合作关系锁定
     */
    String COORELLOCKING = "合作关系锁定";

    /**
     * 合作关系解锁
     */
    String COORELUNLOCK = "合作关系解锁";

    /**
     * 新增合作关系
     */
    String NEWCOOREL = "新增合作关系";

    /**
     * 修改合作关系
     */
    String MODIFYCOOREL = "修改合作关系";

    /**
     * 注销
     */
    String CANCELLATION = "注销";

    /**
     * 恢复
     */
    String RECOVERY = "恢复";

    /**
     * 新增风勘资源
     */
    String NEWSURVEYES = "新增风勘资源";

    /**
     * 修改风勘资源
     */
    String MODIFYSURVEYRES = "修改风勘资源";

    /**
     * 代表审批状态已提交
     */
    String SUBMISSION = "0";
    /**
     * 代表审批状态已通过
     */
    String ALRPAS = "1";
    /**
     * 代表审批状态已驳回
     */
    String DISMISSAL = "2";

    /**
     * 风勘属性，个人
     */
    String SINGLE = "0";

    /**
     * 风勘属性，团体
     */
    String GROUP = "1";
    
    /**
     * 基础代码业务条线
     */
    String CODE_LIST_BUSINESS_LINE = "DepartmentCode";
}
