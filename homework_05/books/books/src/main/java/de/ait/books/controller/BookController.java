package de.ait.books.controller;

import de.ait.books.entity.Book;
import de.ait.books.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
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



}
