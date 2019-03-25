package com.chinalife.test;

/**
 * wgr
 * 包名称： test 
 * 类名称：TestJson<br/>    
 * 类描述：<br/>  
 * @version <br/>   
 */
public class TestJson {
//    @Override
//    public Object originatingTaskSave(JSONObject obj) {
//        LOGGER.info("data:" + obj.toJSONString());
//        Map<String, Object> messageMap = new HashMap<String, Object>();
//        String customerId = "";
//        String mainId = "";
//        String businessId = "";
//        String data = obj.toJSONString();
//        // 解析json数据
//        JSONObject json = JSON.parseObject(data);
//        String surveyCustomer = json.getString("survey_customer");
//        String surveyMain = json.getString("survey_main");
//
//        if (StringUtils.isNotEmpty(surveyCustomer)) {
//            JSONArray customer = JSONArray.parseArray(surveyCustomer);
//            for (int i = 0; i < customer.size(); i++) {
//                String customerType = JSONObject.parseObject(JSONObject.toJSONString(customer.get(i)))
//                        .getString("customerType");
//                String customerName = JSONObject.parseObject(JSONObject.toJSONString(customer.get(i)))
//                        .getString("customerName");
//                String identifyType = JSONObject.parseObject(JSONObject.toJSONString(customer.get(i)))
//                        .getString("identifyType");
//                String identifyNumber = JSONObject.parseObject(JSONObject.toJSONString(customer.get(i)))
//                        .getString("identifyNumber");
//                String customerCode = JSONObject.parseObject(JSONObject.toJSONString(customer.get(i)))
//                        .getString("customerCode");
//                Date identifyEffectiveEndDate = JSONObject.parseObject(JSONObject.toJSONString(customer.get(i)))
//                        .getSqlDate("\"identifyEffectiveEndDate\"");// Date类型
//                BigDecimal age = JSONObject.parseObject(JSONObject.toJSONString(customer.get(i))).getBigDecimal("age");
//                String sex = JSONObject.parseObject(JSONObject.toJSONString(customer.get(i))).getString("sex");
//                Date birthdate = JSONObject.parseObject(JSONObject.toJSONString(customer.get(i)))
//                        .getSqlDate("\"birthdate\"");// Date类型
//                String citizenship = JSONObject.parseObject(JSONObject.toJSONString(customer.get(i)))
//                        .getString("citizenship");
//                String address = JSONObject.parseObject(JSONObject.toJSONString(customer.get(i))).getString("address");
//                String linkerPhoneNo = JSONObject.parseObject(JSONObject.toJSONString(customer.get(i)))
//                        .getString("linkerPhoneNo");
//                String linkerMobile = JSONObject.parseObject(JSONObject.toJSONString(customer.get(i)))
//                        .getString("linkerMobile");
//                String linkereMail = JSONObject.parseObject(JSONObject.toJSONString(customer.get(i)))
//                        .getString("linkereMail");
//                String linkerPost = JSONObject.parseObject(JSONObject.toJSONString(customer.get(i)))
//                        .getString("linkerPost");
//                String iswithinForeign = JSONObject.parseObject(JSONObject.toJSONString(customer.get(i)))
//                        .getString("iswithinForeign");
//                String despositBankName = JSONObject.parseObject(JSONObject.toJSONString(customer.get(i)))
//                        .getString("despositBankName");
//                String accountName = JSONObject.parseObject(JSONObject.toJSONString(customer.get(i)))
//                        .getString("accountName");
//                String accountNo = JSONObject.parseObject(JSONObject.toJSONString(customer.get(i)))
//                        .getString("accountNo");
//
//                SurveyCustomerEO customerEO = new SurveyCustomerEO();
//                customerEO.setCustomerType(customerType);
//                customerEO.setCustomerName(customerName);
//                customerEO.setIdentifyType(identifyType);
//                customerEO.setIdentifyNumber(identifyNumber);
//                customerEO.setCustomerCode(customerCode);
//                customerEO.setIdentifyEffectiveEndDate(identifyEffectiveEndDate);
//                customerEO.setAge(age);
//                customerEO.setSex(sex);
//                customerEO.setBirthdate(birthdate);
//                customerEO.setCitizenship(citizenship);
//                customerEO.setAddress(address);
//                customerEO.setLinkerPhoneNo(linkerPhoneNo);
//                customerEO.setLinkerMobile(linkerMobile);
//                customerEO.setLinkereMail(linkereMail);
//                customerEO.setLinkerPost(linkerPost);
//                customerEO.setIswithinForeign(iswithinForeign);
//                customerEO.setDespositBankName(despositBankName);
//                customerEO.setAccountName(accountName);
//                customerEO.setAccountNo(accountNo);
//                customerEO.setCreateDate(DateUtils.getCurrentDate());
//                customerEO.setUpdateDate(DateUtils.getCurrentDate());
//
//                customerId = surveyCustomerRepository.insert(customerEO).toString();
//            }
//
//        }
//        if (StringUtils.isNotEmpty(surveyMain)) {
//            JSON main = (JSON) JSON.parse(surveyMain);
//            String product = JSONObject.parseObject(JSONObject.toJSONString(main)).getString("product");
//            String productCode = JSONObject.parseObject(JSONObject.toJSONString(main)).getString("productCode");
//            BigDecimal amount = JSONObject.parseObject(JSONObject.toJSONString(main)).getBigDecimal("amount");
//            String applyDeptSec = JSONObject.parseObject(JSONObject.toJSONString(main)).getString("applyDeptSec");
//            String applyDeptSecName = JSONObject.parseObject(JSONObject.toJSONString(main))
//                    .getString("applyDeptSecName");
//            String applyDeptThr = JSONObject.parseObject(JSONObject.toJSONString(main)).getString("applyDeptThr");
//            String applyDeptThrName = JSONObject.parseObject(JSONObject.toJSONString(main))
//                    .getString("applyDeptThrName");
//            String applyDept = JSONObject.parseObject(JSONObject.toJSONString(main)).getString("applyDept");
//            String applyDeptName = JSONObject.parseObject(JSONObject.toJSONString(main)).getString("applyDeptName");
//            String reportDeptSec = JSONObject.parseObject(JSONObject.toJSONString(main)).getString("reportDeptSec");
//            String reportDeptNameSec = JSONObject.parseObject(JSONObject.toJSONString(main))
//                    .getString("reportDeptNameSec");
//            String reportDeptThr = JSONObject.parseObject(JSONObject.toJSONString(main)).getString("reportDeptThr");
//            String reportDeptNameThr = JSONObject.parseObject(JSONObject.toJSONString(main))
//                    .getString("reportDeptNameThr");
//            String reportDept = JSONObject.parseObject(JSONObject.toJSONString(main)).getString("reportDept");
//            String reportDeptName = JSONObject.parseObject(JSONObject.toJSONString(main)).getString("reportDeptName");
//            Date surveyerDate = JSONObject.parseObject(JSONObject.toJSONString(main)).getSqlDate("\"surveyerDate\"");
//            String surveyer = JSONObject.parseObject(JSONObject.toJSONString(main)).getString("surveyer");
//            String surveyerType = JSONObject.parseObject(JSONObject.toJSONString(main)).getString("surveyerType");
//            String surveyerDivision = JSONObject.parseObject(JSONObject.toJSONString(main))
//                    .getString("surveyerDivision");
//            String reportProducer = JSONObject.parseObject(JSONObject.toJSONString(main)).getString("reportProducer");
//            BigDecimal surveyTimes = JSONObject.parseObject(JSONObject.toJSONString(main)).getBigDecimal("surveyTimes");
//            Date reportProduceDate = JSONObject.parseObject(JSONObject.toJSONString(main))
//                    .getSqlDate("\"reportProduceDate\"");
//
//            SurveyMainEO mainEO = new SurveyMainEO();
//            mainEO.setProduct(product);
//            mainEO.setProductCode(productCode);
//            mainEO.setAmount(amount);
//            mainEO.setApplyDeptSec(applyDeptSec);
//            mainEO.setApplyDeptSecName(applyDeptSecName);
//            mainEO.setApplyDeptThr(applyDeptThr);
//            mainEO.setApplyDeptThrName(applyDeptThrName);
//            mainEO.setApplyDept(applyDept);
//            mainEO.setApplyDeptName(applyDeptName);
//            mainEO.setReportDeptSec(reportDeptSec);
//            mainEO.setReportDeptNameSec(reportDeptNameSec);
//            mainEO.setReportDeptThr(reportDeptThr);
//            mainEO.setReportDeptNameThr(reportDeptNameThr);
//            mainEO.setReportDept(reportDept);
//            mainEO.setReportDeptName(reportDeptName);
//            mainEO.setSurveyerDate(surveyerDate);
//            mainEO.setSurveyer(surveyer);
//            mainEO.setSurveyerType(surveyerType);
//            mainEO.setSurveyerDivision(surveyerDivision);
//            mainEO.setReportProducer(reportProducer);
//            mainEO.setReportProduceDate(reportProduceDate);
//            mainEO.setCreateDate(DateUtils.getCurrentDate());
//            mainEO.setUpdateDate(DateUtils.getCurrentDate());
//            mainId = surveyMainRepository.insert(mainEO).toString();
//
//            SurveyRelBusinessEO businessEO = new SurveyRelBusinessEO();
//            businessEO.setSurveyTimes(surveyTimes);
//            businessEO.setCreateDate(DateUtils.getCurrentDate());
//            businessEO.setUpdateDate(DateUtils.getCurrentDate());
//            businessId = surveyRelBusinessRepository.insert(businessEO).toString();
//            if ((customerId != null && customerId != "") && (mainId != null && mainId != "")
//                    && (businessId != null && businessId != "")) {
//                messageMap.put("status", "success");
//                messageMap.put("message", "暂存成功");
//                LOGGER.info("messageMap:" + messageMap);
//            } else {
//                messageMap.put("status", "false");
//                messageMap.put("message", "暂存失败");
//                LOGGER.info("messageMap:" + messageMap);
//            }
//
//        }
//        return messageMap;
//    }
}
