package de.ait.shop43.security;

import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.List;

@Service

public class UserServiceImp implements UserService, UserDetailsService {

    private final UserRepository userRepository;
    public UserServiceImp(UserRepository userRepository) {}

    @Override
    public List<UserResponseDto> getUsers() {
        return List.of();
    }

    @Override
    public UserResponseDto createUser(UserRequestDto userRequestDto) {
        return null;
    }

    @Override
    public UserResponseDto setAdminRole(String name) {
        return null;
    }
    // как Spring получает user по логину
    @Override
    public UserDetails loadUserByUsername(String name) throws UsernameNotFoundException {
        return userRepository.findUserByName(name).orElse(null);
    }
}
