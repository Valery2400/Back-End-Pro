package de.ait.users.service;

import de.ait.users.dto.UserRequestDTO;
import de.ait.users.dto.UserResponseDTO;
import de.ait.users.entity.User;

import java.util.List;

public interface UserService {

    List<UserResponseDTO> getUsers(String name, String email);

    //List<User> findAll();

    UserRequestDTO findById(Long id);
    UserRequestDTO createNewUser (UserRequestDTO user);

    User updateUser(Long id, UserRequestDTO user);

    //List<User> findByName(String name);
}
