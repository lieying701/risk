package com.chinalife.risksurvey.task.component.impl;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import org.apache.commons.collections4.CollectionUtils;
import org.apache.commons.lang.StringUtils;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.chinalife.base.component.impl.BaseComponentImpl;
import com.chinalife.rbac.entity.RbacUserEO;
import com.chinalife.rbac.filter.service.ICurrentRbacUserService;
import com.chinalife.risksurvey.entity.UWSuggestionEO;
import com.chinalife.risksurvey.task.component.IUWSuggestionComponent;
import com.chinalife.risksurvey.task.repository.IUWSuggestionRepository;

/**
 * 包名称： com.chinalife.risksurvey.task.component.impl
 * 类名称：UwSuggestionComponentImpl<br/>
 * 类描述：<br/>
 * 创建人：@author YQ<br/>
 * 创建时间：aug 9, 2018/10:33:38 AM<br/>
 */
@Component("uwSuggestionComponent")
public class UWSuggestionComponentImpl extends BaseComponentImpl<UWSuggestionEO, IUWSuggestionRepository>
        implements IUWSuggestionComponent {

    /**
     * 注入登录机构服务
     */
    @Autowired
    private ICurrentRbacUserService rbacUserService;

    /**
     * 根据实体id查询
     *
     * @param surveyId
     *            参数
     *
     * @return List
     */
    public List<UWSuggestionEO> findUWSuggestionBySurveyId(Long surveyId) {
        List<UWSuggestionEO> list = this.getBaseRepository().findUWSuggestionBySurveyId(surveyId);
        if (CollectionUtils.isNotEmpty(list)) {
            Map<String, List<UWSuggestionEO>> suggestionEOMap = new HashMap();
            for (UWSuggestionEO uw : list) {
                List<UWSuggestionEO> existSuggestionList = suggestionEOMap.get(uw.getSuggesTionId());
                if (CollectionUtils.isEmpty(existSuggestionList)) {
                    existSuggestionList = new ArrayList<>();
                }
                existSuggestionList.add(uw);
                suggestionEOMap.put(uw.getSuggesTionId(), existSuggestionList);
            }
            list = new ArrayList<>();
            Iterator<Map.Entry<String, List<UWSuggestionEO>>> iterator = suggestionEOMap.entrySet().iterator();
            while (iterator.hasNext()) {
                Map.Entry<String, List<UWSuggestionEO>> entry = iterator.next();
                List<UWSuggestionEO> value = entry.getValue();
                if (value != null && value.size() > 0) {
                    for (int i = 0; i < value.size(); i++) {
                        Long lineNo = value.get(i).getLineNo();
                        if (lineNo == null) {
                            value.get(i).setLineNo(1L);
                        } else {
                            continue;
                        }
                    }
                }
                Collections.sort(entry.getValue(), Comparator.comparing(UWSuggestionEO::getLineNo));
                UWSuggestionEO firstUwSuggestionEO = entry.getValue().get(0);
                StringBuilder suggestionSb = new StringBuilder();
                entry.getValue().forEach(uwSuggestionEO -> suggestionSb.append(uwSuggestionEO.getSuggestComment()));
                firstUwSuggestionEO.setSuggestComment(suggestionSb.toString());
                list.add(firstUwSuggestionEO);
            }
            Collections.sort(list, Comparator.comparing(UWSuggestionEO::getCreateDate));
        }

        return list;
    }

    @Override
    public void saveUWSuggestion(UWSuggestionEO suggesTionEO) {
        String leftSuggestionComment = suggesTionEO.getSuggestComment();
        Long lineNo = 1L;
        List<UWSuggestionEO> uwSuggestionEOList = new ArrayList<>();

        while (StringUtils.isNotEmpty(leftSuggestionComment)) {
            String currentSuggestion = leftSuggestionComment.length() > 1333 ? leftSuggestionComment.substring(0, 1333)
                    : leftSuggestionComment;
            leftSuggestionComment = leftSuggestionComment.length() > 1333 ? leftSuggestionComment.substring(1333)
                    : null;
            UWSuggestionEO oneSuggestionEO = new UWSuggestionEO();
            BeanUtils.copyProperties(suggesTionEO, oneSuggestionEO);
            oneSuggestionEO.setSuggestComment(currentSuggestion);
            oneSuggestionEO.setLineNo(lineNo);
            uwSuggestionEOList.add(oneSuggestionEO);
            lineNo++;
        }
        this.insertAll(uwSuggestionEOList);
    }

    /**
     * 查询所有再保沟通历史
     */
    @Override
    public List<UWSuggestionEO> findBySurveyIdAndType(Long surveyId, String type) {
        return this.getBaseRepository().findBySurveyIdAndType(surveyId, type);
    }

    /**
     * 修改意见往来
     */
    @Override
    public void updateUWSuggestion(UWSuggestionEO suggesTionEO) {
        RbacUserEO user = rbacUserService.findCurrentUser();
        if (user != null) {
            String ownedStructureName = user.getOwnedStructureName();
            String name = user.getName();
            suggesTionEO.setCreatorName(name);
            suggesTionEO.setDepartName(ownedStructureName);

        }
        this.getBaseRepository().updateUWSuggestion(suggesTionEO);
    }

    /**
     * 根据实体id查询 order by outflowtime
     *
     * @param surveyId
     *            参数
     *
     * @return List
     */
    @Override
    public List<UWSuggestionEO> findUWSuggestionBySurveyIdOrderbyOutFlowTime(Long surveyId) {
        return this.getBaseRepository().findUWSuggestionBySurveyIdOrderbyOutFlowTime(surveyId);
    }

}
