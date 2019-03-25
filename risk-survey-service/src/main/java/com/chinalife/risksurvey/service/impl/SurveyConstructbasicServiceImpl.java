package com.chinalife.risksurvey.service.impl;

import java.util.HashMap;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.chinalife.base.exception.StandardRuntimeException;
import com.chinalife.risksurvey.component.ISurveyConstructbasicComponent;
import com.chinalife.risksurvey.entity.SurveyConstructbasicEO;
import com.chinalife.risksurvey.entity.SurveyConstructpartyEO;
import com.chinalife.risksurvey.entity.SurveyGeologyEO;
import com.chinalife.risksurvey.entity.SurveyWorksiteEO;
import com.chinalife.risksurvey.service.ISurveyConstructbasicService;
import com.chinalife.risksurvey.service.ISurveyConstructpartyService;
import com.chinalife.risksurvey.service.ISurveyGeologyService;
import com.chinalife.risksurvey.service.ISurveyWorksiteService;
import com.chinalife.risksurvey.vo.RiskSurveyContentVo;

/**
 * 风勘录入2
 */
@Service("surveyConstructbasicService")
public class SurveyConstructbasicServiceImpl implements ISurveyConstructbasicService {

    /**
     * surveyConstructbasicService
     */
    @Autowired
    private ISurveyConstructbasicComponent surveyConstructbasicComponent;
    /**
     * surveyConstructpartyService
     */
    @Autowired
    private ISurveyConstructpartyService surveyConstructpartyService;
    /**
     * surveyGeologyService
     */
    @Autowired
    private ISurveyGeologyService surveyGeologyService;
    /**
     * surveyWorksiteService
     */
    @Autowired
    private ISurveyWorksiteService surveyWorksiteService;

    /**
     * LOGGER
     */
    private static final Logger LOGGER = LoggerFactory.getLogger(SurveyMainServiceImpl.class);

    @Override
    public Object windProspectingInput(RiskSurveyContentVo riskSurveyContentVo) {
        Map<String, Object> commitMap = new HashMap<String, Object>();
        String basic = "";
        String party = "";
        String geology = "";
        String worksite = "";
        try {
            if (riskSurveyContentVo != null && !"".equals(riskSurveyContentVo)) {
                if (riskSurveyContentVo.getSurveyConstructbasic() != null) {
                    SurveyConstructbasicEO surveyConstructbasicEO = riskSurveyContentVo.getSurveyConstructbasic();
                    surveyConstructbasicEO.setRptId(riskSurveyContentVo.getSurveyMainId());
                    basic = surveyConstructbasicComponent.insertOrUpdateSurveyConstructbasic(surveyConstructbasicEO).toString();
                }
                if (riskSurveyContentVo.getSurveyConstructparty() != null) {
                    SurveyConstructpartyEO surveyConstructparty = riskSurveyContentVo.getSurveyConstructparty();
                    surveyConstructparty.setRptId(riskSurveyContentVo.getSurveyMainId());
                    party = surveyConstructpartyService.insertOrUpdateSurveyConstructparty(surveyConstructparty).toString();
                }
                if (riskSurveyContentVo.getSurveyGeology() != null) {
                    SurveyGeologyEO surveyGeology = riskSurveyContentVo.getSurveyGeology();
                    surveyGeology.setRptId(riskSurveyContentVo.getSurveyMainId());
                    geology = surveyGeologyService.insertOrUpdateSurveyGeology(surveyGeology).toString();
                }
                if (riskSurveyContentVo.getSurveyWorksite() != null) {
                    SurveyWorksiteEO surveyWorksite = riskSurveyContentVo.getSurveyWorksite();
                    surveyWorksite.setRptId(riskSurveyContentVo.getSurveyMainId());
                    worksite = surveyWorksiteService.insertOrUpdateSurveyWorksite(surveyWorksite).toString();
                }
                
                if (basic != null && party != null && geology != null  && worksite != null) {
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

}
