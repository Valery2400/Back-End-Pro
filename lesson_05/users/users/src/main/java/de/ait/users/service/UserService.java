package de.ait.users.service;

import de.ait.users.entity.User;

import java.util.List;

public interface UserService {

    List<User> getUsers(String name, String email);

    //List<User> findAll();

    User findById(Long id);
    User createNewUser (User user);

    User updateUser(User user);

    //List<User> findByName(String name);
}
