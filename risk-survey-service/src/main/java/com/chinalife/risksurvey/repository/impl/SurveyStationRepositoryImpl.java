package com.chinalife.risksurvey.repository.impl;

import org.springframework.stereotype.Repository;

import com.chinalife.base.repository.impl.GPBaseRepositoryImpl;
import com.chinalife.risksurvey.entity.SurveyStationEO;
import com.chinalife.risksurvey.repository.ISurveyStationRepository;

/**
 * 车站施工风险 SurveyStationEO
 */
@Repository("surveyStationRepository")
public class SurveyStationRepositoryImpl extends GPBaseRepositoryImpl<SurveyStationEO>
        implements ISurveyStationRepository {

}
