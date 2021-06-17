/*
 * This file is generated by jOOQ.
*/
package example.jooq.databases.tables.records;


import example.jooq.databases.tables.T2;

import javax.annotation.Generated;

import org.jooq.Field;
import org.jooq.Record1;
import org.jooq.Record3;
import org.jooq.Row3;
import org.jooq.impl.UpdatableRecordImpl;


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
public class T2Record extends UpdatableRecordImpl<T2Record> implements Record3<Integer, Integer, Integer> {

    private static final long serialVersionUID = 1004991784;

    /**
     * Setter for <code>mydb.t2.id</code>.
     */
    public void setId(Integer value) {
        set(0, value);
    }

    /**
     * Getter for <code>mydb.t2.id</code>.
     */
    public Integer getId() {
        return (Integer) get(0);
    }

    /**
     * Setter for <code>mydb.t2.c</code>.
     */
    public void setC(Integer value) {
        set(1, value);
    }

    /**
     * Getter for <code>mydb.t2.c</code>.
     */
    public Integer getC() {
        return (Integer) get(1);
    }

    /**
     * Setter for <code>mydb.t2.d</code>.
     */
    public void setD(Integer value) {
        set(2, value);
    }

    /**
     * Getter for <code>mydb.t2.d</code>.
     */
    public Integer getD() {
        return (Integer) get(2);
    }

    // -------------------------------------------------------------------------
    // Primary key information
    // -------------------------------------------------------------------------

    /**
     * {@inheritDoc}
     */
    @Override
    public Record1<Integer> key() {
        return (Record1) super.key();
    }

    // -------------------------------------------------------------------------
    // Record3 type implementation
    // -------------------------------------------------------------------------

    /**
     * {@inheritDoc}
     */
    @Override
    public Row3<Integer, Integer, Integer> fieldsRow() {
        return (Row3) super.fieldsRow();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Row3<Integer, Integer, Integer> valuesRow() {
        return (Row3) super.valuesRow();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Field<Integer> field1() {
        return T2.T2.ID;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Field<Integer> field2() {
        return T2.T2.C;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Field<Integer> field3() {
        return T2.T2.D;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Integer value1() {
        return getId();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Integer value2() {
        return getC();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Integer value3() {
        return getD();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public T2Record value1(Integer value) {
        setId(value);
        return this;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public T2Record value2(Integer value) {
        setC(value);
        return this;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public T2Record value3(Integer value) {
        setD(value);
        return this;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public T2Record values(Integer value1, Integer value2, Integer value3) {
        value1(value1);
        value2(value2);
        value3(value3);
        return this;
    }

    // -------------------------------------------------------------------------
    // Constructors
    // -------------------------------------------------------------------------

    /**
     * Create a detached T2Record
     */
    public T2Record() {
        super(T2.T2);
    }

    /**
     * Create a detached, initialised T2Record
     */
    public T2Record(Integer id, Integer c, Integer d) {
        super(T2.T2);

        set(0, id);
        set(1, c);
        set(2, d);
    }
}
