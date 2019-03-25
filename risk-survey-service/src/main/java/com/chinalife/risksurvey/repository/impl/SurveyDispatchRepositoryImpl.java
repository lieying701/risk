package com.chinalife.risksurvey.repository.impl;

import org.springframework.stereotype.Repository;


import com.chinalife.base.repository.impl.GPBaseRepositoryImpl;
import com.chinalife.base.util.ObjectUtils;
import com.chinalife.risksurvey.entity.SurveyDispatchEO;
import com.chinalife.risksurvey.repository.ISurveyDispatchRepository;

/**   
 * 包名称： com.chinalife.risksurvey.repository.impl 
 * 类名称：SurveyDispatchRepositoryImpl<br/>    
 * 类描述：<br/>  
 * @version <br/>   
 *     
 */  
@Repository("surveyDispatchRepository")
public class SurveyDispatchRepositoryImpl  extends GPBaseRepositoryImpl<SurveyDispatchEO> implements ISurveyDispatchRepository {

    @Override
    public SurveyDispatchEO findBySurveyId(String surveyId) {
        return this.findByCondition("surveyId=?", ObjectUtils.asArray(surveyId), null);
        //以后加 newFlag =1 
    }

    @Override
    public void insertSurveyDispatchEO(SurveyDispatchEO surveyDispatchEO) {
        this.insert(surveyDispatchEO);

    }

    @Override
    public void updateSurveyDispatchEO(SurveyDispatchEO surveyDispatchEO) {
        this.update(surveyDispatchEO);
    }

}
