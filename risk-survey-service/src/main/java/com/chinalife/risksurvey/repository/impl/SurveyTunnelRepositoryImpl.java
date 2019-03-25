package com.chinalife.risksurvey.repository.impl;

import org.springframework.stereotype.Repository;

import com.chinalife.base.repository.impl.GPBaseRepositoryImpl;
import com.chinalife.risksurvey.entity.SurveyTunnelEO;
import com.chinalife.risksurvey.repository.ISurveyTunnelRepository;

/**
 * 隧道施工风险 SurveyTunnelEO
 */
@Repository("surveyTunnelRepository")
public class SurveyTunnelRepositoryImpl extends GPBaseRepositoryImpl<SurveyTunnelEO>
        implements ISurveyTunnelRepository {

}
