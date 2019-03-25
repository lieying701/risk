package com.chinalife.risksurvey.utils;

import com.chinalife.base.entity.AbstractBaseEntity;
import com.chinalife.base.exception.StandardRuntimeException;
import com.chinalife.base.util.JsonUtils;
import com.chinalife.rbac.entity.RbacDataPermissionEO;
import com.chinalife.rbac.entity.RbacDataScopeEO;
import com.chinalife.rbac.entity.RbacParameterPermissionEO;
import org.apache.commons.collections.CollectionUtils;
import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.persistence.Table;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * rbac security utils
 *
 * @author Seamus
 */
public class RbacSecurityUtil {

    /**
     * logger
     */
    private static final Logger LOGGER = LoggerFactory.getLogger(RbacSecurityUtil.class);

    /**
     * not equal
     */
    private static final String NOT_EQUAL = " and 1=0 ";
    /**
     * and
     */
    private static final String AND = " AND ";

    /**
     * or
     */
    private static final String OR = " OR ";
    /**
     * fulle uw path
     */
    public static final List<String> FULL_UW_PATH = new ArrayList<>();

    static {
        FULL_UW_PATH.add("Z");
        FULL_UW_PATH.add("3C");
        FULL_UW_PATH.add("3B");
        FULL_UW_PATH.add("3A");
        FULL_UW_PATH.add("2C");
        FULL_UW_PATH.add("2B");
        FULL_UW_PATH.add("2A");
        FULL_UW_PATH.add("1C");
        FULL_UW_PATH.add("1B");
        FULL_UW_PATH.add("1A");
        FULL_UW_PATH.add("1AA");
    }

    /**
     * dimension
     */
    public enum DIMENSIONS {
        /**
         * structureId
         */
        structureId,
        /**
         * productCode
         */
        productCode,
        /**
         * channelType
         */
        channelType
    }


    /**
     * get security hql
     *
     * @param alias           alias
     * @param dataPermissions data permission
     * @param clazz           clazz
     *
     * @return string
     */
    public static String getSecuritySql(String alias, List<RbacDataPermissionEO> dataPermissions, Class clazz) {
        return getSecuritySql(alias, dataPermissions, null, null, null, clazz);
    }

    /**
     * get security hql
     *
     * @param alias           alias
     * @param dataPermissions data permission
     * @param structureField  structure field
     * @param clazz           clazz
     *
     * @return string
     */
    public static String getSecuritySql(String alias, List<RbacDataPermissionEO> dataPermissions, String structureField, Class clazz) {
        return getSecuritySql(alias, dataPermissions, structureField, null, null, clazz);
    }


