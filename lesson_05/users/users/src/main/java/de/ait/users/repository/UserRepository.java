package de.ait.users.repository;

import de.ait.users.entity.User;
import org.springframework.stereotype.Repository;

import java.util.List;

public interface UserRepository {
    List<User> findAll();
    User findById(int id);
    User save(User user);
    void delete(User user);
}
