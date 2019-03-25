package com.chinalife.risksurvey.utils;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import com.chinalife.actual.domain.Role;

/**
 * 
 * @Description: 字符串公共处理类
 * @author: xxdeng
 * @date: 2018/04/02 16:44:03
 *
 */
public class StringUtil {

    /**
     * 判断str是否为空字符串，或者"null" 和 "underfined"，如果是，返回true
     * 
     * @param str str
     * @return boolean
     */
    public static Boolean isNull(String str) {
        if (org.apache.commons.lang.StringUtils.isBlank(str)) {
            return true;
        }
        if ("null".equalsIgnoreCase(str.trim()) || "underfined".equalsIgnoreCase(str.trim())) {
            return true;
        }
        return false;
    }

    /**
     * 返回isNull()方法的反值
     * 
     * @param str str
     * @return boolean
     */
    public static Boolean isNotNull(String str) {
        return !isNull(str);
    }
    
    /**
     * 判断字符串是否为数字
     * @param str str
     * @return boolean
     */
    public static boolean isNumber(String str) {
        if (null == str || "".equals(str)) {
            return false;
        }
        String reg = "^[0-9]+(.[0-9]+)?$";
        return str.matches(reg);
    }
    
    /**
     * 判断字符串是否为浮点
     * @param str str
     * @return boolean
     */
    public static boolean isDouble(String str) {
        if (null == str || "".equals(str)) {
            return false;
        }
        Pattern pattern = Pattern.compile("^[-\\+]?[.\\d]*$");
        return pattern.matcher(str).matches();
    }
    
    /**
     * 获取字符串数据
     * 
     * @param role
     *            role
     * @param kind
     *            kind
     * @return 字符串
     */
    public static String getStrByProperty(Role role, String kind) {
        if (role == null || kind == null) {
            return null;
        }
        Object kindValue = role.getProperty().get(kind);
        return getStrByObject(kindValue);
    }

    /**
     * 强转Object 为String
     * 
     * @param objValue
     *            源Object 数据
     * @return String 数据
     */
    public static String getStrByObject(Object objValue) {
        if (objValue != null) {
            return String.valueOf(objValue);
        }
        return null;
    }

    /**
     * 手机号的校验
     *
     * @param mobile 手机号
     * @return boolean
     */
    public static boolean matchMobile(String mobile) {
        String regex = "^((13[0-9])|(14[5,7,9])|(15([0-3]|[5-9]))|(166)|(17[0,1,3,5,6,7,8])|(18[0-9])|(19[8|9]))\\d{8}$";
        if (mobile.length() != 11) {
            return false;
        } else {
            Pattern p = Pattern.compile(regex);
            Matcher m = p.matcher(mobile);
            boolean result = m.matches();
            return result;
        }
    }
    
}
