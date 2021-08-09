/*
 * This file is generated by jOOQ.
 */
package example.jooq.databases.tables.daos;


import example.jooq.databases.tables.Author;
import example.jooq.databases.tables.records.AuthorRecord;

import java.util.List;

import org.jooq.Configuration;
import org.jooq.impl.DAOImpl;


/**
 * This class is generated by jOOQ.
 */
@SuppressWarnings({ "all", "unchecked", "rawtypes" })
public class AuthorDao extends DAOImpl<AuthorRecord, example.jooq.databases.tables.pojos.Author, Integer> {

    /**
     * Create a new AuthorDao without any configuration
     */
    public AuthorDao() {
        super(Author.AUTHOR, example.jooq.databases.tables.pojos.Author.class);
    }

    /**
     * Create a new AuthorDao with an attached configuration
     */
    public AuthorDao(Configuration configuration) {
        super(Author.AUTHOR, example.jooq.databases.tables.pojos.Author.class, configuration);
    }

    @Override
    public Integer getId(example.jooq.databases.tables.pojos.Author object) {
        return object.getId();
    }

    /**
     * Fetch records that have <code>id BETWEEN lowerInclusive AND upperInclusive</code>
     */
    public List<example.jooq.databases.tables.pojos.Author> fetchRangeOfId(Integer lowerInclusive, Integer upperInclusive) {
        return fetchRange(Author.AUTHOR.ID, lowerInclusive, upperInclusive);
    }

    /**
     * Fetch records that have <code>id IN (values)</code>
     */
    public List<example.jooq.databases.tables.pojos.Author> fetchById(Integer... values) {
        return fetch(Author.AUTHOR.ID, values);
    }

    /**
     * Fetch a unique record that has <code>id = value</code>
     */
    public example.jooq.databases.tables.pojos.Author fetchOneById(Integer value) {
        return fetchOne(Author.AUTHOR.ID, value);
    }

    /**
     * Fetch records that have <code>first_name BETWEEN lowerInclusive AND upperInclusive</code>
     */
    public List<example.jooq.databases.tables.pojos.Author> fetchRangeOfFirstName(String lowerInclusive, String upperInclusive) {
        return fetchRange(Author.AUTHOR.FIRST_NAME, lowerInclusive, upperInclusive);
    }

    /**
     * Fetch records that have <code>first_name IN (values)</code>
     */
    public List<example.jooq.databases.tables.pojos.Author> fetchByFirstName(String... values) {
        return fetch(Author.AUTHOR.FIRST_NAME, values);
    }

    /**
     * Fetch records that have <code>last_name BETWEEN lowerInclusive AND upperInclusive</code>
     */
    public List<example.jooq.databases.tables.pojos.Author> fetchRangeOfLastName(String lowerInclusive, String upperInclusive) {
        return fetchRange(Author.AUTHOR.LAST_NAME, lowerInclusive, upperInclusive);
    }

    /**
     * Fetch records that have <code>last_name IN (values)</code>
     */
    public List<example.jooq.databases.tables.pojos.Author> fetchByLastName(String... values) {
        return fetch(Author.AUTHOR.LAST_NAME, values);
    }
}