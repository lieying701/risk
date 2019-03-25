package com.chinalife.risksurvey.service.impl;

import com.chinalife.base.exception.StandardRuntimeException;
import com.chinalife.base.service.impl.BaseServiceImpl;
import com.chinalife.risksurvey.component.ISurveyMainComponent;
import com.chinalife.risksurvey.entity.SurveyCustomerEO;
import com.chinalife.risksurvey.entity.SurveyItemlistEO;
import com.chinalife.risksurvey.entity.SurveyMainEO;
import com.chinalife.risksurvey.entity.SurveyRelBusinessEO;
import com.chinalife.risksurvey.repository.ISurveyMainRepository;
import com.chinalife.risksurvey.service.ISurveyCustomerService;
import com.chinalife.risksurvey.service.ISurveyItemlistService;
import com.chinalife.risksurvey.service.ISurveyMainService;
import com.chinalife.risksurvey.service.ISurveyRelBusinessService;
import com.chinalife.risksurvey.task.service.ISurveyProcessService;
import com.chinalife.risksurvey.task.service.ISurveyTaskService;
import com.chinalife.risksurvey.task.vo.ProcessParamEntity;
import com.chinalife.risksurvey.utils.DateUtils;
import com.chinalife.risksurvey.vo.OriginatingTaskCommitVo;
import com.chinalife.type.config.service.ISequenceGeneratorService;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;

/**
 * wl 包名称： com.chinalife.risksurvey.service.impl 类名称：SurveyMainServiceImpl<br/>
 * 类描述：<br/>
 *
 * @version <br/>
 *          TODO
 */
