package de.ait.books.service;

import de.ait.books.entity.Book;

import java.util.List;

public interface BookService {
List<Book> getAllBooks();
Book getBookById(Long id);
List<Book> getBooksByAuthor(String author);
List<Book> getBooksByTitle(String title);
Book addBook(Book book);
Book updateBook(Book book);




}
