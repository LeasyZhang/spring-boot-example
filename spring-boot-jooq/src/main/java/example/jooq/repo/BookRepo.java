package example.jooq.repo;

import example.jooq.databases.tables.Book;
import example.jooq.databases.tables.records.BookRecord;
import example.jooq.model.BookModel;
import org.jooq.DSLContext;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Transactional
@Repository
public class BookRepo {

    Book book = Book.BOOK;

    @Autowired
    private DSLContext dsl;


    public Integer insert(BookModel bookModel) {
        BookRecord bookRecord = dsl.insertInto(book, book.TITLE)
                .values(bookModel.getTitle())
                .returning(book.ID)
                .fetchOne();

        return bookRecord.getValue(book.ID);
    }

    public boolean update(BookModel bookModel) {
        return dsl.update(book)
                .set(book.TITLE, "")
                .where(book.ID.eq(1))
                .execute() == 1;
    }

    public boolean delete(Integer id) {
        return dsl.deleteFrom(book)
                .where(book.ID.eq(id))
                .execute() == 1;
    }

    public List<example.jooq.databases.tables.pojos.Book> selectAll() {
        return dsl.selectFrom(book)
                .fetchInto(example.jooq.databases.tables.pojos.Book.class);
    }

    public example.jooq.databases.tables.pojos.Book selectOneById(Integer id) {
        return dsl.selectFrom(book)
                .where(book.ID.eq(id))
                .fetchOneInto(example.jooq.databases.tables.pojos.Book.class);
    }
}
