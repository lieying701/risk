package com.chinalife.risksurvey.ecifclient.service.impl;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.chinalife.base.exception.StandardRuntimeException;
import com.chinalife.basecode.service.ICodeDetailService;
import com.chinalife.integration.ecif.webservice.PartyIdObj;
import com.chinalife.integration.ecif.webservice.PartyRegistrationKeyInfo;
import com.chinalife.integration.ecif.webservice.Telephone;
import com.chinalife.integration.payment.dto.accountinfomaintenancennuclearbean.AccountInfoVO;
import com.chinalife.integration.payment.dto.accountinfomaintenancennuclearbean.AccountModifyRequestVO;
import com.chinalife.integration.payment.dto.accountinfomaintenancennuclearbean.AccountModifyResponseVO;
import com.chinalife.integration.payment.service.INewPaymentService;
import com.chinalife.risksurvey.ecifclient.component.IECIFClientComponet;
import com.chinalife.risksurvey.ecifclient.component.impl.ECIFClientComponentImpl;
import com.chinalife.risksurvey.ecifclient.service.IECIFClientService;
import com.chinalife.risksurvey.ecifclient.vo.GetCustomeResponseBody;

/**
 * ecif 客户请求
 * 包名称： com.chinalife.risksurvey.ecifclient.service.impl 
 * 类名称：ECIFClientServiceImpl<br/>    
 * 类描述：<br/>  
 * @version <br/>   
 */
@RestController("ecifClientService")
@RequestMapping("/service/risksurvey/ecifClient")
public class ECIFClientServiceImpl implements IECIFClientService {
    /**
     * The Logger.
     */
    protected Logger logger = LoggerFactory.getLogger(this.getClass());

    /**
     * ecif父类component层注入
     */
    @Autowired
    @Qualifier("ecifClientComponent")
    private IECIFClientComponet ecifClientComponet;

    /**
     * ecif个人component层
     */
    @Autowired
    @Qualifier("ecifIndividualComponent")
    private IECIFClientComponet ecifIndividual;

    /**
     * ecif组织component层
     */
    @Autowired
    @Qualifier("ecifOrgnizationComponent")
    private IECIFClientComponet ecifOrgnization;
    /** 注入service */
    @Autowired
    private INewPaymentService paymentNewNuclearService;

    /**
     * 注入service
     */
    @Autowired
    private ICodeDetailService codeDetailService;
    
