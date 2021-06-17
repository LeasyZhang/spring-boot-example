/*
 * This file is generated by jOOQ.
*/
package example.jooq.databases.tables.daos;


import example.jooq.databases.tables.Weather;
import example.jooq.databases.tables.records.WeatherRecord;

import java.sql.Timestamp;
import java.util.List;

import javax.annotation.Generated;

import org.jooq.Configuration;
import org.jooq.impl.DAOImpl;


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
public class WeatherDao extends DAOImpl<WeatherRecord, example.jooq.databases.tables.pojos.Weather, Long> {

    /**
     * Create a new WeatherDao without any configuration
     */
    public WeatherDao() {
        super(Weather.WEATHER, example.jooq.databases.tables.pojos.Weather.class);
    }

    /**
     * Create a new WeatherDao with an attached configuration
     */
    public WeatherDao(Configuration configuration) {
        super(Weather.WEATHER, example.jooq.databases.tables.pojos.Weather.class, configuration);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    protected Long getId(example.jooq.databases.tables.pojos.Weather object) {
        return object.getId();
    }

    /**
     * Fetch records that have <code>id IN (values)</code>
     */
    public List<example.jooq.databases.tables.pojos.Weather> fetchById(Long... values) {
        return fetch(Weather.WEATHER.ID, values);
    }

    /**
     * Fetch a unique record that has <code>id = value</code>
     */
    public example.jooq.databases.tables.pojos.Weather fetchOneById(Long value) {
        return fetchOne(Weather.WEATHER.ID, value);
    }

    /**
     * Fetch records that have <code>temperature IN (values)</code>
     */
    public List<example.jooq.databases.tables.pojos.Weather> fetchByTemperature(Double... values) {
        return fetch(Weather.WEATHER.TEMPERATURE, values);
    }

    /**
     * Fetch records that have <code>description IN (values)</code>
     */
    public List<example.jooq.databases.tables.pojos.Weather> fetchByDescription(String... values) {
        return fetch(Weather.WEATHER.DESCRIPTION, values);
    }

    /**
     * Fetch records that have <code>created_time IN (values)</code>
     */
    public List<example.jooq.databases.tables.pojos.Weather> fetchByCreatedTime(Timestamp... values) {
        return fetch(Weather.WEATHER.CREATED_TIME, values);
    }

    /**
     * Fetch records that have <code>updated_time IN (values)</code>
     */
    public List<example.jooq.databases.tables.pojos.Weather> fetchByUpdatedTime(Timestamp... values) {
        return fetch(Weather.WEATHER.UPDATED_TIME, values);
    }
}
