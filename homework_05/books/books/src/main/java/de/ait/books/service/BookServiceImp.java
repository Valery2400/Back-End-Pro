package de.ait.books.service;

import de.ait.books.entity.Book;
import de.ait.books.repository.BookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BookServiceImp implements BookService {

    private final BookRepository bookRepository;

    @Autowired
    public BookServiceImp(BookRepository bookRepository) {
        this.bookRepository = bookRepository;
    }

    @Override
    public List<Book> getAllBooks() {
        return bookRepository.findAll();
    }

    @Override
    public Book getBookById(Long id) {
        return bookRepository.findAll()
                .stream()
                .filter(book -> book.getId().equals(id))
                .findAny()
                .orElse(null);
    }

    @Override
    public List<Book> getBooksByAuthor(String author) {
        return bookRepository.findAll()
                .stream()
                .filter(book -> book.getAuthor().equals(author))
                .toList();
    }

    @Override
    public List<Book> getBooksByTitle(String title) {
        return bookRepository.findAll()
                .stream()
                .filter(book -> book.getTitle().equals(title))
                .toList();

    }

    @Override
    public Book addBook(Book book) {
        if (book.getId()!=null) {
            book.setId(null);
        }
        return bookRepository.save(book);
    }
}
