package de.ait.books.controller;

import de.ait.books.entity.Book;
import de.ait.books.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
public class BookController {

    private final BookService bookService;

    @Autowired
    public BookController(BookService bookService) {
        this.bookService = bookService;

    }
    @GetMapping("/books")
    public List<Book> getAllBooks() {
        return bookService.getAllBooks();

    }
    @PostMapping("/books")
    public Book createBook(@RequestBody Book book) {
        return bookService.addBook(book);
    }
    @GetMapping("/books/{numberId}")
    public Book getBook(@PathVariable(name="numberId") Long id) {
        return bookService.getBookById(id);
    }
@PutMapping ("/books")
    public Book updateBook(@RequestBody Book book) {
        return bookService.updateBook(book);
}

}
