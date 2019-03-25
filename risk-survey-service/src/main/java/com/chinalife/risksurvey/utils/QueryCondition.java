package com.chinalife.risksurvey.utils;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

import org.apache.commons.collections4.CollectionUtils;
import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.chinalife.base.context.BaseContext;
import com.chinalife.base.context.BaseContextManager;
import com.chinalife.base.util.JsonUtils;
import com.chinalife.rbac.domain.LoginStructure;
import com.chinalife.rbac.entity.RbacDataPermissionEO;
import com.chinalife.rbac.entity.RbacUserEO;
import com.chinalife.rbac.filter.service.ICurrentRbacUserService;
import com.chinalife.rbac.service.IRbacDataPermissionService;

/**
 * 
 * @Description: 查询条件封装类
 * @author: lshi041
 * @date: Oct 17, 2017 10:02:42 AM
 *
 */
public class QueryCondition implements Serializable {

    /**
     * @Fields serialVersionUID :
     */
    private static final long serialVersionUID = -2648377188585194473L;

    /**
     * Logger
     */
    private static final Logger QUERYLOGGER = LoggerFactory.getLogger(QueryCondition.class);
    /**
     * AND条件
     */
    private Map<String, AndFilter> andFilter = new HashMap<String, AndFilter>();

    /**
     * OR条件
     */
    private Map<String, OrFilter> orFilter = new HashMap<String, OrFilter>();

    /**
     * 过滤
     */
    private String sort;

    /**
     * 查询SQL
     */
    private String sql;

    /**
     * 参数值
     */
    private List<Object> values = new LinkedList<Object>();

    /**
     * 权限控制的SQL
     */
    private String securitySql;

    /**
     * 
     * @Description: 拼接条件的枚举类
     * @author: lshi041
     * @date: Dec 9, 2017 2:29:49 PM
     *
     */
    public enum QueryConditionOperatorType {

        /** 条件种类 */
        LIKE("like", "like"), EQUAL("equeal", "="), MORE("more", ">"), LESS("less", "<"),
        /** 条件封装 */
        MOST("most", ">="), LEAST("least", "<="), NOTEQUAL("notequal", "<>"), IN("in", "in"), NOTIN("notin", "not in "),
        /** 条件封装 */
        SCOPE("between", "and"), IS("is", "is"), ISNOTNULL("is not", " is not");

        /**
         * 代码
         */
        private String code;

        /**
         * 值
         */
        private String value;

        /**
         * 
         * @Description: 查询条件的构造方法
         * @param code
         *            code
         * @param value
         *            value
         */
        private QueryConditionOperatorType(String code, String value) {
            this.code = code;
            this.value = value;
        }

        public String getCode() {
            return code;
        }

        public String getValue() {
            return value;
        }
    }

    /** SQL逻辑运算符 */
    public enum LogicType {

        /** OR AND */
        OR, AND
    }

    /**
     * 
     * @Description: 排序分类
     * @author: lshi041
     * @date: Oct 17, 2017 10:26:43 AM
     *
     */
    class SortType {

        /**
         * 排序名称
         */
        private String sortName;

        /**
         * 排序CODE
         */
        private String sortCode;

        public String getSortName() {
            return sortName;
        }

        public void setSortName(String sortName) {
            this.sortName = sortName;
        }

        public String getSortCode() {
            return sortCode;
        }

        public void setSortCode(String sortCode) {
            this.sortCode = sortCode;
        }

    }

    /**
     * 
     * @Description: AND过滤
     * @author: lshi041
     * @date: Oct 17, 2017 10:43:57 AM
     *
     */
    public class AndFilter {

        /** 别名 */
        private String alias;
        /** KEY */
        private String key;
        /** 值 */
        private Object v;
        /** 操作条件 */
        private QueryConditionOperatorType operatorType;
        /** 排序类型 */
        private SortType sortType;
        /** 逻辑运算符 */
        private LogicType logicType;

        public String getKey() {
            return key;
        }

