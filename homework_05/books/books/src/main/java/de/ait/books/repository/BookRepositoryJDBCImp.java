package de.ait.books.repository;

import de.ait.books.entity.Book;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import javax.sql.DataSource;
import java.util.List;

@Repository
public class BookRepositoryJDBCImp implements BookRepository {
    private final DataSource datasource;
    private final JdbcTemplate jdbcTemplate;

    @Autowired
    public BookRepositoryJDBCImp(DataSource datasource, JdbcTemplate jdbcTemplate) {
        this.datasource = datasource;
        this.jdbcTemplate = jdbcTemplate;
    }

    private static final RowMapper<Book> BOOK_ROW_MAPPER = (row, rowNumber) -> {
        Long id = row.getLong("id");
        String title = row.getString("title");
        String author = row.getString("author");
        return new Book(id, title, author);
    };

    @Override
    public List<Book> findAll() {
        String sql = "SELECT * from t_book";
        return jdbcTemplate.query(sql, BOOK_ROW_MAPPER);
    }

    @Override
    public Book save(Book book) {
        return null;
    }

    @Override
    public void deleteById(int id) {

    }
}
