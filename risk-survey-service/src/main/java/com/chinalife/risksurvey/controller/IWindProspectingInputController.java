package com.chinalife.risksurvey.controller;

import java.util.Map;

import com.chinalife.risksurvey.vo.WindProspectingInputVo;

/**
 * 风勘录入
 * 包名称： com.chinalife.risksurvey.controller 
 */
public interface IWindProspectingInputController {
    
    /**
     * 
     * @param windProspectingInputVo windProspectingInputVo
     * @return Object
     */
    Object windProspectingInput(WindProspectingInputVo windProspectingInputVo);
    
    /**
     * 
     * @param parameter parameter
     * @return map
     */
    Map<String,Object> getWindReport(Map<String, Object> parameter);

}