        public void setKey(String key) {
            this.key = key;
        }

        public Object getV() {
            return v;
        }

        public void setV(Object v) {
            this.v = v;
        }

        public QueryConditionOperatorType getOperatorType() {
            return operatorType;
        }

        public void setOperatorType(QueryConditionOperatorType operatorType) {
            this.operatorType = operatorType;
        }

        public SortType getSortType() {
            return sortType;
        }

        public void setSortType(SortType sortType) {
            this.sortType = sortType;
        }

        public String getAlias() {
            return alias;
        }

        public void setAlias(String alias) {
            this.alias = alias;
        }

        public LogicType getLogicType() {
            return logicType;
        }

        public void setLogicType(LogicType logicType) {
            this.logicType = logicType;
        }

    }

    /**
     * 
     * @Description: ORFilter过滤
     * @author: lshi041
     * @date: Oct 17, 2017 10:44:33 AM
     *
     */
    public class OrFilter {

        /** 别名 */
        private String alias;
        /** KEY */
        private String key;
        /** 值 */
        private Object v;
        /** 操作条件 */
        private QueryConditionOperatorType operatorType;
        /** 排序类型 */
        private SortType sortType;
        /** 逻辑运算符 */
        private LogicType logicType;

        public String getKey() {
            return key;
        }

        public void setKey(String key) {
            this.key = key;
        }

        public Object getV() {
            return v;
        }

        public void setV(Object v) {
            this.v = v;
        }

        public QueryConditionOperatorType getOperatorType() {
            return operatorType;
        }

        public void setOperatorType(QueryConditionOperatorType operatorType) {
            this.operatorType = operatorType;
        }

        public SortType getSortType() {
            return sortType;
        }

        public void setSortType(SortType sortType) {
            this.sortType = sortType;
        }

        public String getAlias() {
            return alias;
        }

        public void setAlias(String alias) {
            this.alias = alias;
        }

        public LogicType getLogicType() {
            return logicType;
        }

        public void setLogicType(LogicType logicType) {
            this.logicType = logicType;
        }
    }

    public String getSort() {
        return sort;
    }

    public void setSort(String sort) {
        this.sort = sort;
    }

    /**
     * 
     * @Description:adFilter增加Filter
     * @param andFilter
     *            a
     */
    public void addAddFilter(AndFilter andFilter) {

        String alias = StringUtils.trimToEmpty(andFilter.getAlias());
        if (!"".equalsIgnoreCase(alias)) {
            this.andFilter.put(alias + "." + andFilter.getKey(), andFilter);
        } else {
            this.andFilter.put(andFilter.getKey(), andFilter);
        }
    }

    /**
     * 
     * @Description: a
     * @param orFilter
     *            a
     */
    public void addOrFilter(OrFilter orFilter) {

        String alias = StringUtils.trimToEmpty(orFilter.getAlias());
        if (!"".equalsIgnoreCase(alias)) {
            this.orFilter.put(alias + "." + orFilter.getKey(), orFilter);
        } else {
            this.orFilter.put(orFilter.getKey(), orFilter);
        }
    }

    /**
     * 
     * @Description: 往AddMap的塞值
     * @param key
     *            a
     * @param o
     *            a
     * @param operatorType
     *            a
     */
    public void addAndFilter(String key, Object o, QueryConditionOperatorType operatorType) {

        AndFilter andFilter = new AndFilter();
        andFilter.setKey(key);
        andFilter.setV(o);
        andFilter.setOperatorType(operatorType);
        this.andFilter.put(key, andFilter);
    }

    /**
     * 
     * @Description: a
     * @param alias
     *            a
     * @param key
     *            a
     * @param o
     *            a
     * @param operatorType
     *            a
     */
    public void addAndFilter(String alias, String key, Object o, QueryConditionOperatorType operatorType) {

        AndFilter andFilter = new AndFilter();
        andFilter.setAlias(alias);
        andFilter.setKey(key);
        andFilter.setV(o);
        andFilter.setOperatorType(operatorType);

        alias = StringUtils.trimToEmpty(alias);
        if (!"".equalsIgnoreCase(alias)) {
            this.andFilter.put(alias + "." + key, andFilter);
        } else {
            this.andFilter.put(key, andFilter);
        }
    }

