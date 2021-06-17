/*
 * This file is generated by jOOQ.
 */
package example.jooq.databases.tables.pojos;


import java.io.Serializable;
import java.time.LocalDateTime;


/**
 * This class is generated by jOOQ.
 */
@SuppressWarnings({ "all", "unchecked", "rawtypes" })
public class T1 implements Serializable {

    private static final long serialVersionUID = 1L;

    private final String        val;
    private final LocalDateTime createdTime;

    public T1(T1 value) {
        this.val = value.val;
        this.createdTime = value.createdTime;
    }

    public T1(
        String        val,
        LocalDateTime createdTime
    ) {
        this.val = val;
        this.createdTime = createdTime;
    }

    /**
     * Getter for <code>mydb.t1.val</code>.
     */
    public String getVal() {
        return this.val;
    }

    /**
     * Getter for <code>mydb.t1.created_time</code>.
     */
    public LocalDateTime getCreatedTime() {
        return this.createdTime;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder("T1 (");

        sb.append(val);
        sb.append(", ").append(createdTime);

        sb.append(")");
        return sb.toString();
    }
}
