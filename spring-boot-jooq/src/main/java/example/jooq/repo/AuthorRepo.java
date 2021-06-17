package example.jooq.repo;

import example.jooq.databases.tables.Author;
import example.jooq.databases.tables.AuthorBook;
import example.jooq.databases.tables.records.AuthorRecord;
import example.jooq.model.AuthorModel;
import org.jooq.DSLContext;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Repository
public class AuthorRepo {

    Author author = Author.AUTHOR;
    AuthorBook authorBook = AuthorBook.AUTHOR_BOOK;

    @Autowired
    private DSLContext dsl;

    @Transactional
    public Integer insert(AuthorModel authorModel) {
        AuthorRecord authorRecord = dsl.insertInto(author, author.FIRST_NAME, author.LAST_NAME)
                .values(authorModel.getFirstName(), authorModel.getLastName())
                .returning(author.ID)
                .fetchOne();

        return authorRecord.getValue(author.ID);
    }

    @Transactional
    public boolean update(AuthorModel authorModel) {
        return dsl.update(author)
                .set(author.FIRST_NAME, authorModel.getFirstName())
                .set(author.LAST_NAME, authorModel.getLastName())
                .where(author.ID.eq(authorModel.getId()))
                .execute() == 1;
    }

    @Transactional
    public boolean delete(Integer id) {
        return dsl.deleteFrom(author)
                .where(author.ID.eq(id))
                .execute() == 1;
    }

    @Transactional(readOnly = true)
    public List<example.jooq.databases.tables.pojos.Author> selectAll() {
        return dsl.selectFrom(author)
                .fetchInto(example.jooq.databases.tables.pojos.Author.class);
    }

    @Transactional(readOnly = true)
    public example.jooq.databases.tables.pojos.Author selectOneById(Integer id) {
        return dsl.selectFrom(author)
                .where(author.ID.eq(id))
                .fetchOneInto(example.jooq.databases.tables.pojos.Author.class);
    }
}
