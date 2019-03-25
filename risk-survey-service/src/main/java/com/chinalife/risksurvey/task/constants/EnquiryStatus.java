package com.chinalife.risksurvey.task.constants;

import org.apache.commons.lang3.StringUtils;

/**
 * enquiry status
 *
 * @author jzhou237
 * @version 1
 */
public enum EnquiryStatus {

    /**
     * none
     */
    NONE("None", "无临分询价"),
    /**
     * pause
     */
    PAUSE("0", "暂存"),
    /**
     * to confirm
     */
    TO_CONFIRM("1", "待确认"),
    /**
     * to pass
     */
    TO_PASS("2", "待通过"),
    /**
     * confirm pass
     */
    CONFIRM_PASS("3", "确认通过"),
    /**
     * confirm fail
     */
    CONFIRM_FAIL("4", "确认不通过"),
    /**
     * not enquiry
     */
    NOT_INQUIRY("5", "非临分"),
    /**
     * cancel
     */
    CANCEL("9", "注销");

    /**
     * code
     */
    private String code;

    /**
     * name
     */
    private String name;

    /**
     * constructor
     *
     * @param code code
     * @param name name
     */
    EnquiryStatus(String code, String name) {
        this.code = code;
        this.name = name;
    }

    public String getCode() {
        return code;
    }

    public String getName() {
        return name;
    }

    /**
     * get init status
     *
     * @return enquiry status
     */
    public static EnquiryStatus initStatus() {
        return TO_CONFIRM;
    }

    /**
     * status of
     *
     * @param code code
     *
     * @return enquiry status
     */
    public static EnquiryStatus statusOf(String code) {
        for (EnquiryStatus enquiryStatus : values()) {
            if (enquiryStatus.getCode().equals(code)) {
                return enquiryStatus;
            }
        }
        return TO_CONFIRM;
    }

    /**
     * has enquiry status
     *
     * @param code code
     *
     * @return boolean
     */
    public static Boolean hasEnquiryStatus(String code) {
        return StringUtils.isNotEmpty(code) && !StringUtils.equals(NONE.getCode(), code);
    }

    /**
     * success
     *
     * @param code code
     *
     * @return boolean
     */
    public static Boolean success(String code) {
        return StringUtils.equals(CONFIRM_PASS.getCode(), code);
    }
}
