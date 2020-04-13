package com.weyon.common.mapper.provider;

import org.apache.ibatis.mapping.MappedStatement;
import tk.mybatis.mapper.MapperException;
import tk.mybatis.mapper.entity.EntityColumn;
import tk.mybatis.mapper.mapperhelper.EntityHelper;
import tk.mybatis.mapper.mapperhelper.MapperHelper;
import tk.mybatis.mapper.mapperhelper.MapperTemplate;
import tk.mybatis.mapper.mapperhelper.SqlHelper;

import java.util.Set;

/**
 * @author liuxu
 * @description 批量添加提供者
 * @date 2019-09-18
 **/
public class SpecialBatchProvider extends MapperTemplate {

    public SpecialBatchProvider(Class<?> mapperClass, MapperHelper mapperHelper) {
        super(mapperClass, mapperHelper);
    }

    public String saveBatch(MappedStatement ms) {
        final Class<?> entityClass = getEntityClass(ms);
        // 开始拼sql
        StringBuilder sql = new StringBuilder();
        sql.append(SqlHelper.insertIntoTable(entityClass, tableName(entityClass)));
        sql.append(SqlHelper.insertColumns(entityClass, false, false, false));
        sql.append(" VALUES ");
        sql.append("<foreach collection=\"list\" item=\"record\" separator=\",\" >");
        sql.append("<trim prefix=\"(\" suffix=\")\" suffixOverrides=\",\">");
        // 获取全部列
        Set<EntityColumn> columnList = EntityHelper.getColumns(entityClass);
        // 当某个列有主键策略时，不需要考虑他的属性是否为空，因为如果为空，一定会根据主键策略给他生成一个值
        for (EntityColumn column : columnList) {
            if (column.isInsertable()) {
                sql.append(column.getColumnHolder("record") + ",");
            }
        }
        sql.append("</trim>");
        sql.append("</foreach>");
        return sql.toString();
    }


    public String updateBatchNotNull(MappedStatement ms) {
        final Class<?> entityClass = getEntityClass(ms);
        // 开始拼sql
        StringBuilder sql = new StringBuilder();
        sql.append(SqlHelper.updateTable(entityClass, tableName(entityClass)));
        sql.append("<trim prefix=\"set\" suffixOverrides=\",\">");
        // 获取全部列
        Set<EntityColumn> columnList = EntityHelper.getColumns(entityClass);
        // 获取主键
        Set<EntityColumn> pkColumns = EntityHelper.getPKColumns(entityClass);
        EntityColumn pkColumn;
        if (pkColumns.size() == 1) {
            pkColumn = pkColumns.iterator().next();
        } else {
            throw new MapperException("继承 updateListByPrimaryKeySelective 方法的实体类[" + entityClass.getCanonicalName() + "]中必须只有一个带有 @Id 注解的字段");
        }
        for (EntityColumn column : columnList) {
            if (!column.isId() && column.isUpdatable()) {
                sql.append("  <trim prefix=\"" + column.getColumn() + " =case\" suffix=\"end,\">");
                sql.append("    <foreach collection=\"list\" item=\"i\" index=\"index\">");
                sql.append("      <if test=\"i." + column.getEntityField().getName() + "!=null\">");
                sql.append("         when " + pkColumn.getColumn() + "=#{i." + pkColumn.getProperty() + "} then #{i." + column.getEntityField().getName() + "}");
                sql.append("      </if>");
                sql.append("    </foreach>");
                sql.append("  </trim>");
            }
        }
        sql.append("</trim>");
        sql.append("WHERE");
        sql.append(" " + pkColumn.getColumn() + " IN ");
        sql.append("<trim prefix=\"(\" suffix=\")\">");
        sql.append("<foreach collection=\"list\" separator=\", \" item=\"i\" index=\"index\" >");
        sql.append("#{i." + pkColumn.getProperty() + "}");
        sql.append("</foreach>");
        sql.append("</trim>");
        return sql.toString();
    }

    public String deleteBatch(MappedStatement ms) {
        final Class<?> entityClass = getEntityClass(ms);
        StringBuilder sql = new StringBuilder();
        sql.append(SqlHelper.deleteFromTable(entityClass, tableName(entityClass)));
        Set<EntityColumn> columnList = EntityHelper.getPKColumns(entityClass);
        if (columnList.size() == 1) {
            EntityColumn column = columnList.iterator().next();
            sql.append(" where ");
            sql.append(column.getColumn() + " in ");
            sql.append("<foreach collection=\"list\" index=\"index\" item=\"item\" open=\"(\" close=\")\" separator=\",\">");
            sql.append("#{item}");
            sql.append("</foreach>");
        } else {
            throw new MapperException("继承 deleteBatch 方法的实体类[" + entityClass.getCanonicalName() + "]中必须只有一个带有 @Id 注解的字段");
        }
        return sql.toString();
    }
}
