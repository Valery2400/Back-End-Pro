package de.ait.users.service;

import de.ait.users.dto.UserRequestDTO;
import de.ait.users.dto.UserResponseDTO;
import de.ait.users.entity.User;
import de.ait.users.repository.UserRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.function.Predicate;

@Service
public class UserServiceImp implements UserService {

    private final UserRepository repository;
    private final ModelMapper mapper;


    @Autowired
    public UserServiceImp(@Qualifier("getRepository") UserRepository repository, ModelMapper mapper) {
        this.repository = repository;
        this.mapper = mapper;
    }


    public List<UserResponseDTO> findAll() {
        return UserResponseDTO.of(repository.findAll());
    }

    @Override
    public List<UserResponseDTO> getUsers(String name, String email) {
        Predicate<User> predicateByName = (name.equals("")) ? u -> true : u -> u.getName().equalsIgnoreCase(name);
        Predicate<User> predicateByEmail = (email.equals("")) ? u -> true : u -> u.getEmail().equalsIgnoreCase(email);

        Predicate<User> allConditions = predicateByName.and(predicateByEmail);

        List<User> userList = repository.findAll()
                .stream()
                .filter(allConditions)
                .toList();

        return UserResponseDTO.of(userList);
    }

    @Override
    public UserResponseDTO findById(Long id) {
        return findAll()
                .stream()
                .filter(u -> u.getId().equals(id))
                .findAny()
                .orElse(null);
    }

    @Override
    public UserResponseDTO createNewUser(UserRequestDTO dto) {
        User user = repository.save(UserRequestDTO.toEntity(dto));
//        User user = repository.save(mapper.map(dto, User.class));
        return UserResponseDTO.of(user);
//        return mapper.map(user, UserResponseDTO.class);
    }

    @Override
    public User updateUser(Long id, UserRequestDTO dto) {
        User user = UserRequestDTO.toEntity(dto); // dto -> entity
        user.setId(id);
        return repository.save(user);
    }


    public List<UserResponseDTO> findByName(String name) {
        return findAll()
                .stream()
                .filter(u -> u.getName().equals(name))
                .toList();
    }

}
