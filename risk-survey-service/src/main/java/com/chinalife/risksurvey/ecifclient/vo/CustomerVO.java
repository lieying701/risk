package com.chinalife.risksurvey.ecifclient.vo;

/**
 * ecif 客户请求实体
 *
 * @author: marscheng
 * @date: 2017-11-29 下午8:29
 */
public class CustomerVO extends PlcInsurantVO {

    private static final long serialVersionUID = -1184361563051804642L;
    /**
     * 自然人
     */
    private PlcCustomerVO plcCustomer;
    /**
     * 非自然人
     */
    private PlcGrpcustomerVO plcGrpCustomer;

    public PlcCustomerVO getPlcCustomer() {
        return plcCustomer;
    }

    public void setPlcCustomer(PlcCustomerVO plcCustomer) {
        this.plcCustomer = plcCustomer;
    }

    public PlcGrpcustomerVO getPlcGrpCustomer() {
        return plcGrpCustomer;
    }

    public void setPlcGrpCustomer(PlcGrpcustomerVO plcGrpCustomer) {
        this.plcGrpCustomer = plcGrpCustomer;
    }
}
