package de.ait.users.repository;

import de.ait.users.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import javax.sql.DataSource;
import java.util.List;

@Repository
public class UserRepositoryJDBCImpl implements UserRepository {
    private final DataSource dataSource;
    private final JdbcTemplate jdbcTemplate;

    @Autowired
    public UserRepositoryJDBCImpl(DataSource dataSource, JdbcTemplate jdbcTemplate) {
        this.dataSource = dataSource;
        this.jdbcTemplate = jdbcTemplate;
    }

    private static final RowMapper<User> USER_ROW_MAPPER = (row, rowNumber) -> {
        Long id = row.getLong("id");
        String name = row.getString("name");
        String email = row.getString("email");
        String password = row.getString("password");
        return new User(id, name, email, password);

    };

    @Override
    public List<User> findAll() {
        String queryStr = "SELECT * from t_user";
        return jdbcTemplate.query(queryStr, USER_ROW_MAPPER);
    }

    @Override
    public User findById(int id) {
        return null;
    }

    @Override
    public User save(User user) {
        return null;
    }

    @Override
    public void delete(User user) {

    }
}