    /**
     * 
     * @Description: 往ORMAP的塞值
     * @param key
     *            a
     * @param v
     *            a
     * @param operatorType
     *            a
     */
    public void andOrFilter(String key, Object v, QueryConditionOperatorType operatorType) {

        OrFilter orFilter = new OrFilter();
        orFilter.setKey(key);
        orFilter.setV(v);
        orFilter.setOperatorType(operatorType);
        this.orFilter.put(key, orFilter);
    }

    /**
     * 
     * @Description: 往ORMAP的塞值
     * @param alias
     *            a
     * @param key
     *            a
     * @param o
     *            a
     * @param operatorType
     *            a
     */
    public void andOrFilter(String alias, String key, Object o, QueryConditionOperatorType operatorType) {

        OrFilter orFilter = new OrFilter();
        orFilter.setKey(key);
        orFilter.setV(o);
        orFilter.setOperatorType(operatorType);

        alias = StringUtils.trimToEmpty(alias);
        if (!"".equalsIgnoreCase(alias)) {
            this.orFilter.put(alias + "." + key, orFilter);
        } else {
            this.orFilter.put(key, orFilter);
        }
    }

    /**
     * @Description: 获取AND语句的SQL
     * @return String
     */
    @SuppressWarnings({ "unchecked" })
    private String getAndSql() {

        if (this.andFilter == null || this.andFilter.size() == 0) {
            return "";
        }

        StringBuilder sb = new StringBuilder();

        for (Entry<String, AndFilter> entry : this.andFilter.entrySet()) {

            AndFilter andFilter = entry.getValue();
            if (andFilter.operatorType.value.equalsIgnoreCase(QueryConditionOperatorType.IN.value)
                    || andFilter.operatorType.value.equalsIgnoreCase(QueryConditionOperatorType.NOTIN.value)) {

                Collection<Object> cols = (Collection<Object>) andFilter.getV();
                if (cols.size() == 0) {
                    continue;
                }
                sb.append(" AND ");
                sb.append(" " + entry.getKey() + " ");
                sb.append(" " + andFilter.operatorType.value + " ");
                sb.append(" ( ");
                Iterator<Object> itor = cols.iterator();
                int i = 0;
                while (itor.hasNext()) {
                    sb.append(" ? ");

                    this.values.add(itor.next());
                    if (i != cols.size() - 1) {
                        sb.append(" , ");
                    }
                    i = i + 1;
                }
                sb.append(" ) ");

            } else if (andFilter.operatorType.code.equalsIgnoreCase(QueryConditionOperatorType.SCOPE.code)) {
                Object[] arr = (Object[]) andFilter.getV();
                sb.append(" AND ");
                sb.append(" " + entry.getKey() + " ");
                sb.append(" " + andFilter.operatorType.code + " ");
                sb.append("?");
                sb.append(" " + andFilter.operatorType.value + " ");
                sb.append("?");
                this.values.addAll(Arrays.asList(arr));
            } else if (andFilter.operatorType.code.equalsIgnoreCase(QueryConditionOperatorType.ISNOTNULL.code)) {
                sb.append(" AND ");
                sb.append(" " + entry.getKey() + " ");
                sb.append(" " + andFilter.operatorType.value + " ");
                sb.append(" null ");
            } else {
                sb.append(" AND ");
                if (andFilter.getV() instanceof Collection) {

                    sb.append(" ( ");
                    StringBuilder sBuilder = new StringBuilder();
                    Iterator<Object> itor = ((Collection<Object>) andFilter.getV()).iterator();
                    while (itor.hasNext()) {
                        sBuilder.append(" " + entry.getKey() + " ");
                        sBuilder.append(" " + andFilter.operatorType.value + " ");
                        sBuilder.append(" ? ");
                        this.values.add(itor.next());
                        if (itor.hasNext()) {
                            sBuilder.append(" " + andFilter.getLogicType().name() + " ");
                        }
                    }
                    sb.append(sBuilder.toString());
                    sb.append(" ) ");

                } else {
                    sb.append(" " + entry.getKey() + " ");
                    sb.append(" " + andFilter.operatorType.value + " ");
                    sb.append(" ? ");
                    this.values.add(andFilter.getV());
                }
            }
        }

        return sb.toString();
    }

