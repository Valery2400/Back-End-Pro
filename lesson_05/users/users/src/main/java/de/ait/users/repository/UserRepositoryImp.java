package de.ait.users.repository;

import de.ait.users.entity.User;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

//@Repository
public class UserRepositoryImp implements UserRepository {
    private List<User> database = new ArrayList<>( List.of(
            new User(1L, "Jack", "jack@email.com","qwerty1"),
            new User(2L, "Anna", "ann@email.com","qwerty2"),
            new User(3L, "Bill", "bill@email.com","qwerty3"),
            new User(4L, "Lena", "lena@email.com","qwerty4")
    ));


    @Override
    public List<User> findAll() {
        return new ArrayList<>(database);
    }

    @Override
    public User findById(int id) {
        return null;
    }


    @Override
    public User save(User user) {
        if (user.getId()==null) {
            // создание нового user
            long newId = database.get(database.size()-1).getId()+ 1;
            user.setId(newId);
            database.add(user);

        } else {
            // изменение user
            // TODO update user
           database.add(user);

        }
    return user;
    }

    @Override
    public void delete(User user) {

    }
}
