package com.chinalife.risksurvey.service.impl;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.chinalife.base.exception.StandardRuntimeException;
import com.chinalife.risksurvey.component.ISurveyBasicComponent;
import com.chinalife.risksurvey.entity.SurveyBasicEO;
import com.chinalife.risksurvey.entity.SurveyBuildconstructEO;
import com.chinalife.risksurvey.entity.SurveyItemlistEO;
import com.chinalife.risksurvey.entity.SurveyThirddutyEO;
import com.chinalife.risksurvey.service.ISurveyBasicService;
import com.chinalife.risksurvey.service.ISurveyBuildconstructService;
import com.chinalife.risksurvey.service.ISurveyItemlistService;
import com.chinalife.risksurvey.service.ISurveyThirddutyService;
import com.chinalife.risksurvey.vo.RiskSurveyVo;

/**
 * 风勘录入 {@link RiskSurveyVo}
 */
@Service("surveyBasicService")
public class SurveyBasicServiceImpl implements ISurveyBasicService {

    /**
     * surveyBasicComponent
     */
    @Autowired
    private ISurveyBasicComponent surveyBasicComponent;

    /**
     * surveyBuildconstructService
     */
    @Autowired
    private ISurveyBuildconstructService surveyBuildconstructService;

    /**
     * surveyThirddutyService
     */
    @Autowired
    private ISurveyThirddutyService surveyThirddutyService;
    
    /**
     * surveyItemlistService
     */
    @Autowired
    private ISurveyItemlistService surveyItemlistService;
    
    /**
     * LOGGER
     */
    private static final Logger LOGGER = LoggerFactory.getLogger(SurveyBasicServiceImpl.class);

    @Override
    public Object riskSurvey(RiskSurveyVo riskSurveyVo) {
        Map<String, Object> commitMap = new HashMap<String, Object>();
        String surveyBasic = "";
        String surveyBuildconstruct = "";
        String surveyThirdduty = "";
        String surveyItemlist = "";
        try {
            if (riskSurveyVo != null && !"".equals(riskSurveyVo)) {
                if (riskSurveyVo.getSurveyBasic() != null) {
                    SurveyBasicEO basic = riskSurveyVo.getSurveyBasic();
                    basic.setRptId(riskSurveyVo.getSurveyMainId());
                    surveyBasic = surveyBasicComponent.insertOrUpdateSurveyBasic(basic).toString();
                }
                List<SurveyBuildconstructEO> buildconstruct = riskSurveyVo.getSurveyBuildconstruct();
                List<SurveyBuildconstructEO> construct = new ArrayList<SurveyBuildconstructEO>();
                if (buildconstruct != null && buildconstruct.size() > 0) {
                    for (SurveyBuildconstructEO surveyBuildconstructEO : buildconstruct) {
                        surveyBuildconstructEO.setRptId(riskSurveyVo.getSurveyMainId());
                        construct.add(surveyBuildconstructEO);
                    }
                    surveyBuildconstruct = surveyBuildconstructService.insertOrUpdateSurveyBuildconstruct(construct).toString();
                }
                List<SurveyThirddutyEO> thirdduty = riskSurveyVo.getSurveyThirdduty();
                List<SurveyThirddutyEO> surveyThir = new ArrayList<SurveyThirddutyEO>();
                if (thirdduty != null && thirdduty.size() > 0) {
                    for (SurveyThirddutyEO surveyThirddutyEO : thirdduty) {
                        surveyThirddutyEO.setRptId(riskSurveyVo.getSurveyMainId());
                        surveyThir.add(surveyThirddutyEO);
                    }
                    surveyThirdduty = surveyThirddutyService.insertOrUpdateSurveyThirdduty(surveyThir).toString();
                }
                if (riskSurveyVo.getSurveyItemlist() != null) {
                    SurveyItemlistEO surveyItemlistEO = riskSurveyVo.getSurveyItemlist();
                    surveyItemlistEO.setSurveyId(riskSurveyVo.getSurveyId());
                    if (surveyItemlistEO.getPkId() == null) {
                        surveyItemlist = surveyItemlistService.insertSurveyItemlist(surveyItemlistEO).toString();
                    } else {
                        surveyItemlist = surveyItemlistService.updateSurveyItemlist(surveyItemlistEO).toString();
                    }
                }
                
                if (surveyBasic != null && surveyBuildconstruct != null && surveyThirdduty != null && surveyItemlist != null) {
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
    public Object insertOrUpdateSurveyBasic(SurveyBasicEO surveyBasicEO) {
        return surveyBasicComponent.insertOrUpdateSurveyBasic(surveyBasicEO);
    }

}
