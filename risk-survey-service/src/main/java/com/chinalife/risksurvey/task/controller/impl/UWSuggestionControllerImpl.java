package com.chinalife.risksurvey.task.controller.impl;

import java.util.Date;
import java.util.List;

import org.apache.commons.collections4.CollectionUtils;
import org.apache.cxf.common.util.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.chinalife.rbac.entity.RbacUserEO;
import com.chinalife.rbac.filter.service.ICurrentRbacUserService;
import com.chinalife.risksurvey.entity.UWSuggestionEO;
import com.chinalife.risksurvey.task.controller.IUWSuggestionController;
import com.chinalife.risksurvey.task.service.IUWSuggestionService;

/**
 * 包名称： com.chinalife.risksurvey.task.controller.impl
 * 类名称：UWSuggestionComtrollerImpl<br/>
 * 类描述：<br/>
 * 创建人：@author YQ<br/>
 * 创建时间：aug 9, 2018/10:33:38 AM<br/>
 */
@RestController("uwSuggestionController")
@RequestMapping("/controller/risksurvey/uwSuggestion")
public class UWSuggestionControllerImpl implements IUWSuggestionController {

    /**
     * 注入uWSuggestionService
     */
    @Autowired
    private IUWSuggestionService uwSuggestionService;

    /**
     * rbacUserService
     */
    @Autowired
    private ICurrentRbacUserService rbacUserService;

    @Override
    @RequestMapping(value = "/findUWSuggesTionBySurveyId", method = RequestMethod.GET, produces = "application/json;charset=utf-8")
    @ResponseBody
    public List<UWSuggestionEO> findUWSuggesTionByActualId(@RequestParam(value = "surveyId") Long surveyId) {

        return this.uwSuggestionService.findUWSuggestionBySurveyId(surveyId);
    }

    @Override
    @RequestMapping(value = "/saveSuggestEo", method = RequestMethod.POST, produces = "application/json;charset=utf-8")
    @ResponseBody
    public UWSuggestionEO saveUWSuggesTion(@RequestBody UWSuggestionEO suggesTionEO) {

        this.uwSuggestionService.saveUWSuggestion(suggesTionEO);
        return suggesTionEO;

    }

    /**
     * 修改意见往来
     */
    @Override
    @RequestMapping(value = "/updateUWSuggesEo", method = RequestMethod.POST, produces = "application/json;charset=utf-8")
    @ResponseBody
    public UWSuggestionEO updateUWSuggesTion(@RequestBody UWSuggestionEO suggesTionEO) {
        List<UWSuggestionEO> suggestionEOList = uwSuggestionService
                .findUWSuggestionBySurveyIdOrderbyOutFlowTime(suggesTionEO.getSurveyId());
        if (CollectionUtils.isNotEmpty(suggestionEOList) && suggestionEOList.size() >= 1) {
            boolean flg = true;
            UWSuggestionEO uwSuggestionEO = suggestionEOList.get(0);
            if (StringUtils.isEmpty(uwSuggestionEO.getUwLevel())) {
                suggesTionEO.setSuggesTionId(uwSuggestionEO.getSuggesTionId());
                Date nowDate = new Date();
                suggesTionEO.setSuggestType(UWSuggestionEO.SuggestionType.UwSubmit.toString());
                suggesTionEO.setInflowTime(nowDate);
                suggesTionEO.setOutflowTime(nowDate);
                RbacUserEO rbacUser = rbacUserService.findCurrentUser();
                suggesTionEO.setStructureCode(rbacUser.getOwnedStructureId());
                this.uwSuggestionService.updateUWSuggestion(suggesTionEO);
                flg = false;
            }

            if (flg) {
                suggesTionEO.setSuggesTionId(null);
                Date nowDate = new Date();
                suggesTionEO.setSuggestType(UWSuggestionEO.SuggestionType.UwSubmit.toString());
                suggesTionEO.setInflowTime(nowDate);
                suggesTionEO.setOutflowTime(nowDate);
                RbacUserEO rbacUser = rbacUserService.findCurrentUser();
                suggesTionEO.setStructureCode(rbacUser.getOwnedStructureId());
                this.uwSuggestionService.updateUWSuggestion(suggesTionEO);
            }
        } else {
            if (StringUtils.isEmpty(suggesTionEO.getUwLevel())) {
                Date nowDate = new Date();
                suggesTionEO.setSuggestType(UWSuggestionEO.SuggestionType.UwSubmit.toString());
                suggesTionEO.setInflowTime(nowDate);
                suggesTionEO.setOutflowTime(nowDate);
                RbacUserEO rbacUser = rbacUserService.findCurrentUser();
                suggesTionEO.setStructureCode(rbacUser.getOwnedStructureId());
            }
            this.uwSuggestionService.updateUWSuggestion(suggesTionEO);
        }

        return suggesTionEO;
    }
}
