package com.chinalife.risksurvey.repository.impl;

import org.springframework.stereotype.Repository;

import com.chinalife.base.repository.impl.GPBaseRepositoryImpl;
import com.chinalife.risksurvey.entity.SurveySecurityEO;
import com.chinalife.risksurvey.repository.ISurveySecurityRepository;

/**
 * 保安状况 SurveySecurityEO
 */
@Repository("surveySecurityRepository")
public class SurveySecurityRepositoryImpl extends GPBaseRepositoryImpl<SurveySecurityEO>
        implements ISurveySecurityRepository {

}
