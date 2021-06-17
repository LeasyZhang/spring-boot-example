/*
 * This file is generated by jOOQ.
*/
package example.jooq.databases.tables;


import example.jooq.databases.Mydb;
import example.jooq.databases.tables.records.BRecord;

import javax.annotation.Generated;

import org.jooq.Field;
import org.jooq.Schema;
import org.jooq.Table;
import org.jooq.TableField;
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
public class B extends TableImpl<BRecord> {

    private static final long serialVersionUID = -914020643;

    /**
     * The reference instance of <code>mydb.b</code>
     */
    public static final B B = new B();

    /**
     * The class holding records for this type
     */
    @Override
    public Class<BRecord> getRecordType() {
        return BRecord.class;
    }

    /**
     * The column <code>mydb.b.f1</code>.
     */
    public final TableField<BRecord, Integer> F1 = createField("f1", org.jooq.impl.SQLDataType.INTEGER, this, "");

    /**
     * The column <code>mydb.b.f2</code>.
     */
    public final TableField<BRecord, Integer> F2 = createField("f2", org.jooq.impl.SQLDataType.INTEGER, this, "");

    /**
     * Create a <code>mydb.b</code> table reference
     */
    public B() {
        this("b", null);
    }

    /**
     * Create an aliased <code>mydb.b</code> table reference
     */
    public B(String alias) {
        this(alias, B);
    }

    private B(String alias, Table<BRecord> aliased) {
        this(alias, aliased, null);
    }

    private B(String alias, Table<BRecord> aliased, Field<?>[] parameters) {
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
    public B as(String alias) {
        return new B(alias, this);
    }

    /**
     * Rename this table
     */
    @Override
    public B rename(String name) {
        return new B(name, null);
    }
}
