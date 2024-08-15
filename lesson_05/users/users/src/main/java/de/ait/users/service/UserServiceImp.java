package de.ait.users.service;

import de.ait.users.entity.User;
import de.ait.users.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.function.Predicate;

@Service
public class UserServiceImp implements UserService {

    private final UserRepository repository;

    @Autowired
    public UserServiceImp(UserRepository repository) {
        this.repository = repository;
    }


    public List<User> findAll() {
        return repository.findAll();
    }

    @Override
    public List<User> getUsers(String name, String email) {
        Predicate<User> predicateByName = (name.equals("")) ? u -> true: u -> u.getName().equalsIgnoreCase(name);
        Predicate<User> predicateByEmail = (email.equals("")) ? u -> true: u -> u.getEmail().equalsIgnoreCase(email);

        Predicate<User> allConditions = predicateByName.and(predicateByEmail);

        return repository.findAll()
                .stream()
                .filter(allConditions)
                .toList();


    }

    @Override
    public User findById(Long id) {
        return findAll()
        .stream()
                .filter(u -> u.getId().equals(id))
                .findAny()
                .orElse(null);
    }

    @Override
    public User createNewUser(User user) {
        if (user.getId() != null) {
            user.setId(null);
        }
        return repository.save(user);
    }


    public List<User> findByName(String name) {
        return findAll()
                .stream()
                .filter(u->u.getName().equals(name))
                .toList();
    }
}
