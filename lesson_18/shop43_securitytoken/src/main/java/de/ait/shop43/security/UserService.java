package de.ait.shop43.security;

import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

import java.util.List;

public interface UserService {
 public List<UserResponseDto> getUsers();
 //public UserResponseDto getUserById(long id);
    public UserResponseDto createUser(UserRequestDto userRequestDto);
    public UserResponseDto setAdminRole(String username);
    UserDetails loadUserByUsername(String name) throws UsernameNotFoundException;



}
