package example.jooq.service;

import example.jooq.databases.tables.pojos.Book;
import example.jooq.model.BookModel;
import example.jooq.repo.BookRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BookService {

    @Autowired
    private BookRepo bookRepo;

    public Book save(BookModel bookModel) {
        Integer id = bookRepo.insert(bookModel);

        return getOneById(id);
    }

    public Book edit(BookModel bookModel) {
        bookRepo.update(bookModel);

        return getOneById(bookModel.getId());
    }

    public Book remove(Integer id) {
        bookRepo.delete(id);

        return getOneById(id);
    }

    public List<Book> getAll() {
        return bookRepo.selectAll();
    }

    public Book getOneById(Integer id) {
        return bookRepo.selectOneById(id);
    }
}
