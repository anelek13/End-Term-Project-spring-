package edu.education.schoolsys.controller;

import edu.education.schoolsys.domain.User;
import edu.education.schoolsys.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/users")
public class UserController {

    @Autowired
    UserService service;

    @GetMapping("/create")
    public void createUser(String username, String password) {
        User user = new User();
        user.setUsername(username);
        user.setPassword(password);
        service.createUser(user);
    }

    @PostMapping()
    public void createUser(@RequestBody User user) {
        service.createUser(user);
    }

    @DeleteMapping("/{id}")
    public void deleteUser(@PathVariable("id") Long id) {
        service.deleteUser(id);
    }

    @GetMapping("/{id}")
    public User getUserById(@PathVariable("id") Long id) {
        return service.getUserById(id);
    }

    @GetMapping()
    public List<User> getAllUsers() {
        return service.getAllUsers();
    }

}
