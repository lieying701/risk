package com.chinalife.risksurvey.constant;

/**
 * 包名称： com.chinalife.risksurvey.constant <br/>
 * 类名称：RequestConstrant<br/>
 * 类描述： 响应返回的相关参数 <br/>
 * 
 * @version <br/>
 */
public enum ResponseEnum {

    /**
     * 异常信息
     */
    ErrorMsg("errorMsg","异常信息"),
    /**
     * 状态key
     */
    Status("status","状态key"),
    /**
     * 返回信息key
     */
    ReturnMsg("returnMsg", "返回信息"),
    /**
     * 500, "内部错误！"
     */
    HttpCode500("500", "内部错误！"),
    /**
     * 404, "找不到资源"
     */
    HttpCode404("404", "找不到资源"),
    /**
     * 200, "操作成功。"
     */
    HttpCode200("200", "操作成功。");

    /**
     * code
     */
    private String code;
    /**
     * value
     */
    private String value;

    /**
     * 构造方法
     * 
     * @param code
     *            编码
     * @param value
     *            值
     */
    private ResponseEnum(String code, String value) {
        this.code = code;
        this.value = value;
    }

    /**
     * @return the code
     */
    public String getCode() {
        return code;
    }

    /**
     * @param code
     *            the code to set
     */
    public void setCode(String code) {
        this.code = code;
    }

    /**
     * @return the value
     */
    public String getValue() {
        return value;
    }

    /**
     * @param value
     *            the value to set
     */
    public void setValue(String value) {
        this.value = value;
    }

}
