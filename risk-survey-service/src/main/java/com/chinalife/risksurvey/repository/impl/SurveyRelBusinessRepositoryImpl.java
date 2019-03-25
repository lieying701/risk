package com.chinalife.risksurvey.repository.impl;

import org.springframework.stereotype.Repository;

import com.chinalife.base.repository.impl.GPBaseRepositoryImpl;
import com.chinalife.base.util.ObjectUtils;
import com.chinalife.risksurvey.entity.SurveyRelBusinessEO;
import com.chinalife.risksurvey.repository.ISurveyRelBusinessRepository;

/**
 * SurveyRelBusinessEO
 * 关联业务表
 */
@Repository("surveyRelBusinessRepository")
public class SurveyRelBusinessRepositoryImpl extends GPBaseRepositoryImpl<SurveyRelBusinessEO> 
            implements ISurveyRelBusinessRepository {

    @Override
    public void insertSurveyRelBusiness(SurveyRelBusinessEO surveyRelBusinessEO) {
        
        this.insert(surveyRelBusinessEO);

    }

    @Override
    public SurveyRelBusinessEO findLastSurveyRelBusinessEOBySurveyId(String surveyId) {
        // TODO Auto-generated method stub
        return this.findByCondition("surveyId=? and validflag = ? ", ObjectUtils.asArray(surveyId,"1"), "");
    }

    @Override
    public SurveyRelBusinessEO findSurveyIdExist(String businessNo) {
        // TODO Auto-generated method stub
        return this.findByCondition("businessNo=? and validflag = ? ", ObjectUtils.asArray(businessNo,"1"), "");
    }

}
