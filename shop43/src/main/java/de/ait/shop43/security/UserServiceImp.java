package de.ait.shop43.security;

import lombok.RequiredArgsConstructor;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.List;

@Service
@RequiredArgsConstructor

public class UserServiceImp implements UserService, UserDetailsService {

    private final UserRepository userRepository;
    private final RoleService roleService;
    private final BCryptPasswordEncoder bCryptPasswordEncoder;


    @Override
    public List<UserResponseDto> getUsers() {
        return List.of();
    }

    @Override
    public UserResponseDto createUser(UserRequestDto userRequestDto) {
        userRepository.findUserByName(userRequestDto.getName())
                .ifPresent(u -> {
                    throw new RuntimeException("User " + userRequestDto.getName() + "already exists");
                });

        // иначе создаем нового User
        Role role = roleService.getRoleByTitle("ROLE_USER");
        HashSet<Role> setRole = new HashSet<>();
        setRole.add(role);
        String encodePass = bCryptPasswordEncoder.encode(userRequestDto.getPassword());

        // new User(null, userRequestDto.getName(),userRequestDto.getEmail(), encodePass,
        //          Collections.singleton(role));
        User newUser = userRepository.save(
                new User(null, userRequestDto.getName(), userRequestDto.getEmail(), encodePass,
                        setRole));
        return new UserResponseDto(
                newUser.getId(),
                newUser.getName(),
                newUser.getEmail(),
                newUser.getRoles()
        );


    }

    @Override
    public UserResponseDto setAdminRole(String name) {
        return null;
    }

    // как Spring получает user по логину
    @Override
    public UserDetails loadUserByUsername(String name) throws UsernameNotFoundException {
        return userRepository.findUserByName(name)
                .orElseThrow(() -> new UsernameNotFoundException(name + "not found"));
    }
}
