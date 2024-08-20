package de.ait.books.repository;

import de.ait.books.entity.Book;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.simple.SimpleJdbcInsert;
import org.springframework.stereotype.Repository;

import javax.sql.DataSource;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

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
        if (book.getId() == null) {
            return create(book);
            // create new book
        } else {
            return update(book);
        }
    }

    private Book create(Book book) {
        SimpleJdbcInsert insert = new SimpleJdbcInsert(datasource)
                .withTableName("t_book")
                .usingGeneratedKeyColumns("id");

        Map<String, Object> params = new HashMap<>();
        params.put("title", book.getTitle());
        params.put("author", book.getAuthor());

        Long generateId = insert.executeAndReturnKey(params).longValue();
        book.setId(generateId);
        return book;
    }

    private Book update(Book book) {
        String sql = "UPDATE t_book SET title = ?, author = ? WHERE id = ?";
        int affectedRows = jdbcTemplate.update(sql, book.getTitle(), book.getAuthor(), book.getId());
        return affectedRows == 1 ? book : null;
    }

    @Override
    public void deleteById(int id) {
        String sql = "DELETE FROM t_book WHERE id = ?";
        jdbcTemplate.update(sql, id);
    }
}
