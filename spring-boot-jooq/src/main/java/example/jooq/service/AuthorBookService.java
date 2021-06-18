package example.jooq.service;

import example.jooq.databases.tables.pojos.AuthorBook;
import example.jooq.model.AuthorBookModel;
import example.jooq.repo.AuthorBookRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AuthorBookService {

    @Autowired
    private AuthorBookRepo authorBookRepo;

    public AuthorBook save(AuthorBookModel authorBookModel) {
        authorBookRepo.insert(authorBookModel);

        return getOneById(authorBookModel);
    }

    public AuthorBook edit(AuthorBookModel oldAuthorBookModel, AuthorBookModel newAuthorBookModel) {
        authorBookRepo.update(oldAuthorBookModel, newAuthorBookModel);

        return getOneById(newAuthorBookModel);
    }

    public List<AuthorBook> removeByAuthorId(Integer authorId) {
        authorBookRepo.deleteByAuthorId(authorId);

        return getByAuthorId(authorId);
    }

    public List<AuthorBook> removeByBookId(Integer bookId) {
        authorBookRepo.deleteByBookId(bookId);

        return getByBookId(bookId);
    }

    public List<AuthorBook> getAll() {
        return authorBookRepo.selectAll();
    }

    public AuthorBook getOneById(AuthorBookModel authorBookModel) {
        return getOneById(authorBookModel.getAuthorId(), authorBookModel.getBookId());
    }

    public AuthorBook getOneById(Integer authorId, Integer bookId) {
        return authorBookRepo.selectOneById(authorId, bookId);
    }

    public List<AuthorBook> getByAuthorId(Integer authorId) {
        return authorBookRepo.selectByAuthorId(authorId);
    }

    public List<AuthorBook> getByBookId(Integer bookId) {
        return authorBookRepo.selectByBookId(bookId);
    }
}
