/*
 * This file is generated by jOOQ.
*/
package example.jooq.databases;


import example.jooq.databases.tables.A;
import example.jooq.databases.tables.Account;
import example.jooq.databases.tables.Author;
import example.jooq.databases.tables.AuthorBook;
import example.jooq.databases.tables.B;
import example.jooq.databases.tables.Book;
import example.jooq.databases.tables.T;
import example.jooq.databases.tables.T1;
import example.jooq.databases.tables.T2;
import example.jooq.databases.tables.Weather;

import javax.annotation.Generated;


/**
 * Convenience access to all tables in mydb
 */
@Generated(
    value = {
        "http://www.jooq.org",
        "jOOQ version:3.9.2"
    },
    comments = "This class is generated by jOOQ"
)
@SuppressWarnings({ "all", "unchecked", "rawtypes" })
public class Tables {

    /**
     * The table <code>mydb.a</code>.
     */
    public static final A A = example.jooq.databases.tables.A.A;

    /**
     * The table <code>mydb.account</code>.
     */
    public static final Account ACCOUNT = example.jooq.databases.tables.Account.ACCOUNT;

    /**
     * The table <code>mydb.author</code>.
     */
    public static final Author AUTHOR = example.jooq.databases.tables.Author.AUTHOR;

    /**
     * The table <code>mydb.author_book</code>.
     */
    public static final AuthorBook AUTHOR_BOOK = example.jooq.databases.tables.AuthorBook.AUTHOR_BOOK;

    /**
     * The table <code>mydb.b</code>.
     */
    public static final B B = example.jooq.databases.tables.B.B;

    /**
     * The table <code>mydb.book</code>.
     */
    public static final Book BOOK = example.jooq.databases.tables.Book.BOOK;

    /**
     * The table <code>mydb.t</code>.
     */
    public static final T T = example.jooq.databases.tables.T.T;

    /**
     * The table <code>mydb.t1</code>.
     */
    public static final T1 T1 = example.jooq.databases.tables.T1.T1;

    /**
     * The table <code>mydb.t2</code>.
     */
    public static final T2 T2 = example.jooq.databases.tables.T2.T2;

    /**
     * The table <code>mydb.weather</code>.
     */
    public static final Weather WEATHER = example.jooq.databases.tables.Weather.WEATHER;
}
