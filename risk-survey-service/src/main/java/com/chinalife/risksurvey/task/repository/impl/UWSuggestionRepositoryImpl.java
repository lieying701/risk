package com.chinalife.risksurvey.task.repository.impl;

import java.util.Date;
import java.util.List;

import org.apache.commons.lang.StringUtils;
import org.springframework.stereotype.Repository;

import com.chinalife.base.repository.impl.GPBaseRepositoryImpl;
import com.chinalife.base.util.ObjectUtils;
import com.chinalife.risksurvey.entity.UWSuggestionEO;
import com.chinalife.risksurvey.task.repository.IUWSuggestionRepository;

/**
 * 包名称： com.chinalife.risksurvey.task.repository.impl
 * 类名称：UWSuggestionRepositoryImpl<br/>
 * 类描述：<br/>
 * 创建人：@author YQ<br/>
 * 创建时间：aug 9, 2018/10:33:38 AM<br/>
 */
@Repository("uwSuggestionRepository")
public class UWSuggestionRepositoryImpl extends GPBaseRepositoryImpl<UWSuggestionEO>
        implements IUWSuggestionRepository {

    /**
     * 根据实体id查询
     * 
     * @param surveyId
     *            参数
     * @return List
     */
    @Override
    public List<UWSuggestionEO> findUWSuggestionBySurveyId(Long surveyId) {
        List<UWSuggestionEO> list = this.listByCondition("surveyId=?", ObjectUtils.asArray(surveyId),
                "createDate desc,uwLevel desc ");
        return list.size() > 0 ? list : null;
    }

    /**
     * 新增保存
     * 
     * @param suggesTionEO
     *            实体
     */
    @Override
    public void saveUWSuggestion(UWSuggestionEO suggesTionEO) {
        String suggestComment = StringUtils.trimToEmpty(suggesTionEO.getSuggestComment());
        if (!"".equalsIgnoreCase(suggestComment)) {
            suggesTionEO.setSuggestComment(suggestComment);
        }
        this.insert(suggesTionEO);
    }

    /**
     * 查询所有再保沟通历史
     */
    @Override
    public List<UWSuggestionEO> findBySurveyIdAndType(Long surveyId, String type) {
        return this.listByCondition(" surveyId=? and suggestType=? ", ObjectUtils.asArray(surveyId, type));
    }

    /**
     * 修改意见往来
     */
    @Override
    public void updateUWSuggestion(UWSuggestionEO suggesTionEO) {
        String suggestComment = StringUtils.trimToEmpty(suggesTionEO.getSuggestComment());
        String suggesTionId = suggesTionEO.getSuggesTionId();
        if (!"".equalsIgnoreCase(suggestComment)) {
            suggesTionEO.setSuggestComment(suggestComment);
        }
        if (suggesTionId != null) {
            suggesTionEO.setCreateDate(new Date());
            this.update(suggesTionEO);
        } else {
            suggesTionEO.setCreateDate(new Date());
            this.insert(suggesTionEO);
        }
    }

    /**
     * 根据实体id查询 order by outflowtime
     *
     * @param surveyId
     *            参数
     * @return List
     */
    @Override
    public List<UWSuggestionEO> findUWSuggestionBySurveyIdOrderbyOutFlowTime(Long surveyId) {
        List<UWSuggestionEO> list = this.listByCondition("surveyId=?", ObjectUtils.asArray(surveyId),
                "outflowtime desc");
        return list.size() > 0 ? list : null;
    }

}
