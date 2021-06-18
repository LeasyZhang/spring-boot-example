/*
 * This file is generated by jOOQ.
 */
package example.jooq.databases.tables.daos;


import example.jooq.databases.tables.T2;
import example.jooq.databases.tables.records.T2Record;

import java.util.List;

import org.jooq.Configuration;
import org.jooq.impl.DAOImpl;


/**
 * This class is generated by jOOQ.
 */
@SuppressWarnings({ "all", "unchecked", "rawtypes" })
public class T2Dao extends DAOImpl<T2Record, example.jooq.databases.tables.pojos.T2, Integer> {

    /**
     * Create a new T2Dao without any configuration
     */
    public T2Dao() {
        super(T2.T2, example.jooq.databases.tables.pojos.T2.class);
    }

    /**
     * Create a new T2Dao with an attached configuration
     */
    public T2Dao(Configuration configuration) {
        super(T2.T2, example.jooq.databases.tables.pojos.T2.class, configuration);
    }

    @Override
    public Integer getId(example.jooq.databases.tables.pojos.T2 object) {
        return object.getId();
    }

    /**
     * Fetch records that have <code>id BETWEEN lowerInclusive AND upperInclusive</code>
     */
    public List<example.jooq.databases.tables.pojos.T2> fetchRangeOfId(Integer lowerInclusive, Integer upperInclusive) {
        return fetchRange(T2.T2.ID, lowerInclusive, upperInclusive);
    }

    /**
     * Fetch records that have <code>id IN (values)</code>
     */
    public List<example.jooq.databases.tables.pojos.T2> fetchById(Integer... values) {
        return fetch(T2.T2.ID, values);
    }

    /**
     * Fetch a unique record that has <code>id = value</code>
     */
    public example.jooq.databases.tables.pojos.T2 fetchOneById(Integer value) {
        return fetchOne(T2.T2.ID, value);
    }

    /**
     * Fetch records that have <code>c BETWEEN lowerInclusive AND upperInclusive</code>
     */
    public List<example.jooq.databases.tables.pojos.T2> fetchRangeOfC(Integer lowerInclusive, Integer upperInclusive) {
        return fetchRange(T2.T2.C, lowerInclusive, upperInclusive);
    }

    /**
     * Fetch records that have <code>c IN (values)</code>
     */
    public List<example.jooq.databases.tables.pojos.T2> fetchByC(Integer... values) {
        return fetch(T2.T2.C, values);
    }

    /**
     * Fetch a unique record that has <code>c = value</code>
     */
    public example.jooq.databases.tables.pojos.T2 fetchOneByC(Integer value) {
        return fetchOne(T2.T2.C, value);
    }

    /**
     * Fetch records that have <code>d BETWEEN lowerInclusive AND upperInclusive</code>
     */
    public List<example.jooq.databases.tables.pojos.T2> fetchRangeOfD(Integer lowerInclusive, Integer upperInclusive) {
        return fetchRange(T2.T2.D, lowerInclusive, upperInclusive);
    }

    /**
     * Fetch records that have <code>d IN (values)</code>
     */
    public List<example.jooq.databases.tables.pojos.T2> fetchByD(Integer... values) {
        return fetch(T2.T2.D, values);
    }
}
