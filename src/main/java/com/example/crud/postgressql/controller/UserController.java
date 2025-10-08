package com.example.crud.postgressql.controller;

import com.example.crud.postgressql.entity.User;
import com.example.crud.postgressql.service.UserService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/users")
public class UserController {
    private final UserService userService;

    @PostMapping
    public User createUser(@Valid @RequestBody User user) {
        return this.userService.createUser(user);
    }

    @GetMapping("/{id}")
    public User findUserById(@PathVariable Long id) {
        return this.userService.findById(id);
    }

    @GetMapping
    public List<User> findAllUsers() {
        return this.userService.findAll();
    }

    @PutMapping("/users/{id}")
    public User updateUser(@PathVariable Long id, @Valid @RequestBody User user) {
        return this.userService.updateUser(id, user);
    }

    @PostMapping("/{id}")
    public void deleteUser(@PathVariable Long id) {
        this.userService.deleteById(id);
    }
}