    /**
     * 获取OR的SQL语句
     * 
     * @return String
     */
    @SuppressWarnings({ "unchecked" })
    private String getOrSql() {

        if (this.orFilter == null || this.orFilter.size() == 0) {
            return "";
        }

        StringBuilder sb = new StringBuilder();
        int j = 0;
        for (Entry<String, OrFilter> entry : this.orFilter.entrySet()) {

            OrFilter orFilter = entry.getValue();
            if (orFilter.operatorType.value.equalsIgnoreCase(QueryConditionOperatorType.IN.value)
                    || orFilter.operatorType.value.equalsIgnoreCase(QueryConditionOperatorType.NOTIN.value)) {

                Collection<Object> cols = (Collection<Object>) orFilter.getV();
                if (cols.size() == 0) {
                    continue;
                }
                if (j != 0) {
                    sb.append(" OR ");
                }
                sb.append(" " + entry.getKey() + " ");
                sb.append(" " + orFilter.operatorType.value + " ");
                sb.append(" ( ");
                Iterator<Object> itor = cols.iterator();
                int i = 0;
                while (itor.hasNext()) {
                    sb.append(" ? ");

                    this.values.add(itor.next());
                    if (i != cols.size() - 1) {
                        sb.append(" , ");
                    }
                    i = i + 1;
                }
                sb.append(" ) ");

            } else if (orFilter.operatorType.code.equalsIgnoreCase(QueryConditionOperatorType.SCOPE.code)) {
                if (j != 0) {
                    sb.append(" OR ");
                }
                Object[] arr = (Object[]) orFilter.getV();
                sb.append(" AND ");
                sb.append(" " + entry.getKey() + " ");
                sb.append(" " + orFilter.operatorType.code + " ");
                sb.append("?");
                sb.append(" " + orFilter.operatorType.value + " ");
                sb.append("?");
                this.values.addAll(Arrays.asList(arr));
            } else if (orFilter.operatorType.code.equalsIgnoreCase(QueryConditionOperatorType.ISNOTNULL.code)) {
                sb.append(" OR ");
                sb.append(" " + entry.getKey() + " ");
                sb.append(" " + orFilter.operatorType.value + " ");
                sb.append(" null ");
            } else {
                if (j != 0) {
                    sb.append(" OR ");
                }

                if (orFilter.getV() instanceof Collection) {
                    sb.append(" ( ");
                    StringBuilder sBuilder = new StringBuilder();
                    Iterator<Object> itor = ((Collection<Object>) orFilter.getV()).iterator();
                    while (itor.hasNext()) {
                        sBuilder.append(" " + entry.getKey() + " ");
                        sBuilder.append(" " + orFilter.operatorType.value + " ");
                        sBuilder.append(" ? ");
                        this.values.add(itor.next());
                        if (itor.hasNext()) {
                            sBuilder.append(" " + orFilter.getLogicType().name() + " ");
                        }
                    }
                    sb.append(sBuilder.toString());
                    sb.append(" ) ");
                } else {

                    sb.append(" " + entry.getKey() + " ");
                    sb.append(" " + orFilter.operatorType.value + " ");
                    sb.append(" ? ");
                    this.values.add(orFilter.getV());
                }
            }
            j = j + 1;
        }

        return sb.toString();
    }

