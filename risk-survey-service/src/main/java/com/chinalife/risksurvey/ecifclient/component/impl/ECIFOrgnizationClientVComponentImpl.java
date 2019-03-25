package com.chinalife.risksurvey.ecifclient.component.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Component;

import com.chinalife.base.util.DateUtils;
import com.chinalife.integration.ecif.vo.ECIFResponse;
import com.chinalife.integration.ecif.webservice.Address;
import com.chinalife.integration.ecif.webservice.CustVIPLevel;
import com.chinalife.integration.ecif.webservice.ElectronicContactPoint;
import com.chinalife.integration.ecif.webservice.OrgnizationPrpObj;
import com.chinalife.integration.ecif.webservice.OrgnizationPrpQueryListObj;
import com.chinalife.integration.ecif.webservice.PartyIdObj;
import com.chinalife.integration.ecif.webservice.PartyName;
import com.chinalife.integration.ecif.webservice.PartyRegistrationKeyInfo;
import com.chinalife.integration.ecif.webservice.Telephone;
import com.chinalife.risksurvey.ecifclient.component.IECIFCustomerClientComponent;
import com.chinalife.risksurvey.ecifclient.vo.GetCustomeResponseBody;
import com.chinalife.risksurvey.ecifclient.vo.OrgnizationListResponse;
import com.chinalife.risksurvey.ecifclient.vo.OrgnizationResponse;


/**
 * 组织ecif调用(包含查询/新增/修改)
 *
 * @author: marscheng
 * @date: 2017-12-21 下午4:32
 */
