package com.chinalife.risksurvey.ecifclient.component.impl;

import java.util.Date;
import java.util.GregorianCalendar;

import javax.xml.datatype.XMLGregorianCalendar;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.chinalife.integration.ecif.service.IECIFService;
import com.chinalife.integration.ecif.webservice.PartyIdObj;
import com.chinalife.integration.ecif.webservice.PartyRegistrationKeyInfo;
import com.chinalife.integration.ecif.webservice.Telephone;
import com.chinalife.risksurvey.ecifclient.component.IECIFClientComponet;
import com.chinalife.risksurvey.ecifclient.vo.GetCustomeResponseBody;

/**
 * ecif 客户请求实体
 * 包名称： com.chinalife.risksurvey.ecifclient.component.impl 
 * 类名称：ECIFClientComponentImpl<br/>    
 * 类描述：<br/>  
 * @version <br/>   
 */
@Component("ecifClientComponent")
public class ECIFClientComponentImpl implements IECIFClientComponet {

    /**
     * ecif封装请求类
     */
    @Autowired
    protected IECIFService ecifService;

    /**
     * 个人客户信息
     */
    public static final String INDIVIDUAL_CODE = "1";
    /**
     * 组织客户信息
     */
    public static final String ORGNIZATION_CODE = "2";

    /**
     * // 不中断出单
     */
    protected static final String NO_INTERRUPT = "0";
    /**
     * // 中断出单
     */
    protected static final String INTERRUPT = "1";

    /**
     * ecif请求成功
     */
    protected static final String SUCCESS = "1";
    /**
     * ecif请求失败
     */
    public static final String FAIL = "0";
    /**
     * 客户信息是多条
     */
    protected static final String MULTITERM = "1";
    /**
     * 客户信息是单条
     */
    protected static final String SINGLE = "0";
    /**
     * 客户所属国籍是中国
     */
    protected static final String CHINA = "CHN";
    /**
     * 境内
     */
    protected static final String WITH_IN_FOREIGN = "1";
    /**
     * 境外
     */
    protected static final String FOREIGN = "0";
    /**
     * 个人家庭地址
     */
    public static final String HOME_ADDRESS = "110";
    /**
     * 个人联系地址
     */
    protected static final String POST_ADDRESS = "114";

    /**
     * 传真
     */
    protected static final String FACSIMILE_TYPE = "3";

    /**
     * 组织者传真
     */
    protected static final String FACSIMILE = "231";
    /**
     * 个人固定电话
     */
    protected static final String PHONE = "130";
    /**
     * 个人手机
     */
    protected static final String MOBILE = "132";
    /**
     * 个人邮箱
     */
    protected static final String EMAIL = "121";

    /**
     * 组织邮箱
     */
    protected static final String ORG_EMAIL = "221";

    /**
     * 邮箱代码
     */
    protected static final String CONTACT_EMAIL = "02";

    /**
     * 微信
     */
    protected static final String CONTACT_WECHAT = "07";

    /**
     * 单位电话
     */
    protected static final String UNIT_PHONE = "131";
    /**
     * weChat(没有微信代码,拿QQ代替了)
     */
    protected static final String WECHAT = "123";
    /**
     * 组织注册地址
     */
    protected static final String REGISTY_ADDRESS = "210";
    /**
     * 组织联系地址
     */
    protected static final String MAIL_ADDRESS = "211";
    /**
     * 控股股东
     */
    protected static final String SHAREHOLDER = "21";
    /**
     * 公司法人
     */
    protected static final String LEADERNAME = "22";
    /**
     * 公司负责人
     */
    protected static final String PRINCIPAL = "23";
    /**
     * 当事方类型为组织
     */
    protected static final String ORGNIZATION_TYPE = "1020";
    /**
     * 联系人信息默认为组织客户业务联系人
     */
    protected static final String LINK_MAN = "3";

    /**
     * 名称是组织的
     */
    protected static final String ORGNIZATION_PART = "1020";

    /**
     * 名称是个人的
     */
    protected static final String INDIVIDUAL_PART = "1010";

    /**
     * 个人中文名
     */
    protected static final String IDV_CNAME = "11";

    /**
     * 个人英文名
     */
    protected static final String IDV_ENAME = "12";

    /**
     * 组织中文名
     */
    protected static final String UNIT_CNAME = "21";

    /**
     * 组织英文名
     */
    protected static final String UNIT_ENAME = "23";
    //
    /**
     * 前端日期格式
     */
    protected static final String FRONT_DATE_FORMAT = "yyyy-MM-dd'T'HH:mm:ss.SSSXX";

    @Override
    public GetCustomeResponseBody getCustomer(String sysId, String interruptFlag, String customerType, PartyIdObj partyIdObj, PartyRegistrationKeyInfo partyRegistrationKeyInfo, Telephone telephone) {
        return null;
    }
    
    /**
     * 日历格式转日期格式
     *
     * @param cal 日期格式
     * @return date格式
     * @throws Exception 日期转换异常
     */
    protected Date convertToDate(XMLGregorianCalendar cal) throws Exception {
        GregorianCalendar ca = cal.toGregorianCalendar();
        return ca.getTime();
    }


}
