package com.chinalife.risksurvey.constant;

/**
 * 包名称： com.chinalife.risksurvey.constant <br/>
 * 类名称：RequestEnum<br/>
 * 类描述：<br/>
 * 
 * @version <br/>
 */
public enum RequestEnum {

    /**
     * 标记位key，对应标记状态，只能为true或false的值
     */
    flag("flag", "标记位key，对应标记状态，只能为true或false的值"),
    /**
     * id的集合，前端传输类型为数组
     */
    idList("idList", "id的集合，前端传输类型为数组");

    /**
     * key值
     */
    private String key;
    /**
     * key值说明
     */
    private String content;

    /**
     * @param key
     *            key值
     * @param content
     *            key值说明
     */
    private RequestEnum(String key, String content) {
        this.key = key;
        this.content = content;
    }

    /**
     * @return the key
     */
    public String getKey() {
        return key;
    }

    /**
     * @param key
     *            the key to set
     */
    public void setKey(String key) {
        this.key = key;
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