    /**
     * get security hql
     *
     * @param alias            alias
     * @param dataPermissions  data permission
     * @param structureField   structure field
     * @param productCodeField product code field
     * @param channelField     channel field
     * @param clazz            clazz
     *
     * @return string
     */
    public static String getSecuritySql(String alias, List<RbacDataPermissionEO> dataPermissions, String structureField,
            String productCodeField, String channelField, Class clazz) {

        if (clazz.getAnnotation(Table.class) == null) {
            throw new StandardRuntimeException("securityTableEO has no table annotation");
        }
        // 判断实体类是否有权限维度字段(structureId,productcode,channelType)
        String structureFieldName = StringUtils.isNotEmpty(structureField) ? structureField : RbacSecurityUtil.DIMENSIONS.structureId.name();
        String productFieldName = StringUtils.isNotEmpty(productCodeField) ? structureField : RbacSecurityUtil.DIMENSIONS.productCode.name();
        String channelFieldName = StringUtils.isNotEmpty(channelField) ? structureField : RbacSecurityUtil.DIMENSIONS.channelType.name();
        boolean hasStructureId = StringUtils.isNotEmpty(structureField) ? hasField(structureFieldName, clazz) : hasStructureId(clazz);
        boolean hasProductCode = hasField(productFieldName, clazz);
        boolean hasChannelType = hasField(channelFieldName, clazz);
        if (!hasStructureId && !hasProductCode && !hasChannelType) {
            return StringUtils.EMPTY;
        }

        if (CollectionUtils.isEmpty(dataPermissions)) {
            return NOT_EQUAL;
        }

        Map<String, RbacDataScopeEO> structureDataScopeMap = new HashMap<>();
        Map<String, RbacDataScopeEO> productDataScopeMap = new HashMap<>();
        Map<String, RbacDataScopeEO> productLineDataScopeMap = new HashMap<>();
        Map<String, RbacDataScopeEO> channelDataScopeMap = new HashMap<>();


        // permission级别sql集合
        for (RbacDataPermissionEO permission : dataPermissions) {
            List<RbacDataScopeEO> dataScopeList = permission.getDataScopes();
            // scope级别sql集合
            for (RbacDataScopeEO dataScope : dataScopeList) {
                if (hasStructureId && StringUtils.equalsIgnoreCase(dataScope.getDimensionType(), RbacDataScopeEO.DimensionType.Structure.name())) {
                    structureDataScopeMap.put(dataScope.getDimensionId(), dataScope);
                } else if (hasProductCode && StringUtils.equalsIgnoreCase(dataScope.getDimensionType(),
                        RbacDataScopeEO.DimensionType.Product.name())) {
                    productDataScopeMap.put(dataScope.getDimensionId(), dataScope);
                } else if (hasProductCode && StringUtils.equalsIgnoreCase(dataScope.getDimensionType(),
                        RbacDataScopeEO.DimensionType.ProductLine.name())) {
                    productLineDataScopeMap.put(dataScope.getDimensionId(), dataScope);
                } else if (hasChannelType && StringUtils.equalsIgnoreCase(dataScope.getDimensionType(),
                        RbacDataScopeEO.DimensionType.Channel.name())) {
                    channelDataScopeMap.put(dataScope.getDimensionId(), dataScope);

                }
            }
        }

        String aliasName = StringUtils.trimToEmpty(alias);
        StringBuilder hqlBuilder = new StringBuilder();
        if (structureDataScopeMap.size() > 0) {
            List<StringBuilder> partStructureBuilderList = new ArrayList<>();
            structureDataScopeMap.forEach((dimensionId, dataScope) -> {
                StringBuilder structureHqlBuilder = new StringBuilder(" ");
                if (StringUtils.isNotEmpty(aliasName)) {
                    structureHqlBuilder.append(aliasName + ".");
                }
                structureHqlBuilder.append(structureFieldName);
                structureHqlBuilder.append(" in ( select partyId from StructureViewEO  where structurePath like '%");
                structureHqlBuilder.append(dataScope.getDimensionId()).append("%') ");// 注意空格
                partStructureBuilderList.add(structureHqlBuilder);
            });
            combineHql(hqlBuilder, partStructureBuilderList);
        }
        if (channelDataScopeMap.size() > 0) {
            combineInHql(hqlBuilder, channelFieldName, channelDataScopeMap);
        }

        List<StringBuilder> partProductBuilderList = new ArrayList<>();
        if (productDataScopeMap.size() > 0) {
            StringBuilder productCodeBuilder = new StringBuilder(" ");
            List<String> productCodeList = new ArrayList<>();
            productDataScopeMap.forEach((dimensionId, dataScope) -> productCodeList.add("'" + dimensionId + "'"));
            productCodeBuilder.append(productFieldName);
            productCodeBuilder.append(" in (");
            productCodeBuilder.append(StringUtils.join(productCodeList.toArray(), ","));
            productCodeBuilder.append(") ");
            partProductBuilderList.add(productCodeBuilder);
        }
        if (productLineDataScopeMap.size() > 0) {
            StringBuilder productLineBuilder = new StringBuilder(" ");
            List<String> productList = new ArrayList<>();
            productLineDataScopeMap.forEach((dimensionId, dataScope) -> productList.add("'" + dimensionId + "'"));
            productLineBuilder.append(productFieldName);
            productLineBuilder.append(" in ( select productCode from ProductViewEO  where productLine in (");
            productLineBuilder.append(StringUtils.join(productList.toArray(), ","));
            productLineBuilder.append(") ) ");
            partProductBuilderList.add(productLineBuilder);
        }

        combineHql(hqlBuilder, partProductBuilderList);

        return hqlBuilder.toString();
    }

    /**
     * combine hql
     *
     * @param hqlBuilder         builder
     * @param partHqlBuilderList list
     */
    private static void combineHql(StringBuilder hqlBuilder, List<StringBuilder> partHqlBuilderList) {
        if (CollectionUtils.isNotEmpty(partHqlBuilderList)) {
            hqlBuilder.append(" and (");
            for (int i = 0; i < partHqlBuilderList.size(); i++) {
                if (i > 0) {
                    hqlBuilder.append(OR);
                }
                hqlBuilder.append(partHqlBuilderList.get(i));
            }
            hqlBuilder.append(") ");
        }
    }