    /**
     * 
     * @Description: 拼装后的SQL
     * @return a
     */
    public String getSql() {

        sql = StringUtils.trimToEmpty(sql);
        if ("".equalsIgnoreCase(sql)) {
            sql = this.getAndSql();
        } else {
            sql = sql + this.getAndSql();
        }
        String orSql = StringUtils.trimToEmpty(this.getOrSql());
        if (!"".equalsIgnoreCase(orSql)) {
            if ("".equalsIgnoreCase(sql)) {
                sql = sql + orSql;
            } else {
                sql = sql + "AND ( " + orSql + ")";
            }
        }

        if (StringUtils.isNotBlank(this.getSecuritySql())) {
            sql = sql + this.getSecuritySql();
        }

        String sort = this.getSort();
        sort = StringUtils.trimToEmpty(sort);
        if (!"".equals(sort)) {
            sql = sql + " order by  " + sort;
        }
        return sql;
    }

    public void setSql(String sql) {
        this.sql = sql;
    }

    public List<Object> getValues() {

        return values;
    }

    public void setValues(List<Object> values) {
        this.values = values;
    }

    /**
     * 
     * @Description: 设置查询参数
     * @param parameter
     *            a
     */
    public void setParameter(Map<String, Object> parameter) {

    }

    public String getSecuritySql() {
        return securitySql;
    }

    public void setSecuritySql(String securitySql) {
        this.securitySql = securitySql;
    }

    /**
     * 
     * @Description: 设置条件限制
     * @param rbacUserService
     *            User
     * @param rbacDataPermissionService
     *            数据权限
     * @param alias
     *            别名
     * @param entityName
     *            实体名称
     * @param conditionColumn
     *            查询列
     * @param sourceSystem
     *            系统名称
     * @param resourceKindSet
     *            资源标示集合
     * @return 权限SQL
     */
    public String setSecuritySql(ICurrentRbacUserService rbacUserService, IRbacDataPermissionService rbacDataPermissionService,
            String alias, Class entityName, String conditionColumn, String sourceSystem, Set<String> resourceKindSet) {

        RbacUserEO user = rbacUserService.findCurrentUser();

        if (user != null) {
            List<LoginStructure> loginStructureList = user.getLoginStructures();
            if (CollectionUtils.isEmpty(loginStructureList)) {
                Object currentStructureId = BaseContextManager.get().get(BaseContext.PreferenceName.loginStructureId);
                loginStructureList = new ArrayList<>();
                if (currentStructureId == null) {
                    QUERYLOGGER.error("{}.{}---登录机构为空. LoginStructureList:{}, CurrentStructureId:{}",
                            this.getClass().getSimpleName(), "listEndorsementQuerys", loginStructureList,
                            currentStructureId);
                } else {
                    LoginStructure loginStructure = new LoginStructure();
                    loginStructure.setStructureId((String) currentStructureId);
                    loginStructureList.add(loginStructure);
                }
            }
            if (QUERYLOGGER.isInfoEnabled()) {
                QUERYLOGGER.info("用户【" + user.getLoginName() + "】【" + user.getOwnedStructureId() + "】能登录的机构:"
                        + JsonUtils.toJsonString(loginStructureList, true));
            }

            if (CollectionUtils.isNotEmpty(loginStructureList)) {

                List<RbacDataPermissionEO> allPermissions = new ArrayList<RbacDataPermissionEO>();

                for (LoginStructure loginStructure : loginStructureList) { // 获取用户所有登录机构的查询权限
                    for (String resourceKind : resourceKindSet) {

                        List<RbacDataPermissionEO> permissions = rbacDataPermissionService.findCachedDataPermissions(
                                user.getUserId(), loginStructure.getStructureId(), sourceSystem, resourceKind, null);
                        allPermissions.addAll(permissions);
                    }
                }

                this.securitySql = RbacSecurityUtil.getSecuritySql(alias, allPermissions, conditionColumn, entityName);
            }

        }
        return this.securitySql;
    }

    public Map<String, AndFilter> getAndFilter() {
        return andFilter;
    }
}
