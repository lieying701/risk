package com.chinalife.risksurvey.service.impl;

import com.chinalife.base.exception.StandardRuntimeException;
import com.chinalife.risksurvey.component.ISurveyMainComponent;
import com.chinalife.risksurvey.entity.SurveyBasicEO;
import com.chinalife.risksurvey.entity.SurveyCustomerEO;
import com.chinalife.risksurvey.entity.SurveyMainEO;
import com.chinalife.risksurvey.entity.SurveyRelBusinessEO;
import com.chinalife.risksurvey.service.ISurveyBasicService;
import com.chinalife.risksurvey.service.ISurveyCustomerService;
import com.chinalife.risksurvey.service.ISurveyMainInputService;
import com.chinalife.risksurvey.service.ISurveyRelBusinessService;
import com.chinalife.risksurvey.vo.OriginatingTaskCommitVo;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * wl 包名称： com.chinalife.risksurvey.service.impl 类名称：SurveyMainServiceImpl<br/>
 * 类描述：<br/>
 *
 * @version <br/>
 *          TODO
 */
@Service("surveyMainInputService")
public class SurveyMainInputServiceImpl implements ISurveyMainInputService {

    /**
     * surveyMainComponent
     */
    @Autowired
    private ISurveyMainComponent surveyMainComponent;
    /**
     * surveyCustomerService
     */
    @Autowired
    private ISurveyCustomerService surveyCustomerService;
    /**
     * surveyRelBusinessService
     */
    @Autowired
    private ISurveyRelBusinessService surveyRelBusinessService;
    /**
     * surveyBasicService
     */
    @Autowired
    private ISurveyBasicService surveyBasicService;
    /**
     * LOGGER
     */
    private static final Logger LOGGER = LoggerFactory.getLogger(SurveyMainInputServiceImpl.class);

    @Override
    public Object originatingTaskCommit(OriginatingTaskCommitVo commitVo) {
        String customer = "";
        String main = "";
        String business = "";
        String basic = "";
        Map<String, Object> commitMap = new HashMap<String, Object>();
        try {
            if (commitVo != null && !"".equals(commitVo)) {
                if (commitVo.getSurveyMain() != null) {
                    SurveyMainEO surveyMainEO = commitVo.getSurveyMain();
                    main = surveyMainComponent.updateSurveyMain(surveyMainEO).toString();
                }
                List<SurveyCustomerEO> list = commitVo.getSurveyCustomer();
                if (list != null && list.size() > 0) {
                    for (SurveyCustomerEO customerList : list) {
                        customer = surveyCustomerService.updateSurveyCustomer(customerList).toString();
                    }
                }
                BigDecimal surveyTime = commitVo.getSurveyMain().getSurveyTimes();
                SurveyRelBusinessEO surveyRelBusinessEO = commitVo.getSurveyRelBusiness();
                if (surveyTime != null) {
                    surveyRelBusinessEO.setSurveyTimes(surveyTime);
                }
                if (surveyRelBusinessEO != null) {
                    business = surveyRelBusinessService.insertOrUpdateSurveyRelBusiness(surveyRelBusinessEO).toString();
                }
                if (commitVo.getSurveyBasic() != null) {
                    SurveyBasicEO surveyBasicEO = commitVo.getSurveyBasic();
                    surveyBasicEO.setSurveyId(commitVo.getSurveyId());
                    surveyBasicEO.setRptId(commitVo.getSurveyMain().getPkId());
                    basic = surveyBasicService.insertOrUpdateSurveyBasic(surveyBasicEO).toString();
                }

                if (main != null && customer != null && business != null && basic != null) {
                    commitMap.put("status", "success");
                    commitMap.put("message", "提交成功");
                    LOGGER.info("commitMap:" + commitMap);
                } else {
                    commitMap.put("status", "false");
                    commitMap.put("message", "提交失败");
                    LOGGER.info("commitMap:" + commitMap);
                }
            } else {
                return null;
            }
        } catch (Exception e) {
            LOGGER.error("参数有误");
            throw new StandardRuntimeException("参数有误!", e);
        }

        return commitMap;
    }

    @Override
    public Map<String,Object> getWindReport(Map<String, Object> parameter) {
        
        return surveyMainComponent.getWindReport(parameter);
    }
}
