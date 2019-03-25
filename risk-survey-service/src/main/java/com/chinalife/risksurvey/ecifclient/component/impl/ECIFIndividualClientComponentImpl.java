package com.chinalife.risksurvey.ecifclient.component.impl;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.stereotype.Component;

import com.chinalife.base.exception.StandardRuntimeException;
import com.chinalife.base.util.DateUtils;
import com.chinalife.integration.ecif.vo.ECIFResponse;
import com.chinalife.integration.ecif.webservice.Address;
import com.chinalife.integration.ecif.webservice.ElectronicContactPoint;
import com.chinalife.integration.ecif.webservice.IndividualPrpObjTag;
import com.chinalife.integration.ecif.webservice.IndividualPrpQueryListObjTag;
import com.chinalife.integration.ecif.webservice.PartyIdObj;
import com.chinalife.integration.ecif.webservice.PartyRegistrationKeyInfo;
import com.chinalife.integration.ecif.webservice.Telephone;
import com.chinalife.risksurvey.ecifclient.component.IECIFCustomerClientComponent;
import com.chinalife.risksurvey.ecifclient.vo.GetCustomeResponseBody;
import com.chinalife.risksurvey.ecifclient.vo.IndividualListResponse;
import com.chinalife.risksurvey.ecifclient.vo.IndividualResponse;
/**
 * ecif客户信息
 * 包名称： com.chinalife.risksurvey.ecifclient.component.impl 
 * 类名称：ECIFIndividualClientComponentImpl<br/>    
 * 类描述：<br/>  
 * @version <br/>   
 */

@Component("ecifIndividualComponent")
public class ECIFIndividualClientComponentImpl extends ECIFClientComponentImpl implements IECIFCustomerClientComponent {
    @Override
    public GetCustomeResponseBody getCustomer(String sysId, String interruptFlag, String customerType, PartyIdObj partyIdObj, PartyRegistrationKeyInfo partyRegistrationKeyInfo, Telephone telephone) {
        GetCustomeResponseBody responseBody = new GetCustomeResponseBody();
        ECIFResponse ecifResponse = new ECIFResponse();
        ecifResponse = ecifService.getIndividualStatus(sysId, interruptFlag, partyIdObj, partyRegistrationKeyInfo,
                telephone);
        // ecif请求信息
        responseBody.setEcifInfo(ecifResponse.getEcifInfo());
        // ecif请求结果
        responseBody.setResponseCode(ecifResponse.getResponseCode());
        // 是否中断出单
        responseBody.setInterruptFlag(interruptFlag);
        if (ecifResponse.getResponseCode().equals(SUCCESS)) { // 判断是否请求成功
            // 将是否多条信息赋值
            responseBody.setIfMulti(ecifResponse.getIfMulti());
            if (ecifResponse.getIfMulti().equals(SINGLE)) { // 如果得到的是单条数据
                // 处理ecif返回的单条信息
                responseBody.setIndividualResponse(dealIndividualSingle(ecifResponse.getIndividualDetail()));

            } else if (ecifResponse.getIfMulti().equals(MULTITERM)) { // 如果得到的是多条数据
                if (!(ecifResponse.getIndividualDetailList().isEmpty())) {
                    // 处理ecif返回的多条信息
                    responseBody.setIndividualListResponses(
                            dealIndidualMultiterm(ecifResponse.getIndividualDetailList()));
                }
            }
        }
        return responseBody;
    }
    /**
     * @param individualPrpObjTag ecif单条个人客户数据
     * @return 单条客户信息
     * @Description: 处理ecif返回个人客户单条数据
     */