    @Override
    public GetCustomeResponseBody getCustomer(String sysId, String interruptFlag, String customerType,
            PartyIdObj partyIdObj, PartyRegistrationKeyInfo partyRegistrationKeyInfo, Telephone telephone) {
        logger.info("ECIFClientServiceImpl.getCustomer start");
        long start = System.currentTimeMillis();
        GetCustomeResponseBody response = null;
        AccountModifyRequestVO accountModifyRequestVO = new AccountModifyRequestVO();
        AccountInfoVO accountInfoVO = new AccountInfoVO();
        ArrayList<AccountInfoVO> accountInfoList = new ArrayList<AccountInfoVO>();
        String requestType = "0";
        Map placeHolderMap = new HashMap();
        if (customerType.equals(ECIFClientComponentImpl.INDIVIDUAL_CODE)) { // 个人客户请求
            response = ecifIndividual.getCustomer(sysId, interruptFlag, customerType, partyIdObj,
                    partyRegistrationKeyInfo, telephone);
            logger.info("ECIFClientServiceImpl.getCustomer 请求ecif接口耗时：{} ms", (System.currentTimeMillis() - start));
            long startCountry = System.currentTimeMillis();
            // 国籍code
            String countryCode = null;
            // 职业code
            String occupationCode = null;
            if (response != null && response.getIndividualResponse() != null) {
                countryCode = response.getIndividualResponse().getCountryCode();
            }
            if (response != null && response.getIndividualResponse() != null) {
                occupationCode = response.getIndividualResponse().getOccupationCode();
            }
            String country = null;
            String occupation = null;
            // 国籍
            if (countryCode != null && !"".equals(countryCode)) {
                Map<String, List<Map<String, String>>> findCachedPairs = codeDetailService.findCachedPairMap("Native", placeHolderMap);
                List<Map<String, String>> list = findCachedPairs.get("Native");
                for (int i = 0; i < list.size(); i++) {
                    Map<String, String> map = list.get(i);
                    String authorStr = String.valueOf(map.get("key"));
                    if (authorStr.equals(countryCode)) {
                        country = String.valueOf(map.get("value"));
                        response.getIndividualResponse().setCitizenshipName(country);
                        break;
                    }
                }
            }
            logger.info("ECIFClientServiceImpl.getCustomer 翻译国籍耗时：{} ms", (System.currentTimeMillis() - startCountry));
            long startOccupation = System.currentTimeMillis();
            // 职业
            if (occupationCode != null && !"".equals(occupationCode)) {
                Map<String, List<Map<String, String>>> findCachedPairs2 = codeDetailService.findCachedPairMap("OccupationCategoryECIF", placeHolderMap);
                List<Map<String, String>> list2 = findCachedPairs2.get("OccupationCategoryECIF");
                for (int i = 0; i < list2.size(); i++) {
                    Map<String, String> map = list2.get(i);
                    String authorStr = String.valueOf(map.get("key"));
                    if (authorStr.equals(occupationCode)) {
                        occupation = String.valueOf(map.get("value"));
                        response.getIndividualResponse().setOccupationCodeName(occupation);
                        break;
                    }
                }
            }
            logger.info("ECIFClientServiceImpl.getCustomer 翻译职业耗时：{} ms", (System.currentTimeMillis() - startOccupation));
            if (!StringUtils.equals(response.getIfMulti(), "1")
                    && StringUtils.equals(response.getResponseCode(), "1")) {
                if (response.getIndividualResponse() != null) {
                    if (response.getIndividualResponse().getAutoRiskLevelCode().equalsIgnoreCase("4")
                            || response.getIndividualResponse().getManualRiskLevelCode().equalsIgnoreCase("4")) {
                        throw new StandardRuntimeException("客户风险等级为禁止，不能承保", "客户风险等级为禁止，不能承保");
                    }
                }
            }
        } else if (customerType.equals(ECIFClientComponentImpl.ORGNIZATION_CODE)) { // 组织客户请求
            response = ecifOrgnization.getCustomer(sysId, interruptFlag, customerType, partyIdObj,
                    partyRegistrationKeyInfo, telephone);

            // 注册所在地Code
            String countryCode = null;
            try {
                countryCode = response.getOrgnizationResponse().getRegisteredPlaceCode();
            } catch (Exception e) {
                e.printStackTrace();
            }
            String country = null;
            // 注册所在地
            if (countryCode != null && !"".equals(countryCode)) {
                Map<String, List<Map<String, String>>> findCachedPairs = codeDetailService.findCachedPairMap("Native",placeHolderMap);
                List<Map<String, String>> list = findCachedPairs.get("Native");
                for (int i = 0; i < list.size(); i++) {
                    Map<String, String> map = list.get(i);
                    String authorStr = String.valueOf(map.get("key"));
                    if (authorStr.equals(countryCode)) {
                        country = String.valueOf(map.get("value"));
                        response.getOrgnizationResponse().setRegisteredPlaceName(country);
                        break;
                    }
                }
            }

            if (!StringUtils.equals(response.getIfMulti(), "1")
                    && StringUtils.equals(response.getResponseCode(), "1")) {
                if (response.getOrgnizationResponse() != null) {
                    if (response.getOrgnizationResponse().getAutoRiskLevelCode().equalsIgnoreCase("4")
                            || response.getOrgnizationResponse().getManualRiskLevelCode().equalsIgnoreCase("4")) {
                        throw new StandardRuntimeException("客户风险等级为禁止，registeredPlaceCode  不能承保", "客户风险等级为禁止，不能承保");
                    }
                }
            }
        } else {
            throw new StandardRuntimeException(this.getClass().getSimpleName(), "客户类型有误");
        }
        long startAccountInfo = System.currentTimeMillis();
        if (response.getIndividualResponse() != null && !"".equals(response.getIndividualResponse())
                || response.getOrgnizationResponse() != null && !"".equals(response.getOrgnizationResponse())) {
            String customerCode = response.getIndividualResponse() == null
                    ? response.getOrgnizationResponse().getCustomerCode()
                    : response.getIndividualResponse().getCustomerCode();
            if (customerCode != null && !"".equals(customerCode)) {
                accountInfoVO.setCustomerCode(customerCode);
                accountInfoList.add(accountInfoVO);
                accountModifyRequestVO.setRequestType(requestType);
                accountModifyRequestVO.setAccountInfoList(accountInfoList);
                try {
                    AccountModifyResponseVO accountInfoQueryAndUpdate = paymentNewNuclearService
                            .accountInfoQueryAndUpdate(accountModifyRequestVO);
                    if (accountInfoQueryAndUpdate != null && accountInfoQueryAndUpdate.getAccountInfoList() != null
                            && accountInfoQueryAndUpdate.getAccountInfoList().size() > 0) {
                        accountInfoVO = accountInfoQueryAndUpdate.getAccountInfoList().get(0);
                    }
                    response.setAccountInfoVO(accountInfoVO);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        }
        logger.info("ECIFClientServiceImpl.getCustomer 账户基础信息查询耗时：{} ms", (System.currentTimeMillis() - startAccountInfo));
        logger.info("ECIFClientServiceImpl.getCustomer end ---> 总耗时：{} ms", (System.currentTimeMillis() - start));
        return response;
    }

}
