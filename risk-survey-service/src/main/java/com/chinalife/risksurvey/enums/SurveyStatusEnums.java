package com.chinalife.risksurvey.enums;


/**   
 * 包名称： com.chinalife.risksurvey.enums 
 * 类名称：SurveyStatusEnums<br/>    
 * 类描述：<br/>  
 * @version <br/>   
 */  
public enum SurveyStatusEnums {

    /**
     * 初始化"
     */
    INIT("00", "Init", "初始化"),
    
    /**
     * 保存
     */
    SAVE("01", "Save", "保存"),

    /**
     * 任务创建中  初次创建
     */
    TASKENTERING("02", "TaskEntering", "任务创建中"),

    /**
     * 未分派
     */
    UNASSIGNED("03", "Unassigned", "未分派"),

    /**
     * 已分派
     */
    ASSIGNED("04", "Assigned", "已分派"),

    /**
     * 未提交
     */
    UNCOMMITTED("05", "Uncommitted", "未提交"),

    /**
     * 已提交
     */
    SUBMITTED("06", "Submitted", "已提交"),
    
    /**
     *  补充  任务创建中
     */
    ADDTASKENTERING("07", "AddTaskEntering", "任务创建中(补充)"),
    /**
     * 下发修改
     */
    MODIFY("08", "Modify", "下发修改"),

    /**
     * 完成
     */
    FINISH("09", "Finish", "已完成"),

    /**
     * 
     */
    LOGOUT("10", "Logout", "注销");

    /**
     * 
     */
    private String code;
    
    /**
     * 
     */
    private String name;
    
    /**
     * 
     */
    private String description;

    /** 
     * @param code code
     * @param name name
     * @param description  description
     */
    private SurveyStatusEnums(String code, String name, String description) {
        this.code = code;
        this.name = name;
        this.description = description;
    }

    public String getCode() {
        return code;
    }

    public String getName() {
        return name;
    }

    public String getDescription() {
        return description;
    }

}
