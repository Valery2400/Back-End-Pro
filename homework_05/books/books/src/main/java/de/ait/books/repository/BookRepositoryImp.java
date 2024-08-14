package de.ait.books.repository;

import de.ait.books.entity.Book;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public class BookRepositoryImp implements BookRepository {
    private List<Book> books = new ArrayList<>(List.of(
            new Book(1L, "Book1", "Author1"),
            new Book(2L, "Book2", "Author1"),
            new Book(3L, "Book3", "Author2"),
            new Book(4L, "Book4", "Author2"),
            new Book(5L, "Book5", "Author2")
    ));



    @Override
    public List<Book> findAll() {
        return new ArrayList<>(books);
    }

//    @Override
//    public Book findById(int id) {
//        return null;
//    }

    @Override
    public Book save(Book book) {
        if (book.getId() == null) {
        // create new book
            books.get(books.size() - 1).setId(book.getId()+1);
            books.add(book);

        } else {
            //TODO add validation Id
            books.add(book);
        }
        return book;
    }
    @Override
    public void deleteById(int id) {

    }
}
