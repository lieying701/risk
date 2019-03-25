package com.chinalife.risksurvey.repository.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Repository;

import com.chinalife.base.exception.StandardRuntimeException;
import com.chinalife.base.repository.impl.GPBaseRepositoryImpl;
import com.chinalife.base.util.JsonUtils;
import com.chinalife.base.util.ObjectUtils;
import com.chinalife.risksurvey.entity.SurveyCustomerEO;
import com.chinalife.risksurvey.entity.SurveyItemlistEO;
import com.chinalife.risksurvey.entity.SurveyMainEO;
import com.chinalife.risksurvey.entity.SurveyRelBusinessEO;
import com.chinalife.risksurvey.repository.ISurveyMainRepository;
import com.chinalife.risksurvey.vo.OriginatingTaskCommitVo;

import java.util.ArrayList;


/**
 * SurveyMainEO
 * 风勘主表
 */
@Repository("surveyMainRepository")
public class SurveyMainRepositoryImpl extends GPBaseRepositoryImpl<SurveyMainEO> 
            implements ISurveyMainRepository {

    @Override
    public void insertSurveyMain(SurveyMainEO surveyMainEO) {
        this.insert(surveyMainEO);

    }

    /**
     * 通过风勘任务号查询
     */
    @Override
    public SurveyMainEO getSurveyMainBySurveyId(String surveyId) {
        return this.findByCondition("surveyId=? and newFlag = ? ", ObjectUtils.asArray(surveyId,"1"), null);
    }
    
    @Override
    public void updateSurveyMain(SurveyMainEO surveyMainEO) {
        
        this.update(surveyMainEO);
    }
    
    /**
     * 查询main customer resbusiness
     */
    @SuppressWarnings({ "unchecked"})
    @Override
    public Object getWindReport(Map<String, Object> parameter) {
        
        String hql = "select m,c,r" + " from SurveyMainEO m left join SurveyCustomerEO c on m.surveyId = c.surveyId "
                + " left join SurveyRelBusinessEO r on m.surveyId = r.surveyId";
        StringBuilder builder = new StringBuilder();
        List<Object> values = new ArrayList<Object>();
        builder.append(" where 1 = 1");
        String surveyId = (String)parameter.get("surveyId");
        if (surveyId != null && !"".equals(surveyId)) {
            builder.append(" and m.surveyId = ? ");
            values.add(surveyId);
        }
        String hqlSql = hql + builder;
        long startTime = System.currentTimeMillis();
        List<Object> list = (List<Object>) getBaseQueryRepository().find(hqlSql,values.toArray());
        long endTime = System.currentTimeMillis();
        long totalTime = endTime - startTime;

        if (logger.isWarnEnabled() && totalTime > 1000000) {
            logger.warn("HQL耗时【{}】ms，HQL【{}】，参数表【{}】,from【{}】,limit【{}】", totalTime, hql,
                    JsonUtils.toJsonString(values, false), 0, 50);
        }
        OriginatingTaskCommitVo wind = new OriginatingTaskCommitVo();
        List<SurveyCustomerEO> customerList = new ArrayList<>();
        for (int i = 0;i < list.size();i ++) {
            Object[] ss = (Object[]) list.get(i);
            wind.setSurveyMain((SurveyMainEO)ss[0]);
            customerList.add((SurveyCustomerEO)ss[1]);
            wind.setSurveyCustomer(customerList);
            wind.setSurveyRelBusiness((SurveyRelBusinessEO)ss[2]);
            
        }
        
        return wind;
    }
    
    /**
     * 查询pkId
     */
    @SuppressWarnings("unchecked")
    @Override
    public Object getPkId(Map<String, Object> parameter) {
        String hql = "select m,c,r" + " from SurveyMainEO m left join SurveyCustomerEO c on m.surveyId = c.surveyId "
                + " left join SurveyRelBusinessEO r on m.surveyId = r.surveyId";
        StringBuilder builder = new StringBuilder();
        List<Object> values = new ArrayList<Object>();
        builder.append(" where 1 = 1");
        String surveyId = (String)parameter.get("surveyId");
        if (surveyId != null && !"".equals(surveyId)) {
            builder.append(" and m.surveyId = ? ");
            values.add(surveyId);
        }
        String hqlSql = hql + builder;
        List<Object> pkIds = (List<Object>) getBaseQueryRepository().find(hqlSql,values.toArray());
        
        return pkIds;
    }
    
    @SuppressWarnings("unchecked")
    @Override
    public Object getModelUrl(Map<String, Object> parameter) {
        String hql = "select i from SurveyItemlistEO i";
        StringBuilder builder = new StringBuilder();
        List<Object> values = new ArrayList<Object>();
        builder.append(" where 1 = 1");
        String surveyId = (String)parameter.get("surveyId");
        if (surveyId != null && !"".equals(surveyId)) {
            builder.append(" and i.surveyId = ? ");
            values.add(surveyId);
        }
        String hqlSql = hql + builder;
        long startTime = System.currentTimeMillis();
        List<Object> list = (List<Object>) getBaseQueryRepository().find(hqlSql,values.toArray());
        
        long endTime = System.currentTimeMillis();
        long totalTime = endTime - startTime;
        if (logger.isWarnEnabled() && totalTime > 1000000) {
            logger.warn("HQL耗时【{}】ms，HQL【{}】，参数表【{}】,from【{}】,limit【{}】", totalTime, hql,
                    JsonUtils.toJsonString(values, false));
        }
        SurveyItemlistEO surveyItemlist = new SurveyItemlistEO();
        if (list != null && list.size() > 0) {
            surveyItemlist = (SurveyItemlistEO)list.get(0);
        }
        
        return surveyItemlist;
    }

    @SuppressWarnings("unchecked")
    @Override
    public Object getItemlist(Map<String, Object> parameter) {
        String surveyId = (String)parameter.get("surveyId");
        StringBuilder ite = new StringBuilder();
        StringBuilder item = new StringBuilder();
        StringBuilder itemer = new StringBuilder();
        StringBuilder str = new StringBuilder();
        List<Object> val = new ArrayList<Object>();
        List<Object> list = new ArrayList<Object>();
        String pkId = "";
        StringBuilder hq1 = new StringBuilder();
        String hq = "select pkId from SurveyMainEO m where m.newFlag = 1";
        List<Object> values = new ArrayList<Object>();
        if (surveyId != null && !"".equals(surveyId)) {
            hq1.append(" and m.surveyId = ? ");
            values.add(surveyId);
        }
        List<?> ll = getBaseQueryRepository().find(hq + hq1, values.toArray());
        if (ll.size() == 1) {
            pkId = ll.get(0).toString();
        } else {
            throw new StandardRuntimeException("参数错误");
        }
        SurveyItemlistEO surveyItemlistEO = (SurveyItemlistEO)this.getModelUrl(parameter);
        if (surveyItemlistEO != null && !"".equals(surveyItemlistEO)) {
            String modelUrl = surveyItemlistEO.getModelUrl();
            list.add(modelUrl);
            if (modelUrl != null && !"".equals(modelUrl)) {
                String[] s = list.get(0).toString().split(",");
                for (int i = 0; i < s.length; i++) {
                    ite.append("s" + i + ",");
                    String sng = s[i].toString();
                    char[] ch = sng.toCharArray();
                    ch[0] -= 32;
                    item.append(String.valueOf(ch) + "EO s" + i + ",");
                    itemer.append("s" + i + ".rptId = ? and ");
                    val.add(pkId);
                }
            } else {
                return null;
            }
        } else {
            return null;
        }
        
        String itelist = ite.substring(0, ite.length() - 1);
        String itemlist = item.substring(0, item.length() - 1);
        String itemerlist = itemer.substring(0, itemer.length() - 5);
        String hqlSqls = "select " + itelist + " from " + itemlist;
        str.append(" where 1 = 1");
        str.append(" and " + itemerlist);
        String op = hqlSqls + str;
        List<Object> list1 = (List<Object>) getBaseQueryRepository().find(op,val.toArray());
        
        return list1;
    }
    
    

    @SuppressWarnings("unchecked")
    @Override
    public Map<String, Object> getCommitVoToAdd(String surveyId) {
        String hsql = "select m,b,r,c,s from SurveyMainEO  m left join SurveyBasicEO b  on m.surveyId = b.surveyId "
                + "left join SurveyRelBusinessEO r  on m.surveyId = r.surveyId left join SurveyCustomerEO c on m.surveyId =c.surveyId "
                + "left join SurveyItemlistEO s on m.surveyId = s.surveyId where m.surveyId= ? and m.newFlag =?";
        List<Object> list = (List<Object>) this.getBaseQueryRepository().find(hsql, ObjectUtils.asArray(surveyId, "1"));
        Map<String, Object> map = new HashMap<String, Object>();
        map.put("list1", list.get(0));
        map.put("list2", list.get(1));
        return map;
    }
    
    @Override
    public String getPkidBySurveyId(String surveyId) {
        String hql = "select r.pkid from SurveyRelbusinessEO r";
        StringBuilder str = new StringBuilder();
        str.append(" where 1 = 1");
        str.append(" and survey = ?");
        List<Object> values = new ArrayList<Object>();
        values.add(surveyId);
        long pkid = this.getBaseQueryRepository().findCount(hql + str, values);
        String pkId = String.valueOf(pkid);
        
        return pkId;
    }

}
