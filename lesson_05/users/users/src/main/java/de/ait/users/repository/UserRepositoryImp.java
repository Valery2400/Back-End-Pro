package de.ait.users.repository;

import de.ait.users.entity.User;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Repository
public class UserRepositoryImp implements UserRepository {
    private List<User> database = new ArrayList<>(List.of(
            new User(1L, "Jack", "jack@email.com", "qwerty1"),
            new User(2L, "Anna", "ann@email.com", "qwerty2"),
            new User(3L, "Bill", "bill@email.com", "qwerty3"),
            new User(4L, "Lena", "lena@email.com", "qwerty4")
    ));


    @Override
    public List<User> findAll() {
        return new ArrayList<>(database);
    }

    @Override
    public Optional<User> findById(Long id) {
        return database.stream()
                .filter(u -> u.getId().equals(id))
                .findAny();
    }


    @Override
    public User save(User user) {
        if (user.getId() == null) {
            // создание нового user
            long newId = database.get(database.size() - 1).getId() + 1;
            user.setId(newId);
            database.add(user);

        } else {
            // изменение user
            // TODO update user
            Optional<User> userFromDB = findById(user.getId());
            if (userFromDB.isEmpty()) {
                return null;
            } else {
                User updatedUser = userFromDB.get();
                updatedUser.setEmail(user.getEmail());
                updatedUser.setPassword(user.getPassword());
                updatedUser.setName(user.getName());
            }
            return user;
        }

        @Override
        public void delete User user){
    return null;

        }
    }
}


//        @Override
//        public User save(User user) {
//            if(user.getId()==null){
//                return createUser(user);  //Ctrl+Alt+M
//            } else {
//                return updateUser(user);
//            }
//        }
//        private  User updateUser(User user){
//            Optional<User> userFroDB = findById(user.getId());
//            if(userFroDB.isEmpty()){
//                return null;
//            } else {
//                User u = userFroDB.get();
//                u.setName(user.getName());
//                u.setEmail(user.getEmail());
//                u.setPassword(user.getPassword());
//            }
//            return user;
//        }
//    }