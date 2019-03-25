package com.chinalife.risksurvey.ecifclient.constant;

/**
 * @Description: 送ecif系统的常量类
 * @date: 2017年12月28日
 * @author: huangbiao
 * @version: 1.0.0
 * @Copyright: 2017 www.chinalife-p.com.cn Inc. All rights reserved.
 */
public class EcifConstant {

    /**
     * @Description: 系统ID
     * @date: 2017年12月28日
     * @author: huangbiao
     * @version: 1.0.0
     * @Copyright: 2017 www.chinalife-p.com.cn Inc. All rights reserved.
     */
    public enum SysIdEnum {
        /**
         * 枚举对象
         */
        POLICY_CENTER("B102", "保单中心"), QUOTATION_CENTER("B103", "报价中心"), WORKBENCH("T101", "统一工作台");
        /**
         * @Fields id : id
         */
        private String id;
        /**
         * @Fields descption : 描述
         */
        private String descption;

        /**
         * @param id        值
         * @param descption 描述
         *
         * @Description: 构造方法
         */
        private SysIdEnum(String id, String descption) {
            this.id = id;
            this.descption = descption;
        }

        public String getId() {
            return id;
        }

        public void setId(String id) {
            this.id = id;
        }

        public String getDescption() {
            return descption;
        }

        public void setDescption(String descption) {
            this.descption = descption;
        }

    }

    /**
     * @Description: 中断出单标志
     * @date: 2017年12月28日
     * @author: huangbiao
     * @version: 1.0.0
     * @Copyright: 2017 www.chinalife-p.com.cn Inc. All rights reserved.
     */
    public enum InterruptFlagEnum {
        /**
         * 枚舉對象
         */
        NOT_INTERRUPT("0", "不中断出单"), INTERRUPT("1", "中断出单");
        /**
         * @Fields value : 值
         */
        private String value;
        /**
         * @Fields descption : 描述
         */
        private String descption;

        /**
         * @param value     值
         * @param descption 描述
         *
         * @Description: 构造方法
         */
        private InterruptFlagEnum(String value, String descption) {
            this.value = value;
            this.descption = descption;
        }

        public String getValue() {
            return value;
        }

        public void setValue(String value) {
            this.value = value;
        }

        public String getDescption() {
            return descption;
        }

        public void setDescption(String descption) {
            this.descption = descption;
        }

    }

}
