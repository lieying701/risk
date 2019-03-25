package com.chinalife.risksurvey.task.constants;


import org.apache.commons.lang3.StringUtils;

/**
 * common constants
 *
 * @author jzhou237
 * @version 1
 */
public class CommonConstants {

    /**
     * success
     */
    public static final String SUCCESS = "success";


    /**
     * 同步任务状态使用
     */
    public static final String TASK_STATUS_RETURNED = "Returned";
    /**
     * 是否中断出单
     */
    public static final String NO_INTERRUPT = "0";
    /**
     * return
     */
    public static final String TASK_STATUS_RETURNED_DESCRIPTION = "退回";
    /**
     * 任务同步中的有效状态
     */
    public static final String EFFECTIVE = "Effective";
    /**
     * 任务同步中的有效状态
     */
    public static final String COMPANYWEBSITE = "companyWebsite";
    /**
     * company full name
     */
    public static final String COMPANY_FULLNAME = "companyFullName";
    /**
     * company service number 01
     */
    public static final String COMPANY_SERVICE_NUMBER01 = "companyServiceNumber01";
    /**
     * company service number 02
     */
    public static final String COMPANY_SERVICE_NUMBER02 = "companyServiceNumber02";

    /**
     * 操作类型的key
     */
    public static final String OPERATION_TYPE = "operationType";

    /**
     * 核保意见的key
     */
    public static final String UW_SUGGEST = "uwSuggest";

    /**
     * 任务执行者的key
     */
    public static final String ASSIGNEE = "assignee";

    /**
     * 核保等级key
     */
    public static final String UW_LEVEL = "uwLevel";

    /**
     * 是否退回至录单员
     */
    public static final String TO_CLERK = "toClerk";

    /**
     * 保单再打申请原因
     */
    public static final String REQUEST_REASON = "requestReason";

    /**
     * 保单重打原因
     */
    public static final String REPRINT_REASON = "reprintReason";

    /**
     * 打印类型code
     */
    public static final String PRINT_TYPE_CODE = "printTypeCode";

    /**
     * 打印类型name
     */
    public static final String PRINT_TYPE_NAME = "printTypeName";

    /**
     * 打印状态
     */
    public static final String PRINT_STATUS = "1";
    /**
     * 申请状态-拒绝
     */
    public static final String APPLY_STATUS_REJECT = "2";
    /**
     * 申请状态-通过
     */
    public static final String APPLY_STATUS_PASS = "1";

    /**
     * parameter
     */
    public static final String PARAMETER_KEY = "parameter";

    /**
     * T-投保单
     */
    public static final String CERTI_TYPE_T = "T";
    /**
     * E-批单
     */
    public static final String CERTI_TYPE_E = "E";

    /**
     * 调用接口返回成功代码
     */
    public static final String RESPONSE_SUCCESS = "0000";

    /**
     * 获取role的位置
     */
    public static final int POSITION = 0;

    /**
     * 见费出单
     */
    public static final String SEE_FEE_FLAG_TRUE = "1";

    /**
     * 单证类型
     */
    public static final String VISA_CODE = "visaCode";

    /**
     * 核保级别
     */
    public static final String KIND_UW_LEVEL = "uwlevel";

    /**
     * 机构关系类型
     */
    public static final String STRUCTURE_SHIP_TYPE = "Underwriting";
    /**
     * login name
     */
    public static final String LOGIN_NAME = "loginName";
    /**
     * pc.plm.policyCopyPrint
     */
    public static final String POLICY_COPY_PRINT = "pc.plm.policyCopyPrint";

    /**
     * rule result
     *
     * @author jzhou237
     * @version 1
     */
    public enum RuleResult {
        /**
         * field name
         */
        endorseNo, authorityInfos, renewalNo, businessLevelFormula, riskCode, policyNo, forceToUnderwriteFlag, proposalNo,
        /**
         * field name
         */
        factorInfos, serialVersionUID, businessLevels, isExceptionResult, uwFlag, ruleInfos, underwriteCode, authorityLevel, seeFeeFlag,
        /**
         * field name
         */
        solutionXoms, solutionAuthLevel, solutionauthorityInfos;

        /**
         * reject
         */
        public static final String REJECT = "0";

        /**
         * success
         */
        public static final String SUCCESS = "1";

        /**
         * manual
         */
        public static final String MANUAL = "2";

        /**
         * 判断返回值是否在范围之内
         *
         * @param resultCode
         *            result code
         *
         * @return boolean
         */
        public static boolean containsCode(String resultCode) {
            return StringUtils.equals(resultCode, SUCCESS) || StringUtils.equals(resultCode, REJECT)
                    || StringUtils.equals(resultCode, MANUAL);
        }

        /**
         * success
         *
         * @param resultCode
         *            result code
         *
         * @return boolean
         */
        public static boolean success(String resultCode) {
            return StringUtils.equals(resultCode, SUCCESS);
        }

        /**
         * reject
         *
         * @param resultCode
         *            result code
         *
         * @return boolean
         */
        public static boolean reject(String resultCode) {
            return StringUtils.equals(resultCode, REJECT);
        }

        /**
         * manual
         *
         * @param resultCode
         *            result code
         *
         * @return boolean
         */
        public static boolean manual(String resultCode) {
            return StringUtils.equals(resultCode, MANUAL);
        }
    }

    /**
     * constructor
     */
    private CommonConstants() {

    }
}