    private IndividualResponse dealIndividualSingle(IndividualPrpObjTag individualPrpObjTag) {
        IndividualResponse individualResponse = new IndividualResponse();
        // 或取客户id
        individualResponse.setCustomerCode(individualPrpObjTag.getIndividual().getPartyId() == null ? ""
                : individualPrpObjTag.getIndividual().getPartyId().toString());

        // 获取国家信息
        individualResponse.setCountryCode(individualPrpObjTag.getIndividual().getCountryCode() == null ? ""
                : individualPrpObjTag.getIndividual().getCountryCode());

        //学历信息
        individualResponse.setDegree(individualPrpObjTag.getIndividual().getDegreeLevelCode());

        //年收入
        if (individualPrpObjTag.getIndividual().getIncome() != null) {
            individualResponse.setIncome(individualPrpObjTag.getIndividual().getIncome().longValue());
        }

        //收入币种
        individualResponse.setIncomeCurrency(individualPrpObjTag.getIndividual().getCurrencyCode());

        //行业代码
        individualResponse.setIndustryCategory(individualPrpObjTag.getIndividual().getIndustryCode());

        //民族代码
        individualResponse.setNationality(individualPrpObjTag.getIndividual().getNationalityCode());

        //职业代码
        individualResponse.setOccupationCode(individualPrpObjTag.getIndividual().getOccupationCode());

        //单位名称
        individualResponse.setOccupationName(individualPrpObjTag.getIndividual().getCompanyName());

        //社保编号
        individualResponse.setSocialInsuNo(individualPrpObjTag.getIndividual().getPersonalSocialNo());


        // 获取地址信息
        if (!(individualPrpObjTag.getAddress().isEmpty())) {
            for (Address address : individualPrpObjTag.getAddress()) {
                if (POST_ADDRESS.equals(address.getRoleInContactTypeCode())) { //获取个人联系地址
                    // 获取中文详细地址
                    individualResponse.setAddress(address.getCNAddress());
                    // 获取邮编
                    individualResponse.setPost(address.getPostcode());
                    // 如果individual中不含国家信息
                    if ("".equals(individualResponse.getCountryCode())) {
                        individualResponse.setCountryCode(address.getCountryCode() == null ? ""
                                : address.getCountryCode());
                    }
                } else if (HOME_ADDRESS.equals(address.getRoleInContactTypeCode())) {
                    // 获取家庭地址
                    individualResponse.setHomeAddress(address.getCNAddress());
                }
            }
        }

        if ("".equals(individualResponse.getCountryCode())) { // 如果国家为空也默认境内
            individualResponse.setIsWithinForeign(WITH_IN_FOREIGN);
        } else { // 不为空再判断
            if (individualResponse.getCountryCode().equals(CHINA)) { // 境内
                individualResponse.setIsWithinForeign(WITH_IN_FOREIGN);
            } else { // 境外
                individualResponse.setIsWithinForeign(FOREIGN);
            }
        }
        // 获取性别
        individualResponse.setSex(individualPrpObjTag.getIndividual().getGenderCode());

        try {
            // 获取生日
            if (individualPrpObjTag.getIndividual().getBirthday() != null) {
                Date birthday = convertToDate(individualPrpObjTag.getIndividual().getBirthday());
                individualResponse.setBirthDate(DateUtils.getTimeByCustomPattern(birthday, "yyyy-MM-dd"));
                // 获取年龄
                individualResponse.setAge(DateUtils.getYearsBetween(DateUtils.getCurrentDate(), birthday));
            } else { // 如果为空
                individualResponse.setBirthDate("");
                individualResponse.setAge(0);
            }
            //获取死亡日期
            if (individualPrpObjTag.getIndividual().getDeathDate() != null) {
                Date deathDate = convertToDate(individualPrpObjTag.getIndividual().getDeathDate());
                individualResponse.setDeathDate(DateUtils.getTimeByCustomPattern(deathDate,
                        "yyyy-MM-dd"));
            }

            //入司时间
            if (individualPrpObjTag.getIndividual().getStartWorkDate() != null) {
                Date startWork = convertToDate(individualPrpObjTag.getIndividual()
                        .getStartWorkDate());
                individualResponse.setEnterTime(DateUtils.getTimeByCustomPattern(startWork, "yyyy-MM-dd"));
            }

            // 证件信息
            if (!(individualPrpObjTag.getPartyRegistration().isEmpty())) {
                //证件识别id
                individualResponse.setRegistId(individualPrpObjTag.getPartyRegistration().get(0)
                        .getRegistId().toString());
                // 获取证件名称
                individualResponse.setIdname(individualPrpObjTag.getPartyRegistration().get(0).getIDName());
                // 获取证件号码
                individualResponse.setIdno(individualPrpObjTag.getPartyRegistration().get(0).getIDNo());
                // 获取证件类型
                individualResponse.setIdtypeCode(individualPrpObjTag.getPartyRegistration().get(0).getIDTypeCode());

                if (individualPrpObjTag.getPartyRegistration().get(0).getIssueDate() != null) {
                    //获取证件有效起期
                    individualResponse.setIdentityEffetiveStartDate(DateUtils.getTimeByCustomPattern(
                            (convertToDate(individualPrpObjTag.getPartyRegistration().get(0).getIssueDate())),
                            "yyyy-MM-dd"));
                }

                if (individualPrpObjTag.getPartyRegistration().get(0).getInvalidDate() != null) {
                    // 获取证件到期日期
                    individualResponse.setIdentityEffetiveEndDate(DateUtils.getTimeByCustomPattern(
                            (convertToDate(individualPrpObjTag.getPartyRegistration().get(0).getInvalidDate())),
                            "yyyy-MM-dd"));
                }
                
                // 签发机关
                individualResponse.setSignDepartmentName(individualPrpObjTag.getPartyRegistration().get(0).getIssueOrg());
            }

            //婚姻状况代码
            individualResponse.setMarriage(individualPrpObjTag.getIndividual().getMaritialStatusCode());
            //结婚日期
            if (individualPrpObjTag.getIndividual().getMaritalStatusDate() != null) {
                Date maritalDate = convertToDate(individualPrpObjTag.getIndividual()
                        .getMaritalStatusDate());
                individualResponse.setMarriageDate(DateUtils.getTimeByCustomPattern(maritalDate, "yyyy-MM-dd"));
            }
        } catch (Exception e) {
            e.printStackTrace();
            throw new StandardRuntimeException(e);
        }

        // 获取电话信息
        if (!(individualPrpObjTag.getTelephone().isEmpty())) {
            // 固定电话的标志位，保证取第一个固定电话
            Boolean phoneFlag = false;
            // 手机标志位，保证取第一个手机
            Boolean mobileFlag = false;
            for (Telephone telephone2 : individualPrpObjTag.getTelephone()) {
                // 如果是座机且座机从未取到值
                if (telephone2.getRoleInContactTypeCode().equals(PHONE) && (!phoneFlag)) {
                    if (telephone2.getRegionNo() != null) { // 判断区号字段是否为空
                        individualResponse.setPhoneNumber(telephone2.getRegionNo() + telephone2.getPhoneNo());// 将区号和号码拼接
                    } else { // 区号字段为空
                        individualResponse.setPhoneNumber(telephone2.getPhoneNo());
                    }
                    // 记录重复的电话数量
                    individualResponse.setPhoneNumberRepeatNo(telephone2.getTelephoneTypeCode());
                    phoneFlag = true;
                } else if (telephone2.getRoleInContactTypeCode().equals(MOBILE) && (!mobileFlag)) { // 如果是手机
                    individualResponse.setMobile(telephone2.getPhoneNo());
                    // 记录重复的电话数量
                    individualResponse.setMobileRepeatNo(telephone2.getTelephoneTypeCode());
                    mobileFlag = true;
                }
            }
        }

        // 获取电子地址（QQ或者邮箱等）
        if (!(individualPrpObjTag.getElectronicContactPoint().isEmpty())) {
            for (ElectronicContactPoint electronicContactPoint : individualPrpObjTag.getElectronicContactPoint()) {
                if (electronicContactPoint.getRoleInContactTypeCode().equals(EMAIL)) { // 获取邮箱
                    individualResponse.setEmail(electronicContactPoint.getEAddress());
                    break;
                }
            }
        }

        // 获取客户服务等级
        individualResponse.setCustomerGrade(individualPrpObjTag.getMaxServiceLevelObj().getMaxSrvLevelCode());

        // 客户风险等级
        if (!(individualPrpObjTag.getCustRiskLevel().isEmpty())) {
            // 获取自动客户风险等级
            individualResponse
                    .setAutoRiskLevelCode(individualPrpObjTag.getCustRiskLevel().get(0).getAutoRiskLevelCode());
            // 获取人工客户风险等级
            individualResponse
                    .setManualRiskLevelCode(individualPrpObjTag.getCustRiskLevel().get(0).getManualRiskLevelCode());
        }
        
        if (!individualPrpObjTag.getPartyName().isEmpty()) {
            for (int i = 0; i < individualPrpObjTag.getPartyName().size(); i++) {
                if (IDV_ENAME.equals(individualPrpObjTag.getPartyName().get(i).getNameTypeCode())) {
                    individualResponse.setCustomerEName(individualPrpObjTag.getPartyName().get(i).getLastName());
                }
            }
        }

        return individualResponse;
    }
    
