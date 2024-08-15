package de.ait.users.controller;

import de.ait.users.entity.User;
import de.ait.users.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
public class UserController {

    private final UserService service;

    @Autowired
    public UserController(UserService service) {
        this.service = service;
    }

//     GET /users
//     GET /users?n=jack&email=qwe@qwe&sort=name


    @GetMapping("/users")
    public List<User> getUsers(@RequestParam(name = "n", required = false, defaultValue = "") String name,

    @RequestParam(name = "e", required = false, defaultValue = "") String email) {

            return service.getUsers(name, email);

    };

//    @GetMapping("/users")
//    public List<User> getUsers() {
//    return service.findAll();
//    }

        @PostMapping("/users")
        public User createUser (@RequestBody User user){
            return service.createNewUser(user);
        }

        @GetMapping("/users/{numId}")
        public User getUserById (@PathVariable(name = "numId") Long id){
            return service.findById(id);

        }
        // users/3/accounts/4
        // @GetMapping


    }

