package example.jooq.controller;

import example.jooq.databases.tables.pojos.Book;
import example.jooq.model.BookModel;
import example.jooq.service.BookService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Slf4j
@RestController
@RequestMapping("/book")
public class BookController {

    @Autowired
    private BookService bookService;

    @PostMapping(value = "")
    public ResponseEntity<Book> save(@RequestBody(required = true) BookModel bookModel) {
        log.debug("===== save ===== {}", bookModel);

        Book book = bookService.save(bookModel);

        log.debug("{}", book);

        return ResponseEntity.ok(book);
    }

    @PutMapping(value = "")
    public ResponseEntity<Book> edit(@RequestBody(required = true) BookModel bookModel) {
        log.debug("===== edit ===== {}", bookModel);

        Book book = bookService.edit(bookModel);

        log.debug("{}", book);

        return ResponseEntity.ok(book);
    }

    @DeleteMapping(value = "{id}")
    public ResponseEntity<Book> remove(@PathVariable(value = "id") Integer id) {
        log.debug("===== remove ===== {}", id);

        Book book = bookService.remove(id);

        log.debug("{}", book);

        return ResponseEntity.ok(book);
    }

    @GetMapping(value = "")
    public ResponseEntity<List<Book>> all() {
        log.debug("===== all =====");

        List<Book> books = bookService.getAll();

        return ResponseEntity.ok(books);
    }

    @GetMapping(value = "{id}")
    public ResponseEntity<Book> id(@PathVariable(value = "id") Integer id) {
        log.debug("===== id ===== {}", id);

        Book book = bookService.getOneById(id);

        return ResponseEntity.ok(book);
    }
}
