package com.chinalife.risksurvey.task.constants;

import com.chinalife.base.exception.StandardRuntimeException;
import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * 
 *
 */
public enum TaskStatusEnum {

    /** Pending */
    Pending("02", "待处理", null),

    /** Processing */
    Processing("03", "处理中", new String[] { "Pending" }),

    /** Processed */
    Processed("04", "已处理", new String[] { "Assigning", "Pending", "Processing" }),

    /** Cancel */
    Cancel("05", "已撤销", null),
    
    /** reject */
    REJECT("06", "退回修改", new String[]{"Reject"});

    /** LOGGER */
    public static final Logger LOGGER = LoggerFactory.getLogger(TaskStatusEnum.class);
    /** code */
    private String code;
    /** description */
    private String description;
    /** preStatus */
    private String[] preStatus;

    /**
     * @param code
     *            code
     * @param description
     *            description
     * @param preStatus
     *            preStatus
     */
    private TaskStatusEnum(String code, String description, String[] preStatus) {
        this.code = code;
        this.description = description;
        this.preStatus = preStatus;
    }

    public String getDescription() {
        return description;
    }

    public String getCode() {
        return code;
    }

    public String[] getPreStatus() {
        return preStatus;
    }

    /**
     * @param value
     *            value
     * @return TaskStatusEnum
     */
    public static TaskStatusEnum statusOf(String value) {
        for (TaskStatusEnum taskStatus : values()) {
            if (StringUtils.equals(taskStatus.getCode(), value)) {
                return taskStatus;
            }
        }
        return null;
    }

    /**
     * @param originalCode
     *            originalCode
     * @param destination
     *            destination
     */
    public static void checkStatus(String originalCode, TaskStatusEnum destination) {
        TaskStatusEnum original = statusOf(originalCode);
        if (original == null) {
            throw new StandardRuntimeException("任务执行失败");
        }
        if (!destination.getCode().equals(originalCode) && destination.getPreStatus() != null
                && destination.getPreStatus().length > 0) {
            for (String preStatusCode : destination.getPreStatus()) {
                if (preStatusCode.equals(originalCode)) {
                    return;
                }
            }
            throw new StandardRuntimeException("任务状态出错");
        }
    }


    /**
     * @param code code
     * @return boolean
     */
    public static boolean isPending(String code) {
        return Pending.getCode().equals(code);
    }

    /**
     * @param code code
     * @return boolean
     */
    public static boolean isProcessed(String code) {
        return Processed.getCode().equals(code);
    }

    /**
     * @param code
     *            code
     */
    public static void giveUpChecking(String code) {
        if (!Pending.getCode().equals(code) && !Processing.getCode().equals(code)) {
            LOGGER.error("任务状态不符合条件，Status：{}，应为：{}或{}", code, Pending.getCode(), Processing.getCode());
            throw new StandardRuntimeException("任务状态出错");
        }
    }

    /**
     * @param code
     *            code
     */
    public static void rejectChecking(String code) {
        if (!Pending.getCode().equals(code)) {
            LOGGER.error("任务状态不符合条件，Status：{}，应为：{}", code, Pending.getCode());
            throw new StandardRuntimeException("任务状态出错");
        }
    }

    /**
     * @param code code
     * @return boolean
     */
    public static boolean canBeForceAssign(String code) {
        return !Processed.getCode().equals(code);
    }

    /**
     * @param status status
     * @return boolean
     */
    public static boolean isProcessing(String status) {
        return Processing.getCode().equals(status);
    }

    /**
     * @param code
     *            code
     */
    public static void passChecking(String code) {
        if (!Pending.getCode().equals(code)) {
            throw new StandardRuntimeException("任务状态出错");
        }
    }
}
