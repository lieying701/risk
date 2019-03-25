package com.chinalife.risksurvey.repository.impl;

import org.springframework.stereotype.Repository;

import com.chinalife.base.repository.impl.GPBaseRepositoryImpl;
import com.chinalife.risksurvey.entity.SurveyRoadEO;
import com.chinalife.risksurvey.repository.ISurveyRoadRepository;

/**
 * 道路施工风险 SurveyRoadEO
 */
@Repository("surveyRoadRepository")
public class SurveyRoadRepositoryImpl extends GPBaseRepositoryImpl<SurveyRoadEO> implements ISurveyRoadRepository {

}