    /**
     * combine in hql
     *
     * @param hqlBuilder     builder
     * @param fieldName      field
     * @param dataScopeEOMap map
     */
    private static void combineInHql(StringBuilder hqlBuilder, String fieldName, Map<String, RbacDataScopeEO> dataScopeEOMap) {
        List<String> dimensionList = new ArrayList<>();
        dataScopeEOMap.forEach((dimensionId, dataScope) -> dimensionList.add("'" + dimensionId + "'"));
        hqlBuilder.append(AND);
        hqlBuilder.append(fieldName);
        hqlBuilder.append(" in (");
        hqlBuilder.append(StringUtils.join(dimensionList.toArray(), ","));
        hqlBuilder.append(") ");
    }

    /**
     * has structure id
     *
     * @param clazz clazz
     *
     * @return boolean
     */
    private static Boolean hasStructureId(Class clazz) {
        if (clazz.getName().equals(AbstractBaseEntity.class.getName())) {
            return true;
        }
        if (clazz.getSuperclass().getName().equals(Object.class.getName())) {
            return false;
        }
        return hasStructureId(clazz.getSuperclass());
    }

    /**
     * has field
     *
     * @param targetField target field
     * @param clazz       clazz
     *
     * @return boolean
     */
    private static Boolean hasField(String targetField, Class clazz) {
        try {
            clazz.getDeclaredField(targetField);
            return true;
        } catch (NoSuchFieldException e) {
            return false;
        }
    }

    /**
     * under writing security
     *
     * @param dataPermissions data permissions
     * @param clazz           clazz
     *
     * @return string
     */
    public static String underwritingSecurity(List<RbacDataPermissionEO> dataPermissions, Class clazz) {
        try {
            clazz.getDeclaredField("uwLevel");
        } catch (NoSuchFieldException e) {
            LOGGER.error("类：[{}]，没有[{}]属性", clazz.getName(), "uwLevel");
            return StringUtils.EMPTY;
        }
        LOGGER.info("{}.{}---数据权限：{}", RbacSecurityUtil.class.getSimpleName(), "underwritingSecurity", JsonUtils.toJsonString(dataPermissions, false));

        if (CollectionUtils.isEmpty(dataPermissions)) {
            return StringUtils.EMPTY;
        }


        StringBuilder hql = new StringBuilder();
        List<String> uwLevelList = getUwLevel(dataPermissions);
        if (CollectionUtils.isEmpty(uwLevelList)) {
            return StringUtils.EMPTY;
        }
        hql.append(" and uwLevel in ( ");
        for (int i = 0; i < uwLevelList.size(); i++) {
            hql.append(" '");
            hql.append(uwLevelList.get(i));
            hql.append("' ");
            if (i < uwLevelList.size() - 1) {
                hql.append(" , ");
            }
        }
        hql.append(" ) ");

        LOGGER.info("{}---拼接的权限查询HQL：{}", RbacSecurityUtil.class.getSimpleName(), hql.toString());
        return hql.toString();
    }

    /**
     * get uw level
     *
     * @param dataPermissions dataPermissions
     *
     * @return list
     */
    public static List<String> getUwLevel(List<RbacDataPermissionEO> dataPermissions) {
        Integer highestPriority = -1;
        Boolean hasRecordLevel = false;
        String highestLevel = null;
        for (RbacDataPermissionEO dataPermissionEO : dataPermissions) {
            if (dataPermissionEO != null && CollectionUtils.isNotEmpty(dataPermissionEO.getParameterPermissions())) {
                for (RbacParameterPermissionEO parameterPermissionEO : dataPermissionEO.getParameterPermissions()) {
                    int index = FULL_UW_PATH.indexOf(parameterPermissionEO.getValue());
                    if (index > 0 && (highestPriority < 0 || index > highestPriority)) {
                        highestPriority = index;
                        highestLevel = parameterPermissionEO.getValue();
                    } else {
                        hasRecordLevel = hasRecordLevel || index == 0;
                    }
                }
            }
        }
        List<String> uwLevel = new ArrayList<>();
        if (highestPriority >= 0) {
            int startIndex = hasRecordLevel ? 0 : 1;
            uwLevel.addAll(FULL_UW_PATH.subList(startIndex, highestPriority));
            uwLevel.add(highestLevel);
        } else if (hasRecordLevel) {
            uwLevel.addAll(FULL_UW_PATH.subList(0, 1));
        }
        return uwLevel;
    }

}
