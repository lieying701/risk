package com.chinalife.risksurvey.constant;

/**
 * 
 * @Description: 机构关系类型
 * @author: lshi041
 * @date: Dec 5, 2017 10:58:34 AM
 *
 */
public enum StructureRlshipTypeEnum {

    /**枚举类*/
    SalesManage("Underwriting");

    /**CODE*/
    private String code;

 
    /**
     * 
     * @Description:    构造方法
     * @param code a
     */
    StructureRlshipTypeEnum(String code) {
        this.code = code;
    }

    /**
     * 
     * @Description:    获取Code
     * @return  code
     */
    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }
    
    
}
