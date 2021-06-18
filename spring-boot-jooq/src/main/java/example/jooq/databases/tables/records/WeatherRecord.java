/*
 * This file is generated by jOOQ.
 */
package example.jooq.databases.tables.records;


import example.jooq.databases.tables.Weather;

import java.time.LocalDateTime;

import org.jooq.Field;
import org.jooq.Record1;
import org.jooq.Record5;
import org.jooq.Row5;
import org.jooq.impl.UpdatableRecordImpl;


/**
 * This class is generated by jOOQ.
 */
@SuppressWarnings({ "all", "unchecked", "rawtypes" })
public class WeatherRecord extends UpdatableRecordImpl<WeatherRecord> implements Record5<Long, Double, String, LocalDateTime, LocalDateTime> {

    private static final long serialVersionUID = 1L;

    /**
     * Setter for <code>mydb.weather.id</code>.
     */
    public WeatherRecord setId(Long value) {
        set(0, value);
        return this;
    }

    /**
     * Getter for <code>mydb.weather.id</code>.
     */
    public Long getId() {
        return (Long) get(0);
    }

    /**
     * Setter for <code>mydb.weather.temperature</code>.
     */
    public WeatherRecord setTemperature(Double value) {
        set(1, value);
        return this;
    }

    /**
     * Getter for <code>mydb.weather.temperature</code>.
     */
    public Double getTemperature() {
        return (Double) get(1);
    }

    /**
     * Setter for <code>mydb.weather.description</code>.
     */
    public WeatherRecord setDescription(String value) {
        set(2, value);
        return this;
    }

    /**
     * Getter for <code>mydb.weather.description</code>.
     */
    public String getDescription() {
        return (String) get(2);
    }

    /**
     * Setter for <code>mydb.weather.created_time</code>.
     */
    public WeatherRecord setCreatedTime(LocalDateTime value) {
        set(3, value);
        return this;
    }

    /**
     * Getter for <code>mydb.weather.created_time</code>.
     */
    public LocalDateTime getCreatedTime() {
        return (LocalDateTime) get(3);
    }

    /**
     * Setter for <code>mydb.weather.updated_time</code>.
     */
    public WeatherRecord setUpdatedTime(LocalDateTime value) {
        set(4, value);
        return this;
    }

    /**
     * Getter for <code>mydb.weather.updated_time</code>.
     */
    public LocalDateTime getUpdatedTime() {
        return (LocalDateTime) get(4);
    }

    // -------------------------------------------------------------------------
    // Primary key information
    // -------------------------------------------------------------------------

    @Override
    public Record1<Long> key() {
        return (Record1) super.key();
    }

    // -------------------------------------------------------------------------
    // Record5 type implementation
    // -------------------------------------------------------------------------

    @Override
    public Row5<Long, Double, String, LocalDateTime, LocalDateTime> fieldsRow() {
        return (Row5) super.fieldsRow();
    }

    @Override
    public Row5<Long, Double, String, LocalDateTime, LocalDateTime> valuesRow() {
        return (Row5) super.valuesRow();
    }

    @Override
    public Field<Long> field1() {
        return Weather.WEATHER.ID;
    }

    @Override
    public Field<Double> field2() {
        return Weather.WEATHER.TEMPERATURE;
    }

    @Override
    public Field<String> field3() {
        return Weather.WEATHER.DESCRIPTION;
    }

    @Override
    public Field<LocalDateTime> field4() {
        return Weather.WEATHER.CREATED_TIME;
    }

    @Override
    public Field<LocalDateTime> field5() {
        return Weather.WEATHER.UPDATED_TIME;
    }

    @Override
    public Long component1() {
        return getId();
    }

    @Override
    public Double component2() {
        return getTemperature();
    }

    @Override
    public String component3() {
        return getDescription();
    }

    @Override
    public LocalDateTime component4() {
        return getCreatedTime();
    }

    @Override
    public LocalDateTime component5() {
        return getUpdatedTime();
    }

    @Override
    public Long value1() {
        return getId();
    }

    @Override
    public Double value2() {
        return getTemperature();
    }

    @Override
    public String value3() {
        return getDescription();
    }

    @Override
    public LocalDateTime value4() {
        return getCreatedTime();
    }

    @Override
    public LocalDateTime value5() {
        return getUpdatedTime();
    }

    @Override
    public WeatherRecord value1(Long value) {
        setId(value);
        return this;
    }

    @Override
    public WeatherRecord value2(Double value) {
        setTemperature(value);
        return this;
    }

    @Override
    public WeatherRecord value3(String value) {
        setDescription(value);
        return this;
    }

    @Override
    public WeatherRecord value4(LocalDateTime value) {
        setCreatedTime(value);
        return this;
    }

    @Override
    public WeatherRecord value5(LocalDateTime value) {
        setUpdatedTime(value);
        return this;
    }

    @Override
    public WeatherRecord values(Long value1, Double value2, String value3, LocalDateTime value4, LocalDateTime value5) {
        value1(value1);
        value2(value2);
        value3(value3);
        value4(value4);
        value5(value5);
        return this;
    }

    // -------------------------------------------------------------------------
    // Constructors
    // -------------------------------------------------------------------------

    /**
     * Create a detached WeatherRecord
     */
    public WeatherRecord() {
        super(Weather.WEATHER);
    }

    /**
     * Create a detached, initialised WeatherRecord
     */
    public WeatherRecord(Long id, Double temperature, String description, LocalDateTime createdTime, LocalDateTime updatedTime) {
        super(Weather.WEATHER);

        setId(id);
        setTemperature(temperature);
        setDescription(description);
        setCreatedTime(createdTime);
        setUpdatedTime(updatedTime);
    }
}
