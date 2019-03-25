package com.chinalife.risksurvey.component.impl;

import com.chinalife.base.component.impl.BaseComponentImpl;
import com.chinalife.risksurvey.component.ISurveyMainComponent;
import com.chinalife.risksurvey.entity.SurveyItemlistEO;
import com.chinalife.risksurvey.entity.SurveyMainEO;
import com.chinalife.risksurvey.repository.ISurveyMainRepository;
import com.chinalife.risksurvey.vo.OriginatingTaskCommitVo;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * surveyMainComponent
 * 风勘信息
 */
@Component("surveyMainComponent")
public class SurveyMainComponentImpl extends BaseComponentImpl<SurveyMainEO, ISurveyMainRepository> implements ISurveyMainComponent {

    /**
     * surveyMainRepository
     */
    @Autowired
    private ISurveyMainRepository surveyMainRepository;

    /**
     * LOGGER
     */
    private static final Logger LOGGER = LoggerFactory.getLogger(SurveyMainComponentImpl.class);

    @Override
    public Object insertSurveyMain(SurveyMainEO surveyMainEO) {
        return surveyMainRepository.insert(surveyMainEO);
    }
    
    @Override
    public Object updateSurveyMain(SurveyMainEO surveyMainEO) {
        surveyMainRepository.update(surveyMainEO);
        
        return "main";
    }

    /**
     * 通过风勘任务号查询
     *
     * @param surveyId surveyId
     * @return SurveyMainEO
     */
    @Override
    public SurveyMainEO getSurveyMainBySurveyId(String surveyId) {
        return surveyMainRepository.getSurveyMainBySurveyId(surveyId);
    }

    @SuppressWarnings({ "unchecked", "rawtypes" })
    @Override
    public Map<String,Object> getWindReport(Map<String, Object> parameter) {
        String param = parameter.get("status").toString();
        Map<String,Object> map = new HashMap<String,Object>();
        List<Object> item = null;
        OriginatingTaskCommitVo main = (OriginatingTaskCommitVo)surveyMainRepository.getWindReport(parameter);
        if ("6".equals(param)) {
            item = (List<Object>)surveyMainRepository.getItemlist(parameter);
        }
        //List<Object> pkid = (List<Object>)surveyMainRepository.getPkId(parameter);
        SurveyItemlistEO modelUrl = (SurveyItemlistEO)surveyMainRepository.getModelUrl(parameter);
        if (param != null && !"".equals(param)) {
            //if (param.equals(SurveyStatusEnums.MODIFY.getCode())) {
            if (main != null) {
                map.put("main", main);
                map.put("item", item);
                map.put("modelUrl", modelUrl);
            } else {
                map.put("main", main);
                map.put("modelUrl", modelUrl);
            }
        }
        
        return map;
    }

    @Override
    public Map<String, Object> getCommitVoToAdd(String surveyId) {
        
        return surveyMainRepository.getCommitVoToAdd(surveyId);
    }
    
    @Override
    public String getPkidBySurveyId(String surveyId) {
        
        return surveyMainRepository.getPkidBySurveyId(surveyId);
    }

}