@Component("ecifOrgnizationComponent")
public class ECIFOrgnizationClientVComponentImpl extends ECIFClientComponentImpl implements
        IECIFCustomerClientComponent {

    @Override
    public GetCustomeResponseBody getCustomer(String sysId, String interruptFlag, String customerType, PartyIdObj partyIdObj, PartyRegistrationKeyInfo partyRegistrationKeyInfo, Telephone telephone) {
        GetCustomeResponseBody responseBody = new GetCustomeResponseBody();
        ECIFResponse ecifResponse = new ECIFResponse();
        ecifResponse = ecifService.getOrgnizationStatus(sysId, interruptFlag, partyIdObj, partyRegistrationKeyInfo,
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
                try {
                    responseBody.setOrgnizationResponse(dealOrgnizationSingle(ecifResponse
                            .getOrgnizationDetail(), ecifResponse.getCustVIPLevel()));
                } catch (Exception e) {
                    e.printStackTrace();
                }
            } else if (ecifResponse.getIfMulti().equals(MULTITERM)) { // 如果得到的是多条数据
                // 处理ecif返回的多条数据
                responseBody.setOrgnizationListResponses(
                        dealOrgnizationMultiterm(ecifResponse.getOrgnizationDetailList()));
            }
        }

        return responseBody;

    }

    /**
     * @param orgnizationPrpObj 单条组织客户数据
     * @param customerVIPGrade  重客vip等级
     * @return 单条组织信息
     * @Description: 处理单条组织客户数据
     */
    private OrgnizationResponse dealOrgnizationSingle(OrgnizationPrpObj orgnizationPrpObj, CustVIPLevel
            customerVIPGrade) throws Exception {
        OrgnizationResponse orgnizationResponse = new OrgnizationResponse();


        // 获取客户id
        orgnizationResponse.setCustomerCode(orgnizationPrpObj.getOrgnization().getPartyId() == null ? ""
                : orgnizationPrpObj.getOrgnization().getPartyId().toString());

        //营业执照号码
        orgnizationResponse.setBusilicense(orgnizationPrpObj.getOrgnization().getBizLicenceNo());

        //营业执照有效起期
        if (orgnizationPrpObj.getOrgnization().getBizLicenceNoValidDate() != null) {
            orgnizationResponse.setBusiLicenseStartDate(DateUtils.getTimeByCustomPattern(convertToDate(orgnizationPrpObj.getOrgnization().getBizLicenceNoValidDate()), "yyyy-MM-dd"));
        }

        //营业执照有效止期
        if (orgnizationPrpObj.getOrgnization().getBizLicenceNoInvalidDate() != null) {
            orgnizationResponse.setBusiLicenseEndDate(DateUtils.getTimeByCustomPattern(convertToDate(orgnizationPrpObj.getOrgnization().getBizLicenceNoInvalidDate()), "yyyy-MM-dd"));
        }

        //行业类型代码
        orgnizationResponse.setIndustryCategory(orgnizationPrpObj.getOrgnization().getIndustryCode());

        //税务登记号码(国税)
        orgnizationResponse.setTaxregistrationNo(orgnizationPrpObj.getOrgnization().getNationalTaxNo());

        //经营范围
        orgnizationResponse.setMainBusiness(orgnizationPrpObj.getOrgnization().getBizScope());

        //经济类型代码
        orgnizationResponse.setEconomicTypeCode(orgnizationPrpObj.getOrgnization().getEconomicTypeCode());

        //机构人数
        orgnizationResponse.setOrganizationPeopleNumber(orgnizationPrpObj.getOrgnization().getMemberNumber());

        //机构类型代码
        orgnizationResponse.setOrganizationType(orgnizationPrpObj.getOrgnization().getOrgnizationTypeCode());

        // 获取客户证件信息
        if (!(orgnizationPrpObj.getPartyRegistration().isEmpty())) {
            //客户证件识别id
            orgnizationResponse.setRegistId(orgnizationPrpObj.getPartyRegistration().get(0)
                    .getRegistId().toString());
            // 获取客户名称
            orgnizationResponse.setCustomerName(orgnizationPrpObj.getPartyRegistration().get(0).getIDName());
            // 获取客户证件号码
            orgnizationResponse.setIdno(orgnizationPrpObj.getPartyRegistration().get(0).getIDNo());
            // 获取证件类型
            orgnizationResponse.setIdtypeCode(orgnizationPrpObj.getPartyRegistration().get(0).getIDTypeCode());

            if (orgnizationPrpObj.getPartyRegistration().get(0).getIssueDate() != null) { //证件有效起期
                orgnizationResponse.setIdentityEffetiveStartDate(DateUtils.getTimeByCustomPattern(convertToDate(orgnizationPrpObj
                        .getPartyRegistration().get(0).getIssueDate()), "yyyy-MM-dd"));
            }

            if (orgnizationPrpObj.getPartyRegistration().get(0).getInvalidDate() != null) { //证件有效止期
                orgnizationResponse.setIdentityEffetiveEndDate(DateUtils.getTimeByCustomPattern(convertToDate(orgnizationPrpObj
                        .getPartyRegistration().get(0).getInvalidDate()), "yyyy-MM-dd"));
            }
        }

        // 获取联系人信息
        if (!(orgnizationPrpObj.getPartyLinkman().isEmpty())) {
            // 获取关联人名称
            orgnizationResponse.setLinkerName(orgnizationPrpObj.getPartyLinkman().get(0).getName());
            // 获取关联人手机
            orgnizationResponse.setLinkerMobile(orgnizationPrpObj.getPartyLinkman().get(0).getLinkmanMobile());
            // 获取关联人固话
            orgnizationResponse.setLinkerPhoneNo(orgnizationPrpObj.getPartyLinkman().get(0).getLinkmanPhone());
            // 通讯地址
            orgnizationResponse.setMailAddress(orgnizationPrpObj.getPartyLinkman().get(0).getAddress());
            // 邮政编码
            orgnizationResponse.setMailAddressPost(orgnizationPrpObj.getPartyLinkman().get(0).getPostcode());
            // 联系人邮箱
            if (orgnizationPrpObj.getPartyLinkman().get(0).getLinkmanEmail() != null 
                    && !"".equals(orgnizationPrpObj.getPartyLinkman().get(0).getLinkmanEmail())) {
                orgnizationResponse.setEmail(orgnizationPrpObj.getPartyLinkman().get(0).getLinkmanEmail());
            }
            // 传真
            orgnizationResponse.setFacsimile(orgnizationPrpObj.getPartyLinkman().get(0).getFax());
        }

        // 获取组织英文名
        if (!(orgnizationPrpObj.getPartyName().isEmpty())) {
            for (PartyName partyName : orgnizationPrpObj.getPartyName()) {
                if (partyName.getNameTypeCode().equals(UNIT_ENAME)) {
                    orgnizationResponse.setCustomerEName(partyName.getLastName());
                    break;
                }
            }
        }

        //获取邮箱
        if (orgnizationResponse.getEmail() == null && !(orgnizationPrpObj.getElectronicContactPoint().isEmpty())) {
            for (ElectronicContactPoint electronicContactPoint : orgnizationPrpObj.getElectronicContactPoint()) {
                if (electronicContactPoint.getRoleInContactTypeCode().equals(ORG_EMAIL)) {
                    orgnizationResponse.setEmail(electronicContactPoint.getEAddress());
                    break;
                }
            }
        }

        //获取传真
        if (orgnizationResponse.getFacsimile() == null && !(orgnizationPrpObj.getTelephone().isEmpty())) {
            for (Telephone telephone : orgnizationPrpObj.getTelephone()) {
                if (telephone.getTelephoneTypeCode().equals(FACSIMILE_TYPE) || telephone
                        .getRoleInContactTypeCode().equals(FACSIMILE)) {
                    orgnizationResponse.setFacsimile(telephone.getPhoneNo());
                }
            }
        }

        // 获取地址信息
        if (!(orgnizationPrpObj.getAddress().isEmpty())) {
            for (Address address : orgnizationPrpObj.getAddress()) {
                Boolean registyFlag = false;
                Boolean mailFlag = false;
                if (address.getRoleInContactTypeCode().equals(REGISTY_ADDRESS)) { //注册地址
                    // 获取注册地址
                    orgnizationResponse.setRegistyAddress(address.getCNAddress());
                    orgnizationResponse.setRegisteredPlaceCode(address.getCountryCode()); //注册地址所在地
                    registyFlag = true;
                    if (mailFlag) { //保证取第一条数据
                        break;
                    }
                }
                if (orgnizationResponse.getMailAddress() == null 
                        && address.getCNAddress() != null && !"".equals(address.getCNAddress()) 
                        && address.getRoleInContactTypeCode().equals(MAIL_ADDRESS)) { //联系地址
                    orgnizationResponse.setMailAddress(address.getCNAddress());
                    orgnizationResponse.setMailAddressPost(address.getPostcode());
                    mailFlag = true;
                    if (registyFlag) { //保证取第一条数据
                        break;
                    }
                }

            }
        }
        // 获取客户服务等级
        orgnizationResponse.setCustomerGrade(orgnizationPrpObj.getMaxServiceLevelObj().getMaxSrvLevelCode());
        if (!(orgnizationPrpObj.getCustRiskLevel().isEmpty())) {
            // 获取自动风险等级
            orgnizationResponse
                    .setAutoRiskLevelCode(orgnizationPrpObj.getCustRiskLevel().get(0).getAutoRiskLevelCode());
            // 获取人工风险等级
            orgnizationResponse
                    .setManualRiskLevelCode(orgnizationPrpObj.getCustRiskLevel().get(0).getManualRiskLevelCode());
        }
        //重客服务等级
        orgnizationResponse.setAutoVIPLevelCode(customerVIPGrade.getAutoVIPLevelCode());
        orgnizationResponse.setManualVIPLevelCode(customerVIPGrade.getManualVIPLevelCode());
        return orgnizationResponse;
    }

    /**
     * @param orgnizationPrpQueryListObjs 组织客户多条信息
     * @return 多条组织信息
     * @Description: 处理组织多条信息
     */
    private List<OrgnizationListResponse> dealOrgnizationMultiterm(
            List<OrgnizationPrpQueryListObj> orgnizationPrpQueryListObjs) {
        List<OrgnizationListResponse> orgnizationListResponses = new ArrayList<>();
        for (OrgnizationPrpQueryListObj orgnizationPrpQueryListObj : orgnizationPrpQueryListObjs) {
            OrgnizationListResponse orgnizationListResponse = new OrgnizationListResponse();
            // 标明客户是组织
            orgnizationListResponse.setPartyTypeCode(ORGNIZATION_CODE);

            // 获取证件信息
            if (!(orgnizationPrpQueryListObj.getPartyRegistration().isEmpty())) {
                // 获取证件名称
                orgnizationListResponse.setIdname(orgnizationPrpQueryListObj.getPartyRegistration().get(0).getIDName());
                // 获取证件号码
                orgnizationListResponse.setIdno(orgnizationPrpQueryListObj.getPartyRegistration().get(0).getIDNo());
                // 获取证件类型
                orgnizationListResponse
                        .setIdtypeCode(orgnizationPrpQueryListObj.getPartyRegistration().get(0).getIDTypeCode());
                // 获取客户id
                orgnizationListResponse
                        .setPartyId(orgnizationPrpQueryListObj.getPartyRegistration().get(0).getPartyId() == null ? ""
                                : orgnizationPrpQueryListObj.getPartyRegistration().get(0).getPartyId().toString());
            }

            // 获取客户状态
            if (!(orgnizationPrpQueryListObj.getCustLifeStatus().isEmpty())) {
                orgnizationListResponse
                        .setCustomerStatus(orgnizationPrpQueryListObj.getCustLifeStatus().get(0).getLifeStatusCode());
            }
            
            // 获取组织英文名
            if (!(orgnizationPrpQueryListObj.getPartyName().isEmpty())) {
                for (PartyName partyName : orgnizationPrpQueryListObj.getPartyName()) {
                    if (partyName.getNameTypeCode().equals(UNIT_ENAME)) {
                        orgnizationListResponse.setCustomerEName(partyName.getLastName());
                        break;
                    }
                }
            }
            
            // 获取联系人信息
            if (!(orgnizationPrpQueryListObj.getPartyLinkman().isEmpty())) {
                // 获取关联人名称
                orgnizationListResponse.setLinkerName(orgnizationPrpQueryListObj.getPartyLinkman().get(0).getName());
                // 获取关联人手机
                orgnizationListResponse.setLinkerMobile(orgnizationPrpQueryListObj.getPartyLinkman().get(0).getLinkmanMobile());
                // 获取关联人固话
                orgnizationListResponse.setLinkerPhoneNo(orgnizationPrpQueryListObj.getPartyLinkman().get(0).getLinkmanPhone());
                // 通讯地址
                orgnizationListResponse.setMailAddress(orgnizationPrpQueryListObj.getPartyLinkman().get(0).getAddress());
                // 邮政编码
                orgnizationListResponse.setMailAddressPost(orgnizationPrpQueryListObj.getPartyLinkman().get(0).getPostcode());
            }
            
            orgnizationListResponses.add(orgnizationListResponse);
        }
        return orgnizationListResponses;
    }
}