    /**
     * @param individualPrpQueryListObjTags 多条个人客户数据
     * @return 多条客户信息
     * @Description: 处理多条个人客户数据
     */
    private List<IndividualListResponse> dealIndidualMultiterm(
            List<IndividualPrpQueryListObjTag> individualPrpQueryListObjTags) {
        List<IndividualListResponse> individualListResponses = new ArrayList<>();
        IndividualListResponse individualListResponse = null;
        for (IndividualPrpQueryListObjTag individualPrpQueryListObjTag : individualPrpQueryListObjTags) {
            individualListResponse = new IndividualListResponse();
            // 标志客户类型是个人
            individualListResponse.setPartyTypeCode(INDIVIDUAL_CODE);
            // 获取证件信息
            if (!(individualPrpQueryListObjTag.getPartyRegistration().isEmpty())) {
                // 获取证件名称
                individualListResponse
                        .setIdname(individualPrpQueryListObjTag.getPartyRegistration().get(0).getIDName());
                // 获取证件号码
                individualListResponse.setIdno(individualPrpQueryListObjTag.getPartyRegistration().get(0).getIDNo());
                // 获取证件类型
                individualListResponse
                        .setIdtypeCode(individualPrpQueryListObjTag.getPartyRegistration().get(0).getIDTypeCode());
                // 获取客户id
                individualListResponse
                        .setPartyId(individualPrpQueryListObjTag.getPartyRegistration().get(0).getPartyId() == null ? ""
                                : individualPrpQueryListObjTag.getPartyRegistration().get(0).getPartyId().toString());
            }
            // 获取客户性别
            individualListResponse.setCustomerGender(individualPrpQueryListObjTag.getGenderCode());

            // 获取客户状态
            if (!(individualPrpQueryListObjTag.getCustLifeStatus().isEmpty())) {
                individualListResponse
                        .setCustomerStatus(individualPrpQueryListObjTag.getCustLifeStatus().get(0).getLifeStatusCode());
            }
            
            // 获取英文名称
            if (!individualPrpQueryListObjTag.getPartyName().isEmpty()) {
                for (int i = 0; i < individualPrpQueryListObjTag.getPartyName().size(); i++) {
                    if (IDV_ENAME.equals(individualPrpQueryListObjTag.getPartyName().get(i).getNameTypeCode())) {
                        individualListResponse.setCustomerEName(individualPrpQueryListObjTag.getPartyName().get(i).getLastName());
                    }
                }
            }
            
            // 获取电话信息
            if (!(individualPrpQueryListObjTag.getTelephone().isEmpty())) {
                // 固定电话的标志位，保证取第一个固定电话
                Boolean phoneFlag = false;
                // 手机标志位，保证取第一个手机
                Boolean mobileFlag = false;
                for (Telephone telephone2 : individualPrpQueryListObjTag.getTelephone()) {
                    // 如果是座机且座机从未取到值
                    if (telephone2.getRoleInContactTypeCode().equals(PHONE) && (!phoneFlag)) {
                        if (telephone2.getRegionNo() != null) { // 判断区号字段是否为空
                            individualListResponse.setPhoneNumber(telephone2.getRegionNo() + telephone2.getPhoneNo());// 将区号和号码拼接
                        } else { // 区号字段为空
                            individualListResponse.setPhoneNumber(telephone2.getPhoneNo());
                        }
                        phoneFlag = true;
                    } else if (telephone2.getRoleInContactTypeCode().equals(MOBILE) && (!mobileFlag)) { // 如果是手机
                        individualListResponse.setMobile(telephone2.getPhoneNo());
                        mobileFlag = true;
                    }
                }
            }
            
            // 获取地址信息
            if (!(individualPrpQueryListObjTag.getAddress().isEmpty())) {
                for (Address address : individualPrpQueryListObjTag.getAddress()) {
                    if (POST_ADDRESS.equals(address.getRoleInContactTypeCode())) { //获取个人联系地址
                        // 获取中文详细地址
                        individualListResponse.setAddress(address.getCNAddress());
                        // 获取邮编
                        individualListResponse.setPost(address.getPostcode());
                    }
                }
            }

            individualListResponses.add(individualListResponse);
        }
        return individualListResponses;
    }
}
