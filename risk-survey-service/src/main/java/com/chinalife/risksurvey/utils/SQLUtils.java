package com.chinalife.risksurvey.utils;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

/**
 * 包名称： com.chinalife.risksurvey.utils<br/>
 * 类名称：SQLUtils<br/>
 * 类描述：sql或hql的工具类的工具类<br/>
 * 
 * @version <br/>
 */
public abstract class SQLUtils {
    /**
     * 根据id集合自动组装成对应的hql的in查询语句
     * 
     * @param columnName
     *            列名
     * @param ids
     *            id的组合
     * @return StringBuffer hql
     */
    public static StringBuffer parseIdsHql(String columnName, Collection ids) {
        StringBuffer result = new StringBuffer();
        if (ids != null && ids.size() > 0) {
            int count = ids.size();
            List idList = new ArrayList<>(ids);
            result.append(" ").append(columnName).append(" in (");
            for (int i = 0; i < count; i++) {
                if (i == count - 1) {
                    result.append(" ?");
                } else {
                    result.append(" ?,");
                }
            }
            result.append(")");
        }
        return result;
    }
}
