/*
 * This file is generated by jOOQ.
*/
package example.jooq.databases.tables;


import example.jooq.databases.Keys;
import example.jooq.databases.Mydb;
import example.jooq.databases.tables.records.WeatherRecord;

import java.sql.Timestamp;
import java.util.Arrays;
import java.util.List;

import javax.annotation.Generated;

import org.jooq.Field;
import org.jooq.Identity;
import org.jooq.Schema;
import org.jooq.Table;
import org.jooq.TableField;
import org.jooq.UniqueKey;
import org.jooq.impl.TableImpl;


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
public class Weather extends TableImpl<WeatherRecord> {

    private static final long serialVersionUID = -46116061;

    /**
     * The reference instance of <code>mydb.weather</code>
     */
    public static final Weather WEATHER = new Weather();

    /**
     * The class holding records for this type
     */
    @Override
    public Class<WeatherRecord> getRecordType() {
        return WeatherRecord.class;
    }

    /**
     * The column <code>mydb.weather.id</code>.
     */
    public final TableField<WeatherRecord, Long> ID = createField("id", org.jooq.impl.SQLDataType.BIGINT.nullable(false), this, "");

    /**
     * The column <code>mydb.weather.temperature</code>.
     */
    public final TableField<WeatherRecord, Double> TEMPERATURE = createField("temperature", org.jooq.impl.SQLDataType.FLOAT.nullable(false), this, "");

    /**
     * The column <code>mydb.weather.description</code>.
     */
    public final TableField<WeatherRecord, String> DESCRIPTION = createField("description", org.jooq.impl.SQLDataType.VARCHAR.length(256).nullable(false), this, "");

    /**
     * The column <code>mydb.weather.created_time</code>.
     */
    public final TableField<WeatherRecord, Timestamp> CREATED_TIME = createField("created_time", org.jooq.impl.SQLDataType.TIMESTAMP.defaultValue(org.jooq.impl.DSL.inline("CURRENT_TIMESTAMP", org.jooq.impl.SQLDataType.TIMESTAMP)), this, "");

    /**
     * The column <code>mydb.weather.updated_time</code>.
     */
    public final TableField<WeatherRecord, Timestamp> UPDATED_TIME = createField("updated_time", org.jooq.impl.SQLDataType.TIMESTAMP.defaultValue(org.jooq.impl.DSL.inline("CURRENT_TIMESTAMP", org.jooq.impl.SQLDataType.TIMESTAMP)), this, "");

    /**
     * Create a <code>mydb.weather</code> table reference
     */
    public Weather() {
        this("weather", null);
    }

    /**
     * Create an aliased <code>mydb.weather</code> table reference
     */
    public Weather(String alias) {
        this(alias, WEATHER);
    }

    private Weather(String alias, Table<WeatherRecord> aliased) {
        this(alias, aliased, null);
    }

    private Weather(String alias, Table<WeatherRecord> aliased, Field<?>[] parameters) {
        super(alias, null, aliased, parameters, "");
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Schema getSchema() {
        return Mydb.MYDB;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Identity<WeatherRecord, Long> getIdentity() {
        return Keys.IDENTITY_WEATHER;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public UniqueKey<WeatherRecord> getPrimaryKey() {
        return Keys.KEY_WEATHER_PRIMARY;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public List<UniqueKey<WeatherRecord>> getKeys() {
        return Arrays.<UniqueKey<WeatherRecord>>asList(Keys.KEY_WEATHER_PRIMARY);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Weather as(String alias) {
        return new Weather(alias, this);
    }

    /**
     * Rename this table
     */
    @Override
    public Weather rename(String name) {
        return new Weather(name, null);
    }
}
