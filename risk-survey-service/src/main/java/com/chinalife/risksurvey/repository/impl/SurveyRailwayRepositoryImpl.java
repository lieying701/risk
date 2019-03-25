package com.chinalife.risksurvey.repository.impl;

import org.springframework.stereotype.Repository;

import com.chinalife.base.repository.impl.GPBaseRepositoryImpl;
import com.chinalife.risksurvey.entity.SurveyRailwayEO;
import com.chinalife.risksurvey.repository.ISurveyRailwayRepository;

/**
 * 公路铁路工程风险 SurveyRailwayEO
 */
@Repository("surveyRailwayRepository")
public class SurveyRailwayRepositoryImpl extends GPBaseRepositoryImpl<SurveyRailwayEO>
        implements ISurveyRailwayRepository {

}
