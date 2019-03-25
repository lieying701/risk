package com.chinalife.risksurvey.constant;

/**
 * 包名称： com.chinalife.risksurvey.constant <br/>
 * 类名称：OperationEnum<br/>
 * 类描述：操作历史表中的操作类型<br/>
 * 
 * @version <br/>
 */
public enum OperationEnum {
    
    /**
     * 新增操作
     */
    InsertSurveyPubInfo("insert","新增风勘机构"),
    /**
     * 修改操作
     */
    UpdateSurveyPubInfo("update","修改风勘机构"),
    /**
     * 新增操作
     */
    InsertDiffInfo("insert","新增差异化信息"),
    /**
     * 修改操作
     */
    UpdateDiffInfo("update","修改差异化信息"),
    /**
     * 注销操作
     */
    CancelDiffInfo("cancel","注销差异化信息"),
    /**
     * 恢复操作
     */
    RecoveryDiffInfo("recovery","恢复差异化信息"),
    /**
     * 锁定状态
     */
    LockedSurveyShip("locked","锁定合作关系"),
    /**
     * 解锁状态
     */
    UnlockSurveyShip("unlock","解锁合作关系");
    
    /**
     * 操作类型
     */
    private String type;
    /**
     * 说明
     */
    private String content;

    /**
     * 构造方法
     * 
     * @param type
     *            类型
     * @param content
     *            说明
     */
    private OperationEnum(String type, String content) {
        this.type = type;
        this.content = content;
    }

    /**
     * @return the type
     */
    public String getType() {
        return type;
    }

    /**
     * @param type
     *            the type to set
     */
    public void setType(String type) {
        this.type = type;
    }

    /**
     * @return the content
     */
    public String getContent() {
        return content;
    }

    /**
     * @param content
     *            the content to set
     */
    public void setContent(String content) {
        this.content = content;
    }

}
