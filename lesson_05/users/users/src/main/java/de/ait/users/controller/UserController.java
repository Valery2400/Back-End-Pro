package de.ait.users.controller;

import de.ait.users.dto.UserRequestDTO;
import de.ait.users.dto.UserResponseDTO;
import de.ait.users.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
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
    public List<UserResponseDTO> getUsers(@RequestParam(name = "n", required = false, defaultValue = "") String name,

    @RequestParam(name = "e", required = false, defaultValue = "") String email) {

            return service.getUsers(name, email);

    };

//    @GetMapping("/users")
//    public List<User> getUsers() {
//    return service.findAll();
//    }

        @PostMapping("/users")
        public UserRequestDTO createUser (@RequestBody UserRequestDTO userDto){
            return service.createNewUser(userDto);
        }

        @GetMapping("/users/{id}")
        public UserRequestDTO getUserById (@PathVariable(name = "id") Long id){
            return service.findById(id);
        }

         @PutMapping("/users/{id}")
         public UserRequestDTO updateUser (@PathVariable(name = "id") Long id, @RequestBody UserRequestDTO userRequestDTO){
            return service.updateUser(id, userRequestDTO);
    }
        // users/3/accounts/4
        // @GetMapping


    }

