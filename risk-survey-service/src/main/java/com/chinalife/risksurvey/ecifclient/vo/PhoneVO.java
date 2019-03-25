package com.chinalife.risksurvey.ecifclient.vo;

/**
 * 电话vo实体
 *
 * @author: marscheng
 * @date: 2017-12-19 上午9:27
 */
public class PhoneVO {
    /**
     * 电话号码
     */
    private String phoneNo;

    /**
     * 重复数量
     */
    private String repeatNo;
    /**
     * 电话类型
     */
    private String type;

    /**
     * 电话类型名称
     */
    private String typeName;

    public String getPhoneNo() {
        return phoneNo;
    }

    public void setPhoneNo(String phoneNo) {
        this.phoneNo = phoneNo;
    }

    public String getRepeatNo() {
        return repeatNo;
    }

    public void setRepeatNo(String repeatNo) {
        this.repeatNo = repeatNo;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getTypeName() {
        return typeName;
    }

    public void setTypeName(String typeName) {
        this.typeName = typeName;
    }
}