@Service("surveyMainService")
@RequestMapping("/service/risksurvey/surveyMain")
public class SurveyMainServiceImpl extends BaseServiceImpl<SurveyMainEO, ISurveyMainRepository, ISurveyMainComponent>
        implements ISurveyMainService {

    /**
     * surveyMainComponent
     */
    @Autowired
    private ISurveyMainComponent surveyMainComponent;
    /**
     * surveyCustomerService
     */
    @Autowired
    private ISurveyCustomerService surveyCustomerService;
    /**
     * surveyRelBusinessService
     */
    @Autowired
    private ISurveyRelBusinessService surveyRelBusinessService;
    /**
     * surveyItemlistService
     */
    @Autowired
    private ISurveyItemlistService surveyItemlistService;
    /**
     * surveyProcessService
     */
    @Autowired
    private ISurveyProcessService surveyProcessService;
    /**
     * surveyTaskService
     */
    @Autowired
    private  ISurveyTaskService surveyTaskService;
    /**
     * LOGGER
     */
    private static final Logger LOGGER = LoggerFactory.getLogger(SurveyMainServiceImpl.class);

    /**
     * 序列号生成期
     */
    @Autowired
    @Qualifier("sequenceGeneratorService")
    private  ISequenceGeneratorService sequenceGeneratorService;

    /**
     * 通过风勘任务号查询
     */
    @Override
    public SurveyMainEO getSurveyMainBySurveyId(String surveyId) {
        return this.getBaseComponent().getSurveyMainBySurveyId(surveyId);
    }

    @Override
    public Object originatingTaskCommit(OriginatingTaskCommitVo commitVo) {
        String customer = "";
        String main = "";
        String business = "";
        String itemlist = "";
        Map<String, Object> commitMap = new HashMap<String, Object>();
        commitVo.setStructureId("1234");
        String structureId = commitVo.getStructureId();
        String surveyId = getSurveyId(structureId);
        try {
            if (commitVo != null && !"".equals(commitVo)) {
                if (commitVo.getSurveyMain() != null) {
                    SurveyMainEO surveyMainEO = commitVo.getSurveyMain();
                    if (commitVo.getOperationType().equals("1")) {
                        surveyMainEO.setSurveyId(surveyId);
                        surveyMainEO.setNewFlag("1");
                        surveyMainEO.setStatus("2");
                    }
                    main = surveyMainComponent.insertSurveyMain(surveyMainEO).toString();
                }
                List<SurveyCustomerEO> list = commitVo.getSurveyCustomer();
                List<SurveyCustomerEO> customerList = new ArrayList<SurveyCustomerEO>();
                if (list != null && list.size() > 0) {
                    for (SurveyCustomerEO cusList : list) {
                        cusList.setSurveyId(surveyId);
                        customerList.add(cusList);
                    }
                    customer = surveyCustomerService.insertSurveyCustomer(customerList).toString();
                }
                if (commitVo.getSurveyRelBusiness() != null && !"".equals(commitVo.getSurveyRelBusiness().toString())) {
                    SurveyRelBusinessEO surveyRelBusinessEO = commitVo.getSurveyRelBusiness();
                    surveyRelBusinessEO.setSurveyId(surveyId);
                    business = surveyRelBusinessService.insertOrUpdateSurveyRelBusiness(surveyRelBusinessEO).toString();
                }
                if (commitVo.getSurveyItemlist() != null && !"".equals(commitVo.getSurveyItemlist().getModelUrl())) {
                    SurveyItemlistEO surveyItemlist = commitVo.getSurveyItemlist();
                    surveyItemlist.setSurveyId(surveyId);
                    itemlist = surveyItemlistService.insertSurveyItemlist(surveyItemlist).toString();
                } 

                if (main != null && customer != null && business != null && itemlist != null) {
                    if (commitVo.getOperationType().equals("0")) {
                        commitMap.put("status", "success");
                        commitMap.put("message", "暂存成功");
                        return commitMap;
                    } else {
                        if (surveyId.length() != 14) {
                            return "风勘任务号有误"; 
                        }
                        commitMap.put("status", "success");
                        commitMap.put("message", "提交成功");
                        commitMap.put("surveyId", surveyId);
                        commitMap.put("surveyMainId", main);
                        commitMap.put("surveyCustomerId", customerList);
                        commitMap.put("surveyRelBusinessId", business);
                        LOGGER.info("commitMap:" + commitMap);
                        
                        Map<String, Object> parameters = new HashMap<String, Object>();
                        ProcessParamEntity processParamEntity = new ProcessParamEntity();
                        processParamEntity.setTaskType("正常");
                        processParamEntity.setProcessDefinitionKey("riskSurveyEvaluationWorkflow");
                        processParamEntity.setSurveyIds(surveyId);
                        processParamEntity.setParameters(parameters);
                        String taskId = surveyProcessService.startProcess(processParamEntity);
                        surveyTaskService.completeTask("", taskId, null);
                    }
                } else {
                    commitMap.put("status", "false");
                    commitMap.put("message", "提交失败");
                    LOGGER.info("commitMap:" + commitMap);
                }
            } else {
                return null;
            }
            
        } catch (Exception e) {
            LOGGER.error("参数有误");
            throw new StandardRuntimeException("参数有误!", e);
        }

        return commitMap;
    }
    
    @Override
    @RequestMapping(value = "/getCommitVoToAdd")
    public Map<String,Object> getCommitVoToAdd(String surveyId) {
        return surveyMainComponent.getCommitVoToAdd(surveyId);
        
    }
    
    /** 生成surveyID
     * @param id 机构
     * @return String
     */
    public String getSurveyId(String id) {

        String yearStr = getYearStr().substring(2, 4);
        String structureIdStr = substringByStrAndLength(id, 4);
        String key = structureIdStr + yearStr;

        String otherNo = sequenceGeneratorService.generateBusinessNo(key, 8);
        return otherNo;
    }

    /**
     * @Description: 获取4位年份的字符串
     * @return String
     */
    private String getYearStr() {
        return DateUtils.formatDate(new Date(), "yyyy");
    }

    /**
     * @return String
     */
    public String getOrderIdByUUId() {
        int machineId = 1;// 最大支持1-9个集群机器部署
        int hashCodeV = UUID.randomUUID().toString().hashCode();
        if (hashCodeV < 0) {
            hashCodeV = -hashCodeV;
        }
        // 0 代表前面补充0
        // 4 代表长度为4
        // d 代表参数为正数型
        return machineId + String.format("%015d", hashCodeV);
    }

    /**
     * @Description: 通过长度截取字符串前几位
     * @param str
     *            字符串
     * @param length
     *            长度
     * @return String
     */
    private String substringByStrAndLength(String str, int length) {
        if (str.length() < length) {
            return str;
        }
        return str.substring(0, length);
    }
}