/*
 * This file is generated by jOOQ.
*/
package com.warumono.databases.information_schema.tables.pojos;


import java.io.Serializable;

import javax.annotation.Generated;


/**
 * This class is generated by jOOQ.
 */
@Generated(
    value = {
        "http://www.jooq.org",
        "jOOQ version:3.9.2"
    },
    comments = "This class is generated by jOOQ"
)
@SuppressWarnings({ "all", "unchecked", "rawtypes" })
public class FunctionAliases implements Serializable {

    private static final long serialVersionUID = -1119251371;

    private String  aliasCatalog;
    private String  aliasSchema;
    private String  aliasName;
    private String  javaClass;
    private String  javaMethod;
    private Integer dataType;
    private String  typeName;
    private Integer columnCount;
    private Short   returnsResult;
    private String  remarks;
    private Integer id;
    private String  source;

    public FunctionAliases() {}

    public FunctionAliases(FunctionAliases value) {
        this.aliasCatalog = value.aliasCatalog;
        this.aliasSchema = value.aliasSchema;
        this.aliasName = value.aliasName;
        this.javaClass = value.javaClass;
        this.javaMethod = value.javaMethod;
        this.dataType = value.dataType;
        this.typeName = value.typeName;
        this.columnCount = value.columnCount;
        this.returnsResult = value.returnsResult;
        this.remarks = value.remarks;
        this.id = value.id;
        this.source = value.source;
    }

    public FunctionAliases(
        String  aliasCatalog,
        String  aliasSchema,
        String  aliasName,
        String  javaClass,
        String  javaMethod,
        Integer dataType,
        String  typeName,
        Integer columnCount,
        Short   returnsResult,
        String  remarks,
        Integer id,
        String  source
    ) {
        this.aliasCatalog = aliasCatalog;
        this.aliasSchema = aliasSchema;
        this.aliasName = aliasName;
        this.javaClass = javaClass;
        this.javaMethod = javaMethod;
        this.dataType = dataType;
        this.typeName = typeName;
        this.columnCount = columnCount;
        this.returnsResult = returnsResult;
        this.remarks = remarks;
        this.id = id;
        this.source = source;
    }

    public String getAliasCatalog() {
        return this.aliasCatalog;
    }

    public void setAliasCatalog(String aliasCatalog) {
        this.aliasCatalog = aliasCatalog;
    }

    public String getAliasSchema() {
        return this.aliasSchema;
    }

    public void setAliasSchema(String aliasSchema) {
        this.aliasSchema = aliasSchema;
    }

    public String getAliasName() {
        return this.aliasName;
    }

    public void setAliasName(String aliasName) {
        this.aliasName = aliasName;
    }

    public String getJavaClass() {
        return this.javaClass;
    }

    public void setJavaClass(String javaClass) {
        this.javaClass = javaClass;
    }

    public String getJavaMethod() {
        return this.javaMethod;
    }

    public void setJavaMethod(String javaMethod) {
        this.javaMethod = javaMethod;
    }

    public Integer getDataType() {
        return this.dataType;
    }

    public void setDataType(Integer dataType) {
        this.dataType = dataType;
    }

    public String getTypeName() {
        return this.typeName;
    }

    public void setTypeName(String typeName) {
        this.typeName = typeName;
    }

    public Integer getColumnCount() {
        return this.columnCount;
    }

    public void setColumnCount(Integer columnCount) {
        this.columnCount = columnCount;
    }

    public Short getReturnsResult() {
        return this.returnsResult;
    }

    public void setReturnsResult(Short returnsResult) {
        this.returnsResult = returnsResult;
    }

    public String getRemarks() {
        return this.remarks;
    }

    public void setRemarks(String remarks) {
        this.remarks = remarks;
    }

    public Integer getId() {
        return this.id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getSource() {
        return this.source;
    }

    public void setSource(String source) {
        this.source = source;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder("FunctionAliases (");

        sb.append(aliasCatalog);
        sb.append(", ").append(aliasSchema);
        sb.append(", ").append(aliasName);
        sb.append(", ").append(javaClass);
        sb.append(", ").append(javaMethod);
        sb.append(", ").append(dataType);
        sb.append(", ").append(typeName);
        sb.append(", ").append(columnCount);
        sb.append(", ").append(returnsResult);
        sb.append(", ").append(remarks);
        sb.append(", ").append(id);
        sb.append(", ").append(source);

        sb.append(")");
        return sb.toString();
    }
}
