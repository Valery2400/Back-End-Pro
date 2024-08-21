package de.ait.users.dto;

import de.ait.users.entity.User;

public class UserRequestDTO {
    private String name;
    private String email;
    private String password;

    public UserRequestDTO(String name, String email, String password) {
        this.name = name;
        this.email = email;
        this.password = password;
    }

    public UserRequestDTO() {
    }

    public String getName() {
        return name;
    }

    public String getEmail() {
        return email;
    }

    public String getPassword() {
        return password;
    }

    public static User toEntity(UserRequestDTO dto){
        return new User(null, dto.getName(), dto.getEmail(), dto.getPassword());
    }
}

