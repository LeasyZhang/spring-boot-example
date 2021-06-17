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
public class Sessions implements Serializable {

    private static final long serialVersionUID = -111001749;

    private Integer id;
    private String  userName;
    private String  sessionStart;
    private String  statement;
    private String  statementStart;
    private String  containsUncommitted;

    public Sessions() {}

    public Sessions(Sessions value) {
        this.id = value.id;
        this.userName = value.userName;
        this.sessionStart = value.sessionStart;
        this.statement = value.statement;
        this.statementStart = value.statementStart;
        this.containsUncommitted = value.containsUncommitted;
    }

    public Sessions(
        Integer id,
        String  userName,
        String  sessionStart,
        String  statement,
        String  statementStart,
        String  containsUncommitted
    ) {
        this.id = id;
        this.userName = userName;
        this.sessionStart = sessionStart;
        this.statement = statement;
        this.statementStart = statementStart;
        this.containsUncommitted = containsUncommitted;
    }

    public Integer getId() {
        return this.id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getUserName() {
        return this.userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getSessionStart() {
        return this.sessionStart;
    }

    public void setSessionStart(String sessionStart) {
        this.sessionStart = sessionStart;
    }

    public String getStatement() {
        return this.statement;
    }

    public void setStatement(String statement) {
        this.statement = statement;
    }

    public String getStatementStart() {
        return this.statementStart;
    }

    public void setStatementStart(String statementStart) {
        this.statementStart = statementStart;
    }

    public String getContainsUncommitted() {
        return this.containsUncommitted;
    }

    public void setContainsUncommitted(String containsUncommitted) {
        this.containsUncommitted = containsUncommitted;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder("Sessions (");

        sb.append(id);
        sb.append(", ").append(userName);
        sb.append(", ").append(sessionStart);
        sb.append(", ").append(statement);
        sb.append(", ").append(statementStart);
        sb.append(", ").append(containsUncommitted);

        sb.append(")");
        return sb.toString();
    }
}
