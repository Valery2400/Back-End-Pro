package de.ait.users.dto;

import de.ait.users.entity.User;

import java.util.List;
import java.util.stream.Collector;
import java.util.stream.Collectors;

public class UserResponseDTO {

    private Long id;
    private String name;
    private String email;

    public UserResponseDTO(Long id, String name, String email) {
        this.id = id;
        this.name = name;
        this.email = email;
    }

    public UserResponseDTO() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
//    User -> UserResponseDTO
    public static UserResponseDTO of(User user) {
      return new UserResponseDTO(user.getId(), user.getName(), user.getEmail());
    }
//    List<User> -> List<UserRequestDTO>
    public static List<UserResponseDTO> of(List<User> users) {
        return users.stream()
                .map(UserResponseDTO::of)
                .collect(Collectors.toList());
    }
}
