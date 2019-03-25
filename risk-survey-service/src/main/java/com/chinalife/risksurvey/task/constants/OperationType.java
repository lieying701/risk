package com.chinalife.risksurvey.task.constants;

/**
 * @author
 *
 */
public enum OperationType {
    /** GIVE_UP */
    GIVE_UP("Giveup", "放弃"),
    /** RECALL */
    RECALL("Recall", "撤回"),
    /** REJECT */
    REJECT("Reject", "退回"),
    /** PASS */
    PASS("Pass", "通过"),
    /** SUBMIT */
    SUBMIT("Submit", "提交上级"),
    /** NORMAL */
    NORMAL("Normal", "正常"),
    /** COMPLAIN */
    COMPLAIN("Complain", "申诉"),
    /** WRITENOFF */
    WRITENOFF("WritenOff","注销"),
    /** ENTERING(录入状态，非工作流使用) */
    ENTERING("Entering","录入"),
    /** LOCK */
    LOCK("lock","锁定"),
    /** supp */
    SUPP("supp", "补充");
    /** code */
    private String code;

    /** description */
    private String description;

    /**
     * @param code
     *            code
     * @param description
     *            description
     */
    private OperationType(String code, String description) {
        this.code = code;
        this.description = description;
    }

    public String getCode() {
        return code;
    }

    public String getDescription() {
        return description;
    }

    /**
     * @param code
     *            code
     * @return OperationType
     */
    public static OperationType getOperationType(String code) {
        for (OperationType operationType : values()) {
            if (operationType.getCode().equals(code)) {
                return operationType;
            }
        }
        return null;
    }

    public boolean isPass() {
        return PASS.getCode().equals(this.code);
    }

    public boolean isReject() {
        return REJECT.getCode().equals(this.code);
    }

    public boolean isGiveup() {
        return GIVE_UP.getCode().equals(this.code);
    }

    public boolean isRecall() {
        return RECALL.getCode().equals(this.code);
    }

    public boolean isSubmit() {
        return SUBMIT.getCode().equals(this.code);
    }

    /**
     * @return boolean
     */
    public boolean idSupp() {
        return SUPP.getCode().equals(this.code);
    }

    /**
     * @param operationType
     *            operationType
     * @return boolean
     */
    public static boolean isComplain(String operationType) {
        return COMPLAIN.getCode().equals(operationType);
    }

    // public static boolean isReject(String operationType) {
    // return REJECT.getCode().equals(operationType);
    // }
}
