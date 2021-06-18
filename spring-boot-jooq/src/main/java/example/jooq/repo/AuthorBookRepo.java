package example.jooq.repo;

import example.jooq.databases.tables.Author;
import example.jooq.databases.tables.AuthorBook;
import example.jooq.databases.tables.Book;
import example.jooq.model.AuthorBookModel;
import org.jooq.DSLContext;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Repository
public class AuthorBookRepo {
    Author author = Author.AUTHOR;
    Book book = Book.BOOK;
    AuthorBook authorBook = AuthorBook.AUTHOR_BOOK;

    @Autowired
    private DSLContext dsl;

    @Transactional
    public boolean insert(AuthorBookModel authorBookModel) {
        return dsl.insertInto(authorBook, authorBook.AUTHOR_ID, authorBook.BOOK_ID)
                .values(authorBookModel.getAuthorId(), authorBookModel.getBookId())
                .execute() == 1;
    }

    @Transactional
    public boolean update(AuthorBookModel oldAuthorBookModel, AuthorBookModel newAuthorBookModel) {
        return dsl.update(authorBook)
                .set(authorBook.AUTHOR_ID, newAuthorBookModel.getAuthorId())
                .set(authorBook.AUTHOR_ID, newAuthorBookModel.getBookId())
                .where(authorBook.AUTHOR_ID.eq(oldAuthorBookModel.getAuthorId()))
                .and(authorBook.BOOK_ID.eq(oldAuthorBookModel.getBookId()))
                .execute() == 1;
    }

    @Transactional
    public boolean deleteByAuthorId(Integer authorId) {
        return dsl.deleteFrom(authorBook)
                .where(authorBook.AUTHOR_ID.eq(authorId))
                .execute() > 0;
    }

    @Transactional
    public boolean deleteByBookId(Integer bookId) {
        return dsl.deleteFrom(authorBook)
                .where(authorBook.BOOK_ID.eq(bookId))
                .execute() > 0;
    }

    @Transactional
    public boolean delete(Integer authorId, Integer bookId) {
        return dsl.deleteFrom(authorBook)
                .where(authorBook.AUTHOR_ID.eq(authorId))
                .and(authorBook.BOOK_ID.eq(bookId))
                .execute() == 1;
    }

    @Transactional(readOnly = true)
    public List<example.jooq.databases.tables.pojos.AuthorBook> selectAll() {
        return dsl.selectFrom(authorBook)
                .fetchInto(example.jooq.databases.tables.pojos.AuthorBook.class);
    }

    @Transactional(readOnly = true)
    public example.jooq.databases.tables.pojos.AuthorBook selectOneById(Integer authorId, Integer bookId) {
        return dsl.selectFrom(authorBook)
                .where(authorBook.AUTHOR_ID.eq(authorId))
                .and(authorBook.BOOK_ID.eq(bookId))
                .fetchOneInto(example.jooq.databases.tables.pojos.AuthorBook.class);
    }

    public List<example.jooq.databases.tables.pojos.AuthorBook> selectByAuthorId(Integer authorId) {
        return dsl.select()
                .from(authorBook)
                .join(author)
                .on(author.ID.eq(authorBook.AUTHOR_ID))
                .where(authorBook.AUTHOR_ID.eq(authorId))
                .fetchInto(example.jooq.databases.tables.pojos.AuthorBook.class);
    }

    public List<example.jooq.databases.tables.pojos.AuthorBook> selectByBookId(Integer bookId) {
        return dsl.select()
                .from(authorBook)
                .join(book)
                .on(book.ID.eq(authorBook.BOOK_ID))
                .where(authorBook.BOOK_ID.eq(bookId))
                .fetchInto(example.jooq.databases.tables.pojos.AuthorBook.class);
    }
}
