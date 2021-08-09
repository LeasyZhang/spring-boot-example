/*
 * This file is generated by jOOQ.
 */
package example.jooq.databases.tables.daos;


import example.jooq.databases.tables.Account;
import example.jooq.databases.tables.records.AccountRecord;

import java.time.LocalDateTime;
import java.util.List;

import org.jooq.Configuration;
import org.jooq.impl.DAOImpl;


/**
 * This class is generated by jOOQ.
 */
@SuppressWarnings({ "all", "unchecked", "rawtypes" })
public class AccountDao extends DAOImpl<AccountRecord, example.jooq.databases.tables.pojos.Account, String> {

    /**
     * Create a new AccountDao without any configuration
     */
    public AccountDao() {
        super(Account.ACCOUNT, example.jooq.databases.tables.pojos.Account.class);
    }

    /**
     * Create a new AccountDao with an attached configuration
     */
    public AccountDao(Configuration configuration) {
        super(Account.ACCOUNT, example.jooq.databases.tables.pojos.Account.class, configuration);
    }

    @Override
    public String getId(example.jooq.databases.tables.pojos.Account object) {
        return object.getId();
    }

    /**
     * Fetch records that have <code>id BETWEEN lowerInclusive AND upperInclusive</code>
     */
    public List<example.jooq.databases.tables.pojos.Account> fetchRangeOfId(String lowerInclusive, String upperInclusive) {
        return fetchRange(Account.ACCOUNT.ID, lowerInclusive, upperInclusive);
    }

    /**
     * Fetch records that have <code>id IN (values)</code>
     */
    public List<example.jooq.databases.tables.pojos.Account> fetchById(String... values) {
        return fetch(Account.ACCOUNT.ID, values);
    }

    /**
     * Fetch a unique record that has <code>id = value</code>
     */
    public example.jooq.databases.tables.pojos.Account fetchOneById(String value) {
        return fetchOne(Account.ACCOUNT.ID, value);
    }

    /**
     * Fetch records that have <code>email BETWEEN lowerInclusive AND upperInclusive</code>
     */
    public List<example.jooq.databases.tables.pojos.Account> fetchRangeOfEmail(String lowerInclusive, String upperInclusive) {
        return fetchRange(Account.ACCOUNT.EMAIL, lowerInclusive, upperInclusive);
    }

    /**
     * Fetch records that have <code>email IN (values)</code>
     */
    public List<example.jooq.databases.tables.pojos.Account> fetchByEmail(String... values) {
        return fetch(Account.ACCOUNT.EMAIL, values);
    }

    /**
     * Fetch records that have <code>name BETWEEN lowerInclusive AND upperInclusive</code>
     */
    public List<example.jooq.databases.tables.pojos.Account> fetchRangeOfName(String lowerInclusive, String upperInclusive) {
        return fetchRange(Account.ACCOUNT.NAME, lowerInclusive, upperInclusive);
    }

    /**
     * Fetch records that have <code>name IN (values)</code>
     */
    public List<example.jooq.databases.tables.pojos.Account> fetchByName(String... values) {
        return fetch(Account.ACCOUNT.NAME, values);
    }

    /**
     * Fetch records that have <code>phone_number BETWEEN lowerInclusive AND upperInclusive</code>
     */
    public List<example.jooq.databases.tables.pojos.Account> fetchRangeOfPhoneNumber(String lowerInclusive, String upperInclusive) {
        return fetchRange(Account.ACCOUNT.PHONE_NUMBER, lowerInclusive, upperInclusive);
    }

    /**
     * Fetch records that have <code>phone_number IN (values)</code>
     */
    public List<example.jooq.databases.tables.pojos.Account> fetchByPhoneNumber(String... values) {
        return fetch(Account.ACCOUNT.PHONE_NUMBER, values);
    }

    /**
     * Fetch records that have <code>confirmed_and_active BETWEEN lowerInclusive AND upperInclusive</code>
     */
    public List<example.jooq.databases.tables.pojos.Account> fetchRangeOfConfirmedAndActive(Byte lowerInclusive, Byte upperInclusive) {
        return fetchRange(Account.ACCOUNT.CONFIRMED_AND_ACTIVE, lowerInclusive, upperInclusive);
    }

    /**
     * Fetch records that have <code>confirmed_and_active IN (values)</code>
     */
    public List<example.jooq.databases.tables.pojos.Account> fetchByConfirmedAndActive(Byte... values) {
        return fetch(Account.ACCOUNT.CONFIRMED_AND_ACTIVE, values);
    }

    /**
     * Fetch records that have <code>member_since BETWEEN lowerInclusive AND upperInclusive</code>
     */
    public List<example.jooq.databases.tables.pojos.Account> fetchRangeOfMemberSince(LocalDateTime lowerInclusive, LocalDateTime upperInclusive) {
        return fetchRange(Account.ACCOUNT.MEMBER_SINCE, lowerInclusive, upperInclusive);
    }

    /**
     * Fetch records that have <code>member_since IN (values)</code>
     */
    public List<example.jooq.databases.tables.pojos.Account> fetchByMemberSince(LocalDateTime... values) {
        return fetch(Account.ACCOUNT.MEMBER_SINCE, values);
    }

    /**
     * Fetch records that have <code>password_hash BETWEEN lowerInclusive AND upperInclusive</code>
     */
    public List<example.jooq.databases.tables.pojos.Account> fetchRangeOfPasswordHash(String lowerInclusive, String upperInclusive) {
        return fetchRange(Account.ACCOUNT.PASSWORD_HASH, lowerInclusive, upperInclusive);
    }

    /**
     * Fetch records that have <code>password_hash IN (values)</code>
     */
    public List<example.jooq.databases.tables.pojos.Account> fetchByPasswordHash(String... values) {
        return fetch(Account.ACCOUNT.PASSWORD_HASH, values);
    }

    /**
     * Fetch records that have <code>photo_url BETWEEN lowerInclusive AND upperInclusive</code>
     */
    public List<example.jooq.databases.tables.pojos.Account> fetchRangeOfPhotoUrl(String lowerInclusive, String upperInclusive) {
        return fetchRange(Account.ACCOUNT.PHOTO_URL, lowerInclusive, upperInclusive);
    }

    /**
     * Fetch records that have <code>photo_url IN (values)</code>
     */
    public List<example.jooq.databases.tables.pojos.Account> fetchByPhotoUrl(String... values) {
        return fetch(Account.ACCOUNT.PHOTO_URL, values);
    }

    /**
     * Fetch records that have <code>support BETWEEN lowerInclusive AND upperInclusive</code>
     */
    public List<example.jooq.databases.tables.pojos.Account> fetchRangeOfSupport(Byte lowerInclusive, Byte upperInclusive) {
        return fetchRange(Account.ACCOUNT.SUPPORT, lowerInclusive, upperInclusive);
    }

    /**
     * Fetch records that have <code>support IN (values)</code>
     */
    public List<example.jooq.databases.tables.pojos.Account> fetchBySupport(Byte... values) {
        return fetch(Account.ACCOUNT.SUPPORT, values);
    }
}